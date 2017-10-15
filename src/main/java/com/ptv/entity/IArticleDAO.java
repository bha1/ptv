package com.ptv.entity;

import java.util.List;

public interface IArticleDAO {
    List<Route> getAllArticles();
    Route getArticleById(String articleId);
    void addArticle(Route article);
    void updateArticle(Route article);
    void deleteArticle(String articleId);
}
