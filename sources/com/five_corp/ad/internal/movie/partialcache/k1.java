package com.five_corp.ad.internal.movie.partialcache;

import android.media.MediaFormat;
import com.google.android.gms.common.Scopes;

/* JADX INFO: loaded from: classes9.dex */
public final class k1 extends j1 {
    public MediaFormat m;
    public MediaFormat n;

    public k1(com.five_corp.ad.internal.logger.a aVar) {
        super(aVar);
    }

    public final MediaFormat a() {
        if (this.n == null) {
            C2992a c2992a = this.h;
            if (c2992a == null) {
                return null;
            }
            MediaFormat mediaFormatCreateAudioFormat = MediaFormat.createAudioFormat("audio/mp4a-latm", c2992a.f1464a, c2992a.b);
            mediaFormatCreateAudioFormat.setByteBuffer("csd-0", c2992a.c);
            this.n = mediaFormatCreateAudioFormat;
        }
        return this.n;
    }

    public final MediaFormat b() {
        if (this.m == null) {
            w1 w1Var = this.g;
            if (w1Var == null) {
                return null;
            }
            MediaFormat mediaFormatCreateVideoFormat = MediaFormat.createVideoFormat("video/avc", w1Var.f1505a, w1Var.b);
            mediaFormatCreateVideoFormat.setByteBuffer("csd-0", w1Var.c);
            mediaFormatCreateVideoFormat.setByteBuffer("csd-1", w1Var.d);
            mediaFormatCreateVideoFormat.setInteger(Scopes.PROFILE, w1Var.e);
            mediaFormatCreateVideoFormat.setInteger("level", w1Var.f);
            this.m = mediaFormatCreateVideoFormat;
        }
        return this.m;
    }
}
