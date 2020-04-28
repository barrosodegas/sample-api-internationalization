package br.com.barroso.api.internacionalization.controller

import br.com.barroso.api.internacionalization.translator.MessageTranslator
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.lang.Exception

@RestController
@RequestMapping(value = ["/any-crud"])
class AnyErrorController(val messageTranslator: MessageTranslator) {

    private companion object {
        const val messageName = "any.error"
    }

    @GetMapping
    fun getAnyData(): String {
        throw Exception(messageTranslator.toLocale(messageName))
    }

}
