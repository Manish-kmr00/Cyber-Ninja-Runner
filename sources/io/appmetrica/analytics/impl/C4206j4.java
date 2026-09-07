package io.appmetrica.analytics.impl;

import android.os.Handler;
import io.appmetrica.analytics.coreapi.internal.executors.ICommonExecutor;
import io.appmetrica.analytics.coreapi.internal.executors.IHandlerExecutor;

/* JADX INFO: renamed from: io.appmetrica.analytics.impl.j4, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes9.dex */
public final class C4206j4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C4182i4 f11611a;
    public volatile G9 b;
    public volatile G9 c;

    public C4206j4() {
        this(new C4182i4());
    }

    public final IHandlerExecutor a() {
        if (this.b == null) {
            synchronized (this) {
                if (this.b == null) {
                    this.f11611a.getClass();
                    HandlerThreadC4189ib handlerThreadC4189ibA = G9.a("IAA-CDE");
                    this.b = new G9(handlerThreadC4189ibA, handlerThreadC4189ibA.getLooper(), new Handler(handlerThreadC4189ibA.getLooper()));
                }
            }
        }
        return this.b;
    }

    public final ICommonExecutor b() {
        if (this.c == null) {
            synchronized (this) {
                if (this.c == null) {
                    this.f11611a.getClass();
                    HandlerThreadC4189ib handlerThreadC4189ibA = G9.a("IAA-CRS");
                    this.c = new G9(handlerThreadC4189ibA, handlerThreadC4189ibA.getLooper(), new Handler(handlerThreadC4189ibA.getLooper()));
                }
            }
        }
        return this.c;
    }

    public C4206j4(C4182i4 c4182i4) {
        this.f11611a = c4182i4;
    }
}
