package team.antelope.fg.filter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import team.antelope.fg.entity.Person;
import team.antelope.fg.util.Log4jUtil;

/**
 * 
 * @author 华文财
 * @time:2018年4月12日 上午9:19:21
 * @Description:TODO 访问权限过滤器
 */
public class AccessFilter implements Filter {

	private FilterConfig filterConfig = null;
	private String excludedPage;
	private String[] excludedPages;

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// 获取初始化配置对象
		this.filterConfig = filterConfig;
		excludedPage = filterConfig.getInitParameter("excludedPages");
		if (excludedPage != null && excludedPage.length() > 0) {
			excludedPages = excludedPage.split(",");
		}
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		// 1.强转
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) resp;
		// 定义表示变量 并验证用户请求URL 是否包含不过滤路径
        boolean flag = true;	//需要过滤
        String servletPath = request.getServletPath();
        Log4jUtil.info("request.getServletPath()："+servletPath);
        List<String> list = Arrays.asList(excludedPages);
        
        if(excludedPages != null && excludedPages.length !=0){
        	for (String page:excludedPages) {
                if (servletPath.equals(page)){
                    flag = false;	//不需要过滤
                    break;
                }
            }
        }
        
        Log4jUtil.info("doFilter");
		// 2.逻辑
        // 验证用户登录
        if (flag){
        	Log4jUtil.info("需要验证");
        	Person person = (Person) request.getSession().getAttribute("person");
        	// 如果没有登入系统，则跳转页面
    		if (person == null) {
    			Log4jUtil.info("person为null");
    			response.setStatus(401);// 请求要求身份验证。 对于需要登录的网页，服务器可能返回此响应
    			// 未登入，跳转到登入页面进行登入
    			request.getRequestDispatcher("/login.jsp").forward(request, response);
    			// 没有登入不需要继续执行下一个filter
    			return;
    		}
        }
        Log4jUtil.info("reqsendid"+ request.getRequestedSessionId());
        Log4jUtil.info("sessionid" + request.getSession().getId());
		// 3.放行, 如果登入或者不用过滤的，则可以继续
		chain.doFilter(request, response);
	}

}
