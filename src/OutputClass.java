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

	public void printTotalResult(PlaygroundTypeClass pgType) {
		// TODO Auto-generated method stub
		System.out.println("=============================��������=============================");
		//System.out.println(pgType.outputResult);
		String temp = pgType.outputResult.toString().replace(']', ' ');
		
			temp.replace('[', ' ');
			//temp.replace(']', ' ');
			temp.trim();
		
		String[] temp2 = temp.split(",");
		for(int i = 0; i < temp2.length/6; i++) {
			System.out.println(ProcessingClass.cutStr(temp2[6*i+1], 10)+ ProcessingClass.cutStr(temp2[6*i+2]+ "  X  " , 14) + ProcessingClass.cutStr(temp2[6*i+3], 8) + 
					ProcessingClass.cutStr(temp2[6*i+4] + "��", 16) + ProcessingClass.cutStr(temp2[6*i+5], 30));
		}
		System.out.println("================================================================");
	}


}
