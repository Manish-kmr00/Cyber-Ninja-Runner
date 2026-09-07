package io.bidmachine.rendering.internal.adform.video.player;

import android.net.Uri;
import android.view.View;
import io.bidmachine.rendering.internal.o;
import io.bidmachine.rendering.internal.s;

/* JADX INFO: loaded from: classes9.dex */
public interface b extends o, s {
    void a();

    void a(Uri uri);

    void a(d dVar);

    long g();

    float getVolume();

    long h();

    View o();

    void pause();

    void play();

    void prepare();
}
