package microservicetest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("client")
public class Controller {

    @Autowired
    ClientRest clientRest;

    @GetMapping
    public ResponseOutputAPIEntity getAll() {
        return clientRest.callAPI();
    }

//    @PostMapping
//    public Input postCall(@RequestBody Input input) {
//        System.out.println("Post request..");
//        return input;
//    }

}
