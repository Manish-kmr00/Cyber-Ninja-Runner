package com.inmobi.media;

import com.inmobi.commons.core.configs.AdConfig;
import com.inmobi.commons.core.configs.Config;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
import java.util.ArrayList;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
public final class K2 implements InterfaceC3564t2 {
    @Override // com.inmobi.media.InterfaceC3564t2
    public final void a(Config config) {
        List<String> listEmptyList;
        AdConfig.ContextualDataConfig contextualData;
        Intrinsics.checkNotNullParameter(config, "config");
        synchronized (this) {
            M2 m2 = M2.f3131a;
            Intrinsics.checkNotNullExpressionValue("M2", "<get-TAG>(...)");
            M2.e = (AdConfig) config;
            String str = M2.g;
            AdConfig adConfig = M2.e;
            if (adConfig == null || (contextualData = adConfig.getContextualData()) == null || (listEmptyList = contextualData.getSkipFields()) == null) {
                listEmptyList = CollectionsKt.emptyList();
            }
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(N2.j);
            arrayList.removeAll(listEmptyList);
            String strJoinToString$default = CollectionsKt.joinToString$default(arrayList, StringUtils.COMMA, null, null, 0, null, null, 62, null);
            M2.g = strJoinToString$default;
            if (!Intrinsics.areEqual(strJoinToString$default, str)) {
                m2.d();
            }
            M2.a();
            Unit unit = Unit.INSTANCE;
        }
    }
}
