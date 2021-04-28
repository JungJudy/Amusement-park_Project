package Playground;

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
				//티켓타입,주민번호,주문 갯수,우대사항 입력받기
				input.selectTicekType(pgType);
				input.inputID_Number(pgType);
				input.inputOrderCount(pgType);
				input.inputDiscountType(pgType);
				
				//나이,그룹,나이에 따른 금액,우대사항 할인, 주문갯수와 우대사항에 따른 결제금액 계산
				pc.calAge(pgType);
				pc.calAgeGroup(pgType);
				pc.calPrice(pgType);
				pc.calDiscount(pgType);
				pc.calPriceResult(pgType,output);
				pc.finalTotalPriceResult(pgType);

				//정리 내용 저장
				pc.TotalResult(pgType,output);
				
				//이어서 주문 or 종료 입력받기
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
