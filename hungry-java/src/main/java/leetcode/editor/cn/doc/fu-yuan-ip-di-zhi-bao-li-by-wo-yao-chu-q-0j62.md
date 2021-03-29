翻了很多题解，只能看懂这种解法，够直观够暴力。
```
class Solution {
public:
    vector<string> restoreIpAddresses(string s) {
        vector<string> res;

        for (int a = 1; a < 4; a ++ )
            for (int b = 1; b < 4; b ++ )
                for (int c = 1; c < 4; c ++ )
                    for (int d = 1; d < 4; d ++ )           //abcd分别表示四段ip地址长度
                    {
                        if (a + b + c + d == s.size())      //四段长度刚好
                        {
                            string s1 = s.substr(0, a);     //分别截取四段ip地址
                            string s2 = s.substr(a, b);
                            string s3 = s.substr(a + b, c);
                            string s4 = s.substr(a + b + c);

                            if (check(s1) && check(s2) && check(s3) && check(s4))
                            {
                                string ip = s1 + '.' + s2 + '.' + s3 + '.' + s4;
                                res.push_back(ip);
                            }
                        }
                    }

        return res;
    }

    bool check(string s)        //判断ip地址每段的第一位不为0，或只有一位且该位为0
    {
        if (stoi(s) <= 255)
            if (s[0] != '0' || (s[0] == '0' && s.size() == 1)) return true;
        
        return false;
    }
};
```