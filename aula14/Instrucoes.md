# Aula 14



Links para os vídeos

- Implantação do projeto no Heroku: [https://youtu.be/4UlIc24W3zs](https://youtu.be/4UlIc24W3zs)



## Atividade

Fazer um projeto Maven (Aplicação Web).

Fazer todas as alterações e ações necessárias no projeto para que ele funcione quando colocarmos nos servidores do Heroku, tais como:

1. Criar um *app* no Heroku (alugar uma máquina para colocarmos nosso projeto)
2. Criar um banco de dados PostgreSQL no Heroku e criar todas as tabelas necessárias (tabelas para usuários e tarefas)
3. Mudar a URL de acesso ao banco de dados no código do projeto
4. Mudar os comandos SQL que enviaremos ao banco de dados no código do projeto
5. Alterar a estratégia de armazenamento de imagens para as tarefas (vamos armazená-las diretamente em uma tabela do tipo `BLOB` no banco de dados, que no PostgreSQL é do tipo `BYTEA`)
6. Adicionar as bibliotecas de conexão com o banco (Driver) e as bibliotecas da JSTL via Maven (ao invés de fazer isso manualmente)
7. Adicionar um executável do *Tomcat* via Maven (ao invés de termos ele instalado no computador)
8. Subir o projeto para o Heroku



## Plugin do Maven para o Tomcat executável

```xml
<plugin>
    <groupId>org.apache.maven.plugins</groupId>
    <artifactId>maven-dependency-plugin</artifactId>
    <executions>
        <execution>
            <phase>package</phase>
            <goals><goal>copy</goal></goals>
            <configuration>
                <artifactItems>
                    <artifactItem>
                        <groupId>com.github.jsimone</groupId>
                        <artifactId>webapp-runner</artifactId>
                        <version>9.0.27.0</version>
                        <destFileName>webapp-runner.jar</destFileName>
                    </artifactItem>
                </artifactItems>
            </configuration>
        </execution>
    </executions>
</plugin>
```



## Comando para conectar o nosso projeto ao Heroku

```shell
heroku git:remote -a <nome-do-app>
```





## Explicações sobre as tecnologias utilizadas



### Maven

Maven é um gerenciador de dependências. 

Estávamos baixando, manualmente,  as bibliotecas necessárias para o sistema e adicionando-as no projeto.

Com o Maven, podemos apenas indicar quais são as bibliotecas que o projeto precisa e o próprio Maven se encarrega de baixá-las e instalá-las.



##### O arquivo pom.xml

O pom.xml é o arquivo no qual configuramos o Maven, para o Maven saiba quais são as bibliotecas que o projeto precisa.



### Heroku

O Heroku é um serviço de computação  em nuvem que possui uma faixa gratuita de utilização.

O Heroku permite que coloquemos aplicativos para rodar em servidores conectados à *Internet*.

Portanto, iremos alugar uma máquina nos servidores do Heroku e vamos colocar nosso **webapp** para rodar nessa máquina.

Para isso, vamos precisar executar o *Tomcat* na máquina alugada e colocar os arquivos do nosso projeto nessa máquina de tal forma que o *Tomcat* consiga reconhecê-los.



Até agora, estávamos usando o banco de dados `MySQL` na máquina local (`localhost`). Acontece que, no Heroku, não há como instalar um *software* de banco de dados na mesma máquina na qual o *Tomcat* estará rodando.

Por isso, não vamos conseguir conectar o nosso sistema com o banco de dados na máquina local.

Entretanto, o próprio Heroku oferece também um serviço de banco de dados, no qual podemos alugar **outra máquina**, que terá apenas a funcionalidade de ser um servidor de banco de dados.

Assim, iremos alugar duas máquina no Heroku: uma para rodar o *Tomcat* e o nosso sistema, e outra para rodar o banco de dados.



O banco de dados que possui uma faixa gratuita de utilização  no Heroku é o PostgreSQL.

Então, precisaremos substituir o MySQL pelo PostgreSQL.



Há um outro detalhe em relação ao Heroku: não é possível armazenar arquivos na mesma máquina do *Tomcat*, o que impossibilita utilizarmos aquela segunda estratégia de armazenamento de imagens.

A primeira estratégia que utilizamos para *upload* de imagens foi armazenando-as no próprio banco de dados em uma coluna do tipo `BLOB`.

A segunda, foi armazenando as imagens em um diretório na mesma máquina do *Tomcat*.

Como não é possível aplicar essa segunda estratégia no Heroku, precisaremos alterar a maneira que armazenamos as imagens das tarefas: ao invés de salvá-las em uma pasta do servidor, vamos armazená-las no próprio banco de dados, da mesma forma que fizemos com as imagens de perfil do usuário.



### Heroku CLI

O Heroku CLI é o programa de interface de linha de comando que utilizaremos para usar os serviços do Heroku.

É através desse programa que podemos enviar todos os arquivos do nosso projeto para a máquina do Heroku, além de fazer várias outras configurações.