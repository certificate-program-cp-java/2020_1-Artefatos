# Desenvolvimento Web com Java e Spring Boot

## Sobre a disciplina
Essa disciplina é oferecida no curso de [pós-graduação online em Java](http://pos-graduacao-ead.cp.utfpr.edu.br/java/) da Universidade Tecnológica Federal do Paraná - Campus Cornélio Procópio.

A disciplina é ministrada pelo [prof. Gabriel Costa Silva](https://gabrielcostasilva.github.io/personal-website/) nos semestres de 2019/2 e 2020/1.

## Objetivo
O objetivo geral dessa disciplina é capacitar o estudante para criar aplicações Web completamente funcionais usando Java e o framework Spring Boot. 

## Tecnologias
Além do Java e Spring Boot, outras tecnologias que são usadas na disciplina são:
- Maven;
- Git;
- Bootstrap;
- Freemarker;
- Spring Security e Data;

## Aulas
- [Hello World](./hello-world/): Nesta primeira aula criamos nossa primeira aplicação Web com Java e Spring Boot. Vamos começar como todo curso - criando um Hello World. Ao longo das semanas, vamos evoluir esse app até se tornar um CRUD completo.

- [Páginas Dinâmicas](./paginas-dinamicas/): Até agora nossa aplicação está basicamente estática. Ela pode responder a solicitações do usuário, mas os resultados na página Web continuam sempre os mesmos. Nesta segunda aula vamos introduzir dinamismo na nossa aplicação usando o Freemarker.

- [CRUD](./crud): Nesta aula vamos transformar nosso HelloWorld em um CRUD completo. Vamos trabalhar com um exemplo bem simples para todos consigam acompanhar. Contudo, vamos usar os princípios fundamentais para criar qualquer aplicação Web que envolva ler, criar, alterar ou excluir dados.

- [Validação](./validacao): Da forma como está, nossa aplicação atende as 4 funcionalidades básicas de ler, criar, alterar e excluir dados. Contudo, se houver qualquer erro na entrada desses dados, eles serão inseridos/alterados mesmo assim! Por isso, precisamos de validação - o assunto dessa aula.

- [Camadas](./camadas): Nossa 'parte Web' já é capaz de se comportar como é esperado de uma aplicação Web. Agora precisamos integrar com o restante da aplicação para permitir persistência de dados e gerenciamento das regras de negócio. Vamos fazer isso nessa aula, além de organizar a arquitetura da nossa aplicação usando camadas.

-[Segurança](./seguranca): Nossa aplicação está funcionando. Mas você não quer que qualquer um acesse todas as partes da sua aplicação, não é mesmo? Na maioria das aplicações alguns dados devem ter visibilidade limitada. Para isso vamos usar os recurso do Spring Boot para adicionar autenticação e autorização de usuários.