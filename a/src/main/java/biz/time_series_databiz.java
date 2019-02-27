package biz;

import dao.time_series_dataDao;
import entity.time_series_data;

public interface time_series_databiz {
	public boolean addData(time_series_data data);
	public void settime_series_dataDao(time_series_dataDao dataDao);
}
