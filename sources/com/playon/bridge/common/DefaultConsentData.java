package com.playon.bridge.common;

import android.text.TextUtils;
import androidx.webkit.Profile;
import com.playon.bridge.PersonalInfoManager;
import com.playon.bridge.dto.consent.ConsentType;
import com.yandex.div.core.timer.TimerController;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DefaultConsentData.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0011\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001:\u00011B/\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0006\u0010\u001a\u001a\u00020\u001bJ\u0006\u0010\u001c\u001a\u00020\u001bJ\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0007HÆ\u0003J\t\u0010 \u001a\u00020\tHÆ\u0003J3\u0010!\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001J\u0013\u0010\"\u001a\u00020\t2\b\u0010#\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\u000e\u0010\u0006\u001a\u00020\u001b2\u0006\u0010$\u001a\u00020\u0007J\t\u0010%\u001a\u00020&HÖ\u0001J\u0006\u0010'\u001a\u00020\tJ\u000e\u0010(\u001a\u00020\u001b2\u0006\u0010)\u001a\u00020*J\b\u0010+\u001a\u00020\u001bH\u0002J\u001a\u0010,\u001a\u00020\u001b2\u0006\u0010-\u001a\u00020\t2\n\b\u0002\u0010.\u001a\u0004\u0018\u00010\u0003J\u001a\u0010/\u001a\u00020\u001b2\u0006\u0010-\u001a\u00020\t2\n\b\u0002\u0010.\u001a\u0004\u0018\u00010\u0003J\t\u00100\u001a\u00020\u0003HÖ\u0001R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\u0017\"\u0004\b\u0018\u0010\u0019¨\u00062"}, d2 = {"Lcom/playon/bridge/common/DefaultConsentData;", "", "consentStr", "", "generalConsent", "Lcom/playon/bridge/common/DefaultConsentData$BooleanInt;", "forceRegulationType", "Lcom/playon/bridge/dto/consent/ConsentType;", "isChildDirected", "", "(Ljava/lang/String;Lcom/playon/bridge/common/DefaultConsentData$BooleanInt;Lcom/playon/bridge/dto/consent/ConsentType;Z)V", "getConsentStr", "()Ljava/lang/String;", "setConsentStr", "(Ljava/lang/String;)V", "getForceRegulationType", "()Lcom/playon/bridge/dto/consent/ConsentType;", "setForceRegulationType", "(Lcom/playon/bridge/dto/consent/ConsentType;)V", "getGeneralConsent", "()Lcom/playon/bridge/common/DefaultConsentData$BooleanInt;", "setGeneralConsent", "(Lcom/playon/bridge/common/DefaultConsentData$BooleanInt;)V", "()Z", "setChildDirected", "(Z)V", "clearConsentString", "", "clearForceRegulationType", "component1", "component2", "component3", "component4", "copy", "equals", "other", "type", "hashCode", "", "isGeneralConsentGiven", "processDefaultValues", "mPersonalInfo", "Lcom/playon/bridge/PersonalInfoManager;", TimerController.RESET_COMMAND, "setDoNotSell", "value", "valueStr", "setGdprConsent", "toString", "BooleanInt", "playon_debug"}, k = 1, mv = {1, 1, 13})
public final /* data */ class DefaultConsentData {
    private String consentStr;
    private ConsentType forceRegulationType;
    private BooleanInt generalConsent;
    private boolean isChildDirected;

    /* JADX INFO: compiled from: DefaultConsentData.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/playon/bridge/common/DefaultConsentData$BooleanInt;", "", "(Ljava/lang/String;I)V", "TrueInt", "FalseInt", Profile.DEFAULT_PROFILE_NAME, "playon_debug"}, k = 1, mv = {1, 1, 13})
    public enum BooleanInt {
        TrueInt,
        FalseInt,
        Default
    }

    public DefaultConsentData() {
        this(null, null, null, false, 15, null);
    }

    public static /* synthetic */ DefaultConsentData copy$default(DefaultConsentData defaultConsentData, String str, BooleanInt booleanInt, ConsentType consentType, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            str = defaultConsentData.consentStr;
        }
        if ((i & 2) != 0) {
            booleanInt = defaultConsentData.generalConsent;
        }
        if ((i & 4) != 0) {
            consentType = defaultConsentData.forceRegulationType;
        }
        if ((i & 8) != 0) {
            z = defaultConsentData.isChildDirected;
        }
        return defaultConsentData.copy(str, booleanInt, consentType, z);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getConsentStr() {
        return this.consentStr;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final BooleanInt getGeneralConsent() {
        return this.generalConsent;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final ConsentType getForceRegulationType() {
        return this.forceRegulationType;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final boolean getIsChildDirected() {
        return this.isChildDirected;
    }

    public final DefaultConsentData copy(String consentStr, BooleanInt generalConsent, ConsentType forceRegulationType, boolean isChildDirected) {
        Intrinsics.checkParameterIsNotNull(generalConsent, "generalConsent");
        Intrinsics.checkParameterIsNotNull(forceRegulationType, "forceRegulationType");
        return new DefaultConsentData(consentStr, generalConsent, forceRegulationType, isChildDirected);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DefaultConsentData)) {
            return false;
        }
        DefaultConsentData defaultConsentData = (DefaultConsentData) other;
        return Intrinsics.areEqual(this.consentStr, defaultConsentData.consentStr) && Intrinsics.areEqual(this.generalConsent, defaultConsentData.generalConsent) && Intrinsics.areEqual(this.forceRegulationType, defaultConsentData.forceRegulationType) && this.isChildDirected == defaultConsentData.isChildDirected;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v8, types: [int] */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v6 */
    public int hashCode() {
        String str = this.consentStr;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        BooleanInt booleanInt = this.generalConsent;
        int iHashCode2 = (iHashCode + (booleanInt != null ? booleanInt.hashCode() : 0)) * 31;
        ConsentType consentType = this.forceRegulationType;
        int iHashCode3 = (iHashCode2 + (consentType != null ? consentType.hashCode() : 0)) * 31;
        boolean z = this.isChildDirected;
        ?? r1 = z;
        if (z) {
            r1 = 1;
        }
        return iHashCode3 + r1;
    }

    public String toString() {
        return "DefaultConsentData(consentStr=" + this.consentStr + ", generalConsent=" + this.generalConsent + ", forceRegulationType=" + this.forceRegulationType + ", isChildDirected=" + this.isChildDirected + ")";
    }

    public DefaultConsentData(String str, BooleanInt generalConsent, ConsentType forceRegulationType, boolean z) {
        Intrinsics.checkParameterIsNotNull(generalConsent, "generalConsent");
        Intrinsics.checkParameterIsNotNull(forceRegulationType, "forceRegulationType");
        this.consentStr = str;
        this.generalConsent = generalConsent;
        this.forceRegulationType = forceRegulationType;
        this.isChildDirected = z;
    }

    public /* synthetic */ DefaultConsentData(String str, BooleanInt booleanInt, ConsentType consentType, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? BooleanInt.Default : booleanInt, (i & 4) != 0 ? ConsentType.Undefined : consentType, (i & 8) != 0 ? false : z);
    }

    public final String getConsentStr() {
        return this.consentStr;
    }

    public final void setConsentStr(String str) {
        this.consentStr = str;
    }

    public final BooleanInt getGeneralConsent() {
        return this.generalConsent;
    }

    public final void setGeneralConsent(BooleanInt booleanInt) {
        Intrinsics.checkParameterIsNotNull(booleanInt, "<set-?>");
        this.generalConsent = booleanInt;
    }

    public final ConsentType getForceRegulationType() {
        return this.forceRegulationType;
    }

    public final void setForceRegulationType(ConsentType consentType) {
        Intrinsics.checkParameterIsNotNull(consentType, "<set-?>");
        this.forceRegulationType = consentType;
    }

    public final boolean isChildDirected() {
        return this.isChildDirected;
    }

    public final void setChildDirected(boolean z) {
        this.isChildDirected = z;
    }

    public final boolean isGeneralConsentGiven() {
        return this.generalConsent == BooleanInt.TrueInt;
    }

    public static /* synthetic */ void setDoNotSell$default(DefaultConsentData defaultConsentData, boolean z, String str, int i, Object obj) {
        if ((i & 2) != 0) {
            str = null;
        }
        defaultConsentData.setDoNotSell(z, str);
    }

    public final void setDoNotSell(boolean value, String valueStr) {
        this.consentStr = valueStr;
        this.generalConsent = value ? BooleanInt.FalseInt : BooleanInt.TrueInt;
    }

    public static /* synthetic */ void setGdprConsent$default(DefaultConsentData defaultConsentData, boolean z, String str, int i, Object obj) {
        if ((i & 2) != 0) {
            str = null;
        }
        defaultConsentData.setGdprConsent(z, str);
    }

    public final void setGdprConsent(boolean value, String valueStr) {
        this.consentStr = valueStr;
        this.generalConsent = value ? BooleanInt.TrueInt : BooleanInt.FalseInt;
    }

    private final void reset() {
        this.consentStr = "";
        this.generalConsent = BooleanInt.Default;
        clearForceRegulationType();
    }

    public final void processDefaultValues(PersonalInfoManager mPersonalInfo) {
        Intrinsics.checkParameterIsNotNull(mPersonalInfo, "mPersonalInfo");
        if (!TextUtils.isEmpty(this.consentStr)) {
            mPersonalInfo.setConsentString(this.consentStr);
        }
        if (this.generalConsent != BooleanInt.Default) {
            mPersonalInfo.setGdprConsent(this.generalConsent == BooleanInt.TrueInt, this.consentStr);
        }
        if (this.forceRegulationType != ConsentType.Undefined) {
            mPersonalInfo.forceRegulationType(this.forceRegulationType);
        }
        boolean z = this.isChildDirected;
        if (z) {
            mPersonalInfo.setIsChildDirected(z);
        }
        reset();
    }

    public final void clearForceRegulationType() {
        this.forceRegulationType = ConsentType.Undefined;
    }

    public final void forceRegulationType(ConsentType type) {
        Intrinsics.checkParameterIsNotNull(type, "type");
        this.forceRegulationType = type;
    }

    public final void clearConsentString() {
        this.consentStr = "";
    }
}
