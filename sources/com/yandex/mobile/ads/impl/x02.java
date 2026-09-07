package com.yandex.mobile.ads.impl;

import android.view.MenuItem;
import android.widget.PopupMenu;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class x02 implements PopupMenu.OnMenuItemClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final r62 f10612a;
    private final u41 b;
    private final List<s02> c;
    private final l51 d;
    private final o91 e;

    public x02(r62 trackingUrlHandler, u41 clickReporterCreator, List<s02> items, l51 nativeAdEventController, o91 nativeOpenUrlHandlerCreator) {
        Intrinsics.checkNotNullParameter(trackingUrlHandler, "trackingUrlHandler");
        Intrinsics.checkNotNullParameter(clickReporterCreator, "clickReporterCreator");
        Intrinsics.checkNotNullParameter(items, "items");
        Intrinsics.checkNotNullParameter(nativeAdEventController, "nativeAdEventController");
        Intrinsics.checkNotNullParameter(nativeOpenUrlHandlerCreator, "nativeOpenUrlHandlerCreator");
        this.f10612a = trackingUrlHandler;
        this.b = clickReporterCreator;
        this.c = items;
        this.d = nativeAdEventController;
        this.e = nativeOpenUrlHandlerCreator;
    }

    @Override // android.widget.PopupMenu.OnMenuItemClickListener
    public final boolean onMenuItemClick(MenuItem menuItem) {
        Intrinsics.checkNotNullParameter(menuItem, "menuItem");
        int itemId = menuItem.getItemId();
        if (itemId >= this.c.size()) {
            return true;
        }
        s02 s02Var = this.c.get(itemId);
        rr0 rr0VarA = s02Var.a();
        n91 n91VarA = this.e.a(this.b.a(s02Var.b(), "social_action"));
        this.d.a(rr0VarA);
        this.f10612a.a(rr0VarA.d());
        String strE = rr0VarA.e();
        if (strE == null || strE.length() == 0) {
            return true;
        }
        n91VarA.a(strE);
        return true;
    }
}
