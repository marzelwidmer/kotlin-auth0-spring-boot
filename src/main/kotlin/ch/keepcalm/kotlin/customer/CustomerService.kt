package ch.keepcalm.kotlin.customer

import org.springframework.stereotype.Service

@Service
class CustomerService (val customerRepository: CustomerRepository) {

    fun getAllCustomers(): List<Customer> =
            customerRepository.findAll().map { it }
}