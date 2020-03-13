package com.snake.proxy.util;

import javax.tools.JavaCompiler;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import java.io.File;
import java.io.FileWriter;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;

/**
 * @author snake
 * @date 2020/3/12 22:39
 * 第一版
 */
public class MyProxy2 {

    public static final String line = "\n";
    public static final String tab = "\t";

    /**
     * new -> 反射 -> class -> java -> io -> content -> string
     */

    public static Object newInstance(Class targetInf, MyInvocationHandler handler) {
        String infName = targetInf.getSimpleName();
        String packageContent = "package com.snake.proxy.service;" + line;

        String importContent = "import com.snake.proxy.util.MyInvocationHandler;" + line
                + "import java.lang.reflect.Method;" + line;
        String clazzFirstLineContent = "public class $Proxy implements " + infName + " {" + line;
        String filedContent = tab + "private MyInvocationHandler handler;" + line;
        String constructorContent = tab + "public $Proxy(MyInvocationHandler handler) {" + line
                + tab + tab + "this.handler = handler;" + line
                + tab + "}" + line;
        String methodContent = "";
        Method[] methods = targetInf.getDeclaredMethods();
        for (Method method : methods) {
            String returnTypeName = method.getReturnType().getSimpleName();
            String methodName = method.getName();
            Class[] args = method.getParameterTypes();
            String argsContent = ""; // 方法参数类型 和参数
            String paramsContent = ""; // 方法参数
            String argsTypeContent = "";// 参数类型
            int flag = 0;
            for (Class arg : args) {
                String temp = arg.getSimpleName();// 参数类型
                argsContent += temp + " p" + flag + ",";// String p0,String p1,
                paramsContent += "," + "p" + flag;// 传入到super.method(method,p0,p1)的参数
                argsTypeContent += "," + arg.getName() + ".class";// java.lang.String.Class,
                flag++;
            }
            if (argsContent.length() > 0) {
                argsContent = argsContent.substring(0, argsContent.lastIndexOf(","));
            }


            String returnContent = ""; // 返回类型 + 返回是否强转
            if (!returnTypeName.equals("void")) {
                returnContent += "return (" + returnTypeName + ")";
            }
            String returnNullContent = "";
            if (returnContent.length() > 0) {
                returnNullContent += tab + tab + "return null;" + line;
            }

            methodContent += tab + "public " + returnTypeName + " " + methodName + "(" + argsContent + ") {" + line
                    + tab + tab + "try {" + line
                    + tab + tab + tab + "Method  method = Class.forName(\"" + targetInf.getName() + "\").getDeclaredMethod(\"" + methodName + "\"" + argsTypeContent + ");" + line
                    + tab + tab + tab + returnContent + "handler.invoke(method" + paramsContent + ");" + line
                    + tab + tab + "}catch (Exception e){" + line
                    + tab + tab + tab + "e.printStackTrace();" + line
                    + tab + tab + "}" + line
                    + returnNullContent
                    + tab + "}" + line;
        }
        String clazzLastLine = "}";

        String content = "";
        content += packageContent + importContent + line + clazzFirstLineContent
                + filedContent + constructorContent + methodContent + clazzLastLine;

        File file = new File("proxy\\src\\main\\java\\com\\snake\\proxy\\service\\$Proxy.java"); // 1. 绝对路径 2. 项目的路径
        try {
            // 写入java文件
            FileWriter fw = new FileWriter(file);
            fw.write(content);
            fw.flush();
            fw.close();

            // 生成class文件
            JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();

            StandardJavaFileManager fileMgr = compiler.getStandardFileManager(null, null, null);
            Iterable units = fileMgr.getJavaFileObjects(file);

            JavaCompiler.CompilationTask t = compiler.getTask(null, fileMgr, null, null, null, units);
            t.call();
            fileMgr.close();

            // 将class文件加载到内存 todo URLClassLoader用法  只能用 loadClass()  不能用Class.forName()
            URL[] urls = new URL[]{new URL("file:proxy\\src\\main\\java\\")}; // 包引用路径之前的  1. 绝对路径 或者 2. 项目的路径
            URLClassLoader urlClassLoader = new URLClassLoader(urls);
            Class clazz = urlClassLoader.loadClass("com.snake.proxy.service.$Proxy");// 包引用路径

            // new class()
            Constructor constructor = clazz.getConstructor(MyInvocationHandler.class);

            return constructor.newInstance(handler);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
