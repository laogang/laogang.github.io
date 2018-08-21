package excelport.copy;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.shangh.guog.modle.Bond;
import com.shangh.guog.modle.Disposit;

public class ExcelExportTest {
	public static void main(String[] args) throws Exception {

		String srcFilePath = "d:/test.xlsx";
		String fileName = "test_" + System.currentTimeMillis() + ".xlsx";
		String desFilePath = "d:/" + fileName;

		exportExcel(srcFilePath, desFilePath);
	}

	// ����ָ����excelģ�嵼������
	private static void exportExcel(String srcFilePath, String desFilePath) throws Exception {
		Disposit disposit = getDisposit();
		// ����Excel�ļ�������������
		FileInputStream fis = new FileInputStream(srcFilePath);
		// ����ģ�崴��excel������
		XSSFWorkbook workBook = new XSSFWorkbook(fis);
		// ����Excel�ļ����������
		FileOutputStream fos = new FileOutputStream(desFilePath);
		// ��ȡ�����Ĺ�������һҳ
		XSSFSheet sheet = workBook.getSheetAt(0);
		// ��ָ����sheet����
		workBook.setSheetName(0, "�������һ����");

		// �޸ı���
		XSSFRow row = sheet.getRow(0);
		XSSFCell cell = row.getCell(0);
		// ��ȡָ����Ԫ��ֵ
		String s = cell.getStringCellValue();
		cell.setCellValue("�޸ĺ�ı���Ϊ:" + s);

		XSSFRow row2 = sheet.getRow(1);
		row2.getCell(1).setCellValue("��������22");

		// ������ݴ���ģ���е������������в����Ƶ�һ�����ݵĸ�ʽ
		if (disposit.getBonds().size() > 1) {
			for (int i = 0; i < disposit.getBonds().size() - 1; i++) {
				createRow(workBook, sheet, 6 + i);
			}
		}

		workBook.write(fos);

		// �ر���
		fis.close();
		fos.flush();
		fos.close();
		System.out.println("�����ɹ�");
	}

	private static void copyCell(XSSFWorkbook wb, Cell srcCell, Cell distCell) {
		CellStyle newStyle = wb.createCellStyle();
		CellStyle srcStyle = srcCell.getCellStyle();
		newStyle.cloneStyleFrom(srcStyle);
		newStyle.setFont(wb.getFontAt(srcStyle.getFontIndex()));
		// ��ʽ
		distCell.setCellStyle(newStyle);
		// ����
		if (srcCell.getCellComment() != null) {
			distCell.setCellComment(srcCell.getCellComment());
		}
		// ��ͬ�������ʹ���
		CellType srcCellType = srcCell.getCellTypeEnum();
		distCell.setCellType(srcCellType);
		if (srcCellType == CellType.NUMERIC) {
			if (DateUtil.isCellDateFormatted(srcCell)) {
				distCell.setCellValue(srcCell.getDateCellValue());
			} else {
				distCell.setCellValue(srcCell.getNumericCellValue());
			}
		} else if (srcCellType == CellType.STRING) {
			distCell.setCellValue(srcCell.getRichStringCellValue());
		} else if (srcCellType == CellType.BLANK) {

		} else if (srcCellType == CellType.BOOLEAN) {
			distCell.setCellValue(srcCell.getBooleanCellValue());
		} else if (srcCellType == CellType.ERROR) {
			distCell.setCellErrorValue(srcCell.getErrorCellValue());
		} else if (srcCellType == CellType.FORMULA) {
			distCell.setCellFormula(srcCell.getCellFormula());
		} else {
		}

	}

	/**
	 * �ҵ���Ҫ��������������½�һ��POI��row����
	 * 
	 * @param sheet
	 * @param rowIndex
	 * @return
	 */
	public static XSSFRow createRow(XSSFWorkbook workBook, XSSFSheet sheet, Integer rowIndex) {
		XSSFRow row = null;
		XSSFRow sourceRow = sheet.getRow(rowIndex);
		if (sheet.getRow(rowIndex) != null) {
			int lastRowNo = sheet.getLastRowNum();
			sheet.shiftRows(rowIndex, lastRowNo, 1);
		}
		row = sheet.createRow(rowIndex);

		row.setHeight(sourceRow.getHeight());
		for (int j = 0; j < sourceRow.getLastCellNum(); j++) {
			Cell templateCell = sourceRow.getCell(j);
			if (templateCell != null) {
				Cell newCell = row.createCell(j);
				copyCell(workBook, templateCell, newCell);
			}
		}
		return row;
	}

	private static Disposit getDisposit() {
		Disposit disposit = new Disposit();
		disposit.setAmount("12");
		disposit.setChengyuan("������");
		disposit.setDispNo("10086");
		disposit.setDispositDate("2018-01-19");
		disposit.setDispositName("���»�");
		disposit.setModle("�ʲ���");
		disposit.setNumber("18");
		disposit.setPaymentDate("2018-03-03");
		List<Bond> bonds = new ArrayList<Bond>();
		Bond bond = null;
		for (int i = 0; i < 9; i++) {
			bond = new Bond();
			bond.setBondCode("10000" + i);
			bond.setName("ծȯ" + i);
			bond.setNumber("100" + i);
			bonds.add(bond);
		}
		disposit.setBonds(bonds);
		return disposit;
	}
}
