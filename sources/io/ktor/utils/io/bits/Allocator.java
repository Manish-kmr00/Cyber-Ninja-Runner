package io.ktor.utils.io.bits;

import com.json.m5;
import io.ktor.http.ContentDisposition;
import java.nio.ByteBuffer;
import kotlin.Metadata;

/* JADX INFO: compiled from: MemoryFactory.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\b\u0006\u0010\u0007J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\bH&ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\b\u0006\u0010\tJ\u001d\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0003H&ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\b\r\u0010\u000e\u0082\u0002\u000f\n\u0002\b!\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\u000f"}, d2 = {"Lio/ktor/utils/io/bits/Allocator;", "", "alloc", "Lio/ktor/utils/io/bits/Memory;", ContentDisposition.Parameters.Size, "", "alloc-gFv-Zug", "(I)Ljava/nio/ByteBuffer;", "", "(J)Ljava/nio/ByteBuffer;", "free", "", m5.p, "free-3GNKZMM", "(Ljava/nio/ByteBuffer;)V", "ktor-io"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface Allocator {
    /* JADX INFO: renamed from: alloc-gFv-Zug, reason: not valid java name */
    ByteBuffer mo7622allocgFvZug(int size);

    /* JADX INFO: renamed from: alloc-gFv-Zug, reason: not valid java name */
    ByteBuffer mo7623allocgFvZug(long size);

    /* JADX INFO: renamed from: free-3GNKZMM, reason: not valid java name */
    void mo7624free3GNKZMM(ByteBuffer instance);
}
