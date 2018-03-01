package com.leone.chapter.profiles.test;

import javax.jws.WebMethod;
import javax.jws.WebResult;
import javax.jws.WebService;

@WebService(targetNamespace = "http://service.SapPro.dms.evun.com", endpointInterface = "com.leone.chapter.profiles.test.VehicleInfoRequestService")
public class VehicleInfoRequestServiceImpl implements VehicleInfoRequestService {
	@Override
	@WebMethod(operationName = "saveVehicleInfo")
	@WebResult(name = "VehicleInfoResponse")
	public VehicleInfoResponse saveVehicleInfo(VehicleInfoRequest vehicleInfoRequest) {
		VehicleInfoResponse vehicleInfoResponse = new VehicleInfoResponse();
		vehicleInfoResponse.setMessage("");
		vehicleInfoResponse.setResult("");

		return vehicleInfoResponse;
	}
}