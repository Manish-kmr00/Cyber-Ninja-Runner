package com.yandex.mobile.ads.impl;

import android.util.SparseArray;
import com.google.firebase.sessions.settings.RemoteSettings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes11.dex */
public interface i72 {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f9186a;
        public final byte[] b;

        public a(String str, byte[] bArr) {
            this.f9186a = str;
            this.b = bArr;
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f9187a;
        public final List<a> b;
        public final byte[] c;

        public b(int i, String str, ArrayList arrayList, byte[] bArr) {
            this.f9187a = str;
            this.b = arrayList == null ? Collections.emptyList() : Collections.unmodifiableList(arrayList);
            this.c = bArr;
        }
    }

    public interface c {
        SparseArray<i72> a();

        i72 a(int i, b bVar);
    }

    public static final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f9188a;
        private final int b;
        private final int c;
        private int d;
        private String e;

        public final String b() {
            if (this.d != Integer.MIN_VALUE) {
                return this.e;
            }
            throw new IllegalStateException("generateNewId() must be called before retrieving ids.");
        }

        public final int c() {
            int i = this.d;
            if (i != Integer.MIN_VALUE) {
                return i;
            }
            throw new IllegalStateException("generateNewId() must be called before retrieving ids.");
        }

        public d(int i, int i2, int i3) {
            this.f9188a = i != Integer.MIN_VALUE ? i + RemoteSettings.FORWARD_SLASH_STRING : "";
            this.b = i2;
            this.c = i3;
            this.d = Integer.MIN_VALUE;
            this.e = "";
        }

        public final void a() {
            int i = this.d;
            this.d = i == Integer.MIN_VALUE ? this.b : i + this.c;
            this.e = this.f9188a + this.d;
        }
    }

    void a();

    void a(int i, wf1 wf1Var) throws ag1;

    void a(i52 i52Var, y70 y70Var, d dVar);
}
