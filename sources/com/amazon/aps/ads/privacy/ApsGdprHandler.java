package com.amazon.aps.ads.privacy;

import com.amazon.aps.ads.ApsLog;
import com.amazon.aps.ads.util.ApsAdExtensionsKt;
import com.amazon.aps.shared.ApsMetrics;
import com.amazon.aps.shared.analytics.APSEventSeverity;
import com.amazon.aps.shared.analytics.APSEventType;
import com.amazon.device.ads.DtbSharedPreferences;
import com.iabtcf.decoder.DecoderOption;
import com.iabtcf.decoder.TCString;
import com.iabtcf.v2.PublisherRestriction;
import com.iabtcf.v2.RestrictionType;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: compiled from: ApsGdprHandler.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\r\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u0000 &2\u00020\u0001:\u0001&B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0016\u001a\u00020\u0017J\u0006\u0010\u0018\u001a\u00020\u0004J\u0006\u0010\u0019\u001a\u00020\u0004J\u0006\u0010\u001a\u001a\u00020\u0004J\u0006\u0010\u001b\u001a\u00020\u0004J\u0006\u0010\u001c\u001a\u00020\u0004J\u0006\u0010\u001d\u001a\u00020\u0004J\u0006\u0010\u001e\u001a\u00020\u0004J\u0015\u0010\u001f\u001a\u00020\u00172\b\u0010 \u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010!J\u0015\u0010\u001f\u001a\u00020\u00172\b\u0010 \u001a\u0004\u0018\u00010\u0013¢\u0006\u0002\u0010\"J\u0010\u0010#\u001a\u00020\u00172\b\u0010$\u001a\u0004\u0018\u00010%R\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0005R$\u0010\u0007\u001a\u0004\u0018\u00010\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004@BX\u0086\u000e¢\u0006\n\n\u0002\u0010\u0005\u001a\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001e\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0016\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0005R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0014R\u0012\u0010\u0015\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0014¨\u0006'"}, d2 = {"Lcom/amazon/aps/ads/privacy/ApsGdprHandler;", "", "()V", "isApsVendorConsented", "", "Ljava/lang/Boolean;", "<set-?>", "isGdprApplies", "()Ljava/lang/Boolean;", "isPurpose1Consented", "()Z", "isTcfStringFound", "publisherRestrictions", "", "Lcom/iabtcf/v2/PublisherRestriction;", "purpose1ConsentFlag", "tcString", "Lcom/iabtcf/decoder/TCString;", "tcfVersion", "", "Ljava/lang/Integer;", "vendorListVersion", "calculatePurpose1Consent", "", "isGdprAppliesFalse", "isGdprAppliesTrue", "isPurpose1ConsentFlagOn", "isRestrictedVendorListNotHavingAps", "isValidTcfV2String", "isValidVendorVersion", "isVendorConsentOnForAps", "setGdprApplies", "isApplies", "(Ljava/lang/Boolean;)V", "(Ljava/lang/Integer;)V", "setGdprConsent", "consentString", "", "Companion", "DTBAndroidSDK_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ApsGdprHandler {
    private static int p1CalcCount;
    private Boolean isApsVendorConsented;
    private Boolean isGdprApplies;
    private boolean isPurpose1Consented;
    private boolean isTcfStringFound;
    private List<? extends PublisherRestriction> publisherRestrictions;
    private Boolean purpose1ConsentFlag;
    private TCString tcString;
    private Integer tcfVersion;
    private Integer vendorListVersion;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final int APS_IAB_VENDOR_CONST = 793;
    private static final int APS_SUPPORTED_GVL_VERSION = 25;

    /* JADX INFO: renamed from: isGdprApplies, reason: from getter */
    public final Boolean getIsGdprApplies() {
        return this.isGdprApplies;
    }

    /* JADX INFO: renamed from: isPurpose1Consented, reason: from getter */
    public final boolean getIsPurpose1Consented() {
        return this.isPurpose1Consented;
    }

    /* JADX INFO: renamed from: isTcfStringFound, reason: from getter */
    public final boolean getIsTcfStringFound() {
        return this.isTcfStringFound;
    }

    public final void setGdprApplies(Boolean isApplies) {
        this.isGdprApplies = isApplies;
    }

    public final void setGdprApplies(Integer isApplies) {
        Boolean boolValueOf;
        if (isApplies != null) {
            boolValueOf = Boolean.valueOf(isApplies.intValue() == 1);
        } else {
            boolValueOf = null;
        }
        this.isGdprApplies = boolValueOf;
    }

    public final void setGdprConsent(String consentString) {
        boolean z;
        Boolean boolValueOf;
        Boolean boolValueOf2;
        this.tcString = null;
        this.purpose1ConsentFlag = null;
        this.vendorListVersion = null;
        this.isApsVendorConsented = null;
        this.publisherRestrictions = null;
        this.isTcfStringFound = consentString != null && consentString.length() > 0;
        if (consentString != null) {
            try {
                TCString tCStringDecode = TCString.decode(consentString, new DecoderOption[0]);
                this.tcString = tCStringDecode;
                if (tCStringDecode != null) {
                    this.tcfVersion = Integer.valueOf(tCStringDecode.getVersion());
                    if (tCStringDecode.getPurposesConsent() == null) {
                        boolValueOf = null;
                    } else {
                        boolValueOf = Boolean.valueOf(tCStringDecode.getPurposesConsent().contains(1));
                    }
                    this.purpose1ConsentFlag = boolValueOf;
                    this.vendorListVersion = Integer.valueOf(tCStringDecode.getVendorListVersion());
                    if (tCStringDecode.getVendorConsent() == null) {
                        boolValueOf2 = null;
                    } else {
                        boolValueOf2 = Boolean.valueOf(tCStringDecode.getVendorConsent().contains(APS_IAB_VENDOR_CONST));
                    }
                    this.isApsVendorConsented = boolValueOf2;
                    this.publisherRestrictions = tCStringDecode.getPublisherRestrictions();
                    Unit unit = Unit.INSTANCE;
                }
            } catch (Exception e) {
                ApsAdExtensionsKt.remoteLog(this, APSEventSeverity.FATAL, APSEventType.EXCEPTION, "Error parsing the GDPR String", e);
                Unit unit2 = Unit.INSTANCE;
                z = true;
            } catch (Throwable unused) {
                ApsAdExtensionsKt.remoteLog(this, APSEventSeverity.FATAL, APSEventType.EXCEPTION, "Error parsing the GDPR String", null);
                Unit unit3 = Unit.INSTANCE;
                z = true;
            }
        }
        z = false;
        calculatePurpose1Consent();
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("tcfParseError", z);
            jSONObject.put("nullTcf", consentString == null);
            jSONObject.put("isEmptyTcf", consentString != null && Intrinsics.areEqual(consentString, ""));
            jSONObject.put("isValidTcf", isValidTcfV2String());
            jSONObject.put("p1ConsentFlag", this.purpose1ConsentFlag);
            jSONObject.put("p1Consent", getIsPurpose1Consented());
            jSONObject.put("isEmptyGdprApplies", getIsGdprApplies() == null);
            jSONObject.put("gdprApplies", isGdprAppliesTrue());
            int i = p1CalcCount + 1;
            p1CalcCount = i;
            jSONObject.put("seqCount", i);
            jSONObject.put("gvlVersion", this.vendorListVersion);
            jSONObject.put("isApsVendorConsented", this.isApsVendorConsented);
            jSONObject.put("tcfVersion", this.tcfVersion);
            ApsMetrics.INSTANCE.customEvent("gdprParsing", String.valueOf(DtbSharedPreferences.getInstance().isValidIdfaAvailable()), jSONObject);
        } catch (Exception unused2) {
            ApsLog.e("Error sending the gdpr metrics");
        }
    }

    public final boolean isGdprAppliesTrue() {
        Boolean bool = this.isGdprApplies;
        return bool != null && Intrinsics.areEqual((Object) bool, (Object) true);
    }

    public final boolean isGdprAppliesFalse() {
        Boolean bool = this.isGdprApplies;
        return bool != null && Intrinsics.areEqual((Object) bool, (Object) false);
    }

    public final boolean isValidTcfV2String() {
        Integer num;
        return (this.tcString == null || (num = this.tcfVersion) == null || num == null || num.intValue() != 2) ? false : true;
    }

    public final boolean isPurpose1ConsentFlagOn() {
        Boolean bool = this.purpose1ConsentFlag;
        return bool != null && Intrinsics.areEqual((Object) bool, (Object) true);
    }

    public final boolean isValidVendorVersion() {
        Integer num = this.vendorListVersion;
        if (num == null) {
            return num == null;
        }
        return num.intValue() >= APS_SUPPORTED_GVL_VERSION;
    }

    public final boolean isVendorConsentOnForAps() {
        Boolean bool = this.isApsVendorConsented;
        return bool != null && Intrinsics.areEqual((Object) bool, (Object) true);
    }

    public final boolean isRestrictedVendorListNotHavingAps() {
        List<? extends PublisherRestriction> list = this.publisherRestrictions;
        if (list != null) {
            if (list.isEmpty()) {
                return isVendorConsentOnForAps();
            }
            for (PublisherRestriction publisherRestriction : list) {
                if (publisherRestriction.getPurposeId() == 1 && publisherRestriction.getVendorIds() != null && publisherRestriction.getVendorIds().contains(APS_IAB_VENDOR_CONST) && publisherRestriction.getRestrictionType() != RestrictionType.NOT_ALLOWED && publisherRestriction.getRestrictionType() != RestrictionType.REQUIRE_LEGITIMATE_INTEREST) {
                    return true;
                }
            }
        }
        return isVendorConsentOnForAps();
    }

    public final void calculatePurpose1Consent() {
        this.isPurpose1Consented = (isGdprAppliesTrue() || ((isGdprAppliesFalse() && this.isTcfStringFound) || (this.isGdprApplies == null && this.isTcfStringFound))) && isValidTcfV2String() && isPurpose1ConsentFlagOn() && isValidVendorVersion() && isRestrictedVendorListNotHavingAps();
    }

    /* JADX INFO: compiled from: ApsGdprHandler.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u001a\u0010\t\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lcom/amazon/aps/ads/privacy/ApsGdprHandler$Companion;", "", "()V", "APS_IAB_VENDOR_CONST", "", "getAPS_IAB_VENDOR_CONST", "()I", "APS_SUPPORTED_GVL_VERSION", "getAPS_SUPPORTED_GVL_VERSION", "p1CalcCount", "getP1CalcCount", "setP1CalcCount", "(I)V", "DTBAndroidSDK_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final int getAPS_IAB_VENDOR_CONST() {
            return ApsGdprHandler.APS_IAB_VENDOR_CONST;
        }

        public final int getAPS_SUPPORTED_GVL_VERSION() {
            return ApsGdprHandler.APS_SUPPORTED_GVL_VERSION;
        }

        public final int getP1CalcCount() {
            return ApsGdprHandler.p1CalcCount;
        }

        public final void setP1CalcCount(int i) {
            ApsGdprHandler.p1CalcCount = i;
        }
    }
}
