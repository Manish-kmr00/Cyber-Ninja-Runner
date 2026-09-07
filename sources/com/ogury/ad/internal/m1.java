package com.ogury.ad.internal;

import android.content.Context;
import android.content.SharedPreferences;
import com.ogury.core.internal.InternalCore;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public final class m1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f7352a;

    public m1(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.f7352a = context;
    }

    public final void a(SharedPreferences.OnSharedPreferenceChangeListener onConsentDataChanged, SharedPreferences.OnSharedPreferenceChangeListener onOguryPrivacyDataChanged) {
        Intrinsics.checkNotNullParameter(onConsentDataChanged, "onConsentDataChanged");
        Intrinsics.checkNotNullParameter(onOguryPrivacyDataChanged, "onOguryPrivacyDataChanged");
        InternalCore.setOnPrivacyDataChangeListener(this.f7352a, onConsentDataChanged, onOguryPrivacyDataChanged);
    }
}
