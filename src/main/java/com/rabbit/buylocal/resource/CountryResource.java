package com.rabbit.buylocal.resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.rabbit.buylocal.model.Country;

@RestController
public class CountryResource {

	@GetMapping("/country/{cid}")
	@ResponseBody
	public Country findById(@PathVariable final long cid) {
		return new Country(cid, "Country-" + cid);
	}
}
