<?php

namespace App\Entity;

use App\Repository\ParticipationPublicRepository;
use Doctrine\ORM\Mapping as ORM;
use Symfony\Component\Validator\Constraints as Assert;

/**
 * @ORM\Entity(repositoryClass=ParticipationPublicRepository::class)
 */
class ParticipationPublic
{
    /**
     * @ORM\Id
     * @ORM\GeneratedValue
     * @ORM\Column(type="integer")
     */
    private $id;

    /**
     * @ORM\Column(type="string", length=255)
       * @Assert\Length( min = 3, max = 20, minMessage = "Merci de Vérifier Votre nom")
       * @Assert\NotBlank(message="Le champs nom est obligatoire * ")
     */
    private $nom;

    /**
     * @ORM\Column(type="string", length=255)
       * @Assert\Length( min = 3, max = 20, minMessage = "Merci de Vérifier Votre prenom")
       * @Assert\NotBlank(message="Le champs prenom est obligatoire * ")
     */
    private $prenom;

    /**
     * @ORM\Column(type="string", length=255)
     * @Assert\Email()
     * @Assert\NotBlank(message="Le champs email est obligatoire * ")
     */
    private $email;

    /**
     * @ORM\Column(type="integer")
     */

    /**
     * @ORM\Column(type="float")
     * @Assert\Length(min=1)
    * @Assert\NotBlank(message="Le champs donation est obligatoire * ")
    
     */
    private $donation;

    /**
     * @ORM\Column(type="datetime_immutable")
     */
    private $createdAt;

    public function getId(): ?int
    {
        return $this->id;
    }

    public function getNom(): ?string
    {
        return $this->nom;
    }

    public function setNom(string $nom): self
    {
        $this->nom = $nom;

        return $this;
    }

    public function getPrenom(): ?string
    {
        return $this->prenom;
    }

    public function setPrenom(string $prenom): self
    {
        $this->prenom = $prenom;

        return $this;
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

    public function getNumeroTel(): ?int
    {
        return $this->numeroTel;
    }

    public function setNumeroTel(int $numeroTel): self
    {
        $this->numeroTel = $numeroTel;

        return $this;
    }

    public function getDonation(): ?float
    {
        return $this->donation;
    }

    public function setDonation(float $donation): self
    {
        $this->donation = $donation;

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
}
