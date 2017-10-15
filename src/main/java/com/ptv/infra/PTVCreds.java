package com.ptv.infra;


public class PTVCreds {
	
	protected static int devId = Integer.parseInt(System.getenv().get("PTV_DEV_ID"));

	protected static String privateKey = System.getenv().get("PTV_KEY");
	
	protected static String baseUrl= System.getenv().get("PTV_URL");
	
}
