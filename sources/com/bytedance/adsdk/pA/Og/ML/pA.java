package com.bytedance.adsdk.pA.Og.ML;

/* JADX INFO: loaded from: classes8.dex */
public class pA {
    public static boolean KZx(char c) {
        return c >= '0' && c <= '9';
    }

    public static boolean Og(char c) {
        if (c < 'A' || c > 'Z') {
            return c >= 'a' && c <= 'z';
        }
        return true;
    }

    public static boolean ZZv(char c) {
        return '+' == c || '-' == c || '*' == c || '/' == c || '%' == c || '=' == c || '>' == c || '<' == c || '!' == c || '&' == c || '|' == c || '?' == c || ':' == c;
    }

    public static boolean pA(char c) {
        return c == ' ';
    }
}
