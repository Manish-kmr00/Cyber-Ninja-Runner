package com.ogury.ad.internal;

import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r0v21 com.ogury.ad.internal.o7[], still in use, count: 1, list:
  (r0v21 com.ogury.ad.internal.o7[]) from 0x0206: INVOKE (r0v21 com.ogury.ad.internal.o7[]) STATIC call: kotlin.enums.EnumEntriesKt.enumEntries(java.lang.Enum[]):kotlin.enums.EnumEntries A[MD:<E extends java.lang.Enum<E>>:(E extends java.lang.Enum<E>[]):kotlin.enums.EnumEntries<E extends java.lang.Enum<E>> (m)]
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
/* JADX INFO: loaded from: classes14.dex */
public final class o7 {
    LI_001_SDK_EVENT_LOAD("LI-001", "SDK_EVENT_LOAD"),
    LI_002_SDK_EVENT_SEND_ADSYNC_REQUEST("LI-002", "SDK_EVENT_SEND_ADSYNC_REQUEST"),
    LI_003_SDK_EVENT_ADSYNC_RESPONSE_RECEIVED("LI-003", "SDK_EVENT_ADSYNC_RESPONSE_RECEIVED"),
    LI_004_SDK_EVENT_PRECACHE("LI-004", "SDK_EVENT_PRECACHE"),
    LI_005_SDK_EVENT_AD_PRECACHING("LI-005", "SDK_EVENT_AD_PRECACHING"),
    LI_006_SDK_EVENT_AD_PRECACHED_IN_WEBVIEW("LI-006", "SDK_EVENT_AD_PRECACHED_IN_WEBVIEW"),
    LI_007_SDK_EVENT_AD_PRECACHED_ON_FORMAT("LI-007", "SDK_EVENT_AD_PRECACHED_ON_FORMAT"),
    LI_008_SDK_EVENT_AD_PRECACHED("LI-008", "SDK_EVENT_AD_PRECACHED"),
    LI_009_SDK_EVENT_LOADED("LI-009", "SDK_EVENT_LOADED"),
    LI_010_SDK_EVENT_BACKGROUND_UNLOAD("LI-010", "SDK_EVENT_BACKGROUND_UNLOAD"),
    LI_011_SDK_EVENT_WEBVIEW_TERMINATED("LI-011", "SDK_EVENT_WEBVIEW_TERMINATED"),
    LI_012_SDK_EVENT_AD_PARSING("LI-012", "SDK_EVENT_AD_PARSING"),
    LI_013_SDK_EVENT_AD_PARSED("LI-013", "SDK_EVENT_AD_PARSED"),
    LI_014_SDK_EVENT_MRAID_REQUEST("LI-014", "SDK_EVENT_MRAID_REQUEST"),
    SI_001_SDK_EVENT_SHOW("SI-001", "SDK_EVENT_SHOW"),
    SI_002_SDK_EVENT_DISPLAY("SI-002", "SDK_EVENT_DISPLAY"),
    SI_003_SDK_EVENT_AD_DISPLAYING("SI-003", "SDK_EVENT_AD_DISPLAYING"),
    SI_004_SDK_EVENT_AD_CONTAINER_DISPLAYED("SI-004", "SDK_EVENT_AD_CONTAINER_DISPLAYED"),
    SI_005_SDK_EVENT_AD_CREATIVE_DISPLAYED("SI-005", "SDK_EVENT_AD_CREATIVE_DISPLAYED"),
    SI_006_SDK_EVENT_AD_DISPLAYED("SI-006", "SDK_EVENT_AD_DISPLAYED"),
    SI_007_SDK_EVENT_AD_IMPRESSION("SI-007", "SDK_EVENT_AD_IMPRESSION"),
    SI_008_SDK_EVENT_AD_CLICKED("SI-008", "SDK_EVENT_AD_CLICKED"),
    SI_009_SDK_EVENT_AD_OPEN_LANDING_PAGE("SI-009", "SDK_EVENT_AD_OPEN_LANDING_PAGE"),
    SI_010_SDK_EVENT_AD_LANDING_PAGE_OPENED("SI-010", "SDK_EVENT_AD_LANDING_PAGE_OPENED"),
    SI_011_SDK_EVENT_AD_CLOSE_LANDING_PAGE("SI-011", "SDK_EVENT_AD_CLOSE_LANDING_PAGE"),
    SI_012_SDK_EVENT_AD_LANDING_PAGE_CLOSED("SI-012", "SDK_EVENT_AD_LANDING_PAGE_CLOSED"),
    SI_013_SDK_EVENT_AD_CLOSED("SI-013", "SDK_EVENT_AD_CLOSED"),
    SI_014_SDK_EVENT_LAUNCH_BROWSER("SI-014", "SDK_EVENT_LAUNCH_BROWSER"),
    SI_015_SDK_EVENT_FOREGROUND_UNLOAD("SI-015", "SDK_EVENT_FOREGROUND_UNLOAD"),
    SI_017_SDK_EVENT_WEBVIEW_TERMINATED("SI-017", "SDK_EVENT_WEBVIEW_TERMINATED");


    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f7376a;
    public final String b;

    static {
        EnumEntriesKt.enumEntries(o7VarArr);
    }

    public o7(String str, String str2) {
        super(str, i);
        this.f7376a = str;
        this.b = str2;
    }

    public static o7 valueOf(String str) {
        return (o7) Enum.valueOf(o7.class, str);
    }

    public static o7[] values() {
        return (o7[]) G.clone();
    }
}
