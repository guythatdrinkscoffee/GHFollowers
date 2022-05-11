package com.jmanueldev.ghfollowers.domain.model.utils

interface DomainMapper<T, DomainModel>{
    fun toDomainModel(model: T): DomainModel
}