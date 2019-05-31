package xnjkPhoto;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.sql.DriverManager;




import sun.misc.BASE64Decoder;
@javax.jws.WebService
public class PhotoImpl implements Photo{

	@Override
	public void CreatePrePostShiftMeeting(String formDocumentNo, String file_names, String file_bodys) {
		String  dir = "d:\\photo\\" + file_names;
		String sql ="update DEVICE_XUNJIAN_RECORD set FILENAME = '" + dir + "' where  ID = '" + formDocumentNo + "'";
		java.sql.Connection connect =null;
		java.sql.Statement state=null;
		int result=0;
		
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			connect=DriverManager.getConnection("jdbc:oracle:thin:@10.40.121.167:1521:orcl?useUnicode=true&characterEncoding=utf-8", "xitieams", "xitieams");
			state=connect.createStatement();
			result=state.executeUpdate(sql);
			boolean flag=GenerateImage(file_bodys, file_names);
			System.out.println(flag);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				state.close();
				connect.close();
			} catch (Exception e2) {
				
			}
		}
		}
	  public boolean GenerateImage(String imgStr, String fileName) {
		    if (imgStr == null)
		      return false;
		    BASE64Decoder decoder = new BASE64Decoder();
		    try
		    {
		      byte[] b = decoder.decodeBuffer(imgStr);
		      for (int i = 0; i < b.length; ++i) {
		        if (b[i] < 0)
		        {
		          int tmp41_39 = i;
		          byte[] tmp41_37 = b; tmp41_37[tmp41_39] = (byte)(tmp41_37[tmp41_39] + 256);
		        }
		      }
		      String  dir = "d:\\photo\\" + fileName;
		      OutputStream out = new FileOutputStream(dir);
		      out.write(b);
		      out.flush();
		      out.close();
		      return true;
		    } catch (Exception e) {
		      System.out.println(e.toString()); }
		    return false;
		  }
	
}
