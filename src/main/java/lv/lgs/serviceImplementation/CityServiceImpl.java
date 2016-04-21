package lv.lgs.serviceImplementation;


import lv.lgs.repository.CityRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CityServiceImpl {
	
	@Autowired
	private CityRepository CityReps;


}
