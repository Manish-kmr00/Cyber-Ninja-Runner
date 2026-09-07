package com.json;

import com.json.mediationsdk.logger.IronLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¨\u0006\u000f"}, d2 = {"Lcom/ironsource/u7;", "Lcom/ironsource/g0;", "Lcom/ironsource/a0;", m5.p, "Lcom/ironsource/g0$b;", "loadSelection", "", "a", "", "Lcom/ironsource/w1;", "adUnitData", "Lcom/ironsource/zv;", "waterfallInstances", "<init>", "(Lcom/ironsource/w1;Lcom/ironsource/zv;)V", "mediationsdk_release"}, k = 1, mv = {1, 8, 0})
public final class u7 extends g0 {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public u7(w1 adUnitData, zv waterfallInstances) {
        super(adUnitData, waterfallInstances);
        Intrinsics.checkNotNullParameter(adUnitData, "adUnitData");
        Intrinsics.checkNotNullParameter(waterfallInstances, "waterfallInstances");
    }

    @Override // com.json.g0
    public void a(a0 instance, g0.b loadSelection) {
        String str;
        Intrinsics.checkNotNullParameter(instance, "instance");
        Intrinsics.checkNotNullParameter(loadSelection, "loadSelection");
        if (!instance.getIsBidder()) {
            IronLog.INTERNAL.verbose(instance.getAdFormat().name() + " - Instance " + instance.getInstanceName() + " (non-bidder) is ready to load");
            loadSelection.a().add(instance);
            return;
        }
        loadSelection.a(true);
        if (loadSelection.e()) {
            str = "Advanced Loading: Starting to load bidder " + instance.getInstanceName() + ". No other instances will be loaded at the same time.";
            loadSelection.a().add(instance);
        } else {
            str = "Advanced Loading: Won't start loading bidder " + instance.getInstanceName() + " as a non bidder is being loaded";
        }
        IronLog.INTERNAL.verbose(instance.getAdFormat().name() + " - " + str);
    }

    @Override // com.json.g0
    public boolean a(g0.b loadSelection) {
        Intrinsics.checkNotNullParameter(loadSelection, "loadSelection");
        return super.a(loadSelection) || loadSelection.getIsBidderReached();
    }
}
