package crypt;

import java.util.Base64;

/**
	 * Java 8 より導入された java.util.Base64 の利用デモ。
	 */
	public class Base64EnCrypt {

	    public String enCodePassword(String password) {

	        // エンコードは、Base64.getEncoder() で得られるオブジェクトを利用する
	        // Base64 エンコード結果を String としたい場合は、Encoder#encodeToString() を呼び出す
	        String encoded = Base64.getEncoder()
	                .encodeToString(password.getBytes());

	        // デコードは Base64.getDecoder() で得られるオブジェクトを利用する
//	        String decoded = new String(Base64.getDecoder()
//	                .decode(encoded));

	        System.out.println("# Base64.getEncoder() / Base64.getDecoder() のデモ");
	        System.out.println("エンコード結果 : " + encoded);
//	        System.out.println("デコード結果 : " + decoded);
	        System.out.println();
	        return encoded;
	    }


}
