package com.rabbit.buylocal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rabbit.buylocal.dao.CountryDAO;
import com.rabbit.buylocal.model.Country;

@Service
public class CountryServiceImpl implements CountryService {

    @Autowired
    private CountryDAO countryDAO;

    @Override
    public List<Country> fetchAll() {
        return countryDAO.fetchAll();
    }

    @Override
    public Country fetchById(long cid) {
        return countryDAO.fetchById(cid);
    }
}
