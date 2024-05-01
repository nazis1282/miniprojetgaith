package com.nadhem.produits.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nadhem.produits.entities.TypeMatch;
import com.nadhem.produits.entities.Match;
import com.nadhem.produits.repos.MatchRepository;


@Service
public class MatchServiceImpl implements MatchService{

	@Autowired
	MatchRepository matchRepository;
	
	@Override
	public Match saveMatch(Match p) {
		return matchRepository.save(p);
	}

	@Override
	public Match updateMatch(Match p) {
		return matchRepository.save(p);
	}

	@Override
	public void deleteMatch(Match p) {
		matchRepository.delete(p);
		
	}

	@Override
	public void deleteMatchById(Long id) {
		matchRepository.deleteById(id);
		
	}

	@Override
	public Match getMatch(Long id) {
		return matchRepository.findById(id).get();
	}

	@Override
	public List<Match> getAllMatchs() {
		
		return matchRepository.findAll();
	}

	@Override
	public List<Match> findByNomEquipes(String nom) {
		
		return matchRepository.findByNomEquipes(nom);
	}

	@Override
	public List<Match> findByNomEquipesContains(String nom) {
		
		return matchRepository.findByNomEquipesContains(nom);
	}

	@Override
	public List<Match> findByNomProfit(String nom, Double prix) {
		return matchRepository.findByNomProfit(nom,prix);
	}

	@Override
	public List<Match> findByTypeMatch(TypeMatch typeMatch) {
		
		return matchRepository.findByTypeMatch(typeMatch);
	}

	@Override
	public List<Match> findByTypeMatchIdTm(Long id) {
	
		return matchRepository.findByTypeMatchIdTm(id);
	}

	@Override
	public List<Match> findByOrderByNomEquipesAsc() {
		
		return matchRepository.findByOrderByNomEquipesAsc();
	}

	@Override
	public List<Match> trierMatchsNomsProfit() {
	
		return matchRepository.trierMatchsNomsProfit();
	}
	
	

}
