package test;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;
import java.util.Date;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import util.tool;
import biz.time_series_databiz;
import dao.time_series_dataDao;
import dao.impl.time_series_dataDaoImpl;
import dao.impl.time_series_databizImpl;
import entity.time_series_data;
@RunWith(Parameterized.class)
public class Test {
	private time_series_databiz databiz = null;
	private time_series_dataDao dataDao = null;
	private boolean expected;
	private String uuid;
	private Date trading_date;
	private String stock_code;
	private double item_value;
	public Test(boolean expected, String uuid, Date trading_date, String stock_code , double item_value) {
		this.expected = expected;
		this.uuid = uuid;
		this.trading_date = trading_date;
		this.stock_code = stock_code;
		this.item_value = item_value;
	}
	@Before
	public void init() {
		dataDao = new time_series_dataDaoImpl();
		databiz = new time_series_databizImpl();
		databiz.settime_series_dataDao(dataDao);
	}
	
	@Parameters
	public static Collection<Object[]> data() {
		return Arrays.asList(
				new Object[][] { 
					{ true,tool.getUUID() , new Date(), "000002" ,0.01}, 
					{ false, tool.getUUID(),new Date() , "000002" ,0.01},
					{ true,tool.getUUID() , new Date(), "000003" ,0.01}, 
					{ false,tool.getUUID() , new Date(), "000003" ,0.01},
					});
	}
	@org.junit.Test
	public void test() {
		time_series_data time_series_data = new time_series_data();
		time_series_data.setUuid(uuid);
		time_series_data.setItem_value(item_value);
		time_series_data.setStock_code(stock_code);
		time_series_data.setTrading_date(trading_date);
		assertEquals(expected,databiz.addData(time_series_data) );
	}

}
