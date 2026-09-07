package com.unity3d.player;

import android.hardware.camera2.CameraDevice;

/* JADX INFO: renamed from: com.unity3d.player.t, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes12.dex */
final class C3833t extends CameraDevice.StateCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ C3839w f8304a;

    C3833t(C3839w c3839w) {
        this.f8304a = c3839w;
    }

    @Override // android.hardware.camera2.CameraDevice.StateCallback
    public final void onClosed(CameraDevice cameraDevice) {
        C3839w.D.release();
    }

    @Override // android.hardware.camera2.CameraDevice.StateCallback
    public final void onDisconnected(CameraDevice cameraDevice) {
        B.Log(5, "Camera2: CameraDevice disconnected.");
        this.f8304a.a(cameraDevice);
        C3839w.D.release();
    }

    @Override // android.hardware.camera2.CameraDevice.StateCallback
    public final void onError(CameraDevice cameraDevice, int i) {
        B.Log(6, "Camera2: Error opeining CameraDevice " + i);
        this.f8304a.a(cameraDevice);
        C3839w.D.release();
    }

    @Override // android.hardware.camera2.CameraDevice.StateCallback
    public final void onOpened(CameraDevice cameraDevice) {
        this.f8304a.b = cameraDevice;
        C3839w.D.release();
    }
}
