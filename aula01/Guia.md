# Guia Java



### Métodos

Métodos são **blocos de código** que contêm as instruções que serão processadas pelo processador.

Cada método possui seu próprio escopo, de tal forma que as variáveis declaradas em um método só são acessíveis no próprio método, isto é, não podem ser acessadas de outro método.

Os métodos são **definidos** nas classes.

Veja como definir um método em uma classe:

```java
public class Usuario {
    
    // Definição de um método
    //	void 		-> tipo do valor de retorno
    //	mostrarNome -> identificador do método
    //	() 			-> dentro dos parênteses ficam os parâmetros. Nesse caso não
    //					há parâmetro algum
    //	{ }			-> as chaves definem o corpo (e o escopo) do método
    void mostrarNome() {
        System.out.println("Nome Padrão: Java");
    }
    
    // Definição de um método
    //	void 		-> tipo do valor de retorno
    //	mostrarNome -> identificador do método
    //	(String nome)-> Um parâmetro do tipo String
    //	{ }			-> as chaves definem o corpo (e o escopo) do método
    void mostrarNome(String nome) {
        System.out.println("Nome: " + nome);
    }
    
}
```

Os métodos de uma classe **podem, ou não,** ser acessados por outro escopo, isto é, por **outra classe**.

O acesso dos métodos de uma classe dependem dos **modificadores de acesso**. Veja abaixo:

```java
public class Usuario {
    // modificador protected (que é o padrão)
    protected void mostrarNome() {
        
    }
    
    // modificador public
    public void mostrarEmail() {
        
    }
    
    // modificador private
    private void mostrarSenha() {
        
    }
}
```

- `protected`: **acesso protegido**; apenas as classes que estão no **mesmo pacote** da classe podem acessar os métodos. Nenhuma outra classe que esteja **em outro pacote** tem acesso aos métodos `protected`
- `private`: **acesso privado**; apenas a **própria classe** pode acessar o método. **Nenhuma outra classe** - independente de estar ou não no mesmo pacote - tem acesso aos métodos `private`
- `public`: **acesso público**; acessível por todas as classes



---



### Variáveis Locais

Variáveis locais são variáveis declaradas no escopo de um método e, portanto, só fazem parte desse escopo, não sendo possível acessá-las em outras partes do programa.

Veja como declarar uma variável local:

```java
public class App {
    
    public static void main(String[] args) {
        
        int x; // x é uma variável local por ter sido declarada no escopo da main
        int y; // y é uma variável local por ter sido declarada no escopo da main
        Scanner sc = new Scanner(System.in); // sc também é uma variável local

        x = sc.nextInt();
        y = sc.nextInt();
        soma(x, y);
        
    } // fim do método main
    
    public static void soma(int n1, int n2) {
        
        // n1 e n2 TAMBÉM são variáveis locais, porém, são utilizadas 
        //		para passagem de parâmetro
        System.out.println("Soma = " + (n1 + n2));
    
    } // fim do método soma
    
} // fim da classe App
```

Para declarar uma variável local, colocamos primeiramente o **tipo** da variável e, logo depois, um **identificador** para a variável:

```java
int x; 		// int é o tipo
			// x é o identificador
Scanner sc;	// Scanner é o tipo
			// sc é o identificador
```



---



### Variáveis de classe



Variáveis de classe são variáveis que pertencem ao escopo de uma classe. 

Veja como declarar variáveis de classe:

```java
public class Pessoa {
    String nome; 	// variável de classe
    int idade;		// variável de classe
    
    void mostrarNome() {
        System.out.println("Nome: " + nome);
    }
    
}
```

Diferentemente das variáveis locais, as variáveis de classe **podem, ou não,** ser acessadas por outros escopos, isto é, por outras classes.

O acesso da variável de classe depende dos **modificadores de acesso**. Veja abaixo: 

```java
public class Pessoa {
    protected 	String 	email; // modificador protected (que é o padrão)
    public 		String 	nome;  // modificador public
    private 	int 	idade; // modificador private
}
```

