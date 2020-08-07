package proj.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import proj.entity.Article;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Long> {
}