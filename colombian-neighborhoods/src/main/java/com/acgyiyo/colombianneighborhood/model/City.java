package com.acgyiyo.colombianneighborhood.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.LockModeType;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.Data;

@Entity
@Table(name = "municipios")
// esta propiedad ayuda a que no se genere una referencia circular entre
// departamento y municipio
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@Data
@NamedQuery(name = "City.findCityByName", query = "SELECT e FROM City e where name like CONCAT('%',:name,'%')")
public class City {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  @Column(name = "nombre")
  private String name;

  @JoinColumn(name = "departamento", referencedColumnName = "id")
  @ManyToOne(fetch = FetchType.LAZY)
  // con esta propiedad garantizamos que la serialización no se haga antes de que
  // la carga lazy de hibernate termine
  @JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
  private Department department;

  // en el mappedBy va el nombre del campo en la otra clase no el nombre del campo
  // de la BD
  @OneToMany(fetch = FetchType.LAZY, mappedBy = "city")
  @JsonManagedReference
  private List<Neighborhood> neighborhoodList;
}