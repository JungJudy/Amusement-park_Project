package Playground;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		OutputClass output = new OutputClass();
		PlaygroundTypeClass pgType = new PlaygroundTypeClass();
		InputFromConsoleClass input = new InputFromConsoleClass();
		
		//티켓타입 선택 문구 출력
		output.printTicketType();
		//티켓타입 입력받기
		input.selectTicekType(pgType);
		//주민등록번호 문구 출력
		output.printIDNumber();
		input.inputID_Number(pgType);
	}

}
