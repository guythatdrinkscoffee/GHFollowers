package com.jmanueldev.ghfollowers.domain.model

interface DomainMapper<T, DomainModel>{
    fun toDomainModel(model: T): DomainModel
    fun fromDomainModel(domainModel: DomainModel): T
}