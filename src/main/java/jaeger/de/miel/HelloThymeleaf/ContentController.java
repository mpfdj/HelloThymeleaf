package jaeger.de.miel.HelloThymeleaf;

import jaeger.de.miel.HelloThymeleaf.dto.ContentItemDTO;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("content")
public class ContentController {

    @Autowired
    private ApplicationContext context;
    private List<ContentItemDTO> contentItemDTOs;

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
        model.addAttribute("contentItemDTOs", contentItemDTOs);
        return "content :: content2";
    }


    @PostConstruct
    public void postConstruct() {
        contentItemDTOs = (List<ContentItemDTO>) context.getBean("getContentItemDTOs");
    }
}