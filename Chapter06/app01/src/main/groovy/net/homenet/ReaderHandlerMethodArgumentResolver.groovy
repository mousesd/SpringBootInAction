package net.homenet

import org.springframework.core.MethodParameter
import org.springframework.lang.Nullable
import org.springframework.security.core.Authentication
import org.springframework.web.bind.support.WebDataBinderFactory
import org.springframework.web.context.request.NativeWebRequest
import org.springframework.web.method.support.HandlerMethodArgumentResolver
import org.springframework.web.method.support.ModelAndViewContainer

class ReaderHandlerMethodArgumentResolver implements HandlerMethodArgumentResolver {
    @Override
    boolean supportsParameter(MethodParameter parameter) {
        Reader.class.isAssignableFrom(parameter.getParameterType())
    }

    @Override
    Object resolveArgument(MethodParameter parameter
        , @Nullable ModelAndViewContainer mavContainer
        , NativeWebRequest webRequest
        , @Nullable WebDataBinderFactory binderFactory) throws Exception {

        Authentication auth = (Authentication) webRequest.getUserPrincipal()
        auth != null && auth.getPrincipal() instanceof Reader ? auth.getPrincipal() : null
    }
}
