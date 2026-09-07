package io.bidmachine.rendering.internal.adform.video.player;

import android.content.Context;
import io.bidmachine.rendering.internal.m;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f12338a = new c();

    private c() {
    }

    public static final b a(Context context, String str) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (Intrinsics.areEqual(str, "exo")) {
            m.b("PlayerFactory", "Create player (ExoPlayerImpl)", new Object[0]);
            return new io.bidmachine.rendering.internal.adform.video.player.exo.a(context);
        }
        m.b("PlayerFactory", "Create player (MediaPlayerImpl)", new Object[0]);
        return new io.bidmachine.rendering.internal.adform.video.player.media.a(context);
    }
}
