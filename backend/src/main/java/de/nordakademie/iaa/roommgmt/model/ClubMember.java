package de.nordakademie.iaa.roommgmt.model;

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

    private Long clubMemberId;
    private String clubMemberName;
    private String clubMemberAdress;
    private Date clubMemberBirthday;
    private Date entranceDate;
    private Date exitDate;
    private MEMBERSHIP_TYPE membership_type;
    private Float annualFee;
    //private List<AnnualPayment> annualPaymentList;
    private String iban;
    private ClubMember firstEnteredFamilyClubMember;

    @Id
    @GeneratedValue
    public Long getClubMemberId() {
        return clubMemberId;
    }

    public void setClubMemberId(Long clubMemberId) {
        this.clubMemberId = clubMemberId;
    }

    @Column(name = "CLUBMEMBER_NAME", nullable = false)
    public String getClubMemberName() {
        return clubMemberName;
    }

    public void setClubMemberName(String clubMemberName) {
        this.clubMemberName = clubMemberName;
    }

    @Column(name = "CLUBMEMBER_ADRESS", nullable = false)
    public String getClubMemberAdress() {
        return clubMemberAdress;
    }

    public void setClubMemberAdress(String clubMemberAdress) {
        this.clubMemberAdress = clubMemberAdress;
    }

    @Column(name = "CLUBMEMBER_BIRTHDAY", nullable = false)
    @Temporal(TemporalType.DATE)
    public Date getClubMemberBirthday() {
        return clubMemberBirthday;
    }

    public void setClubMemberBirthday(Date clubMemberBirthday) {
        this.clubMemberBirthday = clubMemberBirthday;
    }

    @Column(name = "ENTRANCE_DATE", nullable = false)
    @Temporal(TemporalType.DATE)
    public Date getEntranceDate() {
        return entranceDate;
    }

    public void setEntranceDate(Date entranceDate) {
        this.entranceDate = entranceDate;
    }

    @Column(name = "EXIT_DATE")
    @Temporal(TemporalType.DATE)
    public Date getExitDate() {
        return exitDate;
    }

    public void setExitDate(Date exitDate) {
        this.exitDate = exitDate;
    }

    @Column(name = "MEMBERSHIP_TYPE", nullable = false)
    @Enumerated(EnumType.STRING)
    public MEMBERSHIP_TYPE getMembership_type() {
        return membership_type;
    }

    public void setMembership_type(MEMBERSHIP_TYPE membership_type) {
        this.membership_type = membership_type;
    }

    @Column(name = "ANNUAL_FEE", nullable = false)
    public Float getAnnualFee() {
        return annualFee;
    }

    public void setAnnualFee(Float annualFee) {
        this.annualFee = annualFee;
    }

    /*@Column(name = "ANNUAL_PAYMENT_LIST")
    public List<AnnualPayment> getAnnualPaymentList() {
        return annualPaymentList;
    }

    public void setAnnualPaymentList(List<AnnualPayment> annualPaymentList) {
        this.annualPaymentList = annualPaymentList;
    }*/

    @Column(name = "IBAN", nullable = false)
    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    @Column(name = "FIRST_ENTERED_FAMILYCLUBMEMBER")
    public ClubMember getFirstEnteredFamilyClubMember() {
        return firstEnteredFamilyClubMember;
    }

    public void setFirstEnteredFamilyClubMember(ClubMember firstEnteredFamilyClubMember) {
        this.firstEnteredFamilyClubMember = firstEnteredFamilyClubMember;
    }


}
