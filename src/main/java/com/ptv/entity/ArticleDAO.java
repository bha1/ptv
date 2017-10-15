package com.ptv.entity;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import org.springframework.stereotype.Repository;

@Transactional
@Repository
public class ArticleDAO implements IArticleDAO {
	@PersistenceContext	
	private EntityManager entityManager;	
	@Override
	public Route getArticleById(String articleId) {
		return entityManager.find(Route.class, articleId);
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Route> getAllArticles() {
		String hql = "FROM Article as atcl ORDER BY atcl.articleId";
		return (List<Route>) entityManager.createQuery(hql).getResultList();
	}	
	@Override
	public void addArticle(Route article) {
		entityManager.persist(article);
	}
	@Override
	public void updateArticle(Route article) {
		Route artcl = getArticleById(article.getRoute_id());
		artcl.setRoute_name(article.getRoute_name());
		artcl.setRoute_number(article.getRoute_number());
		entityManager.flush();
	}
	@Override
	public void deleteArticle(String articleId) {
		entityManager.remove(getArticleById(articleId));
	}
//	@Override
//	public boolean articleExists(String title, String category) {
//		String hql = "FROM Article as atcl WHERE atcl.title = ? and atcl.category = ?";
//		int count = entityManager.createQuery(hql).setParameter(1, title)
//		              .setParameter(2, category).getResultList().size();
//		return count > 0 ? true : false;
//	}

} 