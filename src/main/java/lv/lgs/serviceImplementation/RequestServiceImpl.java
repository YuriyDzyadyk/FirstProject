package lv.lgs.serviceImplementation;


import lv.lgs.repository.RequestRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RequestServiceImpl  {
	
	@Autowired
	private RequestRepository requestReps;


}
