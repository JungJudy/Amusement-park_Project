package k37_Amusement_park;

import java.io.FileWriter;
import java.io.IOException;


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
			String head = "날짜," + "권종," + "연령구분," + "수량," + "가격," + "우대사항" + "\n";
			fw.write(head);
		} 
	}
	
	public void dataWrite(TypeClass pgType) throws IOException {
		String line = null;
		for (int i = 0; i < pgType.outputResult.size()/6; i++) {
			line = pgType.outputResult.get(i*6) + "," + pgType.outputResult.get((i*6)+1) + ","+ pgType.outputResult.get((i*6)+2) + ","+ pgType.outputResult.get((i*6)+3) + ","+ 
		pgType.outputResult.get((i*6)+4) + ","+ pgType.outputResult.get((i*6)+5)+ "\r\n";
			fw.write(line);
		}
		
		//fw.write(pgType.outputResult.toString().replace(']', ' ').replace('[', ' ').trim());
		
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
