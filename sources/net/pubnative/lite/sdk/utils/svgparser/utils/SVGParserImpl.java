package net.pubnative.lite.sdk.utils.svgparser.utils;

import android.graphics.Matrix;
import android.util.Log;
import android.util.Xml;
import androidx.core.internal.view.SupportMenu;
import androidx.core.view.InputDeviceCompat;
import androidx.core.view.ViewCompat;
import com.adjust.sdk.Constants;
import com.json.b9;
import com.json.cc;
import com.json.mediationsdk.utils.IronSourceConstants;
import com.safedk.android.analytics.brandsafety.l;
import com.safedk.android.utils.SdksMapping;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;
import java.util.zip.GZIPInputStream;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParserFactory;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import net.pubnative.lite.sdk.utils.svgparser.PreserveAspectRatio;
import net.pubnative.lite.sdk.utils.svgparser.SVGExternalFileResolver;
import net.pubnative.lite.sdk.utils.svgparser.SVGParseException;
import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.ext.DefaultHandler2;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes5.dex */
class SVGParserImpl implements SVGParser {
    static final String CURRENTCOLOR = "currentColor";
    public static final int ENTITY_WATCH_BUFFER_SIZE = 4096;
    private static final String FEATURE_STRING_PREFIX = "http://www.w3.org/TR/SVG11/feature#";
    static final String NONE = "none";
    private static final String SVG_NAMESPACE = "http://www.w3.org/2000/svg";
    private static final String TAG = "SVGParser";
    static final String VALID_DISPLAY_VALUES = "|inline|block|list-item|run-in|compact|marker|table|inline-table|table-row-group|table-header-group|table-footer-group|table-row|table-column-group|table-column|table-cell|table-caption|none|";
    static final String VALID_VISIBILITY_VALUES = "|visible|hidden|collapse|";
    private static final String XLINK_NAMESPACE = "http://www.w3.org/1999/xlink";
    public static final String XML_STYLESHEET_ATTR_ALTERNATE = "alternate";
    public static final String XML_STYLESHEET_ATTR_ALTERNATE_NO = "no";
    public static final String XML_STYLESHEET_ATTR_HREF = "href";
    public static final String XML_STYLESHEET_ATTR_MEDIA = "media";
    public static final String XML_STYLESHEET_ATTR_MEDIA_ALL = "all";
    public static final String XML_STYLESHEET_ATTR_TYPE = "type";
    private static final String XML_STYLESHEET_PROCESSING_INSTRUCTION = "xml-stylesheet";
    private int ignoreDepth;
    private static final boolean FORCE_SAX_ON_EARLY_ANDROIDS = false;
    private static final Pattern PATTERN_BLOCK_COMMENTS = Pattern.compile("/\\*.*?\\*/");
    private SVGBase svgDocument = null;
    private SVGBase.SvgContainer currentElement = null;
    private boolean enableInternalEntities = true;
    private SVGExternalFileResolver externalFileResolver = null;
    private boolean ignoring = false;
    private boolean inMetadataElement = false;
    private SVGElem metadataTag = null;
    private StringBuilder metadataElementContents = null;
    private boolean inStyleElement = false;
    private StringBuilder styleElementContents = null;

    private void debug(String str, Object... objArr) {
    }

    private void dumpNode(SVGBase.SvgObject svgObject, String str) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void endDocument() {
    }

    private static float hueToRgb(float f, float f2, float f3) {
        float f4;
        if (f3 < 0.0f) {
            f3 += 6.0f;
        }
        if (f3 >= 6.0f) {
            f3 -= 6.0f;
        }
        if (f3 < 1.0f) {
            f4 = (f2 - f) * f3;
        } else {
            if (f3 < 3.0f) {
                return f2;
            }
            if (f3 >= 4.0f) {
                return f;
            }
            f4 = (f2 - f) * (4.0f - f3);
        }
        return f4 + f;
    }

    SVGParserImpl() {
    }

    private enum SVGElem {
        svg,
        a,
        circle,
        clipPath,
        defs,
        desc,
        ellipse,
        g,
        image,
        line,
        linearGradient,
        marker,
        mask,
        path,
        pattern,
        polygon,
        polyline,
        radialGradient,
        rect,
        solidColor,
        stop,
        style,
        SWITCH,
        symbol,
        text,
        textPath,
        title,
        tref,
        tspan,
        use,
        view,
        UNSUPPORTED;

        private static final Map<String, SVGElem> cache = new HashMap();

        static {
            for (SVGElem sVGElem : values()) {
                if (sVGElem == SWITCH) {
                    cache.put("switch", sVGElem);
                } else if (sVGElem != UNSUPPORTED) {
                    cache.put(sVGElem.name(), sVGElem);
                }
            }
        }

        public static SVGElem fromString(String str) {
            SVGElem sVGElem = cache.get(str);
            return sVGElem != null ? sVGElem : UNSUPPORTED;
        }
    }

    enum SVGAttr {
        CLASS,
        clip,
        clip_path,
        clipPathUnits,
        clip_rule,
        color,
        cx,
        cy,
        direction,
        dx,
        dy,
        fx,
        fy,
        fr,
        d,
        display,
        fill,
        fill_rule,
        fill_opacity,
        font,
        font_family,
        font_feature_settings,
        font_size,
        font_stretch,
        font_style,
        font_weight,
        font_kerning,
        font_variant,
        font_variant_ligatures,
        font_variant_position,
        font_variant_caps,
        font_variant_numeric,
        font_variant_east_asian,
        font_variation_settings,
        glyph_orientation_vertical,
        gradientTransform,
        gradientUnits,
        height,
        href,
        image_rendering,
        isolation,
        letter_spacing,
        marker,
        marker_start,
        marker_mid,
        marker_end,
        markerHeight,
        markerUnits,
        markerWidth,
        mask,
        maskContentUnits,
        maskUnits,
        media,
        mix_blend_mode,
        offset,
        opacity,
        orient,
        overflow,
        pathLength,
        patternContentUnits,
        patternTransform,
        patternUnits,
        points,
        preserveAspectRatio,
        r,
        refX,
        refY,
        requiredFeatures,
        requiredExtensions,
        requiredFormats,
        requiredFonts,
        rx,
        ry,
        solid_color,
        solid_opacity,
        spreadMethod,
        startOffset,
        stop_color,
        stop_opacity,
        stroke,
        stroke_dasharray,
        stroke_dashoffset,
        stroke_linecap,
        stroke_linejoin,
        stroke_miterlimit,
        stroke_opacity,
        stroke_width,
        style,
        systemLanguage,
        text_anchor,
        text_decoration,
        text_orientation,
        transform,
        type,
        vector_effect,
        version,
        viewBox,
        width,
        word_spacing,
        writing_mode,
        x,
        y,
        x1,
        y1,
        x2,
        y2,
        viewport_fill,
        viewport_fill_opacity,
        visibility,
        UNSUPPORTED;

        private static final Map<String, SVGAttr> cache = new HashMap();

        static {
            for (SVGAttr sVGAttr : values()) {
                if (sVGAttr == CLASS) {
                    cache.put(SdksMapping.KEY_INSTALLED_MEDIATION_ADAPTERS_CLASS, sVGAttr);
                } else {
                    if (sVGAttr != UNSUPPORTED) {
                        cache.put(sVGAttr.name().replace('_', '-'), sVGAttr);
                    }
                }
            }
        }

        public static SVGAttr fromString(String str) {
            SVGAttr sVGAttr = cache.get(str);
            return sVGAttr != null ? sVGAttr : UNSUPPORTED;
        }
    }

    private static class ColourKeywords {
        private static final Map<String, Integer> colourKeywords;

        private ColourKeywords() {
        }

        static {
            HashMap map = new HashMap(47);
            colourKeywords = map;
            map.put("aliceblue", -984833);
            map.put("antiquewhite", -332841);
            map.put("aqua", -16711681);
            map.put("aquamarine", -8388652);
            map.put("azure", -983041);
            map.put("beige", -657956);
            map.put("bisque", -6972);
            map.put("black", Integer.valueOf(ViewCompat.MEASURED_STATE_MASK));
            map.put("blanchedalmond", -5171);
            map.put("blue", -16776961);
            map.put("blueviolet", -7722014);
            map.put("brown", -5952982);
            map.put("burlywood", -2180985);
            map.put("cadetblue", -10510688);
            map.put("chartreuse", -8388864);
            map.put("chocolate", -2987746);
            map.put("coral", -32944);
            map.put("cornflowerblue", -10185235);
            map.put("cornsilk", -1828);
            map.put("crimson", -2354116);
            map.put("cyan", -16711681);
            map.put("darkblue", -16777077);
            map.put("darkcyan", -16741493);
            map.put("darkgoldenrod", -4684277);
            map.put("darkgray", -5658199);
            map.put("darkgreen", -16751616);
            map.put("darkgrey", -5658199);
            map.put("darkkhaki", -4343957);
            map.put("darkmagenta", -7667573);
            map.put("darkolivegreen", -11179217);
            map.put("darkorange", -29696);
            map.put("darkorchid", -6737204);
            map.put("darkred", -7667712);
            map.put("darksalmon", -1468806);
            map.put("darkseagreen", -7357297);
            map.put("darkslateblue", -12042869);
            map.put("darkslategray", -13676721);
            map.put("darkslategrey", -13676721);
            map.put("darkturquoise", -16724271);
            map.put("darkviolet", -7077677);
            map.put("deeppink", -60269);
            map.put("deepskyblue", -16728065);
            map.put("dimgray", -9868951);
            map.put("dimgrey", -9868951);
            map.put("dodgerblue", -14774017);
            map.put("firebrick", -5103070);
            map.put("floralwhite", -1296);
            map.put("forestgreen", -14513374);
            map.put("fuchsia", -65281);
            map.put("gainsboro", -2302756);
            map.put("ghostwhite", -460545);
            map.put("gold", -10496);
            map.put("goldenrod", -2448096);
            map.put("gray", -8355712);
            map.put("green", -16744448);
            map.put("greenyellow", -5374161);
            map.put("grey", -8355712);
            map.put("honeydew", -983056);
            map.put("hotpink", -38476);
            map.put("indianred", -3318692);
            map.put("indigo", -11861886);
            map.put("ivory", -16);
            map.put("khaki", -989556);
            map.put("lavender", -1644806);
            map.put("lavenderblush", -3851);
            map.put("lawngreen", -8586240);
            map.put("lemonchiffon", -1331);
            map.put("lightblue", -5383962);
            map.put("lightcoral", -1015680);
            map.put("lightcyan", -2031617);
            map.put("lightgoldenrodyellow", -329006);
            map.put("lightgray", -2894893);
            map.put("lightgreen", -7278960);
            map.put("lightgrey", -2894893);
            map.put("lightpink", -18751);
            map.put("lightsalmon", -24454);
            map.put("lightseagreen", -14634326);
            map.put("lightskyblue", -7876870);
            map.put("lightslategray", -8943463);
            map.put("lightslategrey", -8943463);
            map.put("lightsteelblue", -5192482);
            map.put("lightyellow", -32);
            map.put("lime", -16711936);
            map.put("limegreen", -13447886);
            map.put("linen", -331546);
            map.put("magenta", -65281);
            map.put("maroon", -8388608);
            map.put("mediumaquamarine", -10039894);
            map.put("mediumblue", -16777011);
            map.put("mediumorchid", -4565549);
            map.put("mediumpurple", -7114533);
            map.put("mediumseagreen", -12799119);
            map.put("mediumslateblue", -8689426);
            map.put("mediumspringgreen", -16713062);
            map.put("mediumturquoise", -12004916);
            map.put("mediumvioletred", -3730043);
            map.put("midnightblue", -15132304);
            map.put("mintcream", -655366);
            map.put("mistyrose", -6943);
            map.put("moccasin", -6987);
            map.put("navajowhite", -8531);
            map.put("navy", -16777088);
            map.put("oldlace", -133658);
            map.put("olive", -8355840);
            map.put("olivedrab", -9728477);
            map.put("orange", -23296);
            map.put("orangered", -47872);
            map.put("orchid", -2461482);
            map.put("palegoldenrod", -1120086);
            map.put("palegreen", -6751336);
            map.put("paleturquoise", -5247250);
            map.put("palevioletred", -2396013);
            map.put("papayawhip", -4139);
            map.put("peachpuff", -9543);
            map.put("peru", -3308225);
            map.put("pink", -16181);
            map.put("plum", -2252579);
            map.put("powderblue", -5185306);
            map.put("purple", -8388480);
            map.put("rebeccapurple", -10079335);
            map.put("red", Integer.valueOf(SupportMenu.CATEGORY_MASK));
            map.put("rosybrown", -4419697);
            map.put("royalblue", -12490271);
            map.put("saddlebrown", -7650029);
            map.put("salmon", -360334);
            map.put("sandybrown", -744352);
            map.put("seagreen", -13726889);
            map.put("seashell", -2578);
            map.put("sienna", -6270419);
            map.put("silver", -4144960);
            map.put("skyblue", -7876885);
            map.put("slateblue", -9807155);
            map.put("slategray", -9404272);
            map.put("slategrey", -9404272);
            map.put("snow", -1286);
            map.put("springgreen", -16711809);
            map.put("steelblue", -12156236);
            map.put("tan", -2968436);
            map.put("teal", -16744320);
            map.put("thistle", -2572328);
            map.put("tomato", -40121);
            map.put("turquoise", -12525360);
            map.put("violet", -1146130);
            map.put("wheat", -663885);
            map.put("white", -1);
            map.put("whitesmoke", -657931);
            map.put("yellow", Integer.valueOf(InputDeviceCompat.SOURCE_ANY));
            map.put("yellowgreen", -6632142);
            map.put(b9.h.T, 0);
        }

        static Integer get(String str) {
            return colourKeywords.get(str);
        }
    }

    private static class FontSizeKeywords {
        private static final Map<String, SVGBase.Length> fontSizeKeywords;

        private FontSizeKeywords() {
        }

        static {
            HashMap map = new HashMap(9);
            fontSizeKeywords = map;
            map.put("xx-small", new SVGBase.Length(0.694f, SVGBase.Unit.pt));
            map.put("x-small", new SVGBase.Length(0.833f, SVGBase.Unit.pt));
            map.put(Constants.SMALL, new SVGBase.Length(10.0f, SVGBase.Unit.pt));
            map.put("medium", new SVGBase.Length(12.0f, SVGBase.Unit.pt));
            map.put(Constants.LARGE, new SVGBase.Length(14.4f, SVGBase.Unit.pt));
            map.put("x-large", new SVGBase.Length(17.3f, SVGBase.Unit.pt));
            map.put("xx-large", new SVGBase.Length(20.7f, SVGBase.Unit.pt));
            map.put("smaller", new SVGBase.Length(83.33f, SVGBase.Unit.percent));
            map.put("larger", new SVGBase.Length(120.0f, SVGBase.Unit.percent));
        }

        static SVGBase.Length get(String str) {
            return fontSizeKeywords.get(str);
        }
    }

    private static class FontWeightKeywords {
        private static final Map<String, Float> fontWeightKeywords;

        private FontWeightKeywords() {
        }

        static {
            HashMap map = new HashMap(4);
            fontWeightKeywords = map;
            map.put(Constants.NORMAL, Float.valueOf(400.0f));
            map.put("bold", Float.valueOf(700.0f));
            map.put("bolder", Float.valueOf(Float.MAX_VALUE));
            map.put("lighter", Float.valueOf(Float.MIN_VALUE));
        }

        static Float get(String str) {
            return fontWeightKeywords.get(str);
        }

        static boolean contains(String str) {
            return fontWeightKeywords.containsKey(str);
        }
    }

    private static class FontStretchKeywords {
        private static final Map<String, Float> fontStretchKeywords;

        private FontStretchKeywords() {
        }

        static {
            HashMap map = new HashMap(9);
            fontStretchKeywords = map;
            map.put("ultra-condensed", Float.valueOf(50.0f));
            map.put("extra-condensed", Float.valueOf(62.5f));
            map.put("condensed", Float.valueOf(75.0f));
            map.put("semi-condensed", Float.valueOf(87.5f));
            map.put(Constants.NORMAL, Float.valueOf(100.0f));
            map.put("semi-expanded", Float.valueOf(112.5f));
            map.put("expanded", Float.valueOf(125.0f));
            map.put("extra-expanded", Float.valueOf(150.0f));
            map.put("ultra-expanded", Float.valueOf(200.0f));
        }

        static Float get(String str) {
            return fontStretchKeywords.get(str);
        }

        static boolean contains(String str) {
            return fontStretchKeywords.containsKey(str);
        }
    }

    @Override // net.pubnative.lite.sdk.utils.svgparser.utils.SVGParser
    public SVGBase parseStream(InputStream inputStream) throws SVGParseException {
        if (!inputStream.markSupported()) {
            inputStream = new BufferedInputStream(inputStream);
        }
        try {
            inputStream.mark(3);
            int i = inputStream.read() + (inputStream.read() << 8);
            inputStream.reset();
            if (i == 35615) {
                inputStream = new BufferedInputStream(new GZIPInputStream(inputStream));
            }
        } catch (IOException unused) {
        }
        try {
            if (FORCE_SAX_ON_EARLY_ANDROIDS) {
                debug("Forcing SAX parser for this version of Android", new Object[0]);
                parseUsingSAX(inputStream);
                return this.svgDocument;
            }
            if (this.enableInternalEntities) {
                inputStream.mark(4096);
                byte[] bArr = new byte[4096];
                String str = new String(bArr, 0, inputStream.read(bArr));
                inputStream.reset();
                if (str.contains("<!ENTITY ")) {
                    debug("Switching to SAX parser to process entities", new Object[0]);
                    parseUsingSAX(inputStream);
                    return this.svgDocument;
                }
            }
            parseUsingXmlPullParser(inputStream);
            return this.svgDocument;
        } catch (IOException e) {
            Log.e(TAG, "Error occurred while performing check for entities.  File may not be parsed correctly if it contains entity definitions.", e);
            parseUsingXmlPullParser(inputStream);
            return this.svgDocument;
        } finally {
            try {
                inputStream.close();
            } catch (IOException unused2) {
                Log.e(TAG, "Exception thrown closing input stream");
            }
        }
    }

    @Override // net.pubnative.lite.sdk.utils.svgparser.utils.SVGParser
    public SVGParser setInternalEntitiesEnabled(boolean z) {
        this.enableInternalEntities = z;
        return this;
    }

    @Override // net.pubnative.lite.sdk.utils.svgparser.utils.SVGParser
    public SVGParser setExternalFileResolver(SVGExternalFileResolver sVGExternalFileResolver) {
        this.externalFileResolver = sVGExternalFileResolver;
        return this;
    }

    private static class XPPAttributesWrapper implements Attributes {
        private final XmlPullParser parser;

        @Override // org.xml.sax.Attributes
        public int getIndex(String str) {
            return -1;
        }

        @Override // org.xml.sax.Attributes
        public int getIndex(String str, String str2) {
            return -1;
        }

        @Override // org.xml.sax.Attributes
        public String getType(int i) {
            return null;
        }

        @Override // org.xml.sax.Attributes
        public String getType(String str) {
            return null;
        }

        @Override // org.xml.sax.Attributes
        public String getType(String str, String str2) {
            return null;
        }

        @Override // org.xml.sax.Attributes
        public String getValue(String str) {
            return null;
        }

        @Override // org.xml.sax.Attributes
        public String getValue(String str, String str2) {
            return null;
        }

        public XPPAttributesWrapper(XmlPullParser xmlPullParser) {
            this.parser = xmlPullParser;
        }

        @Override // org.xml.sax.Attributes
        public int getLength() {
            return this.parser.getAttributeCount();
        }

        @Override // org.xml.sax.Attributes
        public String getURI(int i) {
            return this.parser.getAttributeNamespace(i);
        }

        @Override // org.xml.sax.Attributes
        public String getLocalName(int i) {
            return this.parser.getAttributeName(i);
        }

        @Override // org.xml.sax.Attributes
        public String getQName(int i) {
            String attributeName = this.parser.getAttributeName(i);
            return this.parser.getAttributePrefix(i) != null ? this.parser.getAttributePrefix(i) + AbstractJsonLexerKt.COLON + attributeName : attributeName;
        }

        @Override // org.xml.sax.Attributes
        public String getValue(int i) {
            return this.parser.getAttributeValue(i);
        }
    }

    private void parseUsingXmlPullParser(InputStream inputStream) throws SVGParseException {
        try {
            XmlPullParser xmlPullParserNewPullParser = Xml.newPullParser();
            XPPAttributesWrapper xPPAttributesWrapper = new XPPAttributesWrapper(xmlPullParserNewPullParser);
            xmlPullParserNewPullParser.setFeature("http://xmlpull.org/v1/doc/features.html#process-docdecl", false);
            xmlPullParserNewPullParser.setFeature("http://xmlpull.org/v1/doc/features.html#process-namespaces", true);
            xmlPullParserNewPullParser.setInput(inputStream, null);
            for (int eventType = xmlPullParserNewPullParser.getEventType(); eventType != 1; eventType = xmlPullParserNewPullParser.nextToken()) {
                if (eventType == 0) {
                    startDocument();
                } else if (eventType == 8) {
                    TextScanner textScanner = new TextScanner(xmlPullParserNewPullParser.getText());
                    handleProcessingInstruction(textScanner.nextToken(), parseProcessingInstructionAttributes(textScanner));
                } else if (eventType == 2) {
                    String name = xmlPullParserNewPullParser.getName();
                    if (xmlPullParserNewPullParser.getPrefix() != null) {
                        name = xmlPullParserNewPullParser.getPrefix() + AbstractJsonLexerKt.COLON + name;
                    }
                    startElement(xmlPullParserNewPullParser.getNamespace(), xmlPullParserNewPullParser.getName(), name, xPPAttributesWrapper);
                } else if (eventType == 3) {
                    String name2 = xmlPullParserNewPullParser.getName();
                    if (xmlPullParserNewPullParser.getPrefix() != null) {
                        name2 = xmlPullParserNewPullParser.getPrefix() + AbstractJsonLexerKt.COLON + name2;
                    }
                    endElement(xmlPullParserNewPullParser.getNamespace(), xmlPullParserNewPullParser.getName(), name2);
                } else if (eventType == 4) {
                    int[] iArr = new int[2];
                    text(xmlPullParserNewPullParser.getTextCharacters(iArr), iArr[0], iArr[1]);
                } else if (eventType == 5) {
                    text(xmlPullParserNewPullParser.getText());
                } else if (eventType == 6) {
                    text(xmlPullParserNewPullParser.getText());
                }
            }
            endDocument();
        } catch (IOException e) {
            throw new SVGParseException("Stream error", e);
        } catch (XmlPullParserException e2) {
            throw new SVGParseException("XML parser problem", e2);
        }
    }

    private void parseUsingSAX(InputStream inputStream) throws SVGParseException {
        try {
            SAXParserFactory sAXParserFactoryNewInstance = SAXParserFactory.newInstance();
            if (!FORCE_SAX_ON_EARLY_ANDROIDS) {
                sAXParserFactoryNewInstance.setFeature("http://xml.org/sax/features/external-general-entities", false);
                sAXParserFactoryNewInstance.setFeature("http://xml.org/sax/features/external-parameter-entities", false);
            }
            XMLReader xMLReader = sAXParserFactoryNewInstance.newSAXParser().getXMLReader();
            SAXHandler sAXHandler = new SAXHandler();
            xMLReader.setContentHandler(sAXHandler);
            xMLReader.setProperty("http://xml.org/sax/properties/lexical-handler", sAXHandler);
            xMLReader.parse(new InputSource(inputStream));
        } catch (IOException e) {
            throw new SVGParseException("Stream error", e);
        } catch (ParserConfigurationException e2) {
            throw new SVGParseException("XML parser problem", e2);
        } catch (SAXException e3) {
            throw new SVGParseException("SVG parse error", e3);
        }
    }

    private class SAXHandler extends DefaultHandler2 {
        private SAXHandler() {
        }

        @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
        public void startDocument() {
            SVGParserImpl.this.startDocument();
        }

        @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
        public void startElement(String str, String str2, String str3, Attributes attributes) throws SAXException {
            SVGParserImpl.this.startElement(str, str2, str3, attributes);
        }

        @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
        public void characters(char[] cArr, int i, int i2) throws SAXException {
            SVGParserImpl.this.text(new String(cArr, i, i2));
        }

        @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
        public void endElement(String str, String str2, String str3) throws SAXException {
            SVGParserImpl.this.endElement(str, str2, str3);
        }

        @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
        public void endDocument() {
            SVGParserImpl.this.endDocument();
        }

        @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
        public void processingInstruction(String str, String str2) {
            SVGParserImpl.this.handleProcessingInstruction(str, SVGParserImpl.this.parseProcessingInstructionAttributes(new TextScanner(str2)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startDocument() {
        this.svgDocument = new SVGBase(this.enableInternalEntities, this.externalFileResolver);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startElement(String str, String str2, String str3, Attributes attributes) throws SVGParseException {
        if (this.ignoring) {
            this.ignoreDepth++;
        }
        if (SVG_NAMESPACE.equals(str) || "".equals(str)) {
            if (str2.length() <= 0) {
                str2 = str3;
            }
            SVGElem sVGElemFromString = SVGElem.fromString(str2);
            switch (AnonymousClass1.$SwitchMap$net$pubnative$lite$sdk$utils$svgparser$utils$SVGParserImpl$SVGElem[sVGElemFromString.ordinal()]) {
                case 1:
                    svg(attributes);
                    break;
                case 2:
                    g(attributes);
                    break;
                case 3:
                    defs(attributes);
                    break;
                case 4:
                    a(attributes);
                    break;
                case 5:
                    use(attributes);
                    break;
                case 6:
                    path(attributes);
                    break;
                case 7:
                    rect(attributes);
                    break;
                case 8:
                    circle(attributes);
                    break;
                case 9:
                    ellipse(attributes);
                    break;
                case 10:
                    line(attributes);
                    break;
                case 11:
                    polyline(attributes);
                    break;
                case 12:
                    polygon(attributes);
                    break;
                case 13:
                    text(attributes);
                    break;
                case 14:
                    tspan(attributes);
                    break;
                case 15:
                    tref(attributes);
                    break;
                case 16:
                    zwitch(attributes);
                    break;
                case 17:
                    symbol(attributes);
                    break;
                case 18:
                    marker(attributes);
                    break;
                case 19:
                    linearGradient(attributes);
                    break;
                case 20:
                    radialGradient(attributes);
                    break;
                case 21:
                    stop(attributes);
                    break;
                case 22:
                case 23:
                    this.inMetadataElement = true;
                    this.metadataTag = sVGElemFromString;
                    break;
                case 24:
                    clipPath(attributes);
                    break;
                case 25:
                    textPath(attributes);
                    break;
                case 26:
                    pattern(attributes);
                    break;
                case 27:
                    image(attributes);
                    break;
                case 28:
                    view(attributes);
                    break;
                case 29:
                    mask(attributes);
                    break;
                case 30:
                    style(attributes);
                    break;
                case 31:
                    solidColor(attributes);
                    break;
                default:
                    this.ignoring = true;
                    this.ignoreDepth = 1;
                    break;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void text(String str) throws SVGParseException {
        if (this.ignoring) {
            return;
        }
        if (this.inMetadataElement) {
            if (this.metadataElementContents == null) {
                this.metadataElementContents = new StringBuilder(str.length());
            }
            this.metadataElementContents.append(str);
        } else if (this.inStyleElement) {
            if (this.styleElementContents == null) {
                this.styleElementContents = new StringBuilder(str.length());
            }
            this.styleElementContents.append(str);
        } else if (this.currentElement instanceof SVGBase.TextContainer) {
            appendToTextContainer(str);
        }
    }

    private void text(char[] cArr, int i, int i2) throws SVGParseException {
        if (this.ignoring) {
            return;
        }
        if (this.inMetadataElement) {
            if (this.metadataElementContents == null) {
                this.metadataElementContents = new StringBuilder(i2);
            }
            this.metadataElementContents.append(cArr, i, i2);
        } else if (this.inStyleElement) {
            if (this.styleElementContents == null) {
                this.styleElementContents = new StringBuilder(i2);
            }
            this.styleElementContents.append(cArr, i, i2);
        } else if (this.currentElement instanceof SVGBase.TextContainer) {
            appendToTextContainer(new String(cArr, i, i2));
        }
    }

    private void appendToTextContainer(String str) throws SVGParseException {
        SVGBase.SvgConditionalContainer svgConditionalContainer = (SVGBase.SvgConditionalContainer) this.currentElement;
        int size = svgConditionalContainer.getChildren().size();
        SVGBase.SvgObject svgObject = size == 0 ? null : svgConditionalContainer.getChildren().get(size - 1);
        if (svgObject instanceof SVGBase.TextSequence) {
            ((SVGBase.TextSequence) svgObject).text += str;
        } else {
            this.currentElement.addChild(new SVGBase.TextSequence(str));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void endElement(String str, String str2, String str3) throws SVGParseException {
        if (this.ignoring) {
            int i = this.ignoreDepth - 1;
            this.ignoreDepth = i;
            if (i == 0) {
                this.ignoring = false;
                return;
            }
            return;
        }
        if (SVG_NAMESPACE.equals(str) || "".equals(str)) {
            if (str2.length() <= 0) {
                str2 = str3;
            }
            int i2 = AnonymousClass1.$SwitchMap$net$pubnative$lite$sdk$utils$svgparser$utils$SVGParserImpl$SVGElem[SVGElem.fromString(str2).ordinal()];
            if (i2 != 1 && i2 != 2 && i2 != 3 && i2 != 4 && i2 != 5 && i2 != 13 && i2 != 14) {
                switch (i2) {
                    case 16:
                    case 17:
                    case 18:
                    case 19:
                    case 20:
                    case 21:
                    case 24:
                    case 25:
                    case 26:
                    case 27:
                    case 28:
                    case 29:
                    case 31:
                        break;
                    case 22:
                    case 23:
                        this.inMetadataElement = false;
                        if (this.metadataElementContents != null) {
                            if (this.metadataTag == SVGElem.title) {
                                this.svgDocument.setTitle(this.metadataElementContents.toString());
                            } else if (this.metadataTag == SVGElem.desc) {
                                this.svgDocument.setDesc(this.metadataElementContents.toString());
                            }
                            this.metadataElementContents.setLength(0);
                            return;
                        }
                        return;
                    case 30:
                        StringBuilder sb = this.styleElementContents;
                        if (sb != null) {
                            this.inStyleElement = false;
                            parseCSSStyleSheet(sb.toString());
                            this.styleElementContents.setLength(0);
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
            Object obj = this.currentElement;
            if (obj == null) {
                throw new SVGParseException(String.format("Unbalanced end element </%s> found", str2));
            }
            this.currentElement = ((SVGBase.SvgObject) obj).parent;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleProcessingInstruction(String str, Map<String, String> map) {
        String str2;
        String strResolveCSSStyleSheet;
        if (!str.equals(XML_STYLESHEET_PROCESSING_INSTRUCTION) || this.externalFileResolver == null) {
            return;
        }
        if (map.get("type") == null || "text/css".equals(map.get("type"))) {
            if ((map.get("alternate") != null && !"no".equals(map.get("alternate"))) || (str2 = map.get("href")) == null || (strResolveCSSStyleSheet = this.externalFileResolver.resolveCSSStyleSheet(str2)) == null) {
                return;
            }
            String str3 = map.get("media");
            if (str3 != null && !"all".equals(str3.trim())) {
                strResolveCSSStyleSheet = "@media " + str3 + " { " + strResolveCSSStyleSheet + "}";
            }
            parseCSSStyleSheet(strResolveCSSStyleSheet);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Map<String, String> parseProcessingInstructionAttributes(TextScanner textScanner) {
        HashMap map = new HashMap();
        textScanner.skipWhitespace();
        String strNextToken = textScanner.nextToken(cc.T);
        while (strNextToken != null) {
            textScanner.consume(cc.T);
            map.put(strNextToken, textScanner.nextQuotedString());
            textScanner.skipWhitespace();
            strNextToken = textScanner.nextToken(cc.T);
        }
        return map;
    }

    private void svg(Attributes attributes) throws SVGParseException {
        debug("<svg>", new Object[0]);
        SVGBase.Svg svg = new SVGBase.Svg();
        svg.document = this.svgDocument;
        svg.parent = this.currentElement;
        parseAttributesCore(svg, attributes);
        parseAttributesStyle(svg, attributes);
        parseAttributesConditional(svg, attributes);
        parseAttributesViewBox(svg, attributes);
        parseAttributesSVG(svg, attributes);
        SVGBase.SvgContainer svgContainer = this.currentElement;
        if (svgContainer == null) {
            this.svgDocument.setRootElement(svg);
        } else {
            svgContainer.addChild(svg);
        }
        this.currentElement = svg;
    }

    private void parseAttributesSVG(SVGBase.Svg svg, Attributes attributes) throws SVGParseException {
        for (int i = 0; i < attributes.getLength(); i++) {
            String strTrim = attributes.getValue(i).trim();
            int i2 = AnonymousClass1.$SwitchMap$net$pubnative$lite$sdk$utils$svgparser$utils$SVGParserImpl$SVGAttr[SVGAttr.fromString(attributes.getLocalName(i)).ordinal()];
            if (i2 == 1) {
                svg.x = parseLength(strTrim);
            } else if (i2 == 2) {
                svg.y = parseLength(strTrim);
            } else if (i2 == 3) {
                svg.width = parseLength(strTrim);
                if (svg.width.isNegative()) {
                    throw new SVGParseException("Invalid <svg> element. width cannot be negative");
                }
            } else if (i2 == 4) {
                svg.height = parseLength(strTrim);
                if (svg.height.isNegative()) {
                    throw new SVGParseException("Invalid <svg> element. height cannot be negative");
                }
            } else if (i2 == 5) {
                svg.version = strTrim;
            }
        }
    }

    /* JADX INFO: renamed from: net.pubnative.lite.sdk.utils.svgparser.utils.SVGParserImpl$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$net$pubnative$lite$sdk$utils$svgparser$utils$SVGParserImpl$SVGElem;

        static {
            int[] iArr = new int[SVGAttr.values().length];
            $SwitchMap$net$pubnative$lite$sdk$utils$svgparser$utils$SVGParserImpl$SVGAttr = iArr;
            try {
                iArr[SVGAttr.x.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$net$pubnative$lite$sdk$utils$svgparser$utils$SVGParserImpl$SVGAttr[SVGAttr.y.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$net$pubnative$lite$sdk$utils$svgparser$utils$SVGParserImpl$SVGAttr[SVGAttr.width.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$net$pubnative$lite$sdk$utils$svgparser$utils$SVGParserImpl$SVGAttr[SVGAttr.height.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$net$pubnative$lite$sdk$utils$svgparser$utils$SVGParserImpl$SVGAttr[SVGAttr.version.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$net$pubnative$lite$sdk$utils$svgparser$utils$SVGParserImpl$SVGAttr[SVGAttr.href.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$net$pubnative$lite$sdk$utils$svgparser$utils$SVGParserImpl$SVGAttr[SVGAttr.preserveAspectRatio.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$net$pubnative$lite$sdk$utils$svgparser$utils$SVGParserImpl$SVGAttr[SVGAttr.d.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$net$pubnative$lite$sdk$utils$svgparser$utils$SVGParserImpl$SVGAttr[SVGAttr.pathLength.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$net$pubnative$lite$sdk$utils$svgparser$utils$SVGParserImpl$SVGAttr[SVGAttr.rx.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$net$pubnative$lite$sdk$utils$svgparser$utils$SVGParserImpl$SVGAttr[SVGAttr.ry.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                $SwitchMap$net$pubnative$lite$sdk$utils$svgparser$utils$SVGParserImpl$SVGAttr[SVGAttr.cx.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                $SwitchMap$net$pubnative$lite$sdk$utils$svgparser$utils$SVGParserImpl$SVGAttr[SVGAttr.cy.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                $SwitchMap$net$pubnative$lite$sdk$utils$svgparser$utils$SVGParserImpl$SVGAttr[SVGAttr.r.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                $SwitchMap$net$pubnative$lite$sdk$utils$svgparser$utils$SVGParserImpl$SVGAttr[SVGAttr.x1.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                $SwitchMap$net$pubnative$lite$sdk$utils$svgparser$utils$SVGParserImpl$SVGAttr[SVGAttr.y1.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                $SwitchMap$net$pubnative$lite$sdk$utils$svgparser$utils$SVGParserImpl$SVGAttr[SVGAttr.x2.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                $SwitchMap$net$pubnative$lite$sdk$utils$svgparser$utils$SVGParserImpl$SVGAttr[SVGAttr.y2.ordinal()] = 18;
            } catch (NoSuchFieldError unused18) {
            }
            try {
                $SwitchMap$net$pubnative$lite$sdk$utils$svgparser$utils$SVGParserImpl$SVGAttr[SVGAttr.dx.ordinal()] = 19;
            } catch (NoSuchFieldError unused19) {
            }
            try {
                $SwitchMap$net$pubnative$lite$sdk$utils$svgparser$utils$SVGParserImpl$SVGAttr[SVGAttr.dy.ordinal()] = 20;
            } catch (NoSuchFieldError unused20) {
            }
            try {
                $SwitchMap$net$pubnative$lite$sdk$utils$svgparser$utils$SVGParserImpl$SVGAttr[SVGAttr.requiredFeatures.ordinal()] = 21;
            } catch (NoSuchFieldError unused21) {
            }
            try {
                $SwitchMap$net$pubnative$lite$sdk$utils$svgparser$utils$SVGParserImpl$SVGAttr[SVGAttr.requiredExtensions.ordinal()] = 22;
            } catch (NoSuchFieldError unused22) {
            }
            try {
                $SwitchMap$net$pubnative$lite$sdk$utils$svgparser$utils$SVGParserImpl$SVGAttr[SVGAttr.systemLanguage.ordinal()] = 23;
            } catch (NoSuchFieldError unused23) {
            }
            try {
                $SwitchMap$net$pubnative$lite$sdk$utils$svgparser$utils$SVGParserImpl$SVGAttr[SVGAttr.requiredFormats.ordinal()] = 24;
            } catch (NoSuchFieldError unused24) {
            }
            try {
                $SwitchMap$net$pubnative$lite$sdk$utils$svgparser$utils$SVGParserImpl$SVGAttr[SVGAttr.requiredFonts.ordinal()] = 25;
            } catch (NoSuchFieldError unused25) {
            }
            try {
                $SwitchMap$net$pubnative$lite$sdk$utils$svgparser$utils$SVGParserImpl$SVGAttr[SVGAttr.refX.ordinal()] = 26;
            } catch (NoSuchFieldError unused26) {
            }
            try {
                $SwitchMap$net$pubnative$lite$sdk$utils$svgparser$utils$SVGParserImpl$SVGAttr[SVGAttr.refY.ordinal()] = 27;
            } catch (NoSuchFieldError unused27) {
            }
            try {
                $SwitchMap$net$pubnative$lite$sdk$utils$svgparser$utils$SVGParserImpl$SVGAttr[SVGAttr.markerWidth.ordinal()] = 28;
            } catch (NoSuchFieldError unused28) {
            }
            try {
                $SwitchMap$net$pubnative$lite$sdk$utils$svgparser$utils$SVGParserImpl$SVGAttr[SVGAttr.markerHeight.ordinal()] = 29;
            } catch (NoSuchFieldError unused29) {
            }
            try {
                $SwitchMap$net$pubnative$lite$sdk$utils$svgparser$utils$SVGParserImpl$SVGAttr[SVGAttr.markerUnits.ordinal()] = 30;
            } catch (NoSuchFieldError unused30) {
            }
            try {
                $SwitchMap$net$pubnative$lite$sdk$utils$svgparser$utils$SVGParserImpl$SVGAttr[SVGAttr.orient.ordinal()] = 31;
            } catch (NoSuchFieldError unused31) {
            }
            try {
                $SwitchMap$net$pubnative$lite$sdk$utils$svgparser$utils$SVGParserImpl$SVGAttr[SVGAttr.gradientUnits.ordinal()] = 32;
            } catch (NoSuchFieldError unused32) {
            }
            try {
                $SwitchMap$net$pubnative$lite$sdk$utils$svgparser$utils$SVGParserImpl$SVGAttr[SVGAttr.gradientTransform.ordinal()] = 33;
            } catch (NoSuchFieldError unused33) {
            }
            try {
                $SwitchMap$net$pubnative$lite$sdk$utils$svgparser$utils$SVGParserImpl$SVGAttr[SVGAttr.spreadMethod.ordinal()] = 34;
            } catch (NoSuchFieldError unused34) {
            }
            try {
                $SwitchMap$net$pubnative$lite$sdk$utils$svgparser$utils$SVGParserImpl$SVGAttr[SVGAttr.fx.ordinal()] = 35;
            } catch (NoSuchFieldError unused35) {
            }
            try {
                $SwitchMap$net$pubnative$lite$sdk$utils$svgparser$utils$SVGParserImpl$SVGAttr[SVGAttr.fy.ordinal()] = 36;
            } catch (NoSuchFieldError unused36) {
            }
            try {
                $SwitchMap$net$pubnative$lite$sdk$utils$svgparser$utils$SVGParserImpl$SVGAttr[SVGAttr.fr.ordinal()] = 37;
            } catch (NoSuchFieldError unused37) {
            }
            try {
                $SwitchMap$net$pubnative$lite$sdk$utils$svgparser$utils$SVGParserImpl$SVGAttr[SVGAttr.offset.ordinal()] = 38;
            } catch (NoSuchFieldError unused38) {
            }
            try {
                $SwitchMap$net$pubnative$lite$sdk$utils$svgparser$utils$SVGParserImpl$SVGAttr[SVGAttr.clipPathUnits.ordinal()] = 39;
            } catch (NoSuchFieldError unused39) {
            }
            try {
                $SwitchMap$net$pubnative$lite$sdk$utils$svgparser$utils$SVGParserImpl$SVGAttr[SVGAttr.startOffset.ordinal()] = 40;
            } catch (NoSuchFieldError unused40) {
            }
            try {
                $SwitchMap$net$pubnative$lite$sdk$utils$svgparser$utils$SVGParserImpl$SVGAttr[SVGAttr.patternUnits.ordinal()] = 41;
            } catch (NoSuchFieldError unused41) {
            }
            try {
                $SwitchMap$net$pubnative$lite$sdk$utils$svgparser$utils$SVGParserImpl$SVGAttr[SVGAttr.patternContentUnits.ordinal()] = 42;
            } catch (NoSuchFieldError unused42) {
            }
            try {
                $SwitchMap$net$pubnative$lite$sdk$utils$svgparser$utils$SVGParserImpl$SVGAttr[SVGAttr.patternTransform.ordinal()] = 43;
            } catch (NoSuchFieldError unused43) {
            }
            try {
                $SwitchMap$net$pubnative$lite$sdk$utils$svgparser$utils$SVGParserImpl$SVGAttr[SVGAttr.maskUnits.ordinal()] = 44;
            } catch (NoSuchFieldError unused44) {
            }
            try {
                $SwitchMap$net$pubnative$lite$sdk$utils$svgparser$utils$SVGParserImpl$SVGAttr[SVGAttr.maskContentUnits.ordinal()] = 45;
            } catch (NoSuchFieldError unused45) {
            }
            try {
                $SwitchMap$net$pubnative$lite$sdk$utils$svgparser$utils$SVGParserImpl$SVGAttr[SVGAttr.style.ordinal()] = 46;
            } catch (NoSuchFieldError unused46) {
            }
            try {
                $SwitchMap$net$pubnative$lite$sdk$utils$svgparser$utils$SVGParserImpl$SVGAttr[SVGAttr.CLASS.ordinal()] = 47;
            } catch (NoSuchFieldError unused47) {
            }
            try {
                $SwitchMap$net$pubnative$lite$sdk$utils$svgparser$utils$SVGParserImpl$SVGAttr[SVGAttr.viewBox.ordinal()] = 48;
            } catch (NoSuchFieldError unused48) {
            }
            try {
                $SwitchMap$net$pubnative$lite$sdk$utils$svgparser$utils$SVGParserImpl$SVGAttr[SVGAttr.type.ordinal()] = 49;
            } catch (NoSuchFieldError unused49) {
            }
            try {
                $SwitchMap$net$pubnative$lite$sdk$utils$svgparser$utils$SVGParserImpl$SVGAttr[SVGAttr.media.ordinal()] = 50;
            } catch (NoSuchFieldError unused50) {
            }
            int[] iArr2 = new int[SVGElem.values().length];
            $SwitchMap$net$pubnative$lite$sdk$utils$svgparser$utils$SVGParserImpl$SVGElem = iArr2;
            try {
                iArr2[SVGElem.svg.ordinal()] = 1;
            } catch (NoSuchFieldError unused51) {
            }
            try {
                $SwitchMap$net$pubnative$lite$sdk$utils$svgparser$utils$SVGParserImpl$SVGElem[SVGElem.g.ordinal()] = 2;
            } catch (NoSuchFieldError unused52) {
            }
            try {
                $SwitchMap$net$pubnative$lite$sdk$utils$svgparser$utils$SVGParserImpl$SVGElem[SVGElem.defs.ordinal()] = 3;
            } catch (NoSuchFieldError unused53) {
            }
            try {
                $SwitchMap$net$pubnative$lite$sdk$utils$svgparser$utils$SVGParserImpl$SVGElem[SVGElem.a.ordinal()] = 4;
            } catch (NoSuchFieldError unused54) {
            }
            try {
                $SwitchMap$net$pubnative$lite$sdk$utils$svgparser$utils$SVGParserImpl$SVGElem[SVGElem.use.ordinal()] = 5;
            } catch (NoSuchFieldError unused55) {
            }
            try {
                $SwitchMap$net$pubnative$lite$sdk$utils$svgparser$utils$SVGParserImpl$SVGElem[SVGElem.path.ordinal()] = 6;
            } catch (NoSuchFieldError unused56) {
            }
            try {
                $SwitchMap$net$pubnative$lite$sdk$utils$svgparser$utils$SVGParserImpl$SVGElem[SVGElem.rect.ordinal()] = 7;
            } catch (NoSuchFieldError unused57) {
            }
            try {
                $SwitchMap$net$pubnative$lite$sdk$utils$svgparser$utils$SVGParserImpl$SVGElem[SVGElem.circle.ordinal()] = 8;
            } catch (NoSuchFieldError unused58) {
            }
            try {
                $SwitchMap$net$pubnative$lite$sdk$utils$svgparser$utils$SVGParserImpl$SVGElem[SVGElem.ellipse.ordinal()] = 9;
            } catch (NoSuchFieldError unused59) {
            }
            try {
                $SwitchMap$net$pubnative$lite$sdk$utils$svgparser$utils$SVGParserImpl$SVGElem[SVGElem.line.ordinal()] = 10;
            } catch (NoSuchFieldError unused60) {
            }
            try {
                $SwitchMap$net$pubnative$lite$sdk$utils$svgparser$utils$SVGParserImpl$SVGElem[SVGElem.polyline.ordinal()] = 11;
            } catch (NoSuchFieldError unused61) {
            }
            try {
                $SwitchMap$net$pubnative$lite$sdk$utils$svgparser$utils$SVGParserImpl$SVGElem[SVGElem.polygon.ordinal()] = 12;
            } catch (NoSuchFieldError unused62) {
            }
            try {
                $SwitchMap$net$pubnative$lite$sdk$utils$svgparser$utils$SVGParserImpl$SVGElem[SVGElem.text.ordinal()] = 13;
            } catch (NoSuchFieldError unused63) {
            }
            try {
                $SwitchMap$net$pubnative$lite$sdk$utils$svgparser$utils$SVGParserImpl$SVGElem[SVGElem.tspan.ordinal()] = 14;
            } catch (NoSuchFieldError unused64) {
            }
            try {
                $SwitchMap$net$pubnative$lite$sdk$utils$svgparser$utils$SVGParserImpl$SVGElem[SVGElem.tref.ordinal()] = 15;
            } catch (NoSuchFieldError unused65) {
            }
            try {
                $SwitchMap$net$pubnative$lite$sdk$utils$svgparser$utils$SVGParserImpl$SVGElem[SVGElem.SWITCH.ordinal()] = 16;
            } catch (NoSuchFieldError unused66) {
            }
            try {
                $SwitchMap$net$pubnative$lite$sdk$utils$svgparser$utils$SVGParserImpl$SVGElem[SVGElem.symbol.ordinal()] = 17;
            } catch (NoSuchFieldError unused67) {
            }
            try {
                $SwitchMap$net$pubnative$lite$sdk$utils$svgparser$utils$SVGParserImpl$SVGElem[SVGElem.marker.ordinal()] = 18;
            } catch (NoSuchFieldError unused68) {
            }
            try {
                $SwitchMap$net$pubnative$lite$sdk$utils$svgparser$utils$SVGParserImpl$SVGElem[SVGElem.linearGradient.ordinal()] = 19;
            } catch (NoSuchFieldError unused69) {
            }
            try {
                $SwitchMap$net$pubnative$lite$sdk$utils$svgparser$utils$SVGParserImpl$SVGElem[SVGElem.radialGradient.ordinal()] = 20;
            } catch (NoSuchFieldError unused70) {
            }
            try {
                $SwitchMap$net$pubnative$lite$sdk$utils$svgparser$utils$SVGParserImpl$SVGElem[SVGElem.stop.ordinal()] = 21;
            } catch (NoSuchFieldError unused71) {
            }
            try {
                $SwitchMap$net$pubnative$lite$sdk$utils$svgparser$utils$SVGParserImpl$SVGElem[SVGElem.title.ordinal()] = 22;
            } catch (NoSuchFieldError unused72) {
            }
            try {
                $SwitchMap$net$pubnative$lite$sdk$utils$svgparser$utils$SVGParserImpl$SVGElem[SVGElem.desc.ordinal()] = 23;
            } catch (NoSuchFieldError unused73) {
            }
            try {
                $SwitchMap$net$pubnative$lite$sdk$utils$svgparser$utils$SVGParserImpl$SVGElem[SVGElem.clipPath.ordinal()] = 24;
            } catch (NoSuchFieldError unused74) {
            }
            try {
                $SwitchMap$net$pubnative$lite$sdk$utils$svgparser$utils$SVGParserImpl$SVGElem[SVGElem.textPath.ordinal()] = 25;
            } catch (NoSuchFieldError unused75) {
            }
            try {
                $SwitchMap$net$pubnative$lite$sdk$utils$svgparser$utils$SVGParserImpl$SVGElem[SVGElem.pattern.ordinal()] = 26;
            } catch (NoSuchFieldError unused76) {
            }
            try {
                $SwitchMap$net$pubnative$lite$sdk$utils$svgparser$utils$SVGParserImpl$SVGElem[SVGElem.image.ordinal()] = 27;
            } catch (NoSuchFieldError unused77) {
            }
            try {
                $SwitchMap$net$pubnative$lite$sdk$utils$svgparser$utils$SVGParserImpl$SVGElem[SVGElem.view.ordinal()] = 28;
            } catch (NoSuchFieldError unused78) {
            }
            try {
                $SwitchMap$net$pubnative$lite$sdk$utils$svgparser$utils$SVGParserImpl$SVGElem[SVGElem.mask.ordinal()] = 29;
            } catch (NoSuchFieldError unused79) {
            }
            try {
                $SwitchMap$net$pubnative$lite$sdk$utils$svgparser$utils$SVGParserImpl$SVGElem[SVGElem.style.ordinal()] = 30;
            } catch (NoSuchFieldError unused80) {
            }
            try {
                $SwitchMap$net$pubnative$lite$sdk$utils$svgparser$utils$SVGParserImpl$SVGElem[SVGElem.solidColor.ordinal()] = 31;
            } catch (NoSuchFieldError unused81) {
            }
        }
    }

    private void g(Attributes attributes) throws SVGParseException {
        debug("<g>", new Object[0]);
        if (this.currentElement == null) {
            throw new SVGParseException("Invalid document. Root element must be <svg>");
        }
        SVGBase.Group group = new SVGBase.Group();
        group.document = this.svgDocument;
        group.parent = this.currentElement;
        parseAttributesCore(group, attributes);
        parseAttributesStyle(group, attributes);
        parseAttributesTransform(group, attributes);
        parseAttributesConditional(group, attributes);
        this.currentElement.addChild(group);
        this.currentElement = group;
    }

    private void defs(Attributes attributes) throws SVGParseException {
        debug("<defs>", new Object[0]);
        if (this.currentElement == null) {
            throw new SVGParseException("Invalid document. Root element must be <svg>");
        }
        SVGBase.Defs defs = new SVGBase.Defs();
        defs.document = this.svgDocument;
        defs.parent = this.currentElement;
        parseAttributesCore(defs, attributes);
        parseAttributesStyle(defs, attributes);
        parseAttributesTransform(defs, attributes);
        this.currentElement.addChild(defs);
        this.currentElement = defs;
    }

    private void a(Attributes attributes) throws SVGParseException {
        debug("<a>", new Object[0]);
        if (this.currentElement == null) {
            throw new SVGParseException("Invalid document. Root element must be <svg>");
        }
        SVGBase.A a2 = new SVGBase.A();
        a2.document = this.svgDocument;
        a2.parent = this.currentElement;
        parseAttributesCore(a2, attributes);
        parseAttributesStyle(a2, attributes);
        parseAttributesTransform(a2, attributes);
        parseAttributesConditional(a2, attributes);
        parseAttributesA(a2, attributes);
        this.currentElement.addChild(a2);
        this.currentElement = a2;
    }

    private void parseAttributesA(SVGBase.A a2, Attributes attributes) {
        for (int i = 0; i < attributes.getLength(); i++) {
            String strTrim = attributes.getValue(i).trim();
            if (AnonymousClass1.$SwitchMap$net$pubnative$lite$sdk$utils$svgparser$utils$SVGParserImpl$SVGAttr[SVGAttr.fromString(attributes.getLocalName(i)).ordinal()] == 6 && ("".equals(attributes.getURI(i)) || XLINK_NAMESPACE.equals(attributes.getURI(i)))) {
                a2.href = strTrim;
            }
        }
    }

    private void use(Attributes attributes) throws SVGParseException {
        debug("<use>", new Object[0]);
        if (this.currentElement == null) {
            throw new SVGParseException("Invalid document. Root element must be <svg>");
        }
        SVGBase.Use use = new SVGBase.Use();
        use.document = this.svgDocument;
        use.parent = this.currentElement;
        parseAttributesCore(use, attributes);
        parseAttributesStyle(use, attributes);
        parseAttributesTransform(use, attributes);
        parseAttributesConditional(use, attributes);
        parseAttributesUse(use, attributes);
        this.currentElement.addChild(use);
        this.currentElement = use;
    }

    private void parseAttributesUse(SVGBase.Use use, Attributes attributes) throws SVGParseException {
        for (int i = 0; i < attributes.getLength(); i++) {
            String strTrim = attributes.getValue(i).trim();
            int i2 = AnonymousClass1.$SwitchMap$net$pubnative$lite$sdk$utils$svgparser$utils$SVGParserImpl$SVGAttr[SVGAttr.fromString(attributes.getLocalName(i)).ordinal()];
            if (i2 == 1) {
                use.x = parseLength(strTrim);
            } else if (i2 == 2) {
                use.y = parseLength(strTrim);
            } else if (i2 == 3) {
                use.width = parseLength(strTrim);
                if (use.width.isNegative()) {
                    throw new SVGParseException("Invalid <use> element. width cannot be negative");
                }
            } else if (i2 == 4) {
                use.height = parseLength(strTrim);
                if (use.height.isNegative()) {
                    throw new SVGParseException("Invalid <use> element. height cannot be negative");
                }
            } else if (i2 == 6 && ("".equals(attributes.getURI(i)) || XLINK_NAMESPACE.equals(attributes.getURI(i)))) {
                use.href = strTrim;
            }
        }
    }

    private void image(Attributes attributes) throws SVGParseException {
        debug("<image>", new Object[0]);
        if (this.currentElement == null) {
            throw new SVGParseException("Invalid document. Root element must be <svg>");
        }
        SVGBase.Image image = new SVGBase.Image();
        image.document = this.svgDocument;
        image.parent = this.currentElement;
        parseAttributesCore(image, attributes);
        parseAttributesStyle(image, attributes);
        parseAttributesTransform(image, attributes);
        parseAttributesConditional(image, attributes);
        parseAttributesImage(image, attributes);
        this.currentElement.addChild(image);
        this.currentElement = image;
    }

    private void parseAttributesImage(SVGBase.Image image, Attributes attributes) throws SVGParseException {
        for (int i = 0; i < attributes.getLength(); i++) {
            String strTrim = attributes.getValue(i).trim();
            int i2 = AnonymousClass1.$SwitchMap$net$pubnative$lite$sdk$utils$svgparser$utils$SVGParserImpl$SVGAttr[SVGAttr.fromString(attributes.getLocalName(i)).ordinal()];
            if (i2 == 1) {
                image.x = parseLength(strTrim);
            } else if (i2 == 2) {
                image.y = parseLength(strTrim);
            } else if (i2 == 3) {
                image.width = parseLength(strTrim);
                if (image.width.isNegative()) {
                    throw new SVGParseException("Invalid <use> element. width cannot be negative");
                }
            } else if (i2 == 4) {
                image.height = parseLength(strTrim);
                if (image.height.isNegative()) {
                    throw new SVGParseException("Invalid <use> element. height cannot be negative");
                }
            } else if (i2 != 6) {
                if (i2 == 7) {
                    parsePreserveAspectRatio(image, strTrim);
                }
            } else if ("".equals(attributes.getURI(i)) || XLINK_NAMESPACE.equals(attributes.getURI(i))) {
                image.href = strTrim;
            }
        }
    }

    private void path(Attributes attributes) throws SVGParseException {
        debug("<path>", new Object[0]);
        if (this.currentElement == null) {
            throw new SVGParseException("Invalid document. Root element must be <svg>");
        }
        SVGBase.Path path = new SVGBase.Path();
        path.document = this.svgDocument;
        path.parent = this.currentElement;
        parseAttributesCore(path, attributes);
        parseAttributesStyle(path, attributes);
        parseAttributesTransform(path, attributes);
        parseAttributesConditional(path, attributes);
        parseAttributesPath(path, attributes);
        this.currentElement.addChild(path);
    }

    private void parseAttributesPath(SVGBase.Path path, Attributes attributes) throws SVGParseException {
        for (int i = 0; i < attributes.getLength(); i++) {
            String strTrim = attributes.getValue(i).trim();
            int i2 = AnonymousClass1.$SwitchMap$net$pubnative$lite$sdk$utils$svgparser$utils$SVGParserImpl$SVGAttr[SVGAttr.fromString(attributes.getLocalName(i)).ordinal()];
            if (i2 == 8) {
                path.d = parsePath(strTrim);
            } else if (i2 != 9) {
                continue;
            } else {
                path.pathLength = Float.valueOf(parseFloat(strTrim));
                if (path.pathLength.floatValue() < 0.0f) {
                    throw new SVGParseException("Invalid <path> element. pathLength cannot be negative");
                }
            }
        }
    }

    private void rect(Attributes attributes) throws SVGParseException {
        debug("<rect>", new Object[0]);
        if (this.currentElement == null) {
            throw new SVGParseException("Invalid document. Root element must be <svg>");
        }
        SVGBase.Rect rect = new SVGBase.Rect();
        rect.document = this.svgDocument;
        rect.parent = this.currentElement;
        parseAttributesCore(rect, attributes);
        parseAttributesStyle(rect, attributes);
        parseAttributesTransform(rect, attributes);
        parseAttributesConditional(rect, attributes);
        parseAttributesRect(rect, attributes);
        this.currentElement.addChild(rect);
    }

    private void parseAttributesRect(SVGBase.Rect rect, Attributes attributes) throws SVGParseException {
        for (int i = 0; i < attributes.getLength(); i++) {
            String strTrim = attributes.getValue(i).trim();
            int i2 = AnonymousClass1.$SwitchMap$net$pubnative$lite$sdk$utils$svgparser$utils$SVGParserImpl$SVGAttr[SVGAttr.fromString(attributes.getLocalName(i)).ordinal()];
            if (i2 == 1) {
                rect.x = parseLength(strTrim);
            } else if (i2 == 2) {
                rect.y = parseLength(strTrim);
            } else if (i2 == 3) {
                rect.width = parseLength(strTrim);
                if (rect.width.isNegative()) {
                    throw new SVGParseException("Invalid <rect> element. width cannot be negative");
                }
            } else if (i2 == 4) {
                rect.height = parseLength(strTrim);
                if (rect.height.isNegative()) {
                    throw new SVGParseException("Invalid <rect> element. height cannot be negative");
                }
            } else if (i2 == 10) {
                rect.rx = parseLength(strTrim);
                if (rect.rx.isNegative()) {
                    throw new SVGParseException("Invalid <rect> element. rx cannot be negative");
                }
            } else if (i2 != 11) {
                continue;
            } else {
                rect.ry = parseLength(strTrim);
                if (rect.ry.isNegative()) {
                    throw new SVGParseException("Invalid <rect> element. ry cannot be negative");
                }
            }
        }
    }

    private void circle(Attributes attributes) throws SVGParseException {
        debug("<circle>", new Object[0]);
        if (this.currentElement == null) {
            throw new SVGParseException("Invalid document. Root element must be <svg>");
        }
        SVGBase.Circle circle = new SVGBase.Circle();
        circle.document = this.svgDocument;
        circle.parent = this.currentElement;
        parseAttributesCore(circle, attributes);
        parseAttributesStyle(circle, attributes);
        parseAttributesTransform(circle, attributes);
        parseAttributesConditional(circle, attributes);
        parseAttributesCircle(circle, attributes);
        this.currentElement.addChild(circle);
    }

    private void parseAttributesCircle(SVGBase.Circle circle, Attributes attributes) throws SVGParseException {
        for (int i = 0; i < attributes.getLength(); i++) {
            String strTrim = attributes.getValue(i).trim();
            switch (SVGAttr.fromString(attributes.getLocalName(i))) {
                case cx:
                    circle.cx = parseLength(strTrim);
                    break;
                case cy:
                    circle.cy = parseLength(strTrim);
                    break;
                case r:
                    circle.r = parseLength(strTrim);
                    if (circle.r.isNegative()) {
                        throw new SVGParseException("Invalid <circle> element. r cannot be negative");
                    }
                    break;
                    break;
            }
        }
    }

    private void ellipse(Attributes attributes) throws SVGParseException {
        debug("<ellipse>", new Object[0]);
        if (this.currentElement == null) {
            throw new SVGParseException("Invalid document. Root element must be <svg>");
        }
        SVGBase.Ellipse ellipse = new SVGBase.Ellipse();
        ellipse.document = this.svgDocument;
        ellipse.parent = this.currentElement;
        parseAttributesCore(ellipse, attributes);
        parseAttributesStyle(ellipse, attributes);
        parseAttributesTransform(ellipse, attributes);
        parseAttributesConditional(ellipse, attributes);
        parseAttributesEllipse(ellipse, attributes);
        this.currentElement.addChild(ellipse);
    }

    private void parseAttributesEllipse(SVGBase.Ellipse ellipse, Attributes attributes) throws SVGParseException {
        for (int i = 0; i < attributes.getLength(); i++) {
            String strTrim = attributes.getValue(i).trim();
            switch (SVGAttr.fromString(attributes.getLocalName(i))) {
                case rx:
                    ellipse.rx = parseLength(strTrim);
                    if (ellipse.rx.isNegative()) {
                        throw new SVGParseException("Invalid <ellipse> element. rx cannot be negative");
                    }
                    break;
                    break;
                case ry:
                    ellipse.ry = parseLength(strTrim);
                    if (ellipse.ry.isNegative()) {
                        throw new SVGParseException("Invalid <ellipse> element. ry cannot be negative");
                    }
                    break;
                    break;
                case cx:
                    ellipse.cx = parseLength(strTrim);
                    break;
                case cy:
                    ellipse.cy = parseLength(strTrim);
                    break;
            }
        }
    }

    private void line(Attributes attributes) throws SVGParseException {
        debug("<line>", new Object[0]);
        if (this.currentElement == null) {
            throw new SVGParseException("Invalid document. Root element must be <svg>");
        }
        SVGBase.Line line = new SVGBase.Line();
        line.document = this.svgDocument;
        line.parent = this.currentElement;
        parseAttributesCore(line, attributes);
        parseAttributesStyle(line, attributes);
        parseAttributesTransform(line, attributes);
        parseAttributesConditional(line, attributes);
        parseAttributesLine(line, attributes);
        this.currentElement.addChild(line);
    }

    private void parseAttributesLine(SVGBase.Line line, Attributes attributes) throws SVGParseException {
        for (int i = 0; i < attributes.getLength(); i++) {
            String strTrim = attributes.getValue(i).trim();
            switch (SVGAttr.fromString(attributes.getLocalName(i))) {
                case x1:
                    line.x1 = parseLength(strTrim);
                    break;
                case y1:
                    line.y1 = parseLength(strTrim);
                    break;
                case x2:
                    line.x2 = parseLength(strTrim);
                    break;
                case y2:
                    line.y2 = parseLength(strTrim);
                    break;
            }
        }
    }

    private void polyline(Attributes attributes) throws SVGParseException {
        debug("<polyline>", new Object[0]);
        if (this.currentElement == null) {
            throw new SVGParseException("Invalid document. Root element must be <svg>");
        }
        SVGBase.PolyLine polyLine = new SVGBase.PolyLine();
        polyLine.document = this.svgDocument;
        polyLine.parent = this.currentElement;
        parseAttributesCore(polyLine, attributes);
        parseAttributesStyle(polyLine, attributes);
        parseAttributesTransform(polyLine, attributes);
        parseAttributesConditional(polyLine, attributes);
        parseAttributesPolyLine(polyLine, attributes, "polyline");
        this.currentElement.addChild(polyLine);
    }

    private void parseAttributesPolyLine(SVGBase.PolyLine polyLine, Attributes attributes, String str) throws SVGParseException {
        for (int i = 0; i < attributes.getLength(); i++) {
            if (SVGAttr.fromString(attributes.getLocalName(i)) == SVGAttr.points) {
                TextScanner textScanner = new TextScanner(attributes.getValue(i));
                ArrayList arrayList = new ArrayList();
                textScanner.skipWhitespace();
                while (!textScanner.empty()) {
                    float fNextFloat = textScanner.nextFloat();
                    if (Float.isNaN(fNextFloat)) {
                        throw new SVGParseException("Invalid <" + str + "> points attribute. Non-coordinate content found in list.");
                    }
                    textScanner.skipCommaWhitespace();
                    float fNextFloat2 = textScanner.nextFloat();
                    if (Float.isNaN(fNextFloat2)) {
                        throw new SVGParseException("Invalid <" + str + "> points attribute. There should be an even number of coordinates.");
                    }
                    textScanner.skipCommaWhitespace();
                    arrayList.add(Float.valueOf(fNextFloat));
                    arrayList.add(Float.valueOf(fNextFloat2));
                }
                polyLine.points = new float[arrayList.size()];
                Iterator it = arrayList.iterator();
                int i2 = 0;
                while (it.hasNext()) {
                    polyLine.points[i2] = ((Float) it.next()).floatValue();
                    i2++;
                }
            }
        }
    }

    private void polygon(Attributes attributes) throws SVGParseException {
        debug("<polygon>", new Object[0]);
        if (this.currentElement == null) {
            throw new SVGParseException("Invalid document. Root element must be <svg>");
        }
        SVGBase.Polygon polygon = new SVGBase.Polygon();
        polygon.document = this.svgDocument;
        polygon.parent = this.currentElement;
        parseAttributesCore(polygon, attributes);
        parseAttributesStyle(polygon, attributes);
        parseAttributesTransform(polygon, attributes);
        parseAttributesConditional(polygon, attributes);
        parseAttributesPolyLine(polygon, attributes, "polygon");
        this.currentElement.addChild(polygon);
    }

    private void text(Attributes attributes) throws SVGParseException {
        debug("<text>", new Object[0]);
        if (this.currentElement == null) {
            throw new SVGParseException("Invalid document. Root element must be <svg>");
        }
        SVGBase.Text text = new SVGBase.Text();
        text.document = this.svgDocument;
        text.parent = this.currentElement;
        parseAttributesCore(text, attributes);
        parseAttributesStyle(text, attributes);
        parseAttributesTransform(text, attributes);
        parseAttributesConditional(text, attributes);
        parseAttributesTextPosition(text, attributes);
        this.currentElement.addChild(text);
        this.currentElement = text;
    }

    private void parseAttributesTextPosition(SVGBase.TextPositionedContainer textPositionedContainer, Attributes attributes) throws SVGParseException {
        for (int i = 0; i < attributes.getLength(); i++) {
            String strTrim = attributes.getValue(i).trim();
            int i2 = AnonymousClass1.$SwitchMap$net$pubnative$lite$sdk$utils$svgparser$utils$SVGParserImpl$SVGAttr[SVGAttr.fromString(attributes.getLocalName(i)).ordinal()];
            if (i2 == 1) {
                textPositionedContainer.x = parseLengthList(strTrim);
            } else if (i2 == 2) {
                textPositionedContainer.y = parseLengthList(strTrim);
            } else if (i2 == 19) {
                textPositionedContainer.dx = parseLengthList(strTrim);
            } else if (i2 == 20) {
                textPositionedContainer.dy = parseLengthList(strTrim);
            }
        }
    }

    private void tspan(Attributes attributes) throws SVGParseException {
        debug("<tspan>", new Object[0]);
        SVGBase.SvgContainer svgContainer = this.currentElement;
        if (svgContainer == null) {
            throw new SVGParseException("Invalid document. Root element must be <svg>");
        }
        if (!(svgContainer instanceof SVGBase.TextContainer)) {
            throw new SVGParseException("Invalid document. <tspan> elements are only valid inside <text> or other <tspan> elements.");
        }
        SVGBase.TSpan tSpan = new SVGBase.TSpan();
        tSpan.document = this.svgDocument;
        tSpan.parent = this.currentElement;
        parseAttributesCore(tSpan, attributes);
        parseAttributesStyle(tSpan, attributes);
        parseAttributesConditional(tSpan, attributes);
        parseAttributesTextPosition(tSpan, attributes);
        this.currentElement.addChild(tSpan);
        this.currentElement = tSpan;
        if (tSpan.parent instanceof SVGBase.TextRoot) {
            tSpan.setTextRoot((SVGBase.TextRoot) tSpan.parent);
        } else {
            tSpan.setTextRoot(((SVGBase.TextChild) tSpan.parent).getTextRoot());
        }
    }

    private void tref(Attributes attributes) throws SVGParseException {
        debug("<tref>", new Object[0]);
        SVGBase.SvgContainer svgContainer = this.currentElement;
        if (svgContainer == null) {
            throw new SVGParseException("Invalid document. Root element must be <svg>");
        }
        if (!(svgContainer instanceof SVGBase.TextContainer)) {
            throw new SVGParseException("Invalid document. <tref> elements are only valid inside <text> or <tspan> elements.");
        }
        SVGBase.TRef tRef = new SVGBase.TRef();
        tRef.document = this.svgDocument;
        tRef.parent = this.currentElement;
        parseAttributesCore(tRef, attributes);
        parseAttributesStyle(tRef, attributes);
        parseAttributesConditional(tRef, attributes);
        parseAttributesTRef(tRef, attributes);
        this.currentElement.addChild(tRef);
        if (tRef.parent instanceof SVGBase.TextRoot) {
            tRef.setTextRoot((SVGBase.TextRoot) tRef.parent);
        } else {
            tRef.setTextRoot(((SVGBase.TextChild) tRef.parent).getTextRoot());
        }
    }

    private void parseAttributesTRef(SVGBase.TRef tRef, Attributes attributes) {
        for (int i = 0; i < attributes.getLength(); i++) {
            String strTrim = attributes.getValue(i).trim();
            if (AnonymousClass1.$SwitchMap$net$pubnative$lite$sdk$utils$svgparser$utils$SVGParserImpl$SVGAttr[SVGAttr.fromString(attributes.getLocalName(i)).ordinal()] == 6 && ("".equals(attributes.getURI(i)) || XLINK_NAMESPACE.equals(attributes.getURI(i)))) {
                tRef.href = strTrim;
            }
        }
    }

    private void zwitch(Attributes attributes) throws SVGParseException {
        debug("<switch>", new Object[0]);
        if (this.currentElement == null) {
            throw new SVGParseException("Invalid document. Root element must be <svg>");
        }
        SVGBase.Switch r0 = new SVGBase.Switch();
        r0.document = this.svgDocument;
        r0.parent = this.currentElement;
        parseAttributesCore(r0, attributes);
        parseAttributesStyle(r0, attributes);
        parseAttributesTransform(r0, attributes);
        parseAttributesConditional(r0, attributes);
        this.currentElement.addChild(r0);
        this.currentElement = r0;
    }

    private void parseAttributesConditional(SVGBase.SvgConditional svgConditional, Attributes attributes) {
        for (int i = 0; i < attributes.getLength(); i++) {
            String strTrim = attributes.getValue(i).trim();
            switch (SVGAttr.fromString(attributes.getLocalName(i))) {
                case requiredFeatures:
                    svgConditional.setRequiredFeatures(parseRequiredFeatures(strTrim));
                    break;
                case requiredExtensions:
                    svgConditional.setRequiredExtensions(strTrim);
                    break;
                case systemLanguage:
                    svgConditional.setSystemLanguage(parseSystemLanguage(strTrim));
                    break;
                case requiredFormats:
                    svgConditional.setRequiredFormats(parseRequiredFormats(strTrim));
                    break;
                case requiredFonts:
                    List<String> fontFamily = parseFontFamily(strTrim);
                    svgConditional.setRequiredFonts(fontFamily != null ? new HashSet(fontFamily) : new HashSet(0));
                    break;
            }
        }
    }

    private void symbol(Attributes attributes) throws SVGParseException {
        debug("<symbol>", new Object[0]);
        if (this.currentElement == null) {
            throw new SVGParseException("Invalid document. Root element must be <svg>");
        }
        SVGBase.Symbol symbol = new SVGBase.Symbol();
        symbol.document = this.svgDocument;
        symbol.parent = this.currentElement;
        parseAttributesCore(symbol, attributes);
        parseAttributesStyle(symbol, attributes);
        parseAttributesConditional(symbol, attributes);
        parseAttributesViewBox(symbol, attributes);
        this.currentElement.addChild(symbol);
        this.currentElement = symbol;
    }

    private void marker(Attributes attributes) throws SVGParseException {
        debug("<marker>", new Object[0]);
        if (this.currentElement == null) {
            throw new SVGParseException("Invalid document. Root element must be <svg>");
        }
        SVGBase.Marker marker = new SVGBase.Marker();
        marker.document = this.svgDocument;
        marker.parent = this.currentElement;
        parseAttributesCore(marker, attributes);
        parseAttributesStyle(marker, attributes);
        parseAttributesConditional(marker, attributes);
        parseAttributesViewBox(marker, attributes);
        parseAttributesMarker(marker, attributes);
        this.currentElement.addChild(marker);
        this.currentElement = marker;
    }

    private void parseAttributesMarker(SVGBase.Marker marker, Attributes attributes) throws SVGParseException {
        for (int i = 0; i < attributes.getLength(); i++) {
            String strTrim = attributes.getValue(i).trim();
            switch (SVGAttr.fromString(attributes.getLocalName(i))) {
                case refX:
                    marker.refX = parseLength(strTrim);
                    break;
                case refY:
                    marker.refY = parseLength(strTrim);
                    break;
                case markerWidth:
                    marker.markerWidth = parseLength(strTrim);
                    if (marker.markerWidth.isNegative()) {
                        throw new SVGParseException("Invalid <marker> element. markerWidth cannot be negative");
                    }
                    break;
                    break;
                case markerHeight:
                    marker.markerHeight = parseLength(strTrim);
                    if (marker.markerHeight.isNegative()) {
                        throw new SVGParseException("Invalid <marker> element. markerHeight cannot be negative");
                    }
                    break;
                    break;
                case markerUnits:
                    if ("strokeWidth".equals(strTrim)) {
                        marker.markerUnitsAreUser = false;
                    } else if ("userSpaceOnUse".equals(strTrim)) {
                        marker.markerUnitsAreUser = true;
                    } else {
                        throw new SVGParseException("Invalid value for attribute markerUnits");
                    }
                    break;
                case orient:
                    if ("auto".equals(strTrim)) {
                        marker.orient = Float.valueOf(Float.NaN);
                    } else {
                        marker.orient = Float.valueOf(parseFloat(strTrim));
                    }
                    break;
            }
        }
    }

    private void linearGradient(Attributes attributes) throws SVGParseException {
        debug("<linearGradient>", new Object[0]);
        if (this.currentElement == null) {
            throw new SVGParseException("Invalid document. Root element must be <svg>");
        }
        SVGBase.SvgLinearGradient svgLinearGradient = new SVGBase.SvgLinearGradient();
        svgLinearGradient.document = this.svgDocument;
        svgLinearGradient.parent = this.currentElement;
        parseAttributesCore(svgLinearGradient, attributes);
        parseAttributesStyle(svgLinearGradient, attributes);
        parseAttributesGradient(svgLinearGradient, attributes);
        parseAttributesLinearGradient(svgLinearGradient, attributes);
        this.currentElement.addChild(svgLinearGradient);
        this.currentElement = svgLinearGradient;
    }

    private void parseAttributesGradient(SVGBase.GradientElement gradientElement, Attributes attributes) throws SVGParseException {
        for (int i = 0; i < attributes.getLength(); i++) {
            String strTrim = attributes.getValue(i).trim();
            int i2 = AnonymousClass1.$SwitchMap$net$pubnative$lite$sdk$utils$svgparser$utils$SVGParserImpl$SVGAttr[SVGAttr.fromString(attributes.getLocalName(i)).ordinal()];
            if (i2 != 6) {
                switch (i2) {
                    case 32:
                        if ("objectBoundingBox".equals(strTrim)) {
                            gradientElement.gradientUnitsAreUser = false;
                        } else if ("userSpaceOnUse".equals(strTrim)) {
                            gradientElement.gradientUnitsAreUser = true;
                        } else {
                            throw new SVGParseException("Invalid value for attribute gradientUnits");
                        }
                        break;
                    case 33:
                        gradientElement.gradientTransform = parseTransformList(strTrim);
                        break;
                    case 34:
                        try {
                            gradientElement.spreadMethod = SVGBase.GradientSpread.valueOf(strTrim);
                        } catch (IllegalArgumentException unused) {
                            throw new SVGParseException("Invalid spreadMethod attribute. \"" + strTrim + "\" is not a valid value.");
                        }
                        break;
                }
            } else if ("".equals(attributes.getURI(i)) || XLINK_NAMESPACE.equals(attributes.getURI(i))) {
                gradientElement.href = strTrim;
            }
        }
    }

    private void parseAttributesLinearGradient(SVGBase.SvgLinearGradient svgLinearGradient, Attributes attributes) throws SVGParseException {
        for (int i = 0; i < attributes.getLength(); i++) {
            String strTrim = attributes.getValue(i).trim();
            switch (SVGAttr.fromString(attributes.getLocalName(i))) {
                case x1:
                    svgLinearGradient.x1 = parseLength(strTrim);
                    break;
                case y1:
                    svgLinearGradient.y1 = parseLength(strTrim);
                    break;
                case x2:
                    svgLinearGradient.x2 = parseLength(strTrim);
                    break;
                case y2:
                    svgLinearGradient.y2 = parseLength(strTrim);
                    break;
            }
        }
    }

    private void radialGradient(Attributes attributes) throws SVGParseException {
        debug("<radialGradient>", new Object[0]);
        if (this.currentElement == null) {
            throw new SVGParseException("Invalid document. Root element must be <svg>");
        }
        SVGBase.SvgRadialGradient svgRadialGradient = new SVGBase.SvgRadialGradient();
        svgRadialGradient.document = this.svgDocument;
        svgRadialGradient.parent = this.currentElement;
        parseAttributesCore(svgRadialGradient, attributes);
        parseAttributesStyle(svgRadialGradient, attributes);
        parseAttributesGradient(svgRadialGradient, attributes);
        parseAttributesRadialGradient(svgRadialGradient, attributes);
        this.currentElement.addChild(svgRadialGradient);
        this.currentElement = svgRadialGradient;
    }

    private void parseAttributesRadialGradient(SVGBase.SvgRadialGradient svgRadialGradient, Attributes attributes) throws SVGParseException {
        for (int i = 0; i < attributes.getLength(); i++) {
            String strTrim = attributes.getValue(i).trim();
            int i2 = AnonymousClass1.$SwitchMap$net$pubnative$lite$sdk$utils$svgparser$utils$SVGParserImpl$SVGAttr[SVGAttr.fromString(attributes.getLocalName(i)).ordinal()];
            switch (i2) {
                case 12:
                    svgRadialGradient.cx = parseLength(strTrim);
                    break;
                case 13:
                    svgRadialGradient.cy = parseLength(strTrim);
                    break;
                case 14:
                    svgRadialGradient.r = parseLength(strTrim);
                    if (svgRadialGradient.r.isNegative()) {
                        throw new SVGParseException("Invalid <radialGradient> element. r cannot be negative");
                    }
                    break;
                    break;
                default:
                    switch (i2) {
                        case 35:
                            svgRadialGradient.fx = parseLength(strTrim);
                            break;
                        case 36:
                            svgRadialGradient.fy = parseLength(strTrim);
                            break;
                        case 37:
                            svgRadialGradient.fr = parseLength(strTrim);
                            if (svgRadialGradient.fr.isNegative()) {
                                throw new SVGParseException("Invalid <radialGradient> element. fr cannot be negative");
                            }
                            break;
                            break;
                    }
                    break;
            }
        }
    }

    private void stop(Attributes attributes) throws SVGParseException {
        debug("<stop>", new Object[0]);
        SVGBase.SvgContainer svgContainer = this.currentElement;
        if (svgContainer == null) {
            throw new SVGParseException("Invalid document. Root element must be <svg>");
        }
        if (!(svgContainer instanceof SVGBase.GradientElement)) {
            throw new SVGParseException("Invalid document. <stop> elements are only valid inside <linearGradient> or <radialGradient> elements.");
        }
        SVGBase.Stop stop = new SVGBase.Stop();
        stop.document = this.svgDocument;
        stop.parent = this.currentElement;
        parseAttributesCore(stop, attributes);
        parseAttributesStyle(stop, attributes);
        parseAttributesStop(stop, attributes);
        this.currentElement.addChild(stop);
        this.currentElement = stop;
    }

    private void parseAttributesStop(SVGBase.Stop stop, Attributes attributes) throws SVGParseException {
        for (int i = 0; i < attributes.getLength(); i++) {
            String strTrim = attributes.getValue(i).trim();
            if (AnonymousClass1.$SwitchMap$net$pubnative$lite$sdk$utils$svgparser$utils$SVGParserImpl$SVGAttr[SVGAttr.fromString(attributes.getLocalName(i)).ordinal()] == 38) {
                stop.offset = parseGradientOffset(strTrim);
            }
        }
    }

    private Float parseGradientOffset(String str) throws SVGParseException {
        if (str.length() == 0) {
            throw new SVGParseException("Invalid offset value in <stop> (empty string)");
        }
        int length = str.length();
        boolean z = true;
        if (str.charAt(str.length() - 1) == '%') {
            length--;
        } else {
            z = false;
        }
        try {
            float f = parseFloat(str, 0, length);
            float f2 = 100.0f;
            if (z) {
                f /= 100.0f;
            }
            if (f < 0.0f) {
                f2 = 0.0f;
            } else if (f <= 100.0f) {
                f2 = f;
            }
            return Float.valueOf(f2);
        } catch (NumberFormatException e) {
            throw new SVGParseException("Invalid offset value in <stop>: " + str, e);
        }
    }

    private void solidColor(Attributes attributes) throws SVGParseException {
        debug("<solidColor>", new Object[0]);
        if (this.currentElement == null) {
            throw new SVGParseException("Invalid document. Root element must be <svg>");
        }
        SVGBase.SolidColor solidColor = new SVGBase.SolidColor();
        solidColor.document = this.svgDocument;
        solidColor.parent = this.currentElement;
        parseAttributesCore(solidColor, attributes);
        parseAttributesStyle(solidColor, attributes);
        this.currentElement.addChild(solidColor);
        this.currentElement = solidColor;
    }

    private void clipPath(Attributes attributes) throws SVGParseException {
        debug("<clipPath>", new Object[0]);
        if (this.currentElement == null) {
            throw new SVGParseException("Invalid document. Root element must be <svg>");
        }
        SVGBase.ClipPath clipPath = new SVGBase.ClipPath();
        clipPath.document = this.svgDocument;
        clipPath.parent = this.currentElement;
        parseAttributesCore(clipPath, attributes);
        parseAttributesStyle(clipPath, attributes);
        parseAttributesTransform(clipPath, attributes);
        parseAttributesConditional(clipPath, attributes);
        parseAttributesClipPath(clipPath, attributes);
        this.currentElement.addChild(clipPath);
        this.currentElement = clipPath;
    }

    private void parseAttributesClipPath(SVGBase.ClipPath clipPath, Attributes attributes) throws SVGParseException {
        for (int i = 0; i < attributes.getLength(); i++) {
            String strTrim = attributes.getValue(i).trim();
            if (AnonymousClass1.$SwitchMap$net$pubnative$lite$sdk$utils$svgparser$utils$SVGParserImpl$SVGAttr[SVGAttr.fromString(attributes.getLocalName(i)).ordinal()] == 39) {
                if ("objectBoundingBox".equals(strTrim)) {
                    clipPath.clipPathUnitsAreUser = false;
                } else if ("userSpaceOnUse".equals(strTrim)) {
                    clipPath.clipPathUnitsAreUser = true;
                } else {
                    throw new SVGParseException("Invalid value for attribute clipPathUnits");
                }
            }
        }
    }

    private void textPath(Attributes attributes) throws SVGParseException {
        debug("<textPath>", new Object[0]);
        if (this.currentElement == null) {
            throw new SVGParseException("Invalid document. Root element must be <svg>");
        }
        SVGBase.TextPath textPath = new SVGBase.TextPath();
        textPath.document = this.svgDocument;
        textPath.parent = this.currentElement;
        parseAttributesCore(textPath, attributes);
        parseAttributesStyle(textPath, attributes);
        parseAttributesConditional(textPath, attributes);
        parseAttributesTextPath(textPath, attributes);
        this.currentElement.addChild(textPath);
        this.currentElement = textPath;
        if (textPath.parent instanceof SVGBase.TextRoot) {
            textPath.setTextRoot((SVGBase.TextRoot) textPath.parent);
        } else {
            textPath.setTextRoot(((SVGBase.TextChild) textPath.parent).getTextRoot());
        }
    }

    private void parseAttributesTextPath(SVGBase.TextPath textPath, Attributes attributes) throws SVGParseException {
        for (int i = 0; i < attributes.getLength(); i++) {
            String strTrim = attributes.getValue(i).trim();
            int i2 = AnonymousClass1.$SwitchMap$net$pubnative$lite$sdk$utils$svgparser$utils$SVGParserImpl$SVGAttr[SVGAttr.fromString(attributes.getLocalName(i)).ordinal()];
            if (i2 != 6) {
                if (i2 == 40) {
                    textPath.startOffset = parseLength(strTrim);
                }
            } else if ("".equals(attributes.getURI(i)) || XLINK_NAMESPACE.equals(attributes.getURI(i))) {
                textPath.href = strTrim;
            }
        }
    }

    private void pattern(Attributes attributes) throws SVGParseException {
        debug("<pattern>", new Object[0]);
        if (this.currentElement == null) {
            throw new SVGParseException("Invalid document. Root element must be <svg>");
        }
        SVGBase.Pattern pattern = new SVGBase.Pattern();
        pattern.document = this.svgDocument;
        pattern.parent = this.currentElement;
        parseAttributesCore(pattern, attributes);
        parseAttributesStyle(pattern, attributes);
        parseAttributesConditional(pattern, attributes);
        parseAttributesViewBox(pattern, attributes);
        parseAttributesPattern(pattern, attributes);
        this.currentElement.addChild(pattern);
        this.currentElement = pattern;
    }

    private void parseAttributesPattern(SVGBase.Pattern pattern, Attributes attributes) throws SVGParseException {
        for (int i = 0; i < attributes.getLength(); i++) {
            String strTrim = attributes.getValue(i).trim();
            int i2 = AnonymousClass1.$SwitchMap$net$pubnative$lite$sdk$utils$svgparser$utils$SVGParserImpl$SVGAttr[SVGAttr.fromString(attributes.getLocalName(i)).ordinal()];
            if (i2 == 1) {
                pattern.x = parseLength(strTrim);
            } else if (i2 == 2) {
                pattern.y = parseLength(strTrim);
            } else if (i2 == 3) {
                pattern.width = parseLength(strTrim);
                if (pattern.width.isNegative()) {
                    throw new SVGParseException("Invalid <pattern> element. width cannot be negative");
                }
            } else if (i2 == 4) {
                pattern.height = parseLength(strTrim);
                if (pattern.height.isNegative()) {
                    throw new SVGParseException("Invalid <pattern> element. height cannot be negative");
                }
            } else if (i2 != 6) {
                switch (i2) {
                    case 41:
                        if ("objectBoundingBox".equals(strTrim)) {
                            pattern.patternUnitsAreUser = false;
                        } else if ("userSpaceOnUse".equals(strTrim)) {
                            pattern.patternUnitsAreUser = true;
                        } else {
                            throw new SVGParseException("Invalid value for attribute patternUnits");
                        }
                        break;
                    case 42:
                        if ("objectBoundingBox".equals(strTrim)) {
                            pattern.patternContentUnitsAreUser = false;
                        } else if ("userSpaceOnUse".equals(strTrim)) {
                            pattern.patternContentUnitsAreUser = true;
                        } else {
                            throw new SVGParseException("Invalid value for attribute patternContentUnits");
                        }
                        break;
                    case 43:
                        pattern.patternTransform = parseTransformList(strTrim);
                        break;
                }
            } else if ("".equals(attributes.getURI(i)) || XLINK_NAMESPACE.equals(attributes.getURI(i))) {
                pattern.href = strTrim;
            }
        }
    }

    private void view(Attributes attributes) throws SVGParseException {
        debug("<view>", new Object[0]);
        if (this.currentElement == null) {
            throw new SVGParseException("Invalid document. Root element must be <svg>");
        }
        SVGBase.View view = new SVGBase.View();
        view.document = this.svgDocument;
        view.parent = this.currentElement;
        parseAttributesCore(view, attributes);
        parseAttributesConditional(view, attributes);
        parseAttributesViewBox(view, attributes);
        this.currentElement.addChild(view);
        this.currentElement = view;
    }

    private void mask(Attributes attributes) throws SVGParseException {
        debug("<mask>", new Object[0]);
        if (this.currentElement == null) {
            throw new SVGParseException("Invalid document. Root element must be <svg>");
        }
        SVGBase.Mask mask = new SVGBase.Mask();
        mask.document = this.svgDocument;
        mask.parent = this.currentElement;
        parseAttributesCore(mask, attributes);
        parseAttributesStyle(mask, attributes);
        parseAttributesConditional(mask, attributes);
        parseAttributesMask(mask, attributes);
        this.currentElement.addChild(mask);
        this.currentElement = mask;
    }

    private void parseAttributesMask(SVGBase.Mask mask, Attributes attributes) throws SVGParseException {
        for (int i = 0; i < attributes.getLength(); i++) {
            String strTrim = attributes.getValue(i).trim();
            int i2 = AnonymousClass1.$SwitchMap$net$pubnative$lite$sdk$utils$svgparser$utils$SVGParserImpl$SVGAttr[SVGAttr.fromString(attributes.getLocalName(i)).ordinal()];
            if (i2 == 1) {
                mask.x = parseLength(strTrim);
            } else if (i2 == 2) {
                mask.y = parseLength(strTrim);
            } else if (i2 == 3) {
                mask.width = parseLength(strTrim);
                if (mask.width.isNegative()) {
                    throw new SVGParseException("Invalid <mask> element. width cannot be negative");
                }
            } else if (i2 == 4) {
                mask.height = parseLength(strTrim);
                if (mask.height.isNegative()) {
                    throw new SVGParseException("Invalid <mask> element. height cannot be negative");
                }
            } else if (i2 != 44) {
                if (i2 != 45) {
                    continue;
                } else if ("objectBoundingBox".equals(strTrim)) {
                    mask.maskContentUnitsAreUser = false;
                } else if ("userSpaceOnUse".equals(strTrim)) {
                    mask.maskContentUnitsAreUser = true;
                } else {
                    throw new SVGParseException("Invalid value for attribute maskContentUnits");
                }
            } else if ("objectBoundingBox".equals(strTrim)) {
                mask.maskUnitsAreUser = false;
            } else if ("userSpaceOnUse".equals(strTrim)) {
                mask.maskUnitsAreUser = true;
            } else {
                throw new SVGParseException("Invalid value for attribute maskUnits");
            }
        }
    }

    private void parseAttributesCore(SVGBase.SvgElementBase svgElementBase, Attributes attributes) throws SVGParseException {
        for (int i = 0; i < attributes.getLength(); i++) {
            String qName = attributes.getQName(i);
            if (qName.equals("id") || qName.equals("xml:id")) {
                svgElementBase.id = attributes.getValue(i).trim();
                return;
            }
            if (qName.equals("xml:space")) {
                String strTrim = attributes.getValue(i).trim();
                if ("default".equals(strTrim)) {
                    svgElementBase.spacePreserve = Boolean.FALSE;
                    return;
                } else {
                    if ("preserve".equals(strTrim)) {
                        svgElementBase.spacePreserve = Boolean.TRUE;
                        return;
                    }
                    throw new SVGParseException("Invalid value for \"xml:space\" attribute: " + strTrim);
                }
            }
        }
    }

    private void parseAttributesStyle(SVGBase.SvgElementBase svgElementBase, Attributes attributes) {
        for (int i = 0; i < attributes.getLength(); i++) {
            String strTrim = attributes.getValue(i).trim();
            if (strTrim.length() != 0) {
                int i2 = AnonymousClass1.$SwitchMap$net$pubnative$lite$sdk$utils$svgparser$utils$SVGParserImpl$SVGAttr[SVGAttr.fromString(attributes.getLocalName(i)).ordinal()];
                if (i2 == 46) {
                    parseStyle(svgElementBase, strTrim);
                } else if (i2 == 47) {
                    svgElementBase.classNames = CSSParser.parseClassAttribute(strTrim);
                } else {
                    if (svgElementBase.baseStyle == null) {
                        svgElementBase.baseStyle = new Style();
                    }
                    Style.processStyleProperty(svgElementBase.baseStyle, attributes.getLocalName(i), attributes.getValue(i).trim(), true);
                }
            }
        }
    }

    private static void parseStyle(SVGBase.SvgElementBase svgElementBase, String str) {
        CSSTextScanner cSSTextScanner = new CSSTextScanner(PATTERN_BLOCK_COMMENTS.matcher(str).replaceAll(""));
        while (!cSSTextScanner.empty()) {
            cSSTextScanner.skipWhitespace();
            String strNextIdentifier = cSSTextScanner.nextIdentifier();
            cSSTextScanner.skipWhitespace();
            if (!cSSTextScanner.consume(';')) {
                if (!cSSTextScanner.consume(AbstractJsonLexerKt.COLON)) {
                    return;
                }
                cSSTextScanner.skipWhitespace();
                String strNextPropertyValue = cSSTextScanner.nextPropertyValue();
                if (strNextPropertyValue != null) {
                    cSSTextScanner.skipWhitespace();
                    if (cSSTextScanner.empty() || cSSTextScanner.consume(';')) {
                        if (svgElementBase.style == null) {
                            svgElementBase.style = new Style();
                        }
                        Style.processStyleProperty(svgElementBase.style, strNextIdentifier, strNextPropertyValue, false);
                        cSSTextScanner.skipWhitespace();
                    }
                }
            }
        }
    }

    private void parseAttributesViewBox(SVGBase.SvgViewBoxContainer svgViewBoxContainer, Attributes attributes) throws SVGParseException {
        for (int i = 0; i < attributes.getLength(); i++) {
            String strTrim = attributes.getValue(i).trim();
            int i2 = AnonymousClass1.$SwitchMap$net$pubnative$lite$sdk$utils$svgparser$utils$SVGParserImpl$SVGAttr[SVGAttr.fromString(attributes.getLocalName(i)).ordinal()];
            if (i2 == 7) {
                parsePreserveAspectRatio(svgViewBoxContainer, strTrim);
            } else if (i2 == 48) {
                svgViewBoxContainer.viewBox = parseViewBox(strTrim);
            }
        }
    }

    private void parseAttributesTransform(SVGBase.HasTransform hasTransform, Attributes attributes) throws SVGParseException {
        for (int i = 0; i < attributes.getLength(); i++) {
            if (SVGAttr.fromString(attributes.getLocalName(i)) == SVGAttr.transform) {
                hasTransform.setTransform(parseTransformList(attributes.getValue(i)));
            }
        }
    }

    private Matrix parseTransformList(String str) throws SVGParseException {
        Matrix matrix = new Matrix();
        TextScanner textScanner = new TextScanner(str);
        textScanner.skipWhitespace();
        while (!textScanner.empty()) {
            String strNextFunction = textScanner.nextFunction();
            if (strNextFunction == null) {
                throw new SVGParseException("Bad transform function encountered in transform list: " + str);
            }
            strNextFunction.hashCode();
            switch (strNextFunction) {
                case "matrix":
                    textScanner.skipWhitespace();
                    float fNextFloat = textScanner.nextFloat();
                    textScanner.skipCommaWhitespace();
                    float fNextFloat2 = textScanner.nextFloat();
                    textScanner.skipCommaWhitespace();
                    float fNextFloat3 = textScanner.nextFloat();
                    textScanner.skipCommaWhitespace();
                    float fNextFloat4 = textScanner.nextFloat();
                    textScanner.skipCommaWhitespace();
                    float fNextFloat5 = textScanner.nextFloat();
                    textScanner.skipCommaWhitespace();
                    float fNextFloat6 = textScanner.nextFloat();
                    textScanner.skipWhitespace();
                    if (Float.isNaN(fNextFloat6) || !textScanner.consume(')')) {
                        throw new SVGParseException("Invalid transform list: " + str);
                    }
                    Matrix matrix2 = new Matrix();
                    matrix2.setValues(new float[]{fNextFloat, fNextFloat3, fNextFloat5, fNextFloat2, fNextFloat4, fNextFloat6, 0.0f, 0.0f, 1.0f});
                    matrix.preConcat(matrix2);
                    break;
                    break;
                case "rotate":
                    textScanner.skipWhitespace();
                    float fNextFloat7 = textScanner.nextFloat();
                    float fPossibleNextFloat = textScanner.possibleNextFloat();
                    float fPossibleNextFloat2 = textScanner.possibleNextFloat();
                    textScanner.skipWhitespace();
                    if (Float.isNaN(fNextFloat7) || !textScanner.consume(')')) {
                        throw new SVGParseException("Invalid transform list: " + str);
                    }
                    if (Float.isNaN(fPossibleNextFloat)) {
                        matrix.preRotate(fNextFloat7);
                    } else if (!Float.isNaN(fPossibleNextFloat2)) {
                        matrix.preRotate(fNextFloat7, fPossibleNextFloat, fPossibleNextFloat2);
                    } else {
                        throw new SVGParseException("Invalid transform list: " + str);
                    }
                    break;
                    break;
                case "scale":
                    textScanner.skipWhitespace();
                    float fNextFloat8 = textScanner.nextFloat();
                    float fPossibleNextFloat3 = textScanner.possibleNextFloat();
                    textScanner.skipWhitespace();
                    if (Float.isNaN(fNextFloat8) || !textScanner.consume(')')) {
                        throw new SVGParseException("Invalid transform list: " + str);
                    }
                    if (Float.isNaN(fPossibleNextFloat3)) {
                        matrix.preScale(fNextFloat8, fNextFloat8);
                    } else {
                        matrix.preScale(fNextFloat8, fPossibleNextFloat3);
                    }
                    break;
                    break;
                case "skewX":
                    textScanner.skipWhitespace();
                    float fNextFloat9 = textScanner.nextFloat();
                    textScanner.skipWhitespace();
                    if (Float.isNaN(fNextFloat9) || !textScanner.consume(')')) {
                        throw new SVGParseException("Invalid transform list: " + str);
                    }
                    matrix.preSkew((float) Math.tan(Math.toRadians(fNextFloat9)), 0.0f);
                    break;
                    break;
                case "skewY":
                    textScanner.skipWhitespace();
                    float fNextFloat10 = textScanner.nextFloat();
                    textScanner.skipWhitespace();
                    if (Float.isNaN(fNextFloat10) || !textScanner.consume(')')) {
                        throw new SVGParseException("Invalid transform list: " + str);
                    }
                    matrix.preSkew(0.0f, (float) Math.tan(Math.toRadians(fNextFloat10)));
                    break;
                    break;
                case "translate":
                    textScanner.skipWhitespace();
                    float fNextFloat11 = textScanner.nextFloat();
                    float fPossibleNextFloat4 = textScanner.possibleNextFloat();
                    textScanner.skipWhitespace();
                    if (Float.isNaN(fNextFloat11) || !textScanner.consume(')')) {
                        throw new SVGParseException("Invalid transform list: " + str);
                    }
                    if (Float.isNaN(fPossibleNextFloat4)) {
                        matrix.preTranslate(fNextFloat11, 0.0f);
                    } else {
                        matrix.preTranslate(fNextFloat11, fPossibleNextFloat4);
                    }
                    break;
                    break;
                default:
                    throw new SVGParseException("Invalid transform list fn: " + strNextFunction + ")");
            }
            if (textScanner.empty()) {
                return matrix;
            }
            textScanner.skipCommaWhitespace();
        }
        return matrix;
    }

    static SVGBase.Length parseLength(String str) throws SVGParseException {
        if (str.length() == 0) {
            throw new SVGParseException("Invalid length value (empty string)");
        }
        int length = str.length();
        SVGBase.Unit unitValueOf = SVGBase.Unit.px;
        char cCharAt = str.charAt(length - 1);
        if (cCharAt == '%') {
            length--;
            unitValueOf = SVGBase.Unit.percent;
        } else if (length > 2 && Character.isLetter(cCharAt) && Character.isLetter(str.charAt(length - 2))) {
            length -= 2;
            try {
                unitValueOf = SVGBase.Unit.valueOf(str.substring(length).toLowerCase(Locale.US));
            } catch (IllegalArgumentException unused) {
                throw new SVGParseException("Invalid length unit specifier: " + str);
            }
        }
        try {
            return new SVGBase.Length(parseFloat(str, 0, length), unitValueOf);
        } catch (NumberFormatException e) {
            throw new SVGParseException("Invalid length value: " + str, e);
        }
    }

    private static List<SVGBase.Length> parseLengthList(String str) throws SVGParseException {
        if (str.length() == 0) {
            throw new SVGParseException("Invalid length list (empty string)");
        }
        ArrayList arrayList = new ArrayList(1);
        TextScanner textScanner = new TextScanner(str);
        textScanner.skipWhitespace();
        while (!textScanner.empty()) {
            float fNextFloat = textScanner.nextFloat();
            if (Float.isNaN(fNextFloat)) {
                throw new SVGParseException("Invalid length list value: " + textScanner.ahead());
            }
            SVGBase.Unit unitNextUnit = textScanner.nextUnit();
            if (unitNextUnit == null) {
                unitNextUnit = SVGBase.Unit.px;
            }
            arrayList.add(new SVGBase.Length(fNextFloat, unitNextUnit));
            textScanner.skipCommaWhitespace();
        }
        return arrayList;
    }

    static float parseFloat(String str) throws SVGParseException {
        int length = str.length();
        if (length == 0) {
            throw new SVGParseException("Invalid float value (empty string)");
        }
        return parseFloat(str, 0, length);
    }

    private static float parseFloat(String str, int i, int i2) throws SVGParseException {
        float number = new NumberParser().parseNumber(str, i, i2);
        if (Float.isNaN(number)) {
            throw new SVGParseException("Invalid float value: " + str);
        }
        return number;
    }

    static Float parseOpacity(String str) {
        try {
            float f = parseFloat(str);
            float fMin = 0.0f;
            if (f >= 0.0f) {
                fMin = Math.min(f, 1.0f);
            }
            return Float.valueOf(fMin);
        } catch (SVGParseException unused) {
            return null;
        }
    }

    private static SVGBase.Box parseViewBox(String str) throws SVGParseException {
        TextScanner textScanner = new TextScanner(str);
        textScanner.skipWhitespace();
        float fNextFloat = textScanner.nextFloat();
        textScanner.skipCommaWhitespace();
        float fNextFloat2 = textScanner.nextFloat();
        textScanner.skipCommaWhitespace();
        float fNextFloat3 = textScanner.nextFloat();
        textScanner.skipCommaWhitespace();
        float fNextFloat4 = textScanner.nextFloat();
        if (Float.isNaN(fNextFloat) || Float.isNaN(fNextFloat2) || Float.isNaN(fNextFloat3) || Float.isNaN(fNextFloat4)) {
            throw new SVGParseException("Invalid viewBox definition - should have four numbers");
        }
        if (fNextFloat3 < 0.0f) {
            throw new SVGParseException("Invalid viewBox. width cannot be negative");
        }
        if (fNextFloat4 < 0.0f) {
            throw new SVGParseException("Invalid viewBox. height cannot be negative");
        }
        return new SVGBase.Box(fNextFloat, fNextFloat2, fNextFloat3, fNextFloat4);
    }

    private static void parsePreserveAspectRatio(SVGBase.SvgPreserveAspectRatioContainer svgPreserveAspectRatioContainer, String str) throws SVGParseException {
        svgPreserveAspectRatioContainer.preserveAspectRatio = PreserveAspectRatio.of(str);
    }

    static SVGBase.SvgPaint parsePaintSpecifier(String str) {
        if (str.startsWith("url(")) {
            int iIndexOf = str.indexOf(")");
            if (iIndexOf != -1) {
                String strTrim = str.substring(4, iIndexOf).trim();
                String strTrim2 = str.substring(iIndexOf + 1).trim();
                return new SVGBase.PaintReference(strTrim, strTrim2.length() > 0 ? parseColourSpecifer(strTrim2) : null);
            }
            return new SVGBase.PaintReference(str.substring(4).trim(), null);
        }
        return parseColourSpecifer(str);
    }

    private static SVGBase.SvgPaint parseColourSpecifer(String str) {
        str.hashCode();
        if (str.equals("none")) {
            return SVGBase.Colour.TRANSPARENT;
        }
        if (str.equals(CURRENTCOLOR)) {
            return SVGBase.CurrentColor.getInstance();
        }
        return parseColour(str);
    }

    static SVGBase.Colour parseColour(String str) {
        if (str.charAt(0) == '#') {
            IntegerParser hex = IntegerParser.parseHex(str, 1, str.length());
            if (hex == null) {
                return SVGBase.Colour.BLACK;
            }
            int endPos = hex.getEndPos();
            if (endPos == 4) {
                int iValue = hex.value();
                int i = iValue & 3840;
                int i2 = iValue & 240;
                int i3 = iValue & 15;
                return new SVGBase.Colour(i3 | (i << 8) | (-16777216) | (i << 12) | (i2 << 8) | (i2 << 4) | (i3 << 4));
            }
            if (endPos != 5) {
                if (endPos == 7) {
                    return new SVGBase.Colour(hex.value() | ViewCompat.MEASURED_STATE_MASK);
                }
                if (endPos == 9) {
                    return new SVGBase.Colour((hex.value() >>> 8) | (hex.value() << 24));
                }
                return SVGBase.Colour.BLACK;
            }
            int iValue2 = hex.value();
            int i4 = 61440 & iValue2;
            int i5 = iValue2 & 3840;
            int i6 = iValue2 & 240;
            int i7 = iValue2 & 15;
            return new SVGBase.Colour((i7 << 24) | (i7 << 28) | (i4 << 8) | (i4 << 4) | (i5 << 4) | i5 | i6 | (i6 >> 4));
        }
        String lowerCase = str.toLowerCase(Locale.US);
        boolean zStartsWith = lowerCase.startsWith("rgba(");
        float fNextFloat = Float.NaN;
        if (zStartsWith || lowerCase.startsWith("rgb(")) {
            TextScanner textScanner = new TextScanner(str.substring(zStartsWith ? 5 : 4));
            textScanner.skipWhitespace();
            float fNextFloat2 = textScanner.nextFloat();
            if (!Float.isNaN(fNextFloat2)) {
                if (textScanner.consume('%')) {
                    fNextFloat2 = (fNextFloat2 * 256.0f) / 100.0f;
                }
                boolean zSkipCommaWhitespace = textScanner.skipCommaWhitespace();
                float fNextFloat3 = textScanner.nextFloat();
                if (!Float.isNaN(fNextFloat3)) {
                    if (textScanner.consume('%')) {
                        fNextFloat3 = (fNextFloat3 * 256.0f) / 100.0f;
                    }
                    if (zSkipCommaWhitespace) {
                        if (!textScanner.skipCommaWhitespace()) {
                            return SVGBase.Colour.BLACK;
                        }
                    } else {
                        textScanner.skipWhitespace();
                    }
                    float fNextFloat4 = textScanner.nextFloat();
                    if (!Float.isNaN(fNextFloat4)) {
                        if (textScanner.consume('%')) {
                            fNextFloat4 = (fNextFloat4 * 256.0f) / 100.0f;
                        }
                        if (zSkipCommaWhitespace) {
                            if (textScanner.skipCommaWhitespace()) {
                                fNextFloat = textScanner.nextFloat();
                            }
                        } else {
                            textScanner.skipWhitespace();
                            if (textScanner.consume('/')) {
                                textScanner.skipWhitespace();
                                fNextFloat = textScanner.nextFloat();
                            }
                        }
                        textScanner.skipWhitespace();
                        if (!textScanner.consume(')')) {
                            return SVGBase.Colour.BLACK;
                        }
                        if (Float.isNaN(fNextFloat)) {
                            return new SVGBase.Colour((clamp255(fNextFloat2) << 16) | ViewCompat.MEASURED_STATE_MASK | (clamp255(fNextFloat3) << 8) | clamp255(fNextFloat4));
                        }
                        return new SVGBase.Colour((clamp255(fNextFloat2) << 16) | (clamp255(fNextFloat * 256.0f) << 24) | (clamp255(fNextFloat3) << 8) | clamp255(fNextFloat4));
                    }
                }
            }
        } else {
            boolean zStartsWith2 = lowerCase.startsWith("hsla(");
            if (zStartsWith2 || lowerCase.startsWith("hsl(")) {
                TextScanner textScanner2 = new TextScanner(str.substring(zStartsWith2 ? 5 : 4));
                textScanner2.skipWhitespace();
                float fNextFloat5 = textScanner2.nextFloat();
                if (!Float.isNaN(fNextFloat5)) {
                    textScanner2.consume("deg");
                    boolean zSkipCommaWhitespace2 = textScanner2.skipCommaWhitespace();
                    float fNextFloat6 = textScanner2.nextFloat();
                    if (!Float.isNaN(fNextFloat6)) {
                        if (!textScanner2.consume('%')) {
                            return SVGBase.Colour.BLACK;
                        }
                        if (zSkipCommaWhitespace2) {
                            if (!textScanner2.skipCommaWhitespace()) {
                                return SVGBase.Colour.BLACK;
                            }
                        } else {
                            textScanner2.skipWhitespace();
                        }
                        float fNextFloat7 = textScanner2.nextFloat();
                        if (!Float.isNaN(fNextFloat7)) {
                            if (!textScanner2.consume('%')) {
                                return SVGBase.Colour.BLACK;
                            }
                            if (zSkipCommaWhitespace2) {
                                if (textScanner2.skipCommaWhitespace()) {
                                    fNextFloat = textScanner2.nextFloat();
                                }
                            } else {
                                textScanner2.skipWhitespace();
                                if (textScanner2.consume('/')) {
                                    textScanner2.skipWhitespace();
                                    fNextFloat = textScanner2.nextFloat();
                                }
                            }
                            textScanner2.skipWhitespace();
                            if (!textScanner2.consume(')')) {
                                return SVGBase.Colour.BLACK;
                            }
                            if (Float.isNaN(fNextFloat)) {
                                return new SVGBase.Colour(hslToRgb(fNextFloat5, fNextFloat6, fNextFloat7) | ViewCompat.MEASURED_STATE_MASK);
                            }
                            return new SVGBase.Colour(hslToRgb(fNextFloat5, fNextFloat6, fNextFloat7) | (clamp255(fNextFloat * 256.0f) << 24));
                        }
                    }
                }
            }
        }
        return parseColourKeyword(lowerCase);
    }

    private static int clamp255(float f) {
        if (f < 0.0f) {
            return 0;
        }
        if (f > 255.0f) {
            return 255;
        }
        return Math.round(f);
    }

    private static int hslToRgb(float f, float f2, float f3) {
        float f4 = f % 360.0f;
        if (f < 0.0f) {
            f4 += 360.0f;
        }
        float f5 = f4 / 60.0f;
        float f6 = f2 / 100.0f;
        float f7 = f3 / 100.0f;
        float fMin = f6 < 0.0f ? 0.0f : Math.min(f6, 1.0f);
        float fMin2 = f7 >= 0.0f ? Math.min(f7, 1.0f) : 0.0f;
        float f8 = fMin2 <= 0.5f ? (fMin + 1.0f) * fMin2 : (fMin2 + fMin) - (fMin * fMin2);
        float f9 = (fMin2 * 2.0f) - f8;
        return clamp255(hueToRgb(f9, f8, f5 - 2.0f) * 256.0f) | (clamp255(hueToRgb(f9, f8, f5 + 2.0f) * 256.0f) << 16) | (clamp255(hueToRgb(f9, f8, f5) * 256.0f) << 8);
    }

    private static SVGBase.Colour parseColourKeyword(String str) {
        Integer num = ColourKeywords.get(str);
        return num == null ? SVGBase.Colour.BLACK : new SVGBase.Colour(num.intValue());
    }

    static void parseFont(Style style, String str) {
        String strNextToken;
        if ("|caption|icon|menu|message-box|small-caption|status-bar|".contains(l.ad + str + '|')) {
            return;
        }
        TextScanner textScanner = new TextScanner(str);
        Float f = null;
        Style.FontStyle fontStyle = null;
        Boolean bool = null;
        Float f2 = null;
        while (true) {
            strNextToken = textScanner.nextToken('/');
            textScanner.skipWhitespace();
            if (strNextToken != null) {
                if (f != null && fontStyle != null) {
                    break;
                }
                if (!strNextToken.equals(Constants.NORMAL)) {
                    if (f == null && FontWeightKeywords.contains(strNextToken)) {
                        f = FontWeightKeywords.get(strNextToken);
                    } else if (fontStyle != null || (fontStyle = parseFontStyle(strNextToken)) == null) {
                        if (bool == null && strNextToken.equals("small-caps")) {
                            bool = true;
                        } else if (f2 != null || !FontStretchKeywords.contains(strNextToken)) {
                            break;
                        } else {
                            f2 = FontStretchKeywords.get(strNextToken);
                        }
                    }
                }
            } else {
                return;
            }
        }
        SVGBase.Length fontSize = parseFontSize(strNextToken);
        if (textScanner.consume('/')) {
            textScanner.skipWhitespace();
            String strNextToken2 = textScanner.nextToken();
            if (strNextToken2 != null) {
                try {
                    parseLength(strNextToken2);
                } catch (SVGParseException unused) {
                    return;
                }
            }
            textScanner.skipWhitespace();
        }
        style.fontFamily = parseFontFamily(textScanner.restOfText());
        style.fontSize = fontSize;
        style.fontWeight = Float.valueOf(f == null ? 400.0f : f.floatValue());
        if (fontStyle == null) {
            fontStyle = Style.FontStyle.normal;
        }
        style.fontStyle = fontStyle;
        style.fontStretch = Float.valueOf(f2 == null ? 100.0f : f2.floatValue());
        style.fontKerning = Style.FontKerning.auto;
        style.fontVariantLigatures = CSSFontFeatureSettings.LIGATURES_NORMAL;
        style.fontVariantPosition = CSSFontFeatureSettings.POSITION_ALL_OFF;
        style.fontVariantCaps = CSSFontFeatureSettings.CAPS_ALL_OFF;
        if (bool == Boolean.TRUE) {
            style.fontVariantCaps = CSSFontFeatureSettings.makeSmallCaps();
        }
        style.fontVariantNumeric = CSSFontFeatureSettings.NUMERIC_ALL_OFF;
        style.fontVariantEastAsian = CSSFontFeatureSettings.EAST_ASIAN_ALL_OFF;
        style.fontFeatureSettings = CSSFontFeatureSettings.FONT_FEATURE_SETTINGS_NORMAL;
        style.fontVariationSettings = null;
        style.specifiedFlags |= 4009918906621952L;
    }

    static List<String> parseFontFamily(String str) {
        TextScanner textScanner = new TextScanner(str);
        ArrayList arrayList = null;
        do {
            String strNextQuotedString = textScanner.nextQuotedString();
            if (strNextQuotedString == null) {
                strNextQuotedString = textScanner.nextTokenWithWhitespace(AbstractJsonLexerKt.COMMA);
            }
            if (strNextQuotedString == null) {
                break;
            }
            if (arrayList == null) {
                arrayList = new ArrayList();
            }
            arrayList.add(strNextQuotedString);
            textScanner.skipCommaWhitespace();
        } while (!textScanner.empty());
        return arrayList;
    }

    static SVGBase.Length parseFontSize(String str) {
        try {
            SVGBase.Length length = FontSizeKeywords.get(str);
            return length == null ? parseLength(str) : length;
        } catch (SVGParseException unused) {
            return null;
        }
    }

    static Float parseFontWeight(String str) {
        Float f = FontWeightKeywords.get(str);
        if (f != null) {
            return f;
        }
        TextScanner textScanner = new TextScanner(str);
        Float fValueOf = Float.valueOf(textScanner.nextFloat());
        textScanner.skipWhitespace();
        if (textScanner.empty() && fValueOf.floatValue() >= 1.0f && fValueOf.floatValue() <= 1000.0f) {
            return fValueOf;
        }
        return null;
    }

    static Float parseFontStretch(String str) {
        Float f = FontStretchKeywords.get(str);
        if (f != null) {
            return f;
        }
        TextScanner textScanner = new TextScanner(str);
        Float fValueOf = Float.valueOf(textScanner.nextFloat());
        if (!textScanner.consume('%')) {
            return null;
        }
        textScanner.skipWhitespace();
        if (textScanner.empty() && fValueOf.floatValue() >= 0.0f) {
            return fValueOf;
        }
        return null;
    }

    static Style.FontStyle parseFontStyle(String str) {
        str.hashCode();
        switch (str) {
            case "oblique":
                return Style.FontStyle.oblique;
            case "italic":
                return Style.FontStyle.italic;
            case "normal":
                return Style.FontStyle.normal;
            default:
                return null;
        }
    }

    static Style.TextDecoration parseTextDecoration(String str) {
        str.hashCode();
        switch (str) {
            case "line-through":
                return Style.TextDecoration.LineThrough;
            case "underline":
                return Style.TextDecoration.Underline;
            case "none":
                return Style.TextDecoration.None;
            case "blink":
                return Style.TextDecoration.Blink;
            case "overline":
                return Style.TextDecoration.Overline;
            default:
                return null;
        }
    }

    static Style.TextDirection parseTextDirection(String str) {
        str.hashCode();
        if (str.equals("ltr")) {
            return Style.TextDirection.LTR;
        }
        if (str.equals("rtl")) {
            return Style.TextDirection.RTL;
        }
        return null;
    }

    static Style.FillRule parseFillRule(String str) {
        if ("nonzero".equals(str)) {
            return Style.FillRule.NonZero;
        }
        if ("evenodd".equals(str)) {
            return Style.FillRule.EvenOdd;
        }
        return null;
    }

    static Style.LineCap parseStrokeLineCap(String str) {
        if ("butt".equals(str)) {
            return Style.LineCap.Butt;
        }
        if ("round".equals(str)) {
            return Style.LineCap.Round;
        }
        if ("square".equals(str)) {
            return Style.LineCap.Square;
        }
        return null;
    }

    static Style.LineJoin parseStrokeLineJoin(String str) {
        if ("miter".equals(str)) {
            return Style.LineJoin.Miter;
        }
        if ("round".equals(str)) {
            return Style.LineJoin.Round;
        }
        if ("bevel".equals(str)) {
            return Style.LineJoin.Bevel;
        }
        return null;
    }

    static SVGBase.Length[] parseStrokeDashArray(String str) {
        SVGBase.Length lengthNextLength;
        TextScanner textScanner = new TextScanner(str);
        textScanner.skipWhitespace();
        if (textScanner.empty() || (lengthNextLength = textScanner.nextLength()) == null || lengthNextLength.isNegative()) {
            return null;
        }
        float fFloatValue = lengthNextLength.floatValue();
        ArrayList arrayList = new ArrayList();
        arrayList.add(lengthNextLength);
        while (!textScanner.empty()) {
            textScanner.skipCommaWhitespace();
            SVGBase.Length lengthNextLength2 = textScanner.nextLength();
            if (lengthNextLength2 == null || lengthNextLength2.isNegative()) {
                return null;
            }
            arrayList.add(lengthNextLength2);
            fFloatValue += lengthNextLength2.floatValue();
        }
        if (fFloatValue == 0.0f) {
            return null;
        }
        return (SVGBase.Length[]) arrayList.toArray(new SVGBase.Length[0]);
    }

    static Style.TextAnchor parseTextAnchor(String str) {
        str.hashCode();
        switch (str) {
            case "middle":
                return Style.TextAnchor.Middle;
            case "end":
                return Style.TextAnchor.End;
            case "start":
                return Style.TextAnchor.Start;
            default:
                return null;
        }
    }

    static Boolean parseOverflow(String str) {
        str.hashCode();
        switch (str) {
            case "hidden":
            case "scroll":
                return Boolean.FALSE;
            case "auto":
            case "visible":
                return Boolean.TRUE;
            default:
                return null;
        }
    }

    static SVGBase.CSSClipRect parseClip(String str) {
        if ("auto".equals(str) || !str.startsWith("rect(")) {
            return null;
        }
        TextScanner textScanner = new TextScanner(str.substring(5));
        textScanner.skipWhitespace();
        SVGBase.Length lengthOrAuto = parseLengthOrAuto(textScanner);
        textScanner.skipCommaWhitespace();
        SVGBase.Length lengthOrAuto2 = parseLengthOrAuto(textScanner);
        textScanner.skipCommaWhitespace();
        SVGBase.Length lengthOrAuto3 = parseLengthOrAuto(textScanner);
        textScanner.skipCommaWhitespace();
        SVGBase.Length lengthOrAuto4 = parseLengthOrAuto(textScanner);
        textScanner.skipWhitespace();
        if (textScanner.consume(')') || textScanner.empty()) {
            return new SVGBase.CSSClipRect(lengthOrAuto, lengthOrAuto2, lengthOrAuto3, lengthOrAuto4);
        }
        return null;
    }

    private static SVGBase.Length parseLengthOrAuto(TextScanner textScanner) {
        if (textScanner.consume("auto")) {
            return SVGBase.Length.ZERO;
        }
        return textScanner.nextLength();
    }

    static Style.VectorEffect parseVectorEffect(String str) {
        str.hashCode();
        if (str.equals("none")) {
            return Style.VectorEffect.None;
        }
        if (str.equals("non-scaling-stroke")) {
            return Style.VectorEffect.NonScalingStroke;
        }
        return null;
    }

    static Style.RenderQuality parseRenderQuality(String str) {
        str.hashCode();
        switch (str) {
            case "optimizeQuality":
                return Style.RenderQuality.optimizeQuality;
            case "auto":
                return Style.RenderQuality.auto;
            case "optimizeSpeed":
                return Style.RenderQuality.optimizeSpeed;
            default:
                return null;
        }
    }

    static Style.Isolation parseIsolation(String str) {
        str.hashCode();
        if (str.equals("auto")) {
            return Style.Isolation.auto;
        }
        if (str.equals("isolate")) {
            return Style.Isolation.isolate;
        }
        return null;
    }

    static SVGBase.Length parseLetterOrWordSpacing(String str) {
        if (Constants.NORMAL.equals(str)) {
            return SVGBase.Length.ZERO;
        }
        try {
            SVGBase.Length length = parseLength(str);
            if (length.unit == SVGBase.Unit.percent) {
                return null;
            }
            return length;
        } catch (SVGParseException unused) {
            return null;
        }
    }

    /* JADX WARN: Code duplicated, block: B:100:0x0277  */
    /* JADX WARN: Code duplicated, block: B:102:0x027d  */
    /* JADX WARN: Code duplicated, block: B:118:0x0276 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:120:0x0285 A[SYNTHETIC] */
    protected static SVGBase.PathDefinition parsePath(String str) {
        float fCheckedNextFloat;
        float fCheckedNextFloat2;
        float f;
        float f2;
        TextScanner textScanner = new TextScanner(str);
        SVGBase.PathDefinition pathDefinition = new SVGBase.PathDefinition();
        if (textScanner.empty()) {
            return pathDefinition;
        }
        int iIntValue = textScanner.nextChar().intValue();
        int i = 109;
        if (iIntValue != 77 && iIntValue != 109) {
            return pathDefinition;
        }
        int iIntValue2 = iIntValue;
        float f3 = 0.0f;
        float f4 = 0.0f;
        float f5 = 0.0f;
        float f6 = 0.0f;
        float f7 = 0.0f;
        float f8 = 0.0f;
        while (true) {
            textScanner.skipWhitespace();
            switch (iIntValue2) {
                case 65:
                case 97:
                    float fNextFloat = textScanner.nextFloat();
                    float fCheckedNextFloat3 = textScanner.checkedNextFloat(fNextFloat);
                    float fCheckedNextFloat4 = textScanner.checkedNextFloat(fCheckedNextFloat3);
                    Boolean boolCheckedNextFlag = textScanner.checkedNextFlag(Float.valueOf(fCheckedNextFloat4));
                    Boolean boolCheckedNextFlag2 = textScanner.checkedNextFlag(boolCheckedNextFlag);
                    float fCheckedNextFloat5 = textScanner.checkedNextFloat(boolCheckedNextFlag2);
                    float fCheckedNextFloat6 = textScanner.checkedNextFloat(fCheckedNextFloat5);
                    if (Float.isNaN(fCheckedNextFloat6) || fNextFloat < 0.0f || fCheckedNextFloat3 < 0.0f) {
                        Log.e(TAG, "Bad path coords for " + ((char) iIntValue2) + " path segment");
                    } else {
                        if (iIntValue2 == 97) {
                            fCheckedNextFloat5 += f3;
                            fCheckedNextFloat6 += f5;
                        }
                        pathDefinition.arcTo(fNextFloat, fCheckedNextFloat3, fCheckedNextFloat4, boolCheckedNextFlag.booleanValue(), boolCheckedNextFlag2.booleanValue(), fCheckedNextFloat5, fCheckedNextFloat6);
                        f3 = fCheckedNextFloat5;
                        f4 = f3;
                        f5 = fCheckedNextFloat6;
                        f6 = f5;
                        textScanner.skipCommaWhitespace();
                        if (textScanner.empty()) {
                            if (textScanner.hasLetter()) {
                                iIntValue2 = textScanner.nextChar().intValue();
                            }
                            i = 109;
                        }
                    }
                    break;
                case 67:
                case 99:
                    float fNextFloat2 = textScanner.nextFloat();
                    float fCheckedNextFloat7 = textScanner.checkedNextFloat(fNextFloat2);
                    float fCheckedNextFloat8 = textScanner.checkedNextFloat(fCheckedNextFloat7);
                    float fCheckedNextFloat9 = textScanner.checkedNextFloat(fCheckedNextFloat8);
                    fCheckedNextFloat = textScanner.checkedNextFloat(fCheckedNextFloat9);
                    fCheckedNextFloat2 = textScanner.checkedNextFloat(fCheckedNextFloat);
                    if (Float.isNaN(fCheckedNextFloat2)) {
                        Log.e(TAG, "Bad path coords for " + ((char) iIntValue2) + " path segment");
                    } else {
                        if (iIntValue2 == 99) {
                            fCheckedNextFloat += f3;
                            fCheckedNextFloat2 += f5;
                            fNextFloat2 += f3;
                            fCheckedNextFloat7 += f5;
                            fCheckedNextFloat8 += f3;
                            fCheckedNextFloat9 += f5;
                        }
                        f = fCheckedNextFloat8;
                        f2 = fCheckedNextFloat9;
                        pathDefinition.cubicTo(fNextFloat2, fCheckedNextFloat7, f, f2, fCheckedNextFloat, fCheckedNextFloat2);
                        f4 = f;
                        f3 = fCheckedNextFloat;
                        f6 = f2;
                        f5 = fCheckedNextFloat2;
                        textScanner.skipCommaWhitespace();
                        if (textScanner.empty()) {
                            if (textScanner.hasLetter()) {
                                iIntValue2 = textScanner.nextChar().intValue();
                            }
                            i = 109;
                        }
                    }
                    break;
                case 72:
                case 104:
                    float fNextFloat3 = textScanner.nextFloat();
                    if (Float.isNaN(fNextFloat3)) {
                        Log.e(TAG, "Bad path coords for " + ((char) iIntValue2) + " path segment");
                    } else {
                        if (iIntValue2 == 104) {
                            fNextFloat3 += f3;
                        }
                        f3 = fNextFloat3;
                        pathDefinition.lineTo(f3, f5);
                        f4 = f3;
                        f6 = f5;
                        textScanner.skipCommaWhitespace();
                        if (textScanner.empty()) {
                            if (textScanner.hasLetter()) {
                                iIntValue2 = textScanner.nextChar().intValue();
                            }
                            i = 109;
                        }
                    }
                    break;
                case 76:
                case 108:
                    float fNextFloat4 = textScanner.nextFloat();
                    float fCheckedNextFloat10 = textScanner.checkedNextFloat(fNextFloat4);
                    if (Float.isNaN(fCheckedNextFloat10)) {
                        Log.e(TAG, "Bad path coords for " + ((char) iIntValue2) + " path segment");
                    } else {
                        if (iIntValue2 == 108) {
                            fNextFloat4 += f3;
                            fCheckedNextFloat10 += f5;
                        }
                        f3 = fNextFloat4;
                        f5 = fCheckedNextFloat10;
                        pathDefinition.lineTo(f3, f5);
                        f4 = f3;
                        f6 = f5;
                        textScanner.skipCommaWhitespace();
                        if (textScanner.empty()) {
                            if (textScanner.hasLetter()) {
                                iIntValue2 = textScanner.nextChar().intValue();
                            }
                            i = 109;
                        }
                    }
                    break;
                case 77:
                case 109:
                    float fNextFloat5 = textScanner.nextFloat();
                    float fCheckedNextFloat11 = textScanner.checkedNextFloat(fNextFloat5);
                    if (Float.isNaN(fCheckedNextFloat11)) {
                        Log.e(TAG, "Bad path coords for " + ((char) iIntValue2) + " path segment");
                    } else {
                        if (iIntValue2 == i && !pathDefinition.isEmpty()) {
                            fNextFloat5 += f3;
                            fCheckedNextFloat11 += f5;
                        }
                        f3 = fNextFloat5;
                        f5 = fCheckedNextFloat11;
                        pathDefinition.moveTo(f3, f5);
                        f4 = f3;
                        f7 = f4;
                        f6 = f5;
                        f8 = f6;
                        iIntValue2 = iIntValue2 != i ? 76 : 108;
                        textScanner.skipCommaWhitespace();
                        if (textScanner.empty()) {
                            if (textScanner.hasLetter()) {
                                iIntValue2 = textScanner.nextChar().intValue();
                            }
                            i = 109;
                        }
                    }
                    break;
                case IronSourceConstants.TROUBLESHOOTING_AD_QUALITY_SDK_INITIALIZED_SUCCESSFULLY_EVENT /* 81 */:
                case 113:
                    float fNextFloat6 = textScanner.nextFloat();
                    float fCheckedNextFloat12 = textScanner.checkedNextFloat(fNextFloat6);
                    float fCheckedNextFloat13 = textScanner.checkedNextFloat(fCheckedNextFloat12);
                    float fCheckedNextFloat14 = textScanner.checkedNextFloat(fCheckedNextFloat13);
                    if (Float.isNaN(fCheckedNextFloat14)) {
                        Log.e(TAG, "Bad path coords for " + ((char) iIntValue2) + " path segment");
                    } else {
                        if (iIntValue2 == 113) {
                            fCheckedNextFloat13 += f3;
                            fCheckedNextFloat14 += f5;
                            fNextFloat6 += f3;
                            fCheckedNextFloat12 += f5;
                        }
                        float f9 = fNextFloat6;
                        float f10 = fCheckedNextFloat12;
                        pathDefinition.quadTo(f9, f10, fCheckedNextFloat13, fCheckedNextFloat14);
                        f4 = f9;
                        f6 = f10;
                        f3 = fCheckedNextFloat13;
                        f5 = fCheckedNextFloat14;
                        textScanner.skipCommaWhitespace();
                        if (textScanner.empty()) {
                            if (textScanner.hasLetter()) {
                                iIntValue2 = textScanner.nextChar().intValue();
                            }
                            i = 109;
                        }
                    }
                    break;
                case IronSourceConstants.TROUBLESHOOTING_AD_QUALITY_SDK_FAILED_TO_INITIALIZE_EVENT /* 83 */:
                case 115:
                    float f11 = (f3 * 2.0f) - f4;
                    float f12 = (2.0f * f5) - f6;
                    float fNextFloat7 = textScanner.nextFloat();
                    float fCheckedNextFloat15 = textScanner.checkedNextFloat(fNextFloat7);
                    fCheckedNextFloat = textScanner.checkedNextFloat(fCheckedNextFloat15);
                    fCheckedNextFloat2 = textScanner.checkedNextFloat(fCheckedNextFloat);
                    if (Float.isNaN(fCheckedNextFloat2)) {
                        Log.e(TAG, "Bad path coords for " + ((char) iIntValue2) + " path segment");
                    } else {
                        if (iIntValue2 == 115) {
                            fCheckedNextFloat += f3;
                            fCheckedNextFloat2 += f5;
                            fNextFloat7 += f3;
                            fCheckedNextFloat15 += f5;
                        }
                        f = fNextFloat7;
                        f2 = fCheckedNextFloat15;
                        pathDefinition.cubicTo(f11, f12, f, f2, fCheckedNextFloat, fCheckedNextFloat2);
                        f4 = f;
                        f3 = fCheckedNextFloat;
                        f6 = f2;
                        f5 = fCheckedNextFloat2;
                        textScanner.skipCommaWhitespace();
                        if (textScanner.empty()) {
                            if (textScanner.hasLetter()) {
                                iIntValue2 = textScanner.nextChar().intValue();
                            }
                            i = 109;
                        }
                    }
                    break;
                case IronSourceConstants.TROUBLESHOOTING_AD_QUALITY_SDK_NOT_EXIST /* 84 */:
                case 116:
                    float f13 = (f3 * 2.0f) - f4;
                    float f14 = (2.0f * f5) - f6;
                    float fNextFloat8 = textScanner.nextFloat();
                    float fCheckedNextFloat16 = textScanner.checkedNextFloat(fNextFloat8);
                    if (Float.isNaN(fCheckedNextFloat16)) {
                        Log.e(TAG, "Bad path coords for " + ((char) iIntValue2) + " path segment");
                    } else {
                        if (iIntValue2 == 116) {
                            fNextFloat8 += f3;
                            fCheckedNextFloat16 += f5;
                        }
                        f3 = fNextFloat8;
                        f5 = fCheckedNextFloat16;
                        pathDefinition.quadTo(f13, f14, f3, f5);
                        f4 = f13;
                        f6 = f14;
                        textScanner.skipCommaWhitespace();
                        if (textScanner.empty()) {
                            if (textScanner.hasLetter()) {
                                iIntValue2 = textScanner.nextChar().intValue();
                            }
                            i = 109;
                        }
                    }
                    break;
                case 86:
                case PROTOBUF_SERIALIZATION_ERROR_VALUE:
                    float fNextFloat9 = textScanner.nextFloat();
                    if (Float.isNaN(fNextFloat9)) {
                        Log.e(TAG, "Bad path coords for " + ((char) iIntValue2) + " path segment");
                    } else {
                        if (iIntValue2 == 118) {
                            fNextFloat9 += f5;
                        }
                        f5 = fNextFloat9;
                        pathDefinition.lineTo(f3, f5);
                        f4 = f3;
                        f6 = f5;
                        textScanner.skipCommaWhitespace();
                        if (textScanner.empty()) {
                            if (textScanner.hasLetter()) {
                                iIntValue2 = textScanner.nextChar().intValue();
                            }
                            i = 109;
                        }
                    }
                    break;
                case 90:
                case INVALID_ADS_ENDPOINT_VALUE:
                    pathDefinition.close();
                    f3 = f7;
                    f4 = f3;
                    f5 = f8;
                    f6 = f5;
                    textScanner.skipCommaWhitespace();
                    if (textScanner.empty()) {
                        if (textScanner.hasLetter()) {
                            iIntValue2 = textScanner.nextChar().intValue();
                        }
                        i = 109;
                    }
                    break;
                default:
                    break;
            }
            return pathDefinition;
        }
    }

    private static Set<String> parseRequiredFeatures(String str) {
        TextScanner textScanner = new TextScanner(str);
        HashSet hashSet = new HashSet();
        while (!textScanner.empty()) {
            String strNextToken = textScanner.nextToken();
            if (strNextToken.startsWith(FEATURE_STRING_PREFIX)) {
                hashSet.add(strNextToken.substring(FEATURE_STRING_PREFIX.length()));
            } else {
                hashSet.add("UNSUPPORTED");
            }
            textScanner.skipWhitespace();
        }
        return hashSet;
    }

    private static Set<String> parseSystemLanguage(String str) {
        TextScanner textScanner = new TextScanner(str);
        HashSet hashSet = new HashSet();
        while (!textScanner.empty()) {
            String strNextToken = textScanner.nextToken();
            int iIndexOf = strNextToken.indexOf(45);
            if (iIndexOf != -1) {
                strNextToken = strNextToken.substring(0, iIndexOf);
            }
            hashSet.add(new Locale(strNextToken, "", "").getLanguage());
            textScanner.skipWhitespace();
        }
        return hashSet;
    }

    private static Set<String> parseRequiredFormats(String str) {
        TextScanner textScanner = new TextScanner(str);
        HashSet hashSet = new HashSet();
        while (!textScanner.empty()) {
            hashSet.add(textScanner.nextToken());
            textScanner.skipWhitespace();
        }
        return hashSet;
    }

    static String parseFunctionalIRI(String str, String str2) {
        if (str.equals("none") || !str.startsWith("url(")) {
            return null;
        }
        if (str.endsWith(")")) {
            return str.substring(4, str.length() - 1).trim();
        }
        return str.substring(4).trim();
    }

    private void style(Attributes attributes) throws SVGParseException {
        debug("<style>", new Object[0]);
        if (this.currentElement == null) {
            throw new SVGParseException("Invalid document. Root element must be <svg>");
        }
        String str = "all";
        boolean zEquals = true;
        for (int i = 0; i < attributes.getLength(); i++) {
            String strTrim = attributes.getValue(i).trim();
            int i2 = AnonymousClass1.$SwitchMap$net$pubnative$lite$sdk$utils$svgparser$utils$SVGParserImpl$SVGAttr[SVGAttr.fromString(attributes.getLocalName(i)).ordinal()];
            if (i2 == 49) {
                zEquals = strTrim.equals("text/css");
            } else if (i2 == 50) {
                str = strTrim;
            }
        }
        if (zEquals && CSSParser.mediaMatches(str, CSSParser.MediaType.screen)) {
            this.inStyleElement = true;
        } else {
            this.ignoring = true;
            this.ignoreDepth = 1;
        }
    }

    private void parseCSSStyleSheet(String str) {
        this.svgDocument.addCSSRules(new CSSParser(CSSParser.MediaType.screen, CSSParser.Source.Document, this.externalFileResolver).parse(str));
    }
}
