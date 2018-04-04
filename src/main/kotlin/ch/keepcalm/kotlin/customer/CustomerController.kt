package ch.keepcalm.kotlin.customer

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class CustomerController(val customerService: CustomerService){

    @GetMapping(value = "/customers")
    fun getCustomers(): List<Customer> = customerService.getAllCustomers()


}