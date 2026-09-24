1. Em qual classe foi utilizado encapsulamento?
O encapsulamento foi utilizado nas classes Pedido e PedidoDelivery, onde os atributos foram declarados como privados (private) e acessados/modificados através dos métodos públicos get e set.

2. Quais classes participaram da herança?
As classes Pedido, PedidoLocal e PedidoDelivery.

3. Qual classe foi considerada a classe pai?
A classe Pedido (também chamada de superclasse ou classe base).

4. Qual ou quais classes foram consideradas classes filhas?
As classes PedidoLocal e PedidoDelivery (também chamadas de subclasses).

5. Qual interface foi criada?
A interface Pagamento.

6. Qual classe utilizou implements?
A classe abstrata Pedido utilizou o implements Pagamento (logo, as classes filhas herdam essa obrigação de implementar os métodos).

7. Qual método possui sobrecarga?
O método realizarPagamento.

8. Qual é a diferença entre os métodos sobrecarregados?
A diferença está nos parâmetros (assinatura do método). O primeiro método recebe apenas um parâmetro (o valor para dinheiro), o segundo recebe dois parâmetros (valor e chave PIX em String), e o terceiro recebe dois parâmetros de tipos diferentes (valor e quantidade de parcelas em int).

9. Onde foi utilizado extends?
Foi utilizado na declaração das classes filhas para estabelecer a herança. Ou seja: public class PedidoLocal extends Pedido e public class PedidoDelivery extends Pedido.

10. Explique com suas palavras a função de uma interface em Java.
Uma interface em Java funciona como um "contrato". Ela serve para definir quais métodos uma classe obrigatoriamente deve ter (as regras), mas não diz como esses métodos devem ser feitos. Quando uma classe "assina" esse contrato (usando implements), ela é obrigada a escrever o código de todos os métodos que a interface exigiu.