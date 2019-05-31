package xnjkPhoto;

import javax.jws.WebMethod;

@javax.jws.WebService
public interface Photo {
	@WebMethod
	public void CreatePrePostShiftMeeting(String formDocumentNo,String file_names, String file_bodys);
}
