package com.ogury.ad;

import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.ogury.core.OguryError;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\u0018\u00002\u00020\u0001:\u0001\u0012B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001a\u0010\u0007\u001a\u00020\u00068\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0013"}, d2 = {"Lcom/ogury/ad/OguryAdError;", "Lcom/ogury/core/OguryError;", "Lcom/ogury/ad/OguryAdError$Type;", "type", "", "code", "", "message", "<init>", "(Lcom/ogury/ad/OguryAdError$Type;ILjava/lang/String;)V", "a", "Lcom/ogury/ad/OguryAdError$Type;", "getType", "()Lcom/ogury/ad/OguryAdError$Type;", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "Ljava/lang/String;", "getMessage", "()Ljava/lang/String;", "Type", "sdk-ads_prodRelease"}, k = 1, mv = {2, 0, 0})
public final class OguryAdError extends OguryError {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final Type type;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    public final String message;

    /* JADX WARN: Enum visitor error
    jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r0v1 com.ogury.ad.OguryAdError$Type[], still in use, count: 1, list:
  (r0v1 com.ogury.ad.OguryAdError$Type[]) from 0x001a: INVOKE (r0v1 com.ogury.ad.OguryAdError$Type[]) STATIC call: kotlin.enums.EnumEntriesKt.enumEntries(java.lang.Enum[]):kotlin.enums.EnumEntries A[MD:<E extends java.lang.Enum<E>>:(E extends java.lang.Enum<E>[]):kotlin.enums.EnumEntries<E extends java.lang.Enum<E>> (m), WRAPPED]
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
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/ogury/ad/OguryAdError$Type;", "", "LOAD_ERROR", "SHOW_ERROR", "sdk-ads_prodRelease"}, k = 1, mv = {2, 0, 0})
    public static final class Type {
        LOAD_ERROR,
        SHOW_ERROR;

        public static final /* synthetic */ EnumEntries b;

        static {
            b = EnumEntriesKt.enumEntries(typeArr);
        }

        public Type() {
            super(str, i);
        }

        public static EnumEntries<Type> getEntries() {
            return b;
        }

        public static Type valueOf(String str) {
            return (Type) Enum.valueOf(Type.class, str);
        }

        public static Type[] values() {
            return (Type[]) f7247a.clone();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OguryAdError(Type type, int i, String message) {
        super(i, message);
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(message, "message");
        this.type = type;
        this.message = message;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        return this.message;
    }

    public final Type getType() {
        return this.type;
    }
}
