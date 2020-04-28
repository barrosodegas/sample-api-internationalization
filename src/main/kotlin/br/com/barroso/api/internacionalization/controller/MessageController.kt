package br.com.barroso.api.internacionalization.controller

import br.com.barroso.api.internacionalization.translator.MessageTranslator
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(value = ["/messages"])
class MessageController(val messageTranslator: MessageTranslator) {

    @GetMapping(params = ["messageName"])
    fun getMessageByMessageName(@RequestParam(value = "messageName") messageName: String): String {
        return messageTranslator.toLocale(messageName)
    }

}
