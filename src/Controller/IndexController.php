<?php
namespace App\Controller;
use Symfony\Bundle\FrameworkBundle\Controller\AbstractController;
use Symfony\Component\HttpFoundation\Response;
Use Symfony\Component\Routing\Annotation\Route;

class IndexController extends AbstractController
{

   
 /**
     * @Route("/", name="home")
     */
 public function home()
 {
    return $this->render('post/index.html.twig');

 }

   

    

     
    


     


            /**
     * @Route("/About", name="About")
     */
    public function About()
    {
       return $this->render('user/about.html.twig');
   
    }

    
























 /**
     * @Route("/General", name="General")
     */
 public function General()
 {
    return $this->render('admin/General.html.twig');

 }
  /**
     * @Route("/Evenementadmin", name="Evenementadmin")
     */
    public function Evenementadmin()
    {
       return $this->render('admin/Evenementadmin.html.twig');
   
    }
      /**
     * @Route("/FOROMadmin", name="FOROMadmin")
     */
    public function FOROMadmin()
    {
       return $this->render('admin/FOROMadmin.html.twig');
   
    }
          /**
     * @Route("/Participationadmin", name="Participationadmin")
     */
    public function Participationadmin()
    {
       return $this->render('admin/Participationadmin.html.twig');
   
    }
              /**
     * @Route("/Postadmin", name="Postadmin")
     */
    public function Postadmin()
    {
       return $this->render('admin/Postadmin.html.twig');
   
    }
                  /**
     * @Route("/Profil_SDFadmin", name="Profil_SDFadmin")
     */
    public function Profil_SDFadmin()
    {
       return $this->render('admin/Profil_SDFadmin.html.twig');
   
    }
                 /**
     * @Route("/Reclamationadmin", name="Reclamationadmin")
     */
    public function Reclamationadmin()
    {
       return $this->render('admin/Reclamationadmin.html.twig');
   
    }
                     /**
     * @Route("/Users", name="Users")
     */
    public function Users()
    {
       return $this->render('admin/Users.html.twig');
   
    }
    /**
     * @Route("/verif", name="verif")
     */
    public function verif()
    {
       return $this->render('admin/verif.html.twig');
   
    }

      /**
     * @Route("/verif2", name="verif2")
     */
    public function verif2()
    {
       return $this->render('admin/verif2.html.twig');
   
    }



}