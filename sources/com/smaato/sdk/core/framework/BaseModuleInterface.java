package com.smaato.sdk.core.framework;

import com.smaato.sdk.core.di.DiRegistry;

/* JADX INFO: loaded from: classes13.dex */
public interface BaseModuleInterface {
    String moduleDiName();

    DiRegistry moduleDiRegistry();

    String version();
}
