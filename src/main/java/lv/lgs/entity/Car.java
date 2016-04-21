package lv.lgs.entity;


import java.util.List;

import javax.persistence.*;
@Entity

public class Car {
		@Id //каже що поле id буде виконувати роль стовпця id
	@GeneratedValue(strategy=GenerationType.IDENTITY) //вказує яким генератором скористатись при генерації поля id

	private int id;
	
	
	//@many to one --багато машин можуть мати один і той самий тип тощо
	
	
 	@ManyToOne //вказує, що поле нижче є відображенням зв`зку багато до одного
 	@JoinColumn //вказує на те що необхідно створити додатковий стовпець, який буде FK до протилежної сторони зв`язку
 	private Color color;
 	@ManyToOne //вказує, що поле нижче є відображенням зв`зку багато до одного
 	@JoinColumn //вказує на те що необхідно створити додатковий стовпець, який буде FK до протилежної сторони зв`язку
	private TranspType transpType;
 	@ManyToOne //вказує, що поле нижче є відображенням зв`зку багато до одного
 	@JoinColumn //вказує на те що необхідно створити додатковий стовпець, який буде FK до протилежної сторони зв`язку
 	private CarModel carModel;
 	@ManyToOne //вказує, що поле нижче є відображенням зв`зку багато до одного
 	@JoinColumn //вказує на те що необхідно створити додатковий стовпець, який буде FK до протилежної сторони зв`язку
 	private Motordeport motordeport;
 
 	
	//@one to meny -- будь-яка машина може підходити до запиту???
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "car") //вказує, що поле є відображенням зв`зку один до багатьох
	//з цієї сторони зв`язку, в анотації OneToMany, завжди необхідно описати додаткові параметри
	//cascade -- опціональний параметр, який вказує на поведінку БД в випадку видалення, оновлення, створення елементів
	//fetch -- зазвичай обов`язковий, оскільки по замовчуванню витягує з БД весь ланцюжок з повною колекцією
	//mappedBy -- обов`язковий, вказує на сторону відповідальну за зв`язок, ссилається завжди на поле (з іншої сторони) яке приймає за параметр об`єкт цього класу
	private List<Request> requests ;
 	
 	
 	
	@Column( name = "loadCapisity")//каже що поле буде стовпцем, //параметр "name" вказує як буде називатись стовпець в БД
 	private int loadCapisity;
 	@Column( name = "seatsCount")//каже що поле буде стовпцем, //параметр "name" вказує як буде називатись стовпець в БД
 	private int seatsCount;
 	@Column( name = "regNumber")//каже що поле буде стовпцем, //параметр "name" вказує як буде називатись стовпець в БД
 	private String regNumber;
 	@Column( name = "outputYear")//каже що поле буде стовпцем, //параметр "name" вказує як буде називатись стовпець в БД
 	private int outputYear;
	
 	
 	
 	
 	public Car() {
		super();
	}
 	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Color getColor() {
		return color;
	}
	public void setColor(Color color) {
		this.color = color;
	}
	public TranspType getTranspType() {
		return transpType;
	}
	public void setTranspType(TranspType transpType) {
		this.transpType = transpType;
	}
	public CarModel getCarModel() {
		return carModel;
	}
	public void setCarModel(CarModel carModel) {
		this.carModel = carModel;
	}
	public Motordeport getMotordeport() {
		return motordeport;
	}
	public void setMotordeport(Motordeport motordeport) {
		this.motordeport = motordeport;
	}
	public List<Request> getRequests() {
		return requests;
	}
	public void setRequests(List<Request> requests) {
		this.requests = requests;
	}
	public int getLoadCapisity() {
		return loadCapisity;
	}
	public void setLoadCapisity(int loadCapisity) {
		this.loadCapisity = loadCapisity;
	}
	public int getSeatsCount() {
		return seatsCount;
	}
	public void setSeatsCount(int seatsCount) {
		this.seatsCount = seatsCount;
	}
	public String getRegNumber() {
		return regNumber;
	}
	public void setRegNumber(String regNumber) {
		this.regNumber = regNumber;
	}
	public int getOutputYear() {
		return outputYear;
	}
	public void setOutputYear(int outputYear) {
		this.outputYear = outputYear;
	}


}
