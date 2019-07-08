package com.acgyiyo.colombianneighborhood.repository;

import java.util.List;

import com.acgyiyo.colombianneighborhood.model.Neighborhood;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

public interface NeighborhoodRepository extends JpaRepository<Neighborhood,Integer> {

  List<Neighborhood> findNeighborhoodByName(@Param("name") String name);
}