package com.yandex.mobile.ads.impl;

import com.yandex.mobile.ads.instream.player.ad.error.InstreamAdPlayerError;

/* JADX INFO: loaded from: classes5.dex */
public final class am2 {

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f8423a;

        static {
            int[] iArr = new int[InstreamAdPlayerError.Reason.values().length];
            try {
                iArr[InstreamAdPlayerError.Reason.RENDERER_FAILED_DEQUEUE_OUTPUT_BUFFER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[InstreamAdPlayerError.Reason.RENDERER_FAILED_DEQUEUE_INPUT_BUFFER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[InstreamAdPlayerError.Reason.RENDERER_FAILED_STOP.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[InstreamAdPlayerError.Reason.RENDERER_FAILED_SET_SURFACE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[InstreamAdPlayerError.Reason.RENDERER_FAILED_RELEASE_OUTPUT_BUFFER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[InstreamAdPlayerError.Reason.RENDERER_FAILED_QUEUE_SECURE_INPUT_BUFFER.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[InstreamAdPlayerError.Reason.RENDERER_MEDIA_CODEC_UNKNOWN.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr[InstreamAdPlayerError.Reason.TIMEOUT.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr[InstreamAdPlayerError.Reason.ILLEGAL_SEEK_POSITION.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                iArr[InstreamAdPlayerError.Reason.DECODER_QUERY_ERROR.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                iArr[InstreamAdPlayerError.Reason.DECODER_INITIALIZATION_ERROR.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                iArr[InstreamAdPlayerError.Reason.DECODER_UNKNOWN_ERROR.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                iArr[InstreamAdPlayerError.Reason.BEHIND_LIVE_WINDOW_ERROR.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                iArr[InstreamAdPlayerError.Reason.DRM_KEYS_EXPIRED.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                iArr[InstreamAdPlayerError.Reason.DRM_MEDIA_RESOURCE_BUSY.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                iArr[InstreamAdPlayerError.Reason.DRM_SESSION_ERROR.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                iArr[InstreamAdPlayerError.Reason.HTTP_CLEARTEXT_NOT_PERMITTED.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                iArr[InstreamAdPlayerError.Reason.HTTP_CODE_UNAUTHORIZED.ordinal()] = 18;
            } catch (NoSuchFieldError unused18) {
            }
            try {
                iArr[InstreamAdPlayerError.Reason.HTTP_CODE_FORBIDDEN.ordinal()] = 19;
            } catch (NoSuchFieldError unused19) {
            }
            try {
                iArr[InstreamAdPlayerError.Reason.HTTP_CODE_NOT_FOUND.ordinal()] = 20;
            } catch (NoSuchFieldError unused20) {
            }
            try {
                iArr[InstreamAdPlayerError.Reason.HTTP_CODE_UNKNOWN.ordinal()] = 21;
            } catch (NoSuchFieldError unused21) {
            }
            try {
                iArr[InstreamAdPlayerError.Reason.SSL_HANDSHAKE_ERROR.ordinal()] = 22;
            } catch (NoSuchFieldError unused22) {
            }
            try {
                iArr[InstreamAdPlayerError.Reason.NETWORK_UNAVAILABLE.ordinal()] = 23;
            } catch (NoSuchFieldError unused23) {
            }
            try {
                iArr[InstreamAdPlayerError.Reason.CONTENT_PARSER_ERROR.ordinal()] = 24;
            } catch (NoSuchFieldError unused24) {
            }
            try {
                iArr[InstreamAdPlayerError.Reason.LOADER_UNEXPECTED_ERROR.ordinal()] = 25;
            } catch (NoSuchFieldError unused25) {
            }
            try {
                iArr[InstreamAdPlayerError.Reason.AUDIO_ERROR.ordinal()] = 26;
            } catch (NoSuchFieldError unused26) {
            }
            try {
                iArr[InstreamAdPlayerError.Reason.SUBTITLE_ERROR.ordinal()] = 27;
            } catch (NoSuchFieldError unused27) {
            }
            try {
                iArr[InstreamAdPlayerError.Reason.CACHE_ERROR.ordinal()] = 28;
            } catch (NoSuchFieldError unused28) {
            }
            try {
                iArr[InstreamAdPlayerError.Reason.UNKNOWN.ordinal()] = 29;
            } catch (NoSuchFieldError unused29) {
            }
            f8423a = iArr;
        }
    }
}
