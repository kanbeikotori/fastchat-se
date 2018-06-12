package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONObject;

import fastchat.*;

/**
 * Servlet implementation class ChangeGroupManger
 */
@WebServlet("/ChangeGroupManager")
public class ChangeGroupManager extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChangeGroupManager() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("change group manager get method");
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("change group manager post method");
		request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
		response.setContentType("application/json;charset=UTF-8");
		PrintWriter out = response.getWriter();
		String data = request.getParameter("data");
		JSONObject jsonObject = JSONObject.parseObject(data);
		Handle handle = new Handle();
		try {
			int groupid = Integer.parseInt(jsonObject.getString("groupid"));
			String username = jsonObject.getString("username");
			 if (handle.changeManager(groupid, username)) {		
				String result = "{\"result\":\"success\"}";
				out.write(result);
			} else {
				String result = "{\"result\":\"fail\"}";
				out.write(result);
			}
		} catch (Exception e) {
			String result = "{\"result\":\"fail\"}";
			out.write(result);
		} finally {
			out.flush();  
	        out.close();
		}
	}

}