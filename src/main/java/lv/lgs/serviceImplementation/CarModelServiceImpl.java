package lv.lgs.serviceImplementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lv.lgs.entity.CarModel;
import lv.lgs.repository.CarModelRepository;

@Service
public class CarModelServiceImpl {
	
	@Autowired
	private CarModelRepository carModelReps;
	//!!!! ??? щоб залишившись пустим видавало список значень
	public CarModel findById(int id){
		if (id!=0){
		return carModelReps.findOne(id);
		}else{
		return null;
		}
		
	}
	
	public Iterable<CarModel> readAllCarModels() {
		return carModelReps.findAll();
	}
	
	public void deleteAll(){
		carModelReps.deleteAll();
		
	}

}
