package com.yasirkula.unity;

import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Build;
import android.util.Log;

/* JADX INFO: loaded from: classes13.dex */
public class NativeShareBroadcastListener extends BroadcastReceiver {
    public static IntentSender Initialize(Context context) {
        return PendingIntent.getBroadcast(context, 0, new Intent(context, (Class<?>) NativeShareBroadcastListener.class), Build.VERSION.SDK_INT >= 31 ? 201326592 : 134217728).getIntentSender();
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (NativeShare.shareResultReceiver != null) {
            ComponentName componentName = (ComponentName) intent.getParcelableExtra("android.intent.extra.CHOSEN_COMPONENT");
            if (componentName != null) {
                String strFlattenToString = componentName.flattenToString();
                Log.d("Unity", "Shared on app: " + strFlattenToString);
                NativeShare.shareResultReceiver.OnShareCompleted(1, strFlattenToString);
                return;
            } else {
                Log.d("Unity", "Shared on app: Unknown");
                NativeShare.shareResultReceiver.OnShareCompleted(1, "");
                return;
            }
        }
        Log.e("Unity", "NativeShareResultReceiver was null!");
    }
}
