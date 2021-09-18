package com.moonspirit.acm.leetcode.p0017;

import java.util.ArrayList;
import java.util.List;

class SolutionA {
    private List<String> res;
    private List<char[]> dict;

    private void backtrace(char[] chs, int idx, StringBuilder sb) {
        if (idx == chs.length) {
            res.add(sb.toString());
            return;
        }

        int k = chs[idx] - '2';
        for (char ch : dict[k].toCharArray()) {
            sb.append(ch);
            backtrace(chs, idx + 1, sb, res);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) {
            return new ArrayList<>();
        }

        res = new ArrayList<>();
        dict.add(new char[]{'a', 'b', 'c'});
        dict.add(new char[]{'d', 'e', 'f'});
        dict.add(new char[]{'g', 'h', 'i'});
        dict.add(new char[]{'j', 'k', 'l'});
        dict.add(new char[]{'a', 'b', 'c'});
        dict.add(new char[]{'a', 'b', 'c'});

        backtrace(digits.toCharArray(), 0, new StringBuilder());
        return res;
    }
}
