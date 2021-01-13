package utilities;


import lombok.*;

@Setter  @Getter
@NoArgsConstructor @RequiredArgsConstructor
@ToString

public class Demo {
    String addPlaceApi = "/maps/api/place/add/json" ;
    String getPlaceApi = "/maps/api/place/get/json" ;
    String deletePlaceApi = "/maps/api/place/delete/json" ;


}
