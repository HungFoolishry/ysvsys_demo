package JUC.BaseStruct;

/**
 * description:
 *
 * @author JunchaoYao
 * @date 2020-07-14 13:48
 **/
// AtomicReferenceTest.java的源码
import java.util.concurrent.atomic.AtomicReference;

public class AtomicReferenceTest {

    public static void main(String[] args){

        // 创建两个Person对象，它们的id分别是101和102。
        LongTestPerson p1 = new LongTestPerson(101);
        LongTestPerson p2 = new LongTestPerson(102);
        // 新建AtomicReference对象，初始化它的值为p1对象
        AtomicReference ar = new AtomicReference(p1);
        // 通过CAS设置ar。如果ar的值为p1的话，则将其设置为p2。
        ar.compareAndSet(p1, p2);

        LongTestPerson p3 = (LongTestPerson)ar.get();
        System.out.println("p3 is "+p3);
        System.out.println("p3.equals(p1)="+p3.equals(p1));
    }
}

class Person {
    volatile long id;
    public Person(long id) {
        this.id = id;
    }
    @Override
    public String toString() {
        return "id:"+id;
    }
}