package com.yandex.mobile.ads.impl;

import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r0v49 com.yandex.mobile.ads.impl.sh0[], still in use, count: 1, list:
  (r0v49 com.yandex.mobile.ads.impl.sh0[]) from 0x0370: INVOKE (r0v49 com.yandex.mobile.ads.impl.sh0[]) STATIC call: kotlin.enums.EnumEntriesKt.enumEntries(java.lang.Enum[]):kotlin.enums.EnumEntries A[MD:<E extends java.lang.Enum<E>>:(E extends java.lang.Enum<E>[]):kotlin.enums.EnumEntries<E extends java.lang.Enum<E>> (m)]
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
/* JADX INFO: loaded from: classes6.dex */
public final class sh0 {
    c("x-aab-fetch-url"),
    d("Ad-Width"),
    e("Ad-Height"),
    f("Ad-Type"),
    g("Ad-Id"),
    h("Ad-Info"),
    i("Ad-ShowNotice"),
    j("Ad-ClickTrackingUrls"),
    k("Ad-CloseButtonDelay"),
    l("Ad-ImpressionData"),
    m("Ad-PreloadNativeVideo"),
    n("Ad-PreloadImages"),
    o("Ad-RenderTrackingUrls"),
    p("Ad-Design"),
    q("Ad-Language"),
    r("Ad-Experiments"),
    s("Ad-AbExperiments"),
    t("Ad-Mediation"),
    u("Ad-NoticeDelay"),
    /* JADX INFO: Fake field, exist only in values array */
    EF0("Ad-ClickThrough"),
    v("Ad-ContentType"),
    w("Ad-FalseClickUrl"),
    x("Ad-FalseClickInterval"),
    y("Ad-ServerLogId"),
    z("Ad-PrefetchCount"),
    A("Ad-RefreshPeriod"),
    B("Ad-ReloadTimeout"),
    C("Ad-RewardAmount"),
    D("Ad-RewardDelay"),
    E("Ad-RewardType"),
    F("Ad-RewardUrl"),
    G("Ad-EmptyInterval"),
    H("Ad-Renderer"),
    I("Ad-RotationEnabled"),
    J("Ad-RawVastEnabled"),
    K("Ad-ServerSideReward"),
    L("Ad-SessionData"),
    M("Ad-FeedSessionData"),
    N("Ad-RenderAdIds"),
    O("Ad-ImpressionAdIds"),
    P("Ad-VisibilityPercent"),
    Q("Ad-NonSkippableAdEnabled"),
    R("Ad-AdTypeFormat"),
    S("Ad-ProductType"),
    T("Ad-Source"),
    /* JADX INFO: Fake field, exist only in values array */
    EF0("Location"),
    U("User-Agent"),
    V("encrypted-request"),
    W("Ad-AnalyticsParameters"),
    X("Ad-IncreasedAdSize"),
    Y("Ad-ShouldInvalidateStartup"),
    Z("Ad-DesignFormat"),
    a0("Ad-NativeVideoPreloadingStrategy"),
    b0("Ad-NativeImageLoadingStrategy"),
    c0("Ad-ServerSideClientIP"),
    d0("Ad-OpenLinksInApp"),
    e0("Ad-Base64Encoding"),
    f0("Ad-MediaBase64Encoding"),
    g0("Ad-DivBase64Encoding");

    private final String b;

    static {
        EnumEntriesKt.enumEntries(sh0VarArr);
    }

    public static sh0 valueOf(String str) {
        return (sh0) Enum.valueOf(sh0.class, str);
    }

    public static sh0[] values() {
        return (sh0[]) h0.clone();
    }

    private sh0(String str) {
        super(str, i);
        this.b = str;
    }

    public final String a() {
        return this.b;
    }
}
