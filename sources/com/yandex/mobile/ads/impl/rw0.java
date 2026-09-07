package com.yandex.mobile.ads.impl;

import android.os.Handler;
import java.io.IOException;

/* JADX INFO: loaded from: classes4.dex */
public interface rw0 {

    public interface a {
    }

    public static final class b extends nw0 {
        public b(int i, long j, Object obj) {
            super(i, j, obj);
        }

        public b(nw0 nw0Var) {
            super(nw0Var);
        }

        public b(Object obj) {
            super(obj);
        }

        public b(Object obj, int i, int i2, long j) {
            super(obj, i, i2, j);
        }

        public b(Object obj, long j) {
            super(obj, j);
        }
    }

    public interface c {
        void a(rw0 rw0Var, b52 b52Var);
    }

    lw0 a(b bVar, cd cdVar, long j);

    void a(Handler handler, e40 e40Var);

    void a(Handler handler, sw0 sw0Var);

    void a(e40 e40Var);

    void a(lw0 lw0Var);

    void a(c cVar);

    void a(c cVar, w62 w62Var, ii1 ii1Var);

    void a(sw0 sw0Var);

    void b(c cVar);

    void c(c cVar);

    fw0 getMediaItem();

    void maybeThrowSourceInfoRefreshError() throws IOException;
}
