package com.yandex.mobile.ads.impl;

import android.os.Handler;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class iv implements y32 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final au f9257a;
    private final t8 b;
    private final Handler c;

    public iv(au customClickHandler, t8 resultReceiver, Handler handler) {
        Intrinsics.checkNotNullParameter(customClickHandler, "customClickHandler");
        Intrinsics.checkNotNullParameter(resultReceiver, "resultReceiver");
        Intrinsics.checkNotNullParameter(handler, "handler");
        this.f9257a = customClickHandler;
        this.b = resultReceiver;
        this.c = handler;
    }

    @Override // com.yandex.mobile.ads.impl.y32
    public final void a(mp1 reporter, final String targetUrl) {
        Intrinsics.checkNotNullParameter(reporter, "reporter");
        Intrinsics.checkNotNullParameter(targetUrl, "targetUrl");
        HashMap map = new HashMap();
        map.put("click_type", "custom");
        hp1.b bVar = hp1.b.c;
        reporter.a(map);
        this.c.post(new Runnable() { // from class: com.yandex.mobile.ads.impl.iv$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                iv.a(this.f$0, targetUrl);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(iv this$0, String targetUrl) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(targetUrl, "$targetUrl");
        this$0.f9257a.a(targetUrl, this$0.new a());
    }

    private final class a implements bu {
        public a() {
        }

        @Override // com.yandex.mobile.ads.impl.bu
        public final void onLeftApplication() {
            iv.this.b.a(19, null);
        }

        @Override // com.yandex.mobile.ads.impl.bu
        public final void onReturnedToApplication() {
            iv.this.b.a(20, null);
        }
    }
}
