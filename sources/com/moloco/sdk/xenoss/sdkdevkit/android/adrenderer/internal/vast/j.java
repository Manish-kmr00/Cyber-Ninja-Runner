package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast;

import android.util.Xml;
import com.moloco.sdk.internal.v;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.w;
import java.io.Closeable;
import java.io.StringReader;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: classes3.dex */
public final class j implements i {

    @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.VastParserImpl", f = "VastParser.kt", i = {}, l = {65}, m = "invoke", n = {}, s = {})
    public static final class a extends ContinuationImpl {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object f6828a;
        public /* synthetic */ Object b;
        public int d;

        public a(Continuation<? super a> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.b = obj;
            this.d |= Integer.MIN_VALUE;
            return j.this.a(null, this);
        }
    }

    /* JADX WARN: Code duplicated, block: B:26:0x0063 A[Catch: all -> 0x002d, TryCatch #3 {all -> 0x002d, blocks: (B:12:0x0029, B:24:0x005f, B:26:0x0063, B:27:0x0069), top: B:44:0x0029 }] */
    /* JADX WARN: Code duplicated, block: B:27:0x0069 A[Catch: all -> 0x002d, TRY_LEAVE, TryCatch #3 {all -> 0x002d, blocks: (B:12:0x0029, B:24:0x005f, B:26:0x0063, B:27:0x0069), top: B:44:0x0029 }] */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.i
    public Object a(String str, Continuation<? super v<w, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.k>> continuation) throws Throwable {
        a aVar;
        Throwable th;
        Closeable closeable;
        w wVar;
        Object aVar2;
        if (continuation instanceof a) {
            aVar = (a) continuation;
            int i = aVar.d;
            if ((i & Integer.MIN_VALUE) != 0) {
                aVar.d = i - Integer.MIN_VALUE;
            } else {
                aVar = new a(continuation);
            }
        } else {
            aVar = new a(continuation);
        }
        Object obj = aVar.b;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = aVar.d;
        try {
            if (i2 != 0) {
                if (i2 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                closeable = (Closeable) aVar.f6828a;
                try {
                    ResultKt.throwOnFailure(obj);
                    wVar = (w) obj;
                    if (wVar != null) {
                        aVar2 = new v.b(wVar);
                    } else {
                        aVar2 = new v.a(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.k.VAST_AD_LOAD_NO_XML_TAG_ERROR);
                    }
                    CloseableKt.closeFinally(closeable, null);
                    return aVar2;
                } catch (Throwable th2) {
                    th = th2;
                    try {
                        throw th;
                    } catch (Throwable th3) {
                        CloseableKt.closeFinally(closeable, th);
                        throw th3;
                    }
                }
            }
            ResultKt.throwOnFailure(obj);
            StringReader stringReader = new StringReader(str);
            try {
                XmlPullParser parser = Xml.newPullParser();
                parser.setFeature("http://xmlpull.org/v1/doc/features.html#process-namespaces", false);
                parser.setInput(stringReader);
                Intrinsics.checkNotNullExpressionValue(parser, "parser");
                aVar.f6828a = stringReader;
                aVar.d = 1;
                Object objS = k.S(parser, aVar);
                if (objS == coroutine_suspended) {
                    return coroutine_suspended;
                }
                obj = objS;
                closeable = stringReader;
                wVar = (w) obj;
                if (wVar != null) {
                    aVar2 = new v.b(wVar);
                } else {
                    aVar2 = new v.a(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.k.VAST_AD_LOAD_NO_XML_TAG_ERROR);
                }
                CloseableKt.closeFinally(closeable, null);
                return aVar2;
            } catch (Throwable th4) {
                th = th4;
                closeable = stringReader;
                throw th;
            }
        } catch (Exception unused) {
            return new v.a(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.k.VAST_AD_LOAD_XML_PARSE_ERROR);
        }
    }
}
