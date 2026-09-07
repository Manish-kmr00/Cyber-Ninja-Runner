package com.unity3d.player;

import android.content.Context;
import android.widget.EditText;

/* JADX INFO: renamed from: com.unity3d.player.e0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes10.dex */
final class C3794e0 extends U {
    W h;

    public C3794e0(Context context, UnityPlayerForActivityOrService unityPlayerForActivityOrService) {
        super(context, unityPlayerForActivityOrService);
    }

    @Override // com.unity3d.player.U
    public final void a(String str, int i, boolean z, boolean z2, boolean z3, boolean z4, String str2, int i2, boolean z5, boolean z6) {
        W w = new W(this.f8250a, this.b);
        this.h = w;
        w.a(this, z5, z6);
        this.h.setOnDismissListener(new DialogInterfaceOnDismissListenerC3782a0(this));
        super.a(str, i, z, z2, z3, z4, str2, i2, z5, z6);
        this.b.getFrameLayout().getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserverOnGlobalLayoutListenerC3785b0(this));
        this.c.requestFocus();
        this.h.setOnCancelListener(new DialogInterfaceOnCancelListenerC3788c0(this));
    }

    @Override // com.unity3d.player.U
    public final void a(boolean z) {
        this.d = z;
        this.h.a(z);
    }

    @Override // com.unity3d.player.U
    public final void b() {
        this.h.dismiss();
    }

    @Override // com.unity3d.player.U
    protected EditText createEditText(U u) {
        return new C3791d0(this, this.f8250a, u);
    }

    @Override // com.unity3d.player.U
    public final void d() {
        this.h.show();
    }

    protected void reportSoftInputArea() {
        if (this.h.isShowing()) {
            this.b.reportSoftInputArea(this.h.a());
        }
    }
}
