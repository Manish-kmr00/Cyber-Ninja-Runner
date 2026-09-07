package com.yandex.mobile.ads.impl;

import android.media.DeniedByServerException;
import android.media.MediaCryptoException;
import android.media.MediaDrmException;
import android.media.NotProvisionedException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/* JADX INFO: loaded from: classes8.dex */
public interface i60 {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final byte[] f9180a;
        private final String b;

        public a(String str, byte[] bArr) {
            this.f9180a = bArr;
            this.b = str;
        }

        public final byte[] a() {
            return this.f9180a;
        }

        public final String b() {
            return this.b;
        }
    }

    public interface b {
    }

    public interface c {
        i60 a(UUID uuid);
    }

    public static final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final byte[] f9181a;
        private final String b;

        public d(String str, byte[] bArr) {
            this.f9181a = bArr;
            this.b = str;
        }

        public final byte[] a() {
            return this.f9181a;
        }

        public final String b() {
            return this.b;
        }
    }

    a a(byte[] bArr, List<c40.b> list, int i, HashMap<String, String> map) throws NotProvisionedException;

    d a();

    Map<String, String> a(byte[] bArr);

    void a(b bVar);

    default void a(byte[] bArr, ii1 ii1Var) {
    }

    void a(byte[] bArr, byte[] bArr2);

    boolean a(String str, byte[] bArr);

    int b();

    void b(byte[] bArr);

    byte[] b(byte[] bArr, byte[] bArr2) throws DeniedByServerException, NotProvisionedException;

    void c(byte[] bArr) throws DeniedByServerException;

    byte[] c() throws MediaDrmException;

    cv d(byte[] bArr) throws MediaCryptoException;

    void release();
}
