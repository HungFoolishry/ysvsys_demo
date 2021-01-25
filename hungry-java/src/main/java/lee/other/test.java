package lee.other;

/**
 * description:
 *
 * @author JunchaoYao
 * @date 2021-01-24 15:43
 **/



import javafx.util.Pair;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Scanner;
import java.util.List;
import java.util.Set;

public class test {

        public static void main(String[] args) {
                String m = "4,2,6,4";
                String n = "5,3,8,7";
                int k = 15;
                int ans = 0;

                String[] mStrs = m.split(",");
                if(mStrs.length ==0){
                        System.out.println(0);;
                }
                int[] mPrices = new int[mStrs.length];
                for(int i =0; i<mStrs.length;i++ ){
                        mPrices[i] = Integer.parseInt(mStrs[i]);
                }
                String[] nStrs = n.split(",");
                int[] nPrices = new int[nStrs.length];
                for(int i =0; i<nStrs.length;i++ ){
                        nPrices[i] = Integer.parseInt(nStrs[i]);
                }
                List<Pair<Integer, Integer>> profits = new ArrayList<>();
                for(int i = 0; i < mPrices.length;i++){
                        int profit = nPrices[i] - mPrices[i];
                        profits.add(new Pair<Integer,Integer>(profit, mPrices[i]));
                }
                profits.sort((o1, o2) -> o2.getKey() - o1.getKey());
                Pair<Integer,Integer> min = profits.stream().min((o1, o2) -> o1.getValue() - o2.getValue()).get();
                while (!profits.isEmpty() && k > min.getValue()) {
                        min = profits.stream().min((o1, o2) -> o1.getValue() - o2.getValue()).get();
                        for (int i = 0; i < profits.size(); i++) {
                                int profit = profits.get(i).getKey();
                                int mPrice = profits.get(i).getValue();
                                if (k >= mPrice) {
                                        int buyNum = k / mPrice;
                                        k = k + buyNum * profit;
                                        ans = ans + buyNum * profit;
                                        profits.remove(i);
                                        break;
                                }
                        }

                }

                System.out.println(ans);}

}