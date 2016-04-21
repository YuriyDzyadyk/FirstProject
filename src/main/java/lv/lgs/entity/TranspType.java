package lv.lgs.entity;

import javax.persistence.*;
import java.util.List;

@Entity

public class TranspType {

	@Id //���� �� ���� id ���� ���������� ���� ������� id
	@GeneratedValue(strategy=GenerationType.IDENTITY) //����� ���� ����������� ������������ ��� ��������� ���� id
	private int id; 
 	@Column( name = "transpType")//���� �� ���� ���� ��������, //�������� "name" ����� �� ���� ���������� �������� � ��
	private String transpType;

	//@one to meny -- ���� � ������ ���� �������� ��� �������� �����
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "transpType") //�����, �� ���� � ������������ ��`��� ���� �� ��������
	//� ���� ������� ��`����, � �������� OneToMany, ������ ��������� ������� �������� ���������
	//cascade -- ������������ ��������, ���� ����� �� �������� �� � ������� ���������, ���������, ��������� ��������
	//fetch -- �������� ����`�������, ������� �� ������������ ������ � �� ���� �������� � ������ ���������
	//mappedBy -- ����`�������, ����� �� ������� ����������� �� ��`����, ��������� ������ �� ���� (� ���� �������) ��� ������ �� �������� ��`��� ����� �����

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
