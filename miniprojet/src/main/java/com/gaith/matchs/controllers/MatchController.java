package com.nadhem.produits.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.nadhem.produits.entities.Match;
import com.nadhem.produits.service.MatchService;

@Controller
public class MatchController {
	
	
	@Autowired
	MatchService matchService;
	
	@RequestMapping("/showCreate")
	public String showCreate()
	{
	return "createMatch";
	}
	
	@RequestMapping("/saveMatch")
	public String saveMatch(@ModelAttribute("match") Match match,
							  @RequestParam("date") String date,
	                          ModelMap modelMap) throws 	ParseException
	{
	//conversion de la date
	SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
	Date DateMatch = dateformat.parse(String.valueOf(date));
	match.setDateMatch(DateMatch);
	
	Match saveMatch = matchService.saveMatch(match);
	String msg ="match enregistré avec Id "+saveMatch.getIdMatch();
	modelMap.addAttribute("msg", msg);
	return "createMatch";
	}
	
	@RequestMapping("/ListeMatchs")
	public String listeMatchs(ModelMap modelMap)
	{
		List<Match> mats = matchService.getAllMatchs();
		modelMap.addAttribute("matchs", mats);
		return "listeMatchs";
	}
	
	@RequestMapping("/supprimerMatch")
	public String supprimerMatch(@RequestParam("id") Long id,
	ModelMap modelMap)
	{
		matchService.deleteMatchById(id);
		List<Match> mats = matchService.getAllMatchs();
		modelMap.addAttribute("matchs", mats);
	return "listeMatchs";
	}
	
	@RequestMapping("/modifierMatch")
	public String editerMatch(@RequestParam("id") Long id,ModelMap modelMap)
	{
	Match p= matchService.getMatch(id);
	modelMap.addAttribute("match", p);
	return "editerMatch";
	}
	
	@RequestMapping("/updateMatch")
	public String updateMatch(@ModelAttribute("match") Match match,
	@RequestParam("date") String date,
	ModelMap modelMap) throws ParseException
	{
	//conversion de la date
	SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
	Date DateMatch = dateformat.parse(String.valueOf(date));
	match.setDateMatch(DateMatch);
	matchService.updateMatch(match);
	List<Match> mats = matchService.getAllMatchs();
	modelMap.addAttribute("matchs", mats);
	return "listeMatchs";
	}
	


}
