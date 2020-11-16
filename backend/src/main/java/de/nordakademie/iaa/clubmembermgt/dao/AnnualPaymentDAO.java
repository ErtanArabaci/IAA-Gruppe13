package de.nordakademie.iaa.clubmembermgt.dao;

import de.nordakademie.iaa.clubmembermgt.model.AnnualPayment;
import org.hibernate.exception.ConstraintViolationException;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
public class AnnualPaymentDAO {
    private EntityManager entityManager;

    public void persistClubMember(AnnualPayment annualPayment) throws ConstraintViolationException {
        entityManager.persist(annualPayment);
    }


    public List<AnnualPayment> listAnnualPaymentsForClubMemberId(Long refClubMemberId) {
        TypedQuery<AnnualPayment> annual = entityManager.createQuery("select annualPayment from AnnualPayment annualPayment where annualPayment.clubMemberId = ?1", AnnualPayment.class);
        return annual.setParameter(1, refClubMemberId).getResultList();
    }

    public AnnualPayment loadAnnualPayment(Long id) {
        return entityManager.find(AnnualPayment.class, id);
    }

    @PersistenceContext
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


    public List<AnnualPayment> listAnnualPayments() {
        return entityManager.createQuery("select annualPayment from AnnualPayment annualPayment").getResultList();
    }

    public void createAnnualPayment(AnnualPayment annualPayment) {
        persistAnnualPayment(annualPayment);
    }

    public void updateAnnualPayment(AnnualPayment annualPayment) {
        entityManager.merge(annualPayment);
    }

    public void deleteAnnualPayment(Long id) {
        entityManager.remove(entityManager.find(AnnualPayment.class, id));
    }

    public void persistAnnualPayment(AnnualPayment annualPayment) throws ConstraintViolationException {
        entityManager.persist(annualPayment);
    }
}
