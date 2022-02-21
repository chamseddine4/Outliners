<?php

namespace App\Repository;

use App\Entity\ListSdf;
use Doctrine\Bundle\DoctrineBundle\Repository\ServiceEntityRepository;
use Doctrine\Persistence\ManagerRegistry;

/**
 * @method ListSdf|null find($id, $lockMode = null, $lockVersion = null)
 * @method ListSdf|null findOneBy(array $criteria, array $orderBy = null)
 * @method ListSdf[]    findAll()
 * @method ListSdf[]    findBy(array $criteria, array $orderBy = null, $limit = null, $offset = null)
 */
class ListSdfRepository extends ServiceEntityRepository
{
    public function __construct(ManagerRegistry $registry)
    {
        parent::__construct($registry, ListSdf::class);
    }

    // /**
    //  * @return ListSdf[] Returns an array of ListSdf objects
    //  */
    /*
    public function findByExampleField($value)
    {
        return $this->createQueryBuilder('l')
            ->andWhere('l.exampleField = :val')
            ->setParameter('val', $value)
            ->orderBy('l.id', 'ASC')
            ->setMaxResults(10)
            ->getQuery()
            ->getResult()
        ;
    }
    */

    /*
    public function findOneBySomeField($value): ?ListSdf
    {
        return $this->createQueryBuilder('l')
            ->andWhere('l.exampleField = :val')
            ->setParameter('val', $value)
            ->getQuery()
            ->getOneOrNullResult()
        ;
    }
    */
}
