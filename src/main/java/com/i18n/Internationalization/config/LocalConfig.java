package com.i18n.Internationalization.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;

import java.util.List;
import java.util.Locale;

@Configuration
public class LocalConfig implements WebMvcConfigurer {
  @Bean
  public LocaleResolver localeResolver() {
    //    SessionLocaleResolver sessionLocaleResolver = new SessionLocaleResolver();
    //    sessionLocaleResolver.setDefaultLocale(Locale.ENGLISH);
    //    sessionLocaleResolver.setLocaleAttributeName("session.current.locale");
    //    sessionLocaleResolver.setTimeZoneAttributeName("session.current.timezone");
    //    return sessionLocaleResolver;

    //    FixedLocaleResolver fixedLocaleResolver = new FixedLocaleResolver();
    //    fixedLocaleResolver.setDefaultLocale(Locale.ENGLISH);
    //    fixedLocaleResolver.setDefaultTimeZone(TimeZone.getTimeZone("UTC+2"));
    //    return fixedLocaleResolver;

    AcceptHeaderLocaleResolver acceptHeaderLocaleResolver = new AcceptHeaderLocaleResolver();
    acceptHeaderLocaleResolver.setDefaultLocale(Locale.ENGLISH);
    acceptHeaderLocaleResolver.setSupportedLocales(
        List.of(Locale.forLanguageTag("en"), Locale.forLanguageTag("ar")));
    return acceptHeaderLocaleResolver;
  }

  @Bean
  public LocaleChangeInterceptor localeChangeInterceptor() {
    LocaleChangeInterceptor localeChangeInterceptor = new LocaleChangeInterceptor();
    localeChangeInterceptor.setParamName("language");
    return localeChangeInterceptor;
  }

  @Override
  public void addInterceptors(InterceptorRegistry registry) {
    registry.addInterceptor(localeChangeInterceptor());
  }
}
