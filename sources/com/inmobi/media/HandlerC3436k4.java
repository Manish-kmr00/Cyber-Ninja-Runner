package com.inmobi.media;

import android.content.Context;
import android.net.wifi.WifiManager;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: com.inmobi.media.k4, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes9.dex */
public final class HandlerC3436k4 extends Handler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f3356a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HandlerC3436k4(Looper looper) {
        super(looper);
        Intrinsics.checkNotNullParameter(looper, "looper");
    }

    @Override // android.os.Handler
    public final void handleMessage(Message msg) {
        Context contextD;
        Intrinsics.checkNotNullParameter(msg, "msg");
        int i = msg.what;
        if (i == 1) {
            Intrinsics.checkNotNullExpressionValue("l4", "access$getTAG$cp(...)");
            sendEmptyMessage(3);
            return;
        }
        if (i == 2) {
            Intrinsics.checkNotNullExpressionValue("l4", "access$getTAG$cp(...)");
            removeMessages(3);
            return;
        }
        if (i != 3) {
            Intrinsics.checkNotNullExpressionValue("l4", "access$getTAG$cp(...)");
            return;
        }
        Intrinsics.checkNotNullExpressionValue("l4", "access$getTAG$cp(...)");
        if (this.f3356a) {
            sendEmptyMessage(2);
            return;
        }
        ud udVar = ud.f3448a;
        ud.b = C3517pb.d();
        Looper looperMyLooper = Looper.myLooper();
        synchronized (udVar) {
            if (ud.c == null && (contextD = C3517pb.d()) != null) {
                Object systemService = contextD.getSystemService(com.json.x8.b);
                WifiManager wifiManager = systemService instanceof WifiManager ? (WifiManager) systemService : null;
                if (wifiManager != null && wifiManager.isWifiEnabled()) {
                    Intrinsics.checkNotNull(looperMyLooper);
                    Handler handler = new Handler(looperMyLooper);
                    ud.c = handler;
                    handler.postDelayed(ud.g, 10000L);
                    if (!ud.d) {
                        ud.d = true;
                        Context context = ud.b;
                        if (context != null) {
                            context.registerReceiver(ud.h, ud.e, null, ud.c);
                        }
                    }
                    wifiManager.startScan();
                }
            }
        }
        sendEmptyMessageDelayed(3, C3601vb.a().getSampleInterval() * 1000);
    }
}
