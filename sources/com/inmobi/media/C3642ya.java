package com.inmobi.media;

import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: renamed from: com.inmobi.media.ya, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes10.dex */
public final class C3642ya implements InterfaceC3349e1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Ba f3488a;

    public C3642ya(Ba ba) {
        this.f3488a = ba;
    }

    @Override // com.inmobi.media.InterfaceC3349e1
    public final void a(C3431k assetBatch, byte b) {
        Intrinsics.checkNotNullParameter(assetBatch, "assetBatch");
        if (assetBatch.c == null || assetBatch.g.size() <= 0) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("url", ((C3417j) assetBatch.g.get(0)).b);
            jSONObject.put("reason", (int) ((C3417j) assetBatch.g.get(0)).l);
        } catch (JSONException unused) {
        }
        String string = jSONObject.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        String str = "sendSaveContentResult(\"saveContent_" + assetBatch.f + "\", 'failed', \"" + StringsKt.replace$default(string, "\"", "\\\"", false, 4, (Object) null) + "\");";
        L4 l4 = this.f3488a.i;
        if (l4 != null) {
            String str2 = Ba.O0;
            ((M4) l4).b(str2, P5.a(str2, "access$getTAG$cp(...)", "Failure injection ", str));
        }
        this.f3488a.a(assetBatch.c, str);
    }

    @Override // com.inmobi.media.InterfaceC3349e1
    public final void a(C3431k assetBatch) {
        Intrinsics.checkNotNullParameter(assetBatch, "assetBatch");
        if (assetBatch.c == null || assetBatch.g.size() <= 0) {
            return;
        }
        String str = "sendSaveContentResult(\"saveContent_" + assetBatch.f + "\", 'success', \"" + ((C3417j) assetBatch.g.get(0)).j + "\");";
        L4 l4 = this.f3488a.i;
        if (l4 != null) {
            String str2 = Ba.O0;
            ((M4) l4).a(str2, P5.a(str2, "access$getTAG$cp(...)", "Success injection ", str));
        }
        this.f3488a.a(assetBatch.c, str);
    }
}
