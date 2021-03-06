CREATE TABLE IF NOT EXISTS skils (
  id INT NOT NULL AUTO_INCREMENT UNIQUE,
  name VARCHAR(45) NOT NULL,
  level VARCHAR(45) NOT NULL,
  PRIMARY KEY (id)
);
  
CREATE TABLE IF NOT EXISTS projects (
  id INT NOT NULL AUTO_INCREMENT UNIQUE,
  name VARCHAR(45) NOT NULL,
  PRIMARY KEY (id)
);
  
CREATE TABLE IF NOT EXISTS developers (
  id INT NOT NULL AUTO_INCREMENT UNIQUE,
  username VARCHAR(45) NOT NULL UNIQUE,
  name VARCHAR(45) NOT NULL,
  surname VARCHAR(45) NOT NULL,
  age INT NOT NULL,
  gender CHAR(1) NOT NULL,
  salary INT NOT NULL,
  PRIMARY KEY (id)
);
  
CREATE TABLE IF NOT EXISTS customers (
  id INT NOT NULL AUTO_INCREMENT UNIQUE,
  name VARCHAR(128) NOT NULL,
  safer VARCHAR(128) NOT NULL,
  PRIMARY KEY (id)
);
  
CREATE TABLE IF NOT EXISTS companies (
  id INT NOT NULL AUTO_INCREMENT UNIQUE,
  name VARCHAR(128) NOT NULL,
  safer VARCHAR(128) NOT NULL,
  PRIMARY KEY (id)
);
  
CREATE TABLE IF NOT EXISTS developers_projects (
  developers_id INT NOT NULL,
  projects_id INT NOT NULL,
  FOREIGN KEY (developers_id) REFERENCES developers (id)
  ON DELETE CASCADE
  ON UPDATE CASCADE,
  FOREIGN KEY (projects_id) REFERENCES projects (id)
  ON DELETE CASCADE
  ON UPDATE CASCADE
);
  
CREATE TABLE IF NOT EXISTS customers_projects (
  projects_id INT NOT NULL,
  customers_id INT NOT NULL,
  FOREIGN KEY (projects_id) REFERENCES projects (id)
  ON DELETE CASCADE
  ON UPDATE CASCADE,
  FOREIGN KEY (customers_id) REFERENCES customers (id)
  ON DELETE CASCADE
  ON UPDATE CASCADE
 );
  
CREATE TABLE IF NOT EXISTS companies_projects (
  projects_id INT NOT NULL,
  companies_id INT NOT NULL,
  FOREIGN KEY (projects_id) REFERENCES projects (id)
  ON DELETE CASCADE
  ON UPDATE CASCADE,
  FOREIGN KEY (companies_id) REFERENCES companies (id)
  ON DELETE CASCADE
  ON UPDATE CASCADE
);
  
CREATE TABLE IF NOT EXISTS developers_skils (
  developers_id INT NOT NULL,
  skils_id INT NOT NULL,
  FOREIGN KEY (developers_id) REFERENCES developers (id)
  ON DELETE CASCADE
  ON UPDATE CASCADE,
  FOREIGN KEY (skils_id) REFERENCES skils (id)
  ON DELETE CASCADE
  ON UPDATE CASCADE
);