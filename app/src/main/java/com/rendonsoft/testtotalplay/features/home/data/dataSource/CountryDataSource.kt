package com.rendonsoft.testtotalplay.features.home.data.dataSourceimport com.rendonsoft.testtotalplay.features.home.domain.CountryItemimport com.rendonsoft.testtotalplay.utils.models.results.ResultApiinterface CountryDataSource {    suspend fun getCountries() : ResultApi<List<CountryItem>>}