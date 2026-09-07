package com.inmobi.media;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.lang.ref.WeakReference;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: com.inmobi.media.p8, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes9.dex */
public final class HandlerC3514p8 extends Handler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WeakReference f3398a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HandlerC3514p8(C3556s8 videoView) {
        super(Looper.getMainLooper());
        Intrinsics.checkNotNullParameter(videoView, "videoView");
        this.f3398a = new WeakReference(videoView);
    }

    @Override // android.os.Handler
    public final void handleMessage(Message msg) {
        InterfaceC3486n8 playbackEventListener;
        Intrinsics.checkNotNullParameter(msg, "msg");
        C3556s8 c3556s8 = (C3556s8) this.f3398a.get();
        if (c3556s8 != null && msg.what == 1) {
            int duration = c3556s8.getDuration();
            int currentPosition = c3556s8.getCurrentPosition();
            if (duration != -1 && currentPosition != 0) {
                Object tag = c3556s8.getTag();
                C3426j8 c3426j8 = tag instanceof C3426j8 ? (C3426j8) tag : null;
                if (c3426j8 != null) {
                    Object obj = c3426j8.t.get("didCompleteQ1");
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Boolean");
                    if (!((Boolean) obj).booleanValue() && (currentPosition * 4) - duration >= 0) {
                        c3426j8.t.put("didCompleteQ1", Boolean.TRUE);
                        InterfaceC3500o8 quartileCompletedListener = c3556s8.getQuartileCompletedListener();
                        Intrinsics.checkNotNull(quartileCompletedListener);
                        ((H7) quartileCompletedListener).a((byte) 0);
                    }
                    Object obj2 = c3426j8.t.get("didCompleteQ2");
                    Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.Boolean");
                    if (!((Boolean) obj2).booleanValue() && (currentPosition * 2) - duration >= 0) {
                        c3426j8.t.put("didCompleteQ2", Boolean.TRUE);
                        InterfaceC3500o8 quartileCompletedListener2 = c3556s8.getQuartileCompletedListener();
                        if (quartileCompletedListener2 != null) {
                            ((H7) quartileCompletedListener2).a((byte) 1);
                        }
                    }
                    Object obj3 = c3426j8.t.get("didCompleteQ3");
                    Intrinsics.checkNotNull(obj3, "null cannot be cast to non-null type kotlin.Boolean");
                    if (!((Boolean) obj3).booleanValue() && (currentPosition * 4) - (duration * 3) >= 0) {
                        c3426j8.t.put("didCompleteQ3", Boolean.TRUE);
                        InterfaceC3500o8 quartileCompletedListener3 = c3556s8.getQuartileCompletedListener();
                        if (quartileCompletedListener3 != null) {
                            ((H7) quartileCompletedListener3).a((byte) 2);
                        }
                    }
                    if ((currentPosition / duration) * 100 > c3426j8.D) {
                        Object obj4 = c3426j8.t.get("didQ4Fire");
                        Intrinsics.checkNotNull(obj4, "null cannot be cast to non-null type kotlin.Boolean");
                        if (!((Boolean) obj4).booleanValue() && (playbackEventListener = c3556s8.getPlaybackEventListener()) != null) {
                            ((I7) playbackEventListener).a((byte) 5);
                        }
                    }
                }
            }
            sendEmptyMessageDelayed(1, 1000L);
        }
        super.handleMessage(msg);
    }
}
