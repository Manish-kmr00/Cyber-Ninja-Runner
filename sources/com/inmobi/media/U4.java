package com.inmobi.media;

import com.inmobi.unifiedId.InMobiUnifiedIdService;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes8.dex */
public final class U4 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ JSONObject f3210a;

    public U4(JSONObject jSONObject) {
        this.f3210a = jSONObject;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Boolean boolC = C3532qc.f3412a.c();
        boolean zBooleanValue = boolC != null ? boolC.booleanValue() : true;
        if (zBooleanValue) {
            InMobiUnifiedIdService.reset();
        }
        if (zBooleanValue) {
            return;
        }
        AbstractC3296a5.a(this.f3210a);
    }
}
