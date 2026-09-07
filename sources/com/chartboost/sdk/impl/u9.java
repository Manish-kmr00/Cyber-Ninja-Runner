package com.chartboost.sdk.impl;

import android.content.SharedPreferences;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000b\u001a\u00020\t¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0004\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001f\u0010\u0004\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0004\u0010\bR\u0014\u0010\u000b\u001a\u00020\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\n¨\u0006\u000e"}, d2 = {"Lcom/chartboost/sdk/impl/u9;", "", "", "sharedPrefsKey", "a", "(Ljava/lang/String;)Ljava/lang/String;", "data", "", "(Ljava/lang/String;Ljava/lang/String;)V", "Landroid/content/SharedPreferences;", "Landroid/content/SharedPreferences;", "sharedPrefs", "<init>", "(Landroid/content/SharedPreferences;)V", "ChartboostMonetization-9.8.3_productionRelease"}, k = 1, mv = {1, 8, 0})
public final class u9 {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final SharedPreferences sharedPrefs;

    public u9(SharedPreferences sharedPrefs) {
        Intrinsics.checkNotNullParameter(sharedPrefs, "sharedPrefs");
        this.sharedPrefs = sharedPrefs;
    }

    public final String a(String sharedPrefsKey) {
        Intrinsics.checkNotNullParameter(sharedPrefsKey, "sharedPrefsKey");
        try {
            return this.sharedPrefs.getString(sharedPrefsKey, null);
        } catch (Exception e) {
            b7.b("Load from shared prefs exception", e);
            return null;
        }
    }

    public final void a(String sharedPrefsKey, String data) {
        Intrinsics.checkNotNullParameter(sharedPrefsKey, "sharedPrefsKey");
        try {
            this.sharedPrefs.edit().putString(sharedPrefsKey, data).apply();
        } catch (Exception e) {
            b7.b("Save to shared prefs exception", e);
        }
    }
}
