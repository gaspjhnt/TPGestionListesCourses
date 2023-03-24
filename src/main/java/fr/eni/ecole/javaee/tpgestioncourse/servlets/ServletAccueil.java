package fr.eni.ecole.javaee.tpgestioncourse.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.digester.SystemPropertySource;

import fr.eni.ecole.javaee.tpgestioncourse.GestionListeExcepetion;
import fr.eni.ecole.javaee.tpgestioncourse.bll.GestionListManager;
import fr.eni.ecole.javaee.tpgestioncourse.bll.GestionListSingl;
//Commentaire de test pour git
/**
 * Servlet implementation class ServletAccueil
 */
@WebServlet("/ServletAccueil")
public class ServletAccueil extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletAccueil() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		GestionListManager dao = GestionListSingl.getInstance();
		if (request.getParameter("butt").contains("cart")) {
			RequestDispatcher rd = request.getRequestDispatcher("./WEB-INF/Panier.jsp");
			rd.forward(request, response);
		} else {
			String[] tab = request.getParameter("butt").split("delete");
			try {
				dao.deleteLst(Integer.parseInt(tab[1]));
			} catch (NumberFormatException e) {
				e.printStackTrace();
			} catch (GestionListeExcepetion e) {
				request.setAttribute("listErreur", e.getListeCodesErreur());
			}
			
			RequestDispatcher rd = request.getRequestDispatcher("./ServletVisualisationLst");
			rd.forward(request, response);

		}
//		RequestDispatcher rd = request.getRequestDispatcher("./ServletVisualisationLst");
//		rd.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher rd = request.getRequestDispatcher("./ServletAddList");
		rd.forward(request, response);
	}

}
