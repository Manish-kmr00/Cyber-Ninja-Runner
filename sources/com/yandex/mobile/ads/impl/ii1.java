package com.yandex.mobile.ads.impl;

import android.media.metrics.LogSessionId;

/* JADX INFO: loaded from: classes9.dex */
public final class ii1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final a f9224a;

    static {
        if (x82.f10629a < 31) {
            new ii1();
        } else {
            int i = a.b;
        }
    }

    public ii1() {
        this((a) null);
        hg.b(x82.f10629a < 31);
    }

    public final LogSessionId a() {
        a aVar = this.f9224a;
        aVar.getClass();
        return aVar.f9225a;
    }

    private static final class a {
        public static final /* synthetic */ int b = 0;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final LogSessionId f9225a;

        static {
            LogSessionId logSessionId = LogSessionId.LOG_SESSION_ID_NONE;
        }

        public a(LogSessionId logSessionId) {
            this.f9225a = logSessionId;
        }
    }

    public ii1(LogSessionId logSessionId) {
        this(new a(logSessionId));
    }

    private ii1(a aVar) {
        this.f9224a = aVar;
    }
}
