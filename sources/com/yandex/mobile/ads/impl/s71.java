package com.yandex.mobile.ads.impl;

import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes8.dex */
public final class s71 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Object f10182a = new Object();
    private static volatile s71 b;
    public static final /* synthetic */ int c = 0;

    public static final class a {
        @JvmStatic
        public static s71 a() {
            s71 s71Var;
            s71 s71Var2 = s71.b;
            if (s71Var2 != null) {
                return s71Var2;
            }
            synchronized (s71.f10182a) {
                s71Var = s71.b;
                if (s71Var == null) {
                    s71Var = new s71(0);
                    s71.b = s71Var;
                }
            }
            return s71Var;
        }
    }

    public final boolean c() {
        return true;
    }

    private s71() {
    }

    public /* synthetic */ s71(int i) {
        this();
    }
}
