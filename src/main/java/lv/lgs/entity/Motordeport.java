package lv.lgs.entity;

import javax.persistence.*;
import java.util.List;

@Entity

public class Motordeport {


	@Id //���� �� ���� id ���� ���������� ���� ������� id
	@GeneratedValue(strategy=GenerationType.IDENTITY) //����� ���� ����������� ������������ ��� ��������� ���� id
	private int id;
 	@Column( name = "motordeport")//���� �� ���� ���� ��������, //�������� "name" ����� �� ���� ���������� �������� � ��
	private String motordeport;
	
	//@one to meny -- ���� � ������ ���� �������� ��� �������� �����
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "motordeport") //�����, �� ���� � ������������ ��`��� ���� �� ��������
	//� ���� ������� ��`����, � �������� OneToMany, ������ ��������� ������� �������� ���������
	//cascade -- ������������ ��������, ���� ����� �� �������� �� � ������� ���������, ���������, ��������� ��������
	//fetch -- �������� ����`�������, ������� �� ������������ ������ � �� ���� �������� � ������ ���������
	//mappedBy -- ����`�������, ����� �� ������� ����������� �� ��`����, ��������� ������ �� ���� (� ���� �������) ��� ������ �� �������� ��`��� ����� �����

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
