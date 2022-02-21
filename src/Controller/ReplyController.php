<?php

namespace App\Controller;

use App\Entity\Forum;
use App\Form\ForumType;

use Symfony\Bundle\FrameworkBundle\Controller\AbstractController;
use Symfony\Component\HttpFoundation\Request;
use App\Repository\ForumRepository;
use Doctrine\ORM\EntityManagerInterface;
use Symfony\Component\HttpFoundation\Response;
use Symfony\Component\Routing\Annotation\Route;

class ReplyController extends AbstractController
{
    /**
     * @Route("/reply", name="reply")
     */
    public function index(): Response
    {
        return $this->render('reply/index.html.twig', [
            'controller_name' => 'ReplyController',
        ]);
    }



     


 



}
