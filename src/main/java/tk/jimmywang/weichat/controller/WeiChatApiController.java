package tk.jimmywang.weichat.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import tk.jimmywang.weichat.service.ProcessService;
import tk.jimmywang.weichat.util.AuthUtil;

@Controller
public class WeiChatApiController {

	public static final String TOKEN = "WEICHATTOKEN";

	@RequestMapping(value = "/weichatapi", method = RequestMethod.GET)
	public void weiChatApiGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		PrintWriter out = response.getWriter();
		String signature = request.getParameter("signature");
		String timestamp = request.getParameter("timestamp");
		String nonce = request.getParameter("nonce");
		String echostr = request.getParameter("echostr");

		if (echostr == null || "".equals(echostr)) {
			out.write("error");
			return;
		}
		String[] tmpArr = { TOKEN, timestamp, nonce };

		Arrays.sort(tmpArr);

		String tmpStr = AuthUtil.arrayToString(tmpArr);

		tmpStr = AuthUtil.SHA1Encode(tmpStr);

		if (tmpStr.equalsIgnoreCase(signature)) {
			out.write(echostr);

		} else {
			out.write("error");
		}
	}

	@RequestMapping(value = "/weichatapi", method = RequestMethod.POST)
	public void weiChatApiPost(HttpServletRequest request, HttpServletResponse response) throws Exception {

		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");

		PrintWriter writer = response.getWriter();

		writer.write(ProcessService.processRequest(request));
		writer.close();

	}
}
