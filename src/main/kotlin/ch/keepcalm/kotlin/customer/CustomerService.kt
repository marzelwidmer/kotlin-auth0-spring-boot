package ch.keepcalm.kotlin.customer

import org.springframework.stereotype.Service

@Service
class CustomerService (val customerRepository: CustomerRepository) {

    fun getAllCustomers(): List<Customer> =
            customerRepository.findAll().map { it }

    fun getCustomerById(id: Long): Customer =
            customerRepository.findById(id).get()

    fun save(customer: Customer) : Customer =
        customerRepository.save(customer)

    fun remove(id: Long) = customerRepository.deleteById(id)

    fun add(customer: Customer): Customer = customerRepository.save(customer)

}