package fr.eni.ecole.javaee.tpgestioncourse.bo;

import java.util.List;

public class LstCourse {
	private int idLstCourse;
	private String nom;
	private List<Articles> lstArticles;
	
	
	
	public LstCourse() {
		
	}
	
	public LstCourse(String nom, List<Articles> lstArticles) {
		super();
		this.nom = nom;
		this.lstArticles = lstArticles;
	}

	
	
	public LstCourse(int idLstCourse, String nom, List<Articles> lstArticles) {
		super();
		this.idLstCourse = idLstCourse;
		this.nom = nom;
		this.lstArticles = lstArticles;
	}


	public int getIdLstCourse() {
		return idLstCourse;
	}
	
	
	public void setIdLstCourse(int idLstCourse) {
		this.idLstCourse = idLstCourse;
	}
	
	
	public String getNom() {
		return nom;
	}
	
	
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	
	public List<Articles> getLstArticles() {
		return lstArticles;
	}
	
	
	public void setLstArticles(List<Articles> lstArticles) {
		this.lstArticles = lstArticles;
	}


	
	@Override
	public String toString() {
		return "LstCourse [idLstCourse=" + idLstCourse + ", nom=" + nom + ", lstArticles=" + lstArticles + "]";
	}
	
	
}
