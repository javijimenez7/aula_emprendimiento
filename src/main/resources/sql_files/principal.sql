-- phpMyAdmin SQL Dump
-- version 5.1.3
-- https://www.phpmyadmin.net/
--
-- Servidor: mysql
-- Tiempo de generación: 14-06-2022 a las 16:23:56
-- Versión del servidor: 5.7.28
-- Versión de PHP: 8.0.15

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `aulaEmprendimiento`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `principal`
--

CREATE TABLE `principal` (
  `id` int(11) NOT NULL,
  `descripcion` longtext
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `principal`
--

INSERT INTO `principal` (`id`, `descripcion`) VALUES
(1, '<h1>EMPRENDER ES TU OPORTUNIDAD</h1>\n<p>A principios de 2021, un grupo de docentes del Departamento de FOL y Empresa iniciamos un ilusionante proyecto con un objetivo claro: poner en pr&aacute;ctica acciones encaminadas al desarrollo de la competencia emprendedora y la empleabilidad.</p>\n<p>&nbsp;</p>\n<p>Naci&oacute; as&oacute; nuestra Aula Profesional de Emprendimiento, un nuevo espacio docente creado especificamente ser motor de cambio y formar a nuestro alumnado para los problemas que se van a encontrar cuando salgan del sistema educativo. Para nosotros, lo m&aacute;s importante es ense&ntilde;arles a tener capacidad emprendedora, y no s&oacute;lo para montar una empresa, sino tambi&eacute;n para dirigir su propia vida. Se trata de que tengan sue&ntilde;os y que hagan todo lo que est&eacute;; en sus manos para hacerlos realidad. As&iacute; se produce el cambio.</p>\n<p>&nbsp;</p>\n<p>Queremos que nuestra Aula Profesional de Emprendimiento sirva de puente para acercar la realidad empresarial al alumnado de Formaci&oacute;n Profesional, y nos dirigimos tanto al alumnado que se encuentra cursando dichas ense&ntilde;anzas en el IES Las Fuentezuelas como de los titulados en los &uacute;timos cursos</p>\n<p>&nbsp;</p>\n<p>Puedes consultar la agenda de actividades y si tienes cualquier propuesta o requieres de asesoramiento, no dudes en <strong>contactar con nosotros.</strong></p>');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `principal`
--
ALTER TABLE `principal`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `principal`
--
ALTER TABLE `principal`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
