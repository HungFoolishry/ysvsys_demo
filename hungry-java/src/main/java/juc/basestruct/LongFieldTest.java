package juc.basestruct;

/**
 * description: AtomicLongFieldUpdater可以对指定"类的 'volatile long'类型的成员"进行原子更新。它是基于反射原理实现的。
 *
 * @author JunchaoYao
 * @date 2020-07-14 13:58
 **/
// LongTest.java的源码
import java.util.concurrent.atomic.AtomicLongFieldUpdater;

public class LongFieldTest {

    public static void main(String[] args) {

        // 获取Person的class对象
        Class cls = LongTestPerson.class;
        // 新建AtomicLongFieldUpdater对象，传递参数是“class对象”和“long类型在类中对应的名称”
        AtomicLongFieldUpdater mAtoLong = AtomicLongFieldUpdater.newUpdater(cls, "id");
        LongTestPerson longTestPerson = new LongTestPerson(12345678L);

        // 比较person的"id"属性，如果id的值为12345678L，则设置为1000。
        mAtoLong.compareAndSet(longTestPerson, 12345678L, 1000);
        System.out.println("id="+ longTestPerson.getId());
    }
}

class LongTestPerson {
    volatile long id;
    public LongTestPerson(long id) {
        this.id = id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public long getId() {
        return id;
    }
}
