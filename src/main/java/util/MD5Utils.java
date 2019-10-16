package util;

import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Utils {
	private final static MessageDigest digest ;
	private final static char[] cs = {'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
	static{
		 try {
			digest =  MessageDigest.getInstance("md5");
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException(e.getMessage(),e);
		};
	}
	public static String digest(String msg){
		byte[] bytes = digest.digest(msg.getBytes(Charset.forName("utf-8")));
		StringBuffer sb = new StringBuffer();
		for(byte b : bytes){
			sb.append(cs[b >>> 4 & 0x0f]);
			sb.append(cs[b & 0x0f]);
			
		}
		
	
		return sb.toString();
		
	}
	
	public static void main(String[] args) {
		System.out.println(digest("hello world"));
		System.out.println(digest("hello world"));
		System.out.println(digest("hello world2"));
		System.out.println(digest("hello world2"));
		
	}
	
}
