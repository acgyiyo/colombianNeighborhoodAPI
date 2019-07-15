package com.acgyiyo.colombianneighborhood.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.Data;

@Entity
@Table(name = "barrios")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@NamedQuery(name = "Neighborhood.findNeighborhoodByName", query = "SELECT e FROM Neighborhood e where name like CONCAT('%',:name,'%')")
@Data
public class Neighborhood {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  @Column(name = "id_alcaldia")
  private String idTownHall;

  @Column(name = "comuna")
  private Integer commune;

  @Column(name = "nombre")
  private String name;

    
  // con esta propiedad garantizamos que la serialización no se haga antes de que
  // la carga lazy de hibernate termine
  @JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
  @JoinColumn(name = "municipio", referencedColumnName = "id")
  @ManyToOne(fetch = FetchType.LAZY)
  private City city;
}