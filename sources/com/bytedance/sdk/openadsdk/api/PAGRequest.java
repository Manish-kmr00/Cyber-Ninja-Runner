package com.bytedance.sdk.openadsdk.api;

import android.os.Bundle;
import java.util.Map;

/* JADX INFO: loaded from: classes9.dex */
public class PAGRequest {
    private Bundle KZx = null;
    private Map<String, Object> Og;
    private String pA;

    public String getAdString() {
        return this.pA;
    }

    public void setAdString(String str) {
        this.pA = str;
    }

    public Map<String, Object> getExtraInfo() {
        return this.Og;
    }

    public void setExtraInfo(Map<String, Object> map) {
        this.Og = map;
    }

    public final void addNetworkExtrasBundle(Class<?> cls, Bundle bundle) {
        if (this.KZx == null) {
            this.KZx = new Bundle();
        }
        this.KZx.putBundle(cls.getName(), bundle);
    }

    public Bundle getNetworkExtrasBundle() {
        return this.KZx;
    }
}
