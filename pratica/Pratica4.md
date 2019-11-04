# Prática 4



Conteúdos que serão praticados:

- Criação de Classe
- **Definição** de métodos de Classe
- **Declaração** de variáveis de Classe
- **Instanciação** de objetos
- **Chamada** de métodos de Classe através de objetos instanciados
- **Atribuição** de valores para as variáveis de Classe
- **Acesso** aos valores das variáveis de Classe
- Entrada de dados com `Scanner`
- Saída de dados com `System.out.print`



### Atividade 1

1. Crie um projeto Java Padrão e dê o nome de `Atividade1`
2. Crie uma classe e dê o nome de `Usuario`
3. Declare as seguintes **variáveis de classe** para `Usuario`:
   1. `email`: tipo `String` 
   2. `nome`: tipo `String`
4. Na `main`, peça para o usuário digitar o email e o nome e armazene os valores nas variáveis da classe `Usuario`
5. Na `main`, mostre na tela os valores de email e nome que o usuário digitou **usando as variáveis da classe** `Usuario`

OBSERVAÇÕES:

- **NÃO USE** variáveis locais
- Use apenas variáves de classe
- `Scanner` e  `System.out.print` devem ser usados na `main`



---



### Atividade 2



1. Crie um projeto Java Padrão e dê o nome de `Atividade2`
2. Crie uma Classe e dê o nome de `Usuario`
3. Declare as seguintes **variáveis de classe** (**NÃO** `static`) para `Usuario`:
   1. `email`: tipo `String` e acesso `private`
   2. `nome`: tipo `String` e acesso `private` 
4. Defina os seguintes métodos (**NÃO** `static`) na classe `Usuario`:
   1. `pedirEmail`: sem parâmetros e retorno `void`; esse método irá pedir para o usuário digitar o email e armazenará o valor digitado na variável de classe `email`  (`Scanner` deve ser usado nesse método)
   2. `pedirNome`: sem parâmetros e retorno `void`; esse método irá pedir para o usuário digitar o nome e armazenará o valor digitado na variável de classe `nome` (`Scanner` deve ser usado nesse método)
   3. `mostrarEmail`: sem parâmetros e retorno `void`; esse método apresentará na tela o valor da variável de classe `email` (`System.out.print` deve ser usado nesse método)
   4. `mostrarNome`: sem parâmetros e retorno `void`; esse método apresentará na tela o valor da variável de classe `nome` (`System.out.print` deve ser usado nesse método)
5. Na `main`, instancie um objeto da classe `Usuario` e chame os métodos `pedirEmail` e `pedirNome`
6. Depois, na `main`, chame os métodos `mostrarEmail` e `mostrarNome` 

OBSERVAÇÕES:

- `Scanner` deve ser usado apenas nos métodos da classe `Usuario` 
- **NÃO USE** `Scanner` na `main` 
- `System.out.print` deve ser usado apenas nos métodos da classe `Usuario` 
- **NÃO USE** `System.out.print` na `main` 
- **NÃO USE** variáveis locais; use apenas variáves de classe



---



### Atividade 3



1. Crie um projeto Java Padrão e dê o nome de `Atividade3`
2. Crie uma classe e dê o nome de `Usuario` 
3. Declare as seguintes variáves de classe (**NÃO** `static`) para `Usuario`:
   1. `email`: tipo `String` e acesso `private` 
   2. `nome`: tipo `String` e acesso `private` 
4. Defina os seguintes métodos (**NÃO** `static`) na classe `Usuario`:
   1. `atribuirEmail`: um parâmetro `String` e retorno `void`; esse método recebe um valor `String` como parâmetro e atribui esse valor na variável de classe `email`
   2. `atribuirNome`: um parâmetro `String` e retorno `void`; esse método recebe um valor `String` como parâmetro e atribui esse valor na variável de classe `nome`
   3. `mostrarEmail`: sem parâmetros e retorno `void`; esse método apenas mostra na tela o valor da variável de classe `email`
   4. `mostrarNome`: sem parâmetros e retorno `void`; esse método apenas mostra na tela o valor da variável de classe `nome`
5. Na `main`, peça para o usuário digitar **o email e o nome** e armazene em variáveis locais (ou seja, declaradas na `main`)
6. Na `main`, instancie um objeto da classe `Usuario`
7. Chame o método `atribuirEmail`, passando como parâmetro o valor inserido para email
8. Chame o método `atribuirNome`, passando como parâmetro o valor inserido para nome
9. Chame os métodos `mostrarEmail` e `mostrarNome` para apresentar os valores na tela

OBSERVAÇÕES:

- `Scanner` deve ser usado na `main` 
- **NÃO USE** `Scanner` nos métodos da classe `Usuario`
- `System.out.print` deve ser usado nos métodos `mostrarEmail`  e `mostrarNome` da classe `Usuario` 
- **NÃO USE** `System.out.print` na `main` 
- Os valores digitados pelo usuário para email e nome devem ser atribuídos nas variáveis de classe **usando os métodos `atribuirEmail` e `atribuirNome`**
- **NÃO ATRIBUA** os valores digitados pelo usuário diretamente às variáveis de classe (pois elas têm acesso `private`)



---



### Atividade 4



1. Crie um projeto Java Padrão e dê o nome de `Atividade4`
2. Crie uma classe e dê o nome de `Usuario` 
3. Declare as seguintes variáves de classe (**NÃO** `static`) para `Usuario`:
   1. `email`: tipo `String` e acesso `private` 
   2. `nome`: tipo `String` e acesso `private` 
4. Defina os seguintes métodos (**NÃO** `static`) na classe `Usuario`:
   1. `atribuirEmail`: um parâmetro `String` e retorno `void`; esse método recebe um valor `String` como parâmetro e atribui esse valor na variável de classe `email`
   2. `atribuirNome`: um parâmetro `String` e retorno `void`; esse método recebe um valor `String` como parâmetro e atribui esse valor na variável de classe `nome`
   3. `pegarEmail`: sem parâmetros e retorno `String`; esse método apenas retorna o valor da variável de classe `email`
   4. `pegarNome`: sem parâmetros e retorno `String`; esse método apenas retorna o valor da variável de classe `nome`
5. Na `main`, peça para o usuário digitar **o email e o nome** e armazene em variáveis locais (ou seja, declaradas na `main`)
6. Na `main`, instancie um objeto da classe `Usuario`
7. Chame o método `atribuirEmail`, passando como parâmetro o valor inserido para email
8. Chame o método `atribuirNome`, passando como parâmetro o valor inserido para nome
9. Chame os métodos `pegarEmail` e `pegarNome` para apresentar os valores na tela, usando `System.out.print` 

OBSERVAÇÕES:

- `Scanner` deve ser usado na `main` 
- **NÃO USE** `Scanner` nos métodos da classe `Usuario`
- `System.out.print` deve ser usado na `main`
- **NÃO USE** `System.out.print` nos métodos da classe `Usuario` 
- Os valores digitados pelo usuário para email e nome devem ser atribuídos nas variáveis de classe **usando os métodos `atribuirEmail` e `atribuirNome`**
- **NÃO ATRIBUA** os valores digitados pelo usuário diretamente às variáveis de classe (pois elas têm acesso `private`)
- Os valores das variáveis de classe devem ser acessados **usando os métodos `pegarEmail` e `pegarNome`**
- **NÃO ACESSE** os valores das variáves de classe diretamente (pois elas têm acesso `private`)