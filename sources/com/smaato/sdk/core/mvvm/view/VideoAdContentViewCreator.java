package com.smaato.sdk.core.mvvm.view;

import com.smaato.sdk.core.api.ImpressionCountingType;
import com.smaato.sdk.core.ui.AdContentView;
import com.smaato.sdk.core.util.fi.Consumer;

/* JADX INFO: loaded from: classes12.dex */
public interface VideoAdContentViewCreator {
    void createAdContentView(Object obj, boolean z, boolean z2, ImpressionCountingType impressionCountingType, SmaatoSdkViewDelegate smaatoSdkViewDelegate, Consumer<AdContentView> consumer, Consumer<SmaatoSdkViewDelegate.VideoActivityLifecycleListener> consumer2);
}
