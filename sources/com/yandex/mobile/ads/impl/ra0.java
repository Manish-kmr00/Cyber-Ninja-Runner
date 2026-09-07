package com.yandex.mobile.ads.impl;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import androidx.core.content.ContextCompat;
import com.yandex.mobile.ads.R;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class ra0 implements cn0 {
    private static final int f = R.drawable.monetization_ads_internal_instream_adtune_control_v2;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ig<?> f10088a;
    private final mg b;
    private final eg2 c;
    private final yb d;
    private final o20 e;

    public ra0(ig<?> igVar, mg assetClickConfigurator, eg2 videoTracker, yb adtuneRenderer, o20 divKitAdtuneRenderer) {
        Intrinsics.checkNotNullParameter(assetClickConfigurator, "assetClickConfigurator");
        Intrinsics.checkNotNullParameter(videoTracker, "videoTracker");
        Intrinsics.checkNotNullParameter(adtuneRenderer, "adtuneRenderer");
        Intrinsics.checkNotNullParameter(divKitAdtuneRenderer, "divKitAdtuneRenderer");
        this.f10088a = igVar;
        this.b = assetClickConfigurator;
        this.c = videoTracker;
        this.d = adtuneRenderer;
        this.e = divKitAdtuneRenderer;
    }

    @Override // com.yandex.mobile.ads.impl.cn0
    public final void a(gb2 uiElements) {
        Intrinsics.checkNotNullParameter(uiElements, "uiElements");
        ImageView imageViewH = uiElements.h();
        if (imageViewH != null) {
            Drawable drawable = imageViewH.getDrawable();
            if (drawable == null) {
                drawable = ContextCompat.getDrawable(imageViewH.getContext(), f);
            }
            imageViewH.setImageDrawable(drawable);
            imageViewH.setVisibility(a() != null ? 0 : 8);
            fk fkVarA = a();
            if (fkVarA == null) {
                this.b.a(imageViewH, this.f10088a);
                return;
            }
            Context context = imageViewH.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
            imageViewH.setOnClickListener(new qa0(fkVarA, this.d, this.e, this.c, new je2(context)));
        }
    }

    private final fk a() {
        x xVar;
        rr0 rr0VarA;
        List<x> listA;
        Object next;
        x xVar2;
        ig<?> igVar = this.f10088a;
        if (igVar == null || (rr0VarA = igVar.a()) == null || (listA = rr0VarA.a()) == null) {
            xVar = null;
        } else {
            Iterator<T> it = listA.iterator();
            do {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
                xVar2 = (x) next;
                if (Intrinsics.areEqual(xVar2.a(), "adtune")) {
                    break;
                }
            } while (!Intrinsics.areEqual(xVar2.a(), "divkit_adtune"));
            xVar = (x) next;
        }
        if (xVar instanceof fk) {
            return (fk) xVar;
        }
        return null;
    }
}
