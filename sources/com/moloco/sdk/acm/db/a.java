package com.moloco.sdk.acm.db;

import io.appmetrica.analytics.coreutils.internal.StringUtils;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes7.dex */
public final class a {
    public final String a(c eventType) {
        Intrinsics.checkNotNullParameter(eventType, "eventType");
        return eventType.name();
    }

    public final List<String> b(String tagsString) {
        Intrinsics.checkNotNullParameter(tagsString, "tagsString");
        return tagsString.length() == 0 ? CollectionsKt.emptyList() : StringsKt.split$default((CharSequence) tagsString, new String[]{StringUtils.COMMA}, false, 0, 6, (Object) null);
    }

    public final c a(String eventType) {
        Intrinsics.checkNotNullParameter(eventType, "eventType");
        return c.valueOf(eventType);
    }

    public final String a(List<String> tags) {
        Intrinsics.checkNotNullParameter(tags, "tags");
        return CollectionsKt.joinToString$default(tags, StringUtils.COMMA, null, null, 0, null, null, 62, null);
    }
}
