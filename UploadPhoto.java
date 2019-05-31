package xnjkphoto;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sun.misc.BASE64Decoder;



@WebServlet("/uploadPhoto")
public class UploadPhoto extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		System.out.println("post...");
		String recordPhoto=request.getParameter("recordPhoto");
		String photoPathAll=request.getParameter("photoPathAll");
		System.out.println(photoPathAll);
		BASE64Decoder decoder=new BASE64Decoder();
		String a= "D:/xnjkPhoto";
		File outDir=new File(a);
		outDir.mkdirs();
		FileOutputStream write=new FileOutputStream(a+"/"+photoPathAll);
		byte[] decoderBytes=decoder.decodeBuffer(recordPhoto);
		write.write(decoderBytes);
		write.close();
	}

}
