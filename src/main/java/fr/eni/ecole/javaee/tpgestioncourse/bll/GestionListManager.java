package fr.eni.ecole.javaee.tpgestioncourse.bll;

import java.util.List;

import fr.eni.ecole.javaee.tpgestioncourse.GestionListeExcepetion;
import fr.eni.ecole.javaee.tpgestioncourse.bo.Articles;
import fr.eni.ecole.javaee.tpgestioncourse.bo.LstCourse;

public interface GestionListManager {

	
	public void insert(LstCourse lst) throws GestionListeExcepetion;
	
	public void insertList(LstCourse lst) throws GestionListeExcepetion;
	
	public void insertArticles(Articles article, int id) throws GestionListeExcepetion;
	
	public List<LstCourse> selectAll() throws GestionListeExcepetion;
	
	public List<LstCourse> selectAllLst() throws GestionListeExcepetion;
	
	public List<Articles> selectAllArticleOf(LstCourse lst) throws GestionListeExcepetion;
	
	public void updateArticles(Articles article) throws GestionListeExcepetion;

	public void updateLst(LstCourse lst) throws GestionListeExcepetion;
	
	public void deleteLst(int id) throws GestionListeExcepetion;
	
	public void deleteArticle(int id) throws GestionListeExcepetion;
}
