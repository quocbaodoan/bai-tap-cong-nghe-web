package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDAO;
import model.User;

@WebServlet(name = "HandleAdminUpdateStudent", urlPatterns = { "/HandleAdminUpdateStudent" })
public class HandleAdminUpdateStudent extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");

		try {

			User student = new User();
			student.setUsername(request.getParameter("username"));
			student.setPassword(request.getParameter("password"));
			student.setFirstname(request.getParameter("firstname"));
			student.setLastname(request.getParameter("lastname"));

			UserDAO.update(student);

			response.sendRedirect("/");

		} catch (Exception e) {
			System.out.println("Request err: " + e.getMessage());
		}

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
