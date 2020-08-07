package proj.entity;

import lombok.*;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Component
@Lazy
@ToString
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long articleNo;
    @Column(length = 500, nullable = false)
    private String banner;
    @Column(length = 500, nullable = false)
    private String title;
    @Column(length = 200, nullable = false)
    private String category;
    @Column(length = 200, nullable = false)
    private String author;
    @Column(length = 200, nullable = false)
    private String date;

    @Builder
    public Article(String banner, String title, String category, String author, String date) {
        this.banner = banner;
        this.title = title;
        this.category = category;
        this.author = author;
        this.date = date;
    }
}