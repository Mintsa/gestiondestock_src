package com.bouali.gestiondestock.repository;

import com.bouali.gestiondestock.dto.ArticleDto;
import com.bouali.gestiondestock.model.Article;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ArticleRepository extends JpaRepository<Article, Integer> {

  Optional<Article> findArticleByCodeArticle(String codeArticle);

  List<Article> findAllByCategoryId(Integer idCategory);

  @Query("SELECT art FROM Article  as art  JOIN art.mvtStks  mvt"
          +" WHERE art.id = mvt.article.id and mvt.article is not null")
  List<Article> findAllArticleWithMvtStock();
}
