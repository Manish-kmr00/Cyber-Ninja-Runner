package com.yandex.mobile.ads.impl;

import android.content.Context;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public interface hx1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f9146a = a.f9147a;

    String a();

    void a(String str);

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ a f9147a = new a();
        private static final Object b = new Object();
        private static volatile hx1 c;

        public static hx1 a(Context context) {
            hx1 ix1Var;
            Intrinsics.checkNotNullParameter(context, "context");
            hx1 hx1Var = c;
            if (hx1Var != null) {
                return hx1Var;
            }
            synchronized (b) {
                ix1Var = c;
                if (ix1Var == null) {
                    int i = ns0.b;
                    Intrinsics.checkNotNullParameter(context, "context");
                    ix1Var = new ix1(ns0.a(context, "YadPreferenceFile"));
                    c = ix1Var;
                }
            }
            return ix1Var;
        }

        private a() {
        }
    }
}
