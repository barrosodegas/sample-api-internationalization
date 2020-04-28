package br.com.barroso.api.internacionalization.configuration

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.support.ResourceBundleMessageSource
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver
import java.util.*
import javax.servlet.http.HttpServletRequest

@Configuration
class CustomLocaleResolver : AcceptHeaderLocaleResolver(), WebMvcConfigurer {

    private companion object {
        /**
         * This data can come from any database (Redis, MongoDB, etc...)
         */
        val LOCALES = listOf(Locale("en"), Locale("pt", "BR"), Locale("es"))
        const val HEADER_ACCEPT_LANGUAGE = "Accept-Language"
    }

    override fun resolveLocale(request: HttpServletRequest): Locale {

        var headerLang: String? = request.getHeader(HEADER_ACCEPT_LANGUAGE)
        var locale = Locale.getDefault()

        if(headerLang == null || headerLang.isEmpty()) locale = Locale.lookup(Locale.LanguageRange.parse(headerLang), LOCALES)

        return locale
    }

    @Bean
    fun messageSource(): ResourceBundleMessageSource {

        val rs = ResourceBundleMessageSource()
        rs.setBasename("messages")
        rs.setDefaultEncoding("UTF-8")
        rs.setUseCodeAsDefaultMessage(true)

        return rs
    }

}
