package com.yandex.mobile.ads.nativeads;

import com.facebook.share.internal.ShareConstants;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r0v1 com.yandex.mobile.ads.nativeads.NativeAdType[], still in use, count: 1, list:
  (r0v1 com.yandex.mobile.ads.nativeads.NativeAdType[]) from 0x002a: INVOKE (r0v1 com.yandex.mobile.ads.nativeads.NativeAdType[]) STATIC call: kotlin.enums.EnumEntriesKt.enumEntries(java.lang.Enum[]):kotlin.enums.EnumEntries A[MD:<E extends java.lang.Enum<E>>:(E extends java.lang.Enum<E>[]):kotlin.enums.EnumEntries<E extends java.lang.Enum<E>> (m), WRAPPED]
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
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0007\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/yandex/mobile/ads/nativeads/NativeAdType;", "", "", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "Ljava/lang/String;", "getValue", "()Ljava/lang/String;", "value", "CONTENT", "APP_INSTALL", ShareConstants.MEDIA, "mobileads_externalRelease"}, k = 1, mv = {1, 9, 0})
public final class NativeAdType {
    CONTENT("content"),
    APP_INSTALL("app"),
    MEDIA("media");

    private static final /* synthetic */ EnumEntries d;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    private final String value;

    static {
        d = EnumEntriesKt.enumEntries(nativeAdTypeArr);
    }

    private NativeAdType(String str) {
        super(str, i);
        this.value = str;
    }

    public static EnumEntries<NativeAdType> getEntries() {
        return d;
    }

    public static NativeAdType valueOf(String str) {
        return (NativeAdType) Enum.valueOf(NativeAdType.class, str);
    }

    public static NativeAdType[] values() {
        return (NativeAdType[]) c.clone();
    }

    public final String getValue() {
        return this.value;
    }
}
