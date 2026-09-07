package io.ktor.utils.io.core;

import io.ktor.http.ContentDisposition;
import io.ktor.utils.io.charsets.CharsetJVMKt;
import io.ktor.utils.io.charsets.EncodingKt;
import io.ktor.utils.io.core.internal.CharArraySequence;
import io.ktor.utils.io.core.internal.ChunkBuffer;
import io.ktor.utils.io.core.internal.EncodeResult;
import io.ktor.utils.io.core.internal.UTF8Kt;
import io.ktor.utils.io.core.internal.UnsafeKt;
import java.io.EOFException;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import java.util.Arrays;
import kotlin.Deprecated;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.UShort;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.Charsets;

/* JADX INFO: compiled from: Strings.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000|\n\u0000\n\u0002\u0010\u0001\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\u0010\f\n\u0000\n\u0002\u0010\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0019\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0002\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0002\u001a\u0010\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0003H\u0001\u001a\u0010\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0006H\u0001\u001a\u0010\u0010\u0007\u001a\u00020\u00012\u0006\u0010\b\u001a\u00020\u0003H\u0002\u001a\r\u0010\t\u001a\u00020\n*\u00020\u000bH\u0082\b\u001a\u0014\u0010\f\u001a\u00020\r*\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u0003\u001a\n\u0010\f\u001a\u00020\r*\u00020\u0010\u001a\u0012\u0010\f\u001a\u00020\r*\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u0003\u001a\u001e\u0010\u0011\u001a\u00020\r*\u00020\u00102\b\b\u0002\u0010\u0012\u001a\u00020\u00032\b\b\u0002\u0010\u0013\u001a\u00020\u0003\u001a\"\u0010\u0014\u001a\u00020\u0015*\u00020\u00162\f\b\u0002\u0010\u0017\u001a\u00060\u0018j\u0002`\u00192\b\b\u0002\u0010\u0013\u001a\u00020\u0003\u001a\"\u0010\u0014\u001a\u00020\u0015*\u00020\u00102\f\b\u0002\u0010\u0017\u001a\u00060\u0018j\u0002`\u00192\b\b\u0002\u0010\u0013\u001a\u00020\u0003\u001a\"\u0010\u0014\u001a\u00020\u0015*\u00020\u00102\n\u0010\u001a\u001a\u00060\u001bj\u0002`\u001c2\b\b\u0002\u0010\u0013\u001a\u00020\u0003H\u0007\u001a.\u0010\u0014\u001a\u00020\u0003*\u00020\u00102\n\u0010\u001d\u001a\u00060\u001ej\u0002`\u001f2\f\b\u0002\u0010\u0017\u001a\u00060\u0018j\u0002`\u00192\b\b\u0002\u0010\u0013\u001a\u00020\u0003\u001a\"\u0010 \u001a\u00020\u0015*\u00020\u00102\f\b\u0002\u0010\u0017\u001a\u00060\u0018j\u0002`\u00192\u0006\u0010\u000f\u001a\u00020\u0003H\u0007\u001a\"\u0010!\u001a\u00020\u0015*\u00020\u00102\f\b\u0002\u0010\u0017\u001a\u00060\u0018j\u0002`\u00192\u0006\u0010\"\u001a\u00020\u0003H\u0007\u001a \u0010!\u001a\u00020\u0015*\u00020\u00102\u0006\u0010#\u001a\u00020\u00032\f\b\u0002\u0010\u0017\u001a\u00060\u0018j\u0002`\u0019\u001a \u0010$\u001a\u00020\u0015*\u00020\u00102\u0006\u0010\b\u001a\u00020\u00032\f\b\u0002\u0010\u0017\u001a\u00060\u0018j\u0002`\u0019\u001a \u0010%\u001a\u0004\u0018\u00010\u0015*\u00020\u000e2\b\b\u0002\u0010&\u001a\u00020\u00032\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u001a \u0010%\u001a\u0004\u0018\u00010\u0015*\u00020\u00102\b\b\u0002\u0010&\u001a\u00020\u00032\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u001a\u001e\u0010'\u001a\u00020\n*\u00020\u00102\n\u0010\u001d\u001a\u00060\u001ej\u0002`\u001f2\u0006\u0010\u0002\u001a\u00020\u0003\u001a\u001c\u0010(\u001a\u00020\u0015*\u00020\u00102\u0006\u0010)\u001a\u00020\u00152\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u001a$\u0010*\u001a\u00020\u0003*\u00020\u00102\u0006\u0010\u001d\u001a\u00020+2\u0006\u0010)\u001a\u00020\u00152\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u001a(\u0010*\u001a\u00020\u0003*\u00020\u00102\n\u0010\u001d\u001a\u00060\u001ej\u0002`\u001f2\u0006\u0010)\u001a\u00020\u00152\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u001a,\u0010,\u001a\u00020\u0003*\u00020\u00102\u0006\u0010\u001d\u001a\u00020+2\u0006\u0010)\u001a\u00020\u00152\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010-\u001a\u00020\u0003H\u0002\u001a0\u0010,\u001a\u00020\u0003*\u00020\u00102\n\u0010\u001d\u001a\u00060\u001ej\u0002`\u001f2\u0006\u0010)\u001a\u00020\u00152\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010-\u001a\u00020\u0003H\u0002\u001a$\u0010.\u001a\u00020\u0003*\u00020\u00102\u0006\u0010)\u001a\u00020\u00152\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u001d\u001a\u00020+H\u0002\u001a\u001b\u0010/\u001a\u00020\r*\u00020\u00152\f\b\u0002\u0010\u0017\u001a\u00060\u0018j\u0002`\u0019H\u0086\b\u001a4\u00100\u001a\u000201*\u00020+2\u0006\u00102\u001a\u0002032\b\b\u0002\u00104\u001a\u00020\u00032\b\b\u0002\u00105\u001a\u00020\u00032\f\b\u0002\u0010\u0017\u001a\u00060\u0018j\u0002`\u0019\u001a4\u00100\u001a\u000201*\u00020+2\u0006\u00102\u001a\u0002062\b\b\u0002\u00104\u001a\u00020\u00032\b\b\u0002\u00105\u001a\u00020\u00032\f\b\u0002\u0010\u0017\u001a\u00060\u0018j\u0002`\u0019\u001a$\u00107\u001a\u000201*\u00020+2\u0006\u00102\u001a\u0002062\u0006\u00104\u001a\u00020\u00032\u0006\u00105\u001a\u00020\u0003H\u0002¨\u00068"}, d2 = {"bufferLimitExceeded", "", "limit", "", "prematureEndOfStream", ContentDisposition.Parameters.Size, "", "prematureEndOfStreamToReadChars", "charactersCount", "isAsciiChar", "", "", "readBytes", "", "Lio/ktor/utils/io/core/ByteReadPacket;", "n", "Lio/ktor/utils/io/core/Input;", "readBytesOf", "min", "max", "readText", "", "Lio/ktor/utils/io/core/Buffer;", "charset", "Ljava/nio/charset/Charset;", "Lio/ktor/utils/io/charsets/Charset;", "decoder", "Ljava/nio/charset/CharsetDecoder;", "Lio/ktor/utils/io/charsets/CharsetDecoder;", "out", "Ljava/lang/Appendable;", "Lkotlin/text/Appendable;", "readTextExact", "readTextExactBytes", "bytes", "bytesCount", "readTextExactCharacters", "readUTF8Line", "estimate", "readUTF8LineTo", "readUTF8UntilDelimiter", "delimiters", "readUTF8UntilDelimiterTo", "Lio/ktor/utils/io/core/Output;", "readUTF8UntilDelimiterToSlowUtf8", "decoded0", "readUTFUntilDelimiterToSlowAscii", "toByteArray", "writeText", "", "text", "", "fromIndex", "toIndex", "", "writeTextUtf8", "ktor-io"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class StringsKt {
    private static final boolean isAsciiChar(char c) {
        return c <= 127;
    }

    public static /* synthetic */ byte[] toByteArray$default(String str, Charset charset, int i, Object obj) {
        if ((i & 1) != 0) {
            charset = Charsets.UTF_8;
        }
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(charset, "charset");
        if (Intrinsics.areEqual(charset, Charsets.UTF_8)) {
            return kotlin.text.StringsKt.encodeToByteArray(str);
        }
        CharsetEncoder charsetEncoderNewEncoder = charset.newEncoder();
        Intrinsics.checkNotNullExpressionValue(charsetEncoderNewEncoder, "charset.newEncoder()");
        return CharsetJVMKt.encodeToByteArray(charsetEncoderNewEncoder, str, 0, str.length());
    }

    public static final byte[] toByteArray(String str, Charset charset) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(charset, "charset");
        if (Intrinsics.areEqual(charset, Charsets.UTF_8)) {
            return kotlin.text.StringsKt.encodeToByteArray(str);
        }
        CharsetEncoder charsetEncoderNewEncoder = charset.newEncoder();
        Intrinsics.checkNotNullExpressionValue(charsetEncoderNewEncoder, "charset.newEncoder()");
        return CharsetJVMKt.encodeToByteArray(charsetEncoderNewEncoder, str, 0, str.length());
    }

    public static /* synthetic */ String readUTF8Line$default(ByteReadPacket byteReadPacket, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = 16;
        }
        if ((i3 & 2) != 0) {
            i2 = Integer.MAX_VALUE;
        }
        return readUTF8Line(byteReadPacket, i, i2);
    }

    public static /* synthetic */ String readUTF8Line$default(Input input, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = 16;
        }
        if ((i3 & 2) != 0) {
            i2 = Integer.MAX_VALUE;
        }
        return readUTF8Line(input, i, i2);
    }

    public static final String readUTF8Line(Input input, int i, int i2) {
        Intrinsics.checkNotNullParameter(input, "<this>");
        StringBuilder sb = new StringBuilder(i);
        if (readUTF8LineTo(input, sb, i2)) {
            return sb.toString();
        }
        return null;
    }

    public static /* synthetic */ String readUTF8UntilDelimiter$default(Input input, String str, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = Integer.MAX_VALUE;
        }
        return readUTF8UntilDelimiter(input, str, i);
    }

    public static final String readUTF8UntilDelimiter(Input input, String delimiters, int i) throws Throwable {
        Intrinsics.checkNotNullParameter(input, "<this>");
        Intrinsics.checkNotNullParameter(delimiters, "delimiters");
        StringBuilder sb = new StringBuilder();
        readUTF8UntilDelimiterTo(input, sb, delimiters, i);
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }

    public static /* synthetic */ int readUTF8UntilDelimiterTo$default(Input input, Appendable appendable, String str, int i, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            i = Integer.MAX_VALUE;
        }
        return readUTF8UntilDelimiterTo(input, appendable, str, i);
    }

    public static /* synthetic */ int readUTF8UntilDelimiterTo$default(Input input, Output output, String str, int i, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            i = Integer.MAX_VALUE;
        }
        return readUTF8UntilDelimiterTo(input, output, str, i);
    }

    public static final int readUTF8UntilDelimiterTo(Input input, Output out, String delimiters, int i) {
        long untilDelimiters;
        Intrinsics.checkNotNullParameter(input, "<this>");
        Intrinsics.checkNotNullParameter(out, "out");
        Intrinsics.checkNotNullParameter(delimiters, "delimiters");
        int length = delimiters.length();
        if (length == 1 && delimiters.charAt(0) <= 127) {
            untilDelimiters = ScannerKt.readUntilDelimiter(input, (byte) delimiters.charAt(0), out);
        } else if (length == 2 && delimiters.charAt(0) <= 127 && delimiters.charAt(1) <= 127) {
            untilDelimiters = ScannerKt.readUntilDelimiters(input, (byte) delimiters.charAt(0), (byte) delimiters.charAt(1), out);
        } else {
            return readUTFUntilDelimiterToSlowAscii(input, delimiters, i, out);
        }
        return (int) untilDelimiters;
    }

    public static /* synthetic */ byte[] readBytes$default(ByteReadPacket byteReadPacket, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            long remaining = byteReadPacket.getRemaining();
            if (remaining > 2147483647L) {
                throw new IllegalArgumentException("Unable to convert to a ByteArray: packet is too big");
            }
            i = (int) remaining;
        }
        return readBytes(byteReadPacket, i);
    }

    public static final byte[] readBytes(ByteReadPacket byteReadPacket, int i) {
        Intrinsics.checkNotNullParameter(byteReadPacket, "<this>");
        if (i != 0) {
            byte[] bArr = new byte[i];
            InputArraysKt.readFully((Input) byteReadPacket, bArr, 0, i);
            return bArr;
        }
        return UnsafeKt.EmptyByteArray;
    }

    public static final byte[] readBytes(Input input, int i) {
        Intrinsics.checkNotNullParameter(input, "<this>");
        return readBytesOf(input, i, i);
    }

    public static final byte[] readBytes(Input input) {
        Intrinsics.checkNotNullParameter(input, "<this>");
        return readBytesOf$default(input, 0, 0, 3, null);
    }

    public static /* synthetic */ byte[] readBytesOf$default(Input input, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = 0;
        }
        if ((i3 & 2) != 0) {
            i2 = Integer.MAX_VALUE;
        }
        return readBytesOf(input, i, i2);
    }

    public static final byte[] readBytesOf(Input input, int i, int i2) throws EOFException {
        int available;
        Intrinsics.checkNotNullParameter(input, "<this>");
        if (i == i2 && i == 0) {
            return UnsafeKt.EmptyByteArray;
        }
        int i3 = 0;
        if (i == i2) {
            byte[] bArr = new byte[i];
            InputArraysKt.readFully(input, bArr, 0, i);
            return bArr;
        }
        byte[] bArrCopyOf = new byte[(int) RangesKt.coerceAtLeast(RangesKt.coerceAtMost(i2, EncodingKt.sizeEstimate(input)), i)];
        while (i3 < i2 && (available = InputArraysKt.readAvailable(input, bArrCopyOf, i3, Math.min(i2, bArrCopyOf.length) - i3)) > 0) {
            i3 += available;
            if (bArrCopyOf.length == i3) {
                bArrCopyOf = Arrays.copyOf(bArrCopyOf, i3 * 2);
                Intrinsics.checkNotNullExpressionValue(bArrCopyOf, "copyOf(this, newSize)");
            }
        }
        if (i3 < i) {
            throw new EOFException("Not enough bytes available to read " + i + " bytes: " + (i - i3) + " more required");
        }
        if (i3 == bArrCopyOf.length) {
            return bArrCopyOf;
        }
        byte[] bArrCopyOf2 = Arrays.copyOf(bArrCopyOf, i3);
        Intrinsics.checkNotNullExpressionValue(bArrCopyOf2, "copyOf(this, newSize)");
        return bArrCopyOf2;
    }

    public static /* synthetic */ int readText$default(Input input, Appendable appendable, Charset charset, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            charset = Charsets.UTF_8;
        }
        if ((i2 & 4) != 0) {
            i = Integer.MAX_VALUE;
        }
        return readText(input, appendable, charset, i);
    }

    public static final int readText(Input input, Appendable out, Charset charset, int i) {
        Intrinsics.checkNotNullParameter(input, "<this>");
        Intrinsics.checkNotNullParameter(out, "out");
        Intrinsics.checkNotNullParameter(charset, "charset");
        CharsetDecoder charsetDecoderNewDecoder = charset.newDecoder();
        Intrinsics.checkNotNullExpressionValue(charsetDecoderNewDecoder, "charset.newDecoder()");
        return CharsetJVMKt.decode(charsetDecoderNewDecoder, input, out, i);
    }

    public static /* synthetic */ String readText$default(Input input, CharsetDecoder charsetDecoder, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = Integer.MAX_VALUE;
        }
        return readText(input, charsetDecoder, i);
    }

    @Deprecated(message = "Use CharsetDecoder.decode instead", replaceWith = @ReplaceWith(expression = "decoder.decode(this, max)", imports = {"io.ktor.utils.io.charsets.decode"}))
    public static final String readText(Input input, CharsetDecoder decoder, int i) {
        Intrinsics.checkNotNullParameter(input, "<this>");
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        return EncodingKt.decode(decoder, input, i);
    }

    public static /* synthetic */ String readText$default(Input input, Charset charset, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            charset = Charsets.UTF_8;
        }
        if ((i2 & 2) != 0) {
            i = Integer.MAX_VALUE;
        }
        return readText(input, charset, i);
    }

    public static final String readText(Input input, Charset charset, int i) {
        Intrinsics.checkNotNullParameter(input, "<this>");
        Intrinsics.checkNotNullParameter(charset, "charset");
        CharsetDecoder charsetDecoderNewDecoder = charset.newDecoder();
        Intrinsics.checkNotNullExpressionValue(charsetDecoderNewDecoder, "charset.newDecoder()");
        return EncodingKt.decode(charsetDecoderNewDecoder, input, i);
    }

    public static final String readText(Buffer buffer, Charset charset, int i) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        Intrinsics.checkNotNullParameter(charset, "charset");
        StringBuilder sb = new StringBuilder();
        CharsetDecoder charsetDecoderNewDecoder = charset.newDecoder();
        Intrinsics.checkNotNullExpressionValue(charsetDecoderNewDecoder, "charset.newDecoder()");
        CharsetJVMKt.decodeBuffer(charsetDecoderNewDecoder, buffer, sb, true, i);
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }

    public static /* synthetic */ String readText$default(Buffer buffer, Charset charset, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            charset = Charsets.UTF_8;
        }
        if ((i2 & 2) != 0) {
            i = Integer.MAX_VALUE;
        }
        return readText(buffer, charset, i);
    }

    public static /* synthetic */ String readTextExact$default(Input input, Charset charset, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            charset = Charsets.UTF_8;
        }
        return readTextExact(input, charset, i);
    }

    @Deprecated(message = "Use readTextExactCharacters instead.", replaceWith = @ReplaceWith(expression = "readTextExactCharacters(n, charset)", imports = {}))
    public static final String readTextExact(Input input, Charset charset, int i) {
        Intrinsics.checkNotNullParameter(input, "<this>");
        Intrinsics.checkNotNullParameter(charset, "charset");
        return readTextExactCharacters(input, i, charset);
    }

    public static /* synthetic */ String readTextExactCharacters$default(Input input, int i, Charset charset, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            charset = Charsets.UTF_8;
        }
        return readTextExactCharacters(input, i, charset);
    }

    public static final String readTextExactCharacters(Input input, int i, Charset charset) throws EOFException {
        Intrinsics.checkNotNullParameter(input, "<this>");
        Intrinsics.checkNotNullParameter(charset, "charset");
        String text = readText(input, charset, i);
        if (text.length() >= i) {
            return text;
        }
        prematureEndOfStreamToReadChars(i);
        throw new KotlinNothingValueException();
    }

    public static /* synthetic */ String readTextExactBytes$default(Input input, Charset charset, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            charset = Charsets.UTF_8;
        }
        return readTextExactBytes(input, charset, i);
    }

    @Deprecated(message = "Parameters order is changed.", replaceWith = @ReplaceWith(expression = "readTextExactBytes(bytes, charset)", imports = {}))
    public static final String readTextExactBytes(Input input, Charset charset, int i) {
        Intrinsics.checkNotNullParameter(input, "<this>");
        Intrinsics.checkNotNullParameter(charset, "charset");
        return readTextExactBytes(input, i, charset);
    }

    public static /* synthetic */ String readTextExactBytes$default(Input input, int i, Charset charset, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            charset = Charsets.UTF_8;
        }
        return readTextExactBytes(input, i, charset);
    }

    public static final String readTextExactBytes(Input input, int i, Charset charset) {
        Intrinsics.checkNotNullParameter(input, "<this>");
        Intrinsics.checkNotNullParameter(charset, "charset");
        CharsetDecoder charsetDecoderNewDecoder = charset.newDecoder();
        Intrinsics.checkNotNullExpressionValue(charsetDecoderNewDecoder, "charset.newDecoder()");
        return CharsetJVMKt.decodeExactBytes(charsetDecoderNewDecoder, input, i);
    }

    public static /* synthetic */ void writeText$default(Output output, CharSequence charSequence, int i, int i2, Charset charset, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = charSequence.length();
        }
        if ((i3 & 8) != 0) {
            charset = Charsets.UTF_8;
        }
        writeText(output, charSequence, i, i2, charset);
    }

    public static final void writeText(Output output, CharSequence text, int i, int i2, Charset charset) {
        Intrinsics.checkNotNullParameter(output, "<this>");
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(charset, "charset");
        if (charset == Charsets.UTF_8) {
            writeTextUtf8(output, text, i, i2);
            return;
        }
        CharsetEncoder charsetEncoderNewEncoder = charset.newEncoder();
        Intrinsics.checkNotNullExpressionValue(charsetEncoderNewEncoder, "charset.newEncoder()");
        EncodingKt.encodeToImpl(charsetEncoderNewEncoder, output, text, i, i2);
    }

    public static /* synthetic */ void writeText$default(Output output, char[] cArr, int i, int i2, Charset charset, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = cArr.length;
        }
        if ((i3 & 8) != 0) {
            charset = Charsets.UTF_8;
        }
        writeText(output, cArr, i, i2, charset);
    }

    public static final void writeText(Output output, char[] text, int i, int i2, Charset charset) {
        Intrinsics.checkNotNullParameter(output, "<this>");
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(charset, "charset");
        if (charset == Charsets.UTF_8) {
            writeTextUtf8(output, new CharArraySequence(text, 0, text.length), i, i2);
            return;
        }
        CharsetEncoder charsetEncoderNewEncoder = charset.newEncoder();
        Intrinsics.checkNotNullExpressionValue(charsetEncoderNewEncoder, "charset.newEncoder()");
        EncodingKt.encode(charsetEncoderNewEncoder, text, i, i2, output);
    }

    private static final Void bufferLimitExceeded(int i) throws BufferLimitExceededException {
        throw new BufferLimitExceededException("Too many characters before delimiter: limit " + i + " exceeded");
    }

    public static final Void prematureEndOfStream(int i) throws EOFException {
        throw new EOFException("Premature end of stream: expected " + i + " bytes");
    }

    public static final Void prematureEndOfStream(long j) throws EOFException {
        throw new EOFException("Premature end of stream: expected " + j + " bytes");
    }

    private static final Void prematureEndOfStreamToReadChars(int i) throws EOFException {
        throw new EOFException("Not enough input bytes to read " + i + " characters.");
    }

    public static final String readUTF8Line(ByteReadPacket byteReadPacket, int i, int i2) {
        Intrinsics.checkNotNullParameter(byteReadPacket, "<this>");
        if (byteReadPacket.getEndOfInput()) {
            return null;
        }
        StringBuilder sb = new StringBuilder(i);
        if (readUTF8LineTo(byteReadPacket, sb, i2)) {
            return sb.toString();
        }
        return null;
    }

    /* JADX WARN: Code duplicated, block: B:150:0x021f  */
    /* JADX WARN: Multi-variable type inference failed */
    public static final boolean readUTF8LineTo(Input input, Appendable out, int i) throws Throwable {
        int i2;
        int i3;
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        ChunkBuffer chunkBufferPrepareReadNextHead;
        int i4;
        Intrinsics.checkNotNullParameter(input, "<this>");
        Intrinsics.checkNotNullParameter(out, "out");
        int i5 = 1;
        ChunkBuffer chunkBufferPrepareReadFirstHead = UnsafeKt.prepareReadFirstHead(input, 1);
        if (chunkBufferPrepareReadFirstHead == null) {
            i4 = 1;
            i2 = 0;
        } else {
            int iCoerceAtLeast = 1;
            int i6 = 1;
            boolean z5 = false;
            i2 = 0;
            boolean z6 = false;
            do {
                try {
                    ChunkBuffer chunkBuffer = chunkBufferPrepareReadFirstHead;
                    int writePosition = chunkBuffer.getWritePosition() - chunkBuffer.getReadPosition();
                    if (writePosition >= iCoerceAtLeast) {
                        try {
                            ChunkBuffer chunkBuffer2 = chunkBufferPrepareReadFirstHead;
                            ByteBuffer byteBufferM7773getMemorySK3TCg8 = chunkBuffer2.getMemory();
                            int readPosition = chunkBuffer2.getReadPosition();
                            int writePosition2 = chunkBuffer2.getWritePosition();
                            int i7 = readPosition;
                            int i8 = 0;
                            int i9 = 0;
                            int i10 = 0;
                            int i11 = 0;
                            while (true) {
                                if (i7 < writePosition2) {
                                    byte b = byteBufferM7773getMemorySK3TCg8.get(i7);
                                    int i12 = b & 255;
                                    ByteBuffer byteBuffer = byteBufferM7773getMemorySK3TCg8;
                                    boolean z7 = z6;
                                    if ((b & 128) != 0) {
                                        if (i8 == 0) {
                                            int i13 = 128;
                                            i9 = i12;
                                            for (int i14 = 1; i14 < 7 && (i9 & i13) != 0; i14++) {
                                                i9 &= ~i13;
                                                i13 >>= 1;
                                                i8++;
                                            }
                                            int i15 = i8 - 1;
                                            if (i8 > writePosition2 - i7) {
                                                chunkBuffer2.discardExact(i7 - readPosition);
                                                i6 = i8;
                                                i3 = i11;
                                                z6 = z7;
                                            } else {
                                                i10 = i8;
                                                z6 = z7;
                                                i8 = i15;
                                            }
                                        } else {
                                            i9 = (i9 << 6) | (b & 127);
                                            i8--;
                                            if (i8 == 0) {
                                                if (UTF8Kt.isBmpCodePoint(i9)) {
                                                    char c = (char) i9;
                                                    if (c == '\r') {
                                                        if (z5) {
                                                            z3 = false;
                                                            z6 = true;
                                                        } else {
                                                            z6 = z7;
                                                            z3 = true;
                                                            z5 = true;
                                                        }
                                                    } else if (c == '\n') {
                                                        z3 = false;
                                                        z6 = true;
                                                        i11 = 1;
                                                    } else if (z5) {
                                                        z3 = false;
                                                        z6 = true;
                                                    } else {
                                                        if (i2 == i) {
                                                            bufferLimitExceeded(i);
                                                            throw new KotlinNothingValueException();
                                                        }
                                                        i2++;
                                                        out.append(c);
                                                        z6 = z7;
                                                        z3 = true;
                                                    }
                                                    if (!z3) {
                                                        chunkBuffer2.discardExact(((i7 - readPosition) - i10) + 1);
                                                        i3 = i11;
                                                    }
                                                } else {
                                                    if (!UTF8Kt.isValidCodePoint(i9)) {
                                                        UTF8Kt.malformedCodePoint(i9);
                                                        throw new KotlinNothingValueException();
                                                    }
                                                    char cHighSurrogate = (char) UTF8Kt.highSurrogate(i9);
                                                    if (cHighSurrogate == '\r') {
                                                        if (z5) {
                                                            z = false;
                                                            z7 = true;
                                                        } else {
                                                            z = true;
                                                            z5 = true;
                                                        }
                                                    } else if (cHighSurrogate == '\n') {
                                                        z = false;
                                                        i11 = 1;
                                                        z7 = true;
                                                    } else if (z5) {
                                                        z = false;
                                                        z7 = true;
                                                    } else {
                                                        if (i2 == i) {
                                                            bufferLimitExceeded(i);
                                                            throw new KotlinNothingValueException();
                                                        }
                                                        i2++;
                                                        out.append(cHighSurrogate);
                                                        z = true;
                                                    }
                                                    if (z) {
                                                        char cLowSurrogate = (char) UTF8Kt.lowSurrogate(i9);
                                                        if (cLowSurrogate == '\r') {
                                                            if (z5) {
                                                                z2 = false;
                                                                z7 = true;
                                                            } else {
                                                                z2 = true;
                                                                z5 = true;
                                                            }
                                                        } else if (cLowSurrogate == '\n') {
                                                            z2 = false;
                                                            i11 = 1;
                                                            z7 = true;
                                                        } else if (z5) {
                                                            z2 = false;
                                                            z7 = true;
                                                        } else {
                                                            if (i2 == i) {
                                                                bufferLimitExceeded(i);
                                                                throw new KotlinNothingValueException();
                                                            }
                                                            i2++;
                                                            out.append(cLowSurrogate);
                                                            z2 = true;
                                                        }
                                                        if (z2) {
                                                            z6 = z7;
                                                        }
                                                    }
                                                    chunkBuffer2.discardExact(((i7 - readPosition) - i10) + 1);
                                                    i3 = i11;
                                                    z6 = z7;
                                                }
                                                i9 = 0;
                                            } else {
                                                z6 = z7;
                                            }
                                        }
                                        i7++;
                                        byteBufferM7773getMemorySK3TCg8 = byteBuffer;
                                    } else {
                                        if (i8 != 0) {
                                            UTF8Kt.malformedByteCount(i8);
                                            throw new KotlinNothingValueException();
                                        }
                                        char c2 = (char) i12;
                                        if (c2 == '\r') {
                                            if (z5) {
                                                z4 = false;
                                                z6 = true;
                                            } else {
                                                z6 = z7;
                                                z4 = true;
                                                z5 = true;
                                            }
                                        } else if (c2 == '\n') {
                                            z4 = false;
                                            z6 = true;
                                            i11 = 1;
                                        } else if (z5) {
                                            z4 = false;
                                            z6 = true;
                                        } else {
                                            if (i2 == i) {
                                                bufferLimitExceeded(i);
                                                throw new KotlinNothingValueException();
                                            }
                                            i2++;
                                            out.append(c2);
                                            z6 = z7;
                                            z4 = true;
                                        }
                                        if (z4) {
                                            i7++;
                                            byteBufferM7773getMemorySK3TCg8 = byteBuffer;
                                        } else {
                                            chunkBuffer2.discardExact(i7 - readPosition);
                                            i3 = i11;
                                        }
                                    }
                                    i6 = -1;
                                } else {
                                    chunkBuffer2.discardExact(writePosition2 - readPosition);
                                    i3 = i11;
                                    z6 = z6;
                                    i6 = 0;
                                }
                                if (i3 > 0) {
                                    chunkBuffer2.discardExact(i3);
                                }
                                iCoerceAtLeast = z6 ? 0 : RangesKt.coerceAtLeast(i6, 1);
                                try {
                                    ChunkBuffer chunkBuffer3 = chunkBufferPrepareReadFirstHead;
                                    writePosition = chunkBuffer3.getWritePosition() - chunkBuffer3.getReadPosition();
                                } catch (Throwable th) {
                                    th = th;
                                    i5 = 1;
                                    if (i5 != 0) {
                                        UnsafeKt.completeReadHead(input, chunkBufferPrepareReadFirstHead);
                                    }
                                    throw th;
                                }
                            }
                        } catch (Throwable th2) {
                            ChunkBuffer chunkBuffer4 = chunkBufferPrepareReadFirstHead;
                            chunkBuffer4.getWritePosition();
                            chunkBuffer4.getReadPosition();
                            throw th2;
                        }
                    }
                    if (writePosition == 0) {
                        try {
                            chunkBufferPrepareReadNextHead = UnsafeKt.prepareReadNextHead(input, chunkBufferPrepareReadFirstHead);
                        } catch (Throwable th3) {
                            th = th3;
                            i5 = 0;
                            if (i5 != 0) {
                                UnsafeKt.completeReadHead(input, chunkBufferPrepareReadFirstHead);
                            }
                            throw th;
                        }
                    } else if (writePosition >= iCoerceAtLeast) {
                        ChunkBuffer chunkBuffer5 = chunkBufferPrepareReadFirstHead;
                        if (chunkBuffer5.getCapacity() - chunkBuffer5.getLimit() < 8) {
                            UnsafeKt.completeReadHead(input, chunkBufferPrepareReadFirstHead);
                            chunkBufferPrepareReadNextHead = UnsafeKt.prepareReadFirstHead(input, iCoerceAtLeast);
                        } else {
                            chunkBufferPrepareReadNextHead = chunkBufferPrepareReadFirstHead;
                        }
                    } else {
                        UnsafeKt.completeReadHead(input, chunkBufferPrepareReadFirstHead);
                        chunkBufferPrepareReadNextHead = UnsafeKt.prepareReadFirstHead(input, iCoerceAtLeast);
                    }
                    if (chunkBufferPrepareReadNextHead == null) {
                        i5 = 0;
                        break;
                    }
                    chunkBufferPrepareReadFirstHead = chunkBufferPrepareReadNextHead;
                    i5 = 1;
                } catch (Throwable th4) {
                    th = th4;
                }
            } while (iCoerceAtLeast > 0);
            if (i5 != 0) {
                UnsafeKt.completeReadHead(input, chunkBufferPrepareReadFirstHead);
            }
            i5 = i6;
            i4 = 1;
        }
        if (i5 > i4) {
            prematureEndOfStream(i5);
            throw new KotlinNothingValueException();
        }
        if (i2 > 0 || !input.getEndOfInput()) {
            return i4;
        }
        return false;
    }

    public static final int readUTF8UntilDelimiterTo(Input input, Appendable out, String delimiters, int i) throws Throwable {
        int i2;
        boolean z;
        boolean z2;
        boolean z3;
        Intrinsics.checkNotNullParameter(input, "<this>");
        Intrinsics.checkNotNullParameter(out, "out");
        Intrinsics.checkNotNullParameter(delimiters, "delimiters");
        ChunkBuffer chunkBufferPrepareReadFirstHead = UnsafeKt.prepareReadFirstHead(input, 1);
        boolean z4 = false;
        if (chunkBufferPrepareReadFirstHead == null) {
            i2 = 0;
        } else {
            i2 = 0;
            boolean z5 = false;
            do {
                try {
                    ChunkBuffer chunkBuffer = chunkBufferPrepareReadFirstHead;
                    ByteBuffer byteBufferM7773getMemorySK3TCg8 = chunkBuffer.getMemory();
                    int readPosition = chunkBuffer.getReadPosition();
                    int writePosition = chunkBuffer.getWritePosition();
                    int i3 = readPosition;
                    while (true) {
                        if (i3 < writePosition) {
                            byte b = byteBufferM7773getMemorySK3TCg8.get(i3);
                            int i4 = b & 255;
                            if ((b & 128) != 128) {
                                char c = (char) i4;
                                boolean z6 = z5;
                                if (!kotlin.text.StringsKt.contains$default((CharSequence) delimiters, c, false, 2, (Object) null)) {
                                    if (i2 == i) {
                                        bufferLimitExceeded(i);
                                        throw new KotlinNothingValueException();
                                    }
                                    i2++;
                                    out.append(c);
                                    z5 = z6;
                                    z3 = true;
                                    if (z) {
                                        UnsafeKt.completeReadHead(input, chunkBufferPrepareReadFirstHead);
                                    }
                                    throw th;
                                }
                                z3 = false;
                                z5 = true;
                                if (z3) {
                                    i3++;
                                }
                            }
                            chunkBuffer.discardExact(i3 - readPosition);
                            z2 = false;
                            break;
                        }
                        boolean z7 = z5;
                        chunkBuffer.discardExact(writePosition - readPosition);
                        z5 = z7;
                        z2 = true;
                        break;
                    }
                    if (z2) {
                        try {
                            chunkBufferPrepareReadFirstHead = UnsafeKt.prepareReadNextHead(input, chunkBufferPrepareReadFirstHead);
                        } catch (Throwable th) {
                            th = th;
                            z = false;
                        }
                    } else {
                        UnsafeKt.completeReadHead(input, chunkBufferPrepareReadFirstHead);
                        break;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    z = true;
                }
            } while (chunkBufferPrepareReadFirstHead != null);
            z4 = z5;
        }
        return !z4 ? readUTF8UntilDelimiterToSlowUtf8(input, out, delimiters, i, i2) : i2;
    }

    private static final void writeTextUtf8(Output output, CharSequence charSequence, int i, int i2) {
        int i3;
        ChunkBuffer chunkBufferPrepareWriteHead = UnsafeKt.prepareWriteHead(output, 1, null);
        while (true) {
            try {
                ChunkBuffer chunkBuffer = chunkBufferPrepareWriteHead;
                int iM7891encodeUTF8lBXzO7A = UTF8Kt.m7891encodeUTF8lBXzO7A(chunkBuffer.getMemory(), charSequence, i, i2, chunkBuffer.getWritePosition(), chunkBuffer.getLimit());
                short sM7880component1Mh2AYeg = EncodeResult.m7880component1Mh2AYeg(iM7891encodeUTF8lBXzO7A);
                short sM7881component2Mh2AYeg = EncodeResult.m7881component2Mh2AYeg(iM7891encodeUTF8lBXzO7A);
                int i4 = sM7880component1Mh2AYeg & UShort.MAX_VALUE;
                i += i4;
                chunkBuffer.commitWritten(sM7881component2Mh2AYeg & UShort.MAX_VALUE);
                if (i4 != 0 || i >= i2) {
                    i3 = i < i2 ? 1 : 0;
                } else {
                    i3 = 8;
                }
                if (i3 > 0) {
                    chunkBufferPrepareWriteHead = UnsafeKt.prepareWriteHead(output, i3, chunkBufferPrepareWriteHead);
                } else {
                    output.afterHeadWrite();
                    return;
                }
            } catch (Throwable th) {
                output.afterHeadWrite();
                throw th;
            }
        }
    }

    private static final int readUTFUntilDelimiterToSlowAscii(Input input, String str, int i, Output output) throws Throwable {
        int i2;
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        ChunkBuffer chunkBufferPrepareReadFirstHead = UnsafeKt.prepareReadFirstHead(input, 1);
        if (chunkBufferPrepareReadFirstHead == null) {
            z4 = false;
            i2 = 0;
        } else {
            i2 = 0;
            boolean z6 = false;
            do {
                try {
                    ChunkBuffer chunkBuffer = chunkBufferPrepareReadFirstHead;
                    int writePosition = chunkBuffer.getWritePosition() - chunkBuffer.getReadPosition();
                    ByteBuffer byteBufferM7773getMemorySK3TCg8 = chunkBuffer.getMemory();
                    int readPosition = chunkBuffer.getReadPosition();
                    int writePosition2 = chunkBuffer.getWritePosition();
                    int i3 = readPosition;
                    while (true) {
                        if (i3 < writePosition2) {
                            byte b = byteBufferM7773getMemorySK3TCg8.get(i3);
                            int i4 = b & 255;
                            if ((b & 128) != 128) {
                                boolean z7 = z6;
                                ByteBuffer byteBuffer = byteBufferM7773getMemorySK3TCg8;
                                z2 = false;
                                if (!kotlin.text.StringsKt.contains$default((CharSequence) str, (char) i4, false, 2, (Object) null)) {
                                    if (i2 == i) {
                                        bufferLimitExceeded(i);
                                        throw new KotlinNothingValueException();
                                    }
                                    i2++;
                                    z6 = z7;
                                    z5 = true;
                                    if (z) {
                                        UnsafeKt.completeReadHead(input, chunkBufferPrepareReadFirstHead);
                                    }
                                    throw th;
                                }
                                z5 = false;
                                z6 = true;
                                if (z5) {
                                    i3++;
                                    byteBufferM7773getMemorySK3TCg8 = byteBuffer;
                                }
                            } else {
                                z2 = false;
                            }
                            chunkBuffer.discardExact(i3 - readPosition);
                            z3 = z2;
                            break;
                        }
                        z2 = false;
                        chunkBuffer.discardExact(writePosition2 - readPosition);
                        z6 = z6;
                        z3 = true;
                        break;
                    }
                    int writePosition3 = writePosition - (chunkBuffer.getWritePosition() - chunkBuffer.getReadPosition());
                    if (writePosition3 > 0) {
                        chunkBuffer.rewind(writePosition3);
                        OutputKt.writeFully(output, chunkBuffer, writePosition3);
                    }
                    if (z3) {
                        try {
                            chunkBufferPrepareReadFirstHead = UnsafeKt.prepareReadNextHead(input, chunkBufferPrepareReadFirstHead);
                        } catch (Throwable th) {
                            th = th;
                            z = z2;
                        }
                    } else {
                        UnsafeKt.completeReadHead(input, chunkBufferPrepareReadFirstHead);
                        break;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    z = true;
                }
            } while (chunkBufferPrepareReadFirstHead != null);
            z4 = z6;
        }
        return (z4 || input.getEndOfInput()) ? i2 : readUTF8UntilDelimiterToSlowUtf8(input, output, str, i, i2);
    }

    /* JADX WARN: Code duplicated, block: B:123:0x01e2  */
    private static final int readUTF8UntilDelimiterToSlowUtf8(Input input, Output output, String str, int i, int i2) throws Throwable {
        int i3;
        int i4;
        int i5;
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        ChunkBuffer chunkBufferPrepareReadFirstHead;
        int i6;
        int i7;
        Input input2 = input;
        int i8 = 1;
        ChunkBuffer chunkBufferPrepareReadFirstHead2 = UnsafeKt.prepareReadFirstHead(input2, 1);
        if (chunkBufferPrepareReadFirstHead2 == null) {
            i3 = i2;
            i6 = 1;
            i7 = 1;
        } else {
            int iCoerceAtLeast = 1;
            int i9 = 1;
            ChunkBuffer chunkBuffer = chunkBufferPrepareReadFirstHead2;
            i3 = i2;
            while (true) {
                try {
                    ChunkBuffer chunkBuffer2 = chunkBuffer;
                    int writePosition = chunkBuffer2.getWritePosition() - chunkBuffer2.getReadPosition();
                    if (writePosition >= iCoerceAtLeast) {
                        try {
                            ChunkBuffer chunkBuffer3 = chunkBuffer;
                            int writePosition2 = chunkBuffer3.getWritePosition() - chunkBuffer3.getReadPosition();
                            ByteBuffer byteBufferM7773getMemorySK3TCg8 = chunkBuffer3.getMemory();
                            int readPosition = chunkBuffer3.getReadPosition();
                            int writePosition3 = chunkBuffer3.getWritePosition();
                            int i10 = readPosition;
                            int i11 = 0;
                            int i12 = 0;
                            int i13 = 0;
                            while (true) {
                                if (i10 < writePosition3) {
                                    byte b = byteBufferM7773getMemorySK3TCg8.get(i10);
                                    int i14 = b & 255;
                                    ByteBuffer byteBuffer = byteBufferM7773getMemorySK3TCg8;
                                    if ((b & 128) != 0) {
                                        if (i11 == 0) {
                                            int i15 = 128;
                                            i12 = i14;
                                            for (int i16 = 1; i16 < 7 && (i12 & i15) != 0; i16++) {
                                                i12 &= ~i15;
                                                i15 >>= 1;
                                                i11++;
                                            }
                                            int i17 = i11 - 1;
                                            if (i11 > writePosition3 - i10) {
                                                chunkBuffer3.discardExact(i10 - readPosition);
                                                i5 = i11;
                                                i4 = 0;
                                            } else {
                                                i13 = i11;
                                                i11 = i17;
                                            }
                                        } else {
                                            i12 = (i12 << 6) | (b & 127);
                                            i11--;
                                            if (i11 == 0) {
                                                if (UTF8Kt.isBmpCodePoint(i12)) {
                                                    if (kotlin.text.StringsKt.contains$default((CharSequence) str, (char) i12, false, 2, (Object) null)) {
                                                        z3 = false;
                                                    } else {
                                                        if (i3 == i) {
                                                            bufferLimitExceeded(i);
                                                            throw new KotlinNothingValueException();
                                                        }
                                                        i3++;
                                                        z3 = true;
                                                    }
                                                    if (z3) {
                                                        i4 = 0;
                                                    } else {
                                                        chunkBuffer3.discardExact(((i10 - readPosition) - i13) + 1);
                                                        i5 = -1;
                                                        i4 = 0;
                                                    }
                                                } else {
                                                    if (!UTF8Kt.isValidCodePoint(i12)) {
                                                        UTF8Kt.malformedCodePoint(i12);
                                                        throw new KotlinNothingValueException();
                                                    }
                                                    if (kotlin.text.StringsKt.contains$default((CharSequence) str, (char) UTF8Kt.highSurrogate(i12), false, 2, (Object) null)) {
                                                        z = false;
                                                    } else {
                                                        if (i3 == i) {
                                                            bufferLimitExceeded(i);
                                                            throw new KotlinNothingValueException();
                                                        }
                                                        i3++;
                                                        z = true;
                                                    }
                                                    if (z) {
                                                        i4 = 0;
                                                        if (kotlin.text.StringsKt.contains$default((CharSequence) str, (char) UTF8Kt.lowSurrogate(i12), false, 2, (Object) null)) {
                                                            z2 = false;
                                                        } else {
                                                            if (i3 == i) {
                                                                bufferLimitExceeded(i);
                                                                throw new KotlinNothingValueException();
                                                            }
                                                            i3++;
                                                            z2 = true;
                                                        }
                                                        if (!z2) {
                                                        }
                                                    } else {
                                                        i4 = 0;
                                                    }
                                                    chunkBuffer3.discardExact(((i10 - readPosition) - i13) + 1);
                                                    i5 = -1;
                                                }
                                                i12 = i4;
                                            }
                                        }
                                        i10++;
                                        byteBufferM7773getMemorySK3TCg8 = byteBuffer;
                                    } else {
                                        if (i11 != 0) {
                                            UTF8Kt.malformedByteCount(i11);
                                            throw new KotlinNothingValueException();
                                        }
                                        if (kotlin.text.StringsKt.contains$default((CharSequence) str, (char) i14, false, 2, (Object) null)) {
                                            z4 = false;
                                        } else {
                                            if (i3 == i) {
                                                bufferLimitExceeded(i);
                                                throw new KotlinNothingValueException();
                                            }
                                            i3++;
                                            z4 = true;
                                        }
                                        if (!z4) {
                                            chunkBuffer3.discardExact(i10 - readPosition);
                                            i5 = -1;
                                            i4 = 0;
                                        }
                                        i10++;
                                        byteBufferM7773getMemorySK3TCg8 = byteBuffer;
                                    }
                                } else {
                                    i4 = 0;
                                    chunkBuffer3.discardExact(writePosition3 - readPosition);
                                    i5 = 0;
                                }
                                int writePosition4 = writePosition2 - (chunkBuffer3.getWritePosition() - chunkBuffer3.getReadPosition());
                                if (writePosition4 > 0) {
                                    chunkBuffer3.rewind(writePosition4);
                                    OutputKt.writeFully(output, chunkBuffer3, writePosition4);
                                }
                                iCoerceAtLeast = i5 == -1 ? i4 : RangesKt.coerceAtLeast(i5, 1);
                                try {
                                    ChunkBuffer chunkBuffer4 = chunkBuffer;
                                    writePosition = chunkBuffer4.getWritePosition() - chunkBuffer4.getReadPosition();
                                    i9 = iCoerceAtLeast;
                                } catch (Throwable th) {
                                    th = th;
                                    i8 = 1;
                                    input2 = input;
                                    if (i8 != 0) {
                                        UnsafeKt.completeReadHead(input2, chunkBuffer);
                                    }
                                    throw th;
                                }
                            }
                        } catch (Throwable th2) {
                            ChunkBuffer chunkBuffer5 = chunkBuffer;
                            chunkBuffer5.getWritePosition();
                            chunkBuffer5.getReadPosition();
                            throw th2;
                        }
                    } else {
                        i4 = 0;
                    }
                    if (writePosition == 0) {
                        input2 = input;
                        try {
                            chunkBufferPrepareReadFirstHead = UnsafeKt.prepareReadNextHead(input2, chunkBuffer);
                        } catch (Throwable th3) {
                            th = th3;
                            i8 = i4;
                            if (i8 != 0) {
                                UnsafeKt.completeReadHead(input2, chunkBuffer);
                            }
                            throw th;
                        }
                    } else {
                        input2 = input;
                        if (writePosition >= iCoerceAtLeast) {
                            ChunkBuffer chunkBuffer6 = chunkBuffer;
                            if (chunkBuffer6.getCapacity() - chunkBuffer6.getLimit() < 8) {
                                UnsafeKt.completeReadHead(input2, chunkBuffer);
                                chunkBufferPrepareReadFirstHead = UnsafeKt.prepareReadFirstHead(input2, iCoerceAtLeast);
                            } else {
                                chunkBufferPrepareReadFirstHead = chunkBuffer;
                            }
                        } else {
                            UnsafeKt.completeReadHead(input2, chunkBuffer);
                            chunkBufferPrepareReadFirstHead = UnsafeKt.prepareReadFirstHead(input2, iCoerceAtLeast);
                        }
                    }
                    if (chunkBufferPrepareReadFirstHead == null) {
                        break;
                    }
                    chunkBuffer = chunkBufferPrepareReadFirstHead;
                    if (iCoerceAtLeast <= 0) {
                        i4 = 1;
                        break;
                    }
                    i8 = 1;
                } catch (Throwable th4) {
                    th = th4;
                }
            }
            if (i4 != 0) {
                UnsafeKt.completeReadHead(input2, chunkBuffer);
            }
            i6 = i9;
            i7 = 1;
        }
        if (i6 <= i7) {
            return i3;
        }
        prematureEndOfStream(i6);
        throw new KotlinNothingValueException();
    }

    /* JADX WARN: Code duplicated, block: B:119:0x01cf  */
    /* JADX WARN: Code duplicated, block: B:81:0x015c  */
    /* JADX WARN: Code duplicated, block: B:82:0x015e A[Catch: all -> 0x0173, TRY_LEAVE, TryCatch #0 {all -> 0x0173, blocks: (B:9:0x0026, B:11:0x003b, B:14:0x004a, B:20:0x0063, B:82:0x015e, B:77:0x014a, B:18:0x005b, B:22:0x0069, B:23:0x0071, B:24:0x0072, B:25:0x007a, B:30:0x0084, B:32:0x0088, B:33:0x0091, B:35:0x0097, B:38:0x00a5, B:40:0x00af, B:42:0x00b5, B:48:0x00ce, B:46:0x00c6, B:50:0x00d8, B:51:0x00e0, B:52:0x00e1, B:54:0x00e7, B:60:0x0104, B:71:0x012e, B:64:0x0119, B:68:0x0124, B:69:0x012c, B:58:0x00fc, B:72:0x0137, B:73:0x013f, B:74:0x0140, B:75:0x0148, B:78:0x0153), top: B:121:0x0026, outer: #3 }] */
    private static final int readUTF8UntilDelimiterToSlowUtf8(Input input, Appendable appendable, String str, int i, int i2) throws Throwable {
        int i3;
        int i4;
        int i5;
        int i6;
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        ChunkBuffer chunkBufferPrepareReadFirstHead;
        int i7;
        int i8;
        Input input2 = input;
        int i9 = 1;
        ChunkBuffer chunkBufferPrepareReadFirstHead2 = UnsafeKt.prepareReadFirstHead(input2, 1);
        if (chunkBufferPrepareReadFirstHead2 == null) {
            i3 = i2;
            i7 = 1;
            i8 = 1;
        } else {
            int iCoerceAtLeast = 1;
            int i10 = 1;
            ChunkBuffer chunkBuffer = chunkBufferPrepareReadFirstHead2;
            i3 = i2;
            while (true) {
                try {
                    ChunkBuffer chunkBuffer2 = chunkBuffer;
                    int writePosition = chunkBuffer2.getWritePosition() - chunkBuffer2.getReadPosition();
                    if (writePosition >= iCoerceAtLeast) {
                        try {
                            ChunkBuffer chunkBuffer3 = chunkBuffer;
                            ByteBuffer byteBufferM7773getMemorySK3TCg8 = chunkBuffer3.getMemory();
                            int readPosition = chunkBuffer3.getReadPosition();
                            int writePosition2 = chunkBuffer3.getWritePosition();
                            int i11 = readPosition;
                            int i12 = 0;
                            int i13 = 0;
                            int i14 = 0;
                            while (true) {
                                try {
                                    if (i11 < writePosition2) {
                                        byte b = byteBufferM7773getMemorySK3TCg8.get(i11);
                                        int i15 = b & 255;
                                        ByteBuffer byteBuffer = byteBufferM7773getMemorySK3TCg8;
                                        if ((b & 128) != 0) {
                                            if (i12 == 0) {
                                                int i16 = 128;
                                                i13 = i15;
                                                for (int i17 = 1; i17 < 7 && (i13 & i16) != 0; i17++) {
                                                    i13 &= ~i16;
                                                    i16 >>= 1;
                                                    i12++;
                                                }
                                                int i18 = i12 - 1;
                                                if (i12 > writePosition2 - i11) {
                                                    chunkBuffer3.discardExact(i11 - readPosition);
                                                    i5 = i12;
                                                    i6 = -1;
                                                    i4 = 0;
                                                } else {
                                                    i14 = i12;
                                                    i12 = i18;
                                                }
                                            } else {
                                                i13 = (i13 << 6) | (b & 127);
                                                i12--;
                                                if (i12 == 0) {
                                                    if (UTF8Kt.isBmpCodePoint(i13)) {
                                                        char c = (char) i13;
                                                        if (kotlin.text.StringsKt.contains$default((CharSequence) str, c, false, 2, (Object) null)) {
                                                            z3 = false;
                                                        } else {
                                                            if (i3 == i) {
                                                                bufferLimitExceeded(i);
                                                                throw new KotlinNothingValueException();
                                                            }
                                                            i3++;
                                                            appendable.append(c);
                                                            z3 = true;
                                                        }
                                                        if (z3) {
                                                            i4 = 0;
                                                        } else {
                                                            chunkBuffer3.discardExact(((i11 - readPosition) - i14) + 1);
                                                            i5 = -1;
                                                            i6 = -1;
                                                            i4 = 0;
                                                        }
                                                    } else {
                                                        if (!UTF8Kt.isValidCodePoint(i13)) {
                                                            UTF8Kt.malformedCodePoint(i13);
                                                            throw new KotlinNothingValueException();
                                                        }
                                                        char cHighSurrogate = (char) UTF8Kt.highSurrogate(i13);
                                                        if (kotlin.text.StringsKt.contains$default((CharSequence) str, cHighSurrogate, false, 2, (Object) null)) {
                                                            z = false;
                                                        } else {
                                                            if (i3 == i) {
                                                                bufferLimitExceeded(i);
                                                                throw new KotlinNothingValueException();
                                                            }
                                                            i3++;
                                                            appendable.append(cHighSurrogate);
                                                            z = true;
                                                        }
                                                        if (z) {
                                                            char cLowSurrogate = (char) UTF8Kt.lowSurrogate(i13);
                                                            i4 = 0;
                                                            if (kotlin.text.StringsKt.contains$default((CharSequence) str, cLowSurrogate, false, 2, (Object) null)) {
                                                                z2 = false;
                                                            } else {
                                                                if (i3 == i) {
                                                                    bufferLimitExceeded(i);
                                                                    throw new KotlinNothingValueException();
                                                                }
                                                                i3++;
                                                                appendable.append(cLowSurrogate);
                                                                z2 = true;
                                                            }
                                                            if (!z2) {
                                                            }
                                                        } else {
                                                            i4 = 0;
                                                        }
                                                        chunkBuffer3.discardExact(((i11 - readPosition) - i14) + 1);
                                                        i5 = -1;
                                                    }
                                                    i13 = i4;
                                                }
                                            }
                                            i11++;
                                            byteBufferM7773getMemorySK3TCg8 = byteBuffer;
                                        } else {
                                            if (i12 != 0) {
                                                UTF8Kt.malformedByteCount(i12);
                                                throw new KotlinNothingValueException();
                                            }
                                            char c2 = (char) i15;
                                            if (kotlin.text.StringsKt.contains$default((CharSequence) str, c2, false, 2, (Object) null)) {
                                                z4 = false;
                                            } else {
                                                if (i3 == i) {
                                                    bufferLimitExceeded(i);
                                                    throw new KotlinNothingValueException();
                                                }
                                                i3++;
                                                appendable.append(c2);
                                                z4 = true;
                                            }
                                            if (!z4) {
                                                chunkBuffer3.discardExact(i11 - readPosition);
                                                i5 = -1;
                                                i6 = -1;
                                                i4 = 0;
                                            }
                                            i11++;
                                            byteBufferM7773getMemorySK3TCg8 = byteBuffer;
                                        }
                                        if (i5 == i6) {
                                            iCoerceAtLeast = i4;
                                        } else {
                                            iCoerceAtLeast = RangesKt.coerceAtLeast(i5, 1);
                                        }
                                        ChunkBuffer chunkBuffer4 = chunkBuffer;
                                        writePosition = chunkBuffer4.getWritePosition() - chunkBuffer4.getReadPosition();
                                        i10 = iCoerceAtLeast;
                                    } else {
                                        i4 = 0;
                                        chunkBuffer3.discardExact(writePosition2 - readPosition);
                                        i5 = 0;
                                    }
                                    ChunkBuffer chunkBuffer5 = chunkBuffer;
                                    writePosition = chunkBuffer5.getWritePosition() - chunkBuffer5.getReadPosition();
                                    i10 = iCoerceAtLeast;
                                } catch (Throwable th) {
                                    th = th;
                                    i9 = 1;
                                    input2 = input;
                                    if (i9 != 0) {
                                        UnsafeKt.completeReadHead(input2, chunkBuffer);
                                    }
                                    throw th;
                                }
                                i6 = -1;
                                if (i5 == i6) {
                                    iCoerceAtLeast = i4;
                                } else {
                                    iCoerceAtLeast = RangesKt.coerceAtLeast(i5, 1);
                                }
                            }
                        } catch (Throwable th2) {
                            ChunkBuffer chunkBuffer6 = chunkBuffer;
                            chunkBuffer6.getWritePosition();
                            chunkBuffer6.getReadPosition();
                            throw th2;
                        }
                    } else {
                        i4 = 0;
                    }
                    if (writePosition == 0) {
                        input2 = input;
                        try {
                            chunkBufferPrepareReadFirstHead = UnsafeKt.prepareReadNextHead(input2, chunkBuffer);
                        } catch (Throwable th3) {
                            th = th3;
                            i9 = i4;
                            if (i9 != 0) {
                                UnsafeKt.completeReadHead(input2, chunkBuffer);
                            }
                            throw th;
                        }
                    } else {
                        input2 = input;
                        if (writePosition >= iCoerceAtLeast) {
                            ChunkBuffer chunkBuffer7 = chunkBuffer;
                            if (chunkBuffer7.getCapacity() - chunkBuffer7.getLimit() < 8) {
                                UnsafeKt.completeReadHead(input2, chunkBuffer);
                                chunkBufferPrepareReadFirstHead = UnsafeKt.prepareReadFirstHead(input2, iCoerceAtLeast);
                            } else {
                                chunkBufferPrepareReadFirstHead = chunkBuffer;
                            }
                        } else {
                            UnsafeKt.completeReadHead(input2, chunkBuffer);
                            chunkBufferPrepareReadFirstHead = UnsafeKt.prepareReadFirstHead(input2, iCoerceAtLeast);
                        }
                    }
                    if (chunkBufferPrepareReadFirstHead == null) {
                        break;
                    }
                    chunkBuffer = chunkBufferPrepareReadFirstHead;
                    if (iCoerceAtLeast <= 0) {
                        i4 = 1;
                        break;
                    }
                    i9 = 1;
                } catch (Throwable th4) {
                    th = th4;
                }
            }
            if (i4 != 0) {
                UnsafeKt.completeReadHead(input2, chunkBuffer);
            }
            i7 = i10;
            i8 = 1;
        }
        if (i7 <= i8) {
            return i3;
        }
        prematureEndOfStream(i7);
        throw new KotlinNothingValueException();
    }
}
