package com.nadhem.produits.service;

import java.util.List;

import com.nadhem.produits.entities.TypeMatch;
import com.nadhem.produits.entities.Match;

public interface MatchService {
	Match saveMatch(Match p);
	Match updateMatch(Match p);
	void deleteMatch(Match p);
	void deleteMatchById(Long id);
	Match getMatch(Long id);
	List<Match> getAllMatchs();
	List<Match> findByNomEquipes(String nom);
	List<Match> findByNomEquipesContains(String nom);
	List<Match> findByNomProfit (String nom, Double profit);
	List<Match> findByTypeMatch (TypeMatch typeMatch);
	List<Match> findByTypeMatchIdTm(Long id);
	List<Match> findByOrderByNomEquipesAsc();
	List<Match> trierMatchsNomsProfit();

}
