package com.facebook.ads.redexgen.core;

import android.os.ConditionVariable;
import com.facebook.video.heroplayer.exocustom.MetaExoPlayerCustomization;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import com.vungle.ads.internal.protos.Sdk;
import java.io.File;
import java.io.IOException;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.NavigableSet;
import java.util.Random;
import java.util.TreeSet;
import kotlin.io.encoding.Base64;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class PM implements InterfaceC2361eR {
    public static byte[] A0B;
    public static String[] A0C = {"NeG", "ZqLGR0II", "VhFF6A41EB9yMgBx7OOJg2s6vj05dBgU", "OUd", "TlQxLF6czJHpQgPh0ASs4MsenlOz7WyM", "Y9r4lpPydj3ardGD0TB3VIqTqNBHHFXp", "LEOkX0ErtuFRc94XfWhkHm9nJ5sSPp0y", "xJXNeDWsR2XKIfULMtfSdi2pfNk8Ydql"};
    public static final HashSet<File> A0D;
    public long A00;
    public long A01;
    public C2358eO A02;
    public boolean A03;
    public final PW A04;
    public final C2367eX A05;
    public final C2380ek A06;
    public final File A07;
    public final HashMap<String, ArrayList<InterfaceC2360eQ>> A08;
    public final Random A09;
    public final boolean A0A;

    public static String A04(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A0B, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 51);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A07() {
        A0B = new byte[]{Ascii.SYN, 77, 81, 92, 109, 66, 67, 88, 68, 73, 94, Ascii.FF, 127, 69, 65, 92, SignedBytes.MAX_POWER_OF_TWO, 73, 111, 77, 79, 68, 73, Ascii.FF, 69, 66, 95, 88, 77, 66, 79, 73, Ascii.FF, 89, 95, 73, 95, Ascii.FF, 88, 68, 73, Ascii.FF, 74, 67, SignedBytes.MAX_POWER_OF_TWO, 72, 73, 94, Ascii.SYN, Ascii.FF, 40, Ascii.NAK, 2, Base64.padSymbol, 1, Ascii.FF, Ascii.DC4, 8, Ascii.US, 87, 62, 4, 0, Ascii.GS, 1, 8, 46, Ascii.FF, Ascii.SO, 5, 8, 36, 3, 4, Ascii.EM, 67, 100, 108, 105, 96, 97, 37, 113, 106, 37, 102, 119, 96, 100, 113, 96, 37, 80, 76, 65, 37, 99, 108, 105, 96, 63, 37, 90, 125, 117, 112, 121, 120, 60, 104, 115, 60, 127, 110, 121, 125, 104, 121, 60, 127, 125, 127, 116, 121, 60, 73, 85, 88, 38, 60, 57, Ascii.RS, Ascii.SYN, 19, Ascii.SUB, Ascii.ESC, 95, Ascii.VT, Ascii.DLE, 95, Ascii.FS, Ascii.CR, Ascii.SUB, Ascii.RS, Ascii.VT, Ascii.SUB, 95, Ascii.FS, Ascii.RS, Ascii.FS, Ascii.ETB, Ascii.SUB, 95, Ascii.ESC, Ascii.SYN, Ascii.CR, Ascii.SUB, Ascii.FS, Ascii.VT, Ascii.DLE, Ascii.CR, 6, 69, 95, 40, Ascii.SI, 7, 2, Ascii.VT, 10, 78, Ascii.SUB, 1, 78, 7, 0, 7, Ascii.SUB, 7, Ascii.SI, 2, 7, Ascii.DC4, Ascii.VT, 78, Ascii.CR, Ascii.SI, Ascii.CR, 6, Ascii.VT, 78, 7, 0, 10, 7, Ascii.CR, Ascii.VT, Ascii.GS, 84, 78, 88, 127, 119, 114, 123, 122, 62, 106, 113, 62, 114, 119, 109, 106, 62, 125, 127, 125, 118, 123, 62, 122, 119, 108, 123, 125, 106, 113, 108, 103, 62, 120, 119, 114, 123, 109, 36, 62, 32, 7, Ascii.SI, 10, 3, 2, 70, Ascii.DC2, 9, 70, Ascii.DC4, 3, Ascii.VT, 9, Ascii.DLE, 3, 70, 0, Ascii.SI, 10, 3, 70, Ascii.SI, 8, 2, 3, Ascii.RS, 70, 3, 8, Ascii.DC2, Ascii.DC4, Ascii.US, 70, 0, 9, Ascii.DC4, 92, 70, 5, 41, 36, 46, 39, 58, 37, 45, 44, 104, Ascii.GS, 1, Ascii.FF, 104, 46, 33, 36, 45, 114, 104, 86, 108, 104, 117, 105, 96, 70, 100, 102, 109, 96, 70, 97, 122, 103, 124, 123, 114, 53, 124, 123, 113, 112, 109, 53, 115, 124, 121, 112, 53, 115, 116, 124, 121, 112, 113};
    }

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    private void A0G(File file, boolean z, File[] fileArr, Map<String, C2366eW> map) {
        if (fileArr != null) {
            int length = fileArr.length;
            String[] strArr = A0C;
            if (strArr[3].length() != strArr[0].length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A0C;
            strArr2[5] = "JvdtWKMo7eQcxg1pXqeetZZ0pN5yBCYZ";
            strArr2[7] = "AmYndUCprjwVoxFacnTWPGUeuN4MhvHz";
            if (length != 0) {
                for (File file2 : fileArr) {
                    String name = file2.getName();
                    if (z && name.indexOf(46) == -1) {
                        A0G(file2, false, file2.listFiles(), map);
                    } else if (!z || (!C2380ek.A0A(name) && !name.endsWith(A04(0, 4, 11)))) {
                        long j = -1;
                        long j2 = -9223372036854775807L;
                        C2366eW c2366eWRemove = map != null ? map.remove(name) : null;
                        if (c2366eWRemove != null) {
                            j = c2366eWRemove.A01;
                            j2 = c2366eWRemove.A00;
                        }
                        PJ pjA00 = PJ.A00(file2, j, j2, this.A06);
                        if (pjA00 != null) {
                            A0C(pjA00);
                        } else {
                            file2.delete();
                        }
                    }
                }
                return;
            }
        }
        if (z) {
            return;
        }
        file.delete();
    }

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    public final synchronized NavigableSet<C2371eb> A0I(String str) {
        C2378ei c2378eiA0C;
        AbstractC2388es.A08(!this.A03);
        c2378eiA0C = this.A06.A0C(str);
        return (c2378eiA0C == null || c2378eiA0C.A09()) ? new TreeSet() : new TreeSet((Collection) c2378eiA0C.A06());
    }

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    @Override // com.facebook.ads.redexgen.core.InterfaceC2361eR
    public final synchronized long A71(String str, long j, long j2) {
        long j3;
        long j4 = j;
        synchronized (this) {
            long j5 = j2 == -1 ? Long.MAX_VALUE : j4 + j2;
            if (j5 < 0) {
                j5 = Long.MAX_VALUE;
            }
            j3 = 0;
            while (j4 < j5) {
                long jA72 = A72(str, j4, j5 - j4);
                if (jA72 > 0) {
                    j3 += jA72;
                } else {
                    jA72 = -jA72;
                }
                j4 += jA72;
            }
        }
        return j3;
    }

    static {
        A07();
        A0D = new HashSet<>();
    }

    @Deprecated
    public PM(File file, PW pw) {
        this(file, pw, (byte[]) null, false);
    }

    public PM(File file, PW pw, InterfaceC1898Sb interfaceC1898Sb, byte[] bArr, boolean z, boolean z2) {
        C2367eX c2367eX;
        C2380ek c2380ek = new C2380ek(interfaceC1898Sb, file, bArr, z, z2);
        if (interfaceC1898Sb != null && !z2) {
            c2367eX = new C2367eX(interfaceC1898Sb);
        } else {
            c2367eX = null;
        }
        this(file, pw, c2380ek, c2367eX);
    }

    public PM(File file, PW pw, C2380ek c2380ek, C2367eX c2367eX) {
        if (A0H(file)) {
            this.A07 = file;
            this.A04 = pw;
            this.A06 = c2380ek;
            this.A05 = c2367eX;
            this.A08 = new HashMap<>();
            this.A09 = new Random();
            this.A0A = pw.AHp();
            this.A01 = -1L;
            ConditionVariable conditionVariable = new ConditionVariable();
            new C2387er(this, A04(50, 25, 94), conditionVariable).start();
            conditionVariable.block();
            return;
        }
        throw new IllegalStateException(A04(4, 46, 31) + file);
    }

    @Deprecated
    public PM(File file, PW pw, byte[] bArr, boolean z) {
        this(file, pw, null, bArr, z, true);
    }

    public static long A00(File file) throws IOException {
        long jNextLong = new SecureRandom().nextLong();
        long jAbs = jNextLong == Long.MIN_VALUE ? 0L : Math.abs(jNextLong);
        File file2 = new File(file, Long.toString(jAbs, 16) + A04(0, 4, 11));
        if (file2.createNewFile()) {
            return jAbs;
        }
        throw new IOException(A04(75, 27, 54) + file2);
    }

    public static long A01(String str) {
        return Long.parseLong(str.substring(0, str.indexOf(46)), 16);
    }

    public static long A02(File[] fileArr) {
        for (File file : fileArr) {
            String fileName = file.getName();
            if (fileName.endsWith(A04(0, 4, 11))) {
                try {
                    return A01(fileName);
                } catch (NumberFormatException unused) {
                    AbstractC2432fb.A05(A04(297, 11, 54), A04(277, 20, Sdk.SDKError.Reason.INVALID_RI_ENDPOINT_VALUE) + file);
                    file.delete();
                }
            }
        }
        return -1L;
    }

    private PJ A03(String str, long j, long j2) {
        PJ pjA04;
        C2378ei c2378eiA0C = this.A06.A0C(str);
        if (c2378eiA0C == null) {
            return PJ.A03(str, j, j2);
        }
        while (true) {
            pjA04 = c2378eiA0C.A04(j, j2);
            if (!pjA04.A05 || pjA04.A03.length() == pjA04.A01) {
                break;
            }
            A06();
        }
        return pjA04;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A05() {
        if (!this.A07.exists()) {
            try {
                A0F(this.A07);
            } catch (C2358eO e) {
                this.A02 = e;
                return;
            }
        }
        File[] fileArrListFiles = this.A07.listFiles();
        String strA04 = A04(297, 11, 54);
        if (fileArrListFiles == null) {
            String str = A04(200, 38, 45) + this.A07;
            AbstractC2432fb.A05(strA04, str);
            this.A02 = new C2358eO(str);
            return;
        }
        this.A01 = A02(fileArrListFiles);
        if (this.A01 == -1) {
            try {
                this.A01 = A00(this.A07);
            } catch (IOException e2) {
                String str2 = A04(102, 28, 47) + this.A07;
                AbstractC2432fb.A08(strA04, str2, e2);
                this.A02 = new C2358eO(str2, e2);
                return;
            }
        }
        try {
            this.A06.A0J(this.A01);
            if (this.A05 != null) {
                this.A05.A06(this.A01);
                Map<String, C2366eW> mapA05 = this.A05.A05();
                A0G(this.A07, true, fileArrListFiles, mapA05);
                this.A05.A09(mapA05.keySet());
            } else {
                A0G(this.A07, true, fileArrListFiles, null);
            }
            this.A06.A0H();
            try {
                this.A06.A0I();
            } catch (IOException e3) {
                AbstractC2432fb.A08(strA04, A04(308, 25, 38), e3);
            }
        } catch (IOException e4) {
            String str3 = A04(164, 36, 93) + this.A07;
            AbstractC2432fb.A08(strA04, str3, e4);
            this.A02 = new C2358eO(str3, e4);
        }
    }

    private void A06() {
        ArrayList arrayList = new ArrayList();
        Iterator<C2378ei> it = this.A06.A0G().iterator();
        while (it.hasNext()) {
            for (PJ pj : it.next().A06()) {
                if (pj.A03.length() != pj.A01) {
                    arrayList.add(pj);
                }
            }
        }
        for (int i = 0; i < arrayList.size(); i++) {
            A0A((C2371eb) arrayList.get(i));
        }
    }

    private final synchronized void A08() throws C2358eO {
        if (this.A02 != null) {
            throw this.A02;
        }
    }

    private void A09(C2371eb c2371eb) {
        ArrayList<InterfaceC2360eQ> arrayList = this.A08.get(c2371eb.A04);
        if (arrayList != null) {
            for (int i = arrayList.size() - 1; i >= 0; i--) {
                arrayList.get(i).AFC(this, c2371eb);
            }
        }
        this.A04.AFC(this, c2371eb);
    }

    private void A0A(C2371eb c2371eb) {
        C2378ei c2378eiA0C = this.A06.A0C(c2371eb.A04);
        if (c2378eiA0C == null || !c2378eiA0C.A0D(c2371eb)) {
            return;
        }
        this.A00 -= c2371eb.A01;
        if (this.A05 != null) {
            String name = c2371eb.A03.getName();
            try {
                this.A05.A07(name);
            } catch (IOException unused) {
                AbstractC2432fb.A07(A04(297, 11, 54), A04(238, 39, 85) + name);
            }
        }
        this.A06.A0K(c2378eiA0C.A02);
        A09(c2371eb);
    }

    private void A0C(PJ pj) {
        this.A06.A0D(pj.A04).A08(pj);
        this.A00 += pj.A01;
        A0D(pj);
    }

    private void A0D(PJ pj) {
        ArrayList<InterfaceC2360eQ> arrayList = this.A08.get(pj.A04);
        if (arrayList != null) {
            for (int i = arrayList.size() - 1; i >= 0; i--) {
                arrayList.get(i).AFB(this, pj);
            }
        }
        this.A04.AFB(this, pj);
    }

    private void A0E(PJ pj, C2371eb c2371eb) {
        ArrayList<InterfaceC2360eQ> arrayList = this.A08.get(pj.A04);
        if (arrayList != null) {
            for (int i = arrayList.size() - 1; i >= 0; i--) {
                arrayList.get(i).AFD(this, pj, c2371eb);
            }
        }
        this.A04.AFD(this, pj, c2371eb);
    }

    public static void A0F(File file) throws C2358eO {
        if (file.mkdirs() || file.isDirectory()) {
            return;
        }
        String str = A04(130, 34, 76) + file;
        String message = A04(297, 11, 54);
        AbstractC2432fb.A05(message, str);
        throw new C2358eO(str);
    }

    public static synchronized boolean A0H(File file) {
        return A0D.add(file.getAbsoluteFile());
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC2361eR
    public final synchronized void A44(String str, C2383en c2383en) throws C2358eO {
        AbstractC2388es.A08(!this.A03);
        A08();
        this.A06.A0L(str, c2383en);
        try {
            this.A06.A0I();
        } catch (IOException e) {
            throw new C2358eO(e);
        }
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC2361eR
    public final synchronized void A4v(File file, long j) throws C2358eO {
        AbstractC2388es.A08(!this.A03);
        if (file.exists()) {
            if (j == 0) {
                file.delete();
                return;
            }
            PJ pj = (PJ) AbstractC2388es.A01(PJ.A01(file, j, this.A06));
            C2378ei c2378ei = (C2378ei) AbstractC2388es.A01(this.A06.A0C(pj.A04));
            AbstractC2388es.A08(c2378ei.A0B(pj.A02, pj.A01));
            long jA00 = AbstractC2381el.A00(c2378ei.A03());
            if (jA00 != -1) {
                AbstractC2388es.A08(pj.A02 + pj.A01 <= jA00);
            }
            if (this.A05 != null) {
                try {
                    this.A05.A08(file.getName(), pj.A01, pj.A00);
                    A0C(pj);
                    try {
                        this.A06.A0I();
                        notifyAll();
                        return;
                    } catch (IOException e) {
                        throw new C2358eO(e);
                    }
                } catch (IOException e2) {
                    throw new C2358eO(e2);
                }
            }
            A0C(pj);
            this.A06.A0I();
            notifyAll();
            return;
            throw th;
        }
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC2361eR
    public final synchronized long A70() {
        AbstractC2388es.A08(!this.A03);
        return this.A00;
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC2361eR
    @MetaExoPlayerCustomization
    public final synchronized long A72(String str, long j, long j2) {
        C2378ei cachedContent;
        AbstractC2388es.A08(!this.A03);
        if (j2 == -1) {
            j2 = Long.MAX_VALUE;
        }
        cachedContent = this.A06.A0C(str);
        return cachedContent != null ? cachedContent.A02(j, j2) : -j2;
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC2361eR
    public final synchronized InterfaceC2382em A7I(String str) {
        AbstractC2388es.A08(!this.A03);
        return this.A06.A0E(str);
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC2361eR
    public final synchronized void AGo(C2371eb c2371eb) {
        AbstractC2388es.A08(!this.A03);
        C2378ei c2378ei = (C2378ei) AbstractC2388es.A01(this.A06.A0C(c2371eb.A04));
        c2378ei.A07(c2371eb.A02);
        this.A06.A0K(c2378ei.A02);
        notifyAll();
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC2361eR
    public final synchronized void AHa(String str) {
        AbstractC2388es.A08(!this.A03);
        Iterator<C2371eb> it = A0I(str).iterator();
        while (it.hasNext()) {
            A0A(it.next());
        }
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC2361eR
    public final synchronized void AHb(C2371eb c2371eb) {
        AbstractC2388es.A08(!this.A03);
        A0A(c2371eb);
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC2361eR
    public final synchronized File AJD(String str, long lastTouchTimestamp, long j) throws C2358eO {
        C2378ei c2378eiA0C;
        File file;
        AbstractC2388es.A08(!this.A03);
        A08();
        c2378eiA0C = this.A06.A0C(str);
        AbstractC2388es.A01(c2378eiA0C);
        AbstractC2388es.A08(c2378eiA0C.A0B(lastTouchTimestamp, j));
        if (!this.A07.exists()) {
            A0F(this.A07);
            A06();
        }
        this.A04.AFE(this, str, lastTouchTimestamp, j);
        file = new File(this.A07, Integer.toString(this.A09.nextInt(10)));
        if (!file.exists()) {
            A0F(file);
        }
        return PJ.A04(file, c2378eiA0C.A01, lastTouchTimestamp, System.currentTimeMillis());
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC2361eR
    public final synchronized C2371eb AJF(String str, long j, long j2, EnumC2359eP enumC2359eP) throws InterruptedException, C2358eO {
        C2371eb span;
        AbstractC2388es.A08(!this.A03);
        A08();
        while (true) {
            span = AJG(str, j, j2, enumC2359eP);
            if (span == null) {
                wait();
            }
        }
        return span;
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC2361eR
    public final synchronized PJ AJG(String str, long j, long j2, EnumC2359eP enumC2359eP) throws C2358eO {
        AbstractC2388es.A08(!this.A03);
        A08();
        PJ pjA03 = A03(str, j, j2);
        if (pjA03.A05) {
            PJ span = this.A06.A0C(str).A05(pjA03, pjA03.A00, false);
            A0E(pjA03, span);
            return span;
        }
        if (this.A06.A0D(str).A0C(j, pjA03.A01)) {
            return pjA03;
        }
        return null;
    }
}
