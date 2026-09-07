package com.yandex.mobile.ads.impl;

import com.yandex.div.DivDataTag;
import com.yandex.div2.DivData;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes13.dex */
public final class d30 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final lp1 f8661a;
    private final c20 b;
    private final e20 c;
    private final a30 d;
    private final rj e;

    public final y20 a(x00 design, boolean z) {
        Intrinsics.checkNotNullParameter(design, "design");
        if (Intrinsics.areEqual(d10.DIV_KIT.a(), design.d())) {
            try {
                String strC = design.c();
                String strB = design.b();
                if (z) {
                    this.e.getClass();
                    strB = rj.a(strB);
                }
                JSONObject jSONObject = new JSONObject(strB);
                JSONObject jSONObject2 = jSONObject.getJSONObject("card");
                JSONObject jSONObject3 = jSONObject.has("templates") ? jSONObject.getJSONObject("templates") : null;
                List<uj0> listA = design.a();
                c20 c20Var = this.b;
                Intrinsics.checkNotNull(jSONObject2);
                DivData divDataA = c20Var.a(jSONObject2, jSONObject3);
                this.c.getClass();
                String string = UUID.randomUUID().toString();
                Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
                DivDataTag divDataTag = new DivDataTag(string);
                Set<p20> setA = this.d.a(jSONObject2);
                if (divDataA != null) {
                    return new y20(strC, jSONObject2, jSONObject3, listA, divDataA, divDataTag, setA);
                }
            } catch (Throwable th) {
                this.f8661a.reportError("Failed to parse DivKit design", th);
            }
        }
        return null;
    }

    public /* synthetic */ d30(lp1 lp1Var) {
        this(lp1Var, new c20(lp1Var), new e20(), new a30(), new rj());
    }

    public d30(lp1 reporter, c20 divDataCreator, e20 divDataTagCreator, a30 assetsProvider, rj base64Decoder) {
        Intrinsics.checkNotNullParameter(reporter, "reporter");
        Intrinsics.checkNotNullParameter(divDataCreator, "divDataCreator");
        Intrinsics.checkNotNullParameter(divDataTagCreator, "divDataTagCreator");
        Intrinsics.checkNotNullParameter(assetsProvider, "assetsProvider");
        Intrinsics.checkNotNullParameter(base64Decoder, "base64Decoder");
        this.f8661a = reporter;
        this.b = divDataCreator;
        this.c = divDataTagCreator;
        this.d = assetsProvider;
        this.e = base64Decoder;
    }
}
