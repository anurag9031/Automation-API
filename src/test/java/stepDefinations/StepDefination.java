package stepDefinations;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import resources.ApiResources;
import resources.TestDataBuild;
import resources.Utils;

import java.io.IOException;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.requestSpecification;
import static org.junit.Assert.assertEquals;

public class StepDefination extends Utils {
    TestDataBuild data = new TestDataBuild();
    RequestSpecification res;
    ResponseSpecification respect;
    Response response;
    static String actualname;
    static String place_id;


    @Given("Add place payload {string},{string},{string}")
    public void add_place_payload(String name,String language,String address) throws IOException {
        res = given().spec(requestSpecification())
                .body(data.add_place_payload(name,language,address));
    }

    @When("user call {string} with {string} http request")
    public void user_call_with_http_request(String resource,String string) {
        ApiResources resourceAPI=ApiResources.valueOf(resource);
        System.out.println(resourceAPI.getResource());
        respect = new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
        response = res.when().post(resourceAPI.getResource())
                .then().spec(respect).extract().response();
    }

    @Then("the api call got success with status code {int}")
    public void the_api_call_got_success_with_status_code(Integer int1) {
        assertEquals(response.getStatusCode(), 200);
    }

    @Then("{string} in response body  is {string}")
    public void in_response_body_is(String key, String ExpectedValue) {

        assertEquals(getJsonPath(response,key), ExpectedValue);
    }
    @Then("Verify Place id created maps to {string} using {string}")
    public void verify_place_id_created_maps_to_using(String name, String resource) throws IOException {
        place_id=getJsonPath(response,"place_id");
        res=given().spec(requestSpecification()).queryParam("place_id",place_id);
        user_call_with_http_request(resource,"GET");
        actualname=getJsonPath(response,"name");
        System.out.println(actualname);
        assertEquals(actualname,name);
    }
    @Given("Delete place payload with DeletePlaceAPI")
    public void delete_place_payload_with_delete_place_api() throws IOException {
       res=given().spec(requestSpecification()).body(data.delete_api_payload(place_id));
    }

}