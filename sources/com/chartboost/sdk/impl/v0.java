package com.chartboost.sdk.impl;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.google.android.gms.appset.AppSet;
import com.google.android.gms.appset.AppSetIdInfo;
import com.google.android.gms.tasks.Task;

/* JADX INFO: loaded from: classes13.dex */
public class v0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static v0 f1160a = new v0();

    public static v0 b() {
        return f1160a;
    }

    public Task<AppSetIdInfo> a(Context context) {
        try {
            return AppSet.getClient(context).getAppSetIdInfo();
        } catch (Exception e) {
            b7.b("Cannot retrieve appSetId client", e);
            return null;
        }
    }

    public boolean a(CharSequence charSequence) {
        return TextUtils.isEmpty(charSequence);
    }

    public String a() {
        return Build.VERSION.RELEASE;
    }
}
