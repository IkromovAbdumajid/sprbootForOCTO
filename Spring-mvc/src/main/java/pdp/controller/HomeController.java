package pdp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

//bean + page qaytarish xususiyati bor
@Controller
// brauzerdan /home san tutib olasan
@RequestMapping("/home")
public class HomeController {

    @RequestMapping(method = RequestMethod.GET)
    public String getHomepage(Model model) {
        model.addAttribute("test", "Hello World!");
        return "index";
    }


}
