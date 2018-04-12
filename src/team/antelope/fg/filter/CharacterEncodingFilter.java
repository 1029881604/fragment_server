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
 * @author ���Ĳ�
 * @time:2018��4��12�� ����9:15:07
 * @Description:TODO   �ַ������������
 */
public class CharacterEncodingFilter implements Filter {

	private FilterConfig filterConfig = null;
	//����Ĭ���ַ�����
	private String defaultCharset = "UTF-8";
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		//��ȡ�������ĳ�ʼ����Ϣ
		this.filterConfig = filterConfig;
	}
	
	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		//1.ǿת
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) resp;
		
		//2.�߼�
		//�����ʼ����������web.xml�е�����filterʱ�Լ�����ģ� ��filter��ǩ�ڲ�
		String charset = filterConfig.getInitParameter("charset");
		if(charset == null){
			charset = defaultCharset;
		}
		request.setCharacterEncoding(charset);
		response.setCharacterEncoding(charset);
		response.setContentType("text/html;charset="+charset);
		
		//3.����
		chain.doFilter(request, response);
	}

}
