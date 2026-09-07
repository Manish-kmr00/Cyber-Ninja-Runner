package com.json;

import android.text.TextUtils;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.json.mediationsdk.logger.IronLog;
import com.json.mediationsdk.model.Placement;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bJ\b\u0010\u0003\u001a\u00020\u0002H\u0014¨\u0006\f"}, d2 = {"Lcom/ironsource/fn;", "Lcom/ironsource/p1;", "Lcom/ironsource/d0;", "a", "Lcom/ironsource/o1;", "adTools", "Lcom/ironsource/gn;", "adUnitData", "Lcom/ironsource/hn;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "<init>", "(Lcom/ironsource/o1;Lcom/ironsource/gn;Lcom/ironsource/hn;)V", "mediationsdk_release"}, k = 1, mv = {1, 8, 0})
public final class fn extends p1 {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public fn(o1 adTools, gn adUnitData, hn listener) {
        String str;
        int iB;
        super(adTools, adUnitData, listener, null, 8, null);
        Intrinsics.checkNotNullParameter(adTools, "adTools");
        Intrinsics.checkNotNullParameter(adUnitData, "adUnitData");
        Intrinsics.checkNotNullParameter(listener, "listener");
        Placement placementG = g();
        IronLog.INTERNAL.verbose("placement = " + placementG);
        if (placementG == null || TextUtils.isEmpty(placementG.getPlacementName())) {
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            str = String.format("can't load native ad - %s", Arrays.copyOf(new Object[]{placementG == null ? "placement is null" : "placement name is empty"}, 1));
            Intrinsics.checkNotNullExpressionValue(str, "format(format, *args)");
            iB = a2.b(adUnitData.getAdProperties().getCom.ironsource.mediationsdk.impressionData.ImpressionData.IMPRESSION_DATA_KEY_AD_FORMAT java.lang.String());
        } else {
            str = null;
            iB = 510;
        }
        if (str != null) {
            IronLog.API.error(a(str));
            a(iB, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final a0 a(fn this$0, b0 adInstanceData, h0 adInstancePayload) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(adInstanceData, "adInstanceData");
        Intrinsics.checkNotNullParameter(adInstancePayload, "adInstancePayload");
        return new xm(new w2(this$0.getAdUnitTools(), e2.b.PROVIDER), adInstanceData, adInstancePayload, new p1.a());
    }

    @Override // com.json.p1
    protected d0 a() {
        return new d0() { // from class: com.ironsource.fn$$ExternalSyntheticLambda0
            @Override // com.json.d0
            public final a0 a(b0 b0Var, h0 h0Var) {
                return fn.a(this.f$0, b0Var, h0Var);
            }
        };
    }
}
