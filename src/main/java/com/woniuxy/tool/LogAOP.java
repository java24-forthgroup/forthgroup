package com.woniuxy.tool;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;
import com.woniuxy.dao.AccessLogMapper;
import com.woniuxy.pojo.AccessLog;
import com.woniuxy.pojo.User;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

//定义一个切面类
@Aspect
@Component
public class LogAOP {
	@Autowired(required = false)
	private AccessLogMapper accessLogMapper;
	//定义切点Pointcut
	@Pointcut("execution(* com.woniuxy.service.impl.*.*(..))")
	public void Pointcut(){
		
	}
	//环绕通知
	@Around("Pointcut()")
	public Object arround(ProceedingJoinPoint pj ) throws Throwable {
		System.out.println("====================================");
		RequestAttributes ra  = RequestContextHolder.getRequestAttributes();
		ServletRequestAttributes sra  =(ServletRequestAttributes) ra;
		HttpServletRequest request  = sra.getRequest();
		//获得当前访问的接口地址
		String url  = request.getRequestURL().toString();
        //获得当前登录用户的ip地址
		String ip  = IpUtil.getIpAddr(request);

		//从切面织入点处通过反射机制获得织入点处的方法
		MethodSignature signature = (MethodSignature)pj.getSignature();
		//获取切入点所在方法
		Method method = signature.getMethod();
		//获取请求的类名
		String className = pj.getTarget().getClass().getName();
		//获取请求的方法名
		String methodName = method.getName();


		//这块可加注解，提取注解上的信息，获得访问的接口名称
		/*RequestMapping requestAnnotation = method.getAnnotation(RequestMapping.class);
        //接口名称
		String methodName = "";
		if(requestAnnotation !=null){
			methodName = requestAnnotation.name();
		}*/
		//从session中获取登录的用户信息
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("loginUser");
		Object obj = (Object) pj.proceed();
		if(user !=null) {
			String userName = user.getUname();
			AccessLog accessLog  = new AccessLog();
			accessLog.setMethod(className + "." + methodName);
			accessLog.setUrl(url);
			accessLog.setIp(ip);
			accessLog.setUserName(userName);
			accessLog.setAddDate(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
			accessLog.setStatus("成功");
			//调用dao层进行数据库操作
			accessLogMapper.save(accessLog);
		}

		return obj;

	}
}
