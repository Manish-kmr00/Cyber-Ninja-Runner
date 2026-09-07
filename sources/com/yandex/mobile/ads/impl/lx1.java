package com.yandex.mobile.ads.impl;

import android.content.Context;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public interface lx1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f9575a = a.f9576a;

    String a();

    void a(String str);

    public static final class a {
        private static volatile mx1 b;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ a f9576a = new a();
        private static final Object c = new Object();

        @JvmStatic
        public static lx1 a(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            if (b == null) {
                synchronized (c) {
                    if (b == null) {
                        int i = ns0.b;
                        Intrinsics.checkNotNullParameter(context, "context");
                        b = new mx1(ns0.a(context, "YadPreferenceFile"));
                    }
                    Unit unit = Unit.INSTANCE;
                }
            }
            mx1 mx1Var = b;
            if (mx1Var != null) {
                return mx1Var;
            }
            throw new IllegalArgumentException("Required value was null.".toString());
        }

        private a() {
        }
    }
}
