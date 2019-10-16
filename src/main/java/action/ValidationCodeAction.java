package action;

import org.patchca.service.Captcha;
import util.ValidationCodeUtils;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.IOException;

@WebServlet("/validationcodeaction.png")
public class ValidationCodeAction extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		Captcha captcha = ValidationCodeUtils.getCaptcha();

		String value = captcha.getChallenge();
		HttpSession session = req.getSession();
		session.setAttribute("value", value);

		BufferedImage image = captcha.getImage();
		ServletOutputStream out = res.getOutputStream();
		ImageIO.write(image, "png", out);
		
	}
}
