package com.revature.DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.exception.ConstraintViolationException;

import com.revature.Models.Reimbursement;
import com.revature.utils.HibernateUtil;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;


public class ReimbursementHibernate implements ReimbursementDAO{

	@Override
	public Reimbursement insertReimbursement(Reimbursement r) {
		// TODO Auto-generated method stub
		try (Session s = HibernateUtil.getSessionFactory().openSession()) {
			Transaction tx = s.beginTransaction();
			int id = (int) s.save(r);
			r.setId(id);
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
	public Reimbursement updateReimbursement(Reimbursement r) {
		// TODO Auto-generated method stub
		try(Session s = HibernateUtil.getSessionFactory().getCurrentSession()){
			
		}
		return null;
	}

	@Override
	public List<Reimbursement> getReimbursementByStatus(Reimbursement rs) {
		// TODO Auto-generated method stub
		List<Reimbursement> stat_reim = null;

		try (Session s = HibernateUtil.getSessionFactory().openSession()) {
			CriteriaBuilder cb = s.getCriteriaBuilder();
			CriteriaQuery<Reimbursement> cq = cb.createQuery(Reimbursement.class);
			Root<Reimbursement> root = cq.from(Reimbursement.class);

			Predicate pFromStatus = cb.equal(root.get("status"), rs.getId());
			cq.select(root).where(pFromStatus);

			stat_reim = s.createQuery(cq).list();
		}
		return stat_reim;
	}

}
