package com.nadhem.produits.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class TypeMatch {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long idTm;
	
	private String nomTm;
	
	
	@OneToMany (mappedBy = "typeMatch")
	@JsonIgnore
	private List<Match> matches;
	
	
}
