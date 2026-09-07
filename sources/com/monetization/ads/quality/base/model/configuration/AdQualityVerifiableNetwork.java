package com.monetization.ads.quality.base.model.configuration;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r0v7 com.monetization.ads.quality.base.model.configuration.AdQualityVerifiableNetwork[], still in use, count: 1, list:
  (r0v7 com.monetization.ads.quality.base.model.configuration.AdQualityVerifiableNetwork[]) from 0x00e4: INVOKE (r0v7 com.monetization.ads.quality.base.model.configuration.AdQualityVerifiableNetwork[]) STATIC call: kotlin.enums.EnumEntriesKt.enumEntries(java.lang.Enum[]):kotlin.enums.EnumEntries A[MD:<E extends java.lang.Enum<E>>:(E extends java.lang.Enum<E>[]):kotlin.enums.EnumEntries<E extends java.lang.Enum<E>> (m), WRAPPED]
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
/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0013\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013¨\u0006\u0014"}, d2 = {"Lcom/monetization/ads/quality/base/model/configuration/AdQualityVerifiableNetwork;", "", "ADCOLONY", "APPLOVIN", "APPLOVINMAX", "BIGOADS", "CHARTBOOST", "GOOGLE", "ADMOB", "INMOBI", "IRONSOURCE", "LEVELPLAY", "MINTEGRAL", "MYTARGET", "PANGLE", "TAPJOY", "UNITYADS", "VUNGLE", "YANDEX", "UNKNOWN", "mobileads_externalRelease"}, k = 1, mv = {1, 9, 0})
public final class AdQualityVerifiableNetwork {
    ADCOLONY,
    APPLOVIN,
    APPLOVINMAX,
    BIGOADS,
    CHARTBOOST,
    GOOGLE,
    ADMOB,
    INMOBI,
    IRONSOURCE,
    LEVELPLAY,
    MINTEGRAL,
    MYTARGET,
    PANGLE,
    TAPJOY,
    UNITYADS,
    VUNGLE,
    YANDEX,
    UNKNOWN;

    private static final /* synthetic */ EnumEntries $ENTRIES;

    static {
        $ENTRIES = EnumEntriesKt.enumEntries(adQualityVerifiableNetworkArr);
    }

    private AdQualityVerifiableNetwork() {
        super(str, i);
    }

    public static AdQualityVerifiableNetwork valueOf(String str) {
        return (AdQualityVerifiableNetwork) Enum.valueOf(AdQualityVerifiableNetwork.class, str);
    }

    public static AdQualityVerifiableNetwork[] values() {
        return (AdQualityVerifiableNetwork[]) $VALUES.clone();
    }
}
