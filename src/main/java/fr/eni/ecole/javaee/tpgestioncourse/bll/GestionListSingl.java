package fr.eni.ecole.javaee.tpgestioncourse.bll;

public class GestionListSingl {
	public static GestionListManager instance;
	
	public static GestionListManager getInstance() {
		if (instance == null) {
			instance = new GestionListManagerImpl();
		}
		return instance;
	}
}
		