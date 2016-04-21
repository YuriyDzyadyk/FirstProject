package lv.lgs.entity;

import javax.persistence.*;

import java.util.List;

@Entity

public class Color {


	@Id //���� �� ���� id ���� ���������� ���� ������� id
	@GeneratedValue(strategy=GenerationType.IDENTITY) //����� ���� ����������� ������������ ��� ��������� ���� id
	private int id; 
 	@Column( name = "color")//���� �� ���� ���� ��������, //�������� "name" ����� �� ���� ���������� �������� � ��
	private String color;
	
	//@one to meny -- ���� � ������ ���� �������� ��� �������� �����
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "color") //�����, �� ���� � ������������ ��`��� ���� �� ��������
	//� ���� ������� ��`����, � �������� OneToMany, ������ ��������� ������� �������� ���������
	//cascade -- ������������ ��������, ���� ����� �� �������� �� � ������� ���������, ���������, ��������� ��������
	//fetch -- �������� ����`�������, ������� �� ������������ ������ � �� ���� �������� � ������ ���������
	//mappedBy -- ����`�������, ����� �� ������� ����������� �� ��`����, ��������� ������ �� ���� (� ���� �������) ��� ������ �� �������� ��`��� ����� �����

	private List<Car> Cars;

	public Color() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	public Color(String color) {
		super();
		this.color = color;
	}


	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
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
