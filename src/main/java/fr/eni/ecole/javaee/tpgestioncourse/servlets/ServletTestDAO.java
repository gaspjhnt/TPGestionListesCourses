package fr.eni.ecole.javaee.tpgestioncourse.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.ecole.javaee.tpgestioncourse.GestionListeExcepetion;
import fr.eni.ecole.javaee.tpgestioncourse.bll.GestionListManager;
import fr.eni.ecole.javaee.tpgestioncourse.bll.GestionListSingl;
import fr.eni.ecole.javaee.tpgestioncourse.bo.Articles;
import fr.eni.ecole.javaee.tpgestioncourse.bo.LstCourse;

/**
 * Servlet implementation class ServletTestDAO
 */
@WebServlet("/ServletTestDAO")
public class ServletTestDAO extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletTestDAO() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Articles pomme = new Articles("Pomme");
		Articles poire = new Articles("Poire");
		Articles peche = new Articles("Peche");
		List<Articles> test= new ArrayList<>();
		test.add(pomme);
		test.add(poire);
		test.add(peche);
		
		LstCourse lsttest = new LstCourse("Test1", test);
		

		GestionListManager dao = GestionListSingl.getInstance();
		
		try {
			dao.insert(lsttest);
//			dao.insert(lsttest);
//			dao.insert(lsttest);
//			dao.insert(lsttest);
//			dao.insert(lsttest);
//			dao.insert(lsttest);
//			dao.insert(lsttest);
//			dao.insert(lsttest);
//			dao.insert(lsttest);
			
		} catch (GestionListeExcepetion e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
