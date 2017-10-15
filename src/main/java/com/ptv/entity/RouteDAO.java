package com.ptv.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import org.springframework.stereotype.Repository;

@Transactional
@Repository
public class RouteDAO implements IRouteDAO {
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Route getRouteById(String route_id) {
		return entityManager.find(Route.class, route_id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Route> getAllRoutes() {
		String hql = "FROM Route as route ORDER BY route.route_id";
		return (List<Route>) entityManager.createQuery(hql).getResultList();
	}

	@Override
	public void addRoute(Route route) {
		entityManager.persist(route);
	}
	@Override
	public void addRouteAll(ArrayList<Route> routeList) {
		for (Route route : routeList) {
			entityManager.persist(route);
			entityManager.flush();
			entityManager.clear();
		}
	}

	@Override
	public void updateRoute(Route route) {
		Route artcl = getRouteById(route.getRoute_id());
		artcl.setRoute_name(route.getRoute_name());
		artcl.setRoute_number(route.getRoute_number());
		entityManager.flush();
	}

	@Override
	public void deleteRoute(String route_id) {
		entityManager.remove(getRouteById(route_id));
	}
	// @Override
	// public boolean articleExists(String title, String category) {
	// String hql = "FROM Article as atcl WHERE atcl.title = ? and atcl.category =
	// ?";
	// int count = entityManager.createQuery(hql).setParameter(1, title)
	// .setParameter(2, category).getResultList().size();
	// return count > 0 ? true : false;
	// }

}