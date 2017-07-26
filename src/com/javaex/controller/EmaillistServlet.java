package com.javaex.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javaex.dao.EmaillistDao;
import com.javaex.vo.EmaillistVo;



@WebServlet("/el")
public class EmaillistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String actionName=request.getParameter("a");//a로 이 계획의 목적을 알아내겠다는 뜻
		if("form".equals(actionName)) {//처리는 form.jsp에서 처리
			
			RequestDispatcher rd=request.getRequestDispatcher("form.jsp");
			rd.forward(request, response);
			
			System.out.println("form출력");//form의 포워드
		
		}else if("insert".equals(actionName)) {
			System.out.println("저장관련");//request안에서 데이터를 꺼냄
			String firstName=request.getParameter("fn");
			String lastName=request.getParameter("ln");
			String email=request.getParameter("email");
			
			EmaillistVo vo=new EmaillistVo(firstName,lastName,email);//get값들을 받아서 정리[포장]
			
			EmaillistDao dao=new EmaillistDao();
			dao.insert(vo);
			
			response.sendRedirect("/emaillist2/el");//사용자에게 날아감 다시신청후 디폴트로 날아감.(인서트후에 반응할 화면이 없으므로 다시신청하세요를 설정 근데 그값에 a가 없으므로 디폴트로 변환[한번깜빡])
			
			
		}else {
			System.out.println("기본값 리스트");
			EmaillistDao dao=new EmaillistDao();
			List<EmaillistVo> list=dao.getList();//리스트를 받는 메소드
			
			request.setAttribute("list", list);//request에다 list를 set해놓음
			
			RequestDispatcher rd=request.getRequestDispatcher("list.jsp");//리스트를 가져옴
			rd.forward(request, response);
			
		}
		/*System.out.println(actionName);*/
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
