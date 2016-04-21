package lv.lgs.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity

public class City {
	
	@Id //каже що поле id буде виконувати роль стовпця id
	@GeneratedValue(strategy=GenerationType.IDENTITY) //вказує яким генератором скористатись при генерації поля id
	private int id; 
	@Column( name = "city")//каже що поле буде стовпцем, //параметр "name" вказує як буде називатись стовпець в БД
	private String city;

	//@one to meny -- один зі списку може підходити для багатьох машин
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "from") //вказує, що поле є відображенням зв`зку один до багатьох
	
	//з цієї сторони зв`язку, в анотації OneToMany, завжди необхідно описати додаткові параметри
	//cascade -- опціональний параметр, який вказує на поведінку БД в випадку видалення, оновлення, створення елементів
	//fetch -- зазвичай обов`язковий, оскільки по замовчуванню витягує з БД весь ланцюжок з повною колекцією
	//mappedBy -- обов`язковий, вказує на сторону відповідальну за зв`язок, ссилається завжди на поле (з іншої сторони) яке приймає за параметр об`єкт цього класу
	private List<Request> requestsFrom ;
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "to")
	private List<Request> requestsTo ;
	
	public City() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	public City(String city) {
		super();
		this.city = city;
	}



	public City(int id, String city) {
		super();
		this.id = id;
		this.city = city;
	}


	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<Request> getRequestsFrom() {
		return requestsFrom;
	}

	public void setRequestsFrom(List<Request> requestsFrom) {
		this.requestsFrom = requestsFrom;
	}

	public List<Request> getRequestsTo() {
		return requestsTo;
	}

	public void setRequestsTo(List<Request> requestsTo) {
		this.requestsTo = requestsTo;
	}

	

	
}
