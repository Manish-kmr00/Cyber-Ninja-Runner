package com.bytedance.sdk.openadsdk.core.act;

import android.content.ComponentName;
import androidx.browser.customtabs.CustomTabsClient;
import androidx.browser.customtabs.CustomTabsServiceConnection;

/* JADX INFO: loaded from: classes10.dex */
public class ActServiceConnection extends CustomTabsServiceConnection {
    private Og mConnectionCallback;

    public ActServiceConnection(Og og) {
        this.mConnectionCallback = og;
    }

    @Override // androidx.browser.customtabs.CustomTabsServiceConnection
    public void onCustomTabsServiceConnected(ComponentName componentName, CustomTabsClient customTabsClient) {
        Og og = this.mConnectionCallback;
        if (og != null) {
            og.pA(customTabsClient);
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        Og og = this.mConnectionCallback;
        if (og != null) {
            og.pA();
        }
    }
}
