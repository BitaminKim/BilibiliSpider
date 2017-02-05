package main;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TakeManga {
	String statuscode="";
	BufferedReader in = null;
	String biliUrl;
	public void setUrl(String Url){
		this.biliUrl = Url;
	}
	public URLConnection getConnection() throws Exception{
		URL urlString = new URL(biliUrl);
		URLConnection con = urlString.openConnection();
		con.setRequestProperty("accept", "*/*");
        con.setRequestProperty("connection", "Keep-Alive");
        con.setRequestProperty("user-agent",
                "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
        con.connect();
		return con;
	}
	public String getStatusCode(){
		
		// 建立实际的连接
		URLConnection con;
		try {
			con = getConnection();
			statuscode = con.getHeaderField(0);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
       		return statuscode;
	}
	
	public String getresult(){
		String result = "";
		try {
			URLConnection con = getConnection();
	        in = new BufferedReader(new InputStreamReader(con.getInputStream()));
	        String line;
	        while ((line = in.readLine()) != null) {
	            result += line;
	        }
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
		return result;
	}
	public String getMangaJpgUrl(String httpresult){
		String jpgurl = "";
		String patternjpg = "(i0.hdslb.com/bfs/bangumi/\\w*.jpg)";
		Pattern rjpg = Pattern.compile(patternjpg);
		Matcher mjpg = rjpg.matcher(httpresult);
		if (mjpg.find()) {
		    jpgurl = mjpg.group(0);
		} else {
		    System.out.println("NO MATCH");
		}
        return jpgurl;
	}
	public String getMangaName(String httpresult){
		String manganame = "";
		String patterntitle = "(<title>[A-Za-z0-9]*[\u4e00-\u9fa5]*[A-Za-z0-9]*..[A-Za-z0-9]*[\u4e00-\u9fa5]*[A-Za-z0-9]*|<title>[A-Za-z0-9]*[\u4e00-\u9fa5]*[A-Za-z0-9]*)";
		Pattern rtitle = Pattern.compile(patterntitle);
        Matcher mtitle = rtitle.matcher(httpresult);
        if (mtitle.find()) {
            manganame = mtitle.group(0).substring(7);
        } else {
            System.out.println("NO MATCH");
        }
        return manganame;
	}
}
