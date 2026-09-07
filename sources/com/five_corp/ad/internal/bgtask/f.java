package com.five_corp.ad.internal.bgtask;

import android.net.Uri;
import androidx.core.app.NotificationCompat;
import com.amazon.aps.shared.metrics.model.ApsMetricsDataMap;
import com.five_corp.ad.FiveAdFormat;
import com.five_corp.ad.internal.o;
import com.five_corp.ad.internal.p;
import com.five_corp.ad.internal.z;
import com.pubmatic.sdk.openwrap.core.POBConstants;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
import java.util.ArrayList;
import java.util.HashMap;

/* JADX INFO: loaded from: classes12.dex */
public final class f extends m {
    public final com.five_corp.ad.internal.beacon.b c;
    public final z d;
    public final com.five_corp.ad.internal.http.d e;

    public f(com.five_corp.ad.internal.beacon.b bVar, z zVar, com.five_corp.ad.internal.http.d dVar) {
        super(4);
        this.c = bVar;
        this.d = zVar;
        this.e = dVar;
    }

    @Override // com.five_corp.ad.internal.bgtask.m
    public final boolean b() {
        FiveAdFormat fiveAdFormat;
        z zVar = this.d;
        com.five_corp.ad.internal.beacon.b bVar = this.c;
        com.five_corp.ad.internal.ad.a aVar = bVar.f1320a;
        Long l = bVar.g;
        HashMap map = new HashMap();
        zVar.a(map, zVar.f.a());
        com.five_corp.ad.internal.context.i iVar = bVar.b;
        if (iVar != null) {
            map.put("ld", iVar.f1361a);
            map.put("sl", iVar.b);
        }
        int iOrdinal = bVar.c.ordinal();
        if (iOrdinal == 0 || iOrdinal == 1) {
            fiveAdFormat = FiveAdFormat.CUSTOM_LAYOUT;
        } else {
            if (iOrdinal != 2 && iOrdinal != 3) {
                throw new RuntimeException();
            }
            fiveAdFormat = FiveAdFormat.VIDEO_REWARD;
        }
        map.put(ApsMetricsDataMap.APSMETRICS_FIELD_ADFORMAT, String.valueOf(fiveAdFormat.rawValue));
        if (bVar.c == com.five_corp.ad.internal.context.h.NATIVE) {
            map.put("isnt", "1");
        }
        map.put("ss", bVar.e.a() ? "1" : "0");
        o oVar = bVar.d;
        p pVar = oVar.f1517a;
        map.put(ApsMetricsDataMap.APSMETRICS_FIELD_CUSTOM, String.valueOf(oVar.a().value));
        map.put("dc", String.valueOf(pVar.f1518a));
        o oVar2 = bVar.d;
        oVar2.getClass();
        ArrayList arrayList = new ArrayList();
        for (o oVar3 = oVar2.d; oVar3 != null; oVar3 = oVar3.d) {
            arrayList.add(Integer.valueOf(oVar3.f1517a.f1518a));
        }
        if (!arrayList.isEmpty()) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(arrayList.get(0));
            for (int i = 1; i < arrayList.size(); i++) {
                stringBuffer.append(StringUtils.COMMA);
                stringBuffer.append(arrayList.get(i));
            }
            map.put("cause", stringBuffer.toString());
        }
        if (aVar != null) {
            map.put(ApsMetricsDataMap.APSMETRICS_FIELD_TIMESTAMP, aVar.b);
            map.put(POBConstants.KEY_AT, String.valueOf(aVar.c));
            map.put("a", String.valueOf(aVar.d.f1274a));
            map.put("av", String.valueOf(aVar.d.b));
            map.put("cr", String.valueOf(aVar.d.c));
        }
        map.put("pt", String.valueOf(bVar.f));
        if (l != null) {
            map.put("it", String.valueOf(l));
        }
        map.put("chk", "1");
        com.five_corp.ad.internal.beacon.e eVar = bVar.h;
        if (eVar != null) {
            map.put("spt", String.valueOf(eVar.f1322a));
        }
        com.five_corp.ad.internal.util.f fVarA = this.e.a(z.a(new Uri.Builder().scheme("https").authority(zVar.f1594a.c), NotificationCompat.CATEGORY_ERROR, map), "POST", this.c.d.b(), null);
        return fVarA.f1560a && ((com.five_corp.ad.internal.http.c) fVarA.c).f1392a == 200;
    }
}
