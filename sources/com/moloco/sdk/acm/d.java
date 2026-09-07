package com.moloco.sdk.acm;

import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes10.dex */
public final class d {
    public static final String a(EventTag eventTag) {
        Intrinsics.checkNotNullParameter(eventTag, "<this>");
        return eventTag.getKey() + AbstractJsonLexerKt.COLON + eventTag.getValue();
    }
}
