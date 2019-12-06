# Aula 10



Links para os vídeos

- `WEB-INF` + `web.xml` + controle básico de acesso + páginas de erro padronizadas: [https://youtu.be/ls0chjLbgGg](https://youtu.be/ls0chjLbgGg)



### Atividade



#### Parte 1

Fazer as alterações necessárias para controlar o acesso às páginas.

Isto é, **não deixar** o usuário acessar diretamente as páginas que **não devem** ser acessadas diretamente: tais como a página que indica sucesso no cadastro e a `home`.

A página que indica sucesso no cadastro deve ser acessada somente após um cadastro ter sido efetivamente feito com sucesso.

A lógica é a mesma para a `home`: só deve ser acessada após o usuário ter efetivamente feito o login.



#### Parte 2

Adicionar páginas de erro padronizadas e apresentá-las quando algum erro acontecer, ao invés de usar as páginas do `tomcat`.

As páginas do `tomcat` são muito técnicas e **não devem** ser apresentadas para os usuários, por motivos tanto de segurança quanto de estética e usabilidade.

As páginas técnicas do `tomcat` disponibilizam informações muito detalhadas que podem abrir vulnerabilidades no sistema.

Além disso, os usuários podem ter uma péssima experiência com uma aplicação web ao se depararem com essas páginas técnicas.