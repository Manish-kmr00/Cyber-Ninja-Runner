package com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4;

import com.adjust.sdk.Constants;
import com.fyber.inneractive.sdk.player.exoplayer2.util.z;
import io.appmetrica.analytics.networktasks.internal.CommonUrlParts;

/* JADX INFO: loaded from: classes12.dex */
public abstract class c {
    public static final int A0;
    public static final int B0;
    public static final int C0;
    public static final int D0;
    public static final int E0;
    public static final int F0;
    public static final int G0;
    public static final int H0;
    public static final int I0;
    public static final int J0;
    public static final int K0;
    public static final int L0;
    public static final int M0;
    public static final int N0;
    public static final int O0;
    public static final int l0;
    public static final int m0;
    public static final int n0;
    public static final int o0;
    public static final int p0;
    public static final int q0;
    public static final int r0;
    public static final int s0;
    public static final int t0;
    public static final int u0;
    public static final int v0;
    public static final int w0;
    public static final int x0;
    public static final int y0;
    public static final int z0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f2035a;
    public static final int b = z.a("ftyp");
    public static final int c = z.a("avc1");
    public static final int d = z.a("avc3");
    public static final int e = z.a("hvc1");
    public static final int f = z.a("hev1");
    public static final int g = z.a("s263");
    public static final int h = z.a("d263");
    public static final int i = z.a("mdat");
    public static final int j = z.a("mp4a");
    public static final int k = z.a(".mp3");
    public static final int l = z.a("wave");
    public static final int m = z.a("lpcm");
    public static final int n = z.a("sowt");
    public static final int o = z.a("ac-3");
    public static final int p = z.a("dac3");
    public static final int q = z.a("ec-3");
    public static final int r = z.a("dec3");
    public static final int s = z.a("dtsc");
    public static final int t = z.a("dtsh");
    public static final int u = z.a("dtsl");
    public static final int v = z.a("dtse");
    public static final int w = z.a("ddts");
    public static final int x = z.a("tfdt");
    public static final int y = z.a("tfhd");
    public static final int z = z.a("trex");
    public static final int A = z.a("trun");
    public static final int B = z.a("sidx");
    public static final int C = z.a("moov");
    public static final int D = z.a("mvhd");
    public static final int E = z.a("trak");
    public static final int F = z.a("mdia");
    public static final int G = z.a("minf");
    public static final int H = z.a("stbl");
    public static final int I = z.a("avcC");
    public static final int J = z.a("hvcC");
    public static final int K = z.a("esds");
    public static final int L = z.a("moof");
    public static final int M = z.a("traf");
    public static final int N = z.a("mvex");
    public static final int O = z.a("mehd");
    public static final int P = z.a("tkhd");
    public static final int Q = z.a("edts");
    public static final int R = z.a("elst");
    public static final int S = z.a("mdhd");
    public static final int T = z.a("hdlr");
    public static final int U = z.a("stsd");
    public static final int V = z.a("pssh");
    public static final int W = z.a("sinf");
    public static final int X = z.a("schm");
    public static final int Y = z.a("schi");
    public static final int Z = z.a("tenc");
    public static final int a0 = z.a("encv");
    public static final int b0 = z.a("enca");
    public static final int c0 = z.a("frma");
    public static final int d0 = z.a("saiz");
    public static final int e0 = z.a("saio");
    public static final int f0 = z.a("sbgp");
    public static final int g0 = z.a("sgpd");
    public static final int h0 = z.a(CommonUrlParts.UUID);
    public static final int i0 = z.a("senc");
    public static final int j0 = z.a("pasp");
    public static final int k0 = z.a("TTML");

    static {
        z.a("vmhd");
        l0 = z.a("mp4v");
        m0 = z.a("stts");
        n0 = z.a("stss");
        o0 = z.a("ctts");
        p0 = z.a("stsc");
        q0 = z.a("stsz");
        r0 = z.a("stz2");
        s0 = z.a("stco");
        t0 = z.a("co64");
        u0 = z.a("tx3g");
        v0 = z.a("wvtt");
        w0 = z.a("stpp");
        x0 = z.a("c608");
        y0 = z.a("samr");
        z0 = z.a("sawb");
        A0 = z.a("udta");
        B0 = z.a(Constants.REFERRER_API_META);
        C0 = z.a("ilst");
        D0 = z.a("mean");
        E0 = z.a("name");
        F0 = z.a("data");
        G0 = z.a("emsg");
        H0 = z.a("st3d");
        I0 = z.a("sv3d");
        J0 = z.a("proj");
        K0 = z.a("vp08");
        L0 = z.a("vp09");
        M0 = z.a("vpcC");
        N0 = z.a("camm");
        O0 = z.a("alac");
    }

    public c(int i2) {
        this.f2035a = i2;
    }

    public static String a(int i2) {
        return "" + ((char) ((i2 >> 24) & 255)) + ((char) ((i2 >> 16) & 255)) + ((char) ((i2 >> 8) & 255)) + ((char) (i2 & 255));
    }

    public String toString() {
        return a(this.f2035a);
    }
}
