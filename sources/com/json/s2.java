package com.json;

import com.json.mediationsdk.h;
import com.json.mediationsdk.model.NetworkSettings;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001d\u0012\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f\u0012\u0006\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u0014\u0010\u0015J\u001c\u0010\u0007\u001a\u00020\u00062\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002H\u0002J\u000e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bJ\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u0003H\u0016R \u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u000b0\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\r¨\u0006\u0016"}, d2 = {"Lcom/ironsource/s2;", "Lcom/ironsource/mediationsdk/h;", "", "", "Lcom/ironsource/i0;", "waterfallPerformance", "", "a", "Lcom/ironsource/zv;", "waterfallInstances", "instanceName", "Lcom/ironsource/k0;", "e", "Ljava/util/Map;", "allInstancesPerformance", "", "Lcom/ironsource/mediationsdk/model/NetworkSettings;", "providers", "", "limit", "<init>", "(Ljava/util/List;I)V", "mediationsdk_release"}, k = 1, mv = {1, 8, 0})
public final class s2 extends h {

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    private final Map<String, k0> allInstancesPerformance;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public s2(List<? extends NetworkSettings> providers, int i) {
        super(providers, i);
        Intrinsics.checkNotNullParameter(providers, "providers");
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(providers, 10)), 16));
        Iterator<T> it = providers.iterator();
        while (it.hasNext()) {
            Pair pair = TuplesKt.to(((NetworkSettings) it.next()).getProviderName(), new k0(i));
            linkedHashMap.put(pair.getFirst(), pair.getSecond());
        }
        this.allInstancesPerformance = linkedHashMap;
    }

    private final void a(Map<String, i0> waterfallPerformance) {
        for (Map.Entry<String, k0> entry : this.allInstancesPerformance.entrySet()) {
            entry.getValue().a(waterfallPerformance.get(entry.getKey()));
        }
    }

    @Override // com.json.mediationsdk.h
    public String a(String instanceName) {
        String strD;
        Intrinsics.checkNotNullParameter(instanceName, "instanceName");
        k0 k0Var = this.allInstancesPerformance.get(instanceName);
        return (k0Var == null || (strD = k0Var.d()) == null) ? "" : strD;
    }

    public final void a(zv waterfallInstances) {
        Intrinsics.checkNotNullParameter(waterfallInstances, "waterfallInstances");
        List<a0> listB = waterfallInstances.b();
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(listB, 10)), 16));
        for (a0 a0Var : listB) {
            Pair pair = TuplesKt.to(a0Var.getInstanceName(), a0Var.getNet.pubnative.lite.sdk.models.AdExperience.PERFORMANCE java.lang.String());
            linkedHashMap.put(pair.getFirst(), pair.getSecond());
        }
        a(linkedHashMap);
    }
}
