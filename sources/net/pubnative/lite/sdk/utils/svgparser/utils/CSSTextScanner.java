package net.pubnative.lite.sdk.utils.svgparser.utils;

import com.json.cc;
import com.safedk.android.utils.SdksMapping;
import io.ktor.util.date.GMTDateParser;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;
import kotlin.text.Typography;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes4.dex */
public class CSSTextScanner extends TextScanner {
    static final Pattern PATTERN_BLOCK_COMMENTS = Pattern.compile("(?s)/\\*.*?\\*/");

    private int hexChar(int i) {
        if (i >= 48 && i <= 57) {
            return i - 48;
        }
        if (i >= 65 && i <= 70) {
            return i - 55;
        }
        if (i < 97 || i > 102) {
            return -1;
        }
        return i - 87;
    }

    public CSSTextScanner(String str) {
        super(PATTERN_BLOCK_COMMENTS.matcher(str).replaceAll(""));
    }

    public String nextIdentifier() {
        int iScanForIdentifier = scanForIdentifier();
        if (iScanForIdentifier == this.position) {
            return null;
        }
        String strSubstring = this.input.substring(this.position, iScanForIdentifier);
        this.position = iScanForIdentifier;
        return strSubstring;
    }

    private int scanForIdentifier() {
        if (empty()) {
            return this.position;
        }
        int i = this.position;
        int i2 = this.position;
        int iCharAt = this.input.charAt(this.position);
        if (iCharAt == 45) {
            iCharAt = advanceChar();
        }
        if ((iCharAt >= 65 && iCharAt <= 90) || ((iCharAt >= 97 && iCharAt <= 122) || iCharAt == 45 || iCharAt == 95 || iCharAt >= 128)) {
            int iAdvanceChar = advanceChar();
            while (true) {
                if ((iAdvanceChar < 65 || iAdvanceChar > 90) && ((iAdvanceChar < 97 || iAdvanceChar > 122) && ((iAdvanceChar < 48 || iAdvanceChar > 57) && iAdvanceChar != 45 && iAdvanceChar != 95 && iAdvanceChar < 128))) {
                    break;
                }
                iAdvanceChar = advanceChar();
            }
            i2 = this.position;
        }
        this.position = i;
        return i2;
    }

    public List<CSSParser.Selector> nextSelectorGroup() throws CSSParseException {
        if (empty()) {
            return null;
        }
        ArrayList arrayList = new ArrayList(1);
        CSSParser.Selector selector = new CSSParser.Selector();
        while (!empty() && nextSimpleSelector(selector)) {
            if (skipCommaWhitespace()) {
                arrayList.add(selector);
                selector = new CSSParser.Selector();
            }
        }
        if (!selector.isEmpty()) {
            arrayList.add(selector);
        }
        return arrayList;
    }

    /* JADX WARN: Code duplicated, block: B:13:0x002d  */
    boolean nextSimpleSelector(CSSParser.Selector selector) throws CSSParseException {
        CSSParser.Combinator combinator;
        CSSParser.SimpleSelector simpleSelector;
        CSSParser.AttribOp attribOp;
        String strNextAttribValue;
        if (empty()) {
            return false;
        }
        int i = this.position;
        if (selector.isEmpty()) {
            combinator = null;
        } else if (consume(Typography.greater)) {
            combinator = CSSParser.Combinator.CHILD;
            skipWhitespace();
        } else if (consume('+')) {
            combinator = CSSParser.Combinator.FOLLOWS;
            skipWhitespace();
        } else {
            combinator = null;
        }
        if (consume(GMTDateParser.ANY)) {
            simpleSelector = new CSSParser.SimpleSelector(combinator, null);
        } else {
            String strNextIdentifier = nextIdentifier();
            if (strNextIdentifier != null) {
                CSSParser.SimpleSelector simpleSelector2 = new CSSParser.SimpleSelector(combinator, strNextIdentifier);
                selector.addedElement();
                simpleSelector = simpleSelector2;
            } else {
                simpleSelector = null;
            }
        }
        while (!empty()) {
            if (consume('.')) {
                if (simpleSelector == null) {
                    simpleSelector = new CSSParser.SimpleSelector(combinator, null);
                }
                String strNextIdentifier2 = nextIdentifier();
                if (strNextIdentifier2 == null) {
                    throw new CSSParseException("Invalid \".class\" simpleSelectors");
                }
                simpleSelector.addAttrib(SdksMapping.KEY_INSTALLED_MEDIATION_ADAPTERS_CLASS, CSSParser.AttribOp.EQUALS, strNextIdentifier2);
                selector.addedAttributeOrPseudo();
            } else if (consume('#')) {
                if (simpleSelector == null) {
                    simpleSelector = new CSSParser.SimpleSelector(combinator, null);
                }
                String strNextIdentifier3 = nextIdentifier();
                if (strNextIdentifier3 == null) {
                    throw new CSSParseException("Invalid \"#id\" simpleSelectors");
                }
                simpleSelector.addAttrib("id", CSSParser.AttribOp.EQUALS, strNextIdentifier3);
                selector.addedIdAttribute();
            } else if (consume(AbstractJsonLexerKt.BEGIN_LIST)) {
                if (simpleSelector == null) {
                    simpleSelector = new CSSParser.SimpleSelector(combinator, null);
                }
                skipWhitespace();
                String strNextIdentifier4 = nextIdentifier();
                if (strNextIdentifier4 == null) {
                    throw new CSSParseException("Invalid attribute simpleSelectors");
                }
                skipWhitespace();
                if (consume(cc.T)) {
                    attribOp = CSSParser.AttribOp.EQUALS;
                } else if (consume("~=")) {
                    attribOp = CSSParser.AttribOp.INCLUDES;
                } else {
                    attribOp = consume("|=") ? CSSParser.AttribOp.DASHMATCH : null;
                }
                if (attribOp != null) {
                    skipWhitespace();
                    strNextAttribValue = nextAttribValue();
                    if (strNextAttribValue == null) {
                        throw new CSSParseException("Invalid attribute simpleSelectors");
                    }
                    skipWhitespace();
                } else {
                    strNextAttribValue = null;
                }
                if (!consume(AbstractJsonLexerKt.END_LIST)) {
                    throw new CSSParseException("Invalid attribute simpleSelectors");
                }
                if (attribOp == null) {
                    attribOp = CSSParser.AttribOp.EXISTS;
                }
                simpleSelector.addAttrib(strNextIdentifier4, attribOp, strNextAttribValue);
                selector.addedAttributeOrPseudo();
            } else {
                if (!consume(AbstractJsonLexerKt.COLON)) {
                    break;
                }
                if (simpleSelector == null) {
                    simpleSelector = new CSSParser.SimpleSelector(combinator, null);
                }
                parsePseudoClass(selector, simpleSelector);
            }
        }
        if (simpleSelector != null) {
            selector.add(simpleSelector);
            return true;
        }
        this.position = i;
        return false;
    }

    private static class AnPlusB {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f12450a;
        public final int b;

        AnPlusB(int i, int i2) {
            this.f12450a = i;
            this.b = i2;
        }
    }

    private AnPlusB nextAnPlusB() {
        IntegerParser integerParser;
        AnPlusB anPlusB;
        if (empty()) {
            return null;
        }
        int i = this.position;
        if (!consume('(')) {
            return null;
        }
        skipWhitespace();
        int i2 = 1;
        if (consume("odd")) {
            anPlusB = new AnPlusB(2, 1);
        } else {
            if (consume("even")) {
                anPlusB = new AnPlusB(2, 0);
            } else {
                int i3 = (!consume('+') && consume('-')) ? -1 : 1;
                IntegerParser integerParser2 = IntegerParser.parseInt(this.input, this.position, this.inputLength, false);
                if (integerParser2 != null) {
                    this.position = integerParser2.getEndPos();
                }
                if (consume('n') || consume('N')) {
                    if (integerParser2 == null) {
                        integerParser2 = new IntegerParser(1L, this.position);
                    }
                    skipWhitespace();
                    boolean zConsume = consume('+');
                    if (!zConsume && (zConsume = consume('-'))) {
                        i2 = -1;
                    }
                    if (zConsume) {
                        skipWhitespace();
                        integerParser = IntegerParser.parseInt(this.input, this.position, this.inputLength, false);
                        if (integerParser != null) {
                            this.position = integerParser.getEndPos();
                        } else {
                            this.position = i;
                            return null;
                        }
                    } else {
                        integerParser = null;
                    }
                    int i4 = i2;
                    i2 = i3;
                    i3 = i4;
                } else {
                    integerParser = integerParser2;
                    integerParser2 = null;
                }
                anPlusB = new AnPlusB(integerParser2 == null ? 0 : i2 * integerParser2.value(), integerParser != null ? i3 * integerParser.value() : 0);
            }
        }
        skipWhitespace();
        if (consume(')')) {
            return anPlusB;
        }
        this.position = i;
        return null;
    }

    private List<String> nextIdentListParam() {
        if (empty()) {
            return null;
        }
        int i = this.position;
        if (!consume('(')) {
            return null;
        }
        skipWhitespace();
        ArrayList arrayList = null;
        do {
            String strNextIdentifier = nextIdentifier();
            if (strNextIdentifier == null) {
                this.position = i;
                return null;
            }
            if (arrayList == null) {
                arrayList = new ArrayList();
            }
            arrayList.add(strNextIdentifier);
            skipWhitespace();
        } while (skipCommaWhitespace());
        if (consume(')')) {
            return arrayList;
        }
        this.position = i;
        return null;
    }

    private List<CSSParser.Selector> nextPseudoNotParam() throws CSSParseException {
        if (empty()) {
            return null;
        }
        int i = this.position;
        if (!consume('(')) {
            return null;
        }
        skipWhitespace();
        List<CSSParser.Selector> listNextSelectorGroup = nextSelectorGroup();
        if (listNextSelectorGroup == null) {
            this.position = i;
            return null;
        }
        if (!consume(')')) {
            this.position = i;
            return null;
        }
        for (CSSParser.Selector selector : listNextSelectorGroup) {
            if (selector.simpleSelectors == null) {
                break;
            }
            for (CSSParser.SimpleSelector simpleSelector : selector.simpleSelectors) {
                if (simpleSelector.pseudos == null) {
                    break;
                }
                Iterator<CSSParser.PseudoClass> it = simpleSelector.pseudos.iterator();
                while (it.hasNext()) {
                    if (it.next() instanceof CSSParser.PseudoClassNot) {
                        return null;
                    }
                }
            }
        }
        return listNextSelectorGroup;
    }

    private void parsePseudoClass(CSSParser.Selector selector, CSSParser.SimpleSelector simpleSelector) throws CSSParseException {
        CSSParser.PseudoClass pseudoClass;
        CSSParser.PseudoClass pseudoClass2;
        String strNextIdentifier = nextIdentifier();
        if (strNextIdentifier == null) {
            throw new CSSParseException("Invalid pseudo class");
        }
        CSSParser.PseudoClassIdents pseudoClassIdentsFromString = CSSParser.PseudoClassIdents.fromString(strNextIdentifier);
        switch (AnonymousClass1.$SwitchMap$net$pubnative$lite$sdk$utils$svgparser$utils$CSSParser$PseudoClassIdents[pseudoClassIdentsFromString.ordinal()]) {
            case 1:
                CSSParser.PseudoClass pseudoClassAnPlusB = new CSSParser.PseudoClassAnPlusB(0, 1, true, false, null);
                selector.addedAttributeOrPseudo();
                pseudoClass2 = pseudoClassAnPlusB;
                simpleSelector.addPseudo(pseudoClass2);
                return;
            case 2:
                CSSParser.PseudoClass pseudoClassAnPlusB2 = new CSSParser.PseudoClassAnPlusB(0, 1, false, false, null);
                selector.addedAttributeOrPseudo();
                pseudoClass2 = pseudoClassAnPlusB2;
                simpleSelector.addPseudo(pseudoClass2);
                return;
            case 3:
                CSSParser.PseudoClass pseudoClassOnlyChild = new CSSParser.PseudoClassOnlyChild(false, null);
                selector.addedAttributeOrPseudo();
                pseudoClass2 = pseudoClassOnlyChild;
                simpleSelector.addPseudo(pseudoClass2);
                return;
            case 4:
                CSSParser.PseudoClass pseudoClassAnPlusB3 = new CSSParser.PseudoClassAnPlusB(0, 1, true, true, simpleSelector.tag);
                selector.addedAttributeOrPseudo();
                pseudoClass2 = pseudoClassAnPlusB3;
                simpleSelector.addPseudo(pseudoClass2);
                return;
            case 5:
                CSSParser.PseudoClass pseudoClassAnPlusB4 = new CSSParser.PseudoClassAnPlusB(0, 1, false, true, simpleSelector.tag);
                selector.addedAttributeOrPseudo();
                pseudoClass2 = pseudoClassAnPlusB4;
                simpleSelector.addPseudo(pseudoClass2);
                return;
            case 6:
                CSSParser.PseudoClass pseudoClassOnlyChild2 = new CSSParser.PseudoClassOnlyChild(true, simpleSelector.tag);
                selector.addedAttributeOrPseudo();
                pseudoClass2 = pseudoClassOnlyChild2;
                simpleSelector.addPseudo(pseudoClass2);
                return;
            case 7:
                CSSParser.PseudoClass pseudoClassRoot = new CSSParser.PseudoClassRoot();
                selector.addedAttributeOrPseudo();
                pseudoClass2 = pseudoClassRoot;
                simpleSelector.addPseudo(pseudoClass2);
                return;
            case 8:
                CSSParser.PseudoClass pseudoClassEmpty = new CSSParser.PseudoClassEmpty();
                selector.addedAttributeOrPseudo();
                pseudoClass2 = pseudoClassEmpty;
                simpleSelector.addPseudo(pseudoClass2);
                return;
            case 9:
            case 10:
            case 11:
            case 12:
                boolean z = pseudoClassIdentsFromString == CSSParser.PseudoClassIdents.nth_child || pseudoClassIdentsFromString == CSSParser.PseudoClassIdents.nth_of_type;
                boolean z2 = pseudoClassIdentsFromString == CSSParser.PseudoClassIdents.nth_of_type || pseudoClassIdentsFromString == CSSParser.PseudoClassIdents.nth_last_of_type;
                AnPlusB anPlusBNextAnPlusB = nextAnPlusB();
                if (anPlusBNextAnPlusB == null) {
                    throw new CSSParseException("Invalid or missing parameter section for pseudo class: " + strNextIdentifier);
                }
                CSSParser.PseudoClass pseudoClassAnPlusB5 = new CSSParser.PseudoClassAnPlusB(anPlusBNextAnPlusB.f12450a, anPlusBNextAnPlusB.b, z, z2, simpleSelector.tag);
                selector.addedAttributeOrPseudo();
                pseudoClass = pseudoClassAnPlusB5;
                pseudoClass2 = pseudoClass;
                simpleSelector.addPseudo(pseudoClass2);
                return;
            case 13:
                List<CSSParser.Selector> listNextPseudoNotParam = nextPseudoNotParam();
                if (listNextPseudoNotParam == null) {
                    throw new CSSParseException("Invalid or missing parameter section for pseudo class: " + strNextIdentifier);
                }
                CSSParser.PseudoClassNot pseudoClassNot = new CSSParser.PseudoClassNot(listNextPseudoNotParam);
                selector.specificity = pseudoClassNot.getSpecificity();
                pseudoClass = pseudoClassNot;
                pseudoClass2 = pseudoClass;
                simpleSelector.addPseudo(pseudoClass2);
                return;
            case 14:
                CSSParser.PseudoClass pseudoClassTarget = new CSSParser.PseudoClassTarget();
                selector.addedAttributeOrPseudo();
                pseudoClass2 = pseudoClassTarget;
                simpleSelector.addPseudo(pseudoClass2);
                return;
            case 15:
                nextIdentListParam();
                CSSParser.PseudoClass pseudoClassNotSupported = new CSSParser.PseudoClassNotSupported(strNextIdentifier);
                selector.addedAttributeOrPseudo();
                pseudoClass2 = pseudoClassNotSupported;
                simpleSelector.addPseudo(pseudoClass2);
                return;
            case 16:
            case 17:
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
            case 24:
                CSSParser.PseudoClass pseudoClassNotSupported2 = new CSSParser.PseudoClassNotSupported(strNextIdentifier);
                selector.addedAttributeOrPseudo();
                pseudoClass2 = pseudoClassNotSupported2;
                simpleSelector.addPseudo(pseudoClass2);
                return;
            default:
                throw new CSSParseException("Unsupported pseudo class: " + strNextIdentifier);
        }
    }

    /* JADX INFO: renamed from: net.pubnative.lite.sdk.utils.svgparser.utils.CSSTextScanner$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$net$pubnative$lite$sdk$utils$svgparser$utils$CSSParser$PseudoClassIdents;

        static {
            int[] iArr = new int[CSSParser.PseudoClassIdents.values().length];
            $SwitchMap$net$pubnative$lite$sdk$utils$svgparser$utils$CSSParser$PseudoClassIdents = iArr;
            try {
                iArr[CSSParser.PseudoClassIdents.first_child.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$net$pubnative$lite$sdk$utils$svgparser$utils$CSSParser$PseudoClassIdents[CSSParser.PseudoClassIdents.last_child.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$net$pubnative$lite$sdk$utils$svgparser$utils$CSSParser$PseudoClassIdents[CSSParser.PseudoClassIdents.only_child.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$net$pubnative$lite$sdk$utils$svgparser$utils$CSSParser$PseudoClassIdents[CSSParser.PseudoClassIdents.first_of_type.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$net$pubnative$lite$sdk$utils$svgparser$utils$CSSParser$PseudoClassIdents[CSSParser.PseudoClassIdents.last_of_type.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$net$pubnative$lite$sdk$utils$svgparser$utils$CSSParser$PseudoClassIdents[CSSParser.PseudoClassIdents.only_of_type.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$net$pubnative$lite$sdk$utils$svgparser$utils$CSSParser$PseudoClassIdents[CSSParser.PseudoClassIdents.root.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$net$pubnative$lite$sdk$utils$svgparser$utils$CSSParser$PseudoClassIdents[CSSParser.PseudoClassIdents.empty.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$net$pubnative$lite$sdk$utils$svgparser$utils$CSSParser$PseudoClassIdents[CSSParser.PseudoClassIdents.nth_child.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$net$pubnative$lite$sdk$utils$svgparser$utils$CSSParser$PseudoClassIdents[CSSParser.PseudoClassIdents.nth_last_child.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$net$pubnative$lite$sdk$utils$svgparser$utils$CSSParser$PseudoClassIdents[CSSParser.PseudoClassIdents.nth_of_type.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                $SwitchMap$net$pubnative$lite$sdk$utils$svgparser$utils$CSSParser$PseudoClassIdents[CSSParser.PseudoClassIdents.nth_last_of_type.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                $SwitchMap$net$pubnative$lite$sdk$utils$svgparser$utils$CSSParser$PseudoClassIdents[CSSParser.PseudoClassIdents.not.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                $SwitchMap$net$pubnative$lite$sdk$utils$svgparser$utils$CSSParser$PseudoClassIdents[CSSParser.PseudoClassIdents.target.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                $SwitchMap$net$pubnative$lite$sdk$utils$svgparser$utils$CSSParser$PseudoClassIdents[CSSParser.PseudoClassIdents.lang.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                $SwitchMap$net$pubnative$lite$sdk$utils$svgparser$utils$CSSParser$PseudoClassIdents[CSSParser.PseudoClassIdents.link.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                $SwitchMap$net$pubnative$lite$sdk$utils$svgparser$utils$CSSParser$PseudoClassIdents[CSSParser.PseudoClassIdents.visited.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                $SwitchMap$net$pubnative$lite$sdk$utils$svgparser$utils$CSSParser$PseudoClassIdents[CSSParser.PseudoClassIdents.hover.ordinal()] = 18;
            } catch (NoSuchFieldError unused18) {
            }
            try {
                $SwitchMap$net$pubnative$lite$sdk$utils$svgparser$utils$CSSParser$PseudoClassIdents[CSSParser.PseudoClassIdents.active.ordinal()] = 19;
            } catch (NoSuchFieldError unused19) {
            }
            try {
                $SwitchMap$net$pubnative$lite$sdk$utils$svgparser$utils$CSSParser$PseudoClassIdents[CSSParser.PseudoClassIdents.focus.ordinal()] = 20;
            } catch (NoSuchFieldError unused20) {
            }
            try {
                $SwitchMap$net$pubnative$lite$sdk$utils$svgparser$utils$CSSParser$PseudoClassIdents[CSSParser.PseudoClassIdents.enabled.ordinal()] = 21;
            } catch (NoSuchFieldError unused21) {
            }
            try {
                $SwitchMap$net$pubnative$lite$sdk$utils$svgparser$utils$CSSParser$PseudoClassIdents[CSSParser.PseudoClassIdents.disabled.ordinal()] = 22;
            } catch (NoSuchFieldError unused22) {
            }
            try {
                $SwitchMap$net$pubnative$lite$sdk$utils$svgparser$utils$CSSParser$PseudoClassIdents[CSSParser.PseudoClassIdents.checked.ordinal()] = 23;
            } catch (NoSuchFieldError unused23) {
            }
            try {
                $SwitchMap$net$pubnative$lite$sdk$utils$svgparser$utils$CSSParser$PseudoClassIdents[CSSParser.PseudoClassIdents.indeterminate.ordinal()] = 24;
            } catch (NoSuchFieldError unused24) {
            }
        }
    }

    private String nextAttribValue() {
        if (empty()) {
            return null;
        }
        String strNextQuotedString = nextQuotedString();
        return strNextQuotedString != null ? strNextQuotedString : nextIdentifier();
    }

    public String nextPropertyValue() {
        if (empty()) {
            return null;
        }
        int i = this.position;
        int i2 = this.position;
        int iCharAt = this.input.charAt(this.position);
        while (iCharAt != -1 && iCharAt != 59 && iCharAt != 125 && iCharAt != 33 && !isEOL(iCharAt)) {
            if (!isWhitespace(iCharAt)) {
                i2 = this.position + 1;
            }
            iCharAt = advanceChar();
        }
        if (this.position > i) {
            return this.input.substring(i, i2);
        }
        this.position = i;
        return null;
    }

    public String nextCSSString() {
        int iHexChar;
        if (empty()) {
            return null;
        }
        char cCharAt = this.input.charAt(this.position);
        if (cCharAt != '\'' && cCharAt != '\"') {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        this.position++;
        int iIntValue = nextChar().intValue();
        while (iIntValue != -1 && iIntValue != cCharAt) {
            if (iIntValue == 92) {
                iIntValue = nextChar().intValue();
                if (iIntValue != -1) {
                    if (iIntValue == 10 || iIntValue == 13 || iIntValue == 12) {
                        iIntValue = nextChar().intValue();
                    } else {
                        int iHexChar2 = hexChar(iIntValue);
                        if (iHexChar2 != -1) {
                            for (int i = 1; i <= 5 && (iHexChar = hexChar((iIntValue = nextChar().intValue()))) != -1; i++) {
                                iHexChar2 = (iHexChar2 * 16) + iHexChar;
                            }
                            sb.append((char) iHexChar2);
                        }
                    }
                }
            }
            sb.append((char) iIntValue);
            iIntValue = nextChar().intValue();
        }
        return sb.toString();
    }

    public String nextURL() {
        if (empty()) {
            return null;
        }
        int i = this.position;
        if (!consume("url(")) {
            return null;
        }
        skipWhitespace();
        String strNextCSSString = nextCSSString();
        if (strNextCSSString == null) {
            strNextCSSString = nextLegacyURL();
        }
        if (strNextCSSString == null) {
            this.position = i;
            return null;
        }
        skipWhitespace();
        if (empty() || consume(")")) {
            return strNextCSSString;
        }
        this.position = i;
        return null;
    }

    String nextLegacyURL() {
        char cCharAt;
        int iHexChar;
        StringBuilder sb = new StringBuilder();
        while (!empty() && (cCharAt = this.input.charAt(this.position)) != '\'' && cCharAt != '\"' && cCharAt != '(' && cCharAt != ')' && !isWhitespace(cCharAt) && !Character.isISOControl((int) cCharAt)) {
            this.position++;
            if (cCharAt == '\\') {
                if (!empty()) {
                    String str = this.input;
                    int i = this.position;
                    this.position = i + 1;
                    cCharAt = str.charAt(i);
                    if (cCharAt != '\n' && cCharAt != '\r' && cCharAt != '\f') {
                        int iHexChar2 = hexChar(cCharAt);
                        if (iHexChar2 != -1) {
                            for (int i2 = 1; i2 <= 5 && !empty() && (iHexChar = hexChar(this.input.charAt(this.position))) != -1; i2++) {
                                this.position++;
                                iHexChar2 = (iHexChar2 * 16) + iHexChar;
                            }
                            sb.append((char) iHexChar2);
                        }
                    }
                }
            }
            sb.append(cCharAt);
        }
        if (sb.length() == 0) {
            return null;
        }
        return sb.toString();
    }
}
