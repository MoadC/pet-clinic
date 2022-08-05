package guru.spring.petclinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class VetController {

    @RequestMapping({"/vets", "/vets/index"})
    public String VetsList(){

        return "vets/index";
    }
}
