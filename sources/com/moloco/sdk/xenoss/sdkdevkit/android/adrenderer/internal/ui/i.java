package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class i implements h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a.AbstractC0705a.c.EnumC0707a, com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a.AbstractC0705a.c> f6718a = new LinkedHashMap();

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.g
    public void a(com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a.AbstractC0705a.c button) {
        Intrinsics.checkNotNullParameter(button, "button");
        this.f6718a.put(button.d(), button);
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.h
    public List<com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a.AbstractC0705a.c> p() {
        List list = MapsKt.toList(this.f6718a);
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add((com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a.AbstractC0705a.c) ((Pair) it.next()).getSecond());
        }
        return arrayList;
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.g
    public void a(com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a.AbstractC0705a.c.EnumC0707a buttonType) {
        Intrinsics.checkNotNullParameter(buttonType, "buttonType");
        this.f6718a.remove(buttonType);
    }
}
