package com.smaato.sdk.video.vast.parser;

import com.smaato.sdk.core.util.fi.Consumer;
import com.smaato.sdk.video.vast.model.VastBeacon;
import java.util.List;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes12.dex */
public final /* synthetic */ class CompanionParser$$ExternalSyntheticLambda25 implements Consumer {
    public final /* synthetic */ List f$0;

    @Override // com.smaato.sdk.core.util.fi.Consumer
    public final void accept(Object obj) {
        this.f$0.add((VastBeacon) obj);
    }
}
