CREATE DATABASE proyectowad;
USE proyectowad;

CREATE TABLE Administrador
(
	idUsuarios           INTEGER NOT NULL
);

ALTER TABLE Administrador
ADD CONSTRAINT XPKAdministrador PRIMARY KEY (idUsuarios);

CREATE TABLE Alumno
(
	idUsuarios           INTEGER NOT NULL
);

ALTER TABLE Alumno
ADD CONSTRAINT XPKAlumno PRIMARY KEY (idUsuarios);

CREATE TABLE Alumno_Ejercicio
(
	idUsuarios           INTEGER NOT NULL,
	idEjercicio          INTEGER NOT NULL
);

ALTER TABLE Alumno_Ejercicio
ADD CONSTRAINT XPKAlumno_Ejercicio PRIMARY KEY (idUsuarios,idEjercicio);

CREATE TABLE Alumno_Grupo
(
	idUsuarios           INTEGER NOT NULL,
	idGrupo              INTEGER NOT NULL
);

ALTER TABLE Alumno_Grupo
ADD CONSTRAINT XPKAlumno_Grupo PRIMARY KEY (idUsuarios,idGrupo);

CREATE TABLE Ejercicio
(
	idEjercicio          INTEGER NOT NULL AUTO_INCREMENT,
	idUsuarios           INTEGER NULL,
	CONSTRAINT XPKEjercicio PRIMARY KEY (idEjercicio)
);



CREATE TABLE Grupo
(
	idGrupo              INTEGER NOT NULL AUTO_INCREMENT,
	nombre               VARCHAR(20) NULL,
	contraseña           VARCHAR(20) NULL,
	idUsuarios           INTEGER NULL,
	CONSTRAINT XPKGrupo PRIMARY KEY (idGrupo)
);


CREATE TABLE Grupo_Ejercicio
(
	idGrupo              INTEGER NOT NULL,
	idEjercicio          INTEGER NOT NULL,
	CONSTRAINT XPKGrupo_Ejercicio PRIMARY KEY (idGrupo,idEjercicio)
);


CREATE TABLE Peticion
(
	idPeticion           INTEGER NOT NULL AUTO_INCREMENT,
	idGrupo              INTEGER NULL,
	idUsuarios           INTEGER NULL,
	aceptacion           INTEGER NULL,
	CONSTRAINT XPKPeticion PRIMARY KEY (idPeticion)
);


CREATE TABLE PreEjercicio
(
	idPreEjercicio       INTEGER NOT NULL AUTO_INCREMENT,
	datos                VARCHAR(30) NULL,
	idUsuarios           INTEGER NULL,
	CONSTRAINT XPKPreEjercicio PRIMARY KEY (idPreEjercicio)
);



CREATE TABLE Profesor
(
	idUsuarios           INTEGER NOT NULL
);

ALTER TABLE Profesor
ADD CONSTRAINT XPKProfesor PRIMARY KEY (idUsuarios);

CREATE TABLE Rol
(
	idRol                INTEGER NOT NULL,
	tipo                 VARCHAR(20) NULL
);

ALTER TABLE Rol
ADD CONSTRAINT XPKRol PRIMARY KEY (idRol);

CREATE TABLE Usuarios
(
	idUsuarios           INTEGER NOT NULL AUTO_INCREMENT,
	nombre               VARCHAR(25) NULL,
	apellidoP            VARCHAR(25) NULL,
	apellidoM            VARCHAR(25) NULL,
	correo               VARCHAR(25) NULL,
	contraseña           VARCHAR(15) NULL,
	idRol                INTEGER NULL,
	CONSTRAINT XPKUsuarios PRIMARY KEY (idUsuarios)
);


ALTER TABLE Administrador
ADD CONSTRAINT R_5 FOREIGN KEY (idUsuarios) REFERENCES Usuarios (idUsuarios)
		ON DELETE CASCADE ON UPDATE CASCADE;

ALTER TABLE Alumno
ADD CONSTRAINT R_3 FOREIGN KEY (idUsuarios) REFERENCES Usuarios (idUsuarios)
		ON DELETE CASCADE ON UPDATE CASCADE;

ALTER TABLE Alumno_Ejercicio
ADD CONSTRAINT R_11 FOREIGN KEY (idUsuarios) REFERENCES Alumno (idUsuarios) ON DELETE CASCADE ON UPDATE CASCADE;

ALTER TABLE Alumno_Ejercicio
ADD CONSTRAINT R_12 FOREIGN KEY (idEjercicio) REFERENCES Ejercicio (idEjercicio) ON DELETE CASCADE ON UPDATE CASCADE;

ALTER TABLE Alumno_Grupo
ADD CONSTRAINT R_7 FOREIGN KEY (idUsuarios) REFERENCES Alumno (idUsuarios) ON DELETE CASCADE ON UPDATE CASCADE;

ALTER TABLE Alumno_Grupo
ADD CONSTRAINT R_8 FOREIGN KEY (idGrupo) REFERENCES Grupo (idGrupo) ON DELETE CASCADE ON UPDATE CASCADE;

ALTER TABLE Ejercicio
ADD CONSTRAINT R_9 FOREIGN KEY (idUsuarios) REFERENCES Profesor (idUsuarios) ON DELETE CASCADE ON UPDATE CASCADE;

ALTER TABLE Grupo
ADD CONSTRAINT R_18 FOREIGN KEY (idUsuarios) REFERENCES Profesor (idUsuarios) ON DELETE CASCADE ON UPDATE CASCADE;

ALTER TABLE Grupo_Ejercicio
ADD CONSTRAINT R_14 FOREIGN KEY (idGrupo) REFERENCES Grupo (idGrupo) ON DELETE CASCADE ON UPDATE CASCADE;

ALTER TABLE Grupo_Ejercicio
ADD CONSTRAINT R_15 FOREIGN KEY (idEjercicio) REFERENCES Ejercicio (idEjercicio) ON DELETE CASCADE ON UPDATE CASCADE;

ALTER TABLE Peticion
ADD CONSTRAINT R_16 FOREIGN KEY (idGrupo) REFERENCES Grupo (idGrupo) ON DELETE CASCADE ON UPDATE CASCADE;

ALTER TABLE Peticion
ADD CONSTRAINT R_17 FOREIGN KEY (idUsuarios) REFERENCES Alumno (idUsuarios) ON DELETE CASCADE ON UPDATE CASCADE;

ALTER TABLE PreEjercicio
ADD CONSTRAINT R_19 FOREIGN KEY (idUsuarios) REFERENCES Profesor (idUsuarios) ON DELETE CASCADE ON UPDATE CASCADE;

ALTER TABLE Profesor
ADD CONSTRAINT R_4 FOREIGN KEY (idUsuarios) REFERENCES Usuarios (idUsuarios)
		ON DELETE CASCADE ON UPDATE CASCADE;

ALTER TABLE Usuarios
ADD CONSTRAINT R_2 FOREIGN KEY (idRol) REFERENCES Rol (idRol) ON DELETE CASCADE ON UPDATE CASCADE;








-------Para insertar usuarios administradores
insert into usuarios(nombre,apellidoP,apellidoM,correo,contraseña,idRol) values ('Samantha','Olmos','Carrillo','champi99@gmail.com','aleychampi',1);
-------Para insertar usuarios profesores
insert into usuarios(nombre,apellidoP,apellidoM,correo,contraseña,idRol) values ('Aristides','Ariza','Martinez','arizaxxx@gmail.com','irenemailof',2);
-------Para insertar usuarios alumnos
insert into usuarios(nombre,apellidoP,apellidoM,correo,contraseña,idRol) values ('Irene','Ramirez','Montalvo','irenedeariza@gmail.com','arismailof',3);


insert into profesor(idUsuarios) values (2);
insert into alumno(idUsuarios) values (3);
create view admins as select u.idUsuarios,u.correo,u.contraseña from usuarios u,administrador a where u.idUsuarios = a.idUsuarios;
create view profes as select u.idUsuarios,u.correo,u.contraseña from usuarios u,profesor p where u.idUsuarios = p.idUsuarios;
create view alumnos as select u.idUsuarios,u.correo,u.contraseña from usuarios u,alumno al where u.idUsuarios = al.idUsuarios;

--Para ver por tipo
selct * from profes;
selct * from admins;
selct * from alumnos;

