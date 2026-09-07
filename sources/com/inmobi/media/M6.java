package com.inmobi.media;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.media.AudioManager;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.core.view.ViewCompat;
import com.inmobi.commons.core.configs.AdConfig;
import com.safedk.android.analytics.brandsafety.creatives.CreativeInfoManager;
import com.safedk.android.utils.Logger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
public final class M6 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Ba f3135a;
    public final L4 b;
    public B6 c;
    public C3638y6 d;
    public C3638y6 e;
    public C3638y6 f;

    public M6(Ba ba, L4 l4) {
        this.f3135a = ba;
        this.b = l4;
    }

    public static final boolean a(View view, MotionEvent motionEvent) {
        return true;
    }

    public static boolean b() {
        Context contextD = C3517pb.d();
        if (contextD == null) {
            return false;
        }
        Object systemService = contextD.getSystemService("audio");
        AudioManager audioManager = systemService instanceof AudioManager ? (AudioManager) systemService : null;
        return audioManager != null && audioManager.isWiredHeadsetOn();
    }

    public final void a(String url, Activity activity) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(activity, "activity");
        L4 l4 = this.b;
        if (l4 != null) {
            ((M4) l4).c("MraidMediaProcessor", "doPlayMedia");
        }
        B6 b6 = new B6(activity, this.b);
        this.c = b6;
        b6.setPlaybackData(url);
        ViewGroup viewGroup = (ViewGroup) activity.findViewById(R.id.content);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.addRule(13);
        B6 b7 = this.c;
        if (b7 != null) {
            b7.setLayoutParams(layoutParams);
        }
        C6 c6 = new C6(activity);
        c6.setOnTouchListener(new View.OnTouchListener() { // from class: com.inmobi.media.M6$$ExternalSyntheticLambda0
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                Logger.d("InMobi|SafeDK: Execution> Lcom/inmobi/media/M6$$ExternalSyntheticLambda0;->onTouch(Landroid/view/View;Landroid/view/MotionEvent;)Z");
                CreativeInfoManager.onViewTouched(com.safedk.android.utils.h.i, view, motionEvent);
                return safedk_M6$$ExternalSyntheticLambda0_onTouch_9459717dd520c5dc1773de243720721c(view, motionEvent);
            }

            public boolean safedk_M6$$ExternalSyntheticLambda0_onTouch_9459717dd520c5dc1773de243720721c(View p0, MotionEvent p1) {
                return M6.a(p0, p1);
            }
        });
        c6.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        c6.addView(this.c);
        L4 l5 = this.b;
        if (l5 != null) {
            ((M4) l5).a("MraidMediaProcessor", "adding media view on top");
        }
        viewGroup.addView(c6, new ViewGroup.LayoutParams(-1, -1));
        B6 b8 = this.c;
        if (b8 != null) {
            b8.setViewContainer(c6);
        }
        B6 b9 = this.c;
        if (b9 != null) {
            b9.requestFocus();
        }
        B6 b10 = this.c;
        if (b10 != null) {
            b10.setOnKeyListener(new View.OnKeyListener() { // from class: com.inmobi.media.M6$$ExternalSyntheticLambda1
                @Override // android.view.View.OnKeyListener
                public final boolean onKey(View view, int i, KeyEvent keyEvent) {
                    return M6.a(this.f$0, view, i, keyEvent);
                }
            });
        }
        B6 b11 = this.c;
        if (b11 != null) {
            b11.setListener(new L6(this));
        }
        B6 b12 = this.c;
        if (b12 != null) {
            b12.a();
        }
    }

    public static final boolean a(M6 this$0, View view, int i, KeyEvent keyEvent) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (4 != i || keyEvent.getAction() != 0) {
            return false;
        }
        B6 b6 = this$0.c;
        if (b6 == null) {
            return true;
        }
        b6.b();
        return true;
    }

    public final int a() {
        AdConfig.RenderingConfig renderingConfig;
        L4 l4 = this.b;
        if (l4 != null) {
            ((M4) l4).c("MraidMediaProcessor", com.ironsource.b9.i.P);
        }
        Context contextD = C3517pb.d();
        if (contextD == null) {
            return -1;
        }
        Ba ba = this.f3135a;
        if (((ba == null || (renderingConfig = ba.getRenderingConfig()) == null) ? false : renderingConfig.getEnablePubMuteControl()) && C3517pb.o()) {
            return 0;
        }
        Object systemService = contextD.getSystemService("audio");
        AudioManager audioManager = systemService instanceof AudioManager ? (AudioManager) systemService : null;
        if (audioManager != null) {
            return audioManager.getStreamVolume(3);
        }
        return -1;
    }
}
