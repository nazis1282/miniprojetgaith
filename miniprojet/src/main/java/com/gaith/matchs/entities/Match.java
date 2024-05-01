package com.nadhem.produits.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Match {	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long idMatch;
	private String nomEquipes;
	private Double Profit;
	private Date dateMatch;
	
	public String getNomEquipes() {
		return nomEquipes;
	}


	public void setNomEquipes(String nomEquipes) {
		this.nomEquipes = nomEquipes;
	}


	public Double getProfit() {
		return Profit;
	}


	public void setProfit(Double profit) {
		this.Profit = profit;
	}


	public Date getDateMatch() {
		return dateMatch;
	}


	public void setDateMatch(Date dateMatch) {
		this.dateMatch = dateMatch;
	}


	@ManyToOne
	private TypeMatch typeMatch;

	public Match() {
		super();
	}
	
	
	public Match(String nomEquipes, Double Profit, Date dateMatch) {
		super();
		this.nomEquipes = nomEquipes;
		this.Profit = Profit;
		this.dateMatch = dateMatch;
	}


	public Long getIdMatch() {
		return idMatch;
	}
	public void setIdMatch(Long idMatch) {
		this.idMatch = idMatch;
	}
	



	@Override
	public String toString() {
		return "Match [idMatch=" + idMatch + ", nomEquipes=" + nomEquipes + ", Profit=" + Profit
				+ ", dateMatch=" + dateMatch + "]";
	}


	public TypeMatch getTypeMatch() {
		return typeMatch;
	}


	public void setTypeMatch(TypeMatch typeMatch) {
		this.typeMatch = typeMatch;
	}
	
	

}
