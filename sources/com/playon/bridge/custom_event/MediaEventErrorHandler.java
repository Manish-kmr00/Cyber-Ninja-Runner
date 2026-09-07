package com.playon.bridge.custom_event;

import com.playon.bridge.common.Log;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MediaEventErrorHandler.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u0000 \u00072\u00020\u0001:\u0001\u0007B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\b"}, d2 = {"Lcom/playon/bridge/custom_event/MediaEventErrorHandler;", "", "()V", "handleEvent", "", "event", "Lcom/playon/bridge/custom_event/Event;", "Companion", "playon_debug"}, k = 1, mv = {1, 1, 13})
public class MediaEventErrorHandler {
    private static final String TAG = "MediaEventErrorHandler";

    public final void handleEvent(Event event) {
        Intrinsics.checkParameterIsNotNull(event, "event");
        try {
            event.call();
        } catch (Exception e) {
            Log.i(TAG, "Failed to send event", e);
        }
    }
}
