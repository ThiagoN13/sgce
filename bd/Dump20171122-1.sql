-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: sgce
-- ------------------------------------------------------
-- Server version	5.5.5-10.1.28-MariaDB

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `aparelho`
--

DROP TABLE IF EXISTS `aparelho`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `aparelho` (
  `id_aparelho` int(5) NOT NULL AUTO_INCREMENT,
  `nome_aparelho` varchar(30) NOT NULL,
  `potencia` varchar(7) NOT NULL,
  `comodo` enum('sala','quarto','cozinha','banheiro','area_servico','outro') NOT NULL,
  `id_usuario` int(5) NOT NULL,
  PRIMARY KEY (`id_aparelho`),
  KEY `id_usuario` (`id_usuario`),
  CONSTRAINT `aparelho_ibfk_1` FOREIGN KEY (`id_usuario`) REFERENCES `usuario` (`id_usuario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `aparelho`
--

LOCK TABLES `aparelho` WRITE;
/*!40000 ALTER TABLE `aparelho` DISABLE KEYS */;
/*!40000 ALTER TABLE `aparelho` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bandeira`
--

DROP TABLE IF EXISTS `bandeira`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `bandeira` (
  `id_bandeira` int(5) NOT NULL AUTO_INCREMENT,
  `verde` tinyint(1) NOT NULL,
  `amarela` tinyint(1) NOT NULL,
  `vermelha_1` tinyint(1) NOT NULL,
  `vermelha_2` tinyint(1) NOT NULL,
  PRIMARY KEY (`id_bandeira`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bandeira`
--

LOCK TABLES `bandeira` WRITE;
/*!40000 ALTER TABLE `bandeira` DISABLE KEYS */;
/*!40000 ALTER TABLE `bandeira` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `historico_consumo`
--

DROP TABLE IF EXISTS `historico_consumo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `historico_consumo` (
  `id_historico` int(5) NOT NULL AUTO_INCREMENT,
  `data_atual` datetime NOT NULL,
  `valor_em_preco` double(20) NOT NULL,
  `quantidade_de_aparelhos` int(10) NOT NULL,
  `quantidade_da_potencia` int(10) NOT NULL,
  `tipo_calculo` enum('diario','mensal') NOT NULL DEFAULT 'diario',
  `id_aprelho` int(5) NOT NULL,
  `id_bandeira` int(5) NOT NULL,
  PRIMARY KEY (`id_historico`),
  KEY `id_aprelho` (`id_aprelho`),
  KEY `id_bandeira` (`id_bandeira`),
  CONSTRAINT `historico_consumo_ibfk_1` FOREIGN KEY (`id_aprelho`) REFERENCES `aparelho` (`id_aparelho`),
  CONSTRAINT `historico_consumo_ibfk_2` FOREIGN KEY (`id_bandeira`) REFERENCES `bandeira` (`id_bandeira`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `historico_consumo`
--

LOCK TABLES `historico_consumo` WRITE;
/*!40000 ALTER TABLE `historico_consumo` DISABLE KEYS */;
/*!40000 ALTER TABLE `historico_consumo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usuario` (
  `id_usuario` int(5) NOT NULL AUTO_INCREMENT,
  `nome` varchar(30) NOT NULL,
  `login` varchar(50) NOT NULL,
  `email` varchar(50) NOT NULL,
  `senha` varchar(50) NOT NULL,
  `tipo_usuario` enum('adm','usr') NOT NULL,
  PRIMARY KEY (`id_usuario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-11-22 10:04:50
