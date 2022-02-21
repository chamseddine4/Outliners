<?php

namespace App\Controller;

use Symfony\Bundle\FrameworkBundle\Controller\AbstractController;
use Symfony\Component\HttpFoundation\Response;
use Symfony\Component\Routing\Annotation\Route;

class ProfilsdfController extends AbstractController
{
    /**
     * @Route("/profilSDF", name="profilSDF")
     */
    public function index(): Response
    {
        return $this->render('profilsdf/index.html.twig', [
            'controller_name' => 'ProfilsdfController',
        ]);
    }
       
    /**
     * @Route("/Profil_SDFadmin", name="Profil_SDFadmin")
     */
    public function Profil_SDFadmin(): Response
    {
        return $this->render('profilsdf/Profil_SDFadmin.html.twig', [
            'controller_name' => 'ProfilsdfController',
        ]);
    }
}
