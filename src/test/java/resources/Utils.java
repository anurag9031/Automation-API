package resources;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.io.*;
import java.util.Properties;

public class Utils {
    public static RequestSpecification reqSpec;

    public RequestSpecification requestSpecification() throws IOException {
        if(reqSpec == null) {
            PrintStream log = new PrintStream(new FileOutputStream("log.txt"));
            reqSpec = new RequestSpecBuilder().setBaseUri(getGlobalValue("baseUrl"))
                    .addQueryParam("key", "qaclick123")
                    .setContentType(ContentType.JSON)
                    .addFilter(RequestLoggingFilter.logRequestTo(log))
                    .addFilter(ResponseLoggingFilter.logResponseTo(log))
                    .build().log().all();
            return reqSpec;
        }
        return reqSpec;
    }

    public String getGlobalValue(String key) throws IOException {
        Properties prop=new Properties();
        FileInputStream fis=new FileInputStream("C:\\Users\\HP\\IdeaProjects\\AutomationAPI\\src\\test\\java\\resources\\global.properties");
        prop.load(fis);
        System.out.println(key);
        return prop.getProperty(key);
    }

    public String getJsonPath(Response response, String key){
        String resp=response.asString();
        JsonPath js=new JsonPath(resp);
        return(js.get(key).toString());

    }
}
