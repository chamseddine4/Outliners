<?php

namespace App\Controller;

use App\Entity\Profil;
use App\Form\ProfilType;
use Symfony\Bundle\FrameworkBundle\Controller\AbstractController;
use Symfony\Component\HttpFoundation\Request;
use App\Repository\ProfilRepository;
use Doctrine\ORM\EntityManagerInterface;
use Symfony\Component\HttpFoundation\Response;
use Symfony\Component\Routing\Annotation\Route;





class UsersController extends AbstractController
{

   


    /**   
     * @Route("/Users", name="Users")
     */
    public function Users(Request $request ,EntityManagerInterface $entityManager)
    {

        $repo = $this ->getDoctrine()->getRepository(Profil::class);
        $Profils=$repo->findAll();

        return $this->render('users/Users.html.twig', [
            'controller_name' => 'UsersController',
            'Profils' => $Profils
        ]);
    }



          /**
     * @Route("/login", name="login")
     */
    public function login(): Response
    {
        return $this->render('users/login.html.twig', [
            'controller_name' => 'UsersController',
        ]);
    }


     
    /**
     * @Route("/General", name="General")
     */
    public function General(): Response
    {
        return $this->render('users/General.html.twig', [
            'controller_name' => 'UsersController',
        ]);
    }
         
      
}

