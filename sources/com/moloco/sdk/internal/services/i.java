package com.moloco.sdk.internal.services;

import android.content.Context;
import android.content.res.Resources;
import android.hardware.SensorManager;
import android.os.Build;
import android.os.SystemClock;
import android.telephony.TelephonyManager;
import android.view.inputmethod.InputMethodManager;
import android.view.inputmethod.InputMethodSubtype;
import androidx.core.content.ContextCompat;
import com.moloco.sdk.R;
import com.pubmatic.sdk.crashanalytics.POBCrashAnalyticsConstants;
import java.util.Locale;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.ReplaceWith;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes9.dex */
public final class i implements y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f6390a;
    public final Lazy b;

    public static final class a extends Lambda implements Function0<Boolean> {
        public a() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke() {
            return Boolean.valueOf(i.this.f6390a.getResources().getBoolean(R.bool.isTablet));
        }
    }

    public i(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.f6390a = context;
        this.b = LazyKt.lazy(new a());
    }

    @Override // com.moloco.sdk.internal.services.y
    public x b() {
        String str = Build.MANUFACTURER;
        String str2 = str == null ? "" : str;
        String str3 = Build.MODEL;
        String str4 = str3 == null ? "" : str3;
        String str5 = Build.HARDWARE;
        String str6 = str5 == null ? "" : str5;
        boolean zE = e();
        String RELEASE = Build.VERSION.RELEASE;
        Intrinsics.checkNotNullExpressionValue(RELEASE, "RELEASE");
        int i = Build.VERSION.SDK_INT;
        String language = Locale.getDefault().getLanguage();
        Intrinsics.checkNotNullExpressionValue(language, "getDefault().language");
        TelephonyManager telephonyManager = (TelephonyManager) ContextCompat.getSystemService(this.f6390a, TelephonyManager.class);
        String networkOperatorName = telephonyManager != null ? telephonyManager.getNetworkOperatorName() : null;
        return new x(str2, str4, str6, zE, "android", RELEASE, i, language, networkOperatorName == null ? "" : networkOperatorName, Resources.getSystem().getDisplayMetrics().density, System.currentTimeMillis() - SystemClock.elapsedRealtime());
    }

    @Override // com.moloco.sdk.internal.services.y
    public String c() {
        String language = Locale.getDefault().getLanguage();
        Intrinsics.checkNotNullExpressionValue(language, "getDefault().language");
        return language;
    }

    @Override // com.moloco.sdk.internal.services.y
    public String d() {
        Object systemService = this.f6390a.getSystemService("input_method");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        InputMethodSubtype currentInputMethodSubtype = ((InputMethodManager) systemService).getCurrentInputMethodSubtype();
        if (currentInputMethodSubtype != null) {
            return currentInputMethodSubtype.getLocale();
        }
        return null;
    }

    public final boolean e() {
        return ((Boolean) this.b.getValue()).booleanValue();
    }

    @Override // com.moloco.sdk.internal.services.y
    @Deprecated(message = "Use invoke() instead", replaceWith = @ReplaceWith(expression = POBCrashAnalyticsConstants.DEVICE_INFO_KEY, imports = {}))
    public x invoke() {
        return b();
    }

    @Override // com.moloco.sdk.internal.services.y
    public Boolean a() {
        try {
            Object systemService = this.f6390a.getSystemService("sensor");
            Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.hardware.SensorManager");
            return Boolean.valueOf(((SensorManager) systemService).getDefaultSensor(4) != null);
        } catch (Exception unused) {
            return null;
        }
    }
}
