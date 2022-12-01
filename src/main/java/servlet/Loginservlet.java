package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.CheckLoginbeans;
import common.ChangeHash;
import model.LoginMain;

/**
 * Servlet implementation class Loginservlet
 */
@WebServlet("/Loginservlet")
public class Loginservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static int count = 0;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Loginservlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
	private void forwardJSP(String url, HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);
	}
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		forwardJSP("Login.html", request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");//フォームデータから送られてきた情報は01。なのでそのデータをどの文字コードで表現するか指定。
		HttpSession session = request.getSession(true);//初回.セッションオブジェクトを生成。trueだと。falseだと作らない。
		System.out.println(session.getId());//セッションIDを表示
		
		switch (request.getParameter("page_num")) {//page_num（ページ）によってムーブ分け
		case "0"://ログイン試行時
			String mail = request.getParameter("mailaddress");//セッションのリクエストに格納されている指定された変数の値を取り出す。
			String pass = request.getParameter("password");//セッションのリクエストに格納されている指定された変数の値を取り出す		
			String hashedpass = ChangeHash.sha256(pass);//パスワードをハッシュ化
			CheckLoginbeans cb = new CheckLoginbeans();//ログインビーンズインスタンス化
			cb.setMailaddress(mail);//格納
			cb.setPassword(hashedpass);//格納
			LoginMain cr = new LoginMain();
			if(cr.checkRecord(cb) == 0) {
				count++;
				System.out.println(count + "回目");
				if(count >= 3) {//３回間違ったときにセッションアウト
					forwardJSP("Burn.html", request, response);
					session.invalidate();
				}
				System.out.println("該当レコードがありませんでした。");
				session.setAttribute("mailaddress",mail);//setAttributeはJSPに値をわたすやつ.getAttributeはオブジェクトを返す。
				forwardJSP("NotRecord.jsp", request, response);
			}else if(cr.checkRecord(cb) == 1){
				System.out.println("該当レコードがありました。");
				forwardJSP("Welcome.jsp", request, response);
			}else {
				System.out.println("システムエラーが発生しました。");
			}
			break;
		case "1":
			System.out.println("2回目つきました");
			break;
		default:
			break;
		}
	}

}
