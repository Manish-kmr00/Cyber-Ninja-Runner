package net.pubnative.lite.sdk.utils.svgparser.utils;

import java.util.Locale;

/* JADX INFO: loaded from: classes13.dex */
public class TextScanner {
    final String input;
    int inputLength;
    int position = 0;
    private final NumberParser numberParser = new NumberParser();

    boolean isEOL(int i) {
        return i == 10 || i == 13;
    }

    boolean isWhitespace(int i) {
        return i == 32 || i == 10 || i == 13 || i == 9;
    }

    public TextScanner(String str) {
        String strTrim = str.trim();
        this.input = strTrim;
        this.inputLength = strTrim.length();
    }

    public boolean empty() {
        return this.position == this.inputLength;
    }

    public void skipWhitespace() {
        while (true) {
            int i = this.position;
            if (i >= this.inputLength || !isWhitespace(this.input.charAt(i))) {
                return;
            } else {
                this.position++;
            }
        }
    }

    public boolean skipCommaWhitespace() {
        skipWhitespace();
        int i = this.position;
        if (i == this.inputLength || this.input.charAt(i) != ',') {
            return false;
        }
        this.position++;
        skipWhitespace();
        return true;
    }

    public float nextFloat() {
        float number = this.numberParser.parseNumber(this.input, this.position, this.inputLength);
        if (!Float.isNaN(number)) {
            this.position = this.numberParser.getEndPos();
        }
        return number;
    }

    float possibleNextFloat() {
        skipCommaWhitespace();
        float number = this.numberParser.parseNumber(this.input, this.position, this.inputLength);
        if (!Float.isNaN(number)) {
            this.position = this.numberParser.getEndPos();
        }
        return number;
    }

    float checkedNextFloat(float f) {
        if (Float.isNaN(f)) {
            return Float.NaN;
        }
        skipCommaWhitespace();
        return nextFloat();
    }

    float checkedNextFloat(Boolean bool) {
        if (bool == null) {
            return Float.NaN;
        }
        skipCommaWhitespace();
        return nextFloat();
    }

    Integer nextInteger(boolean z) {
        IntegerParser integerParser = IntegerParser.parseInt(this.input, this.position, this.inputLength, z);
        if (integerParser == null) {
            return null;
        }
        this.position = integerParser.getEndPos();
        return Integer.valueOf(integerParser.value());
    }

    Integer nextChar() {
        int i = this.position;
        if (i == this.inputLength) {
            return null;
        }
        String str = this.input;
        this.position = i + 1;
        return Integer.valueOf(str.charAt(i));
    }

    SVGBase.Length nextLength() {
        float fNextFloat = nextFloat();
        if (Float.isNaN(fNextFloat)) {
            return null;
        }
        SVGBase.Unit unitNextUnit = nextUnit();
        if (unitNextUnit == null) {
            return new SVGBase.Length(fNextFloat, SVGBase.Unit.px);
        }
        return new SVGBase.Length(fNextFloat, unitNextUnit);
    }

    Boolean nextFlag() {
        int i = this.position;
        if (i == this.inputLength) {
            return null;
        }
        char cCharAt = this.input.charAt(i);
        if (cCharAt != '0' && cCharAt != '1') {
            return null;
        }
        this.position++;
        return Boolean.valueOf(cCharAt == '1');
    }

    Boolean checkedNextFlag(Object obj) {
        if (obj == null) {
            return null;
        }
        skipCommaWhitespace();
        return nextFlag();
    }

    public boolean consume(char c) {
        int i = this.position;
        boolean z = i < this.inputLength && this.input.charAt(i) == c;
        if (z) {
            this.position++;
        }
        return z;
    }

    public boolean consume(String str) {
        int length = str.length();
        int i = this.position;
        boolean z = i <= this.inputLength - length && this.input.substring(i, i + length).equals(str);
        if (z) {
            this.position += length;
        }
        return z;
    }

    int advanceChar() {
        int i = this.position;
        int i2 = this.inputLength;
        if (i == i2) {
            return -1;
        }
        int i3 = i + 1;
        this.position = i3;
        if (i3 < i2) {
            return this.input.charAt(i3);
        }
        return -1;
    }

    public String nextToken() {
        return nextToken(' ', false);
    }

    public String nextToken(char c) {
        return nextToken(c, false);
    }

    String nextTokenWithWhitespace(char c) {
        return nextToken(c, true);
    }

    String nextToken(char c, boolean z) {
        if (empty()) {
            return null;
        }
        char cCharAt = this.input.charAt(this.position);
        if ((!z && isWhitespace(cCharAt)) || cCharAt == c) {
            return null;
        }
        int i = this.position;
        int iAdvanceChar = advanceChar();
        while (iAdvanceChar != -1 && iAdvanceChar != c && (z || !isWhitespace(iAdvanceChar))) {
            iAdvanceChar = advanceChar();
        }
        return this.input.substring(i, this.position);
    }

    public String nextWord() {
        if (empty()) {
            return null;
        }
        int i = this.position;
        char cCharAt = this.input.charAt(i);
        if ((cCharAt >= 'A' && cCharAt <= 'Z') || (cCharAt >= 'a' && cCharAt <= 'z')) {
            int iAdvanceChar = advanceChar();
            while (true) {
                if ((iAdvanceChar < 65 || iAdvanceChar > 90) && (iAdvanceChar < 97 || iAdvanceChar > 122)) {
                    break;
                }
                iAdvanceChar = advanceChar();
            }
            return this.input.substring(i, this.position);
        }
        this.position = i;
        return null;
    }

    String nextFunction() {
        if (empty()) {
            return null;
        }
        int i = this.position;
        int iCharAt = this.input.charAt(i);
        while (true) {
            if ((iCharAt < 97 || iCharAt > 122) && (iCharAt < 65 || iCharAt > 90)) {
                break;
            }
            iCharAt = advanceChar();
        }
        int i2 = this.position;
        while (isWhitespace(iCharAt)) {
            iCharAt = advanceChar();
        }
        if (iCharAt == 40) {
            this.position++;
            return this.input.substring(i, i2);
        }
        this.position = i;
        return null;
    }

    String ahead() {
        int i = this.position;
        while (!empty() && !isWhitespace(this.input.charAt(this.position))) {
            this.position++;
        }
        String strSubstring = this.input.substring(i, this.position);
        this.position = i;
        return strSubstring;
    }

    SVGBase.Unit nextUnit() {
        if (empty()) {
            return null;
        }
        if (this.input.charAt(this.position) == '%') {
            this.position++;
            return SVGBase.Unit.percent;
        }
        int i = this.position;
        if (i > this.inputLength - 2) {
            return null;
        }
        try {
            SVGBase.Unit unitValueOf = SVGBase.Unit.valueOf(this.input.substring(i, i + 2).toLowerCase(Locale.US));
            this.position += 2;
            return unitValueOf;
        } catch (IllegalArgumentException unused) {
            return null;
        }
    }

    boolean hasLetter() {
        int i = this.position;
        if (i == this.inputLength) {
            return false;
        }
        char cCharAt = this.input.charAt(i);
        return (cCharAt >= 'a' && cCharAt <= 'z') || (cCharAt >= 'A' && cCharAt <= 'Z');
    }

    public String nextQuotedString() {
        if (empty()) {
            return null;
        }
        int i = this.position;
        char cCharAt = this.input.charAt(i);
        if (cCharAt != '\'' && cCharAt != '\"') {
            return null;
        }
        int iAdvanceChar = advanceChar();
        while (iAdvanceChar != -1 && iAdvanceChar != cCharAt) {
            iAdvanceChar = advanceChar();
        }
        if (iAdvanceChar == -1) {
            this.position = i;
            return null;
        }
        int i2 = this.position;
        this.position = i2 + 1;
        return this.input.substring(i + 1, i2);
    }

    String restOfText() {
        if (empty()) {
            return null;
        }
        int i = this.position;
        this.position = this.inputLength;
        return this.input.substring(i);
    }
}
