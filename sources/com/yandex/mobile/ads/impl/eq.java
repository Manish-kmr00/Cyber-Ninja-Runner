package com.yandex.mobile.ads.impl;

import com.smaato.sdk.core.gdpr.CmpApiConstants;
import io.bidmachine.IABSharedPreference;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r0v1 com.yandex.mobile.ads.impl.eq[], still in use, count: 1, list:
  (r0v1 com.yandex.mobile.ads.impl.eq[]) from 0x004d: INVOKE (r0v1 com.yandex.mobile.ads.impl.eq[]) STATIC call: kotlin.enums.EnumEntriesKt.enumEntries(java.lang.Enum[]):kotlin.enums.EnumEntries A[MD:<E extends java.lang.Enum<E>>:(E extends java.lang.Enum<E>[]):kotlin.enums.EnumEntries<E extends java.lang.Enum<E>> (m)]
	at jadx.core.utils.InsnRemover.removeSsaVar(InsnRemover.java:164)
	at jadx.core.utils.InsnRemover.unbindResult(InsnRemover.java:129)
	at jadx.core.utils.InsnRemover.lambda$unbindInsns$1(InsnRemover.java:101)
	at java.base/java.util.ArrayList.forEach(Unknown Source)
	at jadx.core.utils.InsnRemover.unbindInsns(InsnRemover.java:100)
	at jadx.core.utils.InsnRemover.removeAllAndUnbind(InsnRemover.java:257)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:187)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:102)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX INFO: loaded from: classes3.dex */
public final class eq {
    /* JADX INFO: Fake field, exist only in values array */
    EF9(IABSharedPreference.IAB_CONSENT_STRING, "IABTCF_TCString"),
    /* JADX INFO: Fake field, exist only in values array */
    EF21(IABSharedPreference.IAB_SUBJECT_TO_GDPR, "IABTCF_gdprApplies"),
    /* JADX INFO: Fake field, exist only in values array */
    EF33("IABConsent_CMPPresent", CmpApiConstants.IABTCF_CMP_SDK_ID),
    /* JADX INFO: Fake field, exist only in values array */
    EF45("IABConsent_ParsedPurposeConsents", CmpApiConstants.IABTCF_PURPOSE_CONSENTS),
    /* JADX INFO: Fake field, exist only in values array */
    EF57("IABConsent_ParsedVendorConsents", CmpApiConstants.IABTCF_VENDOR_CONSENT),
    /* JADX INFO: Fake field, exist only in values array */
    EF68(null, "IABTCF_AddtlConsent");

    public static final a d;
    private final String b;
    private final String c;

    static {
        EnumEntriesKt.enumEntries(eqVarArr);
        d = new a(0);
    }

    public static eq valueOf(String str) {
        return (eq) Enum.valueOf(eq.class, str);
    }

    public static eq[] values() {
        return (eq[]) e.clone();
    }

    private eq(String str, String str2) {
        super(str, i);
        this.b = str;
        this.c = str2;
    }

    public final String a() {
        return this.b;
    }

    public final String b() {
        return this.c;
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(int i) {
            this();
        }
    }
}
