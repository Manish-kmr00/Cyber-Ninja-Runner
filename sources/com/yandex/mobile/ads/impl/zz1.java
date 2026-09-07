package com.yandex.mobile.ads.impl;

import android.view.View;
import com.yandex.div.core.view2.Div2View;
import com.yandex.div2.DivBase;
import com.yandex.div2.DivExtension;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes10.dex */
public final class zz1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final uz1 f10869a;
    private final lp1 b;
    private final f20 c;
    private final t70 d;
    private final dh e;

    public zz1(uz1 sliderAdPrivate, lp1 reporter, f20 divExtensionProvider, t70 extensionPositionParser, n61 assetNamesProvider, dh assetsNativeAdViewProviderCreator) {
        Intrinsics.checkNotNullParameter(sliderAdPrivate, "sliderAdPrivate");
        Intrinsics.checkNotNullParameter(reporter, "reporter");
        Intrinsics.checkNotNullParameter(divExtensionProvider, "divExtensionProvider");
        Intrinsics.checkNotNullParameter(extensionPositionParser, "extensionPositionParser");
        Intrinsics.checkNotNullParameter(assetNamesProvider, "assetNamesProvider");
        Intrinsics.checkNotNullParameter(assetsNativeAdViewProviderCreator, "assetsNativeAdViewProviderCreator");
        this.f10869a = sliderAdPrivate;
        this.b = reporter;
        this.c = divExtensionProvider;
        this.d = extensionPositionParser;
        this.e = assetsNativeAdViewProviderCreator;
    }

    public final void a(Div2View div2View, View view, DivBase divBase) {
        Integer numValueOf;
        Intrinsics.checkNotNullParameter(div2View, "div2View");
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(divBase, "divBase");
        view.setVisibility(8);
        this.c.getClass();
        DivExtension divExtension = f20.a(divBase, "view");
        if (divExtension != null) {
            this.d.getClass();
            Intrinsics.checkNotNullParameter(divExtension, "divExtension");
            JSONObject jSONObject = divExtension.params;
            if (jSONObject != null) {
                try {
                    numValueOf = Integer.valueOf(jSONObject.getInt(com.ironsource.b9.h.L));
                } catch (JSONException unused) {
                    numValueOf = null;
                }
            } else {
                numValueOf = null;
            }
            if (numValueOf != null) {
                ArrayList arrayListD = this.f10869a.d();
                if (numValueOf.intValue() < 0 || numValueOf.intValue() >= arrayListD.size()) {
                    return;
                }
                try {
                    ((m61) arrayListD.get(numValueOf.intValue())).b(this.e.a(view, new ud1(numValueOf.intValue())), r10.a(div2View).a(numValueOf.intValue()));
                    view.setVisibility(0);
                } catch (a61 e) {
                    this.b.reportError("Failed to bind DivKit Slider Inner Ad", e);
                }
            }
        }
    }
}
