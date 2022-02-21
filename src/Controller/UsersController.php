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
     * @Route("/inscription", name="inscription")
     */

    public function create (Request $request ,EntityManagerInterface $entityManager  )
    { 

      $Profil = new Profil ();

  $form = $this ->createForm(ProfilType::class,$Profil);
             

          $form->handleRequest($request)  ;  
          
          if ($form->isSubmitted() && $form->isValid()) {
            $Profil->setCreatedAt(new \DatetimeImmutable ());
            $entityManager->persist($Profil);
            $entityManager->flush();


            return $this->redirectToRoute('Users', ['id' => $Profil ->getId()]);

          }
         
 
        return $this->render('users/inscription.html.twig', [
            'formProfil' => $form->createView()
        ]);
    }







    
    /**
 * @Route("/profil/{id}", name="Profil")
 */
    public function profil(int $id): Response
    {

        $Profil = $this->getDoctrine()->getRepository(Profil::class)->find($id);

        return $this->render('users/profil.html.twig', [
            "Profil" => $Profil,
        ]);
    }








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
 * @Route("/modify-Profil/{id}", name="modify_Profil")
 */
public function modifyProfil(Request $request, int $id): Response
{
    $entityManager = $this->getDoctrine()->getManager();

    $Profil = $entityManager->getRepository(Profil::class)->find($id);
    $form = $this->createForm(ProfilType::class, $Profil);
    $form->handleRequest($request);

    if($form->isSubmitted() && $form->isValid())
    {
        $entityManager->flush();
    }

    return $this->render("users/modifier.html.twig", [
        "form_title" => "Modifier un produit",
        "formProfil" => $form->createView(),
    ]);
}



    /**
 * @Route("/delete-Profil/{id}", name="delete_Profil")
 */
public function deleteReclamation(int $id): Response
{
    $entityManager = $this->getDoctrine()->getManager();
    $Profil = $entityManager->getRepository(Profil::class)->find($id);
    $entityManager->remove($Profil);
    $entityManager->flush();

    return $this->redirectToRoute("Users");
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

