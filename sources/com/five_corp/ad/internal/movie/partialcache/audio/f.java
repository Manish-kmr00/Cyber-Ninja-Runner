package com.five_corp.ad.internal.movie.partialcache.audio;

import android.media.MediaCodec;
import android.media.MediaFormat;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.view.Surface;
import com.five_corp.ad.internal.movie.partialcache.v1;
import com.five_corp.ad.internal.o;
import com.five_corp.ad.internal.p;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayDeque;

/* JADX INFO: loaded from: classes7.dex */
public final class f implements com.five_corp.ad.internal.movie.partialcache.mediacodec.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Looper f1470a;
    public final c b;
    public final MediaFormat e;
    public com.five_corp.ad.internal.movie.partialcache.mediacodec.h f;
    public k g;
    public long h;
    public int d = 1;
    public final ArrayDeque c = new ArrayDeque();

    public f(MediaFormat mediaFormat, Looper looper, c cVar) {
        this.e = mediaFormat;
        this.f1470a = looper;
        this.b = cVar;
    }

    @Override // com.five_corp.ad.internal.movie.partialcache.mediacodec.b
    public final void a(o oVar) {
        int i = this.d;
        if (i == 5 || i == 6) {
            return;
        }
        this.d = 5;
        c cVar = this.b;
        cVar.c.a(new o(p.d5, null, null, oVar));
    }

    public final void b() {
        int i = this.d;
        if (i == 1 || i == 6) {
            return;
        }
        if (i == 5) {
            this.d = 6;
        } else {
            this.d = 1;
        }
        com.five_corp.ad.internal.movie.partialcache.mediacodec.h hVar = this.f;
        if (hVar != null) {
            hVar.a();
            this.f = null;
        }
        k kVar = this.g;
        if (kVar != null) {
            Handler handler = kVar.c;
            if (handler != null) {
                handler.postAtFrontOfQueue(new j(kVar));
            }
            this.g = null;
        }
        this.c.clear();
    }

    @Override // com.five_corp.ad.internal.movie.partialcache.mediacodec.b
    public final boolean a(com.five_corp.ad.internal.movie.partialcache.mediacodec.h hVar, com.five_corp.ad.internal.movie.partialcache.mediacodec.a aVar) {
        v1 v1VarB;
        int i = this.d;
        if (i == 1 || i == 5 || i == 6 || this.f != hVar || (v1VarB = this.b.b.d.b()) == null) {
            return false;
        }
        ByteBuffer byteBuffer = aVar.b;
        byteBuffer.rewind();
        byteBuffer.put(v1VarB.f1499a, v1VarB.b, v1VarB.c);
        byteBuffer.rewind();
        this.f.a(aVar, v1VarB, v1VarB.c);
        return true;
    }

    @Override // com.five_corp.ad.internal.movie.partialcache.mediacodec.b
    public final void a(com.five_corp.ad.internal.movie.partialcache.mediacodec.c cVar, com.five_corp.ad.internal.movie.partialcache.mediacodec.i iVar) {
        boolean z;
        int i = this.d;
        if (i == 1 || i == 5 || i == 6 || this.f != cVar || iVar.b()) {
            return;
        }
        if (this.d == 2) {
            this.d = 3;
            z = true;
        } else {
            z = false;
        }
        if (this.c.isEmpty() && iVar.a() < this.h) {
            k kVar = this.g;
            int i2 = iVar.f1490a;
            MediaCodec.BufferInfo bufferInfo = iVar.b;
            ByteBuffer byteBufferA = this.f.a(i2);
            byteBufferA.position(bufferInfo.offset);
            int i3 = bufferInfo.size;
            byte[] bArr = new byte[i3];
            byteBufferA.get(bArr, 0, i3);
            this.f.a(iVar, false);
            kVar.c.post(new i(kVar, bArr));
        } else {
            this.c.addLast(new e(1, iVar, null));
        }
        if (z) {
            c cVar2 = this.b;
            cVar2.getClass();
            cVar2.f1467a.post(new a(cVar2, new b(cVar2)));
        }
    }

    @Override // com.five_corp.ad.internal.movie.partialcache.mediacodec.b
    public final void a(com.five_corp.ad.internal.movie.partialcache.mediacodec.c cVar, MediaFormat mediaFormat) {
        int i = this.d;
        if (i == 1 || i == 5 || i == 6 || this.f != cVar) {
            return;
        }
        if (this.c.isEmpty()) {
            k kVar = this.g;
            kVar.c.post(new h(kVar, mediaFormat));
        } else {
            this.c.addLast(new e(2, null, mediaFormat));
        }
    }

    public final void a() {
        if (this.d != 1) {
            return;
        }
        this.d = 2;
        this.h = 0L;
        this.c.clear();
        try {
            com.five_corp.ad.internal.movie.partialcache.mediacodec.h hVar = new com.five_corp.ad.internal.movie.partialcache.mediacodec.h(MediaCodec.createDecoderByType(this.e.getString("mime")), this, this.f1470a);
            this.f = hVar;
            hVar.a(this.e, (Surface) null);
            k kVar = new k(this);
            this.g = kVar;
            MediaFormat mediaFormat = this.e;
            if (kVar.f != 1) {
                return;
            }
            HandlerThread handlerThread = new HandlerThread(kVar.f1474a);
            kVar.d = handlerThread;
            handlerThread.start();
            Handler handler = new Handler(kVar.d.getLooper());
            kVar.c = handler;
            kVar.f = 2;
            handler.post(new h(kVar, mediaFormat));
        } catch (IOException e) {
            c cVar = this.b;
            cVar.c.a(new o(p.c5, null, e, null));
        }
    }

    public final void a(long j) {
        int i = this.d;
        if (i == 3 || i == 4) {
            this.d = 4;
            this.h = j + 1000000;
            while (!this.c.isEmpty()) {
                e eVar = (e) this.c.peekFirst();
                if ((eVar.f1469a == 2 ? -1L : eVar.b.a()) >= this.h) {
                    return;
                }
                e eVar2 = (e) this.c.pollFirst();
                if (eVar2.f1469a == 2) {
                    k kVar = this.g;
                    kVar.c.post(new h(kVar, eVar2.c));
                } else {
                    k kVar2 = this.g;
                    com.five_corp.ad.internal.movie.partialcache.mediacodec.i iVar = eVar2.b;
                    int i2 = iVar.f1490a;
                    MediaCodec.BufferInfo bufferInfo = iVar.b;
                    ByteBuffer byteBufferA = this.f.a(i2);
                    byteBufferA.position(bufferInfo.offset);
                    int i3 = bufferInfo.size;
                    byte[] bArr = new byte[i3];
                    byteBufferA.get(bArr, 0, i3);
                    this.f.a(iVar, false);
                    kVar2.c.post(new i(kVar2, bArr));
                }
            }
        }
    }
}
