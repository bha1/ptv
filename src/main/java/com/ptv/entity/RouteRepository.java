package com.ptv.entity;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ptv.entity.Route;

@Repository
public interface RouteRepository extends CrudRepository<Route, String>{




}
