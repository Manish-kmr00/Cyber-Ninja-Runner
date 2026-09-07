package net.pubnative.lite.sdk.utils.svgparser.utils;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Picture;
import android.graphics.RectF;
import androidx.core.view.ViewCompat;
import com.json.b9;
import com.yandex.div.core.timer.TimerController;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import net.pubnative.lite.sdk.utils.svgparser.PreserveAspectRatio;
import net.pubnative.lite.sdk.utils.svgparser.RenderOptions;
import net.pubnative.lite.sdk.utils.svgparser.SVGExternalFileResolver;
import net.pubnative.lite.sdk.utils.svgparser.SVGParseException;

/* JADX INFO: loaded from: classes.dex */
public class SVGBase {
    private static final int DEFAULT_PICTURE_HEIGHT = 512;
    private static final int DEFAULT_PICTURE_WIDTH = 512;
    private static final double SQRT2 = 1.414213562373095d;
    private static boolean enableInternalEntitiesSingleton = true;
    private static SVGExternalFileResolver externalFileResolverSingleton;
    private final boolean enableInternalEntities;
    private final SVGExternalFileResolver externalFileResolver;
    private Svg rootElement = null;
    private String title = "";
    private String desc = "";
    private float renderDPI = 96.0f;
    private final CSSParser.Ruleset cssRules = new CSSParser.Ruleset();
    private final Map<String, SvgElementBase> idToElementMap = new HashMap();

    enum GradientSpread {
        pad,
        reflect,
        repeat
    }

    interface HasTransform {
        void setTransform(Matrix matrix);
    }

    interface NotDirectlyRendered {
    }

    interface PathInterface {
        void arcTo(float f, float f2, float f3, boolean z, boolean z2, float f4, float f5);

        void close();

        void cubicTo(float f, float f2, float f3, float f4, float f5, float f6);

        void lineTo(float f, float f2);

        void moveTo(float f, float f2);

        void quadTo(float f, float f2, float f3, float f4);
    }

    interface SvgConditional {
        String getRequiredExtensions();

        Set<String> getRequiredFeatures();

        Set<String> getRequiredFonts();

        Set<String> getRequiredFormats();

        Set<String> getSystemLanguage();

        void setRequiredExtensions(String str);

        void setRequiredFeatures(Set<String> set);

        void setRequiredFonts(Set<String> set);

        void setRequiredFormats(Set<String> set);

        void setSystemLanguage(Set<String> set);
    }

    public interface SvgContainer {
        void addChild(SvgObject svgObject) throws SVGParseException;

        List<SvgObject> getChildren();
    }

    public static abstract class SvgPaint implements Cloneable {
    }

    interface TextChild {
        TextRoot getTextRoot();

        void setTextRoot(TextRoot textRoot);
    }

    interface TextRoot {
    }

    enum Unit {
        px,
        em,
        ex,
        in,
        cm,
        mm,
        pt,
        pc,
        percent
    }

    SVGBase(boolean z, SVGExternalFileResolver sVGExternalFileResolver) {
        this.enableInternalEntities = z;
        this.externalFileResolver = sVGExternalFileResolver;
    }

    public static SVGBase getFromInputStream(InputStream inputStream) throws SVGParseException {
        return createParser().parseStream(inputStream);
    }

    public static SVGBase getFromString(String str) throws SVGParseException {
        return createParser().parseStream(new ByteArrayInputStream(str.getBytes()));
    }

    public Picture renderToPicture(RenderOptionsBase renderOptionsBase) {
        Box box = (renderOptionsBase == null || !renderOptionsBase.hasViewBox()) ? this.rootElement.viewBox : renderOptionsBase.viewBox;
        if (renderOptionsBase != null && renderOptionsBase.hasViewPort()) {
            return renderToPicture((int) Math.ceil(renderOptionsBase.viewPort.maxX()), (int) Math.ceil(renderOptionsBase.viewPort.maxY()), renderOptionsBase);
        }
        if (this.rootElement.width != null && this.rootElement.width.unit != Unit.percent && this.rootElement.height != null && this.rootElement.height.unit != Unit.percent) {
            return renderToPicture((int) Math.ceil(this.rootElement.width.floatValue(this.renderDPI)), (int) Math.ceil(this.rootElement.height.floatValue(this.renderDPI)), renderOptionsBase);
        }
        if (this.rootElement.width != null && box != null) {
            float fFloatValue = this.rootElement.width.floatValue(this.renderDPI);
            return renderToPicture((int) Math.ceil(fFloatValue), (int) Math.ceil((box.height * fFloatValue) / box.width), renderOptionsBase);
        }
        if (this.rootElement.height != null && box != null) {
            float fFloatValue2 = this.rootElement.height.floatValue(this.renderDPI);
            return renderToPicture((int) Math.ceil((box.width * fFloatValue2) / box.height), (int) Math.ceil(fFloatValue2), renderOptionsBase);
        }
        return renderToPicture(512, 512, renderOptionsBase);
    }

    public Picture renderToPicture(int i, int i2, RenderOptionsBase renderOptionsBase) {
        Picture picture = new Picture();
        Canvas canvasBeginRecording = picture.beginRecording(i, i2);
        if (renderOptionsBase == null || renderOptionsBase.viewPort == null) {
            renderOptionsBase = renderOptionsBase == null ? new RenderOptionsBase() : new RenderOptionsBase(renderOptionsBase);
            renderOptionsBase.viewPort(0.0f, 0.0f, i, i2);
        }
        new SVGAndroidRenderer(canvasBeginRecording, this.renderDPI, this.externalFileResolver).renderDocument(this, renderOptionsBase);
        picture.endRecording();
        return picture;
    }

    public void renderToCanvas(Canvas canvas, RenderOptions renderOptions) {
        if (renderOptions == null) {
            renderOptions = new RenderOptions();
        }
        if (!renderOptions.hasViewPort()) {
            renderOptions.viewPort(0.0f, 0.0f, canvas.getWidth(), canvas.getHeight());
        }
        new SVGAndroidRenderer(canvas, this.renderDPI, this.externalFileResolver).renderDocument(this, renderOptions);
    }

    public PreserveAspectRatio getDocumentPreserveAspectRatio() {
        Svg svg = this.rootElement;
        if (svg == null) {
            throw new IllegalArgumentException("SVG document is empty");
        }
        if (svg.preserveAspectRatio == null) {
            return null;
        }
        return this.rootElement.preserveAspectRatio;
    }

    protected static SVGParser createParser() {
        return new SVGParserImpl().setInternalEntitiesEnabled(enableInternalEntitiesSingleton).setExternalFileResolver(externalFileResolverSingleton);
    }

    public Svg getRootElement() {
        return this.rootElement;
    }

    void setRootElement(Svg svg) {
        this.rootElement = svg;
    }

    SvgObject resolveIRI(String str) {
        if (str == null) {
            return null;
        }
        String strCssQuotedString = cssQuotedString(str);
        if (strCssQuotedString.length() <= 1 || !strCssQuotedString.startsWith("#")) {
            return null;
        }
        return getElementById(strCssQuotedString.substring(1));
    }

    private String cssQuotedString(String str) {
        if (str.startsWith("\"") && str.endsWith("\"")) {
            str = str.substring(1, str.length() - 1).replace("\\\"", "\"");
        } else if (str.startsWith("'") && str.endsWith("'")) {
            str = str.substring(1, str.length() - 1).replace("\\'", "'");
        }
        return str.replace("\\\n", "").replace("\\A", "\n");
    }

    private Box getDocumentDimensions(float f) {
        float fFloatValue;
        Length length = this.rootElement.width;
        Length length2 = this.rootElement.height;
        if (length == null || length.isZero() || length.unit == Unit.percent || length.unit == Unit.em || length.unit == Unit.ex) {
            return new Box(-1.0f, -1.0f, -1.0f, -1.0f);
        }
        float fFloatValue2 = length.floatValue(f);
        if (length2 != null) {
            if (length2.isZero() || length2.unit == Unit.percent || length2.unit == Unit.em || length2.unit == Unit.ex) {
                return new Box(-1.0f, -1.0f, -1.0f, -1.0f);
            }
            fFloatValue = length2.floatValue(f);
        } else {
            fFloatValue = this.rootElement.viewBox != null ? (this.rootElement.viewBox.height * fFloatValue2) / this.rootElement.viewBox.width : fFloatValue2;
        }
        return new Box(0.0f, 0.0f, fFloatValue2, fFloatValue);
    }

    void addCSSRules(CSSParser.Ruleset ruleset) {
        this.cssRules.addAll(ruleset);
    }

    List<CSSParser.Rule> getCSSRules() {
        return this.cssRules.getRules();
    }

    boolean hasCSSRules() {
        return !this.cssRules.isEmpty();
    }

    void clearRenderCSSRules() {
        this.cssRules.removeFromSource(CSSParser.Source.RenderOptions);
    }

    static class Box {
        float height;
        float minX;
        float minY;
        float width;

        Box(float f, float f2, float f3, float f4) {
            this.minX = f;
            this.minY = f2;
            this.width = f3;
            this.height = f4;
        }

        Box(Box box) {
            this.minX = box.minX;
            this.minY = box.minY;
            this.width = box.width;
            this.height = box.height;
        }

        static Box fromLimits(float f, float f2, float f3, float f4) {
            return new Box(f, f2, f3 - f, f4 - f2);
        }

        RectF toRectF() {
            return new RectF(this.minX, this.minY, maxX(), maxY());
        }

        float maxX() {
            return this.minX + this.width;
        }

        float maxY() {
            return this.minY + this.height;
        }

        void union(Box box) {
            float f = box.minX;
            if (f < this.minX) {
                this.minX = f;
            }
            float f2 = box.minY;
            if (f2 < this.minY) {
                this.minY = f2;
            }
            if (box.maxX() > maxX()) {
                this.width = box.maxX() - this.minX;
            }
            if (box.maxY() > maxY()) {
                this.height = box.maxY() - this.minY;
            }
        }

        public String toString() {
            return b9.i.d + this.minX + " " + this.minY + " " + this.width + " " + this.height + b9.i.e;
        }
    }

    public static class Colour extends SvgPaint {
        static final Colour BLACK = new Colour(ViewCompat.MEASURED_STATE_MASK);
        static final Colour TRANSPARENT = new Colour(0);
        final int colour;

        Colour(int i) {
            this.colour = i;
        }

        public String toString() {
            return String.format("#%08x", Integer.valueOf(this.colour));
        }
    }

    static class CurrentColor extends SvgPaint {
        private static final CurrentColor instance = new CurrentColor();

        private CurrentColor() {
        }

        static CurrentColor getInstance() {
            return instance;
        }
    }

    static class PaintReference extends SvgPaint {
        final SvgPaint fallback;
        final String href;

        PaintReference(String str, SvgPaint svgPaint) {
            this.href = str;
            this.fallback = svgPaint;
        }

        public String toString() {
            return this.href + " " + this.fallback;
        }
    }

    public static class Length implements Cloneable {
        final Unit unit;
        final float value;
        static final Length ZERO = new Length(0.0f);
        static final Length PERCENT_100 = new Length(100.0f, Unit.percent);

        public Length(float f, Unit unit) {
            this.value = f;
            this.unit = unit;
        }

        public Length(float f) {
            this.value = f;
            this.unit = Unit.px;
        }

        float floatValue() {
            return this.value;
        }

        float floatValueX(SVGAndroidRenderer sVGAndroidRenderer) {
            switch (AnonymousClass1.$SwitchMap$net$pubnative$lite$sdk$utils$svgparser$utils$SVGBase$Unit[this.unit.ordinal()]) {
                case 1:
                    return this.value * sVGAndroidRenderer.getCurrentFontSize();
                case 2:
                    return this.value * sVGAndroidRenderer.getCurrentFontXHeight();
                case 3:
                    return this.value * sVGAndroidRenderer.getDPI();
                case 4:
                    return (this.value * sVGAndroidRenderer.getDPI()) / 2.54f;
                case 5:
                    return (this.value * sVGAndroidRenderer.getDPI()) / 25.4f;
                case 6:
                    return (this.value * sVGAndroidRenderer.getDPI()) / 72.0f;
                case 7:
                    return (this.value * sVGAndroidRenderer.getDPI()) / 6.0f;
                case 8:
                    Box effectiveViewPortInUserUnits = sVGAndroidRenderer.getEffectiveViewPortInUserUnits();
                    if (effectiveViewPortInUserUnits == null) {
                        return this.value;
                    }
                    return (this.value * effectiveViewPortInUserUnits.width) / 100.0f;
                default:
                    return this.value;
            }
        }

        float floatValueY(SVGAndroidRenderer sVGAndroidRenderer) {
            if (this.unit == Unit.percent) {
                Box effectiveViewPortInUserUnits = sVGAndroidRenderer.getEffectiveViewPortInUserUnits();
                if (effectiveViewPortInUserUnits == null) {
                    return this.value;
                }
                return (this.value * effectiveViewPortInUserUnits.height) / 100.0f;
            }
            return floatValueX(sVGAndroidRenderer);
        }

        float floatValue(SVGAndroidRenderer sVGAndroidRenderer) {
            if (this.unit == Unit.percent) {
                Box effectiveViewPortInUserUnits = sVGAndroidRenderer.getEffectiveViewPortInUserUnits();
                if (effectiveViewPortInUserUnits == null) {
                    return this.value;
                }
                float f = effectiveViewPortInUserUnits.width;
                float f2 = effectiveViewPortInUserUnits.height;
                if (f == f2) {
                    return (this.value * f) / 100.0f;
                }
                return (this.value * ((float) (Math.sqrt((f * f) + (f2 * f2)) / SVGBase.SQRT2))) / 100.0f;
            }
            return floatValueX(sVGAndroidRenderer);
        }

        float floatValue(SVGAndroidRenderer sVGAndroidRenderer, float f) {
            if (this.unit == Unit.percent) {
                return (this.value * f) / 100.0f;
            }
            return floatValueX(sVGAndroidRenderer);
        }

        float floatValue(float f) {
            int i = AnonymousClass1.$SwitchMap$net$pubnative$lite$sdk$utils$svgparser$utils$SVGBase$Unit[this.unit.ordinal()];
            if (i == 3) {
                return this.value * f;
            }
            if (i == 4) {
                return (this.value * f) / 2.54f;
            }
            if (i == 5) {
                return (this.value * f) / 25.4f;
            }
            if (i == 6) {
                return (this.value * f) / 72.0f;
            }
            if (i == 7) {
                return (this.value * f) / 6.0f;
            }
            return this.value;
        }

        boolean isZero() {
            return this.value == 0.0f;
        }

        boolean isNegative() {
            return this.value < 0.0f;
        }

        public String toString() {
            return String.valueOf(this.value) + this.unit;
        }
    }

    /* JADX INFO: renamed from: net.pubnative.lite.sdk.utils.svgparser.utils.SVGBase$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$net$pubnative$lite$sdk$utils$svgparser$utils$SVGBase$Unit;

        static {
            int[] iArr = new int[Unit.values().length];
            $SwitchMap$net$pubnative$lite$sdk$utils$svgparser$utils$SVGBase$Unit = iArr;
            try {
                iArr[Unit.em.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$net$pubnative$lite$sdk$utils$svgparser$utils$SVGBase$Unit[Unit.ex.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$net$pubnative$lite$sdk$utils$svgparser$utils$SVGBase$Unit[Unit.in.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$net$pubnative$lite$sdk$utils$svgparser$utils$SVGBase$Unit[Unit.cm.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$net$pubnative$lite$sdk$utils$svgparser$utils$SVGBase$Unit[Unit.mm.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$net$pubnative$lite$sdk$utils$svgparser$utils$SVGBase$Unit[Unit.pt.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$net$pubnative$lite$sdk$utils$svgparser$utils$SVGBase$Unit[Unit.pc.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$net$pubnative$lite$sdk$utils$svgparser$utils$SVGBase$Unit[Unit.percent.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$net$pubnative$lite$sdk$utils$svgparser$utils$SVGBase$Unit[Unit.px.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
        }
    }

    public static class CSSClipRect {
        final Length bottom;
        final Length left;
        final Length right;
        final Length top;

        CSSClipRect(Length length, Length length2, Length length3, Length length4) {
            this.top = length;
            this.right = length2;
            this.bottom = length3;
            this.left = length4;
        }
    }

    public static class SvgObject {
        SVGBase document;
        SvgContainer parent;

        String getNodeName() {
            return "";
        }
    }

    static abstract class SvgElementBase extends SvgObject {
        String id = null;
        Boolean spacePreserve = null;
        Style baseStyle = null;
        Style style = null;
        List<String> classNames = null;

        SvgElementBase() {
        }

        public String toString() {
            return getNodeName();
        }
    }

    static abstract class SvgElement extends SvgElementBase {
        Box boundingBox = null;

        SvgElement() {
        }
    }

    static abstract class SvgConditionalElement extends SvgElement implements SvgConditional {
        Set<String> requiredFeatures = null;
        String requiredExtensions = null;
        Set<String> systemLanguage = null;
        Set<String> requiredFormats = null;
        Set<String> requiredFonts = null;

        SvgConditionalElement() {
        }

        @Override // net.pubnative.lite.sdk.utils.svgparser.utils.SVGBase.SvgConditional
        public void setRequiredFeatures(Set<String> set) {
            this.requiredFeatures = set;
        }

        @Override // net.pubnative.lite.sdk.utils.svgparser.utils.SVGBase.SvgConditional
        public Set<String> getRequiredFeatures() {
            return this.requiredFeatures;
        }

        @Override // net.pubnative.lite.sdk.utils.svgparser.utils.SVGBase.SvgConditional
        public void setRequiredExtensions(String str) {
            this.requiredExtensions = str;
        }

        @Override // net.pubnative.lite.sdk.utils.svgparser.utils.SVGBase.SvgConditional
        public String getRequiredExtensions() {
            return this.requiredExtensions;
        }

        @Override // net.pubnative.lite.sdk.utils.svgparser.utils.SVGBase.SvgConditional
        public void setSystemLanguage(Set<String> set) {
            this.systemLanguage = set;
        }

        @Override // net.pubnative.lite.sdk.utils.svgparser.utils.SVGBase.SvgConditional
        public Set<String> getSystemLanguage() {
            return this.systemLanguage;
        }

        @Override // net.pubnative.lite.sdk.utils.svgparser.utils.SVGBase.SvgConditional
        public void setRequiredFormats(Set<String> set) {
            this.requiredFormats = set;
        }

        @Override // net.pubnative.lite.sdk.utils.svgparser.utils.SVGBase.SvgConditional
        public Set<String> getRequiredFormats() {
            return this.requiredFormats;
        }

        @Override // net.pubnative.lite.sdk.utils.svgparser.utils.SVGBase.SvgConditional
        public void setRequiredFonts(Set<String> set) {
            this.requiredFonts = set;
        }

        @Override // net.pubnative.lite.sdk.utils.svgparser.utils.SVGBase.SvgConditional
        public Set<String> getRequiredFonts() {
            return this.requiredFonts;
        }
    }

    public static abstract class SvgConditionalContainer extends SvgElement implements SvgContainer, SvgConditional {
        List<SvgObject> children = new ArrayList();
        Set<String> requiredFeatures = null;
        String requiredExtensions = null;
        Set<String> systemLanguage = null;
        Set<String> requiredFormats = null;
        Set<String> requiredFonts = null;

        @Override // net.pubnative.lite.sdk.utils.svgparser.utils.SVGBase.SvgConditional
        public Set<String> getSystemLanguage() {
            return null;
        }

        @Override // net.pubnative.lite.sdk.utils.svgparser.utils.SVGBase.SvgElementBase
        public /* bridge */ /* synthetic */ String toString() {
            return super.toString();
        }

        @Override // net.pubnative.lite.sdk.utils.svgparser.utils.SVGBase.SvgContainer
        public List<SvgObject> getChildren() {
            return this.children;
        }

        @Override // net.pubnative.lite.sdk.utils.svgparser.utils.SVGBase.SvgContainer
        public void addChild(SvgObject svgObject) throws SVGParseException {
            this.children.add(svgObject);
        }

        @Override // net.pubnative.lite.sdk.utils.svgparser.utils.SVGBase.SvgConditional
        public void setRequiredFeatures(Set<String> set) {
            this.requiredFeatures = set;
        }

        @Override // net.pubnative.lite.sdk.utils.svgparser.utils.SVGBase.SvgConditional
        public Set<String> getRequiredFeatures() {
            return this.requiredFeatures;
        }

        @Override // net.pubnative.lite.sdk.utils.svgparser.utils.SVGBase.SvgConditional
        public void setRequiredExtensions(String str) {
            this.requiredExtensions = str;
        }

        @Override // net.pubnative.lite.sdk.utils.svgparser.utils.SVGBase.SvgConditional
        public String getRequiredExtensions() {
            return this.requiredExtensions;
        }

        @Override // net.pubnative.lite.sdk.utils.svgparser.utils.SVGBase.SvgConditional
        public void setSystemLanguage(Set<String> set) {
            this.systemLanguage = set;
        }

        @Override // net.pubnative.lite.sdk.utils.svgparser.utils.SVGBase.SvgConditional
        public void setRequiredFormats(Set<String> set) {
            this.requiredFormats = set;
        }

        @Override // net.pubnative.lite.sdk.utils.svgparser.utils.SVGBase.SvgConditional
        public Set<String> getRequiredFormats() {
            return this.requiredFormats;
        }

        @Override // net.pubnative.lite.sdk.utils.svgparser.utils.SVGBase.SvgConditional
        public void setRequiredFonts(Set<String> set) {
            this.requiredFonts = set;
        }

        @Override // net.pubnative.lite.sdk.utils.svgparser.utils.SVGBase.SvgConditional
        public Set<String> getRequiredFonts() {
            return this.requiredFonts;
        }
    }

    static abstract class SvgPreserveAspectRatioContainer extends SvgConditionalContainer {
        PreserveAspectRatio preserveAspectRatio = null;

        SvgPreserveAspectRatioContainer() {
        }
    }

    static abstract class SvgViewBoxContainer extends SvgPreserveAspectRatioContainer {
        Box viewBox;

        SvgViewBoxContainer() {
        }
    }

    public static class Svg extends SvgViewBoxContainer {
        Length height;
        public String version;
        Length width;
        Length x;
        Length y;

        @Override // net.pubnative.lite.sdk.utils.svgparser.utils.SVGBase.SvgObject
        String getNodeName() {
            return "svg";
        }
    }

    static class Group extends SvgConditionalContainer implements HasTransform {
        Matrix transform;

        Group() {
        }

        @Override // net.pubnative.lite.sdk.utils.svgparser.utils.SVGBase.HasTransform
        public void setTransform(Matrix matrix) {
            this.transform = matrix;
        }

        @Override // net.pubnative.lite.sdk.utils.svgparser.utils.SVGBase.SvgObject
        String getNodeName() {
            return "group";
        }
    }

    static class Defs extends Group implements NotDirectlyRendered {
        Defs() {
        }

        @Override // net.pubnative.lite.sdk.utils.svgparser.utils.SVGBase.Group, net.pubnative.lite.sdk.utils.svgparser.utils.SVGBase.SvgObject
        String getNodeName() {
            return "defs";
        }
    }

    static abstract class GraphicsElement extends SvgConditionalElement implements HasTransform {
        Matrix transform;

        GraphicsElement() {
        }

        @Override // net.pubnative.lite.sdk.utils.svgparser.utils.SVGBase.HasTransform
        public void setTransform(Matrix matrix) {
            this.transform = matrix;
        }
    }

    static class A extends Group {
        String href;

        A() {
        }

        @Override // net.pubnative.lite.sdk.utils.svgparser.utils.SVGBase.Group, net.pubnative.lite.sdk.utils.svgparser.utils.SVGBase.SvgObject
        String getNodeName() {
            return "a";
        }
    }

    static class Use extends Group {
        Length height;
        String href;
        Length width;
        Length x;
        Length y;

        Use() {
        }

        @Override // net.pubnative.lite.sdk.utils.svgparser.utils.SVGBase.Group, net.pubnative.lite.sdk.utils.svgparser.utils.SVGBase.SvgObject
        String getNodeName() {
            return "use";
        }
    }

    static class Path extends GraphicsElement {
        PathDefinition d;
        Float pathLength;

        Path() {
        }

        @Override // net.pubnative.lite.sdk.utils.svgparser.utils.SVGBase.SvgObject
        String getNodeName() {
            return "path";
        }
    }

    static class Rect extends GraphicsElement {
        Length height;
        Length rx;
        Length ry;
        Length width;
        Length x;
        Length y;

        Rect() {
        }

        @Override // net.pubnative.lite.sdk.utils.svgparser.utils.SVGBase.SvgObject
        String getNodeName() {
            return "rect";
        }
    }

    static class Circle extends GraphicsElement {
        Length cx;
        Length cy;
        Length r;

        Circle() {
        }

        @Override // net.pubnative.lite.sdk.utils.svgparser.utils.SVGBase.SvgObject
        String getNodeName() {
            return "circle";
        }
    }

    static class Ellipse extends GraphicsElement {
        Length cx;
        Length cy;
        Length rx;
        Length ry;

        Ellipse() {
        }

        @Override // net.pubnative.lite.sdk.utils.svgparser.utils.SVGBase.SvgObject
        String getNodeName() {
            return "ellipse";
        }
    }

    static class Line extends GraphicsElement {
        Length x1;
        Length x2;
        Length y1;
        Length y2;

        Line() {
        }

        @Override // net.pubnative.lite.sdk.utils.svgparser.utils.SVGBase.SvgObject
        String getNodeName() {
            return "line";
        }
    }

    static class PolyLine extends GraphicsElement {
        float[] points;

        PolyLine() {
        }

        @Override // net.pubnative.lite.sdk.utils.svgparser.utils.SVGBase.SvgObject
        String getNodeName() {
            return "polyline";
        }
    }

    static class Polygon extends PolyLine {
        Polygon() {
        }

        @Override // net.pubnative.lite.sdk.utils.svgparser.utils.SVGBase.PolyLine, net.pubnative.lite.sdk.utils.svgparser.utils.SVGBase.SvgObject
        String getNodeName() {
            return "polygon";
        }
    }

    public static abstract class TextContainer extends SvgConditionalContainer {
        @Override // net.pubnative.lite.sdk.utils.svgparser.utils.SVGBase.SvgConditionalContainer, net.pubnative.lite.sdk.utils.svgparser.utils.SVGBase.SvgContainer
        public void addChild(SvgObject svgObject) throws SVGParseException {
            if (svgObject instanceof TextChild) {
                this.children.add(svgObject);
                return;
            }
            throw new SVGParseException("Text content elements cannot contain " + svgObject + " elements.");
        }
    }

    static abstract class TextPositionedContainer extends TextContainer {
        List<Length> dx;
        List<Length> dy;
        List<Length> x;
        List<Length> y;

        TextPositionedContainer() {
        }
    }

    static class Text extends TextPositionedContainer implements TextRoot, HasTransform {
        Matrix transform;

        Text() {
        }

        @Override // net.pubnative.lite.sdk.utils.svgparser.utils.SVGBase.HasTransform
        public void setTransform(Matrix matrix) {
            this.transform = matrix;
        }

        @Override // net.pubnative.lite.sdk.utils.svgparser.utils.SVGBase.SvgObject
        String getNodeName() {
            return "text";
        }
    }

    static class TSpan extends TextPositionedContainer implements TextChild {
        private TextRoot textRoot;

        TSpan() {
        }

        @Override // net.pubnative.lite.sdk.utils.svgparser.utils.SVGBase.TextChild
        public void setTextRoot(TextRoot textRoot) {
            this.textRoot = textRoot;
        }

        @Override // net.pubnative.lite.sdk.utils.svgparser.utils.SVGBase.TextChild
        public TextRoot getTextRoot() {
            return this.textRoot;
        }

        @Override // net.pubnative.lite.sdk.utils.svgparser.utils.SVGBase.SvgObject
        String getNodeName() {
            return "tspan";
        }
    }

    public static class TextSequence extends SvgObject implements TextChild {
        String text;
        private TextRoot textRoot;

        public TextSequence(String str) {
            this.text = str;
        }

        public String toString() {
            return "TextChild: '" + this.text + "'";
        }

        @Override // net.pubnative.lite.sdk.utils.svgparser.utils.SVGBase.TextChild
        public void setTextRoot(TextRoot textRoot) {
            this.textRoot = textRoot;
        }

        @Override // net.pubnative.lite.sdk.utils.svgparser.utils.SVGBase.TextChild
        public TextRoot getTextRoot() {
            return this.textRoot;
        }
    }

    static class TRef extends TextContainer implements TextChild {
        String href;
        private TextRoot textRoot;

        TRef() {
        }

        @Override // net.pubnative.lite.sdk.utils.svgparser.utils.SVGBase.TextChild
        public void setTextRoot(TextRoot textRoot) {
            this.textRoot = textRoot;
        }

        @Override // net.pubnative.lite.sdk.utils.svgparser.utils.SVGBase.TextChild
        public TextRoot getTextRoot() {
            return this.textRoot;
        }

        @Override // net.pubnative.lite.sdk.utils.svgparser.utils.SVGBase.SvgObject
        String getNodeName() {
            return "tref";
        }
    }

    static class TextPath extends TextContainer implements TextChild {
        String href;
        Length startOffset;
        private TextRoot textRoot;

        TextPath() {
        }

        @Override // net.pubnative.lite.sdk.utils.svgparser.utils.SVGBase.TextChild
        public void setTextRoot(TextRoot textRoot) {
            this.textRoot = textRoot;
        }

        @Override // net.pubnative.lite.sdk.utils.svgparser.utils.SVGBase.TextChild
        public TextRoot getTextRoot() {
            return this.textRoot;
        }

        @Override // net.pubnative.lite.sdk.utils.svgparser.utils.SVGBase.SvgObject
        String getNodeName() {
            return "textPath";
        }
    }

    static class Switch extends Group {
        Switch() {
        }

        @Override // net.pubnative.lite.sdk.utils.svgparser.utils.SVGBase.Group, net.pubnative.lite.sdk.utils.svgparser.utils.SVGBase.SvgObject
        String getNodeName() {
            return "switch";
        }
    }

    static class Symbol extends SvgViewBoxContainer implements NotDirectlyRendered {
        Symbol() {
        }

        @Override // net.pubnative.lite.sdk.utils.svgparser.utils.SVGBase.SvgObject
        String getNodeName() {
            return "symbol";
        }
    }

    static class Marker extends SvgViewBoxContainer implements NotDirectlyRendered {
        Length markerHeight;
        boolean markerUnitsAreUser;
        Length markerWidth;
        Float orient;
        Length refX;
        Length refY;

        Marker() {
        }

        @Override // net.pubnative.lite.sdk.utils.svgparser.utils.SVGBase.SvgObject
        String getNodeName() {
            return "marker";
        }
    }

    static abstract class GradientElement extends SvgElementBase implements SvgContainer {
        List<SvgObject> children = new ArrayList();
        Matrix gradientTransform;
        Boolean gradientUnitsAreUser;
        String href;
        GradientSpread spreadMethod;

        GradientElement() {
        }

        @Override // net.pubnative.lite.sdk.utils.svgparser.utils.SVGBase.SvgContainer
        public List<SvgObject> getChildren() {
            return this.children;
        }

        @Override // net.pubnative.lite.sdk.utils.svgparser.utils.SVGBase.SvgContainer
        public void addChild(SvgObject svgObject) throws SVGParseException {
            if (svgObject instanceof Stop) {
                this.children.add(svgObject);
                return;
            }
            throw new SVGParseException("Gradient elements cannot contain " + svgObject + " elements.");
        }
    }

    static class Stop extends SvgElementBase implements SvgContainer {
        Float offset;

        @Override // net.pubnative.lite.sdk.utils.svgparser.utils.SVGBase.SvgContainer
        public void addChild(SvgObject svgObject) {
        }

        Stop() {
        }

        @Override // net.pubnative.lite.sdk.utils.svgparser.utils.SVGBase.SvgContainer
        public List<SvgObject> getChildren() {
            return Collections.emptyList();
        }

        @Override // net.pubnative.lite.sdk.utils.svgparser.utils.SVGBase.SvgObject
        String getNodeName() {
            return TimerController.STOP_COMMAND;
        }
    }

    static class SvgLinearGradient extends GradientElement {
        Length x1;
        Length x2;
        Length y1;
        Length y2;

        SvgLinearGradient() {
        }

        @Override // net.pubnative.lite.sdk.utils.svgparser.utils.SVGBase.SvgObject
        String getNodeName() {
            return "linearGradient";
        }
    }

    static class SvgRadialGradient extends GradientElement {
        Length cx;
        Length cy;
        Length fr;
        Length fx;
        Length fy;
        Length r;

        SvgRadialGradient() {
        }

        @Override // net.pubnative.lite.sdk.utils.svgparser.utils.SVGBase.SvgObject
        String getNodeName() {
            return "radialGradient";
        }
    }

    static class ClipPath extends Group implements NotDirectlyRendered {
        static final String NODE_NAME = "clipPath";
        Boolean clipPathUnitsAreUser;

        ClipPath() {
        }

        @Override // net.pubnative.lite.sdk.utils.svgparser.utils.SVGBase.Group, net.pubnative.lite.sdk.utils.svgparser.utils.SVGBase.SvgObject
        String getNodeName() {
            return NODE_NAME;
        }
    }

    static class Pattern extends SvgViewBoxContainer implements NotDirectlyRendered {
        Length height;
        String href;
        Boolean patternContentUnitsAreUser;
        Matrix patternTransform;
        Boolean patternUnitsAreUser;
        Length width;
        Length x;
        Length y;

        Pattern() {
        }

        @Override // net.pubnative.lite.sdk.utils.svgparser.utils.SVGBase.SvgObject
        String getNodeName() {
            return "pattern";
        }
    }

    static class Image extends SvgPreserveAspectRatioContainer implements HasTransform {
        Length height;
        String href;
        Matrix transform;
        Length width;
        Length x;
        Length y;

        Image() {
        }

        @Override // net.pubnative.lite.sdk.utils.svgparser.utils.SVGBase.HasTransform
        public void setTransform(Matrix matrix) {
            this.transform = matrix;
        }

        @Override // net.pubnative.lite.sdk.utils.svgparser.utils.SVGBase.SvgObject
        String getNodeName() {
            return "image";
        }
    }

    static class View extends SvgViewBoxContainer implements NotDirectlyRendered {
        static final String NODE_NAME = "view";

        View() {
        }

        @Override // net.pubnative.lite.sdk.utils.svgparser.utils.SVGBase.SvgObject
        String getNodeName() {
            return "view";
        }
    }

    static class Mask extends SvgConditionalContainer implements NotDirectlyRendered {
        Length height;
        Boolean maskContentUnitsAreUser;
        Boolean maskUnitsAreUser;
        Length width;
        Length x;
        Length y;

        Mask() {
        }

        @Override // net.pubnative.lite.sdk.utils.svgparser.utils.SVGBase.SvgObject
        String getNodeName() {
            return "mask";
        }
    }

    static class SolidColor extends SvgElementBase implements SvgContainer {
        @Override // net.pubnative.lite.sdk.utils.svgparser.utils.SVGBase.SvgContainer
        public void addChild(SvgObject svgObject) {
        }

        SolidColor() {
        }

        @Override // net.pubnative.lite.sdk.utils.svgparser.utils.SVGBase.SvgContainer
        public List<SvgObject> getChildren() {
            return Collections.emptyList();
        }

        @Override // net.pubnative.lite.sdk.utils.svgparser.utils.SVGBase.SvgObject
        String getNodeName() {
            return "solidColor";
        }
    }

    void setTitle(String str) {
        this.title = str;
    }

    void setDesc(String str) {
        this.desc = str;
    }

    static class PathDefinition implements PathInterface {
        private static final byte ARCTO = 4;
        private static final byte CLOSE = 8;
        private static final byte CUBICTO = 2;
        private static final byte LINETO = 1;
        private static final byte MOVETO = 0;
        private static final byte QUADTO = 3;
        private int commandsLength = 0;
        private int coordsLength = 0;
        private byte[] commands = new byte[8];
        private float[] coords = new float[16];

        PathDefinition() {
        }

        boolean isEmpty() {
            return this.commandsLength == 0;
        }

        private void addCommand(byte b) {
            int i = this.commandsLength;
            byte[] bArr = this.commands;
            if (i == bArr.length) {
                byte[] bArr2 = new byte[bArr.length * 2];
                System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
                this.commands = bArr2;
            }
            byte[] bArr3 = this.commands;
            int i2 = this.commandsLength;
            this.commandsLength = i2 + 1;
            bArr3[i2] = b;
        }

        private void coordsEnsure(int i) {
            float[] fArr = this.coords;
            if (fArr.length < this.coordsLength + i) {
                float[] fArr2 = new float[fArr.length * 2];
                System.arraycopy(fArr, 0, fArr2, 0, fArr.length);
                this.coords = fArr2;
            }
        }

        @Override // net.pubnative.lite.sdk.utils.svgparser.utils.SVGBase.PathInterface
        public void moveTo(float f, float f2) {
            addCommand((byte) 0);
            coordsEnsure(2);
            float[] fArr = this.coords;
            int i = this.coordsLength;
            int i2 = i + 1;
            this.coordsLength = i2;
            fArr[i] = f;
            this.coordsLength = i + 2;
            fArr[i2] = f2;
        }

        @Override // net.pubnative.lite.sdk.utils.svgparser.utils.SVGBase.PathInterface
        public void lineTo(float f, float f2) {
            addCommand((byte) 1);
            coordsEnsure(2);
            float[] fArr = this.coords;
            int i = this.coordsLength;
            int i2 = i + 1;
            this.coordsLength = i2;
            fArr[i] = f;
            this.coordsLength = i + 2;
            fArr[i2] = f2;
        }

        @Override // net.pubnative.lite.sdk.utils.svgparser.utils.SVGBase.PathInterface
        public void cubicTo(float f, float f2, float f3, float f4, float f5, float f6) {
            addCommand((byte) 2);
            coordsEnsure(6);
            float[] fArr = this.coords;
            int i = this.coordsLength;
            int i2 = i + 1;
            this.coordsLength = i2;
            fArr[i] = f;
            int i3 = i + 2;
            this.coordsLength = i3;
            fArr[i2] = f2;
            int i4 = i + 3;
            this.coordsLength = i4;
            fArr[i3] = f3;
            int i5 = i + 4;
            this.coordsLength = i5;
            fArr[i4] = f4;
            int i6 = i + 5;
            this.coordsLength = i6;
            fArr[i5] = f5;
            this.coordsLength = i + 6;
            fArr[i6] = f6;
        }

        @Override // net.pubnative.lite.sdk.utils.svgparser.utils.SVGBase.PathInterface
        public void quadTo(float f, float f2, float f3, float f4) {
            addCommand((byte) 3);
            coordsEnsure(4);
            float[] fArr = this.coords;
            int i = this.coordsLength;
            int i2 = i + 1;
            this.coordsLength = i2;
            fArr[i] = f;
            int i3 = i + 2;
            this.coordsLength = i3;
            fArr[i2] = f2;
            int i4 = i + 3;
            this.coordsLength = i4;
            fArr[i3] = f3;
            this.coordsLength = i + 4;
            fArr[i4] = f4;
        }

        @Override // net.pubnative.lite.sdk.utils.svgparser.utils.SVGBase.PathInterface
        public void arcTo(float f, float f2, float f3, boolean z, boolean z2, float f4, float f5) {
            addCommand((byte) ((z ? 2 : 0) | 4 | (z2 ? 1 : 0)));
            coordsEnsure(5);
            float[] fArr = this.coords;
            int i = this.coordsLength;
            int i2 = i + 1;
            this.coordsLength = i2;
            fArr[i] = f;
            int i3 = i + 2;
            this.coordsLength = i3;
            fArr[i2] = f2;
            int i4 = i + 3;
            this.coordsLength = i4;
            fArr[i3] = f3;
            int i5 = i + 4;
            this.coordsLength = i5;
            fArr[i4] = f4;
            this.coordsLength = i + 5;
            fArr[i5] = f5;
        }

        @Override // net.pubnative.lite.sdk.utils.svgparser.utils.SVGBase.PathInterface
        public void close() {
            addCommand((byte) 8);
        }

        void enumeratePath(PathInterface pathInterface) {
            int i = 0;
            for (int i2 = 0; i2 < this.commandsLength; i2++) {
                byte b = this.commands[i2];
                if (b == 0) {
                    float[] fArr = this.coords;
                    int i3 = i + 1;
                    float f = fArr[i];
                    i += 2;
                    pathInterface.moveTo(f, fArr[i3]);
                } else if (b == 1) {
                    float[] fArr2 = this.coords;
                    int i4 = i + 1;
                    float f2 = fArr2[i];
                    i += 2;
                    pathInterface.lineTo(f2, fArr2[i4]);
                } else if (b == 2) {
                    float[] fArr3 = this.coords;
                    float f3 = fArr3[i];
                    float f4 = fArr3[i + 1];
                    float f5 = fArr3[i + 2];
                    float f6 = fArr3[i + 3];
                    int i5 = i + 5;
                    float f7 = fArr3[i + 4];
                    i += 6;
                    pathInterface.cubicTo(f3, f4, f5, f6, f7, fArr3[i5]);
                } else if (b == 3) {
                    float[] fArr4 = this.coords;
                    float f8 = fArr4[i];
                    float f9 = fArr4[i + 1];
                    int i6 = i + 3;
                    float f10 = fArr4[i + 2];
                    i += 4;
                    pathInterface.quadTo(f8, f9, f10, fArr4[i6]);
                } else if (b == 8) {
                    pathInterface.close();
                } else {
                    boolean z = (b & 2) != 0;
                    boolean z2 = (b & 1) != 0;
                    float[] fArr5 = this.coords;
                    float f11 = fArr5[i];
                    float f12 = fArr5[i + 1];
                    float f13 = fArr5[i + 2];
                    int i7 = i + 4;
                    float f14 = fArr5[i + 3];
                    i += 5;
                    pathInterface.arcTo(f11, f12, f13, z, z2, f14, fArr5[i7]);
                }
            }
        }
    }

    SvgElementBase getElementById(String str) {
        if (str == null || str.length() == 0) {
            return null;
        }
        if (str.equals(this.rootElement.id)) {
            return this.rootElement;
        }
        if (this.idToElementMap.containsKey(str)) {
            return this.idToElementMap.get(str);
        }
        SvgElementBase elementById = getElementById(this.rootElement, str);
        this.idToElementMap.put(str, elementById);
        return elementById;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private SvgElementBase getElementById(SvgContainer svgContainer, String str) {
        SvgElementBase elementById;
        SvgElementBase svgElementBase = (SvgElementBase) svgContainer;
        if (str.equals(svgElementBase.id)) {
            return svgElementBase;
        }
        for (Object obj : svgContainer.getChildren()) {
            if (obj instanceof SvgElementBase) {
                SvgElementBase svgElementBase2 = (SvgElementBase) obj;
                if (str.equals(svgElementBase2.id)) {
                    return svgElementBase2;
                }
                if ((obj instanceof SvgContainer) && (elementById = getElementById((SvgContainer) obj, str)) != null) {
                    return elementById;
                }
            }
        }
        return null;
    }

    private List<SvgObject> getElementsByTagName(String str) {
        ArrayList arrayList = new ArrayList();
        getElementsByTagName(arrayList, this.rootElement, str);
        return arrayList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void getElementsByTagName(List<SvgObject> list, SvgObject svgObject, String str) {
        if (svgObject.getNodeName().equals(str)) {
            list.add(svgObject);
        }
        if (svgObject instanceof SvgContainer) {
            Iterator<SvgObject> it = ((SvgContainer) svgObject).getChildren().iterator();
            while (it.hasNext()) {
                getElementsByTagName(list, it.next(), str);
            }
        }
    }
}
