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
	
	@Id //���� �� ���� id ���� ���������� ���� ������� id
	@GeneratedValue(strategy=GenerationType.IDENTITY) //����� ���� ����������� ������������ ��� ��������� ���� id
	private int id; 
	@Column( name = "city")//���� �� ���� ���� ��������, //�������� "name" ����� �� ���� ���������� �������� � ��
	private String city;

	//@one to meny -- ���� � ������ ���� �������� ��� �������� �����
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "from") //�����, �� ���� � ������������ ��`��� ���� �� ��������
	
	//� ���� ������� ��`����, � �������� OneToMany, ������ ��������� ������� �������� ���������
	//cascade -- ������������ ��������, ���� ����� �� �������� �� � ������� ���������, ���������, ��������� ��������
	//fetch -- �������� ����`�������, ������� �� ������������ ������ � �� ���� �������� � ������ ���������
	//mappedBy -- ����`�������, ����� �� ������� ����������� �� ��`����, ��������� ������ �� ���� (� ���� �������) ��� ������ �� �������� ��`��� ����� �����
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
