package com.smaato.sdk.core.network;

import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import com.smaato.sdk.core.util.Objects;

/* JADX INFO: loaded from: classes12.dex */
public final class BaseConnectionStatusWatcher implements ConnectionStatusWatcher {
    private final Application application;
    private ConnectionBroadcastReceiver broadcastReceiver;

    public BaseConnectionStatusWatcher(Application application) {
        this.application = (Application) Objects.requireNonNull(application);
    }

    @Override // com.smaato.sdk.core.network.ConnectionStatusWatcher
    public void registerCallback(ConnectionStatusWatcher.Callback callback) {
        if (this.broadcastReceiver != null) {
            unregisterCallback();
        }
        ConnectionBroadcastReceiver connectionBroadcastReceiver = new ConnectionBroadcastReceiver(callback);
        this.broadcastReceiver = connectionBroadcastReceiver;
        if (Build.VERSION.SDK_INT >= 33) {
            this.application.registerReceiver(connectionBroadcastReceiver, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"), 4);
        } else {
            this.application.registerReceiver(connectionBroadcastReceiver, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
        }
    }

    @Override // com.smaato.sdk.core.network.ConnectionStatusWatcher
    public boolean isCallbackRegistered() {
        return this.broadcastReceiver != null;
    }

    @Override // com.smaato.sdk.core.network.ConnectionStatusWatcher
    public void unregisterCallback() {
        ConnectionBroadcastReceiver connectionBroadcastReceiver = this.broadcastReceiver;
        if (connectionBroadcastReceiver != null) {
            this.application.unregisterReceiver(connectionBroadcastReceiver);
            this.broadcastReceiver = null;
        }
    }

    private static final class ConnectionBroadcastReceiver extends BroadcastReceiver {
        private final ConnectionStatusWatcher.Callback callback;

        public ConnectionBroadcastReceiver(ConnectionStatusWatcher.Callback callback) {
            this.callback = callback;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            this.callback.onConnectionStateChanged();
        }
    }
}
