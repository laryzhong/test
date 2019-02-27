<<<<<<< HEAD
package dao.impl;

import java.util.ArrayList;
import java.util.List;

import dao.BaseDao;
import dao.time_series_dataDao;
import entity.time_series_data;

public class time_series_dataDaoImpl extends BaseDao implements time_series_dataDao{

	@Override
	public int insert(time_series_data time_series_data) {
		// TODO Auto-generated method stub
		String table = "time_series_data";
		@SuppressWarnings("rawtypes")
		List<Comparable> list = new ArrayList<Comparable>();
		list.add(time_series_data.getUuid());
		list.add(time_series_data.getTrading_date());
		list.add(time_series_data.getStock_code());	
		list.add(time_series_data.getItem_value());	
		return insert(table, list);
	}

}
=======
package dao.impl;

import java.util.ArrayList;
import java.util.List;

import dao.BaseDao;
import dao.time_series_dataDao;
import entity.time_series_data;

public class time_series_dataDaoImpl extends BaseDao implements time_series_dataDao{

	@Override
	public int insert(time_series_data time_series_data) {
		// TODO Auto-generated method stub
		String table = "time_series_data";
		@SuppressWarnings("rawtypes")
		List<Comparable> list = new ArrayList<Comparable>();
		list.add(time_series_data.getUuid());
		list.add(time_series_data.getTrading_date());
		list.add(time_series_data.getStock_code());	
		list.add(time_series_data.getItem_value());	
		return insert(table, list);
	}

}
>>>>>>> c8a361cdb5bd19bc82a4ecda6a545e77ac7ef6ee
