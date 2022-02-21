<?php

namespace App\Entity;


use Doctrine\ORM\Mapping\Column;
use Doctrine\ORM\Mapping\GeneratedValue;
use App\Repository\ParticipationPriveRepository;
use Symfony\Component\Validator\Constraints\Length;
use Symfony\Component\Validator\Constraints\NotBlank;
use Doctrine\ORM\Mapping as ORM;
use Symfony\Component\Validator\Constraints as Assert;

/**
 * @ORM\Entity(repositoryClass=ParticipationPriveRepository::class)
 */
class ParticipationPrive
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
     * @ORM\Column(type="integer")
     * @Assert\Length( min=8 , max=8)
     * @Assert\NotBlank(message="Le champs NumeroTel est obligatoire * ")
     */
    private $numeroTel;

    /**
     * @ORM\Column(type="string", length=255)
     * @Assert\Email()
     * @Assert\NotBlank(message="Le champs email est obligatoire * ")
     */
    private $email;

    /**
     * @ORM\Column(type="integer")
     * @Assert\Length( min=1 , max=255)
     * @Assert\NotBlank(message="Le champs nombre de prise en charge est obligatoire * ")
     */
    private $nbrPrisecharge;

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

    public function getNumeroTel(): ?int
    {
        return $this->numeroTel;
    }

    public function setNumeroTel(int $numeroTel): self
    {
        $this->numeroTel = $numeroTel;

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

    public function getNbrPrisecharge(): ?int
    {
        return $this->nbrPrisecharge;
    }

    public function setNbrPrisecharge(int $nbrPrisecharge): self
    {
        $this->nbrPrisecharge = $nbrPrisecharge;

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
