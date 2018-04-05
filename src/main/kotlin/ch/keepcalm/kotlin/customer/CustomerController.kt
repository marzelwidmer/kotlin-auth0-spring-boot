package ch.keepcalm.kotlin.customer

import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping(value = ["/customers"])
class CustomerController(val customerService: CustomerService){

    @GetMapping
    fun getCustomers(): List<Customer> = customerService.getAllCustomers()

    @GetMapping(value = ["/{id}"])
    fun getCustomer(@PathVariable id: Long): Customer = customerService.getCustomer(id)

    @PutMapping(value = ["{/id}"])
    fun updateCustomer(@PathVariable id: Long, @RequestBody customer: Customer){
        assert(customer.id == id)
        customerService.save(customer)
    }

}