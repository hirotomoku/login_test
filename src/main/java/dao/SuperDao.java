package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import beans.CheckLoginbeans;

public class SuperDao implements MasterDaoInterface {
	// ******** ＤＢとの接続に必要な情報を保持する ***
	private final static String DRIVER_URL = "jdbc:postgresql://localhost:5432/shop";
	private final static String DRIVER_NAME = "org.postgresql.Driver";
	private final static String USER_NAME = "postgres";
	private final static String PASSWORD = "6918";

	// private final static String RESOURCE_NAME = "jdbc/mydata";

	// ******** ドライバのロード ****************
	@Override
	public void loadJDBCDriver() {
		try {
			Class.forName(DRIVER_NAME);
			System.out.println("ロードに成功しました。");
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}

	// ******** DBに接続 *************************
	@Override
	public Connection getConnection() {
		try {
			System.out.println("connect0");
			return (DriverManager
					.getConnection(DRIVER_URL, USER_NAME, PASSWORD));
		} catch (SQLException e) {
			System.out.println("エラーですな！");
			throw new RuntimeException(e);
		}
	}

	// ******** DBの接続解除 *********************
	@Override
	public void closeConnection(Connection con) {
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// ******** tableの全データ読み出し *******************
	@Override
	public ArrayList<?> selectAllRecord() {
		ArrayList<?> list = new ArrayList<>();
		return list;
	}

	@Override
	public List<?> selectRecordById() {
		return null;
	}

	@Override
	public void insertRecord(Object obj) {

	}

	@Override
	public void updateRecordById(Object obj) {

	}

	@Override
	public Object selectRecordById(Object obj) {
		return null;
	}

	@Override
	public void deleteRecordById(Object obj) {

	}

	@Override
	public int checkRecord(Object obj) {
		// TODO 自動生成されたメソッド・スタブ
		return 0;
	}
	@Override
	public int checkRecord(CheckLoginbeans loginbeans) {
		// TODO 自動生成されたメソッド・スタブ
		return 0;
	}


}
