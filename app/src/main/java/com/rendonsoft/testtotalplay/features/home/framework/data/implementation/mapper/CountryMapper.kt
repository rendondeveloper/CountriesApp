package com.rendonsoft.testtotalplay.features.home.framework.data.implementation.mapperimport com.rendonsoft.testtotalplay.features.home.domain.CountryItemimport com.rendonsoft.testtotalplay.features.home.framework.data.config.response.CountryResponseimport com.rendonsoft.testtotalplay.utils.models.mapper.Mapperclass CountryMapper : Mapper<CountryResponse, List<CountryItem>> {    override fun map(input: CountryResponse): List<CountryItem> {        return input.map {            CountryItem(                   it.flags.png,                   it.name.common,                   it.name.official,                   "lebel 1"            )        }.toList()    }}