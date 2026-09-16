# CRUD Pessoas utilizando Java com Maven


- Verificar POM.xml para as dependências


Projeto simplificado, baseado no padrão DAO.  
Baseado também em 3 camadas.  
Aplicado com separação de Pacotes.  

- Pacote apresentação - Front end - Formulários, apenas entrada e saída de dados  
- Pacote Modelo - Regras de negócio. Classe Pessoa é a DTO  
- Pacote DAL - Data Access Library - Onde ficam todos os objetos DAL e classe de conexão  

---

## Etapas

### 1 - Criar projeto

### 2 - Criar estrutura de camadas - Pacotes

### 3 - Criar o banco de dados no servidor (script abaixo)

### 4 - Criar classe DTO (Pessoa)

### 5 - Criar PessoaDAO no pacote DAL

### 6 - Criar demais classes conforme Diagrama de classes

- DAL - PessoaDAO, Conexao
- Modelo - Controle, Validacao e a DTO Pessoa
- Apresentacao - Os formulários

### 7 - Implementar métodos nas classes
- Primeiro na DAL - Conexão e PessoaDAO - Testar em código temporário na main.
- Demais classes seguindo top-down

## Script BD
```
create database alpoo
go
use alpoo  
go  

create table pessoas  
(  
    id int identity(1,1) primary key,  
    nome varchar(30) not null,  
    rg varchar(10),  
    cpf varchar(13),  
)  
go
```



