package com.rabbit.buylocal.resource;

import java.util.List;

import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.rabbit.buylocal.model.Country;
import com.rabbit.buylocal.service.CountryService;

@RestController
public class CountryResource {

	@Autowired
	private CountryService countryService;

	@GetMapping("/country")
	@ResponseBody
	public ResponseEntity<List<Country>> findAll() {
		List<Country> list = countryService.fetchAll();
		if (list == null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		return new ResponseEntity<>(list, HttpStatus.OK);
	}

	@GetMapping("/country/{cid}")
	@ResponseBody
	public ResponseEntity<Country> findById(@PathVariable final long cid) {
		Country result = countryService.fetchById(cid);

		if (result == null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
}
