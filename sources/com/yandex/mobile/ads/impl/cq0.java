package com.yandex.mobile.ads.impl;

import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes11.dex */
public final class cq0 {
    @JvmStatic
    public static final String a(long j) {
        if (j < 0) {
            return "invalid";
        }
        if (j < 1000) {
            return "<1";
        }
        if (1000 <= j && j < 2001) {
            return "1-2";
        }
        if (2001 <= j && j < 3001) {
            return "2-3";
        }
        if (3001 <= j && j < 5001) {
            return "3-5";
        }
        if (5001 <= j && j < 10001) {
            return "5-10";
        }
        if (10001 <= j && j < 15001) {
            return "10-15";
        }
        if (15001 <= j && j < 20001) {
            return "15-20";
        }
        if (20001 <= j && j < 30001) {
            return "20-30";
        }
        if (30001 <= j && j < 60001) {
            return "30-60";
        }
        if (60001 <= j && j < 300001) {
            return "60-300";
        }
        if (300001 <= j && j < 1800001) {
            return "300-1800";
        }
        if (1800001 <= j && j < 7200001) {
            return "1800-7200";
        }
        return ">7200";
    }
}
