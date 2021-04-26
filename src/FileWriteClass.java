package Playground;

import java.io.FileWriter;
import java.io.IOException;

import Exchange.ExchangeType;

public class FileWriteClass {
	private FileWriter fw;
	private boolean isFileExist;

	FileWriteClass() throws IOException {
		
		if(ConstValueClass.file.exists() == false) {
			isFileExist = false;
		} else {
			isFileExist = true;
		}
		fw = new FileWriter(ConstValueClass.file, true);
	}
	public void headerWrite() throws IOException {
		if (isFileExist == false) {
			String head = "날짜," + "권종," + "연령구분," + "수량," + "가격" + "우대사항" + "\n";
			fw.write(head);
		} 
	}
	
	public void dataWrite(PlaygroundTypeClass pgType) throws IOException {
	
		fw.write(pgType.outputResult.toString().replace(']', ' ').trim());
	}
	
	public void fileClose() {
		try {
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
