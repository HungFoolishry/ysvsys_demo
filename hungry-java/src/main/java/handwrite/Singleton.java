package handwrite;

/**
 * description: 手写单例
 *
 * @author JunchaoYao
 * @date 2021-01-29 17:18
 **/
public class Singleton {
    // 通过静态区只初始化一次来实现sin的单例 懒汉模式
    private static Singleton sin = new Singleton();

    private Singleton() {

    }

    public static void main(String[] args) {
        System.out.println(sin);
    }

    private volatile Singleton sin2;
    private Singleton getSin() {
        if (sin2 == null) {
            synchronized (Singleton.class) {
                if (sin2 == null) {
                    sin2 = new Singleton();
                }
            }
        }
        return sin2;
    }
}
