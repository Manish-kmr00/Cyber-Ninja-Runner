package com.chartboost.sdk.impl;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;

/* JADX INFO: loaded from: classes5.dex */
public class ed {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static d8 f1010a = d8.UNKNOWN;

    public class a extends BroadcastReceiver {
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            d8 d8Var;
            if (intent.getAction() == "android.media.action.HDMI_AUDIO_PLUG") {
                int intExtra = intent.getIntExtra("android.media.extra.AUDIO_PLUG_STATE", -1);
                if (intExtra == 0) {
                    d8Var = d8.NOT_DETECTED;
                } else if (intExtra != 1) {
                    return;
                } else {
                    d8Var = d8.UNKNOWN;
                }
                d8 unused = ed.f1010a = d8Var;
            }
        }
    }

    public static d8 a() {
        return ec.a() != y3.CTV ? d8.UNKNOWN : f1010a;
    }

    public static void a(Context context) {
        context.registerReceiver(new a(), new IntentFilter("android.media.action.HDMI_AUDIO_PLUG"));
    }
}
