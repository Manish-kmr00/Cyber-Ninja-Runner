package com.json;

import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.unity3d.mediation.LevelPlay;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0012\u001a\u00020\u0010\u0012\u0012\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00150\u0013¢\u0006\u0004\b\u0018\u0010\u0019J \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J \u0010\n\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J0\u0010\t\u001a\u00020\b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\b0\u000b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rH\u0002ø\u0001\u0000¢\u0006\u0004\b\t\u0010\u000fJ\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R\u0014\u0010\u0012\u001a\u00020\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\u0011R \u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00150\u00138\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u0016\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u001a"}, d2 = {"Lcom/ironsource/u1;", "Lcom/ironsource/k8;", "Lcom/ironsource/ff$a;", "cappingService", "", "adUnitId", "Lcom/ironsource/t$d;", "features", "", "a", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "Lkotlin/Result;", "result", "Lcom/ironsource/n8;", "cappingType", "(Ljava/lang/Object;Ljava/lang/String;Lcom/ironsource/n8;)V", "Lcom/ironsource/vl;", "Lcom/ironsource/vl;", "tools", "", "Lcom/unity3d/mediation/LevelPlay$AdFormat;", "Lcom/ironsource/t;", "Ljava/util/Map;", "adFormatsConfigurations", "<init>", "(Lcom/ironsource/vl;Ljava/util/Map;)V", "mediationsdk_release"}, k = 1, mv = {1, 8, 0})
public final class u1 implements k8 {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final vl tools;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    private final Map<LevelPlay.AdFormat, t> adFormatsConfigurations;

    public u1(vl tools, Map<LevelPlay.AdFormat, t> adFormatsConfigurations) {
        Intrinsics.checkNotNullParameter(tools, "tools");
        Intrinsics.checkNotNullParameter(adFormatsConfigurations, "adFormatsConfigurations");
        this.tools = tools;
        this.adFormatsConfigurations = adFormatsConfigurations;
    }

    private final void a(ff.a cappingService, String adUnitId, t.d features) throws JSONException {
        h8 capping = features.getCom.ironsource.t.e java.lang.String();
        if (capping != null) {
            n8 n8Var = n8.ShowCount;
            a(cappingService.a(adUnitId, n8Var, new e8(capping.getEnabled(), capping.getMaxImpressions(), capping.getUnit())), adUnitId, n8Var);
        }
    }

    private final void a(Object result, String adUnitId, n8 cappingType) throws JSONException {
        Throwable thM7907exceptionOrNullimpl = Result.m7907exceptionOrNullimpl(result);
        if (thM7907exceptionOrNullimpl != null) {
            this.tools.a(adUnitId, new i8().a(cappingType), thM7907exceptionOrNullimpl.getMessage());
        }
    }

    private final void b(ff.a cappingService, String adUnitId, t.d features) throws JSONException {
        cp pacing = features.getPacing();
        if (pacing != null) {
            n8 n8Var = n8.Pacing;
            a(cappingService.a(adUnitId, n8Var, new e8(pacing.getEnabled(), pacing.getNumOfSeconds(), pacing.getUnit())), adUnitId, n8Var);
        }
    }

    @Override // com.json.k8
    public void a(ff.a cappingService) {
        Intrinsics.checkNotNullParameter(cappingService, "cappingService");
        Iterator<Map.Entry<LevelPlay.AdFormat, t>> it = this.adFormatsConfigurations.entrySet().iterator();
        while (it.hasNext()) {
            for (Map.Entry<String, t.d> entry : it.next().getValue().a().entrySet()) {
                String key = entry.getKey();
                t.d value = entry.getValue();
                a(cappingService, key, value);
                b(cappingService, key, value);
            }
        }
    }
}
