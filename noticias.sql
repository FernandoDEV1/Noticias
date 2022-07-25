
SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `castores`
--
DROP DATABASE IF EXISTS noticiasjava;
CREATE DATABASE noticiasjava;
CREATE USER 'noticiasjava'@'localhost' identified by 'noticiasjava';
GRANT ALL PRIVILEGES ON noticiasjava.* TO 'noticiasjava'@'localhost';
-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `comentario`
--

CREATE TABLE `comentario` (
  `idcomentario` bigint(20) NOT NULL,
  `fechapublicacion` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `texto` varchar(255) COLLATE utf8_spanish2_ci DEFAULT NULL,
  `idnoticia` bigint(20) DEFAULT NULL,
  `idusuario` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci;

--
-- Volcado de datos para la tabla `comentario`
--

INSERT INTO `comentario` (`idcomentario`, `fechapublicacion`, `texto`, `idnoticia`, `idusuario`) VALUES
(1, '2022-07-24 15:05:40', 'Comentario de juan\r\n', 1, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `noticia`
--

CREATE TABLE `noticia` (
  `idnoticia` bigint(20) NOT NULL,
  `cuerpo` text COLLATE utf8_spanish2_ci,
  `desccorta` varchar(255) COLLATE utf8_spanish2_ci DEFAULT NULL,
  `encabezado` varchar(255) COLLATE utf8_spanish2_ci DEFAULT NULL,
  `fechapublicacion` date DEFAULT NULL,
  `idusuario` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci;

--
-- Volcado de datos para la tabla `noticia`
--

INSERT INTO `noticia` (`idnoticia`, `cuerpo`, `desccorta`, `encabezado`, `fechapublicacion`, `idusuario`) VALUES
(1, 'El presidente turco Recep Tayyip Erdogan aseguró este viernes que Turquía no es favorable a una adhesión de Finlandia y Suecia a la OTAN, acusando a los países escandinavos de dar refugio a militantes kurdos.\r\n\"No tenemos una opinión positiva. Los países escandinavos son como una casa de huéspedes para organizaciones terroristas\", dijo a la prensa Erdogan, citando al Partido de los Trabajadores del Kurdistán (PKK), considerado un grupo \"terrorista\" por Turquía, la Unión Europea y Estados Unidos.\r\nEl jefe de Estado aseguró que no quiere \"que se repita el mismo error que se cometió con la adhesión de Grecia\".\r\n\"Seguimos actualmente la evolución de Suecia y Finlandia, pero no tenemos una opinión positiva, porque cometieron un error en la OTAN con respecto a Grecia antes, contra Turquía\", declaró el jefe de Estado.', 'El presidente turco Recep Tayyip Erdogan aseguró que Turquía no es favorable a una adhesión de Finlandia y Suecia a la OTAN, acusando a esos países de dar refugio a militantes kurdos.', 'Turquía se opone a la adhesión de Suecia y Finlandia a la OTAN', '2022-07-24', 2),
(2, 'Mauricio Val estudió Artes Plásticas en la UNAM y se graduó con Mención Honorífica, le gustaba pintar e incluso realizó exposiciones en algunos museos en el interior de México, le apasionaba el arte, la cultura y los viajes.\r\nMauricio contaba con un nivel de alta sensibilidad como artista, de carácter explosivo y las emociones a flor de piel, sin embargo, su paso por el mundo de las drogas modificó su trayectoria, lo lanzó a situaciones complicadas en su vida. \r\nUna de las pérdidas que le afectaron fue su divorcio y con ello, la separación de sus hijos, y la otra gran pérdida, fue la audición, ambas afectando su autoestima, su seguridad, lo que se diagnosticó como un Trastorno Mixto que incluye Ansiedad y Depresión, dos enfermedades mentales que no fueron bien atendidas a lo largo de su historia, por parte del sector salud. ', 'El sector necesita reforzar protocolos en materia de salud mental y aumentar el presupuesto para aminorar el problema.', 'Enfermedades mentales, la pandemia en puerta', '2022-07-24', 2),
(3, 'México y Reino Unido iniciarán negociaciones esta semana en Londres para pactar un Tratado de Libre Comercio (TLC) entre ambos países, informó la Secretaría de Economía de México.\r\nEn diciembre de 2020, las dos naciones acordaron mantener a partir del 1 de enero de 2021 las preferencias arancelarias con las que se han beneficiado en el marco del Tratado de Libre Comercio entre la Unión Europea y México (TLCUEM).\r\nA partir del 1 de enero de 2021, como consecuencia del Brexit, Reino Unido perdió los beneficios de los acuerdos comerciales globales negociados por la Unión Europea en nombre de sus miembros.\r\nEn Londres, iniciarán formalmente las negociaciones para un nuevo TLC con el Reino Unido, y la secretaria de Economía de México, Tatiana Clouthier se reunirá con el sector privado, con el objetivo de fortalecer la inversión británica en México, así como los lazos comerciales.\r\nEn 2021, en su comercio de mercancías con Reino Unido, México registró exportaciones de 2,992 millones de dólares, un crecimiento de 14% interanual, e importaciones de 2,005 millones de dólares, un avance de 15 por ciento.', 'México y Reino Unido iniciarán negociaciones esta semana en Londres para pactar un Tratado de Libre Comercio (TLC) entre ambos países.', 'México iniciará negociaciones para un TLC con Reino Unido', '2022-07-24', 2),
(4, 'Eugenio López Rodea, fundador de la empresa mexicana Jumex, falleció este viernes a los 87 años, confirmó Grupo Jumex a través de un comunicado.\r\n“Grupo Jumex informa con gran tristeza la irreparable pérdida de su fundador Don Eugenio López Rodea, quien falleció el día de hoy en la Ciudad de México a los 87 años de edad”, señala el documento.\r\nEugenio López Rodea creó Jumex en 1961. “Con notable disciplina, Don Eugenio consolidó Grupo Jumex como la procesadora de jugos y néctares más importante, no solo de México, sino también de Estados Unidos”, destaca el comunicado.\r\n“De parte de toda la familia de Grupo Jumex hacemos extensivas nuestras más sensibles condolencias a su hijo Eugenio López Alonso, a toda su familia y amigos, por tan irreparable pérdida”, concluye.', 'Eugenio López Rodea fundó Jumex, la procesadora de jugos y néctares más importante de México y de Estados Unidos. en 1961.', 'Fallece Eugenio López Rodea, fundador de Jumex, a los 87 años', '2022-07-24', 2),
(5, 'Hablamos de Ceuta y Melilla, dos ciudades que pertenecen a España desde hace más de 500 años, pero que Marruecos ha estado reivindicando como suyas prácticamente desde que consiguió su independencia en 1956.\r\n\r\nLa ley internacional no las considera colonias y la Organización de Naciones Unidas (ONU) respalda que son provincias españolas.\r\n\r\nEste 17 de mayo, tras más de dos años de fronteras cerradas a causa del coronavirus, Marruecos reabrió sus pasos terrestres a Ceuta y Melilla. Es el último episodio de la nueva fase de concordia que experimentan ambos países luego de varios años turbulentos.', 'Son los únicos territorios de la Unión Europea en el África continental y sus fronteras han sido foco de crisis migratorias y disputas diplomáticas.', 'Por qué Ceuta y Melilla pertenecen a España si están en África', '2022-07-24', 2),
(6, 'Cuerpo de la noticia', 'Descripción de noticia numero 1', 'Noticia numero 1', '2022-07-24', 2);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `personal`
--

CREATE TABLE `personal` (
  `idpersonal` bigint(20) NOT NULL,
  `apematerno` varchar(255) COLLATE utf8_spanish2_ci DEFAULT NULL,
  `apepaterno` varchar(255) COLLATE utf8_spanish2_ci DEFAULT NULL,
  `direccion` varchar(255) COLLATE utf8_spanish2_ci DEFAULT NULL,
  `fechaingreso` date DEFAULT NULL,
  `nombre` varchar(255) COLLATE utf8_spanish2_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci;

--
-- Volcado de datos para la tabla `personal`
--

INSERT INTO `personal` (`idpersonal`, `apematerno`, `apepaterno`, `direccion`, `fechaingreso`, `nombre`) VALUES
(1, 'Barragan', 'Alcaraz', 'Ciudad X Calle Y', '2022-07-24', 'Jorge'),
(2, 'Alvarez', 'Esparza', 'Ciudad D Calle O', '2022-07-24', 'Jose');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `respuesta`
--

CREATE TABLE `respuesta` (
  `idrespuesta` bigint(20) NOT NULL,
  `fechapublicacion` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `texto` varchar(255) COLLATE utf8_spanish2_ci DEFAULT NULL,
  `idcomentario` bigint(20) DEFAULT NULL,
  `idusuario` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci;

--
-- Volcado de datos para la tabla `respuesta`
--

INSERT INTO `respuesta` (`idrespuesta`, `fechapublicacion`, `texto`, `idcomentario`, `idusuario`) VALUES
(1, '2022-07-24 15:05:55', 'Respuesta de jorge\r\n', 1, 2);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `rol`
--

CREATE TABLE `rol` (
  `idrol` bigint(20) NOT NULL,
  `nombrerol` varchar(255) COLLATE utf8_spanish2_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci;

--
-- Volcado de datos para la tabla `rol`
--

INSERT INTO `rol` (`idrol`, `nombrerol`) VALUES
(1, 'ROL_INTERNO'),
(2, 'ROL_EXTERNO');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE `usuario` (
  `idusuario` bigint(20) NOT NULL,
  `apematerno` varchar(255) COLLATE utf8_spanish2_ci DEFAULT NULL,
  `apepaterno` varchar(255) COLLATE utf8_spanish2_ci DEFAULT NULL,
  `contrasena` varchar(255) COLLATE utf8_spanish2_ci DEFAULT NULL,
  `nomusuario` varchar(255) COLLATE utf8_spanish2_ci DEFAULT NULL,
  `nombre` varchar(255) COLLATE utf8_spanish2_ci DEFAULT NULL,
  `idpersonal` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci;

--
-- Volcado de datos para la tabla `usuario`
--

INSERT INTO `usuario` (`idusuario`, `apematerno`, `apepaterno`, `contrasena`, `nomusuario`, `nombre`, `idpersonal`) VALUES
(1, 'Hernandez', 'Perez', '$2a$10$LiwmgB20xJ3dH4PVloJ1WefegWdwyu7bqO6JEv2ygReJpXRO9VK.a', 'juan', 'Juan', NULL),
(2, 'Barragan', 'Alcaraz', '$2a$10$BU6ohwUXGcXFCHp4iQAjTerO8xBjEKNOuXiwif2ACm4Fw.caonSzi', 'jorge', 'Jorge', 1),
(3, 'Alvarez', 'Esparza', '$2a$10$BU6ohwUXGcXFCHp4iQAjTerO8xBjEKNOuXiwif2ACm4Fw.caonSzi', 'jose', 'Jose', 2);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario_rol`
--

CREATE TABLE `usuario_rol` (
  `idusuario` bigint(20) NOT NULL,
  `idrol` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci;

--
-- Volcado de datos para la tabla `usuario_rol`
--

INSERT INTO `usuario_rol` (`idusuario`, `idrol`) VALUES
(1, 2),
(2, 1),
(3, 1);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `comentario`
--
ALTER TABLE `comentario`
  ADD PRIMARY KEY (`idcomentario`),
  ADD KEY `FK6vvl60rgoh1oanjrx93530el` (`idnoticia`),
  ADD KEY `FKpqns3xhkrjc11ucdamp4hymdo` (`idusuario`);

--
-- Indices de la tabla `noticia`
--
ALTER TABLE `noticia`
  ADD PRIMARY KEY (`idnoticia`),
  ADD KEY `FKh4jsycumu0n5ljmj4vfilufbt` (`idusuario`);

--
-- Indices de la tabla `personal`
--
ALTER TABLE `personal`
  ADD PRIMARY KEY (`idpersonal`);

--
-- Indices de la tabla `respuesta`
--
ALTER TABLE `respuesta`
  ADD PRIMARY KEY (`idrespuesta`),
  ADD KEY `FK9vw0adxy51l373k4q34ww607c` (`idcomentario`),
  ADD KEY `FKiewssyt03vieiendku4f3o2v0` (`idusuario`);

--
-- Indices de la tabla `rol`
--
ALTER TABLE `rol`
  ADD PRIMARY KEY (`idrol`);

--
-- Indices de la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`idusuario`),
  ADD UNIQUE KEY `UKg0frwk9hypk9l7rl3hafgvx6l` (`nomusuario`),
  ADD KEY `FKbsfrpt9bv1bwh8wtdvixlu0db` (`idpersonal`);

--
-- Indices de la tabla `usuario_rol`
--
ALTER TABLE `usuario_rol`
  ADD KEY `fk_rol_usuario` (`idrol`),
  ADD KEY `fk_usuario_rol` (`idusuario`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `comentario`
--
ALTER TABLE `comentario`
  MODIFY `idcomentario` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `noticia`
--
ALTER TABLE `noticia`
  MODIFY `idnoticia` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT de la tabla `personal`
--
ALTER TABLE `personal`
  MODIFY `idpersonal` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `respuesta`
--
ALTER TABLE `respuesta`
  MODIFY `idrespuesta` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `rol`
--
ALTER TABLE `rol`
  MODIFY `idrol` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `usuario`
--
ALTER TABLE `usuario`
  MODIFY `idusuario` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `comentario`
--
ALTER TABLE `comentario`
  ADD CONSTRAINT `FK6vvl60rgoh1oanjrx93530el` FOREIGN KEY (`idnoticia`) REFERENCES `noticia` (`idnoticia`),
  ADD CONSTRAINT `FKpqns3xhkrjc11ucdamp4hymdo` FOREIGN KEY (`idusuario`) REFERENCES `usuario` (`idusuario`);

--
-- Filtros para la tabla `noticia`
--
ALTER TABLE `noticia`
  ADD CONSTRAINT `FKh4jsycumu0n5ljmj4vfilufbt` FOREIGN KEY (`idusuario`) REFERENCES `usuario` (`idusuario`);

--
-- Filtros para la tabla `respuesta`
--
ALTER TABLE `respuesta`
  ADD CONSTRAINT `FK9vw0adxy51l373k4q34ww607c` FOREIGN KEY (`idcomentario`) REFERENCES `comentario` (`idcomentario`),
  ADD CONSTRAINT `FKiewssyt03vieiendku4f3o2v0` FOREIGN KEY (`idusuario`) REFERENCES `usuario` (`idusuario`);

--
-- Filtros para la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD CONSTRAINT `FKbsfrpt9bv1bwh8wtdvixlu0db` FOREIGN KEY (`idpersonal`) REFERENCES `personal` (`idpersonal`);

--
-- Filtros para la tabla `usuario_rol`
--
ALTER TABLE `usuario_rol`
  ADD CONSTRAINT `fk_rol_usuario` FOREIGN KEY (`idrol`) REFERENCES `rol` (`idrol`),
  ADD CONSTRAINT `fk_usuario_rol` FOREIGN KEY (`idusuario`) REFERENCES `usuario` (`idusuario`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
