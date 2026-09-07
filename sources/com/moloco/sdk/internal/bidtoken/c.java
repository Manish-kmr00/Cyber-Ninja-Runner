package com.moloco.sdk.internal.bidtoken;

import android.util.Base64;
import com.moloco.sdk.internal.m;
import com.moloco.sdk.internal.v;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class c implements b {

    @DebugMetadata(c = "com.moloco.sdk.internal.bidtoken.VersionPrefixedJWTokenParser$invoke$2", f = "VersionPrefixedJWTokenParser.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super v<com.moloco.sdk.internal.bidtoken.a, m>>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f6071a;
        public final /* synthetic */ String b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(String str, Continuation<? super a> continuation) {
            super(2, continuation);
            this.b = str;
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super v<com.moloco.sdk.internal.bidtoken.a, m>> continuation) {
            return ((a) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new a(this.b, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.f6071a != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            try {
                byte[] bArrDecode = Base64.decode((String) StringsKt.split$default((CharSequence) StringsKt.split$default((CharSequence) this.b, new char[]{AbstractJsonLexerKt.COLON}, false, 0, 6, (Object) null).get(1), new String[]{"."}, false, 0, 6, (Object) null).get(1), 0);
                Intrinsics.checkNotNullExpressionValue(bArrDecode, "decode(jwTokenChunks[1], Base64.DEFAULT)");
                return new v.b(new com.moloco.sdk.internal.bidtoken.a(new JSONObject(StringsKt.decodeToString(bArrDecode)).getLong("exp")));
            } catch (Exception e) {
                return new v.a(new m(e.toString(), -1));
            }
        }
    }

    @Override // com.moloco.sdk.internal.bidtoken.b
    public Object a(String str, Continuation<? super v<com.moloco.sdk.internal.bidtoken.a, m>> continuation) {
        return BuildersKt.withContext(d.f6072a, new a(str, null), continuation);
    }
}
