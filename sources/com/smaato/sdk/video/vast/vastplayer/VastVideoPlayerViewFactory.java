package com.smaato.sdk.video.vast.vastplayer;

import android.content.Context;
import com.smaato.sdk.video.vast.model.Verification;
import com.smaato.sdk.video.vast.widget.VastVideoAdPlayerView;
import java.util.List;

/* JADX INFO: loaded from: classes9.dex */
public class VastVideoPlayerViewFactory {
    VastVideoAdPlayerView getVastVideoPlayerView(Context context, List<Verification> list) {
        return new VastVideoAdPlayerView(context, list);
    }
}
