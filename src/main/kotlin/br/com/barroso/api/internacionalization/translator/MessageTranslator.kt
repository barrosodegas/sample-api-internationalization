package br.com.barroso.api.internacionalization.translator

import org.springframework.beans.factory.config.ConfigurableBeanFactory
import org.springframework.context.annotation.Scope
import org.springframework.context.i18n.LocaleContextHolder
import org.springframework.context.support.ResourceBundleMessageSource
import org.springframework.stereotype.Component

@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
class MessageTranslator(val messageSource: ResourceBundleMessageSource) {

    fun toLocale(messageName: String): String {
        val locale = LocaleContextHolder.getLocale()
        return messageSource.getMessage(messageName, null, locale)
    }

}
