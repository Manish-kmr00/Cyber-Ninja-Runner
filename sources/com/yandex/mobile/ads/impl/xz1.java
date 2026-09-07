package com.yandex.mobile.ads.impl;

import android.view.View;
import com.yandex.div.core.extension.DivExtensionHandler;
import com.yandex.div.core.view2.Div2View;
import com.yandex.div.json.expressions.ExpressionResolver;
import com.yandex.div2.DivBase;
import com.yandex.div2.DivData;
import com.yandex.div2.DivExtension;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes13.dex */
public final class xz1 implements DivExtensionHandler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final lp1 f10689a;
    private final f20 b;
    private final t70 c;
    private final u70 d;
    private final ConcurrentHashMap<DivData, zz1> e;

    public final void a(DivData divData, uz1 sliderAdPrivate) {
        Intrinsics.checkNotNullParameter(divData, "divData");
        Intrinsics.checkNotNullParameter(sliderAdPrivate, "sliderAdPrivate");
        this.e.put(divData, new zz1(sliderAdPrivate, this.f10689a, new f20(), new t70(), new n61(), new dh(n61.c(sliderAdPrivate))));
    }

    @Override // com.yandex.div.core.extension.DivExtensionHandler
    public final void bindView(Div2View div2View, ExpressionResolver expressionResolver, View view, DivBase divBase) {
        Intrinsics.checkNotNullParameter(div2View, "div2View");
        Intrinsics.checkNotNullParameter(expressionResolver, "expressionResolver");
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(divBase, "divBase");
        zz1 zz1Var = this.e.get(div2View.getDivData());
        if (zz1Var != null) {
            zz1Var.a(div2View, view, divBase);
        }
    }

    @Override // com.yandex.div.core.extension.DivExtensionHandler
    public final boolean matches(DivBase divBase) {
        Integer numValueOf;
        Intrinsics.checkNotNullParameter(divBase, "divBase");
        this.b.getClass();
        DivExtension divExtension = f20.a(divBase, "view");
        if (divExtension == null) {
            return false;
        }
        this.c.getClass();
        Intrinsics.checkNotNullParameter(divExtension, "divExtension");
        JSONObject jSONObject = divExtension.params;
        String string = null;
        if (jSONObject != null) {
            try {
                numValueOf = Integer.valueOf(jSONObject.getInt(com.ironsource.b9.h.L));
            } catch (JSONException unused) {
                numValueOf = null;
            }
        } else {
            numValueOf = null;
        }
        this.d.getClass();
        Intrinsics.checkNotNullParameter(divExtension, "divExtension");
        JSONObject jSONObject2 = divExtension.params;
        if (jSONObject2 != null) {
            try {
                string = jSONObject2.getString("view_name");
            } catch (JSONException unused2) {
            }
        }
        return numValueOf != null && Intrinsics.areEqual("native_ad_view", string);
    }

    @Override // com.yandex.div.core.extension.DivExtensionHandler
    public final void unbindView(Div2View div2View, ExpressionResolver expressionResolver, View view, DivBase divBase) {
        Intrinsics.checkNotNullParameter(div2View, "div2View");
        Intrinsics.checkNotNullParameter(expressionResolver, "expressionResolver");
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(divBase, "divBase");
        if (this.e.get(div2View.getDivData()) != null) {
            Intrinsics.checkNotNullParameter(div2View, "div2View");
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(divBase, "divBase");
        }
    }

    public /* synthetic */ xz1(lp1 lp1Var) {
        this(lp1Var, new f20(), new t70(), new u70());
    }

    public xz1(lp1 reporter, f20 divExtensionProvider, t70 extensionPositionParser, u70 extensionViewNameParser) {
        Intrinsics.checkNotNullParameter(reporter, "reporter");
        Intrinsics.checkNotNullParameter(divExtensionProvider, "divExtensionProvider");
        Intrinsics.checkNotNullParameter(extensionPositionParser, "extensionPositionParser");
        Intrinsics.checkNotNullParameter(extensionViewNameParser, "extensionViewNameParser");
        this.f10689a = reporter;
        this.b = divExtensionProvider;
        this.c = extensionPositionParser;
        this.d = extensionViewNameParser;
        this.e = new ConcurrentHashMap<>();
    }
}
