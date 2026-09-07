package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast;

import com.json.b9;
import com.playon.bridge.Ad;
import com.smaato.sdk.video.vast.model.AdParameters;
import com.smaato.sdk.video.vast.model.Icon;
import io.bidmachine.protobuf.EventTypeExtended;
import io.bidmachine.unified.UnifiedMediationParams;
import java.io.IOException;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import net.pubnative.lite.sdk.vpaid.enums.EventConstants;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes7.dex */
public final class k {
    public static final String A = "CustomClick";
    public static final String B = "Icons";
    public static final String C = "Icon";
    public static final String D = "StaticResource";
    public static final String E = "IFrameResource";
    public static final String F = "HTMLResource";
    public static final String G = "IconClicks";
    public static final String H = "IconClickThrough";
    public static final String I = "IconClickTracking";
    public static final String J = "IconViewTracking";
    public static final String K = "AltText";
    public static final String L = "CompanionAds";
    public static final String M = "Companion";
    public static final String N = "CompanionClickThrough";
    public static final String O = "CompanionClickTracking";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f6829a = LazyKt.lazy(a.f6830a);
    public static final NumberFormat b = NumberFormat.getPercentInstance();
    public static final String c = "Error";
    public static final String d = "Ad";
    public static final String e = "InLine";
    public static final String f = "Wrapper";
    public static final String g = "VASTAdTagURI";
    public static final String h = "AdSystem";
    public static final String i = "AdTitle";
    public static final String j = "Description";
    public static final String k = "Advertiser";
    public static final String l = "Pricing";
    public static final String m = "Survey";
    public static final String n = "Impression";
    public static final String o = "Creatives";
    public static final String p = "Creative";
    public static final String q = "Linear";
    public static final String r = "AdParameters";
    public static final String s = "Duration";
    public static final String t = "MediaFiles";
    public static final String u = "MediaFile";
    public static final String v = "TrackingEvents";
    public static final String w = "Tracking";
    public static final String x = "VideoClicks";
    public static final String y = "ClickThrough";
    public static final String z = "ClickTracking";

    public static final class a extends Lambda implements Function0<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.j> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f6830a = new a();

        public a() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.j invoke() {
            return new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.j();
        }
    }

    @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.VastParserKt$parseInLineTag$$inlined$iterateTag$1", f = "VastParser.kt", i = {0, 1, 2, 3, 4, 5, 6, 7}, l = {946, 947, 948, 949, 950, 951, 953, 954}, m = "invokeSuspend", n = {"initialDepth", "initialDepth", "initialDepth", "initialDepth", "initialDepth", "initialDepth", "initialDepth", "initialDepth"}, s = {"I$0", "I$0", "I$0", "I$0", "I$0", "I$0", "I$0", "I$0"})
    public static final class a0 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f6831a;
        public int b;
        public /* synthetic */ Object c;
        public final /* synthetic */ XmlPullParser d;
        public final /* synthetic */ Ref.ObjectRef e;
        public final /* synthetic */ Ref.ObjectRef f;
        public final /* synthetic */ Ref.ObjectRef g;
        public final /* synthetic */ Ref.ObjectRef h;
        public final /* synthetic */ Ref.ObjectRef i;
        public final /* synthetic */ List j;
        public final /* synthetic */ List k;
        public final /* synthetic */ List l;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a0(XmlPullParser xmlPullParser, Continuation continuation, Ref.ObjectRef objectRef, Ref.ObjectRef objectRef2, Ref.ObjectRef objectRef3, Ref.ObjectRef objectRef4, Ref.ObjectRef objectRef5, List list, List list2, List list3) {
            super(2, continuation);
            this.d = xmlPullParser;
            this.e = objectRef;
            this.f = objectRef2;
            this.g = objectRef3;
            this.h = objectRef4;
            this.i = objectRef5;
            this.j = list;
            this.k = list2;
            this.l = list3;
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((a0) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            a0 a0Var = new a0(this.d, continuation, this.e, this.f, this.g, this.h, this.i, this.j, this.k, this.l);
            a0Var.c = obj;
            return a0Var;
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        /* JADX WARN: Code duplicated, block: B:102:0x01ca  */
        /* JADX WARN: Code duplicated, block: B:104:0x01d2  */
        /* JADX WARN: Code duplicated, block: B:110:0x01f4  */
        /* JADX WARN: Code duplicated, block: B:112:0x01fc  */
        /* JADX WARN: Code duplicated, block: B:115:0x0206  */
        /* JADX WARN: Code duplicated, block: B:26:0x0096  */
        /* JADX WARN: Code duplicated, block: B:28:0x009f  */
        /* JADX WARN: Code duplicated, block: B:31:0x00a4  */
        /* JADX WARN: Code duplicated, block: B:38:0x00be  */
        /* JADX WARN: Code duplicated, block: B:41:0x00c8  */
        /* JADX WARN: Code duplicated, block: B:43:0x00d5 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:46:0x00da  */
        /* JADX WARN: Code duplicated, block: B:47:0x00e5  */
        /* JADX WARN: Code duplicated, block: B:50:0x00ef  */
        /* JADX WARN: Code duplicated, block: B:52:0x00fe A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:53:0x00ff  */
        /* JADX WARN: Code duplicated, block: B:54:0x0103  */
        /* JADX WARN: Code duplicated, block: B:57:0x010d  */
        /* JADX WARN: Code duplicated, block: B:59:0x011c A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:60:0x011d  */
        /* JADX WARN: Code duplicated, block: B:61:0x0121  */
        /* JADX WARN: Code duplicated, block: B:64:0x012b  */
        /* JADX WARN: Code duplicated, block: B:66:0x013a A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:67:0x013b  */
        /* JADX WARN: Code duplicated, block: B:68:0x013f  */
        /* JADX WARN: Code duplicated, block: B:71:0x0149  */
        /* JADX WARN: Code duplicated, block: B:73:0x0156 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:76:0x015b  */
        /* JADX WARN: Code duplicated, block: B:77:0x0166  */
        /* JADX WARN: Code duplicated, block: B:80:0x0170  */
        /* JADX WARN: Code duplicated, block: B:82:0x017f A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:83:0x0180  */
        /* JADX WARN: Code duplicated, block: B:84:0x0184  */
        /* JADX WARN: Code duplicated, block: B:87:0x018e  */
        /* JADX WARN: Code duplicated, block: B:89:0x019c A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:90:0x019d  */
        /* JADX WARN: Code duplicated, block: B:92:0x01a1  */
        /* JADX WARN: Code duplicated, block: B:95:0x01aa  */
        /* JADX WARN: Code duplicated, block: B:97:0x01b8 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:99:0x01c1  */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r7v43, types: [T, java.lang.Object] */
        /* JADX WARN: Type inference failed for: r7v44, types: [T, java.lang.Object] */
        /* JADX WARN: Type inference failed for: r7v46, types: [T, java.lang.Object] */
        /* JADX WARN: Type inference failed for: r7v47, types: [T, java.lang.Object] */
        /* JADX WARN: Type inference failed for: r7v48, types: [T, java.lang.Object] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:100:0x01c7 -> B:114:0x01ff). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:109:0x01e1 -> B:114:0x01ff). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:111:0x01fa -> B:114:0x01ff). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:29:0x00a0 -> B:114:0x01ff). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:32:0x00aa -> B:114:0x01ff). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:34:0x00b2 -> B:114:0x01ff). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:36:0x00b9 -> B:114:0x01ff). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:39:0x00c4 -> B:114:0x01ff). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:45:0x00d8 -> B:114:0x01ff). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:46:0x00da -> B:114:0x01ff). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:48:0x00eb -> B:114:0x01ff). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:55:0x0109 -> B:114:0x01ff). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:62:0x0127 -> B:114:0x01ff). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:69:0x0145 -> B:114:0x01ff). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:75:0x0159 -> B:114:0x01ff). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:76:0x015b -> B:114:0x01ff). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:78:0x016c -> B:114:0x01ff). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:85:0x018a -> B:114:0x01ff). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:93:0x01a7 -> B:114:0x01ff). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:96:0x01b6 -> B:98:0x01b9). Please report as a decompilation issue!!! */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:104:0x01d2
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final java.lang.Object invokeSuspend(java.lang.Object r7) {
            /*
                Method dump skipped, instruction units count: 586
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.k.a0.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.VastParserKt", f = "VastParser.kt", i = {0, 0, 0, 0, 0, 0}, l = {941}, m = "parseWrapperTag", n = {"vastAdTagUrl", "followAdditionalWrappers", "adSystem", "impressions", "errorUrls", "creatives"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5"})
    public static final class a1 extends ContinuationImpl {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object f6832a;
        public Object b;
        public Object c;
        public Object d;
        public Object e;
        public Object f;
        public /* synthetic */ Object g;
        public int h;

        public a1(Continuation<? super a1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.g = obj;
            this.h |= Integer.MIN_VALUE;
            return k.V(null, this);
        }
    }

    @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.VastParserKt$iterateTag$2", f = "VastParser.kt", i = {0, 1, 2}, l = {102, 103, 111}, m = "invokeSuspend", n = {"initialDepth", "initialDepth", "initialDepth"}, s = {"I$0", "I$0", "I$0"})
    public static final class b extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f6833a;
        public int b;
        public /* synthetic */ Object c;
        public final /* synthetic */ XmlPullParser d;
        public final /* synthetic */ Function2<XmlPullParser, Continuation<? super Unit>, Object> e;
        public final /* synthetic */ Function3<XmlPullParser, String, Continuation<? super Unit>, Object> f;
        public final /* synthetic */ Function2<XmlPullParser, Continuation<? super Unit>, Object> g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public b(XmlPullParser xmlPullParser, Function2<? super XmlPullParser, ? super Continuation<? super Unit>, ? extends Object> function2, Function3<? super XmlPullParser, ? super String, ? super Continuation<? super Unit>, ? extends Object> function3, Function2<? super XmlPullParser, ? super Continuation<? super Unit>, ? extends Object> function4, Continuation<? super b> continuation) {
            super(2, continuation);
            this.d = xmlPullParser;
            this.e = function2;
            this.f = function3;
            this.g = function4;
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((b) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            b bVar = new b(this.d, this.e, this.f, this.g, continuation);
            bVar.c = obj;
            return bVar;
        }

        /* JADX WARN: Code duplicated, block: B:23:0x005a  */
        /* JADX WARN: Code duplicated, block: B:25:0x0063  */
        /* JADX WARN: Code duplicated, block: B:27:0x0066  */
        /* JADX WARN: Code duplicated, block: B:31:0x007c A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:32:0x007d  */
        /* JADX WARN: Code duplicated, block: B:34:0x0085  */
        /* JADX WARN: Code duplicated, block: B:36:0x0093 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:37:0x0094  */
        /* JADX WARN: Code duplicated, block: B:39:0x009c  */
        /* JADX WARN: Code duplicated, block: B:47:0x00cb  */
        /* JADX WARN: Code duplicated, block: B:49:0x00d3  */
        /* JADX WARN: Code duplicated, block: B:52:0x00dd  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:25:0x0063 -> B:51:0x00d6). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:28:0x006c -> B:51:0x00d6). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:30:0x007a -> B:51:0x00d6). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:35:0x0091 -> B:51:0x00d6). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:45:0x00c8 -> B:51:0x00d6). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:48:0x00d1 -> B:51:0x00d6). Please report as a decompilation issue!!! */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:23:0x005a
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final java.lang.Object invokeSuspend(java.lang.Object r9) {
            /*
                Method dump skipped, instruction units count: 232
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.k.b.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        public final Object a(Object obj) throws XmlPullParserException, IOException {
            String text;
            CoroutineScopeKt.ensureActive((CoroutineScope) this.c);
            if (k.j(this.d)) {
                this.d.nextTag();
            }
            if (k.h(this.d)) {
                return Unit.INSTANCE;
            }
            if (!k.k(this.d)) {
                throw new XmlPullParserException("iterateCurrentTagEvents call is allowed only for START_TAG event");
            }
            int depth = this.d.getDepth();
            while (this.d.getDepth() >= depth) {
                int depth2 = this.d.getDepth() - depth;
                if (depth2 != 0) {
                    if (depth2 == 1 && k.k(this.d)) {
                        this.g.invoke(this.d, this);
                    }
                } else if (k.k(this.d)) {
                    this.e.invoke(this.d, this);
                } else if (k.l(this.d) && (text = this.d.getText()) != null && !StringsKt.isBlank(text)) {
                    Function3<XmlPullParser, String, Continuation<? super Unit>, Object> function3 = this.f;
                    XmlPullParser xmlPullParser = this.d;
                    String text2 = xmlPullParser.getText();
                    Intrinsics.checkNotNullExpressionValue(text2, "text");
                    function3.invoke(xmlPullParser, StringsKt.trim((CharSequence) text2).toString(), this);
                } else if (k.i(this.d)) {
                    return Unit.INSTANCE;
                }
                this.d.next();
            }
            return Unit.INSTANCE;
        }
    }

    @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.VastParserKt", f = "VastParser.kt", i = {0, 0, 0, 0, 0, 0, 0, 0}, l = {941}, m = "parseInLineTag", n = {"adSystem", "adTitle", "description", b9.h.F0, "pricing", "impressions", "errorUrls", "creatives"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7"})
    public static final class b0 extends ContinuationImpl {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object f6834a;
        public Object b;
        public Object c;
        public Object d;
        public Object e;
        public Object f;
        public Object g;
        public Object h;
        public /* synthetic */ Object i;
        public int j;

        public b0(Continuation<? super b0> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.i = obj;
            this.j |= Integer.MIN_VALUE;
            return k.K(null, this);
        }
    }

    @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.VastParserKt$parseAdParametersTag$$inlined$iterateTag$1", f = "VastParser.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class c extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f6835a;
        public int b;
        public /* synthetic */ Object c;
        public final /* synthetic */ XmlPullParser d;
        public final /* synthetic */ Ref.ObjectRef e;
        public final /* synthetic */ Ref.ObjectRef f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(XmlPullParser xmlPullParser, Continuation continuation, Ref.ObjectRef objectRef, Ref.ObjectRef objectRef2) {
            super(2, continuation);
            this.d = xmlPullParser;
            this.e = objectRef;
            this.f = objectRef2;
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((c) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            c cVar = new c(this.d, continuation, this.e, this.f);
            cVar.c = obj;
            return cVar;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v20, types: [T, java.lang.String] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            String text;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            CoroutineScopeKt.ensureActive((CoroutineScope) this.c);
            if (k.j(this.d)) {
                this.d.nextTag();
            }
            if (k.h(this.d)) {
                return Unit.INSTANCE;
            }
            if (!k.k(this.d)) {
                throw new XmlPullParserException("iterateCurrentTagEvents call is allowed only for START_TAG event");
            }
            int depth = this.d.getDepth();
            while (this.d.getDepth() >= depth) {
                int depth2 = this.d.getDepth() - depth;
                if (depth2 != 0) {
                    if (depth2 == 1) {
                        k.k(this.d);
                    }
                } else if (k.k(this.d)) {
                    XmlPullParser xmlPullParser = this.d;
                    Ref.ObjectRef objectRef = this.e;
                    String strB = k.b(xmlPullParser, AdParameters.XML_ENCODED);
                    objectRef.element = strB != null ? Boxing.boxBoolean(Boolean.parseBoolean(strB)) : 0;
                } else if (k.l(this.d) && (text = this.d.getText()) != null && !StringsKt.isBlank(text)) {
                    String text2 = this.d.getText();
                    Intrinsics.checkNotNullExpressionValue(text2, "text");
                    this.f.element = StringsKt.trim((CharSequence) text2).toString();
                } else if (k.i(this.d)) {
                    return Unit.INSTANCE;
                }
                this.d.next();
            }
            return Unit.INSTANCE;
        }
    }

    @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.VastParserKt$parseLinearTag$$inlined$iterateTag$1", f = "VastParser.kt", i = {0, 1, 2, 3, 4, 5}, l = {947, 948, 949, 950, 951, 952}, m = "invokeSuspend", n = {"initialDepth", "initialDepth", "initialDepth", "initialDepth", "initialDepth", "initialDepth"}, s = {"I$0", "I$0", "I$0", "I$0", "I$0", "I$0"})
    public static final class c0 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f6836a;
        public int b;
        public /* synthetic */ Object c;
        public final /* synthetic */ XmlPullParser d;
        public final /* synthetic */ Ref.ObjectRef e;
        public final /* synthetic */ Ref.ObjectRef f;
        public final /* synthetic */ Ref.ObjectRef g;
        public final /* synthetic */ List h;
        public final /* synthetic */ List i;
        public final /* synthetic */ Ref.ObjectRef j;
        public final /* synthetic */ boolean k;
        public final /* synthetic */ List l;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c0(XmlPullParser xmlPullParser, Continuation continuation, Ref.ObjectRef objectRef, Ref.ObjectRef objectRef2, Ref.ObjectRef objectRef3, List list, List list2, Ref.ObjectRef objectRef4, boolean z, List list3) {
            super(2, continuation);
            this.d = xmlPullParser;
            this.e = objectRef;
            this.f = objectRef2;
            this.g = objectRef3;
            this.h = list;
            this.i = list2;
            this.j = objectRef4;
            this.k = z;
            this.l = list3;
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((c0) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            c0 c0Var = new c0(this.d, continuation, this.e, this.f, this.g, this.h, this.i, this.j, this.k, this.l);
            c0Var.c = obj;
            return c0Var;
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        /* JADX WARN: Code duplicated, block: B:24:0x008c  */
        /* JADX WARN: Code duplicated, block: B:26:0x0095  */
        /* JADX WARN: Code duplicated, block: B:29:0x009a  */
        /* JADX WARN: Code duplicated, block: B:36:0x00b3  */
        /* JADX WARN: Code duplicated, block: B:39:0x00bd  */
        /* JADX WARN: Code duplicated, block: B:41:0x00cc A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:42:0x00cd  */
        /* JADX WARN: Code duplicated, block: B:43:0x00d4  */
        /* JADX WARN: Code duplicated, block: B:46:0x00de  */
        /* JADX WARN: Code duplicated, block: B:48:0x00ed A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:50:0x00f5  */
        /* JADX WARN: Code duplicated, block: B:53:0x00ff  */
        /* JADX WARN: Code duplicated, block: B:55:0x010e A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:56:0x010f  */
        /* JADX WARN: Code duplicated, block: B:57:0x0116  */
        /* JADX WARN: Code duplicated, block: B:60:0x0120  */
        /* JADX WARN: Code duplicated, block: B:62:0x012e A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:63:0x012f  */
        /* JADX WARN: Code duplicated, block: B:65:0x0134  */
        /* JADX WARN: Code duplicated, block: B:68:0x013e  */
        /* JADX WARN: Code duplicated, block: B:70:0x014d A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:73:0x0152  */
        /* JADX WARN: Code duplicated, block: B:74:0x0157  */
        /* JADX WARN: Code duplicated, block: B:76:0x015b  */
        /* JADX WARN: Code duplicated, block: B:79:0x0164  */
        /* JADX WARN: Code duplicated, block: B:81:0x0175 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:82:0x0176  */
        /* JADX WARN: Code duplicated, block: B:83:0x0179  */
        /* JADX WARN: Code duplicated, block: B:85:0x0181  */
        /* JADX WARN: Code duplicated, block: B:86:0x018c  */
        /* JADX WARN: Code duplicated, block: B:88:0x0194  */
        /* JADX WARN: Code duplicated, block: B:94:0x01b6  */
        /* JADX WARN: Code duplicated, block: B:96:0x01be  */
        /* JADX WARN: Code duplicated, block: B:99:0x01c8  */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r6v19, types: [T, java.lang.Long] */
        /* JADX WARN: Type inference failed for: r6v40, types: [T, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.r] */
        /* JADX WARN: Type inference failed for: r6v44, types: [T, java.lang.Object] */
        /* JADX WARN: Type inference failed for: r6v46, types: [T, java.lang.Object] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:27:0x0096 -> B:98:0x01c1). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:30:0x00a0 -> B:98:0x01c1). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:32:0x00a8 -> B:98:0x01c1). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:34:0x00ae -> B:98:0x01c1). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:37:0x00b9 -> B:98:0x01c1). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:44:0x00da -> B:98:0x01c1). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:47:0x00eb -> B:49:0x00ee). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:51:0x00fb -> B:98:0x01c1). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:58:0x011c -> B:98:0x01c1). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:66:0x013a -> B:98:0x01c1). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:77:0x0161 -> B:98:0x01c1). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:85:0x0181 -> B:98:0x01c1). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:93:0x01a3 -> B:98:0x01c1). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:95:0x01bc -> B:98:0x01c1). Please report as a decompilation issue!!! */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:56:0x010f
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final java.lang.Object invokeSuspend(java.lang.Object r6) {
            /*
                Method dump skipped, instruction units count: 512
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.k.c0.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.VastParserKt", f = "VastParser.kt", i = {0, 0}, l = {941}, m = "parseAdParametersTag", n = {"rawText", "isXmlEncoded"}, s = {"L$0", "L$1"})
    public static final class d extends ContinuationImpl {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object f6837a;
        public Object b;
        public /* synthetic */ Object c;
        public int d;

        public d(Continuation<? super d> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.c = obj;
            this.d |= Integer.MIN_VALUE;
            return k.y(null, this);
        }
    }

    @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.VastParserKt", f = "VastParser.kt", i = {0, 0, 0, 0, 0, 0, 0, 0}, l = {941}, m = "parseLinearTag", n = {UnifiedMediationParams.KEY_SKIP_OFFSET, "adParameters", "durationMillis", "mediaFiles", "trackingList", "videoClicks", "icons", "isInLineParent"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "Z$0"})
    public static final class d0 extends ContinuationImpl {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f6838a;
        public Object b;
        public Object c;
        public Object d;
        public Object e;
        public Object f;
        public Object g;
        public Object h;
        public /* synthetic */ Object i;
        public int j;

        public d0(Continuation<? super d0> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.i = obj;
            this.j |= Integer.MIN_VALUE;
            return k.g(null, false, this);
        }
    }

    @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.VastParserKt$parseAdSystemTag$$inlined$iterateTag$1", f = "VastParser.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class e extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f6839a;
        public int b;
        public /* synthetic */ Object c;
        public final /* synthetic */ XmlPullParser d;
        public final /* synthetic */ Ref.ObjectRef e;
        public final /* synthetic */ Ref.ObjectRef f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(XmlPullParser xmlPullParser, Continuation continuation, Ref.ObjectRef objectRef, Ref.ObjectRef objectRef2) {
            super(2, continuation);
            this.d = xmlPullParser;
            this.e = objectRef;
            this.f = objectRef2;
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((e) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            e eVar = new e(this.d, continuation, this.e, this.f);
            eVar.c = obj;
            return eVar;
        }

        /* JADX WARN: Type inference failed for: r0v20, types: [T, java.lang.String] */
        /* JADX WARN: Type inference failed for: r0v22, types: [T, java.lang.String] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            String text;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            CoroutineScopeKt.ensureActive((CoroutineScope) this.c);
            if (k.j(this.d)) {
                this.d.nextTag();
            }
            if (k.h(this.d)) {
                return Unit.INSTANCE;
            }
            if (!k.k(this.d)) {
                throw new XmlPullParserException("iterateCurrentTagEvents call is allowed only for START_TAG event");
            }
            int depth = this.d.getDepth();
            while (this.d.getDepth() >= depth) {
                int depth2 = this.d.getDepth() - depth;
                if (depth2 != 0) {
                    if (depth2 == 1) {
                        k.k(this.d);
                    }
                } else if (k.k(this.d)) {
                    this.e.element = k.b(this.d, "version");
                } else if (k.l(this.d) && (text = this.d.getText()) != null && !StringsKt.isBlank(text)) {
                    String text2 = this.d.getText();
                    Intrinsics.checkNotNullExpressionValue(text2, "text");
                    this.f.element = StringsKt.trim((CharSequence) text2).toString();
                } else if (k.i(this.d)) {
                    return Unit.INSTANCE;
                }
                this.d.next();
            }
            return Unit.INSTANCE;
        }
    }

    @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.VastParserKt$parseMediaFileTag$$inlined$iterateTag$1", f = "VastParser.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class e0 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f6840a;
        public int b;
        public /* synthetic */ Object c;
        public final /* synthetic */ XmlPullParser d;
        public final /* synthetic */ Ref.ObjectRef e;
        public final /* synthetic */ Ref.ObjectRef f;
        public final /* synthetic */ Ref.ObjectRef g;
        public final /* synthetic */ Ref.ObjectRef h;
        public final /* synthetic */ Ref.ObjectRef i;
        public final /* synthetic */ Ref.ObjectRef j;
        public final /* synthetic */ Ref.ObjectRef k;
        public final /* synthetic */ Ref.ObjectRef l;
        public final /* synthetic */ Ref.ObjectRef m;
        public final /* synthetic */ Ref.ObjectRef n;
        public final /* synthetic */ Ref.ObjectRef o;
        public final /* synthetic */ Ref.ObjectRef p;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e0(XmlPullParser xmlPullParser, Continuation continuation, Ref.ObjectRef objectRef, Ref.ObjectRef objectRef2, Ref.ObjectRef objectRef3, Ref.ObjectRef objectRef4, Ref.ObjectRef objectRef5, Ref.ObjectRef objectRef6, Ref.ObjectRef objectRef7, Ref.ObjectRef objectRef8, Ref.ObjectRef objectRef9, Ref.ObjectRef objectRef10, Ref.ObjectRef objectRef11, Ref.ObjectRef objectRef12) {
            super(2, continuation);
            this.d = xmlPullParser;
            this.e = objectRef;
            this.f = objectRef2;
            this.g = objectRef3;
            this.h = objectRef4;
            this.i = objectRef5;
            this.j = objectRef6;
            this.k = objectRef7;
            this.l = objectRef8;
            this.m = objectRef9;
            this.n = objectRef10;
            this.o = objectRef11;
            this.p = objectRef12;
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((e0) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            e0 e0Var = new e0(this.d, continuation, this.e, this.f, this.g, this.h, this.i, this.j, this.k, this.l, this.m, this.n, this.o, this.p);
            e0Var.c = obj;
            return e0Var;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v20, types: [T, java.lang.String] */
        /* JADX WARN: Type inference failed for: r0v22, types: [T, java.lang.String] */
        /* JADX WARN: Type inference failed for: r2v1, types: [T, java.lang.String] */
        /* JADX WARN: Type inference failed for: r2v17, types: [T, java.lang.String] */
        /* JADX WARN: Type inference failed for: r2v5, types: [T, java.lang.Boolean] */
        /* JADX WARN: Type inference failed for: r2v7, types: [T, java.lang.String] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            String text;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            CoroutineScopeKt.ensureActive((CoroutineScope) this.c);
            if (k.j(this.d)) {
                this.d.nextTag();
            }
            if (k.h(this.d)) {
                return Unit.INSTANCE;
            }
            if (!k.k(this.d)) {
                throw new XmlPullParserException("iterateCurrentTagEvents call is allowed only for START_TAG event");
            }
            int depth = this.d.getDepth();
            while (this.d.getDepth() >= depth) {
                int depth2 = this.d.getDepth() - depth;
                if (depth2 != 0) {
                    if (depth2 == 1) {
                        k.k(this.d);
                    }
                } else if (k.k(this.d)) {
                    XmlPullParser xmlPullParser = this.d;
                    this.e.element = k.b(xmlPullParser, "id");
                    this.f.element = Boxing.boxBoolean(Intrinsics.areEqual(k.b(xmlPullParser, "delivery"), "progressive"));
                    this.g.element = k.b(xmlPullParser, "type");
                    Ref.ObjectRef objectRef = this.h;
                    String strB = k.b(xmlPullParser, "width");
                    objectRef.element = strB != null ? StringsKt.toIntOrNull(strB) : 0;
                    Ref.ObjectRef objectRef2 = this.i;
                    String strB2 = k.b(xmlPullParser, "height");
                    objectRef2.element = strB2 != null ? StringsKt.toIntOrNull(strB2) : 0;
                    this.j.element = k.b(xmlPullParser, "codec");
                    Ref.ObjectRef objectRef3 = this.k;
                    String strB3 = k.b(xmlPullParser, "bitrate");
                    objectRef3.element = strB3 != null ? StringsKt.toIntOrNull(strB3) : 0;
                    Ref.ObjectRef objectRef4 = this.l;
                    String strB4 = k.b(xmlPullParser, "minBitrate");
                    objectRef4.element = strB4 != null ? StringsKt.toIntOrNull(strB4) : 0;
                    Ref.ObjectRef objectRef5 = this.m;
                    String strB5 = k.b(xmlPullParser, "maxBitrate");
                    objectRef5.element = strB5 != null ? StringsKt.toIntOrNull(strB5) : 0;
                    Ref.ObjectRef objectRef6 = this.n;
                    String strB6 = k.b(xmlPullParser, "scalable");
                    objectRef6.element = strB6 != null ? Boxing.boxBoolean(Boolean.parseBoolean(strB6)) : 0;
                    this.o.element = k.b(xmlPullParser, "apiFramework");
                } else if (k.l(this.d) && (text = this.d.getText()) != null && !StringsKt.isBlank(text)) {
                    String text2 = this.d.getText();
                    Intrinsics.checkNotNullExpressionValue(text2, "text");
                    this.p.element = StringsKt.trim((CharSequence) text2).toString();
                } else if (k.i(this.d)) {
                    return Unit.INSTANCE;
                }
                this.d.next();
            }
            return Unit.INSTANCE;
        }
    }

    @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.VastParserKt", f = "VastParser.kt", i = {0, 0}, l = {941}, m = "parseAdSystemTag", n = {"name", "version"}, s = {"L$0", "L$1"})
    public static final class f extends ContinuationImpl {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object f6841a;
        public Object b;
        public /* synthetic */ Object c;
        public int d;

        public f(Continuation<? super f> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.c = obj;
            this.d |= Integer.MIN_VALUE;
            return k.z(null, this);
        }
    }

    @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.VastParserKt", f = "VastParser.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, l = {941}, m = "parseMediaFileTag", n = {"mediaFileUrl", "id", "isProgressiveDelivery", "type", "widthPx", "heightPx", "codec", "bitrate", "minBitrate", "maxBitrate", "isScalable", "apiFramework"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11"})
    public static final class f0 extends ContinuationImpl {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object f6842a;
        public Object b;
        public Object c;
        public Object d;
        public Object e;
        public Object f;
        public Object g;
        public Object h;
        public Object i;
        public Object j;
        public Object k;
        public Object l;
        public /* synthetic */ Object m;
        public int n;

        public f0(Continuation<? super f0> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.m = obj;
            this.n |= Integer.MIN_VALUE;
            return k.L(null, this);
        }
    }

    @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.VastParserKt$parseAdTag$$inlined$iterateTag$1", f = "VastParser.kt", i = {0, 1}, l = {949, 950}, m = "invokeSuspend", n = {"initialDepth", "initialDepth"}, s = {"I$0", "I$0"})
    public static final class g extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f6843a;
        public int b;
        public /* synthetic */ Object c;
        public final /* synthetic */ XmlPullParser d;
        public final /* synthetic */ Ref.ObjectRef e;
        public final /* synthetic */ Ref.ObjectRef f;
        public final /* synthetic */ Ref.ObjectRef g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(XmlPullParser xmlPullParser, Continuation continuation, Ref.ObjectRef objectRef, Ref.ObjectRef objectRef2, Ref.ObjectRef objectRef3) {
            super(2, continuation);
            this.d = xmlPullParser;
            this.e = objectRef;
            this.f = objectRef2;
            this.g = objectRef3;
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((g) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            g gVar = new g(this.d, continuation, this.e, this.f, this.g);
            gVar.c = obj;
            return gVar;
        }

        /* JADX WARN: Code duplicated, block: B:22:0x0065  */
        /* JADX WARN: Code duplicated, block: B:24:0x006e  */
        /* JADX WARN: Code duplicated, block: B:26:0x0072  */
        /* JADX WARN: Code duplicated, block: B:30:0x0082  */
        /* JADX WARN: Code duplicated, block: B:32:0x008e  */
        /* JADX WARN: Code duplicated, block: B:34:0x009a A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:35:0x009b  */
        /* JADX WARN: Code duplicated, block: B:36:0x00a3  */
        /* JADX WARN: Code duplicated, block: B:38:0x00ab  */
        /* JADX WARN: Code duplicated, block: B:40:0x00b7 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:44:0x00c2  */
        /* JADX WARN: Code duplicated, block: B:46:0x00c6  */
        /* JADX WARN: Code duplicated, block: B:48:0x00ce  */
        /* JADX WARN: Code duplicated, block: B:49:0x00e3  */
        /* JADX WARN: Code duplicated, block: B:51:0x00eb  */
        /* JADX WARN: Code duplicated, block: B:57:0x010d  */
        /* JADX WARN: Code duplicated, block: B:59:0x0115  */
        /* JADX WARN: Code duplicated, block: B:62:0x011f  */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r6v1, types: [T, java.lang.String] */
        /* JADX WARN: Type inference failed for: r6v10, types: [com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.b$a] */
        /* JADX WARN: Type inference failed for: r6v5 */
        /* JADX WARN: Type inference failed for: r6v6, types: [com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.b$a] */
        /* JADX WARN: Type inference failed for: r6v8 */
        /* JADX WARN: Type inference failed for: r6v9, types: [com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.b$b] */
        /* JADX WARN: Type inference failed for: r9v34, types: [T, java.lang.Integer] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:24:0x006e -> B:61:0x0118). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:27:0x0078 -> B:61:0x0118). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:29:0x0080 -> B:61:0x0118). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:39:0x00b5 -> B:41:0x00b8). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:48:0x00ce -> B:61:0x0118). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:56:0x00fa -> B:61:0x0118). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:58:0x0113 -> B:61:0x0118). Please report as a decompilation issue!!! */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:24:0x006e
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final java.lang.Object invokeSuspend(java.lang.Object r9) {
            /*
                Method dump skipped, instruction units count: 298
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.k.g.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.VastParserKt$parseMediaFilesTag$$inlined$iterateTag$1", f = "VastParser.kt", i = {0}, l = {946}, m = "invokeSuspend", n = {"initialDepth"}, s = {"I$0"})
    public static final class g0 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f6844a;
        public int b;
        public /* synthetic */ Object c;
        public final /* synthetic */ XmlPullParser d;
        public final /* synthetic */ List e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g0(XmlPullParser xmlPullParser, Continuation continuation, List list) {
            super(2, continuation);
            this.d = xmlPullParser;
            this.e = list;
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((g0) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            g0 g0Var = new g0(this.d, continuation, this.e);
            g0Var.c = obj;
            return g0Var;
        }

        /* JADX WARN: Code duplicated, block: B:20:0x0052  */
        /* JADX WARN: Code duplicated, block: B:22:0x005b  */
        /* JADX WARN: Code duplicated, block: B:24:0x005f  */
        /* JADX WARN: Code duplicated, block: B:28:0x0075  */
        /* JADX WARN: Code duplicated, block: B:30:0x007f A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:34:0x008e  */
        /* JADX WARN: Code duplicated, block: B:37:0x0097  */
        /* JADX WARN: Code duplicated, block: B:39:0x009f  */
        /* JADX WARN: Code duplicated, block: B:45:0x00c1  */
        /* JADX WARN: Code duplicated, block: B:47:0x00c9  */
        /* JADX WARN: Code duplicated, block: B:50:0x00d3  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x005b -> B:49:0x00cc). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:25:0x0065 -> B:49:0x00cc). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:27:0x0073 -> B:49:0x00cc). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:29:0x007d -> B:31:0x0080). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:35:0x0094 -> B:49:0x00cc). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:44:0x00ae -> B:49:0x00cc). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:46:0x00c7 -> B:49:0x00cc). Please report as a decompilation issue!!! */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:39:0x009f
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final java.lang.Object invokeSuspend(java.lang.Object r6) {
            /*
                Method dump skipped, instruction units count: 222
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.k.g0.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.VastParserKt", f = "VastParser.kt", i = {0, 0, 0}, l = {941}, m = "parseAdTag", n = {"id", "sequence", "adChild"}, s = {"L$0", "L$1", "L$2"})
    public static final class h extends ContinuationImpl {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object f6845a;
        public Object b;
        public Object c;
        public /* synthetic */ Object d;
        public int e;

        public h(Continuation<? super h> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.d = obj;
            this.e |= Integer.MIN_VALUE;
            return k.A(null, this);
        }
    }

    @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.VastParserKt", f = "VastParser.kt", i = {0}, l = {941}, m = "parseMediaFilesTag", n = {"mediaFiles"}, s = {"L$0"})
    public static final class h0 extends ContinuationImpl {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object f6846a;
        public /* synthetic */ Object b;
        public int c;

        public h0(Continuation<? super h0> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.b = obj;
            this.c |= Integer.MIN_VALUE;
            return k.M(null, this);
        }
    }

    @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.VastParserKt$parseCompanionAdsTag$$inlined$iterateTag$1", f = "VastParser.kt", i = {0}, l = {946}, m = "invokeSuspend", n = {"initialDepth"}, s = {"I$0"})
    public static final class i extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f6847a;
        public int b;
        public /* synthetic */ Object c;
        public final /* synthetic */ XmlPullParser d;
        public final /* synthetic */ List e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public i(XmlPullParser xmlPullParser, Continuation continuation, List list) {
            super(2, continuation);
            this.d = xmlPullParser;
            this.e = list;
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((i) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            i iVar = new i(this.d, continuation, this.e);
            iVar.c = obj;
            return iVar;
        }

        /* JADX WARN: Code duplicated, block: B:20:0x0052  */
        /* JADX WARN: Code duplicated, block: B:22:0x005b  */
        /* JADX WARN: Code duplicated, block: B:24:0x005f  */
        /* JADX WARN: Code duplicated, block: B:28:0x0075  */
        /* JADX WARN: Code duplicated, block: B:30:0x007f A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:34:0x008e  */
        /* JADX WARN: Code duplicated, block: B:37:0x0097  */
        /* JADX WARN: Code duplicated, block: B:39:0x009f  */
        /* JADX WARN: Code duplicated, block: B:45:0x00c1  */
        /* JADX WARN: Code duplicated, block: B:47:0x00c9  */
        /* JADX WARN: Code duplicated, block: B:50:0x00d3  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x005b -> B:49:0x00cc). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:25:0x0065 -> B:49:0x00cc). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:27:0x0073 -> B:49:0x00cc). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:29:0x007d -> B:31:0x0080). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:35:0x0094 -> B:49:0x00cc). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:44:0x00ae -> B:49:0x00cc). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:46:0x00c7 -> B:49:0x00cc). Please report as a decompilation issue!!! */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:39:0x009f
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final java.lang.Object invokeSuspend(java.lang.Object r6) {
            /*
                Method dump skipped, instruction units count: 222
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.k.i.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.VastParserKt$parsePricingTag$$inlined$iterateTag$1", f = "VastParser.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class i0 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f6848a;
        public int b;
        public /* synthetic */ Object c;
        public final /* synthetic */ XmlPullParser d;
        public final /* synthetic */ Ref.ObjectRef e;
        public final /* synthetic */ Ref.ObjectRef f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public i0(XmlPullParser xmlPullParser, Continuation continuation, Ref.ObjectRef objectRef, Ref.ObjectRef objectRef2) {
            super(2, continuation);
            this.d = xmlPullParser;
            this.e = objectRef;
            this.f = objectRef2;
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((i0) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            i0 i0Var = new i0(this.d, continuation, this.e, this.f);
            i0Var.c = obj;
            return i0Var;
        }

        /* JADX WARN: Type inference failed for: r0v21, types: [T, java.lang.String] */
        /* JADX WARN: Type inference failed for: r2v1, types: [T, java.lang.String] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            String text;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            CoroutineScopeKt.ensureActive((CoroutineScope) this.c);
            if (k.j(this.d)) {
                this.d.nextTag();
            }
            if (k.h(this.d)) {
                return Unit.INSTANCE;
            }
            if (!k.k(this.d)) {
                throw new XmlPullParserException("iterateCurrentTagEvents call is allowed only for START_TAG event");
            }
            int depth = this.d.getDepth();
            while (this.d.getDepth() >= depth) {
                int depth2 = this.d.getDepth() - depth;
                if (depth2 != 0) {
                    if (depth2 == 1) {
                        k.k(this.d);
                    }
                } else if (k.k(this.d)) {
                    XmlPullParser xmlPullParser = this.d;
                    this.e.element = k.b(xmlPullParser, "model");
                    this.f.element = k.b(xmlPullParser, "currency");
                } else if (k.l(this.d) && (text = this.d.getText()) != null && !StringsKt.isBlank(text)) {
                    String text2 = this.d.getText();
                    Intrinsics.checkNotNullExpressionValue(text2, "text");
                    StringsKt.trim((CharSequence) text2).toString();
                } else if (k.i(this.d)) {
                    return Unit.INSTANCE;
                }
                this.d.next();
            }
            return Unit.INSTANCE;
        }
    }

    @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.VastParserKt", f = "VastParser.kt", i = {0}, l = {941}, m = "parseCompanionAdsTag", n = {"companions"}, s = {"L$0"})
    public static final class j extends ContinuationImpl {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object f6849a;
        public /* synthetic */ Object b;
        public int c;

        public j(Continuation<? super j> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.b = obj;
            this.c |= Integer.MIN_VALUE;
            return k.B(null, this);
        }
    }

    @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.VastParserKt", f = "VastParser.kt", i = {0, 0}, l = {941}, m = "parsePricingTag", n = {"model", "currency"}, s = {"L$0", "L$1"})
    public static final class j0 extends ContinuationImpl {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object f6850a;
        public Object b;
        public /* synthetic */ Object c;
        public int d;

        public j0(Continuation<? super j0> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.c = obj;
            this.d |= Integer.MIN_VALUE;
            return k.N(null, this);
        }
    }

    /* JADX INFO: renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.k$k, reason: collision with other inner class name */
    @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.VastParserKt$parseCompanionTag$$inlined$iterateTag$1", f = "VastParser.kt", i = {0, 1, 2, 3, 4, 5, 6, 7}, l = {951, 953, 956, 959, 960, 964, 969, 970}, m = "invokeSuspend", n = {"initialDepth", "initialDepth", "initialDepth", "initialDepth", "initialDepth", "initialDepth", "initialDepth", "initialDepth"}, s = {"I$0", "I$0", "I$0", "I$0", "I$0", "I$0", "I$0", "I$0"})
    public static final class C0644k extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f6851a;
        public int b;
        public /* synthetic */ Object c;
        public final /* synthetic */ XmlPullParser d;
        public final /* synthetic */ Ref.ObjectRef e;
        public final /* synthetic */ Ref.ObjectRef f;
        public final /* synthetic */ Ref.ObjectRef g;
        public final /* synthetic */ Ref.ObjectRef h;
        public final /* synthetic */ Ref.ObjectRef i;
        public final /* synthetic */ Ref.ObjectRef j;
        public final /* synthetic */ List k;
        public final /* synthetic */ Ref.ObjectRef l;
        public final /* synthetic */ List m;
        public final /* synthetic */ List n;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0644k(XmlPullParser xmlPullParser, Continuation continuation, Ref.ObjectRef objectRef, Ref.ObjectRef objectRef2, Ref.ObjectRef objectRef3, Ref.ObjectRef objectRef4, Ref.ObjectRef objectRef5, Ref.ObjectRef objectRef6, List list, Ref.ObjectRef objectRef7, List list2, List list3) {
            super(2, continuation);
            this.d = xmlPullParser;
            this.e = objectRef;
            this.f = objectRef2;
            this.g = objectRef3;
            this.h = objectRef4;
            this.i = objectRef5;
            this.j = objectRef6;
            this.k = list;
            this.l = objectRef7;
            this.m = list2;
            this.n = list3;
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C0644k) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C0644k c0644k = new C0644k(this.d, continuation, this.e, this.f, this.g, this.h, this.i, this.j, this.k, this.l, this.m, this.n);
            c0644k.c = obj;
            return c0644k;
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        /* JADX WARN: Code duplicated, block: B:100:0x01d4  */
        /* JADX WARN: Code duplicated, block: B:101:0x01e4  */
        /* JADX WARN: Code duplicated, block: B:104:0x01ee  */
        /* JADX WARN: Code duplicated, block: B:106:0x01fd A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:107:0x01fe  */
        /* JADX WARN: Code duplicated, block: B:108:0x0202  */
        /* JADX WARN: Code duplicated, block: B:110:0x020a  */
        /* JADX WARN: Code duplicated, block: B:112:0x0220  */
        /* JADX WARN: Code duplicated, block: B:113:0x0225  */
        /* JADX WARN: Code duplicated, block: B:116:0x0232  */
        /* JADX WARN: Code duplicated, block: B:117:0x0236  */
        /* JADX WARN: Code duplicated, block: B:118:0x0243  */
        /* JADX WARN: Code duplicated, block: B:120:0x024b  */
        /* JADX WARN: Code duplicated, block: B:126:0x026d  */
        /* JADX WARN: Code duplicated, block: B:128:0x0275  */
        /* JADX WARN: Code duplicated, block: B:131:0x027f  */
        /* JADX WARN: Code duplicated, block: B:140:0x0191 A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:142:0x017c A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:26:0x0092  */
        /* JADX WARN: Code duplicated, block: B:28:0x009c  */
        /* JADX WARN: Code duplicated, block: B:31:0x00a1  */
        /* JADX WARN: Code duplicated, block: B:38:0x00ba  */
        /* JADX WARN: Code duplicated, block: B:41:0x00c4  */
        /* JADX WARN: Code duplicated, block: B:43:0x00d1 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:46:0x00d6  */
        /* JADX WARN: Code duplicated, block: B:47:0x00e6  */
        /* JADX WARN: Code duplicated, block: B:50:0x00f0  */
        /* JADX WARN: Code duplicated, block: B:52:0x00fe A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:55:0x0103  */
        /* JADX WARN: Code duplicated, block: B:56:0x010e  */
        /* JADX WARN: Code duplicated, block: B:59:0x0118  */
        /* JADX WARN: Code duplicated, block: B:61:0x0127 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:62:0x0128  */
        /* JADX WARN: Code duplicated, block: B:63:0x012c  */
        /* JADX WARN: Code duplicated, block: B:66:0x0136  */
        /* JADX WARN: Code duplicated, block: B:68:0x0142 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:71:0x0147  */
        /* JADX WARN: Code duplicated, block: B:72:0x0157  */
        /* JADX WARN: Code duplicated, block: B:75:0x0161  */
        /* JADX WARN: Code duplicated, block: B:77:0x0170 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:81:0x0182  */
        /* JADX WARN: Code duplicated, block: B:85:0x019a  */
        /* JADX WARN: Code duplicated, block: B:88:0x01a4  */
        /* JADX WARN: Code duplicated, block: B:90:0x01b3 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:91:0x01b4  */
        /* JADX WARN: Code duplicated, block: B:92:0x01b8  */
        /* JADX WARN: Code duplicated, block: B:95:0x01c2  */
        /* JADX WARN: Code duplicated, block: B:97:0x01cf A[RETURN] */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r2v15, types: [T, java.lang.Integer] */
        /* JADX WARN: Type inference failed for: r4v3, types: [T, java.lang.String] */
        /* JADX WARN: Type inference failed for: r8v46, types: [T, java.lang.String] */
        /* JADX WARN: Type inference failed for: r8v47, types: [T, java.lang.String] */
        /* JADX WARN: Type inference failed for: r8v51, types: [T, java.lang.Object] */
        /* JADX WARN: Type inference failed for: r8v53, types: [T, java.lang.Object] */
        /* JADX WARN: Type inference failed for: r8v56, types: [T, java.lang.Object] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:100:0x01d4 -> B:130:0x0278). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:102:0x01ea -> B:130:0x0278). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:125:0x025a -> B:130:0x0278). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:127:0x0273 -> B:130:0x0278). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:29:0x009d -> B:130:0x0278). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:32:0x00a7 -> B:130:0x0278). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:34:0x00af -> B:130:0x0278). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:36:0x00b5 -> B:130:0x0278). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:39:0x00c0 -> B:130:0x0278). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:45:0x00d4 -> B:130:0x0278). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:46:0x00d6 -> B:130:0x0278). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:48:0x00ec -> B:130:0x0278). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:51:0x00fc -> B:53:0x00ff). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:57:0x0114 -> B:130:0x0278). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:64:0x0132 -> B:130:0x0278). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:70:0x0145 -> B:130:0x0278). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:71:0x0147 -> B:130:0x0278). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:73:0x015d -> B:130:0x0278). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:84:0x0195 -> B:130:0x0278). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:86:0x01a0 -> B:130:0x0278). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:93:0x01be -> B:130:0x0278). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:99:0x01d2 -> B:130:0x0278). Please report as a decompilation issue!!! */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:88:0x01a4
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final java.lang.Object invokeSuspend(java.lang.Object r8) {
            /*
                Method dump skipped, instruction units count: 706
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.k.C0644k.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.VastParserKt$parseStaticResourceTag$$inlined$iterateTag$1", f = "VastParser.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class k0 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f6852a;
        public int b;
        public /* synthetic */ Object c;
        public final /* synthetic */ XmlPullParser d;
        public final /* synthetic */ Ref.ObjectRef e;
        public final /* synthetic */ Ref.ObjectRef f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public k0(XmlPullParser xmlPullParser, Continuation continuation, Ref.ObjectRef objectRef, Ref.ObjectRef objectRef2) {
            super(2, continuation);
            this.d = xmlPullParser;
            this.e = objectRef;
            this.f = objectRef2;
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((k0) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            k0 k0Var = new k0(this.d, continuation, this.e, this.f);
            k0Var.c = obj;
            return k0Var;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v20, types: [T, java.lang.String] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            String text;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            CoroutineScopeKt.ensureActive((CoroutineScope) this.c);
            if (k.j(this.d)) {
                this.d.nextTag();
            }
            if (k.h(this.d)) {
                return Unit.INSTANCE;
            }
            if (!k.k(this.d)) {
                throw new XmlPullParserException("iterateCurrentTagEvents call is allowed only for START_TAG event");
            }
            int depth = this.d.getDepth();
            while (this.d.getDepth() >= depth) {
                int depth2 = this.d.getDepth() - depth;
                if (depth2 != 0) {
                    if (depth2 == 1) {
                        k.k(this.d);
                    }
                } else if (k.k(this.d)) {
                    XmlPullParser xmlPullParser = this.d;
                    Ref.ObjectRef objectRef = this.e;
                    String strB = k.b(xmlPullParser, "creativeType");
                    objectRef.element = strB != null ? k.e(strB) : 0;
                } else if (k.l(this.d) && (text = this.d.getText()) != null && !StringsKt.isBlank(text)) {
                    String text2 = this.d.getText();
                    Intrinsics.checkNotNullExpressionValue(text2, "text");
                    this.f.element = StringsKt.trim((CharSequence) text2).toString();
                } else if (k.i(this.d)) {
                    return Unit.INSTANCE;
                }
                this.d.next();
            }
            return Unit.INSTANCE;
        }
    }

    @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.VastParserKt", f = "VastParser.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, l = {941}, m = "parseCompanionTag", n = {"id", "widthPx", "heightPx", "altText", "apiFramework", "adParameters", "creativeViewTrackingList", "resources", "clickThroughUrl", "clickTrackingList"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9"})
    public static final class l extends ContinuationImpl {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object f6853a;
        public Object b;
        public Object c;
        public Object d;
        public Object e;
        public Object f;
        public Object g;
        public Object h;
        public Object i;
        public Object j;
        public /* synthetic */ Object k;
        public int l;

        public l(Continuation<? super l> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.k = obj;
            this.l |= Integer.MIN_VALUE;
            return k.C(null, this);
        }
    }

    @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.VastParserKt", f = "VastParser.kt", i = {0, 0}, l = {941}, m = "parseStaticResourceTag", n = {Ad.VERIFICATIONRESOURCE, "creativeType"}, s = {"L$0", "L$1"})
    public static final class l0 extends ContinuationImpl {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object f6854a;
        public Object b;
        public /* synthetic */ Object c;
        public int d;

        public l0(Continuation<? super l0> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.c = obj;
            this.d |= Integer.MIN_VALUE;
            return k.O(null, this);
        }
    }

    @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.VastParserKt$parseCreativeTag$$inlined$iterateTag$1", f = "VastParser.kt", i = {0, 1}, l = {952, 956}, m = "invokeSuspend", n = {"initialDepth", "initialDepth"}, s = {"I$0", "I$0"})
    public static final class m extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f6855a;
        public int b;
        public /* synthetic */ Object c;
        public final /* synthetic */ XmlPullParser d;
        public final /* synthetic */ Ref.ObjectRef e;
        public final /* synthetic */ Ref.ObjectRef f;
        public final /* synthetic */ Ref.ObjectRef g;
        public final /* synthetic */ Ref.ObjectRef h;
        public final /* synthetic */ Ref.ObjectRef i;
        public final /* synthetic */ boolean j;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public m(XmlPullParser xmlPullParser, Continuation continuation, Ref.ObjectRef objectRef, Ref.ObjectRef objectRef2, Ref.ObjectRef objectRef3, Ref.ObjectRef objectRef4, Ref.ObjectRef objectRef5, boolean z) {
            super(2, continuation);
            this.d = xmlPullParser;
            this.e = objectRef;
            this.f = objectRef2;
            this.g = objectRef3;
            this.h = objectRef4;
            this.i = objectRef5;
            this.j = z;
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((m) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            m mVar = new m(this.d, continuation, this.e, this.f, this.g, this.h, this.i, this.j);
            mVar.c = obj;
            return mVar;
        }

        /* JADX WARN: Code duplicated, block: B:22:0x0066  */
        /* JADX WARN: Code duplicated, block: B:24:0x006f  */
        /* JADX WARN: Code duplicated, block: B:26:0x0073  */
        /* JADX WARN: Code duplicated, block: B:30:0x0083  */
        /* JADX WARN: Code duplicated, block: B:32:0x008f  */
        /* JADX WARN: Code duplicated, block: B:34:0x009d A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:37:0x00a2  */
        /* JADX WARN: Code duplicated, block: B:38:0x00a8  */
        /* JADX WARN: Code duplicated, block: B:40:0x00b0  */
        /* JADX WARN: Code duplicated, block: B:42:0x00bc A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:52:0x00d6  */
        /* JADX WARN: Code duplicated, block: B:54:0x00de  */
        /* JADX WARN: Code duplicated, block: B:55:0x0107  */
        /* JADX WARN: Code duplicated, block: B:57:0x010f  */
        /* JADX WARN: Code duplicated, block: B:63:0x0131  */
        /* JADX WARN: Code duplicated, block: B:65:0x0139  */
        /* JADX WARN: Code duplicated, block: B:68:0x0143  */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r6v3, types: [T, java.lang.String] */
        /* JADX WARN: Type inference failed for: r6v4, types: [T, java.lang.Integer] */
        /* JADX WARN: Type inference failed for: r6v6, types: [T, java.lang.String] */
        /* JADX WARN: Type inference failed for: r9v36, types: [T, java.lang.String] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:24:0x006f -> B:67:0x013c). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:27:0x0079 -> B:67:0x013c). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:29:0x0081 -> B:67:0x013c). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:37:0x00a2 -> B:51:0x00d3). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:41:0x00ba -> B:43:0x00bd). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:50:0x00d2 -> B:51:0x00d3). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:54:0x00de -> B:67:0x013c). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:62:0x011e -> B:67:0x013c). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:64:0x0137 -> B:67:0x013c). Please report as a decompilation issue!!! */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:26:0x0073
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final java.lang.Object invokeSuspend(java.lang.Object r9) {
            /*
                Method dump skipped, instruction units count: 334
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.k.m.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.VastParserKt$parseTagsTextOnly$$inlined$iterateTag$1", f = "VastParser.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class m0 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f6856a;
        public int b;
        public /* synthetic */ Object c;
        public final /* synthetic */ XmlPullParser d;
        public final /* synthetic */ Ref.ObjectRef e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public m0(XmlPullParser xmlPullParser, Continuation continuation, Ref.ObjectRef objectRef) {
            super(2, continuation);
            this.d = xmlPullParser;
            this.e = objectRef;
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((m0) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            m0 m0Var = new m0(this.d, continuation, this.e);
            m0Var.c = obj;
            return m0Var;
        }

        /* JADX WARN: Type inference failed for: r0v20, types: [T, java.lang.String] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            String text;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            CoroutineScopeKt.ensureActive((CoroutineScope) this.c);
            if (k.j(this.d)) {
                this.d.nextTag();
            }
            if (k.h(this.d)) {
                return Unit.INSTANCE;
            }
            if (!k.k(this.d)) {
                throw new XmlPullParserException("iterateCurrentTagEvents call is allowed only for START_TAG event");
            }
            int depth = this.d.getDepth();
            while (this.d.getDepth() >= depth) {
                int depth2 = this.d.getDepth() - depth;
                if (depth2 != 0) {
                    if (depth2 == 1) {
                        k.k(this.d);
                    }
                } else if (k.k(this.d)) {
                    continue;
                } else if (k.l(this.d) && (text = this.d.getText()) != null && !StringsKt.isBlank(text)) {
                    String text2 = this.d.getText();
                    Intrinsics.checkNotNullExpressionValue(text2, "text");
                    this.e.element = StringsKt.trim((CharSequence) text2).toString();
                } else if (k.i(this.d)) {
                    return Unit.INSTANCE;
                }
                this.d.next();
            }
            return Unit.INSTANCE;
        }
    }

    @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.VastParserKt", f = "VastParser.kt", i = {0, 0, 0, 0, 0}, l = {941}, m = "parseCreativeTag", n = {"id", "sequence", "adId", "apiFramework", "child"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4"})
    public static final class n extends ContinuationImpl {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object f6857a;
        public Object b;
        public Object c;
        public Object d;
        public Object e;
        public /* synthetic */ Object f;
        public int g;

        public n(Continuation<? super n> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.f = obj;
            this.g |= Integer.MIN_VALUE;
            return k.e(null, false, this);
        }
    }

    @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.VastParserKt", f = "VastParser.kt", i = {0}, l = {941}, m = "parseTagsTextOnly", n = {"simpleText"}, s = {"L$0"})
    public static final class n0 extends ContinuationImpl {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object f6858a;
        public /* synthetic */ Object b;
        public int c;

        public n0(Continuation<? super n0> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.b = obj;
            this.c |= Integer.MIN_VALUE;
            return k.P(null, this);
        }
    }

    @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.VastParserKt$parseCreativesTag$$inlined$iterateTag$1", f = "VastParser.kt", i = {0}, l = {946}, m = "invokeSuspend", n = {"initialDepth"}, s = {"I$0"})
    public static final class o extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f6859a;
        public int b;
        public /* synthetic */ Object c;
        public final /* synthetic */ XmlPullParser d;
        public final /* synthetic */ boolean e;
        public final /* synthetic */ List f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public o(XmlPullParser xmlPullParser, Continuation continuation, boolean z, List list) {
            super(2, continuation);
            this.d = xmlPullParser;
            this.e = z;
            this.f = list;
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((o) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            o oVar = new o(this.d, continuation, this.e, this.f);
            oVar.c = obj;
            return oVar;
        }

        /* JADX WARN: Code duplicated, block: B:20:0x0053  */
        /* JADX WARN: Code duplicated, block: B:22:0x005c  */
        /* JADX WARN: Code duplicated, block: B:24:0x0060  */
        /* JADX WARN: Code duplicated, block: B:28:0x0076  */
        /* JADX WARN: Code duplicated, block: B:30:0x0082 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:34:0x0091  */
        /* JADX WARN: Code duplicated, block: B:37:0x009a  */
        /* JADX WARN: Code duplicated, block: B:39:0x00a2  */
        /* JADX WARN: Code duplicated, block: B:45:0x00c4  */
        /* JADX WARN: Code duplicated, block: B:47:0x00cc  */
        /* JADX WARN: Code duplicated, block: B:50:0x00d6  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x005c -> B:49:0x00cf). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:25:0x0066 -> B:49:0x00cf). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:27:0x0074 -> B:49:0x00cf). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:29:0x0080 -> B:31:0x0083). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:35:0x0097 -> B:49:0x00cf). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:44:0x00b1 -> B:49:0x00cf). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:46:0x00ca -> B:49:0x00cf). Please report as a decompilation issue!!! */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:39:0x00a2
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final java.lang.Object invokeSuspend(java.lang.Object r6) {
            /*
                Method dump skipped, instruction units count: 225
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.k.o.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.VastParserKt$parseTrackingEventsTag$$inlined$iterateTag$1", f = "VastParser.kt", i = {0}, l = {946}, m = "invokeSuspend", n = {"initialDepth"}, s = {"I$0"})
    public static final class o0 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f6860a;
        public int b;
        public /* synthetic */ Object c;
        public final /* synthetic */ XmlPullParser d;
        public final /* synthetic */ List e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public o0(XmlPullParser xmlPullParser, Continuation continuation, List list) {
            super(2, continuation);
            this.d = xmlPullParser;
            this.e = list;
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((o0) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            o0 o0Var = new o0(this.d, continuation, this.e);
            o0Var.c = obj;
            return o0Var;
        }

        /* JADX WARN: Code duplicated, block: B:20:0x0052  */
        /* JADX WARN: Code duplicated, block: B:22:0x005b  */
        /* JADX WARN: Code duplicated, block: B:24:0x005f  */
        /* JADX WARN: Code duplicated, block: B:28:0x0075  */
        /* JADX WARN: Code duplicated, block: B:30:0x007f A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:34:0x008e  */
        /* JADX WARN: Code duplicated, block: B:37:0x0097  */
        /* JADX WARN: Code duplicated, block: B:39:0x009f  */
        /* JADX WARN: Code duplicated, block: B:45:0x00c1  */
        /* JADX WARN: Code duplicated, block: B:47:0x00c9  */
        /* JADX WARN: Code duplicated, block: B:50:0x00d3  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x005b -> B:49:0x00cc). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:25:0x0065 -> B:49:0x00cc). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:27:0x0073 -> B:49:0x00cc). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:29:0x007d -> B:31:0x0080). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:35:0x0094 -> B:49:0x00cc). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:44:0x00ae -> B:49:0x00cc). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:46:0x00c7 -> B:49:0x00cc). Please report as a decompilation issue!!! */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:39:0x009f
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final java.lang.Object invokeSuspend(java.lang.Object r6) {
            /*
                Method dump skipped, instruction units count: 222
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.k.o0.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.VastParserKt", f = "VastParser.kt", i = {0}, l = {941}, m = "parseCreativesTag", n = {"creatives"}, s = {"L$0"})
    public static final class p extends ContinuationImpl {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object f6861a;
        public /* synthetic */ Object b;
        public int c;

        public p(Continuation<? super p> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.b = obj;
            this.c |= Integer.MIN_VALUE;
            return k.f(null, false, this);
        }
    }

    @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.VastParserKt", f = "VastParser.kt", i = {0}, l = {941}, m = "parseTrackingEventsTag", n = {"trackingList"}, s = {"L$0"})
    public static final class p0 extends ContinuationImpl {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object f6862a;
        public /* synthetic */ Object b;
        public int c;

        public p0(Continuation<? super p0> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.b = obj;
            this.c |= Integer.MIN_VALUE;
            return k.Q(null, this);
        }
    }

    @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.VastParserKt", f = "VastParser.kt", i = {}, l = {799}, m = "parseHtmlResourceTag", n = {}, s = {})
    public static final class q extends ContinuationImpl {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public /* synthetic */ Object f6863a;
        public int b;

        public q(Continuation<? super q> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.f6863a = obj;
            this.b |= Integer.MIN_VALUE;
            return k.E(null, this);
        }
    }

    @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.VastParserKt$parseTrackingTag$$inlined$iterateTag$1", f = "VastParser.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class q0 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f6864a;
        public int b;
        public /* synthetic */ Object c;
        public final /* synthetic */ XmlPullParser d;
        public final /* synthetic */ Ref.ObjectRef e;
        public final /* synthetic */ Ref.ObjectRef f;
        public final /* synthetic */ Ref.ObjectRef g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public q0(XmlPullParser xmlPullParser, Continuation continuation, Ref.ObjectRef objectRef, Ref.ObjectRef objectRef2, Ref.ObjectRef objectRef3) {
            super(2, continuation);
            this.d = xmlPullParser;
            this.e = objectRef;
            this.f = objectRef2;
            this.g = objectRef3;
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((q0) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            q0 q0Var = new q0(this.d, continuation, this.e, this.f, this.g);
            q0Var.c = obj;
            return q0Var;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v20, types: [T, java.lang.String] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            String text;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            CoroutineScopeKt.ensureActive((CoroutineScope) this.c);
            if (k.j(this.d)) {
                this.d.nextTag();
            }
            if (k.h(this.d)) {
                return Unit.INSTANCE;
            }
            if (!k.k(this.d)) {
                throw new XmlPullParserException("iterateCurrentTagEvents call is allowed only for START_TAG event");
            }
            int depth = this.d.getDepth();
            while (this.d.getDepth() >= depth) {
                int depth2 = this.d.getDepth() - depth;
                if (depth2 != 0) {
                    if (depth2 == 1) {
                        k.k(this.d);
                    }
                } else if (k.k(this.d)) {
                    XmlPullParser xmlPullParser = this.d;
                    Ref.ObjectRef objectRef = this.e;
                    String strB = k.b(xmlPullParser, "event");
                    objectRef.element = strB != null ? k.i(strB) : 0;
                    Ref.ObjectRef objectRef2 = this.f;
                    String strB2 = k.b(xmlPullParser, "offset");
                    objectRef2.element = strB2 != null ? k.g(strB2) : 0;
                } else if (k.l(this.d) && (text = this.d.getText()) != null && !StringsKt.isBlank(text)) {
                    String text2 = this.d.getText();
                    Intrinsics.checkNotNullExpressionValue(text2, "text");
                    this.g.element = StringsKt.trim((CharSequence) text2).toString();
                } else if (k.i(this.d)) {
                    return Unit.INSTANCE;
                }
                this.d.next();
            }
            return Unit.INSTANCE;
        }
    }

    @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.VastParserKt", f = "VastParser.kt", i = {}, l = {EventTypeExtended.EVENT_TYPE_EXTENDED_NURL_VALUE}, m = "parseIFrameResourceTag", n = {}, s = {})
    public static final class r extends ContinuationImpl {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public /* synthetic */ Object f6865a;
        public int b;

        public r(Continuation<? super r> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.f6865a = obj;
            this.b |= Integer.MIN_VALUE;
            return k.F(null, this);
        }
    }

    @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.VastParserKt", f = "VastParser.kt", i = {0, 0, 0}, l = {941}, m = "parseTrackingTag", n = {"event", "url", "offset"}, s = {"L$0", "L$1", "L$2"})
    public static final class r0 extends ContinuationImpl {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object f6866a;
        public Object b;
        public Object c;
        public /* synthetic */ Object d;
        public int e;

        public r0(Continuation<? super r0> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.d = obj;
            this.e |= Integer.MIN_VALUE;
            return k.R(null, this);
        }
    }

    @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.VastParserKt$parseIconClicksTag$$inlined$iterateTag$1", f = "VastParser.kt", i = {0, 1}, l = {946, 947}, m = "invokeSuspend", n = {"initialDepth", "initialDepth"}, s = {"I$0", "I$0"})
    public static final class s extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f6867a;
        public int b;
        public /* synthetic */ Object c;
        public final /* synthetic */ XmlPullParser d;
        public final /* synthetic */ Ref.ObjectRef e;
        public final /* synthetic */ List f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public s(XmlPullParser xmlPullParser, Continuation continuation, Ref.ObjectRef objectRef, List list) {
            super(2, continuation);
            this.d = xmlPullParser;
            this.e = objectRef;
            this.f = list;
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((s) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            s sVar = new s(this.d, continuation, this.e, this.f);
            sVar.c = obj;
            return sVar;
        }

        /* JADX WARN: Code duplicated, block: B:22:0x0060  */
        /* JADX WARN: Code duplicated, block: B:24:0x0069  */
        /* JADX WARN: Code duplicated, block: B:26:0x006d  */
        /* JADX WARN: Code duplicated, block: B:30:0x0083  */
        /* JADX WARN: Code duplicated, block: B:32:0x0091 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:33:0x0092  */
        /* JADX WARN: Code duplicated, block: B:34:0x0095  */
        /* JADX WARN: Code duplicated, block: B:36:0x009d  */
        /* JADX WARN: Code duplicated, block: B:38:0x00aa A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:42:0x00b9  */
        /* JADX WARN: Code duplicated, block: B:45:0x00c2  */
        /* JADX WARN: Code duplicated, block: B:47:0x00ca  */
        /* JADX WARN: Code duplicated, block: B:53:0x00ec  */
        /* JADX WARN: Code duplicated, block: B:55:0x00f4  */
        /* JADX WARN: Code duplicated, block: B:58:0x00fe  */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r7v37, types: [T, java.lang.Object] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:24:0x0069 -> B:57:0x00f7). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:27:0x0073 -> B:57:0x00f7). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:35:0x009b -> B:57:0x00f7). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:37:0x00a8 -> B:39:0x00ab). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:43:0x00bf -> B:57:0x00f7). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:52:0x00d9 -> B:57:0x00f7). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:54:0x00f2 -> B:57:0x00f7). Please report as a decompilation issue!!! */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:47:0x00ca
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final java.lang.Object invokeSuspend(java.lang.Object r7) {
            /*
                Method dump skipped, instruction units count: 265
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.k.s.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.VastParserKt$parseVast$2", f = "VastParser.kt", i = {}, l = {130}, m = "invokeSuspend", n = {}, s = {})
    public static final class s0 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.w>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f6868a;
        public final /* synthetic */ XmlPullParser b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public s0(XmlPullParser xmlPullParser, Continuation<? super s0> continuation) {
            super(2, continuation);
            this.b = xmlPullParser;
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.w> continuation) {
            return ((s0) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new s0(this.b, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.f6868a;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                XmlPullParser xmlPullParser = this.b;
                this.f6868a = 1;
                obj = k.T(xmlPullParser, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return obj;
        }
    }

    @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.VastParserKt", f = "VastParser.kt", i = {0, 0}, l = {941}, m = "parseIconClicksTag", n = {"clickThroughUrl", "clickTrackingUrlList"}, s = {"L$0", "L$1"})
    public static final class t extends ContinuationImpl {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object f6869a;
        public Object b;
        public /* synthetic */ Object c;
        public int d;

        public t(Continuation<? super t> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.c = obj;
            this.d |= Integer.MIN_VALUE;
            return k.G(null, this);
        }
    }

    @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.VastParserKt$parseVastTag$$inlined$iterateTag$1", f = "VastParser.kt", i = {0, 1}, l = {947, 948}, m = "invokeSuspend", n = {"initialDepth", "initialDepth"}, s = {"I$0", "I$0"})
    public static final class t0 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f6870a;
        public int b;
        public /* synthetic */ Object c;
        public final /* synthetic */ XmlPullParser d;
        public final /* synthetic */ Ref.ObjectRef e;
        public final /* synthetic */ Ref.ObjectRef f;
        public final /* synthetic */ List g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public t0(XmlPullParser xmlPullParser, Continuation continuation, Ref.ObjectRef objectRef, Ref.ObjectRef objectRef2, List list) {
            super(2, continuation);
            this.d = xmlPullParser;
            this.e = objectRef;
            this.f = objectRef2;
            this.g = list;
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((t0) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            t0 t0Var = new t0(this.d, continuation, this.e, this.f, this.g);
            t0Var.c = obj;
            return t0Var;
        }

        /* JADX WARN: Code duplicated, block: B:22:0x0060  */
        /* JADX WARN: Code duplicated, block: B:24:0x0069  */
        /* JADX WARN: Code duplicated, block: B:26:0x006d  */
        /* JADX WARN: Code duplicated, block: B:30:0x0083  */
        /* JADX WARN: Code duplicated, block: B:32:0x0091 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:33:0x0092  */
        /* JADX WARN: Code duplicated, block: B:34:0x0096  */
        /* JADX WARN: Code duplicated, block: B:36:0x009e  */
        /* JADX WARN: Code duplicated, block: B:38:0x00ab A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:42:0x00ba  */
        /* JADX WARN: Code duplicated, block: B:44:0x00c2  */
        /* JADX WARN: Code duplicated, block: B:45:0x00cf  */
        /* JADX WARN: Code duplicated, block: B:47:0x00d7  */
        /* JADX WARN: Code duplicated, block: B:53:0x00f9  */
        /* JADX WARN: Code duplicated, block: B:55:0x0101  */
        /* JADX WARN: Code duplicated, block: B:58:0x010b  */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r7v34, types: [T, java.lang.String] */
        /* JADX WARN: Type inference failed for: r7v39, types: [T, java.lang.Object] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:24:0x0069 -> B:57:0x0104). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:27:0x0073 -> B:57:0x0104). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:35:0x009c -> B:57:0x0104). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:37:0x00a9 -> B:39:0x00ac). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:44:0x00c2 -> B:57:0x0104). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:52:0x00e6 -> B:57:0x0104). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:54:0x00ff -> B:57:0x0104). Please report as a decompilation issue!!! */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:22:0x0060
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final java.lang.Object invokeSuspend(java.lang.Object r7) {
            /*
                Method dump skipped, instruction units count: 278
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.k.t0.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.VastParserKt$parseIconTag$$inlined$iterateTag$1", f = "VastParser.kt", i = {0, 0, 1, 1, 2, 2, 3, 4}, l = {953, 955, 956, 962, 963}, m = "invokeSuspend", n = {"$this$parseIconTag_u24lambda_u2497", "initialDepth", "$this$parseIconTag_u24lambda_u2497", "initialDepth", "$this$parseIconTag_u24lambda_u2497", "initialDepth", "initialDepth", "initialDepth"}, s = {"L$0", "I$0", "L$0", "I$0", "L$0", "I$0", "I$0", "I$0"})
    public static final class u extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f6871a;
        public int b;
        public /* synthetic */ Object c;
        public final /* synthetic */ XmlPullParser d;
        public final /* synthetic */ Ref.ObjectRef e;
        public final /* synthetic */ Ref.ObjectRef f;
        public final /* synthetic */ Ref.ObjectRef g;
        public final /* synthetic */ Ref.ObjectRef h;
        public final /* synthetic */ Ref.ObjectRef i;
        public final /* synthetic */ Ref.ObjectRef j;
        public final /* synthetic */ Ref.ObjectRef k;
        public final /* synthetic */ Ref.ObjectRef l;
        public final /* synthetic */ List m;
        public Object n;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public u(XmlPullParser xmlPullParser, Continuation continuation, Ref.ObjectRef objectRef, Ref.ObjectRef objectRef2, Ref.ObjectRef objectRef3, Ref.ObjectRef objectRef4, Ref.ObjectRef objectRef5, Ref.ObjectRef objectRef6, Ref.ObjectRef objectRef7, Ref.ObjectRef objectRef8, List list) {
            super(2, continuation);
            this.d = xmlPullParser;
            this.e = objectRef;
            this.f = objectRef2;
            this.g = objectRef3;
            this.h = objectRef4;
            this.i = objectRef5;
            this.j = objectRef6;
            this.k = objectRef7;
            this.l = objectRef8;
            this.m = list;
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((u) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            u uVar = new u(this.d, continuation, this.e, this.f, this.g, this.h, this.i, this.j, this.k, this.l, this.m);
            uVar.c = obj;
            return uVar;
        }

        /* JADX WARN: Code duplicated, block: B:100:0x01cf  */
        /* JADX WARN: Code duplicated, block: B:103:0x01dc  */
        /* JADX WARN: Code duplicated, block: B:104:0x01e1  */
        /* JADX WARN: Code duplicated, block: B:106:0x01e5  */
        /* JADX WARN: Code duplicated, block: B:108:0x01ed  */
        /* JADX WARN: Code duplicated, block: B:114:0x020f  */
        /* JADX WARN: Code duplicated, block: B:116:0x0217  */
        /* JADX WARN: Code duplicated, block: B:119:0x0221  */
        /* JADX WARN: Code duplicated, block: B:28:0x0098  */
        /* JADX WARN: Code duplicated, block: B:30:0x00a1  */
        /* JADX WARN: Code duplicated, block: B:32:0x00a5  */
        /* JADX WARN: Code duplicated, block: B:36:0x00b5  */
        /* JADX WARN: Code duplicated, block: B:38:0x00bb  */
        /* JADX WARN: Code duplicated, block: B:40:0x00c4  */
        /* JADX WARN: Code duplicated, block: B:42:0x00c9  */
        /* JADX WARN: Code duplicated, block: B:45:0x00cf  */
        /* JADX WARN: Code duplicated, block: B:50:0x00e6 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:53:0x00eb  */
        /* JADX WARN: Code duplicated, block: B:54:0x00f1  */
        /* JADX WARN: Code duplicated, block: B:56:0x00f9  */
        /* JADX WARN: Code duplicated, block: B:58:0x0107 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:61:0x010c  */
        /* JADX WARN: Code duplicated, block: B:62:0x0112  */
        /* JADX WARN: Code duplicated, block: B:65:0x011b  */
        /* JADX WARN: Code duplicated, block: B:67:0x0129 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:70:0x012e  */
        /* JADX WARN: Code duplicated, block: B:73:0x0137 A[PHI: r1 r9
  0x0137: PHI (r1v2 int) = (r1v6 int), (r1v8 int) binds: [B:72:0x0135, B:35:0x00b3] A[DONT_GENERATE, DONT_INLINE]
  0x0137: PHI (r9v0 org.xmlpull.v1.XmlPullParser) = (r9v4 org.xmlpull.v1.XmlPullParser), (r9v26 org.xmlpull.v1.XmlPullParser) binds: [B:72:0x0135, B:35:0x00b3] A[DONT_GENERATE, DONT_INLINE]] */
        /* JADX WARN: Code duplicated, block: B:75:0x0143  */
        /* JADX WARN: Code duplicated, block: B:77:0x0153 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:78:0x0154  */
        /* JADX WARN: Code duplicated, block: B:79:0x0158  */
        /* JADX WARN: Code duplicated, block: B:81:0x0160  */
        /* JADX WARN: Code duplicated, block: B:83:0x016e A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:87:0x017e  */
        /* JADX WARN: Code duplicated, block: B:89:0x0186  */
        /* JADX WARN: Code duplicated, block: B:91:0x019c  */
        /* JADX WARN: Code duplicated, block: B:92:0x01a1  */
        /* JADX WARN: Code duplicated, block: B:95:0x01ae  */
        /* JADX WARN: Code duplicated, block: B:96:0x01b3  */
        /* JADX WARN: Code duplicated, block: B:99:0x01ca  */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r13v17, types: [T, java.lang.Object] */
        /* JADX WARN: Type inference failed for: r13v46, types: [T, java.lang.Long] */
        /* JADX WARN: Type inference failed for: r9v17, types: [T, java.lang.String] */
        /* JADX WARN: Type inference failed for: r9v7, types: [T, java.lang.String] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:113:0x01fc -> B:118:0x021a). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:115:0x0215 -> B:118:0x021a). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:30:0x00a1 -> B:118:0x021a). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:33:0x00ab -> B:118:0x021a). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:80:0x015e -> B:118:0x021a). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:82:0x016c -> B:84:0x016f). Please report as a decompilation issue!!! */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:36:0x00b5
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final java.lang.Object invokeSuspend(java.lang.Object r13) {
            /*
                Method dump skipped, instruction units count: 556
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.k.u.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.VastParserKt", f = "VastParser.kt", i = {0, 0, 0}, l = {941}, m = "parseVastTag", n = {"ads", "version", "errorUrl"}, s = {"L$0", "L$1", "L$2"})
    public static final class u0 extends ContinuationImpl {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object f6872a;
        public Object b;
        public Object c;
        public /* synthetic */ Object d;
        public int e;

        public u0(Continuation<? super u0> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.d = obj;
            this.e |= Integer.MIN_VALUE;
            return k.T(null, this);
        }
    }

    @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.VastParserKt", f = "VastParser.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 0}, l = {941}, m = "parseIconTag", n = {Icon.PROGRAM, "widthPx", "heightPx", "apiFramework", "offset", "durationMillis", "clicks", Ad.VERIFICATIONRESOURCE, "viewTrackingUrlList"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8"})
    public static final class v extends ContinuationImpl {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object f6873a;
        public Object b;
        public Object c;
        public Object d;
        public Object e;
        public Object f;
        public Object g;
        public Object h;
        public Object i;
        public /* synthetic */ Object j;
        public int k;

        public v(Continuation<? super v> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.j = obj;
            this.k |= Integer.MIN_VALUE;
            return k.H(null, this);
        }
    }

    @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.VastParserKt$parseVideoClickTag$$inlined$iterateTag$1", f = "VastParser.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class v0 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f6874a;
        public int b;
        public /* synthetic */ Object c;
        public final /* synthetic */ XmlPullParser d;
        public final /* synthetic */ Ref.ObjectRef e;
        public final /* synthetic */ Ref.ObjectRef f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public v0(XmlPullParser xmlPullParser, Continuation continuation, Ref.ObjectRef objectRef, Ref.ObjectRef objectRef2) {
            super(2, continuation);
            this.d = xmlPullParser;
            this.e = objectRef;
            this.f = objectRef2;
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((v0) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            v0 v0Var = new v0(this.d, continuation, this.e, this.f);
            v0Var.c = obj;
            return v0Var;
        }

        /* JADX WARN: Type inference failed for: r0v20, types: [T, java.lang.String] */
        /* JADX WARN: Type inference failed for: r0v22, types: [T, java.lang.String] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            String text;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            CoroutineScopeKt.ensureActive((CoroutineScope) this.c);
            if (k.j(this.d)) {
                this.d.nextTag();
            }
            if (k.h(this.d)) {
                return Unit.INSTANCE;
            }
            if (!k.k(this.d)) {
                throw new XmlPullParserException("iterateCurrentTagEvents call is allowed only for START_TAG event");
            }
            int depth = this.d.getDepth();
            while (this.d.getDepth() >= depth) {
                int depth2 = this.d.getDepth() - depth;
                if (depth2 != 0) {
                    if (depth2 == 1) {
                        k.k(this.d);
                    }
                } else if (k.k(this.d)) {
                    this.e.element = k.b(this.d, "id");
                } else if (k.l(this.d) && (text = this.d.getText()) != null && !StringsKt.isBlank(text)) {
                    String text2 = this.d.getText();
                    Intrinsics.checkNotNullExpressionValue(text2, "text");
                    this.f.element = StringsKt.trim((CharSequence) text2).toString();
                } else if (k.i(this.d)) {
                    return Unit.INSTANCE;
                }
                this.d.next();
            }
            return Unit.INSTANCE;
        }
    }

    @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.VastParserKt$parseIconsTag$$inlined$iterateTag$1", f = "VastParser.kt", i = {0}, l = {946}, m = "invokeSuspend", n = {"initialDepth"}, s = {"I$0"})
    public static final class w extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f6875a;
        public int b;
        public /* synthetic */ Object c;
        public final /* synthetic */ XmlPullParser d;
        public final /* synthetic */ List e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public w(XmlPullParser xmlPullParser, Continuation continuation, List list) {
            super(2, continuation);
            this.d = xmlPullParser;
            this.e = list;
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((w) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            w wVar = new w(this.d, continuation, this.e);
            wVar.c = obj;
            return wVar;
        }

        /* JADX WARN: Code duplicated, block: B:20:0x0052  */
        /* JADX WARN: Code duplicated, block: B:22:0x005b  */
        /* JADX WARN: Code duplicated, block: B:24:0x005f  */
        /* JADX WARN: Code duplicated, block: B:28:0x0075  */
        /* JADX WARN: Code duplicated, block: B:30:0x007f A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:34:0x008e  */
        /* JADX WARN: Code duplicated, block: B:37:0x0097  */
        /* JADX WARN: Code duplicated, block: B:39:0x009f  */
        /* JADX WARN: Code duplicated, block: B:45:0x00c1  */
        /* JADX WARN: Code duplicated, block: B:47:0x00c9  */
        /* JADX WARN: Code duplicated, block: B:50:0x00d3  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x005b -> B:49:0x00cc). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:25:0x0065 -> B:49:0x00cc). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:27:0x0073 -> B:49:0x00cc). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:29:0x007d -> B:31:0x0080). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:35:0x0094 -> B:49:0x00cc). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:44:0x00ae -> B:49:0x00cc). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:46:0x00c7 -> B:49:0x00cc). Please report as a decompilation issue!!! */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:39:0x009f
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final java.lang.Object invokeSuspend(java.lang.Object r6) {
            /*
                Method dump skipped, instruction units count: 222
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.k.w.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.VastParserKt", f = "VastParser.kt", i = {0, 0}, l = {941}, m = "parseVideoClickTag", n = {"id", "url"}, s = {"L$0", "L$1"})
    public static final class w0 extends ContinuationImpl {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object f6876a;
        public Object b;
        public /* synthetic */ Object c;
        public int d;

        public w0(Continuation<? super w0> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.c = obj;
            this.d |= Integer.MIN_VALUE;
            return k.U(null, this);
        }
    }

    @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.VastParserKt", f = "VastParser.kt", i = {0}, l = {941}, m = "parseIconsTag", n = {"icons"}, s = {"L$0"})
    public static final class x extends ContinuationImpl {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object f6877a;
        public /* synthetic */ Object b;
        public int c;

        public x(Continuation<? super x> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.b = obj;
            this.c |= Integer.MIN_VALUE;
            return k.I(null, this);
        }
    }

    @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.VastParserKt$parseVideoClicksTag$$inlined$iterateTag$1", f = "VastParser.kt", i = {0, 1, 2}, l = {946, 947, 949}, m = "invokeSuspend", n = {"initialDepth", "initialDepth", "initialDepth"}, s = {"I$0", "I$0", "I$0"})
    public static final class x0 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f6878a;
        public int b;
        public /* synthetic */ Object c;
        public final /* synthetic */ XmlPullParser d;
        public final /* synthetic */ Ref.ObjectRef e;
        public final /* synthetic */ List f;
        public final /* synthetic */ List g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public x0(XmlPullParser xmlPullParser, Continuation continuation, Ref.ObjectRef objectRef, List list, List list2) {
            super(2, continuation);
            this.d = xmlPullParser;
            this.e = objectRef;
            this.f = list;
            this.g = list2;
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((x0) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            x0 x0Var = new x0(this.d, continuation, this.e, this.f, this.g);
            x0Var.c = obj;
            return x0Var;
        }

        /* JADX WARN: Code duplicated, block: B:24:0x006b  */
        /* JADX WARN: Code duplicated, block: B:26:0x0074  */
        /* JADX WARN: Code duplicated, block: B:28:0x0078  */
        /* JADX WARN: Code duplicated, block: B:34:0x0091  */
        /* JADX WARN: Code duplicated, block: B:36:0x0097  */
        /* JADX WARN: Code duplicated, block: B:39:0x009e  */
        /* JADX WARN: Code duplicated, block: B:44:0x00b4 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:47:0x00b9  */
        /* JADX WARN: Code duplicated, block: B:48:0x00c4  */
        /* JADX WARN: Code duplicated, block: B:51:0x00ce  */
        /* JADX WARN: Code duplicated, block: B:53:0x00da A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:57:0x00e9  */
        /* JADX WARN: Code duplicated, block: B:60:0x00f2  */
        /* JADX WARN: Code duplicated, block: B:62:0x0100 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:63:0x0101  */
        /* JADX WARN: Code duplicated, block: B:64:0x0104  */
        /* JADX WARN: Code duplicated, block: B:67:0x010d  */
        /* JADX WARN: Code duplicated, block: B:69:0x0115  */
        /* JADX WARN: Code duplicated, block: B:75:0x0137  */
        /* JADX WARN: Code duplicated, block: B:77:0x013f  */
        /* JADX WARN: Code duplicated, block: B:80:0x0149  */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r10v39, types: [T, java.lang.Object] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:26:0x0074 -> B:79:0x0142). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:29:0x007e -> B:79:0x0142). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:31:0x0086 -> B:79:0x0142). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:37:0x009a -> B:79:0x0142). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:40:0x00a4 -> B:79:0x0142). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:46:0x00b7 -> B:79:0x0142). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:47:0x00b9 -> B:79:0x0142). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:49:0x00ca -> B:79:0x0142). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:52:0x00d8 -> B:54:0x00db). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:58:0x00ef -> B:79:0x0142). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:65:0x010a -> B:79:0x0142). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:74:0x0124 -> B:79:0x0142). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:76:0x013d -> B:79:0x0142). Please report as a decompilation issue!!! */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:69:0x0115
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final java.lang.Object invokeSuspend(java.lang.Object r10) {
            /*
                Method dump skipped, instruction units count: 340
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.k.x0.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.VastParserKt$parseImpressionTag$$inlined$iterateTag$1", f = "VastParser.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class y extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f6879a;
        public int b;
        public /* synthetic */ Object c;
        public final /* synthetic */ XmlPullParser d;
        public final /* synthetic */ Ref.ObjectRef e;
        public final /* synthetic */ Ref.ObjectRef f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public y(XmlPullParser xmlPullParser, Continuation continuation, Ref.ObjectRef objectRef, Ref.ObjectRef objectRef2) {
            super(2, continuation);
            this.d = xmlPullParser;
            this.e = objectRef;
            this.f = objectRef2;
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((y) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            y yVar = new y(this.d, continuation, this.e, this.f);
            yVar.c = obj;
            return yVar;
        }

        /* JADX WARN: Type inference failed for: r0v20, types: [T, java.lang.String] */
        /* JADX WARN: Type inference failed for: r0v22, types: [T, java.lang.String] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            String text;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            CoroutineScopeKt.ensureActive((CoroutineScope) this.c);
            if (k.j(this.d)) {
                this.d.nextTag();
            }
            if (k.h(this.d)) {
                return Unit.INSTANCE;
            }
            if (!k.k(this.d)) {
                throw new XmlPullParserException("iterateCurrentTagEvents call is allowed only for START_TAG event");
            }
            int depth = this.d.getDepth();
            while (this.d.getDepth() >= depth) {
                int depth2 = this.d.getDepth() - depth;
                if (depth2 != 0) {
                    if (depth2 == 1) {
                        k.k(this.d);
                    }
                } else if (k.k(this.d)) {
                    this.e.element = k.b(this.d, "id");
                } else if (k.l(this.d) && (text = this.d.getText()) != null && !StringsKt.isBlank(text)) {
                    String text2 = this.d.getText();
                    Intrinsics.checkNotNullExpressionValue(text2, "text");
                    this.f.element = StringsKt.trim((CharSequence) text2).toString();
                } else if (k.i(this.d)) {
                    return Unit.INSTANCE;
                }
                this.d.next();
            }
            return Unit.INSTANCE;
        }
    }

    @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.VastParserKt", f = "VastParser.kt", i = {0, 0, 0, 0}, l = {941}, m = "parseVideoClicksTag", n = {"clickThrough", "clickTrackingList", "customClickList", "isInLineParent"}, s = {"L$0", "L$1", "L$2", "Z$0"})
    public static final class y0 extends ContinuationImpl {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f6880a;
        public Object b;
        public Object c;
        public Object d;
        public /* synthetic */ Object e;
        public int f;

        public y0(Continuation<? super y0> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.e = obj;
            this.f |= Integer.MIN_VALUE;
            return k.h(null, false, this);
        }
    }

    @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.VastParserKt", f = "VastParser.kt", i = {0, 0}, l = {941}, m = "parseImpressionTag", n = {"id", "impressionUrl"}, s = {"L$0", "L$1"})
    public static final class z extends ContinuationImpl {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object f6881a;
        public Object b;
        public /* synthetic */ Object c;
        public int d;

        public z(Continuation<? super z> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.c = obj;
            this.d |= Integer.MIN_VALUE;
            return k.J(null, this);
        }
    }

    @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.VastParserKt$parseWrapperTag$$inlined$iterateTag$1", f = "VastParser.kt", i = {0, 1, 2, 3, 4}, l = {949, 950, 951, 952, 953}, m = "invokeSuspend", n = {"initialDepth", "initialDepth", "initialDepth", "initialDepth", "initialDepth"}, s = {"I$0", "I$0", "I$0", "I$0", "I$0"})
    public static final class z0 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f6882a;
        public int b;
        public /* synthetic */ Object c;
        public final /* synthetic */ XmlPullParser d;
        public final /* synthetic */ Ref.ObjectRef e;
        public final /* synthetic */ Ref.ObjectRef f;
        public final /* synthetic */ Ref.ObjectRef g;
        public final /* synthetic */ List h;
        public final /* synthetic */ List i;
        public final /* synthetic */ List j;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public z0(XmlPullParser xmlPullParser, Continuation continuation, Ref.ObjectRef objectRef, Ref.ObjectRef objectRef2, Ref.ObjectRef objectRef3, List list, List list2, List list3) {
            super(2, continuation);
            this.d = xmlPullParser;
            this.e = objectRef;
            this.f = objectRef2;
            this.g = objectRef3;
            this.h = list;
            this.i = list2;
            this.j = list3;
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((z0) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            z0 z0Var = new z0(this.d, continuation, this.e, this.f, this.g, this.h, this.i, this.j);
            z0Var.c = obj;
            return z0Var;
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        /* JADX WARN: Code duplicated, block: B:28:0x0083  */
        /* JADX WARN: Code duplicated, block: B:30:0x008d  */
        /* JADX WARN: Code duplicated, block: B:32:0x0091  */
        /* JADX WARN: Code duplicated, block: B:39:0x00aa  */
        /* JADX WARN: Code duplicated, block: B:42:0x00b4  */
        /* JADX WARN: Code duplicated, block: B:44:0x00c0 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:47:0x00c5  */
        /* JADX WARN: Code duplicated, block: B:48:0x00d0  */
        /* JADX WARN: Code duplicated, block: B:51:0x00da  */
        /* JADX WARN: Code duplicated, block: B:53:0x00e6 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:56:0x00eb  */
        /* JADX WARN: Code duplicated, block: B:57:0x00f6  */
        /* JADX WARN: Code duplicated, block: B:60:0x0100  */
        /* JADX WARN: Code duplicated, block: B:62:0x010e A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:63:0x010f  */
        /* JADX WARN: Code duplicated, block: B:64:0x0113  */
        /* JADX WARN: Code duplicated, block: B:67:0x011d  */
        /* JADX WARN: Code duplicated, block: B:69:0x012b A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:70:0x012c  */
        /* JADX WARN: Code duplicated, block: B:71:0x0130  */
        /* JADX WARN: Code duplicated, block: B:74:0x0139  */
        /* JADX WARN: Code duplicated, block: B:76:0x0146 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:78:0x014f  */
        /* JADX WARN: Code duplicated, block: B:80:0x0157  */
        /* JADX WARN: Code duplicated, block: B:82:0x0163  */
        /* JADX WARN: Code duplicated, block: B:83:0x016b  */
        /* JADX WARN: Code duplicated, block: B:84:0x016e  */
        /* JADX WARN: Code duplicated, block: B:86:0x0176  */
        /* JADX WARN: Code duplicated, block: B:92:0x0198  */
        /* JADX WARN: Code duplicated, block: B:94:0x01a0  */
        /* JADX WARN: Code duplicated, block: B:97:0x01aa  */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r11v46, types: [T, java.lang.Object] */
        /* JADX WARN: Type inference failed for: r11v47, types: [T, java.lang.Object] */
        /* JADX WARN: Type inference failed for: r7v4, types: [T, java.lang.Boolean] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:30:0x008d -> B:96:0x01a3). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:33:0x0097 -> B:96:0x01a3). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:35:0x009f -> B:96:0x01a3). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:37:0x00a5 -> B:96:0x01a3). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:40:0x00b0 -> B:96:0x01a3). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:46:0x00c3 -> B:96:0x01a3). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:47:0x00c5 -> B:96:0x01a3). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:49:0x00d6 -> B:96:0x01a3). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:55:0x00e9 -> B:96:0x01a3). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:56:0x00eb -> B:96:0x01a3). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:58:0x00fc -> B:96:0x01a3). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:65:0x0119 -> B:96:0x01a3). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:72:0x0136 -> B:96:0x01a3). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:75:0x0144 -> B:77:0x0147). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:91:0x0185 -> B:96:0x01a3). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:93:0x019e -> B:96:0x01a3). Please report as a decompilation issue!!! */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:82:0x0163
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final java.lang.Object invokeSuspend(java.lang.Object r11) {
            /*
                Method dump skipped, instruction units count: 460
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.k.z0.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Object A(XmlPullParser xmlPullParser, Continuation<? super com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.a> continuation) throws Throwable {
        h hVar;
        Ref.ObjectRef objectRef;
        Ref.ObjectRef objectRef2;
        Ref.ObjectRef objectRef3;
        if (continuation instanceof h) {
            hVar = (h) continuation;
            int i2 = hVar.e;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                hVar.e = i2 - Integer.MIN_VALUE;
            } else {
                hVar = new h(continuation);
            }
        } else {
            hVar = new h(continuation);
        }
        Object obj = hVar.d;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = hVar.e;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            Ref.ObjectRef objectRef4 = new Ref.ObjectRef();
            Ref.ObjectRef objectRef5 = new Ref.ObjectRef();
            Ref.ObjectRef objectRef6 = new Ref.ObjectRef();
            g gVar = new g(xmlPullParser, null, objectRef4, objectRef5, objectRef6);
            hVar.f6845a = objectRef4;
            hVar.b = objectRef5;
            hVar.c = objectRef6;
            hVar.e = 1;
            if (CoroutineScopeKt.coroutineScope(gVar, hVar) == coroutine_suspended) {
                return coroutine_suspended;
            }
            objectRef = objectRef4;
            objectRef2 = objectRef5;
            objectRef3 = objectRef6;
        } else {
            if (i3 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            objectRef3 = (Ref.ObjectRef) hVar.c;
            objectRef2 = (Ref.ObjectRef) hVar.b;
            objectRef = (Ref.ObjectRef) hVar.f6845a;
            ResultKt.throwOnFailure(obj);
        }
        com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.b bVar = (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.b) objectRef3.element;
        if (bVar != null) {
            return new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.a((String) objectRef.element, (Integer) objectRef2.element, bVar);
        }
        return null;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public static final Object B(XmlPullParser xmlPullParser, Continuation<? super List<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.e>> continuation) throws Throwable {
        j jVar;
        if (continuation instanceof j) {
            jVar = (j) continuation;
            int i2 = jVar.c;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                jVar.c = i2 - Integer.MIN_VALUE;
            } else {
                jVar = new j(continuation);
            }
        } else {
            jVar = new j(continuation);
        }
        Object obj = jVar.b;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = jVar.c;
        if (i3 != 0) {
            if (i3 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            List list = (List) jVar.f6849a;
            ResultKt.throwOnFailure(obj);
            return list;
        }
        ResultKt.throwOnFailure(obj);
        ArrayList arrayList = new ArrayList();
        i iVar = new i(xmlPullParser, null, arrayList);
        jVar.f6849a = arrayList;
        jVar.c = 1;
        return CoroutineScopeKt.coroutineScope(iVar, jVar) == coroutine_suspended ? coroutine_suspended : arrayList;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0015  */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Object C(XmlPullParser xmlPullParser, Continuation<? super com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.e> continuation) throws Throwable {
        l lVar;
        Ref.ObjectRef objectRef;
        List list;
        List list2;
        List list3;
        Ref.ObjectRef objectRef2;
        Ref.ObjectRef objectRef3;
        Ref.ObjectRef objectRef4;
        Ref.ObjectRef objectRef5;
        Ref.ObjectRef objectRef6;
        Ref.ObjectRef objectRef7;
        if (continuation instanceof l) {
            lVar = (l) continuation;
            int i2 = lVar.l;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                lVar.l = i2 - Integer.MIN_VALUE;
            } else {
                lVar = new l(continuation);
            }
        } else {
            lVar = new l(continuation);
        }
        Object obj = lVar.k;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = lVar.l;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            Ref.ObjectRef objectRef8 = new Ref.ObjectRef();
            Ref.ObjectRef objectRef9 = new Ref.ObjectRef();
            Ref.ObjectRef objectRef10 = new Ref.ObjectRef();
            Ref.ObjectRef objectRef11 = new Ref.ObjectRef();
            Ref.ObjectRef objectRef12 = new Ref.ObjectRef();
            Ref.ObjectRef objectRef13 = new Ref.ObjectRef();
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            Ref.ObjectRef objectRef14 = new Ref.ObjectRef();
            ArrayList arrayList3 = new ArrayList();
            C0644k c0644k = new C0644k(xmlPullParser, null, objectRef8, objectRef9, objectRef10, objectRef12, objectRef11, objectRef13, arrayList, objectRef14, arrayList2, arrayList3);
            lVar.f6853a = objectRef8;
            lVar.b = objectRef9;
            lVar.c = objectRef10;
            lVar.d = objectRef11;
            lVar.e = objectRef12;
            lVar.f = objectRef13;
            lVar.g = arrayList;
            lVar.h = arrayList2;
            lVar.i = objectRef14;
            lVar.j = arrayList3;
            lVar.l = 1;
            if (CoroutineScopeKt.coroutineScope(c0644k, lVar) == coroutine_suspended) {
                return coroutine_suspended;
            }
            objectRef = objectRef8;
            list = arrayList;
            list2 = arrayList2;
            list3 = arrayList3;
            objectRef2 = objectRef10;
            objectRef3 = objectRef11;
            objectRef4 = objectRef13;
            objectRef5 = objectRef12;
            objectRef6 = objectRef9;
            objectRef7 = objectRef14;
        } else {
            if (i3 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            list3 = (List) lVar.j;
            objectRef7 = (Ref.ObjectRef) lVar.i;
            List list4 = (List) lVar.h;
            List list5 = (List) lVar.g;
            objectRef4 = (Ref.ObjectRef) lVar.f;
            objectRef5 = (Ref.ObjectRef) lVar.e;
            objectRef3 = (Ref.ObjectRef) lVar.d;
            objectRef2 = (Ref.ObjectRef) lVar.c;
            objectRef6 = (Ref.ObjectRef) lVar.b;
            objectRef = (Ref.ObjectRef) lVar.f6853a;
            ResultKt.throwOnFailure(obj);
            list2 = list4;
            list = list5;
        }
        String str = (String) objectRef7.element;
        com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.f fVar = str != null ? new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.f(str, list3) : null;
        if (list2.isEmpty()) {
            return null;
        }
        return new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.e((String) objectRef.element, (Integer) objectRef6.element, (Integer) objectRef2.element, (String) objectRef3.element, (String) objectRef5.element, fVar, (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.c) objectRef4.element, list, list2);
    }

    public static final Object D(XmlPullParser xmlPullParser, Continuation<? super String> continuation) {
        return P(xmlPullParser, continuation);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public static final Object E(XmlPullParser xmlPullParser, Continuation<? super com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.j> continuation) throws Throwable {
        q qVar;
        if (continuation instanceof q) {
            qVar = (q) continuation;
            int i2 = qVar.b;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                qVar.b = i2 - Integer.MIN_VALUE;
            } else {
                qVar = new q(continuation);
            }
        } else {
            qVar = new q(continuation);
        }
        Object objP = qVar.f6863a;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = qVar.b;
        if (i3 == 0) {
            ResultKt.throwOnFailure(objP);
            qVar.b = 1;
            objP = P(xmlPullParser, qVar);
            if (objP == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i3 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(objP);
        }
        String str = (String) objP;
        if (str != null) {
            return new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.j(str);
        }
        return null;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public static final Object F(XmlPullParser xmlPullParser, Continuation<? super com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.k> continuation) throws Throwable {
        r rVar;
        if (continuation instanceof r) {
            rVar = (r) continuation;
            int i2 = rVar.b;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                rVar.b = i2 - Integer.MIN_VALUE;
            } else {
                rVar = new r(continuation);
            }
        } else {
            rVar = new r(continuation);
        }
        Object objP = rVar.f6865a;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = rVar.b;
        if (i3 == 0) {
            ResultKt.throwOnFailure(objP);
            rVar.b = 1;
            objP = P(xmlPullParser, rVar);
            if (objP == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i3 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(objP);
        }
        String str = (String) objP;
        if (str != null) {
            return new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.k(str);
        }
        return null;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Object G(XmlPullParser xmlPullParser, Continuation<? super com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.m> continuation) throws Throwable {
        t tVar;
        Ref.ObjectRef objectRef;
        List list;
        if (continuation instanceof t) {
            tVar = (t) continuation;
            int i2 = tVar.d;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                tVar.d = i2 - Integer.MIN_VALUE;
            } else {
                tVar = new t(continuation);
            }
        } else {
            tVar = new t(continuation);
        }
        Object obj = tVar.c;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = tVar.d;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
            ArrayList arrayList = new ArrayList();
            s sVar = new s(xmlPullParser, null, objectRef2, arrayList);
            tVar.f6869a = objectRef2;
            tVar.b = arrayList;
            tVar.d = 1;
            if (CoroutineScopeKt.coroutineScope(sVar, tVar) == coroutine_suspended) {
                return coroutine_suspended;
            }
            objectRef = objectRef2;
            list = arrayList;
        } else {
            if (i3 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            list = (List) tVar.b;
            objectRef = (Ref.ObjectRef) tVar.f6869a;
            ResultKt.throwOnFailure(obj);
        }
        String str = (String) objectRef.element;
        if (str != null) {
            return new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.m(str, list);
        }
        return null;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0015  */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Object H(XmlPullParser xmlPullParser, Continuation<? super com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.l> continuation) throws Throwable {
        v vVar;
        List list;
        Ref.ObjectRef objectRef;
        Ref.ObjectRef objectRef2;
        Ref.ObjectRef objectRef3;
        Ref.ObjectRef objectRef4;
        Ref.ObjectRef objectRef5;
        Ref.ObjectRef objectRef6;
        Ref.ObjectRef objectRef7;
        Ref.ObjectRef objectRef8;
        if (continuation instanceof v) {
            vVar = (v) continuation;
            int i2 = vVar.k;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                vVar.k = i2 - Integer.MIN_VALUE;
            } else {
                vVar = new v(continuation);
            }
        } else {
            vVar = new v(continuation);
        }
        Object obj = vVar.j;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = vVar.k;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            Ref.ObjectRef objectRef9 = new Ref.ObjectRef();
            Ref.ObjectRef objectRef10 = new Ref.ObjectRef();
            Ref.ObjectRef objectRef11 = new Ref.ObjectRef();
            Ref.ObjectRef objectRef12 = new Ref.ObjectRef();
            Ref.ObjectRef objectRef13 = new Ref.ObjectRef();
            Ref.ObjectRef objectRef14 = new Ref.ObjectRef();
            Ref.ObjectRef objectRef15 = new Ref.ObjectRef();
            Ref.ObjectRef objectRef16 = new Ref.ObjectRef();
            ArrayList arrayList = new ArrayList();
            u uVar = new u(xmlPullParser, null, objectRef9, objectRef10, objectRef11, objectRef12, objectRef13, objectRef14, objectRef16, objectRef15, arrayList);
            vVar.f6873a = objectRef9;
            vVar.b = objectRef10;
            vVar.c = objectRef11;
            vVar.d = objectRef12;
            vVar.e = objectRef13;
            vVar.f = objectRef14;
            vVar.g = objectRef15;
            vVar.h = objectRef16;
            list = arrayList;
            vVar.i = list;
            vVar.k = 1;
            if (CoroutineScopeKt.coroutineScope(uVar, vVar) == coroutine_suspended) {
                return coroutine_suspended;
            }
            objectRef = objectRef9;
            objectRef2 = objectRef10;
            objectRef3 = objectRef16;
            objectRef4 = objectRef13;
            objectRef5 = objectRef15;
            objectRef6 = objectRef11;
            objectRef7 = objectRef14;
            objectRef8 = objectRef12;
        } else {
            if (i3 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            List list2 = (List) vVar.i;
            objectRef3 = (Ref.ObjectRef) vVar.h;
            objectRef5 = (Ref.ObjectRef) vVar.g;
            objectRef7 = (Ref.ObjectRef) vVar.f;
            objectRef4 = (Ref.ObjectRef) vVar.e;
            objectRef8 = (Ref.ObjectRef) vVar.d;
            objectRef6 = (Ref.ObjectRef) vVar.c;
            objectRef2 = (Ref.ObjectRef) vVar.b;
            objectRef = (Ref.ObjectRef) vVar.f6873a;
            ResultKt.throwOnFailure(obj);
            list = list2;
        }
        com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.y yVar = (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.y) objectRef3.element;
        if (yVar != null) {
            return new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.l((String) objectRef.element, (Integer) objectRef2.element, (Integer) objectRef6.element, (String) objectRef8.element, (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.r) objectRef4.element, (Long) objectRef7.element, (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.m) objectRef5.element, list, yVar);
        }
        return null;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public static final Object I(XmlPullParser xmlPullParser, Continuation<? super List<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.l>> continuation) throws Throwable {
        x xVar;
        if (continuation instanceof x) {
            xVar = (x) continuation;
            int i2 = xVar.c;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                xVar.c = i2 - Integer.MIN_VALUE;
            } else {
                xVar = new x(continuation);
            }
        } else {
            xVar = new x(continuation);
        }
        Object obj = xVar.b;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = xVar.c;
        if (i3 != 0) {
            if (i3 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            List list = (List) xVar.f6877a;
            ResultKt.throwOnFailure(obj);
            return list;
        }
        ResultKt.throwOnFailure(obj);
        ArrayList arrayList = new ArrayList();
        w wVar = new w(xmlPullParser, null, arrayList);
        xVar.f6877a = arrayList;
        xVar.c = 1;
        return CoroutineScopeKt.coroutineScope(wVar, xVar) == coroutine_suspended ? coroutine_suspended : arrayList;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Object J(XmlPullParser xmlPullParser, Continuation<? super com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.n> continuation) throws Throwable {
        z zVar;
        Ref.ObjectRef objectRef;
        Ref.ObjectRef objectRef2;
        if (continuation instanceof z) {
            zVar = (z) continuation;
            int i2 = zVar.d;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                zVar.d = i2 - Integer.MIN_VALUE;
            } else {
                zVar = new z(continuation);
            }
        } else {
            zVar = new z(continuation);
        }
        Object obj = zVar.c;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = zVar.d;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            Ref.ObjectRef objectRef3 = new Ref.ObjectRef();
            Ref.ObjectRef objectRef4 = new Ref.ObjectRef();
            y yVar = new y(xmlPullParser, null, objectRef3, objectRef4);
            zVar.f6881a = objectRef3;
            zVar.b = objectRef4;
            zVar.d = 1;
            if (CoroutineScopeKt.coroutineScope(yVar, zVar) == coroutine_suspended) {
                return coroutine_suspended;
            }
            objectRef = objectRef3;
            objectRef2 = objectRef4;
        } else {
            if (i3 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            objectRef2 = (Ref.ObjectRef) zVar.b;
            objectRef = (Ref.ObjectRef) zVar.f6881a;
            ResultKt.throwOnFailure(obj);
        }
        String str = (String) objectRef2.element;
        if (str != null) {
            return new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.n((String) objectRef.element, str);
        }
        return null;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0015  */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Object K(XmlPullParser xmlPullParser, Continuation<? super com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.o> continuation) throws Throwable {
        b0 b0Var;
        Ref.ObjectRef objectRef;
        List list;
        List list2;
        List list3;
        Ref.ObjectRef objectRef2;
        Ref.ObjectRef objectRef3;
        Ref.ObjectRef objectRef4;
        Ref.ObjectRef objectRef5;
        if (continuation instanceof b0) {
            b0Var = (b0) continuation;
            int i2 = b0Var.j;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                b0Var.j = i2 - Integer.MIN_VALUE;
            } else {
                b0Var = new b0(continuation);
            }
        } else {
            b0Var = new b0(continuation);
        }
        Object obj = b0Var.i;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = b0Var.j;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            Ref.ObjectRef objectRef6 = new Ref.ObjectRef();
            Ref.ObjectRef objectRef7 = new Ref.ObjectRef();
            Ref.ObjectRef objectRef8 = new Ref.ObjectRef();
            Ref.ObjectRef objectRef9 = new Ref.ObjectRef();
            Ref.ObjectRef objectRef10 = new Ref.ObjectRef();
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            ArrayList arrayList3 = new ArrayList();
            a0 a0Var = new a0(xmlPullParser, null, objectRef6, objectRef7, objectRef8, objectRef9, objectRef10, arrayList, arrayList2, arrayList3);
            b0Var.f6834a = objectRef6;
            b0Var.b = objectRef7;
            b0Var.c = objectRef8;
            b0Var.d = objectRef9;
            b0Var.e = objectRef10;
            b0Var.f = arrayList;
            b0Var.g = arrayList2;
            b0Var.h = arrayList3;
            b0Var.j = 1;
            if (CoroutineScopeKt.coroutineScope(a0Var, b0Var) == coroutine_suspended) {
                return coroutine_suspended;
            }
            objectRef = objectRef6;
            list = arrayList;
            list2 = arrayList2;
            list3 = arrayList3;
            objectRef2 = objectRef8;
            objectRef3 = objectRef7;
            objectRef4 = objectRef9;
            objectRef5 = objectRef10;
        } else {
            if (i3 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            List list4 = (List) b0Var.h;
            List list5 = (List) b0Var.g;
            List list6 = (List) b0Var.f;
            objectRef5 = (Ref.ObjectRef) b0Var.e;
            objectRef4 = (Ref.ObjectRef) b0Var.d;
            objectRef2 = (Ref.ObjectRef) b0Var.c;
            objectRef3 = (Ref.ObjectRef) b0Var.b;
            objectRef = (Ref.ObjectRef) b0Var.f6834a;
            ResultKt.throwOnFailure(obj);
            list3 = list4;
            list2 = list5;
            list = list6;
        }
        return new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.o((com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.d) objectRef.element, (String) objectRef3.element, (String) objectRef2.element, (String) objectRef4.element, (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.s) objectRef5.element, list, list2, list3);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0015  */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Object L(XmlPullParser xmlPullParser, Continuation<? super com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.q> continuation) throws Throwable {
        f0 f0Var;
        Ref.ObjectRef objectRef;
        Ref.ObjectRef objectRef2;
        Ref.ObjectRef objectRef3;
        Ref.ObjectRef objectRef4;
        Ref.ObjectRef objectRef5;
        Ref.ObjectRef objectRef6;
        Ref.ObjectRef objectRef7;
        Ref.ObjectRef objectRef8;
        Ref.ObjectRef objectRef9;
        Ref.ObjectRef objectRef10;
        Ref.ObjectRef objectRef11;
        Ref.ObjectRef objectRef12;
        if (continuation instanceof f0) {
            f0Var = (f0) continuation;
            int i2 = f0Var.n;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                f0Var.n = i2 - Integer.MIN_VALUE;
            } else {
                f0Var = new f0(continuation);
            }
        } else {
            f0Var = new f0(continuation);
        }
        Object obj = f0Var.m;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = f0Var.n;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            Ref.ObjectRef objectRef13 = new Ref.ObjectRef();
            Ref.ObjectRef objectRef14 = new Ref.ObjectRef();
            Ref.ObjectRef objectRef15 = new Ref.ObjectRef();
            Ref.ObjectRef objectRef16 = new Ref.ObjectRef();
            Ref.ObjectRef objectRef17 = new Ref.ObjectRef();
            Ref.ObjectRef objectRef18 = new Ref.ObjectRef();
            Ref.ObjectRef objectRef19 = new Ref.ObjectRef();
            Ref.ObjectRef objectRef20 = new Ref.ObjectRef();
            Ref.ObjectRef objectRef21 = new Ref.ObjectRef();
            Ref.ObjectRef objectRef22 = new Ref.ObjectRef();
            Ref.ObjectRef objectRef23 = new Ref.ObjectRef();
            Ref.ObjectRef objectRef24 = new Ref.ObjectRef();
            e0 e0Var = new e0(xmlPullParser, null, objectRef14, objectRef15, objectRef16, objectRef17, objectRef18, objectRef19, objectRef20, objectRef21, objectRef22, objectRef23, objectRef24, objectRef13);
            f0Var.f6842a = objectRef13;
            f0Var.b = objectRef14;
            f0Var.c = objectRef15;
            f0Var.d = objectRef16;
            f0Var.e = objectRef17;
            f0Var.f = objectRef18;
            f0Var.g = objectRef19;
            f0Var.h = objectRef20;
            f0Var.i = objectRef21;
            f0Var.j = objectRef22;
            f0Var.k = objectRef23;
            f0Var.l = objectRef24;
            f0Var.n = 1;
            if (CoroutineScopeKt.coroutineScope(e0Var, f0Var) == coroutine_suspended) {
                return coroutine_suspended;
            }
            objectRef = objectRef13;
            objectRef2 = objectRef24;
            objectRef3 = objectRef14;
            objectRef4 = objectRef23;
            objectRef5 = objectRef17;
            objectRef6 = objectRef22;
            objectRef7 = objectRef15;
            objectRef8 = objectRef21;
            objectRef9 = objectRef16;
            objectRef10 = objectRef20;
            objectRef11 = objectRef18;
            objectRef12 = objectRef19;
        } else {
            if (i3 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            objectRef2 = (Ref.ObjectRef) f0Var.l;
            objectRef4 = (Ref.ObjectRef) f0Var.k;
            objectRef6 = (Ref.ObjectRef) f0Var.j;
            objectRef8 = (Ref.ObjectRef) f0Var.i;
            objectRef10 = (Ref.ObjectRef) f0Var.h;
            objectRef12 = (Ref.ObjectRef) f0Var.g;
            objectRef11 = (Ref.ObjectRef) f0Var.f;
            objectRef5 = (Ref.ObjectRef) f0Var.e;
            objectRef9 = (Ref.ObjectRef) f0Var.d;
            objectRef7 = (Ref.ObjectRef) f0Var.c;
            objectRef3 = (Ref.ObjectRef) f0Var.b;
            objectRef = (Ref.ObjectRef) f0Var.f6842a;
            ResultKt.throwOnFailure(obj);
        }
        if (objectRef.element == 0 || objectRef9.element == 0 || objectRef7.element == 0) {
            return null;
        }
        T t2 = objectRef.element;
        Intrinsics.checkNotNull(t2);
        String str = (String) t2;
        String str2 = (String) objectRef3.element;
        T t3 = objectRef7.element;
        Intrinsics.checkNotNull(t3);
        boolean zBooleanValue = ((Boolean) t3).booleanValue();
        T t4 = objectRef9.element;
        Intrinsics.checkNotNull(t4);
        return new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.q(str, str2, zBooleanValue, (String) t4, (Integer) objectRef5.element, (Integer) objectRef11.element, (String) objectRef12.element, (Integer) objectRef10.element, (Integer) objectRef8.element, (Integer) objectRef6.element, (Boolean) objectRef4.element, (String) objectRef2.element);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public static final Object M(XmlPullParser xmlPullParser, Continuation<? super List<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.q>> continuation) throws Throwable {
        h0 h0Var;
        if (continuation instanceof h0) {
            h0Var = (h0) continuation;
            int i2 = h0Var.c;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                h0Var.c = i2 - Integer.MIN_VALUE;
            } else {
                h0Var = new h0(continuation);
            }
        } else {
            h0Var = new h0(continuation);
        }
        Object obj = h0Var.b;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = h0Var.c;
        if (i3 != 0) {
            if (i3 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            List list = (List) h0Var.f6846a;
            ResultKt.throwOnFailure(obj);
            return list;
        }
        ResultKt.throwOnFailure(obj);
        ArrayList arrayList = new ArrayList();
        g0 g0Var = new g0(xmlPullParser, null, arrayList);
        h0Var.f6846a = arrayList;
        h0Var.c = 1;
        return CoroutineScopeKt.coroutineScope(g0Var, h0Var) == coroutine_suspended ? coroutine_suspended : arrayList;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Object N(XmlPullParser xmlPullParser, Continuation<? super com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.s> continuation) throws Throwable {
        j0 j0Var;
        Ref.ObjectRef objectRef;
        Ref.ObjectRef objectRef2;
        if (continuation instanceof j0) {
            j0Var = (j0) continuation;
            int i2 = j0Var.d;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                j0Var.d = i2 - Integer.MIN_VALUE;
            } else {
                j0Var = new j0(continuation);
            }
        } else {
            j0Var = new j0(continuation);
        }
        Object obj = j0Var.c;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = j0Var.d;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            Ref.ObjectRef objectRef3 = new Ref.ObjectRef();
            Ref.ObjectRef objectRef4 = new Ref.ObjectRef();
            i0 i0Var = new i0(xmlPullParser, null, objectRef3, objectRef4);
            j0Var.f6850a = objectRef3;
            j0Var.b = objectRef4;
            j0Var.d = 1;
            if (CoroutineScopeKt.coroutineScope(i0Var, j0Var) == coroutine_suspended) {
                return coroutine_suspended;
            }
            objectRef = objectRef3;
            objectRef2 = objectRef4;
        } else {
            if (i3 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            objectRef2 = (Ref.ObjectRef) j0Var.b;
            objectRef = (Ref.ObjectRef) j0Var.f6850a;
            ResultKt.throwOnFailure(obj);
        }
        if (objectRef.element == 0 && objectRef2.element == 0) {
            return null;
        }
        return new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.s((String) objectRef.element, (String) objectRef2.element);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Object O(XmlPullParser xmlPullParser, Continuation<? super com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.t> continuation) throws Throwable {
        l0 l0Var;
        Ref.ObjectRef objectRef;
        Ref.ObjectRef objectRef2;
        if (continuation instanceof l0) {
            l0Var = (l0) continuation;
            int i2 = l0Var.d;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                l0Var.d = i2 - Integer.MIN_VALUE;
            } else {
                l0Var = new l0(continuation);
            }
        } else {
            l0Var = new l0(continuation);
        }
        Object obj = l0Var.c;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = l0Var.d;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            Ref.ObjectRef objectRef3 = new Ref.ObjectRef();
            Ref.ObjectRef objectRef4 = new Ref.ObjectRef();
            k0 k0Var = new k0(xmlPullParser, null, objectRef4, objectRef3);
            l0Var.f6854a = objectRef3;
            l0Var.b = objectRef4;
            l0Var.d = 1;
            if (CoroutineScopeKt.coroutineScope(k0Var, l0Var) == coroutine_suspended) {
                return coroutine_suspended;
            }
            objectRef = objectRef3;
            objectRef2 = objectRef4;
        } else {
            if (i3 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            objectRef2 = (Ref.ObjectRef) l0Var.b;
            objectRef = (Ref.ObjectRef) l0Var.f6854a;
            ResultKt.throwOnFailure(obj);
        }
        if (objectRef.element == 0 || objectRef2.element == 0) {
            return null;
        }
        T t2 = objectRef.element;
        Intrinsics.checkNotNull(t2);
        T t3 = objectRef2.element;
        Intrinsics.checkNotNull(t3);
        return new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.t((String) t2, (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.i) t3);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public static final Object P(XmlPullParser xmlPullParser, Continuation<? super String> continuation) throws Throwable {
        n0 n0Var;
        Ref.ObjectRef objectRef;
        if (continuation instanceof n0) {
            n0Var = (n0) continuation;
            int i2 = n0Var.c;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                n0Var.c = i2 - Integer.MIN_VALUE;
            } else {
                n0Var = new n0(continuation);
            }
        } else {
            n0Var = new n0(continuation);
        }
        Object obj = n0Var.b;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = n0Var.c;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
            m0 m0Var = new m0(xmlPullParser, null, objectRef2);
            n0Var.f6858a = objectRef2;
            n0Var.c = 1;
            if (CoroutineScopeKt.coroutineScope(m0Var, n0Var) == coroutine_suspended) {
                return coroutine_suspended;
            }
            objectRef = objectRef2;
        } else {
            if (i3 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            objectRef = (Ref.ObjectRef) n0Var.f6858a;
            ResultKt.throwOnFailure(obj);
        }
        return objectRef.element;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public static final Object Q(XmlPullParser xmlPullParser, Continuation<? super List<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.u>> continuation) throws Throwable {
        p0 p0Var;
        if (continuation instanceof p0) {
            p0Var = (p0) continuation;
            int i2 = p0Var.c;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                p0Var.c = i2 - Integer.MIN_VALUE;
            } else {
                p0Var = new p0(continuation);
            }
        } else {
            p0Var = new p0(continuation);
        }
        Object obj = p0Var.b;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = p0Var.c;
        if (i3 != 0) {
            if (i3 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            List list = (List) p0Var.f6862a;
            ResultKt.throwOnFailure(obj);
            return list;
        }
        ResultKt.throwOnFailure(obj);
        ArrayList arrayList = new ArrayList();
        o0 o0Var = new o0(xmlPullParser, null, arrayList);
        p0Var.f6862a = arrayList;
        p0Var.c = 1;
        return CoroutineScopeKt.coroutineScope(o0Var, p0Var) == coroutine_suspended ? coroutine_suspended : arrayList;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Object R(XmlPullParser xmlPullParser, Continuation<? super com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.u> continuation) throws Throwable {
        r0 r0Var;
        Ref.ObjectRef objectRef;
        Ref.ObjectRef objectRef2;
        Ref.ObjectRef objectRef3;
        if (continuation instanceof r0) {
            r0Var = (r0) continuation;
            int i2 = r0Var.e;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                r0Var.e = i2 - Integer.MIN_VALUE;
            } else {
                r0Var = new r0(continuation);
            }
        } else {
            r0Var = new r0(continuation);
        }
        Object obj = r0Var.d;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = r0Var.e;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            Ref.ObjectRef objectRef4 = new Ref.ObjectRef();
            Ref.ObjectRef objectRef5 = new Ref.ObjectRef();
            Ref.ObjectRef objectRef6 = new Ref.ObjectRef();
            q0 q0Var = new q0(xmlPullParser, null, objectRef4, objectRef6, objectRef5);
            r0Var.f6866a = objectRef4;
            r0Var.b = objectRef5;
            r0Var.c = objectRef6;
            r0Var.e = 1;
            if (CoroutineScopeKt.coroutineScope(q0Var, r0Var) == coroutine_suspended) {
                return coroutine_suspended;
            }
            objectRef = objectRef4;
            objectRef2 = objectRef5;
            objectRef3 = objectRef6;
        } else {
            if (i3 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            objectRef3 = (Ref.ObjectRef) r0Var.c;
            objectRef2 = (Ref.ObjectRef) r0Var.b;
            objectRef = (Ref.ObjectRef) r0Var.f6866a;
            ResultKt.throwOnFailure(obj);
        }
        T t2 = objectRef.element;
        if (t2 == 0 || objectRef2.element == 0 || (t2 == com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.v.Progress && objectRef3.element == 0)) {
            return null;
        }
        T t3 = objectRef.element;
        Intrinsics.checkNotNull(t3);
        T t4 = objectRef2.element;
        Intrinsics.checkNotNull(t4);
        return new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.u((com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.v) t3, (String) t4, (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.r) objectRef3.element);
    }

    public static final Object S(XmlPullParser xmlPullParser, Continuation<? super com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.w> continuation) {
        return BuildersKt.withContext(com.moloco.sdk.internal.scheduling.b.a().getIo(), new s0(xmlPullParser, null), continuation);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Object T(XmlPullParser xmlPullParser, Continuation<? super com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.w> continuation) throws Throwable {
        u0 u0Var;
        List list;
        Ref.ObjectRef objectRef;
        Ref.ObjectRef objectRef2;
        if (continuation instanceof u0) {
            u0Var = (u0) continuation;
            int i2 = u0Var.e;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                u0Var.e = i2 - Integer.MIN_VALUE;
            } else {
                u0Var = new u0(continuation);
            }
        } else {
            u0Var = new u0(continuation);
        }
        Object obj = u0Var.d;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = u0Var.e;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            ArrayList arrayList = new ArrayList();
            Ref.ObjectRef objectRef3 = new Ref.ObjectRef();
            Ref.ObjectRef objectRef4 = new Ref.ObjectRef();
            t0 t0Var = new t0(xmlPullParser, null, objectRef3, objectRef4, arrayList);
            u0Var.f6872a = arrayList;
            u0Var.b = objectRef3;
            u0Var.c = objectRef4;
            u0Var.e = 1;
            if (CoroutineScopeKt.coroutineScope(t0Var, u0Var) == coroutine_suspended) {
                return coroutine_suspended;
            }
            list = arrayList;
            objectRef = objectRef3;
            objectRef2 = objectRef4;
        } else {
            if (i3 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            objectRef2 = (Ref.ObjectRef) u0Var.c;
            objectRef = (Ref.ObjectRef) u0Var.b;
            list = (List) u0Var.f6872a;
            ResultKt.throwOnFailure(obj);
        }
        if (list.isEmpty() && objectRef2.element == 0) {
            return null;
        }
        return new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.w(list, (String) objectRef2.element, (String) objectRef.element);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Object U(XmlPullParser xmlPullParser, Continuation<? super com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.z> continuation) throws Throwable {
        w0 w0Var;
        Ref.ObjectRef objectRef;
        Ref.ObjectRef objectRef2;
        if (continuation instanceof w0) {
            w0Var = (w0) continuation;
            int i2 = w0Var.d;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                w0Var.d = i2 - Integer.MIN_VALUE;
            } else {
                w0Var = new w0(continuation);
            }
        } else {
            w0Var = new w0(continuation);
        }
        Object obj = w0Var.c;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = w0Var.d;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            Ref.ObjectRef objectRef3 = new Ref.ObjectRef();
            Ref.ObjectRef objectRef4 = new Ref.ObjectRef();
            v0 v0Var = new v0(xmlPullParser, null, objectRef3, objectRef4);
            w0Var.f6876a = objectRef3;
            w0Var.b = objectRef4;
            w0Var.d = 1;
            if (CoroutineScopeKt.coroutineScope(v0Var, w0Var) == coroutine_suspended) {
                return coroutine_suspended;
            }
            objectRef = objectRef3;
            objectRef2 = objectRef4;
        } else {
            if (i3 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            objectRef2 = (Ref.ObjectRef) w0Var.b;
            objectRef = (Ref.ObjectRef) w0Var.f6876a;
            ResultKt.throwOnFailure(obj);
        }
        String str = (String) objectRef2.element;
        if (str != null) {
            return new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.z((String) objectRef.element, str);
        }
        return null;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0015  */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Object V(XmlPullParser xmlPullParser, Continuation<? super com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.b0> continuation) throws Throwable {
        a1 a1Var;
        List arrayList;
        Ref.ObjectRef objectRef;
        Ref.ObjectRef objectRef2;
        List list;
        List list2;
        Ref.ObjectRef objectRef3;
        if (continuation instanceof a1) {
            a1Var = (a1) continuation;
            int i2 = a1Var.h;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                a1Var.h = i2 - Integer.MIN_VALUE;
            } else {
                a1Var = new a1(continuation);
            }
        } else {
            a1Var = new a1(continuation);
        }
        Object obj = a1Var.g;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = a1Var.h;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            Ref.ObjectRef objectRef4 = new Ref.ObjectRef();
            Ref.ObjectRef objectRef5 = new Ref.ObjectRef();
            Ref.ObjectRef objectRef6 = new Ref.ObjectRef();
            arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            ArrayList arrayList3 = new ArrayList();
            z0 z0Var = new z0(xmlPullParser, null, objectRef5, objectRef4, objectRef6, arrayList, arrayList2, arrayList3);
            a1Var.f6832a = objectRef4;
            a1Var.b = objectRef5;
            a1Var.c = objectRef6;
            a1Var.d = arrayList;
            a1Var.e = arrayList2;
            a1Var.f = arrayList3;
            a1Var.h = 1;
            if (CoroutineScopeKt.coroutineScope(z0Var, a1Var) == coroutine_suspended) {
                return coroutine_suspended;
            }
            objectRef = objectRef4;
            objectRef2 = objectRef5;
            list = arrayList2;
            list2 = arrayList3;
            objectRef3 = objectRef6;
        } else {
            if (i3 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            List list3 = (List) a1Var.f;
            List list4 = (List) a1Var.e;
            List list5 = (List) a1Var.d;
            objectRef3 = (Ref.ObjectRef) a1Var.c;
            objectRef2 = (Ref.ObjectRef) a1Var.b;
            objectRef = (Ref.ObjectRef) a1Var.f6832a;
            ResultKt.throwOnFailure(obj);
            list2 = list3;
            list = list4;
            arrayList = list5;
        }
        String str = (String) objectRef.element;
        if (str != null) {
            return new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.b0(str, (Boolean) objectRef2.element, (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.d) objectRef3.element, arrayList, list, list2);
        }
        return null;
    }

    public static /* synthetic */ void c() {
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Object y(XmlPullParser xmlPullParser, Continuation<? super com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.c> continuation) throws Throwable {
        d dVar;
        Ref.ObjectRef objectRef;
        Ref.ObjectRef objectRef2;
        if (continuation instanceof d) {
            dVar = (d) continuation;
            int i2 = dVar.d;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                dVar.d = i2 - Integer.MIN_VALUE;
            } else {
                dVar = new d(continuation);
            }
        } else {
            dVar = new d(continuation);
        }
        Object obj = dVar.c;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = dVar.d;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            Ref.ObjectRef objectRef3 = new Ref.ObjectRef();
            Ref.ObjectRef objectRef4 = new Ref.ObjectRef();
            c cVar = new c(xmlPullParser, null, objectRef4, objectRef3);
            dVar.f6837a = objectRef3;
            dVar.b = objectRef4;
            dVar.d = 1;
            if (CoroutineScopeKt.coroutineScope(cVar, dVar) == coroutine_suspended) {
                return coroutine_suspended;
            }
            objectRef = objectRef3;
            objectRef2 = objectRef4;
        } else {
            if (i3 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            objectRef2 = (Ref.ObjectRef) dVar.b;
            objectRef = (Ref.ObjectRef) dVar.f6837a;
            ResultKt.throwOnFailure(obj);
        }
        String str = (String) objectRef.element;
        if (str != null) {
            return new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.c(str, (Boolean) objectRef2.element);
        }
        return null;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Object z(XmlPullParser xmlPullParser, Continuation<? super com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.d> continuation) throws Throwable {
        f fVar;
        Ref.ObjectRef objectRef;
        Ref.ObjectRef objectRef2;
        if (continuation instanceof f) {
            fVar = (f) continuation;
            int i2 = fVar.d;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                fVar.d = i2 - Integer.MIN_VALUE;
            } else {
                fVar = new f(continuation);
            }
        } else {
            fVar = new f(continuation);
        }
        Object obj = fVar.c;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = fVar.d;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            Ref.ObjectRef objectRef3 = new Ref.ObjectRef();
            Ref.ObjectRef objectRef4 = new Ref.ObjectRef();
            e eVar = new e(xmlPullParser, null, objectRef4, objectRef3);
            fVar.f6841a = objectRef3;
            fVar.b = objectRef4;
            fVar.d = 1;
            if (CoroutineScopeKt.coroutineScope(eVar, fVar) == coroutine_suspended) {
                return coroutine_suspended;
            }
            objectRef = objectRef3;
            objectRef2 = objectRef4;
        } else {
            if (i3 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            objectRef2 = (Ref.ObjectRef) fVar.b;
            objectRef = (Ref.ObjectRef) fVar.f6841a;
            ResultKt.throwOnFailure(obj);
        }
        if (objectRef.element == 0 && objectRef2.element == 0) {
            return null;
        }
        return new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.d((String) objectRef.element, (String) objectRef2.element);
    }

    public static final boolean h(XmlPullParser xmlPullParser) {
        return xmlPullParser.getEventType() == 1;
    }

    public static final boolean i(XmlPullParser xmlPullParser) {
        return xmlPullParser.getEventType() == 3;
    }

    public static final boolean j(XmlPullParser xmlPullParser) {
        return xmlPullParser.getEventType() == 0;
    }

    public static final boolean k(XmlPullParser xmlPullParser) {
        return xmlPullParser.getEventType() == 2;
    }

    public static final boolean l(XmlPullParser xmlPullParser) {
        return xmlPullParser.getEventType() == 4;
    }

    public static final Integer m(XmlPullParser xmlPullParser) {
        String strB = b(xmlPullParser, "sequence");
        if (strB == null) {
            return null;
        }
        Integer intOrNull = StringsKt.toIntOrNull(strB);
        return Integer.valueOf(intOrNull != null ? intOrNull.intValue() : 999);
    }

    public static final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.r n(XmlPullParser xmlPullParser) {
        String strB = b(xmlPullParser, "skipoffset");
        if (strB != null) {
            return g(strB);
        }
        return null;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0015  */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Object e(XmlPullParser xmlPullParser, boolean z2, Continuation<? super com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.g> continuation) throws Throwable {
        n nVar;
        Ref.ObjectRef objectRef;
        Ref.ObjectRef objectRef2;
        Ref.ObjectRef objectRef3;
        Ref.ObjectRef objectRef4;
        Ref.ObjectRef objectRef5;
        if (continuation instanceof n) {
            nVar = (n) continuation;
            int i2 = nVar.g;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                nVar.g = i2 - Integer.MIN_VALUE;
            } else {
                nVar = new n(continuation);
            }
        } else {
            nVar = new n(continuation);
        }
        Object obj = nVar.f;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = nVar.g;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            Ref.ObjectRef objectRef6 = new Ref.ObjectRef();
            Ref.ObjectRef objectRef7 = new Ref.ObjectRef();
            Ref.ObjectRef objectRef8 = new Ref.ObjectRef();
            Ref.ObjectRef objectRef9 = new Ref.ObjectRef();
            Ref.ObjectRef objectRef10 = new Ref.ObjectRef();
            m mVar = new m(xmlPullParser, null, objectRef6, objectRef7, objectRef8, objectRef9, objectRef10, z2);
            nVar.f6857a = objectRef6;
            nVar.b = objectRef7;
            nVar.c = objectRef8;
            nVar.d = objectRef9;
            nVar.e = objectRef10;
            nVar.g = 1;
            if (CoroutineScopeKt.coroutineScope(mVar, nVar) == coroutine_suspended) {
                return coroutine_suspended;
            }
            objectRef = objectRef6;
            objectRef2 = objectRef7;
            objectRef3 = objectRef10;
            objectRef4 = objectRef8;
            objectRef5 = objectRef9;
        } else {
            if (i3 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            objectRef3 = (Ref.ObjectRef) nVar.e;
            objectRef5 = (Ref.ObjectRef) nVar.d;
            objectRef4 = (Ref.ObjectRef) nVar.c;
            objectRef2 = (Ref.ObjectRef) nVar.b;
            objectRef = (Ref.ObjectRef) nVar.f6857a;
            ResultKt.throwOnFailure(obj);
        }
        com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.h hVar = (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.h) objectRef3.element;
        if (hVar != null) {
            return new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.g((String) objectRef.element, (Integer) objectRef2.element, (String) objectRef4.element, (String) objectRef5.element, hVar);
        }
        return null;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public static final Object f(XmlPullParser xmlPullParser, boolean z2, Continuation<? super List<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.g>> continuation) throws Throwable {
        p pVar;
        if (continuation instanceof p) {
            pVar = (p) continuation;
            int i2 = pVar.c;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                pVar.c = i2 - Integer.MIN_VALUE;
            } else {
                pVar = new p(continuation);
            }
        } else {
            pVar = new p(continuation);
        }
        Object obj = pVar.b;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = pVar.c;
        if (i3 != 0) {
            if (i3 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            List list = (List) pVar.f6861a;
            ResultKt.throwOnFailure(obj);
            return list;
        }
        ResultKt.throwOnFailure(obj);
        ArrayList arrayList = new ArrayList();
        o oVar = new o(xmlPullParser, null, z2, arrayList);
        pVar.f6861a = arrayList;
        pVar.c = 1;
        return CoroutineScopeKt.coroutineScope(oVar, pVar) == coroutine_suspended ? coroutine_suspended : arrayList;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0015  */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Object g(XmlPullParser xmlPullParser, boolean z2, Continuation<? super com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.p> continuation) throws Throwable {
        d0 d0Var;
        Ref.ObjectRef objectRef;
        Ref.ObjectRef objectRef2;
        Ref.ObjectRef objectRef3;
        List list;
        boolean z3;
        List list2;
        List list3;
        Ref.ObjectRef objectRef4;
        if (continuation instanceof d0) {
            d0Var = (d0) continuation;
            int i2 = d0Var.j;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                d0Var.j = i2 - Integer.MIN_VALUE;
            } else {
                d0Var = new d0(continuation);
            }
        } else {
            d0Var = new d0(continuation);
        }
        Object obj = d0Var.i;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = d0Var.j;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            Ref.ObjectRef objectRef5 = new Ref.ObjectRef();
            objectRef = new Ref.ObjectRef();
            Ref.ObjectRef objectRef6 = new Ref.ObjectRef();
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            Ref.ObjectRef objectRef7 = new Ref.ObjectRef();
            ArrayList arrayList3 = new ArrayList();
            c0 c0Var = new c0(xmlPullParser, null, objectRef5, objectRef, objectRef6, arrayList, arrayList2, objectRef7, z2, arrayList3);
            d0Var.b = objectRef5;
            d0Var.c = objectRef;
            d0Var.d = objectRef6;
            d0Var.e = arrayList;
            d0Var.f = arrayList2;
            d0Var.g = objectRef7;
            d0Var.h = arrayList3;
            d0Var.f6838a = z2;
            d0Var.j = 1;
            if (CoroutineScopeKt.coroutineScope(c0Var, d0Var) == coroutine_suspended) {
                return coroutine_suspended;
            }
            objectRef2 = objectRef5;
            objectRef3 = objectRef6;
            list = arrayList3;
            z3 = z2;
            list2 = arrayList2;
            list3 = arrayList;
            objectRef4 = objectRef7;
        } else {
            if (i3 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            z3 = d0Var.f6838a;
            List list4 = (List) d0Var.h;
            objectRef4 = (Ref.ObjectRef) d0Var.g;
            List list5 = (List) d0Var.f;
            List list6 = (List) d0Var.e;
            Ref.ObjectRef objectRef8 = (Ref.ObjectRef) d0Var.d;
            Ref.ObjectRef objectRef9 = (Ref.ObjectRef) d0Var.c;
            objectRef2 = (Ref.ObjectRef) d0Var.b;
            ResultKt.throwOnFailure(obj);
            list = list4;
            objectRef3 = objectRef8;
            objectRef = objectRef9;
            list2 = list5;
            list3 = list6;
        }
        if (z3 && list3.isEmpty()) {
            return null;
        }
        return new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.p((com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.r) objectRef2.element, (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.c) objectRef.element, (Long) objectRef3.element, list3, list2, (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.a0) objectRef4.element, list);
    }

    public static final Integer h(String str) {
        Object objM7904constructorimpl;
        Integer numValueOf;
        int iIntValue;
        try {
            Result.Companion companion = Result.INSTANCE;
            Number number = b.parse(str);
            if (number == null || (iIntValue = (numValueOf = Integer.valueOf((int) (number.floatValue() * 100))).intValue()) < 0 || iIntValue >= 101) {
                numValueOf = null;
            }
            objM7904constructorimpl = Result.m7904constructorimpl(numValueOf);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM7904constructorimpl = Result.m7904constructorimpl(ResultKt.createFailure(th));
        }
        return (Integer) (Result.m7910isFailureimpl(objM7904constructorimpl) ? null : objM7904constructorimpl);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public static final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.v i(String str) {
        switch (str.hashCode()) {
            case -1638835128:
                if (str.equals("midpoint")) {
                    return com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.v.Midpoint;
                }
                return null;
            case -1337830390:
                if (str.equals(EventConstants.THIRD_QUARTILE)) {
                    return com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.v.ThirdQuartile;
                }
                return null;
            case -1001078227:
                if (str.equals("progress")) {
                    return com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.v.Progress;
                }
                return null;
            case -934426579:
                if (str.equals("resume")) {
                    return com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.v.Resume;
                }
                return null;
            case -934318917:
                if (str.equals(EventConstants.REWIND)) {
                    return com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.v.Rewind;
                }
                return null;
            case -840405966:
                if (str.equals("unmute")) {
                    return com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.v.UnMute;
                }
                return null;
            case -599445191:
                if (str.equals("complete")) {
                    return com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.v.Complete;
                }
                return null;
            case -37683395:
                if (str.equals(EventConstants.CLOSE_LINEAR)) {
                    return com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.v.CloseLinear;
                }
                return null;
            case 3363353:
                if (str.equals("mute")) {
                    return com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.v.Mute;
                }
                return null;
            case 3532159:
                if (str.equals(EventConstants.SKIP)) {
                    return com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.v.Skip;
                }
                return null;
            case 106440182:
                if (str.equals("pause")) {
                    return com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.v.Pause;
                }
                return null;
            case 109757538:
                if (str.equals("start")) {
                    return com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.v.Start;
                }
                return null;
            case 560220243:
                if (str.equals(EventConstants.FIRST_QUARTILE)) {
                    return com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.v.FirstQuartile;
                }
                return null;
            case 1778167540:
                if (str.equals(EventConstants.CREATIVE_VIEW)) {
                    return com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.v.CreativeView;
                }
                return null;
            default:
                return null;
        }
    }

    public static final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.j b() {
        return (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.j) f6829a.getValue();
    }

    public static final SimpleDateFormat d() {
        return com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.d0.a("HH:mm:ss.SSS");
    }

    public static final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.i a() {
        return b();
    }

    public static final String b(XmlPullParser xmlPullParser, String str) {
        String attributeValue = xmlPullParser.getAttributeValue(null, str);
        if (attributeValue == null || StringsKt.isBlank(attributeValue)) {
            return null;
        }
        return attributeValue;
    }

    public static final Object a(XmlPullParser xmlPullParser, Function2<? super XmlPullParser, ? super Continuation<? super Unit>, ? extends Object> function2, Function3<? super XmlPullParser, ? super String, ? super Continuation<? super Unit>, ? extends Object> function3, Function2<? super XmlPullParser, ? super Continuation<? super Unit>, ? extends Object> function4, Continuation<? super Unit> continuation) {
        b bVar = new b(xmlPullParser, function2, function3, function4, null);
        InlineMarker.mark(0);
        CoroutineScopeKt.coroutineScope(bVar, continuation);
        InlineMarker.mark(1);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Object h(XmlPullParser xmlPullParser, boolean z2, Continuation<? super com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.a0> continuation) throws Throwable {
        y0 y0Var;
        Ref.ObjectRef objectRef;
        List list;
        List list2;
        if (continuation instanceof y0) {
            y0Var = (y0) continuation;
            int i2 = y0Var.f;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                y0Var.f = i2 - Integer.MIN_VALUE;
            } else {
                y0Var = new y0(continuation);
            }
        } else {
            y0Var = new y0(continuation);
        }
        Object obj = y0Var.e;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = y0Var.f;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            x0 x0Var = new x0(xmlPullParser, null, objectRef2, arrayList, arrayList2);
            y0Var.b = objectRef2;
            y0Var.c = arrayList;
            y0Var.d = arrayList2;
            y0Var.f6880a = z2;
            y0Var.f = 1;
            if (CoroutineScopeKt.coroutineScope(x0Var, y0Var) == coroutine_suspended) {
                return coroutine_suspended;
            }
            objectRef = objectRef2;
            list = arrayList;
            list2 = arrayList2;
        } else {
            if (i3 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            z2 = y0Var.f6880a;
            list2 = (List) y0Var.d;
            list = (List) y0Var.c;
            objectRef = (Ref.ObjectRef) y0Var.b;
            ResultKt.throwOnFailure(obj);
        }
        if (z2 && objectRef.element == 0) {
            return null;
        }
        return new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.a0((com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.z) objectRef.element, list, list2);
    }

    public static final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.r g(String str) {
        Long lF = f(str);
        if (lF != null) {
            return new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.r.b(lF.longValue());
        }
        Integer numH = h(str);
        if (numH != null) {
            return new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.r.a(numH.intValue());
        }
        return null;
    }

    public static final SimpleDateFormat e() {
        return com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.d0.a("HH:mm:ss");
    }

    public static final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.i e(String str) {
        if (StringsKt.startsWith(str, "image/", true)) {
            return com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.i.Image;
        }
        if (StringsKt.contains((CharSequence) str, (CharSequence) "javascript", true)) {
            return com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.i.JS;
        }
        return null;
    }

    public static final Long f(String str) {
        Object objM7904constructorimpl;
        Object objM7904constructorimpl2;
        try {
            Result.Companion companion = Result.INSTANCE;
            Date date = d().parse(str);
            objM7904constructorimpl = Result.m7904constructorimpl(date != null ? Long.valueOf(date.getTime()) : null);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM7904constructorimpl = Result.m7904constructorimpl(ResultKt.createFailure(th));
        }
        if (Result.m7910isFailureimpl(objM7904constructorimpl)) {
            objM7904constructorimpl = null;
        }
        Long l2 = (Long) objM7904constructorimpl;
        if (l2 != null) {
            return l2;
        }
        try {
            Result.Companion companion3 = Result.INSTANCE;
            Date date2 = e().parse(str);
            objM7904constructorimpl2 = Result.m7904constructorimpl(date2 != null ? Long.valueOf(date2.getTime()) : null);
        } catch (Throwable th2) {
            Result.Companion companion4 = Result.INSTANCE;
            objM7904constructorimpl2 = Result.m7904constructorimpl(ResultKt.createFailure(th2));
        }
        return (Long) (Result.m7910isFailureimpl(objM7904constructorimpl2) ? null : objM7904constructorimpl2);
    }
}
