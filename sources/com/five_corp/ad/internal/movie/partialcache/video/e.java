package com.five_corp.ad.internal.movie.partialcache.video;

import android.media.MediaCodec;
import android.media.MediaFormat;
import android.os.Handler;
import android.view.Surface;
import com.five_corp.ad.internal.movie.partialcache.mediacodec.h;
import com.five_corp.ad.internal.movie.partialcache.mediacodec.i;
import com.five_corp.ad.internal.movie.partialcache.v1;
import com.five_corp.ad.internal.o;
import com.five_corp.ad.internal.p;
import java.nio.ByteBuffer;
import java.util.ArrayDeque;

/* JADX INFO: loaded from: classes10.dex */
public final class e implements com.five_corp.ad.internal.movie.partialcache.mediacodec.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final MediaFormat f1504a;
    public final Handler b;
    public final c c;
    public h e;
    public long g;
    public int f = 1;
    public long h = 0;
    public final ArrayDeque d = new ArrayDeque();

    public e(MediaFormat mediaFormat, Handler handler, c cVar) {
        this.f1504a = mediaFormat;
        this.b = handler;
        this.c = cVar;
    }

    public final void a(Surface surface, long j) {
        if (this.f != 1) {
            return;
        }
        this.f = 2;
        try {
            h hVar = new h(MediaCodec.createDecoderByType(this.f1504a.getString("mime")), this, this.b.getLooper());
            this.e = hVar;
            this.g = j;
            hVar.a(this.f1504a, surface);
        } catch (Exception e) {
            c cVar = this.c;
            cVar.c.a(new o(p.r0, null, e, null));
        }
    }

    @Override // com.five_corp.ad.internal.movie.partialcache.mediacodec.b
    public final void a(com.five_corp.ad.internal.movie.partialcache.mediacodec.c cVar, MediaFormat mediaFormat) {
    }

    @Override // com.five_corp.ad.internal.movie.partialcache.mediacodec.b
    public final void a(o oVar) {
        int i = this.f;
        if (i == 5 || i == 6) {
            return;
        }
        this.f = 5;
        c cVar = this.c;
        cVar.c.a(new o(p.q5, null, null, oVar));
    }

    @Override // com.five_corp.ad.internal.movie.partialcache.mediacodec.b
    public final boolean a(h hVar, com.five_corp.ad.internal.movie.partialcache.mediacodec.a aVar) {
        v1 v1VarB;
        int i = this.f;
        if (i == 1 || i == 5 || i == 6 || this.e != hVar || (v1VarB = this.c.b.f.b()) == null) {
            return false;
        }
        try {
            ByteBuffer byteBuffer = aVar.b;
            ByteBuffer byteBufferWrap = ByteBuffer.wrap(v1VarB.f1499a, v1VarB.b, v1VarB.c);
            byteBuffer.rewind();
            while (byteBufferWrap.position() < byteBufferWrap.limit()) {
                int i2 = byteBufferWrap.getInt();
                byteBuffer.put(new byte[]{0, 0, 0, 1});
                byteBuffer.put(byteBufferWrap.array(), byteBufferWrap.position(), i2);
                byteBufferWrap.position(byteBufferWrap.position() + i2);
            }
            int iPosition = byteBuffer.position();
            byteBuffer.position(0);
            byteBuffer.limit(iPosition);
            this.e.a(aVar, v1VarB, iPosition);
        } catch (Exception e) {
            a(new o(p.r5, null, e, null));
        }
        return true;
    }

    @Override // com.five_corp.ad.internal.movie.partialcache.mediacodec.b
    public final void a(com.five_corp.ad.internal.movie.partialcache.mediacodec.c cVar, i iVar) {
        int i = this.f;
        if (i == 1 || i == 5 || i == 6 || this.e != cVar || iVar.b()) {
            return;
        }
        if (this.f != 2) {
            if (!this.d.isEmpty() || iVar.a() >= this.h) {
                this.d.addLast(iVar);
                return;
            } else {
                this.e.a(iVar, true);
                return;
            }
        }
        if (iVar.a() < this.g) {
            this.e.a(iVar, false);
            return;
        }
        this.e.a(iVar, true);
        this.f = 3;
        c cVar2 = this.c;
        cVar2.getClass();
        cVar2.f1502a.post(new a(cVar2, new b(cVar2)));
    }

    public final void a(long j) {
        i iVar;
        int i = this.f;
        if (i == 3 || i == 4) {
            this.f = 4;
            this.h = j;
            if (this.d.isEmpty() || ((i) this.d.peekFirst()).a() >= j) {
                return;
            }
            Object objPollFirst = this.d.pollFirst();
            while (true) {
                iVar = (i) objPollFirst;
                if (this.d.isEmpty() || ((i) this.d.peekFirst()).a() >= j) {
                    break;
                }
                this.e.a(iVar, false);
                objPollFirst = this.d.pollFirst();
            }
            this.e.a(iVar, true);
        }
    }

    public final void a() {
        int i = this.f;
        if (i == 1 || i == 6) {
            return;
        }
        if (i == 5) {
            this.f = 6;
        } else {
            this.f = 1;
        }
        h hVar = this.e;
        if (hVar != null) {
            hVar.a();
            this.e = null;
        }
        this.d.clear();
    }
}
