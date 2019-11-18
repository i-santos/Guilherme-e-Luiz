# Aula 05 - Servlet - Instruções

A atividade de hoje é transformar o programa cliente que fizemos usando o Java padrão e uma aplicação web usando o Java Web.

Toda a lógica já foi feita.

É preciso apenas conhecer como funciona *Servlets* e o Java Web para conseguirmos transformar a aplicação em um *web app*.



---

### Importante:

Vamos fazer o mesmo passo-a-passo, para não pular etapas nessa etapa de aprendizado do Java Web.

Existem **muitos detalhes** que precisam ser vistos com calma para não darmos o passo maior que a perna.

Por enquanto vamos apenas fazer o uma **simulação de cadastro e login** de usuários.

---



### Atividade

1. Crie um projeto Java Web e dê o nome de `CadastroDeUsuariosWeb`
2. Crie duas páginas HTML e dê o nome de `cadastro.html` e `login.html` 
3. Crie um pacote Java e dê o nome de `servlet`: é nesse pacote onde ficarão todas as nossas classes que farão o papel de `Servlet`
   1. Crie duas `Servlet` dentro desse pacote e dê o nome de `CadastroServlet` e `LoginServlet`
4. Crie um pacote Java e dê o nome de `model`: é nesse pacote onde ficarão todas as nossas classes para modelar o mundo real dentro do nosso sistema
   1. Crie uma classe Java e dê o nome de `Usuario`, com os mesmos atributos e métodos que estávamos utilizando antes
5. Configure a página `cadastro.html` para enviar os dados de *e-mail* e senha para a `CadastroServlet`
6. Configure a página de `login.html` para enviar os dados de *e-mail* e senha para a `LoginServlet`
7. Na `CadastroServlet`, receba os dados de *e-mail* e senha e faça o seguinte processo de validação:
   1. *E-mail*: precisa necessariamente ter um '@' (essa validação deve ser feita na `Servlet`; fazer apenas no HTML **não é suficiente**)
   2. Senha: precisa ter entre 6 e 15 caracteres
8. Se os dados forem válidos e se não existir nenhum usuário já cadastrado com o *e-mail* informado, adicione o novo usuário à lista de usuários cadastrados e depois informe uma mensagem de sucesso ao usuário
   Caso já exista algum usuário cadastro com o *e-mail* informado, ou se *e-mail*/senha não forem válidos, informe o erro ao usuário.
9. Na `LoginServlet`, receba *e-mail* e senha e verifique se os dados informados conferem com os dados de algum usuário já cadastrado.
   Se conferirem, informe uma mensagem dizendo que o login foi feito com sucesso;
   Caso contrário, informe uma mensagem erro.



---

### Vídeos de referência

- Parte 1 (Comparando a interface da aplicação cliente com a interface da aplicação web): [https://youtu.be/UWUBgjZF-s8](https://youtu.be/UWUBgjZF-s8)
- Parte 2 (Explicação básica dos Servlets para retomarmos o  estudo do Java Web): 

[https://youtu.be/-IKJ-pwdIBo](https://youtu.be/-IKJ-pwdIBo)

