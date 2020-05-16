package com.kienht.gapo.dashboard.data

/**
 * @author kienht
 * @company OICSoft
 * @since 27/12/2018
 */
internal interface Mapper<E, M> {
    fun mapFromEntity(type: E): M

    fun mapToEntity(type: M): E
}