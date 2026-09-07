package com.json;

import com.amazon.aps.shared.metrics.model.ApsMetricsDataMap;
import com.json.mediationsdk.impressionData.ImpressionData;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.unity3d.mediation.LevelPlay;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0015\u001a\u00020\u0013\u0012\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00170\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ(\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002J(\u0010\f\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002J(\u0010\r\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002J8\u0010\f\u001a\u00020\n2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\n0\u000e2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0010H\u0002ø\u0001\u0000¢\u0006\u0004\b\f\u0010\u0012J\u000e\u0010\f\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\u0015\u001a\u00020\u00138\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\u0014R \u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00170\u00168\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\u0018\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u001c"}, d2 = {"Lcom/ironsource/np;", "", "Lcom/ironsource/zf$a;", "cappingService", "", "placementName", "Lcom/unity3d/mediation/LevelPlay$AdFormat;", ImpressionData.IMPRESSION_DATA_KEY_AD_FORMAT, "Lcom/ironsource/t$d;", "features", "", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "a", ApsMetricsDataMap.APSMETRICS_FIELD_CUSTOM, "Lkotlin/Result;", "result", "Lcom/ironsource/n8;", "cappingType", "(Ljava/lang/Object;Ljava/lang/String;Lcom/unity3d/mediation/LevelPlay$AdFormat;Lcom/ironsource/n8;)V", "Lcom/ironsource/vl;", "Lcom/ironsource/vl;", "tools", "", "Lcom/ironsource/t;", "Ljava/util/Map;", "adFormatsConfigurations", "<init>", "(Lcom/ironsource/vl;Ljava/util/Map;)V", "mediationsdk_release"}, k = 1, mv = {1, 8, 0})
public final class np {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final vl tools;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    private final Map<LevelPlay.AdFormat, t> adFormatsConfigurations;

    public np(vl tools, Map<LevelPlay.AdFormat, t> adFormatsConfigurations) {
        Intrinsics.checkNotNullParameter(tools, "tools");
        Intrinsics.checkNotNullParameter(adFormatsConfigurations, "adFormatsConfigurations");
        this.tools = tools;
        this.adFormatsConfigurations = adFormatsConfigurations;
    }

    private final void a(zf.a cappingService, String placementName, LevelPlay.AdFormat adFormat, t.d features) throws JSONException {
        h8 h8VarB = features.getCom.ironsource.t.e java.lang.String();
        if (h8VarB != null) {
            n8 n8Var = n8.ShowCount;
            a(cappingService.a(placementName, adFormat, n8Var, new e8(h8VarB.getEnabled(), h8VarB.getMaxImpressions(), h8VarB.getUnit())), placementName, adFormat, n8Var);
        }
    }

    private final void a(Object result, String placementName, LevelPlay.AdFormat adFormat, n8 cappingType) throws JSONException {
        Throwable thM7907exceptionOrNullimpl = Result.m7907exceptionOrNullimpl(result);
        if (thM7907exceptionOrNullimpl != null) {
            this.tools.a(placementName, adFormat, new i8().a(cappingType), thM7907exceptionOrNullimpl.getMessage());
        }
    }

    private final void b(zf.a cappingService, String placementName, LevelPlay.AdFormat adFormat, t.d features) throws JSONException {
        n8 n8Var = n8.Delivery;
        oa oaVarC = features.getDelivery();
        a(cappingService.a(placementName, adFormat, n8Var, new e8(oaVarC != null ? Boolean.valueOf(oaVarC.getEnabled()) : null, null, null, 6, null)), placementName, adFormat, n8Var);
    }

    private final void c(zf.a cappingService, String placementName, LevelPlay.AdFormat adFormat, t.d features) throws JSONException {
        cp cpVarE = features.getPacing();
        if (cpVarE != null) {
            n8 n8Var = n8.Pacing;
            a(cappingService.a(placementName, adFormat, n8Var, new e8(cpVarE.getEnabled(), cpVarE.getNumOfSeconds(), m8.Second)), placementName, adFormat, n8Var);
        }
    }

    public final void a(zf.a cappingService) {
        Intrinsics.checkNotNullParameter(cappingService, "cappingService");
        for (Map.Entry<LevelPlay.AdFormat, t> entry : this.adFormatsConfigurations.entrySet()) {
            LevelPlay.AdFormat key = entry.getKey();
            for (Map.Entry<String, t.d> entry2 : entry.getValue().c().entrySet()) {
                String key2 = entry2.getKey();
                t.d value = entry2.getValue();
                b(cappingService, key2, key, value);
                a(cappingService, key2, key, value);
                c(cappingService, key2, key, value);
            }
        }
    }
}
