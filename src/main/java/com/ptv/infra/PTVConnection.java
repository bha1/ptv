package com.ptv.infra;

import java.security.Key;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

public class PTVConnection {
	   /**
     * Method to demonstrate building of Timetable API URL 
     * 
     * @param baseURL    - Timetable API base URL without slash at the end ( Example :http://timetableapi.ptv.vic.gov.au ) 
     * @param privateKey - Developer Key supplied by PTV (((Example :"9c132d31-6a30-4cac-8d8b-8a1970834799")
     * @param uri - Request URI with parameters(Example :/v2/mode/0/line/8/stop/1104/directionid/0/departures/all/limit/5?for_utc=2014-08-15T06:18:08Z)
     * @param developerId- Developer ID supplied by PTV 
     * @return Complete URL with signature
     * @throws Exception
     * 
     */
    public String buildTTAPIURL(final String baseURL, final String privateKey, final String uri,
            final int developerId) throws Exception
    {
        
        String HMAC_SHA1_ALGORITHM = "HmacSHA1";
        StringBuffer uriWithDeveloperID = new StringBuffer().append(uri).append(uri.contains("?") ? "&" : "?")
                .append("devid=" + developerId);
        byte[] keyBytes = privateKey.getBytes();
        byte[] uriBytes = uriWithDeveloperID.toString().getBytes();
        Key signingKey = new SecretKeySpec(keyBytes, HMAC_SHA1_ALGORITHM);
        Mac mac = Mac.getInstance(HMAC_SHA1_ALGORITHM);
        mac.init(signingKey);
        byte[] signatureBytes = mac.doFinal(uriBytes);
        StringBuffer signature = new StringBuffer(signatureBytes.length * 2);
        for (byte signatureByte : signatureBytes)
        {
            int intVal = signatureByte & 0xff;
            if (intVal < 0x10)
            {
                signature.append("0");
            }
            signature.append(Integer.toHexString(intVal));
        }
        StringBuffer url = new StringBuffer(baseURL).append(uri).append(uri.contains("?") ? "&" : "?")
                .append("devid=" + developerId).append("&signature=" + signature.toString().toUpperCase());

        return url.toString();

    }
    
    public String wrapper(final String uri) throws Exception {
    	return buildTTAPIURL(PTVCreds.baseUrl, PTVCreds.privateKey, uri, PTVCreds.devId);
    }
}
