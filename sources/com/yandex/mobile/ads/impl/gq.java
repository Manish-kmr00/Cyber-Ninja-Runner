package com.yandex.mobile.ads.impl;

import android.content.Context;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public interface gq {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f9028a = a.f9029a;

    String a();

    String b();

    String c();

    public static final class a {
        private static volatile iq b;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ a f9029a = new a();
        private static final Object c = new Object();

        @JvmStatic
        public static gq a(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            if (b == null) {
                synchronized (c) {
                    if (b == null) {
                        b = hq.a(context);
                    }
                    Unit unit = Unit.INSTANCE;
                }
            }
            iq iqVar = b;
            if (iqVar != null) {
                return iqVar;
            }
            throw new IllegalArgumentException("Required value was null.".toString());
        }

        private a() {
        }
    }
}
