package com.json;

import java.util.Date;

/* JADX INFO: loaded from: classes10.dex */
public class ib {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f3777a = new Date().getTime();

    public static long a(ib ibVar) {
        if (ibVar == null) {
            return 0L;
        }
        return new Date().getTime() - ibVar.f3777a;
    }
}
