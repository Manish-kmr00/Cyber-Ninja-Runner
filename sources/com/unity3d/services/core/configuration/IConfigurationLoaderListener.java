package com.unity3d.services.core.configuration;

/* JADX INFO: loaded from: classes13.dex */
public interface IConfigurationLoaderListener {
    void onError(String str);

    void onSuccess(Configuration configuration);
}
