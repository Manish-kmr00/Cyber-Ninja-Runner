package com.yandex.mobile.ads.impl;

import android.media.MediaDrmException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes13.dex */
public final class m40 implements i60 {
    @Override // com.yandex.mobile.ads.impl.i60
    public final void a(i60.b bVar) {
    }

    @Override // com.yandex.mobile.ads.impl.i60
    public final int b() {
        return 1;
    }

    @Override // com.yandex.mobile.ads.impl.i60
    public final void b(byte[] bArr) {
    }

    @Override // com.yandex.mobile.ads.impl.i60
    public final byte[] c() throws MediaDrmException {
        throw new MediaDrmException("Attempting to open a session using a dummy ExoMediaDrm.");
    }

    @Override // com.yandex.mobile.ads.impl.i60
    public final cv d(byte[] bArr) {
        throw new IllegalStateException();
    }

    @Override // com.yandex.mobile.ads.impl.i60
    public final void release() {
    }

    @Override // com.yandex.mobile.ads.impl.i60
    public final i60.a a(byte[] bArr, List<c40.b> list, int i, HashMap<String, String> map) {
        throw new IllegalStateException();
    }

    @Override // com.yandex.mobile.ads.impl.i60
    public final void c(byte[] bArr) {
        throw new IllegalStateException();
    }

    @Override // com.yandex.mobile.ads.impl.i60
    public final i60.d a() {
        throw new IllegalStateException();
    }

    @Override // com.yandex.mobile.ads.impl.i60
    public final byte[] b(byte[] bArr, byte[] bArr2) {
        throw new IllegalStateException();
    }

    @Override // com.yandex.mobile.ads.impl.i60
    public final Map<String, String> a(byte[] bArr) {
        throw new IllegalStateException();
    }

    @Override // com.yandex.mobile.ads.impl.i60
    public final boolean a(String str, byte[] bArr) {
        throw new IllegalStateException();
    }

    @Override // com.yandex.mobile.ads.impl.i60
    public final void a(byte[] bArr, byte[] bArr2) {
        throw new IllegalStateException();
    }
}
