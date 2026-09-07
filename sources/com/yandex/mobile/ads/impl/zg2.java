package com.yandex.mobile.ads.impl;

import android.view.View;
import com.yandex.mobile.ads.R;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class zg2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Function1<zx, Unit> f10816a;
    private final ix b;

    /* JADX WARN: Multi-variable type inference failed */
    public zg2(Function1<? super zx, Unit> onAction, ix imageLoader) {
        Intrinsics.checkNotNullParameter(onAction, "onAction");
        Intrinsics.checkNotNullParameter(imageLoader, "imageLoader");
        this.f10816a = onAction;
        this.b = imageLoader;
    }

    public final hy a(View itemView, int i) {
        Intrinsics.checkNotNullParameter(itemView, "itemView");
        if (i == R.layout.debug_panel_item_action_button) {
            return new y(tg2.b, itemView);
        }
        if (i == R.layout.debug_panel_item_switch) {
            return new p32(itemView, new ug2(this));
        }
        if (i == R.layout.deubg_panel_item_header) {
            return new mf0(itemView);
        }
        if (i == R.layout.deubg_panel_item_key_value) {
            return new uq0(itemView);
        }
        if (i == R.layout.debug_panel_item_mediation_adapter) {
            return new uz0(itemView, this.b, new vg2(this), new wg2(this));
        }
        if (i == R.layout.debug_panel_item_ad_units) {
            return new ma(itemView, new xg2(this));
        }
        return i == R.layout.debug_panel_item_ad_unit ? new ka(new yg2(this), itemView) : new l30(itemView);
    }
}
