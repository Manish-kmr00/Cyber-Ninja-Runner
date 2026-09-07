package com.inmobi.media;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Point;
import android.media.MediaMetadataRetriever;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.RelativeLayout;
import androidx.core.view.GravityCompat;
import com.facebook.share.internal.ShareConstants;
import com.inmobi.ads.viewsv2.NativeRecyclerViewAdapter;
import com.inmobi.commons.core.configs.AdConfig;
import com.safedk.android.analytics.brandsafety.creatives.CreativeInfoManager;
import com.safedk.android.utils.Logger;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import net.pubnative.lite.sdk.vpaid.enums.EventConstants;

/* JADX INFO: loaded from: classes6.dex */
public final class L7 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AdConfig f3125a;
    public final C3313b7 b;
    public final C3625x7 c;
    public final E7 d;
    public final D7 e;
    public final L4 f;
    public final String g;
    public final Handler h;
    public final WeakReference i;
    public T7 j;
    public int k;
    public final L0 l;
    public final K8 m;
    public boolean n;
    public Ba o;
    public F7 p;

    public L7(Context context, AdConfig adConfig, C3313b7 nativeAdContainer, C3625x7 dataModel, E7 viewEventListener, D7 clickEventListener, F7 timerFinishListener, L4 l4) {
        K8 k8;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(adConfig, "adConfig");
        Intrinsics.checkNotNullParameter(nativeAdContainer, "nativeAdContainer");
        Intrinsics.checkNotNullParameter(dataModel, "dataModel");
        Intrinsics.checkNotNullParameter(viewEventListener, "viewEventListener");
        Intrinsics.checkNotNullParameter(clickEventListener, "clickEventListener");
        Intrinsics.checkNotNullParameter(timerFinishListener, "timerFinishListener");
        this.f3125a = adConfig;
        this.b = nativeAdContainer;
        this.c = dataModel;
        this.d = viewEventListener;
        this.e = clickEventListener;
        this.f = l4;
        this.g = "L7";
        this.h = new Handler(Looper.getMainLooper());
        this.i = new WeakReference(context);
        this.l = new L0();
        HashMap map = K8.c;
        Intrinsics.checkNotNullParameter(context, "context");
        WeakReference weakReference = K8.d;
        K8 k9 = weakReference != null ? (K8) weakReference.get() : null;
        if (k9 == null) {
            synchronized (K8.class) {
                WeakReference weakReference2 = K8.d;
                if (weakReference2 == null || (k8 = (K8) weakReference2.get()) == null) {
                    k8 = new K8(context);
                    K8.d = new WeakReference(k8);
                }
                Intrinsics.checkNotNull(k8);
            }
            k9 = k8;
        }
        this.m = k9;
        this.p = timerFinishListener;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0023  */
    public final ViewGroup a(ViewGroup parent, C3513p7 root) {
        ViewGroup viewGroup;
        Intrinsics.checkNotNullParameter(parent, "parent");
        Intrinsics.checkNotNullParameter(root, "root");
        Context context = (Context) this.i.get();
        if (context != null) {
            View viewA = this.m.a(context, root, this.f3125a);
            if (viewA instanceof ViewGroup) {
                viewGroup = (ViewGroup) viewA;
            } else {
                viewGroup = null;
            }
        } else {
            viewGroup = null;
        }
        if (viewGroup != null) {
            HashMap map = K8.c;
            viewGroup.setLayoutParams(C3584u8.a(root, parent));
        }
        return viewGroup;
    }

    public final void b(View view, final C3455l7 c3455l7) {
        if (c3455l7.f) {
            view.setOnClickListener(new View.OnClickListener() { // from class: com.inmobi.media.L7$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    Logger.d("InMobi|SafeDK: Execution> Lcom/inmobi/media/L7$$ExternalSyntheticLambda0;->onClick(Landroid/view/View;)V");
                    CreativeInfoManager.onViewClicked(com.safedk.android.utils.h.i, view2);
                    safedk_L7$$ExternalSyntheticLambda0_onClick_7f031a3dd5846e29c39a5b46f52d9752(view2);
                }

                public void safedk_L7$$ExternalSyntheticLambda0_onClick_7f031a3dd5846e29c39a5b46f52d9752(View p0) {
                    L7.a(this.f$0, c3455l7, p0);
                }
            });
        }
    }

    /* JADX WARN: Code duplicated, block: B:100:0x0221  */
    /* JADX WARN: Code duplicated, block: B:103:0x022d  */
    /* JADX WARN: Code duplicated, block: B:104:0x0231  */
    /* JADX WARN: Code duplicated, block: B:107:0x023b A[Catch: IOException -> 0x0263, TRY_LEAVE, TryCatch #1 {IOException -> 0x0263, blocks: (B:105:0x0237, B:107:0x023b), top: B:215:0x0237 }] */
    /* JADX WARN: Code duplicated, block: B:111:0x0248  */
    /* JADX WARN: Code duplicated, block: B:123:0x0278  */
    /* JADX WARN: Code duplicated, block: B:126:0x029b  */
    /* JADX WARN: Code duplicated, block: B:134:0x02bc  */
    /* JADX WARN: Code duplicated, block: B:137:0x02cc  */
    /* JADX WARN: Code duplicated, block: B:139:0x02d5  */
    /* JADX WARN: Code duplicated, block: B:144:0x02f1  */
    /* JADX WARN: Code duplicated, block: B:146:0x02f5  */
    /* JADX WARN: Code duplicated, block: B:147:0x02fa  */
    /* JADX WARN: Code duplicated, block: B:149:0x02fd  */
    /* JADX WARN: Code duplicated, block: B:151:0x0309  */
    /* JADX WARN: Code duplicated, block: B:152:0x030c  */
    /* JADX WARN: Code duplicated, block: B:156:0x0315 A[Catch: Exception -> 0x0397, TryCatch #4 {Exception -> 0x0397, blocks: (B:154:0x030f, B:156:0x0315, B:158:0x031d, B:160:0x0333, B:163:0x033b, B:165:0x0341), top: B:221:0x030f }] */
    /* JADX WARN: Code duplicated, block: B:157:0x031c  */
    /* JADX WARN: Code duplicated, block: B:160:0x0333 A[Catch: Exception -> 0x0397, TryCatch #4 {Exception -> 0x0397, blocks: (B:154:0x030f, B:156:0x0315, B:158:0x031d, B:160:0x0333, B:163:0x033b, B:165:0x0341), top: B:221:0x030f }] */
    /* JADX WARN: Code duplicated, block: B:161:0x0338  */
    /* JADX WARN: Code duplicated, block: B:163:0x033b A[Catch: Exception -> 0x0397, TryCatch #4 {Exception -> 0x0397, blocks: (B:154:0x030f, B:156:0x0315, B:158:0x031d, B:160:0x0333, B:163:0x033b, B:165:0x0341), top: B:221:0x030f }] */
    /* JADX WARN: Code duplicated, block: B:164:0x0340  */
    /* JADX WARN: Code duplicated, block: B:169:0x0365 A[Catch: Exception -> 0x0395, TryCatch #5 {Exception -> 0x0395, blocks: (B:167:0x0353, B:169:0x0365, B:171:0x038d, B:170:0x0377), top: B:223:0x0353 }] */
    /* JADX WARN: Code duplicated, block: B:170:0x0377 A[Catch: Exception -> 0x0395, TryCatch #5 {Exception -> 0x0395, blocks: (B:167:0x0353, B:169:0x0365, B:171:0x038d, B:170:0x0377), top: B:223:0x0353 }] */
    /* JADX WARN: Code duplicated, block: B:179:0x03be  */
    /* JADX WARN: Code duplicated, block: B:182:0x03ca  */
    /* JADX WARN: Code duplicated, block: B:204:0x043e  */
    /* JADX WARN: Code duplicated, block: B:221:0x030f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:27:0x008f  */
    /* JADX WARN: Code duplicated, block: B:29:0x0099  */
    /* JADX WARN: Code duplicated, block: B:31:0x009e  */
    /* JADX WARN: Code duplicated, block: B:33:0x00a7  */
    /* JADX WARN: Code duplicated, block: B:34:0x00ab  */
    /* JADX WARN: Code duplicated, block: B:63:0x0141  */
    /* JADX WARN: Code duplicated, block: B:65:0x0144  */
    /* JADX WARN: Code duplicated, block: B:67:0x014e  */
    /* JADX WARN: Code duplicated, block: B:68:0x0157  */
    /* JADX WARN: Code duplicated, block: B:70:0x015a  */
    /* JADX WARN: Code duplicated, block: B:72:0x0164  */
    /* JADX WARN: Code duplicated, block: B:73:0x017a  */
    /* JADX WARN: Code duplicated, block: B:75:0x0180  */
    /* JADX WARN: Code duplicated, block: B:78:0x01aa  */
    /* JADX WARN: Code duplicated, block: B:81:0x01c0  */
    /* JADX WARN: Code duplicated, block: B:84:0x01c9  */
    /* JADX WARN: Code duplicated, block: B:87:0x01d2  */
    /* JADX WARN: Code duplicated, block: B:91:0x01ef  */
    /* JADX WARN: Code duplicated, block: B:92:0x01f2  */
    /* JADX WARN: Code duplicated, block: B:94:0x01f5  */
    /* JADX WARN: Code duplicated, block: B:96:0x01fd  */
    /* JADX WARN: Code duplicated, block: B:99:0x021b  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v32 */
    /* JADX WARN: Type inference failed for: r0v33, types: [com.inmobi.media.j8, com.inmobi.media.l7] */
    /* JADX WARN: Type inference failed for: r0v99 */
    /* JADX WARN: Type inference failed for: r10v0 */
    /* JADX WARN: Type inference failed for: r10v1, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r10v5 */
    /* JADX WARN: Type inference failed for: r13v11, types: [android.view.TextureView, android.view.View, com.inmobi.media.s8] */
    /* JADX WARN: Type inference failed for: r13v2, types: [android.media.MediaMetadataRetriever] */
    /* JADX WARN: Type inference failed for: r14v16 */
    /* JADX WARN: Type inference failed for: r14v2 */
    /* JADX WARN: Type inference failed for: r14v3, types: [int] */
    /* JADX WARN: Type inference failed for: r2v41, types: [com.inmobi.media.h8] */
    /* JADX WARN: Type inference failed for: r3v12 */
    /* JADX WARN: Type inference failed for: r3v13, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r3v16 */
    /* JADX WARN: Type inference failed for: r3v17, types: [int] */
    /* JADX WARN: Type inference failed for: r3v54 */
    /* JADX WARN: Type inference failed for: r3v55 */
    public final ViewGroup b(ViewGroup viewGroup, C3513p7 c3513p7) {
        View viewA;
        final WeakReference weakReference;
        Object obj;
        Object obj2;
        C3570t8 c3570t8;
        int i;
        L7 l7;
        C3570t8 c3570t9;
        Object tag;
        ?? r0;
        RelativeLayout.LayoutParams layoutParams;
        Rc rcD;
        ?? B;
        String strExtractMetadata;
        String strExtractMetadata2;
        ?? r3;
        ?? r14;
        Point point;
        double d;
        double d2;
        double dA;
        double dA2;
        int i2;
        C3426j8 c3426j8;
        C3426j8 videoAsset;
        ?? videoView;
        C3513p7 c3513p8;
        long jCurrentTimeMillis;
        Object obj3;
        Rc rc;
        String strB;
        Uri uri;
        Object obj4;
        O7 o7A;
        int i3;
        int i4;
        C3455l7 c3455l7;
        C3313b7 c3313b7;
        O7 o7;
        long j;
        Context context;
        T7 nativeRecyclerViewAdapter;
        int i5;
        int i6;
        int i7;
        L7 inflater = this;
        b((View) viewGroup, (C3455l7) c3513p7);
        ?? r10 = 0;
        int i8 = 0;
        while (i8 < c3513p7.B) {
            try {
                int i9 = i8 + 1;
                C3455l7 c3455l8 = (C3455l7) c3513p7.A.get(i8);
                Intrinsics.checkNotNull(c3455l8);
                t7 = null;
                T7 t7 = null;
                if (Intrinsics.areEqual("CONTAINER", c3455l8.c)) {
                    if (StringsKt.equals(c3455l8.b, "card_scrollable", true)) {
                        Context context2 = (Context) inflater.i.get();
                        View viewA2 = context2 != null ? inflater.m.a(context2, c3455l8, inflater.f3125a) : null;
                        if (viewA2 instanceof S7) {
                            S7 s7 = (S7) viewA2;
                            byte type = s7.getType();
                            C3625x7 dataModel = inflater.c;
                            Intrinsics.checkNotNullParameter(dataModel, "dataModel");
                            Intrinsics.checkNotNullParameter(inflater, "inflater");
                            if (type == 0) {
                                nativeRecyclerViewAdapter = new C3639y7(dataModel, inflater);
                            } else {
                                if (type == 1) {
                                    try {
                                        nativeRecyclerViewAdapter = new NativeRecyclerViewAdapter(dataModel, inflater);
                                    } catch (NoClassDefFoundError e) {
                                        AbstractC3498o6.a((byte) 1, "InMobi", "Error rendering ad! RecyclerView not found. Please check if the recyclerview support library was included");
                                        C3339d5 c3339d5 = C3339d5.f3292a;
                                        P1 event = new P1(e);
                                        Intrinsics.checkNotNullParameter(event, "event");
                                        C3339d5.c.a(event);
                                    }
                                }
                                inflater.j = t7;
                                if (t7 != null) {
                                    Intrinsics.checkNotNull(c3455l8, "null cannot be cast to non-null type com.inmobi.ads.modelsv2.NativeContainerAsset");
                                    C3513p7 c3513p9 = (C3513p7) c3455l8;
                                    i5 = inflater.k;
                                    if (i5 == 0) {
                                        i7 = GravityCompat.START;
                                    } else {
                                        if (i5 == inflater.c.d() - 1) {
                                            i7 = GravityCompat.END;
                                        } else {
                                            i6 = 1;
                                        }
                                        s7.a(c3513p9, t7, i5, i6, this);
                                        HashMap map = K8.c;
                                        s7.setLayoutParams(C3584u8.a(c3455l8, viewGroup));
                                        inflater.a(viewA2, c3455l8);
                                        viewGroup.addView(viewA2);
                                    }
                                    i6 = i7;
                                    s7.a(c3513p9, t7, i5, i6, this);
                                    HashMap map2 = K8.c;
                                    s7.setLayoutParams(C3584u8.a(c3455l8, viewGroup));
                                    inflater.a(viewA2, c3455l8);
                                    viewGroup.addView(viewA2);
                                }
                            }
                            t7 = nativeRecyclerViewAdapter;
                            inflater.j = t7;
                            if (t7 != null) {
                                Intrinsics.checkNotNull(c3455l8, "null cannot be cast to non-null type com.inmobi.ads.modelsv2.NativeContainerAsset");
                                C3513p7 c3513p10 = (C3513p7) c3455l8;
                                i5 = inflater.k;
                                if (i5 == 0) {
                                    i7 = GravityCompat.START;
                                } else {
                                    if (i5 == inflater.c.d() - 1) {
                                        i7 = GravityCompat.END;
                                    } else {
                                        i6 = 1;
                                    }
                                    s7.a(c3513p10, t7, i5, i6, this);
                                    HashMap map3 = K8.c;
                                    s7.setLayoutParams(C3584u8.a(c3455l8, viewGroup));
                                    inflater.a(viewA2, c3455l8);
                                    viewGroup.addView(viewA2);
                                }
                                i6 = i7;
                                s7.a(c3513p10, t7, i5, i6, this);
                                HashMap map4 = K8.c;
                                s7.setLayoutParams(C3584u8.a(c3455l8, viewGroup));
                                inflater.a(viewA2, c3455l8);
                                viewGroup.addView(viewA2);
                            }
                        }
                    } else {
                        Context context3 = (Context) inflater.i.get();
                        View viewA3 = context3 != null ? inflater.m.a(context3, c3455l8, inflater.f3125a) : null;
                        if (viewA3 instanceof ViewGroup) {
                            Intrinsics.checkNotNull(c3455l8, "null cannot be cast to non-null type com.inmobi.ads.modelsv2.NativeContainerAsset");
                            ViewGroup viewGroupB = inflater.b((ViewGroup) viewA3, (C3513p7) c3455l8);
                            HashMap map5 = K8.c;
                            viewGroupB.setLayoutParams(C3584u8.a(c3455l8, viewGroup));
                            inflater.a(viewGroupB, c3455l8);
                            viewGroup.addView(viewGroupB);
                        }
                    }
                } else if (Intrinsics.areEqual("WEBVIEW", c3455l8.c)) {
                    Intrinsics.checkNotNull(c3455l8, "null cannot be cast to non-null type com.inmobi.ads.modelsv2.NativeWebViewAsset");
                    M8 m8 = (M8) c3455l8;
                    if (m8.z && (viewA = inflater.o) != null) {
                        ViewParent parent = viewA.getParent();
                        ViewGroup viewGroup2 = parent instanceof ViewGroup ? (ViewGroup) parent : null;
                        if (viewGroup2 != null) {
                            viewGroup2.removeView(viewA);
                        }
                        inflater.o = null;
                        if (viewA == null) {
                            context = (Context) inflater.i.get();
                            if (context != null) {
                                viewA = inflater.m.a(context, c3455l8, inflater.f3125a);
                            } else {
                                viewA = null;
                            }
                        }
                        if (viewA != null) {
                            weakReference = new WeakReference(viewA);
                            if (c3455l8.n == -1) {
                                obj = "WEBVIEW";
                                if (c3455l8.o != -1) {
                                    inflater.h.postDelayed(new Runnable() { // from class: com.inmobi.media.L7$$ExternalSyntheticLambda3
                                        @Override // java.lang.Runnable
                                        public final void run() {
                                            L7.a(weakReference);
                                        }
                                    }, c3455l8.o * 1000);
                                }
                            } else {
                                viewA.setVisibility(4);
                                obj = "WEBVIEW";
                                inflater.h.postDelayed(new Runnable() { // from class: com.inmobi.media.L7$$ExternalSyntheticLambda2
                                    @Override // java.lang.Runnable
                                    public final void run() {
                                        L7.b(weakReference);
                                    }
                                }, c3455l8.n * 1000);
                            }
                            HashMap map6 = K8.c;
                            viewA.setLayoutParams(C3584u8.a(c3455l8, viewGroup));
                            inflater.a(viewA, c3455l8);
                            viewGroup.addView(viewA);
                            if (!Intrinsics.areEqual(ShareConstants.VIDEO_URL, c3455l8.c)) {
                                obj2 = ShareConstants.VIDEO_URL;
                                c3570t8 = null;
                            } else {
                                Intrinsics.checkNotNull(c3455l8, "null cannot be cast to non-null type com.inmobi.ads.modelsv2.NativeVideoAsset");
                                videoAsset = (C3426j8) c3455l8;
                                videoView = ((C3570t8) viewA).getVideoView();
                                c3513p8 = videoAsset.r;
                                if (!(c3513p8 instanceof C3513p7)) {
                                    c3513p8 = null;
                                }
                                jCurrentTimeMillis = System.currentTimeMillis();
                                obj2 = ShareConstants.VIDEO_URL;
                                if (c3513p8 != null) {
                                    j = c3513p8.y;
                                    if (0 == j) {
                                        j = jCurrentTimeMillis;
                                    }
                                    c3513p8.y = j;
                                }
                                videoView.setClickable(r10);
                                videoView.setId(Integer.MAX_VALUE);
                                Intrinsics.checkNotNullParameter(videoAsset, "videoAsset");
                                videoView.e = r10;
                                videoView.f = r10;
                                obj3 = videoAsset.e;
                                if (obj3 instanceof Rc) {
                                    rc = (Rc) obj3;
                                } else {
                                    rc = null;
                                }
                                if (rc != null) {
                                    strB = "";
                                } else {
                                    strB = "";
                                }
                                uri = Uri.parse(strB);
                                videoView.f3427a = uri;
                                obj4 = videoAsset.t.get("placementType");
                                Intrinsics.checkNotNull(obj4, "null cannot be cast to non-null type kotlin.Byte");
                                if (1 == ((Byte) obj4).byteValue()) {
                                    o7A = new O7();
                                } else {
                                    Object obj5 = O7.d;
                                    o7A = N7.a();
                                }
                                videoView.c = o7A;
                                i3 = videoView.d;
                                if (i3 != 0) {
                                    o7A.setAudioSessionId(i3);
                                } else {
                                    videoView.d = o7A.getAudioSessionId();
                                }
                                o7 = videoView.c;
                                if (o7 != null) {
                                    c3570t8 = null;
                                    o7.setDataSource(videoView.getContext().getApplicationContext(), uri, (Map<String, String>) null);
                                } else {
                                    c3570t8 = null;
                                }
                                videoView.setTag(videoAsset);
                                videoView.m = new HandlerC3514p8(videoView);
                                videoView.setSurfaceTextureListener(videoView.B);
                                videoView.setFocusable(true);
                                videoView.setFocusableInTouchMode(true);
                                videoView.requestFocus();
                                c3455l7 = videoAsset.w;
                                if (c3455l7 instanceof C3426j8) {
                                    videoAsset.a((C3426j8) c3455l7);
                                }
                                videoView.setQuartileCompletedListener(new H7(inflater, videoAsset));
                                videoView.setPlaybackEventListener(new I7(inflater, videoAsset));
                                videoView.setMediaErrorListener(new J7(inflater, videoAsset));
                                c3313b7 = inflater.b;
                                if (!c3313b7.t) {
                                    ((C3398h8) c3313b7).b(videoAsset, videoView);
                                }
                            }
                            inflater.b(viewA, c3455l8);
                            if (Intrinsics.areEqual("TIMER", c3455l8.c)) {
                                viewA.setTag("timerView");
                                if (c3455l8 instanceof Y7) {
                                    ((C3314b8) viewA).setTimerEventsListener(new K7(inflater, (Y7) c3455l8));
                                }
                            }
                            if (Intrinsics.areEqual(obj2, c3455l8.c)) {
                                if (viewA instanceof C3570t8) {
                                    c3570t9 = (C3570t8) viewA;
                                } else {
                                    c3570t9 = c3570t8;
                                }
                                if (c3570t9 != null) {
                                    tag = c3570t9.getVideoView().getTag();
                                    if (tag instanceof C3426j8) {
                                        c3426j8 = (C3426j8) tag;
                                    } else {
                                        r0 = c3570t8;
                                    }
                                    if (r0 != 0) {
                                        r0 = c3426j8;
                                        rcD = r0.d();
                                        if (rcD != null) {
                                            B = ((Qc) rcD).b();
                                        } else {
                                            B = c3570t8;
                                        }
                                        ?? mediaMetadataRetriever = new MediaMetadataRetriever();
                                        mediaMetadataRetriever.setDataSource(B);
                                        strExtractMetadata = mediaMetadataRetriever.extractMetadata(18);
                                        strExtractMetadata2 = mediaMetadataRetriever.extractMetadata(19);
                                        if (strExtractMetadata != null) {
                                            i2 = Integer.parseInt(strExtractMetadata);
                                        } else {
                                            r3 = r10;
                                        }
                                        if (strExtractMetadata2 != null) {
                                            r3 = i2;
                                            r14 = Integer.parseInt(strExtractMetadata2);
                                        } else {
                                            r3 = i2;
                                            r14 = r10;
                                        }
                                        mediaMetadataRetriever.release();
                                        point = r0.d.f3375a;
                                        HashMap map7 = K8.c;
                                        i = i9;
                                        d = (double) r3;
                                        d2 = (double) r14;
                                        if (((double) C3584u8.a(point.x)) / ((double) C3584u8.a(point.y)) > d / d2) {
                                            dA2 = ((((double) C3584u8.a(point.y)) * 1.0d) / d2) * d;
                                            dA = C3584u8.a(point.y);
                                        } else {
                                            double dA3 = C3584u8.a(point.x);
                                            dA = ((((double) C3584u8.a(point.x)) * 1.0d) / d) * d2;
                                            dA2 = dA3;
                                        }
                                        layoutParams = new RelativeLayout.LayoutParams((int) dA2, (int) dA);
                                        layoutParams.addRule(13);
                                        c3570t9.getVideoView().setLayoutParams(layoutParams);
                                    } else {
                                        r0 = c3426j8;
                                        i = i9;
                                    }
                                } else {
                                    r0 = c3426j8;
                                    i = i9;
                                }
                            } else {
                                r0 = c3426j8;
                                i = i9;
                            }
                            if (Intrinsics.areEqual(obj, c3455l8.c)) {
                                l7 = this;
                            } else {
                                l7 = this;
                            }
                        }
                        inflater = l7;
                        i8 = i;
                        r10 = 0;
                    } else {
                        if (!Intrinsics.areEqual("UNKNOWN", m8.y)) {
                            viewA = null;
                            if (viewA == null) {
                                context = (Context) inflater.i.get();
                                if (context != null) {
                                    viewA = inflater.m.a(context, c3455l8, inflater.f3125a);
                                } else {
                                    viewA = null;
                                }
                            }
                            if (viewA != null) {
                                weakReference = new WeakReference(viewA);
                                if (c3455l8.n == -1) {
                                    obj = "WEBVIEW";
                                    if (c3455l8.o != -1) {
                                        inflater.h.postDelayed(new Runnable() { // from class: com.inmobi.media.L7$$ExternalSyntheticLambda3
                                            @Override // java.lang.Runnable
                                            public final void run() {
                                                L7.a(weakReference);
                                            }
                                        }, c3455l8.o * 1000);
                                    }
                                } else {
                                    viewA.setVisibility(4);
                                    obj = "WEBVIEW";
                                    inflater.h.postDelayed(new Runnable() { // from class: com.inmobi.media.L7$$ExternalSyntheticLambda2
                                        @Override // java.lang.Runnable
                                        public final void run() {
                                            L7.b(weakReference);
                                        }
                                    }, c3455l8.n * 1000);
                                }
                                HashMap map8 = K8.c;
                                viewA.setLayoutParams(C3584u8.a(c3455l8, viewGroup));
                                inflater.a(viewA, c3455l8);
                                viewGroup.addView(viewA);
                                if (!Intrinsics.areEqual(ShareConstants.VIDEO_URL, c3455l8.c)) {
                                    obj2 = ShareConstants.VIDEO_URL;
                                    c3570t8 = null;
                                } else {
                                    Intrinsics.checkNotNull(c3455l8, "null cannot be cast to non-null type com.inmobi.ads.modelsv2.NativeVideoAsset");
                                    videoAsset = (C3426j8) c3455l8;
                                    videoView = ((C3570t8) viewA).getVideoView();
                                    c3513p8 = videoAsset.r;
                                    if (!(c3513p8 instanceof C3513p7)) {
                                        c3513p8 = null;
                                    }
                                    jCurrentTimeMillis = System.currentTimeMillis();
                                    obj2 = ShareConstants.VIDEO_URL;
                                    if (c3513p8 != null) {
                                        j = c3513p8.y;
                                        if (0 == j) {
                                            j = jCurrentTimeMillis;
                                        }
                                        c3513p8.y = j;
                                    }
                                    videoView.setClickable(r10);
                                    videoView.setId(Integer.MAX_VALUE);
                                    Intrinsics.checkNotNullParameter(videoAsset, "videoAsset");
                                    videoView.e = r10;
                                    videoView.f = r10;
                                    obj3 = videoAsset.e;
                                    if (obj3 instanceof Rc) {
                                        rc = (Rc) obj3;
                                    } else {
                                        rc = null;
                                    }
                                    if (rc != null || (strB = ((Qc) rc).b()) == null) {
                                        strB = "";
                                    }
                                    uri = Uri.parse(strB);
                                    videoView.f3427a = uri;
                                    obj4 = videoAsset.t.get("placementType");
                                    Intrinsics.checkNotNull(obj4, "null cannot be cast to non-null type kotlin.Byte");
                                    if (1 == ((Byte) obj4).byteValue()) {
                                        o7A = new O7();
                                    } else {
                                        Object obj6 = O7.d;
                                        o7A = N7.a();
                                    }
                                    videoView.c = o7A;
                                    i3 = videoView.d;
                                    if (i3 != 0) {
                                        o7A.setAudioSessionId(i3);
                                    } else {
                                        videoView.d = o7A.getAudioSessionId();
                                    }
                                    try {
                                        o7 = videoView.c;
                                        if (o7 != null) {
                                            c3570t8 = null;
                                            try {
                                                o7.setDataSource(videoView.getContext().getApplicationContext(), uri, (Map<String, String>) null);
                                            } catch (IOException unused) {
                                                O7 o8 = videoView.c;
                                                if (o8 == null) {
                                                    i4 = -1;
                                                } else {
                                                    i4 = -1;
                                                    o8.f3156a = -1;
                                                }
                                                if (o8 != null) {
                                                    o8.b = i4;
                                                }
                                            }
                                        } else {
                                            c3570t8 = null;
                                        }
                                        videoView.setTag(videoAsset);
                                        videoView.m = new HandlerC3514p8(videoView);
                                        videoView.setSurfaceTextureListener(videoView.B);
                                        videoView.setFocusable(true);
                                        videoView.setFocusableInTouchMode(true);
                                        videoView.requestFocus();
                                    } catch (IOException unused2) {
                                        c3570t8 = null;
                                    }
                                    c3455l7 = videoAsset.w;
                                    if (c3455l7 instanceof C3426j8) {
                                        videoAsset.a((C3426j8) c3455l7);
                                    }
                                    videoView.setQuartileCompletedListener(new H7(inflater, videoAsset));
                                    videoView.setPlaybackEventListener(new I7(inflater, videoAsset));
                                    videoView.setMediaErrorListener(new J7(inflater, videoAsset));
                                    c3313b7 = inflater.b;
                                    if (!c3313b7.t && (c3313b7 instanceof C3398h8)) {
                                        try {
                                            ((C3398h8) c3313b7).b(videoAsset, videoView);
                                        } catch (Exception e2) {
                                            L4 l4 = inflater.f;
                                            if (l4 != null) {
                                                String str = inflater.g;
                                                ((M4) l4).b(str, ld.a(e2, O5.a(str, "TAG", "SDK encountered unexpected error in handling the onVideoViewCreated event; ")));
                                            }
                                        }
                                    }
                                }
                                inflater.b(viewA, c3455l8);
                                if (Intrinsics.areEqual("TIMER", c3455l8.c)) {
                                    viewA.setTag("timerView");
                                    if ((c3455l8 instanceof Y7) && (viewA instanceof C3314b8)) {
                                        ((C3314b8) viewA).setTimerEventsListener(new K7(inflater, (Y7) c3455l8));
                                    }
                                }
                                if (Intrinsics.areEqual(obj2, c3455l8.c)) {
                                    r0 = c3426j8;
                                    i = i9;
                                } else {
                                    if (viewA instanceof C3570t8) {
                                        c3570t9 = (C3570t8) viewA;
                                    } else {
                                        c3570t9 = c3570t8;
                                    }
                                    if (c3570t9 != null) {
                                        tag = c3570t9.getVideoView().getTag();
                                        if (tag instanceof C3426j8) {
                                            c3426j8 = (C3426j8) tag;
                                        } else {
                                            r0 = c3570t8;
                                        }
                                        if (r0 != 0) {
                                            try {
                                                r0 = c3426j8;
                                                rcD = r0.d();
                                                if (rcD != null) {
                                                    B = ((Qc) rcD).b();
                                                } else {
                                                    B = c3570t8;
                                                }
                                                ?? mediaMetadataRetriever2 = new MediaMetadataRetriever();
                                                mediaMetadataRetriever2.setDataSource(B);
                                                strExtractMetadata = mediaMetadataRetriever2.extractMetadata(18);
                                                strExtractMetadata2 = mediaMetadataRetriever2.extractMetadata(19);
                                                if (strExtractMetadata != null) {
                                                    i2 = Integer.parseInt(strExtractMetadata);
                                                } else {
                                                    r3 = r10;
                                                }
                                                if (strExtractMetadata2 != null) {
                                                    r3 = i2;
                                                    r14 = Integer.parseInt(strExtractMetadata2);
                                                } else {
                                                    r3 = i2;
                                                    r14 = r10;
                                                }
                                                mediaMetadataRetriever2.release();
                                                point = r0.d.f3375a;
                                                HashMap map9 = K8.c;
                                                i = i9;
                                                try {
                                                    d = (double) r3;
                                                    d2 = (double) r14;
                                                    if (((double) C3584u8.a(point.x)) / ((double) C3584u8.a(point.y)) > d / d2) {
                                                        dA2 = ((((double) C3584u8.a(point.y)) * 1.0d) / d2) * d;
                                                        dA = C3584u8.a(point.y);
                                                    } else {
                                                        double dA4 = C3584u8.a(point.x);
                                                        dA = ((((double) C3584u8.a(point.x)) * 1.0d) / d) * d2;
                                                        dA2 = dA4;
                                                    }
                                                    layoutParams = new RelativeLayout.LayoutParams((int) dA2, (int) dA);
                                                } catch (Exception e3) {
                                                    e = e3;
                                                    Intrinsics.checkNotNullExpressionValue(c3570t9.f3434a, "TAG");
                                                    RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -1);
                                                    C3339d5 c3339d6 = C3339d5.f3292a;
                                                    C3339d5.c.a(I4.a(e, "event"));
                                                    layoutParams = layoutParams2;
                                                }
                                            } catch (Exception e4) {
                                                e = e4;
                                                i = i9;
                                            }
                                            layoutParams.addRule(13);
                                            c3570t9.getVideoView().setLayoutParams(layoutParams);
                                        } else {
                                            r0 = c3426j8;
                                            i = i9;
                                        }
                                    } else {
                                        r0 = c3426j8;
                                        i = i9;
                                    }
                                }
                                if (Intrinsics.areEqual(obj, c3455l8.c) || !(viewA instanceof Ba)) {
                                    l7 = this;
                                } else {
                                    Ba ba = (Ba) viewA;
                                    boolean z = c3455l8 instanceof M8;
                                    if (z) {
                                        ba.setScrollable(((M8) c3455l8).x);
                                    }
                                    l7 = this;
                                    ba.setReferenceContainer(l7.b.v);
                                    C3313b7 c3313b8 = l7.b;
                                    C3298a7 c3298a7 = c3313b8.L;
                                    if (c3298a7 == null) {
                                        c3298a7 = new C3298a7(c3313b8);
                                        c3313b8.L = c3298a7;
                                    }
                                    ba.setRenderViewEventListener(c3298a7);
                                    ba.setPlacementId(l7.b.e);
                                    ba.setAllowAutoRedirection(l7.b.f);
                                    ba.setCreativeId(l7.b.getCreativeId());
                                    ba.setImpressionId(l7.b.getImpressionId());
                                    if (z && ((M8) c3455l8).z) {
                                        C3313b7 c3313b9 = l7.b;
                                        L4 l5 = c3313b9.j;
                                        if (l5 != null) {
                                            String TAG = c3313b9.m;
                                            Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
                                            ((M4) l5).c(TAG, "setHTMLTrackedView");
                                        }
                                        if (c3313b9.K == 0 && c3313b9.I == null && c3313b9.H == null) {
                                            c3313b9.I = ba;
                                        }
                                    }
                                }
                            }
                        }
                        inflater = l7;
                        i8 = i;
                        r10 = 0;
                    }
                } else {
                    if (!Intrinsics.areEqual(ShareConstants.IMAGE_URL, c3455l8.c) || c3455l8.e != null) {
                        viewA = null;
                        if (viewA == null) {
                            context = (Context) inflater.i.get();
                            if (context != null) {
                                viewA = inflater.m.a(context, c3455l8, inflater.f3125a);
                            } else {
                                viewA = null;
                            }
                        }
                        if (viewA != null) {
                            weakReference = new WeakReference(viewA);
                            if (c3455l8.n == -1) {
                                obj = "WEBVIEW";
                                if (c3455l8.o != -1) {
                                    inflater.h.postDelayed(new Runnable() { // from class: com.inmobi.media.L7$$ExternalSyntheticLambda3
                                        @Override // java.lang.Runnable
                                        public final void run() {
                                            L7.a(weakReference);
                                        }
                                    }, c3455l8.o * 1000);
                                }
                            } else {
                                viewA.setVisibility(4);
                                obj = "WEBVIEW";
                                inflater.h.postDelayed(new Runnable() { // from class: com.inmobi.media.L7$$ExternalSyntheticLambda2
                                    @Override // java.lang.Runnable
                                    public final void run() {
                                        L7.b(weakReference);
                                    }
                                }, c3455l8.n * 1000);
                            }
                            HashMap map10 = K8.c;
                            viewA.setLayoutParams(C3584u8.a(c3455l8, viewGroup));
                            inflater.a(viewA, c3455l8);
                            viewGroup.addView(viewA);
                            if (!Intrinsics.areEqual(ShareConstants.VIDEO_URL, c3455l8.c)) {
                                obj2 = ShareConstants.VIDEO_URL;
                                c3570t8 = null;
                            } else {
                                Intrinsics.checkNotNull(c3455l8, "null cannot be cast to non-null type com.inmobi.ads.modelsv2.NativeVideoAsset");
                                videoAsset = (C3426j8) c3455l8;
                                videoView = ((C3570t8) viewA).getVideoView();
                                c3513p8 = videoAsset.r;
                                if (!(c3513p8 instanceof C3513p7)) {
                                    c3513p8 = null;
                                }
                                jCurrentTimeMillis = System.currentTimeMillis();
                                obj2 = ShareConstants.VIDEO_URL;
                                if (c3513p8 != null) {
                                    j = c3513p8.y;
                                    if (0 == j) {
                                        j = jCurrentTimeMillis;
                                    }
                                    c3513p8.y = j;
                                }
                                videoView.setClickable(r10);
                                videoView.setId(Integer.MAX_VALUE);
                                Intrinsics.checkNotNullParameter(videoAsset, "videoAsset");
                                videoView.e = r10;
                                videoView.f = r10;
                                obj3 = videoAsset.e;
                                if (obj3 instanceof Rc) {
                                    rc = (Rc) obj3;
                                } else {
                                    rc = null;
                                }
                                if (rc != null) {
                                    strB = "";
                                } else {
                                    strB = "";
                                }
                                uri = Uri.parse(strB);
                                videoView.f3427a = uri;
                                obj4 = videoAsset.t.get("placementType");
                                Intrinsics.checkNotNull(obj4, "null cannot be cast to non-null type kotlin.Byte");
                                if (1 == ((Byte) obj4).byteValue()) {
                                    o7A = new O7();
                                } else {
                                    Object obj7 = O7.d;
                                    o7A = N7.a();
                                }
                                videoView.c = o7A;
                                i3 = videoView.d;
                                if (i3 != 0) {
                                    o7A.setAudioSessionId(i3);
                                } else {
                                    videoView.d = o7A.getAudioSessionId();
                                }
                                o7 = videoView.c;
                                if (o7 != null) {
                                    c3570t8 = null;
                                    o7.setDataSource(videoView.getContext().getApplicationContext(), uri, (Map<String, String>) null);
                                } else {
                                    c3570t8 = null;
                                }
                                videoView.setTag(videoAsset);
                                videoView.m = new HandlerC3514p8(videoView);
                                videoView.setSurfaceTextureListener(videoView.B);
                                videoView.setFocusable(true);
                                videoView.setFocusableInTouchMode(true);
                                videoView.requestFocus();
                                c3455l7 = videoAsset.w;
                                if (c3455l7 instanceof C3426j8) {
                                    videoAsset.a((C3426j8) c3455l7);
                                }
                                videoView.setQuartileCompletedListener(new H7(inflater, videoAsset));
                                videoView.setPlaybackEventListener(new I7(inflater, videoAsset));
                                videoView.setMediaErrorListener(new J7(inflater, videoAsset));
                                c3313b7 = inflater.b;
                                if (!c3313b7.t) {
                                    ((C3398h8) c3313b7).b(videoAsset, videoView);
                                }
                            }
                            inflater.b(viewA, c3455l8);
                            if (Intrinsics.areEqual("TIMER", c3455l8.c)) {
                                viewA.setTag("timerView");
                                if (c3455l8 instanceof Y7) {
                                    ((C3314b8) viewA).setTimerEventsListener(new K7(inflater, (Y7) c3455l8));
                                }
                            }
                            if (Intrinsics.areEqual(obj2, c3455l8.c)) {
                                r0 = c3426j8;
                                i = i9;
                            } else {
                                if (viewA instanceof C3570t8) {
                                    c3570t9 = (C3570t8) viewA;
                                } else {
                                    c3570t9 = c3570t8;
                                }
                                if (c3570t9 != null) {
                                    tag = c3570t9.getVideoView().getTag();
                                    if (tag instanceof C3426j8) {
                                        c3426j8 = (C3426j8) tag;
                                    } else {
                                        r0 = c3570t8;
                                    }
                                    if (r0 != 0) {
                                        r0 = c3426j8;
                                        rcD = r0.d();
                                        if (rcD != null) {
                                            B = ((Qc) rcD).b();
                                        } else {
                                            B = c3570t8;
                                        }
                                        ?? mediaMetadataRetriever3 = new MediaMetadataRetriever();
                                        mediaMetadataRetriever3.setDataSource(B);
                                        strExtractMetadata = mediaMetadataRetriever3.extractMetadata(18);
                                        strExtractMetadata2 = mediaMetadataRetriever3.extractMetadata(19);
                                        if (strExtractMetadata != null) {
                                            i2 = Integer.parseInt(strExtractMetadata);
                                        } else {
                                            r3 = r10;
                                        }
                                        if (strExtractMetadata2 != null) {
                                            r3 = i2;
                                            r14 = Integer.parseInt(strExtractMetadata2);
                                        } else {
                                            r3 = i2;
                                            r14 = r10;
                                        }
                                        mediaMetadataRetriever3.release();
                                        point = r0.d.f3375a;
                                        HashMap map11 = K8.c;
                                        i = i9;
                                        d = (double) r3;
                                        d2 = (double) r14;
                                        if (((double) C3584u8.a(point.x)) / ((double) C3584u8.a(point.y)) > d / d2) {
                                            dA2 = ((((double) C3584u8.a(point.y)) * 1.0d) / d2) * d;
                                            dA = C3584u8.a(point.y);
                                        } else {
                                            double dA5 = C3584u8.a(point.x);
                                            dA = ((((double) C3584u8.a(point.x)) * 1.0d) / d) * d2;
                                            dA2 = dA5;
                                        }
                                        layoutParams = new RelativeLayout.LayoutParams((int) dA2, (int) dA);
                                        layoutParams.addRule(13);
                                        c3570t9.getVideoView().setLayoutParams(layoutParams);
                                    } else {
                                        r0 = c3426j8;
                                        i = i9;
                                    }
                                } else {
                                    r0 = c3426j8;
                                    i = i9;
                                }
                            }
                            if (Intrinsics.areEqual(obj, c3455l8.c)) {
                                l7 = this;
                            } else {
                                l7 = this;
                            }
                        }
                    }
                    inflater = l7;
                    i8 = i;
                    r10 = 0;
                }
                l7 = inflater;
                i = i9;
                inflater = l7;
                i8 = i;
                r10 = 0;
            } catch (IndexOutOfBoundsException e5) {
                throw new NoSuchElementException(e5.getMessage());
            }
        }
        return viewGroup;
    }

    public final R7 a(R7 r7, final ViewGroup parent, Ba ba) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        this.o = ba;
        final R7 r7A = a(r7, parent);
        this.h.post(new Runnable() { // from class: com.inmobi.media.L7$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                L7.a(this.f$0, r7A, parent);
            }
        });
        return r7A;
    }

    public static final void a(L7 this$0, R7 container, ViewGroup parent) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(parent, "$parent");
        if (this$0.n) {
            return;
        }
        C3513p7 root = this$0.c.e;
        if (container == null || root == null) {
            return;
        }
        Intrinsics.checkNotNullParameter(container, "container");
        Intrinsics.checkNotNullParameter(parent, "parent");
        Intrinsics.checkNotNullParameter(root, "root");
        this$0.b((ViewGroup) container, root);
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0021  */
    public final R7 a(R7 r7, ViewGroup viewGroup) {
        R7 viewGroup2;
        C3513p7 c3513p7 = this.c.e;
        if (r7 == null) {
            Context context = (Context) this.i.get();
            if (context == null || c3513p7 == null) {
                viewGroup2 = null;
            } else {
                View viewA = this.m.a(context, c3513p7, this.f3125a);
                if (viewA instanceof R7) {
                    viewGroup2 = (R7) viewA;
                } else {
                    viewGroup2 = null;
                }
            }
        } else {
            viewGroup2 = r7;
        }
        if (viewGroup2 != null && r7 != null) {
            ViewParent parent = viewGroup2.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(viewGroup2);
            }
            K8 k8 = this.m;
            k8.getClass();
            Intrinsics.checkNotNullParameter(viewGroup2, "viewGroup");
            int childCount = viewGroup2.getChildCount();
            while (true) {
                childCount--;
                if (-1 >= childCount) {
                    break;
                }
                View childAt = viewGroup2.getChildAt(childCount);
                viewGroup2.removeViewAt(childCount);
                Intrinsics.checkNotNull(childAt);
                k8.a(childAt);
            }
            if (c3513p7 != null) {
                HashMap map = K8.c;
                C3584u8.a(viewGroup2, c3513p7.d);
            }
        }
        if (c3513p7 != null) {
            K8 k9 = this.m;
            int i = c3513p7.d.f3375a.x;
            k9.getClass();
            K8.g = i;
        }
        if (viewGroup2 != null && c3513p7 != null) {
            HashMap map2 = K8.c;
            viewGroup2.setLayoutParams(C3584u8.a(c3513p7, viewGroup));
        }
        return viewGroup2;
    }

    public static final void b(WeakReference childViewRef) {
        Intrinsics.checkNotNullParameter(childViewRef, "$childViewRef");
        View view = (View) childViewRef.get();
        if (view != null) {
            view.setVisibility(0);
        }
    }

    public final void a(View view, C3455l7 nativeAsset) {
        L0 l0 = this.l;
        l0.getClass();
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(nativeAsset, "nativeAsset");
        ArrayList arrayList = new ArrayList();
        boolean z = true;
        try {
            HashMap map = K8.c;
            float fA = C3584u8.a(nativeAsset.d.c.x);
            float fA2 = C3584u8.a(nativeAsset.d.d.x);
            if (fA != fA2) {
                arrayList.add(L0.a(L0.a(view, fA, fA2), nativeAsset));
            }
            float fA3 = C3584u8.a(nativeAsset.d.c.y);
            float fA4 = C3584u8.a(nativeAsset.d.d.y);
            if (fA3 != fA4) {
                arrayList.add(L0.a(L0.b(view, fA3, fA4), nativeAsset));
            }
            float fA5 = C3584u8.a(nativeAsset.d.f3375a.x);
            float fA6 = C3584u8.a(nativeAsset.d.b.x);
            if (fA5 != fA6) {
                view.setPivotX(0.0f);
                view.setPivotY(0.0f);
                ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(view, "scaleX", fA6 / fA5);
                Intrinsics.checkNotNullExpressionValue(objectAnimatorOfFloat, "ofFloat(...)");
                arrayList.add(L0.a(objectAnimatorOfFloat, nativeAsset));
            }
            float fA7 = C3584u8.a(nativeAsset.d.f3375a.y);
            float fA8 = C3584u8.a(nativeAsset.d.b.y);
            if (fA7 != fA8) {
                view.setPivotX(0.0f);
                view.setPivotY(0.0f);
                ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(view, "scaleY", fA8 / fA7);
                Intrinsics.checkNotNullExpressionValue(objectAnimatorOfFloat2, "ofFloat(...)");
                arrayList.add(L0.a(objectAnimatorOfFloat2, nativeAsset));
            }
        } catch (Exception unused) {
            String TAG = l0.f3121a;
            Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
        }
        if (arrayList.isEmpty()) {
            arrayList = null;
        }
        Intrinsics.checkNotNullParameter(EventConstants.CREATIVE_VIEW, "eventType");
        Iterator it = nativeAsset.s.iterator();
        do {
            if (!it.hasNext()) {
                z = false;
                break;
            }
        } while (!Intrinsics.areEqual(EventConstants.CREATIVE_VIEW, ((C3328c8) it.next()).b));
        if (arrayList != null || z) {
            view.addOnAttachStateChangeListener(new G7(this, arrayList, nativeAsset));
        }
    }

    public static final void a(WeakReference childViewRef) {
        Intrinsics.checkNotNullParameter(childViewRef, "$childViewRef");
        View view = (View) childViewRef.get();
        if (view != null) {
            view.setVisibility(4);
        }
    }

    public static final void a(L7 this$0, C3455l7 asset, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(asset, "$asset");
        D7 d7 = this$0.e;
        Intrinsics.checkNotNull(view);
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(asset, "asset");
        F7 f7 = d7.f3049a;
        if (f7.f3070a) {
            return;
        }
        f7.b.a(view, asset);
        d7.f3049a.b.a(asset, false);
    }
}
