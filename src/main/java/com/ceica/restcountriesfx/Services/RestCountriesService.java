package com.ceica.restcountriesfx.Services;

import com.ceica.restcountriesfx.Models.CountryDTO;

import java.util.List;

public class RestCountriesService implements IRestCountries {
    @Override
    public String[] getRegions() {

        return new String[0];
    }

    @Override
    public List<CountryDTO> getCoutriesByRegion(String region) {
        return null;
    }

    @Override
    public CountryDTO getCountryByName(String name) {
        return null;
    }
}
