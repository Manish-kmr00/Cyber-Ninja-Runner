package com.yandex.mobile.ads.impl;

import java.util.ArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class is0 {
    private static final Object d = new Object();
    private static volatile is0 e;
    public static final /* synthetic */ int f = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final b41 f9255a;
    private final ArrayList b;
    private int c;

    public static final class a {
        @JvmStatic
        public static is0 a() {
            is0 is0Var;
            is0 is0Var2 = is0.e;
            if (is0Var2 != null) {
                return is0Var2;
            }
            synchronized (is0.d) {
                is0Var = is0.e;
                if (is0Var == null) {
                    is0Var = new is0();
                    is0.e = is0Var;
                }
            }
            return is0Var;
        }
    }

    /* synthetic */ is0() {
        this(new b41(b41.c));
    }

    private is0(b41 b41Var) {
        this.f9255a = b41Var;
        this.b = new ArrayList();
    }

    public final Executor c() {
        Executor executorNewSingleThreadExecutor;
        synchronized (d) {
            if (this.b.size() < 4) {
                executorNewSingleThreadExecutor = Executors.newSingleThreadExecutor(this.f9255a);
                Intrinsics.checkNotNullExpressionValue(executorNewSingleThreadExecutor, "newSingleThreadExecutor(...)");
                this.b.add(executorNewSingleThreadExecutor);
            } else {
                ArrayList arrayList = this.b;
                int i = this.c;
                this.c = i + 1;
                executorNewSingleThreadExecutor = (Executor) arrayList.get(i);
                if (this.c == 4) {
                    this.c = 0;
                }
            }
        }
        return executorNewSingleThreadExecutor;
    }
}
