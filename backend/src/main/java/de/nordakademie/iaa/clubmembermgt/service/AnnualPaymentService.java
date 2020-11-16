package de.nordakademie.iaa.clubmembermgt.service;

import de.nordakademie.iaa.clubmembermgt.dao.AnnualPaymentDAO;
import de.nordakademie.iaa.clubmembermgt.model.AnnualPayment;

import javax.inject.Inject;
import java.util.List;

public class AnnualPaymentService {

    private AnnualPaymentDAO annualPaymentDAO;

    public List<AnnualPayment> listAnnualPaymentsForClubMemberId(Long clubMemberId) {
        return annualPaymentDAO.listAnnualPaymentsForClubMemberId(clubMemberId);
    }

    public AnnualPayment loadAnnualPaymentById(Long annualPaymentId) {
        return annualPaymentDAO.loadAnnualPayment(annualPaymentId);
    }

    @Inject
    public void setAnnualPaymentDAO(AnnualPaymentDAO annualPaymentDAO) {
        this.annualPaymentDAO = annualPaymentDAO;
    }

    public List<AnnualPayment> listAnnualPayments() {
        return annualPaymentDAO.listAnnualPayments();
    }

    public void createAnnualPayment(AnnualPayment annualPayment) {
        annualPaymentDAO.createAnnualPayment(annualPayment);
    }

    public void updateAnnualPayment(AnnualPayment annualPayment) {
        annualPaymentDAO.updateAnnualPayment(annualPayment);
    }

    public void deleteAnnualPayment(Long id) {
        annualPaymentDAO.deleteAnnualPayment(id);
    }
}
