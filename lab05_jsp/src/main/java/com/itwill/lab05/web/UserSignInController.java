package com.itwill.lab05.web;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.itwill.lab05.repository.User;
import com.itwill.lab05.service.UserService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "userSignInController",urlPatterns = {"/user/signin"})
public class UserSignInController extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
private static final Logger log = LoggerFactory.getLogger(UserSignUpController.class);
	
	private final UserService userService = UserService.INSTANCE;
	
	//TODO : 로그인에 필요한 요청 처리 메서드.
	
	//브라우저에서 로그인 클릭했을때 호출( header.jspf에서 설정한 링크)
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		log.debug("doGet()");
		//로그인 하는 폼으로 이동함
		//로그인 폼(양식)을 작성하는 뷰(jsp)로 이동(forward).jsp에서 HTML작성하기가 더 쉽기때문에 이동하는 것.
				req.getRequestDispatcher("/WEB-INF/views/user/signin.jsp")
					.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		log.debug("doPost()");
		
		
	}
	
}
