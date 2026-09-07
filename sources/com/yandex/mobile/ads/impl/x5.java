package com.yandex.mobile.ads.impl;

import androidx.media3.common.AdPlaybackState;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
public final class x5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final q9 f10622a;
    private final o5 b;
    private final qi1 c;
    private final ui1 d;

    public interface a {
        void a();
    }

    /* JADX WARN: Enum visitor error
    jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r0v1 com.yandex.mobile.ads.impl.x5$b[], still in use, count: 1, list:
  (r0v1 com.yandex.mobile.ads.impl.x5$b[]) from 0x001a: INVOKE (r0v1 com.yandex.mobile.ads.impl.x5$b[]) STATIC call: kotlin.enums.EnumEntriesKt.enumEntries(java.lang.Enum[]):kotlin.enums.EnumEntries A[MD:<E extends java.lang.Enum<E>>:(E extends java.lang.Enum<E>[]):kotlin.enums.EnumEntries<E extends java.lang.Enum<E>> (m)]
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
    public static final class b {
        b,
        c;

        static {
            EnumEntriesKt.enumEntries(bVarArr);
        }

        public static b valueOf(String str) {
            return (b) Enum.valueOf(b.class, str);
        }

        public static b[] values() {
            return (b[]) d.clone();
        }

        private b() {
            super(str, i);
        }
    }

    public final void a(u4 adInfo, b adDiscardType, a adDiscardListener) {
        Intrinsics.checkNotNullParameter(adInfo, "adInfo");
        Intrinsics.checkNotNullParameter(adDiscardType, "adDiscardType");
        Intrinsics.checkNotNullParameter(adDiscardListener, "adDiscardListener");
        int iA = adInfo.a();
        int iB = adInfo.b();
        AdPlaybackState adPlaybackStateA = this.b.a();
        if (adPlaybackStateA.isAdInErrorState(iA, iB)) {
            return;
        }
        if (b.c == adDiscardType) {
            int i = adPlaybackStateA.getAdGroup(iA).count;
            while (iB < i) {
                if (!adPlaybackStateA.isAdInErrorState(iA, iB)) {
                    adPlaybackStateA = adPlaybackStateA.withSkippedAd(iA, iB).withAdResumePositionUs(0L);
                    Intrinsics.checkNotNull(adPlaybackStateA);
                }
                iB++;
            }
        } else if (!adPlaybackStateA.isAdInErrorState(iA, iB)) {
            adPlaybackStateA = adPlaybackStateA.withSkippedAd(iA, iB).withAdResumePositionUs(0L);
            Intrinsics.checkNotNull(adPlaybackStateA);
        }
        this.b.a(adPlaybackStateA);
        this.d.b();
        adDiscardListener.a();
        if (this.c.c()) {
            return;
        }
        this.f10622a.a((xi1) null);
    }

    public /* synthetic */ x5(o9 o9Var, oi1 oi1Var) {
        this(o9Var, oi1Var, o9Var.b(), o9Var.c(), oi1Var.d(), oi1Var.e());
    }

    public x5(o9 adStateDataController, oi1 playerStateController, q9 adStateHolder, o5 adPlaybackStateController, qi1 playerStateHolder, ui1 playerVolumeController) {
        Intrinsics.checkNotNullParameter(adStateDataController, "adStateDataController");
        Intrinsics.checkNotNullParameter(playerStateController, "playerStateController");
        Intrinsics.checkNotNullParameter(adStateHolder, "adStateHolder");
        Intrinsics.checkNotNullParameter(adPlaybackStateController, "adPlaybackStateController");
        Intrinsics.checkNotNullParameter(playerStateHolder, "playerStateHolder");
        Intrinsics.checkNotNullParameter(playerVolumeController, "playerVolumeController");
        this.f10622a = adStateHolder;
        this.b = adPlaybackStateController;
        this.c = playerStateHolder;
        this.d = playerVolumeController;
    }
}
