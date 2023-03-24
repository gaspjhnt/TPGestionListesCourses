package fr.eni.ecole.javaee.tpgestioncourse.dao;

public class GestionDAOFact {
	
	public static GestionListDAO getGestionDAO() {
		return new GestionListDAOImpl();
	}
}
