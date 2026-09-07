package com.five_corp.ad.internal;

import android.graphics.Rect;
import android.net.Uri;
import android.util.Base64;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.amazon.aps.shared.metrics.model.ApsMetricsDataMap;
import com.five_corp.ad.BuildConfig;
import com.five_corp.ad.CreativeType;
import com.five_corp.ad.FiveAdConfig;
import com.five_corp.ad.FiveAdFormat;
import com.pubmatic.sdk.openwrap.core.POBConstants;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes10.dex */
public final class z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.five_corp.ad.internal.base_url.a f1594a;
    public final C b;
    public final FiveAdConfig c;
    public final E d;
    public final com.five_corp.ad.internal.context.n e;
    public final com.five_corp.ad.internal.tracking_data.b f;

    static {
        z.class.toString();
    }

    public z(com.five_corp.ad.internal.base_url.a aVar, C c, FiveAdConfig fiveAdConfig, E e, com.five_corp.ad.internal.time.a aVar2, com.five_corp.ad.internal.context.n nVar, com.five_corp.ad.internal.tracking_data.b bVar) {
        this.f1594a = aVar;
        this.b = c;
        this.c = fiveAdConfig;
        this.d = e;
        this.e = nVar;
        this.f = bVar;
    }

    public final void a(HashMap map, com.five_corp.ad.internal.tracking_data.a aVar) {
        map.put("dt", "Android");
        map.put("dv", this.b.f1263a);
        map.put("sv", String.valueOf(BuildConfig.SEMVER_PATCH));
        map.put("s", this.b.e);
        map.put("i", this.c.appId);
        map.put("pv", this.b.f);
        map.put("sui", this.d.b);
        String str = aVar.f1552a;
        if (str != null) {
            map.put("ty", str);
        }
        map.put("nt", aVar.b ? "1" : "0");
        if (this.c.isTest) {
            map.put(POBConstants.TEST_MODE, "1");
        }
        map.put("ngnpa", String.valueOf(this.c.getNeedGdprNonPersonalizedAdsTreatment().value));
        map.put("ncd", String.valueOf(this.c.getNeedChildDirectedTreatment().value));
        map.put("maar", String.valueOf(this.c.getFiveAdAgeRating().value));
    }

    public final String b(com.five_corp.ad.internal.context.m mVar) {
        HashMap map = new HashMap();
        map.put("dv", this.b.f1263a);
        map.put("sv", String.valueOf(BuildConfig.SEMVER_PATCH));
        map.put("pv", this.b.f);
        map.put("s", this.b.e);
        map.put("i", this.c.appId);
        map.put("sl", mVar.b.f1370a.b);
        map.put("dt", "Android");
        com.five_corp.ad.internal.tracking_data.a aVar = mVar.b.d;
        map.put("nt", aVar.b ? "1" : "0");
        String str = aVar.f1552a;
        if (str != null) {
            map.put("ty", str);
        }
        if (this.c.isTest) {
            map.put(POBConstants.TEST_MODE, "1");
        }
        return a(new Uri.Builder().scheme("https").authority(this.f1594a.f1318a), "/v1/chk", map);
    }

    public static String a(Uri.Builder builder, String str, HashMap map) {
        builder.path(str);
        for (Map.Entry entry : map.entrySet()) {
            builder.appendQueryParameter((String) entry.getKey(), (String) entry.getValue());
        }
        return builder.toString();
    }

    /* JADX WARN: Code duplicated, block: B:79:0x0223  */
    /* JADX WARN: Code duplicated, block: B:82:0x022d A[LOOP:2: B:80:0x0227->B:82:0x022d, LOOP_END] */
    public final String a(com.five_corp.ad.internal.beacon.a aVar) {
        FiveAdFormat fiveAdFormat;
        com.five_corp.ad.internal.ad.beacon.f fVar;
        List<com.five_corp.ad.internal.ad.beacon.g> list;
        com.five_corp.ad.internal.ad.beacon.f fVar2;
        com.five_corp.ad.internal.ad.a aVar2 = aVar.c;
        long j = aVar.i;
        com.five_corp.ad.internal.context.i iVar = aVar.f1319a;
        String str = iVar.b;
        int i = aVar.e;
        com.five_corp.ad.internal.ad.beacon.a aVar3 = aVar.k;
        HashMap map = new HashMap();
        a(map, aVar.d);
        map.put("ld", iVar.f1361a);
        map.put("sl", iVar.b);
        int iOrdinal = aVar.b.ordinal();
        if (iOrdinal == 0 || iOrdinal == 1) {
            fiveAdFormat = FiveAdFormat.CUSTOM_LAYOUT;
        } else {
            if (iOrdinal != 2 && iOrdinal != 3) {
                throw new RuntimeException();
            }
            fiveAdFormat = FiveAdFormat.VIDEO_REWARD;
        }
        map.put(ApsMetricsDataMap.APSMETRICS_FIELD_ADFORMAT, String.valueOf(fiveAdFormat.rawValue));
        if (aVar.b == com.five_corp.ad.internal.context.h.NATIVE) {
            map.put("isnt", "1");
        }
        map.put(ApsMetricsDataMap.APSMETRICS_FIELD_TIMESTAMP, aVar2.b);
        map.put(POBConstants.KEY_AT, String.valueOf(aVar2.c));
        map.put("a", String.valueOf(aVar2.d.f1274a));
        map.put("av", String.valueOf(aVar2.d.b));
        map.put(ApsMetricsDataMap.APSMETRICS_FIELD_CUSTOM, String.valueOf(aVar2.d.c));
        map.put("ss", aVar.f.a() ? "1" : "0");
        map.put("pt", String.valueOf(aVar.h));
        map.put("it", String.valueOf(j));
        map.put("ct", String.valueOf(aVar2.f1266a.value));
        map.put("tp", String.valueOf(com.five_corp.ad.internal.ad.beacon.b.a(i)));
        map.put("spt", String.valueOf(aVar.g.f1322a));
        com.five_corp.ad.internal.ad.format_config.a aVarA = com.five_corp.ad.internal.ad.a.a(aVar2, str);
        if (aVarA != null) {
            map.put("sti", String.valueOf(aVarA.f1289a));
        }
        double d = aVar.j;
        if (d >= 0.0d) {
            map.put("mvar", String.format(Locale.US, "%.3f", Double.valueOf(d)));
        }
        map.put("chk", "1");
        String str2 = aVar2.C;
        if (str2 != null) {
            map.put("ext", str2);
        }
        if (aVar3 != null) {
            map.put("clkt", String.valueOf(com.five_corp.ad.internal.ad.beacon.c.a(aVar3.f1268a)));
            map.put("vims", String.valueOf(com.five_corp.ad.internal.ad.beacon.h.a(aVar3.b)));
            map.put("tms", String.valueOf(aVar3.c));
            if (aVar3.f1268a == 2) {
                map.put("ar", String.valueOf(aVar3.d.b));
                map.put("vct", String.valueOf(com.five_corp.ad.internal.ad.beacon.i.a(aVar3.d.f1273a)));
            }
        }
        if (aVar2.f1266a == CreativeType.MOVIE) {
            map.put("vsar", String.format(Locale.US, "%.3f", Double.valueOf(aVar2.y.b)));
            map.put("vvct", String.valueOf(com.five_corp.ad.internal.ad.beacon.i.a(aVar2.y.f1273a)));
        }
        if (i == 3 && aVar.m) {
            map.put("bc", "1");
        }
        Map map2 = aVar.l;
        if (map2 != null) {
            for (Map.Entry entry : map2.entrySet()) {
                map.put((String) entry.getKey(), (String) entry.getValue());
            }
        }
        int iA = com.five_corp.ad.e.a(i);
        if (iA != 0) {
            if (iA != 13) {
                list = null;
                if (aVar3 != null) {
                    ArrayList arrayList = aVar2.B;
                    if (arrayList == null) {
                        fVar2 = null;
                        break;
                    }
                    Iterator it = arrayList.iterator();
                    do {
                        if (!it.hasNext()) {
                            fVar2 = null;
                            break;
                        }
                        fVar2 = (com.five_corp.ad.internal.ad.beacon.f) it.next();
                    } while (!aVar3.equals(fVar2.b));
                    if (fVar2 != null) {
                        list = fVar2.c;
                    }
                } else {
                    ArrayList<com.five_corp.ad.internal.ad.beacon.f> arrayList2 = aVar2.B;
                    if (arrayList2 != null) {
                        for (com.five_corp.ad.internal.ad.beacon.f fVar3 : arrayList2) {
                            if (fVar3.f1271a == i) {
                                list = fVar3.c;
                                break;
                            }
                        }
                    }
                }
            } else {
                fVar = aVar2.A;
            }
            if (list != null) {
                for (com.five_corp.ad.internal.ad.beacon.g gVar : list) {
                    map.put(gVar.f1272a, gVar.b);
                }
            }
            return a(new Uri.Builder().scheme("https").authority(this.f1594a.b), "bc", map);
        }
        fVar = aVar2.z;
        list = fVar.c;
        if (list != null) {
            while (r15.hasNext()) {
                map.put(gVar.f1272a, gVar.b);
            }
        }
        return a(new Uri.Builder().scheme("https").authority(this.f1594a.b), "bc", map);
    }

    public final JSONObject a(com.five_corp.ad.internal.context.m mVar) throws JSONException {
        FiveAdFormat fiveAdFormat;
        com.five_corp.ad.internal.context.o oVarA = this.e.a();
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("hw", this.b.b);
        jSONObject.put("make", this.b.c);
        jSONObject.put("l", Locale.getDefault().toString());
        jSONObject.put("ngnpa", this.c.getNeedGdprNonPersonalizedAdsTreatment().value);
        jSONObject.put("ncd", this.c.getNeedChildDirectedTreatment().value);
        jSONObject.put("maar", this.c.getFiveAdAgeRating().value);
        Rect rectB = this.d.b();
        jSONObject.put("sw", rectB.width());
        jSONObject.put(com.mbridge.msdk.foundation.entity.b.JSON_KEY_SH, rectB.height());
        WindowManager windowManager = (WindowManager) this.d.f1264a.getSystemService("window");
        DisplayMetrics displayMetrics = new DisplayMetrics();
        windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        jSONObject.put("dpr", (long) (((double) displayMetrics.density) * 1000000.0d));
        jSONObject.put("cr", this.b.d);
        jSONObject.put("nexp", oVarA.f1367a);
        jSONObject.put("ssa", com.five_corp.ad.e.a(mVar.c.b));
        jSONObject.put("ssm", com.five_corp.ad.e.a(mVar.c.d.f1523a));
        jSONObject.put("rt", mVar.d);
        int iOrdinal = mVar.f1365a.ordinal();
        if (iOrdinal == 0 || iOrdinal == 1) {
            fiveAdFormat = FiveAdFormat.CUSTOM_LAYOUT;
        } else {
            if (iOrdinal != 2 && iOrdinal != 3) {
                throw new RuntimeException();
            }
            fiveAdFormat = FiveAdFormat.VIDEO_REWARD;
        }
        jSONObject.put(ApsMetricsDataMap.APSMETRICS_FIELD_ADFORMAT, fiveAdFormat.rawValue);
        jSONObject.put("ld", mVar.b.f1370a.f1361a);
        jSONObject.put("isnt", mVar.f1365a == com.five_corp.ad.internal.context.h.NATIVE);
        jSONObject.put("sui", this.d.b);
        return jSONObject;
    }

    public final JSONObject a(com.five_corp.ad.internal.context.a aVar) throws JSONException {
        com.five_corp.ad.internal.context.o oVarA = this.e.a();
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("hw", this.b.b);
        jSONObject.put("make", this.b.c);
        jSONObject.put("l", Locale.getDefault().toString());
        jSONObject.put("ngnpa", this.c.getNeedGdprNonPersonalizedAdsTreatment().value);
        jSONObject.put("ncd", this.c.getNeedChildDirectedTreatment().value);
        jSONObject.put("maar", this.c.getFiveAdAgeRating().value);
        Rect rectB = this.d.b();
        jSONObject.put("sw", rectB.width());
        jSONObject.put(com.mbridge.msdk.foundation.entity.b.JSON_KEY_SH, rectB.height());
        WindowManager windowManager = (WindowManager) this.d.f1264a.getSystemService("window");
        DisplayMetrics displayMetrics = new DisplayMetrics();
        windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        jSONObject.put("dpr", (long) (((double) displayMetrics.density) * 1000000.0d));
        jSONObject.put("cr", this.b.d);
        jSONObject.put("ft", 0);
        jSONObject.put("nexp", oVarA.f1367a);
        jSONObject.put("ssm", com.five_corp.ad.e.a(aVar.f1356a.f1523a));
        jSONObject.put("rt", aVar.c);
        jSONObject.put("sui", this.d.b);
        int i = aVar.b;
        int i2 = 1;
        if (i != 1) {
            i2 = 2;
            if (i != 2) {
                i2 = 3;
                if (i != 3) {
                    i2 = 4;
                    if (i != 4) {
                        throw null;
                    }
                }
            }
        }
        jSONObject.put("arrs", i2);
        return jSONObject;
    }

    public final com.five_corp.ad.internal.util.f a(com.five_corp.ad.internal.context.i iVar, com.five_corp.ad.internal.tracking_data.a aVar, com.five_corp.ad.internal.soundstate.d dVar) {
        com.five_corp.ad.internal.context.o oVarA = this.e.a();
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("dt", "Android");
            jSONObject.put("sv", String.valueOf(BuildConfig.SEMVER_PATCH));
            jSONObject.put("dv", this.b.f1263a);
            jSONObject.put("pv", this.b.f);
            jSONObject.put("s", this.b.e);
            jSONObject.put("i", this.c.appId);
            jSONObject.put("hw", this.b.b);
            jSONObject.put("cr", this.b.d);
            jSONObject.put("l", Locale.getDefault().toString());
            Rect rectB = this.d.b();
            jSONObject.put("sw", rectB.width());
            jSONObject.put(com.mbridge.msdk.foundation.entity.b.JSON_KEY_SH, rectB.height());
            jSONObject.put("sui", this.d.b);
            String str = "1";
            if (this.c.isTest) {
                jSONObject.put(POBConstants.TEST_MODE, "1");
            }
            String str2 = aVar.f1552a;
            if (str2 != null) {
                jSONObject.put("ty", str2);
            }
            if (!aVar.b) {
                str = "0";
            }
            jSONObject.put("nt", str);
            jSONObject.put("ngnpa", this.c.getNeedGdprNonPersonalizedAdsTreatment().value);
            jSONObject.put("ncd", this.c.getNeedChildDirectedTreatment().value);
            jSONObject.put("maar", this.c.getFiveAdAgeRating().value);
            jSONObject.put("sl", iVar.b);
            jSONObject.put("ld", iVar.f1361a);
            jSONObject.put("ssm", com.five_corp.ad.e.a(dVar.f1523a));
            jSONObject.put("nexp", oVarA.f1367a);
            return new com.five_corp.ad.internal.util.f(true, null, "v1:".concat(new String(Base64.encode(jSONObject.toString().getBytes(StandardCharsets.UTF_8), 2))));
        } catch (JSONException e) {
            return new com.five_corp.ad.internal.util.f(false, new o(p.K5, null, e, null), null);
        }
    }
}
