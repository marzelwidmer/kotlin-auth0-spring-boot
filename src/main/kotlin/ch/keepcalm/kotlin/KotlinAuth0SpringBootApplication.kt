package ch.keepcalm.kotlin

import ch.keepcalm.kotlin.customer.Customer
import ch.keepcalm.kotlin.customer.CustomerRepository
import org.springframework.boot.ApplicationArguments
import org.springframework.boot.ApplicationRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.PropertySource
import org.springframework.context.annotation.PropertySources
import org.springframework.stereotype.Component

@SpringBootApplication
@PropertySources(PropertySource("classpath:application.properties"), PropertySource("classpath:auth0.properties"))
class KotlinAuth0SpringBootApplication

fun main(args: Array<String>) {
    runApplication<KotlinAuth0SpringBootApplication>(*args)
}

@Component
class DataLoader (val customerRepository: CustomerRepository): ApplicationRunner {
    override fun run(args: ApplicationArguments?) {
            customerRepository.save(Customer(firstName = "Marcel", lastName = "Widmer"))
            customerRepository.save(Customer(firstName = "Basco", lastName = "Rex"))
    }
}
