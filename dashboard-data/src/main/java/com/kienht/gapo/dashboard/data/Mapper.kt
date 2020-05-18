package com.kienht.gapo.dashboard.data

/**
 * @author kienht
 */
internal interface Mapper<E, M> {
    fun mapFromEntity(type: E): M

    fun mapToEntity(type: M): E
}