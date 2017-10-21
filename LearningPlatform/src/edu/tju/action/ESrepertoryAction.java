package edu.tju.action;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import edu.tju.dao.EsrepertoryDAO;

public class ESrepertoryAction extends ActionSupport{
	
	public int page;
	public int numbercount;
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getNumbercount() {
		return numbercount;
	}
	public void setNumbercount(int numbercount) {
		this.numbercount = numbercount;
	}
	private EsrepertoryDAO esrepertorydao;
	
	public String browsePagedExercise(){
		HttpServletRequest request1 = ServletActionContext.getRequest();
		
		Map request = (Map)ActionContext.getContext().get("request");
		
		System.out.println(page + numbercount );
		//String page1 = (String) request1.getAttribute("page");
		//String numbercount1 = (String) request1.getAttribute("numbercount");
		//System.out.println(page1 + "   " + numbercount1);
		List exercises = esrepertorydao.showAllSelectionExercise(page, numbercount);
		System.out.println("Esrepertorydao wancheng" );

		request.put("exercises", exercises);
		
		return SUCCESS;
		
		
		
		
		
	}
	public EsrepertoryDAO getEsrepertorydao() {
		return esrepertorydao;
	}
	public void setEsrepertorydao(EsrepertoryDAO esrepertorydao) {
		this.esrepertorydao = esrepertorydao;
	}
	public ESrepertoryAction() {
		// TODO Auto-generated constructor stub
	}

}
