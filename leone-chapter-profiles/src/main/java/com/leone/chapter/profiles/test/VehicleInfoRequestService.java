package com.leone.chapter.profiles.test;


import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

@WebService(targetNamespace = "http://service.gsc.dms.evun.com/")
public interface VehicleInfoRequestService {

	@WebMethod(operationName = "saveVehicleInfo")
	@WebResult(name = "VehicleInfoResponse")
	public VehicleInfoResponse saveVehicleInfo(@WebParam(name = "VehicleInfoRequest") VehicleInfoRequest vehicleInfoRequest);
}