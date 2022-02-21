<?php

namespace App\Controller;

use App\Entity\Forum;
use App\Form\ForumType;

use Symfony\Bundle\FrameworkBundle\Controller\AbstractController;
use Symfony\Component\HttpFoundation\Request;
use App\Repository\ForumRepository;
use Doctrine\ORM\EntityManagerInterface;
use Symfony\Component\HttpFoundation\Response;
use Symfony\Component\Routing\Annotation\Route;

class FormController extends AbstractController
{

 


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
