package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer;

import android.view.View;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.l;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.i;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.j;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.StateFlow;

/* JADX INFO: loaded from: classes12.dex */
public interface d extends j {
    boolean D();

    View M();

    Object a(Continuation<? super Unit> continuation);

    void a(String str);

    void a(boolean z);

    StateFlow<l> e();

    StateFlow<a> isPlaying();

    String m();

    StateFlow<i> o();

    void pause();

    void play();

    void seekTo(long j);
}
