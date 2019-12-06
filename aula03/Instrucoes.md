# Instruções



### Atividade 1



Desenvolver um programa que faz o cadastro de usuários.

Esse programa **deve usar** bando de dados.

Portanto, os dados vão continuar existindo mesmo depois de finalizar o programa.



1. Criar um projeto Java Padrão e dar o nome de `CadastroDeUsuarios`
2. Criar uma nova base de dados no MySQL, usando o MySQL Workbench (ou qualquer outro *software* de preferência):
   1. Criar base de dados com o nome `cadastro_de_usuarios`
   2. Criar uma tabela com o nome `usuarios`, com as seguintes colunas:
      1. `id`: INT, NOT NULL, PRIMARY KEY, AUTO_INCREMENT
      2. `email`: VARCHAR(45), NOT NULL
      3. `senha`: VARCHAR(45), NOT NULL
3. O programa deve ser capaz de
   1. Adicionar um novo usuário: pedir email e senha do novo usuário e adicionar no Banco de dados
   2. Listar todos os usuários cadastrados: mostrar todos os usuários do Banco de Dados.
   3. Procurar um usuário específico através do email: pedir email e procurar usuário no Banco de Dados. Se tiver, mostrar esse usuário na tela; senão, informar que não existe nenhum usuário cadastrado com o email digitado.
   4. Remover um usuário específico através do email: pedir email e remover o usuário no Banco de Dados. Se o usuário realmente existir, remover o usuário do Banco de Dados e mostrar uma mensagem de sucesso na tela; senão, mostrar uma mensagem dizendo que não existe usuário cadastrado com o email informado.
   5. Oferecer uma maneira para o usuário finalizar o programa no momento que quiser.



### Observações

- *Driver* de conexão com o *MySQL*, isto é, o arquivo .jar, está no repositório do *GitHub* dessa aula
- O código de explicação do vídeo de como acessar o *MySQL* com o Java também está no respositório do *GitHub*



---

### Vídeos de referência

1. Parte 1: [https://www.youtube.com/watch?v=7yL_nmFXml8&list=PLh7NspZkGKR_YsFphTcufUi1Mclajc7v7&index=6&t=0s](https://www.youtube.com/watch?v=7yL_nmFXml8&list=PLh7NspZkGKR_YsFphTcufUi1Mclajc7v7&index=6&t=0s)
2. Parte 2: [https://www.youtube.com/watch?v=1K2y5U-0FE8&list=PLh7NspZkGKR_YsFphTcufUi1Mclajc7v7&index=6](https://www.youtube.com/watch?v=1K2y5U-0FE8&list=PLh7NspZkGKR_YsFphTcufUi1Mclajc7v7&index=6)
3. Parte 3: [https://www.youtube.com/watch?v=E3-alzw59gU&list=PLh7NspZkGKR_YsFphTcufUi1Mclajc7v7&index=7](https://www.youtube.com/watch?v=E3-alzw59gU&list=PLh7NspZkGKR_YsFphTcufUi1Mclajc7v7&index=7)
4. Parte 4: [https://youtu.be/zdiiuLBDJPA](https://youtu.be/zdiiuLBDJPA)

