package com.smaato.sdk.core.network;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.smaato.sdk.core.util.Objects;
import com.smaato.sdk.core.util.collections.Iterables;
import com.smaato.sdk.core.util.fi.Consumer;
import com.smaato.sdk.core.util.notifier.ChangeNotifier;
import com.smaato.sdk.core.util.notifier.ChangeSender;
import com.smaato.sdk.core.util.notifier.ChangeSenderUtils;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes10.dex */
public final class NetworkStateMonitor {
    private final Set callbacks;
    private final ChangeSender changeSender;
    private final ChangeNotifier.Listener changeSenderListener;
    private final ConnectionStatusWatcher connectionStatusWatcher;
    private final ConnectionStatusWatcher.Callback connectionStatusWatcherCallback;
    private final ConnectivityManager connectivityManager;

    public interface Callback {
        void onNetworkStateChanged(boolean z);
    }

    public NetworkStateMonitor(ConnectivityManager connectivityManager, ConnectionStatusWatcher connectionStatusWatcher) {
        ChangeNotifier.Listener listener = new ChangeNotifier.Listener() { // from class: com.smaato.sdk.core.network.NetworkStateMonitor$$ExternalSyntheticLambda1
            @Override // com.smaato.sdk.core.util.notifier.ChangeNotifier.Listener
            public final void onNextValue(Object obj) {
                this.f$0.notifyCallbacks(((Boolean) obj).booleanValue());
            }
        };
        this.changeSenderListener = listener;
        this.callbacks = Collections.newSetFromMap(new WeakHashMap());
        this.connectivityManager = (ConnectivityManager) Objects.requireNonNull(connectivityManager, "Parameter connectivityManager cannot be null for NetworkStateMonitor::new");
        this.connectionStatusWatcher = (ConnectionStatusWatcher) Objects.requireNonNull(connectionStatusWatcher, "Parameter connectionStatusWatcher cannot be null for NetworkStateMonitor::new");
        ChangeSender changeSenderCreateDebounceChangeSender = ChangeSenderUtils.createDebounceChangeSender(Boolean.valueOf(isOnline()), 500L);
        this.changeSender = changeSenderCreateDebounceChangeSender;
        changeSenderCreateDebounceChangeSender.addListener(listener);
        this.connectionStatusWatcherCallback = new ConnectionStatusWatcher.Callback() { // from class: com.smaato.sdk.core.network.NetworkStateMonitor$$ExternalSyntheticLambda2
            @Override // com.smaato.sdk.core.network.ConnectionStatusWatcher.Callback
            public final void onConnectionStateChanged() {
                this.f$0.m5570lambda$new$0$comsmaatosdkcorenetworkNetworkStateMonitor();
            }
        };
    }

    /* JADX INFO: renamed from: lambda$new$0$com-smaato-sdk-core-network-NetworkStateMonitor, reason: not valid java name */
    /* synthetic */ void m5570lambda$new$0$comsmaatosdkcorenetworkNetworkStateMonitor() {
        this.changeSender.newValue(Boolean.valueOf(isOnline()));
    }

    public synchronized void addCallback(Callback callback) {
        Objects.requireNonNull(callback);
        this.callbacks.add(callback);
        if (!this.callbacks.isEmpty() && !this.connectionStatusWatcher.isCallbackRegistered()) {
            this.connectionStatusWatcher.registerCallback(this.connectionStatusWatcherCallback);
        }
    }

    public synchronized void removeCallback(Callback callback) {
        this.callbacks.remove(callback);
        if (this.callbacks.isEmpty() && this.connectionStatusWatcher.isCallbackRegistered()) {
            this.connectionStatusWatcher.unregisterCallback();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void notifyCallbacks(final boolean z) {
        Iterables.forEach(new HashSet(this.callbacks), new Consumer() { // from class: com.smaato.sdk.core.network.NetworkStateMonitor$$ExternalSyntheticLambda0
            @Override // com.smaato.sdk.core.util.fi.Consumer
            public final void accept(Object obj) {
                ((NetworkStateMonitor.Callback) obj).onNetworkStateChanged(z);
            }
        });
    }

    public boolean isOnline() {
        return isConnected();
    }

    private boolean isConnected() {
        NetworkInfo networkInfo = getNetworkInfo();
        return networkInfo != null && networkInfo.isConnected();
    }

    private NetworkInfo getNetworkInfo() {
        return this.connectivityManager.getActiveNetworkInfo();
    }

    public NetworkConnectionType getNetworkConnectionType() {
        NetworkInfo networkInfo = getNetworkInfo();
        if (networkInfo == null || !networkInfo.isConnected()) {
            return null;
        }
        if (networkInfo.getType() == 1) {
            return NetworkConnectionType.WIFI;
        }
        if (networkInfo.getType() == 0) {
            switch (networkInfo.getSubtype()) {
                case 1:
                case 2:
                case 4:
                case 7:
                case 11:
                case 16:
                    return NetworkConnectionType.CARRIER_2G;
                case 3:
                case 5:
                case 6:
                case 8:
                case 9:
                case 10:
                case 12:
                case 14:
                case 15:
                case 17:
                    return NetworkConnectionType.CARRIER_3G;
                case 13:
                case 18:
                case 19:
                    return NetworkConnectionType.CARRIER_4G;
                default:
                    return NetworkConnectionType.CARRIER_UNKNOWN;
            }
        }
        if (networkInfo.getType() == 9) {
            return NetworkConnectionType.ETHERNET;
        }
        return NetworkConnectionType.OTHER;
    }
}
