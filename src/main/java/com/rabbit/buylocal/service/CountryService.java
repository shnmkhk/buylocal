package com.rabbit.buylocal.service;

import java.util.List;

import com.rabbit.buylocal.model.Country;

public interface CountryService {
    public List<Country> fetchAll();
    public Country fetchById(long cid);
}
