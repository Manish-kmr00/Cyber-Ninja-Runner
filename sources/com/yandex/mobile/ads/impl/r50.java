package com.yandex.mobile.ads.impl;

import java.util.Map;
import java.util.UUID;

/* JADX INFO: loaded from: classes11.dex */
public final class r50 implements d40 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final d40.a f10073a;

    @Override // com.yandex.mobile.ads.impl.d40
    public final void a(e40.a aVar) {
    }

    @Override // com.yandex.mobile.ads.impl.d40
    public final void b(e40.a aVar) {
    }

    @Override // com.yandex.mobile.ads.impl.d40
    public final cv getCryptoConfig() {
        return null;
    }

    @Override // com.yandex.mobile.ads.impl.d40
    public final UUID getSchemeUuid() {
        return qm.f10035a;
    }

    @Override // com.yandex.mobile.ads.impl.d40
    public final int getState() {
        return 1;
    }

    @Override // com.yandex.mobile.ads.impl.d40
    public final boolean playClearSamplesWithoutKeys() {
        return false;
    }

    @Override // com.yandex.mobile.ads.impl.d40
    public final Map<String, String> queryKeyStatus() {
        return null;
    }

    @Override // com.yandex.mobile.ads.impl.d40
    public final boolean requiresSecureDecoder(String str) {
        return false;
    }

    public r50(d40.a aVar) {
        this.f10073a = (d40.a) hg.a(aVar);
    }

    @Override // com.yandex.mobile.ads.impl.d40
    public final d40.a getError() {
        return this.f10073a;
    }
}
