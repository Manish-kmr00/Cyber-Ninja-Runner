package com.facebook.ads.redexgen.core;

import android.util.SparseArray;
import java.util.Arrays;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class YE {
    public static String[] A0I = {"fyMCesn94ZUaX1", "xXHQkaDx7xTG2skhDWNaR7J9v1Ihzxpo", "7Oq", "kTtuH2eqfZJTb6bh0egtONV7U1bP5J07", "s1a1xO39uTTuSTjW0X6bCmtUL1vt7rUE", "YPZNwn", "K3ka9u", "uQ65ovfoFxKalB"};
    public int A00;
    public int A01;
    public long A02;
    public long A03;
    public long A04;
    public long A05;
    public boolean A08;
    public boolean A09;
    public boolean A0A;
    public final InterfaceC1957Uo A0F;
    public final boolean A0G;
    public final boolean A0H;
    public final SparseArray<C1948Uc> A0D = new SparseArray<>();
    public final SparseArray<Ub> A0C = new SparseArray<>();
    public YD A06 = new YD();
    public YD A07 = new YD();
    public byte[] A0B = new byte[128];
    public final C1951Uf A0E = new C1951Uf(this.A0B, 0, 0);

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    public final void A05(byte[] bArr, int i, int i2) {
        if (this.A08) {
            int i3 = i2 - i;
            if (this.A0B.length < this.A00 + i3) {
                this.A0B = Arrays.copyOf(this.A0B, (this.A00 + i3) * 2);
            }
            System.arraycopy(bArr, i, this.A0B, this.A00, i3);
            this.A00 += i3;
            this.A0E.A08(this.A0B, 0, this.A00);
            if (this.A0E.A0B(8)) {
                this.A0E.A06();
                C1951Uf c1951Uf = this.A0E;
                String[] strArr = A0I;
                if (strArr[5].length() != strArr[6].length()) {
                    throw new RuntimeException();
                }
                A0I[2] = "9KPlmBkoYjXxqFD0euMsIYvX5khbM4E1";
                int iA05 = c1951Uf.A05(2);
                this.A0E.A07(5);
                if (this.A0E.A09()) {
                    this.A0E.A04();
                    if (this.A0E.A09()) {
                        int iA04 = this.A0E.A04();
                        if (!this.A0H) {
                            this.A08 = false;
                            this.A07.A03(iA04);
                            return;
                        }
                        if (this.A0E.A09()) {
                            int iA06 = this.A0E.A04();
                            if (this.A0C.indexOfKey(iA06) < 0) {
                                this.A08 = false;
                                return;
                            }
                            Ub ub = this.A0C.get(iA06);
                            C1948Uc c1948Uc = this.A0D.get(ub.A01);
                            if (c1948Uc.A0D) {
                                if (!this.A0E.A0B(2)) {
                                    return;
                                } else {
                                    this.A0E.A07(2);
                                }
                            }
                            if (this.A0E.A0B(c1948Uc.A02)) {
                                boolean zA0A = false;
                                boolean z = false;
                                boolean zA0A2 = false;
                                int iA07 = this.A0E.A05(c1948Uc.A02);
                                if (!c1948Uc.A0C) {
                                    if (!this.A0E.A0B(1)) {
                                        return;
                                    }
                                    zA0A = this.A0E.A0A();
                                    if (zA0A) {
                                        if (!this.A0E.A0B(1)) {
                                            return;
                                        }
                                        zA0A2 = this.A0E.A0A();
                                        z = true;
                                    }
                                }
                                boolean z2 = this.A01 == 5;
                                int iA08 = 0;
                                if (z2) {
                                    if (!this.A0E.A09()) {
                                        return;
                                    } else {
                                        iA08 = this.A0E.A04();
                                    }
                                }
                                int iA09 = 0;
                                int iA03 = 0;
                                int iA010 = 0;
                                int iA011 = 0;
                                if (c1948Uc.A07 == 0) {
                                    if (!this.A0E.A0B(c1948Uc.A06)) {
                                        return;
                                    }
                                    iA09 = this.A0E.A05(c1948Uc.A06);
                                    if (ub.A02 && !zA0A) {
                                        if (!this.A0E.A09()) {
                                            return;
                                        } else {
                                            iA03 = this.A0E.A03();
                                        }
                                    }
                                } else if (c1948Uc.A07 == 1 && !c1948Uc.A0B) {
                                    if (!this.A0E.A09()) {
                                        return;
                                    }
                                    iA010 = this.A0E.A03();
                                    if (ub.A02 && !zA0A) {
                                        if (!this.A0E.A09()) {
                                            return;
                                        }
                                        iA011 = this.A0E.A03();
                                        if (A0I[2].length() != 28) {
                                            String[] strArr2 = A0I;
                                            strArr2[0] = "8C9SB7EBPHdh7G";
                                            strArr2[7] = "0JTjfVSC1SUZ1y";
                                        }
                                    }
                                }
                                this.A07.A04(c1948Uc, iA05, iA04, iA07, iA06, zA0A, z, zA0A2, z2, iA08, iA09, iA03, iA010, iA011);
                                this.A08 = false;
                            }
                        }
                    }
                }
            }
        }
    }

    public YE(InterfaceC1957Uo interfaceC1957Uo, boolean z, boolean z2) {
        this.A0F = interfaceC1957Uo;
        this.A0G = z;
        this.A0H = z2;
        A01();
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    private void A00(int i) {
        if (this.A05 == -9223372036854775807L) {
            return;
        }
        boolean z = this.A0A;
        this.A0F.AI0(this.A05, z ? 1 : 0, (int) (this.A02 - this.A04), i, null);
    }

    public final void A01() {
        this.A08 = false;
        this.A09 = false;
        this.A07.A02();
    }

    public final void A02(long j, int i, long j2) {
        this.A01 = i;
        this.A03 = j2;
        this.A02 = j;
        if (!this.A0G || this.A01 != 1) {
            if (!this.A0H) {
                return;
            }
            if (this.A01 != 5) {
                int i2 = this.A01;
                String[] strArr = A0I;
                if (strArr[5].length() != strArr[6].length()) {
                    throw new RuntimeException();
                }
                String[] strArr2 = A0I;
                strArr2[3] = "20AQDGM3v0DzgNmDy140SjPPODR7VcFg";
                strArr2[1] = "caozRXSQlqOd7OxP2wl31YaipgOeDhZb";
                if (i2 != 1 && this.A01 != 2) {
                    return;
                }
            }
        }
        YD yd = this.A06;
        YD newSliceHeader = this.A07;
        this.A06 = newSliceHeader;
        this.A07 = yd;
        YD newSliceHeader2 = this.A07;
        newSliceHeader2.A02();
        this.A00 = 0;
        this.A08 = true;
    }

    public final void A03(Ub ub) {
        this.A0C.append(ub.A00, ub);
    }

    public final void A04(C1948Uc c1948Uc) {
        this.A0D.append(c1948Uc.A09, c1948Uc);
    }

    public final boolean A06() {
        return this.A0H;
    }

    public final boolean A07(long j, int i, boolean z, boolean z2) {
        boolean z3 = false;
        if (this.A01 == 9 || (this.A0H && this.A07.A00(this.A06))) {
            if (z && this.A09) {
                A00(i + ((int) (j - this.A02)));
            }
            this.A04 = this.A02;
            this.A05 = this.A03;
            this.A0A = false;
            this.A09 = true;
        }
        if (this.A0G) {
            z2 = this.A07.A05();
        }
        boolean z4 = this.A0A;
        if (this.A01 == 5 || (z2 && this.A01 == 1)) {
            z3 = true;
        }
        this.A0A = z4 | z3;
        boolean treatIFrameAsKeyframe = this.A0A;
        return treatIFrameAsKeyframe;
    }
}
