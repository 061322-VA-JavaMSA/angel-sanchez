package com.revature.DAO;

import java.io.IOException;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.exception.ConstraintViolationException;
import org.hibernate.query.NativeQuery;

import com.revature.Models.R_status;
import com.revature.Models.Reimbursement;
import com.revature.Models.User;
import com.revature.utils.HibernateUtil;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.CriteriaUpdate;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;


public class ReimbursementHibernate implements ReimbursementDAO{

	@Override
	public Reimbursement insertReimbursement(Reimbursement r) {
		// TODO Auto-generated method stub
//		r.setId(-1);
		
		try (Session s = HibernateUtil.getSessionFactory().openSession()) {
			Transaction tx = s.beginTransaction();
//			int id = (int) s.save(r);
//			r.setId(id);
			s.save(r);
			
			tx.commit();
		} catch (ConstraintViolationException e) {
			// log it
		}
		return r;
	}

	@Override
	public List<Reimbursement> getReimbursement() {
		// TODO Auto-generated method stub
		List<Reimbursement> reimbursements = null;
		
		try (Session s = HibernateUtil.getSessionFactory().openSession()) {
			reimbursements = s.createQuery("from Reimbursement", Reimbursement.class).list();
		}
		return reimbursements;
	}

	@Override
	public List<Reimbursement> getReimbursementByResolverId(int id) {
		// TODO Auto-generated method stub
		List<Reimbursement> res_reim = null;

		try (Session s = HibernateUtil.getSessionFactory().openSession()) {
			CriteriaBuilder cb = s.getCriteriaBuilder();
			CriteriaQuery<Reimbursement> cq = cb.createQuery(Reimbursement.class);
			Root<Reimbursement> root = cq.from(Reimbursement.class);

			Predicate pFromUser = cb.equal(root.get("resolver"), id);
			cq.select(root).where(pFromUser);

			res_reim = s.createQuery(cq).list();
		}
		return res_reim;
	}

	@Override
	public Reimbursement updateReimbursement(Reimbursement r) throws IOException {
		// TODO Auto-generated method stub
		try(Session s = HibernateUtil.getSessionFactory().getCurrentSession()){
			Transaction tx = s.beginTransaction();
			
//			Reimbursement ur = (Reimbursement) s.get(Reimbursement.class, r.getId());
//			System.out.println(ur);
//			ur.setStatus_id(r.getStatus_id());
//			ur.setResolver(r.getResolver());
//			System.out.println(ur);
//			s.merge(ur);
			s.update(r);
			tx.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return r;
	}

	@Override
	public List<Reimbursement> getReimbursementByStatus(Reimbursement rs) {
		// TODO Auto-generated method stub
		List<Reimbursement> stat_reim = null;

		try (Session s = HibernateUtil.getSessionFactory().openSession()) {
			CriteriaBuilder cb = s.getCriteriaBuilder();
			CriteriaQuery<Reimbursement> cq = cb.createQuery(Reimbursement.class);
			Root<Reimbursement> root = cq.from(Reimbursement.class);

			Predicate Status = cb.equal(root.get("status"), rs.getId());
			cq.select(root).where(Status);

			stat_reim = s.createQuery(cq).list();
		}
		return stat_reim;
	}

	@Override
	public List<Reimbursement> getReimbursementByAuthor(User u) {
		// TODO Auto-generated method stub
		List<Reimbursement> auth_reim = null;
		try(Session s = HibernateUtil.getSessionFactory().openSession();){
 
			CriteriaBuilder cb = s.getCriteriaBuilder();
			CriteriaQuery<Reimbursement> cq = cb.createQuery(Reimbursement.class);
			// define entity to be searched
			Root<Reimbursement> root = cq.from(Reimbursement.class);
			
			//define conditions
			Predicate predicateForReimbursementname = cb.equal(root.get("author"), u);
 
			cq.select(root).where(predicateForReimbursementname);
			cq.orderBy(cb.asc(root.get("id"))) ;
			
			auth_reim = (List<Reimbursement>)  s.createQuery(cq).getResultList();			
		}
				
		return auth_reim;
	}

	@Override
	public boolean setStatusById(int userID, User approverUser, R_status rs) {
		// TODO Auto-generated method stub
		int rowsChanged = -1;
		try(Session s = HibernateUtil.getSessionFactory().openSession()){
			System.out.println(userID);
			System.out.println(approverUser.toString());
			System.out.println(rs.toString());
			Transaction t = s.beginTransaction();
			
			CriteriaBuilder cb =s.getCriteriaBuilder();
			CriteriaUpdate<Reimbursement> cu = cb.createCriteriaUpdate(Reimbursement.class);
			Root<Reimbursement> root = cu.from(Reimbursement.class);
			
			String hql = "update reimbursement set resolver = :resolver, status_id = :status_id where id = :id ;";
			NativeQuery<User> nq = s.createNativeQuery(hql, User.class);
			nq.setParameter("id", userID);
			nq.setParameter("resolver_id", approverUser.getId());
			nq.setParameter("reimbursement_status_id", rs.getId());
			rowsChanged = nq.executeUpdate();
			
			if(rowsChanged < 1) {
				return false;
			}
		}
		return true;
	}

}
