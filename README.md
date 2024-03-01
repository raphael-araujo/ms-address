# Challenge III - PB Springboot Dez 2023

-------------------------------------------------------------------------------------------------------

O projeto consiste em um microsserviço desenvolvido em Spring Boot para busca e armazenamento de endereços.

-------------------------------------------------------------------------------------------------------

### Tecnologias Utilizadas

<table>
  <tr>
    <td>Java</td>
    <td>Spring</td>
    <td>MySql</td>
  </tr>
  <tr>
    <td>17.*</td>
    <td>3.2</td>
    <td>8.0</td>
  </tr>
</table>

-------------------------------------------------------------------------------------------------------

### Setup

<br>
1 - Clone o repositório

```
git clone https://github.com/raphael-araujo/ms-address.git
```

<br>

2 - Crie e Configure o banco de dados de acordo com o arquivo `application.yml`

<br>

3 - Execute a aplicação

```
mvn spring-boot:run
```

<br>

##### OBS:

-  É necessário que o [msuser](https://github.com/raphael-araujo/ms-user) e
  o [msnotification](https://github.com/raphael-araujo/ms-notification) estejam em execução, junto com o RabbitMQ via
  docker.

-------------------------------------------------------------------------------------------------------