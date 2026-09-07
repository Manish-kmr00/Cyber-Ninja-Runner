package com.unity3d.ads.core.domain;

import java.util.ArrayList;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AndroidGetIsAdActivity.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u0000 \u00072\u00020\u0001:\u0001\u0007B\u0005¢\u0006\u0002\u0010\u0002J\u0011\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0086\u0002¨\u0006\b"}, d2 = {"Lcom/unity3d/ads/core/domain/AndroidGetIsAdActivity;", "", "()V", "invoke", "", "activityName", "", "Companion", "unity-ads_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class AndroidGetIsAdActivity {
    private static final Set<String> knownAdActivities;

    public final boolean invoke(String activityName) {
        Intrinsics.checkNotNullParameter(activityName, "activityName");
        return knownAdActivities.contains(activityName);
    }

    static {
        AdActivity[] adActivityArrValues = AdActivity.values();
        ArrayList arrayList = new ArrayList(adActivityArrValues.length);
        for (AdActivity adActivity : adActivityArrValues) {
            arrayList.add(adActivity.getActivityName());
        }
        knownAdActivities = CollectionsKt.toSet(arrayList);
    }
}
