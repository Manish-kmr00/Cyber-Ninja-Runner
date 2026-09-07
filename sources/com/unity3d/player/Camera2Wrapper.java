package com.unity3d.player;

import android.content.Context;
import android.graphics.Rect;
import android.view.Surface;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes10.dex */
public class Camera2Wrapper implements com.unity3d.player.a.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f8209a;
    private C3839w b = null;

    public Camera2Wrapper(Context context) {
        this.f8209a = context;
        initCamera2Jni();
    }

    private final native void initCamera2Jni();

    private final native void nativeFrameReady(Object obj, Object obj2, Object obj3, int i, int i2, int i3);

    private final native void nativeSurfaceTextureReady(Object obj);

    public final void a(Object obj) {
        nativeSurfaceTextureReady(obj);
    }

    public final void a(ByteBuffer byteBuffer, ByteBuffer byteBuffer2, ByteBuffer byteBuffer3, int i, int i2, int i3) {
        nativeFrameReady(byteBuffer, byteBuffer2, byteBuffer3, i, i2, i3);
    }

    protected void closeCamera2() {
        C3839w c3839w = this.b;
        if (c3839w != null) {
            c3839w.a();
        }
        this.b = null;
    }

    protected int getCamera2Count() {
        return C3839w.a(this.f8209a);
    }

    protected int getCamera2FocalLengthEquivalent(int i) {
        return C3839w.a(this.f8209a, i);
    }

    protected int[] getCamera2Resolutions(int i) {
        return C3839w.b(this.f8209a, i);
    }

    protected int getCamera2SensorOrientation(int i) {
        return C3839w.c(this.f8209a, i);
    }

    protected Rect getFrameSizeCamera2() {
        C3839w c3839w = this.b;
        return c3839w != null ? c3839w.c() : new Rect();
    }

    protected boolean initializeCamera2(int i, int i2, int i3, int i4, int i5, Surface surface) {
        if (this.b != null || UnityPlayer.currentActivity == null) {
            return false;
        }
        C3839w c3839w = new C3839w(this);
        this.b = c3839w;
        return c3839w.a(this.f8209a, i, i2, i3, i4, i5, surface);
    }

    protected boolean isCamera2AutoFocusPointSupported(int i) {
        return C3839w.d(this.f8209a, i);
    }

    protected boolean isCamera2FrontFacing(int i) {
        return C3839w.e(this.f8209a, i);
    }

    protected void pauseCamera2() {
        C3839w c3839w = this.b;
        if (c3839w != null) {
            c3839w.d();
        }
    }

    protected boolean setAutoFocusPoint(float f, float f2) {
        C3839w c3839w = this.b;
        if (c3839w != null) {
            return c3839w.a(f, f2);
        }
        return false;
    }

    protected void startCamera2() {
        C3839w c3839w = this.b;
        if (c3839w != null) {
            c3839w.h();
        }
    }

    protected void stopCamera2() {
        C3839w c3839w = this.b;
        if (c3839w != null) {
            c3839w.i();
        }
    }
}
