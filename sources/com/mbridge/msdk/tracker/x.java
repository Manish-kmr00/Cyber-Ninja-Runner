package com.mbridge.msdk.tracker;

import android.util.Log;

/* JADX INFO: compiled from: TrackConfig.java */
/* JADX INFO: loaded from: classes7.dex */
public class x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f5667a;
    public final int b;
    public final int c;
    public final int d;
    public final int e;
    public final int f;
    public final p g;
    public final d h;
    public final w i;
    public final f j;

    /* JADX INFO: compiled from: TrackConfig.java */
    public static final class b {
        private p d;
        private d h;
        private w i;
        private f j;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f5668a = 50;
        private int b = 15000;
        private int c = 1;
        private int e = 2;
        private int f = 50;
        private int g = 604800000;

        public b a(int i, p pVar) {
            this.c = i;
            this.d = pVar;
            return this;
        }

        public b b(int i) {
            if (i <= 0) {
                this.f5668a = 50;
            } else {
                this.f5668a = i;
            }
            return this;
        }

        public b c(int i) {
            if (i < 0) {
                this.b = 15000;
            } else {
                this.b = i;
            }
            return this;
        }

        public b d(int i) {
            if (i < 0) {
                this.f = 50;
            } else {
                this.f = i;
            }
            return this;
        }

        public b e(int i) {
            if (i <= 0) {
                this.e = 2;
            } else {
                this.e = i;
            }
            return this;
        }

        public b a(int i) {
            if (i < 0) {
                this.g = 604800000;
            } else {
                this.g = i;
            }
            return this;
        }

        public b a(d dVar) {
            this.h = dVar;
            return this;
        }

        public b a(w wVar) {
            this.i = wVar;
            return this;
        }

        public b a(f fVar) {
            this.j = fVar;
            return this;
        }

        public x a() {
            if (y.b(this.h) && com.mbridge.msdk.tracker.a.f5612a) {
                Log.e("TrackManager", "decorate can not be null");
            }
            if (y.b(this.i) && com.mbridge.msdk.tracker.a.f5612a) {
                Log.e("TrackManager", "responseHandler can not be null");
            }
            if ((y.b(this.d) || y.b(this.d.b())) && com.mbridge.msdk.tracker.a.f5612a) {
                Log.e("TrackManager", "networkStackConfig or stack can not be null");
            }
            return new x(this);
        }
    }

    private x(b bVar) {
        this.f5667a = bVar.f5668a;
        this.b = bVar.b;
        this.c = bVar.c;
        this.d = bVar.e;
        this.e = bVar.f;
        this.f = bVar.g;
        this.g = bVar.d;
        this.h = bVar.h;
        this.i = bVar.i;
        this.j = bVar.j;
    }
}
