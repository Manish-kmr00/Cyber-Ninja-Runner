package com.five_corp.ad.internal;

import android.net.Uri;
import com.five_corp.ad.BuildConfig;
import com.pubmatic.sdk.openwrap.core.POBConstants;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes10.dex */
public final class h extends com.five_corp.ad.internal.bgtask.m {
    public final com.five_corp.ad.internal.context.g c;
    public int d;
    public final z e;
    public final com.five_corp.ad.internal.cache.w f;
    public final com.five_corp.ad.internal.http.d g;
    public final l h;

    public h(com.five_corp.ad.internal.context.g gVar, z zVar, com.five_corp.ad.internal.cache.w wVar, com.five_corp.ad.internal.http.d dVar, l lVar, int i, j jVar) {
        super(jVar);
        this.c = gVar;
        this.e = zVar;
        this.f = wVar;
        this.g = dVar;
        this.h = lVar;
        this.d = i;
    }

    /* JADX WARN: Code duplicated, block: B:54:0x017b  */
    @Override // com.five_corp.ad.internal.bgtask.m
    public final boolean b() {
        com.five_corp.ad.internal.util.g gVar;
        com.five_corp.ad.internal.util.g gVar2;
        long j;
        com.five_corp.ad.internal.util.f fVar;
        com.five_corp.ad.internal.util.g gVar3;
        p pVar;
        for (int i = 0; i < 2; i++) {
            com.five_corp.ad.internal.context.g gVar4 = this.c;
            int i2 = this.d;
            gVar4.b.b();
            com.five_corp.ad.internal.context.a aVar = new com.five_corp.ad.internal.context.a(gVar4.e.a(), i2, System.currentTimeMillis());
            z zVar = this.e;
            HashMap map = new HashMap();
            map.put("dt", "Android");
            map.put("sv", String.valueOf(BuildConfig.SEMVER_PATCH));
            map.put("s", zVar.b.e);
            map.put("i", zVar.c.appId);
            map.put("pv", zVar.b.f);
            com.five_corp.ad.internal.tracking_data.a aVarA = zVar.f.a();
            String str = aVarA.f1552a;
            if (str != null) {
                map.put("ty", str);
            }
            map.put("nt", aVarA.b ? "1" : "0");
            map.put("dv", zVar.b.f1263a);
            if (zVar.c.isTest) {
                map.put(POBConstants.TEST_MODE, "1");
            }
            try {
                com.five_corp.ad.internal.util.f fVarA = this.g.a(z.a(new Uri.Builder().scheme("https").authority("ad2.fivecdm.com"), "v1/ad", map), "POST", this.e.a(aVar).toString(), "application/json;charset=utf-8");
                if (fVarA.f1560a) {
                    com.five_corp.ad.internal.http.c cVar = (com.five_corp.ad.internal.http.c) fVarA.c;
                    int i3 = cVar.f1392a;
                    if (i3 == 403) {
                        pVar = p.e;
                    } else {
                        int i4 = i3 / 100;
                        if (i4 == 5) {
                            pVar = p.s;
                        } else if (i4 == 4) {
                            pVar = p.p;
                        } else {
                            String strA = cVar.a();
                            if (strA == null) {
                                pVar = p.r;
                            } else if (strA.isEmpty()) {
                                pVar = p.u;
                            } else {
                                try {
                                    i iVarA = com.five_corp.ad.internal.parser.c.a(strA);
                                    com.five_corp.ad.internal.cache.w wVar = this.f;
                                    com.five_corp.ad.internal.media_config.a aVar2 = iVarA.f1410a;
                                    wVar.f1354a.a(new com.five_corp.ad.internal.cache.u(wVar, aVar2));
                                    long jCurrentTimeMillis = System.currentTimeMillis();
                                    synchronized (wVar.e) {
                                        j = wVar.f;
                                        wVar.f = jCurrentTimeMillis;
                                    }
                                    r rVar = wVar.b;
                                    try {
                                        JSONObject jSONObject = new JSONObject();
                                        jSONObject.put("mcfg", new JSONObject(aVar2.f1423a));
                                        fVar = new com.five_corp.ad.internal.util.f(true, null, jSONObject.toString());
                                    } catch (JSONException e) {
                                        fVar = new com.five_corp.ad.internal.util.f(false, new o(p.x3, "failed to serialize AdConfig", e, null), null);
                                    }
                                    if (fVar.f1560a) {
                                        byte[] bytes = ((String) fVar.c).getBytes();
                                        String strA2 = r.a(jCurrentTimeMillis);
                                        if (!rVar.a(strA2, bytes).f1560a) {
                                            rVar.a(strA2);
                                        } else if (!rVar.a(strA2 + "_SUCCESS", new byte[0]).f1560a) {
                                            rVar.a(strA2);
                                        }
                                        gVar3 = new com.five_corp.ad.internal.util.g(true, null);
                                    } else {
                                        gVar3 = new com.five_corp.ad.internal.util.g(false, fVar.b);
                                    }
                                    if (gVar3.f1560a) {
                                        wVar.b.a(r.a(j));
                                        gVar3 = new com.five_corp.ad.internal.util.g(true, null);
                                    }
                                    if (gVar3.f1560a) {
                                        HashSet hashSet = new HashSet();
                                        Iterator it = wVar.f1354a.a().iterator();
                                        while (it.hasNext()) {
                                            hashSet.addAll(((com.five_corp.ad.internal.cache.x) it.next()).f1355a.f1265a);
                                        }
                                        HashSet hashSet2 = new HashSet();
                                        Iterator it2 = hashSet.iterator();
                                        while (it2.hasNext()) {
                                            hashSet2.addAll(((com.five_corp.ad.internal.ad.a) it2.next()).D);
                                        }
                                        wVar.c.a(hashSet2);
                                        gVar = new com.five_corp.ad.internal.util.g(true, null);
                                        gVar2 = gVar;
                                    } else {
                                        gVar2 = new com.five_corp.ad.internal.util.g(false, gVar3.b);
                                    }
                                } catch (com.five_corp.ad.internal.exception.b e2) {
                                    e2.toString();
                                    gVar = new com.five_corp.ad.internal.util.g(false, new o(e2.f1373a, null, e2, null));
                                } catch (JSONException e3) {
                                    e3.toString();
                                    gVar = new com.five_corp.ad.internal.util.g(false, new o(p.r, null, e3, null));
                                }
                            }
                        }
                    }
                    gVar2 = com.five_corp.ad.internal.util.g.a(pVar);
                } else {
                    gVar2 = new com.five_corp.ad.internal.util.g(false, fVarA.b);
                }
            } catch (JSONException e4) {
                gVar = new com.five_corp.ad.internal.util.g(false, new o(p.Z5, null, e4, null));
            }
            if (gVar2.f1560a) {
                return true;
            }
            this.h.a(gVar2.b);
            this.d = 2;
        }
        return false;
    }
}
