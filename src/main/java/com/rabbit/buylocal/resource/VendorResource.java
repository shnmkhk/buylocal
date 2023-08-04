package com.rabbit.buylocal.resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.rabbit.buylocal.model.Vendor;

@RestController
public class VendorResource {

	@GetMapping("/vendor/{vid}")
	@ResponseBody
	public Vendor findById(@PathVariable final String vid) {
		return new Vendor(100L, vid, "Vendor-"+vid);
	}
}
