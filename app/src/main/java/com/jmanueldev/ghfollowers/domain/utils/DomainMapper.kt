package com.jmanueldev.ghfollowers.domain.utils

interface DomainMapper<T, DomainModel>{
    fun toDomainModel(model: T): DomainModel
}