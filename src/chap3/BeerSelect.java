package chap3;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BeerSelect extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		String color = req.getParameter("color");
		BeerExpert beerExpert = new BeerExpert();
		List<String> brands = beerExpert.getBrands(color);

		req.setAttribute("styles", brands);
		RequestDispatcher view = req.getRequestDispatcher("result.jsp");
		view.forward(req, resp);

	}

}
