#language: pt
  #enconding: utf-8

Funcionalidade: Cadastro de Usuario

  Esquema do Cenario: Cadastro de Usuario com Sucesso

    Dado que a requisicao contem <id> <username> <firstname> <lastname> <email> <passord> <phone> <userStatus>
    Quando chamo com a uri da PetShop
    Entao valido o <code> <type> <message>



    Exemplos:
      | id          | username    | firstname | lastname | email           | passord  | phone         | userStatus | code | type      | message     |
      | "119900325" | "AnaPaula"  | "Ana"     | "Paula"  | "ana@teste.com" | "123456" | "41999999991" | 1          | 200  | "unknown" | "119900325" |
      | "219900325" | "JucaTeste" | "Juca"    | "Teste"  | "juc@teste.com" | "654321" | "41999999992" | 1          | 200  | "unknown" | "219900325" |