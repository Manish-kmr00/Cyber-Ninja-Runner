package com.safedk.android.analytics.brandsafety;

import android.text.TextUtils;
import com.safedk.android.analytics.brandsafety.creatives.AdNetworkConfiguration;
import com.safedk.android.analytics.brandsafety.creatives.CreativeInfoManager;
import com.safedk.android.analytics.brandsafety.creatives.infos.CreativeInfo;
import com.safedk.android.utils.Logger;

/* JADX INFO: loaded from: classes6.dex */
public class d {
    private static final String j = "AdInfoKey";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    String f8095a;
    String b;
    String c;
    String d;
    String e;
    BrandSafetyUtils.AdType f;
    String g = null;
    String h = null;
    boolean i = false;

    public d(String str, String str2, String str3, String str4, String str5, BrandSafetyUtils.AdType adType) {
        this.f8095a = str;
        this.b = str2;
        this.c = str3;
        this.d = str4;
        this.e = str5;
        this.f = adType;
    }

    private boolean a(BrandSafetyUtils.AdType adType) {
        return (adType == BrandSafetyUtils.AdType.BANNER || adType == BrandSafetyUtils.AdType.MREC) ? false : true;
    }

    public boolean equals(Object o) {
        Logger.d(j, "equals started with this: " + this + " and that: " + o);
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        d dVar = (d) o;
        boolean zEquals = this.f8095a.equals(dVar.f8095a);
        boolean z = this.b != null && this.b.equals(dVar.b);
        boolean zEquals2 = zEquals && this.d.equals(dVar.d) && ((this.e != null && this.e.equals(dVar.e)) || (this.e == null && dVar.e == null));
        if (this.c != null) {
            zEquals2 &= this.c.equals(dVar.c);
            String strA = CreativeInfoManager.a(this.d, AdNetworkConfiguration.DONT_USE_PLACEMENT_ID_IN_BANNER_AD_INFO_KEY, "");
            if (strA != null && strA.contains(this.e) && !a(this.f)) {
                Logger.d(j, "not using placement id - equals result is: " + zEquals2);
                return zEquals2;
            }
        }
        return zEquals2 && z;
    }

    public int hashCode() {
        int iHashCode = this.f8095a.hashCode() * this.d.hashCode();
        String strA = CreativeInfoManager.a(this.d, AdNetworkConfiguration.DONT_USE_PLACEMENT_ID_IN_BANNER_AD_INFO_KEY, "");
        if (a(this.f) || this.e == null || strA == null || !strA.contains(this.e)) {
            iHashCode *= this.b.hashCode();
        }
        if (this.c != null) {
            return iHashCode * this.c.hashCode();
        }
        return iHashCode;
    }

    public String toString() {
        return "AdInfoKey{adUnitId=" + this.f8095a + ", placementId=" + this.b + ", eventId=" + com.safedk.android.utils.n.b((Object) this.c) + ", sdk=" + this.d + ", maxNetwork=" + com.safedk.android.utils.n.b((Object) this.e) + "}";
    }

    public String a() {
        return (this.f8095a != null ? this.f8095a : "") + "_" + (this.b != null ? this.b : "") + "_" + (this.c != null ? this.c : "") + "_" + (this.d != null ? this.d : "");
    }

    public boolean a(d dVar, CreativeInfo creativeInfo) {
        if (!dVar.equals(this)) {
            return false;
        }
        if (TextUtils.isEmpty(this.b)) {
            creativeInfo.j(dVar.b);
            this.b = dVar.b;
        }
        return true;
    }
}
