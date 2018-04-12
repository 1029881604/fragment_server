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
 * @author ���Ĳ�
 * @time:2018��4��12�� ����9:19:21
 * @Description:TODO   ����Ȩ�޹�����
 */
public class AccessFilter implements Filter {

	private FilterConfig filterConfig = null;
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		//��ȡ��ʼ�����ö���
		this.filterConfig = filterConfig;
	}
	
	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		//1.ǿת
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) resp;
		
		//2.�߼�
		User user = (User) request.getSession().getAttribute("user");
		//���û�е���ϵͳ������תҳ��
		if(user == null){
			//δ���룬��ת������ҳ����е���
			request.getRequestDispatcher("/login.jsp").forward(request, response);
			//û�е��벻��Ҫ����ִ����һ��filter
			return;
		}
		
		//3.����, ������룬����Լ���
		chain.doFilter(request, response);
		
	}

}
