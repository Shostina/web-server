package servlets;

import accounts.AccountService;
import service.ServiceException;
import utils.WriteInPage;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/signIn")
public class SignInServlet extends HttpServlet {
    @Override
    public void doPost(HttpServletRequest request,
                       HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        if (login == null || password == null) {
            WriteInPage.write(response,"login or password is null", HttpServletResponse.SC_BAD_REQUEST);
            return;
        }
        try {
            AccountService.instance().checkUser(login, password);
        } catch (ServiceException e) {
            WriteInPage.write(response,"login or password is wrong", HttpServletResponse.SC_UNAUTHORIZED);
            return;
        }
        request.setAttribute("login", login);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/chat.jsp");
        dispatcher.forward(request, response);
    }
}
