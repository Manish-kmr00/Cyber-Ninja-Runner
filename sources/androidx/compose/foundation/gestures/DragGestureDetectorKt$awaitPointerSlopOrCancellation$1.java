package androidx.compose.foundation.gestures;

import com.vungle.ads.internal.protos.Sdk;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: compiled from: DragGestureDetector.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.foundation.gestures.DragGestureDetectorKt", f = "DragGestureDetector.kt", i = {0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1}, l = {103, Sdk.SDKError.Reason.OMSDK_DOWNLOAD_JS_ERROR_VALUE}, m = "awaitPointerSlopOrCancellation-gDDlDlE", n = {"$this$awaitPointerSlopOrCancellation_u2dgDDlDlE", "onPointerSlopReached", "pointer", "offset", "touchSlop", "$this$awaitPointerSlopOrCancellation_u2dgDDlDlE", "onPointerSlopReached", "pointer", "dragEvent", "offset", "touchSlop"}, s = {"L$0", "L$1", "L$2", "J$0", "F$0", "L$0", "L$1", "L$2", "L$3", "J$0", "F$0"})
final class DragGestureDetectorKt$awaitPointerSlopOrCancellation$1 extends ContinuationImpl {
    float F$0;
    long J$0;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    /* synthetic */ Object result;

    DragGestureDetectorKt$awaitPointerSlopOrCancellation$1(Continuation<? super DragGestureDetectorKt$awaitPointerSlopOrCancellation$1> continuation) {
        super(continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return DragGestureDetectorKt.m261awaitPointerSlopOrCancellationgDDlDlE(null, 0L, 0, null, this);
    }
}
