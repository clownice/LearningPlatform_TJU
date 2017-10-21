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

public class LoginPageAction extends ActionSupport{

	

	/**
	 * 
	 */
	private static final long serialVersionUID = 2998034267890020001L;
	public String loginname;
	public String password;
	public String forward;
	public String imgcheck;
	public String rolecheck;
	private AdminDAO admindao;
	private TeacherDAO teacherdao;
	private StudentDAO studentdao;
	public final int FIRSTLEVEL = 21013001;
	public final int SECONDLEVEL = 61013001;
	
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
	
	public String checkUser() throws Exception
	{
		/*
		//方式一： 将参数作为Ａction的类属性，让OGNL自动填充  
        
        System.out.println("方法一，把参数作为Action的类属性,让OGNL自动填充：");  
        System.out.println("bookName: "+this.bookName);  
        System.out.println("bookPrice: " +this.bookPrice);  
          
          
        //方法二:在Action中使用ActionContext得到parameterMap获取参数:  
        ActionContext context=ActionContext.getContext();  
        Map  parameterMap=context.getParameters();  
          
        String bookName2[]=(String[])parameterMap.get("bookName");  
        String bookPrice2[]=(String[])parameterMap.get("bookPrice");  
          
        System.out.println("方法二，在Action中使用ActionContext得到parameterMap获取参数：");  
        System.out.println("bookName: " +bookName2[0]);  
        System.out.println("bookPrice: " +bookPrice2[0]);  
          
          
        //方法三:在Action中取得HttpServletRequest对象，使用request.getParameter获取参数  
        HttpServletRequest request = (HttpServletRequest)context.get(ServletActionContext.HTTP_REQUEST);   
        HttpServletRequest request = ServletActionContext.getRequest();
		Map session = ActionContext.getContext().getSession();
		loginname = request.getParameter("loginname");
		System.out.println(loginname);   
        String bookName=request.getParameter("bookName");  
        String bookPrice=request.getParameter("bookPrice");  
          
        System.out.println("方法三，在Action中取得HttpServletRequest对象，使用request.getParameter获取参数：");  
        System.out.println("bookName: " +bookName);  
        System.out.println("bookPrice: " +bookPrice);  
        return SUCCESS;  

		*/
		System.out.println(loginname + password+ forward + imgcheck + rolecheck);
		Map session = ActionContext.getContext().getSession();
		String status = "";
		int loginid = Integer.parseInt(loginname);
		
		/*HttpServletResponse response = ServletActionContext.getResponse();  
        response.setContentType("text/html;charset=UTF-8");  
        PrintWriter out = response.getWriter(); */
        
		if(rolecheck.equals("guanliyuan") ){	
			//管理员判定
			Admin admin = admindao.checkAdmin(loginid);
			if(admin != null && password.equals(admin.getApassword())){
				
				status = "Admin";
				session.put("Admin", admin);
				//out.print("success");
				//out.close();
			}
			else
			{
				System.out.println("管理员判定错误");
				status = ERROR;
			}
		}
		else if(rolecheck.equals("student")){
			
			//学生判定
			Student student = studentdao.checkStudent(loginname);
			if(student != null && password.equals(student.getSpassword())){
				status = "Student";
				session.put("Student", student);
				session.get("Student");
			}
			else
			{
				System.out.println("学生判定错误");
				status = ERROR;
			}
			
		}
		else if(rolecheck.equals("teacher")){
			//教师判定
			System.out.println(loginname);
			Teacher teacher = teacherdao.checkTeacher(loginname);
			
			if(teacher != null && password.equals(teacher.getTpassword())){
				status = "Teacher";
				session.put("Teacher", teacher);
			}
			else
			{
				System.out.println("老师判定错误");
				status = ERROR;
			}
			
		}
		else
		{
			status = ERROR;
		}
		System.out.println("status");	
		return status;
		
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
