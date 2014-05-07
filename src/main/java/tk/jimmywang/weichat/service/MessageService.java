package tk.jimmywang.weichat.service;

import org.springframework.stereotype.Component;

@Component
public class MessageService {

	public String mainMenu(){
		StringBuilder sb = new StringBuilder();
		sb.append("您好,请回复数字选择服务:").append("\n\n");
		sb.append("1  天气预报").append("\n");  
	    sb.append("2  公交查询").append("\n");  
	    sb.append("3  周边搜索").append("\n");  
	    sb.append("4  歌曲点播").append("\n");  
	    sb.append("5  经典游戏").append("\n");  
	    sb.append("6  美女电台").append("\n");  
	    sb.append("7  人脸识别").append("\n");  
	    sb.append("8  聊天唠嗑").append("\n\n");  
	    sb.append("回复\"?\"显示此帮助菜单");
		return sb.toString();
	}
}
