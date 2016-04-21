package lv.lgs.entity;


import java.util.List;

import javax.persistence.*;
@Entity

public class Car {
		@Id //���� �� ���� id ���� ���������� ���� ������� id
	@GeneratedValue(strategy=GenerationType.IDENTITY) //����� ���� ����������� ������������ ��� ��������� ���� id

	private int id;
	
	
	//@many to one --������ ����� ������ ���� ���� � ��� ����� ��� ����
	
	
 	@ManyToOne //�����, �� ���� ����� � ������������ ��`��� ������ �� ������
 	@JoinColumn //����� �� �� �� ��������� �������� ���������� ��������, ���� ���� FK �� ���������� ������� ��`����
 	private Color color;
 	@ManyToOne //�����, �� ���� ����� � ������������ ��`��� ������ �� ������
 	@JoinColumn //����� �� �� �� ��������� �������� ���������� ��������, ���� ���� FK �� ���������� ������� ��`����
	private TranspType transpType;
 	@ManyToOne //�����, �� ���� ����� � ������������ ��`��� ������ �� ������
 	@JoinColumn //����� �� �� �� ��������� �������� ���������� ��������, ���� ���� FK �� ���������� ������� ��`����
 	private CarModel carModel;
 	@ManyToOne //�����, �� ���� ����� � ������������ ��`��� ������ �� ������
 	@JoinColumn //����� �� �� �� ��������� �������� ���������� ��������, ���� ���� FK �� ���������� ������� ��`����
 	private Motordeport motordeport;
 
 	
	//@one to meny -- ����-��� ������ ���� �������� �� ������???
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "car") //�����, �� ���� � ������������ ��`��� ���� �� ��������
	//� ���� ������� ��`����, � �������� OneToMany, ������ ��������� ������� �������� ���������
	//cascade -- ������������ ��������, ���� ����� �� �������� �� � ������� ���������, ���������, ��������� ��������
	//fetch -- �������� ����`�������, ������� �� ������������ ������ � �� ���� �������� � ������ ���������
	//mappedBy -- ����`�������, ����� �� ������� ����������� �� ��`����, ��������� ������ �� ���� (� ���� �������) ��� ������ �� �������� ��`��� ����� �����
	private List<Request> requests ;
 	
 	
 	
	@Column( name = "loadCapisity")//���� �� ���� ���� ��������, //�������� "name" ����� �� ���� ���������� �������� � ��
 	private int loadCapisity;
 	@Column( name = "seatsCount")//���� �� ���� ���� ��������, //�������� "name" ����� �� ���� ���������� �������� � ��
 	private int seatsCount;
 	@Column( name = "regNumber")//���� �� ���� ���� ��������, //�������� "name" ����� �� ���� ���������� �������� � ��
 	private String regNumber;
 	@Column( name = "outputYear")//���� �� ���� ���� ��������, //�������� "name" ����� �� ���� ���������� �������� � ��
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
