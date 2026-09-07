package com.fyber.inneractive.sdk.bidder;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import com.fyber.inneractive.sdk.util.AbstractC3251o;

/* JADX INFO: renamed from: com.fyber.inneractive.sdk.bidder.f, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes9.dex */
public final class C3058f extends BroadcastReceiver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final InterfaceC3057e f1631a;

    public C3058f(InterfaceC3057e interfaceC3057e) {
        this.f1631a = interfaceC3057e;
    }

    public final void a() {
        AbstractC3251o.f2370a.registerReceiver(this, new IntentFilter("android.media.RINGER_MODE_CHANGED"));
        AbstractC3251o.f2370a.registerReceiver(this, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        AbstractC3251o.f2370a.registerReceiver(this, new IntentFilter("android.app.action.INTERRUPTION_FILTER_CHANGED"));
        AbstractC3251o.f2370a.registerReceiver(this, new IntentFilter("android.os.action.POWER_SAVE_MODE_CHANGED"));
        AbstractC3251o.f2370a.registerReceiver(this, new IntentFilter("android.intent.action.AIRPLANE_MODE"));
        if (AbstractC3251o.a("android.permission.BLUETOOTH")) {
            AbstractC3251o.f2370a.registerReceiver(this, new IntentFilter("android.bluetooth.adapter.action.CONNECTION_STATE_CHANGED"));
            AbstractC3251o.f2370a.registerReceiver(this, new IntentFilter("android.bluetooth.adapter.action.STATE_CHANGED"));
        }
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        boolean z;
        if (intent == null || intent.getAction() == null) {
            return;
        }
        String action = intent.getAction();
        action.getClass();
        action.hashCode();
        switch (action) {
            case "android.intent.action.BATTERY_CHANGED":
                C3054b c3054b = (C3054b) this.f1631a;
                c3054b.b.getClass();
                int intExtra = intent.getIntExtra("plugged", -1);
                z = intExtra == 1 || intExtra == 2 || intExtra == 4;
                Boolean bool = c3054b.c.B;
                if (bool == null || bool.booleanValue() != z) {
                    c3054b.c.B = Boolean.valueOf(z);
                    c3054b.d();
                }
                c3054b.b.getClass();
                if (!TextUtils.equals(c3054b.c.C, com.fyber.inneractive.sdk.serverapi.b.a((intent.getIntExtra("level", -1) * 100) / intent.getIntExtra("scale", -1)))) {
                    C3056d c3056d = c3054b.c;
                    c3054b.b.getClass();
                    c3056d.C = com.fyber.inneractive.sdk.serverapi.b.a((intent.getIntExtra("level", -1) * 100) / intent.getIntExtra("scale", -1));
                    c3054b.d();
                    break;
                }
                break;
            case "android.bluetooth.adapter.action.STATE_CHANGED":
            case "android.bluetooth.adapter.action.CONNECTION_STATE_CHANGED":
                C3054b c3054b2 = (C3054b) this.f1631a;
                c3054b2.getClass();
                Boolean bool2 = intent.getIntExtra("android.bluetooth.adapter.extra.CONNECTION_STATE", Integer.MIN_VALUE) == 2 ? Boolean.TRUE : null;
                C3056d c3056d2 = c3054b2.c;
                if (c3056d2.t != bool2) {
                    c3056d2.t = bool2;
                    c3054b2.d();
                    break;
                }
                break;
            case "android.intent.action.AIRPLANE_MODE":
                C3054b c3054b3 = (C3054b) this.f1631a;
                c3054b3.c.w = Boolean.valueOf(intent.getBooleanExtra("state", false));
                c3054b3.d();
                break;
            case "android.os.action.POWER_SAVE_MODE_CHANGED":
                C3054b c3054b4 = (C3054b) this.f1631a;
                c3054b4.c.u = com.fyber.inneractive.sdk.serverapi.b.n();
                c3054b4.d();
                break;
            case "android.media.RINGER_MODE_CHANGED":
                C3054b c3054b5 = (C3054b) this.f1631a;
                c3054b5.getClass();
                int intExtra2 = intent.getIntExtra("android.media.EXTRA_RINGER_MODE", -1);
                z = intExtra2 == 0 || intExtra2 == 1;
                Boolean bool3 = c3054b5.c.y;
                if (bool3 == null || bool3.booleanValue() != z) {
                    c3054b5.c.y = Boolean.valueOf(z);
                    c3054b5.d();
                    break;
                }
                break;
            case "android.app.action.INTERRUPTION_FILTER_CHANGED":
                ((C3054b) this.f1631a).c();
                break;
        }
    }
}
