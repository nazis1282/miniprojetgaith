package com.nadhem.produits.entities;

import org.springframework.data.rest.core.config.Projection;

@Projection(name = "nomMat", types = { Match.class })
public interface MatchProjection {
	public String getNomEquipes();

}
