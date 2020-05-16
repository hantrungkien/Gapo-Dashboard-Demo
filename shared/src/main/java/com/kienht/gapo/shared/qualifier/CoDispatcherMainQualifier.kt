package com.kienht.gapo.shared.qualifier

import javax.inject.Qualifier

/**
 * @author kienht
 * @company OICSoft
 * @since 15/05/2020
 */
@Qualifier
@Retention(AnnotationRetention.RUNTIME)
@Target(
    AnnotationTarget.FIELD,
    AnnotationTarget.VALUE_PARAMETER,
    AnnotationTarget.FUNCTION,
    AnnotationTarget.PROPERTY_GETTER,
    AnnotationTarget.PROPERTY_SETTER
)
annotation class CoDispatcherMainQualifier