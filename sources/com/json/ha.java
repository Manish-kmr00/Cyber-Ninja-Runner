package com.json;

import com.json.mediationsdk.logger.IronLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¨\u0006\u000e"}, d2 = {"Lcom/ironsource/ha;", "Lcom/ironsource/g0;", "Lcom/ironsource/a0;", m5.p, "Lcom/ironsource/g0$b;", "loadSelection", "", "a", "Lcom/ironsource/w1;", "adUnitData", "Lcom/ironsource/zv;", "waterfallInstances", "<init>", "(Lcom/ironsource/w1;Lcom/ironsource/zv;)V", "mediationsdk_release"}, k = 1, mv = {1, 8, 0})
public class ha extends g0 {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ha(w1 adUnitData, zv waterfallInstances) {
        super(adUnitData, waterfallInstances);
        Intrinsics.checkNotNullParameter(adUnitData, "adUnitData");
        Intrinsics.checkNotNullParameter(waterfallInstances, "waterfallInstances");
    }

    @Override // com.json.g0
    public void a(a0 instance, g0.b loadSelection) {
        Intrinsics.checkNotNullParameter(instance, "instance");
        Intrinsics.checkNotNullParameter(loadSelection, "loadSelection");
        IronLog.INTERNAL.verbose(instance.getAdFormat().name() + " - Instance " + instance.getInstanceSignature() + " is ready to load");
        loadSelection.a().add(instance);
    }
}
