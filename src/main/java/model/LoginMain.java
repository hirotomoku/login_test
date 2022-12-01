package model;

import java.util.ArrayList;

import beans.CheckLoginbeans;
import dao.LoginDao;

/**
 * ビジネスロジック層、つまりModelの処理の中心となるクラスです。<br>
 * このサンプルでは、ShohinJavabeansの内容をDBのテーブルに書くだけで処理はありませんが<br>
 * 本来は、このビジネスロジック層、Ｍが処理を担当します。<br>
 * このＭを作成しないとサーブレットから、ＤＢにアクセスすることになりＭＶＣモデルとは<br>
 * 言えなくなります<br>
 * @author M.Hosoi
 *
 */
public class LoginMain {

	public void insertData(CheckLoginbeans beans) {
		LoginDao sdao = new LoginDao();
		sdao.insertRecord(beans);
	}

	public ArrayList<CheckLoginbeans> selectAll() {
		LoginDao sdao = new LoginDao();
		ArrayList<CheckLoginbeans> alist = sdao.selectAllRecord();

		return alist;
	}
	public int checkRecord(CheckLoginbeans beans) {
		LoginDao sdao = new LoginDao();
		int a = sdao.checkRecord(beans);
		return a;
	}

}
