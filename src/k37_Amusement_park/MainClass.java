package k37_Amusement_park;

import java.io.IOException;

public class MainClass {

	public static void main(String[] args) throws IOException {
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
				pc.finalTotalPriceResult(pgType);

				//���� ���� ����
				pc.TotalResult(pgType,output);
				
				//�̾ �ֹ� or ���� �Է¹ޱ�
				input.orderContinue(pgType);
				if (pgType.orderContinueType == ConstValueClass.ORDER_EXIT) break;
				
			}
			
			output.printTotalResult(pgType);
			fwc.headerWrite();
			fwc.dataWrite(pgType);
			input.programContinue(pgType);
			if (pgType.programConinueType == ConstValueClass.PROGRAM_EXIT) {
				break;
			}
		}
		fwc.fileClose();

	}

}
