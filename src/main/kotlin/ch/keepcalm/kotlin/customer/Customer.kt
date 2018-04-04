package ch.keepcalm.kotlin.customer

import java.util.*
import javax.persistence.Entity
import javax.persistence.Id

/*
The Entity class is so small and concise, right?
That’s because A Kotlin class doesn’t need getters and setters like Java. Moreover,
I have used a data class here. A data class automatically generates equals(), hashcode(), toString() and copy() methods.

Note that, I’ve assigned a default value for all the fields in the Article class.
This is needed because Hibernate requires an entity to have a no-arg constructor.
*/
@Entity
data class Customer(@Id val id: String = UUID.randomUUID().toString(),
                    val firstName: String = "",
                    val lastName: String = ""){

    // only needed because of DatabaseLoader
    constructor(firstName: String, lastName: String) : this(UUID.randomUUID().toString(),firstName, lastName)

}


