package course.spring.web;

import course.spring.domain.ArticleService;
import course.spring.exception.InvalidEntityDataException;
import course.spring.model.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/api/Articles")
public class ArticleRestController {
    @Autowired
    private ArticleService ArticleService;

    @GetMapping
    public List<Article> getAllArticles() {
        return ArticleService.getAllArticles();
    }

//    @GetMapping("{id}")
//    public ResponseEntity<Article> getArticleById(@PathVariable("id") Long id) {
//        var result = ArticleRepo.findById(id);
//        if(result.isPresent()) {
//            return ResponseEntity.ok(ArticleRepo.findById(id).get());
//        } else {
//            return ResponseEntity.notFound().build();
//        }
//    }

    @GetMapping("count")
    public long getArticlesCount() {
        return ArticleService.getArticlesCount();
    }

    @GetMapping("{id:\\d+}")
    public Article getArticleById(@PathVariable("id") Long id) {
        return ArticleService.getArticleById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Article> addArticle(@RequestBody Article Article) {
        var newArticle = ArticleService.addArticle(Article);
        return ResponseEntity.created(
                ServletUriComponentsBuilder.fromCurrentRequestUri().pathSegment("{id}")
                        .buildAndExpand(newArticle.getId()).toUri()
        ).body(newArticle);
    }

    @PutMapping("{id}")
    public Article updateArticle(@PathVariable("id") Long id, @RequestBody Article Article) {
        if(!id.equals(Article.getId())) {
            throw new InvalidEntityDataException(
                    String.format("Non-matching IDs in path '%s' and in request body '%s'.", id, Article.getId())
            );
        }
        return ArticleService.updateArticle(Article);
    }

    @DeleteMapping("{id}")
    public Article updateArticle(@PathVariable("id") Long id) {
        return ArticleService.deleteArticleById(id);
    }


}
