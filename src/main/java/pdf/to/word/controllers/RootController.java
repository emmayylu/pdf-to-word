package pdf.to.word.controllers;

import org.springframework.boot.autoconfigure.*;
import org.springframework.web.bind.annotation.*;


@SpringBootApplication
@RestController
@EnableAutoConfiguration
public class RootController {

    @GetMapping("/ping")
    public @ResponseBody
    String root() {
        return "pong";
    }

}
