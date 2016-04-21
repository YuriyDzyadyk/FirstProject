package lv.lgs.repository;

import lv.lgs.entity.*;
import org.springframework.data.repository.CrudRepository;

public interface CarModelRepository extends CrudRepository<CarModel, Integer> {

	CarModel findOneByCarModel(String carModel);
	
}
