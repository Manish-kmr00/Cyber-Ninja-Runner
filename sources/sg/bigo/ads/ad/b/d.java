package sg.bigo.ads.ad.b;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Point;
import android.text.TextUtils;
import android.util.Pair;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.URLUtil;
import android.widget.ImageView;
import com.google.common.base.Ascii;
import com.json.mediationsdk.logger.IronSourceError;
import com.json.mediationsdk.utils.IronSourceConstants;
import java.io.File;
import java.net.URI;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import sg.bigo.ads.api.AdError;
import sg.bigo.ads.api.AdInteractionListener;
import sg.bigo.ads.api.AdOptionsView;
import sg.bigo.ads.api.MediaView;
import sg.bigo.ads.api.NativeAd;
import sg.bigo.ads.api.VideoController;
import sg.bigo.ads.api.a.h;
import sg.bigo.ads.api.a.i;
import sg.bigo.ads.api.a.m;
import sg.bigo.ads.common.o;
import sg.bigo.ads.common.utils.q;
import sg.bigo.ads.common.utils.u;
import sg.bigo.ads.core.f.a.j;
import sg.bigo.ads.core.f.a.k;
import sg.bigo.ads.core.f.a.l;
import sg.bigo.ads.core.f.a.n;
import sg.bigo.ads.core.f.a.p;

/* JADX INFO: loaded from: classes4.dex */
public class d extends c {
    public sg.bigo.ads.core.player.c H;
    public p I;
    public boolean J;
    private final a V;
    private g W;
    private final sg.bigo.ads.core.g.c X;
    private sg.bigo.ads.core.player.b.a v;
    private Pair<Boolean, Boolean> w;
    private AtomicBoolean x;

    /* JADX INFO: renamed from: sg.bigo.ads.ad.b.d$4, reason: invalid class name */
    final class AnonymousClass4 implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f12515a;
        final /* synthetic */ sg.bigo.ads.api.b.d.a b;
        final /* synthetic */ sg.bigo.ads.core.a.a c;
        final /* synthetic */ sg.bigo.ads.api.core.c d;

        AnonymousClass4(int i, sg.bigo.ads.api.b.d.a aVar, sg.bigo.ads.core.a.a aVar2, sg.bigo.ads.api.core.c cVar) {
            this.f12515a = i;
            this.b = aVar;
            this.c = aVar2;
            this.d = cVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (this.f12515a != 0) {
                d.this.z();
                this.b.a(d.this, 1006, this.f12515a, "Invalid media video.");
                return;
            }
            d.this.y();
            if (!d.a(d.this, (int) ((d.this.I != null ? d.this.I.s : 0L) / 1000))) {
                this.b.a(d.this, 1032, 1402, "Invalid video duration.");
            } else {
                d.this.v = new sg.bigo.ads.core.player.b.a() { // from class: sg.bigo.ads.ad.b.d.4.1
                    @Override // sg.bigo.ads.core.player.b.a
                    public final void a() {
                        if (d.this.x.get() || AnonymousClass4.this.c.bf() == 3 || AnonymousClass4.this.c.bg() != null) {
                            sg.bigo.ads.common.t.a.a(0, 3, "onResourceDownloadBackup", "downloading or backup img is ready, stop to download img");
                            return;
                        }
                        sg.bigo.ads.common.t.a.a(0, 3, "onResourceDownloadBackup", "begin to download backup img");
                        d.this.x.set(true);
                        final Pair<Boolean, Boolean> pairD = d.this.D();
                        ArrayList arrayList = new ArrayList();
                        if (((Boolean) pairD.first).booleanValue()) {
                            arrayList.add(AnonymousClass4.this.c.bl().b);
                        }
                        String strAS = ((sg.bigo.ads.core.a.a) d.this.f()).aS();
                        if (!TextUtils.isEmpty(strAS) && URLUtil.isNetworkUrl(strAS)) {
                            arrayList.add(AnonymousClass4.this.c.aS());
                        }
                        if (arrayList.size() == 0 && !((Boolean) pairD.second).booleanValue()) {
                            AnonymousClass4.this.c.k(0);
                        } else {
                            AnonymousClass4.this.c.k(3);
                            sg.bigo.ads.common.p.e.a(d.this.b.e, arrayList, AnonymousClass4.this.c.al(), new sg.bigo.ads.common.p.g() { // from class: sg.bigo.ads.ad.b.d.4.1.1
                                @Override // sg.bigo.ads.common.p.g
                                public final void a(int i, String str, String str2) {
                                    AnonymousClass4.this.c.k(1);
                                    if (((Boolean) pairD.second).booleanValue()) {
                                        VideoController videoController = d.this.getVideoController();
                                        if (videoController == null || videoController.getLoadHTMLCallback() == null) {
                                            AnonymousClass4.this.c.bi();
                                        } else {
                                            videoController.getLoadHTMLCallback().a();
                                        }
                                    }
                                }

                                @Override // sg.bigo.ads.common.p.g
                                public final void a(Bitmap bitmap, sg.bigo.ads.common.p.f fVar) {
                                    AnonymousClass4.this.c.k(2);
                                    AnonymousClass4.this.c.a(new Pair<>(bitmap, fVar.e));
                                    VideoController videoController = d.this.getVideoController();
                                    if (videoController != null) {
                                        videoController.notifyBackupResourceReady();
                                    }
                                }
                            });
                        }
                    }

                    @Override // sg.bigo.ads.core.player.b.a
                    public final void a(int i) {
                        final d dVar = d.this;
                        final sg.bigo.ads.core.a.a aVar = AnonymousClass4.this.c;
                        if (!dVar.G() && !dVar.K && aVar != null && aVar.aQ()) {
                            dVar.K = true;
                            sg.bigo.ads.common.n.d.a(1, new Runnable() { // from class: sg.bigo.ads.ad.b.e.1

                                /* JADX INFO: renamed from: a */
                                final /* synthetic */ sg.bigo.ads.core.a.a f12519a;

                                AnonymousClass1() {
                                    aVar = aVar;
                                }

                                @Override // java.lang.Runnable
                                public final void run() {
                                    try {
                                        String strB = o.b(e.this.b.e, aVar.aM());
                                        if (TextUtils.isEmpty(strB)) {
                                            return;
                                        }
                                        File file = new File(URI.create(strB));
                                        if (!file.exists() || file.length() <= 0) {
                                            return;
                                        }
                                        Bitmap bitmapDecodeFile = BitmapFactory.decodeFile(file.getAbsolutePath());
                                        e.this.w = sg.bigo.ads.common.w.b.a(bitmapDecodeFile);
                                    } catch (Throwable unused) {
                                    }
                                }
                            });
                        }
                        d.this.a("is_cache", Boolean.valueOf(i == 0));
                        AnonymousClass4.this.c.aZ();
                        d.a(d.this);
                        if (d.this.e || d.this.f) {
                            return;
                        }
                        d.b(d.this, i);
                        AnonymousClass4.this.b.a(d.this);
                    }

                    @Override // sg.bigo.ads.core.player.b.a
                    public final void a(String str, sg.bigo.ads.common.h.a aVar) {
                        if (d.this.e || d.this.f) {
                            return;
                        }
                        AnonymousClass4.this.c.h(2);
                        if (AnonymousClass4.this.d.x() != 1) {
                            AnonymousClass4.this.b.a(d.this, aVar.d(), IronSourceError.ERROR_RV_LOAD_FAIL_DUE_TO_INIT, 10202, "video download failed and no backup creative resource.", true);
                        } else if (AnonymousClass4.this.c.bg() != null || aVar.d()) {
                            AnonymousClass4.this.b.a(d.this);
                        } else {
                            sg.bigo.ads.core.d.b.a(AnonymousClass4.this.c, aVar.b, str, 0L, aVar.g / 1024, 2, "video", aVar.o);
                            AnonymousClass4.this.b.a(d.this, IronSourceError.ERROR_RV_LOAD_FAIL_DUE_TO_INIT, 10202, "video download failed and no backup creative resource.");
                        }
                    }

                    @Override // sg.bigo.ads.core.player.b.a
                    public final void b(int i) {
                        sg.bigo.ads.core.a.a aVar;
                        int i2;
                        if (d.this.e || d.this.f) {
                            return;
                        }
                        if (AnonymousClass4.this.c.aN()) {
                            aVar = AnonymousClass4.this.c;
                            i2 = 3;
                        } else {
                            aVar = AnonymousClass4.this.c;
                            i2 = 4;
                        }
                        aVar.h(i2);
                        AnonymousClass4.this.b.a(d.this, IronSourceError.ERROR_RV_LOAD_UNEXPECTED_CALLBACK, i, "Failed to download media video.");
                    }
                };
                sg.bigo.ads.core.player.b.a().a(d.this.b.e, this.c, d.this.v);
            }
        }
    }

    class a implements AdInteractionListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        AdInteractionListener f12518a;

        a() {
        }

        @Override // sg.bigo.ads.api.AdInteractionListener
        public final void onAdClicked() {
            AdInteractionListener adInteractionListener = this.f12518a;
            if (adInteractionListener != null) {
                adInteractionListener.onAdClicked();
            }
        }

        @Override // sg.bigo.ads.api.AdInteractionListener
        public final void onAdClosed() {
            AdInteractionListener adInteractionListener = this.f12518a;
            if (adInteractionListener != null) {
                adInteractionListener.onAdClosed();
            }
        }

        @Override // sg.bigo.ads.api.AdInteractionListener
        public final void onAdError(AdError adError) {
            if (this.f12518a != null) {
                if (adError.getCode() == 2002 && d.this.n()) {
                    sg.bigo.ads.common.t.a.a(0, 3, "NativeVideoAdImpl", "don't call onAdError when video has impressed");
                } else {
                    this.f12518a.onAdError(adError);
                }
            }
        }

        @Override // sg.bigo.ads.api.AdInteractionListener
        public final void onAdImpression() {
            AdInteractionListener adInteractionListener = this.f12518a;
            if (adInteractionListener != null) {
                adInteractionListener.onAdImpression();
            }
        }

        @Override // sg.bigo.ads.api.AdInteractionListener
        public final void onAdOpened() {
            AdInteractionListener adInteractionListener = this.f12518a;
            if (adInteractionListener != null) {
                adInteractionListener.onAdOpened();
            }
        }
    }

    public d(sg.bigo.ads.api.core.g gVar) {
        super(gVar);
        this.x = new AtomicBoolean(false);
        this.V = new a();
        this.X = new sg.bigo.ads.core.g.c() { // from class: sg.bigo.ads.ad.b.d.1
            @Override // sg.bigo.ads.core.g.c
            public final void a(String str, Object obj, int[] iArr) {
                d.a(d.this, str, obj, iArr);
            }

            @Override // sg.bigo.ads.core.g.c
            public final void a(String str, int[] iArr) {
                d.a(d.this, str, iArr);
            }
        };
    }

    static /* synthetic */ int a(d dVar, String str) {
        Context context;
        if (q.a((CharSequence) str)) {
            return 10074;
        }
        sg.bigo.ads.core.a.a aVar = (sg.bigo.ads.core.a.a) dVar.f();
        k kVarE = dVar.E();
        p pVarA = kVarE.a(dVar.b.e, str);
        int i = kVarE.f13594a;
        String str2 = kVarE.c;
        long j = kVarE.b;
        if (i.f13093a.n().a(9) && URLUtil.isHttpUrl(str2)) {
            sg.bigo.ads.core.d.b.a(aVar, i, str2, j, 10076, "Invalid http url");
            return 10076;
        }
        if (pVarA != null && pVarA.n != null) {
            pVarA.o = new StringBuilder().append(pVarA.n.c.hashCode()).toString();
            dVar.H = new sg.bigo.ads.core.player.c(dVar.b.e, pVarA, dVar.d);
            aVar.a(pVarA);
            dVar.I = pVarA;
            dVar.D();
            sg.bigo.ads.core.d.b.a(aVar, i, j);
            return 0;
        }
        sg.bigo.ads.core.f.a.e eVar = kVarE.d;
        List<n> list = kVarE.e;
        if (eVar == null) {
            return 10075;
        }
        int i2 = eVar.f13588a;
        if (i2 == 10062) {
            context = dVar.b.e;
            sg.bigo.ads.core.f.a.f fVar = sg.bigo.ads.core.f.a.f.NO_ADS_VAST_RESPONSE;
        } else {
            context = dVar.b.e;
            if (i2 == 10073) {
                sg.bigo.ads.core.f.a.f fVar2 = sg.bigo.ads.core.f.a.f.WRAPPER_TIMEOUT;
            } else {
                sg.bigo.ads.core.f.a.f fVar3 = sg.bigo.ads.core.f.a.f.XML_PARSING_ERROR;
            }
        }
        sg.bigo.ads.core.player.c.a(context, list);
        sg.bigo.ads.core.d.b.a(aVar, i, str2, j, i2, eVar.b);
        return i2;
    }

    static /* synthetic */ void a(d dVar) {
        VideoController videoController = dVar.getVideoController();
        if (videoController != null) {
            videoController.notifyResourceReady();
        }
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    static /* synthetic */ void a(d dVar, String str, Object obj, int[] iArr) {
        sg.bigo.ads.core.a.a aVar = (sg.bigo.ads.core.a.a) dVar.f();
        str.hashCode();
        switch (str) {
            case "AdLoaded":
                g gVar = dVar.W;
                if (gVar != null && gVar.e != null) {
                    gVar.e.a(gVar.f12521a);
                    break;
                }
                break;
            case "AdVideoThirdQuartile":
                sg.bigo.ads.core.player.c cVar = dVar.H;
                if (cVar != null) {
                    Iterator<Integer> it = cVar.j.iterator();
                    while (it.hasNext()) {
                        int iIntValue = it.next().intValue();
                        if (75 >= iIntValue) {
                            if (iIntValue == 75) {
                                if (cVar.f != null) {
                                    cVar.f.a(sg.bigo.ads.core.c.b.EnumC0891b.c);
                                }
                                iIntValue = 5;
                            }
                            sg.bigo.ads.core.player.c.a(aVar, iIntValue);
                            it.remove();
                        }
                    }
                    break;
                }
                break;
            case "AdVideoMidpoint":
                sg.bigo.ads.core.player.c cVar2 = dVar.H;
                if (cVar2 != null) {
                    Iterator<Integer> it2 = cVar2.j.iterator();
                    while (it2.hasNext()) {
                        int iIntValue2 = it2.next().intValue();
                        if (50 >= iIntValue2) {
                            if (iIntValue2 == 50) {
                                if (cVar2.f != null) {
                                    cVar2.f.a(sg.bigo.ads.core.c.b.EnumC0891b.b);
                                }
                                iIntValue2 = 4;
                            }
                            sg.bigo.ads.core.player.c.a(aVar, iIntValue2);
                            it2.remove();
                        }
                    }
                    break;
                }
                break;
            case "AdVideoFirstQuartile":
                sg.bigo.ads.core.player.c cVar3 = dVar.H;
                if (cVar3 != null) {
                    Iterator<Integer> it3 = cVar3.j.iterator();
                    while (it3.hasNext()) {
                        int iIntValue3 = it3.next().intValue();
                        if (25 >= iIntValue3) {
                            if (iIntValue3 == 25) {
                                if (cVar3.f != null) {
                                    cVar3.f.a(sg.bigo.ads.core.c.b.EnumC0891b.f13531a);
                                }
                                iIntValue3 = 3;
                            }
                            sg.bigo.ads.core.player.c.a(aVar, iIntValue3);
                            it3.remove();
                        }
                    }
                    break;
                }
                break;
            case "AdVPAIDClickThru":
                if (iArr != null && iArr.length > 0) {
                    dVar.a(obj instanceof sg.bigo.ads.common.i ? (sg.bigo.ads.common.i) obj : null, 12, 5);
                    break;
                }
                break;
            case "AdError":
                g gVar2 = dVar.W;
                if (gVar2 != null) {
                    String str2 = obj instanceof String ? (String) obj : "VPAID error";
                    if (gVar2.e != null) {
                        gVar2.e.a(gVar2.f12521a, 1006, 10222, str2);
                    }
                    break;
                }
                break;
            case "AdVPAIDImpression":
                g gVar3 = dVar.W;
                if (gVar3 != null && gVar3.a()) {
                    sg.bigo.ads.common.t.a.a(0, 3, "NativeVideoAdImpl", "vpaid impression method");
                    super.a_();
                    break;
                }
                break;
            case "AdVideoStart":
                sg.bigo.ads.core.player.c cVar4 = dVar.H;
                if (cVar4 != null) {
                    Iterator<Integer> it4 = cVar4.j.iterator();
                    while (it4.hasNext()) {
                        int iIntValue4 = it4.next().intValue();
                        if (iIntValue4 <= 0) {
                            if (iIntValue4 == 0) {
                                if (cVar4.f != null) {
                                    cVar4.f.a(cVar4.f13714a.s, cVar4.g ? 0.0f : 1.0f);
                                }
                                iIntValue4 = 2;
                            }
                            sg.bigo.ads.core.player.c.a(aVar, iIntValue4);
                            it4.remove();
                        }
                    }
                    break;
                }
                break;
        }
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    static /* synthetic */ void a(d dVar, String str, int[] iArr) {
        VideoController.VideoLifeCallback videoLifeCallback;
        VideoController.d progressChangeListener;
        VideoController.a backupLoadCallback;
        VideoController videoController = dVar.getVideoController();
        if (videoController != null) {
            videoLifeCallback = videoController.getVideoLifeCallback();
            progressChangeListener = videoController.getProgressChangeListener();
            backupLoadCallback = videoController.getBackupLoadCallback();
        } else {
            videoLifeCallback = null;
            progressChangeListener = null;
            backupLoadCallback = null;
        }
        sg.bigo.ads.core.a.a aVar = (sg.bigo.ads.core.a.a) dVar.f();
        str.hashCode();
        boolean z = true;
        byte b = -1;
        switch (str.hashCode()) {
            case -2104076401:
                if (str.equals("AdClosed")) {
                    b = 0;
                }
                break;
            case -1928311131:
                if (str.equals("AdBackupImgReady")) {
                    b = 1;
                }
                break;
            case -1844074968:
                if (str.equals("AdLoaded")) {
                    b = 2;
                }
                break;
            case -799585545:
                if (str.equals("AdVideoBuffered")) {
                    b = 3;
                }
                break;
            case 123005777:
                if (str.equals("AdVideoComplete")) {
                    b = 4;
                }
                break;
            case 227130189:
                if (str.equals("AdVolumeChange")) {
                    b = 5;
                }
                break;
            case 479049069:
                if (str.equals("AdSkipped")) {
                    b = 6;
                }
                break;
            case 488344453:
                if (str.equals("AdError")) {
                    b = 7;
                }
                break;
            case 739506502:
                if (str.equals("AdVideoPaused")) {
                    b = 8;
                }
                break;
            case 858456394:
                if (str.equals("AdVideoStart")) {
                    b = 9;
                }
                break;
            case 982656138:
                if (str.equals("AdVideoBuffering")) {
                    b = 10;
                }
                break;
            case 1099014402:
                if (str.equals("AdVideoTooLate")) {
                    b = Ascii.VT;
                }
                break;
            case 1746498326:
                if (str.equals("AdVideoPlaying")) {
                    b = Ascii.FF;
                }
                break;
            case 1766207024:
                if (str.equals("AdRemainingTimeChange")) {
                    b = Ascii.CR;
                }
                break;
        }
        switch (b) {
            case 0:
                sg.bigo.ads.core.player.c cVar = dVar.H;
                if (cVar != null) {
                    cVar.a(cVar.f13714a.e, "va_close");
                }
                break;
            case 1:
                if (backupLoadCallback != null) {
                    backupLoadCallback.i(((iArr == null || iArr.length <= 0) ? 0 : iArr[0]) != 0);
                }
                break;
            case 2:
                sg.bigo.ads.core.player.c cVar2 = dVar.H;
                if (cVar2 != null) {
                    cVar2.c = true;
                }
                break;
            case 3:
                if (videoLifeCallback instanceof VideoController.b) {
                    ((VideoController.b) videoLifeCallback).b();
                }
                break;
            case 4:
                if (videoLifeCallback != null) {
                    videoLifeCallback.onVideoEnd();
                }
                sg.bigo.ads.core.player.c cVar3 = dVar.H;
                if (cVar3 != null) {
                    cVar3.a(cVar3.f13714a.d, "va_comp");
                    cVar3.a(cVar3.f13714a.b, "va_prog1");
                    cVar3.a(cVar3.f13714a.c, "va_prog2");
                    if (!cVar3.i) {
                        cVar3.i = true;
                        sg.bigo.ads.core.player.c.a(aVar, 6);
                        if (cVar3.f != null) {
                            cVar3.f.a(sg.bigo.ads.core.c.b.EnumC0891b.d);
                        }
                    }
                }
                boolean z2 = dVar instanceof sg.bigo.ads.ad.b.a.b;
                if (!(sg.bigo.ads.api.core.b.e(aVar.x()) && dVar.b.b.h()) && !z2 && !dVar.J) {
                    z = false;
                }
                if (z && videoController != null) {
                    videoController.play();
                    break;
                }
                break;
            case 5:
                if (iArr != null && iArr.length > 0) {
                    int i = iArr[0];
                    if (videoLifeCallback != null) {
                        videoLifeCallback.onMuteChange(i == 0);
                    }
                    sg.bigo.ads.core.player.c cVar4 = dVar.H;
                    if (cVar4 != null) {
                        sg.bigo.ads.core.player.c.a(aVar, i == 0 ? 7 : 17);
                        if (cVar4.f13714a != null) {
                            Iterator<j> it = cVar4.f13714a.g.iterator();
                            while (it.hasNext()) {
                                j next = it.next();
                                if ((i == 0 && next.f13593a) || (i == 100 && !next.f13593a)) {
                                    cVar4.a(next, "va_mst");
                                    it.remove();
                                }
                            }
                        }
                        cVar4.g = i / 100 == 0;
                        if (cVar4.f != null) {
                            sg.bigo.ads.core.c.b bVar = cVar4.f;
                            float f = i / 100.0f;
                            if (bVar.f13527a != null && bVar.b) {
                                bVar.f13527a.volumeChange(f);
                                bVar.a("video volume change: ".concat(String.valueOf(f)));
                                break;
                            }
                        }
                    }
                }
                break;
            case 6:
                sg.bigo.ads.core.player.c cVar5 = dVar.H;
                if (cVar5 != null) {
                    cVar5.a(cVar5.f13714a.f, "va_skip");
                    if (cVar5.f != null) {
                        cVar5.f.b(sg.bigo.ads.core.c.b.a.e);
                    }
                }
                break;
            case 7:
            case 11:
                sg.bigo.ads.core.player.c cVar6 = dVar.H;
                if (cVar6 != null) {
                    String str2 = sg.bigo.ads.core.f.a.f.GENERAL_LINEAR_AD_ERROR.g;
                    ArrayList<n> arrayList = cVar6.f13714a.k;
                    if (arrayList != null) {
                        Iterator<n> it2 = arrayList.iterator();
                        while (it2.hasNext()) {
                            n next2 = it2.next();
                            String str3 = next2.b;
                            if (q.a((CharSequence) str3) || (next2.c && !next2.d)) {
                                sg.bigo.ads.common.t.a.a(0, "VASTController", "invalidate tracking url or is tracked");
                            } else {
                                String strA = sg.bigo.ads.core.player.c.a(str3);
                                String strA2 = q.a((CharSequence) strA) ? "" : q.a(strA, "[ERRORCODE]", str2, false);
                                next2.c = true;
                                if (!q.a((CharSequence) strA2)) {
                                    cVar6.e.a(cVar6.h, "va_err", strA2, "bigoad");
                                    sg.bigo.ads.common.t.a.a(0, 3, "VASTController", "Send track info, action: va_err, url: ".concat(String.valueOf(strA2)));
                                }
                            }
                            it2.remove();
                        }
                    }
                    sg.bigo.ads.core.player.c.a(aVar, 16);
                    if (iArr != null) {
                        dVar.a(2002, "Video error: " + iArr[0]);
                    }
                }
                break;
            case 8:
                if (videoLifeCallback != null) {
                    videoLifeCallback.onVideoPause();
                }
                sg.bigo.ads.core.player.c cVar7 = dVar.H;
                if (cVar7 != null) {
                    cVar7.d = true;
                    Iterator<n> it3 = cVar7.f13714a.h.iterator();
                    while (it3.hasNext()) {
                        cVar7.a(it3.next(), "va_pau");
                    }
                    if (cVar7.f != null) {
                        cVar7.f.b(sg.bigo.ads.core.c.b.a.f13530a);
                    }
                }
                break;
            case 9:
                if (videoLifeCallback != null) {
                    videoLifeCallback.onVideoStart();
                }
                sg.bigo.ads.core.player.c cVar8 = dVar.H;
                break;
            case 10:
                if (videoLifeCallback instanceof VideoController.b) {
                    ((VideoController.b) videoLifeCallback).a();
                }
                break;
            case 12:
                if (videoLifeCallback != null) {
                    videoLifeCallback.onVideoPlay();
                }
                sg.bigo.ads.core.player.c cVar9 = dVar.H;
                if (cVar9 != null && cVar9.d) {
                    cVar9.d = false;
                    Iterator<n> it4 = cVar9.f13714a.i.iterator();
                    while (it4.hasNext()) {
                        cVar9.a(it4.next(), "va_res");
                    }
                    if (cVar9.f != null) {
                        cVar9.f.b(sg.bigo.ads.core.c.b.a.b);
                    }
                    break;
                }
                break;
            case 13:
                if (iArr != null && iArr.length > 2) {
                    sg.bigo.ads.core.player.c cVar10 = dVar.H;
                    if (cVar10 != null && iArr != null && iArr.length > 2) {
                        int i2 = iArr[0];
                        int i3 = iArr[2];
                        Iterator<l> it5 = cVar10.f13714a.b.iterator();
                        while (it5.hasNext()) {
                            l next3 = it5.next();
                            if (i3 >= next3.f13596a) {
                                cVar10.a(next3, "va_prog1");
                                it5.remove();
                            }
                        }
                        Iterator<sg.bigo.ads.core.f.a.c> it6 = cVar10.f13714a.c.iterator();
                        while (it6.hasNext()) {
                            sg.bigo.ads.core.f.a.c next4 = it6.next();
                            if (i2 >= next4.f13586a) {
                                cVar10.a(next4, "va_prog2");
                                it6.remove();
                            }
                        }
                        Iterator<Integer> it7 = cVar10.k.iterator();
                        while (it7.hasNext()) {
                            int iIntValue = it7.next().intValue();
                            if (i2 >= iIntValue) {
                                if (iIntValue == 2000) {
                                    iIntValue = 11;
                                } else if (iIntValue == 3000) {
                                    iIntValue = 12;
                                } else if (iIntValue == 5000) {
                                    iIntValue = 13;
                                } else if (iIntValue == 8000) {
                                    iIntValue = 14;
                                } else if (iIntValue == 10000) {
                                    iIntValue = 15;
                                }
                                sg.bigo.ads.core.player.c.a(aVar, iIntValue);
                                it7.remove();
                            }
                        }
                        Iterator<Integer> it8 = cVar10.j.iterator();
                        while (it8.hasNext()) {
                            int iIntValue2 = it8.next().intValue();
                            if (i3 >= iIntValue2) {
                                if (iIntValue2 == 0) {
                                    if (cVar10.f != null) {
                                        cVar10.f.a(cVar10.f13714a.s, cVar10.g ? 0.0f : 1.0f);
                                    }
                                    iIntValue2 = 2;
                                } else if (iIntValue2 == 25) {
                                    if (cVar10.f != null) {
                                        cVar10.f.a(sg.bigo.ads.core.c.b.EnumC0891b.f13531a);
                                    }
                                    iIntValue2 = 3;
                                } else if (iIntValue2 == 50) {
                                    if (cVar10.f != null) {
                                        cVar10.f.a(sg.bigo.ads.core.c.b.EnumC0891b.b);
                                    }
                                    iIntValue2 = 4;
                                } else if (iIntValue2 == 75) {
                                    if (cVar10.f != null) {
                                        cVar10.f.a(sg.bigo.ads.core.c.b.EnumC0891b.c);
                                    }
                                    iIntValue2 = 5;
                                }
                                sg.bigo.ads.core.player.c.a(aVar, iIntValue2);
                                it8.remove();
                            }
                        }
                    }
                    if (progressChangeListener != null) {
                        progressChangeListener.a(iArr[0], iArr[1]);
                    }
                    break;
                }
                break;
        }
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    static /* synthetic */ void a(d dVar, sg.bigo.ads.api.b.d.a aVar, sg.bigo.ads.api.core.c cVar, int i, boolean z) {
        m mVarE;
        sg.bigo.ads.core.a.a aVar2 = (sg.bigo.ads.core.a.a) dVar.f();
        if (!aVar2.aR()) {
            AnonymousClass4 anonymousClass4 = dVar.new AnonymousClass4(i, aVar, aVar2, cVar);
            if (z) {
                sg.bigo.ads.common.n.d.a(1, anonymousClass4);
                return;
            } else {
                anonymousClass4.run();
                return;
            }
        }
        dVar.U.f13113a = aVar2.bn();
        g gVar = new g(dVar.b.e, dVar.X, aVar2, dVar.I, aVar, dVar);
        dVar.W = gVar;
        int iX = gVar.c.x();
        if (iX == 1 || iX == 2 || !(iX == 3 || iX == 4 || (iX == 12 ? !((mVarE = gVar.c.e()) == null || 6 != mVarE.a("video_play_page.ad_component_layout", 1)) : iX == 20))) {
            gVar.e.a(gVar.f12521a, 1006, 10066, "Failed to support VPAID.");
            return;
        }
        g.AnonymousClass1 anonymousClass1 = new g.AnonymousClass1(i);
        if (z) {
            sg.bigo.ads.common.n.d.a(1, anonymousClass1);
        } else {
            anonymousClass1.run();
        }
    }

    static /* synthetic */ boolean a(d dVar, int i) {
        return ((sg.bigo.ads.core.a.a) dVar.f()).x() != 4 || i >= 5;
    }

    static /* synthetic */ void b(d dVar, int i) {
        sg.bigo.ads.core.a.a aVar = (sg.bigo.ads.core.a.a) dVar.f();
        int i2 = 1;
        if (i != 0) {
            if (i != 1) {
                i2 = i != 2 ? 0 : 3;
            } else {
                i2 = 4;
            }
        }
        aVar.h(i2);
    }

    @Override // sg.bigo.ads.ad.b.c
    protected final List<sg.bigo.ads.core.c.a> A() {
        List<sg.bigo.ads.core.c.a> list;
        p pVar = this.I;
        return (pVar == null || (list = pVar.C) == null || list.size() <= 0) ? super.A() : list;
    }

    @Override // sg.bigo.ads.ad.b.c
    protected final boolean C() {
        return ((sg.bigo.ads.core.a.a) f()).aQ();
    }

    public final Pair<Boolean, Boolean> D() {
        boolean z;
        sg.bigo.ads.core.a.a aVar = (sg.bigo.ads.core.a.a) f();
        Pair<Boolean, Boolean> pair = this.w;
        if (pair != null) {
            return pair;
        }
        p pVar = this.I;
        boolean z2 = false;
        if (pVar != null) {
            z = false;
            for (sg.bigo.ads.core.f.a.a aVar2 : pVar.A) {
                if (aVar2 != null) {
                    sg.bigo.ads.core.f.a.a.C0894a c0894aA = sg.bigo.ads.core.f.a.a.a(aVar2.b);
                    if (!z2 && c0894aA != null && c0894aA.a()) {
                        aVar.a(c0894aA);
                        z2 = true;
                    }
                    sg.bigo.ads.core.f.a.a.C0894a c0894aA2 = sg.bigo.ads.core.f.a.a.a(aVar2.f13576a);
                    if (!z && c0894aA2 != null && c0894aA2.a()) {
                        aVar.b(c0894aA2);
                        z = true;
                    }
                }
            }
        } else {
            z = false;
        }
        Pair<Boolean, Boolean> pair2 = new Pair<>(Boolean.valueOf(z2), Boolean.valueOf(z));
        this.w = pair2;
        return pair2;
    }

    protected k E() {
        int iG = this.b.b.g();
        h hVar = i.f13093a;
        return new k(iG, (hVar == null || hVar.r() == null) ? 0 : hVar.r().a());
    }

    @Override // sg.bigo.ads.ad.b.c, sg.bigo.ads.ad.c
    public final void a(Point point, int i, int i2, sg.bigo.ads.api.core.e eVar) {
        super.a(point, i, i2, eVar);
        sg.bigo.ads.core.player.c cVar = this.H;
        if (cVar != null) {
            cVar.a();
        }
    }

    @Override // sg.bigo.ads.ad.b.c
    public final void a(ViewGroup viewGroup, MediaView mediaView, ImageView imageView, AdOptionsView adOptionsView, List<View> list, int i, View... viewArr) {
        super.a(viewGroup, mediaView, imageView, adOptionsView, list, i, viewArr);
        sg.bigo.ads.core.player.c cVar = this.H;
        if (cVar != null) {
            cVar.f = this.B;
        }
    }

    @Override // sg.bigo.ads.ad.b.c
    public void a(MediaView mediaView) {
        g gVar;
        if (this.I == null || mediaView == null) {
            return;
        }
        sg.bigo.ads.core.a.a aVar = (sg.bigo.ads.core.a.a) f();
        if (!aVar.aR() || (gVar = this.W) == null) {
            mediaView.a(aVar, this.I, this.X);
            VideoController videoController = mediaView.getVideoController();
            if (videoController != null) {
                videoController.mute(this.b.b.i());
                return;
            }
            return;
        }
        boolean zI = this.b.b.i();
        if (gVar.d != null) {
            mediaView.a(gVar.h);
            VideoController videoController2 = mediaView.getVideoController();
            if (videoController2 != null) {
                videoController2.mute(zI);
            }
        }
    }

    @Override // sg.bigo.ads.ad.b.c
    public void a(final sg.bigo.ads.api.b.d.a<NativeAd> aVar, int i) {
        sg.bigo.ads.api.a.j jVarN;
        final sg.bigo.ads.api.core.c cVar = this.b.f13106a;
        if (!(cVar instanceof sg.bigo.ads.core.a.a)) {
            aVar.a(this, 1030, IronSourceConstants.RV_CAP_PLACEMENT, "NativeVideo with invalid AdData class type.");
            return;
        }
        sg.bigo.ads.api.core.o.c cVarAx = ((sg.bigo.ads.core.a.a) cVar).ax();
        if (cVarAx == null) {
            aVar.a(this, 1031, IronSourceConstants.RV_CAP_SESSION, "Missing media video.");
            return;
        }
        final String strC = cVarAx.c();
        h hVar = i.f13093a;
        if (hVar == null || (jVarN = hVar.n()) == null || !jVarN.a(14)) {
            sg.bigo.ads.common.n.d.a(1, new Runnable() { // from class: sg.bigo.ads.ad.b.d.3
                @Override // java.lang.Runnable
                public final void run() {
                    d.a(d.this, aVar, cVar, d.a(d.this, strC), false);
                }
            });
        } else {
            sg.bigo.ads.common.u.a.e.f().execute(new Runnable() { // from class: sg.bigo.ads.ad.b.d.2
                @Override // java.lang.Runnable
                public final void run() {
                    d.a(d.this, aVar, cVar, d.a(d.this, strC), true);
                }
            });
        }
    }

    @Override // sg.bigo.ads.ad.c
    public final void a_() {
        g gVar = this.W;
        if (gVar == null || !gVar.a()) {
            super.a_();
            sg.bigo.ads.common.t.a.a(0, 3, "NativeVideoAdImpl", "BIGOAds impression method");
        }
    }

    @Override // sg.bigo.ads.ad.b.c, sg.bigo.ads.ad.d, sg.bigo.ads.ad.c
    public void destroyInMainThread() {
        VideoController videoController = getVideoController();
        if (videoController != null) {
            videoController.setVideoLifeCallback(null);
        }
        super.destroyInMainThread();
        sg.bigo.ads.core.player.c cVar = this.H;
        if (cVar != null) {
            if (cVar.c && !cVar.b) {
                cVar.b = true;
            }
            if (cVar.f13714a != null) {
                Iterator<n> it = cVar.f13714a.l.iterator();
                while (it.hasNext()) {
                    cVar.a(it.next(), "va_des");
                }
            }
            sg.bigo.ads.common.t.a.a(0, 3, "AdTracker", "destroy");
            cVar.f = null;
        }
        g gVar = this.W;
        if (gVar != null) {
            if (gVar.h != null) {
                u.b(gVar.h);
                gVar.h.d();
                gVar.h = null;
            }
            gVar.f12521a = null;
            gVar.c = null;
            gVar.g = null;
            gVar.d = null;
            this.W = null;
        }
        this.v = null;
    }

    @Override // sg.bigo.ads.ad.b.c, sg.bigo.ads.api.NativeAd
    public NativeAd.CreativeType getCreativeType() {
        return NativeAd.CreativeType.VIDEO;
    }

    @Override // sg.bigo.ads.ad.b.c, sg.bigo.ads.api.NativeAd
    public VideoController getVideoController() {
        if (this.D != null) {
            return this.D.getVideoController();
        }
        return null;
    }

    @Override // sg.bigo.ads.ad.b.c, sg.bigo.ads.ad.c
    public void h() {
        super.h();
        sg.bigo.ads.core.a.a aVar = (sg.bigo.ads.core.a.a) f();
        sg.bigo.ads.core.player.c cVar = this.H;
        if (cVar != null) {
            if (!cVar.b) {
                cVar.b = true;
            }
            sg.bigo.ads.core.player.c.a(aVar, 1);
            Iterator<n> it = cVar.f13714a.f13600a.iterator();
            while (it.hasNext()) {
                cVar.a(it.next(), "va_show");
            }
        }
    }

    @Override // sg.bigo.ads.ad.c, sg.bigo.ads.api.Ad, sg.bigo.ads.api.IconAds
    public void setAdInteractionListener(AdInteractionListener adInteractionListener) {
        super.setAdInteractionListener(this.V);
        this.V.f12518a = adInteractionListener;
    }
}
