package com.five_corp.ad.internal.ad.format_config;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes11.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f1290a;
    public final ArrayList b;
    public final String c;

    public b(int i, ArrayList arrayList, String str) {
        this.f1290a = i;
        if (arrayList != null) {
            this.b = arrayList;
        } else {
            this.b = new ArrayList();
        }
        this.c = str;
    }
}
