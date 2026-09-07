package com.applovin.impl;

import com.facebook.internal.AnalyticsEvents;

/* JADX INFO: loaded from: classes.dex */
public class p1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f576a;
    private final Object b;
    private String c;
    private String d;

    public p1(Object obj, long j) {
        this.b = obj;
        this.f576a = j;
        if (obj instanceof com.applovin.impl.sdk.ad.b) {
            com.applovin.impl.sdk.ad.b bVar = (com.applovin.impl.sdk.ad.b) obj;
            this.c = bVar.getAdZone().d() != null ? bVar.getAdZone().d().getLabel() : null;
            this.d = "AppLovin";
        } else if (obj instanceof v2) {
            v2 v2Var = (v2) obj;
            this.c = v2Var.getFormat().getLabel();
            this.d = v2Var.getNetworkName();
        }
    }

    public Object a() {
        return this.b;
    }

    public long b() {
        return this.f576a;
    }

    public String c() {
        String str = this.c;
        return str != null ? str : AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN;
    }

    public String d() {
        String str = this.d;
        return str != null ? str : AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN;
    }
}
