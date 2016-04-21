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
	//��� ����� ��������  ����� �� ���������/���������� �����, ��� ���� � jsp, ��������, �������� ������ ����....
	public void saveUser(){
		//��� ����� ��������  ����� �� ���������/���������� �����, ��� ���� � jsp, �������� ����....	
		
	}
	
	//������� ����� ���� ����
	public UserDetails loadUserByUsername(String arg0) //��������� ����
			throws UsernameNotFoundException {
		// TODO Auto-generated method stub
			
		
		lv.lgs.entity.User username = userRepository.findOneByName(arg0);
		if(username!=null){		
			username = userRepository.findOneByMail(arg0); //���� �� ��������� ����, ���� �� �����
		}else{
			return null;
		}
		
		Collection<SimpleGrantedAuthority> rolles = new ArrayList<SimpleGrantedAuthority>();
		rolles.add(new SimpleGrantedAuthority(username.getRolle().toString()));
		
		User user= new User(String.valueOf(username.getId()), username.getPassword(), rolles); //id - user-a, password � ����, authorities - ����
		return user;
	}

}
