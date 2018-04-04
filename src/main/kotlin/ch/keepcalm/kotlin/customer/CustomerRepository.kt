package ch.keepcalm.kotlin.customer

import org.springframework.data.repository.CrudRepository

interface CustomerRepository : CrudRepository<Customer, String>