<?php

namespace App\Controller;

use App\Entity\Forum;
use App\Form\ForumType;

use App\Repository\ForumRepository;
use Doctrine\ORM\EntityManagerInterface;
use Symfony\Component\HttpFoundation\Request;
use Symfony\Component\HttpFoundation\Response;
use Symfony\Component\Routing\Annotation\Route;
use Symfony\Bundle\FrameworkBundle\Controller\AbstractController;
use Symfony\Component\HttpFoundation\File\Exception\FileException;

class FormController extends AbstractController
{

 


    /**
     * @Route("/form", name="ajouterforum")
     */
    public function create (Request $request ,EntityManagerInterface $entityManager)
    {

        
                $forum = new forum ();
 
                $form = $this ->createForm(ForumType::class,$forum);
                     //firas
                    $file = $form->get('image')->getData();
                    $fileName = md5(uniqid()).'.'.$file->guessExtension();
                    try {
                       $file->move(
                            $this->getParameter('images_directrory'),
                            $fileName
                        );
 
 
                   }catch (FileException $e){}
                         $entityManager= $this->getDoctrine()->getManager();
                         $forum->setImage($fileName);
                         //firas
       
      
                $form->handleRequest($request)  ;  
                
                if ($form->isSubmitted() && $form->isValid()) {
                  $forum->setCreatedAt(new \DatetimeImmutable ());
                  $entityManager->persist($forum);
                  $entityManager->flush();
       
                  return $this->redirectToRoute('chat', ['id' => $forum ->getId()]); 
                
        }


        return $this->render('form/ajouterforum.html.twig', [
            'formForum' => $form->createView()
        ]);
    } 

    





    /**
 * @Route("/forum/{id}", name="detailforum")
 */
public function forum (int $id): Response
{
    $forum = $this->getDoctrine()->getRepository(Forum::class)->find($id);

    return $this->render("form/forum.html.twig", [
        "forum" => $forum,
    ]);
}











    /** 
 * @Route("/delete-forum/{id}", name="delete_forum")
 */
public function deleteforum(int $id): Response
{
    $entityManager = $this->getDoctrine()->getManager();
    $forum = $entityManager->getRepository(Forum::class)->find($id);
    $entityManager->remove($forum);
    $entityManager->flush();

    return $this->redirectToRoute("FOROMadmin");
}




      /**
     * @Route("/chat", name="chat")
     */
    public function chat(Request $request ,EntityManagerInterface $entityManager)
    {
        $repo = $this ->getDoctrine()->getRepository(Forum::class);
        $forums=$repo->findAll();
 
        return $this->render('form/forums.html.twig', [
            'controller_name' => 'FormController',
            'forums' => $forums
          
        ]);
    }






     
    /**
     * @Route("/FOROMadmin", name="FOROMadmin")
     */
    public function FOROMadmin(Request $request ,EntityManagerInterface $entityManager)
    {

               
        $repo = $this ->getDoctrine()->getRepository(Forum::class);
        $forums=$repo->findAll();

        return $this->render('form/FOROMadmin.html.twig', [
            'controller_name' => 'FormController',
            'forums' => $forums
        ]);
    }



}
