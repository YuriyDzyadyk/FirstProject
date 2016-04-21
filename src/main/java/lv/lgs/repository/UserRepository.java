package lv.lgs.repository;

import lv.lgs.entity.User;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository  extends CrudRepository<User, Integer>{
	
	User findOneByName(String name);

	User findOneByMail(String mail);



}
