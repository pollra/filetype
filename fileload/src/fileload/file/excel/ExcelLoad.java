package fileload.file.excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.attribute.FileAttribute;
import java.util.Scanner;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFChart.HSSFSeries;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class ExcelLoad {

	public static void main(String[] args) {
		try {
			//������ �б����� ���������� �����´�
			String fileDirectory = "C:\\Users\\pc1\\eclipse-workspace"
					+ "\\fileload\\src\\fileload\\file\\excel\\08.29_1.xls";
			FileInputStream fis=new FileInputStream(fileDirectory);
			HSSFWorkbook workbook=new HSSFWorkbook(fis);
			int rowindex=0;
			int columnindex=0;
			//��Ʈ �� (ù��°���� �����ϹǷ� 0�� �ش�)
			//���� �� ��Ʈ�� �б����ؼ��� FOR���� �ѹ��� �����ش�
			HSSFSheet sheet=workbook.getSheetAt(0);
			//���� ��
			int rows=sheet.getPhysicalNumberOfRows();
			for(rowindex=1;rowindex<rows;rowindex++){
			    //���� �д´�
			    HSSFRow row=sheet.getRow(rowindex);
			    if(row !=null){
			        //���� ��
			        int cells=row.getPhysicalNumberOfCells();
			        for(columnindex=0;columnindex<=cells;columnindex++){
			            //������ �д´�
			            HSSFCell cell=row.getCell(columnindex);
			            String value="";
			            //���� ���ϰ�츦 ���� ��üũ
			            if(cell==null){
			                continue;
			            }else{
			            	
			            	System.out.println("���� ����");
			            	System.out.println(cell.getCellTypeEnum());
			            	switch (cell.getCellTypeEnum()) {
			            	case STRING:
			            		System.out.println("input String Data");
			            		value=cell.getStringCellValue()+"";
			            		break;
			            	case BLANK:
			            		System.out.println("input blank Data");
			            		value=cell.getBooleanCellValue()+"";
			            		break;
			            	case ERROR:
			            		System.out.println("input ERROR");
			            		value=cell.getErrorCellValue()+"";
			            		break;
			            	}
			                //Ÿ�Ժ��� ���� �б�
//			                switch (cell.getColumnIndex()){
//			                case HSSFCell.CELL_TYPE_FORMULA:
//			                    value=cell.getCellFormula();
//			                    break;
//			                case HSSFCell.CELL_TYPE_NUMERIC:
//			                    value=cell.getNumericCellValue()+"";
//			                    break;
//			                case HSSFCell.CELL_TYPE_STRING:
//			                    value=cell.getStringCellValue()+"";
//			                    break;
//			                case HSSFCell.CELL_TYPE_BLANK:
//			                    value=cell.getBooleanCellValue()+"";
//			                    break;
//			                case HSSFCell.CELL_TYPE_ERROR:
//			                    value=cell.getErrorCellValue()+"";
//			                    break;
//			                }
			            }
			            System.out.println(rowindex+"�� "+columnindex+"��° �� ���� :"+value);
			            }
			        }
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("[!] File false");
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("[!] file incoding error");
		}
	}
	
}
