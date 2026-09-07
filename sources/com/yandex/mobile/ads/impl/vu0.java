package com.yandex.mobile.ads.impl;

import android.view.View;
import android.widget.ImageView;
import com.monetization.ads.nativeads.CustomizableMediaView;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class vu0 implements jg<ax0>, v00<ax0> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ck0 f10509a;
    private final dx0 b;

    @Override // com.yandex.mobile.ads.impl.jg
    public final boolean d() {
        dx0 dx0Var = this.b;
        boolean z = dx0Var != null && oh2.a(dx0Var.b(), 100);
        ck0 ck0Var = this.f10509a;
        return z || (ck0Var != null && oh2.a(ck0Var.b(), 100));
    }

    public vu0(ck0 ck0Var, dx0 dx0Var) {
        this.f10509a = ck0Var;
        this.b = dx0Var;
    }

    @Override // com.yandex.mobile.ads.impl.jg
    public final boolean b() {
        ck0 ck0Var;
        dx0 dx0Var = this.b;
        return ((dx0Var == null || dx0Var.b() == null) && ((ck0Var = this.f10509a) == null || ck0Var.b() == null)) ? false : true;
    }

    @Override // com.yandex.mobile.ads.impl.jg
    public final boolean e() {
        dx0 dx0Var = this.b;
        if (dx0Var != null && dx0Var.c()) {
            return true;
        }
        ck0 ck0Var = this.f10509a;
        return ck0Var != null && ck0Var.c();
    }

    @Override // com.yandex.mobile.ads.impl.jg
    public final dh2 c() {
        CustomizableMediaView view = (CustomizableMediaView) a((ng2) this.b);
        ImageView view2 = (ImageView) a((ng2) this.f10509a);
        if (view != null) {
            Intrinsics.checkNotNullParameter(view, "view");
            return new dh2(view.getWidth(), view.getHeight());
        }
        if (view2 == null) {
            return null;
        }
        Intrinsics.checkNotNullParameter(view2, "view");
        return new dh2(view2.getWidth(), view2.getHeight());
    }

    public final dx0.a f() {
        dx0.a aVarD;
        dx0 dx0Var = this.b;
        if (dx0Var != null && (aVarD = dx0Var.d()) != null) {
            return aVarD;
        }
        if (this.f10509a != null) {
            return dx0.a.f;
        }
        return null;
    }

    @Override // com.yandex.mobile.ads.impl.jg
    public final void a() {
        dx0 dx0Var;
        ck0 ck0Var;
        ImageView imageView = (ImageView) a((ng2) this.f10509a);
        if (imageView != null && (ck0Var = this.f10509a) != null) {
            ck0Var.a(imageView);
        }
        CustomizableMediaView customizableMediaView = (CustomizableMediaView) a((ng2) this.b);
        if (customizableMediaView == null || (dx0Var = this.b) == null) {
            return;
        }
        dx0Var.a(customizableMediaView);
    }

    @Override // com.yandex.mobile.ads.impl.v00
    public final void b(ax0 ax0Var) {
        ax0 mediaValue = ax0Var;
        Intrinsics.checkNotNullParameter(mediaValue, "mediaValue");
        uj0 uj0VarA = a((List) mediaValue.a());
        ImageView imageView = (ImageView) a((ng2) this.f10509a);
        if (imageView != null && uj0VarA != null) {
            ck0 ck0Var = this.f10509a;
            if (ck0Var != null) {
                ck0Var.a(imageView, uj0VarA);
            }
            imageView.setVisibility(0);
        }
        CustomizableMediaView customizableMediaView = (CustomizableMediaView) a((ng2) this.b);
        if (customizableMediaView == null) {
            return;
        }
        dx0 dx0Var = this.b;
        if (dx0Var != null) {
            dx0Var.a(mediaValue);
        }
        customizableMediaView.setVisibility(0);
    }

    @Override // com.yandex.mobile.ads.impl.jg
    public final void a(ig<ax0> asset, qg2 viewConfigurator) {
        Intrinsics.checkNotNullParameter(asset, "asset");
        Intrinsics.checkNotNullParameter(viewConfigurator, "viewConfigurator");
        ax0 ax0VarD = asset.d();
        ck0 ck0Var = this.f10509a;
        if (ck0Var != null) {
            ck0Var.a(asset, viewConfigurator, a((List) ax0VarD.a()));
        }
        dx0 dx0Var = this.b;
        if (dx0Var != null) {
            dx0Var.a(asset, viewConfigurator, ax0VarD);
        }
    }

    @Override // com.yandex.mobile.ads.impl.jg
    public final void c(ax0 ax0Var) {
        ax0 mediaValue = ax0Var;
        Intrinsics.checkNotNullParameter(mediaValue, "mediaValue");
        uj0 uj0VarA = a((List) mediaValue.a());
        ImageView imageView = (ImageView) a((ng2) this.f10509a);
        if (imageView != null && uj0VarA != null) {
            ck0 ck0Var = this.f10509a;
            if (ck0Var != null) {
                ck0Var.a(imageView, uj0VarA);
            }
            imageView.setVisibility(0);
        }
        CustomizableMediaView customizableMediaView = (CustomizableMediaView) a((ng2) this.b);
        if (customizableMediaView != null) {
            dx0 dx0Var = this.b;
            if (dx0Var != null) {
                dx0Var.b(customizableMediaView, mediaValue);
            }
            customizableMediaView.setVisibility(0);
        }
    }

    @Override // com.yandex.mobile.ads.impl.jg
    public final void destroy() {
        dx0 dx0Var = this.b;
        if (dx0Var != null) {
            dx0Var.a();
        }
    }

    private static View a(ng2 ng2Var) {
        if (ng2Var != null) {
            return ng2Var.b();
        }
        return null;
    }

    private static uj0 a(List list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        return (uj0) list.get(0);
    }

    @Override // com.yandex.mobile.ads.impl.jg
    public final boolean a(ax0 ax0Var) {
        ax0 mediaValue = ax0Var;
        Intrinsics.checkNotNullParameter(mediaValue, "mediaValue");
        ck0 ck0Var = this.f10509a;
        uj0 uj0VarA = a((List) mediaValue.a());
        View viewA = a((ng2) ck0Var);
        boolean z = (viewA == null || uj0VarA == null || ck0Var == null || !ck0Var.a(viewA, uj0VarA)) ? false : true;
        dx0 dx0Var = this.b;
        View viewA2 = a((ng2) dx0Var);
        return z || (viewA2 != null && dx0Var != null && dx0Var.a(viewA2, mediaValue));
    }
}
