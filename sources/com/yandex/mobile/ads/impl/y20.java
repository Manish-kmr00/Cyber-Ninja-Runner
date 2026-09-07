package com.yandex.mobile.ads.impl;

import com.yandex.div.DivDataTag;
import com.yandex.div2.DivData;
import java.util.List;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes6.dex */
public final class y20 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f10693a;
    private final JSONObject b;
    private final JSONObject c;
    private final List<uj0> d;
    private final DivData e;
    private final DivDataTag f;
    private final Set<p20> g;

    public y20(String target, JSONObject card, JSONObject jSONObject, List<uj0> list, DivData divData, DivDataTag divDataTag, Set<p20> divAssets) {
        Intrinsics.checkNotNullParameter(target, "target");
        Intrinsics.checkNotNullParameter(card, "card");
        Intrinsics.checkNotNullParameter(divData, "divData");
        Intrinsics.checkNotNullParameter(divDataTag, "divDataTag");
        Intrinsics.checkNotNullParameter(divAssets, "divAssets");
        this.f10693a = target;
        this.b = card;
        this.c = jSONObject;
        this.d = list;
        this.e = divData;
        this.f = divDataTag;
        this.g = divAssets;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof y20)) {
            return false;
        }
        y20 y20Var = (y20) obj;
        return Intrinsics.areEqual(this.f10693a, y20Var.f10693a) && Intrinsics.areEqual(this.b, y20Var.b) && Intrinsics.areEqual(this.c, y20Var.c) && Intrinsics.areEqual(this.d, y20Var.d) && Intrinsics.areEqual(this.e, y20Var.e) && Intrinsics.areEqual(this.f, y20Var.f) && Intrinsics.areEqual(this.g, y20Var.g);
    }

    public final int hashCode() {
        int iHashCode = (this.b.hashCode() + (this.f10693a.hashCode() * 31)) * 31;
        JSONObject jSONObject = this.c;
        int iHashCode2 = (iHashCode + (jSONObject == null ? 0 : jSONObject.hashCode())) * 31;
        List<uj0> list = this.d;
        return this.g.hashCode() + ((this.f.hashCode() + ((this.e.hashCode() + ((iHashCode2 + (list != null ? list.hashCode() : 0)) * 31)) * 31)) * 31);
    }

    public final String toString() {
        return "DivKitDesign(target=" + this.f10693a + ", card=" + this.b + ", templates=" + this.c + ", images=" + this.d + ", divData=" + this.e + ", divDataTag=" + this.f + ", divAssets=" + this.g + ")";
    }

    public final String e() {
        return this.f10693a;
    }

    public final List<uj0> d() {
        return this.d;
    }

    public final DivData b() {
        return this.e;
    }

    public final DivDataTag c() {
        return this.f;
    }

    public final Set<p20> a() {
        return this.g;
    }
}
