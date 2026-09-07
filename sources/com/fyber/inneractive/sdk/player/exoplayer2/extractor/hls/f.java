package com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls;

import android.net.Uri;
import com.fyber.inneractive.sdk.player.exoplayer2.source.y;
import java.math.BigInteger;
import java.util.List;
import java.util.Locale;

/* JADX INFO: loaded from: classes11.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.fyber.inneractive.sdk.player.exoplayer2.upstream.h f2008a;
    public final com.fyber.inneractive.sdk.player.exoplayer2.upstream.h b;
    public final o c;
    public final com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.playlist.a[] d;
    public final com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.playlist.k e;
    public final y f;
    public final List g;
    public boolean h;
    public byte[] i;
    public com.fyber.inneractive.sdk.player.exoplayer2.source.g j;
    public com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.playlist.a k;
    public Uri l;
    public byte[] m;
    public String n;
    public byte[] o;
    public com.fyber.inneractive.sdk.player.exoplayer2.trackselection.b p;

    public f(com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.playlist.k kVar, com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.playlist.a[] aVarArr, b bVar, o oVar, List list) {
        this.e = kVar;
        this.d = aVarArr;
        this.c = oVar;
        this.g = list;
        com.fyber.inneractive.sdk.player.exoplayer2.o[] oVarArr = new com.fyber.inneractive.sdk.player.exoplayer2.o[aVarArr.length];
        int[] iArr = new int[aVarArr.length];
        for (int i = 0; i < aVarArr.length; i++) {
            oVarArr[i] = aVarArr[i].b;
            iArr[i] = i;
        }
        this.f2008a = bVar.f2006a.a();
        this.b = bVar.f2006a.a();
        y yVar = new y(oVarArr);
        this.f = yVar;
        this.p = new e(yVar, iArr);
    }

    public final void a(Uri uri, String str, byte[] bArr) {
        byte[] byteArray = new BigInteger(str.toLowerCase(Locale.getDefault()).startsWith("0x") ? str.substring(2) : str, 16).toByteArray();
        byte[] bArr2 = new byte[16];
        int length = byteArray.length > 16 ? byteArray.length - 16 : 0;
        System.arraycopy(byteArray, length, bArr2, (16 - byteArray.length) + length, byteArray.length - length);
        this.l = uri;
        this.m = bArr;
        this.n = str;
        this.o = bArr2;
    }
}
