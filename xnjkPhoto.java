package xnjkPhoto;

import javax.xml.ws.Endpoint;


public class xnjkPhoto {

	public static void main(String[] args) {
		String address="http://10.40.16.27:8081/xnjkPhoto/Photo";
		Endpoint.publish(address, new PhotoImpl());
		System.out.println("success");
	}

}
