package ch.keepcalm.kotlin

import ch.keepcalm.kotlin.customer.Customer
import ch.keepcalm.kotlin.customer.CustomerRepository
import org.springframework.boot.ApplicationArguments
import org.springframework.boot.ApplicationRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.stereotype.Component

@SpringBootApplication
class KotlinAuth0SpringBootApplication

fun main(args: Array<String>) {
    runApplication<KotlinAuth0SpringBootApplication>(*args)
}

@Component
class DataLoader (val customerRepository: CustomerRepository): ApplicationRunner {
    override fun run(args: ApplicationArguments?) {
            val customer = Customer(id = 0,firstName = "Marcel", lastName = "Widmer")
            customerRepository.save(customer)
    }
}
