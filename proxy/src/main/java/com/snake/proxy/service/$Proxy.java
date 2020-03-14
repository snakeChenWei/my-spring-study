package com.snake.proxy.service;
import com.snake.proxy.util.MyInvocationHandler;
import java.lang.reflect.Method;

public class $Proxy implements SnakeService {
	private MyInvocationHandler handler;
	public $Proxy(MyInvocationHandler handler) {
		this.handler = handler;
	}
	@Override
	public void printStr() {
		try {
			Method  method = Class.forName("com.snake.proxy.service.SnakeService").getDeclaredMethod("printStr");
			handler.invoke(method);
		}catch (Exception e){
			e.printStackTrace();
		}
	}
	@Override
	public String sayName(String p0,String p1) {
		try {
			Method  method = Class.forName("com.snake.proxy.service.SnakeService").getDeclaredMethod("sayName",java.lang.String.class,java.lang.String.class);
			return (String)handler.invoke(method,p0,p1);
		}catch (Exception e){
			e.printStackTrace();
		}
		return null;
	}
}