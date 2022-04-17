package mainservlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.BucketList;
import service.BucketListDAO;

/**
 * Servlet implementation class MainContoller
 */
@WebServlet("/")
public class MainContoller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MainContoller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String g = request.getServletPath();
		switch(g)
		{
			case "/add" :
				insertTodo(request,response);
				break;
			
			case "/edit":
				editTodo(request,response);
				break;
	
			case "/delete":
				deleteTodo(request,response);
				break;
		}
	}

	private void deleteTodo(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		String type = request.getParameter("type");
		BucketListDAO bd = new BucketListDAO();
		String result = null;
		try {
			result = bd.deleteList(new BucketList(type));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		response.getWriter().println(result);
	}

	
	private void editTodo(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		int id = Integer.parseInt(request.getParameter("id"));
		String type = request.getParameter("type");
		String description = request.getParameter("description");
		int priority = Integer.parseInt(request.getParameter("priority"));
		
		BucketList b = new BucketList(id, type, description, priority);
		BucketListDAO bd = new BucketListDAO();
		
		try {
			bd.editList(b);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		response.sendRedirect("Index.jsp");
	}

	private void insertTodo(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		int id = Integer.parseInt(request.getParameter("id"));
		String type = request.getParameter("type");
		String description = request.getParameter("description");
		int priority = Integer.parseInt(request.getParameter("priority"));
		
		BucketList b1 = new BucketList(id, type, description, priority);
		BucketListDAO bd = new BucketListDAO();
		
		try {
			bd.addList(b1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		response.sendRedirect("Index.jsp");
	}

}
