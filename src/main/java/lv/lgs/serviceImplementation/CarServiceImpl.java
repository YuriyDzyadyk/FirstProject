package lv.lgs.serviceImplementation;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lv.lgs.entity.Car;
import lv.lgs.entity.CarModel;
import lv.lgs.entity.Color;
import lv.lgs.entity.Motordeport;
import lv.lgs.entity.TranspType;
import lv.lgs.repository.CarModelRepository;
import lv.lgs.repository.CarRepository;
import lv.lgs.repository.ColorRepository;
import lv.lgs.repository.MotordeportRepository;
import lv.lgs.repository.TranspTypeRepository;

@Service
public class CarServiceImpl {
	
	
	@Autowired
	private CarModelRepository carModelReps;
	@Autowired
	private TranspTypeRepository transpTypeReps;
	@Autowired
	private MotordeportRepository motordeportReps;
	@Autowired
	private ColorRepository colorReps;
	@Autowired
	private CarRepository carReps;
	
	//�� �� ����������� ���
	//����� ���� ������� ������ � ����
	public String createUpdataCar(int id, String carModelInput,String transpTypeInput, String motordepotInput, String capTInput,String seatsCountInput,String regNumberInput,String outputYearInput,String colorInput) {
		//��������� ��������� �����
				
			//	��������� � ��� CarModel carModel = new CarModel();
		//����� �� � � ���
		CarModel carModel = carModelReps.findOneByCarModel(carModelInput);
				TranspType transpType = transpTypeReps.findByTranspType(transpTypeInput);
				Motordeport motordeport = motordeportReps.findOneByMotordeport(motordepotInput);
				Color color = colorReps.findOneByColor(colorInput);
				//���� � ��� ����
				//���������� � ��������� ������ ��������
				if(carModel==null){
					carModel = new CarModel();
					carModel.setCarModel(carModelInput);
					carModelReps.save(carModel);
				}
				if(transpType==null){
					transpType = new TranspType();
				transpType.setTranspType(transpTypeInput);
				transpTypeReps.save(transpType);
				}
				
				if(motordeport==null){
					motordeport = new Motordeport();
					motordeport.setMotordeport(motordepotInput);
					motordeportReps.save(motordeport);
				}
				if(color == null){
					color = new Color();
					color.setColor(colorInput);
					colorReps.save(color);
					}
				if(id == 0){
		//������ �� � ���� �����
				// �� ��������� ���������� ��� � ������ Integer.parseInt
				Car newCar = new Car();
				newCar.setCarModel(carModel);
				newCar.setTranspType(transpType);
				newCar.setMotordeport(motordeport);
				newCar.setColor(color);
				//????? ��� �� ���������� ������� ��������� ������� -- �������� ����� ������� !!!!

	newCar.setLoadCapisity(Integer.parseInt(capTInput));
				
					newCar.setSeatsCount(Integer.parseInt(seatsCountInput));
					// !!!!!  ���� ����� ����� ���� ��� ������ ����������� --��������
					Car carRegN = carReps.findOneByRegNumber(regNumberInput);
					if(carRegN!=null){
						return "redirect:/sitemap?wrongnumber=true";
					
					}else{
						newCar.setRegNumber(regNumberInput);
					}

					newCar.setOutputYear(Integer.parseInt(outputYearInput));

				
				carReps.save(newCar);
}else{
		
	Car updateCar = carReps.findOne(id);
			
			updateCar.setCarModel(carModel);
			updateCar.setTranspType(transpType);
			updateCar.setMotordeport(motordeport);
			updateCar.setLoadCapisity(Integer.parseInt(capTInput));
			updateCar.setSeatsCount(Integer.parseInt(seatsCountInput));
			updateCar.setRegNumber(regNumberInput);
			updateCar.setOutputYear(Integer.parseInt(outputYearInput));
			updateCar.setColor(color);
			carReps.save(updateCar);
	
}
				return null;	
				
	}
//�������� �� ������
	public Iterable<Car> readAll() {
		return carReps.findAll();
	}
//������� �� ������
	public void deleteAll(){
		carReps.deleteAll();
		
	}


public List<Car> findBy(String regNumberInput){
	//	Car car = new Car();
//	if(car.getColor().equals(colorInput)){
//	int cId= car.getColor().getId();
//	return carReps.findOne(cId);
//	}
	return null;
	}
//public List<Car> findByRegNum(String regNumberInput){
//List<Car> car = carReps.findByregNumber(regNumberInput);
//return car;
//}
/*
public void update(String id, String colorInput) {
	// TODO Auto-generated method stub
	Car car = carReps.findOne(Integer.parseInt(id));
	Color color = new Color();
	color.setColor(colorInput);
//�� ����� ��������� ���� �� �������� --��� ���� �����? ������� ������ �� ����� ��� � ����� �������?
	colorReps.save(color);
	car.setColor(color);
	carReps.save(car);


}*/

public void delete(String id) {
	// TODO Auto-generated method stub
	carReps.delete(Integer.parseInt(id));
}

public Car findById(String id){
	return carReps.findOne(Integer.parseInt(id));
}


}
