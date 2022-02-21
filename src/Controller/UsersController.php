<?php

namespace App\Controller;

use App\Entity\User;
use App\Form\UserType;
use App\Form\ProfilType;
use Symfony\Component\Routing\Annotation\Route;
use Symfony\Bundle\FrameworkBundle\Controller\AbstractController;
use Symfony\Component\HttpFoundation\Request;
use App\Repository\UserRepository;
use Doctrine\ORM\EntityManagerInterface;
use Symfony\Component\HttpFoundation\Response;
use Symfony\Component\Security\Core\Encoder\UserPasswordEncoderInterface;
use Symfony\Component\Security\Http\Authentication\AuthenticationUtils;
use Sensio\Bundle\FrameworkExtraBundle\Configuration\IsGranted;



class UsersController extends AbstractController
{

   
      /** 
     * @Route("/inscription", name="inscription")
     */

    public function create (Request $request ,EntityManagerInterface $entityManager , UserPasswordEncoderInterface $encoder  )
    { 
       
      $User = new User ();

       $form = $this ->createForm(UserType::class,$User);
             

          $form->handleRequest($request)  ;  
          
          if ($form->isSubmitted() && $form->isValid()) {

            $hash = $encoder->encodePassword($User, $User->getPassword());

            $User->setPassword($hash);
            $User->setCreatedAt(new \DatetimeImmutable ());
            $entityManager->persist($User);
            $entityManager->flush();


            return $this->redirectToRoute('login');

          }
         
 
        return $this->render('users/inscription.html.twig', [
            'formProfil' => $form->createView()
        ]);
    }







    
    /**
 * @Route("/profiluser/{id}", name="Profil")
 */
    public function profiluser(int $id): Response
    {

        $User = $this->getDoctrine()->getRepository(User::class)->find($id);

        return $this->render('users/profil.html.twig', [
            "User" => $User,
        ]);
    }








    /**   
     * @Route("/Users", name="Users")
     */
    public function Users(Request $request ,EntityManagerInterface $entityManager)
    {

        $repo = $this ->getDoctrine()->getRepository(User::class);
        $Users=$repo->findAll();

        return $this->render('users/Users.html.twig', [
            'controller_name' => 'UsersController',
            'Users' => $Users
        ]);
    }





    
    
/** 
 * @Route("/modify-Profil/{id}", name="modify_Profil")
 */
public function modifyProfil(Request $request, int $id): Response
{
   
    $entityManager = $this->getDoctrine()->getManager();

    $User = $entityManager->getRepository(User::class)->find($id);
    $form = $this->createForm(UserType::class, $User);
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
    $User = $entityManager->getRepository(User::class)->find($id);
    $entityManager->remove($User);
    $entityManager->flush();

    return $this->redirectToRoute("Users");
}





     /**
     * @Route("/login", name="login")
     */
    public function login(AuthenticationUtils $utils)
    {

       $error = $utils ->getLastAuthenticationError();


        return $this->render('users/login.html.twig', [
            'hasError' => $error !== null 
        
        ]);
    }

    

          /**
     * @Route("/logout", name="logout")
     */
    public function logout()
    {
    }








     /**
     * @Route("/profile", name="profile")
     */
    public function profileModifier(Request $request,EntityManagerInterface $entityManager)
    {
        $User = $this->getUser();
        $form = $this->createForm(ProfilType::class, $User);

        $form->handleRequest($request);
        if ($form->isSubmitted() && $form->isValid()) {

            $entityManager->persist($User);
            $entityManager->flush();
            return $this->redirectToRoute('post');
 }


        return $this->render('users/profile.html.twig',[
            "form" => $form->createView(),
        ]);
    }



     
    /**
     * @Route("/myaccounty", name="myaccounty")
     */
    public function myaccounty()
    {
        return $this->render('users/index.html.twig', [
           'User' => $this->getUser()
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

