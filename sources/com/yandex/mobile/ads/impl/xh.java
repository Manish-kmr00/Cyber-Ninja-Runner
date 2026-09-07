package com.yandex.mobile.ads.impl;

import android.media.AudioTimestamp;
import android.media.AudioTrack;

/* JADX INFO: loaded from: classes6.dex */
final class xh {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final a f10654a;
    private int b;
    private long c;
    private long d;
    private long e;
    private long f;

    public xh(AudioTrack audioTrack) {
        if (x82.f10629a >= 19) {
            this.f10654a = new a(audioTrack);
            f();
        } else {
            this.f10654a = null;
            a(3);
        }
    }

    public final void e() {
        a(4);
    }

    public final void a() {
        if (this.b == 4) {
            f();
        }
    }

    public final boolean d() {
        return this.b == 2;
    }

    public final void f() {
        if (this.f10654a != null) {
            a(0);
        }
    }

    public final long c() {
        a aVar = this.f10654a;
        if (aVar != null) {
            return aVar.a();
        }
        return -9223372036854775807L;
    }

    public final long b() {
        a aVar = this.f10654a;
        if (aVar != null) {
            return aVar.e;
        }
        return -1L;
    }

    private static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final AudioTrack f10655a;
        private final AudioTimestamp b = new AudioTimestamp();
        private long c;
        private long d;
        private long e;

        public a(AudioTrack audioTrack) {
            this.f10655a = audioTrack;
        }

        public final boolean b() {
            boolean timestamp = this.f10655a.getTimestamp(this.b);
            if (timestamp) {
                long j = this.b.framePosition;
                if (this.d > j) {
                    this.c++;
                }
                this.d = j;
                this.e = j + (this.c << 32);
            }
            return timestamp;
        }

        public final long a() {
            return this.b.nanoTime / 1000;
        }
    }

    public final boolean a(long j) {
        a aVar = this.f10654a;
        if (aVar == null || j - this.e < this.d) {
            return false;
        }
        this.e = j;
        boolean zB = aVar.b();
        int i = this.b;
        if (i != 0) {
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        if (i != 4) {
                            throw new IllegalStateException();
                        }
                    } else if (zB) {
                        f();
                    }
                } else if (!zB) {
                    f();
                }
            } else if (!zB) {
                f();
            } else if (this.f10654a.e > this.f) {
                a(2);
            }
        } else if (zB) {
            if (this.f10654a.a() < this.c) {
                return false;
            }
            this.f = this.f10654a.e;
            a(1);
        } else if (j - this.c > 500000) {
            a(3);
        }
        return zB;
    }

    private void a(int i) {
        this.b = i;
        if (i == 0) {
            this.e = 0L;
            this.f = -1L;
            this.c = System.nanoTime() / 1000;
            this.d = 10000L;
            return;
        }
        if (i == 1) {
            this.d = 10000L;
            return;
        }
        if (i == 2 || i == 3) {
            this.d = 10000000L;
        } else {
            if (i != 4) {
                throw new IllegalStateException();
            }
            this.d = 500000L;
        }
    }
}
