package com.ptv.entity;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

@Transactional
@Repository
public class DirectionDOA implements IDirectionDOA {
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Direction getDirectionByRouteId(String route_id) {
		String hql = "FROM Direction as direction WHERE direction.route_id = :route_id";
		return (Direction) entityManager.createQuery(hql).setParameter("route_id", route_id).getResultList().get(0);
	}
	
	@Override
	public void addDirectionAll(ArrayList<Direction> directionList) {
		for (Direction direction : directionList) {
			entityManager.persist(direction);
			entityManager.flush();
			entityManager.clear();
		}
	}
}
