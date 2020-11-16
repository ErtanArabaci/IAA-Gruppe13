package de.nordakademie.iaa.clubmembermgt.controller;

import de.nordakademie.iaa.clubmembermgt.model.AnnualPayment;
import de.nordakademie.iaa.clubmembermgt.service.AnnualPaymentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;
import java.util.List;

@RestController
public class AnnualPaymentController {



    private AnnualPaymentService annualPaymentService;

     @GetMapping("/annual-payments/club-member/{id}")
    public List<AnnualPayment> listAnnualPaymentsForClubMemberId(@PathVariable Long id){
         System.out.println("Given Club Member id: " + id);
         return annualPaymentService.listAnnualPaymentsForClubMemberId(id);
     }

    @GetMapping("/annual-payments/{id}")
    public AnnualPayment loadAnnualPaymentById(@PathVariable Long id){
        System.out.println("Given  AnnualPayment: " + id);
        return annualPaymentService.loadAnnualPaymentById(id);
    }

     @Inject
     public void setAnnualPaymentService(AnnualPaymentService annualPaymentService) {
         this.annualPaymentService = annualPaymentService;
     }

}
