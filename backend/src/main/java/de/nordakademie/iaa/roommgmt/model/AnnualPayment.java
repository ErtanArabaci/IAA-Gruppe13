package de.nordakademie.iaa.roommgmt.model;

public class AnnualPayment {
    private int year;
    private Float paidFee;
    private Float annualFee;

    public AnnualPayment(int year, Float paidFee, Float annualFee) {
        this.year = year;
        this.paidFee = paidFee;
        this.annualFee = annualFee;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public Float getPaidFee() {
        return paidFee;
    }

    public void setPaidFee(Float paidFee) {
        this.paidFee = paidFee;
    }

    public Float getAnnualFee() {
        return annualFee;
    }

    public void setAnnualFee(Float annualFee) {
        this.annualFee = annualFee;
    }
}
