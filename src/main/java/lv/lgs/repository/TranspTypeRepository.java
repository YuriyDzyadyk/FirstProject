package lv.lgs.repository;

import lv.lgs.entity.*;
import org.springframework.data.repository.CrudRepository;

public interface TranspTypeRepository extends CrudRepository<TranspType, Integer>{

	TranspType findByTranspType(String transpType);
	
}
