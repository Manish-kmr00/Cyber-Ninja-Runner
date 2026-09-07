package com.amazon.aps.ads.privacy;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import com.amazon.aps.ads.util.ApsAdExtensionsKt;
import com.amazon.aps.shared.analytics.APSEventSeverity;
import com.amazon.aps.shared.analytics.APSEventType;
import com.amazon.device.ads.AdRegistration;
import com.amazon.device.ads.DtbSharedPreferences;
import java.io.File;
import java.util.Locale;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;

/* JADX INFO: compiled from: ApsPrivacyManager.kt */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u0000 %2\u00020\u0001:\u0001%B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001d\u0010\u0010\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\r¢\u0006\u0002\u0010\u0014J\u001d\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\r¢\u0006\u0002\u0010\u0017J\u0018\u0010\u0018\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\rJ\u0010\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cJ\u0006\u0010\u001d\u001a\u00020\u0006J\u0006\u0010\u001e\u001a\u00020\u0006J\u0006\u0010\u001f\u001a\u00020\u001aJ\u0006\u0010 \u001a\u00020\u001aJ\u0010\u0010!\u001a\u00020\u001a2\b\u0010\"\u001a\u0004\u0018\u00010#J\u000e\u0010$\u001a\u00020\u001a2\u0006\u0010\u0011\u001a\u00020\u0012R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0007R\u001e\u0010\t\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Lcom/amazon/aps/ads/privacy/ApsPrivacyManager;", "", "()V", "gdprHandler", "Lcom/amazon/aps/ads/privacy/ApsGdprHandler;", "isGdprToBeAppliedFromConfig", "", "Ljava/lang/Boolean;", "<set-?>", "isInitialized", "()Z", "keysInterested", "", "", "prefChangeListener", "Landroid/content/SharedPreferences$OnSharedPreferenceChangeListener;", "getBooleanValue", "prefs", "Landroid/content/SharedPreferences;", "key", "(Landroid/content/SharedPreferences;Ljava/lang/String;)Ljava/lang/Boolean;", "getIntValue", "", "(Landroid/content/SharedPreferences;Ljava/lang/String;)Ljava/lang/Integer;", "getStringValue", "init", "", "context", "Landroid/content/Context;", "isGdprConsentRequired", "isSystemResourceAccessAllowed", "removeConfigFileIfExists", "removeStoragesByApsIfNoConsent", "setGdprConfiguration", "jsonArray", "Lorg/json/JSONArray;", "setGdprConsent", "Companion", "DTBAndroidSDK_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class ApsPrivacyManager {
    public static final ApsPrivacyManager INSTANCE = new ApsPrivacyManager();
    private Boolean isGdprToBeAppliedFromConfig;
    private boolean isInitialized;
    private final Set<String> keysInterested = SetsKt.setOf((Object[]) new String[]{"IABTCF_TCString", "IABTCF_gdprApplies"});
    private final ApsGdprHandler gdprHandler = new ApsGdprHandler();
    private final SharedPreferences.OnSharedPreferenceChangeListener prefChangeListener = new SharedPreferences.OnSharedPreferenceChangeListener() { // from class: com.amazon.aps.ads.privacy.ApsPrivacyManager$$ExternalSyntheticLambda0
        @Override // android.content.SharedPreferences.OnSharedPreferenceChangeListener
        public final void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
            ApsPrivacyManager.m4363prefChangeListener$lambda0(this.f$0, sharedPreferences, str);
        }
    };

    private ApsPrivacyManager() {
    }

    /* JADX INFO: renamed from: isInitialized, reason: from getter */
    public final boolean getIsInitialized() {
        return this.isInitialized;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: prefChangeListener$lambda-0, reason: not valid java name */
    public static final void m4363prefChangeListener$lambda0(ApsPrivacyManager this$0, SharedPreferences prefs, String str) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ApsAdExtensionsKt.d(this$0, "Received the shared preference changed event");
        if (Intrinsics.areEqual(str, "IABTCF_TCString")) {
            ApsGdprHandler apsGdprHandler = this$0.gdprHandler;
            Intrinsics.checkNotNullExpressionValue(prefs, "prefs");
            apsGdprHandler.setGdprConsent(this$0.getStringValue(prefs, "IABTCF_TCString"));
        } else if (Intrinsics.areEqual(str, "IABTCF_gdprApplies")) {
            ApsGdprHandler apsGdprHandler2 = this$0.gdprHandler;
            Intrinsics.checkNotNullExpressionValue(prefs, "prefs");
            apsGdprHandler2.setGdprApplies(this$0.getBooleanValue(prefs, "IABTCF_gdprApplies"));
        }
        if (this$0.keysInterested.contains(str)) {
            this$0.removeStoragesByApsIfNoConsent();
        }
    }

    public final void init(Context context) {
        if (this.isInitialized || context == null) {
            return;
        }
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        if (defaultSharedPreferences != null) {
            setGdprConsent(defaultSharedPreferences);
            defaultSharedPreferences.registerOnSharedPreferenceChangeListener(this.prefChangeListener);
        }
        this.isInitialized = true;
    }

    public final boolean isGdprConsentRequired() {
        Boolean bool = this.isGdprToBeAppliedFromConfig;
        if (bool != null && bool.booleanValue()) {
            return true;
        }
        return (this.gdprHandler.getIsGdprApplies() != null && Intrinsics.areEqual((Object) this.gdprHandler.getIsGdprApplies(), (Object) true)) || this.gdprHandler.getIsTcfStringFound();
    }

    public final Boolean getBooleanValue(SharedPreferences prefs, String key) {
        Intrinsics.checkNotNullParameter(prefs, "prefs");
        Intrinsics.checkNotNullParameter(key, "key");
        if (!prefs.contains(key)) {
            return null;
        }
        Object obj = prefs.getAll().get(key);
        if (obj instanceof Boolean) {
            return Boolean.valueOf(Intrinsics.areEqual((Object) true, obj));
        }
        boolean z = obj instanceof Integer;
        if (z) {
            return Boolean.valueOf(z && 1 == ((Number) obj).intValue());
        }
        if (!(obj instanceof String)) {
            return null;
        }
        String lowerCase = ((String) obj).toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(Locale.ROOT)");
        return Boolean.valueOf(lowerCase.equals(true));
    }

    public final Integer getIntValue(SharedPreferences prefs, String key) {
        Intrinsics.checkNotNullParameter(prefs, "prefs");
        Intrinsics.checkNotNullParameter(key, "key");
        try {
            if (prefs.contains(key)) {
                return Integer.valueOf(prefs.getInt(key, 0));
            }
            return null;
        } catch (Exception e) {
            ApsAdExtensionsKt.remoteLog(this, APSEventSeverity.FATAL, APSEventType.EXCEPTION, "Error reading the shared pref value", e);
            return null;
        }
    }

    public final String getStringValue(SharedPreferences prefs, String key) {
        Intrinsics.checkNotNullParameter(prefs, "prefs");
        Intrinsics.checkNotNullParameter(key, "key");
        try {
            return prefs.getString(key, null);
        } catch (Exception e) {
            ApsAdExtensionsKt.remoteLog(this, APSEventSeverity.FATAL, APSEventType.EXCEPTION, "Error reading the shared pref value", e);
            return null;
        }
    }

    public final void setGdprConsent(SharedPreferences prefs) {
        Intrinsics.checkNotNullParameter(prefs, "prefs");
        this.gdprHandler.setGdprConsent(getStringValue(prefs, "IABTCF_TCString"));
        this.gdprHandler.setGdprApplies(getIntValue(prefs, "IABTCF_gdprApplies"));
        removeStoragesByApsIfNoConsent();
    }

    public final void removeStoragesByApsIfNoConsent() {
        if (isSystemResourceAccessAllowed()) {
            return;
        }
        DtbSharedPreferences.clearStorage();
        removeConfigFileIfExists();
    }

    public final void removeConfigFileIfExists() {
        File filesDir;
        Context context = AdRegistration.getContext();
        if (context == null || (filesDir = context.getFilesDir()) == null) {
            return;
        }
        File file = new File(Intrinsics.stringPlus(filesDir.getAbsolutePath(), "/config/aps_mobile_client_config.json"));
        if (file.exists()) {
            file.delete();
        }
    }

    public final void setGdprConfiguration(JSONArray jsonArray) {
        int i = 0;
        if (jsonArray != null) {
            int length = jsonArray.length();
            while (i < length) {
                int i2 = i + 1;
                if (Intrinsics.areEqual("gdprtcfv2", jsonArray.get(i))) {
                    this.isGdprToBeAppliedFromConfig = true;
                    return;
                }
                i = i2;
            }
            return;
        }
        this.isGdprToBeAppliedFromConfig = false;
    }

    public final boolean isSystemResourceAccessAllowed() {
        if (!isGdprConsentRequired()) {
            return true;
        }
        ApsGdprHandler apsGdprHandler = this.gdprHandler;
        return apsGdprHandler != null && apsGdprHandler.getIsPurpose1Consented();
    }
}
