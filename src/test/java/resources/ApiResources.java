package resources;

//Enum is the special class in Java which have collection of constant or methods
public enum ApiResources {
    //This is collection of Method in enum class all the path have included as part of enum class
    AddPlaceAPI("/maps/api/place/add/json"),GetPlaceAPI("/maps/api/place/get/json"),
    DeletePlaceAPI("/maps/api/place/delete/json");
    private String resource;
    //Constructor for Enum class
    ApiResources(String resource) {
            this.resource=resource;
    }

    public String getResource(){
        return resource;
    }
}
