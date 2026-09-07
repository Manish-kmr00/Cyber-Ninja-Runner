package net.pubnative.lite.sdk.utils.svgparser.utils;

import android.util.Log;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.json.cc;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Locale;
import java.util.Map;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import net.pubnative.lite.sdk.utils.svgparser.SVGExternalFileResolver;

/* JADX INFO: loaded from: classes5.dex */
public class CSSParser {
    static final String CLASS = "class";
    static final String CSS_MIME_TYPE = "text/css";
    static final String ID = "id";
    private static final int SPECIFICITY_ATTRIBUTE_OR_PSEUDOCLASS = 1000;
    private static final int SPECIFICITY_ELEMENT_OR_PSEUDOELEMENT = 1;
    private static final int SPECIFICITY_ID_ATTRIBUTE = 1000000;
    private static final String TAG = "CSSParser";
    private MediaType deviceMediaType;
    private SVGExternalFileResolver externalFileResolver;
    private boolean inMediaRule;
    private Source source;

    enum AttribOp {
        EXISTS,
        EQUALS,
        INCLUDES,
        DASHMATCH
    }

    enum Combinator {
        DESCENDANT,
        CHILD,
        FOLLOWS
    }

    enum MediaType {
        all,
        aural,
        braille,
        embossed,
        handheld,
        print,
        projection,
        screen,
        speech,
        tty,
        tv
    }

    interface PseudoClass {
        boolean matches(RuleMatchContext ruleMatchContext, SVGBase.SvgElementBase svgElementBase);
    }

    public enum Source {
        Document,
        RenderOptions
    }

    enum PseudoClassIdents {
        target,
        root,
        nth_child,
        nth_last_child,
        nth_of_type,
        nth_last_of_type,
        first_child,
        last_child,
        first_of_type,
        last_of_type,
        only_child,
        only_of_type,
        empty,
        not,
        lang,
        link,
        visited,
        hover,
        active,
        focus,
        enabled,
        disabled,
        checked,
        indeterminate,
        UNSUPPORTED;

        private static final Map<String, PseudoClassIdents> cache = new HashMap();

        static {
            for (PseudoClassIdents pseudoClassIdents : values()) {
                if (pseudoClassIdents != UNSUPPORTED) {
                    cache.put(pseudoClassIdents.name().replace('_', '-'), pseudoClassIdents);
                }
            }
        }

        public static PseudoClassIdents fromString(String str) {
            PseudoClassIdents pseudoClassIdents = cache.get(str);
            return pseudoClassIdents != null ? pseudoClassIdents : UNSUPPORTED;
        }
    }

    private static class Attrib {
        public final String name;
        final AttribOp operation;
        public final String value;

        Attrib(String str, AttribOp attribOp, String str2) {
            this.name = str;
            this.operation = attribOp;
            this.value = str2;
        }
    }

    static class SimpleSelector {
        Combinator combinator;
        String tag;
        List<Attrib> attribs = null;
        List<PseudoClass> pseudos = null;

        SimpleSelector(Combinator combinator, String str) {
            this.combinator = combinator == null ? Combinator.DESCENDANT : combinator;
            this.tag = str;
        }

        void addAttrib(String str, AttribOp attribOp, String str2) {
            if (this.attribs == null) {
                this.attribs = new ArrayList();
            }
            this.attribs.add(new Attrib(str, attribOp, str2));
        }

        void addPseudo(PseudoClass pseudoClass) {
            if (this.pseudos == null) {
                this.pseudos = new ArrayList();
            }
            this.pseudos.add(pseudoClass);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            if (this.combinator == Combinator.CHILD) {
                sb.append("> ");
            } else if (this.combinator == Combinator.FOLLOWS) {
                sb.append("+ ");
            }
            String str = this.tag;
            if (str == null) {
                str = "*";
            }
            sb.append(str);
            List<Attrib> list = this.attribs;
            if (list != null) {
                for (Attrib attrib : list) {
                    sb.append(AbstractJsonLexerKt.BEGIN_LIST).append(attrib.name);
                    int i = AnonymousClass1.$SwitchMap$net$pubnative$lite$sdk$utils$svgparser$utils$CSSParser$AttribOp[attrib.operation.ordinal()];
                    if (i == 1) {
                        sb.append(cc.T).append(attrib.value);
                    } else if (i == 2) {
                        sb.append("~=").append(attrib.value);
                    } else if (i == 3) {
                        sb.append("|=").append(attrib.value);
                    }
                    sb.append(AbstractJsonLexerKt.END_LIST);
                }
            }
            List<PseudoClass> list2 = this.pseudos;
            if (list2 != null) {
                Iterator<PseudoClass> it = list2.iterator();
                while (it.hasNext()) {
                    sb.append(AbstractJsonLexerKt.COLON).append(it.next());
                }
            }
            return sb.toString();
        }
    }

    /* JADX INFO: renamed from: net.pubnative.lite.sdk.utils.svgparser.utils.CSSParser$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$net$pubnative$lite$sdk$utils$svgparser$utils$CSSParser$AttribOp;

        static {
            int[] iArr = new int[AttribOp.values().length];
            $SwitchMap$net$pubnative$lite$sdk$utils$svgparser$utils$CSSParser$AttribOp = iArr;
            try {
                iArr[AttribOp.EQUALS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$net$pubnative$lite$sdk$utils$svgparser$utils$CSSParser$AttribOp[AttribOp.INCLUDES.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$net$pubnative$lite$sdk$utils$svgparser$utils$CSSParser$AttribOp[AttribOp.DASHMATCH.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public static class Ruleset {
        private List<Rule> rules = null;

        void add(Rule rule) {
            if (this.rules == null) {
                this.rules = new LinkedList();
            }
            ListIterator<Rule> listIterator = this.rules.listIterator();
            while (listIterator.hasNext()) {
                int iNextIndex = listIterator.nextIndex();
                if (listIterator.next().selector.specificity > rule.selector.specificity) {
                    this.rules.add(iNextIndex, rule);
                    return;
                }
            }
            this.rules.add(rule);
        }

        public void addAll(Ruleset ruleset) {
            if (ruleset.rules == null) {
                return;
            }
            if (this.rules == null) {
                this.rules = new LinkedList();
            }
            Iterator<Rule> it = ruleset.rules.iterator();
            while (it.hasNext()) {
                add(it.next());
            }
        }

        public List<Rule> getRules() {
            return this.rules;
        }

        public boolean isEmpty() {
            List<Rule> list = this.rules;
            return list == null || list.isEmpty();
        }

        int ruleCount() {
            List<Rule> list = this.rules;
            if (list != null) {
                return list.size();
            }
            return 0;
        }

        public void removeFromSource(Source source) {
            List<Rule> list = this.rules;
            if (list == null) {
                return;
            }
            Iterator<Rule> it = list.iterator();
            while (it.hasNext()) {
                if (it.next().source == source) {
                    it.remove();
                }
            }
        }

        public String toString() {
            if (this.rules == null) {
                return "";
            }
            StringBuilder sb = new StringBuilder();
            Iterator<Rule> it = this.rules.iterator();
            while (it.hasNext()) {
                sb.append(it.next().toString()).append('\n');
            }
            return sb.toString();
        }
    }

    public static class Rule {
        final Selector selector;
        final Source source;
        final Style style;

        Rule(Selector selector, Style style, Source source) {
            this.selector = selector;
            this.style = style;
            this.source = source;
        }

        public String toString() {
            return this.selector + " {...} (src=" + this.source + ")";
        }
    }

    static class Selector {
        List<SimpleSelector> simpleSelectors = null;
        int specificity = 0;

        Selector() {
        }

        void add(SimpleSelector simpleSelector) {
            if (this.simpleSelectors == null) {
                this.simpleSelectors = new ArrayList();
            }
            this.simpleSelectors.add(simpleSelector);
        }

        int size() {
            List<SimpleSelector> list = this.simpleSelectors;
            if (list == null) {
                return 0;
            }
            return list.size();
        }

        SimpleSelector get(int i) {
            return this.simpleSelectors.get(i);
        }

        boolean isEmpty() {
            List<SimpleSelector> list = this.simpleSelectors;
            return list == null || list.isEmpty();
        }

        void addedIdAttribute() {
            this.specificity += 1000000;
        }

        void addedAttributeOrPseudo() {
            this.specificity += 1000;
        }

        void addedElement() {
            this.specificity++;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            Iterator<SimpleSelector> it = this.simpleSelectors.iterator();
            while (it.hasNext()) {
                sb.append(it.next()).append(' ');
            }
            return sb.append(AbstractJsonLexerKt.BEGIN_LIST).append(this.specificity).append(AbstractJsonLexerKt.END_LIST).toString();
        }
    }

    CSSParser(Source source, SVGExternalFileResolver sVGExternalFileResolver) {
        this(MediaType.screen, source, sVGExternalFileResolver);
    }

    CSSParser(MediaType mediaType, Source source, SVGExternalFileResolver sVGExternalFileResolver) {
        this.inMediaRule = false;
        this.deviceMediaType = mediaType;
        this.source = source;
        this.externalFileResolver = sVGExternalFileResolver;
    }

    Ruleset parse(String str) {
        CSSTextScanner cSSTextScanner = new CSSTextScanner(str);
        cSSTextScanner.skipWhitespace();
        return parseRuleset(cSSTextScanner);
    }

    static boolean mediaMatches(String str, MediaType mediaType) {
        CSSTextScanner cSSTextScanner = new CSSTextScanner(str);
        cSSTextScanner.skipWhitespace();
        return mediaMatches(parseMediaList(cSSTextScanner), mediaType);
    }

    private static void warn(String str, Object... objArr) {
        Log.w(TAG, String.format(str, objArr));
    }

    private static boolean mediaMatches(List<MediaType> list, MediaType mediaType) {
        if (list.size() == 0) {
            return true;
        }
        for (MediaType mediaType2 : list) {
            if (mediaType2 == MediaType.all || mediaType2 == mediaType) {
                return true;
            }
        }
        return false;
    }

    private static List<MediaType> parseMediaList(CSSTextScanner cSSTextScanner) {
        String strNextWord;
        ArrayList arrayList = new ArrayList();
        while (!cSSTextScanner.empty() && (strNextWord = cSSTextScanner.nextWord()) != null) {
            try {
                arrayList.add(MediaType.valueOf(strNextWord));
            } catch (IllegalArgumentException unused) {
            }
            if (!cSSTextScanner.skipCommaWhitespace()) {
                break;
            }
        }
        return arrayList;
    }

    private void parseAtRule(Ruleset ruleset, CSSTextScanner cSSTextScanner) throws CSSParseException {
        String strNextIdentifier = cSSTextScanner.nextIdentifier();
        cSSTextScanner.skipWhitespace();
        if (strNextIdentifier == null) {
            throw new CSSParseException("Invalid '@' rule");
        }
        if (!this.inMediaRule && strNextIdentifier.equals("media")) {
            List<MediaType> mediaList = parseMediaList(cSSTextScanner);
            if (!cSSTextScanner.consume(AbstractJsonLexerKt.BEGIN_OBJ)) {
                throw new CSSParseException("Invalid @media rule: missing rule set");
            }
            cSSTextScanner.skipWhitespace();
            if (mediaMatches(mediaList, this.deviceMediaType)) {
                this.inMediaRule = true;
                ruleset.addAll(parseRuleset(cSSTextScanner));
                this.inMediaRule = false;
            } else {
                parseRuleset(cSSTextScanner);
            }
            if (!cSSTextScanner.empty() && !cSSTextScanner.consume(AbstractJsonLexerKt.END_OBJ)) {
                throw new CSSParseException("Invalid @media rule: expected '}' at end of rule set");
            }
        } else if (!this.inMediaRule && strNextIdentifier.equals("import")) {
            String strNextURL = cSSTextScanner.nextURL();
            if (strNextURL == null) {
                strNextURL = cSSTextScanner.nextCSSString();
            }
            if (strNextURL == null) {
                throw new CSSParseException("Invalid @import rule: expected string or url()");
            }
            cSSTextScanner.skipWhitespace();
            List<MediaType> mediaList2 = parseMediaList(cSSTextScanner);
            if (!cSSTextScanner.empty() && !cSSTextScanner.consume(';')) {
                throw new CSSParseException("Invalid @media rule: expected '}' at end of rule set");
            }
            if (this.externalFileResolver != null && mediaMatches(mediaList2, this.deviceMediaType)) {
                String strResolveCSSStyleSheet = this.externalFileResolver.resolveCSSStyleSheet(strNextURL);
                if (strResolveCSSStyleSheet == null) {
                    return;
                } else {
                    ruleset.addAll(parse(strResolveCSSStyleSheet));
                }
            }
        } else {
            warn("Ignoring @%s rule", strNextIdentifier);
            skipAtRule(cSSTextScanner);
        }
        cSSTextScanner.skipWhitespace();
    }

    private void skipAtRule(CSSTextScanner cSSTextScanner) {
        int i = 0;
        while (!cSSTextScanner.empty()) {
            int iIntValue = cSSTextScanner.nextChar().intValue();
            if (iIntValue == 59 && i == 0) {
                return;
            }
            if (iIntValue == 123) {
                i++;
            } else if (iIntValue == 125 && i > 0 && (i = i - 1) == 0) {
                return;
            }
        }
    }

    private Ruleset parseRuleset(CSSTextScanner cSSTextScanner) {
        Ruleset ruleset = new Ruleset();
        while (!cSSTextScanner.empty()) {
            try {
                if (!cSSTextScanner.consume("<!--") && !cSSTextScanner.consume("-->")) {
                    if (cSSTextScanner.consume('@')) {
                        parseAtRule(ruleset, cSSTextScanner);
                    } else if (!parseRule(ruleset, cSSTextScanner)) {
                        break;
                    }
                }
            } catch (CSSParseException e) {
                Log.e(TAG, "CSS parser terminated early due to error: " + e.getMessage());
            }
        }
        return ruleset;
    }

    private boolean parseRule(Ruleset ruleset, CSSTextScanner cSSTextScanner) throws CSSParseException {
        List<Selector> listNextSelectorGroup = cSSTextScanner.nextSelectorGroup();
        if (listNextSelectorGroup == null || listNextSelectorGroup.isEmpty()) {
            return false;
        }
        if (!cSSTextScanner.consume(AbstractJsonLexerKt.BEGIN_OBJ)) {
            throw new CSSParseException("Malformed rule block: expected '{'");
        }
        cSSTextScanner.skipWhitespace();
        Style declarations = parseDeclarations(cSSTextScanner);
        cSSTextScanner.skipWhitespace();
        Iterator<Selector> it = listNextSelectorGroup.iterator();
        while (it.hasNext()) {
            ruleset.add(new Rule(it.next(), declarations, this.source));
        }
        return true;
    }

    private Style parseDeclarations(CSSTextScanner cSSTextScanner) throws CSSParseException {
        Style style = new Style();
        do {
            String strNextIdentifier = cSSTextScanner.nextIdentifier();
            cSSTextScanner.skipWhitespace();
            if (!cSSTextScanner.consume(AbstractJsonLexerKt.COLON)) {
                throw new CSSParseException("Expected ':'");
            }
            cSSTextScanner.skipWhitespace();
            String strNextPropertyValue = cSSTextScanner.nextPropertyValue();
            if (strNextPropertyValue == null) {
                throw new CSSParseException("Expected property value");
            }
            cSSTextScanner.skipWhitespace();
            if (cSSTextScanner.consume('!')) {
                cSSTextScanner.skipWhitespace();
                if (!cSSTextScanner.consume("important")) {
                    throw new CSSParseException("Malformed rule set: found unexpected '!'");
                }
                cSSTextScanner.skipWhitespace();
            }
            cSSTextScanner.consume(';');
            Style.processStyleProperty(style, strNextIdentifier, strNextPropertyValue, false);
            cSSTextScanner.skipWhitespace();
            if (cSSTextScanner.empty()) {
                break;
            }
        } while (!cSSTextScanner.consume(AbstractJsonLexerKt.END_OBJ));
        return style;
    }

    public static List<String> parseClassAttribute(String str) {
        CSSTextScanner cSSTextScanner = new CSSTextScanner(str);
        ArrayList arrayList = null;
        while (!cSSTextScanner.empty()) {
            String strNextToken = cSSTextScanner.nextToken();
            if (strNextToken != null) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(strNextToken);
                cSSTextScanner.skipWhitespace();
            }
        }
        return arrayList;
    }

    static class RuleMatchContext {
        SVGBase.SvgElementBase targetElement;

        RuleMatchContext() {
        }

        public String toString() {
            SVGBase.SvgElementBase svgElementBase = this.targetElement;
            if (svgElementBase != null) {
                return String.format("<%s id=\"%s\">", svgElementBase.getNodeName(), this.targetElement.id);
            }
            return "";
        }
    }

    static boolean ruleMatch(RuleMatchContext ruleMatchContext, Selector selector, SVGBase.SvgElementBase svgElementBase) {
        if (selector.size() == 1) {
            return selectorMatch(ruleMatchContext, selector.get(0), svgElementBase);
        }
        ArrayList arrayList = new ArrayList();
        for (Object obj = svgElementBase.parent; obj != null; obj = ((SVGBase.SvgObject) obj).parent) {
            arrayList.add(obj);
        }
        Collections.reverse(arrayList);
        return ruleMatch(ruleMatchContext, selector, selector.size() - 1, arrayList, arrayList.size() - 1, svgElementBase);
    }

    private static boolean ruleMatch(RuleMatchContext ruleMatchContext, Selector selector, int i, List<SVGBase.SvgContainer> list, int i2, SVGBase.SvgElementBase svgElementBase) {
        SimpleSelector simpleSelector = selector.get(i);
        if (!selectorMatch(ruleMatchContext, simpleSelector, svgElementBase)) {
            return false;
        }
        if (simpleSelector.combinator != Combinator.DESCENDANT) {
            if (simpleSelector.combinator == Combinator.CHILD) {
                return ruleMatchOnAncestors(ruleMatchContext, selector, i - 1, list, i2);
            }
            int childPosition = getChildPosition(list, i2, svgElementBase);
            if (childPosition <= 0) {
                return false;
            }
            return ruleMatch(ruleMatchContext, selector, i - 1, list, i2, (SVGBase.SvgElementBase) svgElementBase.parent.getChildren().get(childPosition - 1));
        }
        if (i == 0) {
            return true;
        }
        for (int i3 = i2; i3 >= 0; i3--) {
            if (ruleMatchOnAncestors(ruleMatchContext, selector, i - 1, list, i3)) {
                return true;
            }
        }
        return false;
    }

    private static boolean ruleMatchOnAncestors(RuleMatchContext ruleMatchContext, Selector selector, int i, List<SVGBase.SvgContainer> list, int i2) {
        SimpleSelector simpleSelector = selector.get(i);
        SVGBase.SvgElementBase svgElementBase = (SVGBase.SvgElementBase) list.get(i2);
        if (!selectorMatch(ruleMatchContext, simpleSelector, svgElementBase)) {
            return false;
        }
        if (simpleSelector.combinator != Combinator.DESCENDANT) {
            if (simpleSelector.combinator == Combinator.CHILD) {
                return ruleMatchOnAncestors(ruleMatchContext, selector, i - 1, list, i2 - 1);
            }
            int childPosition = getChildPosition(list, i2, svgElementBase);
            if (childPosition <= 0) {
                return false;
            }
            return ruleMatch(ruleMatchContext, selector, i - 1, list, i2, (SVGBase.SvgElementBase) svgElementBase.parent.getChildren().get(childPosition - 1));
        }
        if (i == 0) {
            return true;
        }
        int i3 = i2;
        while (i3 > 0) {
            i3--;
            if (ruleMatchOnAncestors(ruleMatchContext, selector, i - 1, list, i3)) {
                return true;
            }
        }
        return false;
    }

    private static int getChildPosition(List<SVGBase.SvgContainer> list, int i, SVGBase.SvgElementBase svgElementBase) {
        int i2 = 0;
        if (i < 0) {
            return 0;
        }
        if (list.get(i) != svgElementBase.parent) {
            return -1;
        }
        Iterator<SVGBase.SvgObject> it = svgElementBase.parent.getChildren().iterator();
        while (it.hasNext()) {
            if (it.next() == svgElementBase) {
                return i2;
            }
            i2++;
        }
        return -1;
    }

    private static boolean selectorMatch(RuleMatchContext ruleMatchContext, SimpleSelector simpleSelector, SVGBase.SvgElementBase svgElementBase) {
        if (simpleSelector.tag != null && !simpleSelector.tag.equals(svgElementBase.getNodeName().toLowerCase(Locale.US))) {
            return false;
        }
        if (simpleSelector.attribs != null) {
            int size = simpleSelector.attribs.size();
            for (int i = 0; i < size; i++) {
                Attrib attrib = simpleSelector.attribs.get(i);
                String str = attrib.name;
                str.hashCode();
                if (str.equals("id")) {
                    if (!attrib.value.equals(svgElementBase.id)) {
                        return false;
                    }
                } else if (!str.equals("class") || svgElementBase.classNames == null || !svgElementBase.classNames.contains(attrib.value)) {
                    return false;
                }
            }
        }
        if (simpleSelector.pseudos == null) {
            return true;
        }
        int size2 = simpleSelector.pseudos.size();
        for (int i2 = 0; i2 < size2; i2++) {
            if (!simpleSelector.pseudos.get(i2).matches(ruleMatchContext, svgElementBase)) {
                return false;
            }
        }
        return true;
    }

    static class PseudoClassAnPlusB implements PseudoClass {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f12449a;
        private final int b;
        private final boolean isFromStart;
        private final boolean isOfType;
        private final String nodeName;

        PseudoClassAnPlusB(int i, int i2, boolean z, boolean z2, String str) {
            this.f12449a = i;
            this.b = i2;
            this.isFromStart = z;
            this.isOfType = z2;
            this.nodeName = str;
        }

        @Override // net.pubnative.lite.sdk.utils.svgparser.utils.CSSParser.PseudoClass
        public boolean matches(RuleMatchContext ruleMatchContext, SVGBase.SvgElementBase svgElementBase) {
            int i;
            int i2;
            String nodeName = (this.isOfType && this.nodeName == null) ? svgElementBase.getNodeName() : this.nodeName;
            if (svgElementBase.parent != null) {
                Iterator<SVGBase.SvgObject> it = svgElementBase.parent.getChildren().iterator();
                i = 0;
                i2 = 0;
                while (it.hasNext()) {
                    SVGBase.SvgElementBase svgElementBase2 = (SVGBase.SvgElementBase) it.next();
                    if (svgElementBase2 == svgElementBase) {
                        i = i2;
                    }
                    if (nodeName == null || svgElementBase2.getNodeName().equals(nodeName)) {
                        i2++;
                    }
                }
            } else {
                i = 0;
                i2 = 1;
            }
            int i3 = this.isFromStart ? i + 1 : i2 - i;
            int i4 = this.f12449a;
            if (i4 == 0) {
                return i3 == this.b;
            }
            int i5 = this.b;
            if ((i3 - i5) % i4 == 0) {
                return Integer.signum(i3 - i5) == 0 || Integer.signum(i3 - this.b) == Integer.signum(this.f12449a);
            }
            return false;
        }

        public String toString() {
            String str = this.isFromStart ? "" : "last-";
            return this.isOfType ? String.format(Locale.US, "nth-%schild(%dn%+d of type <%s>)", str, Integer.valueOf(this.f12449a), Integer.valueOf(this.b), this.nodeName) : String.format(Locale.US, "nth-%schild(%dn%+d)", str, Integer.valueOf(this.f12449a), Integer.valueOf(this.b));
        }
    }

    static class PseudoClassOnlyChild implements PseudoClass {
        private final boolean isOfType;
        private final String nodeName;

        public PseudoClassOnlyChild(boolean z, String str) {
            this.isOfType = z;
            this.nodeName = str;
        }

        @Override // net.pubnative.lite.sdk.utils.svgparser.utils.CSSParser.PseudoClass
        public boolean matches(RuleMatchContext ruleMatchContext, SVGBase.SvgElementBase svgElementBase) {
            int i;
            String nodeName = (this.isOfType && this.nodeName == null) ? svgElementBase.getNodeName() : this.nodeName;
            if (svgElementBase.parent != null) {
                Iterator<SVGBase.SvgObject> it = svgElementBase.parent.getChildren().iterator();
                i = 0;
                while (it.hasNext()) {
                    SVGBase.SvgElementBase svgElementBase2 = (SVGBase.SvgElementBase) it.next();
                    if (nodeName == null || svgElementBase2.getNodeName().equals(nodeName)) {
                        i++;
                    }
                }
            } else {
                i = 1;
            }
            return i == 1;
        }

        public String toString() {
            return this.isOfType ? String.format("only-of-type <%s>", this.nodeName) : "only-child";
        }
    }

    static class PseudoClassRoot implements PseudoClass {
        PseudoClassRoot() {
        }

        @Override // net.pubnative.lite.sdk.utils.svgparser.utils.CSSParser.PseudoClass
        public boolean matches(RuleMatchContext ruleMatchContext, SVGBase.SvgElementBase svgElementBase) {
            return svgElementBase.parent == null;
        }

        public String toString() {
            return "root";
        }
    }

    static class PseudoClassEmpty implements PseudoClass {
        PseudoClassEmpty() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // net.pubnative.lite.sdk.utils.svgparser.utils.CSSParser.PseudoClass
        public boolean matches(RuleMatchContext ruleMatchContext, SVGBase.SvgElementBase svgElementBase) {
            return !(svgElementBase instanceof SVGBase.SvgContainer) || ((SVGBase.SvgContainer) svgElementBase).getChildren().size() == 0;
        }

        public String toString() {
            return "empty";
        }
    }

    static class PseudoClassNot implements PseudoClass {
        private final List<Selector> selectorGroup;

        PseudoClassNot(List<Selector> list) {
            this.selectorGroup = list;
        }

        @Override // net.pubnative.lite.sdk.utils.svgparser.utils.CSSParser.PseudoClass
        public boolean matches(RuleMatchContext ruleMatchContext, SVGBase.SvgElementBase svgElementBase) {
            Iterator<Selector> it = this.selectorGroup.iterator();
            while (it.hasNext()) {
                if (CSSParser.ruleMatch(ruleMatchContext, it.next(), svgElementBase)) {
                    return false;
                }
            }
            return true;
        }

        int getSpecificity() {
            int i = Integer.MIN_VALUE;
            for (Selector selector : this.selectorGroup) {
                if (selector.specificity > i) {
                    i = selector.specificity;
                }
            }
            return i;
        }

        public String toString() {
            return "not(" + this.selectorGroup + ")";
        }
    }

    static class PseudoClassTarget implements PseudoClass {
        PseudoClassTarget() {
        }

        @Override // net.pubnative.lite.sdk.utils.svgparser.utils.CSSParser.PseudoClass
        public boolean matches(RuleMatchContext ruleMatchContext, SVGBase.SvgElementBase svgElementBase) {
            return ruleMatchContext != null && svgElementBase == ruleMatchContext.targetElement;
        }

        public String toString() {
            return TypedValues.AttributesType.S_TARGET;
        }
    }

    static class PseudoClassNotSupported implements PseudoClass {
        private final String clazz;

        @Override // net.pubnative.lite.sdk.utils.svgparser.utils.CSSParser.PseudoClass
        public boolean matches(RuleMatchContext ruleMatchContext, SVGBase.SvgElementBase svgElementBase) {
            return false;
        }

        PseudoClassNotSupported(String str) {
            this.clazz = str;
        }

        public String toString() {
            return this.clazz;
        }
    }
}
