package com.pubmatic.sdk.nativead.request;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes12.dex */
public abstract class POBBaseNativeRequestAsset {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f7701a;
    private final boolean b;

    POBBaseNativeRequestAsset(int i, boolean z) {
        this.f7701a = i;
        this.b = z;
    }

    public int getId() {
        return this.f7701a;
    }

    public abstract JSONObject getRTBJSON();

    public boolean isRequired() {
        return this.b;
    }
}
