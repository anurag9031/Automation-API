package stepDefinations;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import pojo.AddPlace;
import pojo.Location;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class StepDefination {
    RequestSpecification reqspec;
    ResponseSpecification resspec;
    RequestSpecification req;
    Response response;
    @Given("Add place payload")
    public void add_place_payload() {
        AddPlace p=new AddPlace();
        p.setAccuracy(50);
        p.setAddress("Viman Nagar,Pune");
        p.setLanguage("English");
        p.setName("Mukesh");
        p.setPhone_number("89765467");
        p.setWebsite("http://google.com");
        List<String> mylist=new ArrayList<String>();
        mylist.add("Car park");
        mylist.add("shop");
        p.setTypes(mylist);
        Location l=new Location();
        l.setLat(-38.383494);
        l.setLng( 33.427362);
        p.setLocation(l);
        reqspec=new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com/")
                .addQueryParam("key","qaclick123").build();

        req=given().spec(reqspec).body(p);

        resspec=new ResponseSpecBuilder().expectStatusCode(200)
                .expectContentType("application/json").build();

        req.when().post("maps/api/place/add/json")
                .then().spec(resspec).log().all();
    }
    @When("User call {string} with Post http request")
    public void user_call_with_post_http_request(String string) {
        response=req.when().post("maps/api/place/add/json")
                .then().spec(resspec).extract().response();
    }
    @Then("the api call got success with status code {int}")
    public void the_api_call_got_success_with_status_code(Integer int1) {
        assertEquals(response.getStatusCode(),200);
    }
    @Then("{string} in response body  is {string}")
    public void in_response_body_is(String key, String ExpectedValue) {
        String result=response.asString();
        JsonPath js=new JsonPath(result);
       assertEquals(js.get(key).toString(),ExpectedValue);



    }
}
