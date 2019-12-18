# Aula 13



Links para os vídeos

- Imagens em diretório no servidor (outra abordagem para *upload* de imagens): [https://youtu.be/4UlIc24W3zs](https://youtu.be/4UlIc24W3zs)



### Atividade



Fazer as alterações necessárias para que cada tarefa possua uma imagem.



Lembrar que precisa modificar:

1. A tabela `tarefa` no banco de dados para armazenar o **nome do arquivo da imagem**.
2. A classe modelo `Tarefa`, para guardar o nome da imagem nos objetos no código Java.
3. A classe `TarefaDAO`, para que seja possível adicionar o nome do arquivo da imagem no banco e para que seja possível ler o nome da imagem também
4. A `AdicionarTarefaServlet` para que seja possível receber o arquivo de imagem do navegador e para realizar todo o processamento necessário de armazenamento da imagem (pegar referência para o diretório, verificar se existe, criar um novo arquivo dentro desse diretório, etc.)
5. A `home.jsp` para que o usuário consiga adicionar uma imagem e para que a Lista de Tarefas apresente a imagem de cada uma das tarefas