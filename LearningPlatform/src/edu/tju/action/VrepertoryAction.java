package edu.tju.action;

import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import edu.tju.dao.VrepertoryDAO;

public class VrepertoryAction extends ActionSupport {
	
	public int vid;
	public int getVid() {
		return vid;
	}

	public void setVid(int vid) {
		this.vid = vid;
	}

	public VrepertoryDAO getVrepertoryDao() {
		return vrepertoryDao;
	}

	public void setVrepertoryDao(VrepertoryDAO vrepertoryDao) {
		this.vrepertoryDao = vrepertoryDao;
	}

	private VrepertoryDAO vrepertoryDao;
	
	public String browseVideos(){
		System.out.println("browseVideos");
		List videos = vrepertoryDao.getAllVideos();
		Map request = (Map)ActionContext.getContext().get("request");
		request.put("videos", videos);
		return SUCCESS;
	}

}
