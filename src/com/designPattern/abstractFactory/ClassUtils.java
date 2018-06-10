package com.designPattern.abstractFactory;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

public class ClassUtils {
	public static List<Class> getAllClassByInterface(Class c) {
		List<Class> returnClassList = new ArrayList<Class>();

		if (c.isInterface()) {

			String packageName = c.getPackage().getName();
			try {
				List<Class> allClass = getClasses(packageName, c.getSimpleName());

				for(int i=0; i<allClass.size(); i++) {
					if (c.isAssignableFrom(allClass.get(i))) {
						returnClassList.add(allClass.get(i));
					}
				}
			} catch (ClassNotFoundException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			} catch (IOException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}
		}

		return returnClassList;
	}

	private static List<Class> getClasses(String packageName, String fromName) throws IOException, ClassNotFoundException {

		ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
		String path = packageName.replace('.', '/');
		Enumeration<URL> resources = classLoader.getResources(path);
		List<File> dirs = new ArrayList<File>();
		while(resources.hasMoreElements()) {
			URL resource = resources.nextElement();
			dirs.add(new File(resource.getFile()));
		}
		ArrayList<Class> classes = new ArrayList<Class>();
		for(File directory : dirs) {
			classes.addAll(findClasses(directory, packageName, fromName));
		}
		return classes;
	}

	private static List<Class> findClasses(File dircetory, String packageName, String formName) throws ClassNotFoundException {
		List<Class> classes = new ArrayList<Class>();
		if (!dircetory.exists()) {
			return classes;
		}

		File[] files = dircetory.listFiles();
		for(File file : files) {
			if (file.isDirectory()) {
				assert !file.getName().contains(".");
				classes.addAll(findClasses(file, packageName + "." + file.getName(), formName));
			} else if (file.getName().endsWith(".class")) {
				if ((formName + ".class").equals(file.getName())) {
					continue;
				}
				classes.add(Class.forName(packageName + '.' + file.getName().substring(0, file.getName().length() - 6)));
			}
		}
		return classes;
	}
}
