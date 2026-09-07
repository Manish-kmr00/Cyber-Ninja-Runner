package io.appmetrica.analytics.impl;

import java.util.List;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes3.dex */
public final class Se implements V7 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C4118ff f11348a;
    public final List<Re> b;

    public Se(C4118ff c4118ff, List<Re> list) {
        this.f11348a = c4118ff;
        this.b = list;
    }

    @Override // io.appmetrica.analytics.impl.V7
    public final List<Re> a() {
        return this.b;
    }

    @Override // io.appmetrica.analytics.impl.V7
    public final Object b() {
        return this.f11348a;
    }

    public final C4118ff c() {
        return this.f11348a;
    }

    public final String toString() {
        return "PreloadInfoData{chosenPreloadInfo=" + this.f11348a + ", candidates=" + this.b + AbstractJsonLexerKt.END_OBJ;
    }
}
