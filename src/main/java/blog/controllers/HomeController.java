package blog.controllers;

import blog.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.stream.Collectors;

import blog.models.Post;
@Controller
public class HomeController {
    @Autowired
    private PostService postService;

    @RequestMapping("/")
    public String index(Model model){

        List<Post> latest5posts = postService.findLatest5();
        model.addAttribute("latest5posts", latest5posts);

        List<Post> latest3Posts = latest5posts
                .stream()
                .limit(3)
                .collect(Collectors.toList());
        model.addAttribute("latest3posts", latest3Posts);
        return "index";
    }

}
