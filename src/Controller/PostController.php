<?php

namespace App\Controller;

use Symfony\Bundle\FrameworkBundle\Controller\AbstractController;
use Symfony\Component\HttpFoundation\Response;
use Symfony\Component\Routing\Annotation\Route;

class PostController extends AbstractController
{
       


    /**
     * @Route("/", name="post")
     */
    public function home(): Response
    {
        return $this->render('post/index.html.twig', [
            'controller_name' => 'PostController',
        ]);
    }

        /**
     * @Route("/Postadmin", name="Postadmin")
     */
    public function Postadmin(): Response
    {
        return $this->render('post/Postadmin.html.twig', [
            'controller_name' => 'PostController',
        ]);
    }


}
