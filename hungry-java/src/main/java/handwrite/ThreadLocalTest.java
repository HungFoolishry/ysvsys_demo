package handwrite;

/**
 * description: Threadlocal 内存泄露
 *
 * @author JunchaoYao
 * @date 2021-02-16 00:50
 **/

import java.lang.reflect.Field;

/**
 * 测试ThreadLocal 在gc后引发的threadLocalMap的key为null,但value不为null的情况
 * @Author thewindkee
 * @Date 2019/12/27 9:28
 */
public class ThreadLocalTest {

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException, InterruptedException {
        Thread t = new Thread(()->test("abc",false));
        t.start();
        t.join();
        System.out.println("--gc后--");
        Thread t2 = new Thread(() -> test("def", true));
        t2.start();
        t2.join();
    }

    private static void test(String s,boolean isGC)  {
        try {
            ThreadLocal<Object> threadLocal = new ThreadLocal<>();
            threadLocal.set(s);
            threadLocal = null;//失去对threadLocal的强引用 ,help gc
            if (isGC) {
                System.gc();
            }
            Thread t = Thread.currentThread();
            Class<? extends Thread> clz = t.getClass();
            Field field = clz.getDeclaredField("threadLocals");
            field.setAccessible(true);
            Object threadLocalMap = field.get(t);
            Class<?> tlmClass = threadLocalMap.getClass();
            Field tableField = tlmClass.getDeclaredField("table");
            tableField.setAccessible(true);
            Object[] arr = (Object[]) tableField.get(threadLocalMap);
            for (Object o : arr) {
                if (o != null) {
                    Class<?> entryClass = o.getClass();
                    Field valueField = entryClass.getDeclaredField("value");
                    Field referenceField = entryClass.getSuperclass().getSuperclass().getDeclaredField("referent");
                    valueField.setAccessible(true);
                    referenceField.setAccessible(true);
                    System.out.printf("当前线程：%s 弱引用key:%s,值:%s%n",t.getName(), referenceField.get(o), valueField.get(o));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
