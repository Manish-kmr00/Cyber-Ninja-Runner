package com.moloco.sdk.publisher.privacy;

import com.moloco.sdk.internal.MolocoLogger;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001:\u0001\nB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u0004H\u0007R \u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00048F@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u000b"}, d2 = {"Lcom/moloco/sdk/publisher/privacy/MolocoPrivacy;", "", "()V", "<set-?>", "Lcom/moloco/sdk/publisher/privacy/MolocoPrivacy$PrivacySettings;", "privacySettings", "getPrivacySettings", "()Lcom/moloco/sdk/publisher/privacy/MolocoPrivacy$PrivacySettings;", "setPrivacy", "", "PrivacySettings", "moloco-sdk_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class MolocoPrivacy {
    public static final MolocoPrivacy INSTANCE = new MolocoPrivacy();
    private static PrivacySettings privacySettings = new PrivacySettings(null, null, null, 7, null);
    public static final int $stable = 8;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\b\n\u0000\b\u0007\u0018\u00002\u00020\u0001B/\b\u0010\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bB)\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\tJ\u0013\u0010\u0014\u001a\u00020\u00032\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0016\u001a\u00020\u0017H\u0016R\"\u0010\u000b\u001a\u0004\u0018\u00010\u00072\b\u0010\n\u001a\u0004\u0018\u00010\u0007@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\u00020\u00078BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\rR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u0004\u0010\u0010R\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u0005\u0010\u0010R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u0002\u0010\u0010R\u0011\u0010\u0012\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\u0013\u0010\r¨\u0006\u0018"}, d2 = {"Lcom/moloco/sdk/publisher/privacy/MolocoPrivacy$PrivacySettings;", "", "isUserConsent", "", "isAgeRestrictedUser", "isDoNotSell", "tcfConsent", "", "(Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;)V", "(Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;)V", "<set-?>", "TCFConsent", "getTCFConsent", "()Ljava/lang/String;", "_usPrivacy", "get_usPrivacy", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "usPrivacy", "getUsPrivacy", "equals", "other", "hashCode", "", "moloco-sdk_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class PrivacySettings {
        public static final int $stable = 8;
        private String TCFConsent;
        private final Boolean isAgeRestrictedUser;
        private final Boolean isDoNotSell;
        private final Boolean isUserConsent;

        public PrivacySettings() {
            this(null, null, null, 7, null);
        }

        private final String get_usPrivacy() {
            String str;
            Boolean bool = this.isDoNotSell;
            if (bool == null) {
                str = "1---";
            } else {
                str = Intrinsics.areEqual(bool, Boolean.TRUE) ? "1-Y-" : "1-N-";
            }
            return MolocoPrivacyKt.getUSPrivacyConsentString(str);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof PrivacySettings)) {
                return false;
            }
            PrivacySettings privacySettings = (PrivacySettings) other;
            return Intrinsics.areEqual(this.isUserConsent, privacySettings.isUserConsent) && Intrinsics.areEqual(this.isAgeRestrictedUser, privacySettings.isAgeRestrictedUser) && Intrinsics.areEqual(this.isDoNotSell, privacySettings.isDoNotSell) && Intrinsics.areEqual(this.TCFConsent, privacySettings.TCFConsent);
        }

        public final String getTCFConsent() {
            return this.TCFConsent;
        }

        public final String getUsPrivacy() {
            return get_usPrivacy();
        }

        public int hashCode() {
            Boolean bool = this.isUserConsent;
            int iHashCode = (bool != null ? bool.hashCode() : 0) * 31;
            Boolean bool2 = this.isAgeRestrictedUser;
            int iHashCode2 = (iHashCode + (bool2 != null ? bool2.hashCode() : 0)) * 31;
            Boolean bool3 = this.isDoNotSell;
            int iHashCode3 = (iHashCode2 + (bool3 != null ? bool3.hashCode() : 0)) * 31;
            String str = this.TCFConsent;
            return iHashCode3 + (str != null ? str.hashCode() : 0);
        }

        /* JADX INFO: renamed from: isAgeRestrictedUser, reason: from getter */
        public final Boolean getIsAgeRestrictedUser() {
            return this.isAgeRestrictedUser;
        }

        /* JADX INFO: renamed from: isDoNotSell, reason: from getter */
        public final Boolean getIsDoNotSell() {
            return this.isDoNotSell;
        }

        /* JADX INFO: renamed from: isUserConsent, reason: from getter */
        public final Boolean getIsUserConsent() {
            return this.isUserConsent;
        }

        public PrivacySettings(Boolean bool, Boolean bool2, Boolean bool3) {
            this.isUserConsent = bool;
            this.isAgeRestrictedUser = bool2;
            this.isDoNotSell = bool3;
        }

        public /* synthetic */ PrivacySettings(Boolean bool, Boolean bool2, Boolean bool3, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : bool, (i & 2) != 0 ? null : bool2, (i & 4) != 0 ? null : bool3);
        }

        public PrivacySettings(Boolean bool, Boolean bool2, Boolean bool3, String str) {
            this(bool, bool2, bool3);
            this.TCFConsent = str;
        }
    }

    private MolocoPrivacy() {
    }

    @JvmStatic
    public static final void setPrivacy(PrivacySettings privacySettings2) {
        Intrinsics.checkNotNullParameter(privacySettings2, "privacySettings");
        privacySettings = privacySettings2;
    }

    public final PrivacySettings getPrivacySettings() {
        PrivacySettings privacySettings2 = privacySettings;
        Boolean boolGdprApplies = MolocoPrivacyKt.gdprApplies();
        PrivacySettings privacySettings3 = new PrivacySettings(boolGdprApplies == null ? privacySettings2.getIsUserConsent() : boolGdprApplies, privacySettings2.getIsAgeRestrictedUser(), privacySettings2.getIsDoNotSell(), MolocoPrivacyKt.getTCFConsent());
        if (boolGdprApplies != null) {
            MolocoLogger.info$default(MolocoLogger.INSTANCE, "MolocoPrivacy", "PrivacySettings (isUserConsent/gdpr): " + boolGdprApplies + ", (isAgeRestrictedUser/coppa): " + privacySettings3.getIsAgeRestrictedUser() + ", (isDoNotSell/ccpa): " + privacySettings3.getIsDoNotSell(), null, false, 12, null);
        } else {
            MolocoLogger.info$default(MolocoLogger.INSTANCE, "MolocoPrivacy", "PrivacySettings (isUserConsent/gdpr): " + privacySettings3.getIsUserConsent() + ", (isAgeRestrictedUser/coppa): " + privacySettings3.getIsAgeRestrictedUser() + ", (isDoNotSell/ccpa): " + privacySettings3.getIsDoNotSell(), null, false, 12, null);
        }
        MolocoLogger.info$default(MolocoLogger.INSTANCE, "MolocoPrivacy", "PrivacySettings (TCF): " + privacySettings3.getTCFConsent(), null, false, 12, null);
        return privacySettings3;
    }
}
