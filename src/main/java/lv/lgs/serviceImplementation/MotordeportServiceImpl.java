package lv.lgs.serviceImplementation;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lv.lgs.entity.Motordeport;
import lv.lgs.repository.MotordeportRepository;

@Service
public class MotordeportServiceImpl {
	
	@Autowired
	private MotordeportRepository motordeportReps;

	public Motordeport findById(int id){
		return motordeportReps.findOne(id);
	}
	
	public Iterable<Motordeport> readAllDeports() {
		return motordeportReps.findAll();
	}
	
	public void deleteAll(){
		motordeportReps.deleteAll();
		
	}

}
