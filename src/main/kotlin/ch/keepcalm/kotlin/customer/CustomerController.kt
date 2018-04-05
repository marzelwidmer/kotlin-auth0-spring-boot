package ch.keepcalm.kotlin.customer

import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping(value = ["/customers"])
class CustomerController(val customerService: CustomerService){

    @GetMapping
    fun getCustomers(): List<Customer> = customerService.getAllCustomers()

    @GetMapping(value = ["/{id}"])
    fun getCustomerById(@PathVariable id: Long): Customer = customerService.getCustomerById(id)

    @PutMapping(value = ["{/id}"])
    fun updateCustomer(@PathVariable id: Long, @RequestBody customer: Customer){
        assert(customer.id == id)
        customerService.save(customer)
    }

    @DeleteMapping(value = ["/{id}"])
    fun removeCustomer(@PathVariable id: Long) = customerService.remove(id)

    @PostMapping
    fun addCustomer(customer: Customer) : Customer = customerService.add(customer)
}