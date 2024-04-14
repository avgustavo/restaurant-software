# Sistema de controle de pedidos de um restaurante
Um projeto da disciplina de Programação Orientada a Objetos.

# Descrição Geral
Este documento descreve as funcionalidades do sistema de controle e realização de pedidos de um restaurante. O sistema permite que pedidos sejam realizados de diferentes maneiras: na mesa, no balcão ou para entrega. Além disso, oferece flexibilidade para editar, remover e encerrar pedidos.

# Padrões de Projeto
## Padrão Model-View-Controller (MVC)
O sistema foi desenvolvido seguindo a arquitetura Model-View-Controller (MVC), que separa a lógica de negócio da interface do usuário, facilitando a manutenção e a escalabilidade. As principais componentes são:
* Model: Responsável pelos dados e regras de negócio.
* View: Apresenta os dados e interações à disposição do usuário.
* Controller: Faz a mediação da entrada e saída de dados entre o Model e a View.

## Padrão Fachada
Utilizamos o padrão de projeto Fachada para simplificar as interações entre as interfaces gráficas e a lógica de negócio, proporcionando uma camada única de comunicação para as operações mais complexas, o que torna o sistema mais organizado e fácil de utilizar.

# Funcionalidades
## Realização de Pedidos
* Na mesa;
* No balcão;
* Para entrega.

## Gerenciamento de Pedidos
* Editar Pedido: Cada pedido pode ser editado enquanto estiver aberto.
* Remover Pedido: Um pedido pode ser removido se ainda não tiver sido encerrado.
* Encerrar Pedido: Quando um pedido é concluído, ele pode ser encerrado. Uma vez encerrado, o pedido é removido da tela de pedidos abertos.

## Telas do Sistema
* Tela de Pedidos Abertos: Mostra todos os pedidos que estão atualmente ativos e não encerrados.
* Tela de Pedidos Encerrados: Acessível através do botão "Encerrar Caixa". Esta tela exibe todos os pedidos que foram encerrados durante o dia, mas que não podem mais ser editados.
* Tela de realização do pedido: Mostra o cardápio, os itens adicionados, tipo de entrega e valor total.

## Encerramento do Dia
* Encerrar Caixa: Ao final do dia, o operador pode encerrar o caixa. Isso faz com que a tela de pedidos encerrados seja exibida.
* Geração de Relatório: Quando o caixa é encerrado, um arquivo de texto é automaticamente gerado contendo todos os pedidos do dia.

# Teste da Aplicação
Para testar a aplicação, siga os passos abaixo:

1) Navegue até a pasta "dist"
2) Execute o arquivo Restaurante.jar
3) usuario: fernando30
4) senha: nota10

# Observações finais
Projeto realizado por mim, Lucas de Albuquerque, João Victor Tavares e Carlos Henrique Mapurunga
