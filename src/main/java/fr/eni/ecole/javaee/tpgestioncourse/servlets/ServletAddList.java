package fr.eni.ecole.javaee.tpgestioncourse.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.ecole.javaee.tpgestioncourse.GestionListeExcepetion;
import fr.eni.ecole.javaee.tpgestioncourse.bll.GestionListManager;
import fr.eni.ecole.javaee.tpgestioncourse.bll.GestionListSingl;
import fr.eni.ecole.javaee.tpgestioncourse.bo.LstCourse;

/**
 * Servlet implementation class ServletAddList
 */
@WebServlet("/ServletAddList")
public class ServletAddList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletAddList() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher rd = request.getRequestDispatcher("./ServletVisualisationLst");
		rd.forward(request, response);
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		GestionListManager dao = GestionListSingl.getInstance();
//		while(valueLst.length()<1) {
		if (request.getParameter("nomLst") != null) {
			request.setAttribute("articleBool", false);
			LstCourse lst = new LstCourse();
			lst.setNom(request.getParameter("nomLst"));
			try {
				dao.insertList(lst);
			} catch (GestionListeExcepetion e) {
				request.setAttribute("listErreur", e.getListeCodesErreur());
			}
		} else {				
			try {
			request.setAttribute("valueLst", dao.selectAllLst().get(dao.selectAllLst().size() - 1).getNom());
			System.out.println("fonctionne");
			
	} catch (GestionListeExcepetion e) {
		System.out.println("vilaine erreur");
	}
		}
//		System.out.println("\n\nATTENTION C4EST ICI CIMPORTANT : " + valueLst + "\n\n");
//				System.out.println("nom lst pass null");
				

			
		
				
//		}
		
		
		RequestDispatcher rd = request.getRequestDispatcher("./WEB-INF/AddListe.jsp");
		rd.forward(request, response);
		
	}
	


}
