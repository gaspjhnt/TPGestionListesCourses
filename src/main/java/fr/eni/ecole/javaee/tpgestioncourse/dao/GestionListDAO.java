package fr.eni.ecole.javaee.tpgestioncourse.dao;

import java.util.List;

import fr.eni.ecole.javaee.tpgestioncourse.GestionListeExcepetion;
import fr.eni.ecole.javaee.tpgestioncourse.bo.Articles;
import fr.eni.ecole.javaee.tpgestioncourse.bo.LstCourse;

public interface GestionListDAO {

	public void insertLst(LstCourse lst) throws GestionListeExcepetion;
	
	public void insertArticle(Articles article, int id) throws GestionListeExcepetion;
	
	public List<Articles> selectArticles(LstCourse lst) throws GestionListeExcepetion; //On récupère tous les articles de la liste
	
	public List<LstCourse> selectLst() throws GestionListeExcepetion; // => pour la page d'accueil pour pas faire une trop grosse
										// requête a la bdd on deamnde juste le nom de la list
	
	public void updateArticles(Articles article) throws GestionListeExcepetion; // Passer de coché a non coché
	
	public void updateLst(LstCourse lst) throws GestionListeExcepetion; // Pour retirer ou ajouter un article a cette liste en question
	
	public void deleteArticles(int id) throws GestionListeExcepetion;  // Supprimé un article dans la bdd quand il n'existe plus
													// Après l'avoir update? ou avant jsp encore surement a mettre en BLL
	
	public void deleteLst(int id) throws GestionListeExcepetion; // Supprimé une liste
}
