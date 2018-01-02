package fr.youness.mescourses.dao;

import org.hibernate.Session;

import fr.youness.mescourses.bean.Utilisateur;
import fr.youness.mescourses.util.HibernateUtil;

public class UtilisateurImpl implements IUtilisateur {

	@Override
	public boolean seConnecter(Utilisateur u) {
		boolean autoriser = false;
		Session session = HibernateUtil.getSessionFactory().openSession();	
		session.beginTransaction();
        Utilisateur user = (Utilisateur)session.load(Utilisateur.class, new String(u.getIdentifiant()));
        if(user == null){
        	autoriser = false;
        }else{
        	autoriser = true;
        }
        session.getTransaction().commit();
        session.clear();
        session.close();
		return autoriser;
	}

}
