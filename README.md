🔰 Sistema de Cadastro de Usuários (Spring Boot)
<p align="center">
<img src="https://img.shields.io/badge/Java-17+-blue.svg" alt="Java Version">
<img src="https://img.shields.io/badge/Spring%20Boot-3.x-green.svg" alt="Spring Boot Version">
<img src="https://img.shields.io/badge/API%20REST-Yes-orange.svg" alt="API REST">
</p>

---

📜 Sobre o Projeto  

  Este projeto é um Sistema de Cadastro de Usuários simples, desenvolvido como prática para consolidar conhecimentos em Java e Spring Boot. Ele segue o padrão de Arquitetura em Camadas e utiliza boas práticas como DTOs (Data Transfer Objects) e Validação de Dados.

  O foco principal foi implementar a camada de API RESTful com segurança básica, incluindo a criptografia de senhas através do Spring Security.

---

🧱 Funcionalidades

O sistema oferece uma API completa para o gerenciamento de usuários:

 •  ✅ Cadastro de novos usuários (POST /usuarios).

 •  ✅ Listagem de todos os usuários (GET /usuarios).

 •  ✅ Atualização de dados do usuário por ID (PUT /usuarios/{id}).

 •  ✅ Busca de usuário por e-mail (GET /usuarios/buscar?email={email}).

 •  ✅ Exclusão de usuários por ID ou por e-mail.

 •  🔒 Criptografia de Senha utilizando PasswordEncoder (Spring Security).

 •  🔄 Uso de DTOs e Mappers para desacoplamento de dados.

 •  ⚙️ Validação de Dados rigorosa em todos os campos obrigatórios.

---

💻 Tecnologias Utilizadas

• Linguagem: Java 17+

• Framework: Spring Boot (Web, Data JPA, Security)

• Banco de Dados: H2 Database (em memória, para desenvolvimento)

• Gerenciador de Dependências: Maven

• Extras: Lombok, Jakarta Validation

---

⚙️ Configuração e Execução
Para rodar este projeto localmente, siga os passos abaixo:

Pré-requisitos
• Certifique-se de ter instalado em sua máquina:

• JDK 17 ou superior.

• Maven.

---

📌 Endpoints da API

Método	Caminho	Descrição  

**POST**	/usuarios	Cria um novo usuário.   
**GET**	/usuarios	Retorna a lista de todos os usuários.  
**GET**	/usuarios/buscar?email={email}	Busca um usuário específico por e-mail.  
**PUT**	/usuarios/{id}	Atualiza o usuário com o ID especificado.  
**DELETE**	/usuarios/id/{id}	Deleta um usuário pelo seu ID.  
**DELETE**	/usuarios/email/{email}	Deleta um usuário pelo seu e-mail.  
