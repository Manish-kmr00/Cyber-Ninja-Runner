package com.chartboost.sdk.impl;

import com.chartboost.sdk.privacy.model.DataUseConsent;

/* JADX INFO: loaded from: classes5.dex */
public class j5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final p8 f1050a;

    public j5(p8 p8Var) {
        this.f1050a = p8Var;
    }

    public DataUseConsent a(String str) {
        return this.f1050a.a().get(str);
    }
}
