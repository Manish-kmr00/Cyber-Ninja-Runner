package com.yandex.mobile.ads.impl;

import java.io.File;
import java.io.IOException;

/* JADX INFO: loaded from: classes4.dex */
public interface rm {

    public interface b {
        void a(en enVar);

        void a(rm rmVar, en enVar);

        void a(rm rmVar, en enVar, en enVar2);
    }

    File a(String str, long j, long j2) throws a;

    void a(en enVar);

    void a(File file, long j) throws a;

    void a(String str);

    void a(String str, bs bsVar) throws a;

    long b(String str, long j, long j2);

    kz b(String str);

    void b(en enVar);

    en c(String str, long j, long j2) throws a;

    long d(String str, long j, long j2);

    en e(String str, long j, long j2) throws InterruptedException, a;

    public static class a extends IOException {
        public a(String str) {
            super(str);
        }

        public a(String str, Throwable th) {
            super(str, th);
        }

        public a(Throwable th) {
            super(th);
        }
    }
}
