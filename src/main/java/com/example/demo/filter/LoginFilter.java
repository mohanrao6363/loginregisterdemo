package com.example.demo.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.filter.OncePerRequestFilter;

import com.example.demo.entity.LoginIdentity;
import com.example.demo.repository.LoginIdentityRepository;

@WebFilter(urlPatterns = "/start", filterName = "loginFilter")
public class LoginFilter extends OncePerRequestFilter{
	
	@Autowired
	LoginIdentityRepository loginIdentityRepository;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
		boolean check = false;
        String errorInformation = "輸入帳密有誤，請重新輸入";
		String username = request.getParameter("username");
        String password = request.getParameter("password");
        try {
        	LoginIdentity loginIdentity = loginIdentityRepository.findByAccountName(username).get();//之後要修改資料庫規則，讓帳號名稱不能有重複的出現
        	System.out.println(loginIdentity.getAccountPassword());
        	if (password.equals(loginIdentity.getAccountPassword() ) ) {
				check = true;
			}else {
				System.out.println("not correct");
				request.setAttribute("errorInformation", errorInformation);
			}
        } catch (Exception e) {
        	request.setAttribute("errorInformation", errorInformation);
			System.out.println("not find");
		}

        

		if (check) {
				filterChain.doFilter(request, response);
	        } else {
	            RequestDispatcher rd = request.getRequestDispatcher("/login_filter");
	            rd.forward(request, response);
	        }
		
	}

}
