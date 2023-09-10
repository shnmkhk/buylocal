package com.rabbit.buylocal.dao;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.sql.DataSource;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.rabbit.buylocal.model.Country;

@Repository
public class CountryDAOImpl implements CountryDAO {

    @Autowired
    private DataSource dataSource;

    public List<Country> fetchAll() {
        // Create a ResultSetHandler implementation to convert the
        // first row into an Object[].
        ResultSetHandler<List<Country>> h = new ResultSetHandler<List<Country>>() {
            public List<Country> handle(ResultSet rs) throws SQLException {
                if (!rs.next()) {
                    return null;
                }
                List<Country> list = new ArrayList<>();
                do {
                    list.add(new Country(rs.getInt(1), rs.getString(2)));
                } while (rs.next());
                return list;
            }
        };

        // Create a QueryRunner that will use connections from
        // the given DataSource
        QueryRunner run = new QueryRunner(dataSource);

        // Execute the query and get the results back from the handler
        try {
            List<Country> result = run.query(
                    "SELECT * FROM Country", h);
            System.out.println("Countries: " + result);
            return result;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Country fetchById(long id) {
    // Create a ResultSetHandler implementation to convert the
        // first row into an Object[].
        ResultSetHandler<Country> h = new ResultSetHandler<Country>() {
            public Country handle(ResultSet rs) throws SQLException {
                if (!rs.next()) {
                    return null;
                }
                return new Country(rs.getInt(1), rs.getString(2));
            }
        };

        // Create a QueryRunner that will use connections from
        // the given DataSource
        QueryRunner run = new QueryRunner(dataSource);

        // Execute the query and get the results back from the handler
        try {
            Country result = run.query(
                    "SELECT * FROM Country where id=?", h, id);
            return result;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
