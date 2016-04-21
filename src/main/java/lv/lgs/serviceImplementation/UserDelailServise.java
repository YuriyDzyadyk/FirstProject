package lv.lgs.serviceImplementation;

import java.util.ArrayList;
import java.util.Collection;

import lv.lgs.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
@Service("userDetailsService")
public class UserDelailServise implements UserDetailsService {

	@Autowired
	UserRepository userRepository;
	//далі треба накодити  метод на створення/збереження юзера, ввід його з jsp, валідація, перевірка паролів тощо....
	public void saveUser(){
		//далі треба накодити  метод на створення/збереження юзера, ввід його з jsp, валідація тощо....	
		
	}
	
	//відкриває юзеру його роль
	public UserDetails loadUserByUsername(String arg0) //приходить логін
			throws UsernameNotFoundException {
		// TODO Auto-generated method stub
			
		
		lv.lgs.entity.User username = userRepository.findOneByName(arg0);
		if(username!=null){		
			username = userRepository.findOneByMail(arg0); //якщо не знаходить логін, шукає по мейлу
		}else{
			return null;
		}
		
		Collection<SimpleGrantedAuthority> rolles = new ArrayList<SimpleGrantedAuthority>();
		rolles.add(new SimpleGrantedAuthority(username.getRolle().toString()));
		
		User user= new User(String.valueOf(username.getId()), username.getPassword(), rolles); //id - user-a, password з бази, authorities - роль
		return user;
	}

}
