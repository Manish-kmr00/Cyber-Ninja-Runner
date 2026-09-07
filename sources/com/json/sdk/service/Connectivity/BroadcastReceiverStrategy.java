package com.json.sdk.service.Connectivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.util.Log;
import com.json.Cif;
import com.json.hf;
import com.json.mediationsdk.logger.IronLog;
import com.json.o9;
import com.json.y8;
import com.safedk.android.internal.partials.IronSourceNetworkBridge;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes11.dex */
public class BroadcastReceiverStrategy implements hf {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Cif f4400a;
    private BroadcastReceiver b = new BroadcastReceiver() { // from class: com.ironsource.sdk.service.Connectivity.BroadcastReceiverStrategy.1
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String strB = y8.b(context);
            if (strB.equals("none")) {
                BroadcastReceiverStrategy.this.f4400a.a();
            } else {
                BroadcastReceiverStrategy.this.f4400a.a(strB, IronSourceNetworkBridge.jsonObjectInit());
            }
        }
    };

    public BroadcastReceiverStrategy(Cif cif) {
        this.f4400a = cif;
    }

    @Override // com.json.hf
    public void a() {
        this.b = null;
    }

    @Override // com.json.hf
    public void a(Context context) {
        try {
            context.unregisterReceiver(this.b);
        } catch (IllegalArgumentException e) {
            o9.d().a(e);
        } catch (Exception e2) {
            o9.d().a(e2);
            Log.e("ContentValues", "unregisterConnectionReceiver - " + e2);
        }
    }

    @Override // com.json.hf
    public void b(Context context) {
        try {
            context.registerReceiver(this.b, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
        } catch (Exception e) {
            o9.d().a(e);
            IronLog.INTERNAL.error(e.toString());
        }
    }

    @Override // com.json.hf
    public JSONObject c(Context context) {
        return IronSourceNetworkBridge.jsonObjectInit();
    }
}
