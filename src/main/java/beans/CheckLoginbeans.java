package beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class CheckLoginbeans implements Serializable {
	private static final long serialVersionID = 1L;

	private String mailaddress;
	private String password;


	// 引数なしのコンストラクタ
	public CheckLoginbeans() {

	}


	public String getMailaddress() {
		return mailaddress;
	}


	public void setMailaddress(String mailaddress) {
		this.mailaddress = mailaddress;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public List<String> getAll() {
		List<String> list = new ArrayList<String>();
		list.add(getMailaddress());
		list.add(getPassword());

		return list;
	}

	public void setAll(List<String> list) {
		setMailaddress(list.get(0));
		setPassword(list.get(1));
	}

}
