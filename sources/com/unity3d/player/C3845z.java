package com.unity3d.player;

import android.content.Context;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.widget.FrameLayout;

/* JADX INFO: renamed from: com.unity3d.player.z, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes12.dex */
final class C3845z extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private UnityPlayerForActivityOrService f8317a;
    private B0 b;

    public C3845z(Context context, UnityPlayerForActivityOrService unityPlayerForActivityOrService) {
        super(context);
        this.f8317a = unityPlayerForActivityOrService;
        B0 b0 = new B0(unityPlayerForActivityOrService);
        this.b = b0;
        addView(b0);
    }

    public final B0 a() {
        return this.b;
    }

    @Override // android.view.View
    public final boolean onGenericMotionEvent(MotionEvent motionEvent) {
        if (this.b.c()) {
            return false;
        }
        return this.f8317a.injectEvent(motionEvent);
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public final boolean onKeyDown(int i, KeyEvent keyEvent) {
        return this.f8317a.injectEvent(keyEvent);
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public final boolean onKeyLongPress(int i, KeyEvent keyEvent) {
        return this.f8317a.injectEvent(keyEvent);
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public final boolean onKeyMultiple(int i, int i2, KeyEvent keyEvent) {
        return this.f8317a.injectEvent(keyEvent);
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public final boolean onKeyUp(int i, KeyEvent keyEvent) {
        return this.f8317a.injectEvent(keyEvent);
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.b.c()) {
            return false;
        }
        return this.f8317a.injectEvent(motionEvent);
    }
}
