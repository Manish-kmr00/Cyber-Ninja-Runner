package com.unity3d.player;

import android.app.Activity;
import android.app.Dialog;
import android.window.OnBackInvokedCallback;
import android.window.OnBackInvokedDispatcher;

/* JADX INFO: loaded from: classes12.dex */
final class F extends E {
    private OnBackInvokedCallback d;
    private OnBackInvokedDispatcher e;
    private int f;

    private F(OnBackInvokedDispatcher onBackInvokedDispatcher, int i, Runnable runnable) {
        super(runnable);
        this.d = null;
        this.f = i;
        this.e = onBackInvokedDispatcher;
    }

    public static E a(Object obj, int i, Runnable runnable) {
        E f = (PlatformSupport.TIRAMISU_SUPPORT && ((obj instanceof Activity) || (obj instanceof Dialog))) ? new F(AbstractC3793e.a(obj), i, runnable) : new E(runnable);
        f.registerOnBackPressedCallback();
        return f;
    }

    @Override // com.unity3d.player.E
    protected void registerOnBackPressedCallback() {
        if (this.f8213a != null) {
            return;
        }
        super.registerOnBackPressedCallback();
        if (PlatformSupport.TIRAMISU_SUPPORT) {
            C3790d c3790d = new C3790d(this.f8213a);
            this.d = c3790d;
            AbstractC3793e.a(this.e, this.f, c3790d);
        }
    }

    @Override // com.unity3d.player.E
    protected void unregisterOnBackPressedCallback() {
        if (this.f8213a != null) {
            if (PlatformSupport.TIRAMISU_SUPPORT) {
                AbstractC3793e.a(this.e, this.d);
                this.d = null;
            }
            super.unregisterOnBackPressedCallback();
        }
    }
}
