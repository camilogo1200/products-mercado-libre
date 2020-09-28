package com.mercadolibre.camilogo1200.data.mapper

import com.mercadolibre.camilogo1200.data.model.Site
import com.mercadolibre.camilogo1200.data.net.dto.SiteDTO
import com.mercadolibre.camilogo1200.data.persistence.entities.SiteEntity

interface ISiteMapper {
//region DTO to Model

    /**
     * Transform a [SiteDTO] into an [Site].
     * @param dto  Object to be transformed.
     * @return [Site] if valid [SiteDTO]
     * @since 1.0.0
     */
    fun transform(dto: SiteDTO): Site

    /**
     * Transform a Collection of [SiteDTO] into a List of [Site].
     * @param dtoCollection Object Collection to be transformed.
     * @return list of [Site]
     * @since 1.0.0
     */
    fun transform(dtoCollection: Collection<SiteDTO>): List<Site>
//endregion

    //region ENTITY to MODEL
    fun transform(entity: SiteEntity): Site


    fun transformEntities(entityCollection: Collection<SiteEntity>): List<Site>

// endregion
}