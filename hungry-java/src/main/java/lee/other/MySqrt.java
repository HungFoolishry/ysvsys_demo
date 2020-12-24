package lee.other;

/**
 * description:  开平方根
 *
 * @author JunchaoYao
 * @date 2020-12-23 11:02
 **/
public class MySqrt {
    class Solution {
        public int mySqrt(int x) {
            float fx = (float) x;
//            float xhalf = 0.5f * fx;
//            int i = (int) fx;
//            i = 0x5f3759df - (i>>1);
//            fx = (int) fx &  i;
//            fx = fx * (1.5f - xhalf * fx * fx);
            return (int) fx;
        }
    }

//    public static void main(String[] args) {
//        float fx = (float) 16;
//        float xhalf = 0.5f * fx;
//        int i = (int) fx;
//        i = 0x5f3759df - (i>>1);
//        fx = (float) i;
//        fx = fx * (1.5f - xhalf * fx * fx);
//        System.out.println(fx);
//    }
}
