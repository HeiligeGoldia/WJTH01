package servlet;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.annotation.Resource;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

public class TestServlet extends HttpServlet {
	
	@Resource(name="connect01")
	private DataSource dataSource;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) {
		try {
			PrintWriter out = response.getWriter();
			response.setContentType("text/plain");
			
			Connection con = null;
			Statement stmt = null;
			ResultSet rss = null;
			
			while(rss.next()) {
				String ten = rss.getString("tensach");
				out.println(ten);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
