package com.smaato.sdk.core.network;

import android.net.ConnectivityManager;
import android.net.Network;
import com.smaato.sdk.core.util.Objects;

/* JADX INFO: loaded from: classes10.dex */
public final class PieConnectionStatusWatcher implements ConnectionStatusWatcher {
    private final ConnectivityManager connectivityManager;
    private SomaNetworkCallback networkCallback;

    public PieConnectionStatusWatcher(ConnectivityManager connectivityManager) {
        this.connectivityManager = (ConnectivityManager) Objects.requireNonNull(connectivityManager);
    }

    @Override // com.smaato.sdk.core.network.ConnectionStatusWatcher
    public void registerCallback(ConnectionStatusWatcher.Callback callback) {
        try {
            if (this.networkCallback != null) {
                unregisterCallback();
            }
            SomaNetworkCallback somaNetworkCallback = new SomaNetworkCallback(callback);
            this.networkCallback = somaNetworkCallback;
            this.connectivityManager.registerDefaultNetworkCallback(somaNetworkCallback);
        } catch (Exception unused) {
        }
    }

    @Override // com.smaato.sdk.core.network.ConnectionStatusWatcher
    public boolean isCallbackRegistered() {
        return this.networkCallback != null;
    }

    @Override // com.smaato.sdk.core.network.ConnectionStatusWatcher
    public void unregisterCallback() {
        try {
            SomaNetworkCallback somaNetworkCallback = this.networkCallback;
            if (somaNetworkCallback != null) {
                this.connectivityManager.unregisterNetworkCallback(somaNetworkCallback);
                this.networkCallback = null;
            }
        } catch (Exception unused) {
        }
    }

    private static final class SomaNetworkCallback extends ConnectivityManager.NetworkCallback {
        private final ConnectionStatusWatcher.Callback callback;

        private SomaNetworkCallback(ConnectionStatusWatcher.Callback callback) {
            this.callback = callback;
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onAvailable(Network network) {
            this.callback.onConnectionStateChanged();
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onLost(Network network) {
            this.callback.onConnectionStateChanged();
        }
    }
}
