package com.unity3d.player;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Insets;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowInsets;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;

/* JADX INFO: loaded from: classes12.dex */
final class W extends Dialog implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected Context f8255a;
    protected UnityPlayerForActivityOrService b;
    protected S c;
    protected U d;
    private E e;

    public W(Context context, UnityPlayerForActivityOrService unityPlayerForActivityOrService) {
        super(context);
        this.c = null;
        this.d = null;
        this.e = null;
        this.f8255a = context;
        this.b = unityPlayerForActivityOrService;
    }

    public final Rect a() {
        Rect rect = new Rect();
        FrameLayout frameLayout = this.b.getFrameLayout();
        frameLayout.getWindowVisibleDisplayFrame(rect);
        int[] iArr = new int[2];
        frameLayout.getLocationOnScreen(iArr);
        Point point = new Point(rect.left - iArr[0], rect.height() - this.c.getHeight());
        Point point2 = new Point();
        getWindow().getWindowManager().getDefaultDisplay().getSize(point2);
        int height = frameLayout.getHeight();
        int i = height - point2.y;
        int i2 = height - point.y;
        int height2 = this.c.getHeight() + i;
        UnityPlayerForActivityOrService unityPlayerForActivityOrService = this.b;
        if (i2 != height2) {
            unityPlayerForActivityOrService.reportSoftInputIsVisible(true);
        } else {
            unityPlayerForActivityOrService.reportSoftInputIsVisible(false);
        }
        return new Rect(point.x, point.y, this.c.getWidth(), i2);
    }

    public final void a(U u, boolean z, boolean z2) {
        this.d = u;
        Window window = getWindow();
        window.requestFeature(1);
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.gravity = 80;
        attributes.x = 0;
        attributes.y = 0;
        window.setAttributes(attributes);
        b();
        this.c = createSoftInputView(this.d.c);
        window.setLayout(-1, -2);
        window.clearFlags(2);
        window.clearFlags(134217728);
        window.clearFlags(67108864);
        if (!z2) {
            window.addFlags(32);
            window.addFlags(262144);
        }
        a(z);
        getWindow().setSoftInputMode(5);
        this.e = F.a(this, 1000000, new V(this));
    }

    public final void a(boolean z) {
        S s = this.c;
        if (z) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) s.b.getLayoutParams();
            layoutParams.height = 1;
            s.b.setLayoutParams(layoutParams);
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) s.f8247a.getLayoutParams();
            layoutParams2.height = 1;
            s.f8247a.setLayoutParams(layoutParams2);
            Rect rect = s.e;
            s.setPadding(rect.left, rect.top, rect.right, rect.bottom);
            s.setVisibility(4);
        } else {
            s.setVisibility(0);
            Rect rect2 = s.d;
            s.setPadding(rect2.left, rect2.top, rect2.right, rect2.bottom);
            RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) s.b.getLayoutParams();
            layoutParams3.height = -2;
            s.b.setLayoutParams(layoutParams3);
            RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) s.f8247a.getLayoutParams();
            layoutParams4.height = -2;
            s.f8247a.setLayoutParams(layoutParams4);
        }
        s.invalidate();
        s.requestLayout();
    }

    public final void b() {
        ColorDrawable colorDrawable = new ColorDrawable(0);
        if (!PlatformSupport.VANILLA_ICE_CREAM_SUPPORT) {
            getWindow().setBackgroundDrawable(colorDrawable);
            return;
        }
        Insets insets = this.b.getActivity().getWindow().getDecorView().getRootWindowInsets().getInsets(WindowInsets.Type.displayCutout());
        getWindow().setBackgroundDrawable(new InsetDrawable((Drawable) colorDrawable, insets.left, insets.top, insets.right, 0));
    }

    protected S createSoftInputView(EditText editText) {
        S s = new S(this.f8255a, editText);
        s.f8247a.setOnClickListener(this);
        setContentView(s);
        return s;
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public final boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.d.c() || !(motionEvent.getAction() == 4 || this.d.d)) {
            return super.dispatchTouchEvent(motionEvent);
        }
        return true;
    }

    @Override // android.app.Dialog
    public final void onBackPressed() {
        com.unity3d.player.a.e eVar;
        Runnable runnable;
        E e = this.e;
        if (e == null || (eVar = e.f8213a) == null || (runnable = ((D) eVar).f8210a) == null) {
            return;
        }
        runnable.run();
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        U u = this.d;
        u.a(u.a(), false);
    }

    @Override // android.app.Dialog
    public final void onStop() {
        E e = this.e;
        if (e != null) {
            e.unregisterOnBackPressedCallback();
            this.e = null;
        }
        super.onStop();
    }
}
