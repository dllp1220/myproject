

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.TypedQuery;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import model.*;
import java.util.*;



/**
 * Servlet implementation class loginservlet
 */
@WebServlet("/loginservlet")
public class loginservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public loginservlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			factory = new Configuration().configure().buildSessionFactory();
		} catch (Throwable ex) {
			System.err.println("Failed to create sessionFactory object." + ex);
			throw new ExceptionInInitializerError(ex);
		}

		Session session = factory.openSession();
		System.out.println("Session created");	 		    
		Transaction tx = session.beginTransaction();
		TypedQuery<Login> querya= session.createQuery("from login a where a.account= :account", Login.class);
		TypedQuery<Login> queryp= session.createQuery("from login a where a.password= :password", Login.class);
		querya.setParameter("account", "asd");
		queryp.setParameter("password", 123);
		List<Login> log=querya.getResultList();
		List<Login> AC=log.get(0).getAccount();
		List<Login> PS=log.get(0).getPassword();
		List<Coffee> cofss=new ArrayList<>(cofs);
		List<Login> cofss=new ArrayList<>(account);
		
		request.setAttribute("sups", sups);
		request.setAttribute("coffees", cofs);
		request.getRequestDispatcher("viewTables.jsp").forward(request, response);		
		tx.commit();


	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String u=request.getParameter("user");
		String p=request.getParameter("password");
		response.getWriter().append(u).append(":").append(p);
		doGet(request, response);
	}

}
