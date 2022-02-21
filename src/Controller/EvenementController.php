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
     * @Route("/ajouterevenement", name="ajouterevenement")
     */
    public function create (Request $request ,EntityManagerInterface $entityManager )
    {

        $evenement = new evenement ();

        $form = $this ->createFormBuilder($evenement)
         ->add ('nom')
         ->add ('typeE')
        ->add ('date_debut')
        ->add ('date_fin')
        ->add ('description')
        ->add ('image')
        ->getForm();

            
      
                $form->handleRequest($request)  ;  
                
                if ($form->isSubmitted() && $form->isValid()) {
                
                  $entityManager->persist($evenement);
                  $entityManager->flush();
    
                  return $this->redirectToRoute('Evenementadmin', ['id' => $evenement ->getId()]);
                }



        return $this->render('evenement/ajouterevenement.html.twig', [
            'formevenement' => $form->createView()
        ]);
    }


 
    
    
/**
 * @Route("/modify-evenement/{id}", name="modify_evenement")
 */
public function modifier (Request $request, int $id): Response
{
    $entityManager = $this->getDoctrine()->getManager();

    $evenement = $entityManager->getRepository(Evenement::class)->find($id);
   
    $form = $this ->createFormBuilder($evenement)
    ->add ('nom')
    ->add ('typeE')
   ->add ('date_debut')
   ->add ('date_fin')
   ->add ('description')
   ->add ('image')
   ->getForm(); 

    $form->handleRequest($request);

    if($form->isSubmitted() && $form->isValid())
    {
        $entityManager->flush();
    }

    return $this->render("evenement/modifier.html.twig", [
        "form_title" => "Modifier un evenement",
        "formevenement" => $form->createView(),
    ]);
}



    /**
 * @Route("/delete-evenement/{id}", name="delete_evenement")
 */
public function delete (int $id): Response
{
    $entityManager = $this->getDoctrine()->getManager();
    $evenement = $entityManager->getRepository(Evenement::class)->find($id);
    $entityManager->remove($evenement);
    $entityManager->flush();

    return $this->redirectToRoute("Evenementadmin");
}





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



    

    /**
 * @Route("/evenement/{id}", name="evenement")
 */
public function evenement(int $id): Response
{
    $evenement = $this->getDoctrine()->getRepository(Evenement::class)->find($id);

    return $this->render("evenement/evenement.html.twig", [
        "evenement" => $evenement,
    ]);
}









    
}
 