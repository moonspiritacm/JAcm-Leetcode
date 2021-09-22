package com.moonspirit.acm.leetcode.p0068;

import java.util.ArrayList;
import java.util.List;

/**
 * 其余情况（分散对齐）：如果当前行字符长度l，空格长度n，空格数量k，那么最小分配长度s=n/k，前n%k空格长度s+1，其余空格长度s。
 */
class Solution {
    /**
     * @param words 单词表
     * @param i     起始索引
     * @param j     终止索引
     * @param l     字符长度
     * @param n     空格长度
     * @return 字符串
     */
    private String common(String[] words, int i, int j, int l, int n) {
        int k = j - i;           // 空格数量
        int s = n / k;           // 最小分配长度
        int m = i + n % k;       // 前半段长度
        StringBuilder sb = new StringBuilder();
        while (i < j) {
            sb.append(words[i]);
            int cnt = i < m ? -1 : 0;
            while (cnt++ < s) {
                sb.append(" ");
            }
            i++;
        }
        sb.append(words[j]);
        return sb.toString();
    }

    private String left(String[] words, int i, int j, int n) {
        System.out.printf("%d %d %d\n", i, j, n);
        n -= j - i;
        StringBuilder sb = new StringBuilder();
        while (i < j) {
            sb.append(words[i++]);
            sb.append(" ");
        }
        sb.append(words[j]);
        System.out.println(sb + "a");

        while (n-- > 0) {
            sb.append(" ");
        }
        return sb.toString();
    }

    public List<String> fullJustify(String[] words, int maxWidth) {
        if (words == null || words.length == 0 || maxWidth <= 0) {
            return new ArrayList<>();
        }

        List<String> res = new ArrayList<>();
        int i = 0;
        int j = 0;
        int l = 0;
        while (j < words.length) {
            int len = words[j].length();
            if (l + len + j - i <= maxWidth) {
                l += len;
                j++;
            } else {
                if (j - i == 1) {
                    res.add(left(words, i, j - 1, maxWidth - l));
                } else {
                    res.add(common(words, i, j - 1, l, maxWidth - l));
                }
                l = 0;
                i = j;
            }
        }
        res.add(left(words, i, j - 1, maxWidth - l));
        return res;
    }
}
