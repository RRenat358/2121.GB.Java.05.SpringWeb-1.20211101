package ru.rrenat358.api;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServlet;

@Controller
public class GeetingsController extends HttpServlet {

//    @GetMapping("/h")
    @GetMapping("/h/{name}")
//    @RequestMapping(value = "/h", method = RequestMethod.GET)
    @ResponseBody
//    public String helloWord(@RequestParam String name) {
    public String helloWord(@PathVariable String name) {
        return "Hello  " + name + " !";
    }


    @GetMapping("/home")
    public String home(@RequestParam(required = false) String name, Model model) {
        if (name != null) {
            model.addAttribute("name", name);
        } else{
            model.addAttribute("name", "Java");
        }

        return "home";
    }



    // GET http://localhost:8180/app/hello?name=Igor
    // [GET, POST, PUT, ... ] -> DispatcherServlet -> Ищет нужный контроллер -> Отдает ответ клиенту



}
