package team.antelope.fg.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import team.antelope.fg.entity.User;
/**
 * 
 * @author 华文财
 * @time:2018年4月12日 上午9:19:21
 * @Description:TODO   访问权限过滤器
 */
public class AccessFilter implements Filter {

	private FilterConfig filterConfig = null;
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		//获取初始化配置对象
		this.filterConfig = filterConfig;
	}
	
	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		//1.强转
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) resp;
		
		//2.逻辑
		User user = (User) request.getSession().getAttribute("user");
		//如果没有登入系统，则跳转页面
		if(user == null){
			//未登入，跳转到登入页面进行登入
			request.getRequestDispatcher("/login.jsp").forward(request, response);
			//没有登入不需要继续执行下一个filter
			return;
		}
		
		//3.放行, 如果登入，则可以继续
		chain.doFilter(request, response);
		
	}

}
