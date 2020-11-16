package de.nordakademie.iaa.clubmembermgt.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class AnnualPayment implements Serializable {

    private static final long serialVersionUID = 6925248180274039274L;


    @Id
    private Long annualPaymentId;

    @Column(name = "CLUBMEMBER_ID", nullable = false)
    private Long clubMemberId;

    @Column(name = "ANNUALPAYMENT_YEAR", nullable = false)
    private Long annualPaymentYear;

    @Column(name = "ANNUALPAYMENT_FEE", nullable = false)
    private Long annualPaymentFee;

    @Column(name = "ANNUALPAYMENT_PAID_FEE", nullable = false)
    private Long annualPaymentPaidFee;


    public Long getClubMemberId() {
        return clubMemberId;
    }

    public void setClubMemberId(Long clubMemberId) {
        this.clubMemberId = clubMemberId;
    }

    public Long getAnnualPaymentId() {
        return annualPaymentId;
    }

    public void setAnnualPaymentId(Long annualPaymentId) {
        this.annualPaymentId = annualPaymentId;
    }

    public Long getAnnualPaymentYear() {
        return annualPaymentYear;
    }

    public void setAnnualPaymentYear(Long annualPaymentYear) {
        this.annualPaymentYear = annualPaymentYear;
    }

    public Long getAnnualPaymentFee() {
        return annualPaymentFee;
    }

    public void setAnnualPaymentFee(Long annualPaymentFee) {
        this.annualPaymentFee = annualPaymentFee;
    }

    public Long getAnnualPaymentPaidFee() {
        return annualPaymentPaidFee;
    }

    public void setAnnualPaymentPaidFee(Long annualPaymentPaidFee) {
        this.annualPaymentPaidFee = annualPaymentPaidFee;
    }
}
