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
		//티켓타입 선택 문구 출력
		output.printTicketType();
		//티켓타입 입력받기
		input.selectTicekType(pgType);
		//주민등록번호 문구 출력
		output.printIDNumber();
		//주민번호 입력받기
		input.inputID_Number(pgType);
		//나이계산
		pc.calAge(pgType);
		//나이 그룹 계산
		pc.calAgeGroup(pgType);
		//주문 갯수 문구 출력
		output.printOrderCount();
		//주문 갯수 입력받기
		input.inputOrderCount(pgType);
		//나이에 따른 금액 계산
		pc.calPrice(pgType);
		//우대사항 문구 출력
		output.printDiscount();
		//우대사항 입력받기
		input.inputDiscountType(pgType);
		//우대사항 할인
		pc.calDiscount(pgType);
		//주문갯수와 우대사항에 따른 결제금액
		pc.calPriceResult(pgType);
		//가격 출력
		output.printPriceResult(pgType);
		//이어서 주문 or 종료 문구 출력
		output.printOrderContinue();
		//이어서 주문 or 종료 입력받기
		input.orderContinue(pgType);
		}
	}

}
