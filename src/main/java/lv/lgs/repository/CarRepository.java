package lv.lgs.repository;

import lv.lgs.entity.*;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface CarRepository extends CrudRepository<Car, Integer>  {

	Car findOneByLoadCapisity(int loadCapisity);
	Car findOneBySeatsCount(int seatsCount);
	Car findOneByRegNumber(String regNumber);
	Car findOneByOutputYear(int outputYear);
	
}
