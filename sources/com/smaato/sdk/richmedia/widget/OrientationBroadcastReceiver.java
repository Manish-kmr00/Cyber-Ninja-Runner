package com.smaato.sdk.richmedia.widget;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import com.smaato.sdk.core.util.Objects;
import com.smaato.sdk.core.util.Whatever;
import com.smaato.sdk.core.util.notifier.ChangeSender;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes13.dex */
public final class OrientationBroadcastReceiver extends BroadcastReceiver {
    private final Context context;
    private final AtomicBoolean isRegistered = new AtomicBoolean();
    private final ChangeSender orientationChangeSender;

    public OrientationBroadcastReceiver(Context context, ChangeSender<Whatever> changeSender) {
        this.context = (Context) Objects.requireNonNull(context);
        this.orientationChangeSender = (ChangeSender) Objects.requireNonNull(changeSender);
    }

    public ChangeSender<Whatever> getOrientationChangeSender() {
        return this.orientationChangeSender;
    }

    public void register() {
        if (this.isRegistered.compareAndSet(false, true)) {
            if (Build.VERSION.SDK_INT >= 33) {
                this.context.registerReceiver(this, new IntentFilter("android.intent.action.CONFIGURATION_CHANGED"), 4);
            } else {
                this.context.registerReceiver(this, new IntentFilter("android.intent.action.CONFIGURATION_CHANGED"));
            }
        }
    }

    public void unregister() {
        if (this.isRegistered.compareAndSet(true, false)) {
            this.context.unregisterReceiver(this);
        }
    }

    public boolean isRegistered() {
        return this.isRegistered.get();
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (intent == null || !"android.intent.action.CONFIGURATION_CHANGED".equals(intent.getAction())) {
            return;
        }
        this.orientationChangeSender.newValue(Whatever.INSTANCE);
    }
}
