package lv.lgs.serviceImplementation;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lv.lgs.entity.Color;
import lv.lgs.repository.ColorRepository;

@Service
public class ColorServiceImpl {
	
	@Autowired //new ColorRepository
	private ColorRepository colorReps;


	public Color findById(int id){
		return colorReps.findOne(id);
	}
	
	public Iterable<Color> readAllColors() {
		return colorReps.findAll();
	}
	
	public void deleteAll(){
		colorReps.deleteAll();
		
	}
		  
	}
	
	

