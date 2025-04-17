package co.yedam.control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.*;

import co.yedam.common.Control;

public class LoginFormControl implements Control {

    @Override
    public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        Object error = session.getAttribute("loginError");

        if (error != null) {
            req.setAttribute("message", error);
            session.removeAttribute("loginError");
        }

        req.getRequestDispatcher("common/login.tiles").forward(req, resp);
    }
}
