package io.ktor.utils.io.jvm.javaio;

import kotlin.Metadata;
import kotlinx.coroutines.Job;

/* JADX INFO: compiled from: Blocking.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0011\u0010\u0002\u001a\u00020\u0003H\u0094@ø\u0001\u0000¢\u0006\u0002\u0010\u0004\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0005"}, d2 = {"io/ktor/utils/io/jvm/javaio/OutputAdapter$loop$1", "Lio/ktor/utils/io/jvm/javaio/BlockingAdapter;", "loop", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ktor-io"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class OutputAdapter$loop$1 extends BlockingAdapter {
    final /* synthetic */ OutputAdapter this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    OutputAdapter$loop$1(Job job, OutputAdapter outputAdapter) {
        super(job);
        this.this$0 = outputAdapter;
    }

    /* JADX WARN: Code duplicated, block: B:25:0x0065 A[Catch: all -> 0x0045, TryCatch #0 {all -> 0x0045, blocks: (B:13:0x002d, B:23:0x004c, B:25:0x0065, B:28:0x006e, B:38:0x0091, B:40:0x0097, B:43:0x00ad, B:44:0x00ae, B:46:0x00b2, B:18:0x0041), top: B:60:0x0023 }] */
    /* JADX WARN: Code duplicated, block: B:27:0x006d A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:38:0x0091 A[Catch: all -> 0x0045, TRY_ENTER, TryCatch #0 {all -> 0x0045, blocks: (B:13:0x002d, B:23:0x004c, B:25:0x0065, B:28:0x006e, B:38:0x0091, B:40:0x0097, B:43:0x00ad, B:44:0x00ae, B:46:0x00b2, B:18:0x0041), top: B:60:0x0023 }] */
    /* JADX WARN: Code duplicated, block: B:40:0x0097 A[Catch: all -> 0x0045, TryCatch #0 {all -> 0x0045, blocks: (B:13:0x002d, B:23:0x004c, B:25:0x0065, B:28:0x006e, B:38:0x0091, B:40:0x0097, B:43:0x00ad, B:44:0x00ae, B:46:0x00b2, B:18:0x0041), top: B:60:0x0023 }] */
    /* JADX WARN: Code duplicated, block: B:42:0x00ac  */
    /* JADX WARN: Code duplicated, block: B:43:0x00ad A[Catch: all -> 0x0045, TryCatch #0 {all -> 0x0045, blocks: (B:13:0x002d, B:23:0x004c, B:25:0x0065, B:28:0x006e, B:38:0x0091, B:40:0x0097, B:43:0x00ad, B:44:0x00ae, B:46:0x00b2, B:18:0x0041), top: B:60:0x0023 }] */
    /* JADX WARN: Code duplicated, block: B:44:0x00ae A[Catch: all -> 0x0045, TryCatch #0 {all -> 0x0045, blocks: (B:13:0x002d, B:23:0x004c, B:25:0x0065, B:28:0x006e, B:38:0x0091, B:40:0x0097, B:43:0x00ad, B:44:0x00ae, B:46:0x00b2, B:18:0x0041), top: B:60:0x0023 }] */
    /* JADX WARN: Code duplicated, block: B:46:0x00b2 A[Catch: all -> 0x0045, TRY_LEAVE, TryCatch #0 {all -> 0x0045, blocks: (B:13:0x002d, B:23:0x004c, B:25:0x0065, B:28:0x006e, B:38:0x0091, B:40:0x0097, B:43:0x00ad, B:44:0x00ae, B:46:0x00b2, B:18:0x0041), top: B:60:0x0023 }] */
    /* JADX WARN: Code duplicated, block: B:48:0x00cf A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v19 */
    /* JADX WARN: Type inference failed for: r2v0, types: [int] */
    /* JADX WARN: Type inference failed for: r2v1, types: [io.ktor.utils.io.jvm.javaio.OutputAdapter$loop$1] */
    /* JADX WARN: Type inference failed for: r2v11 */
    /* JADX WARN: Type inference failed for: r2v12 */
    /* JADX WARN: Type inference failed for: r2v13 */
    /* JADX WARN: Type inference failed for: r2v14 */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v3, types: [io.ktor.utils.io.jvm.javaio.OutputAdapter$loop$1, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v4, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v8, types: [io.ktor.utils.io.jvm.javaio.OutputAdapter$loop$1] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:42:0x00ac -> B:23:0x004c). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:45:0x00b0 -> B:23:0x004c). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:47:0x00cd -> B:23:0x004c). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    @Override // io.ktor.utils.io.jvm.javaio.BlockingAdapter
    protected java.lang.Object loop(kotlin.coroutines.Continuation<? super kotlin.Unit> r10) {
        /*
            Method dump skipped, instruction units count: 249
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.jvm.javaio.OutputAdapter$loop$1.loop(kotlin.coroutines.Continuation):java.lang.Object");
    }
}
