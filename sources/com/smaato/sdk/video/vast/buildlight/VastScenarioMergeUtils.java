package com.smaato.sdk.video.vast.buildlight;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class VastScenarioMergeUtils {
    public static <T> List<T> merge(List<T> list, List<T> list2) {
        ArrayList arrayList = new ArrayList(list.size() + list2.size());
        arrayList.addAll(list);
        arrayList.addAll(list2);
        return arrayList;
    }
}
