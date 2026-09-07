package com.facebook.ads.redexgen.core;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.google.android.exoplayer2.Metadata;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.json.JSONException;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.0z, reason: invalid class name and case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C12330z extends AbstractC1568Et implements Handler.Callback {
    public static byte[] A0C;
    public static String[] A0D = {"6V2fjQztmdn6QcOoRwn3w8YkXQrUwfPb", "gLKOasdWHz2avaAyZSrahHSssLuflmhM", "bR75mNlI8UA", "nHhAnxT", "7tJniP93ZGNDIcJIvO2SJ6", "Untzv3yh6Om2HITwrP06gVfusJ8", "QK6WbRXgXI5pYkNKDtOGNEhzfKJ4rfHy", "3TNgAmzMy9qHvv"};
    public int A00;
    public int A01;
    public long A02;
    public V7 A03;
    public List<ImfDataTrack> A04;
    public boolean A05;
    public final Handler A06;
    public final Bi A07;
    public final InterfaceC2071Zc A08;
    public final InterfaceC2073Ze A09;
    public final long[] A0A;
    public final Metadata[] A0B;

    public static String A00(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A0C, i, i + i2);
        int i4 = 0;
        while (true) {
            int length = bArrCopyOfRange.length;
            if (A0D[1].charAt(8) != 'H') {
                throw new RuntimeException();
            }
            A0D[7] = "nd2M2LhIt1V42b";
            if (i4 >= length) {
                return new String(bArrCopyOfRange);
            }
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 48);
            i4++;
        }
    }

    public static void A02() {
        A0C = new byte[]{-39, 6, 6, 3, 6, -76, -3, 2, -76, 4, -11, 6, 7, -3, 2, -5, -76, -35, -31, -38, -76, 7, 4, -7, -9, -126, -102, -87, -106, -103, -106, -87, -106, -121, -102, -93, -103, -102, -89, -102, -89};
    }

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    private void A07(Metadata metadata, List<Metadata.Entry> list) {
        for (int i = 0; i < metadata.A02(); i++) {
            ZM zmA9R = metadata.A03(i).A9R();
            if (zmA9R == null || !this.A08.AJS(zmA9R)) {
                list.add(metadata.A03(i));
            } else {
                V7 v7A59 = this.A08.A59(zmA9R);
                byte[] bArr = (byte[]) AbstractC2388es.A01(metadata.A03(i).A9Q());
                this.A07.A0A();
                this.A07.A0C(bArr.length);
                ((ByteBuffer) AbstractC2471gE.A0f(this.A07.A02)).put(bArr);
                this.A07.A0B();
                Metadata metadataA5e = v7A59.A5e(this.A07);
                if (metadataA5e != null) {
                    A07(metadataA5e, list);
                }
            }
        }
    }

    static {
        A02();
    }

    public C12330z(InterfaceC2073Ze interfaceC2073Ze, Looper looper) {
        this(interfaceC2073Ze, looper, InterfaceC2071Zc.A00, null);
    }

    public C12330z(InterfaceC2073Ze interfaceC2073Ze, Looper looper, InterfaceC2071Zc interfaceC2071Zc, String str) {
        super(5);
        this.A09 = (InterfaceC2073Ze) AbstractC2388es.A01(interfaceC2073Ze);
        this.A06 = looper == null ? null : AbstractC2471gE.A0c(looper, this);
        this.A08 = (InterfaceC2071Zc) AbstractC2388es.A01(interfaceC2071Zc);
        this.A07 = new Bi();
        this.A0B = new Metadata[5];
        this.A0A = new long[5];
        A08(str);
    }

    private void A01() {
        Arrays.fill(this.A0B, (Object) null);
        this.A01 = 0;
        this.A00 = 0;
    }

    private void A03(long j) {
        if (this.A04 == null) {
            return;
        }
        for (ImfDataTrack imfDataTrack : this.A04) {
            if (imfDataTrack.A01 > j || imfDataTrack.A00 >= j) {
            }
        }
    }

    private void A04(long j) {
        if (this.A04 == null) {
            return;
        }
        long jA01 = O5.A01(j);
        if (this.A06 != null) {
            this.A06.obtainMessage(1, Long.valueOf(jA01)).sendToTarget();
        } else {
            A03(jA01);
        }
    }

    private void A05(Metadata metadata, long j) {
        if (this.A06 != null) {
            this.A06.obtainMessage(0, new Object[]{metadata, Long.valueOf(j)}).sendToTarget();
        } else {
            A06(metadata, j);
        }
    }

    private void A06(Metadata metadata, long j) {
        this.A09.AE8(metadata, j);
    }

    private void A08(String str) {
        if (str != null && !str.isEmpty()) {
            try {
                this.A04 = ImfSpecParser.A01(str);
            } catch (JSONException unused) {
                String strA00 = A00(25, 16, 5);
                String strA01 = A00(0, 25, 100);
                if (A0D[5].length() != 27) {
                    throw new RuntimeException();
                }
                A0D[4] = "hxyGwgOXpwCLhqmkYLEnsz";
                AbstractC2432fb.A05(strA00, strA01);
            }
        }
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC1568Et
    public final void A1Z() {
        A01();
        this.A03 = null;
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC1568Et
    public final void A1a(long j, boolean z) {
        A01();
        this.A05 = false;
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC1568Et
    public final void A1c(ZM[] zmArr, long j, long j2) {
        this.A03 = this.A08.A59(zmArr[0]);
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC2059Yq
    public final boolean AAE() {
        return this.A05;
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC2059Yq
    public final boolean AAT() {
        return true;
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC2059Yq
    public final void AHd(long j, long j2) {
        A04(j);
        if (!this.A05 && this.A00 < 5) {
            this.A07.A0A();
            P6 p6A1U = A1U();
            int iA1R = A1R(p6A1U, this.A07, 0);
            if (iA1R == -4) {
                if (this.A07.A05()) {
                    this.A05 = true;
                } else if (!this.A07.A04()) {
                    this.A07.A00 = this.A02;
                    this.A07.A0B();
                    V7 v7 = (V7) AbstractC2471gE.A0f(this.A03);
                    Bi bi = this.A07;
                    if (A0D[4].length() != 22) {
                        throw new RuntimeException();
                    }
                    A0D[7] = "PBA8I2gAt6QzGP";
                    Metadata metadataA5e = v7.A5e(bi);
                    if (metadataA5e != null) {
                        ArrayList arrayList = new ArrayList(metadataA5e.A02());
                        A07(metadataA5e, arrayList);
                        if (!arrayList.isEmpty()) {
                            Metadata metadata = new Metadata(arrayList);
                            int i = (this.A01 + this.A00) % 5;
                            this.A0B[i] = metadata;
                            this.A0A[i] = this.A07.A01;
                            this.A00++;
                        }
                    }
                }
            } else if (iA1R == -5) {
                this.A02 = ((ZM) AbstractC2388es.A01(p6A1U.A00)).A0M;
            }
        }
        if (this.A00 > 0 && this.A0A[this.A01] <= j) {
            A05((Metadata) AbstractC2471gE.A0f(this.A0B[this.A01]), O5.A01(j - this.A0A[this.A01]));
            this.A0B[this.A01] = null;
            this.A01 = (this.A01 + 1) % 5;
            this.A00--;
        }
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1854Qi
    public final int AJR(ZM zm) {
        if (this.A08.AJS(zm)) {
            return AbstractC1847Qb.A00(AnonymousClass10.A1G(zm) ? 4 : 2);
        }
        return AbstractC1847Qb.A00(0);
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC2059Yq, com.facebook.ads.redexgen.core.InterfaceC1854Qi
    public final String getName() {
        return A00(25, 16, 5);
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        switch (message.what) {
            case 0:
                Object[] objArr = (Object[]) message.obj;
                A06((Metadata) objArr[0], ((Long) objArr[1]).longValue());
                return true;
            case 1:
                Long l = (Long) message.obj;
                String[] strArr = A0D;
                if (strArr[6].charAt(29) != strArr[0].charAt(29)) {
                    throw new RuntimeException();
                }
                A0D[3] = "0fwPxOq";
                A03(l.longValue());
                return true;
            default:
                throw new IllegalStateException();
        }
    }
}
