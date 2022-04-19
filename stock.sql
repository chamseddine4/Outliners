-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le : mer. 09 mars 2022 à 16:44
-- Version du serveur : 10.4.22-MariaDB
-- Version de PHP : 7.4.27

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `stock`
--

-- --------------------------------------------------------

--
-- Structure de la table `fournisseur`
--

CREATE TABLE `fournisseur` (
  `ID` int(11) NOT NULL,
  `nom` varchar(255) NOT NULL,
  `adress` varchar(255) NOT NULL,
  `num_tel` int(11) NOT NULL,
  `email` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `fournisseur`
--

INSERT INTO `fournisseur` (`ID`, `nom`, `adress`, `num_tel`, `email`) VALUES
(7, 'a', 'a', 1, 'a'),
(11, 'a', 'a', 1, 'a'),
(13, 'dhia', 'mourou', 987777, 'adel9860@gmail.com'),
(27, 'am', 'kk', 123, 'dhia'),
(28, 'am', 'kk', 123, 'dhia'),
(30, 'am', 'kk', 123, 'dhia'),
(31, 'am', 'kk', 123, 'dhia'),
(32, 'am', 'kk', 123, 'dhia'),
(33, 'am', 'kk', 123, 'dhia'),
(34, 'am', 'kk', 123, 'dhia'),
(35, 'am', 'kk', 123, 'dhia'),
(36, 'am', 'kk', 123, 'dhia'),
(37, 'am', 'kk', 123, 'dhia'),
(38, 'am', 'kk', 123, 'dhia'),
(39, 'nourhene', 'm', 988, 'nourhene.lihiouel@esprit.tn'),
(40, 'nourhene', 'm', 988, 'nourhene.lihiouel@esprit.tn'),
(41, 'a', 'z', 99, 'nourhene.lihouil@esprit.tn'),
(42, 'a', 'z', 99, 'dhia.elair@esprit.tn@esprit.tn'),
(43, 'a', 'z', 99, 'adel9860@gmail.com'),
(44, 'a', 'a', 1, 'a'),
(45, 'a', 'a', 11, 'dhia.elair@esprit.tn'),
(48, 'am', 'kk', 123, 'dhia'),
(49, 'am', 'kk', 123, 'dhia'),
(50, 'am', 'kk', 123, 'dhia');

-- --------------------------------------------------------

--
-- Structure de la table `panier`
--

CREATE TABLE `panier` (
  `id` int(11) NOT NULL,
  `prix` int(11) NOT NULL,
  `quantite` int(11) NOT NULL,
  `date_exp` date NOT NULL,
  `type` varchar(255) NOT NULL,
  `nom` varchar(255) NOT NULL,
  `image` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `panier`
--

INSERT INTO `panier` (`id`, `prix`, `quantite`, `date_exp`, `type`, `nom`, `image`) VALUES
(7, 12, 1, '2022-03-12', 'materiel', 'aazzéé', 'aae.jpg'),
(8, 12, 1, '2022-03-12', 'materiel', 'aazz', ''),
(9, 50, 2, '2022-03-08', 'produit', 'Maram', 'images.jpg'),
(10, 12, 1, '2022-03-12', 'materiel', 'aazzéé', 'aae.jpg'),
(11, 12, 1, '2022-03-09', 'produit', 'aa', ''),
(12, 12, 2, '2022-03-09', 'materiel', 'a', 'images.jpg');

-- --------------------------------------------------------

--
-- Structure de la table `produit`
--

CREATE TABLE `produit` (
  `id` int(11) NOT NULL,
  `prix` int(11) NOT NULL,
  `quantite` int(11) NOT NULL,
  `date_exp` date NOT NULL,
  `type` varchar(11) NOT NULL,
  `nom` varchar(255) NOT NULL,
  `image` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `produit`
--

INSERT INTO `produit` (`id`, `prix`, `quantite`, `date_exp`, `type`, `nom`, `image`) VALUES
(38, 12, 1, '2022-03-09', 'produit', 'aa', ''),
(39, 12, 1, '2022-03-06', 'produit', 'a', 'a'),
(40, 50, 2, '2022-03-08', 'produit', 'Maram', 'images.jpg'),
(41, 12, 2, '2022-03-09', 'materiel', 'a', 'images.jpg'),
(42, 12, 2, '2022-03-09', 'materiel', 'a', 'images.jpg'),
(43, 12, 1, '2022-03-09', 'produit', 'aa', ''),
(44, 12, 1, '2022-03-09', 'produit', 'aa', ''),
(45, 33, 1, '2022-03-05', 'produit', 'MM', 'aae.jpg'),
(47, 12, 1, '2022-03-12', 'materiel', 'aazz', ''),
(48, 12, 1, '2022-03-12', 'materiel', 'aazzéé', 'aae.jpg'),
(49, 12, 1, '2022-03-12', 'produit', 'aazzéé', 'aae.jpg');

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `fournisseur`
--
ALTER TABLE `fournisseur`
  ADD PRIMARY KEY (`ID`);

--
-- Index pour la table `panier`
--
ALTER TABLE `panier`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `produit`
--
ALTER TABLE `produit`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `fournisseur`
--
ALTER TABLE `fournisseur`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=51;

--
-- AUTO_INCREMENT pour la table `panier`
--
ALTER TABLE `panier`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT pour la table `produit`
--
ALTER TABLE `produit`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=50;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
