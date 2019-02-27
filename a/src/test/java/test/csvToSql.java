<<<<<<< HEAD
package test;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;

import util.tool;
import dao.time_series_dataDao;
import dao.impl.time_series_dataDaoImpl;
import dao.impl.time_series_databizImpl;
import biz.time_series_databiz;
import entity.time_series_data;

public class csvToSql {

	private time_series_databiz databiz = null;
	private time_series_dataDao dataDao = null;

	public void init() {

		dataDao = new time_series_dataDaoImpl();
		databiz = new time_series_databizImpl();
		databiz.settime_series_dataDao(dataDao);
	}

	// 读取csv文件的内容
	@SuppressWarnings("resource")
	public static ArrayList<String[]> readCsv(String filepath) {
		FileInputStream in;
		BufferedReader br = null;
		try {
			in = new FileInputStream(filepath);
			br = new BufferedReader(new InputStreamReader(in, "UTF-8"));
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String line = "";
		ArrayList<String[]> allString = new ArrayList<>();

		try {
			br.readLine();// 去掉Title
			String item[] = null;
			while ((line = br.readLine()) != null) // 读取到的内容给line变量
			{
				item = line.split(",");
				// System.out.println(item[2]);
				allString.add(item);

			}

			// System.out.println("csv表格中所有行数：" + allString.size());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return allString;

	}

	public static void main(String[] args) throws IOException {
		csvToSql csvToSql = new csvToSql();
		csvToSql.init();
		File directory = new File("");
		ArrayList<String[]> allString = readCsv(directory.getCanonicalPath()
				+ "/data/tradingDate.csv");

		String stock_code = null;
		time_series_data time_series_data = new time_series_data();
		for (int i = 0; i < allString.size(); i++) {
			stock_code = allString.get(i)[0];
			for (int j = 1; j < allString.get(i).length - 1; j++) {
				time_series_data.setUuid(tool.getUUID());
				time_series_data.setTrading_date(new Date());
				time_series_data.setStock_code(stock_code);
				time_series_data
						.setItem_value(Double.valueOf(allString.get(i)[j]
								.toString()));
				csvToSql.databiz.addData(time_series_data);
			}

		}

	}

}
=======
package test;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;

import util.tool;
import dao.time_series_dataDao;
import dao.impl.time_series_dataDaoImpl;
import dao.impl.time_series_databizImpl;
import biz.time_series_databiz;
import entity.time_series_data;

public class csvToSql {

	private time_series_databiz databiz = null;
	private time_series_dataDao dataDao = null;

	public void init() {

		dataDao = new time_series_dataDaoImpl();
		databiz = new time_series_databizImpl();
		databiz.settime_series_dataDao(dataDao);
	}

	// 读取csv文件的内容
	@SuppressWarnings("resource")
	public static ArrayList<String[]> readCsv(String filepath) {
		FileInputStream in;
		BufferedReader br = null;
		try {
			in = new FileInputStream(filepath);
			br = new BufferedReader(new InputStreamReader(in, "UTF-8"));
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String line = "";
		ArrayList<String[]> allString = new ArrayList<>();

		try {
			br.readLine();// 去掉Title
			String item[] = null;
			while ((line = br.readLine()) != null) // 读取到的内容给line变量
			{
				item = line.split(",");
				// System.out.println(item[2]);
				allString.add(item);

			}

			// System.out.println("csv表格中所有行数：" + allString.size());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return allString;

	}

	public static void main(String[] args) throws IOException {
		csvToSql csvToSql = new csvToSql();
		csvToSql.init();
		File directory = new File("");
		ArrayList<String[]> allString = readCsv(directory.getCanonicalPath()
				+ "/data/tradingDate.csv");

		String stock_code = null;
		time_series_data time_series_data = new time_series_data();
		for (int i = 0; i < allString.size(); i++) {
			stock_code = allString.get(i)[0];
			for (int j = 1; j < allString.get(i).length - 1; j++) {
				time_series_data.setUuid(tool.getUUID());
				time_series_data.setTrading_date(new Date());
				time_series_data.setStock_code(stock_code);
				time_series_data
						.setItem_value(Double.valueOf(allString.get(i)[j]
								.toString()));
				csvToSql.databiz.addData(time_series_data);
			}

		}

	}

}
>>>>>>> c8a361cdb5bd19bc82a4ecda6a545e77ac7ef6ee
