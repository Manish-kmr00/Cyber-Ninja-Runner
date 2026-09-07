package com.inmobi.media;

import android.os.Handler;
import android.os.Message;
import java.lang.ref.WeakReference;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: com.inmobi.media.k8, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes10.dex */
public final class HandlerC3440k8 extends Handler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WeakReference f3359a;

    public HandlerC3440k8(C3456l8 controller) {
        Intrinsics.checkNotNullParameter(controller, "controller");
        this.f3359a = new WeakReference(controller);
    }

    @Override // android.os.Handler
    public final void handleMessage(Message msg) {
        C3556s8 c3556s8;
        Intrinsics.checkNotNullParameter(msg, "msg");
        if (msg.what != 2) {
            super.handleMessage(msg);
            return;
        }
        C3456l8 c3456l8 = (C3456l8) this.f3359a.get();
        if (c3456l8 != null) {
            C3556s8 c3556s9 = c3456l8.d;
            if (c3556s9 != null) {
                int currentPosition = c3556s9.getCurrentPosition();
                int duration = c3556s9.getDuration();
                if (duration != 0) {
                    c3456l8.h.setProgress((currentPosition * 100) / duration);
                }
            }
            if (c3456l8.e && (c3556s8 = c3456l8.d) != null && c3556s8.isPlaying()) {
                Message messageObtainMessage = obtainMessage(2);
                Intrinsics.checkNotNullExpressionValue(messageObtainMessage, "obtainMessage(...)");
                sendMessageDelayed(messageObtainMessage, 200L);
            }
        }
    }
}
