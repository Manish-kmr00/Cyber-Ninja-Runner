package com.yandex.mobile.ads.impl;

import android.os.SystemClock;
import android.util.Log;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes7.dex */
public final class li2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f9524a = Log.isLoggable("Volley", 2);

    static class a {
        public static final boolean c = li2.f9524a;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ArrayList f9525a = new ArrayList();
        private boolean b = false;

        a() {
        }

        /* JADX INFO: renamed from: com.yandex.mobile.ads.impl.li2$a$a, reason: collision with other inner class name */
        private static class C0751a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final String f9526a;
            public final long b;
            public final long c;

            public C0751a(String str, long j, long j2) {
                this.f9526a = str;
                this.b = j;
                this.c = j2;
            }
        }

        public final synchronized void a(String str, long j) {
            if (!this.b) {
                this.f9525a.add(new C0751a(str, j, SystemClock.elapsedRealtime()));
            } else {
                throw new IllegalStateException("Marker added to finished log");
            }
        }

        protected final void finalize() throws Throwable {
            if (this.b) {
                return;
            }
            a("Request on the loose");
            op0.b(new Object[0]);
        }

        public final synchronized void a(String str) {
            long j;
            this.b = true;
            if (this.f9525a.size() == 0) {
                j = 0;
            } else {
                long j2 = ((C0751a) this.f9525a.get(0)).c;
                ArrayList arrayList = this.f9525a;
                j = ((C0751a) arrayList.get(arrayList.size() - 1)).c - j2;
            }
            if (j <= 0) {
                return;
            }
            long j3 = ((C0751a) this.f9525a.get(0)).c;
            op0.a(Long.valueOf(j), str);
            for (C0751a c0751a : this.f9525a) {
                long j4 = c0751a.c;
                op0.a(Long.valueOf(j4 - j3), Long.valueOf(c0751a.b), c0751a.f9526a);
                j3 = j4;
            }
        }
    }
}
