package com.rabbit.buylocal.dao;

import java.util.List;

import com.rabbit.buylocal.model.Country;

public interface CountryDAO {
    public List<Country> fetchAll();

    public Country fetchById(final long id);
}
