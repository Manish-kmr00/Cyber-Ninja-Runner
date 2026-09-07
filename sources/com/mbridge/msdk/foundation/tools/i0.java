package com.mbridge.msdk.foundation.tools;

import android.text.TextUtils;
import com.google.common.base.Ascii;
import io.ktor.util.date.GMTDateParser;
import java.util.HashMap;
import java.util.Map;
import kotlin.io.encoding.Base64;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: compiled from: SameBase64Tool.java */
/* JADX INFO: loaded from: classes3.dex */
public class i0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Map<Character, Character> f5061a;
    private static Map<Character, Character> b;
    private static byte[] c = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, -1, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, Base64.padSymbol, -1, -1, -1, -1, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, Ascii.VT, Ascii.FF, Ascii.CR, Ascii.SO, Ascii.SI, Ascii.DLE, 17, Ascii.DC2, 19, Ascii.DC4, Ascii.NAK, Ascii.SYN, Ascii.ETB, Ascii.CAN, Ascii.EM, -1, -1, -1, -1, -1, -1, Ascii.SUB, Ascii.ESC, Ascii.FS, Ascii.GS, Ascii.RS, Ascii.US, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1};
    private static char[] d = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', GMTDateParser.MONTH, 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', GMTDateParser.YEAR, 'Z', 'a', 'b', 'c', GMTDateParser.DAY_OF_MONTH, 'e', 'f', 'g', GMTDateParser.HOURS, 'i', 'j', 'k', 'l', GMTDateParser.MINUTES, 'n', 'o', 'p', 'q', 'r', GMTDateParser.SECONDS, 't', AbstractJsonLexerKt.UNICODE_ESC, 'v', 'w', 'x', 'y', GMTDateParser.ZONE, '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '+', '/'};

    static {
        HashMap map = new HashMap();
        f5061a = map;
        map.put('v', 'A');
        f5061a.put('S', 'B');
        f5061a.put('o', 'C');
        f5061a.put('a', 'D');
        f5061a.put('j', 'E');
        f5061a.put('c', 'F');
        f5061a.put('7', 'G');
        f5061a.put(Character.valueOf(GMTDateParser.DAY_OF_MONTH), 'H');
        f5061a.put('R', 'I');
        f5061a.put(Character.valueOf(GMTDateParser.ZONE), 'J');
        f5061a.put('p', 'K');
        f5061a.put('W', 'L');
        f5061a.put('i', Character.valueOf(GMTDateParser.MONTH));
        f5061a.put('f', 'N');
        f5061a.put('G', 'O');
        f5061a.put('y', 'P');
        f5061a.put('N', 'Q');
        f5061a.put('x', 'R');
        f5061a.put('Z', 'S');
        f5061a.put('n', 'T');
        f5061a.put('V', 'U');
        f5061a.put('5', 'V');
        f5061a.put('k', 'W');
        f5061a.put('+', 'X');
        f5061a.put('D', Character.valueOf(GMTDateParser.YEAR));
        f5061a.put('H', 'Z');
        f5061a.put('L', 'a');
        f5061a.put(Character.valueOf(GMTDateParser.YEAR), 'b');
        f5061a.put(Character.valueOf(GMTDateParser.HOURS), 'c');
        f5061a.put('J', Character.valueOf(GMTDateParser.DAY_OF_MONTH));
        f5061a.put('4', 'e');
        f5061a.put('6', 'f');
        f5061a.put('l', 'g');
        f5061a.put('t', Character.valueOf(GMTDateParser.HOURS));
        f5061a.put('0', 'i');
        f5061a.put('U', 'j');
        f5061a.put('3', 'k');
        f5061a.put('Q', 'l');
        f5061a.put('r', Character.valueOf(GMTDateParser.MINUTES));
        f5061a.put('g', 'n');
        f5061a.put('E', 'o');
        f5061a.put(Character.valueOf(AbstractJsonLexerKt.UNICODE_ESC), 'p');
        f5061a.put('q', 'q');
        f5061a.put('8', 'r');
        f5061a.put(Character.valueOf(GMTDateParser.SECONDS), Character.valueOf(GMTDateParser.SECONDS));
        f5061a.put('w', 't');
        f5061a.put('/', Character.valueOf(AbstractJsonLexerKt.UNICODE_ESC));
        f5061a.put('X', 'v');
        f5061a.put(Character.valueOf(GMTDateParser.MONTH), 'w');
        f5061a.put('e', 'x');
        f5061a.put('B', 'y');
        f5061a.put('A', Character.valueOf(GMTDateParser.ZONE));
        f5061a.put('T', '0');
        f5061a.put('2', '1');
        f5061a.put('F', '2');
        f5061a.put('b', '3');
        f5061a.put('9', '4');
        f5061a.put('P', '5');
        f5061a.put('1', '6');
        f5061a.put('O', '7');
        f5061a.put('I', '8');
        f5061a.put('K', '9');
        f5061a.put(Character.valueOf(GMTDateParser.MINUTES), '+');
        f5061a.put('C', '/');
        HashMap map2 = new HashMap();
        b = map2;
        map2.put('A', 'v');
        b.put('B', 'S');
        b.put('C', 'o');
        b.put('D', 'a');
        b.put('E', 'j');
        b.put('F', 'c');
        b.put('G', '7');
        b.put('H', Character.valueOf(GMTDateParser.DAY_OF_MONTH));
        b.put('I', 'R');
        b.put('J', Character.valueOf(GMTDateParser.ZONE));
        b.put('K', 'p');
        b.put('L', 'W');
        b.put(Character.valueOf(GMTDateParser.MONTH), 'i');
        b.put('N', 'f');
        b.put('O', 'G');
        b.put('P', 'y');
        b.put('Q', 'N');
        b.put('R', 'x');
        b.put('S', 'Z');
        b.put('T', 'n');
        b.put('U', 'V');
        b.put('V', '5');
        b.put('W', 'k');
        b.put('X', '+');
        b.put(Character.valueOf(GMTDateParser.YEAR), 'D');
        b.put('Z', 'H');
        b.put('a', 'L');
        b.put('b', Character.valueOf(GMTDateParser.YEAR));
        b.put('c', Character.valueOf(GMTDateParser.HOURS));
        b.put(Character.valueOf(GMTDateParser.DAY_OF_MONTH), 'J');
        b.put('e', '4');
        b.put('f', '6');
        b.put('g', 'l');
        b.put(Character.valueOf(GMTDateParser.HOURS), 't');
        b.put('i', '0');
        b.put('j', 'U');
        b.put('k', '3');
        b.put('l', 'Q');
        b.put(Character.valueOf(GMTDateParser.MINUTES), 'r');
        b.put('n', 'g');
        b.put('o', 'E');
        b.put('p', Character.valueOf(AbstractJsonLexerKt.UNICODE_ESC));
        b.put('q', 'q');
        b.put('r', '8');
        b.put(Character.valueOf(GMTDateParser.SECONDS), Character.valueOf(GMTDateParser.SECONDS));
        b.put('t', 'w');
        b.put(Character.valueOf(AbstractJsonLexerKt.UNICODE_ESC), '/');
        b.put('v', 'X');
        b.put('w', Character.valueOf(GMTDateParser.MONTH));
        b.put('x', 'e');
        b.put('y', 'B');
        b.put(Character.valueOf(GMTDateParser.ZONE), 'A');
        b.put('0', 'T');
        b.put('1', '2');
        b.put('2', 'F');
        b.put('3', 'b');
        b.put('4', '9');
        b.put('5', 'P');
        b.put('6', '1');
        b.put('7', 'O');
        b.put('8', 'I');
        b.put('9', 'K');
        b.put('+', Character.valueOf(GMTDateParser.MINUTES));
        b.put('/', 'C');
    }

    public static String a(String str) {
        return p0.b(str);
    }

    public static String b(String str) {
        return TextUtils.isEmpty(str) ? "" : p0.c(str);
    }
}
