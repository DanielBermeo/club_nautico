SET NAMES 'latin1';
DROP DATABASE IF EXISTS club_nautico;
CREATE DATABASE IF NOT EXISTS club_nautico DEFAULT CHARACTER SET utf8;

USE club_nautico;

CREATE TABLE amarres(
    num_amarres         INTEGER NOT NULL,
    fecha_registro      DATE NOT NULL DEFAULT NOW(), 
    cuota               DECIMAL(10,2) NOT NULL,
    disponibilidad      BOOLEAN DEFAULT TRUE,
    
    PRIMARY KEY(num_amarres,fecha_registro)
)DEFAULT CHARACTER SET utf8;


CREATE TABLE contactos(
    id_cto              INTEGER NOT NULL AUTO_INCREMENT,
    nombre              VARCHAR(30) NOT NULL,
    ap_paterno          VARCHAR(30) NOT NULL,
    ap_materno          VARCHAR(30) ,
    telefono            VARCHAR(40) NOT NULL,
    email               VARCHAR(30) NOT NULL,
    CONSTRAINT email_invalido CHECK (email LIKE '%_@__%.__%'),
	CONSTRAINT telefono_invalido CHECK (telefono REGEXP '^[0-9]+$'),
	CONSTRAINT no_rep_email UNIQUE (email),
CONSTRAINT no_rep_telefono UNIQUE (telefono),
    PRIMARY KEY (id_cto)
)DEFAULT CHARACTER SET utf8;


CREATE TABLE socios(
    id_sco              INTEGER NOT NULL AUTO_INCREMENT,
    id_cto              INTEGER NOT NULL, 
    
    PRIMARY KEY (id_sco),
    FOREIGN KEY (id_cto) REFERENCES contactos(id_cto)
)DEFAULT CHARACTER SET utf8;

CREATE TABLE patrones(
    id_ptn              INTEGER NOT NULL AUTO_INCREMENT,
    id_sco              INTEGER,
    id_cto              INTEGER NOT NULL,
    
    PRIMARY KEY (id_ptn),
    FOREIGN KEY (id_sco) REFERENCES socios(id_sco),
    FOREIGN KEY (id_cto) REFERENCES contactos(id_cto)
)DEFAULT CHARACTER SET utf8;

CREATE TABLE duenos(
    id_dno              INTEGER NOT NULL AUTO_INCREMENT,
    id_cto              INTEGER NOT NULL,
    
    PRIMARY KEY (id_dno),
    FOREIGN KEY (id_cto) REFERENCES contactos(id_cto)
)DEFAULT CHARACTER SET utf8;

CREATE TABLE barcos( 
    num_matricula       VARCHAR(50) NOT NULL,
    nombre              VARCHAR(30) NOT NULL,
    id_ptn              INTEGER NOT NULL,
    id_dno              INTEGER NOT NULL,
    
    PRIMARY KEY(num_matricula),
    FOREIGN KEY (id_ptn) REFERENCES patrones(id_ptn),
    FOREIGN KEY (id_dno) REFERENCES duenos(id_dno)
)DEFAULT CHARACTER SET utf8;

CREATE TABLE salidas(
    id_sla              INTEGER NOT NULL AUTO_INCREMENT,
    fecha_salida        DATE NOT NULL,
    destino             VARCHAR(30),
    num_mta             VARCHAR(50) NOT NULL,
    
    PRIMARY KEY (id_sla),
    FOREIGN KEY (num_mta) REFERENCES barcos(num_matricula)
)DEFAULT CHARACTER SET utf8;

CREATE TABLE entradas(
    id_eta              INTEGER NOT NULL AUTO_INCREMENT,
    fecha_llegada       DATE NOT NULL, 
    num_ams             INTEGER NOT NULL,
    num_mta             VARCHAR(50) NOT NULL,
    
    PRIMARY KEY(id_eta),
    FOREIGN KEY (num_ams) REFERENCES amarres(num_amarres),
    FOREIGN KEY (num_mta) REFERENCES barcos(num_matricula)
)DEFAULT CHARACTER SET utf8;