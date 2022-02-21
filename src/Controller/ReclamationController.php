<?php

namespace App\Controller;

use App\Entity\Reclamation;
use App\Form\ReclamationType;

use Symfony\Bundle\FrameworkBundle\Controller\AbstractController;
use Symfony\Component\HttpFoundation\Request;
use App\Repository\ReclamationRepository;
use Doctrine\ORM\EntityManagerInterface;
use Symfony\Component\HttpFoundation\Response;
use Symfony\Component\Routing\Annotation\Route;


class ReclamationController extends AbstractController
{
 



    /**
     * @Route("/reclamation", name="reclamationCreate")
     */
    public function create (Request $request ,EntityManagerInterface $entityManager)
    { 
 
        $Reclamation = new Reclamation ();

        $form = $this ->createForm(ReclamationType::class,$Reclamation);
                     
       
      
                $form->handleRequest($request)  ;  
                
                if ($form->isSubmitted() && $form->isValid()) {


                    //upload image
            $uploadFile = $form['image']->getData(); // valeur  image
            $filename = md5(uniqid()) . '.' .$uploadFile->guessExtension();//crypter image

            $uploadFile->move($this->getParameter('kernel.project_dir').'/public/uploads/hotel_image',$filename);


            $Reclamation->setImage($filename);

            //-----


                         
                  $Reclamation->setCreatedAt(new \DatetimeImmutable ());
                  $entityManager->persist($Reclamation);
                  $entityManager->flush();
       
                  
                  return $this->redirectToRoute('reclamationadmin', ['id' => $Reclamation ->getId()]); 
        }
           
        return $this->render('reclamation/index.html.twig', [
            'formReclamation' => $form->createView()
          
        ]);
 
    }





 

    /**
     * @Route("/reclamationadmin", name="reclamationadmin")
     */
    public function reclamations(Request $request ,EntityManagerInterface $entityManager)
    {

        $repo = $this ->getDoctrine()->getRepository(Reclamation::class);
        $Reclamations=$repo->findAll();

        return $this->render('reclamation/Reclamationadmin.html.twig', [
            'controller_name' => 'ReclamationController',
             'Reclamations' => $Reclamations
           
        ]);
    }












 
    

    /**
 * @Route("/Reclamation/{id}", name="Reclamation")
 */
public function reclamation(int $id): Response
{
    $Reclamation = $this->getDoctrine()->getRepository(Reclamation::class)->find($id);

    return $this->render("reclamation/reclamation.html.twig", [
        "Reclamation" => $Reclamation,
    ]);
}








    /**
 * @Route("/delete-Reclamation/{id}", name="delete_Reclamation")
 */
public function deleteReclamation(int $id): Response
{
    $entityManager = $this->getDoctrine()->getManager();
    $Reclamation = $entityManager->getRepository(Reclamation::class)->find($id);
    $entityManager->remove($Reclamation);
    $entityManager->flush();

    return $this->redirectToRoute("reclamationadmin");
}


}
