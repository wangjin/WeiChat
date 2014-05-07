package tk.jimmywang.weichat.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import tk.jimmywang.weichat.entity.response.Article;
import tk.jimmywang.weichat.entity.response.NewsMessage;
import tk.jimmywang.weichat.entity.response.TextMessage;
import tk.jimmywang.weichat.util.MessageUtil;

@Component
public class ProcessService {
	
	@Autowired
	private MessageService messageService;
	
	public String processRequest(HttpServletRequest request) {
		
		Logger logger  = LoggerFactory.getLogger(ProcessService.class);
		String respMessage = null;
		try {

			// xml请求解析
			Map<String, String> requestMap = MessageUtil.parseXml(request);
			// String content = requestMap.get("Content");
			// 发送方帐号（open_id）
			String fromUserName = requestMap.get("FromUserName");
			// 公众帐号
			String toUserName = requestMap.get("ToUserName");
			// 消息类型
			String msgType = requestMap.get("MsgType");
			
			logger.info("[msgType]" + msgType);

			// 文本消息
			if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_TEXT)) {
				
				
				 TextMessage textMessage = new TextMessage();
				// //开发者
				 textMessage.setToUserName(fromUserName);
				// //发送方帐号（一个OpenID）
				 textMessage.setFromUserName(toUserName);
				 textMessage.setCreateTime(new Date().getTime());
				 textMessage.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_TEXT);
				 textMessage.setContent(messageService.mainMenu());
				 textMessage.setFuncFlag(0);
				 respMessage = MessageUtil.textMessageToXml(textMessage);
			}
			// 图片消息
			else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_IMAGE)) {
				logger.info("into image");
				respMessage = "您发送的是图片消息！";
				// // 回复文本消息
				 TextMessage textMessage = new TextMessage();
				// //开发者
				 textMessage.setToUserName(fromUserName);
				// //发送方帐号（一个OpenID）
				 textMessage.setFromUserName(toUserName);
				 textMessage.setCreateTime(new Date().getTime());
				 textMessage.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_TEXT);
				 textMessage.setContent("您好，已收到您的图片消息！");
				 textMessage.setFuncFlag(0);
				 respMessage = MessageUtil.textMessageToXml(textMessage);

			}
			// 地理位置消息
			else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_LOCATION)) {
				respMessage = "您发送的是地理位置消息！";
			}
			// 链接消息
			else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_LINK)) {
				respMessage = "您发送的是链接消息！";
			}
			// 音频消息
			else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_VOICE)) {
				respMessage = "您发送的是音频消息！";
			}
			// 图文消息
			else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_NEWS)) {
				respMessage = "您发送的是图文消息！";

			}
			// 事件推送
			else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_EVENT)) {
				// 事件类型
				String eventType = requestMap.get("Event");
				// 订阅
				if (eventType.equals(MessageUtil.EVENT_TYPE_SUBSCRIBE)) {

					// 创建图文消息
					NewsMessage newsMessage = new NewsMessage();
					newsMessage.setToUserName(fromUserName);
					newsMessage.setFromUserName(toUserName);
					newsMessage.setCreateTime(new Date().getTime());
					newsMessage.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_NEWS);
					newsMessage.setFuncFlag(0);

					List<Article> articleList = new ArrayList<Article>();
					Article article1 = new Article();
					article1.setTitle("开发测试");
					article1.setDescription("这是一个开发测试");
					article1.setPicUrl("http://weichat.wangjinzone.tk/resources/images/car.jpg");
					article1.setUrl("http://weichat.wangjinzone.tk/");

					Article article2 = new Article();
					article2.setTitle("第2篇\n微信公众帐号的类型");
					article2.setDescription("");
					article2.setPicUrl("http://202.102.83.54/4sWeixin/img/pic/xtp.png");
					article2.setUrl("http://www.ibrdp.com/WeiXinTest/Driving!drivingList.action");

					// Article article3 = new Article();
					// article3.setTitle("第3篇\n开发模式启用及接口配置");
					// article3.setDescription("");
					// article3.setPicUrl("http://avatar.csdn.net/1/4/A/1_lyq8479.jpg");
					// article3.setUrl("http://blog.csdn.net/lyq8479/article/details/8944988");

					articleList.add(article1);
					// articleList.add(article2);
					// articleList.add(article3);
					newsMessage.setArticleCount(articleList.size());
					newsMessage.setArticles(articleList);
					respMessage = MessageUtil.newsMessageToXml(newsMessage);
				}
				// 取消订阅
				else if (eventType.equals(MessageUtil.EVENT_TYPE_UNSUBSCRIBE)) {
					// TODO 取消订阅后用户再收不到公众号发送的消息，因此不需要回复消息
				}
				// 自定义菜单点击事件
				else if (eventType.equals(MessageUtil.EVENT_TYPE_CLICK)) {
					// TODO 自定义菜单权没有开放，暂不处理该类消息

				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return respMessage;
	}
}
