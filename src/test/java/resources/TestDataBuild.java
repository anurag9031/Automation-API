package resources;
import pojo.AddPlace;
import pojo.Location;
import java.util.ArrayList;
import java.util.List;

public class TestDataBuild {

    public AddPlace add_place_payload(String name,String language,String address) {
        AddPlace p = new AddPlace();
        p.setAccuracy(50);
        p.setAddress(address);
        p.setLanguage(language);
        p.setName(name);
        p.setPhone_number("89765467");
        p.setWebsite("http://google.com");
        List<String> mylist = new ArrayList<String>();
        mylist.add("Car park");
        mylist.add("shop");
        p.setTypes(mylist);
        Location l = new Location();
        l.setLat(-38.383494);
        l.setLng(33.427362);
        p.setLocation(l);
        return p;
    }
    public String delete_api_payload(String placeId){
        return "{\n" +
                "    \"place_id\":\""+placeId+"\"\n" +
                "}";
    }


}
