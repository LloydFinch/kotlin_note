import kotlin.collections.ArrayDeque;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/**
 * Name: Test
 * Author: lloydfinch
 * Function: Test
 * Date: 2020-05-28 11:13
 * Modify: lloydfinch 2020-05-28 11:13
 */
public class Test {

    //模版单例========================================================
    public static final Singleton<User> user = new Singleton<>() {
        @Override
        protected User create() {
            return new User();
        }
    };

    public static void main(String[] args) {
        System.out.println(user.get());
    }

    public static abstract class Singleton<T> {
        private T mInstance;

        protected abstract T create();

        public final T get() {
            synchronized (this) {
                if (mInstance == null) {
                    mInstance = create();
                }
            }
            return mInstance;
        }
    }

    public static class User {
        private User() {
        }
    }
    //模版单例========================================================


    //使用finalize观察gc==============================================
    private WeakReference<GcWatcher> gcWatcher = new WeakReference<>(new GcWatcher());
    private List<Runnable> gcWatchers = new ArrayList<>();
    private Runnable[] watchers = new Runnable[1];

    private class GcWatcher {
        @Override
        protected void finalize() throws Throwable {
            //当gcWatcher被回收会走到这里
            {
                /**
                 * 这里有个技巧，先复制再遍历，防止回调中添加
                 */
                synchronized (gcWatchers) {
                    watchers = gcWatchers.toArray(watchers);
                }
                for (int i = 0; i < watchers.length; i++) {
                    if (watchers[i] != null) {
                        watchers[i].run();
                    }
                }
            }

            //重新创建gcWatcher来观测系统gc情况
            gcWatcher = new WeakReference<>(new GcWatcher());
        }
    }


    public void addGcWatcher(Runnable watcher) {
        gcWatchers.add(watcher);
    }

    //栈帧信息抓取
    public static void getStackInfo() {

        System.out.println("========Start=================================================================================");

        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        for (StackTraceElement trace : stackTrace) {
            String loaderName = trace.getClassLoaderName();
            String className = trace.getClassName();
            String methodName = trace.getMethodName();
            String fileName = trace.getFileName();
            int lineNumber = trace.getLineNumber();
            String moduleName = trace.getModuleName();
            String moduleVersion = trace.getModuleVersion();
            boolean isNative = trace.isNativeMethod();

            System.out.println("loaderName: " + loaderName);
            System.out.println("className: " + className);
            System.out.println("methodName: " + methodName);
            System.out.println("fileName: " + fileName);
            System.out.println("lineNumber: " + lineNumber);
            System.out.println("moduleName: " + moduleName);
            System.out.println("moduleVersion: " + moduleVersion);
            System.out.println("isNative: " + isNative);
            Exception exception = new Exception();
            exception.setStackTrace(stackTrace);
            exception.printStackTrace();
            System.out.println("========End=================================================================================");
        }
    }


}
