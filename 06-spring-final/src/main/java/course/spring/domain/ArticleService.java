package course.spring.domain;

import course.spring.model.Article;

import java.util.List;

public interface ArticleService {
    List<Article> getAllArticles();
    Article getArticleById(Long id);
    Article getArticleByArticlename(String Articlename);
    Article addArticle(Article Article);
    Article updateArticle(Article Article);
    Article deleteArticleById(Long id);
    long getArticlesCount();
}
