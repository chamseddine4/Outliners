<?php

namespace App\Entity;

use App\Repository\PaiementRepository;
use Doctrine\ORM\Mapping as ORM;
use Symfony\Component\Validator\Constraints as Assert;

/**
 * @ORM\Entity(repositoryClass=PaiementRepository::class)
 */
class Paiement
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
     * @Assert\NotBlank(message="Le champs nom sur carte est obligatoire * ")
     */
    private $NomSurCarte;

    /**
     * @ORM\Column(type="integer")
     * @Assert\Length( min=16 , max=16)
     * @Assert\NotBlank(message="Le champs NumeroTel est obligatoire * ")
     */
    private $NumCarte;

    /**
     * @ORM\Column(type="string", length=255)
     * @Assert\Length( min = 3, max = 20, minMessage = "Merci de Vérifier Votre MoisExp")
     * @Assert\NotBlank(message="Le champs MoisExp est obligatoire * ")
     */
    private $MoisExp;

    /**
     * @ORM\Column(type="integer")
     * @Assert\Length( min=4 , max=4)
     * @Assert\NotBlank(message="Le champs AnneeExp est obligatoire * ")
     */
    private $AnneeExp;

    /**
     * @ORM\Column(type="integer")
     * @Assert\Length( min=3 , max=3)
     * @Assert\NotBlank(message="Le champs CVV est obligatoire * ")
     */
    private $CVV;

    public function getId(): ?int
    {
        return $this->id;
    }

    public function getNomSurCarte(): ?string
    {
        return $this->NomSurCarte;
    }

    public function setNomSurCarte(string $NomSurCarte): self
    {
        $this->NomSurCarte = $NomSurCarte;

        return $this;
    }

    public function getNumCarte(): ?int
    {
        return $this->NumCarte;
    }

    public function setNumCarte(int $NumCarte): self
    {
        $this->NumCarte = $NumCarte;

        return $this;
    }

    public function getMoisExp(): ?string
    {
        return $this->MoisExp;
    }

    public function setMoisExp(string $MoisExp): self
    {
        $this->MoisExp = $MoisExp;

        return $this;
    }

    public function getAnneeExp(): ?int
    {
        return $this->AnneeExp;
    }

    public function setAnneeExp(int $AnneeExp): self
    {
        $this->AnneeExp = $AnneeExp;

        return $this;
    }

    public function getCVV(): ?int
    {
        return $this->CVV;
    }

    public function setCVV(int $CVV): self
    {
        $this->CVV = $CVV;

        return $this;
    }
}
