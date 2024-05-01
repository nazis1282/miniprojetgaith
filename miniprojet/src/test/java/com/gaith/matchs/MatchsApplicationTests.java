package com.nadhem.produits;



import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.nadhem.produits.entities.TypeMatch;
import com.nadhem.produits.entities.Match;
import com.nadhem.produits.repos.MatchRepository;


@SpringBootTest
class MatchsApplicationTests {

	@Autowired
	private MatchRepository matchRepository;
	
	@Test
	public void testCreateMatch() {
	Match mat = new Match("Barca vs real ",1500.500,new Date());
	matchRepository.save(mat);
	}
	
	@Test
	public void testFindMatch()
	{
	Match m = matchRepository.findById(1L).get();
	System.out.println(m);
	}
	
	@Test
	public void testUpdateMatch()
	{
	Match m = matchRepository.findById(1L).get();
	m.setProfit(2000.0);
	matchRepository.save(m);
	
	System.out.println(m);
	}
	
	@Test
	public void testDeleteMatch()
	{
		matchRepository.deleteById(1L);
	}
	
	@Test
	public void testFindAllMatchs()
	{
		List<Match> mats = matchRepository.findAll();
		
		for (Match m:mats)
			 System.out.println(m);
		
	}
	
	
	@Test
	public void testFindMatchByNom()
	{
	List<Match> mats = matchRepository.findByNomEquipes("barca");
	
	for (Match m:mats)
		 System.out.println(m);
	
	}
	
	@Test
	public void testFindMatchByNomContains()
	{
	List<Match> mats = matchRepository.findByNomEquipesContains("P");
	
	for (Match m:mats)
		 System.out.println(m);
	
	}
	
	@Test
	public void testfindByNomProfit()
	{
	List<Match> mats = matchRepository.findByNomProfit("PS 4", 1000.0);
		for (Match m : mats)
			{
				System.out.println(m);
			}
	}
	
	
	@Test
	public void testfindByTypeMatch()
	{
	TypeMatch cat = new TypeMatch();
	cat.setIdTm(1L);
	
	List<Match> mats = matchRepository.findByTypeMatch(cat);
	for (Match p : mats)
	{
		System.out.println(p);
	}
	}
	
	@Test
	public void findByTypeMatchIdTm()
	{
	List<Match> mats = matchRepository.findByTypeMatchIdTm(1L);
	for (Match m : mats)
	{
		System.out.println(m);
	}
	}
	
	
	@Test
	public void testfindByOrderByomEquipesAsc()
	{
	List<Match> mats =  matchRepository.findByOrderByNomEquipesAsc();
	for (Match m : mats)
		{
			System.out.println(m);
		}
	}
	
	@Test
	public void testTrierMatchsNomsProfit()
	{
	List<Match> mats = matchRepository.trierMatchsNomsProfit();
	for (Match m : mats)
	{
	System.out.println(m);
	}
	}
	
	
}
