package com.fyber.inneractive.sdk.player.ui;

import android.view.ViewGroup;
import com.fyber.inneractive.sdk.config.enums.UnitDisplayType;
import com.fyber.inneractive.sdk.util.AbstractC3251o;
import com.fyber.inneractive.sdk.util.i0;
import com.fyber.inneractive.sdk.util.n0;

/* JADX INFO: loaded from: classes13.dex */
public final class h implements a {
    @Override // com.fyber.inneractive.sdk.player.ui.a
    public final i0 a(UnitDisplayType unitDisplayType, int i, int i2, boolean z, i0 i0Var, int i3, int i4, int i5, int i6) {
        if (i0Var == null) {
            return null;
        }
        if (unitDisplayType == UnitDisplayType.SQUARE) {
            int iMin = Math.min(i3, i5) - AbstractC3251o.a(i6 * 2);
            i0Var.f2365a = iMin;
            i0Var.b = iMin;
        } else if (unitDisplayType == UnitDisplayType.LANDSCAPE) {
            int iMin2 = Math.min(i3, i5) - AbstractC3251o.a(i6 * 2);
            i0Var.f2365a = iMin2;
            i0Var.b = (iMin2 * 9) / 16;
        } else if (unitDisplayType == UnitDisplayType.MRECT) {
            i0Var.f2365a = AbstractC3251o.a(300);
            i0Var.b = AbstractC3251o.a(250);
        } else if (unitDisplayType == UnitDisplayType.DEFAULT && z) {
            n0.a(unitDisplayType, i0Var, i, i2, i3, i4);
        } else {
            i0Var.f2365a = 0;
            i0Var.b = 0;
        }
        return i0Var;
    }

    @Override // com.fyber.inneractive.sdk.player.ui.a
    public final i0 a(UnitDisplayType unitDisplayType, int i, int i2, i0 i0Var, int i3, ViewGroup viewGroup) {
        i0 i0Var2 = new i0(0, 0);
        if (unitDisplayType == UnitDisplayType.SQUARE) {
            int i4 = i0Var.f2365a;
            n0.a(unitDisplayType, i0Var2, i, i2, i4, i4);
        } else {
            n0.a(unitDisplayType, i0Var2, i, i2, i0Var.f2365a, i0Var.b);
        }
        return i0Var2;
    }
}
