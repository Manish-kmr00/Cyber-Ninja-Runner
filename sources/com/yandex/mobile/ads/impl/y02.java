package com.yandex.mobile.ads.impl;

import android.content.Context;
import android.view.View;
import android.widget.PopupMenu;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
public final class y02 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final o3 f10692a;
    private final u41 b;
    private final l51 c;
    private final o91 d;
    private final d12 e;

    public y02(Context context, o3 adConfiguration, o8<?> adResponse, u41 clickReporterCreator, l51 nativeAdEventController, c71 nativeAdViewAdapter, o91 nativeOpenUrlHandlerCreator, d12 socialMenuCreator) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(adConfiguration, "adConfiguration");
        Intrinsics.checkNotNullParameter(adResponse, "adResponse");
        Intrinsics.checkNotNullParameter(clickReporterCreator, "clickReporterCreator");
        Intrinsics.checkNotNullParameter(nativeAdEventController, "nativeAdEventController");
        Intrinsics.checkNotNullParameter(nativeAdViewAdapter, "nativeAdViewAdapter");
        Intrinsics.checkNotNullParameter(nativeOpenUrlHandlerCreator, "nativeOpenUrlHandlerCreator");
        Intrinsics.checkNotNullParameter(socialMenuCreator, "socialMenuCreator");
        this.f10692a = adConfiguration;
        this.b = clickReporterCreator;
        this.c = nativeAdEventController;
        this.d = nativeOpenUrlHandlerCreator;
        this.e = socialMenuCreator;
    }

    public final void a(View view, p02 action) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(action, "action");
        List<s02> listC = action.c();
        if (listC.isEmpty()) {
            return;
        }
        PopupMenu popupMenuA = this.e.a(view, listC);
        Context context = view.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        popupMenuA.setOnMenuItemClickListener(new x02(new r62(new v9(context, this.f10692a)), this.b, listC, this.c, this.d));
        popupMenuA.show();
    }
}
