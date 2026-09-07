package net.pubnative.lite.sdk.views.shape.path.parser;

/* JADX INFO: loaded from: classes11.dex */
class ParserHelper {
    private static final double[] pow10 = new double[128];
    private char current;
    private final int n;
    public int pos = 0;
    private final CharSequence s;

    static {
        int i = 0;
        while (true) {
            double[] dArr = pow10;
            if (i >= dArr.length) {
                return;
            }
            dArr[i] = Math.pow(10.0d, i);
            i++;
        }
    }

    public ParserHelper(CharSequence charSequence) {
        this.s = charSequence;
        this.n = charSequence.length();
        this.current = charSequence.charAt(this.pos);
    }

    private static float buildFloat(int i, int i2) {
        if (i2 < -125 || i == 0) {
            return 0.0f;
        }
        if (i2 >= 128) {
            return i > 0 ? Float.POSITIVE_INFINITY : Float.NEGATIVE_INFINITY;
        }
        if (i2 == 0) {
            return i;
        }
        if (i >= 67108864) {
            i++;
        }
        double d = i;
        double[] dArr = pow10;
        return (float) (i2 > 0 ? d * dArr[i2] : d / dArr[-i2]);
    }

    private char read() {
        int i = this.pos;
        int i2 = this.n;
        if (i < i2) {
            this.pos = i + 1;
        }
        int i3 = this.pos;
        if (i3 == i2) {
            return (char) 0;
        }
        return this.s.charAt(i3);
    }

    public void skipWhitespace() {
        while (true) {
            int i = this.pos;
            if (i >= this.n || !Character.isWhitespace(this.s.charAt(i))) {
                return;
            } else {
                advance();
            }
        }
    }

    void skipNumberSeparator() {
        while (true) {
            int i = this.pos;
            if (i >= this.n) {
                return;
            }
            char cCharAt = this.s.charAt(i);
            if (cCharAt != '\t' && cCharAt != '\n' && cCharAt != ' ' && cCharAt != ',') {
                return;
            } else {
                advance();
            }
        }
    }

    public void advance() {
        this.current = read();
    }

    /* JADX WARN: Code duplicated, block: B:11:0x0025 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:13:0x0028 A[LOOP:0: B:13:0x0028->B:85:?, LOOP_START] */
    /* JADX WARN: Code duplicated, block: B:19:0x0038  */
    /* JADX WARN: Code duplicated, block: B:21:0x003d  */
    /* JADX WARN: Code duplicated, block: B:22:0x0047  */
    /* JADX WARN: Code duplicated, block: B:28:0x0058  */
    /* JADX WARN: Code duplicated, block: B:31:0x0060  */
    /* JADX WARN: Code duplicated, block: B:33:0x0069 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:34:0x006b  */
    /* JADX WARN: Code duplicated, block: B:36:0x006f A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:37:0x0071 A[LOOP:1: B:37:0x0071->B:88:?, LOOP_START, PHI: r11
  0x0071: PHI (r11v11 int) = (r11v5 int), (r11v12 int) binds: [B:36:0x006f, B:88:?] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:40:0x007e A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:42:0x0081  */
    /* JADX WARN: Code duplicated, block: B:47:0x0099 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:49:0x009c  */
    /* JADX WARN: Code duplicated, block: B:51:0x00a4 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:52:0x00a6  */
    /* JADX WARN: Code duplicated, block: B:53:0x00a9  */
    /* JADX WARN: Code duplicated, block: B:55:0x00ad  */
    /* JADX WARN: Code duplicated, block: B:56:0x00ae A[PHI: r4
  0x00ae: PHI (r4v1 boolean) = (r4v0 boolean), (r4v3 boolean) binds: [B:50:0x00a2, B:55:0x00ad] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:58:0x00b7  */
    /* JADX WARN: Code duplicated, block: B:63:0x00c1 A[LOOP:3: B:63:0x00c1->B:94:?, LOOP_START] */
    /* JADX WARN: Code duplicated, block: B:66:0x00cb  */
    /* JADX WARN: Code duplicated, block: B:69:0x00cf  */
    /* JADX WARN: Code duplicated, block: B:74:0x00e4  */
    /* JADX WARN: Code duplicated, block: B:77:0x00e8  */
    /* JADX WARN: Code duplicated, block: B:86:0x007c A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:87:0x007f A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:88:? A[LOOP:1: B:37:0x0071->B:88:?, LOOP_END, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:89:0x0095 A[DONT_GENERATE, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:90:? A[FALL_THROUGH, PHI: r11
  PHI (r11v7 int) = (r11v5 int), (r11v5 int), (r11v12 int) binds: [B:32:0x0066, B:36:0x006f, B:87:0x007f] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:91:? A[LOOP:2: B:41:0x007f->B:91:?, LOOP_END, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:92:0x00cb A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:93:0x00e2 A[DONT_GENERATE, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:94:? A[LOOP:3: B:63:0x00c1->B:94:?, LOOP_END, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:95:0x00e1 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:96:? A[LOOP:4: B:67:0x00cc->B:96:?, LOOP_END, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:97:0x0056 A[DONT_GENERATE, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:98:? A[LOOP:5: B:20:0x003b->B:98:?, LOOP_END, SYNTHETIC] */
    float parseFloat() {
        boolean z;
        int i;
        int i2;
        int i3;
        boolean z2;
        char c;
        char c2;
        char c3;
        char c4;
        int i4;
        char c5;
        char c6;
        char c7;
        char c8;
        char c9;
        char c10;
        char c11 = this.current;
        int i5 = 0;
        boolean z3 = true;
        if (c11 != '+') {
            if (c11 != '-') {
                z = true;
            } else {
                z = false;
            }
            switch (this.current) {
                case '.':
                    i = 0;
                    i2 = 0;
                    i3 = 0;
                    z2 = false;
                    if (this.current == '.') {
                        c7 = read();
                        this.current = c7;
                        switch (c7) {
                            case '0':
                                if (i == 0) {
                                    while (true) {
                                        c9 = read();
                                        this.current = c9;
                                        i2--;
                                        switch (c9) {
                                            case '0':
                                                break;
                                            case '1':
                                            case '2':
                                            case '3':
                                            case '4':
                                            case '5':
                                            case '6':
                                            case '7':
                                            case '8':
                                            case '9':
                                                break;
                                            default:
                                                if (!z2) {
                                                    return 0.0f;
                                                }
                                                break;
                                        }
                                    }
                                }
                            case '1':
                            case '2':
                            case '3':
                            case '4':
                            case '5':
                            case '6':
                            case '7':
                            case '8':
                            case '9':
                                while (true) {
                                    if (i < 9) {
                                        i++;
                                        i3 = (i3 * 10) + (this.current - '0');
                                        i2--;
                                    }
                                    c8 = read();
                                    this.current = c8;
                                    switch (c8) {
                                        case '0':
                                        case '1':
                                        case '2':
                                        case '3':
                                        case '4':
                                        case '5':
                                        case '6':
                                        case '7':
                                        case '8':
                                        case '9':
                                            break;
                                    }
                                }
                                break;
                            default:
                                if (!z2) {
                                    reportUnexpectedCharacterError(c7);
                                    return 0.0f;
                                }
                                break;
                        }
                    }
                    c2 = this.current;
                    if (c2 != 'E' || c2 == 'e') {
                        c3 = read();
                        this.current = c3;
                        if (c3 == '+') {
                            c4 = read();
                            this.current = c4;
                            switch (c4) {
                                case '0':
                                case '1':
                                case '2':
                                case '3':
                                case '4':
                                case '5':
                                case '6':
                                case '7':
                                case '8':
                                case '9':
                                    break;
                                default:
                                    reportUnexpectedCharacterError(c4);
                                    return 0.0f;
                            }
                        } else if (c3 != '-') {
                            switch (c3) {
                                case '0':
                                case '1':
                                case '2':
                                case '3':
                                case '4':
                                case '5':
                                case '6':
                                case '7':
                                case '8':
                                case '9':
                                    break;
                                default:
                                    reportUnexpectedCharacterError(c3);
                                    return 0.0f;
                            }
                        } else {
                            z3 = false;
                            c4 = read();
                            this.current = c4;
                            switch (c4) {
                                case '0':
                                case '1':
                                case '2':
                                case '3':
                                case '4':
                                case '5':
                                case '6':
                                case '7':
                                case '8':
                                case '9':
                                    break;
                                default:
                                    reportUnexpectedCharacterError(c4);
                                    return 0.0f;
                            }
                        }
                        switch (this.current) {
                            case '0':
                                while (true) {
                                    c6 = read();
                                    this.current = c6;
                                    switch (c6) {
                                        case '0':
                                            break;
                                        case '1':
                                        case '2':
                                        case '3':
                                        case '4':
                                        case '5':
                                        case '6':
                                        case '7':
                                        case '8':
                                        case '9':
                                            i4 = 0;
                                            while (true) {
                                                if (i5 < 3) {
                                                    i5++;
                                                    i4 = (i4 * 10) + (this.current - '0');
                                                }
                                                c5 = read();
                                                this.current = c5;
                                                switch (c5) {
                                                    case '0':
                                                    case '1':
                                                    case '2':
                                                    case '3':
                                                    case '4':
                                                    case '5':
                                                    case '6':
                                                    case '7':
                                                    case '8':
                                                    case '9':
                                                        break;
                                                    default:
                                                        i5 = i4;
                                                        break;
                                                }
                                            }
                                            break;
                                    }
                                }
                                break;
                            case '1':
                            case '2':
                            case '3':
                            case '4':
                            case '5':
                            case '6':
                            case '7':
                            case '8':
                            case '9':
                                i4 = 0;
                                while (true) {
                                    if (i5 < 3) {
                                        i5++;
                                        i4 = (i4 * 10) + (this.current - '0');
                                    }
                                    c5 = read();
                                    this.current = c5;
                                    switch (c5) {
                                        case '0':
                                        case '1':
                                        case '2':
                                        case '3':
                                        case '4':
                                        case '5':
                                        case '6':
                                        case '7':
                                        case '8':
                                        case '9':
                                            break;
                                        default:
                                            i5 = i4;
                                            break;
                                    }
                                }
                                break;
                        }
                    }
                    if (!z3) {
                        i5 = -i5;
                    }
                    int i6 = i5 + i2;
                    if (!z) {
                        i3 = -i3;
                    }
                    return buildFloat(i3, i6);
                case '/':
                default:
                    return Float.NaN;
                case '0':
                    while (true) {
                        c10 = read();
                        this.current = c10;
                        if (c10 != '.' || c10 == 'E' || c10 == 'e') {
                            i = 0;
                            i2 = 0;
                            i3 = 0;
                            z2 = true;
                            if (this.current == '.') {
                                c7 = read();
                                this.current = c7;
                                switch (c7) {
                                    case '0':
                                        if (i == 0) {
                                            while (true) {
                                                c9 = read();
                                                this.current = c9;
                                                i2--;
                                                switch (c9) {
                                                    case '0':
                                                        break;
                                                    case '1':
                                                    case '2':
                                                    case '3':
                                                    case '4':
                                                    case '5':
                                                    case '6':
                                                    case '7':
                                                    case '8':
                                                    case '9':
                                                        break;
                                                    default:
                                                        if (!z2) {
                                                            return 0.0f;
                                                        }
                                                        break;
                                                }
                                            }
                                        }
                                    case '1':
                                    case '2':
                                    case '3':
                                    case '4':
                                    case '5':
                                    case '6':
                                    case '7':
                                    case '8':
                                    case '9':
                                        while (true) {
                                            if (i < 9) {
                                                i++;
                                                i3 = (i3 * 10) + (this.current - '0');
                                                i2--;
                                            }
                                            c8 = read();
                                            this.current = c8;
                                            switch (c8) {
                                                case '0':
                                                case '1':
                                                case '2':
                                                case '3':
                                                case '4':
                                                case '5':
                                                case '6':
                                                case '7':
                                                case '8':
                                                case '9':
                                                    break;
                                            }
                                        }
                                        break;
                                    default:
                                        if (!z2) {
                                            reportUnexpectedCharacterError(c7);
                                            return 0.0f;
                                        }
                                        break;
                                }
                            }
                            c2 = this.current;
                            if (c2 != 'E') {
                                c3 = read();
                                this.current = c3;
                                if (c3 == '+') {
                                    c4 = read();
                                    this.current = c4;
                                    switch (c4) {
                                        case '0':
                                        case '1':
                                        case '2':
                                        case '3':
                                        case '4':
                                        case '5':
                                        case '6':
                                        case '7':
                                        case '8':
                                        case '9':
                                            break;
                                        default:
                                            reportUnexpectedCharacterError(c4);
                                            return 0.0f;
                                    }
                                } else if (c3 != '-') {
                                    switch (c3) {
                                        case '0':
                                        case '1':
                                        case '2':
                                        case '3':
                                        case '4':
                                        case '5':
                                        case '6':
                                        case '7':
                                        case '8':
                                        case '9':
                                            break;
                                        default:
                                            reportUnexpectedCharacterError(c3);
                                            return 0.0f;
                                    }
                                } else {
                                    z3 = false;
                                    c4 = read();
                                    this.current = c4;
                                    switch (c4) {
                                        case '0':
                                        case '1':
                                        case '2':
                                        case '3':
                                        case '4':
                                        case '5':
                                        case '6':
                                        case '7':
                                        case '8':
                                        case '9':
                                            break;
                                        default:
                                            reportUnexpectedCharacterError(c4);
                                            return 0.0f;
                                    }
                                }
                                switch (this.current) {
                                    case '0':
                                        while (true) {
                                            c6 = read();
                                            this.current = c6;
                                            switch (c6) {
                                                case '0':
                                                    break;
                                                case '1':
                                                case '2':
                                                case '3':
                                                case '4':
                                                case '5':
                                                case '6':
                                                case '7':
                                                case '8':
                                                case '9':
                                                    i4 = 0;
                                                    while (true) {
                                                        if (i5 < 3) {
                                                            i5++;
                                                            i4 = (i4 * 10) + (this.current - '0');
                                                        }
                                                        c5 = read();
                                                        this.current = c5;
                                                        switch (c5) {
                                                            case '0':
                                                            case '1':
                                                            case '2':
                                                            case '3':
                                                            case '4':
                                                            case '5':
                                                            case '6':
                                                            case '7':
                                                            case '8':
                                                            case '9':
                                                                break;
                                                            default:
                                                                i5 = i4;
                                                                break;
                                                        }
                                                    }
                                                    break;
                                            }
                                        }
                                        break;
                                    case '1':
                                    case '2':
                                    case '3':
                                    case '4':
                                    case '5':
                                    case '6':
                                    case '7':
                                    case '8':
                                    case '9':
                                        i4 = 0;
                                        while (true) {
                                            if (i5 < 3) {
                                                i5++;
                                                i4 = (i4 * 10) + (this.current - '0');
                                            }
                                            c5 = read();
                                            this.current = c5;
                                            switch (c5) {
                                                case '0':
                                                case '1':
                                                case '2':
                                                case '3':
                                                case '4':
                                                case '5':
                                                case '6':
                                                case '7':
                                                case '8':
                                                case '9':
                                                    break;
                                                default:
                                                    i5 = i4;
                                                    break;
                                            }
                                        }
                                        break;
                                }
                            } else {
                                c3 = read();
                                this.current = c3;
                                if (c3 == '+') {
                                    c4 = read();
                                    this.current = c4;
                                    switch (c4) {
                                        case '0':
                                        case '1':
                                        case '2':
                                        case '3':
                                        case '4':
                                        case '5':
                                        case '6':
                                        case '7':
                                        case '8':
                                        case '9':
                                            break;
                                        default:
                                            reportUnexpectedCharacterError(c4);
                                            return 0.0f;
                                    }
                                } else if (c3 != '-') {
                                    switch (c3) {
                                        case '0':
                                        case '1':
                                        case '2':
                                        case '3':
                                        case '4':
                                        case '5':
                                        case '6':
                                        case '7':
                                        case '8':
                                        case '9':
                                            break;
                                        default:
                                            reportUnexpectedCharacterError(c3);
                                            return 0.0f;
                                    }
                                } else {
                                    z3 = false;
                                    c4 = read();
                                    this.current = c4;
                                    switch (c4) {
                                        case '0':
                                        case '1':
                                        case '2':
                                        case '3':
                                        case '4':
                                        case '5':
                                        case '6':
                                        case '7':
                                        case '8':
                                        case '9':
                                            break;
                                        default:
                                            reportUnexpectedCharacterError(c4);
                                            return 0.0f;
                                    }
                                }
                                switch (this.current) {
                                    case '0':
                                        while (true) {
                                            c6 = read();
                                            this.current = c6;
                                            switch (c6) {
                                                case '0':
                                                    break;
                                                case '1':
                                                case '2':
                                                case '3':
                                                case '4':
                                                case '5':
                                                case '6':
                                                case '7':
                                                case '8':
                                                case '9':
                                                    i4 = 0;
                                                    while (true) {
                                                        if (i5 < 3) {
                                                            i5++;
                                                            i4 = (i4 * 10) + (this.current - '0');
                                                        }
                                                        c5 = read();
                                                        this.current = c5;
                                                        switch (c5) {
                                                            case '0':
                                                            case '1':
                                                            case '2':
                                                            case '3':
                                                            case '4':
                                                            case '5':
                                                            case '6':
                                                            case '7':
                                                            case '8':
                                                            case '9':
                                                                break;
                                                            default:
                                                                i5 = i4;
                                                                break;
                                                        }
                                                    }
                                                    break;
                                            }
                                        }
                                        break;
                                    case '1':
                                    case '2':
                                    case '3':
                                    case '4':
                                    case '5':
                                    case '6':
                                    case '7':
                                    case '8':
                                    case '9':
                                        i4 = 0;
                                        while (true) {
                                            if (i5 < 3) {
                                                i5++;
                                                i4 = (i4 * 10) + (this.current - '0');
                                            }
                                            c5 = read();
                                            this.current = c5;
                                            switch (c5) {
                                                case '0':
                                                case '1':
                                                case '2':
                                                case '3':
                                                case '4':
                                                case '5':
                                                case '6':
                                                case '7':
                                                case '8':
                                                case '9':
                                                    break;
                                                default:
                                                    i5 = i4;
                                                    break;
                                            }
                                        }
                                        break;
                                }
                            }
                            if (!z3) {
                                i5 = -i5;
                            }
                            int i7 = i5 + i2;
                            if (!z) {
                                i3 = -i3;
                            }
                            return buildFloat(i3, i7);
                        }
                        switch (c10) {
                            case '0':
                                break;
                            case '1':
                            case '2':
                            case '3':
                            case '4':
                            case '5':
                            case '6':
                            case '7':
                            case '8':
                            case '9':
                                break;
                            default:
                                return 0.0f;
                        }
                        i = 0;
                        i2 = 0;
                        i3 = 0;
                        while (true) {
                            if (i < 9) {
                                i++;
                                i3 = (i3 * 10) + (this.current - '0');
                            } else {
                                i2++;
                            }
                            c = read();
                            this.current = c;
                            switch (c) {
                                case '0':
                                case '1':
                                case '2':
                                case '3':
                                case '4':
                                case '5':
                                case '6':
                                case '7':
                                case '8':
                                case '9':
                                    break;
                            }
                            z2 = true;
                            if (this.current == '.') {
                                c7 = read();
                                this.current = c7;
                                switch (c7) {
                                    case '0':
                                        if (i == 0) {
                                            while (true) {
                                                c9 = read();
                                                this.current = c9;
                                                i2--;
                                                switch (c9) {
                                                    case '0':
                                                        break;
                                                    case '1':
                                                    case '2':
                                                    case '3':
                                                    case '4':
                                                    case '5':
                                                    case '6':
                                                    case '7':
                                                    case '8':
                                                    case '9':
                                                        break;
                                                    default:
                                                        if (!z2) {
                                                            return 0.0f;
                                                        }
                                                        break;
                                                }
                                            }
                                        }
                                    case '1':
                                    case '2':
                                    case '3':
                                    case '4':
                                    case '5':
                                    case '6':
                                    case '7':
                                    case '8':
                                    case '9':
                                        while (true) {
                                            if (i < 9) {
                                                i++;
                                                i3 = (i3 * 10) + (this.current - '0');
                                                i2--;
                                            }
                                            c8 = read();
                                            this.current = c8;
                                            switch (c8) {
                                                case '0':
                                                case '1':
                                                case '2':
                                                case '3':
                                                case '4':
                                                case '5':
                                                case '6':
                                                case '7':
                                                case '8':
                                                case '9':
                                                    break;
                                            }
                                        }
                                        break;
                                    default:
                                        if (!z2) {
                                            reportUnexpectedCharacterError(c7);
                                            return 0.0f;
                                        }
                                        break;
                                }
                            }
                            c2 = this.current;
                            if (c2 != 'E') {
                                c3 = read();
                                this.current = c3;
                                if (c3 == '+') {
                                    c4 = read();
                                    this.current = c4;
                                    switch (c4) {
                                        case '0':
                                        case '1':
                                        case '2':
                                        case '3':
                                        case '4':
                                        case '5':
                                        case '6':
                                        case '7':
                                        case '8':
                                        case '9':
                                            break;
                                        default:
                                            reportUnexpectedCharacterError(c4);
                                            return 0.0f;
                                    }
                                } else if (c3 != '-') {
                                    switch (c3) {
                                        case '0':
                                        case '1':
                                        case '2':
                                        case '3':
                                        case '4':
                                        case '5':
                                        case '6':
                                        case '7':
                                        case '8':
                                        case '9':
                                            break;
                                        default:
                                            reportUnexpectedCharacterError(c3);
                                            return 0.0f;
                                    }
                                } else {
                                    z3 = false;
                                    c4 = read();
                                    this.current = c4;
                                    switch (c4) {
                                        case '0':
                                        case '1':
                                        case '2':
                                        case '3':
                                        case '4':
                                        case '5':
                                        case '6':
                                        case '7':
                                        case '8':
                                        case '9':
                                            break;
                                        default:
                                            reportUnexpectedCharacterError(c4);
                                            return 0.0f;
                                    }
                                }
                                switch (this.current) {
                                    case '0':
                                        while (true) {
                                            c6 = read();
                                            this.current = c6;
                                            switch (c6) {
                                                case '0':
                                                    break;
                                                case '1':
                                                case '2':
                                                case '3':
                                                case '4':
                                                case '5':
                                                case '6':
                                                case '7':
                                                case '8':
                                                case '9':
                                                    i4 = 0;
                                                    while (true) {
                                                        if (i5 < 3) {
                                                            i5++;
                                                            i4 = (i4 * 10) + (this.current - '0');
                                                        }
                                                        c5 = read();
                                                        this.current = c5;
                                                        switch (c5) {
                                                            case '0':
                                                            case '1':
                                                            case '2':
                                                            case '3':
                                                            case '4':
                                                            case '5':
                                                            case '6':
                                                            case '7':
                                                            case '8':
                                                            case '9':
                                                                break;
                                                            default:
                                                                i5 = i4;
                                                                break;
                                                        }
                                                    }
                                                    break;
                                            }
                                        }
                                        break;
                                    case '1':
                                    case '2':
                                    case '3':
                                    case '4':
                                    case '5':
                                    case '6':
                                    case '7':
                                    case '8':
                                    case '9':
                                        i4 = 0;
                                        while (true) {
                                            if (i5 < 3) {
                                                i5++;
                                                i4 = (i4 * 10) + (this.current - '0');
                                            }
                                            c5 = read();
                                            this.current = c5;
                                            switch (c5) {
                                                case '0':
                                                case '1':
                                                case '2':
                                                case '3':
                                                case '4':
                                                case '5':
                                                case '6':
                                                case '7':
                                                case '8':
                                                case '9':
                                                    break;
                                                default:
                                                    i5 = i4;
                                                    break;
                                            }
                                        }
                                        break;
                                }
                            } else {
                                c3 = read();
                                this.current = c3;
                                if (c3 == '+') {
                                    c4 = read();
                                    this.current = c4;
                                    switch (c4) {
                                        case '0':
                                        case '1':
                                        case '2':
                                        case '3':
                                        case '4':
                                        case '5':
                                        case '6':
                                        case '7':
                                        case '8':
                                        case '9':
                                            break;
                                        default:
                                            reportUnexpectedCharacterError(c4);
                                            return 0.0f;
                                    }
                                } else if (c3 != '-') {
                                    switch (c3) {
                                        case '0':
                                        case '1':
                                        case '2':
                                        case '3':
                                        case '4':
                                        case '5':
                                        case '6':
                                        case '7':
                                        case '8':
                                        case '9':
                                            break;
                                        default:
                                            reportUnexpectedCharacterError(c3);
                                            return 0.0f;
                                    }
                                } else {
                                    z3 = false;
                                    c4 = read();
                                    this.current = c4;
                                    switch (c4) {
                                        case '0':
                                        case '1':
                                        case '2':
                                        case '3':
                                        case '4':
                                        case '5':
                                        case '6':
                                        case '7':
                                        case '8':
                                        case '9':
                                            break;
                                        default:
                                            reportUnexpectedCharacterError(c4);
                                            return 0.0f;
                                    }
                                }
                                switch (this.current) {
                                    case '0':
                                        while (true) {
                                            c6 = read();
                                            this.current = c6;
                                            switch (c6) {
                                                case '0':
                                                    break;
                                                case '1':
                                                case '2':
                                                case '3':
                                                case '4':
                                                case '5':
                                                case '6':
                                                case '7':
                                                case '8':
                                                case '9':
                                                    i4 = 0;
                                                    while (true) {
                                                        if (i5 < 3) {
                                                            i5++;
                                                            i4 = (i4 * 10) + (this.current - '0');
                                                        }
                                                        c5 = read();
                                                        this.current = c5;
                                                        switch (c5) {
                                                            case '0':
                                                            case '1':
                                                            case '2':
                                                            case '3':
                                                            case '4':
                                                            case '5':
                                                            case '6':
                                                            case '7':
                                                            case '8':
                                                            case '9':
                                                                break;
                                                            default:
                                                                i5 = i4;
                                                                break;
                                                        }
                                                    }
                                                    break;
                                            }
                                        }
                                        break;
                                    case '1':
                                    case '2':
                                    case '3':
                                    case '4':
                                    case '5':
                                    case '6':
                                    case '7':
                                    case '8':
                                    case '9':
                                        i4 = 0;
                                        while (true) {
                                            if (i5 < 3) {
                                                i5++;
                                                i4 = (i4 * 10) + (this.current - '0');
                                            }
                                            c5 = read();
                                            this.current = c5;
                                            switch (c5) {
                                                case '0':
                                                case '1':
                                                case '2':
                                                case '3':
                                                case '4':
                                                case '5':
                                                case '6':
                                                case '7':
                                                case '8':
                                                case '9':
                                                    break;
                                                default:
                                                    i5 = i4;
                                                    break;
                                            }
                                        }
                                        break;
                                }
                            }
                            if (!z3) {
                                i5 = -i5;
                            }
                            int i8 = i5 + i2;
                            if (!z) {
                                i3 = -i3;
                            }
                            return buildFloat(i3, i8);
                        }
                    }
                case '1':
                case '2':
                case '3':
                case '4':
                case '5':
                case '6':
                case '7':
                case '8':
                case '9':
                    i = 0;
                    i2 = 0;
                    i3 = 0;
                    while (true) {
                        if (i < 9) {
                            i++;
                            i3 = (i3 * 10) + (this.current - '0');
                        } else {
                            i2++;
                        }
                        c = read();
                        this.current = c;
                        switch (c) {
                            case '0':
                            case '1':
                            case '2':
                            case '3':
                            case '4':
                            case '5':
                            case '6':
                            case '7':
                            case '8':
                            case '9':
                                break;
                        }
                        z2 = true;
                        if (this.current == '.') {
                            c7 = read();
                            this.current = c7;
                            switch (c7) {
                                case '0':
                                    if (i == 0) {
                                        while (true) {
                                            c9 = read();
                                            this.current = c9;
                                            i2--;
                                            switch (c9) {
                                                case '0':
                                                    break;
                                                case '1':
                                                case '2':
                                                case '3':
                                                case '4':
                                                case '5':
                                                case '6':
                                                case '7':
                                                case '8':
                                                case '9':
                                                    break;
                                                default:
                                                    if (!z2) {
                                                        return 0.0f;
                                                    }
                                                    break;
                                            }
                                        }
                                    }
                                case '1':
                                case '2':
                                case '3':
                                case '4':
                                case '5':
                                case '6':
                                case '7':
                                case '8':
                                case '9':
                                    while (true) {
                                        if (i < 9) {
                                            i++;
                                            i3 = (i3 * 10) + (this.current - '0');
                                            i2--;
                                        }
                                        c8 = read();
                                        this.current = c8;
                                        switch (c8) {
                                            case '0':
                                            case '1':
                                            case '2':
                                            case '3':
                                            case '4':
                                            case '5':
                                            case '6':
                                            case '7':
                                            case '8':
                                            case '9':
                                                break;
                                        }
                                    }
                                    break;
                                default:
                                    if (!z2) {
                                        reportUnexpectedCharacterError(c7);
                                        return 0.0f;
                                    }
                                    break;
                            }
                        }
                        c2 = this.current;
                        if (c2 != 'E') {
                            c3 = read();
                            this.current = c3;
                            if (c3 == '+') {
                                c4 = read();
                                this.current = c4;
                                switch (c4) {
                                    case '0':
                                    case '1':
                                    case '2':
                                    case '3':
                                    case '4':
                                    case '5':
                                    case '6':
                                    case '7':
                                    case '8':
                                    case '9':
                                        break;
                                    default:
                                        reportUnexpectedCharacterError(c4);
                                        return 0.0f;
                                }
                            } else if (c3 != '-') {
                                switch (c3) {
                                    case '0':
                                    case '1':
                                    case '2':
                                    case '3':
                                    case '4':
                                    case '5':
                                    case '6':
                                    case '7':
                                    case '8':
                                    case '9':
                                        break;
                                    default:
                                        reportUnexpectedCharacterError(c3);
                                        return 0.0f;
                                }
                            } else {
                                z3 = false;
                                c4 = read();
                                this.current = c4;
                                switch (c4) {
                                    case '0':
                                    case '1':
                                    case '2':
                                    case '3':
                                    case '4':
                                    case '5':
                                    case '6':
                                    case '7':
                                    case '8':
                                    case '9':
                                        break;
                                    default:
                                        reportUnexpectedCharacterError(c4);
                                        return 0.0f;
                                }
                            }
                            switch (this.current) {
                                case '0':
                                    while (true) {
                                        c6 = read();
                                        this.current = c6;
                                        switch (c6) {
                                            case '0':
                                                break;
                                            case '1':
                                            case '2':
                                            case '3':
                                            case '4':
                                            case '5':
                                            case '6':
                                            case '7':
                                            case '8':
                                            case '9':
                                                i4 = 0;
                                                while (true) {
                                                    if (i5 < 3) {
                                                        i5++;
                                                        i4 = (i4 * 10) + (this.current - '0');
                                                    }
                                                    c5 = read();
                                                    this.current = c5;
                                                    switch (c5) {
                                                        case '0':
                                                        case '1':
                                                        case '2':
                                                        case '3':
                                                        case '4':
                                                        case '5':
                                                        case '6':
                                                        case '7':
                                                        case '8':
                                                        case '9':
                                                            break;
                                                        default:
                                                            i5 = i4;
                                                            break;
                                                    }
                                                }
                                                break;
                                        }
                                    }
                                    break;
                                case '1':
                                case '2':
                                case '3':
                                case '4':
                                case '5':
                                case '6':
                                case '7':
                                case '8':
                                case '9':
                                    i4 = 0;
                                    while (true) {
                                        if (i5 < 3) {
                                            i5++;
                                            i4 = (i4 * 10) + (this.current - '0');
                                        }
                                        c5 = read();
                                        this.current = c5;
                                        switch (c5) {
                                            case '0':
                                            case '1':
                                            case '2':
                                            case '3':
                                            case '4':
                                            case '5':
                                            case '6':
                                            case '7':
                                            case '8':
                                            case '9':
                                                break;
                                            default:
                                                i5 = i4;
                                                break;
                                        }
                                    }
                                    break;
                            }
                        } else {
                            c3 = read();
                            this.current = c3;
                            if (c3 == '+') {
                                c4 = read();
                                this.current = c4;
                                switch (c4) {
                                    case '0':
                                    case '1':
                                    case '2':
                                    case '3':
                                    case '4':
                                    case '5':
                                    case '6':
                                    case '7':
                                    case '8':
                                    case '9':
                                        break;
                                    default:
                                        reportUnexpectedCharacterError(c4);
                                        return 0.0f;
                                }
                            } else if (c3 != '-') {
                                switch (c3) {
                                    case '0':
                                    case '1':
                                    case '2':
                                    case '3':
                                    case '4':
                                    case '5':
                                    case '6':
                                    case '7':
                                    case '8':
                                    case '9':
                                        break;
                                    default:
                                        reportUnexpectedCharacterError(c3);
                                        return 0.0f;
                                }
                            } else {
                                z3 = false;
                                c4 = read();
                                this.current = c4;
                                switch (c4) {
                                    case '0':
                                    case '1':
                                    case '2':
                                    case '3':
                                    case '4':
                                    case '5':
                                    case '6':
                                    case '7':
                                    case '8':
                                    case '9':
                                        break;
                                    default:
                                        reportUnexpectedCharacterError(c4);
                                        return 0.0f;
                                }
                            }
                            switch (this.current) {
                                case '0':
                                    while (true) {
                                        c6 = read();
                                        this.current = c6;
                                        switch (c6) {
                                            case '0':
                                                break;
                                            case '1':
                                            case '2':
                                            case '3':
                                            case '4':
                                            case '5':
                                            case '6':
                                            case '7':
                                            case '8':
                                            case '9':
                                                i4 = 0;
                                                while (true) {
                                                    if (i5 < 3) {
                                                        i5++;
                                                        i4 = (i4 * 10) + (this.current - '0');
                                                    }
                                                    c5 = read();
                                                    this.current = c5;
                                                    switch (c5) {
                                                        case '0':
                                                        case '1':
                                                        case '2':
                                                        case '3':
                                                        case '4':
                                                        case '5':
                                                        case '6':
                                                        case '7':
                                                        case '8':
                                                        case '9':
                                                            break;
                                                        default:
                                                            i5 = i4;
                                                            break;
                                                    }
                                                }
                                                break;
                                        }
                                    }
                                    break;
                                case '1':
                                case '2':
                                case '3':
                                case '4':
                                case '5':
                                case '6':
                                case '7':
                                case '8':
                                case '9':
                                    i4 = 0;
                                    while (true) {
                                        if (i5 < 3) {
                                            i5++;
                                            i4 = (i4 * 10) + (this.current - '0');
                                        }
                                        c5 = read();
                                        this.current = c5;
                                        switch (c5) {
                                            case '0':
                                            case '1':
                                            case '2':
                                            case '3':
                                            case '4':
                                            case '5':
                                            case '6':
                                            case '7':
                                            case '8':
                                            case '9':
                                                break;
                                            default:
                                                i5 = i4;
                                                break;
                                        }
                                    }
                                    break;
                            }
                        }
                        if (!z3) {
                            i5 = -i5;
                        }
                        int i9 = i5 + i2;
                        if (!z) {
                            i3 = -i3;
                        }
                        return buildFloat(i3, i9);
                    }
            }
        }
        z = true;
        this.current = read();
        switch (this.current) {
            case '.':
                i = 0;
                i2 = 0;
                i3 = 0;
                z2 = false;
                if (this.current == '.') {
                    c7 = read();
                    this.current = c7;
                    switch (c7) {
                        case '0':
                            if (i == 0) {
                                while (true) {
                                    c9 = read();
                                    this.current = c9;
                                    i2--;
                                    switch (c9) {
                                        case '0':
                                            break;
                                        case '1':
                                        case '2':
                                        case '3':
                                        case '4':
                                        case '5':
                                        case '6':
                                        case '7':
                                        case '8':
                                        case '9':
                                            break;
                                        default:
                                            if (!z2) {
                                                return 0.0f;
                                            }
                                            break;
                                    }
                                }
                            }
                        case '1':
                        case '2':
                        case '3':
                        case '4':
                        case '5':
                        case '6':
                        case '7':
                        case '8':
                        case '9':
                            while (true) {
                                if (i < 9) {
                                    i++;
                                    i3 = (i3 * 10) + (this.current - '0');
                                    i2--;
                                }
                                c8 = read();
                                this.current = c8;
                                switch (c8) {
                                    case '0':
                                    case '1':
                                    case '2':
                                    case '3':
                                    case '4':
                                    case '5':
                                    case '6':
                                    case '7':
                                    case '8':
                                    case '9':
                                        break;
                                }
                            }
                            break;
                        default:
                            if (!z2) {
                                reportUnexpectedCharacterError(c7);
                                return 0.0f;
                            }
                            break;
                    }
                }
                c2 = this.current;
                if (c2 != 'E') {
                    c3 = read();
                    this.current = c3;
                    if (c3 == '+') {
                        c4 = read();
                        this.current = c4;
                        switch (c4) {
                            case '0':
                            case '1':
                            case '2':
                            case '3':
                            case '4':
                            case '5':
                            case '6':
                            case '7':
                            case '8':
                            case '9':
                                break;
                            default:
                                reportUnexpectedCharacterError(c4);
                                return 0.0f;
                        }
                    } else if (c3 != '-') {
                        switch (c3) {
                            case '0':
                            case '1':
                            case '2':
                            case '3':
                            case '4':
                            case '5':
                            case '6':
                            case '7':
                            case '8':
                            case '9':
                                break;
                            default:
                                reportUnexpectedCharacterError(c3);
                                return 0.0f;
                        }
                    } else {
                        z3 = false;
                        c4 = read();
                        this.current = c4;
                        switch (c4) {
                            case '0':
                            case '1':
                            case '2':
                            case '3':
                            case '4':
                            case '5':
                            case '6':
                            case '7':
                            case '8':
                            case '9':
                                break;
                            default:
                                reportUnexpectedCharacterError(c4);
                                return 0.0f;
                        }
                    }
                    switch (this.current) {
                        case '0':
                            while (true) {
                                c6 = read();
                                this.current = c6;
                                switch (c6) {
                                    case '0':
                                        break;
                                    case '1':
                                    case '2':
                                    case '3':
                                    case '4':
                                    case '5':
                                    case '6':
                                    case '7':
                                    case '8':
                                    case '9':
                                        i4 = 0;
                                        while (true) {
                                            if (i5 < 3) {
                                                i5++;
                                                i4 = (i4 * 10) + (this.current - '0');
                                            }
                                            c5 = read();
                                            this.current = c5;
                                            switch (c5) {
                                                case '0':
                                                case '1':
                                                case '2':
                                                case '3':
                                                case '4':
                                                case '5':
                                                case '6':
                                                case '7':
                                                case '8':
                                                case '9':
                                                    break;
                                                default:
                                                    i5 = i4;
                                                    break;
                                            }
                                        }
                                        break;
                                }
                            }
                            break;
                        case '1':
                        case '2':
                        case '3':
                        case '4':
                        case '5':
                        case '6':
                        case '7':
                        case '8':
                        case '9':
                            i4 = 0;
                            while (true) {
                                if (i5 < 3) {
                                    i5++;
                                    i4 = (i4 * 10) + (this.current - '0');
                                }
                                c5 = read();
                                this.current = c5;
                                switch (c5) {
                                    case '0':
                                    case '1':
                                    case '2':
                                    case '3':
                                    case '4':
                                    case '5':
                                    case '6':
                                    case '7':
                                    case '8':
                                    case '9':
                                        break;
                                    default:
                                        i5 = i4;
                                        break;
                                }
                            }
                            break;
                    }
                } else {
                    c3 = read();
                    this.current = c3;
                    if (c3 == '+') {
                        c4 = read();
                        this.current = c4;
                        switch (c4) {
                            case '0':
                            case '1':
                            case '2':
                            case '3':
                            case '4':
                            case '5':
                            case '6':
                            case '7':
                            case '8':
                            case '9':
                                break;
                            default:
                                reportUnexpectedCharacterError(c4);
                                return 0.0f;
                        }
                    } else if (c3 != '-') {
                        switch (c3) {
                            case '0':
                            case '1':
                            case '2':
                            case '3':
                            case '4':
                            case '5':
                            case '6':
                            case '7':
                            case '8':
                            case '9':
                                break;
                            default:
                                reportUnexpectedCharacterError(c3);
                                return 0.0f;
                        }
                    } else {
                        z3 = false;
                        c4 = read();
                        this.current = c4;
                        switch (c4) {
                            case '0':
                            case '1':
                            case '2':
                            case '3':
                            case '4':
                            case '5':
                            case '6':
                            case '7':
                            case '8':
                            case '9':
                                break;
                            default:
                                reportUnexpectedCharacterError(c4);
                                return 0.0f;
                        }
                    }
                    switch (this.current) {
                        case '0':
                            while (true) {
                                c6 = read();
                                this.current = c6;
                                switch (c6) {
                                    case '0':
                                        break;
                                    case '1':
                                    case '2':
                                    case '3':
                                    case '4':
                                    case '5':
                                    case '6':
                                    case '7':
                                    case '8':
                                    case '9':
                                        i4 = 0;
                                        while (true) {
                                            if (i5 < 3) {
                                                i5++;
                                                i4 = (i4 * 10) + (this.current - '0');
                                            }
                                            c5 = read();
                                            this.current = c5;
                                            switch (c5) {
                                                case '0':
                                                case '1':
                                                case '2':
                                                case '3':
                                                case '4':
                                                case '5':
                                                case '6':
                                                case '7':
                                                case '8':
                                                case '9':
                                                    break;
                                                default:
                                                    i5 = i4;
                                                    break;
                                            }
                                        }
                                        break;
                                }
                            }
                            break;
                        case '1':
                        case '2':
                        case '3':
                        case '4':
                        case '5':
                        case '6':
                        case '7':
                        case '8':
                        case '9':
                            i4 = 0;
                            while (true) {
                                if (i5 < 3) {
                                    i5++;
                                    i4 = (i4 * 10) + (this.current - '0');
                                }
                                c5 = read();
                                this.current = c5;
                                switch (c5) {
                                    case '0':
                                    case '1':
                                    case '2':
                                    case '3':
                                    case '4':
                                    case '5':
                                    case '6':
                                    case '7':
                                    case '8':
                                    case '9':
                                        break;
                                    default:
                                        i5 = i4;
                                        break;
                                }
                            }
                            break;
                    }
                }
                if (!z3) {
                    i5 = -i5;
                }
                int i10 = i5 + i2;
                if (!z) {
                    i3 = -i3;
                }
                return buildFloat(i3, i10);
            case '/':
            default:
                return Float.NaN;
            case '0':
                while (true) {
                    c10 = read();
                    this.current = c10;
                    if (c10 != '.') {
                    }
                    i = 0;
                    i2 = 0;
                    i3 = 0;
                    z2 = true;
                    if (this.current == '.') {
                        c7 = read();
                        this.current = c7;
                        switch (c7) {
                            case '0':
                                if (i == 0) {
                                    while (true) {
                                        c9 = read();
                                        this.current = c9;
                                        i2--;
                                        switch (c9) {
                                            case '0':
                                                break;
                                            case '1':
                                            case '2':
                                            case '3':
                                            case '4':
                                            case '5':
                                            case '6':
                                            case '7':
                                            case '8':
                                            case '9':
                                                break;
                                            default:
                                                if (!z2) {
                                                    return 0.0f;
                                                }
                                                break;
                                        }
                                    }
                                }
                            case '1':
                            case '2':
                            case '3':
                            case '4':
                            case '5':
                            case '6':
                            case '7':
                            case '8':
                            case '9':
                                while (true) {
                                    if (i < 9) {
                                        i++;
                                        i3 = (i3 * 10) + (this.current - '0');
                                        i2--;
                                    }
                                    c8 = read();
                                    this.current = c8;
                                    switch (c8) {
                                        case '0':
                                        case '1':
                                        case '2':
                                        case '3':
                                        case '4':
                                        case '5':
                                        case '6':
                                        case '7':
                                        case '8':
                                        case '9':
                                            break;
                                    }
                                }
                                break;
                            default:
                                if (!z2) {
                                    reportUnexpectedCharacterError(c7);
                                    return 0.0f;
                                }
                                break;
                        }
                    }
                    c2 = this.current;
                    if (c2 != 'E') {
                        c3 = read();
                        this.current = c3;
                        if (c3 == '+') {
                            c4 = read();
                            this.current = c4;
                            switch (c4) {
                                case '0':
                                case '1':
                                case '2':
                                case '3':
                                case '4':
                                case '5':
                                case '6':
                                case '7':
                                case '8':
                                case '9':
                                    break;
                                default:
                                    reportUnexpectedCharacterError(c4);
                                    return 0.0f;
                            }
                        } else if (c3 != '-') {
                            switch (c3) {
                                case '0':
                                case '1':
                                case '2':
                                case '3':
                                case '4':
                                case '5':
                                case '6':
                                case '7':
                                case '8':
                                case '9':
                                    break;
                                default:
                                    reportUnexpectedCharacterError(c3);
                                    return 0.0f;
                            }
                        } else {
                            z3 = false;
                            c4 = read();
                            this.current = c4;
                            switch (c4) {
                                case '0':
                                case '1':
                                case '2':
                                case '3':
                                case '4':
                                case '5':
                                case '6':
                                case '7':
                                case '8':
                                case '9':
                                    break;
                                default:
                                    reportUnexpectedCharacterError(c4);
                                    return 0.0f;
                            }
                        }
                        switch (this.current) {
                            case '0':
                                while (true) {
                                    c6 = read();
                                    this.current = c6;
                                    switch (c6) {
                                        case '0':
                                            break;
                                        case '1':
                                        case '2':
                                        case '3':
                                        case '4':
                                        case '5':
                                        case '6':
                                        case '7':
                                        case '8':
                                        case '9':
                                            i4 = 0;
                                            while (true) {
                                                if (i5 < 3) {
                                                    i5++;
                                                    i4 = (i4 * 10) + (this.current - '0');
                                                }
                                                c5 = read();
                                                this.current = c5;
                                                switch (c5) {
                                                    case '0':
                                                    case '1':
                                                    case '2':
                                                    case '3':
                                                    case '4':
                                                    case '5':
                                                    case '6':
                                                    case '7':
                                                    case '8':
                                                    case '9':
                                                        break;
                                                    default:
                                                        i5 = i4;
                                                        break;
                                                }
                                            }
                                            break;
                                    }
                                }
                                break;
                            case '1':
                            case '2':
                            case '3':
                            case '4':
                            case '5':
                            case '6':
                            case '7':
                            case '8':
                            case '9':
                                i4 = 0;
                                while (true) {
                                    if (i5 < 3) {
                                        i5++;
                                        i4 = (i4 * 10) + (this.current - '0');
                                    }
                                    c5 = read();
                                    this.current = c5;
                                    switch (c5) {
                                        case '0':
                                        case '1':
                                        case '2':
                                        case '3':
                                        case '4':
                                        case '5':
                                        case '6':
                                        case '7':
                                        case '8':
                                        case '9':
                                            break;
                                        default:
                                            i5 = i4;
                                            break;
                                    }
                                }
                                break;
                        }
                    } else {
                        c3 = read();
                        this.current = c3;
                        if (c3 == '+') {
                            c4 = read();
                            this.current = c4;
                            switch (c4) {
                                case '0':
                                case '1':
                                case '2':
                                case '3':
                                case '4':
                                case '5':
                                case '6':
                                case '7':
                                case '8':
                                case '9':
                                    break;
                                default:
                                    reportUnexpectedCharacterError(c4);
                                    return 0.0f;
                            }
                        } else if (c3 != '-') {
                            switch (c3) {
                                case '0':
                                case '1':
                                case '2':
                                case '3':
                                case '4':
                                case '5':
                                case '6':
                                case '7':
                                case '8':
                                case '9':
                                    break;
                                default:
                                    reportUnexpectedCharacterError(c3);
                                    return 0.0f;
                            }
                        } else {
                            z3 = false;
                            c4 = read();
                            this.current = c4;
                            switch (c4) {
                                case '0':
                                case '1':
                                case '2':
                                case '3':
                                case '4':
                                case '5':
                                case '6':
                                case '7':
                                case '8':
                                case '9':
                                    break;
                                default:
                                    reportUnexpectedCharacterError(c4);
                                    return 0.0f;
                            }
                        }
                        switch (this.current) {
                            case '0':
                                while (true) {
                                    c6 = read();
                                    this.current = c6;
                                    switch (c6) {
                                        case '0':
                                            break;
                                        case '1':
                                        case '2':
                                        case '3':
                                        case '4':
                                        case '5':
                                        case '6':
                                        case '7':
                                        case '8':
                                        case '9':
                                            i4 = 0;
                                            while (true) {
                                                if (i5 < 3) {
                                                    i5++;
                                                    i4 = (i4 * 10) + (this.current - '0');
                                                }
                                                c5 = read();
                                                this.current = c5;
                                                switch (c5) {
                                                    case '0':
                                                    case '1':
                                                    case '2':
                                                    case '3':
                                                    case '4':
                                                    case '5':
                                                    case '6':
                                                    case '7':
                                                    case '8':
                                                    case '9':
                                                        break;
                                                    default:
                                                        i5 = i4;
                                                        break;
                                                }
                                            }
                                            break;
                                    }
                                }
                                break;
                            case '1':
                            case '2':
                            case '3':
                            case '4':
                            case '5':
                            case '6':
                            case '7':
                            case '8':
                            case '9':
                                i4 = 0;
                                while (true) {
                                    if (i5 < 3) {
                                        i5++;
                                        i4 = (i4 * 10) + (this.current - '0');
                                    }
                                    c5 = read();
                                    this.current = c5;
                                    switch (c5) {
                                        case '0':
                                        case '1':
                                        case '2':
                                        case '3':
                                        case '4':
                                        case '5':
                                        case '6':
                                        case '7':
                                        case '8':
                                        case '9':
                                            break;
                                        default:
                                            i5 = i4;
                                            break;
                                    }
                                }
                                break;
                        }
                    }
                    if (!z3) {
                        i5 = -i5;
                    }
                    int i11 = i5 + i2;
                    if (!z) {
                        i3 = -i3;
                    }
                    return buildFloat(i3, i11);
                }
                break;
            case '1':
            case '2':
            case '3':
            case '4':
            case '5':
            case '6':
            case '7':
            case '8':
            case '9':
                i = 0;
                i2 = 0;
                i3 = 0;
                while (true) {
                    if (i < 9) {
                        i++;
                        i3 = (i3 * 10) + (this.current - '0');
                    } else {
                        i2++;
                    }
                    c = read();
                    this.current = c;
                    switch (c) {
                        case '0':
                        case '1':
                        case '2':
                        case '3':
                        case '4':
                        case '5':
                        case '6':
                        case '7':
                        case '8':
                        case '9':
                            break;
                    }
                    z2 = true;
                    if (this.current == '.') {
                        c7 = read();
                        this.current = c7;
                        switch (c7) {
                            case '0':
                                if (i == 0) {
                                    while (true) {
                                        c9 = read();
                                        this.current = c9;
                                        i2--;
                                        switch (c9) {
                                            case '0':
                                                break;
                                            case '1':
                                            case '2':
                                            case '3':
                                            case '4':
                                            case '5':
                                            case '6':
                                            case '7':
                                            case '8':
                                            case '9':
                                                break;
                                            default:
                                                if (!z2) {
                                                    return 0.0f;
                                                }
                                                break;
                                        }
                                    }
                                }
                            case '1':
                            case '2':
                            case '3':
                            case '4':
                            case '5':
                            case '6':
                            case '7':
                            case '8':
                            case '9':
                                while (true) {
                                    if (i < 9) {
                                        i++;
                                        i3 = (i3 * 10) + (this.current - '0');
                                        i2--;
                                    }
                                    c8 = read();
                                    this.current = c8;
                                    switch (c8) {
                                        case '0':
                                        case '1':
                                        case '2':
                                        case '3':
                                        case '4':
                                        case '5':
                                        case '6':
                                        case '7':
                                        case '8':
                                        case '9':
                                            break;
                                    }
                                }
                                break;
                            default:
                                if (!z2) {
                                    reportUnexpectedCharacterError(c7);
                                    return 0.0f;
                                }
                                break;
                        }
                    }
                    c2 = this.current;
                    if (c2 != 'E') {
                        c3 = read();
                        this.current = c3;
                        if (c3 == '+') {
                            c4 = read();
                            this.current = c4;
                            switch (c4) {
                                case '0':
                                case '1':
                                case '2':
                                case '3':
                                case '4':
                                case '5':
                                case '6':
                                case '7':
                                case '8':
                                case '9':
                                    break;
                                default:
                                    reportUnexpectedCharacterError(c4);
                                    return 0.0f;
                            }
                        } else if (c3 != '-') {
                            switch (c3) {
                                case '0':
                                case '1':
                                case '2':
                                case '3':
                                case '4':
                                case '5':
                                case '6':
                                case '7':
                                case '8':
                                case '9':
                                    break;
                                default:
                                    reportUnexpectedCharacterError(c3);
                                    return 0.0f;
                            }
                        } else {
                            z3 = false;
                            c4 = read();
                            this.current = c4;
                            switch (c4) {
                                case '0':
                                case '1':
                                case '2':
                                case '3':
                                case '4':
                                case '5':
                                case '6':
                                case '7':
                                case '8':
                                case '9':
                                    break;
                                default:
                                    reportUnexpectedCharacterError(c4);
                                    return 0.0f;
                            }
                        }
                        switch (this.current) {
                            case '0':
                                while (true) {
                                    c6 = read();
                                    this.current = c6;
                                    switch (c6) {
                                        case '0':
                                            break;
                                        case '1':
                                        case '2':
                                        case '3':
                                        case '4':
                                        case '5':
                                        case '6':
                                        case '7':
                                        case '8':
                                        case '9':
                                            i4 = 0;
                                            while (true) {
                                                if (i5 < 3) {
                                                    i5++;
                                                    i4 = (i4 * 10) + (this.current - '0');
                                                }
                                                c5 = read();
                                                this.current = c5;
                                                switch (c5) {
                                                    case '0':
                                                    case '1':
                                                    case '2':
                                                    case '3':
                                                    case '4':
                                                    case '5':
                                                    case '6':
                                                    case '7':
                                                    case '8':
                                                    case '9':
                                                        break;
                                                    default:
                                                        i5 = i4;
                                                        break;
                                                }
                                            }
                                            break;
                                    }
                                }
                                break;
                            case '1':
                            case '2':
                            case '3':
                            case '4':
                            case '5':
                            case '6':
                            case '7':
                            case '8':
                            case '9':
                                i4 = 0;
                                while (true) {
                                    if (i5 < 3) {
                                        i5++;
                                        i4 = (i4 * 10) + (this.current - '0');
                                    }
                                    c5 = read();
                                    this.current = c5;
                                    switch (c5) {
                                        case '0':
                                        case '1':
                                        case '2':
                                        case '3':
                                        case '4':
                                        case '5':
                                        case '6':
                                        case '7':
                                        case '8':
                                        case '9':
                                            break;
                                        default:
                                            i5 = i4;
                                            break;
                                    }
                                }
                                break;
                        }
                    } else {
                        c3 = read();
                        this.current = c3;
                        if (c3 == '+') {
                            c4 = read();
                            this.current = c4;
                            switch (c4) {
                                case '0':
                                case '1':
                                case '2':
                                case '3':
                                case '4':
                                case '5':
                                case '6':
                                case '7':
                                case '8':
                                case '9':
                                    break;
                                default:
                                    reportUnexpectedCharacterError(c4);
                                    return 0.0f;
                            }
                        } else if (c3 != '-') {
                            switch (c3) {
                                case '0':
                                case '1':
                                case '2':
                                case '3':
                                case '4':
                                case '5':
                                case '6':
                                case '7':
                                case '8':
                                case '9':
                                    break;
                                default:
                                    reportUnexpectedCharacterError(c3);
                                    return 0.0f;
                            }
                        } else {
                            z3 = false;
                            c4 = read();
                            this.current = c4;
                            switch (c4) {
                                case '0':
                                case '1':
                                case '2':
                                case '3':
                                case '4':
                                case '5':
                                case '6':
                                case '7':
                                case '8':
                                case '9':
                                    break;
                                default:
                                    reportUnexpectedCharacterError(c4);
                                    return 0.0f;
                            }
                        }
                        switch (this.current) {
                            case '0':
                                while (true) {
                                    c6 = read();
                                    this.current = c6;
                                    switch (c6) {
                                        case '0':
                                            break;
                                        case '1':
                                        case '2':
                                        case '3':
                                        case '4':
                                        case '5':
                                        case '6':
                                        case '7':
                                        case '8':
                                        case '9':
                                            i4 = 0;
                                            while (true) {
                                                if (i5 < 3) {
                                                    i5++;
                                                    i4 = (i4 * 10) + (this.current - '0');
                                                }
                                                c5 = read();
                                                this.current = c5;
                                                switch (c5) {
                                                    case '0':
                                                    case '1':
                                                    case '2':
                                                    case '3':
                                                    case '4':
                                                    case '5':
                                                    case '6':
                                                    case '7':
                                                    case '8':
                                                    case '9':
                                                        break;
                                                    default:
                                                        i5 = i4;
                                                        break;
                                                }
                                            }
                                            break;
                                    }
                                }
                                break;
                            case '1':
                            case '2':
                            case '3':
                            case '4':
                            case '5':
                            case '6':
                            case '7':
                            case '8':
                            case '9':
                                i4 = 0;
                                while (true) {
                                    if (i5 < 3) {
                                        i5++;
                                        i4 = (i4 * 10) + (this.current - '0');
                                    }
                                    c5 = read();
                                    this.current = c5;
                                    switch (c5) {
                                        case '0':
                                        case '1':
                                        case '2':
                                        case '3':
                                        case '4':
                                        case '5':
                                        case '6':
                                        case '7':
                                        case '8':
                                        case '9':
                                            break;
                                        default:
                                            i5 = i4;
                                            break;
                                    }
                                }
                                break;
                        }
                    }
                    if (!z3) {
                        i5 = -i5;
                    }
                    int i12 = i5 + i2;
                    if (!z) {
                        i3 = -i3;
                    }
                    return buildFloat(i3, i12);
                }
        }
    }

    private void reportUnexpectedCharacterError(char c) {
        throw new RuntimeException("Unexpected char '" + c + "'.");
    }

    public float nextFloat() {
        skipWhitespace();
        float f = parseFloat();
        skipNumberSeparator();
        return f;
    }
}
