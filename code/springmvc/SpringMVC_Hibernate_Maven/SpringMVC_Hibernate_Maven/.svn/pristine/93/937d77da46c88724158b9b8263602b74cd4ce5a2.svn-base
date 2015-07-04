package com.lh.util.excel;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import com.google.gson.Gson;
import com.google.gson.internal.LinkedTreeMap;
import com.google.gson.reflect.TypeToken;

/**
 * 新建Excel处理工具类
 * 
 * @author 刘浩
 * @date 2014-7-4
 * 
 */
public class ExcelUtils {

	/**
	 * 根据给定Excel的表头格式和数据生成Workbook
	 * 
	 * @author 刘浩
	 * @date 2014-7-4
	 * @param header
	 * @param sheetName
	 * @param data
	 * @return
	 * @throws InvocationTargetException
	 * @throws NoSuchMethodException
	 * @throws Exception
	 */
	@SuppressWarnings("rawtypes")
	public static Workbook getWorkbook(ExcelHeader header, String sheetName,
			java.util.Collection data) throws InvocationTargetException,
			NoSuchMethodException, Exception {
		Workbook wb = new HSSFWorkbook();
		Sheet st = wb.createSheet(sheetName);
		st.setDefaultColumnWidth(20);// 设置默认列宽
		createHead(wb, st, header);
		if (data != null) {
			createRow(wb, st, header, data);
		}
		return wb;
	}

	/**
	 * 解析Excel将Excel的每行转换为一个Map，在header里指定Map的键，默认读取第一 sheet ，读取头
	 * 
	 * @author 刘浩
	 * @date 2014-7-4
	 * @param header
	 * @param wb
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public static java.util.Collection<Map> getMaps(ExcelHeader header,
			Workbook wb) {
		return getMaps(header, wb, 0, true);
	}

	/**
	 * 解析Excel将Excel的每行转换为一个Map，在header里指定Map的键
	 * 
	 * @author 刘浩
	 * @date 2014-7-4
	 * @param header
	 * @param wb
	 * @param sheetIndex
	 * @param readFirst
	 * @return
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static java.util.Collection<Map> getMaps(ExcelHeader header,
			Workbook wb, int sheetIndex, boolean readFirst) {
		List<Map> datas = new ArrayList<Map>();
		Sheet sheet = wb.getSheetAt(sheetIndex);
		boolean isHead = true;
		for (Iterator rit = sheet.rowIterator(); rit.hasNext();) {
			Row row = null;
			if (!readFirst && isHead) {
				isHead = false;
				rit.next();
				continue;
			} else {
				row = (Row) rit.next();
			}
			Map data = new HashMap();
			int i = 0;
			Map<String, String>[] clums = header.getColumns();
			for (Iterator cit = row.cellIterator(); cit.hasNext();) {
				Cell cell = (Cell) cit.next();
				int type = cell.getCellType();
				String key = clums[i++].get(ExcelHeader.COLUMNS_INDEX);
				switch (type) {
				case Cell.CELL_TYPE_STRING:
					data.put(key, cell.getStringCellValue());
					break;
				case Cell.CELL_TYPE_BOOLEAN:
					data.put(key, cell.getBooleanCellValue());
				case Cell.CELL_TYPE_NUMERIC:
					data.put(key, cell.getNumericCellValue());
					break;
				default:
					data.put(key, cell.getStringCellValue());
					break;
				}
			}
			datas.add(data);
		}
		return datas;
	}

	/**
	 * 创建表头
	 * 
	 * @param st
	 * @param header
	 */
	public static void createHead(Workbook wb, Sheet st, ExcelHeader header) {
		Row row = st.createRow(0);
		Map<String, String>[] clums = header.getColumns();
		if (clums != null) {
			for (int i = 0; i < clums.length; i++) {
				String name = clums[i].get(ExcelHeader.COLUMNS_NAME);
				Cell cell = row.createCell(i);
				cell.setCellStyle(getHeadStye(wb));
				cell.setCellValue(name);
			}
		}
	}

	/**
	 * 创建行 默认列不自适应宽度
	 * 
	 * @param st
	 * @param header
	 * @param data
	 * @throws Exception
	 * @throws InvocationTargetException
	 * @throws NoSuchMethodException
	 */
	@SuppressWarnings("rawtypes")
	public static void createRow(Workbook wb, Sheet st, ExcelHeader header,
			java.util.Collection data) throws Exception,
			InvocationTargetException, NoSuchMethodException {
		createRow(wb, st, header, data, false);
	}

	/**
	 * 创建行
	 * 
	 * @param wb
	 * @param st
	 * @param header
	 * @param data
	 * @param isAutoSizeColumn
	 *            列是否自适应宽度
	 * @throws Exception
	 * @throws InvocationTargetException
	 * @throws NoSuchMethodException
	 * @date 2014-11-25
	 * @author 刘浩
	 */
	@SuppressWarnings("rawtypes")
	public static void createRow(Workbook wb, Sheet st, ExcelHeader header,
			java.util.Collection data, boolean isAutoSizeColumn)
			throws Exception, InvocationTargetException, NoSuchMethodException {
		Map<String, String>[] clums = header.getColumns();
		//2014-11-25 修复生成万条数据以上时格式获取耗时及获取不到bug
		CellStyle cellstyle = getCellStringStye(wb);
		for (Object bean : data) {
			Row row = st.createRow(st.getLastRowNum() + 1);
			for (int i = 0; i < clums.length; i++) {
				Object name = null;
				if (isAutoSizeColumn) {
					// 设置列自适应宽度
					st.autoSizeColumn(i);
				}
				if (bean instanceof Map) {
					name = ((Map) bean).get(clums[i]
							.get(ExcelHeader.COLUMNS_INDEX));
				} else {
					name = org.apache.commons.beanutils.PropertyUtils
							.getProperty(bean,
									clums[i].get(ExcelHeader.COLUMNS_INDEX));
				}
				Cell cell = row.createCell(i);
				cell.setCellStyle(cellstyle);
				// if(name != null) {
				// cell.setCellValue(String.valueOf(name));
				// }else{
				// cell.setCellValue("");
				// }
				// 2014-11-25修改
				if (name != null) {
					if (name instanceof Integer) {
						cell.setCellValue(((Integer) name).intValue());
					} else if (name instanceof Long) {
						cell.setCellValue(((Long) name).longValue());
					} else if (name instanceof BigDecimal) {
						cell.setCellValue(((BigDecimal) name).doubleValue());
					} else if (name instanceof Double) {
						cell.setCellValue(((Double) name).doubleValue());
					} else if (name instanceof String) {
						cell.setCellValue((String) name);
					} else if (name instanceof java.util.Date) {
						long time = ((java.util.Date) name).getTime();
						cell.setCellValue(new java.sql.Date(time));
					} else {
						cell.setCellValue(String.valueOf(name));
					}
				} else {
					cell.setCellValue("");
				}
			}
		}
	}

	/**
	 * 创建行
	 * 
	 * @param st
	 * @param header
	 * @param data
	 * @throws Exception
	 * @throws InvocationTargetException
	 * @throws NoSuchMethodException
	 */
	@SuppressWarnings({ "rawtypes" })
	public static void createRow(Workbook wb, Sheet st, ExcelHeader header,
			Map data) throws Exception, InvocationTargetException,
			NoSuchMethodException {
		Map<String, String>[] clums = header.getColumns();
		Row row = st.createRow(st.getLastRowNum() + 1);
		for (int i = 0; i < clums.length; i++) {
			Object name = null;
			if (data instanceof Map) {
				name = ((Map) data)
						.get(clums[i].get(ExcelHeader.COLUMNS_INDEX));
			}
			Cell cell = row.createCell(i);
			if (name != null) {
				if (name instanceof Integer) {
					cell.setCellValue(((Integer) name).intValue());
				} else if (name instanceof Long) {
					cell.setCellValue(((Long) name).longValue());
				} else if (name instanceof BigDecimal) {
					cell.setCellValue(((BigDecimal) name).doubleValue());
				} else if (name instanceof Double) {
					cell.setCellValue(((Double) name).doubleValue());
				} else if (name instanceof String) {
					cell.setCellValue((String) name);
				} else if (name instanceof java.util.Date) {
					long time = ((java.util.Date) name).getTime();
					cell.setCellValue(new java.sql.Date(time));
				} else {
					cell.setCellValue(String.valueOf(name));
				}
			} else {
				cell.setCellValue("");
			}
		}
	}

	/**
	 * 导出Excel文件
	 * 
	 * @param OutputStream
	 *            输出流
	 * @throws IOException
	 */
	public static void export(OutputStream out, Workbook wb)
			throws FileNotFoundException, IOException {
		try {
			wb.write(out);
			out.flush();
			out.close();
		} catch (FileNotFoundException e) {
			throw new IOException(" 生成导出Excel文件出错! ");
		} catch (IOException e) {
			throw new IOException(" 写入Excel文件出错! ");
		}
	}

	/**
	 * 表头字体
	 * 
	 * @author 刘浩
	 * @date 2014-7-4
	 * @param wb
	 * @return
	 */
	public static Font getHdrFont(Workbook wb) {
		Font fontStyle = wb.createFont();
		fontStyle.setFontName("宋体");
		fontStyle.setFontHeightInPoints((short) 10);
		fontStyle.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
		return fontStyle;
	}

	/**
	 * 内容字体
	 * 
	 * @author 刘浩
	 * @date 2014-7-4
	 * @param wb
	 * @return
	 */
	public static Font getContentFont(Workbook wb) {
		Font fontStyle = wb.createFont();
		fontStyle.setFontName("宋体");
		fontStyle.setFontHeightInPoints((short) 10);
		fontStyle.setBoldweight(HSSFFont.BOLDWEIGHT_NORMAL);
		return fontStyle;
	}

	/**
	 * 设置表头样式
	 * 
	 * @author 刘浩
	 * @date 2014-7-4
	 * @param wb
	 * @return
	 */
	public static CellStyle getHeadStye(Workbook wb) {
		CellStyle cellStyle = wb.createCellStyle();
		cellStyle.setFont(getHdrFont(wb));
		cellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		cellStyle.setBorderBottom(HSSFCellStyle.BORDER_THIN);// 边框
		cellStyle.setBottomBorderColor(HSSFColor.BLACK.index);
		cellStyle.setBorderLeft(HSSFCellStyle.BORDER_THIN);
		cellStyle.setLeftBorderColor(HSSFColor.BLACK.index);
		cellStyle.setBorderRight(HSSFCellStyle.BORDER_THIN);
		cellStyle.setRightBorderColor(HSSFColor.BLACK.index);
		cellStyle.setBorderTop(HSSFCellStyle.BORDER_THIN);
		cellStyle.setTopBorderColor(HSSFColor.BLACK.index);
		cellStyle.setFillForegroundColor(HSSFColor.LIGHT_GREEN.index);
		cellStyle.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
		return cellStyle;
	}

	/**
	 * 设置单元格样式
	 * 
	 * @author 刘浩
	 * @date 2014-7-4
	 * @param wb
	 * @return
	 */
	public static CellStyle getCellStringStye(Workbook wb) {
		CellStyle cellStyle = wb.createCellStyle();
		cellStyle.setAlignment(HSSFCellStyle.ALIGN_RIGHT); // 靠右
		cellStyle.setBorderBottom(HSSFCellStyle.BORDER_THIN);// 边框
		cellStyle.setBottomBorderColor(HSSFColor.BLACK.index);
		cellStyle.setBorderLeft(HSSFCellStyle.BORDER_THIN);
		cellStyle.setLeftBorderColor(HSSFColor.BLACK.index);
		cellStyle.setBorderRight(HSSFCellStyle.BORDER_THIN);
		cellStyle.setRightBorderColor(HSSFColor.BLACK.index);
		cellStyle.setBorderTop(HSSFCellStyle.BORDER_THIN);
		cellStyle.setTopBorderColor(HSSFColor.BLACK.index);
		// cellStyle.setWrapText(true);// 自动换行
		return cellStyle;
	}

	/**
	 * 将json数据转换为workbook对象 测试
	 * 
	 * @param jsonString
	 * @return
	 * @date 2014-11-25
	 * @author 刘浩
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static Workbook JsonToWork(String jsonString, String sheetName) {
		Gson gson = new Gson();
		HashMap map = gson.fromJson(jsonString, new TypeToken<HashMap>() {
		}.getType());
		LinkedTreeMap headerMap = (LinkedTreeMap) map.get("header");
		ArrayList list = (ArrayList) headerMap.get("columns");
		ExcelHeader header = new ExcelHeader();
		for (int i = 0; i < list.size(); i++) {
			LinkedTreeMap<String, String> m = (LinkedTreeMap) list.get(i);
			header.addColumn(m.get("name"), m.get("index"));
		}
		ArrayList data = (ArrayList) map.get("data");
		try {
			Workbook wb = ExcelUtils.getWorkbook(header, sheetName, data);
			return wb;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	

	/**
	 * 导出Excel文件
	 * @param out
	 * @param jsonString
	 * @param sheetName
	 * @throws FileNotFoundException
	 * @throws IOException
	 * @date 2014-12-25
	 * @author 刘浩
	 */
	public static void export(OutputStream out, String jsonString, String sheetName)
			throws FileNotFoundException, IOException {
		try {
			Workbook wb = JsonToWork(jsonString, sheetName);
			if (wb != null) {
				wb.write(out);
				out.flush();
				out.close();
			}
		} catch (FileNotFoundException e) {
			throw new IOException(" 生成导出Excel文件出错! ");
		} catch (IOException e) {
			throw new IOException(" 写入Excel文件出错! ");
		}
	}
}