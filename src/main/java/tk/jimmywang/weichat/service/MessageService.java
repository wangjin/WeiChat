package tk.jimmywang.weichat.service;

import org.springframework.stereotype.Component;

@Component
public class MessageService {

	public String mainMenu() {
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

	public String menuProcess(String content) {
		String respMessage = "";
		if ("?".equals(content)||"？".equals(content)) {
			respMessage = this.mainMenu();
		} else {
			switch (Integer.parseInt(content)) {
			case 1:
				respMessage = "天气预报正在建设中...";
				break;
			case 2:
				respMessage = "公交查询正在建设中...";
				break;
			case 3:
				respMessage = "周边搜索正在建设中...";
				break;
			case 4:
				respMessage = "歌曲点播正在建设中...";
				break;
			case 5:
				respMessage = "经典游戏正在建设中...";
				break;
			case 6:
				respMessage = "美女电台正在建设中...";
				break;
			case 7:
				respMessage = "人脸识别正在建设中...";
				break;
			case 8:
				respMessage = "聊天唠嗑正在建设中...";
				break;

			}
		}
		return respMessage;
	}
}
