package com.yandex.mobile.ads.impl;

import android.os.Bundle;
import android.view.TextureView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes8.dex */
public interface di1 {

    public static final class a implements jm {
        public static final a c = new a(new yb0.a().a());
        private final yb0 b;

        static {
            new jm.a() { // from class: com.yandex.mobile.ads.impl.di1$a$$ExternalSyntheticLambda0
                @Override // com.yandex.mobile.ads.impl.jm.a
                public final jm fromBundle(Bundle bundle) {
                    return di1.a.a(bundle);
                }
            };
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static a a(Bundle bundle) {
            ArrayList<Integer> integerArrayList = bundle.getIntegerArrayList(Integer.toString(0, 36));
            if (integerArrayList == null) {
                return c;
            }
            yb0.a aVar = new yb0.a();
            for (int i = 0; i < integerArrayList.size(); i++) {
                aVar.a(integerArrayList.get(i).intValue());
            }
            return new a(aVar.a());
        }

        /* JADX INFO: renamed from: com.yandex.mobile.ads.impl.di1$a$a, reason: collision with other inner class name */
        public static final class C0740a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final yb0.a f8698a = new yb0.a();

            public final C0740a a(int i) {
                this.f8698a.a(i);
                return this;
            }

            public final C0740a a(a aVar) {
                this.f8698a.a(aVar.b);
                return this;
            }

            public final C0740a a(int... iArr) {
                yb0.a aVar = this.f8698a;
                aVar.getClass();
                for (int i : iArr) {
                    aVar.a(i);
                }
                return this;
            }

            public final C0740a a(boolean z, int i) {
                yb0.a aVar = this.f8698a;
                if (z) {
                    aVar.a(i);
                } else {
                    aVar.getClass();
                }
                return this;
            }

            public final a a() {
                return new a(this.f8698a.a());
            }
        }

        private a(yb0 yb0Var) {
            this.b = yb0Var;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof a) {
                return this.b.equals(((a) obj).b);
            }
            return false;
        }

        public final int hashCode() {
            return this.b.hashCode();
        }
    }

    public interface b {
        default void a(int i) {
        }

        default void a(a aVar) {
        }

        default void a(c cVar, c cVar2, int i) {
        }

        default void a(f10 f10Var) {
        }

        default void a(fw0 fw0Var, int i) {
        }

        default void a(g01 g01Var) {
        }

        default void a(gv gvVar) {
        }

        default void a(iw0 iw0Var) {
        }

        default void a(j60 j60Var) {
        }

        default void a(u62 u62Var) {
        }

        default void a(uf2 uf2Var) {
        }

        default void a(xh1 xh1Var) {
        }

        default void a(boolean z, int i) {
        }

        default void b(j60 j60Var) {
        }

        @Deprecated
        default void onCues(List<ev> list) {
        }

        default void onIsLoadingChanged(boolean z) {
        }

        default void onIsPlayingChanged(boolean z) {
        }

        default void onPlayWhenReadyChanged(boolean z, int i) {
        }

        default void onPlaybackStateChanged(int i) {
        }

        default void onPlaybackSuppressionReasonChanged(int i) {
        }

        @Deprecated
        default void onPlayerStateChanged(boolean z, int i) {
        }

        default void onRenderedFirstFrame() {
        }

        default void onSkipSilenceEnabledChanged(boolean z) {
        }

        default void onSurfaceSizeChanged(int i, int i2) {
        }

        default void onVolumeChanged(float f) {
        }
    }

    public static final class c implements jm {
        public final Object b;
        public final int c;
        public final fw0 d;
        public final Object e;
        public final int f;
        public final long g;
        public final long h;
        public final int i;
        public final int j;

        static {
            new jm.a() { // from class: com.yandex.mobile.ads.impl.di1$c$$ExternalSyntheticLambda0
                @Override // com.yandex.mobile.ads.impl.jm.a
                public final jm fromBundle(Bundle bundle) {
                    return di1.c.a(bundle);
                }
            };
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static c a(Bundle bundle) {
            int i = bundle.getInt(Integer.toString(0, 36), -1);
            Bundle bundle2 = bundle.getBundle(Integer.toString(1, 36));
            return new c(null, i, bundle2 == null ? null : (fw0) fw0.h.fromBundle(bundle2), null, bundle.getInt(Integer.toString(2, 36), -1), bundle.getLong(Integer.toString(3, 36), -9223372036854775807L), bundle.getLong(Integer.toString(4, 36), -9223372036854775807L), bundle.getInt(Integer.toString(5, 36), -1), bundle.getInt(Integer.toString(6, 36), -1));
        }

        public c(Object obj, int i, fw0 fw0Var, Object obj2, int i2, long j, long j2, int i3, int i4) {
            this.b = obj;
            this.c = i;
            this.d = fw0Var;
            this.e = obj2;
            this.f = i2;
            this.g = j;
            this.h = j2;
            this.i = i3;
            this.j = i4;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || c.class != obj.getClass()) {
                return false;
            }
            c cVar = (c) obj;
            return this.c == cVar.c && this.f == cVar.f && this.g == cVar.g && this.h == cVar.h && this.i == cVar.i && this.j == cVar.j && vd1.a(this.b, cVar.b) && vd1.a(this.e, cVar.e) && vd1.a(this.d, cVar.d);
        }

        public final int hashCode() {
            return Arrays.hashCode(new Object[]{this.b, Integer.valueOf(this.c), this.d, this.e, Integer.valueOf(this.f), Long.valueOf(this.g), Long.valueOf(this.h), Integer.valueOf(this.i), Integer.valueOf(this.j)});
        }
    }

    j60 a();

    void a(b bVar);

    void b(b bVar);

    long getContentPosition();

    int getCurrentAdGroupIndex();

    int getCurrentAdIndexInAdGroup();

    int getCurrentMediaItemIndex();

    int getCurrentPeriodIndex();

    long getCurrentPosition();

    b52 getCurrentTimeline();

    u62 getCurrentTracks();

    long getDuration();

    boolean getPlayWhenReady();

    int getPlaybackState();

    int getPlaybackSuppressionReason();

    long getTotalBufferedDuration();

    float getVolume();

    boolean hasNextMediaItem();

    boolean hasPreviousMediaItem();

    boolean isCurrentMediaItemDynamic();

    boolean isCurrentMediaItemLive();

    boolean isCurrentMediaItemSeekable();

    boolean isPlayingAd();

    void prepare();

    void release();

    void setPlayWhenReady(boolean z);

    void setVideoTextureView(TextureView textureView);

    void setVolume(float f);

    void stop();
}
