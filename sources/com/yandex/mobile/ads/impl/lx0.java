package com.yandex.mobile.ads.impl;

import android.content.Context;
import com.monetization.ads.nativeads.CustomizableMediaView;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;

/* JADX INFO: loaded from: classes12.dex */
public final class lx0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final o3 f9574a;
    private final ih2 b;
    private final hh2 c;
    private final Executor d;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public lx0(Context context, o3 adConfiguration) {
        this(adConfiguration, new ih2(context), new hh2(context, adConfiguration));
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(adConfiguration, "adConfiguration");
    }

    public final void a(CustomizableMediaView view, String mediaType) {
        Intrinsics.checkNotNullParameter(view, "mediaView");
        Intrinsics.checkNotNullParameter(mediaType, "mediaType");
        String strC = this.f9574a.c();
        if (strC != null) {
            int iO = this.f9574a.o();
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(mediaType, "mediaType");
            final fh2 fh2VarA = jh2.a(view, mediaType);
            final kh2 kh2Var = new kh2(iO, strC);
            this.d.execute(new Runnable() { // from class: com.yandex.mobile.ads.impl.lx0$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() throws JSONException {
                    lx0.a(this.f$0, kh2Var, fh2VarA);
                }
            });
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ lx0(o3 o3Var, ih2 ih2Var, hh2 hh2Var) {
        ExecutorService executorServiceNewSingleThreadExecutor = Executors.newSingleThreadExecutor();
        Intrinsics.checkNotNullExpressionValue(executorServiceNewSingleThreadExecutor, "newSingleThreadExecutor(...)");
        this(o3Var, ih2Var, hh2Var, executorServiceNewSingleThreadExecutor);
    }

    public lx0(o3 adConfiguration, ih2 viewSizeInfoStorage, hh2 viewSizeInfoReporter, Executor executor) {
        Intrinsics.checkNotNullParameter(adConfiguration, "adConfiguration");
        Intrinsics.checkNotNullParameter(viewSizeInfoStorage, "viewSizeInfoStorage");
        Intrinsics.checkNotNullParameter(viewSizeInfoReporter, "viewSizeInfoReporter");
        Intrinsics.checkNotNullParameter(executor, "executor");
        this.f9574a = adConfiguration;
        this.b = viewSizeInfoStorage;
        this.c = viewSizeInfoReporter;
        this.d = executor;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(lx0 this$0, kh2 viewSizeKey, fh2 viewSizeInfo) throws JSONException {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(viewSizeKey, "$viewSizeKey");
        Intrinsics.checkNotNullParameter(viewSizeInfo, "$viewSizeInfo");
        this$0.b.a(viewSizeKey, viewSizeInfo);
        this$0.c.a(viewSizeInfo, this$0.f9574a);
    }
}
