package com.yandex.mobile.ads.impl;

import android.view.MenuItem;
import android.widget.PopupMenu;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class ij1 implements PopupMenu.OnMenuItemClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final v9 f9228a;
    private final List<la0.a> b;
    private final mp1 c;
    private final l51 d;

    public ij1(v9 adTracker, List<la0.a> items, mp1 reporter, l51 nativeAdEventController) {
        Intrinsics.checkNotNullParameter(adTracker, "adTracker");
        Intrinsics.checkNotNullParameter(items, "items");
        Intrinsics.checkNotNullParameter(reporter, "reporter");
        Intrinsics.checkNotNullParameter(nativeAdEventController, "nativeAdEventController");
        this.f9228a = adTracker;
        this.b = items;
        this.c = reporter;
        this.d = nativeAdEventController;
    }

    @Override // android.widget.PopupMenu.OnMenuItemClickListener
    public final boolean onMenuItemClick(MenuItem menuItem) {
        Intrinsics.checkNotNullParameter(menuItem, "menuItem");
        int itemId = menuItem.getItemId();
        if (itemId >= this.b.size()) {
            return true;
        }
        this.f9228a.a(this.b.get(itemId).b(), s62.c);
        this.c.a(hp1.b.E);
        this.d.a();
        return true;
    }
}
