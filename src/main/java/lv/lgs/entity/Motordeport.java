package lv.lgs.entity;

import javax.persistence.*;
import java.util.List;

@Entity

public class Motordeport {


	@Id //каже що поле id буде виконувати роль стовпця id
	@GeneratedValue(strategy=GenerationType.IDENTITY) //вказує яким генератором скористатись при генерації поля id
	private int id;
 	@Column( name = "motordeport")//каже що поле буде стовпцем, //параметр "name" вказує як буде називатись стовпець в БД
	private String motordeport;
	
	//@one to meny -- один зі списку може підходити для багатьох машин
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "motordeport") //вказує, що поле є відображенням зв`зку один до багатьох
	//з цієї сторони зв`язку, в анотації OneToMany, завжди необхідно описати додаткові параметри
	//cascade -- опціональний параметр, який вказує на поведінку БД в випадку видалення, оновлення, створення елементів
	//fetch -- зазвичай обов`язковий, оскільки по замовчуванню витягує з БД весь ланцюжок з повною колекцією
	//mappedBy -- обов`язковий, вказує на сторону відповідальну за зв`язок, ссилається завжди на поле (з іншої сторони) яке приймає за параметр об`єкт цього класу

	private List<Car> Cars;

	public Motordeport() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	public Motordeport(String motordeport) {
		super();
		this.motordeport = motordeport;
	}



	public String getMotordeport() {
		return motordeport;
	}

	public void setMotordeport(String motordeport) {
		this.motordeport = motordeport;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<Car> getCars() {
		return Cars;
	}

	public void setCars(List<Car> cars) {
		Cars = cars;
	}
	
	

	
	
}
