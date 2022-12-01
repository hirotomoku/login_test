package common;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class ChangeHash {
	public static String sha256(String orgStr) {
	    String hashedStr = "";

	    try {
	        MessageDigest md = MessageDigest.getInstance("SHA-256");//SHA256を使ってハッシュ値をつくるオブジェクトを作成
	        byte[] hash = md.digest(orgStr.getBytes());//引数の文字列を一度バイト配列に変換。そのバイト配列をmdオブジェクトに入れてハッシュ値を生成。
	        System.out.println(hash);
	        BigInteger bi = new BigInteger(1, hash);
	        hashedStr = String.format("%0" + (hash.length << 1) + "x", bi);

	    } catch (NoSuchAlgorithmException e) {
	        e.printStackTrace();
	    }

	    return hashedStr;
	}

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		String str = sha256("123456");
		String str2 = "123456";
		
		System.out.println(str);
		System.out.println(sha256(str2));
	}

}
