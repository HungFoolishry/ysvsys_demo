主要是记录自己的思考过程。


![879aa52f0790db5c05c602e19e6fc5fdd9cf6cd823f10cae8fee2d8d06b40945-截屏2020-05-09 上午11.47.44.png](https://pic.leetcode-cn.com/9c7103ec5d2ffc01db37ee4448c58fb1150c628ba89121fa682343ff4c3a99c4-879aa52f0790db5c05c602e19e6fc5fdd9cf6cd823f10cae8fee2d8d06b40945-%E6%88%AA%E5%B1%8F2020-05-09%20%E4%B8%8A%E5%8D%8811.47.44.png)



![7773b28bb0be7757a7302034599c046fb16e700c7040cda114ab9df658b43c9f-截屏2020-05-09 上午11.48.01.png](https://pic.leetcode-cn.com/7bfc43ef83a955cd3c2b3df86621a5cb4c34b1bf923a00f16846184e35af44cd-7773b28bb0be7757a7302034599c046fb16e700c7040cda114ab9df658b43c9f-%E6%88%AA%E5%B1%8F2020-05-09%20%E4%B8%8A%E5%8D%8811.48.01.png)



![bad2ce390cb0c417bd81e1f2b17e0e7eadba1159bc13c43cf7bf72bd55ddb69b-截屏2020-05-09 上午11.48.14.png](https://pic.leetcode-cn.com/a087ef3df33a26210275027ca6cafb03168cf0865fadc611c8ca7af41ab8b226-bad2ce390cb0c417bd81e1f2b17e0e7eadba1159bc13c43cf7bf72bd55ddb69b-%E6%88%AA%E5%B1%8F2020-05-09%20%E4%B8%8A%E5%8D%8811.48.14.png)



![截屏2020-05-09 上午11.48.24.png](https://pic.leetcode-cn.com/e629f75af562f93ab02e853c59ad8bbccd3d080252a0e01b2aa226ce6eb7fcae-%E6%88%AA%E5%B1%8F2020-05-09%20%E4%B8%8A%E5%8D%8811.48.24.png)

```java
class Solution {
    public int findKthNumber(int n, int k) {
        int cur = 1;
        k = k - 1;//扣除掉第一个0节点
        while(k>0){
            int num = getNode(n,cur,cur+1);
            if(num<=k){//第k个数不在以cur为根节点的树上
                cur+=1;//cur在字典序数组中从左往右移动
                k-=num;
            }else{//在子树中
                cur*=10;//cur在字典序数组中从上往下移动
                k-=1;//刨除根节点
            }
        }
        return cur;
    }
    public int getNode(int n, long first, long last){
        int num = 0;
        while(first <= n){
            num += Math.min(n+1,last) - first;//比如n是195的情况195到100有96个数
            first *= 10;
            last *= 10;
        }
        return num;
    }
}
```

