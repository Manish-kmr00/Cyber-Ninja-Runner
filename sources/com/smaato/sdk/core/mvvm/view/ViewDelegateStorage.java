package com.smaato.sdk.core.mvvm.view;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes6.dex */
public class ViewDelegateStorage {
    private final Map<UUID, SmaatoSdkViewDelegate> storage = new ConcurrentHashMap();

    public void add(UUID uuid, SmaatoSdkViewDelegate smaatoSdkViewDelegate) {
        this.storage.put(uuid, smaatoSdkViewDelegate);
    }

    public void remove(UUID uuid) {
        this.storage.remove(uuid);
    }

    public SmaatoSdkViewDelegate get(UUID uuid) {
        return this.storage.get(uuid);
    }
}
