package com.rabbit.buylocal.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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

	private QueryRunner qr = null;

	private QueryRunner getQR() {
		if (qr == null) {
			qr = new QueryRunner(dataSource);
		}
		return qr;
	}

	public List<Country> fetchAll() {
		// Execute the query and get the results back from the handler
		try {
			List<Country> result = getQR().query("SELECT * FROM Country", listRsHandler);
			System.out.println("Countries: " + result);
			return result;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Country fetchById(long id) {
		// Execute the query and get the results back from the handler
		try {
			Country result = getQR().query("SELECT * FROM Country where id=?", objRsHandler, id);
			return result;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	// Create a ResultSetHandler implementation to convert the
	// first row into an Object[].
	private static final ResultSetHandler<List<Country>> listRsHandler = new ResultSetHandler<List<Country>>() {
		public List<Country> handle(ResultSet rs) throws SQLException {
			if (!rs.next()) {
				return null;
			}
			List<Country> list = new ArrayList<>();
			do {
				list.add(Country.of(rs.getInt(1), rs.getString(2)));
			} while (rs.next());
			return list;
		}
	};

	// Create a ResultSetHandler implementation to convert the
	// first row into an Object[].
	private static final ResultSetHandler<Country> objRsHandler = new ResultSetHandler<Country>() {
		public Country handle(ResultSet rs) throws SQLException {
			if (!rs.next()) {
				return null;
			}
			return Country.of(rs.getInt(1), rs.getString(2));
		}
	};
}
