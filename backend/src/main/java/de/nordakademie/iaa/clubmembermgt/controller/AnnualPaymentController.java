package de.nordakademie.iaa.clubmembermgt.controller;

import de.nordakademie.iaa.clubmembermgt.model.AnnualPayment;
import de.nordakademie.iaa.clubmembermgt.service.AnnualPaymentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
public class AnnualPaymentController {


    private AnnualPaymentService annualPaymentService;

    @GetMapping("/annual-payments/club-member/{id}")
    public List<AnnualPayment> listAnnualPaymentsForClubMemberId(@PathVariable Long id) {
        System.out.println("Given Club Member id: " + id);
        return annualPaymentService.listAnnualPaymentsForClubMemberId(id);
    }

    @GetMapping("/annual-payments/{id}")
    public AnnualPayment loadAnnualPaymentById(@PathVariable Long id) {
        System.out.println("Given  AnnualPayment: " + id);
        return annualPaymentService.loadAnnualPaymentById(id);
    }

    @GetMapping("/annual-payments")
    public List<AnnualPayment> listAnnualPayments() {
        return annualPaymentService.listAnnualPayments();
    }

    @DeleteMapping(path = "/annual-payments/{id}")
    public ResponseEntity<?> deleteAnnualPayment(@PathVariable Long id) {
        this.annualPaymentService.deleteAnnualPayment(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @PutMapping(path = "/annual-payments")
    public void updateAnnualPayment(@RequestBody AnnualPayment annualPayment) {
        this.annualPaymentService.updateAnnualPayment(annualPayment);
    }

    @PostMapping(path = "/annual-payments")
    public void createAnnualPayment(@RequestBody AnnualPayment annualPayment) {
        this.annualPaymentService.createAnnualPayment(annualPayment);
    }


    @Inject
    public void setAnnualPaymentService(AnnualPaymentService annualPaymentService) {
        this.annualPaymentService = annualPaymentService;
    }

}
