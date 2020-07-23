package Steps;

import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import static io.restassured.RestAssured.given;
import static org.hamcrest.core.Is.is;

public class Usuario {
    //RestAssured restAssured = new RestAssured();
    RequestSpecification requestSpecification = RestAssured.given();
    //Response response;



    @Dado("^que a requisicao contem \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" (\\d+)$")
    public void que_a_requisicao_contem(String id, String username, String firstname, String lastname, String email, String password, String phone, int userStatus) throws Throwable {

        requestSpecification.given(). //dado que
                contentType("application/json"). //Tipo do conteudo REST é sempre assim
                // Existem serviço ASMX e outros, o formato seria text/xml
                        log().all().                    // Gerar um Log completo
                        body("{\"id\":" +id+ "," +
                "\"username\":" + username +"," +
                "\"firstname\":" + firstname +"," +
                "\"lastname\":" + lastname +"," +
                "\"email\":" + email +"," +
                "\"password\":" + password +"," +
                "\"phone\":" + phone +"," +
                "\"userStatus\":" + userStatus + "}");
    }

    @Quando("^chamo com a uri da PetShop$")
    public void chamo_com_a_uri_da_PetShop() throws Throwable {
        requestSpecification.when().post("https://petstore.swagger.io/v2/user");
    }

    @Entao("^valido o (\\d+) \"([^\"]*)\" \"([^\"]*)\"$")
    public void valido_o(int code, String type, String message) throws Throwable {
        requestSpecification.then().log().all().statusCode(200) // teste de Interoperabilidade (conectou)
         .body("code", is(code))
         .body("type", is(type))
         .body("message", is(message));

    }

}
