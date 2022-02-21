<?php

namespace App\Controller;

use App\Entity\ParticipationPublic;
use App\Entity\ParticipationPrive;
use App\Entity\Paiement;
use Symfony\Bundle\FrameworkBundle\Controller\AbstractController;
use Symfony\Component\HttpFoundation\Request;
use App\Repository\ParticipationPublicRepository;
use App\Repository\ParticipationPriveRepository;
use App\Repository\PaiementRepository;
use Doctrine\ORM\EntityManagerInterface;
use Symfony\Component\HttpFoundation\Response;
use Symfony\Component\Routing\Annotation\Route;

class ParticipationController extends AbstractController
{
    

   

        /**
     * @Route("/participationpublicadmin", name="participationpublicadmin")
     */

    public function participationpublicadmin(): Response
    {
        $repo = $this ->getDoctrine()->getRepository(ParticipationPublic::class);
        $ParticipationPublics=$repo->findAll();
        return $this->render('participation/participationpublicadmin.html.twig', [
            'controller_name' => 'ParticipationController',
            'ParticipationPublics' => $ParticipationPublics,
        ]);
    } 




  

    /**
     * @Route("/participationpriveadmin", name="participationpriveadmin")
     */

    public function participationpriveadmin(): Response
    {
      
        $repo = $this ->getDoctrine()->getRepository(ParticipationPrive::class);
        $ParticipationPrives=$repo->findAll();
        return $this->render('participation/participationpriveadmin.html.twig', [
            'controller_name' => 'ParticipationController',
            'ParticipationPrives' => $ParticipationPrives,
        ]);
    } 








                /**
     * @Route("/verif", name="verif")
     */
    public function verif(): Response
    {
        return $this->render('participation/verif.html.twig', [
            'controller_name' => 'ParticipationController',
        ]);
    } 



    
        /** 
     * @Route("/paiementadmin", name="paiementadmin")
     */
    public function showpaiment (): Response
    {

        $repo = $this ->getDoctrine()->getRepository(Paiement::class);
        $Paiements=$repo->findAll();
        return $this->render('participation/paiementadmin.html.twig', [
            'controller_name' => 'ParticipationController',
            'Paiements' => $Paiements,
        ]); 
    } 


}
