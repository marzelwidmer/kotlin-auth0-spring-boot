package ch.keepcalm.kotlin.customer

import org.springframework.stereotype.Service

@Service
class CustomerService (val customerRepository: CustomerRepository) {

    fun getAllCustomers(): List<Customer> =
            customerRepository.findAll().map { it }

    fun getCustomer(id: Long): Customer =
            customerRepository.findById(id).get()

    fun save(customer: Customer) : Customer =
        customerRepository.save(customer)

}