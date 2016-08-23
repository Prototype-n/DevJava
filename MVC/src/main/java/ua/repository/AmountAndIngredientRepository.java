package ua.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ua.entity.AmountAndIngredient;

public interface AmountAndIngredientRepository extends JpaRepository<AmountAndIngredient, Integer>, JpaSpecificationExecutor<AmountAndIngredient>{

	@Query(value="SELECT ai FROM AmountAndIngredient ai LEFT JOIN FETCH "
			+ "ai.measuringSystem LEFT JOIN FETCH ai.ingredient"
			/*countQuery="SELECT count(ai.id) FROM AmountAndIngredient ai"*/)
	List<AmountAndIngredient> findAll();
	
	@Query("SELECT ai FROM AmountAndIngredient ai LEFT JOIN FETCH "
			+ "ai.measuringSystem LEFT JOIN FETCH ai.ingredient "
			+ "WHERE ai.id=:id")
	AmountAndIngredient findOneIngredientMsInited(@Param("id") int id);
}
