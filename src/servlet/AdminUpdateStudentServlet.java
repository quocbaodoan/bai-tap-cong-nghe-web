package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = { "/admin/student/update" })
public class AdminUpdateStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AdminUpdateStudentServlet() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		// (NgÆ°á»�i dÃ¹ng khÃ´ng bao giá»� truy cáº­p trá»±c tiáº¿p Ä‘Æ°á»£c vÃ o cÃ¡c trang JSP
		// Ä‘áº·t trong WEB-INF)
		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/UpdateStudent.jsp");

		dispatcher.forward(request, response);

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}

