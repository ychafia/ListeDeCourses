package fr.youness.mescourses.dao;

import java.util.List;

import fr.youness.mescourses.bean.Element;

public interface IElementDAO {
	public List<Element> consulter();
	public void ajouterElement(Element elt);
	public void supprimer(int id);
}
