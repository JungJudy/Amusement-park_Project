package Playground;


public class OutputClass {
	
	public void printTicketType() {
		System.out.println("������ �������ּ���");
		System.out.println("1.�ְ���\n2.�߰���");
	}

	public void printIDNumber() {
		// TODO Auto-generated method stub
		System.out.println("�ֹε�Ϲ�ȣ�� �Է����ּ��� (ex.210426-1234567)");
	}

	public void printOrderCount() {
		// TODO Auto-generated method stub
		System.out.println("������ �����Ͻðڽ��ϱ�? (�ִ� 10��)");
	}

	public void printDiscount() {
		// TODO Auto-generated method stub
		System.out.println("�������� �������ּ���");
		System.out.println("1.���� (���� ���� �ڵ�ó��)");
		System.out.println("2.�����");
		System.out.println("3.����������");
		System.out.println("4.���ڳ�");
		System.out.println("5.�ӻ��");
	}

	public void printPriceResult(PlaygroundTypeClass pgType) {
		// TODO Auto-generated method stub
		System.out.printf("������ %d �� �Դϴ�.\n�����մϴ�.\n", pgType.priceResult);
	}

	public void printOrderContinue() {
		// TODO Auto-generated method stub
		System.out.println("��� �߱��Ͻðڽ��ϱ�?");
		System.out.println("1.Ƽ�� �߱�");
		System.out.println("2.����");
	}
	
	
	

	public void printProgramContinue() {
		System.out.printf("��� ����(1: ���ο� �ֹ�, 2:���α׷� ����) : ");
		
	}


}
