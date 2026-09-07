package com.yandex.mobile.ads.impl;

import android.media.MediaCodec;
import android.media.MediaDrmResetException;
import android.media.ResourceBusyException;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.ExoTimeoutException;
import com.google.android.exoplayer2.IllegalSeekPositionException;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.audio.AudioSink;
import com.google.android.exoplayer2.audio.DefaultAudioSink;
import com.google.android.exoplayer2.drm.DrmSession;
import com.google.android.exoplayer2.drm.KeysExpiredException;
import com.google.android.exoplayer2.mediacodec.MediaCodecRenderer;
import com.google.android.exoplayer2.mediacodec.MediaCodecUtil;
import com.google.android.exoplayer2.source.BehindLiveWindowException;
import com.google.android.exoplayer2.text.SubtitleDecoderException;
import com.google.android.exoplayer2.upstream.HttpDataSource;
import com.google.android.exoplayer2.upstream.Loader;
import com.google.android.exoplayer2.upstream.cache.Cache;
import com.google.android.exoplayer2.upstream.cache.CacheDataSink;
import com.google.android.exoplayer2.video.MediaCodecVideoDecoderException;
import javax.net.ssl.SSLHandshakeException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class eb {
    public static pc2 c(Throwable throwable) {
        Intrinsics.checkNotNullParameter(throwable, "throwable");
        return new pc2(a(throwable), throwable);
    }

    private static pc2.a a(Throwable th) {
        pc2.a aVar;
        if (th instanceof ExoPlaybackException) {
            pc2.a aVarB = b(th);
            if (aVarB != null) {
                return aVarB;
            }
            Throwable cause = th.getCause();
            pc2.a aVarA = cause != null ? a(cause) : null;
            if (aVarA != null) {
                return aVarA;
            }
            aVar = pc2.a.D;
        } else if (th instanceof ExoTimeoutException) {
            aVar = pc2.a.i;
        } else if (th instanceof IllegalSeekPositionException) {
            aVar = pc2.a.j;
        } else if (th instanceof MediaCodecUtil.DecoderQueryException) {
            aVar = pc2.a.k;
        } else if (th instanceof MediaCodecRenderer.DecoderInitializationException) {
            aVar = pc2.a.l;
        } else if (th instanceof MediaCodecVideoDecoderException) {
            pc2.a aVarB2 = b(th);
            if (aVarB2 != null) {
                return aVarB2;
            }
            aVar = pc2.a.m;
        } else if (th instanceof BehindLiveWindowException) {
            aVar = pc2.a.n;
        } else if (th instanceof MediaCodec.CryptoException) {
            aVar = pc2.a.o;
        } else if (th instanceof DrmSession.DrmSessionException) {
            Throwable cause2 = ((DrmSession.DrmSessionException) th).getCause();
            if (cause2 == null) {
                aVar = pc2.a.q;
            } else if ((cause2 instanceof MediaDrmResetException) || (cause2 instanceof ResourceBusyException)) {
                aVar = pc2.a.p;
            } else {
                aVar = ((cause2 instanceof MediaCodec.CryptoException) || (cause2 instanceof KeysExpiredException)) ? pc2.a.o : pc2.a.q;
            }
        } else if (th instanceof HttpDataSource.CleartextNotPermittedException) {
            aVar = pc2.a.r;
        } else if (th instanceof HttpDataSource.InvalidResponseCodeException) {
            int i = ((HttpDataSource.InvalidResponseCodeException) th).responseCode;
            if (i == 401) {
                aVar = pc2.a.s;
            } else if (i != 403) {
                aVar = i != 404 ? pc2.a.v : pc2.a.u;
            } else {
                aVar = pc2.a.t;
            }
        } else if (th instanceof HttpDataSource.HttpDataSourceException) {
            aVar = ((HttpDataSource.HttpDataSourceException) th).getCause() instanceof SSLHandshakeException ? pc2.a.w : pc2.a.x;
        } else if (th instanceof ParserException) {
            aVar = pc2.a.y;
        } else if (th instanceof Loader.UnexpectedLoaderException) {
            aVar = pc2.a.z;
        } else if ((th instanceof AudioSink.ConfigurationException) || (th instanceof AudioSink.InitializationException) || (th instanceof DefaultAudioSink.InvalidAudioTrackTimestampException)) {
            aVar = pc2.a.A;
        } else if (th instanceof SubtitleDecoderException) {
            aVar = pc2.a.B;
        } else {
            aVar = ((th instanceof Cache.CacheException) || (th instanceof CacheDataSink.CacheDataSinkException)) ? pc2.a.C : pc2.a.D;
        }
        return aVar;
    }

    private static pc2.a b(Throwable th) {
        Throwable cause = th.getCause();
        if (cause == null) {
            return null;
        }
        boolean z = cause instanceof MediaCodec.CodecException;
        if (!z && !(cause instanceof IllegalStateException) && !(cause instanceof IllegalArgumentException)) {
            return null;
        }
        StackTraceElement[] stackTrace = cause.getStackTrace();
        Intrinsics.checkNotNull(stackTrace);
        if ((stackTrace.length == 0) || !stackTrace[0].isNativeMethod() || !Intrinsics.areEqual(stackTrace[0].getClassName(), "android.media.MediaCodec")) {
            return null;
        }
        String methodName = stackTrace[0].getMethodName();
        if (methodName == null) {
            methodName = "";
        }
        if (Intrinsics.areEqual(methodName, "native_dequeueOutputBuffer")) {
            return pc2.a.b;
        }
        if (Intrinsics.areEqual(methodName, "native_dequeueInputBuffer")) {
            return pc2.a.c;
        }
        if (Intrinsics.areEqual(methodName, "native_stop")) {
            return pc2.a.d;
        }
        if (Intrinsics.areEqual(methodName, "native_setSurface")) {
            return pc2.a.e;
        }
        if (Intrinsics.areEqual(methodName, "releaseOutputBuffer")) {
            return pc2.a.f;
        }
        if (Intrinsics.areEqual(methodName, "native_queueSecureInputBuffer")) {
            return pc2.a.g;
        }
        if (z) {
            return pc2.a.h;
        }
        return null;
    }
}
