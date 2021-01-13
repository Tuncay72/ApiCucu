package utilities;

public enum APIResorces {

    AddPlaceApi("/maps/api/place/add/json") ,
    GetPlaceApi("/maps/api/place/get/json") ,
    DeletePlaceApi("/maps/api/place/delete/json" );

    private String resource;
    
     APIResorces(String resource){
       this.resource = resource;
         
     }
     public String getResource(){
         return resource;
     }
     
}
