package com.applovin.impl.mediation;

import com.applovin.impl.v2;
import com.applovin.impl.x2;
import com.applovin.mediation.MaxAd;
import com.applovin.mediation.MaxAdWaterfallInfo;
import com.applovin.mediation.MaxNetworkResponseInfo;
import java.util.List;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes7.dex */
public class MaxAdWaterfallInfoImpl implements MaxAdWaterfallInfo {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final v2 f512a;
    private final String b;
    private final String c;
    private final List d;
    private final long e;
    private final x2 f;
    private final List g;
    private final String h;
    private final String i;

    public MaxAdWaterfallInfoImpl(v2 v2Var, long j, List<MaxNetworkResponseInfo> list, String str) {
        this(v2Var, v2Var.S(), v2Var.T(), j, list, v2Var.M(), v2Var.R(), str, v2Var.P());
    }

    public String getEventId() {
        return this.i;
    }

    @Override // com.applovin.mediation.MaxAdWaterfallInfo
    public long getLatencyMillis() {
        return this.e;
    }

    @Override // com.applovin.mediation.MaxAdWaterfallInfo
    public MaxAd getLoadedAd() {
        return this.f512a;
    }

    public String getMCode() {
        return this.h;
    }

    @Override // com.applovin.mediation.MaxAdWaterfallInfo
    public String getName() {
        return this.b;
    }

    @Override // com.applovin.mediation.MaxAdWaterfallInfo
    public List<MaxNetworkResponseInfo> getNetworkResponses() {
        return this.d;
    }

    public List<String> getPostbackUrls() {
        return this.g;
    }

    public x2 getRequestParameters() {
        return this.f;
    }

    @Override // com.applovin.mediation.MaxAdWaterfallInfo
    public String getTestName() {
        return this.c;
    }

    public String toString() {
        return "MaxAdWaterfallInfo{name=" + this.b + ", testName=" + this.c + ", networkResponses=" + this.d + ", latencyMillis=" + this.e + AbstractJsonLexerKt.END_OBJ;
    }

    public MaxAdWaterfallInfoImpl(v2 v2Var, String str, String str2, long j, List<MaxNetworkResponseInfo> list, x2 x2Var, List<String> list2, String str3, String str4) {
        this.f512a = v2Var;
        this.b = str;
        this.c = str2;
        this.e = j;
        this.d = list;
        this.f = x2Var;
        this.g = list2;
        this.h = str3;
        this.i = str4;
    }
}
