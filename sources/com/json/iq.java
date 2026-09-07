package com.json;

import com.amazon.aps.shared.metrics.model.ApsMetricsDataMap;
import com.json.mediationsdk.utils.IronSourceConstants;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B;\u0012\u0006\u0010\u0013\u001a\u00020\u0011\u0012\u0014\u0010\u0017\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0014\u0012\u0014\u0010\u0019\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0014¢\u0006\u0004\b\u001a\u0010\u001bJ3\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0002¢\u0006\u0004\b\n\u0010\u000bJ3\u0010\f\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0002¢\u0006\u0004\b\f\u0010\u000bJ2\u0010\f\u001a\b\u0012\u0004\u0012\u00020\t0\u000f2\b\u0010\r\u001a\u0004\u0018\u00010\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\u0007H\u0002ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\b\f\u0010\u0010J\u000e\u0010\f\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\u0013\u001a\u00020\u00118\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\u0012R\"\u0010\u0017\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u00148\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u0016R\"\u0010\u0019\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u00148\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0016\u0082\u0002\u000f\n\u0002\b!\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\u001c"}, d2 = {"Lcom/ironsource/iq;", "", "Lcom/ironsource/eg$a;", "rewardService", "", "identifier", IronSourceConstants.EVENTS_REWARD_NAME, "", IronSourceConstants.EVENTS_REWARD_AMOUNT, "", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "(Lcom/ironsource/eg$a;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)V", "a", "name", "amount", "Lkotlin/Result;", "(Ljava/lang/String;Ljava/lang/Integer;)Ljava/lang/Object;", "Lcom/ironsource/vl;", "Lcom/ironsource/vl;", "tools", "", "Lcom/ironsource/t$d;", "Ljava/util/Map;", y2.c, ApsMetricsDataMap.APSMETRICS_FIELD_CUSTOM, sp.c, "<init>", "(Lcom/ironsource/vl;Ljava/util/Map;Ljava/util/Map;)V", "mediationsdk_release"}, k = 1, mv = {1, 8, 0})
public final class iq {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final vl tools;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    private final Map<String, t.d> adUnits;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    private final Map<String, t.d> placements;

    public iq(vl tools, Map<String, t.d> map, Map<String, t.d> map2) {
        Intrinsics.checkNotNullParameter(tools, "tools");
        this.tools = tools;
        this.adUnits = map;
        this.placements = map2;
    }

    private final Object a(String name, Integer amount) {
        Object objCreateFailure;
        if (name == null || amount == null) {
            Result.Companion companion = Result.INSTANCE;
            objCreateFailure = ResultKt.createFailure(new Exception("name - " + name + " or amount - " + amount + " is not provided or invalid"));
        } else {
            Result.Companion companion2 = Result.INSTANCE;
            objCreateFailure = Unit.INSTANCE;
        }
        return Result.m7904constructorimpl(objCreateFailure);
    }

    private final void a(eg.a rewardService, String identifier, String rewardName, Integer rewardAmount) throws JSONException {
        Object objA = a(rewardName, rewardAmount);
        if (Result.m7911isSuccessimpl(objA)) {
            Intrinsics.checkNotNull(rewardName);
            Intrinsics.checkNotNull(rewardAmount);
            rewardService.b(identifier, rewardName, rewardAmount.intValue());
        }
        Throwable thM7907exceptionOrNullimpl = Result.m7907exceptionOrNullimpl(objA);
        if (thM7907exceptionOrNullimpl != null) {
            this.tools.b(identifier, 3004, thM7907exceptionOrNullimpl.getMessage());
        }
    }

    private final void b(eg.a rewardService, String identifier, String rewardName, Integer rewardAmount) throws JSONException {
        Object objA = a(rewardName, rewardAmount);
        if (Result.m7911isSuccessimpl(objA)) {
            Intrinsics.checkNotNull(rewardName);
            Intrinsics.checkNotNull(rewardAmount);
            rewardService.a(identifier, rewardName, rewardAmount.intValue());
        }
        Throwable thM7907exceptionOrNullimpl = Result.m7907exceptionOrNullimpl(objA);
        if (thM7907exceptionOrNullimpl != null) {
            this.tools.b(identifier, 3004, thM7907exceptionOrNullimpl.getMessage());
        }
    }

    public final void a(eg.a rewardService) {
        Intrinsics.checkNotNullParameter(rewardService, "rewardService");
        Map<String, t.d> map = this.placements;
        if (map != null && (r0 = map.entrySet().iterator()) != null) {
            for (Map.Entry<String, t.d> entry : map.entrySet()) {
                String key = entry.getKey();
                gq gqVarF = entry.getValue().getPlacementReward();
                if (gqVarF != null) {
                    b(rewardService, key, gqVarF.getName(), gqVarF.getAmount());
                }
            }
        }
        Map<String, t.d> map2 = this.adUnits;
        if (map2 == null || (r0 = map2.entrySet().iterator()) == null) {
            return;
        }
        for (Map.Entry<String, t.d> entry2 : map2.entrySet()) {
            String key2 = entry2.getKey();
            gq gqVarA = entry2.getValue().getAdUnitReward();
            if (gqVarA != null) {
                a(rewardService, key2, gqVarA.getName(), gqVarA.getAmount());
            }
        }
    }
}
