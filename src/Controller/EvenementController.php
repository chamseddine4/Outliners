<?php

namespace App\Controller;
use App\Entity\Evenement;
use Symfony\Bundle\FrameworkBundle\Controller\AbstractController;
use Symfony\Component\HttpFoundation\Request;
use App\Repository\EvenementRepository;
use Doctrine\ORM\EntityManagerInterface;
use Symfony\Component\HttpFoundation\Response;
use Symfony\Component\Routing\Annotation\Route;

class EvenementController extends AbstractController
{


 


    /**
     * @Route("/event", name="event") 
     */
    public function index(): Response
    {
        $repo = $this ->getDoctrine()->getRepository(evenement::class);
        $evenements=$repo->findAll();
        return $this->render('evenement/index.html.twig', [
            'controller_name' => 'EvenementController',
            'evenements' => $evenements
        ]);
    }
 




    /**
     * @Route("/Evenementadmin", name="Evenementadmin") 
     */
    public function Evenementadmin(): Response
    {
        $repo = $this ->getDoctrine()->getRepository(evenement::class);
        $evenements=$repo->findAll();
        return $this->render('evenement/Evenementadmin.html.twig', [
            'controller_name' => 'EvenementController',
            'evenements' => $evenements
        ]);
    }










    
}
 