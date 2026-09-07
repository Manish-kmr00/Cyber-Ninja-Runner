package com.yandex.mobile.ads.impl;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.monetization.ads.instream.view.InstreamMuteView;
import com.monetization.ads.video.playback.view.ExtendedVideoAdControlsContainer;
import com.yandex.mobile.ads.R;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class r00 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final mn0 f10061a;
    private final zs1<ExtendedVideoAdControlsContainer> b;

    public r00(mn0 instreamDesign) {
        Intrinsics.checkNotNullParameter(instreamDesign, "instreamDesign");
        this.f10061a = instreamDesign;
        this.b = new zs1<>();
    }

    public final gb2 a(Context context, ViewGroup rootView) {
        int i;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        mn0 instreamDesign = this.f10061a;
        Intrinsics.checkNotNullParameter(instreamDesign, "instreamDesign");
        int iOrdinal = instreamDesign.ordinal();
        if (iOrdinal == 0) {
            i = R.layout.monetization_ads_internal_instream_skin_v1;
        } else {
            if (iOrdinal != 1) {
                throw new NoWhenBranchMatchedException();
            }
            i = R.layout.monetization_ads_internal_instream_skin_v2;
        }
        this.b.getClass();
        ExtendedVideoAdControlsContainer extendedVideoAdControlsContainer = (ExtendedVideoAdControlsContainer) zs1.a(context, ExtendedVideoAdControlsContainer.class, i, rootView);
        if (extendedVideoAdControlsContainer == null) {
            return null;
        }
        ImageView imageView = (ImageView) extendedVideoAdControlsContainer.findViewById(R.id.sponsored_image);
        ImageView imageView2 = (ImageView) extendedVideoAdControlsContainer.findViewById(R.id.favicon);
        TextView textView = (TextView) extendedVideoAdControlsContainer.findViewById(R.id.call_to_action);
        ImageView imageView3 = (ImageView) extendedVideoAdControlsContainer.findViewById(R.id.instream_call_to_action);
        InstreamMuteView instreamMuteView = (InstreamMuteView) extendedVideoAdControlsContainer.findViewById(R.id.instream_mute);
        ProgressBar progressBar = (ProgressBar) extendedVideoAdControlsContainer.findViewById(R.id.instream_progress_display_view);
        View viewFindViewById = extendedVideoAdControlsContainer.findViewById(R.id.instream_skip);
        TextView textView2 = (TextView) extendedVideoAdControlsContainer.findViewById(R.id.domain);
        TextView textView3 = (TextView) extendedVideoAdControlsContainer.findViewById(R.id.sponsored);
        TextView textView4 = (TextView) extendedVideoAdControlsContainer.findViewById(R.id.ad_position);
        ImageView imageView4 = (ImageView) extendedVideoAdControlsContainer.findViewById(R.id.trademark_icon);
        TextView textView5 = (TextView) extendedVideoAdControlsContainer.findViewById(R.id.trademark_delimiter);
        View viewFindViewById2 = extendedVideoAdControlsContainer.findViewById(R.id.instream_cta_container);
        ImageView imageView5 = (ImageView) extendedVideoAdControlsContainer.findViewById(R.id.feedback);
        TextView textView6 = (TextView) extendedVideoAdControlsContainer.findViewById(R.id.timer_value);
        return new gb2(new gb2.a(extendedVideoAdControlsContainer).d(imageView).b(imageView2).b(textView).a(imageView3).a((v31) instreamMuteView).a(progressBar).b(viewFindViewById).e(textView3).c(textView2).a(textView4).e(imageView4).f(textView5).d(textView6).a(viewFindViewById2).c(imageView5).g((TextView) extendedVideoAdControlsContainer.findViewById(R.id.warning)), 0);
    }
}
