package de.nordakademie.iaa.clubmembermgt.service;

import de.nordakademie.iaa.clubmembermgt.dao.AnnualPaymentDAO;
import de.nordakademie.iaa.clubmembermgt.model.AnnualPayment;

import javax.inject.Inject;
import java.util.List;

/**
 * The implementation of a service for AnnualPayment
 *
 * @author Kim Bartikowski, Torben Labs, Ertan Arabaci
 */
public class AnnualPaymentService {

    private AnnualPaymentDAO annualPaymentDAO;

    /**
     * Calls dao to return the list of annual payments for a specific club member
     *
     * @param clubMemberId the id of the club member which annual payments are to be returned
     * @return a list of annual payments belonging to the given club member
     */
    public List<AnnualPayment> listAnnualPaymentsForClubMemberId(Long clubMemberId) {
        return annualPaymentDAO.listAnnualPaymentsForClubMemberId(clubMemberId);
    }

    /**
     * calls dao to return one annual payment
     *
     * @param annualPaymentId the id of the annual payment which is to be returned
     * @return an annual payment with given id
     */
    public AnnualPayment loadAnnualPaymentById(Long annualPaymentId) {
        return annualPaymentDAO.loadAnnualPayment(annualPaymentId);
    }

    @Inject
    public void setAnnualPaymentDAO(AnnualPaymentDAO annualPaymentDAO) {
        this.annualPaymentDAO = annualPaymentDAO;
    }

    /**
     * calls dao to return a list of annual payments
     *
     * @return a list of annual payments
     */
    public List<AnnualPayment> listAnnualPayments() {
        return annualPaymentDAO.listAnnualPayments();
    }

    /**
     * calls dao to return an annual payment
     *
     * @param annualPayment to be created
     */
    public void createAnnualPayment(AnnualPayment annualPayment) {
        annualPaymentDAO.createAnnualPayment(annualPayment);
    }

    /**
     * calls dao to update an annual payment
     *
     * @param annualPayment to be updated
     */
    public void updateAnnualPayment(AnnualPayment annualPayment) {
        annualPaymentDAO.updateAnnualPayment(annualPayment);
    }

    /**
     * calls dao to delete an annual payment
     *
     * @param id the id of the annual payment that is to be deleted
     */
    public void deleteAnnualPayment(Long id) {
        annualPaymentDAO.deleteAnnualPayment(id);
    }
}
