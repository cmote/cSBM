package wen.cmote.cSBM.springboot.config;

import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;

import com.alibaba.druid.support.http.StatViewServlet;
/**
 * Druid的Servlet
 */
@SuppressWarnings("serial")
@WebServlet(urlPatterns = "/druid/*",
initParams = {
		@WebInitParam(name = "allow", value = "127.0.0.1"), //IP白名单（没有配置或者为空，则允许所有访问
		@WebInitParam(name = "deny", value = "192.168.1.111"), //IP黑名单（存在共同时，deny优先于allow）
		@WebInitParam(name = "loginUsername", value = "cmote"), //用户名
		@WebInitParam(name = "loginPassword", value = "cmote"), //密码
		@WebInitParam(name = "resetEnable", value = "false") // 禁用HTML页面上的“Rest All”功能是·
})
public class DruidStatViewServlet extends StatViewServlet {

}
