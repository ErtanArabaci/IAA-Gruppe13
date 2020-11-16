package de.nordakademie.iaa.clubmembermgt.controller;

import de.nordakademie.iaa.clubmembermgt.model.AnnualPayment;
import de.nordakademie.iaa.clubmembermgt.service.AnnualPaymentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

/**The implementation of a controller for annual payment logic
 *
 * @author Kim Bartikowski, Torben Labs
 */
@RestController
public class AnnualPaymentController {

    private AnnualPaymentService annualPaymentService;

    /**
     * get list of all annual apyments a user has
     *
     * @param id id to identify the annual payment
     * @return a list of all annual payments
     */
    @GetMapping("/annual-payments/club-member/{id}")
    public List<AnnualPayment> listAnnualPaymentsForClubMemberId(@PathVariable Long id) {
        return annualPaymentService.listAnnualPaymentsForClubMemberId(id);
    }

    /**
     * loads annual payments by id
     *
     * @param id id for the annual payment
     * @return returns the annual payment for given id
     */
    @GetMapping("/annual-payments/{id}")
    public AnnualPayment loadAnnualPaymentById(@PathVariable Long id) {
        return annualPaymentService.loadAnnualPaymentById(id);
    }

    /**
     * loads empty annual payment data
     *
     * @param id id for the new annual payment
     */
    @GetMapping("/annual-payments/new/{id}")
    public void loadAnnualPaymentForNew(@PathVariable Long id) {
    }

    /**
     * gets all the annual payments
     *
     * @return returns all annual payments
     */
    @GetMapping("/annual-payments")
    public List<AnnualPayment> listAnnualPayments() {
        return annualPaymentService.listAnnualPayments();
    }

    /**
     * deletes annual payments by id
     *
     * @param id id for the annual payment to be deleted
     * @return returns a response entity
     */
    @DeleteMapping(path = "/annual-payments/{id}")
    public ResponseEntity<?> deleteAnnualPayment(@PathVariable Long id) {
        this.annualPaymentService.deleteAnnualPayment(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    /**
     * updates an annual payment
     *
     * @param annualPayment the annual payment that should be updated
     */
    @PutMapping(path = "/annual-payments")
    public void updateAnnualPayment(@RequestBody AnnualPayment annualPayment) {
        this.annualPaymentService.updateAnnualPayment(annualPayment);
    }

    /**
     * creates a new annual payment
     *
     * @param annualPayment annual payment to be created
     */
    @PostMapping(path = "/annual-payments")
    public void createAnnualPayment(@RequestBody AnnualPayment annualPayment) {
        this.annualPaymentService.createAnnualPayment(annualPayment);
    }

    /**
     * sets the annual payment service
     *
     * @param annualPaymentService new annual payment service
     */
    @Inject
    public void setAnnualPaymentService(AnnualPaymentService annualPaymentService) {
        this.annualPaymentService = annualPaymentService;
    }

}
