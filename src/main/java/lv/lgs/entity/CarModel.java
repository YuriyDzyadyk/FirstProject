package lv.lgs.entity;

import javax.persistence.*;//������ ������ ��� (��� �� ����������� �� ������ ��� "��������")
import java.util.List;

@Entity //��������������� ��� ����, ��� ��������� Hibernate, �� ���� �����䳺 � ���. 

public class CarModel {



	@Id //���� �� ���� id ���� ���������� ���� ������� id
	@GeneratedValue(strategy=GenerationType.IDENTITY) //����� ���� ����������� ������������ ��� ��������� ���� id
	private int id;
 	@Column( name = "carModel")//���� �� ���� ���� ��������, //�������� "name" ����� �� ���� ���������� �������� � ��
	private String carModel;

	
	//@one to meny -- ���� � ������ ���� �������� ��� �������� �����
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "carModel") //�����, �� ���� � ������������ ��`��� ���� �� ��������
	//� ���� ������� ��`����, � �������� OneToMany, ������ ��������� ������� �������� ���������
	//cascade -- ������������ ��������, ���� ����� �� �������� �� � ������� ���������, ���������, ��������� ��������
	//fetch -- �������� ����`�������, ������� �� ������������ ������ � �� ���� �������� � ������ ���������
	//mappedBy -- ����`�������, ����� �� ������� ����������� �� ��`����, ��������� ������ �� ���� (� ���� �������) ��� ������ �� �������� ��`��� ����� �����
	private List<Car> Cars;

	public CarModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getCarModel() {
		return carModel;
	}

	public void setCarModel(String carModel) {
		this.carModel = carModel;
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
