package com.yandex.mobile.ads.impl;

import android.opengl.GLES20;
import java.nio.Buffer;
import java.nio.FloatBuffer;

/* JADX INFO: loaded from: classes7.dex */
final class fm1 {
    private static final float[] i = {1.0f, 0.0f, 0.0f, 0.0f, -1.0f, 0.0f, 0.0f, 1.0f, 1.0f};
    private static final float[] j = {1.0f, 0.0f, 0.0f, 0.0f, -0.5f, 0.0f, 0.0f, 0.5f, 1.0f};
    private static final float[] k = {0.5f, 0.0f, 0.0f, 0.0f, -1.0f, 0.0f, 0.0f, 1.0f, 1.0f};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f8908a;
    private a b;
    private me0 c;
    private int d;
    private int e;
    private int f;
    private int g;
    private int h;

    public final void a(int i2, float[] fArr) {
        float[] fArr2;
        a aVar = this.b;
        if (aVar == null) {
            return;
        }
        int i3 = this.f8908a;
        if (i3 == 1) {
            fArr2 = j;
        } else {
            fArr2 = i3 == 2 ? k : i;
        }
        GLES20.glUniformMatrix3fv(this.e, 1, false, fArr2, 0);
        GLES20.glUniformMatrix4fv(this.d, 1, false, fArr, 0);
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(36197, i2);
        GLES20.glUniform1i(this.h, 0);
        ne0.a();
        GLES20.glVertexAttribPointer(this.f, 3, 5126, false, 12, (Buffer) aVar.b);
        ne0.a();
        GLES20.glVertexAttribPointer(this.g, 2, 5126, false, 8, (Buffer) aVar.c);
        ne0.a();
        GLES20.glDrawArrays(aVar.d, 0, aVar.f8909a);
        ne0.a();
    }

    fm1() {
    }

    public final void a() {
        me0 me0Var = new me0();
        this.c = me0Var;
        this.d = me0Var.b("uMvpMatrix");
        this.e = this.c.b("uTexMatrix");
        this.f = this.c.a("aPosition");
        this.g = this.c.a("aTexCoords");
        this.h = this.c.b("uTexture");
    }

    public final void a(dm1 dm1Var) {
        dm1.a aVar = dm1Var.f8710a;
        dm1.a aVar2 = dm1Var.b;
        if (aVar.b() == 1 && aVar.a().f8712a == 0 && aVar2.b() == 1 && aVar2.a().f8712a == 0) {
            this.f8908a = dm1Var.c;
            this.b = new a(dm1Var.f8710a.a());
            if (dm1Var.d) {
                return;
            }
            new a(dm1Var.b.a());
        }
    }

    private static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f8909a;
        private final FloatBuffer b;
        private final FloatBuffer c;
        private final int d;

        public a(dm1.b bVar) {
            this.f8909a = bVar.a();
            this.b = ne0.a(bVar.c);
            this.c = ne0.a(bVar.d);
            int i = bVar.b;
            if (i == 1) {
                this.d = 5;
            } else if (i != 2) {
                this.d = 4;
            } else {
                this.d = 6;
            }
        }
    }
}
