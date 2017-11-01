package fr.youness.mescourses.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import fr.youness.mescourses.util.HibernateUtil;
import fr.youness.mescourses.bean.Element;

public class ElementImpl implements IElementDAO {

	public List<Element> consulter() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		List liste_courses = new ArrayList<Element>();
		liste_courses = session.createCriteria(Element.class).list();
		session.clear();
		session.close();
		return liste_courses;
	}

	public void ajouterElement(Element elt) {
		Session session = HibernateUtil.getSessionFactory().openSession();	
		session.beginTransaction();
        session.save(elt);
        session.getTransaction().commit();
        session.clear();
        session.close();
	}
	public void supprimer(int id) {
		Session session = HibernateUtil.getSessionFactory().openSession();	
		session.beginTransaction();
		Element elt = (Element) session.load(Element.class, new Integer(id));
        session.delete(elt);
        session.getTransaction().commit();
        session.clear();
        session.close();	
	}
	@Override
	public void mettreAjour(int id) {
		Session session = HibernateUtil.getSessionFactory().openSession();	
		session.beginTransaction();
		Element elt = (Element) session.load(Element.class, new Integer(id));
		if(elt.equals("true")){
			elt.setComplete("false");
		}else{
			elt.setComplete("true");
		}
        session.update(elt);
        session.getTransaction().commit();
        session.clear();
        session.close();	
	}
}
