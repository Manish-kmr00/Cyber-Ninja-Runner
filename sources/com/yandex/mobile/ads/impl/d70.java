package com.yandex.mobile.ads.impl;

/* JADX INFO: loaded from: classes13.dex */
public final class d70 extends RuntimeException {
    public d70(int i) {
        super(a(i));
    }

    private static String a(int i) {
        if (i == 1) {
            return "Player release timed out.";
        }
        if (i == 2) {
            return "Setting foreground mode timed out.";
        }
        if (i != 3) {
            return "Undefined timeout.";
        }
        return "Detaching surface timed out.";
    }
}
