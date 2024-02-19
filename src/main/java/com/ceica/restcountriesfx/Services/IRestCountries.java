package com.ceica.restcountriesfx.Services;

import com.ceica.restcountriesfx.Models.CountryDTO;

import java.util.List;

public interface IRestCountries {
    public String[] getRegions();
    public List<CountryDTO> getCoutriesByRegion(String region);
    public CountryDTO getCountryByName(String name);
}
