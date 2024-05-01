package com.nadhem.produits.repos;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import com.nadhem.produits.entities.TypeMatch;
import com.nadhem.produits.entities.Match;

@RepositoryRestResource(path = "rest")
public interface MatchRepository extends JpaRepository<Match, Long> {
	
	List<Match> findByNomEquipes(String nom);
	List<Match> findByNomEquipesContains(String nom);
	
	/*@Query("select m from Match m where m.NomEquipes like %?1 and m.Profit > ?2")
	List<Match> findByNomProfit (String nom, Double profit);*/
	
	@Query("select m from Match m where m.NomEquipes like %:nom and m.Profit > :profit")
	List<Match> findByNomProfit (@Param("nom") String nom,@Param("profit") Double profit);

	@Query("select m from Match m where m.TypeMatch = ?1")
	List<Match> findByTypeMatch (TypeMatch typematch);
	
	List<Match> findByTypeMatchIdTm(Long id);
	
	List<Match> findByOrderByNomEquipesAsc();
	
	@Query("select m from Match m order by m.NomEquipes ASC, m.Profit DESC")
	List<Match> trierMatchsNomsProfit ();

}
