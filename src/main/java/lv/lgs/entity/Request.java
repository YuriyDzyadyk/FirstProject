package lv.lgs.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Request {
	
	@Id //каже що поле id буде виконувати роль стовпця id
	@GeneratedValue(strategy=GenerationType.IDENTITY) //вказує яким генератором скористатись при генерації поля id
	private int id; 

 	@ManyToOne //вказує, що поле нижче є відображенням зв`зку багато до одного
 	@JoinColumn //вказує на те що необхідно створити додатковий стовпець, який буде FK до протилежної сторони зв`язку
	private Car car;
 
	@ManyToOne //вказує, що поле нижче є відображенням зв`зку багато до одного
 	@JoinColumn //вказує на те що необхідно створити додатковий стовпець, який буде FK до протилежної сторони зв`язку
	private City from;
	
 	@ManyToOne //вказує, що поле нижче є відображенням зв`зку багато до одного
 	@JoinColumn //вказує на те що необхідно створити додатковий стовпець, який буде FK до протилежної сторони зв`язку
	private City to;


}
