package com.example.emtbackend191216.service.interfaces;

import com.example.emtbackend191216.model.entities.Country;

import java.util.List;

public interface CountryService {
    Country save(String name, String continent);
    Country edit(Long id, String name, String continent);
    List<Country> findAll();
    Country findById(Long countryId);
    Country deleteById(Long countryId);
}
