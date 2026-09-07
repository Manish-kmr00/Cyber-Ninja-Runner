package com.chartboost.sdk.impl;

import android.app.Application;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.media.AudioDeviceInfo;
import android.media.AudioManager;
import android.os.BatteryManager;
import android.os.Build;
import android.os.LocaleList;
import android.os.StatFs;
import android.support.v4.media.session.PlaybackStateCompat;
import com.amazon.aps.shared.metrics.model.ApsMetricsDataMap;
import com.chartboost.sdk.privacy.model.DataUseConsent;
import com.fyber.inneractive.sdk.external.InneractiveMediationDefs;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import io.appmetrica.analytics.networktasks.internal.CommonUrlParts;
import java.lang.ref.WeakReference;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\n\b\u0000\u0018\u0000 \u00102\u00020\u0001:\u0004\f\u0015\u001d!B\u0017\u0012\u0006\u0010\u0019\u001a\u00020\u0017\u0012\u0006\u0010\u001c\u001a\u00020\u001a¢\u0006\u0004\b7\u00108J=\u0010\f\u001a\u00020\u000b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\b2\b\u0010\n\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\f\u0010\rJ\u0019\u0010\f\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002¢\u0006\u0004\b\f\u0010\u000eJ\u000f\u0010\u0010\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\u0012H\u0003¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\f\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\u0012H\u0002¢\u0006\u0004\b\f\u0010\u0016R\u0014\u0010\u0019\u001a\u00020\u00178\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\u0018R\u0014\u0010\u001c\u001a\u00020\u001a8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u001bR\u0014\u0010\u001f\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010#\u001a\u0004\u0018\u00010 8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b!\u0010\"R\u0014\u0010&\u001a\u00020\u00068BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b$\u0010%R\u0014\u0010*\u001a\u00020'8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b(\u0010)R\u0014\u0010,\u001a\u00020\u00068BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b+\u0010%R\u0014\u0010.\u001a\u00020\u00068BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b-\u0010%R\u0014\u00102\u001a\u00020/8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b0\u00101R\u0014\u00104\u001a\u00020\u00148BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u00103R\u0014\u00105\u001a\u00020\u00148BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u00103R\u0014\u00106\u001a\u00020'8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b!\u0010)¨\u00069"}, d2 = {"Lcom/chartboost/sdk/impl/h4;", "", "Lcom/chartboost/sdk/impl/r5;", "identity", "Lcom/chartboost/sdk/impl/t9;", "session", "", com.ironsource.b9.i.t, "Lcom/chartboost/sdk/impl/l8;", "privacyApi", RemoteConfigConstants.RequestFieldKey.APP_ID, "Lcom/chartboost/sdk/impl/i4;", "a", "(Lcom/chartboost/sdk/impl/r5;Lcom/chartboost/sdk/impl/t9;Ljava/lang/String;Lcom/chartboost/sdk/impl/l8;Ljava/lang/String;)Lcom/chartboost/sdk/impl/i4;", "(Lcom/chartboost/sdk/impl/r5;)Ljava/lang/String;", "Lcom/chartboost/sdk/impl/h4$d;", "e", "()Lcom/chartboost/sdk/impl/h4$d;", "Landroid/media/AudioManager;", "audioManager", "", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "(Landroid/media/AudioManager;)I", "Landroid/app/Application;", "Landroid/app/Application;", "app", "Lcom/chartboost/sdk/impl/b4;", "Lcom/chartboost/sdk/impl/b4;", "displayMeasurement", ApsMetricsDataMap.APSMETRICS_FIELD_CUSTOM, "Ljava/lang/String;", "currentTimeZone", "Ljava/util/Locale;", "d", "Ljava/util/Locale;", CommonUrlParts.LOCALE, "g", "()Ljava/lang/String;", "orientationString", "", InneractiveMediationDefs.GENDER_FEMALE, "()J", "deviceStorage", "h", "platform", "i", "systemLanguage", "", "j", "()Z", "isAudioMute", "()I", "audioVolumeLevelForMusic", "audioOutput", "availableHeapMemoryInMB", "<init>", "(Landroid/app/Application;Lcom/chartboost/sdk/impl/b4;)V", "ChartboostMonetization-9.8.3_productionRelease"}, k = 1, mv = {1, 8, 0})
public final class h4 {

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static String f;

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final Application app;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    public final b4 displayMeasurement;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    public final String currentTimeZone;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    public final Locale locale;

    public h4(Application app, b4 displayMeasurement) {
        String strA;
        Locale locale;
        Intrinsics.checkNotNullParameter(app, "app");
        Intrinsics.checkNotNullParameter(displayMeasurement, "displayMeasurement");
        this.app = app;
        this.displayMeasurement = displayMeasurement;
        try {
            strA = n2.a();
        } catch (Exception e) {
            b7.a("Cannot retrieve timezone", e);
            strA = "Cannot retrieve timezone";
        }
        this.currentTimeZone = strA;
        try {
            locale = Locale.getDefault();
        } catch (Exception e2) {
            b7.a("Cannot retrieve locale", e2);
            locale = null;
        }
        this.locale = locale;
    }

    public final long f() {
        try {
            return new StatFs(this.app.getCacheDir() + "/.chartboost").getAvailableBytes();
        } catch (Exception e) {
            b7.a("Cannot create environment device storage for tracking", e);
            return -1L;
        }
    }

    public final String h() {
        return StringsKt.equals("Amazon", Build.MANUFACTURER, true) ? "Amazon" : "Android";
    }

    public final String i() {
        String language;
        try {
            language = LocaleList.getDefault().get(0).getLanguage();
        } catch (Exception e) {
            b7.a("Cannot retrieve language", e);
            language = "Cannot retrieve language";
        }
        Intrinsics.checkNotNullExpressionValue(language, "{\n                try {\n…          }\n            }");
        return language;
    }

    public final d e() {
        try {
            Object systemService = this.app.getSystemService("batterymanager");
            Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.os.BatteryManager");
            BatteryManager batteryManager = (BatteryManager) systemService;
            return new d(batteryManager.getIntProperty(4), batteryManager.isCharging());
        } catch (Exception e) {
            b7.a("Cannot create environment device battery for tracking", e);
            return new d(0, 0 == true ? 1 : 0, 3, null);
        }
    }

    public final i4 a(r5 identity, t9 session, String connectionType, l8 privacyApi, String appId) {
        String id;
        String string;
        String string2;
        Object consent;
        Object consent2;
        Intrinsics.checkNotNullParameter(privacyApi, "privacyApi");
        d dVarE = e();
        if (session == null || (id = session.getId()) == null) {
            id = "session not ready";
        }
        String str = id;
        int sessionCounter = session != null ? session.getSessionCounter() : -1;
        String str2 = appId == null ? "App was not init yet" : appId;
        String strA = INSTANCE.a();
        if (strA == null) {
            strA = "App was not init yet";
        }
        DataUseConsent dataUseConsentA = privacyApi.a("gdpr");
        Object consent3 = dataUseConsentA != null ? dataUseConsentA.getConsent() : null;
        String str3 = consent3 instanceof String ? (String) consent3 : null;
        if (str3 == null) {
            str3 = "gdpr not available";
        }
        String str4 = str3;
        DataUseConsent dataUseConsentA2 = privacyApi.a("us_privacy");
        Object consent4 = dataUseConsentA2 != null ? dataUseConsentA2.getConsent() : null;
        String str5 = consent4 instanceof String ? (String) consent4 : null;
        if (str5 == null) {
            str5 = "ccpa not available";
        }
        String str6 = str5;
        DataUseConsent dataUseConsentA3 = privacyApi.a("coppa");
        if (dataUseConsentA3 == null || (consent2 = dataUseConsentA3.getConsent()) == null || (string = consent2.toString()) == null) {
            string = "coppa not available";
        }
        String str7 = string;
        DataUseConsent dataUseConsentA4 = privacyApi.a("lgpd");
        if (dataUseConsentA4 == null || (consent = dataUseConsentA4.getConsent()) == null || (string2 = consent.toString()) == null) {
            string2 = "lgpd not available";
        }
        String str8 = string2;
        String strA2 = a(identity);
        String MANUFACTURER = Build.MANUFACTURER;
        Intrinsics.checkNotNullExpressionValue(MANUFACTURER, "MANUFACTURER");
        String MODEL = Build.MODEL;
        Intrinsics.checkNotNullExpressionValue(MODEL, "MODEL");
        String str9 = "Android " + Build.VERSION.RELEASE;
        String strH = h();
        Locale locale = this.locale;
        String country = locale != null ? locale.getCountry() : null;
        return new i4(str, sessionCounter, str2, strA, "9.8.3", false, str4, str6, str7, str8, strA2, MANUFACTURER, MODEL, str9, strH, country == null ? "Cannot retrieve country" : country, i(), this.currentTimeZone, connectionType == null ? "connection type not provided" : connectionType, g(), dVarE.getBatteryLevel(), dVarE.getIsCharging(), c(), j(), b(), f(), d(), session != null ? session.getInterstitialImpressionCounter() : 0, session != null ? session.getRewardedImpressionCounter() : 0, session != null ? session.getBannerImpressionCounter() : 0, session != null ? session.getDuration() : -1L, 0L, Integer.MIN_VALUE, null);
    }

    public final String g() {
        try {
            return b8.b(this.app, this.displayMeasurement);
        } catch (Exception e) {
            b7.a("Cannot retrieve orientation", e);
            return "Cannot retrieve orientation";
        }
    }

    public final boolean j() {
        try {
            Object systemService = this.app.getSystemService("audio");
            Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.media.AudioManager");
            return ((AudioManager) systemService).getRingerMode() != 2;
        } catch (Exception e) {
            b7.a("Cannot create environment audio for tracking", e);
            return false;
        }
    }

    public final int c() {
        try {
            Object systemService = this.app.getSystemService("audio");
            Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.media.AudioManager");
            AudioManager audioManager = (AudioManager) systemService;
            return (int) ((audioManager.getStreamVolume(3) / audioManager.getStreamMaxVolume(3)) * 100);
        } catch (Exception e) {
            b7.a("Cannot create environment audio for tracking", e);
            return -1;
        }
    }

    public final int b() {
        try {
            Object systemService = this.app.getSystemService("audio");
            Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.media.AudioManager");
            return b((AudioManager) systemService);
        } catch (Exception e) {
            b7.a("Cannot create environment audio output for tracking", e);
            return a.OTHER.getValue();
        }
    }

    public final long d() {
        try {
            Runtime runtime = Runtime.getRuntime();
            return (runtime.maxMemory() - (runtime.totalMemory() - runtime.freeMemory())) / PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED;
        } catch (Exception e) {
            b7.a("Cannot create environment runtime for tracking", e);
            return -1L;
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u000b\b\u0082\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\u0006\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005j\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/chartboost/sdk/impl/h4$a;", "", "", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "I", "()I", "value", "<init>", "(Ljava/lang/String;II)V", ApsMetricsDataMap.APSMETRICS_FIELD_CUSTOM, "d", "e", InneractiveMediationDefs.GENDER_FEMALE, "ChartboostMonetization-9.8.3_productionRelease"}, k = 1, mv = {1, 8, 0})
    public enum a {
        BUILTIN_SPEAKER(0),
        WIRED_HEADPHONES(1),
        BLUETOOTH_A2DP(2),
        OTHER(3);


        /* JADX INFO: renamed from: b, reason: from kotlin metadata */
        public final int value;

        a(int i) {
            this.value = i;
        }

        /* JADX INFO: renamed from: b, reason: from getter */
        public final int getValue() {
            return this.value;
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\f\b\u0082\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0012\u001a\u00020\t¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\n\u0010\u000bR\u0017\u0010\u000e\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\f\u0010\u0007R\u0017\u0010\u0012\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u000f\u0010\u0011¨\u0006\u0015"}, d2 = {"Lcom/chartboost/sdk/impl/h4$d;", "", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "a", "I", com.ironsource.b9.i.Y, DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "Z", "()Z", com.ironsource.b9.i.k0, "<init>", "(IZ)V", "ChartboostMonetization-9.8.3_productionRelease"}, k = 1, mv = {1, 8, 0})
    public static final /* data */ class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
        public final int batteryLevel;

        /* JADX INFO: renamed from: b, reason: from kotlin metadata */
        public final boolean isCharging;

        public d() {
            this(0, 0 == true ? 1 : 0, 3, null);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof d)) {
                return false;
            }
            d dVar = (d) other;
            return this.batteryLevel == dVar.batteryLevel && this.isCharging == dVar.isCharging;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v3, types: [int] */
        /* JADX WARN: Type inference failed for: r1v1, types: [int] */
        /* JADX WARN: Type inference failed for: r1v2 */
        /* JADX WARN: Type inference failed for: r1v3 */
        public int hashCode() {
            int iHashCode = Integer.hashCode(this.batteryLevel) * 31;
            boolean z = this.isCharging;
            ?? r1 = z;
            if (z) {
                r1 = 1;
            }
            return iHashCode + r1;
        }

        public String toString() {
            return "DeviceBattery(batteryLevel=" + this.batteryLevel + ", isCharging=" + this.isCharging + ')';
        }

        public d(int i, boolean z) {
            this.batteryLevel = i;
            this.isCharging = z;
        }

        /* JADX INFO: renamed from: a, reason: from getter */
        public final int getBatteryLevel() {
            return this.batteryLevel;
        }

        /* JADX INFO: renamed from: b, reason: from getter */
        public final boolean getIsCharging() {
            return this.isCharging;
        }

        public /* synthetic */ d(int i, boolean z, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this((i2 & 1) != 0 ? 0 : i, (i2 & 2) != 0 ? false : z);
        }
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0010\u0010\u0011R\u001e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005R\u0018\u0010\n\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\b\u0010\tR(\u0010\u000f\u001a\u0004\u0018\u00010\u00032\b\u0010\u000b\u001a\u0004\u0018\u00010\u00038F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\f\u0010\r\"\u0004\b\f\u0010\u000e¨\u0006\u0012"}, d2 = {"Lcom/chartboost/sdk/impl/h4$c;", "", "Ljava/lang/ref/WeakReference;", "Landroid/content/Context;", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "Ljava/lang/ref/WeakReference;", "contextRef", "Landroid/app/Application;", ApsMetricsDataMap.APSMETRICS_FIELD_CUSTOM, "Landroid/app/Application;", "appContext", "value", "a", "()Landroid/content/Context;", "(Landroid/content/Context;)V", "context", "<init>", "()V", "ChartboostMonetization-9.8.3_productionRelease"}, k = 1, mv = {1, 8, 0})
    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f1036a = new c();

        /* JADX INFO: renamed from: b, reason: from kotlin metadata */
        public static WeakReference<Context> contextRef;

        /* JADX INFO: renamed from: c, reason: from kotlin metadata */
        public static Application appContext;

        public final void a(Context context) {
            if (!(context instanceof Application)) {
                contextRef = new WeakReference<>(context);
                Context applicationContext = context != null ? context.getApplicationContext() : null;
                appContext = applicationContext instanceof Application ? (Application) applicationContext : null;
                return;
            }
            appContext = (Application) context;
        }

        public final Context a() {
            Context context;
            WeakReference<Context> weakReference = contextRef;
            return (weakReference == null || (context = weakReference.get()) == null) ? appContext : context;
        }
    }

    /* JADX INFO: renamed from: com.chartboost.sdk.impl.h4$b, reason: from kotlin metadata */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nR$\u0010\u0003\u001a\u0004\u0018\u00010\u00028F@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/chartboost/sdk/impl/h4$b;", "", "", "appVersion", "Ljava/lang/String;", "a", "()Ljava/lang/String;", "setAppVersion", "(Ljava/lang/String;)V", "<init>", "()V", "ChartboostMonetization-9.8.3_productionRelease"}, k = 1, mv = {1, 8, 0})
    public static final class Companion {
        public final String a() {
            try {
                c cVar = c.f1036a;
                Context contextA = cVar.a();
                PackageManager packageManager = contextA != null ? contextA.getPackageManager() : null;
                Context contextA2 = cVar.a();
                String packageName = contextA2 != null ? contextA2.getPackageName() : null;
                if (packageManager != null && packageName != null) {
                    PackageInfo packageInfo = Build.VERSION.SDK_INT >= 33 ? packageManager.getPackageInfo(packageName, PackageManager.PackageInfoFlags.of(0L)) : packageManager.getPackageInfo(packageName, 0);
                    if (packageInfo != null) {
                        h4.f = packageInfo.versionName;
                    }
                }
            } catch (PackageManager.NameNotFoundException e) {
                b7.b("Exception raised while retrieving appVersionName: " + e.getMessage(), null, 2, null);
            }
            return h4.f;
        }

        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public final int a(AudioManager audioManager) {
        if (audioManager.isSpeakerphoneOn()) {
            return a.BUILTIN_SPEAKER.getValue();
        }
        return a.OTHER.getValue();
    }

    public final int b(AudioManager audioManager) {
        AudioDeviceInfo audioDeviceInfo = audioManager.getDevices(2)[0];
        Integer numValueOf = audioDeviceInfo != null ? Integer.valueOf(audioDeviceInfo.getType()) : null;
        if (numValueOf != null && numValueOf.intValue() == 2) {
            return a.BUILTIN_SPEAKER.getValue();
        }
        if (numValueOf != null && numValueOf.intValue() == 4) {
            return a.WIRED_HEADPHONES.getValue();
        }
        return (numValueOf != null && numValueOf.intValue() == 8) ? a.BLUETOOTH_A2DP.getValue() : a.OTHER.getValue();
    }

    public final String a(r5 identity) {
        if (identity != null) {
            String uuid = identity.getCom.ironsource.fe.Q0 java.lang.String();
            if (uuid == null) {
                uuid = identity.getUuid();
            }
            if (uuid != null) {
                return uuid;
            }
        }
        return "unknown";
    }
}
