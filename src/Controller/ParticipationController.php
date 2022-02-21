<?php

namespace App\Controller;

use App\Entity\ParticipationPublic;
use App\Entity\ParticipationPrive;
use App\Entity\Paiement;
use App\Form\PaiementType;
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
     * @Route("/participationpublic", name="participationpublic")
     */
    public function createparticipationpublic (Request $request ,EntityManagerInterface $entityManager )
    {

        $ParticipationPublic = new ParticipationPublic ();

        $form = $this ->createFormBuilder($ParticipationPublic)
                      ->add ('nom')
                      ->add ('prenom')
                      ->add ('email')
                      ->add ('donation')
                      ->getForm();
       
      
                $form->handleRequest($request)  ;  
                
                if ($form->isSubmitted() && $form->isValid()) {
                  $ParticipationPublic->setCreatedAt(new \DatetimeImmutable ());
                  $entityManager->persist($ParticipationPublic);
                  $entityManager->flush();
      
      
                  return $this->redirectToRoute('paiment', ['id' => $ParticipationPublic ->getId()]);
      
                }

        return $this->render('participation/participationpublic.html.twig', [
            'formParticipationPublic' => $form->createView()
        ]);
    } 


  /**
 * @Route("/public/{id}", name="public")
 */
public function showpublic (int $id): Response
{
    $public = $this->getDoctrine()->getRepository(ParticipationPublic::class)->find($id);

    return $this->render("participation/public.html.twig", [
        "public" => $public
    ]);
}



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
 * @Route("/delete-public/{id}", name="delete_public")
 */
public function deletepublic(int $id): Response
{
    $entityManager = $this->getDoctrine()->getManager();
    $public = $entityManager->getRepository(ParticipationPublic::class)->find($id);
    $entityManager->remove($public);
    $entityManager->flush();

    return $this->redirectToRoute("participationpublicadmin");
}















    /**
     * @Route("/participationprive", name="participationprive")
     */
    public function createparticipationprive (Request $request ,EntityManagerInterface $entityManager )
    {

        $ParticipationPrive = new ParticipationPrive ();

        $form = $this ->createFormBuilder($ParticipationPrive)
                      ->add ('nom')
                      ->add ('numeroTel')
                      ->add ('email')
                      ->add ('nbrPrisecharge')
                      ->getForm();
       
      
                $form->handleRequest($request)  ;  
                
                if ($form->isSubmitted() && $form->isValid()) {
                  $ParticipationPrive->setCreatedAt(new \DatetimeImmutable ());
                  $entityManager->persist($ParticipationPrive);
                  $entityManager->flush();
      
      
                  return $this->redirectToRoute('verif', ['id' => $ParticipationPrive ->getId()]);
      
                }

        return $this->render('participation/participationprive.html.twig', [
            'formParticipationPrive' => $form->createView()
        ]);
    } 




    /**
 * @Route("/prive/{id}", name="prive")
 */
public function showprivee (int $id): Response
{
    $prive = $this->getDoctrine()->getRepository(ParticipationPrive::class)->find($id);

    return $this->render("participation/prive.html.twig", [
        "prive" => $prive
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
 * @Route("/delete-prive/{id}", name="delete_prive")
 */
public function deleteprive(int $id): Response
{
    $entityManager = $this->getDoctrine()->getManager();
    $prive = $entityManager->getRepository(ParticipationPrive::class)->find($id);
    $entityManager->remove($prive);
    $entityManager->flush();

    return $this->redirectToRoute("participationpriveadmin");
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
     * @Route("/create_paiment", name="paiment")
     */
    public function createpaiment (Request $request ,EntityManagerInterface $entityManager )
    {

        $Paiement = new Paiement ();

        $form = $this ->createFormBuilder($Paiement)
          ->add ('NomSurCarte')
          ->add ('NumCarte')
          ->add ('MoisExp')
          ->add ('AnneeExp')
          ->add ('CVV')
          ->getForm();

              
                $form->handleRequest($request)  ;  
                
                if ($form->isSubmitted() && $form->isValid()) {
               
                  $entityManager->persist($Paiement);
                  $entityManager->flush();
      
                  return $this->redirectToRoute('verif', ['id' => $Paiement ->getId()]);
      
               }

        return $this->render('participation/paiment.html.twig', [
            'formPaiement' => $form->createView()
        ]);
    } 




    

    /**
 * @Route("/Paiement/{id}", name="Paiement")
 */
public function index (int $id): Response
{
    $Paiement = $this->getDoctrine()->getRepository(Paiement::class)->find($id);

    return $this->render("participation/index.html.twig", [
        "Paiement" => $Paiement,
    ]);
}





    /**
 * @Route("/delete-Paiement/{id}", name="delete_Paiement")
 */
public function deletePaiement(int $id): Response
{
    $entityManager = $this->getDoctrine()->getManager();
    $Paiement = $entityManager->getRepository(Paiement::class)->find($id);
    $entityManager->remove($Paiement);
    $entityManager->flush();

    return $this->redirectToRoute("paiementadmin");
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



/** 
 * @Route("/modify-Paiement/{id}", name="modify_Paiement")
 */
public function modifyPaiement(Request $request, int $id): Response
{
    $entityManager = $this->getDoctrine()->getManager();

    $Paiement = $entityManager->getRepository(Paiement::class)->find($id);
    $form = $this->createForm(PaiementType::class, $Paiement);
    $form->handleRequest($request);

    if($form->isSubmitted() && $form->isValid())
    {
        $entityManager->flush();
        return $this->redirectToRoute('verif', ['id' => $Paiement ->getId()]);
    }

    return $this->render("participation/modifier.html.twig", [
        "form_title" => "Modifier Paiement",
        "formPaiement" => $form->createView(),
    ]);
}










}
