package jaeger.de.miel.HelloThymeleaf;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("content")
public class ContentController {

    @RequestMapping("")
    public String loadContent() {
        return "website";
    }

    @RequestMapping("content1")
    public String getContent1(Model model) {
        System.out.println("getContent1");
        model.addAttribute("data", "hello1");
        return "content :: content1";
    }

    @RequestMapping("content2")
    public String getContent2(Model model) {
        System.out.println("getContent2");
        model.addAttribute("data", "hello2");
        return "content :: content2";
    }
}