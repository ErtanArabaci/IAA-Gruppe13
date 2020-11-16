package de.nordakademie.iaa.clubmembermgt.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * ClubMember entity.
 *
 * @author Ertan Arabaci, Kim Bartikowski
 */

@Entity
public class ClubMember implements Serializable {

    private static final long serialVersionUID = 6925248180274039273L;

    @Id
    private Long clubMemberId;

    @Column(name = "CLUBMEMBER_NAME", nullable = false)
    private String clubMemberName;

    @Column(name = "CLUBMEMBER_ADRESS", nullable = false)
    private String clubMemberAdress;

    @Column(name = "CLUBMEMBER_BIRTHDAY", nullable = false)
    private Date clubMemberBirthday;

    @Column(name = "ENTRANCE_DATE", nullable = false)
    private Date entranceDate;

    @Column(name = "TERMINATION_DATE")
    private Date terminationDate;

    @Column(name = "EXIT_DATE")
    private Date exitDate;

    @Column(name = "MEMBERSHIP_TYPE", nullable = false)
    @Enumerated(EnumType.STRING)
    private MEMBERSHIP_TYPE membership_type;

    @Column(name = "ANNUAL_FEE", nullable = false)
    private Long annualFee;
    //private List<AnnualPayment> annualPaymentList;

    @Column(name = "IBAN", nullable = false)
    private String iban;


    public Long getClubMemberId() {
        return clubMemberId;
    }

    public void setClubMemberId(Long clubMemberId) {
        this.clubMemberId = clubMemberId;
    }

    public String getClubMemberName() {
        return clubMemberName;
    }

    public void setClubMemberName(String clubMemberName) {
        this.clubMemberName = clubMemberName;
    }

    public String getClubMemberAdress() {
        return clubMemberAdress;
    }

    public void setClubMemberAdress(String clubMemberAdress) {
        this.clubMemberAdress = clubMemberAdress;
    }

    public Date getClubMemberBirthday() {
        return clubMemberBirthday;
    }

    public void setClubMemberBirthday(Date clubMemberBirthday) {
        this.clubMemberBirthday = clubMemberBirthday;
    }

    public Date getEntranceDate() {
        return entranceDate;
    }

    public void setEntranceDate(Date entranceDate) {
        this.entranceDate = entranceDate;
    }

    public Date getTerminationDate() {
        return terminationDate;
    }

    public void setTerminationDate(Date terminationDate) {
        this.terminationDate = terminationDate;
    }

    public Date getExitDate() {
        return exitDate;
    }

    public void setExitDate(Date exitDate) {
        this.exitDate = exitDate;
    }


    public MEMBERSHIP_TYPE getMembership_type() {
        return membership_type;
    }

    public void setMembership_type(MEMBERSHIP_TYPE membership_type) {
        this.membership_type = membership_type;
    }

    public Long getAnnualFee() {
        return annualFee;
    }

    public void setAnnualFee(Long annualFee) {
        this.annualFee = annualFee;
    }

    /*@Column(name = "ANNUAL_PAYMENT_LIST")
    public List<AnnualPayment> getAnnualPaymentList() {
        return annualPaymentList;
    }

    public void setAnnualPaymentList(List<AnnualPayment> annualPaymentList) {
        this.annualPaymentList = annualPaymentList;
    }*/

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }


}
