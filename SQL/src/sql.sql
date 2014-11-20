create database employee-manager;
********************

CREATE TABLE project
(
    id INT PRIMARY KEY NOT NULL,
    dtype VARCHAR(31),
    name VARCHAR(255)
);

CREATE TABLE employee
(
    id INT PRIMARY KEY NOT NULL,
    name VARCHAR(255),
    salary BIGINT,
    startdate DATE,
    adressid INT,
    departementid INT,
    FOREIGN KEY (departementid) REFERENCES departement(id),
    FOREIGN KEY (adressid) REFERENCES adress(id)
);


CREATE TABLE work (
id_project INT  NOT NULL,
id_employee INT NOT NULL,
constraint work PRIMARY KEY (id_project,id_employee),
FOREIGN KEY (id_project) REFERENCES project(id),
FOREIGN KEY (id_employee) REFERENCES employee(id));



CREATE TABLE departement
(
    id INT PRIMARY KEY NOT NULL,
    name VARCHAR(255)
);

CREATE TABLE adress
(
    id INT PRIMARY KEY NOT NULL,
    city VARCHAR(255),
    state VARCHAR(255),
    street VARCHAR(255),
    zip VARCHAR(255)
);



CREATE INDEX `index_nom` ON `employee` (`name`);



INSERT INTO adress
  (id, city, state, street,zip )
VALUES
  (1,'Marseille', 'France', 'Bd Baille', '13005'),
  (2, 'Aix-en-provence', 'France', 'Cours Mirabeau', '13100'),
  (3, 'New York', 'NY', '123 Apple Tree', '10001');
  
  
  INSERT INTO departement
  (id,name )
VALUES
   (1,'Qualité'),
   (2,'R&D'),
  (3,'Web');
  
  INSERT INTO project
  (id,dtype, name )
VALUES
  (1,'','TOPPUB'),
  (2,'','Fusion Portail Web'),
  (3,'','Copernic');
  
INSERT INTO employee
  (id, name, salary, startdate, adressid,departementid )
VALUES
  (1,'Jhon', 15000, '01/01/01', 1, 1),
  (2,'Rob', 20000, '12/03/11', 2, 2),
  (3,'Peter', 25000, '05/06/12', 2, 3);
  
  INSERT INTO work
  (id_project, id_employee )
VALUES
  (1,1),
  (1,2),
  (2,2);

  
  ALTER TABLE employee ADD last_name VARCHAR(255);
  SELECT MAX(salary) FROM employee;
  SELECT  name , MIN(salary) FROM employee;
  SELECT AVG(salary) FROM employee;
  SELECT name FROM project LEFT JOIN employee ON employee.id = 1;
  SELECT id_project FROM work WHERE id_employee = 1; 
  SELECT name FROM work WHERE id_employee = 1;
  SELECT p.name FROM project p WHERE p.id = (SELECT w.id_project FROM work w WHERE w.id_employee=1);
  SELECT w.name, w. FROM work e 
  Afficher le nom des employés et des projets associés classés par projet
 select department.name, count(*) as c from employee join department on department.id= department_id group by department_id order by c desc limit 1;
  
  
  
