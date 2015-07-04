package com.mvc.controller;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.lh.base.BaseController;
import com.lh.util.common.FunctionUtils;
import com.lh.util.excel.ExcelUtils;
import com.lh.util.log.LHLog;
import com.test.excel.GetTestJsonData;

@Controller
public class ExcelController extends BaseController{
	
//    @SuppressWarnings("unused")
	@RequestMapping(value = "/excel.do", method = RequestMethod.POST)
    public String excel(@RequestParam("myfile") MultipartFile myfile,
            HttpServletRequest request,HttpServletResponse response) throws IOException {
    	if (myfile.isEmpty()) {
            System.out.println("文件未上传");
        } else {
            System.out.println("文件长度: " + myfile.getSize());
            System.out.println("文件类型: " + myfile.getContentType());
            System.out.println("文件名称: " + myfile.getName());
            System.out.println("文件原名: " + myfile.getOriginalFilename());
            System.out.println("========================================");
        }
    	return null;
    }
    
	@RequestMapping(value = "/exportExcel.do")
    public void exportExcel( HttpServletRequest request,HttpServletResponse response){
    	try {
    		System.out.println("下载Excel测试");
    		FunctionUtils.downloadSet(response, "testExcel.xls", null);
			ExcelUtils.export(response.getOutputStream(), GetTestJsonData.getJsonString(), "testExcel");
//			response.flushBuffer();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
    
    
    
    
    
    
    
    
//    @RequestMapping(value = "/excel.do", method = RequestMethod.POST)
//    public String excel(@RequestParam("myfile") MultipartFile myfile,
//            HttpServletRequest request,HttpServletResponse response) throws IOException {
//        // 如果只是上传一个文件，则只需要MultipartFile类型接收文件即可，而且无需显式指定@RequestParam注解
//        // 如果想上传多个文件，那么这里就要用MultipartFile[]类型来接收文件，并且还要指定@RequestParam注解
//        // 并且上传多个文件时，前台表单中的所有<input type="file">的name都应该是myfiles，否则参数里的myfiles无法获取到所有上传的文件
//    	Workbook wb = null;
//    	//是否需要返回提示错误的xls文档给用户
//    	boolean isDownload = false;
//    	//判断上传文件是否失败或校验是否通过：用于判断返回结果页
//    	boolean isError = true;
//    	if (myfile.isEmpty()) {
//            System.out.println("文件未上传");
//        } else {
//            System.out.println("文件长度: " + myfile.getSize());
//            System.out.println("文件类型: " + myfile.getContentType());
//            System.out.println("文件名称: " + myfile.getName());
//            System.out.println("文件原名: " + myfile.getOriginalFilename());
//            System.out.println("========================================");
//            
//            
//            
////            // 如果用的是Tomcat服务器，则文件会上传到\\%TOMCAT_HOME%\\webapps\\YourWebProject\\WEB-INF\\upload\\文件夹中
////            String realPath = request.getSession().getServletContext().getRealPath("/files/upload/loanData");
////            // 这里不必处理IO流关闭的问题，因为FileUtils.copyInputStreamToFile()方法内部会自动把用到的IO流关掉，我是看它的源码才知道的
////            File file = new File(realPath, myfile.getOriginalFilename());
////            FileUtils.copyInputStreamToFile(myfile.getInputStream(), file);
//            if(myfile.getOriginalFilename().toLowerCase().endsWith("xls")){
//            	wb = readXls(myfile.getInputStream());
//            }else if(myfile.getOriginalFilename().toLowerCase().endsWith("xlsx")){
//            	wb =readXlsx(myfile.getInputStream());
//            }
//        }
//    	String filename = myfile.getOriginalFilename();
//    	OutputStream out = response.getOutputStream();
//    	if (isDownload) {
//    		//问题，下载了文件后无法返回结果页给用户了
//    		try {
//        		if (response != null && wb != null && filename != null && !"".equals(filename)) {
//        			System.out.println("进入到Excel文件导出");
//        			response.setHeader("Content-Disposition", "attachment; filename="+toUtf8String("（请修改标红字段）"+filename));
//        			response.setContentType("text/plain;charset=utf-8");
//        			wb.write(response.getOutputStream());
//        			out.flush();
//        		}
//        	} catch (FileNotFoundException e) {
//        		isError = true;
//        		LHLog.error(" 生成导出Excel文件出错! ",e);
//    			throw new IOException(" 生成导出Excel文件出错! ");
//    		} catch (IOException e) {
//    			isError = true;
//    			LHLog.error(" 写入Excel文件出错! ",e);
//    			throw new IOException(" 写入Excel文件出错! ");
//    		} finally{
//    			if (out!=null) {
//    				out.flush();
//    			}
//    			try {
//    				response.flushBuffer();
//    			} catch (IOException e) {
//    				LHLog.error("response清除缓冲出错",e);
//    			}
//    		}
//		}
//    	if (isError) {
//    		return null;
//		}else{
//			return "success";
//		}
//    }
 
    @SuppressWarnings("unused")
	private void readXlsx(String fileName) throws IOException {
        //String fileName = "D:\\excel\\xlsx_test.xlsx";
        XSSFWorkbook xssfWorkbook = new XSSFWorkbook(fileName);
        // 循环工作表Sheet
        for (int numSheet = 0; numSheet < xssfWorkbook.getNumberOfSheets(); numSheet++) {
            XSSFSheet xssfSheet = xssfWorkbook.getSheetAt(numSheet);
            if (xssfSheet == null) {
                continue;
            }
            // 循环行Row
            for (int rowNum = 0; rowNum <= xssfSheet.getLastRowNum(); rowNum++) {
                XSSFRow xssfRow = xssfSheet.getRow(rowNum);
                if (xssfRow == null) {
                    continue;
                }
 
                // 循环列Cell
                for (int cellNum = 0; cellNum <= xssfRow.getLastCellNum(); cellNum++) {
                    XSSFCell xssfCell = xssfRow.getCell(cellNum);
                    if (xssfCell == null) {
                        continue;
                    }
                    System.out.print("   " + getValue(xssfCell));
                }
                System.out.println();
            }
        }
    }
    
    @SuppressWarnings("unused")
	private XSSFWorkbook readXlsx(InputStream is) throws IOException {
        XSSFWorkbook xssfWorkbook = new XSSFWorkbook(is);
        // 循环工作表Sheet
        for (int numSheet = 0; numSheet < xssfWorkbook.getNumberOfSheets(); numSheet++) {
            XSSFSheet xssfSheet = xssfWorkbook.getSheetAt(numSheet);
            if (xssfSheet == null) {
                continue;
            }
            // 循环行Row
            for (int rowNum = 0; rowNum <= xssfSheet.getLastRowNum(); rowNum++) {
                XSSFRow xssfRow = xssfSheet.getRow(rowNum);
                if (xssfRow == null) {
                    continue;
                }
 
                // 循环列Cell
                for (int cellNum = 0; cellNum <= xssfRow.getLastCellNum(); cellNum++) {
                    XSSFCell xssfCell = xssfRow.getCell(cellNum);
                    if (xssfCell == null) {
                        continue;
                    }
                    System.out.print("   " + getValue(xssfCell));
                }
                System.out.println();
            }
        }
        return xssfWorkbook;
    }
    
             
    @SuppressWarnings("static-access")
    private String getValue(XSSFCell xssfCell) {
        if (xssfCell.getCellType() == xssfCell.CELL_TYPE_BOOLEAN) {
            return String.valueOf(xssfCell.getBooleanCellValue());
        } else if (xssfCell.getCellType() == xssfCell.CELL_TYPE_NUMERIC) {
            return String.valueOf(xssfCell.getNumericCellValue());
        } else if(xssfCell.getCellType() == xssfCell.CELL_TYPE_FORMULA){
        	return String.valueOf(xssfCell.getNumericCellValue());
        } else{
            return String.valueOf(xssfCell.getStringCellValue());
        }
    }
     
    @SuppressWarnings("unused")
	private HSSFWorkbook readXls(InputStream is) throws IOException {
        HSSFWorkbook hssfWorkbook = new HSSFWorkbook(is);
        // 循环工作表Sheet
        for (int numSheet = 0; numSheet < hssfWorkbook.getNumberOfSheets(); numSheet++) {
            HSSFSheet hssfSheet = hssfWorkbook.getSheetAt(numSheet);
            if (hssfSheet == null) {
                continue;
            }
            // 循环行Row
            for (int rowNum = 0; rowNum <= hssfSheet.getLastRowNum(); rowNum++) {
                HSSFRow hssfRow = hssfSheet.getRow(rowNum);
                if (hssfRow == null) {
                    continue;
                }
                // 循环列Cell
                for (int cellNum = 0; cellNum <= hssfRow.getLastCellNum(); cellNum++) {
                    HSSFCell hssfCell = hssfRow.getCell(cellNum);
                    if (hssfCell == null) {
                        continue;
                    }
 
                    System.out.print("    " + getValue(hssfCell));
                }
                System.out.println();
            }
        }
        return hssfWorkbook;
    }
 
    @SuppressWarnings("static-access")
    private String getValue(HSSFCell hssfCell) {
        if (hssfCell.getCellType() == hssfCell.CELL_TYPE_BOOLEAN) {
            return String.valueOf(hssfCell.getBooleanCellValue());
        } else if (hssfCell.getCellType() == hssfCell.CELL_TYPE_NUMERIC) {
            return String.valueOf(hssfCell.getNumericCellValue());
        } else if (hssfCell.getCellType() == hssfCell.CELL_TYPE_FORMULA) {
        	return String.valueOf(hssfCell.getNumericCellValue()); 
		} else{
            return String.valueOf(hssfCell.getStringCellValue());
        }
    }
    
    /**
	 * 将文件名中的汉字转为UTF8编码的串,以便下载时能正确显示另存的文件名.
	 * @param s 原文件名
	 * @return 重新编码后的文件名
	 */
	public static String toUtf8String(String s) {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c >= 0 && c <= 255) {
				sb.append(c);
			} else {
				byte[] b;
				try {
					b = String.valueOf(c).getBytes("utf-8");
				} catch (Exception ex) {
					LHLog.error(ex);
					b = new byte[0];
				}
				for (int j = 0; j < b.length; j++) {
					int k = b[j];
					if (k < 0)
						k += 256;
					sb.append("%" + Integer.toHexString(k).toUpperCase());
				}
			}
		}
		return sb.toString();
	}
}
