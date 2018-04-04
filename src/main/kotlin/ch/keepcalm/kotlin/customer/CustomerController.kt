package ch.keepcalm.kotlin.customer

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(value = ["/customers"])
class CustomerController(val customerService: CustomerService){

    @GetMapping
    fun getCustomers(): List<Customer> = customerService.getAllCustomers()

    @GetMapping(value = ["/{id}"])
    fun getCustomer(@PathVariable id: String): Customer = customerService.getCustomer(id)


}