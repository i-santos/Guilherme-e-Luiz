# Prática 5



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
2. Crie uma classe e dê o nome de `Calculadora`
3. Declare as seguintes **variáveis de classe** para `Calculadora`:
   1. `x`: tipo `float` 
   2. `y`: tipo `float`
4. Defina os seguintes **métodos de classe** para `Calculadora`:
   1. `soma`: sem parâmetros e retorno `void`; apresentar na tela o resultado da soma dos valores das variáves de classe `x` e `y` (`System.out.print` deve ser usado nesse método)
   2. `sub`: sem parâmetros e retorno `void`; apresentar na tela o resultado da subtração dos valores das variáveis de classe `x` e `y` (`System.out.print` deve ser usado nesse método)
   3. `mult`: sem parâmetros e retorno `void`; apresentar na tela o resultado da multiplicação dos valores das variáveis de classe `x` e `y` (`System.out.print` deve ser usado nesse método)
   4. `div`: sem parâmetros e retorno `void`; apresentar na tela o resultado da divisão dos valores das variáveis de classe `x` e `y`  (`System.out.print` deve ser usado nesse método)
5. Na `main`, instancie um objeto da classe `Calculadora`
6. Na `main`, peça para o usuário digitar valores para x e y e armazene-os nas variáveis da classe `Calculadora`
7. Na `main`, mostre na tela os resultados usando os métodos do objeto instanciado da classe `Calculadora`

OBSERVAÇÕES:

- **NÃO USE** variáveis locais
- Use apenas variáves de classe
- `Scanner` deve ser usado na `main`
- **NÃO USE** `Scanner` nos métodos da classe `Calculadora`  
- `System.out.print` deve ser usado nos métodos da classe `Calculadora` 
- **NÃO USE** `System.out.print` na `main` 



---



### Atividade 2



1. Crie um projeto Java Padrão e dê o nome de `Atividade2`
2. Crie uma Classe e dê o nome de `Calculadora`
3. Declare as seguintes **variáveis de classe** (**NÃO** `static`) para `Calculadora`:
   1. `x`: tipo `float` e acesso `private`
   2. `y`: tipo `float` e acesso `private` 
4. Defina os seguintes métodos (**NÃO** `static`) na classe `Calculadora`:
   1. `pedirX`: sem parâmetros e retorno `void`; esse método irá pedir para o usuário digitar o valor de x e armazenará o valor digitado na variável de classe `x`  (`Scanner` deve ser usado nesse método)
   2. `pedirY`: sem parâmetros e retorno `void`; esse método irá pedir para o usuário digitar o valor de y e armazenará o valor digitado na variável de classe `y` (`Scanner` deve ser usado nesse método)
   3. `soma`: sem parâmetros e retorno `void`; esse método apresentará na tela o resultado da soma das variáveis de classe `x` e `y` (`System.out.print` deve ser usado nesse método)
   4. `sub`: sem parâmetros e retorno `void`;  esse método apresentará na tela o resultado da subtração das variáveis de classe `x` e `y` (`System.out.print` deve ser usado nesse método)
   5. `mult`: sem parâmetros e retorno `void`;  esse método apresentará na tela o resultado da multiplicação das variáveis de classe `x` e `y` (`System.out.print` deve ser usado nesse método)
   6. `div`: sem parâmetros e retorno `void`;  esse método apresentará na tela o resultado da divisão das variáveis de classe `x` e `y` (`System.out.print` deve ser usado nesse método)
5. Na `main`, instancie um objeto da classe `Calculadora` e chame os métodos `pedirX` e `pedirY`
6. Depois, na `main`, chame os métodos `soma`, `sub`, `mult` e `div` 

OBSERVAÇÕES:

- `Scanner` deve ser usado apenas nos métodos da classe `Calculadora` 
- **NÃO USE** `Scanner` na `main` 
- `System.out.print` deve ser usado apenas nos métodos da classe `Calculadora` 
- **NÃO USE** `System.out.print` na `main` 
- **NÃO USE** variáveis locais; use apenas variáves de classe



---



### Atividade 3



1. Crie um projeto Java Padrão e dê o nome de `Atividade3`
2. Crie uma classe e dê o nome de `Calculadora` 
3. Declare as seguintes variáves de classe (**NÃO** `static`) para `Calculadora`:
   1. `x`: tipo `float` e acesso `private` 
   2. `y`: tipo `float` e acesso `private` 
4. Defina os seguintes métodos (**NÃO** `static`) na classe `Usuario`:
   1. `atribuirX`: um parâmetro `float` e retorno `void`; esse método recebe um valor `float` como parâmetro e atribui esse valor na variável de classe `x`
   2. `atribuirY`: um parâmetro `float` e retorno `void`; esse método recebe um valor `float` como parâmetro e atribui esse valor na variável de classe `y`
   3. `soma`: sem parâmetros e retorno `float`; esse método apenas retorna o resultado da soma das variáveis de classe `x` e `y` 
   4. `sub`: sem parâmetros e retorno `float`; esse método apenas retorna o resultado da subtração das variáveis de classe `x` e `y` 
   5. `mult`: sem parâmetros e retorno `float`; esse método apenas retorna o resultado da multiplicação das variáveis de classe `x` e `y` 
   6. `div`: sem parâmetros e retorno `float`; esse método apenas retorna o resultado da divisão das variáveis de classe `x` e `y` 
5. Na `main`, peça para o usuário digitar **o x e o y** e armazene em variáveis locais (ou seja, declaradas na `main`)
6. Na `main`, instancie um objeto da classe `Calculadora`
7. Chame o método `atribuirX`, passando como parâmetro o valor inserido para x
8. Chame o método `atribuirY`, passando como parâmetro o valor inserido para y
9. Chame os métodos `soma`, `sub`, `mult` e `div` e use os valores retornados para apresentar os resultados na tela

OBSERVAÇÕES:

- `Scanner` deve ser usado na `main` 
- **NÃO USE** `Scanner` nos métodos da classe `Calculadora`
- `System.out.print` deve ser usado na `main` 
- **NÃO USE** `System.out.print` nos métodos da classe `Calculadora`
- Os valores digitados pelo usuário para x e y devem ser atribuídos nas variáveis de classe **usando os métodos `atribuirX` e `atribuirY`**
- **NÃO ATRIBUA** os valores digitados pelo usuário diretamente às variáveis de classe (pois elas têm acesso `private`)



---



### Atividade 4



1. Crie um projeto Java Padrão e dê o nome de `Atividade4`
2. Crie uma classe e dê o nome de `Calculadora` 
3. Declare as seguintes variáves de classe (**NÃO** `static`) para `Calculadora`:
   1. `x`: tipo `float` e acesso `private` 
   2. `y`: tipo `float` e acesso `private` 
   3. `ultimoResultado`: tipo `float` e acesso `private` 
4. Defina os seguintes métodos (**NÃO** `static`) na classe `Calculadora`:
   1. `atribuirX`: um parâmetro `float` e retorno `void`; esse método recebe um valor `float` como parâmetro e atribui esse valor na variável de classe `x`
   2. `atribuirY`: um parâmetro `float` e retorno `void`; esse método recebe um valor `float` como parâmetro e atribui esse valor na variável de classe `y`
   3. `soma`: sem parâmetros e retorno `float`; esse método armazena o resultado da soma na variável de classe `ultimoResultado` e retorna o resultado
   4. `sub`: sem parâmetros e retorno `float`; esse método armazena o resultado da subtração na variável de classe `ultimoResultado` e retorna o resultado
   5. `mult`: sem parâmetros e retorno `float`; esse método armazena o resultado da multiplicação na variável de classe `ultimoResultado` e retorna o resultado
   6. `div`: sem parâmetros e retorno `float`; esse método armazena o resultado da divisão na variável de classe `ultimoResultado` e retorna o resultado
   7. `mostrarUltimoResultado`: sem parâmetros e retorno `void`; esse método apenas apresenta na tela o valor da variável de classe `ultimoResultado`
5. Na `main`, peça para o usuário digitar **o x e o y** e armazene em variáveis locais (ou seja, declaradas na `main`)
6. Na `main`, instancie um objeto da classe `Calculadora`
7. Chame o método `atribuirX`, passando como parâmetro o valor inserido para x
8. Chame o método `atribuirY`, passando como parâmetro o valor inserido para y
9. Chame os métodos `soma`, `sub`, `mult` e `div` e use os valores retornados para apresentar os resultados na tela
10. Chame o método `mostrarUltimoResultado` 

OBSERVAÇÕES:

- `Scanner` deve ser usado na `main` 
- **NÃO USE** `Scanner` nos métodos da classe `Calculadora`
- `System.out.print` deve ser usado na `main`
- **NÃO USE** `System.out.print` nos métodos da classe `Calculadora` 
- Os valores digitados pelo usuário para x e y devem ser atribuídos nas variáveis de classe **usando os métodos `atribuirX` e `atribuirY`**
- **NÃO ATRIBUA** os valores digitados pelo usuário diretamente às variáveis de classe (pois elas têm acesso `private`)



---



### Atividade 5



1. Crie um projeto Java Padrão e dê o nome de `Atividade5`
2. Crie uma classe e dê o nome de `Calculadora` 
3. Declare as seguintes variáves de classe (**NÃO** `static`) para `Calculadora`:
   1. `ultimoX`: tipo `float` e acesso `private` 
   2. `ultimoY`: tipo `float` e acesso `private` 
   3. `ultimaOperacao`: tipo `String` e acesso `private` 
   4. `ultimoResultado`: tipo `float` e acesso `private` 
4. Defina os seguintes métodos (**NÃO** `static`) na classe `Calculadora`:
   1. `soma`: dois parâmetros do tipo `float` e retorno `float`; esse método armazena o primeiro parâmetro na variável de classe `ultimoX`, o segundo parâmetro na variável de classe `ultimoY`, o valor "+" na variável de classe `ultimaOperacao`, o resultado da soma na variável de classe `ultimoResultado` e retorna o resultado
   2. `sub`: dois parâmetros do tipo `float` e retorno `float`; esse método armazena o primeiro parâmetro na variável de classe `ultimoX`, o segundo parâmetro na variável de classe `ultimoY`, o valor "-" na variável de classe `ultimaOperacao`, o resultado da subtração na variável de classe `ultimoResultado` e retorna o resultado
   3. `mult`: dois parâmetros do tipo `float` e retorno `float`; esse método armazena o primeiro parâmetro na variável de classe `ultimoX`, o segundo parâmetro na variável de classe `ultimoY`, o valor "*" na variável de classe `ultimaOperacao`, o resultado da multiplicação na variável de classe `ultimoResultado` e retorna o resultado
   4. `div`: dois parâmetros do tipo `float` e retorno `float`; esse método armazena o primeiro parâmetro na variável de classe `ultimoX`, o segundo parâmetro na variável de classe `ultimoY`, o valor "/" na variável de classe `ultimaOperacao`, o resultado da divisão na variável de classe `ultimoResultado` e retorna o resultado
   5. `mostrarUltimaOperacao`: sem parâmetros e retorno `void`; esse método apenas apresenta na tela os valores das variáveis de classe `ultimoX`, `ultimoY`, `ultimaOperacao` e `ultimoResultado` 
5. Na `main`, peça para o usuário digitar **o x e o y** e armazene em variáveis locais (ou seja, declaradas na `main`)
6. Na `main`, instancie um objeto da classe `Calculadora`
7. Chame os métodos `soma`, `sub`, `mult` e `div`, passando os valores das variáveis locais x e y como parâmetros e use os valores retornados para apresentar os resultados na tela
8. Chame o método `mostrarUltimaOperacao` 

OBSERVAÇÕES:

- `Scanner` deve ser usado na `main` 
- **NÃO USE** `Scanner` nos métodos da classe `Calculadora`
- `System.out.print` deve ser usado na `main` (e também no método `mostrarUltimaOperacao`)
- **NÃO USE** `System.out.print` nos métodos da classe `Calculadora` (com exceção de `mostrarUltimaOperacao`)
- Os valores digitados pelo usuário para x e y devem ser atribuídos nas variáveis de classe **usando os métodos de classe**
- **NÃO ATRIBUA** os valores digitados pelo usuário diretamente às variáveis de classe (pois elas têm acesso `private`)

