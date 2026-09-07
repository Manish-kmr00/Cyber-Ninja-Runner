package com.unity3d.player;

import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CaptureRequest;

/* JADX INFO: renamed from: com.unity3d.player.s, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes12.dex */
final class C3831s extends CameraCaptureSession.StateCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ C3839w f8301a;

    C3831s(C3839w c3839w) {
        this.f8301a = c3839w;
    }

    @Override // android.hardware.camera2.CameraCaptureSession.StateCallback
    public final void onConfigureFailed(CameraCaptureSession cameraCaptureSession) {
        B.Log(6, "Camera2: CaptureSession configuration failed.");
    }

    @Override // android.hardware.camera2.CameraCaptureSession.StateCallback
    public void onConfigured(CameraCaptureSession cameraCaptureSession) {
        StringBuilder sbAppend;
        C3839w c3839w = this.f8301a;
        if (c3839w.b == null) {
            return;
        }
        synchronized (c3839w.s) {
            C3839w c3839w2 = this.f8301a;
            c3839w2.r = cameraCaptureSession;
            try {
                try {
                    c3839w2.q = c3839w2.b.createCaptureRequest(1);
                    C3839w c3839w3 = this.f8301a;
                    c3839w3.q.addTarget(c3839w3.v);
                    C3839w c3839w4 = this.f8301a;
                    c3839w4.q.set(CaptureRequest.CONTROL_AE_TARGET_FPS_RANGE, c3839w4.n);
                    this.f8301a.g();
                } catch (CameraAccessException e) {
                    sbAppend = new StringBuilder("Camera2: CameraAccessException ").append(e);
                    B.Log(6, sbAppend.toString());
                }
            } catch (IllegalStateException e2) {
                sbAppend = new StringBuilder("Camera2: IllegalStateException ").append(e2);
                B.Log(6, sbAppend.toString());
            }
        }
    }
}
