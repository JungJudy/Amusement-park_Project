package Playground;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		OutputClass output = new OutputClass();
		PlaygroundTypeClass pgType;
		InputFromConsoleClass input = new InputFromConsoleClass();
		ProcessingClass pc = new ProcessingClass();
		FileWriteClass fwc = new FileWriteClass();

		while (true) {
			pgType = new PlaygroundTypeClass();
			
			while(true) {
				//Ƽ��Ÿ��,�ֹι�ȣ,�ֹ� ����,������ �Է¹ޱ�
				input.selectTicekType(pgType);
				input.inputID_Number(pgType);
				input.inputOrderCount(pgType);
				input.inputDiscountType(pgType);
				
				//����,�׷�,���̿� ���� �ݾ�,������ ����, �ֹ������� �����׿� ���� �����ݾ� ���
				pc.calAge(pgType);
				pc.calAgeGroup(pgType);
				pc.calPrice(pgType);
				pc.calDiscount(pgType);
				pc.calPriceResult(pgType,output);

				//���� ���� ����
				pc.TotalResult(pgType);
				
				//�̾ �ֹ� or ���� �Է¹ޱ�
				input.orderContinue(pgType);
				if (pgType.orderContinueType == ConstValueClass.ORDER_EXIT) break;
			}
			
			input.programContinue(pgType);
			if (pgType.programConinueType == ConstValueClass.PROGRAM_EXIT) break;
		}

	}

}
