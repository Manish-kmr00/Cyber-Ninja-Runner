package com.smaato.sdk.video.vast.widget.companion;

import com.smaato.sdk.video.vast.widget.element.VastElementErrorCodeStrategy;
import com.smaato.sdk.video.vast.widget.element.VastElementException;
import com.smaato.sdk.video.vast.widget.element.VastElementLoadingException;

/* JADX INFO: loaded from: classes10.dex */
public final class CompanionErrorCodeStrategy implements VastElementErrorCodeStrategy {
    @Override // com.smaato.sdk.video.vast.widget.element.VastElementErrorCodeStrategy
    public int getVastErrorCode(VastElementException vastElementException) {
        return vastElementException instanceof VastElementLoadingException ? 603 : 900;
    }
}
