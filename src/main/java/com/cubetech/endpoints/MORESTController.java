/**
 * 
 */
package com.cubetech.endpoints;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ThanhND
 *
 */
@RestController
public class MORESTController {

	@RequestMapping(value = "/cp", method = RequestMethod.POST)
	public @ResponseBody String receiverMO(@RequestHeader(value = "username", required = true) String username,
			@RequestHeader(value = "password", required = true) String password, @RequestBody String moJson) {
		if ("thanhnd".equals(username) && "thanhnd".equals(password)) {
			return "1";
		}
		return "0";
	}
}
