

import java.io.IOException;

import javax.persistence.TypedQuery;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import model.*;
import java.util.*;
/**
 * Servlet implementation class SupplierCoffeeServlet
 */
@WebServlet("/SupplierCoffeeServlet")
public class SupplierCoffeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	SessionFactory factory;   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SupplierCoffeeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			factory = new Configuration().configure().buildSessionFactory();
		} catch (Throwable ex) {
			System.err.println("Failed to create sessionFactory object." + ex);
			throw new ExceptionInInitializerError(ex);
		}

		Session session = factory.openSession();
		System.out.println("Session created");	 		    
		Transaction tx = session.beginTransaction();
		TypedQuery<Supplier> query= session.createQuery("from Supplier a where a.supId= :sup_id", Supplier.class);
		query.setParameter("sup_id", 49);
		List<Supplier> sups=query.getResultList();
		List<Coffee> cofs=sups.get(0).getCoffees();
		List<Coffee> cofss=new ArrayList<>(cofs);
		request.setAttribute("sups", sups);
		request.setAttribute("coffees", cofs);
		request.getRequestDispatcher("viewTables.jsp").forward(request, response);		
		tx.commit();


	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
