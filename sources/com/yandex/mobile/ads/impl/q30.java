package com.yandex.mobile.ads.impl;

/* JADX INFO: loaded from: classes13.dex */
public final class q30 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f9977a;

    private q30(String str) {
        this.f9977a = str;
    }

    public static q30 a(wf1 wf1Var) {
        String str;
        wf1Var.f(2);
        int iT = wf1Var.t();
        int i = iT >> 1;
        int iT2 = ((wf1Var.t() >> 3) & 31) | ((iT & 1) << 5);
        if (i == 4 || i == 5 || i == 7) {
            str = "dvhe";
        } else if (i == 8) {
            str = "hev1";
        } else {
            if (i != 9) {
                return null;
            }
            str = "avc3";
        }
        return new q30(str + ".0" + i + (iT2 >= 10 ? "." : ".0") + iT2);
    }
}
