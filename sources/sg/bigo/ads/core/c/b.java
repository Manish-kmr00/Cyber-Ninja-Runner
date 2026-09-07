package sg.bigo.ads.core.c;

import com.iab.omid.library.bigosg.adsession.AdEvents;
import com.iab.omid.library.bigosg.adsession.AdSession;
import com.iab.omid.library.bigosg.adsession.media.InteractionType;
import com.iab.omid.library.bigosg.adsession.media.MediaEvents;
import com.iab.omid.library.bigosg.adsession.media.Position;
import com.iab.omid.library.bigosg.adsession.media.VastProperties;
import com.json.b9;
import com.pubmatic.sdk.omsdk.POBOMSDKUtil;
import sg.bigo.ads.common.n.d;

/* JADX INFO: loaded from: classes8.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public MediaEvents f13527a;
    public boolean b = false;
    private final AdSession c;
    private final AdEvents d;

    /* JADX INFO: renamed from: sg.bigo.ads.core.c.b$2, reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f13529a;
        static final /* synthetic */ int[] b;

        static {
            int[] iArr = new int[a.a().length];
            b = iArr;
            try {
                iArr[a.f13530a - 1] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                b[a.b - 1] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                b[a.c - 1] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                b[a.d - 1] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                b[a.e - 1] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            int[] iArr2 = new int[EnumC0891b.a().length];
            f13529a = iArr2;
            try {
                iArr2[EnumC0891b.f13531a - 1] = 1;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f13529a[EnumC0891b.b - 1] = 2;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f13529a[EnumC0891b.c - 1] = 3;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f13529a[EnumC0891b.d - 1] = 4;
            } catch (NoSuchFieldError unused9) {
            }
        }
    }

    /* JADX WARN: $VALUES field not found */
    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final int f13530a = 1;
        public static final int b = 2;
        public static final int c = 3;
        public static final int d = 4;
        public static final int e = 5;
        private static final /* synthetic */ int[] f = {1, 2, 3, 4, 5};

        public static int[] a() {
            return (int[]) f.clone();
        }
    }

    /* JADX WARN: $VALUES field not found */
    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX INFO: renamed from: sg.bigo.ads.core.c.b$b, reason: collision with other inner class name */
    public static final class EnumC0891b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final int f13531a = 1;
        public static final int b = 2;
        public static final int c = 3;
        public static final int d = 4;
        private static final /* synthetic */ int[] e = {1, 2, 3, 4};

        public static int[] a() {
            return (int[]) e.clone();
        }
    }

    b(AdSession adSession, MediaEvents mediaEvents) {
        this.c = adSession;
        this.f13527a = mediaEvents;
        AdEvents adEventsCreateAdEvents = AdEvents.createAdEvents(adSession);
        this.d = adEventsCreateAdEvents;
        if (this.f13527a != null) {
            try {
                adEventsCreateAdEvents.loaded(VastProperties.createVastPropertiesForNonSkippableMedia(true, Position.STANDALONE));
                a(b9.h.r);
            } catch (Exception unused) {
            }
        } else {
            try {
                adEventsCreateAdEvents.loaded();
                a(b9.h.r);
            } catch (Exception unused2) {
            }
        }
    }

    public final void a() {
        try {
            this.d.impressionOccurred();
            a("impression");
        } catch (Exception unused) {
        }
    }

    public final void a(float f, float f2) {
        MediaEvents mediaEvents = this.f13527a;
        if (mediaEvents == null) {
            return;
        }
        mediaEvents.start(f, f2);
        this.b = true;
        a("video start, duration: " + f + ", volume: " + f2);
    }

    public final void a(int i) {
        String str;
        if (this.f13527a == null) {
            return;
        }
        int i2 = AnonymousClass2.f13529a[i - 1];
        if (i2 == 1) {
            this.f13527a.firstQuartile();
            str = "video first quartile";
        } else if (i2 == 2) {
            this.f13527a.midpoint();
            str = "video mid point";
        } else {
            if (i2 != 3) {
                if (i2 != 4) {
                    return;
                }
                this.f13527a.complete();
                a("video complete");
                return;
            }
            this.f13527a.thirdQuartile();
            str = "video third quartile";
        }
        a(str);
    }

    public final void a(InteractionType interactionType) {
        MediaEvents mediaEvents = this.f13527a;
        if (mediaEvents == null) {
            return;
        }
        mediaEvents.adUserInteraction(interactionType);
        a("ad user interaction: " + interactionType.toString());
    }

    public final void a(String str) {
        sg.bigo.ads.common.t.a.a(0, 3, POBOMSDKUtil.TAG, "Event: " + str + " (" + this.c.getAdSessionId() + ")");
    }

    public final void b() {
        if (d.b()) {
            c();
        } else {
            d.a(2, new Runnable() { // from class: sg.bigo.ads.core.c.b.1
                @Override // java.lang.Runnable
                public final void run() {
                    b.this.c();
                }
            });
        }
        this.f13527a = null;
    }

    public final void b(int i) {
        String str;
        if (this.f13527a == null) {
            return;
        }
        int i2 = AnonymousClass2.b[i - 1];
        if (i2 == 1) {
            this.f13527a.pause();
            str = "video pause";
        } else if (i2 == 2) {
            this.f13527a.resume();
            str = "video resume";
        } else if (i2 == 3) {
            this.f13527a.bufferStart();
            str = "video buffer start";
        } else {
            if (i2 != 4) {
                if (i2 != 5) {
                    return;
                }
                this.f13527a.skipped();
                a("video skipped");
                return;
            }
            this.f13527a.bufferFinish();
            str = "video buffer finish";
        }
        a(str);
    }

    final void c() {
        try {
            this.c.finish();
        } catch (Throwable unused) {
        }
    }
}
