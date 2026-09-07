package com.playon.bridge.dto.consent;

import android.content.Context;
import android.content.SharedPreferences;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ConsentData.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u000b\u0018\u0000 .2\u00020\u0001:\u0001.B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010#\u001a\u00020$J\u0006\u0010%\u001a\u00020$J\u000e\u0010\u000e\u001a\u00020$2\u0006\u0010&\u001a\u00020\u000fJ\b\u0010'\u001a\u0004\u0018\u00010\u0006J\u0006\u0010(\u001a\u00020\u0010J\u0012\u0010)\u001a\u00020$2\n\b\u0002\u0010*\u001a\u0004\u0018\u00010\u0006J\u001a\u0010+\u001a\u00020$2\u0006\u0010,\u001a\u00020\u00102\n\b\u0002\u0010*\u001a\u0004\u0018\u00010\u0006J\u001a\u0010-\u001a\u00020$2\u0006\u0010,\u001a\u00020\u00102\n\b\u0002\u0010*\u001a\u0004\u0018\u00010\u0006R(\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u00068B@BX\u0082\u000e¢\u0006\f\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R$\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0005\u001a\u00020\u00108B@BX\u0082\u000e¢\u0006\f\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0016\u001a\u00020\u00108FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0013\"\u0004\b\u0017\u0010\u0015R$\u0010\u0018\u001a\u00020\u00102\u0006\u0010\u0005\u001a\u00020\u00108F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0018\u0010\u0013\"\u0004\b\u0019\u0010\u0015R$\u0010\u001a\u001a\u00020\u00102\u0006\u0010\u0005\u001a\u00020\u00108F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u001a\u0010\u0013\"\u0004\b\u001b\u0010\u0015R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u001e\u001a\u00020\u000f8FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"¨\u0006/"}, d2 = {"Lcom/playon/bridge/dto/consent/ConsentData;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "value", "", "consentStr", "getConsentStr", "()Ljava/lang/String;", "setConsentStr", "(Ljava/lang/String;)V", "getContext", "()Landroid/content/Context;", "forceRegulationType", "Lcom/playon/bridge/dto/consent/ConsentType;", "", "generalConsent", "getGeneralConsent", "()Z", "setGeneralConsent", "(Z)V", "isCanCollectPersonalInfo", "setCanCollectPersonalInfo", "isCcpaApplied", "setCcpaApplied", "isGdprApplied", "setGdprApplied", "prefs", "Landroid/content/SharedPreferences;", "regulationType", "getRegulationType", "()Lcom/playon/bridge/dto/consent/ConsentType;", "setRegulationType", "(Lcom/playon/bridge/dto/consent/ConsentType;)V", "clearConsentString", "", "clearForceRegulationType", "type", "getConsentString", "isGeneralConsentGiven", "setConsentString", "consentString", "setDoNotSell", "status", "setGdprConsent", "Companion", "playon_debug"}, k = 1, mv = {1, 1, 13})
public final class ConsentData {
    public static final String PREF_CONSENT_KEY = "com.playon.dto.consent.consentdata";
    public static final String PREF_CONSENT_STRING = "privacy.consent.consentStr";
    public static final String PREF_IS_CCPA_APPLIED = "privacy.consent.isCcpaApplied";
    public static final String PREF_IS_GDPR_APPLIED = "privacy.consent.isGdprApplied";
    public static final String PREF_IS_GENERAL_CONSENT = "privacy.consent.isGeneralConsent";
    private final Context context;
    private ConsentType forceRegulationType;
    private boolean isCanCollectPersonalInfo;
    private final SharedPreferences prefs;
    private ConsentType regulationType;

    public ConsentData(Context context) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        this.context = context;
        SharedPreferences sharedPreferences = context.getSharedPreferences(PREF_CONSENT_KEY, 0);
        Intrinsics.checkExpressionValueIsNotNull(sharedPreferences, "context.getSharedPrefere…EY, Context.MODE_PRIVATE)");
        this.prefs = sharedPreferences;
        this.forceRegulationType = ConsentType.Undefined;
        this.regulationType = ConsentType.Undefined;
    }

    public final Context getContext() {
        return this.context;
    }

    private final String getConsentStr() {
        return this.prefs.getString(PREF_CONSENT_STRING, "");
    }

    private final void setConsentStr(String str) {
        this.prefs.edit().putString(PREF_CONSENT_STRING, str).apply();
    }

    private final boolean getGeneralConsent() {
        return this.prefs.getBoolean(PREF_IS_GENERAL_CONSENT, false);
    }

    private final void setGeneralConsent(boolean z) {
        this.prefs.edit().putBoolean(PREF_IS_GENERAL_CONSENT, z).apply();
    }

    public final boolean isGdprApplied() {
        return this.prefs.getBoolean(PREF_IS_GDPR_APPLIED, false);
    }

    public final void setGdprApplied(boolean z) {
        if (z) {
            setCcpaApplied(false);
        }
        this.prefs.edit().putBoolean(PREF_IS_GDPR_APPLIED, z).apply();
    }

    public final boolean isCcpaApplied() {
        return this.prefs.getBoolean(PREF_IS_CCPA_APPLIED, false);
    }

    public final void setCcpaApplied(boolean z) {
        if (z) {
            setGdprApplied(false);
        }
        this.prefs.edit().putBoolean(PREF_IS_CCPA_APPLIED, z).apply();
    }

    public final void setRegulationType(ConsentType consentType) {
        Intrinsics.checkParameterIsNotNull(consentType, "<set-?>");
        this.regulationType = consentType;
    }

    public final ConsentType getRegulationType() {
        if (this.forceRegulationType != ConsentType.Undefined) {
            return this.forceRegulationType;
        }
        if (isGdprApplied()) {
            return ConsentType.Gdpr;
        }
        return isCcpaApplied() ? ConsentType.Ccpa : ConsentType.None;
    }

    public final void setCanCollectPersonalInfo(boolean z) {
        this.isCanCollectPersonalInfo = z;
    }

    public final boolean isCanCollectPersonalInfo() {
        return getRegulationType() == ConsentType.None || (getRegulationType() != ConsentType.None && getGeneralConsent());
    }

    public static /* synthetic */ void setGdprConsent$default(ConsentData consentData, boolean z, String str, int i, Object obj) {
        if ((i & 2) != 0) {
            str = null;
        }
        consentData.setGdprConsent(z, str);
    }

    public final void setGdprConsent(boolean status, String consentString) {
        setGeneralConsent(status);
        setConsentStr(consentString);
    }

    public static /* synthetic */ void setConsentString$default(ConsentData consentData, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        consentData.setConsentString(str);
    }

    public final void setConsentString(String consentString) {
        setConsentStr(consentString);
    }

    public static /* synthetic */ void setDoNotSell$default(ConsentData consentData, boolean z, String str, int i, Object obj) {
        if ((i & 2) != 0) {
            str = null;
        }
        consentData.setDoNotSell(z, str);
    }

    public final void setDoNotSell(boolean status, String consentString) {
        setGeneralConsent(!status);
        setConsentStr(consentString);
    }

    public final String getConsentString() {
        return getConsentStr();
    }

    public final boolean isGeneralConsentGiven() {
        return getGeneralConsent();
    }

    public final void clearConsentString() {
        setConsentStr("");
    }

    public final void forceRegulationType(ConsentType type) {
        Intrinsics.checkParameterIsNotNull(type, "type");
        this.forceRegulationType = type;
    }

    public final void clearForceRegulationType() {
        this.forceRegulationType = ConsentType.Undefined;
    }
}
