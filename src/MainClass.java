package Playground;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		OutputClass output = new OutputClass();
		PlaygroundTypeClass pgType;
		InputFromConsoleClass input = new InputFromConsoleClass();
		ProcessingClass pc = new ProcessingClass();
		
		while (true) {
		pgType = new PlaygroundTypeClass();
		//Ƽ��Ÿ�� ���� ���� ���
		output.printTicketType();
		//Ƽ��Ÿ�� �Է¹ޱ�
		input.selectTicekType(pgType);
		//�ֹε�Ϲ�ȣ ���� ���
		output.printIDNumber();
		//�ֹι�ȣ �Է¹ޱ�
		input.inputID_Number(pgType);
		//���̰��
		pc.calAge(pgType);
		//���� �׷� ���
		pc.calAgeGroup(pgType);
		//�ֹ� ���� ���� ���
		output.printOrderCount();
		//�ֹ� ���� �Է¹ޱ�
		input.inputOrderCount(pgType);
		//���̿� ���� �ݾ� ���
		pc.calPrice(pgType);
		//������ ���� ���
		output.printDiscount();
		//������ �Է¹ޱ�
		input.inputDiscountType(pgType);
		//������ ����
		pc.calDiscount(pgType);
		//�ֹ������� �����׿� ���� �����ݾ�
		pc.calPriceResult(pgType);
		//���� ���
		output.printPriceResult(pgType);
		//�̾ �ֹ� or ���� ���� ���
		output.printOrderContinue();
		//�̾ �ֹ� or ���� �Է¹ޱ�
		input.orderContinue(pgType);
		}
	}

}
