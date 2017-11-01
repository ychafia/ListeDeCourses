package fr.youness.mescourses.bean;

public class Element {
	private int idElement;
	private String nomElement;
	private String complete;

	public Element() {
		super();
	}

	public Element(int idElement, String nomElement) {
		super();
		this.idElement = idElement;
		this.nomElement = nomElement;
	}

	public int getIdElement() {
		return idElement;
	}

	public void setIdElement(int idElement) {
		this.idElement = idElement;
	}

	public String getNomElement() {
		return nomElement;
	}

	public void setNomElement(String nomElement) {
		this.nomElement = nomElement;
	}
	
	public String getComplete() {
		return complete;
	}

	public void setComplete(String complete) {
		this.complete = complete;
	}
}
