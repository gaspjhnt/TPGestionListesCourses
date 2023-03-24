package fr.eni.ecole.javaee.tpgestioncourse.bll;

import java.util.ArrayList;
import java.util.List;

import fr.eni.ecole.javaee.tpgestioncourse.GestionListeExcepetion;
import fr.eni.ecole.javaee.tpgestioncourse.bo.Articles;
import fr.eni.ecole.javaee.tpgestioncourse.bo.LstCourse;
import fr.eni.ecole.javaee.tpgestioncourse.dao.GestionDAOFact;
import fr.eni.ecole.javaee.tpgestioncourse.dao.GestionListDAO;

class GestionListManagerImpl implements GestionListManager{

	private GestionListDAO dao = GestionDAOFact.getGestionDAO();
	
	
	@Override
	public void insert(LstCourse lst) throws GestionListeExcepetion {
		GestionListeExcepetion gle = new GestionListeExcepetion();
		verifInsertAll(lst, gle);
		
		if (!gle.hasErreurs()) {
			dao.insertLst(lst);
			for (Articles article: lst.getLstArticles()) {
				dao.insertArticle(article, lst.getIdLstCourse());
			}
		} else {
			throw gle;
		}
		
	}

	@Override
	public void insertList(LstCourse lst) throws GestionListeExcepetion {
		GestionListeExcepetion gle = new GestionListeExcepetion();

		verifInsertLST(lst, gle);
		
		
		if (!gle.hasErreurs()) {
			dao.insertLst(lst);
		} else {
			throw gle;
		}
		
	}

	@Override
	public void insertArticles(Articles article, int id) throws GestionListeExcepetion {
		GestionListeExcepetion gle = new GestionListeExcepetion();

		verifInsertArticles(article, gle);
		
		
		if (!gle.hasErreurs()) {
			try {
				dao.insertArticle(article, id);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			throw gle;
		}
		
	}

	@Override
	public List<LstCourse> selectAll() throws GestionListeExcepetion {
		GestionListeExcepetion gle = new GestionListeExcepetion();
		
		verifSelectAll(gle);
		
		
		if (!gle.hasErreurs()) {
			List<LstCourse> lstCourse = dao.selectLst();
			for (LstCourse element : lstCourse) {
				element.setLstArticles(dao.selectArticles(element));
			}
			
			return lstCourse;
		} else {
			throw gle;
		}
		
	}

	@Override
	public List<LstCourse> selectAllLst() throws GestionListeExcepetion {
		GestionListeExcepetion gle = new GestionListeExcepetion();
		
		if (!gle.hasErreurs()) {
			return dao.selectLst();
		} else {
			throw gle;
		}
		
	}
	
	
	
	@Override
	public List<Articles> selectAllArticleOf(LstCourse lst) throws GestionListeExcepetion {
		GestionListeExcepetion gle = new GestionListeExcepetion();
		
		verifSelectAllArticle(lst, gle);
		
		if (!gle.hasErreurs()) {
			return dao.selectArticles(lst);
		} else {
			throw gle;
		}
		
	}
	
	
	@Override
	public void updateLst(LstCourse lst) throws GestionListeExcepetion {
		GestionListeExcepetion gle = new GestionListeExcepetion();
		
		verifUpdateLst(lst, gle);
		
		
		
		if (!gle.hasErreurs()) {
			dao.updateLst(lst);
		} else {
			throw gle;
		}
		
	}
	


	@Override
	public void updateArticles(Articles article) throws GestionListeExcepetion {
		GestionListeExcepetion gle = new GestionListeExcepetion();
		
		verifUpdateArticle(article, gle);
		
		
		if (!gle.hasErreurs()) {
			dao.updateArticles(article);
		} else {
			throw gle;
		}
		
	}
	
	
	@Override
	public void deleteLst(int id) throws GestionListeExcepetion {
		GestionListeExcepetion gle = new GestionListeExcepetion();
		
		verifDeleteLSt(id, gle);
		
		
		
		
		if (!gle.hasErreurs()) {
			dao.deleteLst(id);
		} else {
			throw gle;
		}
		
	}

	@Override
	public void deleteArticle(int id) throws GestionListeExcepetion {
		GestionListeExcepetion gle = new GestionListeExcepetion();
		
		verifDeleteArticle(id, gle);
		
		
		if (!gle.hasErreurs()) {
			dao.deleteArticles(id);
		} else {
			throw gle;
		}
		
	}
	
	
	
	
	
	//VERIFS


	private void verifInsertAll(LstCourse lst, GestionListeExcepetion gle) {
		verifInsertLST(lst, gle);
		
		for(Articles article : lst.getLstArticles()) {
			verifInsertArticles(article, gle);
		}
	}
	
	


	private void verifInsertLST(LstCourse lst, GestionListeExcepetion gle) {
		if (lst.getNom().length()>250) {
			gle.ajouterErreur("Nom de liste trop grand");
		}
		
//		if (lst.getLstArticles().size()<1) {
//			gle.ajouterErreur("Aucun article dans la liste.");
//		}
	}
	
	


	private void verifInsertArticles(Articles article, GestionListeExcepetion gle) {
		if (article.getNom().length()>250) {
			gle.ajouterErreur("Nom d'article trop grand");
		}
	}

	
	


	private void verifSelectAll(GestionListeExcepetion gle) throws GestionListeExcepetion {
		if (dao.selectLst().size()<1) {
			gle.ajouterErreur("Äucune liste créée.");
		}
		

		List<LstCourse> lstCourseVerif = dao.selectLst();
		for (LstCourse element : lstCourseVerif) {
			if (dao.selectArticles(element).size()<1) {
				gle.ajouterErreur("Aucun article pour cette liste : " + element);
			}
		}
	}
	
	
	



	


	private void verifSelectAllArticle(LstCourse lst, GestionListeExcepetion gle) throws GestionListeExcepetion {
		if (!dao.selectLst().contains(lst)) {
			gle.ajouterErreur("Liste introuvable.");
		}
		
		if (dao.selectArticles(lst).size()<1) {
			gle.ajouterErreur("Pas d'article correspondant a cette liste.");
		}
	}
	
	


	private void verifUpdateLst(LstCourse lst, GestionListeExcepetion gle) throws GestionListeExcepetion {
		List<Integer> listId = new ArrayList<>();
		
		for(LstCourse element: dao.selectLst()) {
			listId.add(element.getIdLstCourse());
		}

		if (!dao.selectLst().contains(lst)) {
			gle.ajouterErreur("Liste introuvable");
		}
	}
	


	private void verifUpdateArticle(Articles article, GestionListeExcepetion gle) throws GestionListeExcepetion {
		if (article.getIdLstCourse() == 0 ) {
			gle.ajouterErreur("Impossible de trouver l'article");
		}

		List<Integer> listId = new ArrayList<>();
		for (LstCourse lst: dao.selectLst()) {
			listId.add(lst.getIdLstCourse());
		}
		
		if (!listId.contains(article.getIdLstCourse())) {
			gle.ajouterErreur("Impossible de trouver l'article");
		}
	}
	


	private void verifDeleteArticle(int id, GestionListeExcepetion gle) throws GestionListeExcepetion {
		if (id != 0 ) {
			gle.ajouterErreur("Impossible de trouver l'article");
		}

	}
	


	private void verifDeleteLSt(int id, GestionListeExcepetion gle) throws GestionListeExcepetion {
			
			List<Integer> listId = new ArrayList<>();
		
			for (LstCourse lst : dao.selectLst()) {
				listId.add(lst.getIdLstCourse());
			}
			

			if (!listId.contains(id)) {
				gle.ajouterErreur("Liste introuvable");
			}
	}

}
