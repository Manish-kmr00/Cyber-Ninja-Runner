package com.facebook.ads.redexgen.core;

import com.google.common.collect.ElementTypesAreNonnullByDefault;
import com.google.errorprone.annotations.concurrent.LazyInit;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.util.Arrays;
import java.util.Collection;
import java.util.Objects;
import java.util.Set;
import java.util.SortedSet;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: assets/audience_network.dex */
@ElementTypesAreNonnullByDefault
public abstract class OG<E> extends AbstractC2795ld<E> implements Set<E> {
    public static byte[] A01 = null;
    public static String[] A02 = {"tpMJzZrhhsrMkwhOFEYR9GbFlaKVIskH", "YlBA8T7Fro2", "USXGP8OuBAzNSq5CbRyfQ0SKNWZdvns1", "IwkjEd2x85ogj6Hkpqc", "vhSxYEQIRpWfy1n6I2fIJfhoZxh6fLOY", "PMh9AUA5ndLdUxX8KVZJ5S1GU2oeFGKJ", "nfsou9g6KKUnvuudu0UQjvY", "janJ9NtfQ2imEKBo1ypA"};
    public static final long serialVersionUID = 912559;

    @CheckForNull
    @LazyInit
    public transient OI<E> A00;

    public static String A0B(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A01, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 70);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A0C() {
        A01 = new byte[]{-55, -25, -39, -108, -57, -39, -26, -35, -43, -32, -35, -18, -39, -40, -70, -29, -26, -31, -67, -55, -58, -58, -65, -67, -50, -61, -55, -56, 122, -50, -55, -55, 122, -58, -69, -52, -63, -65};
    }

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException: Index 2 out of bounds for length 2
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.startVar(DebugInfoParser.java:203)
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.process(DebugInfoParser.java:135)
    	at jadx.plugins.input.dex.sections.DexCodeReader.getDebugInfo(DexCodeReader.java:122)
    	at jadx.core.dex.nodes.MethodNode.getDebugInfo(MethodNode.java:656)
    	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.visit(DebugInfoAttachVisitor.java:38)
     */
    @Override // com.facebook.ads.redexgen.core.AbstractC2795ld
    public OI<E> A0J() {
        OI<E> oi = this.A00;
        if (oi != null) {
            return oi;
        }
        OI<E> oiA0M = A0M();
        this.A00 = oiA0M;
        return oiA0M;
    }

    /* JADX INFO: renamed from: A0N */
    public abstract AbstractC2964oj<E> iterator();

    static {
        A0C();
    }

    public static int A03(int setSize) {
        int iMax = Math.max(setSize, 2);
        if (iMax < 751619276) {
            int iHighestOneBit = Integer.highestOneBit(iMax - 1) << 1;
            while (((double) iHighestOneBit) * 0.7d < iMax) {
                iHighestOneBit <<= 1;
            }
            return iHighestOneBit;
        }
        AbstractC2589iD.A0E(iMax < 1073741824, A0B(18, 20, 20));
        return 1073741824;
    }

    public static <E> OG<E> A04(int n, Object... elements) {
        Object[] objArrCopyOf = elements;
        switch (n) {
            case 0:
                C3V c3vA09 = A09();
                if (A02[1].length() == 11) {
                    A02[6] = "xMSzqHeYX9fl0z6G3xaNHOB";
                    return c3vA09;
                }
                break;
            case 1:
                return A0A(Objects.requireNonNull(objArrCopyOf[0]));
            default:
                int iA03 = A03(n);
                Object[] objArr = new Object[iA03];
                int i = iA03 - 1;
                int uniques = 0;
                int i2 = 0;
                for (int j = 0; j < n; j++) {
                    Object objA00 = AbstractC2908nU.A00(objArrCopyOf[j], j);
                    int iHashCode = objA00.hashCode();
                    int tableSize = AbstractC2789lX.A00(iHashCode);
                    while (true) {
                        int i3 = tableSize & i;
                        Object obj = objArr[i3];
                        if (obj == null) {
                            int index = i2 + 1;
                            int tableSize2 = A02[3].length();
                            if (tableSize2 != 32) {
                                String[] strArr = A02;
                                strArr[0] = "Zw143axrDatzvvuiLOoxXPNJBQDLOllI";
                                strArr[2] = "imRh362HWPXwfaqxgHfljoqeqcFI5Kex";
                                objArrCopyOf[i2] = objA00;
                                objArr[i3] = objA00;
                                uniques += iHashCode;
                                i2 = index;
                            }
                        } else {
                            if (obj.equals(objA00)) {
                            }
                            tableSize++;
                        }
                        break;
                    }
                }
                Arrays.fill(objArrCopyOf, i2, n, (Object) null);
                if (i2 == 1) {
                    return new C12832x(Objects.requireNonNull(objArrCopyOf[0]));
                }
                int tableSize3 = A03(i2);
                if (tableSize3 < iA03 / 2) {
                    return A04(i2, objArrCopyOf);
                }
                if (A0D(i2, objArrCopyOf.length)) {
                    objArrCopyOf = Arrays.copyOf(objArrCopyOf, i2);
                }
                return new C3V(objArrCopyOf, uniques, objArr, i, i2);
        }
        throw new RuntimeException();
    }

    public static <E> OG<E> A05(E e1, E e2) {
        return A04(2, e1, e2);
    }

    public static <E> OG<E> A06(E e1, E e2, E e3) {
        return A04(3, e1, e2, e3);
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.OG != com.google.common.collect.ImmutableSet<E> */
    public static <E> OG<E> A07(Collection<? extends E> elements) {
        if ((elements instanceof OG) && !(elements instanceof SortedSet)) {
            OG<E> og = (OG) elements;
            if (!og.A0K()) {
                return og;
            }
        }
        Object[] array = elements.toArray();
        int length = array.length;
        if (A02[3].length() == 32) {
            throw new RuntimeException();
        }
        A02[4] = "vJyPhnBCGNruVJXdAMH0mrO2J76B9Swt";
        return A04(length, array);
    }

    public static <E> OG<E> A08(E[] elements) {
        switch (elements.length) {
            case 0:
                return A09();
            case 1:
                C12832x c12832xA0A = A0A(elements[0]);
                if (A02[3].length() == 32) {
                    throw new RuntimeException();
                }
                A02[7] = "14gyZ0VPjhYiFYlwFK2N";
                return c12832xA0A;
            default:
                return A04(elements.length, (Object[]) elements.clone());
        }
    }

    public static <E> OG<E> A09() {
        return C3V.A05;
    }

    public static <E> OG<E> A0A(E element) {
        return new C12832x(element);
    }

    public static boolean A0D(int actualUnique, int expectedUnique) {
        return actualUnique < (expectedUnique >> 1) + (expectedUnique >> 2);
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.OG != com.google.common.collect.ImmutableSet<E> */
    public OI<E> A0M() {
        return OI.A06(toArray());
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.OG != com.google.common.collect.ImmutableSet<E> */
    public boolean A0O() {
        return false;
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.OG != com.google.common.collect.ImmutableSet<E> */
    @Override // java.util.Collection, java.util.Set
    public boolean equals(@CheckForNull Object object) {
        if (object == this) {
            return true;
        }
        if ((object instanceof OG) && A0O() && ((OG) object).A0O() && hashCode() != object.hashCode()) {
            return false;
        }
        return AbstractC2933nx.A09(this, object);
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.OG != com.google.common.collect.ImmutableSet<E> */
    @Override // java.util.Collection, java.util.Set
    public int hashCode() {
        return AbstractC2933nx.A00(this);
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.OG != com.google.common.collect.ImmutableSet<E> */
    private void readObject(ObjectInputStream stream) throws InvalidObjectException {
        throw new InvalidObjectException(A0B(0, 18, 46));
    }
}
