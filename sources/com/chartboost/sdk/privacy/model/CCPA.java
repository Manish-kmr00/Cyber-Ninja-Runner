package com.chartboost.sdk.privacy.model;

import com.amazon.aps.shared.metrics.model.ApsMetricsDataMap;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \f2\u00020\u0001:\u0002\r\fB\u000f\u0012\u0006\u0010\u0003\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\u000e"}, d2 = {"Lcom/chartboost/sdk/privacy/model/CCPA;", "Lcom/chartboost/sdk/privacy/model/GenericDataUseConsent;", "", "consent", "", ApsMetricsDataMap.APSMETRICS_FIELD_CUSTOM, "(Ljava/lang/String;)Z", "getConsent", "()Ljava/lang/String;", "Lcom/chartboost/sdk/privacy/model/CCPA$CCPA_CONSENT;", "<init>", "(Lcom/chartboost/sdk/privacy/model/CCPA$CCPA_CONSENT;)V", "Companion", "CCPA_CONSENT", "ChartboostMonetization-9.8.3_productionRelease"}, k = 1, mv = {1, 8, 0})
public final class CCPA extends GenericDataUseConsent {
    public static final String CCPA_STANDARD = "us_privacy";

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0086\u0001\u0018\u0000 \n2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\nB\u0011\b\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\tR\u0017\u0010\u0007\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/chartboost/sdk/privacy/model/CCPA$CCPA_CONSENT;", "", "", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "Ljava/lang/String;", "getValue", "()Ljava/lang/String;", "value", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "Companion", "OPT_OUT_SALE", "OPT_IN_SALE", "ChartboostMonetization-9.8.3_productionRelease"}, k = 1, mv = {1, 8, 0})
    public enum CCPA_CONSENT {
        OPT_OUT_SALE("1YY-"),
        OPT_IN_SALE("1YN-");


        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);

        /* JADX INFO: renamed from: b, reason: from kotlin metadata */
        public final String value;

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"}, d2 = {"Lcom/chartboost/sdk/privacy/model/CCPA$CCPA_CONSENT$Companion;", "", "()V", "fromValue", "Lcom/chartboost/sdk/privacy/model/CCPA$CCPA_CONSENT;", "value", "", "ChartboostMonetization-9.8.3_productionRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            @JvmStatic
            public final CCPA_CONSENT fromValue(String value) {
                Intrinsics.checkNotNullParameter(value, "value");
                CCPA_CONSENT ccpa_consent = CCPA_CONSENT.OPT_OUT_SALE;
                if (Intrinsics.areEqual(ccpa_consent.getValue(), value)) {
                    return ccpa_consent;
                }
                CCPA_CONSENT ccpa_consent2 = CCPA_CONSENT.OPT_IN_SALE;
                if (Intrinsics.areEqual(ccpa_consent2.getValue(), value)) {
                    return ccpa_consent2;
                }
                return null;
            }

            private Companion() {
            }
        }

        CCPA_CONSENT(String str) {
            this.value = str;
        }

        @JvmStatic
        public static final CCPA_CONSENT fromValue(String str) {
            return INSTANCE.fromValue(str);
        }

        public final String getValue() {
            return this.value;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CCPA(CCPA_CONSENT consent) {
        super(null, 1, 0 == true ? 1 : 0);
        Intrinsics.checkNotNullParameter(consent, "consent");
        if (!c(consent.getValue())) {
            a("Invalid CCPA consent values. Use provided values or Custom class. Value: " + consent);
        } else {
            b("us_privacy");
            a((Object) consent.getValue());
        }
    }

    public final boolean c(String consent) {
        return Intrinsics.areEqual(CCPA_CONSENT.OPT_OUT_SALE.getValue(), consent) || Intrinsics.areEqual(CCPA_CONSENT.OPT_IN_SALE.getValue(), consent);
    }

    @Override // com.chartboost.sdk.privacy.model.DataUseConsent
    public String getConsent() {
        Object objA = getConsentValue();
        Intrinsics.checkNotNull(objA, "null cannot be cast to non-null type kotlin.String");
        return (String) objA;
    }
}
