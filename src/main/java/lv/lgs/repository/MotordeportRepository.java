package lv.lgs.repository;

import lv.lgs.entity.*;
import org.springframework.data.repository.CrudRepository;

public interface MotordeportRepository extends CrudRepository<Motordeport, Integer> {

	Motordeport	findOneByMotordeport(String motordeport);
	
}
