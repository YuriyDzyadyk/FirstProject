package lv.lgs.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Request {
	
	@Id //���� �� ���� id ���� ���������� ���� ������� id
	@GeneratedValue(strategy=GenerationType.IDENTITY) //����� ���� ����������� ������������ ��� ��������� ���� id
	private int id; 

 	@ManyToOne //�����, �� ���� ����� � ������������ ��`��� ������ �� ������
 	@JoinColumn //����� �� �� �� ��������� �������� ���������� ��������, ���� ���� FK �� ���������� ������� ��`����
	private Car car;
 
	@ManyToOne //�����, �� ���� ����� � ������������ ��`��� ������ �� ������
 	@JoinColumn //����� �� �� �� ��������� �������� ���������� ��������, ���� ���� FK �� ���������� ������� ��`����
	private City from;
	
 	@ManyToOne //�����, �� ���� ����� � ������������ ��`��� ������ �� ������
 	@JoinColumn //����� �� �� �� ��������� �������� ���������� ��������, ���� ���� FK �� ���������� ������� ��`����
	private City to;


}
