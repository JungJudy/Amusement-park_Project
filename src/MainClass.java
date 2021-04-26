package Playground;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		OutputClass output = new OutputClass();
		PlaygroundTypeClass pgType = new PlaygroundTypeClass();
		InputFromConsoleClass input = new InputFromConsoleClass();
		ProcessingClass pc = new ProcessingClass();
		
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
		//우대사항 할인
		pc.calDiscount(pgType);
	}

}
