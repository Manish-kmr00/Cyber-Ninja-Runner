package androidx.compose.foundation.lazy;

import com.safedk.android.analytics.brandsafety.l;
import kotlin.Metadata;
import kotlin.jvm.JvmInline;

/* JADX INFO: compiled from: DataIndex.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0081@\u0018\u00002\u00020\u0001B\u0012\u0012\u0006\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005J\u001e\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0000H\u0086\nø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0019\u0010\f\u001a\u00020\u0000H\u0086\nø\u0001\u0000ø\u0001\u0002ø\u0001\u0001¢\u0006\u0004\b\r\u0010\u0005J\u001a\u0010\u000e\u001a\u00020\u000f2\b\u0010\t\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0012\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0005J\u0019\u0010\u0014\u001a\u00020\u0000H\u0086\nø\u0001\u0000ø\u0001\u0002ø\u0001\u0001¢\u0006\u0004\b\u0015\u0010\u0005J\u001e\u0010\u0016\u001a\u00020\u00002\u0006\u0010\u0017\u001a\u00020\u0000H\u0086\nø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0018\u0010\u000bJ!\u0010\u0016\u001a\u00020\u00002\u0006\u0010\u0017\u001a\u00020\u0003H\u0086\nø\u0001\u0000ø\u0001\u0002ø\u0001\u0001¢\u0006\u0004\b\u0019\u0010\u000bJ!\u0010\u001a\u001a\u00020\u00002\u0006\u0010\u0017\u001a\u00020\u0003H\u0086\nø\u0001\u0000ø\u0001\u0002ø\u0001\u0001¢\u0006\u0004\b\u001b\u0010\u000bJ\u0010\u0010\u001c\u001a\u00020\u001dHÖ\u0001¢\u0006\u0004\b\u001e\u0010\u001fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u0088\u0001\u0002ø\u0001\u0000\u0082\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006 "}, d2 = {"Landroidx/compose/foundation/lazy/DataIndex;", "", "value", "", "constructor-impl", "(I)I", "getValue", "()I", "compareTo", "other", "compareTo-ZjPyQlc", "(II)I", l.Q, "dec-jQJCoq8", "equals", "", "equals-impl", "(ILjava/lang/Object;)Z", "hashCode", "hashCode-impl", "inc", "inc-jQJCoq8", "minus", "i", "minus-yUvdeeg", "minus-PBKCTt8", "plus", "plus-PBKCTt8", "toString", "", "toString-impl", "(I)Ljava/lang/String;", "foundation_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
@JvmInline
public final class DataIndex {
    private final int value;

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ DataIndex m510boximpl(int i) {
        return new DataIndex(i);
    }

    /* JADX INFO: renamed from: compareTo-ZjPyQlc, reason: not valid java name */
    public static final int m511compareToZjPyQlc(int i, int i2) {
        return i - i2;
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static int m512constructorimpl(int i) {
        return i;
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m514equalsimpl(int i, Object obj) {
        return (obj instanceof DataIndex) && i == ((DataIndex) obj).m522unboximpl();
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m515equalsimpl0(int i, int i2) {
        return i == i2;
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m516hashCodeimpl(int i) {
        return Integer.hashCode(i);
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m521toStringimpl(int i) {
        return "DataIndex(value=" + i + ')';
    }

    public boolean equals(Object obj) {
        return m514equalsimpl(this.value, obj);
    }

    public int hashCode() {
        return m516hashCodeimpl(this.value);
    }

    public String toString() {
        return m521toStringimpl(this.value);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ int m522unboximpl() {
        return this.value;
    }

    private /* synthetic */ DataIndex(int i) {
        this.value = i;
    }

    public final int getValue() {
        return this.value;
    }

    /* JADX INFO: renamed from: inc-jQJCoq8, reason: not valid java name */
    public static final int m517incjQJCoq8(int i) {
        return m512constructorimpl(i + 1);
    }

    /* JADX INFO: renamed from: dec-jQJCoq8, reason: not valid java name */
    public static final int m513decjQJCoq8(int i) {
        return m512constructorimpl(i - 1);
    }

    /* JADX INFO: renamed from: plus-PBKCTt8, reason: not valid java name */
    public static final int m520plusPBKCTt8(int i, int i2) {
        return m512constructorimpl(i + i2);
    }

    /* JADX INFO: renamed from: minus-PBKCTt8, reason: not valid java name */
    public static final int m518minusPBKCTt8(int i, int i2) {
        return m512constructorimpl(i - i2);
    }

    /* JADX INFO: renamed from: minus-yUvdeeg, reason: not valid java name */
    public static final int m519minusyUvdeeg(int i, int i2) {
        return m512constructorimpl(i - i2);
    }
}
