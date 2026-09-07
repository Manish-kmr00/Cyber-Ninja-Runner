package com.facebook.ads.redexgen.core;

import android.net.Uri;
import android.view.View;

/* JADX INFO: loaded from: assets/audience_network.dex */
public interface JG {
    void A9T();

    boolean A9g();

    boolean A9h();

    boolean AAR();

    void AFz(boolean z, int i);

    void AJ7(int i);

    void AJC(IP ip, int i);

    void AJK(int i);

    void destroy();

    int getCurrentPosition();

    int getDuration();

    long getInitialBufferTime();

    IP getStartReason();

    JI getState();

    int getVideoHeight();

    int getVideoWidth();

    View getView();

    float getVolume();

    void seekTo(int i);

    void setBackgroundPlaybackEnabled(boolean z);

    void setControlsAnchorView(View view);

    void setFullScreen(boolean z);

    void setRequestedVolume(float f);

    void setVideoMPD(String str);

    void setVideoStateChangeListener(JJ jj);

    void setup(Uri uri);
}
