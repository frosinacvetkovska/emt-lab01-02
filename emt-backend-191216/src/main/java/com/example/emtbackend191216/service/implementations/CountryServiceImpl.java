package com.example.emtbackend191216.service.implementations;

import com.example.emtbackend191216.model.entities.Country;
import com.example.emtbackend191216.model.exceptions.CountryNotFoundException;
import com.example.emtbackend191216.repository.CountryRepository;
import com.example.emtbackend191216.service.interfaces.CountryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryServiceImpl implements CountryService {

    private final CountryRepository countryRepository;

    public CountryServiceImpl(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    @Override
    public Country save(String name, String continent) {
        return this.countryRepository.save(new Country(name, continent));
    }

    @Override
    public Country edit(Long id, String name, String continent) {
        Country country = this.findById(id);
        country.setName(name);
        country.setContinent(continent);
        return this.countryRepository.save(country);
    }

    @Override
    public List<Country> findAll() {
        return this.countryRepository.findAll();
    }

    @Override
    public Country findById(Long countryId) {
        return this.countryRepository.findById(countryId).orElseThrow(() -> new CountryNotFoundException(countryId));
    }

    @Override
    public Country deleteById(Long countryId) {
        Country country = this.findById(countryId);
        this.countryRepository.deleteById(countryId);
        return country;
    }
}
