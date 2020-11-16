package de.nordakademie.iaa.clubmembermgt.dao;

import de.nordakademie.iaa.clubmembermgt.model.AnnualPayment;
import org.hibernate.exception.ConstraintViolationException;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

/**
 * The annualPayment DAO that manages all persistence functionality.
 *
 * @author Kim Bartikowski, Ertan Arabaci, Torben Labs
 */
@Transactional
public class AnnualPaymentDAO {
    private EntityManager entityManager;

    /**
     * Saves entity in the data base
     *
     * @param annualPayment the club member to be saved
     */
    public void persistClubMember(AnnualPayment annualPayment) throws ConstraintViolationException {
        entityManager.persist(annualPayment);
    }

    /**
     * Gives a list of annualPayments from the database
     *
     * @param refClubMemberId the id of the refered club member
     * @return a list of annualPayments
     */
    public List<AnnualPayment> listAnnualPaymentsForClubMemberId(Long refClubMemberId) {
        TypedQuery<AnnualPayment> annual = entityManager.createQuery("select annualPayment from AnnualPayment annualPayment where annualPayment.clubMemberId = ?1", AnnualPayment.class);
        return annual.setParameter(1, refClubMemberId).getResultList();
    }

    /**
     * Loads a single annualPayment from the database
     *
     * @param id of the annualPayment
     * @return one annualPayment
     */
    public AnnualPayment loadAnnualPayment(Long id) {
        return entityManager.find(AnnualPayment.class, id);
    }

    @PersistenceContext
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    /**
     * Loads a list of annualPayments from the database
     *
     * @return list of annualPayments
     */
    public List<AnnualPayment> listAnnualPayments() {
        return entityManager.createQuery("select annualPayment from AnnualPayment annualPayment").getResultList();
    }

    /**
     * Creates one annualPayment
     *
     * @param annualPayment
     */
    public void createAnnualPayment(AnnualPayment annualPayment) {
        persistAnnualPayment(annualPayment);
    }

    /**
     * Updates the annualPayment with the given id
     *
     * @param annualPayment
     */
    public void updateAnnualPayment(AnnualPayment annualPayment) {
        entityManager.merge(annualPayment);
    }

    /**
     * Deletes the annualPayment with the given id
     *
     * @param id
     */
    public void deleteAnnualPayment(Long id) {
        entityManager.remove(entityManager.find(AnnualPayment.class, id));
    }

    /**
     * Saves the entity in the data base
     *
     * @param annualPayment the payment to be saved
     */
    public void persistAnnualPayment(AnnualPayment annualPayment) throws ConstraintViolationException {
        entityManager.persist(annualPayment);
    }
}
