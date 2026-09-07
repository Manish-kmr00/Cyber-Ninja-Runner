package com.ogury.ad.internal;

import com.ogury.ad.OguryAdError;
import com.ogury.ad.common.OguryMediation;
import kotlin.Pair;
import kotlin.TuplesKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes12.dex */
public final class w implements b6 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ x f7424a;

    public w(x xVar) {
        this.f7424a = xVar;
    }

    @Override // com.ogury.ad.internal.b6
    public final void a() {
        this.f7424a.a();
    }

    public final void b() {
        if (this.f7424a.j.b().length() == 0) {
            this.f7424a.d("Impossible to set up module (no asset key found)");
            x xVar = this.f7424a;
            d4 d4Var = xVar.e;
            n7 n7Var = n7.LE_015_SDK_NEVER_INITIALIZED;
            String str = xVar.b.f7276a;
            String str2 = xVar.m;
            OguryMediation oguryMediation = xVar.n;
            Pair pair = TuplesKt.to("from_ad_markup", Boolean.valueOf(xVar.y != null));
            Pair pair2 = TuplesKt.to("reload", Boolean.valueOf(this.f7424a.p));
            int i = this.f7424a.z;
            d4Var.a(n7Var, str, str2, oguryMediation, p7.a(pair, pair2, TuplesKt.to("webview_termination", i > 0 ? Integer.valueOf(i) : null)), (JSONObject) null);
            this.f7424a.a(new OguryAdError(OguryAdError.Type.LOAD_ERROR, 2000, "The load could not proceed because the SDK appears to have not been started."));
            return;
        }
        this.f7424a.d("SDK not initialized. Please initialize the SDK before attempting to load an Ad.");
        x xVar2 = this.f7424a;
        d4 d4Var2 = xVar2.e;
        n7 n7Var2 = n7.LE_015_SDK_NOT_INITIALIZED;
        String str3 = xVar2.b.f7276a;
        String str4 = xVar2.m;
        OguryMediation oguryMediation2 = xVar2.n;
        Pair pair3 = TuplesKt.to("from_ad_markup", Boolean.valueOf(xVar2.y != null));
        Pair pair4 = TuplesKt.to("reload", Boolean.valueOf(this.f7424a.p));
        int i2 = this.f7424a.z;
        d4Var2.a(n7Var2, str3, str4, oguryMediation2, p7.a(pair3, pair4, TuplesKt.to("webview_termination", i2 > 0 ? Integer.valueOf(i2) : null)), (JSONObject) null);
        this.f7424a.a(new OguryAdError(OguryAdError.Type.LOAD_ERROR, 2000, "The load could not proceed because the SDK appears to have not been started."));
    }

    @Override // com.ogury.ad.internal.b6
    public final void a(Throwable th) {
        this.f7424a.d("Module setup issue");
        x xVar = this.f7424a;
        d4 d4Var = xVar.e;
        n7 n7Var = n7.LE_015_SDK_INITIALIZATION_FAILED;
        String str = xVar.b.f7276a;
        String str2 = xVar.m;
        OguryMediation oguryMediation = xVar.n;
        JSONObject jSONObjectPut = new JSONObject().put("stacktrace", th != null ? th.getMessage() : null);
        Pair pair = TuplesKt.to("from_ad_markup", Boolean.valueOf(this.f7424a.y != null));
        Pair pair2 = TuplesKt.to("reload", Boolean.valueOf(this.f7424a.p));
        int i = this.f7424a.z;
        d4Var.a(n7Var, str, str2, oguryMediation, p7.a(pair, pair2, TuplesKt.to("webview_termination", i > 0 ? Integer.valueOf(i) : null)), jSONObjectPut);
        this.f7424a.a(new OguryAdError(OguryAdError.Type.LOAD_ERROR, 2001, "The load could not proceed because the SDK is not properly initialized."));
    }
}
