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
/**
 * 
 * @author 华文财
 * @time:2018年4月12日 上午9:15:07
 * @Description:TODO   字符编码过滤器类
 */
public class CharacterEncodingFilter implements Filter {

	private FilterConfig filterConfig = null;
	//设置默认字符编码
	private String defaultCharset = "UTF-8";
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		//获取过滤器的初始化信息
		this.filterConfig = filterConfig;
	}
	
	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		//1.强转
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) resp;
		
		//2.逻辑
		//这个初始化参数是在web.xml中的配置filter时自己定义的， 在filter标签内部
		String charset = filterConfig.getInitParameter("charset");
		if(charset == null){
			charset = defaultCharset;
		}
		request.setCharacterEncoding(charset);
		response.setCharacterEncoding(charset);
		response.setContentType("text/html;charset="+charset);
		
		//3.放行
		chain.doFilter(request, response);
	}

}
