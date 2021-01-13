package stepDefinations;


import io.cucumber.java.en.*;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import utilities.APIResorces;
import utilities.TestDataBuild;
import utilities.Utils;
import java.io.IOException;

import static io.restassured.RestAssured.*;
import static org.junit.Assert.*;

public class StepDefination2 extends Utils{

    RequestSpecification res;
    ResponseSpecification resspec;
    Response response;
    JsonPath jp;
   static String place_id;


    TestDataBuild dataBuild = new TestDataBuild();

    @Given("Add Place Payload {string}, {string},{string}")
    public void addPlacePayload(String name, String language, String address) throws IOException {
        res = given()
                .spec(requestSpecification())
                .body(dataBuild.addPlacePayload2(name, language, address))
        ;
    }


    @When("User calls {string} with {string} http request")
    public void userCallsWithHttpRequest(String resource, String method){

       APIResorces resourceAPI = APIResorces.valueOf(resource);

        resspec = new ResponseSpecBuilder().expectStatusCode(200)
                      .expectContentType(ContentType.JSON).build();

        response = res.when()
                            .post(resourceAPI.getResource()).
                       then()
                .log().all()
                            .spec(resspec).extract().response();
       // System.out.println("response ="+response)
    }

    @Then("the API call got success with status code {int}")
    public void the_api_call_got_success_with_status_code(Integer int1) {
        assertEquals(response.getStatusCode(),200);
    }


    @And("{string} in response body is {string}")
    public void inResponseBodyIs(String keyValue, String expectedValue) {

        
        String resp = response.asString();
                  jp = new JsonPath(resp);
        assertEquals(jp.getJsonObject(keyValue).toString(),expectedValue);
        assertEquals(getJsonPath(response,keyValue),expectedValue);
    }


    @And("Verify place_Id created maps to {string}  using {string}")
    public void verifyPlace_IdCreatedMapsToUsing(String expectedName, String resource) {
        //req spec
        place_id  = getJsonPath(response,"place_id") ;
        
        res = given()
                .spec(requestSpecification)
                .queryParam("place_id",place_id) ;

        userCallsWithHttpRequest(resource,"GET");
       String actualName= getJsonPath(response,"name");
       assertEquals(actualName,expectedName);
    }

    @Given("DeletePlace  Payload")
    public void deleteplacePayload() throws IOException {
        given()
                .spec(requestSpecification().body(dataBuild.deletePlacePayload(place_id)));

    }

    @When("user class {string} with {string} http request")
    public void userClassWithHttpRequest(String arg0, String arg1) {
    }

    @Then("the API call got  success with status code {int}")
    public void theAPICallGotSuccessWithStatusCode(int arg0) {
    }


}
