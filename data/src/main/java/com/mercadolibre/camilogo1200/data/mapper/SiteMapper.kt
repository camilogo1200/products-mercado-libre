package com.mercadolibre.camilogo1200.data.mapper

import com.mercadolibre.camilogo1200.data.model.Site
import com.mercadolibre.camilogo1200.data.net.dto.SiteDTO
import com.mercadolibre.camilogo1200.data.persistence.entities.SiteEntity
import javax.inject.Inject

/**
 * Mapper class used to transform [SiteDTO] or [SiteEntity] in [Site]
 *
 * @author Cristhian C Gómez N
 * @see ISiteMapper
 * @see SiteDTO
 * @see Site
 * @see SiteEntity
 * @since 1.0.0
 */
class SiteMapper @Inject constructor() : ISiteMapper {
    /**
     * @inheritDoc
     */
    override fun transform(dto: SiteDTO): Site =
        Site(dto.id, dto.name, dto.countryId, dto.mercadoPagoVersion, dto.defaultCurrencyId)

    /**
     * @inheritDoc
     */
    override fun transform(dtoCollection: Collection<SiteDTO>): List<Site> =
        dtoCollection.map { site -> transform(site) }

    /**
     * @inheritDoc
     */
    override fun transform(entity: SiteEntity): Site =
        with(entity) { Site(id, name, countryId, mercadoPagoVersion, defaultCurrencyId) }

    /**
     * @inheritDoc
     */
    override fun transformEntities(entityCollection: Collection<SiteEntity>): List<Site> =
        entityCollection.map { entity -> transform(entity) }
}