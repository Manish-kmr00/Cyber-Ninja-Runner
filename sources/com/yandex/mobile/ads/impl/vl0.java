package com.yandex.mobile.ads.impl;

import android.content.Context;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class vl0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final sl0 f10490a;

    public interface a {
        void a(ArrayList arrayList);
    }

    public vl0(uu1 sdkEnvironmentModule, xb2 videoAdLoader) {
        Intrinsics.checkNotNullParameter(sdkEnvironmentModule, "sdkEnvironmentModule");
        Intrinsics.checkNotNullParameter(videoAdLoader, "videoAdLoader");
        this.f10490a = new sl0(sdkEnvironmentModule, videoAdLoader);
    }

    public final void a(Context context, ArrayList adBreaks, a instreamAdBreaksLoadListener) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(adBreaks, "adBreaks");
        Intrinsics.checkNotNullParameter(instreamAdBreaksLoadListener, "instreamAdBreaksLoadListener");
        b bVar = new b(instreamAdBreaksLoadListener, new AtomicInteger(adBreaks.size()));
        Iterator it = adBreaks.iterator();
        while (it.hasNext()) {
            this.f10490a.a(context, (p2) it.next(), bVar);
        }
    }

    private static final class b implements wp1<dt> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final a f10491a;
        private final AtomicInteger b;
        private final ArrayList c;

        public b(a instreamAdBreaksLoadListener, AtomicInteger instreamAdCounter) {
            Intrinsics.checkNotNullParameter(instreamAdBreaksLoadListener, "instreamAdBreaksLoadListener");
            Intrinsics.checkNotNullParameter(instreamAdCounter, "instreamAdCounter");
            this.f10491a = instreamAdBreaksLoadListener;
            this.b = instreamAdCounter;
            this.c = new ArrayList();
        }

        @Override // com.yandex.mobile.ads.impl.wp1
        public final void a(kb2 error) {
            Intrinsics.checkNotNullParameter(error, "error");
            if (this.b.decrementAndGet() == 0) {
                this.f10491a.a(this.c);
            }
        }

        @Override // com.yandex.mobile.ads.impl.wp1
        public final void a(dt dtVar) {
            dt coreInstreamAdBreak = dtVar;
            Intrinsics.checkNotNullParameter(coreInstreamAdBreak, "coreInstreamAdBreak");
            this.c.add(coreInstreamAdBreak);
            if (this.b.decrementAndGet() == 0) {
                this.f10491a.a(this.c);
            }
        }
    }
}
