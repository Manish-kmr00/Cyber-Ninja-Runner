package com.yandex.mobile.ads.impl;

import android.opengl.EGL14;
import android.opengl.GLES20;
import android.opengl.GLU;
import androidx.work.Data;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

/* JADX INFO: loaded from: classes2.dex */
public final class ne0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final oe0 f9724a = jm1.c();
    public static final /* synthetic */ int b = 0;

    public static int b() {
        if (x82.a(EGL14.eglGetCurrentContext(), EGL14.EGL_NO_CONTEXT)) {
            at0.b("GlUtil", "No current context");
        }
        int[] iArr = new int[1];
        GLES20.glGenTextures(1, iArr, 0);
        a();
        int i = iArr[0];
        GLES20.glBindTexture(36197, i);
        a();
        GLES20.glTexParameteri(36197, Data.MAX_DATA_BYTES, 9729);
        a();
        GLES20.glTexParameteri(36197, 10241, 9729);
        a();
        GLES20.glTexParameteri(36197, 10242, 33071);
        a();
        GLES20.glTexParameteri(36197, 10243, 33071);
        a();
        return i;
    }

    public static boolean c() {
        String strEglQueryString;
        return x82.f10629a >= 17 && (strEglQueryString = EGL14.eglQueryString(EGL14.eglGetDisplay(0), 12373)) != null && strEglQueryString.contains("EGL_KHR_surfaceless_context");
    }

    public static void a() {
        int i = 0;
        while (true) {
            int iGlGetError = GLES20.glGetError();
            if (iGlGetError == 0) {
                break;
            }
            at0.b("GlUtil", "glError: " + GLU.gluErrorString(iGlGetError));
            i = iGlGetError;
        }
        if (i != 0) {
            at0.b("GlUtil", "glError: " + GLU.gluErrorString(i));
        }
    }

    public static FloatBuffer a(float[] fArr) {
        return (FloatBuffer) ByteBuffer.allocateDirect(fArr.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer().put(fArr).flip();
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0042, code lost:
    
        if (new java.lang.String(r3, r7).equals(com.yandex.mobile.ads.impl.x82.d) != false) goto L11;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean a(android.content.Context r8) {
        /*
            int r0 = com.yandex.mobile.ads.impl.x82.f10629a
            r1 = 24
            r2 = 0
            if (r0 >= r1) goto L8
            return r2
        L8:
            r1 = 26
            if (r0 >= r1) goto L45
            com.yandex.mobile.ads.impl.oe0 r3 = com.yandex.mobile.ads.impl.ne0.f9724a
            r3.getClass()
            java.lang.String r4 = "c2Ftc3VuZw=="
            byte[] r4 = android.util.Base64.decode(r4, r2)
            java.lang.String r5 = "decode(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r5)
            java.lang.String r6 = new java.lang.String
            java.nio.charset.Charset r7 = kotlin.text.Charsets.UTF_8
            r6.<init>(r4, r7)
            java.lang.String r4 = com.yandex.mobile.ads.impl.x82.c
            boolean r4 = r6.equals(r4)
            if (r4 != 0) goto L44
            r3.getClass()
            java.lang.String r3 = "WFQxNjUw"
            byte[] r3 = android.util.Base64.decode(r3, r2)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r5)
            java.lang.String r4 = new java.lang.String
            r4.<init>(r3, r7)
            java.lang.String r3 = com.yandex.mobile.ads.impl.x82.d
            boolean r3 = r4.equals(r3)
            if (r3 == 0) goto L45
        L44:
            return r2
        L45:
            if (r0 >= r1) goto L54
            android.content.pm.PackageManager r8 = r8.getPackageManager()
            java.lang.String r0 = "android.hardware.vr.high_performance"
            boolean r8 = r8.hasSystemFeature(r0)
            if (r8 != 0) goto L54
            return r2
        L54:
            android.opengl.EGLDisplay r8 = android.opengl.EGL14.eglGetDisplay(r2)
            r0 = 12373(0x3055, float:1.7338E-41)
            java.lang.String r8 = android.opengl.EGL14.eglQueryString(r8, r0)
            if (r8 == 0) goto L69
            java.lang.String r0 = "EGL_EXT_protected_content"
            boolean r8 = r8.contains(r0)
            if (r8 == 0) goto L69
            r2 = 1
        L69:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.yandex.mobile.ads.impl.ne0.a(android.content.Context):boolean");
    }

    static void a(String str) {
        at0.b("GlUtil", str);
    }
}
