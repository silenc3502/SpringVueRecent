package proj.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import proj.entity.Article;
import proj.repository.ArticleRepository;
import proj.service.CrawlService;
import proj.utils.Box;
import proj.utils.Proxy;

import java.util.HashMap;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
public class CrawlController {
    @Autowired
    Box<Object> box;

    @Autowired
    CrawlService crawler;

    @Autowired
    Proxy pxy;

    @Autowired
    ArticleRepository articleRepository;

    @GetMapping("/article")
    public HashMap<String,Object> articles(){
        box.clear();
        if(articleRepository.count() == 0){
            crawler.article();
        }
        List<Article> list = articleRepository.findAll();
        pxy.print(articleRepository.findAll().toString());
        box.put("list", list);
        box.put("count", list.size());
        return box.get();
    }
}
