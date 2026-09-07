package com.unity3d.player;

import android.content.Context;
import android.widget.FrameLayout;

/* JADX INFO: loaded from: classes12.dex */
final class B0 extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private C3796f f8205a;
    private UnityPlayerForActivityOrService b;
    private M c;

    public B0(UnityPlayerForActivityOrService unityPlayerForActivityOrService) {
        super(unityPlayerForActivityOrService.getContext());
        Context context = unityPlayerForActivityOrService.getContext();
        this.c = new M(context);
        this.b = unityPlayerForActivityOrService;
        C3796f c3796f = new C3796f(unityPlayerForActivityOrService);
        this.f8205a = c3796f;
        c3796f.setId(context.getResources().getIdentifier("unitySurfaceView", "id", context.getPackageName()));
        this.b.applySurfaceViewSettings(this.f8205a);
        this.f8205a.getHolder().addCallback(new A0(this));
        this.f8205a.setFocusable(true);
        this.f8205a.setFocusableInTouchMode(true);
        this.f8205a.setContentDescription(a(context));
        addView(this.f8205a, new FrameLayout.LayoutParams(-1, -1, 17));
    }

    private static String a(Context context) {
        return context.getResources().getString(context.getResources().getIdentifier("game_view_content_description", "string", context.getPackageName()));
    }

    final C3796f a() {
        return this.f8205a;
    }

    final void a(float f) {
        this.f8205a.a(f);
    }

    public final void b() {
        M m = this.c;
        FrameLayout frameLayout = this.b.getFrameLayout();
        L l = m.b;
        if (l != null && l.getParent() != null) {
            frameLayout.removeView(m.b);
        }
        this.c.b = null;
    }

    public final boolean c() {
        C3796f c3796f = this.f8205a;
        return c3796f != null && c3796f.a();
    }
}
