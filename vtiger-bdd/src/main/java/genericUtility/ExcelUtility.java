package genericUtility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDateTime;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {
	/**
	 * 
	 * @param sheetName
	 * @param rowNo
	 * @param cellNo
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public static String fetchStringDataFromExcelSheet(String sheetName, int rowNo, int cellNo)
			throws EncryptedDocumentException, FileNotFoundException, IOException {

		return WorkbookFactory.create(new FileInputStream(IPathConstant.EXCEL_FILE_PATH))
				.getSheet(sheetName).getRow(rowNo).getCell(cellNo).getStringCellValue();
	}

	/**
	 * 
	 * @param sheetName
	 * @param rowNo
	 * @param cellNo
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public static double fetchNumericDataFromExcelSheet(String sheetName, int rowNo, int cellNo)
			throws EncryptedDocumentException, FileNotFoundException, IOException {

		return WorkbookFactory.create(new FileInputStream("./src/test/resources/testData/vtigerTestData.xlsx"))
				.getSheet(sheetName).getRow(rowNo).getCell(cellNo).getNumericCellValue();
	}

	/**
	 * 
	 * @param sheetName
	 * @param rowNo
	 * @param cellNo
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public static boolean fetchBooleanDataFromExcelSheet(String sheetName, int rowNo, int cellNo)
			throws EncryptedDocumentException, FileNotFoundException, IOException {

		return WorkbookFactory.create(new FileInputStream("./src/test/resources/testData/vtigerTestData.xlsx"))
				.getSheet(sheetName).getRow(rowNo).getCell(cellNo).getBooleanCellValue();
	}
	
	public static String fetchDateDataFromExcelSheet(String sheetName, int rowNo, int cellNo)
			throws EncryptedDocumentException, FileNotFoundException, IOException {

		return WorkbookFactory.create(new FileInputStream("./src/test/resources/testData/vtigerTestData.xlsx"))
				.getSheet(sheetName).getRow(rowNo).getCell(cellNo).getLocalDateTimeCellValue().toString().substring(0, 10);
	}


}
