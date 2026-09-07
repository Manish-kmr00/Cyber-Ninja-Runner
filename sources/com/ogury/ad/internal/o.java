package com.ogury.ad.internal;

import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r0v1 com.ogury.ad.internal.o[], still in use, count: 1, list:
  (r0v1 com.ogury.ad.internal.o[]) from 0x004c: INVOKE (r0v1 com.ogury.ad.internal.o[]) STATIC call: kotlin.enums.EnumEntriesKt.enumEntries(java.lang.Enum[]):kotlin.enums.EnumEntries A[MD:<E extends java.lang.Enum<E>>:(E extends java.lang.Enum<E>[]):kotlin.enums.EnumEntries<E extends java.lang.Enum<E>> (m), WRAPPED]
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
/* JADX INFO: loaded from: classes12.dex */
public final class o {
    INTERSTITIAL("interstitial", "Interstitial"),
    REWARDED("optin_video", "Rewarded"),
    OVERLAY_THUMBNAIL("overlay_thumbnail", "Thumbnail"),
    SMALL_BANNER("banner_320x50", "Small Banner (320x50)"),
    MEDIUM_RECTANGLE("medium_rectangle", "MREC (300x250)");

    public static final a c = new a();
    public static final /* synthetic */ EnumEntries j;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f7369a;
    public final String b;

    public static final class a {
        public static String a(String str) {
            for (o oVar : o.j) {
                if (Intrinsics.areEqual(oVar.f7369a, str)) {
                    return oVar.b;
                }
            }
            return str;
        }
    }

    static {
        j = EnumEntriesKt.enumEntries(new o[]{r0, r1, r2, r3, r4});
    }

    public o(String str, String str2) {
        super(str, i);
        this.f7369a = str;
        this.b = str2;
    }

    public static o valueOf(String str) {
        return (o) Enum.valueOf(o.class, str);
    }

    public static o[] values() {
        return (o[]) i.clone();
    }

    public final String a() {
        return this.f7369a;
    }

    public final String b() {
        return this.b;
    }

    public final boolean c() {
        return this == SMALL_BANNER || this == MEDIUM_RECTANGLE;
    }

    public final boolean d() {
        return this == INTERSTITIAL || this == REWARDED;
    }

    public final boolean e() {
        return this == OVERLAY_THUMBNAIL;
    }
}
