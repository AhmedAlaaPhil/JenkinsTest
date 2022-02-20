import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.exc.UnrecognizedPropertyException;
import model.Product;
import org.testng.annotations.Test;

import java.io.IOException;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class TrainingXYZ {
    String baseURL = "https://reqres.in/api/";
    String endPoint = "users";
    String qpage = "page";
    int pageNumber = 2;
    @Test
    public void getRequest(){


           given().when()
                   .get(baseURL+endPoint)
                   .then()
                   .log().body()
                   .log().headers()
                   .assertThat()
                   .statusCode(200)
                   .body("per_page" , equalTo(6))
                   .body("data.size()" , equalTo(6))
                   .body("data.id" , everyItem(notNullValue()))
                   .body("data[0].id" , equalTo(1))
                   .header("Content-Type","application/json; charset=utf-8")
           ;

    }

    @Test
    public  void getRequestWithParam (){


        var respons = given().queryParam(qpage,pageNumber).when().get(baseURL+endPoint).then();
        respons.log().body();
    }

    @Test
    public void postRequest (){
        String body = """ 
                {
                "name": "morpheus",
                "job": "leader"
                }
                """;
        var respons = given().body(body).when().post(baseURL+endPoint).then();
        respons.log().body();

    }

    @Test
    public void putRequest (){

        String body = """ 
                {
                "name": "neo",
                "job": "leader"
                "id": "834"
                }
                """;
        var respons = given().body(body).when().put(baseURL+endPoint).then();
        respons.log().body();



    }

    @Test
    public void deleteRequest (){
        String body = """ 
                {
              
                "id": "834"
                }
                """;
        var respons = given().body(body).when().delete(baseURL+endPoint).then();
        respons.log().body();



    }


    @Test
    public void serializedRequest (){

        Product product= new Product ("neo" , "Player");

        var respons = given().body(product).when().post(baseURL+endPoint).then();
        respons.log().body();

    }



}
