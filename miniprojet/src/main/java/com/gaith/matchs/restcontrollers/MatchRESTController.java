package com.nadhem.produits.restcontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.nadhem.produits.entities.Match;
import com.nadhem.produits.service.MatchService;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class MatchRESTController {
	
	@Autowired
	MatchService matchService;
	
	@RequestMapping(method=RequestMethod.GET)
	public List<Match> getAllMatchs()
	{
		return matchService.getAllMatchs();
	}
	
	@RequestMapping(value="/{id}",method = RequestMethod.GET)
	public Match getMatchById(@PathVariable("id") Long id) {
		return matchService.getMatch(id);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public Match createMatch(@RequestBody Match match) {
			return matchService.saveMatch(match);
	}
	
	@RequestMapping(method = RequestMethod.PUT)
	public Match updateMatch(@RequestBody Match match) {
		return matchService.updateMatch(match);
	}
	
	@RequestMapping(value="/{id}",method = RequestMethod.DELETE)
	public void deleteMatch(@PathVariable("id") Long id)
	{
			matchService.deleteMatchById(id);
	}
	
	@RequestMapping(value="/matstm/{idTm}",method = RequestMethod.GET)
	public List<Match> getMatchsByTmId(@PathVariable("idTm") Long idTm) {
		return matchService.findByTypeMatchIdTm(idTm);
	}

	
	
	


}
