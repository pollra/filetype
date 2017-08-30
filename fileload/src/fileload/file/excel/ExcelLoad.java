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
			//파일을 읽기위해 엑셀파일을 가져온다
			String fileDirectory = "C:\\Users\\pc1\\eclipse-workspace"
					+ "\\fileload\\src\\fileload\\file\\excel\\08.29_1.xls";
			FileInputStream fis=new FileInputStream(fileDirectory);
			HSSFWorkbook workbook=new HSSFWorkbook(fis);
			int rowindex=0;
			int columnindex=0;
			//시트 수 (첫번째에만 존재하므로 0을 준다)
			//만약 각 시트를 읽기위해서는 FOR문을 한번더 돌려준다
			HSSFSheet sheet=workbook.getSheetAt(0);
			//행의 수
			int rows=sheet.getPhysicalNumberOfRows();
			for(rowindex=1;rowindex<rows;rowindex++){
			    //행을 읽는다
			    HSSFRow row=sheet.getRow(rowindex);
			    if(row !=null){
			        //셀의 수
			        int cells=row.getPhysicalNumberOfCells();
			        for(columnindex=0;columnindex<=cells;columnindex++){
			            //셀값을 읽는다
			            HSSFCell cell=row.getCell(columnindex);
			            String value="";
			            //셀이 빈값일경우를 위한 널체크
			            if(cell==null){
			                continue;
			            }else{
			            	
			            	System.out.println("진입 성공");
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
			                //타입별로 내용 읽기
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
			            System.out.println(rowindex+"행 "+columnindex+"번째 셀 내용 :"+value);
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
