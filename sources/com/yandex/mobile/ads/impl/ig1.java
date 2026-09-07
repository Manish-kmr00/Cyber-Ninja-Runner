package com.yandex.mobile.ads.impl;

import android.os.Handler;
import android.os.Looper;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public interface ig1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f9217a = 0;

    void a(long j, kg1 kg1Var);

    void a(f52 f52Var);

    void invalidate();

    void pause();

    void resume();

    void stop();

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ a f9218a = new a();

        public static ig1 a(boolean z) {
            Handler handler = new Handler(Looper.getMainLooper());
            Intrinsics.checkNotNullParameter(handler, "handler");
            return new jg1(z, handler);
        }

        private a() {
        }
    }
}
