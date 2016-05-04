package com.cubetech.endpoints;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import org.springframework.ws.soap.SoapHeaderElement;
import org.springframework.ws.soap.server.endpoint.annotation.SoapHeader;

import com.cubetech.model.AuthHeader;
import com.cubetech.model.MOResponse;
import com.cubetech.model.ReceiverMO;
import com.cubetech.utils.Constant;

@Endpoint
public class MOSOAPController {

	@PayloadRoot(namespace = Constant.NAMESPACE_URI, localPart = "receiverMO")
	@ResponsePayload
	public MOResponse sendMT(@RequestPayload ReceiverMO request,
			 @SoapHeader("{" + AuthHeader.AUTH_NS + "}authHeader") SoapHeaderElement auth) {
		AuthHeader authHeader = getAuthentication(auth);
		System.out.println(authHeader.getUsername());
		System.out.println(authHeader.getPassword());
		MOResponse response = new MOResponse();
		response.setStatus(1);
		response.setMessage("success");
		return response;
	}
	
	private AuthHeader getAuthentication(SoapHeaderElement header){
        AuthHeader authHeader = null;
        try {

            JAXBContext context = JAXBContext.newInstance(AuthHeader.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            authHeader = (AuthHeader) unmarshaller.unmarshal(header.getSource());

        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return authHeader;
    }
}
