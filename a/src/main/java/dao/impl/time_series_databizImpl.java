package dao.impl;

import dao.time_series_dataDao;
import entity.time_series_data;
import biz.time_series_databiz;

public class time_series_databizImpl implements time_series_databiz{
	time_series_dataDao dataDao = null;
	@Override
	public boolean addData(time_series_data data) {
		int row = dataDao.insert(data);
		return row > 0 ? true : false;
	}
	@Override
	public void settime_series_dataDao(time_series_dataDao dataDao) {
		this.dataDao = dataDao;		
	}

}
