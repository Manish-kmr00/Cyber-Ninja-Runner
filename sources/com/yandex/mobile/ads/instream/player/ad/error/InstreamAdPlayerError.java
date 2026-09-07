package com.yandex.mobile.ads.instream.player.ad.error;

import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0003\n\u0002\b\t\u0018\u00002\u00020\u0001:\u0001\u0010B\u0017\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\r\u001a\u00020\b¢\u0006\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0007\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\r\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f¨\u0006\u0011"}, d2 = {"Lcom/yandex/mobile/ads/instream/player/ad/error/InstreamAdPlayerError;", "", "Lcom/yandex/mobile/ads/instream/player/ad/error/InstreamAdPlayerError$Reason;", "a", "Lcom/yandex/mobile/ads/instream/player/ad/error/InstreamAdPlayerError$Reason;", "getReason", "()Lcom/yandex/mobile/ads/instream/player/ad/error/InstreamAdPlayerError$Reason;", "reason", "", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "Ljava/lang/Throwable;", "getUnderlyingError", "()Ljava/lang/Throwable;", "underlyingError", "<init>", "(Lcom/yandex/mobile/ads/instream/player/ad/error/InstreamAdPlayerError$Reason;Ljava/lang/Throwable;)V", "Reason", "mobileads_externalRelease"}, k = 1, mv = {1, 9, 0})
public final class InstreamAdPlayerError {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final Reason reason;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    private final Throwable underlyingError;

    /* JADX WARN: Enum visitor error
    jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r0v18 com.yandex.mobile.ads.instream.player.ad.error.InstreamAdPlayerError$Reason[], still in use, count: 1, list:
  (r0v18 com.yandex.mobile.ads.instream.player.ad.error.InstreamAdPlayerError$Reason[]) from 0x0173: INVOKE (r0v18 com.yandex.mobile.ads.instream.player.ad.error.InstreamAdPlayerError$Reason[]) STATIC call: kotlin.enums.EnumEntriesKt.enumEntries(java.lang.Enum[]):kotlin.enums.EnumEntries A[MD:<E extends java.lang.Enum<E>>:(E extends java.lang.Enum<E>[]):kotlin.enums.EnumEntries<E extends java.lang.Enum<E>> (m), WRAPPED]
    	at jadx.core.utils.InsnRemover.removeSsaVar(InsnRemover.java:164)
    	at jadx.core.utils.InsnRemover.unbindResult(InsnRemover.java:129)
    	at jadx.core.utils.InsnRemover.lambda$unbindInsns$1(InsnRemover.java:101)
    	at java.base/java.util.ArrayList.forEach(Unknown Source)
    	at jadx.core.utils.InsnRemover.unbindInsns(InsnRemover.java:100)
    	at jadx.core.utils.InsnRemover.removeAllAndUnbind(InsnRemover.java:257)
    	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:187)
    	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:102)
     */
    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u001e\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001e¨\u0006\u001f"}, d2 = {"Lcom/yandex/mobile/ads/instream/player/ad/error/InstreamAdPlayerError$Reason;", "", "RENDERER_FAILED_DEQUEUE_OUTPUT_BUFFER", "RENDERER_FAILED_DEQUEUE_INPUT_BUFFER", "RENDERER_FAILED_STOP", "RENDERER_FAILED_SET_SURFACE", "RENDERER_FAILED_RELEASE_OUTPUT_BUFFER", "RENDERER_FAILED_QUEUE_SECURE_INPUT_BUFFER", "RENDERER_MEDIA_CODEC_UNKNOWN", "TIMEOUT", "ILLEGAL_SEEK_POSITION", "DECODER_QUERY_ERROR", "DECODER_INITIALIZATION_ERROR", "DECODER_UNKNOWN_ERROR", "BEHIND_LIVE_WINDOW_ERROR", "DRM_KEYS_EXPIRED", "DRM_MEDIA_RESOURCE_BUSY", "DRM_SESSION_ERROR", "HTTP_CLEARTEXT_NOT_PERMITTED", "HTTP_CODE_UNAUTHORIZED", "HTTP_CODE_FORBIDDEN", "HTTP_CODE_NOT_FOUND", "HTTP_CODE_UNKNOWN", "SSL_HANDSHAKE_ERROR", "NETWORK_UNAVAILABLE", "CONTENT_PARSER_ERROR", "LOADER_UNEXPECTED_ERROR", "AUDIO_ERROR", "SUBTITLE_ERROR", "CACHE_ERROR", "UNKNOWN", "mobileads_externalRelease"}, k = 1, mv = {1, 9, 0})
    public static final class Reason {
        RENDERER_FAILED_DEQUEUE_OUTPUT_BUFFER,
        RENDERER_FAILED_DEQUEUE_INPUT_BUFFER,
        RENDERER_FAILED_STOP,
        RENDERER_FAILED_SET_SURFACE,
        RENDERER_FAILED_RELEASE_OUTPUT_BUFFER,
        RENDERER_FAILED_QUEUE_SECURE_INPUT_BUFFER,
        RENDERER_MEDIA_CODEC_UNKNOWN,
        TIMEOUT,
        ILLEGAL_SEEK_POSITION,
        DECODER_QUERY_ERROR,
        DECODER_INITIALIZATION_ERROR,
        DECODER_UNKNOWN_ERROR,
        BEHIND_LIVE_WINDOW_ERROR,
        DRM_KEYS_EXPIRED,
        DRM_MEDIA_RESOURCE_BUSY,
        DRM_SESSION_ERROR,
        HTTP_CLEARTEXT_NOT_PERMITTED,
        HTTP_CODE_UNAUTHORIZED,
        HTTP_CODE_FORBIDDEN,
        HTTP_CODE_NOT_FOUND,
        HTTP_CODE_UNKNOWN,
        SSL_HANDSHAKE_ERROR,
        NETWORK_UNAVAILABLE,
        CONTENT_PARSER_ERROR,
        LOADER_UNEXPECTED_ERROR,
        AUDIO_ERROR,
        SUBTITLE_ERROR,
        CACHE_ERROR,
        UNKNOWN;

        private static final /* synthetic */ EnumEntries c;

        static {
            c = EnumEntriesKt.enumEntries(reasonArr);
        }

        private Reason() {
            super(str, i);
        }

        public static EnumEntries<Reason> getEntries() {
            return c;
        }

        public static Reason valueOf(String str) {
            return (Reason) Enum.valueOf(Reason.class, str);
        }

        public static Reason[] values() {
            return (Reason[]) b.clone();
        }
    }

    public InstreamAdPlayerError(Reason reason, Throwable underlyingError) {
        Intrinsics.checkNotNullParameter(reason, "reason");
        Intrinsics.checkNotNullParameter(underlyingError, "underlyingError");
        this.reason = reason;
        this.underlyingError = underlyingError;
    }

    public final Reason getReason() {
        return this.reason;
    }

    public final Throwable getUnderlyingError() {
        return this.underlyingError;
    }
}
