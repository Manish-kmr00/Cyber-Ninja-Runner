package com.yandex.mobile.ads.instream;

import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import kotlin.Metadata;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\t\u0018\u00002\u00020\u0001:\u0001\u0010B\u0017\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\r\u001a\u00020\b¢\u0006\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0007\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\r\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f¨\u0006\u0011"}, d2 = {"Lcom/yandex/mobile/ads/instream/InstreamAdBreakPosition;", "", "Lcom/yandex/mobile/ads/instream/InstreamAdBreakPosition$Type;", "a", "Lcom/yandex/mobile/ads/instream/InstreamAdBreakPosition$Type;", "getPositionType", "()Lcom/yandex/mobile/ads/instream/InstreamAdBreakPosition$Type;", "positionType", "", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "J", "getValue", "()J", "value", "<init>", "(Lcom/yandex/mobile/ads/instream/InstreamAdBreakPosition$Type;J)V", "Type", "mobileads_externalRelease"}, k = 1, mv = {1, 9, 0})
public final class InstreamAdBreakPosition {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final Type positionType;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    private final long value;

    /* JADX WARN: Enum visitor error
    jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r0v1 com.yandex.mobile.ads.instream.InstreamAdBreakPosition$Type[], still in use, count: 1, list:
  (r0v1 com.yandex.mobile.ads.instream.InstreamAdBreakPosition$Type[]) from 0x0024: INVOKE (r0v1 com.yandex.mobile.ads.instream.InstreamAdBreakPosition$Type[]) STATIC call: kotlin.enums.EnumEntriesKt.enumEntries(java.lang.Enum[]):kotlin.enums.EnumEntries A[MD:<E extends java.lang.Enum<E>>:(E extends java.lang.Enum<E>[]):kotlin.enums.EnumEntries<E extends java.lang.Enum<E>> (m)]
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
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/yandex/mobile/ads/instream/InstreamAdBreakPosition$Type;", "", "PERCENTS", "MILLISECONDS", "POSITION", "mobileads_externalRelease"}, k = 1, mv = {1, 9, 0})
    public static final class Type {
        PERCENTS,
        MILLISECONDS,
        POSITION;

        static {
            EnumEntriesKt.enumEntries(typeArr);
        }

        private Type() {
            super(str, i);
        }

        public static Type valueOf(String str) {
            return (Type) Enum.valueOf(Type.class, str);
        }

        public static Type[] values() {
            return (Type[]) b.clone();
        }
    }

    public InstreamAdBreakPosition(Type positionType, long j) {
        Intrinsics.checkNotNullParameter(positionType, "positionType");
        this.positionType = positionType;
        this.value = j;
    }

    public final Type getPositionType() {
        return this.positionType;
    }

    public final long getValue() {
        return this.value;
    }
}
