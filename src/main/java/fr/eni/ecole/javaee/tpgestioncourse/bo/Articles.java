package fr.eni.ecole.javaee.tpgestioncourse.bo;

public class Articles {
	private int idArticle;
	private String nom;
	private boolean addCart; //DAns la dao => si addCart == true -> dans BDD addCart == 1 sinon 0;
	private int idLstCourse;
	
	
	public Articles() {
		
	}
	
	public Articles(String nom) {
		super();
		this.nom = nom;
		this.addCart = false;
	}
	
	
	public Articles(int idArticle, String nom, boolean addCart, int idLstCourse) {
		super();
		this.idArticle = idArticle;
		this.nom = nom;
		this.addCart = addCart;
		this.idLstCourse = idLstCourse;
	}


	public int getIdArticle() {
		return idArticle;
	}
	
	
	public void setIdArticle(int idArticle) {
		this.idArticle = idArticle;
	}
	
	
	public String getNom() {
		return nom;
	}
	
	
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	
	public boolean isAddCart() {
		return addCart;
	}
	
	
	public void setAddCart(boolean addCart) {
		this.addCart = addCart;
	}
	
	
	public int getIdLstCourse() {
		return idLstCourse;
	}
	
	
	public void setIdLstCourse(int idLstCourse) {
		this.idLstCourse = idLstCourse;
	}


	@Override
	public String toString() {
		return "Articles [idArticle=" + idArticle + ", nom=" + nom + ", addCart=" + addCart + ", idLstCourse="
				+ idLstCourse + "]\n";
	}
	
	
	
}
