## Solução e-commerce com microsserviços em Java

#### Projeto desenvolvido durante o Bootcamp Inter Java Developer - Digital Innovation One 💻 📚

O objetivo desse projeto foi aprender a implementar arquitetura de microsserviços desenvolvendo uma solução e-commerce, 
com a construção de uma API de checkout e outra de pagamento. O projeto possui a API de checkout como "producer" que lança 
um evento para o Kafka e a API de pagamento como "processor" que escuta, processa o pagamento e devolve o evento de pagamento 
para o kafka, sendo escutado pelo checkout. Além disso, a aplicação utiliza o Apache Avro como sistema de serialização dos 
dados.


⚙️ Foram utilizados:

* Spring Boot
* Spring Cloud Streams
* Apache Kafka
* Apache Avro
* Schema Registry

👣 Passo a passo:
* Desenvolvimento da aplicação de checkout:
    - Subir o Postgres, zookeeper e Schema-registry e broker via docker compose (Compose file disponibilizado na pasta docker pelo professor)
    - Criação dos schemas avro CheckoutCreated.avsc e PaymentCreated.avsc;
    - Configuração do arquivo application.yml;
    - Criação e configuração de streaming CheckoutCreatedSource e PaymentPaidSink;
    - Criação do serviço CheckoutService que cria o evento Checkout enviando-o para o Kafka;
    - Criação de um REST controller que recebe requisição HTTP para chamar o serviço de criação do checkout;

* Desenvolvimento da [aplicação payment](https://github.com/andressaOlimpia/ecommerce-microservice-payment)
  
    - Criação dos schemas avro CheckoutCreated.avsc e PaymentCreated.avsc;
    - Configuração do arquivo application.yml;
    - Criação e configuração do streaming Checkoutprocessor;
    - Criação do serviço PaymentService que recebe o evento de checkout e cria o evento de pagamento;
    - Criação do listener que recebe o checkout, chama o serviço PaymentService e envia o evento de pagamento;


:bulb: Material base para execução desse módulo:
https://github.com/hatanakadaniel/ecommerce-checkout-api





  