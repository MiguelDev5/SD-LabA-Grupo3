CREATE TABLE IF NOT EXISTS Departamento (
  IDDpto INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  Nombre VARCHAR(45) NOT NULL,
  Descripcion VARCHAR(200),
  Telefono VARCHAR(15),
  Fax VARCHAR(15)
);	

CREATE TABLE IF NOT EXISTS Ingeniero (
  IDIng INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  Nombres VARCHAR(50) NOT NULL,
  Apellidos VARCHAR(50),
  Especialidad VARCHAR(20),
  Cargo VARCHAR(20)
);

CREATE TABLE IF NOT EXISTS Proyecto (
  IDProy INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  Nombre VARCHAR(45) NOT NULL,
  Descripcion VARCHAR(100) NOT NULL,
  FecInicio DATE NOT NULL,
  FecTermino DATE NOT NULL,
  FEncargado INT NOT NULL,
  FIDDpto INT NOT NULL,
  FOREIGN KEY (FIDDpto) REFERENCES Departamento(IDDpto),
  FOREIGN KEY (FEncargado) REFERENCES Ingeniero(IDIng)
);
  
CREATE TABLE IF NOT EXISTS Asignacion (
  IDAsig INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  FIDProy INT NOT NULL,
  FIDIng INT NOT NULL,
  FOREIGN KEY (FIDProy) REFERENCES Proyecto(IDProy),
  FOREIGN KEY (FIDIng) REFERENCES Ingeniero(IDIng)
);
