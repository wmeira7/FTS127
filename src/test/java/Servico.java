import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.core.Is.is;

public class Servico {
    public String lerJson(String caminhoJson) throws IOException {
        return new String(Files.readAllBytes(Paths.get(caminhoJson)));
    }

    @Test
    public void tc_01_incluir_usuario() throws IOException {
        String resultado = "119900325";

        String jsonBody = lerJson("src/test/resources/usuario.json");

        given(). //dado que
                contentType("application/json"). //Tipo do conteudo REST é sempre assim
                                                // Existem serviço ASMX e outros, o formato seria text/xml
                log().all().                    // Gerar um Log completo
                body(jsonBody)
                .when().post("https://petstore.swagger.io/v2/user")
                .then().log().all().statusCode(200) // teste de Interoperabilidade (conectou)
                .body("code", is(200))
                .body("type", is("unknown"))
                .body("message", is(resultado));
    }

    @Test
    public void tc_02_consultar_usuario() throws IOException {
        //String resultado = "119900325";

        //String jsonBody = lerJson("src/test/resources/usuario.json");

        given(). //dado que
                contentType("application/json"). //Tipo do conteudo REST é sempre assim
                // Existem serviço ASMX e outros, o formato seria text/xml
                        log().all()                    // Gerar um Log completo
               // .body(jsonBody)
                .when().get("https://petstore.swagger.io/v2/user/AnaPaula")
                .then().log().all().statusCode(200);// teste de Interoperabilidade (conectou)
                //.body("id", is(119900325));
                // .body("code", is(0))
               // .body("type", is("unknown"))
               // .body("message", is(resultado));
    }
    @Test
    public void tc_03_delete_usuario() throws IOException {
        //String resultado = "119900325";

        //String jsonBody = lerJson("src/test/resources/usuario.json");

        given(). //dado que
                contentType("application/json"). //Tipo do conteudo REST é sempre assim
                // Existem serviço ASMX e outros, o formato seria text/xml
                        log().all()                    // Gerar um Log completo
                // .body(jsonBody)
                .when().delete("https://petstore.swagger.io/v2/user/AnaPaula1")
                .then().log().all().statusCode(200);// teste de Interoperabilidade (conectou)
        // .body("id", is(119900325));
        // .body("code", is(0))
        // .body("type", is("unknown"))
        // .body("message", is(resultado));
    }
    @Test
    public void tc_04_alterar_usuario() throws IOException {
        //String resultado = "119900325";

        String jsonBody = lerJson("src/test/resources/usuario1.json");

        given(). //dado que
                contentType("application/json"). //Tipo do conteudo REST é sempre assim
                // Existem serviço ASMX e outros, o formato seria text/xml
                        log().all()                    // Gerar um Log completo
                .body(jsonBody)
                .when().put("https://petstore.swagger.io/v2/user/AnaPaula")
                .then().log().all().statusCode(200);// teste de Interoperabilidade (conectou)
        // .body("id", is(119900325));
        // .body("code", is(0))
        // .body("type", is("unknown"))
        // .body("message", is(resultado));
    }
}


