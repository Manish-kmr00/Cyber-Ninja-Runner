package com.yandex.mobile.ads.impl;

import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.serialization.json.Json;

/* JADX INFO: loaded from: classes6.dex */
public final class ap0 implements si2<ox> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ar1<String> f8431a;
    private final Json b;
    private final mi2 c;

    public ap0(y22 stringResponseParser, Json jsonParser, mi2 responseMapper) {
        Intrinsics.checkNotNullParameter(stringResponseParser, "stringResponseParser");
        Intrinsics.checkNotNullParameter(jsonParser, "jsonParser");
        Intrinsics.checkNotNullParameter(responseMapper, "responseMapper");
        this.f8431a = stringResponseParser;
        this.b = jsonParser;
        this.c = responseMapper;
    }

    @Override // com.yandex.mobile.ads.impl.si2
    public final ox a(tc1 networkResponse) {
        Intrinsics.checkNotNullParameter(networkResponse, "networkResponse");
        this.c.getClass();
        String strA = this.f8431a.a(mi2.a(networkResponse));
        if (strA == null || StringsKt.isBlank(strA)) {
            return null;
        }
        Json json = this.b;
        json.getSerializersModule();
        return (ox) json.decodeFromString(ox.Companion.serializer(), strA);
    }
}
