package com.moloco.sdk.internal.services;

import android.content.Context;
import android.media.AudioManager;
import androidx.core.content.ContextCompat;
import com.moloco.sdk.internal.MolocoLogger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class o implements n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AudioManager f6421a;

    public o(Context context) {
        AudioManager audioManager;
        Intrinsics.checkNotNullParameter(context, "context");
        try {
            audioManager = (AudioManager) ContextCompat.getSystemService(context.getApplicationContext(), AudioManager.class);
        } catch (Exception e) {
            MolocoLogger.error$default(MolocoLogger.INSTANCE, p.f6422a, "couldn't get android.media.AudioManager service", e, false, 8, null);
            audioManager = null;
        }
        this.f6421a = audioManager;
    }

    @Override // com.moloco.sdk.internal.services.n
    public z a() {
        AudioManager audioManager = this.f6421a;
        Integer numValueOf = audioManager != null ? Integer.valueOf(audioManager.getRingerMode()) : null;
        if (numValueOf != null && numValueOf.intValue() == 0) {
            return z.SILENT;
        }
        if (numValueOf != null && numValueOf.intValue() == 1) {
            return z.VIBRATE;
        }
        return (numValueOf != null && numValueOf.intValue() == 2) ? z.NORMAL : z.NORMAL;
    }

    @Override // com.moloco.sdk.internal.services.n
    public int b() {
        AudioManager audioManager = this.f6421a;
        if (audioManager != null) {
            return audioManager.getStreamVolume(3);
        }
        return 0;
    }

    @Override // com.moloco.sdk.internal.services.n
    public boolean c() {
        AudioManager audioManager = this.f6421a;
        if (audioManager == null) {
            return false;
        }
        return audioManager.isStreamMute(3);
    }
}
