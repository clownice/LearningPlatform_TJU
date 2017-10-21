package edu.tju.action;

import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import edu.etju.model.Admin;
import edu.etju.model.Student;
import edu.etju.model.Teacher;
import edu.tju.dao.AdminDAO;
import edu.tju.dao.StudentDAO;
import edu.tju.dao.TeacherDAO;

public class MLoginPageAction extends ActionSupport{

	

	/**
	 * 
	 */
	private static final long serialVersionUID = -4488490707700353977L;

	public String loginname;
	public String password;
	public String forward;
	public String imgcheck;
	public String rolecheck;
	private AdminDAO admindao;
	private TeacherDAO teacherdao;
	private StudentDAO studentdao;

	
	public AdminDAO getAdmindao() {
		return admindao;
	}

	public void setAdmindao(AdminDAO admindao) {
		this.admindao = admindao;
	}

	public TeacherDAO getTeacherdao() {
		return teacherdao;
	}

	public void setTeacherdao(TeacherDAO teacherdao) {
		this.teacherdao = teacherdao;
	}

	public StudentDAO getStudentdao() {
		return studentdao;
	}

	public void setStudentdao(StudentDAO studentdao) {
		this.studentdao = studentdao;
	}
	
	public String getRolecheck() {
		return rolecheck;
	}

	public void setRolecheck(String rolecheck) {
		this.rolecheck = rolecheck;
	}
	
	public void checkUser() throws Exception
	{
		int loginid = Integer.parseInt(loginname);
		HttpServletResponse response = ServletActionContext.getResponse();  
        response.setContentType("text/html;charset=UTF-8");  
        PrintWriter out = response.getWriter(); 
        
		if(rolecheck.equals("guanliyuan") ){	
			//管理员判定
			Admin admin = admindao.checkAdmin(loginid);
			if(admin != null && password.equals(admin.getApassword())){
				out.print("admin success");
				out.close();
			}
		}
		else if(rolecheck.equals("student")){
			
			//学生判定
			Student student = studentdao.checkStudent(loginname);
			if(student != null && password.equals(student.getSpassword())){
				out.print("student success");
				out.close();
			}
			
		}
		else if(rolecheck.equals("teacher")){
			//教师判定
			System.out.println(loginname);
			Teacher teacher = teacherdao.checkTeacher(loginname);
			
			if(teacher != null && password.equals(teacher.getTpassword())){
				out.print("teacher success");
				out.close();
			}
			
		}
		else
		{
			out.print("error");
			out.close();
		}				
	}

	public String getLoginname() {
		return loginname;
	}

	public void setLoginname(String loginname) {
		this.loginname = loginname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getForward() {
		return forward;
	}

	public void setForward(String forward) {
		this.forward = forward;
	}

	public String getImgcheck() {
		return imgcheck;
	}

	public void setImgcheck(String imgcheck) {
		this.imgcheck = imgcheck;
	}
	
}
