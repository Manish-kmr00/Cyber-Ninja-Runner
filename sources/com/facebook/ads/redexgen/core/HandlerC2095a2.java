package com.facebook.ads.redexgen.core;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import com.google.android.exoplayer2.offline.Download;
import com.google.android.exoplayer2.offline.DownloadRequest;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import com.vungle.ads.internal.protos.Sdk;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.io.encoding.Base64;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.a2, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class HandlerC2095a2 extends Handler {
    public static byte[] A0D;
    public static String[] A0E = {"swfC0ibcmhP3x", "", "k5axwtra5rVBXrxN3oOIFzux7ifCzNXy", "DAMM4", "yyRLod3JIhrL30dabLfmNrZ0B112ujjP", "oQYtaz4vuwyMSJpHXF0VT70PFLFDuJr", "VfARV", "rZqZbPAoR0p6fWqNbno2UZy1XGgudDbH"};
    public boolean A00;
    public int A01;
    public int A02;
    public int A03;
    public int A04;
    public boolean A05;
    public boolean A06;
    public final Handler A07;
    public final HandlerThread A08;
    public final InterfaceC2111aJ A09;
    public final RD A0A;
    public final ArrayList<C2078Zk> A0B;
    public final HashMap<String, RH> A0C;

    public static String A08(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A0D, i, i + i2);
        int i4 = 0;
        while (true) {
            int length = bArrCopyOfRange.length;
            String[] strArr = A0E;
            if (strArr[7].length() != strArr[2].length()) {
                throw new RuntimeException();
            }
            A0E[1] = "";
            if (i4 >= length) {
                return new String(bArrCopyOfRange);
            }
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 25);
            i4++;
        }
    }

    public static void A0D() {
        A0D = new byte[]{81, 93, Ascii.GS, 54, 46, 55, 53, 54, 56, Base64.padSymbol, Ascii.DC4, 56, 55, 56, 62, 60, 43, Ascii.VT, 44, 36, 33, 40, 41, 109, 57, 34, 109, 33, 34, 44, 41, 109, 41, 34, 58, 35, 33, 34, 44, 41, 119, 109, 94, 121, 113, 116, 125, 124, 56, 108, 119, 56, 116, 119, 121, 124, 56, 124, 119, 111, 118, 116, 119, 121, 124, 107, 54, 0, 39, 47, 42, 35, 34, 102, 50, 41, 102, 42, 41, 39, 34, 102, 47, 40, 34, 35, 62, 104, 120, 95, 87, 82, 91, 90, Ascii.RS, 74, 81, Ascii.RS, 76, 91, 83, 81, 72, 91, Ascii.RS, 88, 76, 81, 83, Ascii.RS, 90, 95, 74, 95, 92, 95, 77, 91, 38, 1, 9, Ascii.FF, 5, 4, SignedBytes.MAX_POWER_OF_TWO, Ascii.DC4, Ascii.SI, SignedBytes.MAX_POWER_OF_TWO, Ascii.DC2, 5, Ascii.CR, Ascii.SI, Ascii.SYN, 5, SignedBytes.MAX_POWER_OF_TWO, Ascii.SO, Ascii.SI, Ascii.SO, 5, Ascii.CAN, 9, 19, Ascii.DC4, 5, Ascii.SO, Ascii.DC4, SignedBytes.MAX_POWER_OF_TWO, 4, Ascii.SI, Ascii.ETB, Ascii.SO, Ascii.FF, Ascii.SI, 1, 4, 90, SignedBytes.MAX_POWER_OF_TWO, Ascii.CAN, 63, 55, 50, 59, 58, 126, 42, 49, 126, 45, 59, 42, 126, 51, 63, 48, 43, 63, 50, 126, 45, 42, 49, 46, 126, 44, 59, 63, 45, 49, 48, 83, 116, 124, 121, 112, 113, 53, 97, 122, 53, 102, 112, 97, 53, 120, 116, 123, 96, 116, 121, 53, 102, 97, 122, 101, 53, 103, 112, 116, 102, 122, 123, 47, 53, 81, 118, 126, 123, 114, 115, 55, 99, 120, 55, 98, 103, 115, 118, 99, 114, 55, 126, 121, 115, 114, 111, 57, 67, 118, 100, 124, 55, 113, 118, 126, 123, 114, 115, 45, 55};
    }

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException: Index 17 out of bounds for length 17
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.startVar(DebugInfoParser.java:203)
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.process(DebugInfoParser.java:125)
    	at jadx.plugins.input.dex.sections.DexCodeReader.getDebugInfo(DexCodeReader.java:122)
    	at jadx.core.dex.nodes.MethodNode.getDebugInfo(MethodNode.java:656)
    	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.visit(DebugInfoAttachVisitor.java:38)
     */
    private void A0Q(DownloadRequest downloadRequest, int i) {
        C2078Zk c2078ZkA06 = A06(downloadRequest.A02, true);
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (c2078ZkA06 != null) {
            A03(C2098a5.A00(c2078ZkA06, downloadRequest, i, jCurrentTimeMillis));
        } else {
            A03(new C2078Zk(downloadRequest, i != 0 ? 1 : 0, jCurrentTimeMillis, jCurrentTimeMillis, -1L, i, 0));
        }
        A0B();
    }

    static {
        A0D();
    }

    public HandlerC2095a2(HandlerThread handlerThread, RD rd, InterfaceC2111aJ interfaceC2111aJ, Handler handler, int i, int i2, boolean z) {
        super(handlerThread.getLooper());
        this.A08 = handlerThread;
        this.A0A = rd;
        this.A09 = interfaceC2111aJ;
        this.A07 = handler;
        this.A02 = i;
        this.A03 = i2;
        this.A05 = z;
        this.A0B = new ArrayList<>();
        this.A0C = new HashMap<>();
    }

    public static int A00(C2078Zk c2078Zk, C2078Zk c2078Zk2) {
        return AbstractC2471gE.A08(c2078Zk.A05, c2078Zk2.A05);
    }

    private int A02(String str) {
        for (int i = 0; i < i; i++) {
            if (this.A0B.get(i).A07.A02.equals(str)) {
                return i;
            }
        }
        return -1;
    }

    private C2078Zk A03(C2078Zk c2078Zk) {
        AbstractC2388es.A08((c2078Zk.A02 == 3 || c2078Zk.A02 == 4) ? false : true);
        int iA02 = A02(c2078Zk.A07.A02);
        if (iA02 == -1) {
            this.A0B.add(c2078Zk);
            Collections.sort(this.A0B, new C2094a1());
        } else {
            boolean z = c2078Zk.A05 != this.A0B.get(iA02).A05;
            this.A0B.set(iA02, c2078Zk);
            if (z) {
                Collections.sort(this.A0B, new C2094a1());
            }
        }
        try {
            this.A0A.AGN(c2078Zk);
        } catch (IOException e) {
            AbstractC2432fb.A08(A08(2, 15, 64), A08(Sdk.SDKError.Reason.STALE_CACHED_RESPONSE_VALUE, 23, 14), e);
        }
        this.A07.obtainMessage(2, new C2093a0(c2078Zk, false, new ArrayList(this.A0B), null)).sendToTarget();
        return c2078Zk;
    }

    private C2078Zk A04(C2078Zk c2078Zk, int i, int i2) {
        AbstractC2388es.A08((i == 3 || i == 4) ? false : true);
        return A03(A05(c2078Zk, i, i2));
    }

    public static C2078Zk A05(C2078Zk c2078Zk, int i, int i2) {
        return new C2078Zk(c2078Zk.A07, i, c2078Zk.A05, System.currentTimeMillis(), c2078Zk.A04, i2, 0, c2078Zk.A00);
    }

    private C2078Zk A06(String str, boolean z) {
        int iA02 = A02(str);
        if (iA02 != -1) {
            return this.A0B.get(iA02);
        }
        if (z) {
            try {
                return this.A0A.A7g(str);
            } catch (IOException e) {
                AbstractC2432fb.A08(A08(2, 15, 64), A08(17, 25, 84) + str, e);
                return null;
            }
        }
        return null;
    }

    private RH A07(RH rh, C2078Zk c2078Zk) {
        if (rh != null) {
            AbstractC2388es.A08(!rh.A06);
            rh.A05(false);
            if (A0E[0].length() == 13) {
                A0E[1] = "";
                return rh;
            }
        } else {
            if (!A0U()) {
                return null;
            }
            int i = this.A01;
            String[] strArr = A0E;
            if (strArr[3].length() == strArr[6].length()) {
                String[] strArr2 = A0E;
                strArr2[7] = "clCTtan1hGsiTpzOnYvuaYS7HeVgH65T";
                strArr2[2] = "s0FRQ6WZgjKqiR2A5bQGQkiYgEO3ktzW";
                if (i < this.A02) {
                    C2078Zk c2078ZkA04 = A04(c2078Zk, 2, 0);
                    RH rh2 = new RH(c2078ZkA04.A07, this.A09.A5C(c2078ZkA04.A07), c2078ZkA04.A00, false, this.A03, this);
                    this.A0C.put(c2078ZkA04.A07.A02, rh2);
                    int i2 = this.A01;
                    this.A01 = i2 + 1;
                    if (i2 == 0) {
                        sendEmptyMessageDelayed(11, 5000L);
                    }
                    rh2.start();
                    return rh2;
                }
                return null;
            }
        }
        throw new RuntimeException();
    }

    private void A09() {
        Iterator<RH> it = this.A0C.values().iterator();
        while (it.hasNext()) {
            it.next().A05(true);
        }
        try {
            this.A0A.AIU();
        } catch (IOException e) {
            AbstractC2432fb.A08(A08(2, 15, 64), A08(Sdk.SDKError.Reason.STALE_CACHED_RESPONSE_VALUE, 23, 14), e);
        }
        this.A0B.clear();
        this.A08.quit();
        synchronized (this) {
            this.A00 = true;
            notifyAll();
        }
    }

    private void A0A() {
        String strA08 = A08(2, 15, 64);
        ArrayList arrayList = new ArrayList();
        try {
            RO roA7h = this.A0A.A7h(3, 4);
            while (roA7h.A01()) {
                try {
                    arrayList.add(roA7h.A00());
                } catch (Throwable th) {
                    if (roA7h != null) {
                        try {
                            roA7h.close();
                        } catch (Throwable th2) {
                            th.addSuppressed(th2);
                        }
                    }
                    throw th;
                }
            }
            if (roA7h != null) {
                roA7h.close();
            }
        } catch (IOException unused) {
            AbstractC2432fb.A05(strA08, A08(42, 25, 1));
        }
        for (int i = 0; i < this.A0B.size(); i++) {
            this.A0B.set(i, A05(this.A0B.get(i), 5, 0));
        }
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            this.A0B.add(A05((C2078Zk) arrayList.get(i2), 5, 0));
        }
        List<Download> terminalDownloads = this.A0B;
        Collections.sort(terminalDownloads, new C2094a1());
        try {
            this.A0A.AIv();
        } catch (IOException e) {
            AbstractC2432fb.A08(strA08, A08(Sdk.SDKError.Reason.STALE_CACHED_RESPONSE_VALUE, 23, 14), e);
        }
        ArrayList arrayList2 = new ArrayList(this.A0B);
        for (int i3 = 0; i3 < this.A0B.size(); i3++) {
            this.A07.obtainMessage(2, new C2093a0(this.A0B.get(i3), false, arrayList2, null)).sendToTarget();
        }
        A0B();
    }

    private void A0B() {
        int i = 0;
        for (int i2 = 0; i2 < accumulatingDownloadTaskCount; i2++) {
            C2078Zk download = this.A0B.get(i2);
            RH rhA07 = this.A0C.get(download.A07.A02);
            int accumulatingDownloadTaskCount = download.A02;
            switch (accumulatingDownloadTaskCount) {
                case 0:
                    rhA07 = A07(rhA07, download);
                    break;
                case 1:
                    A0M(rhA07);
                    break;
                case 2:
                    AbstractC2388es.A01(rhA07);
                    A0P(rhA07, download, i);
                    break;
                case 3:
                case 4:
                case 6:
                default:
                    throw new IllegalStateException();
                case 5:
                case 7:
                    A0O(rhA07, download);
                    break;
            }
            if (rhA07 != null && !rhA07.A06) {
                i++;
            }
        }
    }

    private void A0C() {
        for (int i = 0; i < i; i++) {
            C2078Zk c2078Zk = this.A0B.get(i);
            if (c2078Zk.A02 == 2) {
                try {
                    this.A0A.AGN(c2078Zk);
                } catch (IOException e) {
                    AbstractC2432fb.A08(A08(2, 15, 64), A08(Sdk.SDKError.Reason.STALE_CACHED_RESPONSE_VALUE, 23, 14), e);
                }
            }
        }
        sendEmptyMessageDelayed(11, 5000L);
    }

    private void A0E(int i) {
        this.A04 = i;
        RO roA7h = null;
        try {
            try {
                this.A0A.AIU();
                roA7h = this.A0A.A7h(0, 1, 2, 5, 7);
                while (roA7h.A01()) {
                    this.A0B.add(roA7h.A00());
                }
            } catch (IOException e) {
                AbstractC2432fb.A08(A08(2, 15, 64), A08(67, 21, 95), e);
                this.A0B.clear();
            }
            AbstractC2471gE.A10(roA7h);
            this.A07.obtainMessage(0, new ArrayList(this.A0B)).sendToTarget();
            A0B();
        } catch (Throwable th) {
            AbstractC2471gE.A10(roA7h);
            throw th;
        }
    }

    private void A0F(int i) {
        this.A02 = i;
        A0B();
    }

    private void A0G(int i) {
        this.A03 = i;
    }

    private void A0H(int i) {
        this.A04 = i;
        A0B();
    }

    private void A0I(C2078Zk c2078Zk) {
        if (c2078Zk.A02 == 7) {
            int i = c2078Zk.A03 == 0 ? 0 : 1;
            int state = c2078Zk.A03;
            A04(c2078Zk, i, state);
            A0B();
            return;
        }
        this.A0B.remove(A02(c2078Zk.A07.A02));
        try {
            this.A0A.AHX(c2078Zk.A07.A02);
        } catch (IOException unused) {
            AbstractC2432fb.A05(A08(2, 15, 64), A08(88, 30, 39));
        }
        this.A07.obtainMessage(2, new C2093a0(c2078Zk, true, new ArrayList(this.A0B), null)).sendToTarget();
    }

    private void A0J(C2078Zk c2078Zk, int i) {
        if (i == 0) {
            if (c2078Zk.A02 == 1) {
                String[] strArr = A0E;
                if (strArr[7].length() != strArr[2].length()) {
                    throw new RuntimeException();
                }
                A0E[1] = "";
                A04(c2078Zk, 0, 0);
                return;
            }
            return;
        }
        int i2 = c2078Zk.A03;
        if (A0E[0].length() != 13) {
            A0E[5] = "gmNkl1fxoG4c55uAK63V6czVgHJPrQL";
            if (i == i2) {
                return;
            }
        } else {
            A0E[1] = "";
            if (i == i2) {
                return;
            }
        }
        int i3 = c2078Zk.A02;
        if (i3 == 0 || i3 == 2) {
            i3 = 1;
        }
        A03(new C2078Zk(c2078Zk.A07, i3, c2078Zk.A05, System.currentTimeMillis(), c2078Zk.A04, i, 0, c2078Zk.A00));
    }

    private void A0K(C2078Zk c2078Zk, Exception exc) {
        C2078Zk c2078Zk2 = new C2078Zk(c2078Zk.A07, exc == null ? 3 : 4, c2078Zk.A05, System.currentTimeMillis(), c2078Zk.A04, c2078Zk.A03, exc == null ? 0 : 1, c2078Zk.A00);
        String[] strArr = A0E;
        if (strArr[3].length() != strArr[6].length()) {
            throw new RuntimeException();
        }
        A0E[0] = "r5gLw2w7Harrz";
        this.A0B.remove(A02(c2078Zk2.A07.A02));
        try {
            this.A0A.AGN(c2078Zk2);
        } catch (IOException e) {
            AbstractC2432fb.A08(A08(2, 15, 64), A08(Sdk.SDKError.Reason.STALE_CACHED_RESPONSE_VALUE, 23, 14), e);
        }
        this.A07.obtainMessage(2, new C2093a0(c2078Zk2, false, new ArrayList(this.A0B), exc)).sendToTarget();
    }

    private void A0L(RH rh) {
        String str = rh.A04.A02;
        this.A0C.remove(str);
        boolean z = rh.A06;
        if (z) {
            this.A06 = false;
        } else {
            int i = this.A01 - 1;
            this.A01 = i;
            if (i == 0) {
                removeMessages(11);
            }
        }
        if (!rh.A08) {
            Exception exc = rh.A01;
            if (exc != null) {
                StringBuilder sb = new StringBuilder();
                String downloadId = A08(246, 13, 14);
                StringBuilder sbAppend = sb.append(downloadId).append(rh.A04);
                String downloadId2 = A08(0, 2, 100);
                String string = sbAppend.append(downloadId2).append(z).toString();
                String downloadId3 = A08(2, 15, 64);
                AbstractC2432fb.A08(downloadId3, string, exc);
            }
            C2078Zk c2078Zk = (C2078Zk) AbstractC2388es.A01(A06(str, false));
            switch (c2078Zk.A02) {
                case 2:
                    AbstractC2388es.A08(!z);
                    A0K(c2078Zk, exc);
                    break;
                case 3:
                case 4:
                case 6:
                default:
                    throw new IllegalStateException();
                case 5:
                case 7:
                    AbstractC2388es.A08(z);
                    A0I(c2078Zk);
                    break;
            }
            A0B();
            return;
        }
        A0B();
    }

    private void A0M(RH rh) {
        if (rh != null) {
            AbstractC2388es.A08(!rh.A06);
            rh.A05(false);
        }
    }

    private void A0N(RH rh, long j) {
        C2078Zk c2078Zk = (C2078Zk) AbstractC2388es.A01(A06(rh.A04.A02, false));
        if (j == c2078Zk.A04 || j == -1) {
            return;
        }
        A03(new C2078Zk(c2078Zk.A07, c2078Zk.A02, c2078Zk.A05, System.currentTimeMillis(), j, c2078Zk.A03, c2078Zk.A01, c2078Zk.A00));
    }

    private void A0O(RH rh, C2078Zk c2078Zk) {
        if (rh != null) {
            if (rh.A06) {
                return;
            }
            String[] strArr = A0E;
            if (strArr[3].length() != strArr[6].length()) {
                throw new RuntimeException();
            }
            A0E[0] = "cabchplwOtJyL";
            rh.A05(false);
            return;
        }
        if (this.A06) {
            return;
        }
        RH rh2 = new RH(c2078Zk.A07, this.A09.A5C(c2078Zk.A07), c2078Zk.A00, true, this.A03, this);
        this.A0C.put(c2078Zk.A07.A02, rh2);
        this.A06 = true;
        rh2.start();
    }

    private void A0P(RH rh, C2078Zk c2078Zk, int i) {
        AbstractC2388es.A08(!rh.A06);
        if (!A0U() || i >= this.A02) {
            A04(c2078Zk, 0, 0);
            rh.A05(false);
        }
    }

    private void A0R(String str) {
        C2078Zk c2078ZkA06 = A06(str, true);
        if (c2078ZkA06 == null) {
            AbstractC2432fb.A05(A08(2, 15, 64), A08(Sdk.SDKError.Reason.PROTOBUF_SERIALIZATION_ERROR_VALUE, 39, Sdk.SDKError.Reason.TPAT_ERROR_VALUE) + str);
        } else {
            A04(c2078ZkA06, 5, 0);
            A0B();
        }
    }

    private void A0S(String str, int i) {
        String strA08 = A08(2, 15, 64);
        if (str == null) {
            for (int i2 = 0; i2 < this.A0B.size(); i2++) {
                A0J(this.A0B.get(i2), i);
            }
            try {
                this.A0A.AIw(i);
            } catch (IOException e) {
                AbstractC2432fb.A08(strA08, A08(157, 32, 71), e);
            }
        } else {
            C2078Zk c2078ZkA06 = A06(str, false);
            if (c2078ZkA06 != null) {
                A0J(c2078ZkA06, i);
            } else {
                try {
                    this.A0A.AIx(str, i);
                } catch (IOException e2) {
                    AbstractC2432fb.A08(strA08, A08(189, 34, 12) + str, e2);
                }
            }
        }
        A0B();
    }

    private void A0T(boolean z) {
        this.A05 = z;
        A0B();
    }

    private boolean A0U() {
        return !this.A05 && this.A04 == 0;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) throws Throwable {
        if (BQ.A02(this)) {
            return;
        }
        boolean z = true;
        try {
            switch (message.what) {
                case 0:
                    A0E(message.arg1);
                    break;
                case 1:
                    A0T(message.arg1 != 0);
                    break;
                case 2:
                    A0H(message.arg1);
                    break;
                case 3:
                    A0S((String) message.obj, message.arg1);
                    break;
                case 4:
                    A0F(message.arg1);
                    break;
                case 5:
                    A0G(message.arg1);
                    break;
                case 6:
                    A0Q((DownloadRequest) message.obj, message.arg1);
                    break;
                case 7:
                    A0R((String) message.obj);
                    break;
                case 8:
                    A0A();
                    break;
                case 9:
                    A0L((RH) message.obj);
                    z = false;
                    break;
                case 10:
                    A0N((RH) message.obj, AbstractC2471gE.A0N(message.arg1, message.arg2));
                    return;
                case 11:
                    A0C();
                    return;
                case 12:
                    A09();
                    return;
                default:
                    throw new IllegalStateException();
            }
            this.A07.obtainMessage(1, z ? 1 : 0, this.A0C.size()).sendToTarget();
        } catch (Throwable th) {
            BQ.A00(th, this);
        }
    }
}
