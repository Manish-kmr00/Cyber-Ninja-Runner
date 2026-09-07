package io.ktor.utils.io.internal;

import com.google.android.exoplayer2.source.rtsp.SessionDescription;
import io.ktor.utils.io.charsets.UTFKt;
import java.nio.ByteBuffer;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Strings.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000*\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0019\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\f\n\u0002\u0010\u000b\n\u0002\b\u0005\u001a(\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00012\b\b\u0002\u0010\u0006\u001a\u00020\u0001H\u0000\u001a$\u0010\u0007\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u0001H\u0002\u001a9\u0010\u0007\u001a\u00020\b*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u00012\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\nH\u0082\b\u001a$\u0010\r\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u0001H\u0002\u001a9\u0010\r\u001a\u00020\b*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u00012\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\nH\u0082\b\u001a(\u0010\u000e\u001a\u00020\b*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00012\b\b\u0002\u0010\u0006\u001a\u00020\u0001H\u0000\u001a$\u0010\u000f\u001a\u00020\b*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u0001H\u0002\u001a$\u0010\u0010\u001a\u00020\b*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u0001H\u0002¨\u0006\u0011"}, d2 = {"decodeASCII", "", "Ljava/nio/ByteBuffer;", "out", "", "offset", SessionDescription.ATTR_LENGTH, "decodeASCII3_array", "", "predicate", "Lkotlin/Function1;", "", "", "decodeASCII3_buffer", "decodeASCIILine", "decodeASCIILine_array", "decodeASCIILine_buffer", "ktor-io"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class StringsKt {
    public static /* synthetic */ int decodeASCII$default(ByteBuffer byteBuffer, char[] cArr, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = cArr.length;
        }
        return decodeASCII(byteBuffer, cArr, i, i2);
    }

    public static final int decodeASCII(ByteBuffer byteBuffer, char[] out, int i, int i2) {
        Intrinsics.checkNotNullParameter(byteBuffer, "<this>");
        Intrinsics.checkNotNullParameter(out, "out");
        if (byteBuffer.hasArray()) {
            return decodeASCII3_array(byteBuffer, out, i, i2);
        }
        return decodeASCII3_buffer(byteBuffer, out, i, i2);
    }

    public static /* synthetic */ long decodeASCIILine$default(ByteBuffer byteBuffer, char[] cArr, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = cArr.length;
        }
        return decodeASCIILine(byteBuffer, cArr, i, i2);
    }

    public static final long decodeASCIILine(ByteBuffer byteBuffer, char[] out, int i, int i2) {
        Intrinsics.checkNotNullParameter(byteBuffer, "<this>");
        Intrinsics.checkNotNullParameter(out, "out");
        return byteBuffer.hasArray() ? decodeASCIILine_array(byteBuffer, out, i, i2) : decodeASCIILine_buffer(byteBuffer, out, i, i2);
    }

    private static final int decodeASCII3_array(ByteBuffer byteBuffer, char[] cArr, int i, int i2) {
        int i3;
        int i4 = i2 + i;
        byte[] bArrArray = byteBuffer.array();
        int iArrayOffset = byteBuffer.arrayOffset() + byteBuffer.position();
        int iRemaining = byteBuffer.remaining() + iArrayOffset;
        if (i4 > cArr.length || iRemaining > bArrArray.length) {
            i3 = i;
        } else {
            i3 = i;
            while (iArrayOffset < iRemaining && i3 < i4) {
                byte b = bArrArray[iArrayOffset];
                if (b < 0) {
                    break;
                }
                cArr[i3] = (char) b;
                i3++;
                iArrayOffset++;
            }
            byteBuffer.position(iArrayOffset - byteBuffer.arrayOffset());
        }
        return i3 - i;
    }

    private static final int decodeASCII3_buffer(ByteBuffer byteBuffer, char[] cArr, int i, int i2) {
        int i3;
        int i4 = i2 + i;
        boolean z = false;
        if (i4 <= cArr.length) {
            i3 = i;
            while (byteBuffer.hasRemaining()) {
                byte b = byteBuffer.get();
                if (b < 0 || i3 >= i4) {
                    z = true;
                    break;
                }
                cArr[i3] = (char) b;
                i3++;
            }
        } else {
            i3 = i;
        }
        if (z) {
            byteBuffer.position(byteBuffer.position() - 1);
        }
        return i3 - i;
    }

    private static final long decodeASCII3_array(ByteBuffer byteBuffer, char[] cArr, int i, int i2, Function1<? super Character, Boolean> function1) {
        int i3;
        int i4 = i2 + i;
        byte[] bArrArray = byteBuffer.array();
        int iArrayOffset = byteBuffer.arrayOffset() + byteBuffer.position();
        int iRemaining = byteBuffer.remaining() + iArrayOffset;
        if (i4 > cArr.length || iRemaining > bArrArray.length) {
            i3 = i;
        } else {
            i3 = i;
            while (iArrayOffset < iRemaining) {
                byte b = bArrArray[iArrayOffset];
                if (b < 0) {
                    break;
                }
                char c = (char) b;
                if (!function1.invoke(Character.valueOf(c)).booleanValue()) {
                    byteBuffer.position(iArrayOffset - byteBuffer.arrayOffset());
                    return UTFKt.decodeUtf8Result(i3 - i, -1);
                }
                if (i3 >= i4) {
                    break;
                }
                cArr[i3] = c;
                i3++;
                iArrayOffset++;
            }
            byteBuffer.position(iArrayOffset - byteBuffer.arrayOffset());
        }
        return UTFKt.decodeUtf8Result(i3 - i, 0);
    }

    /* JADX WARN: Code duplicated, block: B:20:0x0036  */
    /* JADX WARN: Code duplicated, block: B:23:0x0041  */
    private static final long decodeASCII3_buffer(ByteBuffer byteBuffer, char[] cArr, int i, int i2, Function1<? super Character, Boolean> function1) {
        int i3;
        boolean z;
        boolean z2;
        int i4 = i2 + i;
        if (i4 <= cArr.length) {
            i3 = i;
            while (true) {
                if (byteBuffer.hasRemaining()) {
                    byte b = byteBuffer.get();
                    if (b >= 0) {
                        char c = (char) b;
                        if (!function1.invoke(Character.valueOf(c)).booleanValue()) {
                            z = true;
                            z2 = z;
                        } else if (i3 < i4) {
                            cArr[i3] = c;
                            i3++;
                        }
                    }
                    z = true;
                    z2 = false;
                }
                if (z) {
                    byteBuffer.position(byteBuffer.position() - 1);
                }
                return UTFKt.decodeUtf8Result(i3 - i, z2 ? -1 : 0);
            }
        }
        i3 = i;
        z = false;
        z2 = z;
        if (z) {
            byteBuffer.position(byteBuffer.position() - 1);
        }
        return UTFKt.decodeUtf8Result(i3 - i, z2 ? -1 : 0);
    }

    /* JADX WARN: Code duplicated, block: B:22:0x0047 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:24:0x004a A[LOOP:0: B:7:0x0020->B:24:0x004a, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:30:0x006c  */
    /* JADX WARN: Code duplicated, block: B:32:0x0071  */
    /* JADX WARN: Code duplicated, block: B:34:0x0077  */
    /* JADX WARN: Code duplicated, block: B:36:0x0081  */
    /* JADX WARN: Code duplicated, block: B:38:0x0086  */
    /* JADX WARN: Code duplicated, block: B:40:0x008b A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:41:0x008d  */
    /* JADX WARN: Code duplicated, block: B:46:0x0039 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:47:0x0051 A[SYNTHETIC] */
    private static final long decodeASCIILine_array(ByteBuffer byteBuffer, char[] cArr, int i, int i2) {
        int i3;
        boolean z;
        long jDecodeUtf8Result;
        int i4;
        int i5;
        boolean z2;
        int i6 = i2 + i;
        byte[] bArrArray = byteBuffer.array();
        int iArrayOffset = byteBuffer.arrayOffset() + byteBuffer.position();
        int iRemaining = byteBuffer.remaining() + iArrayOffset;
        if (i6 > cArr.length || iRemaining > bArrArray.length) {
            i3 = i;
            z = false;
        } else {
            i3 = i;
            z = false;
            while (true) {
                if (iArrayOffset < iRemaining) {
                    byte b = bArrArray[iArrayOffset];
                    if (b >= 0) {
                        char c = (char) b;
                        if (c != '\r') {
                            if (c == '\n') {
                                z = false;
                            } else {
                                z2 = !z;
                            }
                            if (!z2) {
                                byteBuffer.position(iArrayOffset - byteBuffer.arrayOffset());
                                jDecodeUtf8Result = UTFKt.decodeUtf8Result(i3 - i, -1);
                            } else if (i3 >= i6) {
                                cArr[i3] = c;
                                i3++;
                                iArrayOffset++;
                            }
                            if (((int) (4294967295L & jDecodeUtf8Result)) == -1) {
                                i4 = (int) (jDecodeUtf8Result >> 32);
                                if (z) {
                                    return UTFKt.decodeUtf8Result(i4 - 1, -1);
                                }
                                byteBuffer.position(byteBuffer.position() + 1);
                                if (i4 > 0) {
                                    i5 = i4 - 1;
                                    if (cArr[i5] == '\r') {
                                        return UTFKt.decodeUtf8Result(i5, -1);
                                    }
                                }
                            } else if (z) {
                                int i7 = (int) (jDecodeUtf8Result >> 32);
                                byteBuffer.position(byteBuffer.position() - 1);
                                return UTFKt.decodeUtf8Result(i7 - 1, 2);
                            }
                            return jDecodeUtf8Result;
                        }
                        z = true;
                        z2 = z;
                        if (!z2) {
                            byteBuffer.position(iArrayOffset - byteBuffer.arrayOffset());
                            jDecodeUtf8Result = UTFKt.decodeUtf8Result(i3 - i, -1);
                        } else if (i3 >= i6) {
                            cArr[i3] = c;
                            i3++;
                            iArrayOffset++;
                        }
                        if (((int) (4294967295L & jDecodeUtf8Result)) == -1) {
                            i4 = (int) (jDecodeUtf8Result >> 32);
                            if (z) {
                                return UTFKt.decodeUtf8Result(i4 - 1, -1);
                            }
                            byteBuffer.position(byteBuffer.position() + 1);
                            if (i4 > 0) {
                                i5 = i4 - 1;
                                if (cArr[i5] == '\r') {
                                    return UTFKt.decodeUtf8Result(i5, -1);
                                }
                            }
                        } else if (z) {
                            int i8 = (int) (jDecodeUtf8Result >> 32);
                            byteBuffer.position(byteBuffer.position() - 1);
                            return UTFKt.decodeUtf8Result(i8 - 1, 2);
                        }
                        return jDecodeUtf8Result;
                    }
                }
                byteBuffer.position(iArrayOffset - byteBuffer.arrayOffset());
            }
        }
        jDecodeUtf8Result = UTFKt.decodeUtf8Result(i3 - i, 0);
        if (((int) (4294967295L & jDecodeUtf8Result)) == -1) {
            i4 = (int) (jDecodeUtf8Result >> 32);
            if (z) {
                return UTFKt.decodeUtf8Result(i4 - 1, -1);
            }
            byteBuffer.position(byteBuffer.position() + 1);
            if (i4 > 0) {
                i5 = i4 - 1;
                if (cArr[i5] == '\r') {
                    return UTFKt.decodeUtf8Result(i5, -1);
                }
            }
        } else if (z) {
            int i9 = (int) (jDecodeUtf8Result >> 32);
            byteBuffer.position(byteBuffer.position() - 1);
            return UTFKt.decodeUtf8Result(i9 - 1, 2);
        }
        return jDecodeUtf8Result;
    }

    /* JADX WARN: Code duplicated, block: B:22:0x002e A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:24:0x0031 A[LOOP:0: B:5:0x000a->B:24:0x0031, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:51:0x002c A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:52:0x0016 A[SYNTHETIC] */
    private static final long decodeASCIILine_buffer(ByteBuffer byteBuffer, char[] cArr, int i, int i2) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        int i3 = i2 + i;
        int i4 = i;
        if (i3 <= cArr.length) {
            z2 = false;
            while (true) {
                if (byteBuffer.hasRemaining()) {
                    byte b = byteBuffer.get();
                    if (b >= 0) {
                        char c = (char) b;
                        if (c == '\r') {
                            z2 = true;
                        } else {
                            if (c == '\n') {
                                z2 = false;
                            } else {
                                z4 = !z2;
                            }
                            if (!z4) {
                                z = true;
                            } else if (i4 >= i3) {
                                cArr[i4] = c;
                                i4++;
                            }
                        }
                        z4 = z2;
                        if (!z4) {
                            z = true;
                        } else if (i4 >= i3) {
                            cArr[i4] = c;
                            i4++;
                        }
                    }
                    z = true;
                    z3 = false;
                } else {
                    z = false;
                }
                z3 = z;
            }
        } else {
            z = false;
            z2 = false;
            z3 = false;
        }
        if (z) {
            byteBuffer.position(byteBuffer.position() - 1);
        }
        long jDecodeUtf8Result = UTFKt.decodeUtf8Result(i4 - i, z3 ? -1 : 0);
        if (((int) (4294967295L & jDecodeUtf8Result)) == -1) {
            int i5 = (int) (jDecodeUtf8Result >> 32);
            if (z2) {
                return UTFKt.decodeUtf8Result(i5 - 1, -1);
            }
            byteBuffer.position(byteBuffer.position() + 1);
            if (i5 > 0) {
                int i6 = i5 - 1;
                if (cArr[i6] == '\r') {
                    return UTFKt.decodeUtf8Result(i6, -1);
                }
            }
        } else if (z2) {
            byteBuffer.position(byteBuffer.position() - 1);
            return UTFKt.decodeUtf8Result(((int) (jDecodeUtf8Result >> 32)) - 1, 2);
        }
        return jDecodeUtf8Result;
    }
}
