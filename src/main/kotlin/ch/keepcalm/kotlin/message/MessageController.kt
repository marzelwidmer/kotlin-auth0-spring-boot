package ch.keepcalm.kotlin.message

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController


@RestController
class APIController {


    @GetMapping(value = arrayOf("/api/public"), produces = arrayOf("application/json"))
     fun publicEndpoint(): Message {
        return Message("All good. You DO NOT need to be authenticated to call /api/public.")
    }

    @GetMapping(value = arrayOf("/api/private"), produces = arrayOf("application/json"))
     fun privateEndpoint(): Message {
        return Message("All good. You can see this because you are Authenticated.")

    }

    @GetMapping(value = arrayOf("/api/private-scoped"), produces = arrayOf("application/json"))
    fun privateScopedEndpoint(): Message {
        return Message("All good. You can see this because you are Authenticated with a Token granted the 'read:messages' scope")
    }

}
