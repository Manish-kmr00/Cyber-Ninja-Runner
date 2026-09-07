package com.fyber.inneractive.sdk.player.exoplayer2.source;

import java.io.EOFException;

/* JADX INFO: loaded from: classes14.dex */
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.fyber.inneractive.sdk.player.exoplayer2.extractor.i[] f2132a;
    public final com.fyber.inneractive.sdk.player.exoplayer2.extractor.j b;
    public com.fyber.inneractive.sdk.player.exoplayer2.extractor.i c;

    public n(com.fyber.inneractive.sdk.player.exoplayer2.extractor.i[] iVarArr, com.fyber.inneractive.sdk.player.exoplayer2.extractor.j jVar) {
        this.f2132a = iVarArr;
        this.b = jVar;
    }

    public final com.fyber.inneractive.sdk.player.exoplayer2.extractor.i a(com.fyber.inneractive.sdk.player.exoplayer2.extractor.b bVar) throws A {
        com.fyber.inneractive.sdk.player.exoplayer2.extractor.i iVar = this.c;
        if (iVar != null) {
            return iVar;
        }
        for (com.fyber.inneractive.sdk.player.exoplayer2.extractor.i iVar2 : this.f2132a) {
            try {
                if (iVar2.a(bVar)) {
                    this.c = iVar2;
                    bVar.e = 0;
                    break;
                }
                continue;
            } catch (EOFException unused) {
            } catch (Throwable th) {
                bVar.e = 0;
                throw th;
            }
            bVar.e = 0;
        }
        com.fyber.inneractive.sdk.player.exoplayer2.extractor.i iVar3 = this.c;
        if (iVar3 != null) {
            iVar3.a(this.b);
            return this.c;
        }
        StringBuilder sb = new StringBuilder("None of the available extractors (");
        com.fyber.inneractive.sdk.player.exoplayer2.extractor.i[] iVarArr = this.f2132a;
        int i = com.fyber.inneractive.sdk.player.exoplayer2.util.z.f2192a;
        StringBuilder sb2 = new StringBuilder();
        for (int i2 = 0; i2 < iVarArr.length; i2++) {
            sb2.append(iVarArr[i2].getClass().getSimpleName());
            if (i2 < iVarArr.length - 1) {
                sb2.append(", ");
            }
        }
        throw new A(sb.append(sb2.toString()).append(") could read the stream.").toString());
    }
}
