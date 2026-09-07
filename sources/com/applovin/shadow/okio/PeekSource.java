package com.applovin.shadow.okio;

import com.pubmatic.sdk.openwrap.core.POBConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PeekSource.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\u0018\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u000eH\u0016J\b\u0010\u0014\u001a\u00020\u0015H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/applovin/shadow/okio/PeekSource;", "Lcom/applovin/shadow/okio/Source;", "upstream", "Lcom/applovin/shadow/okio/BufferedSource;", "(Lokio/BufferedSource;)V", "buffer", "Lcom/applovin/shadow/okio/Buffer;", "closed", "", "expectedPos", "", "expectedSegment", "Lcom/applovin/shadow/okio/Segment;", POBConstants.KEY_POSITION, "", "close", "", "read", "sink", "byteCount", "timeout", "Lcom/applovin/shadow/okio/Timeout;", "com.applovin.shadow.okio"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class PeekSource implements Source {
    private final Buffer buffer;
    private boolean closed;
    private int expectedPos;
    private Segment expectedSegment;
    private long pos;
    private final BufferedSource upstream;

    public PeekSource(BufferedSource upstream) {
        Intrinsics.checkNotNullParameter(upstream, "upstream");
        this.upstream = upstream;
        Buffer buffer = upstream.getBuffer();
        this.buffer = buffer;
        this.expectedSegment = buffer.head;
        Segment segment = buffer.head;
        this.expectedPos = segment != null ? segment.pos : -1;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0025, code lost:
    
        if (r3 == r4.pos) goto L15;
     */
    @Override // com.applovin.shadow.okio.Source
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public long read(com.applovin.shadow.okio.Buffer r9, long r10) {
        /*
            r8 = this;
            java.lang.String r0 = "sink"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
            r0 = 0
            int r2 = (r10 > r0 ? 1 : (r10 == r0 ? 0 : -1))
            if (r2 < 0) goto L8a
            boolean r3 = r8.closed
            if (r3 != 0) goto L7e
            com.applovin.shadow.okio.Segment r3 = r8.expectedSegment
            if (r3 == 0) goto L34
            com.applovin.shadow.okio.Buffer r4 = r8.buffer
            com.applovin.shadow.okio.Segment r4 = r4.head
            if (r3 != r4) goto L28
            int r3 = r8.expectedPos
            com.applovin.shadow.okio.Buffer r4 = r8.buffer
            com.applovin.shadow.okio.Segment r4 = r4.head
            kotlin.jvm.internal.Intrinsics.checkNotNull(r4)
            int r4 = r4.pos
            if (r3 != r4) goto L28
            goto L34
        L28:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "Peek source is invalid because upstream source was used"
            java.lang.String r10 = r10.toString()
            r9.<init>(r10)
            throw r9
        L34:
            if (r2 != 0) goto L37
            return r0
        L37:
            com.applovin.shadow.okio.BufferedSource r0 = r8.upstream
            long r1 = r8.pos
            r3 = 1
            long r1 = r1 + r3
            boolean r0 = r0.request(r1)
            if (r0 != 0) goto L47
            r9 = -1
            return r9
        L47:
            com.applovin.shadow.okio.Segment r0 = r8.expectedSegment
            if (r0 != 0) goto L62
            com.applovin.shadow.okio.Buffer r0 = r8.buffer
            com.applovin.shadow.okio.Segment r0 = r0.head
            if (r0 == 0) goto L62
            com.applovin.shadow.okio.Buffer r0 = r8.buffer
            com.applovin.shadow.okio.Segment r0 = r0.head
            r8.expectedSegment = r0
            com.applovin.shadow.okio.Buffer r0 = r8.buffer
            com.applovin.shadow.okio.Segment r0 = r0.head
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0)
            int r0 = r0.pos
            r8.expectedPos = r0
        L62:
            com.applovin.shadow.okio.Buffer r0 = r8.buffer
            long r0 = r0.size()
            long r2 = r8.pos
            long r0 = r0 - r2
            long r10 = java.lang.Math.min(r10, r0)
            com.applovin.shadow.okio.Buffer r2 = r8.buffer
            long r4 = r8.pos
            r3 = r9
            r6 = r10
            r2.copyTo(r3, r4, r6)
            long r0 = r8.pos
            long r0 = r0 + r10
            r8.pos = r0
            return r10
        L7e:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "closed"
            java.lang.String r10 = r10.toString()
            r9.<init>(r10)
            throw r9
        L8a:
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            java.lang.String r0 = "byteCount < 0: "
            r9.<init>(r0)
            java.lang.StringBuilder r9 = r9.append(r10)
            java.lang.String r9 = r9.toString()
            java.lang.IllegalArgumentException r10 = new java.lang.IllegalArgumentException
            java.lang.String r9 = r9.toString()
            r10.<init>(r9)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.shadow.okio.PeekSource.read(com.applovin.shadow.okio.Buffer, long):long");
    }

    @Override // com.applovin.shadow.okio.Source
    /* JADX INFO: renamed from: timeout */
    public Timeout getThis$0() {
        return this.upstream.getThis$0();
    }

    @Override // com.applovin.shadow.okio.Source, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.closed = true;
    }
}
