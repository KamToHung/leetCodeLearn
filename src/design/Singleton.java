package design;

public class Singleton {

    private static volatile Singleton singleton;

    public static Singleton getSingleton() {
        if (singleton == null) {
            // TODO 处理
            synchronized (Singleton.class) {
                if (singleton == null) {
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }


}
