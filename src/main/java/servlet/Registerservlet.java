package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Registerservlet
 */
@WebServlet("/Registerservlet")
public class Registerservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Registerservlet() {
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
		// TODO Auto-generated method stub
		forwardJSP("Register.jsp", request, response);
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
			String mail = request.getParameter("mailaddress");
			String pass1 = request.getParameter("password1");
			String pass2 = request.getParameter("password2");
			String sei = request.getParameter("sei");
			String mei = request.getParameter("mei");
			session.setAttribute("mailaddress", mail);
			session.setAttribute("sei", sei);
			session.setAttribute("mei", mei);
			
			if(pass1.compareTo(pass2)!=0) {
				forwardJSP("Unmatch.jsp", request, response);
			}
			forwardJSP("Confirm.jsp", request, response);
		}
	}

}
