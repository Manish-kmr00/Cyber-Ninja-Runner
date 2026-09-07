package io.appmetrica.analytics.impl;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Base64;
import android.util.Pair;
import io.appmetrica.analytics.billinginterface.internal.Period;
import io.appmetrica.analytics.billinginterface.internal.ProductInfo;
import io.appmetrica.analytics.billinginterface.internal.ProductType;
import io.appmetrica.analytics.coreapi.internal.event.CounterReportApi;
import io.appmetrica.analytics.coreapi.internal.permission.PermissionState;
import io.appmetrica.analytics.coreutils.internal.collection.CollectionUtils;
import io.appmetrica.analytics.coreutils.internal.time.SystemTimeProvider;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import java.util.Collection;
import java.util.Currency;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: renamed from: io.appmetrica.analytics.impl.a6, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes6.dex */
public class C3984a6 implements CounterReportApi, Parcelable {
    public static final Parcelable.Creator<C3984a6> CREATOR = new Z5();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected String f11459a;
    protected String b;
    public String c;
    public int d;
    public int e;
    public Pair f;
    public int g;
    public String h;
    public long i;
    public long j;
    public EnumC4237ka k;
    public EnumC4435s9 l;
    public Bundle m;
    public Boolean n;
    public Integer o;
    public Map p;

    public C3984a6() {
        this("", 0);
    }

    public final void a(String str, String str2) {
        if (this.f == null) {
            this.f = new Pair(str, str2);
        }
    }

    public final Pair<String, String> b() {
        return this.f;
    }

    public final void c(Bundle bundle) {
        this.m = bundle;
    }

    public final long d() {
        return this.i;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final long e() {
        return this.j;
    }

    public final String f() {
        return this.c;
    }

    public final EnumC4237ka g() {
        return this.k;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.event.CounterReportApi
    public final int getBytesTruncated() {
        return this.g;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.event.CounterReportApi
    public final int getCustomType() {
        return this.e;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.event.CounterReportApi
    public final Map<String, byte[]> getExtras() {
        return this.p;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.event.CounterReportApi
    public final String getName() {
        return this.f11459a;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.event.CounterReportApi
    public final int getType() {
        return this.d;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.event.CounterReportApi
    public final String getValue() {
        return this.b;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.event.CounterReportApi
    public final byte[] getValueBytes() {
        String str = this.b;
        if (str == null) {
            return null;
        }
        return Base64.decode(str, 0);
    }

    public final Integer h() {
        return this.o;
    }

    public final Bundle i() {
        return this.m;
    }

    public final String j() {
        return this.h;
    }

    public final EnumC4435s9 k() {
        return this.l;
    }

    public final boolean l() {
        return this.f11459a == null;
    }

    public final boolean m() {
        EnumC4164hb enumC4164hb = EnumC4164hb.EVENT_TYPE_UNDEFINED;
        return -1 == this.d;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.event.CounterReportApi
    public final void setBytesTruncated(int i) {
        this.g = i;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.event.CounterReportApi
    public final void setCustomType(int i) {
        this.e = i;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.event.CounterReportApi
    public final void setExtras(Map<String, byte[]> map) {
        this.p = map;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.event.CounterReportApi
    public void setName(String str) {
        this.f11459a = str;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.event.CounterReportApi
    public final void setType(int i) {
        this.d = i;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.event.CounterReportApi
    public void setValue(String str) {
        this.b = str;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.event.CounterReportApi
    public void setValueBytes(byte[] bArr) {
        this.b = bArr == null ? null : new String(Base64.encode(bArr, 0));
    }

    public final String toString() {
        Locale locale = Locale.US;
        String str = this.f11459a;
        String str2 = EnumC4164hb.a(this.d).b;
        String strSubstring = this.b;
        if (strSubstring == null) {
            strSubstring = null;
        } else if (strSubstring.length() > 500) {
            strSubstring = strSubstring.substring(0, 500);
        }
        return String.format(locale, "[event: %s, type: %s, value: %s]", str, str2, strSubstring);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        Bundle bundle = new Bundle();
        bundle.putString("CounterReport.Event", this.f11459a);
        bundle.putString("CounterReport.Value", this.b);
        bundle.putInt("CounterReport.Type", this.d);
        bundle.putInt("CounterReport.CustomType", this.e);
        bundle.putInt("CounterReport.TRUNCATED", this.g);
        bundle.putString("CounterReport.ProfileID", this.h);
        bundle.putInt("CounterReport.UniquenessStatus", this.k.f11635a);
        Bundle bundle2 = this.m;
        if (bundle2 != null) {
            bundle.putParcelable("CounterReport.Payload", bundle2);
        }
        String str = this.c;
        if (str != null) {
            bundle.putString("CounterReport.Environment", str);
        }
        Pair pair = this.f;
        if (pair != null) {
            bundle.putString("CounterReport.AppEnvironmentDiffKey", (String) pair.first);
            bundle.putString("CounterReport.AppEnvironmentDiffValue", (String) pair.second);
        }
        bundle.putLong("CounterReport.CreationElapsedRealtime", this.i);
        bundle.putLong("CounterReport.CreationTimestamp", this.j);
        EnumC4435s9 enumC4435s9 = this.l;
        if (enumC4435s9 != null) {
            bundle.putInt("CounterReport.Source", enumC4435s9.f11762a);
        }
        Boolean bool = this.n;
        if (bool != null) {
            bundle.putBoolean("CounterReport.AttributionIdChanged", bool.booleanValue());
        }
        Integer num = this.o;
        if (num != null) {
            bundle.putInt("CounterReport.OpenId", num.intValue());
        }
        bundle.putBundle("CounterReport.Extras", CollectionUtils.mapToBundle(this.p));
        parcel.writeBundle(bundle);
    }

    public C3984a6(String str, int i) {
        this("", str, i);
    }

    public static C3984a6 e(C3984a6 c3984a6) {
        return a(c3984a6, EnumC4164hb.EVENT_TYPE_APP_UPDATE);
    }

    public final void b(String str) {
        this.c = str;
    }

    public void c(String str) {
        this.h = str;
    }

    public final Bundle d(Bundle bundle) {
        if (bundle == null) {
            bundle = new Bundle();
        }
        bundle.putParcelable("CounterReport.Object", this);
        return bundle;
    }

    public C3984a6(String str, String str2, int i) {
        this(str, str2, i, new SystemTimeProvider());
    }

    public final void a(long j) {
        this.i = j;
    }

    public final void b(long j) {
        this.j = j;
    }

    public final Boolean c() {
        return this.n;
    }

    public C3984a6(String str, String str2, int i, SystemTimeProvider systemTimeProvider) {
        this.k = EnumC4237ka.UNKNOWN;
        this.p = new HashMap();
        this.f11459a = str2;
        this.d = i;
        this.b = str;
        this.i = systemTimeProvider.elapsedRealtime();
        this.j = systemTimeProvider.currentTimeMillis();
    }

    public static C3984a6 b(Bundle bundle) {
        if (bundle != null) {
            try {
                C3984a6 c3984a6 = (C3984a6) bundle.getParcelable("CounterReport.Object");
                if (c3984a6 != null) {
                    return c3984a6;
                }
            } catch (Throwable unused) {
                return new C3984a6("", 0);
            }
        }
        return new C3984a6("", 0);
    }

    public static C3984a6 c(C3984a6 c3984a6) {
        return a(c3984a6, EnumC4164hb.EVENT_TYPE_INIT);
    }

    public static C3984a6 d(C3984a6 c3984a6) {
        C3984a6 c3984a7 = new C3984a6("", 0);
        c3984a7.j = c3984a6.j;
        c3984a7.i = c3984a6.i;
        c3984a7.f = c3984a6.f;
        c3984a7.c = c3984a6.c;
        c3984a7.m = c3984a6.m;
        c3984a7.p = c3984a6.p;
        c3984a7.h = c3984a6.h;
        return c3984a7;
    }

    public final void a(EnumC4237ka enumC4237ka) {
        this.k = enumC4237ka;
    }

    public final void a(EnumC4435s9 enumC4435s9) {
        this.l = enumC4435s9;
    }

    public final void a(Boolean bool) {
        this.n = bool;
    }

    public final void a(Integer num) {
        this.o = num;
    }

    public static Pair a(Bundle bundle) {
        if (bundle.containsKey("CounterReport.AppEnvironmentDiffKey") && bundle.containsKey("CounterReport.AppEnvironmentDiffValue")) {
            return new Pair(bundle.getString("CounterReport.AppEnvironmentDiffKey"), bundle.getString("CounterReport.AppEnvironmentDiffValue"));
        }
        return null;
    }

    public static C3984a6 a(C3984a6 c3984a6, EnumC4164hb enumC4164hb) {
        C3984a6 c3984a6D = d(c3984a6);
        c3984a6D.d = enumC4164hb.f11583a;
        return c3984a6D;
    }

    public static C3984a6 b(C3984a6 c3984a6) {
        return a(c3984a6, EnumC4164hb.EVENT_TYPE_FIRST_ACTIVATION);
    }

    public static C3984a6 a(C3984a6 c3984a6) {
        return a(c3984a6, EnumC4164hb.EVENT_TYPE_ALIVE);
    }

    public static C3984a6 a(C3984a6 c3984a6, T9 t9) {
        C3984a6 c3984a6A = a(c3984a6, EnumC4164hb.EVENT_TYPE_START);
        c3984a6A.setValueBytes(MessageNano.toByteArray(new C4510v9().fromModel(new C4485u9((String) t9.b.a()))));
        c3984a6A.j = c3984a6.j;
        c3984a6A.i = c3984a6.i;
        return c3984a6A;
    }

    public static C3984a6 a(C3984a6 c3984a6, Collection<PermissionState> collection, H2 h2, C4130g2 c4130g2, List<String> list) {
        String string;
        String str;
        C3984a6 c3984a6D = d(c3984a6);
        try {
            JSONArray jSONArray = new JSONArray();
            for (PermissionState permissionState : collection) {
                jSONArray.put(new JSONObject().put("name", permissionState.name).put("granted", permissionState.granted));
            }
            JSONObject jSONObject = new JSONObject();
            if (h2 != null) {
                jSONObject.put("background_restricted", h2.b);
                G2 g2 = h2.f11171a;
                c4130g2.getClass();
                if (g2 != null) {
                    int iOrdinal = g2.ordinal();
                    if (iOrdinal == 0) {
                        str = "ACTIVE";
                    } else if (iOrdinal == 1) {
                        str = "WORKING_SET";
                    } else if (iOrdinal == 2) {
                        str = "FREQUENT";
                    } else if (iOrdinal == 3) {
                        str = "RARE";
                    } else if (iOrdinal == 4) {
                        str = "RESTRICTED";
                    }
                    jSONObject.put("app_standby_bucket", str);
                }
                str = null;
                jSONObject.put("app_standby_bucket", str);
            }
            string = new JSONObject().put("permissions", jSONArray).put("background_restrictions", jSONObject).put("available_providers", new JSONArray((Collection) list)).toString();
        } catch (Throwable unused) {
            string = "";
        }
        EnumC4164hb enumC4164hb = EnumC4164hb.EVENT_TYPE_UNDEFINED;
        c3984a6D.d = 12288;
        c3984a6D.setValue(string);
        return c3984a6D;
    }

    public static C3984a6 a(C3984a6 c3984a6, String str) {
        C3984a6 c3984a6D = d(c3984a6);
        EnumC4164hb enumC4164hb = EnumC4164hb.EVENT_TYPE_UNDEFINED;
        c3984a6D.d = 12289;
        c3984a6D.setValue(str);
        return c3984a6D;
    }

    public static C3984a6 a() {
        C3984a6 c3984a6 = new C3984a6("", 0);
        EnumC4164hb enumC4164hb = EnumC4164hb.EVENT_TYPE_UNDEFINED;
        c3984a6.d = 16384;
        return c3984a6;
    }

    public static C3984a6 a(C4466tf c4466tf) {
        int i;
        String currencyCode = "";
        int i2 = 0;
        C3984a6 c3984a6 = new C3984a6("", "", 0);
        EnumC4164hb enumC4164hb = EnumC4164hb.EVENT_TYPE_UNDEFINED;
        c3984a6.d = 40976;
        ProductInfo productInfo = c4466tf.f11781a;
        Ci ci = new Ci();
        ci.f11092a = productInfo.quantity;
        ci.f = productInfo.priceMicros;
        try {
            currencyCode = Currency.getInstance(productInfo.priceCurrency).getCurrencyCode();
        } catch (Throwable unused) {
        }
        ci.b = currencyCode.getBytes();
        ci.c = productInfo.sku.getBytes();
        C4569xi c4569xi = new C4569xi();
        c4569xi.f11845a = productInfo.purchaseOriginalJson.getBytes();
        c4569xi.b = productInfo.signature.getBytes();
        ci.e = c4569xi;
        ci.g = true;
        ci.h = 1;
        ci.i = AbstractC4441sf.f11763a[productInfo.type.ordinal()] != 2 ? 1 : 2;
        Bi bi = new Bi();
        bi.f11076a = productInfo.purchaseToken.getBytes();
        bi.b = TimeUnit.MILLISECONDS.toSeconds(productInfo.purchaseTime);
        ci.j = bi;
        if (productInfo.type == ProductType.SUBS) {
            Ai ai = new Ai();
            ai.f11061a = productInfo.autoRenewing;
            Period period = productInfo.subscriptionPeriod;
            if (period != null) {
                C4619zi c4619zi = new C4619zi();
                c4619zi.f11880a = period.number;
                int i3 = AbstractC4441sf.b[period.timeUnit.ordinal()];
                if (i3 == 1) {
                    i = 1;
                } else if (i3 == 2) {
                    i = 2;
                } else if (i3 != 3) {
                    i = i3 != 4 ? 0 : 4;
                } else {
                    i = 3;
                }
                c4619zi.b = i;
                ai.b = c4619zi;
            }
            C4594yi c4594yi = new C4594yi();
            c4594yi.f11862a = productInfo.introductoryPriceMicros;
            Period period2 = productInfo.introductoryPricePeriod;
            if (period2 != null) {
                C4619zi c4619zi2 = new C4619zi();
                c4619zi2.f11880a = period2.number;
                int i4 = AbstractC4441sf.b[period2.timeUnit.ordinal()];
                if (i4 == 1) {
                    i2 = 1;
                } else if (i4 == 2) {
                    i2 = 2;
                } else if (i4 == 3) {
                    i2 = 3;
                } else if (i4 == 4) {
                    i2 = 4;
                }
                c4619zi2.b = i2;
                c4594yi.b = c4619zi2;
            }
            c4594yi.c = productInfo.introductoryPriceCycles;
            ai.c = c4594yi;
            ci.k = ai;
        }
        c3984a6.setValueBytes(MessageNano.toByteArray(ci));
        return c3984a6;
    }

    public static C3984a6 a(String str) {
        C3984a6 c3984a6 = new C3984a6("", 0);
        EnumC4164hb enumC4164hb = EnumC4164hb.EVENT_TYPE_UNDEFINED;
        c3984a6.d = 12320;
        c3984a6.b = str;
        c3984a6.l = EnumC4435s9.JS;
        return c3984a6;
    }
}
