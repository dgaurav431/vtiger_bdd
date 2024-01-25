package opportunities_module;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDateTime;

import org.apache.poi.EncryptedDocumentException;

import genericUtility.ExcelUtility;
import genericUtility.IPathConstant;

public class Demo {

	public static void main(String[] args) throws EncryptedDocumentException, FileNotFoundException, IOException {
		
		ExcelUtility eUtils = new ExcelUtility();
		
		 String date = eUtils.fetchDateDataFromExcelSheet(IPathConstant.OPPORTUNITIES_SHEET_NAME, 1, 1);

		System.out.println(date);
	}

}
