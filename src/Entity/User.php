<?php

namespace App\Entity;

use App\Repository\UserRepository;
use Doctrine\ORM\Mapping as ORM;
use Symfony\Component\Security\Core\User\UserInterface;
use Symfony\Component\Validator\Constraints as Assert;


/**
 * @ORM\Entity(repositoryClass=UserRepository::class)

 */
class User implements UserInterface
{
    /** 
     * @ORM\Id
     * @ORM\GeneratedValue
     * @ORM\Column(type="integer")
     */
    private $id;

    /**
     * @ORM\Column(type="string", length=255)
     * @Assert\Email(message="l adresse  n est pas valide")
     */
    private $email;

    /**
     * @ORM\Column(type="string", length=255)
     *  @Assert\Length( min = 3, max = 20, minMessage = "Merci de Vérifier Votre nom")
     * @Assert\Type(type={"alpha", "digit"}, message="Votre nom {{ value }} doit contenir  seulement des lettres alphabétiques" )
     */
    private $username;

        /**
     * @ORM\Column(type="datetime_immutable")
     */
    private $createdAt;

    /**
     * @ORM\Column(type="json")
     */
    private $roles = [];

    /**
     * @ORM\Column(type="string", length=255)
     *  @Assert\Length( min=6 , minMessage="votre mot de passe doit faire de minuimum 6 caracteres")
     * @Assert\EqualTo(propertyPath="confirm_password"))
     */
    private $password;

   /**
     * @ORM\Column(type="string", length=255)
     *  @Assert\Length( min=6 , minMessage="votre mot de passe doit faire de minuimum 6 caracteres")
     * @Assert\EqualTo(propertyPath="password"))
     */
    public $confirm_password;



    public function getId(): ?int
    {
        return $this->id;
    }

    public function getEmail(): ?string
    {
        return $this->email;
    }

    public function setEmail(string $email): self
    {
        $this->email = $email;

        return $this;
    }

    public function getUsername(): ?string
    {
        return $this->username;
    }

    public function setUsername(string $username): self
    {
        $this->username = $username;

        return $this;
    }

    public function getCreatedAt(): ?\DateTimeImmutable
    {
        return $this->createdAt;
    }

    public function setCreatedAt(\DateTimeImmutable $createdAt): self
    {
        $this->createdAt = $createdAt;

        return $this;
    }


    public function setRoles(array $roles): self
    {
        $this->roles = $roles;

        return $this;
    }



    public function getPassword(): ?string
    {
        return $this->password;
    }

    public function setPassword(string $password): self
    {
        $this->password = $password;

        return $this;
    }


    public function eraseCredentials(){}
    
    public function getSalt(){}

    
    public function getRoles(){
        $roles = $this->roles;
        // guarantee every user at least has ROLE_USER
        $roles[] = 'ROLE_USER';

        return array_unique($roles);
    }



  
}
