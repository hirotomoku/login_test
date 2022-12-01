package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import beans.CheckLoginbeans;

public class LoginDao extends SuperDao {

	private static String TABLENAME = "member";
	
	//メールアドレスとパスワードでレコードが検出されるかチェック
	@Override
	public int checkRecord(CheckLoginbeans loginbeans) {
		int a = 0;
		//データベースに接続
		loadJDBCDriver();
		System.out.println("ロードできました。");
		Connection con = null;
		try {
			con = getConnection();//継承されてるメソッドとフィールドの接続情報を使ってアクセス
			//mailaddressとパスワードで一致するかチェック
			String sql = "select count(*) AS count from " + TABLENAME+" where mailaddress = '" +loginbeans.getMailaddress() + 
					"' AND password = '" + loginbeans.getPassword() + "'";
			Statement stmt = con.createStatement();//SQL文をデータベースへ送るためのオブジェクトを生成
			ResultSet rs = stmt.executeQuery(sql);//SQL文を実行し、結果をrsへ格納している。
			rs.next();//レコードを取り出す。
			a = rs.getInt("count");//そのレコードのcountカラムを取り出す。
			
		} catch (SQLException e) {
			/* エラー時の処理 */
			e.printStackTrace();
			// メンバ一覧獲得に失敗した場合はnullを返す

		} finally {
			/* データベースからの切断 */
			closeConnection(con);
		}
		return a; 
	}

	// ******** tableの全データ読み出し *******************
	@Override
	public ArrayList<CheckLoginbeans> selectAllRecord() {
		loadJDBCDriver();
		System.out.println("ロードできました。");

		// メンバ一覧を保持するリスト
		ArrayList<CheckLoginbeans> list = new ArrayList<>();

		Connection con = null;
		try {
			/* データベースに接続 */
			con = getConnection();

			/* データベースにSQL文を送信 */
			String sql = "select * from " + TABLENAME+" order by shohin_id";
			Statement stmt = con.createStatement();//SQL文をデータベースへ送るためのオブジェクトを生成
			ResultSet rs = stmt.executeQuery(sql);

			/* メンバ一覧情報の作成 */
			while (rs.next()) {
				CheckLoginbeans shohinbeans = new CheckLoginbeans();

				// 検索結果をSample_Javabeansに格納
//				shohinbeans.setShohin_id(rs.getString("shohin_id"));
//				shohinbeans.setShohin_mei(rs.getString("shohin_mei"));
//				shohinbeans.setShohin_bunrui(rs.getString("shohin_bunrui"));
//				shohinbeans.setHanbai_tanka(rs.getInt("hanbai_tanka"));
//				shohinbeans.setShiire_tanka(rs.getInt("shiire_tanka"));
//				shohinbeans.setTorokubi(rs.getDate("torokubi"));

				// Sample_Javabeansを、 一覧を保持するリストに追加
				list.add(shohinbeans);
			}

			/* メンバ一覧を返す */

		} catch (SQLException e) {
			/* エラー時の処理 */
			e.printStackTrace();
			// メンバ一覧獲得に失敗した場合はnullを返す
			list = null;

		} finally {
			/* データベースからの切断 */
			closeConnection(con);
		}
		return list;
	}

	// Tableに1レコード挿入
	// @Override
	public void insertRecord(CheckLoginbeans loginbeans) {
		loadJDBCDriver();
		Connection con = getConnection();

		String sql = "insert into " + TABLENAME + " values(?,?,?,?,?,?);";

		try {
			PreparedStatement statement = con.prepareStatement(sql);
//			statement.setString(1, loginbeans.getShohin_id());
//			statement.setString(2, loginbeans.getShohin_mei());
//			statement.setString(3, loginbeans.getShohin_bunrui());
//			statement.setInt(4, loginbeans.getHanbai_tanka());
//			statement.setInt(5, loginbeans.getShiire_tanka());
//			statement.setDate(6, loginbeans.getTorokubi());


			System.out.println(sql + "を発行しました"); // OK
			// Statement stmt = con.createStatement();

			statement.executeUpdate();
			//commitする。自動コミットの場合は、使わない。
			//con.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			/* データベースからの切断 */
			closeConnection(con);
			System.out.println("DAO抜ける！");
		}
		return;
	}
	public static void main(String[] args) {
		CheckLoginbeans test = new CheckLoginbeans();
		test.setMailaddress("hirotomoku@gmail.com");
		test.setPassword("69186919");
		LoginDao a = new LoginDao();
		a.checkRecord(test);
	}
}
