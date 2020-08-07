package proj.service;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import proj.entity.Article;
import proj.repository.ArticleRepository;
import proj.utils.Box;
import proj.utils.Proxy;

@Component("crawler") @Lazy
public class CrawlService extends Proxy {
    @Autowired
    Box<String> box;

    @Autowired
    ArticleRepository articleRepository;

    public void article(){
        try{
            String url = "http://www.inven.co.kr/webzine/news/?site=overwatch";
            Connection.Response homepage = Jsoup.connect(url).method(Connection.Method.GET)
                    .userAgent("Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/51.0.2704.103 Safari/537.36")
                    .execute();
            Document d = homepage.parse();
            Elements banner = d.select("img.banner");
            Elements title = d.select("span.title > a");
            Elements category = d.select("span.info > span.category:first-child");
            Elements info = d.select("span.info");
            print(info.toString());
            Article article = null;
            for(int i=0;i < banner.size(); i++){
                article = new Article();
                article.setBanner(banner.get(i).select("img").attr("src"));
                article.setTitle(title.get(i).text());
                article.setCategory(category.get(i).text());
                article.setAuthor(info.get(i).text().substring(6,34));
                article.setDate(info.get(i).text().substring(34));
                articleRepository.save(article);
            }
        }catch(Exception e){
            print("에러 발생"+2);
        }
    }
}
