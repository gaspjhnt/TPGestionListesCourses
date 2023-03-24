package fr.eni.ecole.javaee.tpgestioncourse.servlets;

import java.io.IOException;
import java.util.List;

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
import fr.eni.ecole.javaee.tpgestioncourse.bo.LstCourse;

/**
 * Servlet implementation class ServletVisualisationLst
 */
@WebServlet("/ServletVisualisationLst")
public class ServletVisualisationLst extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletVisualisationLst() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		GestionListeExcepetion gle = new GestionListeExcepetion();
		GestionListManager dao = GestionListSingl.getInstance();
		try {
			List<LstCourse> lst = dao.selectAllLst();
			request.setAttribute("lstCourse", lst);
		} catch (GestionListeExcepetion e) {
			request.setAttribute("listErreur", e.getListeCodesErreur());
		}
		RequestDispatcher rd = request.getRequestDispatcher("./WEB-INF/Accueil.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
