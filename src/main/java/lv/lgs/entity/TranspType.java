package lv.lgs.entity;

import javax.persistence.*;
import java.util.List;

@Entity

public class TranspType {

	@Id //каже що поле id буде виконувати роль стовпця id
	@GeneratedValue(strategy=GenerationType.IDENTITY) //вказує яким генератором скористатись при генерації поля id
	private int id; 
 	@Column( name = "transpType")//каже що поле буде стовпцем, //параметр "name" вказує як буде називатись стовпець в БД
	private String transpType;

	//@one to meny -- один зі списку може підходити для багатьох машин
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "transpType") //вказує, що поле є відображенням зв`зку один до багатьох
	//з цієї сторони зв`язку, в анотації OneToMany, завжди необхідно описати додаткові параметри
	//cascade -- опціональний параметр, який вказує на поведінку БД в випадку видалення, оновлення, створення елементів
	//fetch -- зазвичай обов`язковий, оскільки по замовчуванню витягує з БД весь ланцюжок з повною колекцією
	//mappedBy -- обов`язковий, вказує на сторону відповідальну за зв`язок, ссилається завжди на поле (з іншої сторони) яке приймає за параметр об`єкт цього класу

	private List<Car> Cars;

	public TranspType() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	public TranspType(String transpType) {
		super();
		this.transpType = transpType;
	}



	public String getTranspType() {
		return transpType;
	}



	public void setTranspType(String transpType) {
		this.transpType = transpType;
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
