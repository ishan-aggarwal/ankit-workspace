package kwic2;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class ClassLoaderUtil {

    public Object getInstance(String className) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        ClassLoader loader = this.getClass().getClassLoader();
        Class<?> loadedClass = loader.loadClass(className.trim());
        Constructor<?> constructor = loadedClass.getConstructor();
        return constructor.newInstance();
    }

}
