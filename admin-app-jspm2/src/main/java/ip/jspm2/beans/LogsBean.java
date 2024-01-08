package ip.jspm2.beans;

import java.io.Serializable;
import java.util.ArrayList;

import ip.jspm2.dao.LogsDAO;
import ip.jspm2.dto.Log;

public class LogsBean implements Serializable {

	public LogsBean() {
		// TODO Auto-generated constructor stub
	}
	
	public ArrayList<Log> getAllLogs() {
		return LogsDAO.getAllLogs();
	}

}
