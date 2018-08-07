package utils;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class WriteInPage {
    public static void write(HttpServletResponse response, String message, int status) throws IOException {
        response.setContentType("text/html;charset=utf-8");
        response.getWriter().println(message);
        response.setStatus(status);
    }
}
