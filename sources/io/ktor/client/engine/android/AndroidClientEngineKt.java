package io.ktor.client.engine.android;

import com.vungle.ads.internal.protos.Sdk;
import io.ktor.client.call.UnsupportedContentTypeException;
import io.ktor.http.HttpMethod;
import io.ktor.http.content.OutgoingContent;
import io.ktor.utils.io.ByteReadChannel;
import io.ktor.utils.io.CoroutinesKt;
import io.ktor.utils.io.jvm.javaio.WritingKt;
import java.io.Closeable;
import java.io.OutputStream;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.GlobalScope;

/* JADX INFO: compiled from: AndroidClientEngine.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a%\u0010\u0003\u001a\u00020\u0004*\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0080@ø\u0001\u0000¢\u0006\u0002\u0010\n\"\u0014\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u000b"}, d2 = {"METHODS_WITHOUT_BODY", "", "Lio/ktor/http/HttpMethod;", "writeTo", "", "Lio/ktor/http/content/OutgoingContent;", "stream", "Ljava/io/OutputStream;", "callContext", "Lkotlin/coroutines/CoroutineContext;", "(Lio/ktor/http/content/OutgoingContent;Ljava/io/OutputStream;Lkotlin/coroutines/CoroutineContext;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ktor-client-android"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class AndroidClientEngineKt {
    private static final List<HttpMethod> METHODS_WITHOUT_BODY = CollectionsKt.listOf((Object[]) new HttpMethod[]{HttpMethod.INSTANCE.getGet(), HttpMethod.INSTANCE.getHead()});

    /* JADX INFO: renamed from: io.ktor.client.engine.android.AndroidClientEngineKt$writeTo$1, reason: invalid class name */
    /* JADX INFO: compiled from: AndroidClientEngine.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.client.engine.android.AndroidClientEngineKt", f = "AndroidClientEngine.kt", i = {}, l = {116, Sdk.SDKError.Reason.INVALID_RI_ENDPOINT_VALUE}, m = "writeTo", n = {}, s = {})
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return AndroidClientEngineKt.writeTo(null, null, null, this);
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v10 */
    /* JADX WARN: Type inference failed for: r2v12, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r2v19 */
    /* JADX WARN: Type inference failed for: r2v20 */
    /* JADX WARN: Type inference failed for: r2v3, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r2v5, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r2v6 */
    public static final Object writeTo(OutgoingContent outgoingContent, OutputStream outputStream, CoroutineContext coroutineContext, Continuation<? super Unit> continuation) throws Throwable {
        AnonymousClass1 anonymousClass1;
        Closeable closeable;
        if (continuation instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuation;
            if ((anonymousClass1.label & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label -= Integer.MIN_VALUE;
            } else {
                anonymousClass1 = new AnonymousClass1(continuation);
            }
        } else {
            anonymousClass1 = new AnonymousClass1(continuation);
        }
        AnonymousClass1 anonymousClass2 = anonymousClass1;
        Object obj = anonymousClass2.result;
        ?? coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = anonymousClass2.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                OutputStream outputStream2 = outputStream;
                try {
                    OutputStream outputStream3 = outputStream2;
                    if (outgoingContent instanceof OutgoingContent.ByteArrayContent) {
                        outputStream3.write(((OutgoingContent.ByteArrayContent) outgoingContent).getBytes());
                    } else if (outgoingContent instanceof OutgoingContent.ReadChannelContent) {
                        ByteReadChannel from = ((OutgoingContent.ReadChannelContent) outgoingContent).readFrom();
                        anonymousClass2.L$0 = outputStream2;
                        anonymousClass2.label = 1;
                        Object objCopyTo$default = WritingKt.copyTo$default(from, outputStream3, 0L, anonymousClass2, 2, null);
                        if (objCopyTo$default == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        closeable = outputStream2;
                        obj = objCopyTo$default;
                        ((Number) obj).longValue();
                        coroutine_suspended = closeable;
                    } else if (outgoingContent instanceof OutgoingContent.WriteChannelContent) {
                        ByteReadChannel channel = CoroutinesKt.writer$default((CoroutineScope) GlobalScope.INSTANCE, coroutineContext, false, (Function2) new AndroidClientEngineKt$writeTo$2$channel$1(outgoingContent, null), 2, (Object) null).getChannel();
                        anonymousClass2.L$0 = outputStream2;
                        anonymousClass2.label = 2;
                        if (WritingKt.copyTo$default(channel, outputStream3, 0L, anonymousClass2, 2, null) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else if (!(outgoingContent instanceof OutgoingContent.NoContent)) {
                        throw new UnsupportedContentTypeException(outgoingContent);
                    }
                    coroutine_suspended = outputStream2;
                } catch (Throwable th) {
                    th = th;
                    coroutine_suspended = outputStream2;
                    Throwable th2 = th;
                    try {
                        throw th2;
                    } catch (Throwable th3) {
                        CloseableKt.closeFinally(coroutine_suspended, th2);
                        throw th3;
                    }
                }
            } else if (i == 1) {
                Closeable closeable2 = (Closeable) anonymousClass2.L$0;
                ResultKt.throwOnFailure(obj);
                closeable = closeable2;
                ((Number) obj).longValue();
                coroutine_suspended = closeable;
            } else {
                if (i != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                Closeable closeable3 = (Closeable) anonymousClass2.L$0;
                ResultKt.throwOnFailure(obj);
                coroutine_suspended = closeable3;
            }
            Unit unit = Unit.INSTANCE;
            CloseableKt.closeFinally(coroutine_suspended, null);
            return Unit.INSTANCE;
        } catch (Throwable th4) {
            th = th4;
        }
    }
}
