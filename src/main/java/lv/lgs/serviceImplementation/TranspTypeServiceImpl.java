package lv.lgs.serviceImplementation;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lv.lgs.entity.TranspType;
import lv.lgs.repository.TranspTypeRepository;

@Service
public class TranspTypeServiceImpl {
	
	@Autowired
	private TranspTypeRepository transpTypeReps;

	public TranspType findById(int id){
		return transpTypeReps.findOne(id);
	}
	
	public Iterable<TranspType> readAllTtypes() {
		return transpTypeReps.findAll();
	}
	
	public void deleteAll(){
		transpTypeReps.deleteAll();
		
	}

}
