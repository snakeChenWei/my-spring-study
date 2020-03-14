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
 * @date   2020/3/12 22:39
 */
public class MyProxy {

    public static final String line = "\n";
    public static final String tab = "\t";

    /**
     * new -> 反射 -> class -> java -> io -> content -> string
     */

    public static Object newInstance(Object target) {
        Object proxy = null;
        Class targetInf = target.getClass().getInterfaces()[0];
        String infName = targetInf.getSimpleName();
        String packageContent = "package com.snake.proxy.service;" + line;
        String importContent = "import " + targetInf.getName() + ";" + line;
        String clazzFirstLineContent = "public class $Proxy implements " + infName + " {" + line;
        String filedContent = tab + "private " + infName + " target;" + line;
        String constructorContent = tab + "public $Proxy(" + infName + " target) {" + line
                + tab + tab + "this.target = target;" + line
                + tab + "}" + line;
        String methodContent = "";
        Method[] methods = targetInf.getDeclaredMethods();
        for (Method method : methods) {
            String returnTypeName = method.getReturnType().getSimpleName();
            String methodName = method.getName();
            Class[] args = method.getParameterTypes();
            String argsContent = "";
            String paramsContent = "";
            int flag = 0;
            for (Class arg : args) {
                String temp = arg.getSimpleName();// 参数类型
                argsContent += temp + " p" + flag + ",";// String p0,String p1,
                paramsContent += "p" + flag + ",";// 传入到super.method()的参数
                flag++;
            }
            if (argsContent.length() > 0) {
                argsContent = argsContent.substring(0, argsContent.lastIndexOf(","));
                paramsContent = paramsContent.substring(0, paramsContent.lastIndexOf(","));
            }

            String returnContent = "";
            if (!returnTypeName.equals("void")) {
                returnContent += "return ";
            }

            methodContent += tab + "public " + returnTypeName + " " + methodName + "(" + argsContent + ") {" + line
                    + tab + tab + "System.out.println(\"======我是proxy=======\");" + line
                    + tab + tab + returnContent + " target." + methodName + "(" + paramsContent + ");" + line
                    + tab + "}" + line;
        }
        String clazzLastLine = "}";

        String content = "";
        content += packageContent + importContent + clazzFirstLineContent
                + filedContent + constructorContent + methodContent + clazzLastLine;

        File file = new File("proxy/src/main/java/com/snake/proxy/service/$Proxy.java"); // 1. 绝对路径 2. 项目的路径
        try {
            // 写入java文件
            System.out.println();
            System.out.println(file.getAbsolutePath());
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

            // 将class文件加载到内存 todo URLClassLoader用法
            URL[] urls = new URL[]{new URL("file:proxy/src/main/java/")}; // 包引用路径之前的  1. 绝对路径 或者 2. 项目的路径
            URLClassLoader urlClassLoader = new URLClassLoader(urls);
            Class clazz = urlClassLoader.loadClass("com.snake.proxy.service.$Proxy");// 包引用路径

            // new class()
//            Constructor constructor = clazz.getConstructor(targetInf);
//            proxy = constructor.newInstance(target);

            Constructor constructor = clazz.getConstructor(targetInf);

            proxy = constructor.newInstance(target);
        } catch (Exception e) {
            e.printStackTrace();
        }


        return proxy;
    }
}
