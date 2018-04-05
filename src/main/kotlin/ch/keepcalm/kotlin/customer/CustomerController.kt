package ch.keepcalm.kotlin.customer

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping(value = ["/customers"])
class CustomerController(val customerService: CustomerService){

    @GetMapping
    fun getCustomers(): List<Customer> = customerService.getAllCustomers()

    @GetMapping(value = ["/{id}"])
    fun getCustomerById(@PathVariable id: Long): Customer = customerService.getCustomerById(id)

    @PutMapping(value = ["/{id}"])
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun updateCustomer(@PathVariable id: Long,  @RequestBody @Valid customer: Customer) {
        if (customer.id == id) customerService.save(customer)
        else throw BadRequestException()
    }

    @DeleteMapping(value = ["/{id}"])
    fun removeCustomer(@PathVariable id: Long) = customerService.remove(id)

    @PostMapping
    fun addCustomer(@RequestBody @Valid customer: Customer) : Customer = customerService.add(customer)
}

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
class BadRequestException: RuntimeException()