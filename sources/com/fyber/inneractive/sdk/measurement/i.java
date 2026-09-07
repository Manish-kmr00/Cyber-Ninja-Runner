package com.fyber.inneractive.sdk.measurement;

import android.text.TextUtils;
import com.fyber.inneractive.sdk.model.vast.x;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: loaded from: classes12.dex */
public final class i implements com.fyber.inneractive.sdk.response.i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public URL f1863a;
    public String b;
    public String d;
    public String e;
    public String f;
    public final HashMap c = new HashMap();
    public boolean g = false;

    public final void a(x xVar, String str) {
        List arrayList = (List) this.c.get(xVar);
        if (arrayList == null) {
            arrayList = new ArrayList();
            this.c.put(xVar, arrayList);
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        arrayList.add(str);
    }

    public final boolean b() {
        String str;
        return this.g && this.f1863a != null && ((str = this.b) == null || (!TextUtils.isEmpty(str) && this.b.equalsIgnoreCase(CampaignEx.KEY_OMID)));
    }

    public final String toString() {
        return "Verification{mJavaScriptResource=" + this.f1863a + ", mTrackingEvents=" + this.c + ", mVerificationParameters='" + this.d + "', mVendor='" + this.e + "'}";
    }

    @Override // com.fyber.inneractive.sdk.response.i
    public final List a(x xVar) {
        HashMap map;
        if (xVar == null || (map = this.c) == null) {
            return null;
        }
        return (List) map.get(xVar);
    }

    public final String a() {
        if (!this.g) {
            return "JavaScriptResource = ";
        }
        if (TextUtils.isEmpty(this.b)) {
            return "apiFramework = ";
        }
        if (!this.b.equalsIgnoreCase(CampaignEx.KEY_OMID)) {
            return "apiFramework = " + this.b;
        }
        return "JavaScriptResource_url = " + (TextUtils.isEmpty(this.f) ? "" : this.f);
    }
}
