package com.yandex.mobile.ads.impl;

import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r0v16 com.yandex.mobile.ads.impl.f5[], still in use, count: 1, list:
  (r0v16 com.yandex.mobile.ads.impl.f5[]) from 0x0184: INVOKE (r0v16 com.yandex.mobile.ads.impl.f5[]) STATIC call: kotlin.enums.EnumEntriesKt.enumEntries(java.lang.Enum[]):kotlin.enums.EnumEntries A[MD:<E extends java.lang.Enum<E>>:(E extends java.lang.Enum<E>[]):kotlin.enums.EnumEntries<E extends java.lang.Enum<E>> (m)]
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
public final class f5 {
    c("adapter_loading_duration"),
    d("advertising_info_loading_duration"),
    e("ad_loading_duration"),
    f("ad_rendering_duration"),
    g("autograb_loading_duration"),
    h("bidding_data_loading_duration"),
    i("identifiers_loading_duration"),
    j("sdk_initialization_duration"),
    k("ad_blocker_detecting_duration"),
    l("sdk_configuration_queue_duration"),
    m("sdk_configuration_loading_duration"),
    n("sdk_configuration_request_queue_duration"),
    o("sdk_configuration_request_duration"),
    p("resources_loading_duration"),
    q("image_loading_duration"),
    r("video_caching_duration"),
    s("web_view_caching_duration"),
    t("network_request_queue_duration"),
    u("network_request_durations"),
    v("vast_loading_durations"),
    w("video_ad_rendering_duration"),
    x("video_ad_prepare_duration"),
    y("vmap_loading_duration"),
    z("bidder_token_loading_duration"),
    A("bidder_token_generation_duration"),
    B("dns_prefetch_duration");

    private final String b;

    static {
        EnumEntriesKt.enumEntries(f5VarArr);
    }

    public static f5 valueOf(String str) {
        return (f5) Enum.valueOf(f5.class, str);
    }

    public static f5[] values() {
        return (f5[]) C.clone();
    }

    private f5(String str) {
        super(str, i);
        this.b = str;
    }

    public final String a() {
        return this.b;
    }
}
