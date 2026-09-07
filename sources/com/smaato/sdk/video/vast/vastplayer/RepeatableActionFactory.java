package com.smaato.sdk.video.vast.vastplayer;

import android.os.Handler;
import com.smaato.sdk.core.util.Objects;
import com.smaato.sdk.video.utils.RepeatableAction;

/* JADX INFO: loaded from: classes13.dex */
public class RepeatableActionFactory {
    private final Handler handler;

    public RepeatableActionFactory(Handler handler) {
        this.handler = (Handler) Objects.requireNonNull(handler);
    }

    public RepeatableAction createRepeatableAction(RepeatableAction.Listener listener) {
        return new RepeatableAction(this.handler, listener);
    }
}
