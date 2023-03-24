package fr.eni.ecole.javaee.tpgestioncourse.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.eni.ecole.javaee.tpgestioncourse.GestionListeExcepetion;
import fr.eni.ecole.javaee.tpgestioncourse.bo.Articles;
import fr.eni.ecole.javaee.tpgestioncourse.bo.LstCourse;

class GestionListDAOImpl implements GestionListDAO{
	
	private static final String INSERT_LST="INSERT INTO listcourse(nom) VALUES (?)";
	private static final String SELECT_LST="SELECT idListCourse, nom FROM listcourse";
	private static final String UPDATE_LST="UPDATE listCourse SET Nom=? WHERE idListcourse = ?";
	private static final String DELETE_LST="DELETE FROM listCourse WHERE idListcourse=?";
	
	private static final String INSERT_ARTICLE="INSERT INTO articles(nom, AjouterPanier, ListCourse_idListCourse) VALUES (?,?,?)";
	private static final String SELECT_ARTICLE="SELECT idArticles, nom, AjouterPanier, ListCourse_idListCourse FROM articles";
	private static final String UPDATE_ARTICLE="UPDATE articles SET Nom=?, AjouterPanier=? WHERE idArticles = ?";
	private static final String DELETE_ARTICLE="DELETE FROM articles WHERE idArticles=?";

	
	
	
	public void insertLst(LstCourse lst) throws GestionListeExcepetion {
		GestionListeExcepetion gle = new GestionListeExcepetion();
		try(Connection con = ConnectionProvider.getConnection()){
			PreparedStatement stmt = con.prepareStatement(INSERT_LST,Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1, lst.getNom());
			int nb = stmt.executeUpdate();
			if(nb>0) {
				ResultSet rs = stmt.getGeneratedKeys();
				if(rs.next()) {
					lst.setIdLstCourse(rs.getInt(1));
				}
			}
			
			
			
		}catch (SQLException e){
			e.printStackTrace();
			gle.ajouterErreur("problème à l'insertion de la donnée (LstCourse)");
			throw gle;
		}
		
	}
	
	public void insertArticle(Articles article, int id) throws GestionListeExcepetion{
		GestionListeExcepetion gle = new GestionListeExcepetion();
		try(Connection con = ConnectionProvider.getConnection()){
			PreparedStatement stmt = con.prepareStatement(INSERT_ARTICLE,Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1, article.getNom());
			if (article.isAddCart()) {
				stmt.setInt(2, 1);
			} else {
				stmt.setInt(2, 0);
			}
			stmt.setInt(3, id);
			int nb = stmt.executeUpdate();
			if(nb>0) {
				ResultSet rs = stmt.getGeneratedKeys();
				if(rs.next()) {
					article.setIdArticle(rs.getInt(1));
				}
			}
			
			
			
		}catch (SQLException e){
			e.printStackTrace();
			gle.ajouterErreur("problème à l'insertion de la donnée (Articles)");
			throw gle;
		}
	}
	


// idArticles, nom, AjouterPanier, ListCourse_idListCourse FROM articles";
	@Override
	public List<Articles> selectArticles(LstCourse lst) throws GestionListeExcepetion {
		GestionListeExcepetion gle = new GestionListeExcepetion();
		List<Articles> result = new ArrayList<>();
		try(Connection con = ConnectionProvider.getConnection()){
			PreparedStatement stmt = con.prepareStatement(SELECT_ARTICLE);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				Articles article = new Articles();
				article.setNom(rs.getString("nom"));
				article.setIdArticle(rs.getInt("idArticles"));
				if (rs.getInt("AjouterPanier") == 1) {
					article.setAddCart(true);
				} else {
					article.setAddCart(false);
				}
				article.setIdLstCourse(rs.getInt("ListCourse_idListCourse"));
				
				result.add(article);
			}
			
			
		}catch (SQLException e){
			e.printStackTrace();
			gle.ajouterErreur("Problème à la selection des données (SelectArticles)");
			throw gle;
		}
		return result;
	}
	
	
	@Override
	public List<LstCourse> selectLst() throws GestionListeExcepetion {
		GestionListeExcepetion gle = new GestionListeExcepetion();
		List<LstCourse> result = new ArrayList<>();
		try(Connection con = ConnectionProvider.getConnection()){
			PreparedStatement stmt = con.prepareStatement(SELECT_LST);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				LstCourse lst = new LstCourse();
				lst.setIdLstCourse(rs.getInt("idListCourse"));
				lst.setNom(rs.getString("nom"));
				
				result.add(lst);
			}
			
			
		}catch (SQLException e){
			e.printStackTrace();
			gle.ajouterErreur("Problème à la selection des données (SelectArticles)");
			throw gle;
		}
		return result;
	}

	
	
	
	//"UPDATE articles SET Nom=?, AjouterPanier=? WHERE idArticles = ?";
	@Override
	public void updateArticles(Articles article) throws GestionListeExcepetion {
		GestionListeExcepetion gle = new GestionListeExcepetion();
		try(Connection con = ConnectionProvider.getConnection()){
			PreparedStatement stmt = con.prepareStatement(UPDATE_ARTICLE);
			stmt.setString(1, article.getNom());
			if (article.isAddCart()) {
				stmt.setInt(2, 1);
			} else {
				stmt.setInt(2, 0);
			}
			stmt.setInt(3, article.getIdArticle());
			System.out.println(article.getNom() + "  -  " + article.getIdArticle() + "   -  " + article.isAddCart());
			stmt.executeUpdate();
			
			
			
		}catch (SQLException e){
			e.printStackTrace();
			gle.ajouterErreur("Problème à la modification des données (Articles)");
			throw gle;
		}
	}
	

	
	//"UPDATE listCourse SET Nom=? WHERE idListcourse = ?";
	@Override
	public void updateLst(LstCourse lst) throws GestionListeExcepetion {
		GestionListeExcepetion gle = new GestionListeExcepetion();
		try(Connection con = ConnectionProvider.getConnection()){
			PreparedStatement stmt = con.prepareStatement(UPDATE_LST);
			stmt.setString(1, lst.getNom());
			stmt.setInt(2, lst.getIdLstCourse());
			stmt.executeUpdate();
			
			
			
		}catch (SQLException e){
			e.printStackTrace();
			gle.ajouterErreur("Problème à la modification des données (ListCourse)");
			throw gle;
		}
	}
	

	@Override
	public void deleteArticles(int id) throws GestionListeExcepetion {
		GestionListeExcepetion gle = new GestionListeExcepetion();
		try(Connection con = ConnectionProvider.getConnection()){
			PreparedStatement stmt = con.prepareStatement(DELETE_ARTICLE);
			stmt.setInt(1, id);
			stmt.executeUpdate();
			
			
			
		}catch (SQLException e){
			e.printStackTrace();
			gle.ajouterErreur("Problème à la supression des données (Articles)");
			throw gle;
		}
	}

	
	
	@Override
	public void deleteLst(int id) throws GestionListeExcepetion {
		GestionListeExcepetion gle = new GestionListeExcepetion();
		try(Connection con = ConnectionProvider.getConnection()){
			PreparedStatement stmt = con.prepareStatement(DELETE_LST);
			stmt.setInt(1, id);
			stmt.executeUpdate();
			
			
			
		}catch (SQLException e){
			e.printStackTrace();
			gle.ajouterErreur("Problème à la supression des données (ListCourse)");
			throw gle;
		}
	}

}
