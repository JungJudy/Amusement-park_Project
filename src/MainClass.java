package Playground;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		OutputClass output = new OutputClass();
		PlaygroundTypeClass pgType = new PlaygroundTypeClass();
		InputFromConsoleClass input = new InputFromConsoleClass();
		
		//Ƽ��Ÿ�� ���� ���� ���
		output.printTicketType();
		//Ƽ��Ÿ�� �Է¹ޱ�
		input.selectTicekType(pgType);
		//�ֹε�Ϲ�ȣ ���� ���
		output.printIDNumber();
		input.inputID_Number(pgType);
	}

}
