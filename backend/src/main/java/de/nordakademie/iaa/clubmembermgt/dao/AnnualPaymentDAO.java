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
        System.out.println("Club Member Id for query: "+ refClubMemberId);
        TypedQuery<AnnualPayment> annual = entityManager.createQuery("select annualPayment from AnnualPayment annualPayment where annualPayment.clubMemberId = ?1" , AnnualPayment.class);
        return annual.setParameter(1, refClubMemberId).getResultList();
    }

    @PersistenceContext
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


}
