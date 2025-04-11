
# JDBC Training Project

Este é um repositório de **treino com JDBC (Java Database Connectivity)**, com o objetivo de praticar conceitos de acesso a banco de dados utilizando Java e MySQL.

## 📦 Entidades do Projeto

O projeto contém duas entidades principais:

- **Department**: representa o departamento de uma empresa.
- **Seller**: representa os vendedores associados a um departamento.

### 🧩 Relacionamento

Cada `Seller` pertence a um `Department`, formando uma **relação muitos-para-um**.

## 🗄️ Estrutura das Tabelas (DDL)

```sql
CREATE TABLE department (
  Id int(11) NOT NULL AUTO_INCREMENT,
  Name varchar(60) DEFAULT NULL,
  PRIMARY KEY (Id)
);

CREATE TABLE seller (
  Id int(11) NOT NULL AUTO_INCREMENT,
  Name varchar(60) NOT NULL,
  Email varchar(100) NOT NULL,
  BirthDate datetime NOT NULL,
  BaseSalary double NOT NULL,
  DepartmentId int(11) NOT NULL,
  PRIMARY KEY (Id),
  FOREIGN KEY (DepartmentId) REFERENCES department (Id)
);
```

## 💾 Dados Iniciais (DML)

```sql
INSERT INTO department (Name) VALUES 
  ('Computers'),
  ('Electronics'),
  ('Fashion'),
  ('Books');

INSERT INTO seller (Name, Email, BirthDate, BaseSalary, DepartmentId) VALUES 
  ('Bob Brown','bob@gmail.com','1998-04-21 00:00:00',1000,1),
  ('Maria Green','maria@gmail.com','1979-12-31 00:00:00',3500,2),
  ('Alex Grey','alex@gmail.com','1988-01-15 00:00:00',2200,1),
  ('Martha Red','martha@gmail.com','1993-11-30 00:00:00',3000,4),
  ('Donald Blue','donald@gmail.com','2000-01-09 00:00:00',4000,3),
  ('Alex Pink','bob@gmail.com','1997-03-04 00:00:00',3000,2);
```

## ⚙️ Funcionalidades Implementadas

- Conexão com banco de dados MySQL usando JDBC
- CRUD completo (Create, Read, Update, Delete) para as entidades `Seller` e `Department`
- Tratamento de exceções personalizadas com `DbException`
- Utilização de DAO pattern para organização do código

## 📚 Objetivo

Este projeto é voltado para aprendizado e fixação dos conceitos de JDBC puro, além da prática de design patterns como DAO e separação de responsabilidades na camada de persistência.

---

💡 *Feito para fins educacionais. Sinta-se livre para clonar, testar e modificar como quiser.*


