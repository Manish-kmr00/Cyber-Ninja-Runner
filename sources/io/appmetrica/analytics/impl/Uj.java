package io.appmetrica.analytics.impl;

import android.os.Handler;
import android.os.Looper;
import io.appmetrica.analytics.coreapi.internal.executors.IHandlerExecutor;
import java.util.HashMap;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes3.dex */
public final class Uj {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Tj f11380a;
    public volatile G9 b;
    public volatile G9 c;
    public volatile G9 d;
    public volatile G9 e;
    public volatile G9 f;
    public volatile G9 g;
    public volatile Sj h;

    public Uj() {
        this(new Tj());
    }

    public final IHandlerExecutor a() {
        if (this.g == null) {
            synchronized (this) {
                if (this.g == null) {
                    this.f11380a.getClass();
                    HandlerThreadC4189ib handlerThreadC4189ibA = G9.a("IAA-SDE");
                    this.g = new G9(handlerThreadC4189ibA, handlerThreadC4189ibA.getLooper(), new Handler(handlerThreadC4189ibA.getLooper()));
                }
            }
        }
        return this.g;
    }

    public final IHandlerExecutor b() {
        if (this.b == null) {
            synchronized (this) {
                if (this.b == null) {
                    this.f11380a.getClass();
                    HandlerThreadC4189ib handlerThreadC4189ibA = G9.a("IAA-SC");
                    this.b = new G9(handlerThreadC4189ibA, handlerThreadC4189ibA.getLooper(), new Handler(handlerThreadC4189ibA.getLooper()));
                }
            }
        }
        return this.b;
    }

    public final IHandlerExecutor c() {
        if (this.d == null) {
            synchronized (this) {
                if (this.d == null) {
                    this.f11380a.getClass();
                    HandlerThreadC4189ib handlerThreadC4189ibA = G9.a("IAA-SMH-1");
                    this.d = new G9(handlerThreadC4189ibA, handlerThreadC4189ibA.getLooper(), new Handler(handlerThreadC4189ibA.getLooper()));
                }
            }
        }
        return this.d;
    }

    public final IHandlerExecutor d() {
        if (this.e == null) {
            synchronized (this) {
                if (this.e == null) {
                    this.f11380a.getClass();
                    HandlerThreadC4189ib handlerThreadC4189ibA = G9.a("IAA-SNTPE");
                    this.e = new G9(handlerThreadC4189ibA, handlerThreadC4189ibA.getLooper(), new Handler(handlerThreadC4189ibA.getLooper()));
                }
            }
        }
        return this.e;
    }

    public final IHandlerExecutor e() {
        if (this.c == null) {
            synchronized (this) {
                if (this.c == null) {
                    this.f11380a.getClass();
                    HandlerThreadC4189ib handlerThreadC4189ibA = G9.a("IAA-STE");
                    this.c = new G9(handlerThreadC4189ibA, handlerThreadC4189ibA.getLooper(), new Handler(handlerThreadC4189ibA.getLooper()));
                }
            }
        }
        return this.c;
    }

    public final Executor f() {
        if (this.h == null) {
            synchronized (this) {
                if (this.h == null) {
                    this.f11380a.getClass();
                    this.h = new Sj(new Handler(Looper.getMainLooper()));
                }
            }
        }
        return this.h;
    }

    public Uj(Tj tj) {
        new HashMap();
        this.f11380a = tj;
    }
}
