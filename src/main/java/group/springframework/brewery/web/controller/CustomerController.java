package group.springframework.brewery.web.controller;

import org.springframework.web.bind.annotation.*;

@RequestMapping("api/v1/customer")
@RestController
public class CustomerController {

//    private final CustomerService customerService;
//
//    public CustomerController(CustomerService customerService) {
//        this.customerService = customerService;
//    }
//
//    @GetMapping("/{customerId}")
//    public ResponseEntity<CustomerDTO> getCustomer(@PathVariable("customerId") UUID id) {
//
//        return new ResponseEntity<>(this.customerService.getCustomerById(id), HttpStatus.OK);
//    }
//
//    @PostMapping
//    public ResponseEntity handlePost(@RequestBody CustomerDTO customerDTO) {
//        CustomerDTO savedDTO = customerService.createNewCustomer(customerDTO);
//
//        HttpHeaders headers = new HttpHeaders();
//        headers.add("Location", "api/v1/customer/" + savedDTO.getId().toString());
//
//        return new ResponseEntity(headers, HttpStatus.CREATED);
//    }
//
//    @PutMapping("/{customerId}")
//    @ResponseStatus(HttpStatus.NO_CONTENT)
//    public void handleUpdate(@PathVariable("customerId") UUID id, @RequestBody CustomerDTO customerDTO) {
//
//        customerService.updateCustomer(id, customerDTO);
//    }
//
//    @DeleteMapping("/{customerId}")
//    @ResponseStatus(HttpStatus.NO_CONTENT)
//    public void handleDelete(@PathVariable UUID customerId) {
//        customerService.deleteById(customerId);
//    }

}
