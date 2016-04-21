package lv.lgs.repository;

import lv.lgs.entity.*;

import org.springframework.data.repository.CrudRepository;

public interface ColorRepository extends CrudRepository<Color, Integer> {

	//квері яка шукає чи є колір під іменем color
Color findOneByColor(String color);

		  
	}
	
	

