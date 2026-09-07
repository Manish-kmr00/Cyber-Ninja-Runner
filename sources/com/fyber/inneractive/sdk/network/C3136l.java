package com.fyber.inneractive.sdk.network;

import java.io.FilterInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Map;

/* JADX INFO: renamed from: com.fyber.inneractive.sdk.network.l, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes6.dex */
public class C3136l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f1924a;
    public final String b;
    public InputStream c;
    public Map d;
    public String e;
    public final ArrayList f = new ArrayList();

    public C3136l() {
    }

    public void a() {
        InputStream inputStream = this.c;
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (Throwable unused) {
            }
        }
    }

    public C3136l(FilterInputStream filterInputStream, int i, String str, Map map, String str2) {
        this.c = filterInputStream;
        this.f1924a = i;
        this.b = str;
        this.d = map;
        this.e = str2;
    }
}
