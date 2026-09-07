package com.yandex.mobile.ads.impl;

import android.content.Context;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public interface jr {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f9346a = a.f9347a;

    cu1 a();

    void a(cu1 cu1Var);

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ a f9347a = new a();
        private static final Object b = new Object();
        private static volatile jr c;

        @JvmStatic
        public static jr a(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            if (c == null) {
                synchronized (b) {
                    if (c == null) {
                        int i = ns0.b;
                        Intrinsics.checkNotNullParameter(context, "context");
                        c = new kr(ns0.a(context, "YadPreferenceFile"), new d60(), new u6());
                    }
                    Unit unit = Unit.INSTANCE;
                }
            }
            jr jrVar = c;
            if (jrVar != null) {
                return jrVar;
            }
            throw new IllegalArgumentException("Required value was null.".toString());
        }

        private a() {
        }
    }
}
