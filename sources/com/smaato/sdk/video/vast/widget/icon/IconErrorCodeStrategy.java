package com.smaato.sdk.video.vast.widget.icon;

import com.smaato.sdk.video.vast.widget.element.VastElementErrorCodeStrategy;
import com.smaato.sdk.video.vast.widget.element.VastElementException;

/* JADX INFO: loaded from: classes2.dex */
public final class IconErrorCodeStrategy implements VastElementErrorCodeStrategy {
    @Override // com.smaato.sdk.video.vast.widget.element.VastElementErrorCodeStrategy
    public int getVastErrorCode(VastElementException vastElementException) {
        return 900;
    }
}
