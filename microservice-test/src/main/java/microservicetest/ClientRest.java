package microservicetest;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ClientRest {

    public ResponseOutputAPIEntity callAPI() {

        RestTemplate restTemplate = new RestTemplate();
        String fooResourceUrl
                = "http://localhost:8091/test";
        ResponseEntity<ResponseOutputAPIEntity> response
                = restTemplate.getForEntity(fooResourceUrl, ResponseOutputAPIEntity.class);
        return  response.getBody();
    }
}
