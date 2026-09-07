package com.chartboost.sdk.impl;

import android.view.View;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public interface cc {

    public interface a {
        void a(View view, cc ccVar, JSONObject jSONObject, boolean z);
    }

    JSONObject a(View view);

    void a(View view, JSONObject jSONObject, a aVar, boolean z, boolean z2);
}
