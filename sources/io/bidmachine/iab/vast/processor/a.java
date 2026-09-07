package io.bidmachine.iab.vast.processor;

import io.bidmachine.iab.vast.tags.VastXmlTag;

/* JADX INFO: loaded from: classes9.dex */
class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f12313a;
    private final boolean b;
    private final boolean c;

    a() {
        this(true, true, true);
    }

    boolean a() {
        return this.b;
    }

    boolean b() {
        return this.c;
    }

    boolean c() {
        return this.f12313a;
    }

    a(VastXmlTag vastXmlTag) {
        this(vastXmlTag.getBooleanAttributeValueByName("followAdditionalWrappers", true), vastXmlTag.getBooleanAttributeValueByName("allowMultipleAds", true), vastXmlTag.getBooleanAttributeValueByName("fallbackOnNoAd", true));
    }

    private a(boolean followAdditionalWrappers, boolean allowMultipleAds, boolean fallbackOnNoAd) {
        this.f12313a = followAdditionalWrappers;
        this.b = allowMultipleAds;
        this.c = fallbackOnNoAd;
    }
}
