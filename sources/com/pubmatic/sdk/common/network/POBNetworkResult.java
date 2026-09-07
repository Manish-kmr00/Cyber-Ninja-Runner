package com.pubmatic.sdk.common.network;

import java.util.Map;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes11.dex */
public class POBNetworkResult {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Map f7612a;
    private long b;

    public POBNetworkResult(Map<String, String> map, long j) {
        this.f7612a = map;
        this.b = j;
    }

    public Map<String, String> getHeaders() {
        return this.f7612a;
    }

    public long getNetworkTimeMs() {
        return this.b;
    }

    public String toString() {
        return "POBNetworkResult{ networkTimeMs=" + this.b + AbstractJsonLexerKt.END_OBJ;
    }
}
