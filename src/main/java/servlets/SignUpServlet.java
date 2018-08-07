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

@WebServlet("/signUp")
public class SignUpServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("message", "Hi!");
        RequestDispatcher dispatcher = req.getRequestDispatcher("/signUp.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");

        if(login == null || password == null) {
            WriteInPage.write(resp, "login or password is null", HttpServletResponse.SC_BAD_REQUEST);
            return;
        }
        try {
            AccountService.instance().addUser(login, password);
        } catch (ServiceException e) {
            WriteInPage.write(resp,/*"login or password is unoriginal"*/e.getMessage(), HttpServletResponse.SC_BAD_REQUEST);
            return;
        }
        req.setAttribute("message", "Congratulations, you registered.\nLogin: " + login);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/signUp.jsp");
        dispatcher.forward(req, resp);
    }
}
