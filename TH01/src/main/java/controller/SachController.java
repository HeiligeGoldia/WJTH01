package controller;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import dbutil.SachDbUtil;
import model.Sach;

@WebServlet("/SachController")
public class SachController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private SachDbUtil dbutil;
	
	@Resource(name="connect01")
	private DataSource dataSource;
	
	@Override
	public void init() throws ServletException {
		super.init();
		dbutil = new SachDbUtil(dataSource);
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) {
		try {
			String cmd = request.getParameter("command");
			if(cmd==null) {
				cmd="LIST";
			}
			switch(cmd) {
				case "LIST":
					list(request, response); break;
				case "ADD":
					add(request, response); break;
				case "LOAD":
					load(request, response); break;
				case "UPDATE":
					update(request, response); break;
				case "DELETE":
					delete(request, response); break;
				default:
					list(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void list(HttpServletRequest request, HttpServletResponse response) throws Exception {
		List<Sach> sachs = dbutil.getSachs();
		request.setAttribute("Sach_List", sachs);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/list-sach.jsp");
		dispatcher.forward(request, response);
	}
	
	private void add(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int id = Integer.parseInt(request.getParameter("masach"));
		String ten = request.getParameter("tensach");
		String nsx = request.getParameter("nsx");
		float gia = Float.parseFloat(request.getParameter("dongia"));
		Sach sach = new Sach (id, ten, nsx, gia);
		dbutil.addSach(sach);
		list(request, response);
	}
	
	private void load(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int id = Integer.parseInt(request.getParameter("masach"));
		Sach sach = dbutil.getSach(id);
		request.setAttribute("THE_STUDENT", sach);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/update-sach-form.jsp");
		dispatcher.forward(request, response);
	}
	
	private void update(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int id = Integer.parseInt(request.getParameter("masach"));
		String ten = request.getParameter("tensach");
		String nsx = request.getParameter("nsx");
		float gia = Float.parseFloat(request.getParameter("dongia"));
		Sach sach = new Sach (id, ten, nsx, gia);
		dbutil.updateSach(sach);
		list(request, response);
	}
	
	private void delete(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int id = Integer.parseInt(request.getParameter("masach"));
		dbutil.deleteSach(id);
		list(request, response);
	}

}
