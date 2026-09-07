package net.pubnative.lite.sdk.utils.svgparser.utils;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BlendMode;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.DashPathEffect;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.Typeface;
import android.os.Build;
import android.support.v4.media.session.PlaybackStateCompat;
import android.util.Base64;
import android.util.Log;
import androidx.core.view.ViewCompat;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.Stack;
import java.util.regex.Pattern;
import net.pubnative.lite.sdk.utils.svgparser.PreserveAspectRatio;
import net.pubnative.lite.sdk.utils.svgparser.SVGExternalFileResolver;

/* JADX INFO: loaded from: classes2.dex */
public class SVGAndroidRenderer {
    private static final float BEZIER_ARC_FACTOR = 0.5522848f;
    private static final String DEFAULT_FONT_FAMILY = "serif";
    public static final float LUMINANCE_TO_ALPHA_BLUE = 0.0722f;
    public static final float LUMINANCE_TO_ALPHA_GREEN = 0.7151f;
    public static final float LUMINANCE_TO_ALPHA_RED = 0.2127f;
    private static final Pattern PATTERN_DOUBLE_SPACES;
    private static final Pattern PATTERN_END_SPACES;
    private static final Pattern PATTERN_LINE_BREAKS;
    private static final Pattern PATTERN_START_SPACES;
    private static final Pattern PATTERN_TABS;
    private static final Pattern PATTERN_TABS_OR_LINE_BREAKS;
    private static final boolean SUPPORTS_BLEND_MODE;
    private static final boolean SUPPORTS_PAINT_FONT_VARIATION_SETTINGS;
    private static final boolean SUPPORTS_PAINT_WORD_SPACING;
    private static final boolean SUPPORTS_RADIAL_GRADIENT_WITH_FOCUS;
    private static final boolean SUPPORTS_SAVE_LAYER_FLAGLESS;
    private static final String TAG = "SVGAndroidRenderer";
    private static HashSet<String> supportedFeatures;
    private final Canvas canvas;
    private SVGBase document;
    private final float dpi;
    private SVGExternalFileResolver externalFileResolver;
    private Stack<Matrix> matrixStack;
    private Stack<SVGBase.SvgContainer> parentStack;
    private CSSParser.RuleMatchContext ruleMatchContext = null;
    private RendererState state;
    private Stack<RendererState> stateStack;
    private static final boolean SUPPORTS_FONT_HINTING = true;
    private static final boolean SUPPORTS_STROKED_UNDERLINES = true;
    private static final boolean SUPPORTS_PATH_OP = true;
    private static final boolean SUPPORTS_PAINT_FONT_FEATURE_SETTINGS = true;
    private static final boolean SUPPORTS_PAINT_LETTER_SPACING = true;

    /* JADX INFO: Access modifiers changed from: private */
    public static void debug(String str, Object... objArr) {
    }

    private float dotProduct(float f, float f2, float f3, float f4) {
        return (f * f3) + (f2 * f4);
    }

    static {
        SUPPORTS_PAINT_FONT_VARIATION_SETTINGS = Build.VERSION.SDK_INT >= 26;
        SUPPORTS_BLEND_MODE = Build.VERSION.SDK_INT >= 29;
        SUPPORTS_PAINT_WORD_SPACING = Build.VERSION.SDK_INT >= 29;
        SUPPORTS_SAVE_LAYER_FLAGLESS = true;
        SUPPORTS_RADIAL_GRADIENT_WITH_FOCUS = Build.VERSION.SDK_INT >= 31;
        PATTERN_TABS_OR_LINE_BREAKS = Pattern.compile("[\\n\\t]");
        PATTERN_TABS = Pattern.compile("\\t");
        PATTERN_LINE_BREAKS = Pattern.compile("\\n");
        PATTERN_START_SPACES = Pattern.compile("^\\s+");
        PATTERN_END_SPACES = Pattern.compile("\\s+$");
        PATTERN_DOUBLE_SPACES = Pattern.compile("\\s{2,}");
        supportedFeatures = null;
    }

    public static class RendererState {
        final Paint fillPaint;
        final CSSFontFeatureSettings fontFeatureSet;
        final CSSFontVariationSettings fontVariationSet;
        boolean hasFill;
        boolean hasStroke;
        boolean spacePreserve;
        final Paint strokePaint;
        Style style;
        SVGBase.Box viewBox;
        SVGBase.Box viewPort;

        RendererState() {
            Paint paint = new Paint();
            this.fillPaint = paint;
            paint.setFlags(193);
            if (SVGAndroidRenderer.SUPPORTS_FONT_HINTING) {
                paint.setHinting(0);
            }
            paint.setStyle(Paint.Style.FILL);
            paint.setTypeface(Typeface.DEFAULT);
            Paint paint2 = new Paint();
            this.strokePaint = paint2;
            paint2.setFlags(193);
            if (SVGAndroidRenderer.SUPPORTS_FONT_HINTING) {
                paint2.setHinting(0);
            }
            paint2.setStyle(Paint.Style.STROKE);
            paint2.setTypeface(Typeface.DEFAULT);
            this.fontFeatureSet = new CSSFontFeatureSettings();
            this.fontVariationSet = new CSSFontVariationSettings();
            this.style = Style.getDefaultStyle();
        }

        RendererState(RendererState rendererState) {
            this.hasFill = rendererState.hasFill;
            this.hasStroke = rendererState.hasStroke;
            this.fillPaint = new Paint(rendererState.fillPaint);
            this.strokePaint = new Paint(rendererState.strokePaint);
            if (rendererState.viewPort != null) {
                this.viewPort = new SVGBase.Box(rendererState.viewPort);
            }
            if (rendererState.viewBox != null) {
                this.viewBox = new SVGBase.Box(rendererState.viewBox);
            }
            this.spacePreserve = rendererState.spacePreserve;
            this.fontFeatureSet = new CSSFontFeatureSettings(rendererState.fontFeatureSet);
            this.fontVariationSet = new CSSFontVariationSettings(rendererState.fontVariationSet);
            try {
                this.style = (Style) rendererState.style.clone();
            } catch (CloneNotSupportedException e) {
                Log.e(SVGAndroidRenderer.TAG, "Unexpected clone error", e);
                this.style = Style.getDefaultStyle();
            }
        }
    }

    private void resetState() {
        this.state = new RendererState();
        this.stateStack = new Stack<>();
        updateStyle(this.state, Style.getDefaultStyle());
        this.state.viewPort = null;
        this.state.spacePreserve = false;
        this.stateStack.push(new RendererState(this.state));
        this.matrixStack = new Stack<>();
        this.parentStack = new Stack<>();
    }

    SVGAndroidRenderer(Canvas canvas, float f, SVGExternalFileResolver sVGExternalFileResolver) {
        this.canvas = canvas;
        this.dpi = f;
        this.externalFileResolver = sVGExternalFileResolver;
    }

    float getDPI() {
        return this.dpi;
    }

    float getCurrentFontSize() {
        return this.state.fillPaint.getTextSize();
    }

    float getCurrentFontXHeight() {
        return this.state.fillPaint.getTextSize() / 2.0f;
    }

    SVGBase.Box getEffectiveViewPortInUserUnits() {
        if (this.state.viewBox != null) {
            return this.state.viewBox;
        }
        return this.state.viewPort;
    }

    void renderDocument(SVGBase sVGBase, RenderOptionsBase renderOptionsBase) {
        SVGBase.Box box;
        PreserveAspectRatio preserveAspectRatio;
        if (renderOptionsBase == null) {
            throw new NullPointerException("renderOptions shouldn't be null");
        }
        this.document = sVGBase;
        SVGBase.Svg rootElement = sVGBase.getRootElement();
        if (rootElement == null) {
            warn("Nothing to render. Document is empty.", new Object[0]);
            return;
        }
        if (renderOptionsBase.hasView()) {
            SVGBase.SvgElementBase elementById = this.document.getElementById(renderOptionsBase.viewId);
            if (!(elementById instanceof SVGBase.View)) {
                Log.w(TAG, String.format("View element with id \"%s\" not found.", renderOptionsBase.viewId));
                return;
            }
            SVGBase.View view = (SVGBase.View) elementById;
            if (view.viewBox == null) {
                Log.w(TAG, String.format("View element with id \"%s\" is missing a viewBox attribute.", renderOptionsBase.viewId));
                return;
            } else {
                box = view.viewBox;
                preserveAspectRatio = view.preserveAspectRatio;
            }
        } else {
            box = renderOptionsBase.hasViewBox() ? renderOptionsBase.viewBox : rootElement.viewBox;
            preserveAspectRatio = renderOptionsBase.hasPreserveAspectRatio() ? renderOptionsBase.preserveAspectRatio : rootElement.preserveAspectRatio;
        }
        if (renderOptionsBase.hasCss()) {
            if (renderOptionsBase.css != null) {
                sVGBase.addCSSRules(new CSSParser(CSSParser.Source.RenderOptions, this.externalFileResolver).parse(renderOptionsBase.css));
            } else if (renderOptionsBase.cssRuleset != null) {
                sVGBase.addCSSRules(renderOptionsBase.cssRuleset);
            }
        }
        if (renderOptionsBase.hasTarget()) {
            CSSParser.RuleMatchContext ruleMatchContext = new CSSParser.RuleMatchContext();
            this.ruleMatchContext = ruleMatchContext;
            ruleMatchContext.targetElement = sVGBase.getElementById(renderOptionsBase.targetId);
        }
        resetState();
        checkXMLSpaceAttribute(rootElement);
        statePush(true);
        SVGBase.Box box2 = new SVGBase.Box(renderOptionsBase.viewPort);
        if (rootElement.width != null) {
            box2.width = rootElement.width.floatValue(this, box2.width);
        }
        if (rootElement.height != null) {
            box2.height = rootElement.height.floatValue(this, box2.height);
        }
        render(rootElement, box2, box, preserveAspectRatio);
        statePop();
        if (renderOptionsBase.hasCss()) {
            sVGBase.clearRenderCSSRules();
        }
    }

    private void render(SVGBase.SvgObject svgObject) {
        if (svgObject instanceof SVGBase.NotDirectlyRendered) {
            return;
        }
        statePush();
        checkXMLSpaceAttribute(svgObject);
        if (svgObject instanceof SVGBase.Svg) {
            render((SVGBase.Svg) svgObject);
        } else if (svgObject instanceof SVGBase.Use) {
            render((SVGBase.Use) svgObject);
        } else if (svgObject instanceof SVGBase.Switch) {
            render((SVGBase.Switch) svgObject);
        } else if (svgObject instanceof SVGBase.Group) {
            render((SVGBase.Group) svgObject);
        } else if (svgObject instanceof SVGBase.Image) {
            render((SVGBase.Image) svgObject);
        } else if (svgObject instanceof SVGBase.Path) {
            render((SVGBase.Path) svgObject);
        } else if (svgObject instanceof SVGBase.Rect) {
            render((SVGBase.Rect) svgObject);
        } else if (svgObject instanceof SVGBase.Circle) {
            render((SVGBase.Circle) svgObject);
        } else if (svgObject instanceof SVGBase.Ellipse) {
            render((SVGBase.Ellipse) svgObject);
        } else if (svgObject instanceof SVGBase.Line) {
            render((SVGBase.Line) svgObject);
        } else if (svgObject instanceof SVGBase.Polygon) {
            render((SVGBase.Polygon) svgObject);
        } else if (svgObject instanceof SVGBase.PolyLine) {
            render((SVGBase.PolyLine) svgObject);
        } else if (svgObject instanceof SVGBase.Text) {
            render((SVGBase.Text) svgObject);
        }
        statePop();
    }

    private void renderChildren(SVGBase.SvgContainer svgContainer, boolean z) {
        if (z) {
            parentPush(svgContainer);
        }
        Iterator<SVGBase.SvgObject> it = svgContainer.getChildren().iterator();
        while (it.hasNext()) {
            render(it.next());
        }
        if (z) {
            parentPop();
        }
    }

    private void statePush() {
        statePush(false);
    }

    private void statePush(boolean z) {
        if (z) {
            canvasSaveLayer(this.canvas, null, null);
        } else {
            this.canvas.save();
        }
        this.stateStack.push(this.state);
        this.state = new RendererState(this.state);
    }

    private void statePop() {
        this.canvas.restore();
        this.state = this.stateStack.pop();
    }

    private void canvasSaveLayer(Canvas canvas, RectF rectF, Paint paint) {
        if (SUPPORTS_SAVE_LAYER_FLAGLESS) {
            canvas.saveLayer(rectF, paint);
        } else {
            CanvasLegacy.saveLayer(canvas, rectF, paint, CanvasLegacy.ALL_SAVE_FLAG);
        }
    }

    private void parentPush(SVGBase.SvgContainer svgContainer) {
        this.parentStack.push(svgContainer);
        this.matrixStack.push(this.canvas.getMatrix());
    }

    private void parentPop() {
        this.parentStack.pop();
        this.matrixStack.pop();
    }

    private void updateStyleForElement(RendererState rendererState, SVGBase.SvgElementBase svgElementBase) {
        rendererState.style.resetNonInheritingProperties(svgElementBase.parent == null);
        if (svgElementBase.baseStyle != null) {
            updateStyle(rendererState, svgElementBase.baseStyle);
        }
        if (this.document.hasCSSRules()) {
            for (CSSParser.Rule rule : this.document.getCSSRules()) {
                if (CSSParser.ruleMatch(this.ruleMatchContext, rule.selector, svgElementBase)) {
                    updateStyle(rendererState, rule.style);
                }
            }
        }
        if (svgElementBase.style != null) {
            updateStyle(rendererState, svgElementBase.style);
        }
    }

    private void checkXMLSpaceAttribute(SVGBase.SvgObject svgObject) {
        if (svgObject instanceof SVGBase.SvgElementBase) {
            SVGBase.SvgElementBase svgElementBase = (SVGBase.SvgElementBase) svgObject;
            if (svgElementBase.spacePreserve != null) {
                this.state.spacePreserve = svgElementBase.spacePreserve.booleanValue();
            }
        }
    }

    private void doFilledPath(SVGBase.SvgElement svgElement, Path path) {
        if (this.state.style.fill instanceof SVGBase.PaintReference) {
            SVGBase.SvgObject svgObjectResolveIRI = this.document.resolveIRI(((SVGBase.PaintReference) this.state.style.fill).href);
            if (svgObjectResolveIRI instanceof SVGBase.Pattern) {
                fillWithPattern(svgElement, path, (SVGBase.Pattern) svgObjectResolveIRI);
                return;
            }
        }
        this.canvas.drawPath(path, this.state.fillPaint);
    }

    private void doStroke(Path path) {
        if (this.state.style.vectorEffect == Style.VectorEffect.NonScalingStroke) {
            Matrix matrix = this.canvas.getMatrix();
            Path path2 = new Path();
            path.transform(matrix, path2);
            this.canvas.setMatrix(new Matrix());
            Shader shader = this.state.strokePaint.getShader();
            Matrix matrix2 = new Matrix();
            if (shader != null) {
                shader.getLocalMatrix(matrix2);
                Matrix matrix3 = new Matrix(matrix2);
                matrix3.postConcat(matrix);
                shader.setLocalMatrix(matrix3);
            }
            this.canvas.drawPath(path2, this.state.strokePaint);
            this.canvas.setMatrix(matrix);
            if (shader != null) {
                shader.setLocalMatrix(matrix2);
                return;
            }
            return;
        }
        this.canvas.drawPath(path, this.state.strokePaint);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void warn(String str, Object... objArr) {
        Log.w(TAG, String.format(str, objArr));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void error(String str, Object... objArr) {
        Log.e(TAG, String.format(str, objArr));
    }

    private void render(SVGBase.Svg svg) {
        render(svg, makeViewPort(svg.x, svg.y, svg.width, svg.height), svg.viewBox, svg.preserveAspectRatio);
    }

    private void render(SVGBase.Svg svg, SVGBase.Box box) {
        render(svg, box, svg.viewBox, svg.preserveAspectRatio);
    }

    private void render(SVGBase.Svg svg, SVGBase.Box box, SVGBase.Box box2, PreserveAspectRatio preserveAspectRatio) {
        debug("Svg render", new Object[0]);
        if (box.width == 0.0f || box.height == 0.0f) {
            return;
        }
        if (preserveAspectRatio == null) {
            preserveAspectRatio = svg.preserveAspectRatio != null ? svg.preserveAspectRatio : PreserveAspectRatio.LETTERBOX;
        }
        updateStyleForElement(this.state, svg);
        if (display()) {
            this.state.viewPort = box;
            if (!this.state.style.overflow.booleanValue()) {
                setClipRect(this.state.viewPort.minX, this.state.viewPort.minY, this.state.viewPort.width, this.state.viewPort.height);
            }
            checkForClipPath(svg, this.state.viewPort);
            if (box2 != null) {
                this.canvas.concat(calculateViewBoxTransform(this.state.viewPort, box2, preserveAspectRatio));
                this.state.viewBox = svg.viewBox;
            } else {
                this.canvas.translate(this.state.viewPort.minX, this.state.viewPort.minY);
                this.state.viewBox = null;
            }
            boolean zPushLayer = pushLayer();
            viewportFill();
            renderChildren(svg, true);
            if (zPushLayer) {
                popLayer(svg);
            }
            updateParentBoundingBox(svg);
        }
    }

    private SVGBase.Box makeViewPort(SVGBase.Length length, SVGBase.Length length2, SVGBase.Length length3, SVGBase.Length length4) {
        float fFloatValueX = length != null ? length.floatValueX(this) : 0.0f;
        float fFloatValueY = length2 != null ? length2.floatValueY(this) : 0.0f;
        SVGBase.Box effectiveViewPortInUserUnits = getEffectiveViewPortInUserUnits();
        return new SVGBase.Box(fFloatValueX, fFloatValueY, length3 != null ? length3.floatValueX(this) : effectiveViewPortInUserUnits.width, length4 != null ? length4.floatValueY(this) : effectiveViewPortInUserUnits.height);
    }

    private void render(SVGBase.Group group) {
        debug(group.getNodeName() + " render", new Object[0]);
        updateStyleForElement(this.state, group);
        if (display()) {
            if (group.transform != null) {
                this.canvas.concat(group.transform);
            }
            checkForClipPath(group);
            boolean zPushLayer = pushLayer();
            renderChildren(group, true);
            if (zPushLayer) {
                popLayer(group);
            }
            updateParentBoundingBox(group);
        }
    }

    private void updateParentBoundingBox(SVGBase.SvgElement svgElement) {
        if (svgElement.parent == null || svgElement.boundingBox == null) {
            return;
        }
        Matrix matrix = new Matrix();
        if (this.matrixStack.peek().invert(matrix)) {
            float[] fArr = {svgElement.boundingBox.minX, svgElement.boundingBox.minY, svgElement.boundingBox.maxX(), svgElement.boundingBox.minY, svgElement.boundingBox.maxX(), svgElement.boundingBox.maxY(), svgElement.boundingBox.minX, svgElement.boundingBox.maxY()};
            matrix.preConcat(this.canvas.getMatrix());
            matrix.mapPoints(fArr);
            float f = fArr[0];
            float f2 = fArr[1];
            RectF rectF = new RectF(f, f2, f, f2);
            for (int i = 2; i <= 6; i += 2) {
                if (fArr[i] < rectF.left) {
                    rectF.left = fArr[i];
                }
                if (fArr[i] > rectF.right) {
                    rectF.right = fArr[i];
                }
                int i2 = i + 1;
                if (fArr[i2] < rectF.top) {
                    rectF.top = fArr[i2];
                }
                if (fArr[i2] > rectF.bottom) {
                    rectF.bottom = fArr[i2];
                }
            }
            SVGBase.SvgElement svgElement2 = (SVGBase.SvgElement) this.parentStack.peek();
            if (svgElement2.boundingBox == null) {
                svgElement2.boundingBox = SVGBase.Box.fromLimits(rectF.left, rectF.top, rectF.right, rectF.bottom);
            } else {
                svgElement2.boundingBox.union(SVGBase.Box.fromLimits(rectF.left, rectF.top, rectF.right, rectF.bottom));
            }
        }
    }

    private boolean pushLayer() {
        return pushLayer(1.0f);
    }

    private boolean pushLayer(float f) {
        if (!requiresCompositing() && f == 1.0f) {
            return false;
        }
        Paint paint = new Paint();
        paint.setAlpha(clamp255(this.state.style.opacity.floatValue() * f));
        if (SUPPORTS_BLEND_MODE && this.state.style.mixBlendMode != Style.CSSBlendMode.normal) {
            setBlendMode(paint);
        }
        canvasSaveLayer(this.canvas, null, paint);
        this.stateStack.push(this.state);
        RendererState rendererState = new RendererState(this.state);
        this.state = rendererState;
        if (rendererState.style.mask != null && !(this.document.resolveIRI(this.state.style.mask) instanceof SVGBase.Mask)) {
            error("Mask reference '%s' not found", this.state.style.mask);
            this.state.style.mask = null;
        }
        return true;
    }

    private void popLayer(SVGBase.SvgElement svgElement) {
        popLayer(svgElement, svgElement.boundingBox);
    }

    private void popLayer(SVGBase.SvgElement svgElement, SVGBase.Box box) {
        if (this.state.style.mask != null) {
            Paint paint = new Paint();
            paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
            canvasSaveLayer(this.canvas, null, paint);
            Paint paint2 = new Paint();
            paint2.setColorFilter(new ColorMatrixColorFilter(new ColorMatrix(new float[]{0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.2127f, 0.7151f, 0.0722f, 0.0f, 0.0f})));
            canvasSaveLayer(this.canvas, null, paint2);
            SVGBase.Mask mask = (SVGBase.Mask) this.document.resolveIRI(this.state.style.mask);
            renderMask(mask, svgElement, box);
            this.canvas.restore();
            Paint paint3 = new Paint();
            paint3.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
            canvasSaveLayer(this.canvas, null, paint3);
            renderMask(mask, svgElement, box);
            this.canvas.restore();
            this.canvas.restore();
        }
        statePop();
    }

    private boolean requiresCompositing() {
        return this.state.style.opacity.floatValue() < 1.0f || this.state.style.mask != null || this.state.style.isolation == Style.Isolation.isolate || (SUPPORTS_BLEND_MODE && this.state.style.mixBlendMode != Style.CSSBlendMode.normal);
    }

    private void setBlendMode(Paint paint) {
        debug("Setting blend mode to " + this.state.style.mixBlendMode, new Object[0]);
        switch (AnonymousClass1.$SwitchMap$net$pubnative$lite$sdk$utils$svgparser$utils$Style$CSSBlendMode[this.state.style.mixBlendMode.ordinal()]) {
            case 1:
                paint.setBlendMode(BlendMode.MULTIPLY);
                break;
            case 2:
                paint.setBlendMode(BlendMode.SCREEN);
                break;
            case 3:
                paint.setBlendMode(BlendMode.OVERLAY);
                break;
            case 4:
                paint.setBlendMode(BlendMode.DARKEN);
                break;
            case 5:
                paint.setBlendMode(BlendMode.LIGHTEN);
                break;
            case 6:
                paint.setBlendMode(BlendMode.COLOR_DODGE);
                break;
            case 7:
                paint.setBlendMode(BlendMode.COLOR_BURN);
                break;
            case 8:
                paint.setBlendMode(BlendMode.HARD_LIGHT);
                break;
            case 9:
                paint.setBlendMode(BlendMode.SOFT_LIGHT);
                break;
            case 10:
                paint.setBlendMode(BlendMode.DIFFERENCE);
                break;
            case 11:
                paint.setBlendMode(BlendMode.EXCLUSION);
                break;
            case 12:
                paint.setBlendMode(BlendMode.HUE);
                break;
            case 13:
                paint.setBlendMode(BlendMode.SATURATION);
                break;
            case 14:
                paint.setBlendMode(BlendMode.COLOR);
                break;
            case 15:
                paint.setBlendMode(BlendMode.LUMINOSITY);
                break;
            default:
                paint.setBlendMode(null);
                break;
        }
    }

    private void render(SVGBase.Switch r3) {
        debug("Switch render", new Object[0]);
        updateStyleForElement(this.state, r3);
        if (display()) {
            if (r3.transform != null) {
                this.canvas.concat(r3.transform);
            }
            checkForClipPath(r3);
            boolean zPushLayer = pushLayer();
            renderSwitchChild(r3);
            if (zPushLayer) {
                popLayer(r3);
            }
            updateParentBoundingBox(r3);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void renderSwitchChild(SVGBase.Switch r9) {
        Set<String> systemLanguage;
        String language = Locale.getDefault().getLanguage();
        for (SVGBase.SvgObject svgObject : r9.getChildren()) {
            if (svgObject instanceof SVGBase.SvgConditional) {
                SVGBase.SvgConditional svgConditional = (SVGBase.SvgConditional) svgObject;
                if (svgConditional.getRequiredExtensions() == null && ((systemLanguage = svgConditional.getSystemLanguage()) == null || (!systemLanguage.isEmpty() && systemLanguage.contains(language)))) {
                    Set<String> requiredFeatures = svgConditional.getRequiredFeatures();
                    if (requiredFeatures != null) {
                        if (supportedFeatures == null) {
                            initialiseSupportedFeaturesMap();
                        }
                        if (requiredFeatures.isEmpty() || !supportedFeatures.containsAll(requiredFeatures)) {
                        }
                    }
                    Set<String> requiredFormats = svgConditional.getRequiredFormats();
                    if (requiredFormats != null) {
                        if (!requiredFormats.isEmpty() && this.externalFileResolver != null) {
                            Iterator<String> it = requiredFormats.iterator();
                            while (true) {
                                if (it.hasNext()) {
                                    if (!this.externalFileResolver.isFormatSupported(it.next())) {
                                    }
                                }
                            }
                        }
                    }
                    Set<String> requiredFonts = svgConditional.getRequiredFonts();
                    if (requiredFonts != null) {
                        if (!requiredFonts.isEmpty() && this.externalFileResolver != null) {
                            Iterator<String> it2 = requiredFonts.iterator();
                            do {
                                if (it2.hasNext()) {
                                }
                            } while (this.externalFileResolver.resolveFont(it2.next(), this.state.style.fontWeight.floatValue(), String.valueOf(this.state.style.fontStyle), this.state.style.fontStretch.floatValue()) != null);
                        }
                    }
                    render(svgObject);
                    return;
                }
            }
        }
    }

    private static synchronized void initialiseSupportedFeaturesMap() {
        HashSet<String> hashSet = new HashSet<>();
        supportedFeatures = hashSet;
        hashSet.add("Structure");
        supportedFeatures.add("BasicStructure");
        supportedFeatures.add("ConditionalProcessing");
        supportedFeatures.add("Image");
        supportedFeatures.add("Style");
        supportedFeatures.add("ViewportAttribute");
        supportedFeatures.add("Shape");
        supportedFeatures.add("BasicText");
        supportedFeatures.add("PaintAttribute");
        supportedFeatures.add("BasicPaintAttribute");
        supportedFeatures.add("OpacityAttribute");
        supportedFeatures.add("BasicGraphicsAttribute");
        supportedFeatures.add("Marker");
        supportedFeatures.add("Gradient");
        supportedFeatures.add("Pattern");
        supportedFeatures.add("Clip");
        supportedFeatures.add("BasicClip");
        supportedFeatures.add("Mask");
        supportedFeatures.add("View");
    }

    private void render(SVGBase.Use use) {
        debug("Use render", new Object[0]);
        if (use.width == null || !use.width.isZero()) {
            if (use.height == null || !use.height.isZero()) {
                updateStyleForElement(this.state, use);
                if (display()) {
                    SVGBase.SvgObject svgObjectResolveIRI = use.document.resolveIRI(use.href);
                    if (svgObjectResolveIRI == null) {
                        error("Use reference '%s' not found", use.href);
                        return;
                    }
                    if (use.transform != null) {
                        this.canvas.concat(use.transform);
                    }
                    this.canvas.translate(use.x != null ? use.x.floatValueX(this) : 0.0f, use.y != null ? use.y.floatValueY(this) : 0.0f);
                    checkForClipPath(use);
                    boolean zPushLayer = pushLayer();
                    parentPush(use);
                    if (svgObjectResolveIRI instanceof SVGBase.Svg) {
                        SVGBase.Box boxMakeViewPort = makeViewPort(null, null, use.width, use.height);
                        statePush();
                        render((SVGBase.Svg) svgObjectResolveIRI, boxMakeViewPort);
                        statePop();
                    } else if (svgObjectResolveIRI instanceof SVGBase.Symbol) {
                        SVGBase.Box boxMakeViewPort2 = makeViewPort(null, null, use.width != null ? use.width : new SVGBase.Length(100.0f, SVGBase.Unit.percent), use.height != null ? use.height : new SVGBase.Length(100.0f, SVGBase.Unit.percent));
                        statePush();
                        render((SVGBase.Symbol) svgObjectResolveIRI, boxMakeViewPort2);
                        statePop();
                    } else {
                        render(svgObjectResolveIRI);
                    }
                    parentPop();
                    if (zPushLayer) {
                        popLayer(use);
                    }
                    updateParentBoundingBox(use);
                }
            }
        }
    }

    private void render(SVGBase.Path path) {
        debug("Path render", new Object[0]);
        if (path.d == null) {
            return;
        }
        updateStyleForElement(this.state, path);
        if (display() && visible()) {
            if (this.state.hasStroke || this.state.hasFill) {
                if (path.transform != null) {
                    this.canvas.concat(path.transform);
                }
                Path path2 = new PathConverter(path.d).getPath();
                if (path.boundingBox == null) {
                    path.boundingBox = calculatePathBounds(path2);
                }
                updateParentBoundingBox(path);
                checkForGradientsAndPatterns(path);
                checkForClipPath(path);
                boolean zPushLayer = pushLayer();
                if (this.state.hasFill) {
                    path2.setFillType(getFillTypeFromState());
                    doFilledPath(path, path2);
                }
                if (this.state.hasStroke) {
                    doStroke(path2);
                }
                renderMarkers(path);
                if (zPushLayer) {
                    popLayer(path);
                }
            }
        }
    }

    private SVGBase.Box calculatePathBounds(Path path) {
        RectF rectF = new RectF();
        path.computeBounds(rectF, true);
        return new SVGBase.Box(rectF.left, rectF.top, rectF.width(), rectF.height());
    }

    private void render(SVGBase.Rect rect) {
        debug("Rect render", new Object[0]);
        if (rect.width == null || rect.height == null || rect.width.isZero() || rect.height.isZero()) {
            return;
        }
        updateStyleForElement(this.state, rect);
        if (display() && visible()) {
            if (rect.transform != null) {
                this.canvas.concat(rect.transform);
            }
            Path pathMakePathAndBoundingBox = makePathAndBoundingBox(rect);
            updateParentBoundingBox(rect);
            checkForGradientsAndPatterns(rect);
            checkForClipPath(rect);
            boolean zPushLayer = pushLayer();
            if (this.state.hasFill) {
                doFilledPath(rect, pathMakePathAndBoundingBox);
            }
            if (this.state.hasStroke) {
                doStroke(pathMakePathAndBoundingBox);
            }
            if (zPushLayer) {
                popLayer(rect);
            }
        }
    }

    private void render(SVGBase.Circle circle) {
        debug("Circle render", new Object[0]);
        if (circle.r == null || circle.r.isZero()) {
            return;
        }
        updateStyleForElement(this.state, circle);
        if (display() && visible()) {
            if (circle.transform != null) {
                this.canvas.concat(circle.transform);
            }
            Path pathMakePathAndBoundingBox = makePathAndBoundingBox(circle);
            updateParentBoundingBox(circle);
            checkForGradientsAndPatterns(circle);
            checkForClipPath(circle);
            boolean zPushLayer = pushLayer();
            if (this.state.hasFill) {
                doFilledPath(circle, pathMakePathAndBoundingBox);
            }
            if (this.state.hasStroke) {
                doStroke(pathMakePathAndBoundingBox);
            }
            if (zPushLayer) {
                popLayer(circle);
            }
        }
    }

    private void render(SVGBase.Ellipse ellipse) {
        debug("Ellipse render", new Object[0]);
        if (ellipse.rx == null || ellipse.ry == null || ellipse.rx.isZero() || ellipse.ry.isZero()) {
            return;
        }
        updateStyleForElement(this.state, ellipse);
        if (display() && visible()) {
            if (ellipse.transform != null) {
                this.canvas.concat(ellipse.transform);
            }
            Path pathMakePathAndBoundingBox = makePathAndBoundingBox(ellipse);
            updateParentBoundingBox(ellipse);
            checkForGradientsAndPatterns(ellipse);
            checkForClipPath(ellipse);
            boolean zPushLayer = pushLayer();
            if (this.state.hasFill) {
                doFilledPath(ellipse, pathMakePathAndBoundingBox);
            }
            if (this.state.hasStroke) {
                doStroke(pathMakePathAndBoundingBox);
            }
            if (zPushLayer) {
                popLayer(ellipse);
            }
        }
    }

    private void render(SVGBase.Line line) {
        debug("Line render", new Object[0]);
        updateStyleForElement(this.state, line);
        if (display() && visible() && this.state.hasStroke) {
            if (line.transform != null) {
                this.canvas.concat(line.transform);
            }
            Path pathMakePathAndBoundingBox = makePathAndBoundingBox(line);
            updateParentBoundingBox(line);
            checkForGradientsAndPatterns(line);
            checkForClipPath(line);
            boolean zPushLayer = pushLayer();
            doStroke(pathMakePathAndBoundingBox);
            renderMarkers(line);
            if (zPushLayer) {
                popLayer(line);
            }
        }
    }

    private List<MarkerVector> calculateMarkerPositions(SVGBase.Line line) {
        float fFloatValueX = line.x1 != null ? line.x1.floatValueX(this) : 0.0f;
        float fFloatValueY = line.y1 != null ? line.y1.floatValueY(this) : 0.0f;
        float fFloatValueX2 = line.x2 != null ? line.x2.floatValueX(this) : 0.0f;
        float fFloatValueY2 = line.y2 != null ? line.y2.floatValueY(this) : 0.0f;
        ArrayList arrayList = new ArrayList(2);
        float f = fFloatValueX2 - fFloatValueX;
        float f2 = fFloatValueY2 - fFloatValueY;
        arrayList.add(new MarkerVector(fFloatValueX, fFloatValueY, f, f2));
        arrayList.add(new MarkerVector(fFloatValueX2, fFloatValueY2, f, f2));
        return arrayList;
    }

    private void render(SVGBase.PolyLine polyLine) {
        debug("PolyLine render", new Object[0]);
        updateStyleForElement(this.state, polyLine);
        if (display() && visible()) {
            if (this.state.hasStroke || this.state.hasFill) {
                if (polyLine.transform != null) {
                    this.canvas.concat(polyLine.transform);
                }
                int length = polyLine.points != null ? polyLine.points.length : 0;
                if (length < 2 || length % 2 == 1) {
                    return;
                }
                Path pathMakePathAndBoundingBox = makePathAndBoundingBox(polyLine);
                updateParentBoundingBox(polyLine);
                pathMakePathAndBoundingBox.setFillType(getFillTypeFromState());
                checkForGradientsAndPatterns(polyLine);
                checkForClipPath(polyLine);
                boolean zPushLayer = pushLayer();
                if (this.state.hasFill) {
                    doFilledPath(polyLine, pathMakePathAndBoundingBox);
                }
                if (this.state.hasStroke) {
                    doStroke(pathMakePathAndBoundingBox);
                }
                renderMarkers(polyLine);
                if (zPushLayer) {
                    popLayer(polyLine);
                }
            }
        }
    }

    private List<MarkerVector> calculateMarkerPositions(SVGBase.PolyLine polyLine) {
        int length = polyLine.points != null ? polyLine.points.length : 0;
        int i = 2;
        if (length < 2) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        float f = 0.0f;
        MarkerVector markerVector = new MarkerVector(polyLine.points[0], polyLine.points[1], 0.0f, 0.0f);
        float f2 = 0.0f;
        while (i < length) {
            f = polyLine.points[i];
            f2 = polyLine.points[i + 1];
            markerVector.add(f, f2);
            arrayList.add(markerVector);
            i += 2;
            markerVector = new MarkerVector(f, f2, f - markerVector.x, f2 - markerVector.y);
        }
        if (!(polyLine instanceof SVGBase.Polygon)) {
            arrayList.add(markerVector);
        } else if (f != polyLine.points[0] && f2 != polyLine.points[1]) {
            float f3 = polyLine.points[0];
            float f4 = polyLine.points[1];
            markerVector.add(f3, f4);
            arrayList.add(markerVector);
            MarkerVector markerVector2 = new MarkerVector(f3, f4, f3 - markerVector.x, f4 - markerVector.y);
            markerVector2.add((MarkerVector) arrayList.get(0));
            arrayList.add(markerVector2);
            arrayList.set(0, markerVector2);
        }
        return arrayList;
    }

    private void render(SVGBase.Polygon polygon) {
        debug("Polygon render", new Object[0]);
        updateStyleForElement(this.state, polygon);
        if (display() && visible()) {
            if (this.state.hasStroke || this.state.hasFill) {
                if (polygon.transform != null) {
                    this.canvas.concat(polygon.transform);
                }
                if ((polygon.points != null ? polygon.points.length : 0) < 2) {
                    return;
                }
                Path pathMakePathAndBoundingBox = makePathAndBoundingBox(polygon);
                updateParentBoundingBox(polygon);
                checkForGradientsAndPatterns(polygon);
                checkForClipPath(polygon);
                boolean zPushLayer = pushLayer();
                if (this.state.hasFill) {
                    doFilledPath(polygon, pathMakePathAndBoundingBox);
                }
                if (this.state.hasStroke) {
                    doStroke(pathMakePathAndBoundingBox);
                }
                renderMarkers(polygon);
                if (zPushLayer) {
                    popLayer(polygon);
                }
            }
        }
    }

    private void render(SVGBase.Text text) {
        debug("Text render", new Object[0]);
        updateStyleForElement(this.state, text);
        if (display()) {
            selectTypefaceAndFontStyling();
            if (text.transform != null) {
                this.canvas.concat(text.transform);
            }
            float fFloatValueY = 0.0f;
            float fFloatValueX = (text.x == null || text.x.size() == 0) ? 0.0f : text.x.get(0).floatValueX(this);
            float fFloatValueY2 = (text.y == null || text.y.size() == 0) ? 0.0f : text.y.get(0).floatValueY(this);
            float fFloatValueX2 = (text.dx == null || text.dx.size() == 0) ? 0.0f : text.dx.get(0).floatValueX(this);
            if (text.dy != null && text.dy.size() != 0) {
                fFloatValueY = text.dy.get(0).floatValueY(this);
            }
            Style.TextAnchor anchorPosition = getAnchorPosition();
            if (anchorPosition != Style.TextAnchor.Start) {
                float fCalculateTextWidth = calculateTextWidth(text);
                if (anchorPosition == Style.TextAnchor.Middle) {
                    fCalculateTextWidth /= 2.0f;
                }
                fFloatValueX -= fCalculateTextWidth;
            }
            if (text.boundingBox == null) {
                TextBoundsCalculator textBoundsCalculator = new TextBoundsCalculator(fFloatValueX, fFloatValueY2);
                enumerateTextSpans(text, textBoundsCalculator);
                text.boundingBox = new SVGBase.Box(textBoundsCalculator.bbox.left, textBoundsCalculator.bbox.top, textBoundsCalculator.bbox.width(), textBoundsCalculator.bbox.height());
            }
            updateParentBoundingBox(text);
            checkForGradientsAndPatterns(text);
            checkForClipPath(text);
            boolean zPushLayer = pushLayer();
            enumerateTextSpans(text, new PlainTextDrawer(fFloatValueX + fFloatValueX2, fFloatValueY2 + fFloatValueY));
            if (zPushLayer) {
                popLayer(text);
            }
        }
    }

    private void selectTypefaceAndFontStyling() {
        SVGExternalFileResolver sVGExternalFileResolver;
        Typeface typefaceCheckGenericFont = null;
        if (this.state.style.fontFamily != null && this.document != null) {
            for (String str : this.state.style.fontFamily) {
                Typeface typefaceCheckGenericFont2 = checkGenericFont(str, this.state.style.fontWeight, this.state.style.fontStyle);
                typefaceCheckGenericFont = (typefaceCheckGenericFont2 != null || (sVGExternalFileResolver = this.externalFileResolver) == null) ? typefaceCheckGenericFont2 : sVGExternalFileResolver.resolveFont(str, this.state.style.fontWeight.floatValue(), String.valueOf(this.state.style.fontStyle), this.state.style.fontStretch.floatValue());
                if (typefaceCheckGenericFont != null) {
                    break;
                }
            }
        }
        if (typefaceCheckGenericFont == null) {
            typefaceCheckGenericFont = checkGenericFont("serif", this.state.style.fontWeight, this.state.style.fontStyle);
        }
        this.state.fillPaint.setTypeface(typefaceCheckGenericFont);
        this.state.strokePaint.setTypeface(typefaceCheckGenericFont);
        if (SUPPORTS_PAINT_FONT_VARIATION_SETTINGS) {
            this.state.fontVariationSet.addSetting("wght", this.state.style.fontWeight.floatValue());
            if (this.state.style.fontStyle == Style.FontStyle.italic) {
                this.state.fontVariationSet.addSetting("ital", CSSFontVariationSettings.VARIATION_ITALIC_VALUE_ON.floatValue());
                this.state.fontVariationSet.addSetting("slnt", CSSFontVariationSettings.VARIATION_OBLIQUE_VALUE_ON.floatValue());
            } else if (this.state.style.fontStyle == Style.FontStyle.oblique) {
                this.state.fontVariationSet.addSetting("slnt", CSSFontVariationSettings.VARIATION_OBLIQUE_VALUE_ON.floatValue());
            }
            this.state.fontVariationSet.addSetting("wdth", this.state.style.fontStretch.floatValue());
            String string = this.state.fontVariationSet.toString();
            debug("fontVariationSettings = " + string, new Object[0]);
            this.state.fillPaint.setFontVariationSettings(string);
            this.state.strokePaint.setFontVariationSettings(string);
        }
        if (SUPPORTS_PAINT_FONT_FEATURE_SETTINGS) {
            String string2 = this.state.fontFeatureSet.toString();
            debug("fontFeatureSettings = " + string2, new Object[0]);
            this.state.fillPaint.setFontFeatureSettings(string2);
            this.state.strokePaint.setFontFeatureSettings(string2);
        }
    }

    private Style.TextAnchor getAnchorPosition() {
        if (this.state.style.direction == Style.TextDirection.LTR || this.state.style.textAnchor == Style.TextAnchor.Middle) {
            return this.state.style.textAnchor;
        }
        return this.state.style.textAnchor == Style.TextAnchor.Start ? Style.TextAnchor.End : Style.TextAnchor.Start;
    }

    private class PlainTextDrawer extends TextProcessor {
        float x;
        float y;

        PlainTextDrawer(float f, float f2) {
            super();
            this.x = f;
            this.y = f2;
        }

        @Override // net.pubnative.lite.sdk.utils.svgparser.utils.SVGAndroidRenderer.TextProcessor
        public void processText(String str) {
            SVGAndroidRenderer.debug("TextSequence render", new Object[0]);
            if (SVGAndroidRenderer.this.visible()) {
                float fFloatValue = SVGAndroidRenderer.SUPPORTS_PAINT_LETTER_SPACING ? SVGAndroidRenderer.this.state.style.letterSpacing.floatValue(SVGAndroidRenderer.this) / 2.0f : 0.0f;
                if (SVGAndroidRenderer.this.state.hasFill) {
                    SVGAndroidRenderer.this.canvas.drawText(str, this.x - fFloatValue, this.y, SVGAndroidRenderer.this.state.fillPaint);
                }
                if (SVGAndroidRenderer.this.state.hasStroke) {
                    SVGAndroidRenderer.this.canvas.drawText(str, this.x - fFloatValue, this.y, SVGAndroidRenderer.this.state.strokePaint);
                }
            }
            float f = this.x;
            SVGAndroidRenderer sVGAndroidRenderer = SVGAndroidRenderer.this;
            this.x = f + sVGAndroidRenderer.measureText(str, sVGAndroidRenderer.state.fillPaint);
        }
    }

    private static abstract class TextProcessor {
        public boolean doTextContainer(SVGBase.TextContainer textContainer) {
            return true;
        }

        public abstract void processText(String str);

        private TextProcessor() {
        }
    }

    private void enumerateTextSpans(SVGBase.TextContainer textContainer, TextProcessor textProcessor) {
        if (display()) {
            Iterator<SVGBase.SvgObject> it = textContainer.children.iterator();
            boolean z = true;
            while (it.hasNext()) {
                SVGBase.SvgObject next = it.next();
                if (next instanceof SVGBase.TextSequence) {
                    textProcessor.processText(textXMLSpaceTransform(((SVGBase.TextSequence) next).text, z, !it.hasNext()));
                } else {
                    processTextChild(next, textProcessor);
                }
                z = false;
            }
        }
    }

    private void processTextChild(SVGBase.SvgObject svgObject, TextProcessor textProcessor) {
        float f;
        float fFloatValueY;
        float fFloatValueX;
        Style.TextAnchor anchorPosition;
        if (textProcessor.doTextContainer((SVGBase.TextContainer) svgObject)) {
            if (svgObject instanceof SVGBase.TextPath) {
                statePush();
                renderTextPath((SVGBase.TextPath) svgObject);
                statePop();
                return;
            }
            if (svgObject instanceof SVGBase.TSpan) {
                debug("TSpan render", new Object[0]);
                statePush();
                SVGBase.TSpan tSpan = (SVGBase.TSpan) svgObject;
                updateStyleForElement(this.state, tSpan);
                if (display()) {
                    selectTypefaceAndFontStyling();
                    boolean z = tSpan.x != null && tSpan.x.size() > 0;
                    boolean z2 = textProcessor instanceof PlainTextDrawer;
                    float fFloatValueY2 = 0.0f;
                    if (z2) {
                        float fFloatValueX2 = !z ? ((PlainTextDrawer) textProcessor).x : tSpan.x.get(0).floatValueX(this);
                        fFloatValueY = (tSpan.y == null || tSpan.y.size() == 0) ? ((PlainTextDrawer) textProcessor).y : tSpan.y.get(0).floatValueY(this);
                        fFloatValueX = (tSpan.dx == null || tSpan.dx.size() == 0) ? 0.0f : tSpan.dx.get(0).floatValueX(this);
                        if (tSpan.dy != null && tSpan.dy.size() != 0) {
                            fFloatValueY2 = tSpan.dy.get(0).floatValueY(this);
                        }
                        f = fFloatValueY2;
                        fFloatValueY2 = fFloatValueX2;
                    } else {
                        f = 0.0f;
                        fFloatValueY = 0.0f;
                        fFloatValueX = 0.0f;
                    }
                    if (z && (anchorPosition = getAnchorPosition()) != Style.TextAnchor.Start) {
                        float fCalculateTextWidth = calculateTextWidth(tSpan);
                        if (anchorPosition == Style.TextAnchor.Middle) {
                            fCalculateTextWidth /= 2.0f;
                        }
                        fFloatValueY2 -= fCalculateTextWidth;
                    }
                    checkForGradientsAndPatterns((SVGBase.SvgElement) tSpan.getTextRoot());
                    if (z2) {
                        PlainTextDrawer plainTextDrawer = (PlainTextDrawer) textProcessor;
                        plainTextDrawer.x = fFloatValueY2 + fFloatValueX;
                        plainTextDrawer.y = fFloatValueY + f;
                    }
                    boolean zPushLayer = pushLayer();
                    enumerateTextSpans(tSpan, textProcessor);
                    if (zPushLayer) {
                        popLayer(tSpan);
                    }
                }
                statePop();
                return;
            }
            if (svgObject instanceof SVGBase.TRef) {
                statePush();
                SVGBase.TRef tRef = (SVGBase.TRef) svgObject;
                updateStyleForElement(this.state, tRef);
                if (display()) {
                    checkForGradientsAndPatterns((SVGBase.SvgElement) tRef.getTextRoot());
                    SVGBase.SvgObject svgObjectResolveIRI = svgObject.document.resolveIRI(tRef.href);
                    if (svgObjectResolveIRI instanceof SVGBase.TextContainer) {
                        StringBuilder sb = new StringBuilder();
                        extractRawText((SVGBase.TextContainer) svgObjectResolveIRI, sb);
                        if (sb.length() > 0) {
                            textProcessor.processText(sb.toString());
                        }
                    } else {
                        error("Tref reference '%s' not found", tRef.href);
                    }
                }
                statePop();
            }
        }
    }

    private void renderTextPath(SVGBase.TextPath textPath) {
        debug("TextPath render", new Object[0]);
        updateStyleForElement(this.state, textPath);
        if (display() && visible()) {
            selectTypefaceAndFontStyling();
            SVGBase.SvgObject svgObjectResolveIRI = textPath.document.resolveIRI(textPath.href);
            if (svgObjectResolveIRI == null) {
                error("TextPath reference '%s' not found", textPath.href);
                return;
            }
            SVGBase.Path path = (SVGBase.Path) svgObjectResolveIRI;
            Path path2 = new PathConverter(path.d).getPath();
            if (path.transform != null) {
                path2.transform(path.transform);
            }
            float fFloatValue = textPath.startOffset != null ? textPath.startOffset.floatValue(this, new PathMeasure(path2, false).getLength()) : 0.0f;
            Style.TextAnchor anchorPosition = getAnchorPosition();
            if (anchorPosition != Style.TextAnchor.Start) {
                float fCalculateTextWidth = calculateTextWidth(textPath);
                if (anchorPosition == Style.TextAnchor.Middle) {
                    fCalculateTextWidth /= 2.0f;
                }
                fFloatValue -= fCalculateTextWidth;
            }
            checkForGradientsAndPatterns((SVGBase.SvgElement) textPath.getTextRoot());
            boolean zPushLayer = pushLayer();
            enumerateTextSpans(textPath, new PathTextDrawer(path2, fFloatValue, 0.0f));
            if (zPushLayer) {
                popLayer(textPath);
            }
        }
    }

    private class PathTextDrawer extends PlainTextDrawer {
        private final Path path;

        PathTextDrawer(Path path, float f, float f2) {
            super(f, f2);
            this.path = path;
        }

        @Override // net.pubnative.lite.sdk.utils.svgparser.utils.SVGAndroidRenderer.PlainTextDrawer, net.pubnative.lite.sdk.utils.svgparser.utils.SVGAndroidRenderer.TextProcessor
        public void processText(String str) {
            if (SVGAndroidRenderer.this.visible()) {
                float fFloatValue = SVGAndroidRenderer.SUPPORTS_PAINT_LETTER_SPACING ? SVGAndroidRenderer.this.state.style.letterSpacing.floatValue(SVGAndroidRenderer.this) / 2.0f : 0.0f;
                if (SVGAndroidRenderer.this.state.hasFill) {
                    SVGAndroidRenderer.this.canvas.drawTextOnPath(str, this.path, this.x - fFloatValue, this.y, SVGAndroidRenderer.this.state.fillPaint);
                }
                if (SVGAndroidRenderer.this.state.hasStroke) {
                    SVGAndroidRenderer.this.canvas.drawTextOnPath(str, this.path, this.x - fFloatValue, this.y, SVGAndroidRenderer.this.state.strokePaint);
                }
            }
            float f = this.x;
            SVGAndroidRenderer sVGAndroidRenderer = SVGAndroidRenderer.this;
            this.x = f + sVGAndroidRenderer.measureText(str, sVGAndroidRenderer.state.fillPaint);
        }
    }

    private float calculateTextWidth(SVGBase.TextContainer textContainer) {
        TextWidthCalculator textWidthCalculator = new TextWidthCalculator();
        enumerateTextSpans(textContainer, textWidthCalculator);
        return textWidthCalculator.x;
    }

    private class TextWidthCalculator extends TextProcessor {
        float x;

        private TextWidthCalculator() {
            super();
            this.x = 0.0f;
        }

        @Override // net.pubnative.lite.sdk.utils.svgparser.utils.SVGAndroidRenderer.TextProcessor
        public void processText(String str) {
            float f = this.x;
            SVGAndroidRenderer sVGAndroidRenderer = SVGAndroidRenderer.this;
            this.x = f + sVGAndroidRenderer.measureText(str, sVGAndroidRenderer.state.fillPaint);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float measureText(String str, Paint paint) {
        int length = str.length();
        float[] fArr = new float[length];
        paint.getTextWidths(str, fArr);
        float f = 0.0f;
        for (int i = 0; i < length; i++) {
            f += fArr[i];
        }
        return f;
    }

    private class TextBoundsCalculator extends TextProcessor {
        final RectF bbox;
        float x;
        float y;

        TextBoundsCalculator(float f, float f2) {
            super();
            this.bbox = new RectF();
            this.x = f;
            this.y = f2;
        }

        @Override // net.pubnative.lite.sdk.utils.svgparser.utils.SVGAndroidRenderer.TextProcessor
        public boolean doTextContainer(SVGBase.TextContainer textContainer) {
            if (!(textContainer instanceof SVGBase.TextPath)) {
                return true;
            }
            SVGBase.TextPath textPath = (SVGBase.TextPath) textContainer;
            SVGBase.SvgObject svgObjectResolveIRI = textContainer.document.resolveIRI(textPath.href);
            if (svgObjectResolveIRI == null) {
                SVGAndroidRenderer.error("TextPath path reference '%s' not found", textPath.href);
                return false;
            }
            SVGBase.Path path = (SVGBase.Path) svgObjectResolveIRI;
            Path path2 = new PathConverter(path.d).getPath();
            if (path.transform != null) {
                path2.transform(path.transform);
            }
            RectF rectF = new RectF();
            path2.computeBounds(rectF, true);
            this.bbox.union(rectF);
            return false;
        }

        @Override // net.pubnative.lite.sdk.utils.svgparser.utils.SVGAndroidRenderer.TextProcessor
        public void processText(String str) {
            if (SVGAndroidRenderer.this.visible()) {
                Rect rect = new Rect();
                SVGAndroidRenderer.this.state.fillPaint.getTextBounds(str, 0, str.length(), rect);
                RectF rectF = new RectF(rect);
                rectF.offset(this.x, this.y);
                this.bbox.union(rectF);
            }
            float f = this.x;
            SVGAndroidRenderer sVGAndroidRenderer = SVGAndroidRenderer.this;
            this.x = f + sVGAndroidRenderer.measureText(str, sVGAndroidRenderer.state.fillPaint);
        }
    }

    private void extractRawText(SVGBase.TextContainer textContainer, StringBuilder sb) {
        Iterator<SVGBase.SvgObject> it = textContainer.children.iterator();
        boolean z = true;
        while (it.hasNext()) {
            SVGBase.SvgObject next = it.next();
            if (next instanceof SVGBase.TextContainer) {
                extractRawText((SVGBase.TextContainer) next, sb);
            } else if (next instanceof SVGBase.TextSequence) {
                sb.append(textXMLSpaceTransform(((SVGBase.TextSequence) next).text, z, !it.hasNext()));
            }
            z = false;
        }
    }

    private String textXMLSpaceTransform(String str, boolean z, boolean z2) {
        if (this.state.spacePreserve) {
            return PATTERN_TABS_OR_LINE_BREAKS.matcher(str).replaceAll(" ");
        }
        String strReplaceAll = PATTERN_LINE_BREAKS.matcher(PATTERN_TABS.matcher(str).replaceAll("")).replaceAll(" ");
        if (z) {
            strReplaceAll = PATTERN_START_SPACES.matcher(strReplaceAll).replaceAll("");
        }
        if (z2) {
            strReplaceAll = PATTERN_END_SPACES.matcher(strReplaceAll).replaceAll("");
        }
        return PATTERN_DOUBLE_SPACES.matcher(strReplaceAll).replaceAll(" ");
    }

    private void render(SVGBase.Symbol symbol, SVGBase.Box box) {
        debug("Symbol render", new Object[0]);
        if (box.width == 0.0f || box.height == 0.0f) {
            return;
        }
        PreserveAspectRatio preserveAspectRatio = symbol.preserveAspectRatio != null ? symbol.preserveAspectRatio : PreserveAspectRatio.LETTERBOX;
        updateStyleForElement(this.state, symbol);
        this.state.viewPort = box;
        if (!this.state.style.overflow.booleanValue()) {
            setClipRect(this.state.viewPort.minX, this.state.viewPort.minY, this.state.viewPort.width, this.state.viewPort.height);
        }
        if (symbol.viewBox != null) {
            this.canvas.concat(calculateViewBoxTransform(this.state.viewPort, symbol.viewBox, preserveAspectRatio));
            this.state.viewBox = symbol.viewBox;
        } else {
            this.canvas.translate(this.state.viewPort.minX, this.state.viewPort.minY);
            this.state.viewBox = null;
        }
        boolean zPushLayer = pushLayer();
        renderChildren(symbol, true);
        if (zPushLayer) {
            popLayer(symbol);
        }
        updateParentBoundingBox(symbol);
    }

    private void render(SVGBase.Image image) {
        debug("Image render", new Object[0]);
        if (image.width == null || image.width.isZero() || image.height == null || image.height.isZero() || image.href == null) {
            return;
        }
        PreserveAspectRatio preserveAspectRatio = image.preserveAspectRatio != null ? image.preserveAspectRatio : PreserveAspectRatio.LETTERBOX;
        Bitmap bitmapCheckForImageDataURL = checkForImageDataURL(image.href);
        if (bitmapCheckForImageDataURL == null) {
            SVGExternalFileResolver sVGExternalFileResolver = this.externalFileResolver;
            if (sVGExternalFileResolver == null) {
                return;
            } else {
                bitmapCheckForImageDataURL = sVGExternalFileResolver.resolveImage(image.href);
            }
        }
        if (bitmapCheckForImageDataURL == null) {
            error("Could not locate image '%s'", image.href);
            return;
        }
        SVGBase.Box box = new SVGBase.Box(0.0f, 0.0f, bitmapCheckForImageDataURL.getWidth(), bitmapCheckForImageDataURL.getHeight());
        updateStyleForElement(this.state, image);
        if (display() && visible()) {
            if (image.transform != null) {
                this.canvas.concat(image.transform);
            }
            this.state.viewPort = new SVGBase.Box(image.x != null ? image.x.floatValueX(this) : 0.0f, image.y != null ? image.y.floatValueY(this) : 0.0f, image.width.floatValueX(this), image.height.floatValueX(this));
            if (!this.state.style.overflow.booleanValue()) {
                setClipRect(this.state.viewPort.minX, this.state.viewPort.minY, this.state.viewPort.width, this.state.viewPort.height);
            }
            image.boundingBox = this.state.viewPort;
            updateParentBoundingBox(image);
            checkForClipPath(image);
            boolean zPushLayer = pushLayer();
            viewportFill();
            this.canvas.save();
            this.canvas.concat(calculateViewBoxTransform(this.state.viewPort, box, preserveAspectRatio));
            this.canvas.drawBitmap(bitmapCheckForImageDataURL, 0.0f, 0.0f, new Paint(this.state.style.imageRendering != Style.RenderQuality.optimizeSpeed ? 2 : 0));
            this.canvas.restore();
            if (zPushLayer) {
                popLayer(image);
            }
        }
    }

    private Bitmap checkForImageDataURL(String str) {
        int iIndexOf;
        if (!str.startsWith("data:") || str.length() < 14 || (iIndexOf = str.indexOf(44)) < 12 || !";base64".equals(str.substring(iIndexOf - 7, iIndexOf))) {
            return null;
        }
        try {
            byte[] bArrDecode = Base64.decode(str.substring(iIndexOf + 1), 0);
            return BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length);
        } catch (Exception e) {
            Log.e(TAG, "Could not decode bad Data URL", e);
            return null;
        }
    }

    private boolean display() {
        if (this.state.style.display != null) {
            return this.state.style.display.booleanValue();
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean visible() {
        if (this.state.style.visibility != null) {
            return this.state.style.visibility.booleanValue();
        }
        return true;
    }

    /* JADX WARN: Code duplicated, block: B:23:0x0076  */
    /* JADX WARN: Code duplicated, block: B:25:0x0079  */
    /* JADX WARN: Code duplicated, block: B:27:0x007c  */
    /* JADX WARN: Code duplicated, block: B:29:0x007f  */
    /* JADX WARN: Code duplicated, block: B:31:0x0082  */
    /* JADX WARN: Code duplicated, block: B:35:0x008b  */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0084, code lost:
    
        if (r11 != 8) goto L37;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private android.graphics.Matrix calculateViewBoxTransform(net.pubnative.lite.sdk.utils.svgparser.utils.SVGBase.Box r9, net.pubnative.lite.sdk.utils.svgparser.utils.SVGBase.Box r10, net.pubnative.lite.sdk.utils.svgparser.PreserveAspectRatio r11) {
        /*
            r8 = this;
            android.graphics.Matrix r0 = new android.graphics.Matrix
            r0.<init>()
            if (r11 == 0) goto L9d
            net.pubnative.lite.sdk.utils.svgparser.PreserveAspectRatio$Alignment r1 = r11.getAlignment()
            if (r1 != 0) goto Lf
            goto L9d
        Lf:
            float r1 = r9.width
            float r2 = r10.width
            float r1 = r1 / r2
            float r2 = r9.height
            float r3 = r10.height
            float r2 = r2 / r3
            float r3 = r10.minX
            float r3 = -r3
            float r4 = r10.minY
            float r4 = -r4
            net.pubnative.lite.sdk.utils.svgparser.PreserveAspectRatio r5 = net.pubnative.lite.sdk.utils.svgparser.PreserveAspectRatio.STRETCH
            boolean r5 = r11.equals(r5)
            if (r5 == 0) goto L35
            float r10 = r9.minX
            float r9 = r9.minY
            r0.preTranslate(r10, r9)
            r0.preScale(r1, r2)
            r0.preTranslate(r3, r4)
            return r0
        L35:
            net.pubnative.lite.sdk.utils.svgparser.PreserveAspectRatio$Scale r5 = r11.getScale()
            net.pubnative.lite.sdk.utils.svgparser.PreserveAspectRatio$Scale r6 = net.pubnative.lite.sdk.utils.svgparser.PreserveAspectRatio.Scale.slice
            if (r5 != r6) goto L42
            float r1 = java.lang.Math.max(r1, r2)
            goto L46
        L42:
            float r1 = java.lang.Math.min(r1, r2)
        L46:
            float r2 = r9.width
            float r2 = r2 / r1
            float r5 = r9.height
            float r5 = r5 / r1
            int[] r6 = net.pubnative.lite.sdk.utils.svgparser.utils.SVGAndroidRenderer.AnonymousClass1.$SwitchMap$net$pubnative$lite$sdk$utils$svgparser$PreserveAspectRatio$Alignment
            net.pubnative.lite.sdk.utils.svgparser.PreserveAspectRatio$Alignment r7 = r11.getAlignment()
            int r7 = r7.ordinal()
            r6 = r6[r7]
            r7 = 1073741824(0x40000000, float:2.0)
            switch(r6) {
                case 1: goto L62;
                case 2: goto L62;
                case 3: goto L62;
                case 4: goto L5e;
                case 5: goto L5e;
                case 6: goto L5e;
                default: goto L5d;
            }
        L5d:
            goto L67
        L5e:
            float r6 = r10.width
            float r6 = r6 - r2
            goto L66
        L62:
            float r6 = r10.width
            float r6 = r6 - r2
            float r6 = r6 / r7
        L66:
            float r3 = r3 - r6
        L67:
            int[] r2 = net.pubnative.lite.sdk.utils.svgparser.utils.SVGAndroidRenderer.AnonymousClass1.$SwitchMap$net$pubnative$lite$sdk$utils$svgparser$PreserveAspectRatio$Alignment
            net.pubnative.lite.sdk.utils.svgparser.PreserveAspectRatio$Alignment r11 = r11.getAlignment()
            int r11 = r11.ordinal()
            r11 = r2[r11]
            r2 = 2
            if (r11 == r2) goto L8b
            r2 = 3
            if (r11 == r2) goto L87
            r2 = 5
            if (r11 == r2) goto L8b
            r2 = 6
            if (r11 == r2) goto L87
            r2 = 7
            if (r11 == r2) goto L8b
            r2 = 8
            if (r11 == r2) goto L87
            goto L90
        L87:
            float r10 = r10.height
            float r10 = r10 - r5
            goto L8f
        L8b:
            float r10 = r10.height
            float r10 = r10 - r5
            float r10 = r10 / r7
        L8f:
            float r4 = r4 - r10
        L90:
            float r10 = r9.minX
            float r9 = r9.minY
            r0.preTranslate(r10, r9)
            r0.preScale(r1, r1)
            r0.preTranslate(r3, r4)
        L9d:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: net.pubnative.lite.sdk.utils.svgparser.utils.SVGAndroidRenderer.calculateViewBoxTransform(net.pubnative.lite.sdk.utils.svgparser.utils.SVGBase$Box, net.pubnative.lite.sdk.utils.svgparser.utils.SVGBase$Box, net.pubnative.lite.sdk.utils.svgparser.PreserveAspectRatio):android.graphics.Matrix");
    }

    private boolean isSpecified(Style style, long j) {
        return (style.specifiedFlags & j) != 0;
    }

    private void updateStyle(RendererState rendererState, Style style) {
        if (isSpecified(style, PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM)) {
            rendererState.style.color = style.color;
        }
        if (isSpecified(style, PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH)) {
            rendererState.style.opacity = style.opacity;
        }
        if (isSpecified(style, 1L)) {
            rendererState.style.fill = style.fill;
            rendererState.hasFill = (style.fill == null || style.fill == SVGBase.Colour.TRANSPARENT) ? false : true;
        }
        if (isSpecified(style, 4L)) {
            rendererState.style.fillOpacity = style.fillOpacity;
        }
        if (isSpecified(style, 6149L)) {
            setPaintColour(rendererState, true, rendererState.style.fill);
        }
        if (isSpecified(style, 2L)) {
            rendererState.style.fillRule = style.fillRule;
        }
        if (isSpecified(style, 8L)) {
            rendererState.style.stroke = style.stroke;
            rendererState.hasStroke = (style.stroke == null || style.stroke == SVGBase.Colour.TRANSPARENT) ? false : true;
        }
        if (isSpecified(style, 16L)) {
            rendererState.style.strokeOpacity = style.strokeOpacity;
        }
        if (isSpecified(style, 6168L)) {
            setPaintColour(rendererState, false, rendererState.style.stroke);
        }
        if (isSpecified(style, 34359738368L)) {
            rendererState.style.vectorEffect = style.vectorEffect;
        }
        if (isSpecified(style, 32L)) {
            rendererState.style.strokeWidth = style.strokeWidth;
            rendererState.strokePaint.setStrokeWidth(rendererState.style.strokeWidth.floatValue(this));
        }
        if (isSpecified(style, 64L)) {
            rendererState.style.strokeLineCap = style.strokeLineCap;
            int i = AnonymousClass1.$SwitchMap$net$pubnative$lite$sdk$utils$svgparser$utils$Style$LineCap[style.strokeLineCap.ordinal()];
            if (i == 1) {
                rendererState.strokePaint.setStrokeCap(Paint.Cap.BUTT);
            } else if (i == 2) {
                rendererState.strokePaint.setStrokeCap(Paint.Cap.ROUND);
            } else if (i == 3) {
                rendererState.strokePaint.setStrokeCap(Paint.Cap.SQUARE);
            }
        }
        if (isSpecified(style, 128L)) {
            rendererState.style.strokeLineJoin = style.strokeLineJoin;
            int i2 = AnonymousClass1.$SwitchMap$net$pubnative$lite$sdk$utils$svgparser$utils$Style$LineJoin[style.strokeLineJoin.ordinal()];
            if (i2 == 1) {
                rendererState.strokePaint.setStrokeJoin(Paint.Join.MITER);
            } else if (i2 == 2) {
                rendererState.strokePaint.setStrokeJoin(Paint.Join.ROUND);
            } else if (i2 == 3) {
                rendererState.strokePaint.setStrokeJoin(Paint.Join.BEVEL);
            }
        }
        if (isSpecified(style, 256L)) {
            rendererState.style.strokeMiterLimit = style.strokeMiterLimit;
            rendererState.strokePaint.setStrokeMiter(style.strokeMiterLimit.floatValue());
        }
        if (isSpecified(style, 512L)) {
            rendererState.style.strokeDashArray = style.strokeDashArray;
        }
        if (isSpecified(style, 1024L)) {
            rendererState.style.strokeDashOffset = style.strokeDashOffset;
        }
        if (isSpecified(style, 1536L)) {
            if (rendererState.style.strokeDashArray == null) {
                rendererState.strokePaint.setPathEffect(null);
            } else {
                int length = rendererState.style.strokeDashArray.length;
                int i3 = length % 2 == 0 ? length : length * 2;
                float[] fArr = new float[i3];
                float f = 0.0f;
                for (int i4 = 0; i4 < i3; i4++) {
                    float fFloatValue = rendererState.style.strokeDashArray[i4 % length].floatValue(this);
                    fArr[i4] = fFloatValue;
                    f += fFloatValue;
                }
                if (f == 0.0f) {
                    rendererState.strokePaint.setPathEffect(null);
                } else {
                    float fFloatValue2 = rendererState.style.strokeDashOffset.floatValue(this);
                    if (fFloatValue2 < 0.0f) {
                        fFloatValue2 = (fFloatValue2 % f) + f;
                    }
                    rendererState.strokePaint.setPathEffect(new DashPathEffect(fArr, fFloatValue2));
                }
            }
        }
        if (isSpecified(style, 16384L)) {
            float currentFontSize = getCurrentFontSize();
            rendererState.style.fontSize = style.fontSize;
            rendererState.fillPaint.setTextSize(style.fontSize.floatValue(this, currentFontSize));
            rendererState.strokePaint.setTextSize(style.fontSize.floatValue(this, currentFontSize));
        }
        if (isSpecified(style, PlaybackStateCompat.ACTION_PLAY_FROM_URI)) {
            rendererState.style.fontFamily = style.fontFamily;
        }
        if (isSpecified(style, PlaybackStateCompat.ACTION_PREPARE_FROM_MEDIA_ID)) {
            if (style.fontWeight.floatValue() == Float.MIN_VALUE) {
                float fFloatValue3 = rendererState.style.fontWeight.floatValue();
                if (fFloatValue3 >= 100.0f && fFloatValue3 < 550.0f) {
                    rendererState.style.fontWeight = Float.valueOf(100.0f);
                } else if (fFloatValue3 >= 550.0f && fFloatValue3 < 750.0f) {
                    rendererState.style.fontWeight = Float.valueOf(400.0f);
                } else if (fFloatValue3 >= 750.0f) {
                    rendererState.style.fontWeight = Float.valueOf(700.0f);
                }
            } else if (style.fontWeight.floatValue() == Float.MAX_VALUE) {
                float fFloatValue4 = rendererState.style.fontWeight.floatValue();
                if (fFloatValue4 < 350.0f) {
                    rendererState.style.fontWeight = Float.valueOf(400.0f);
                } else if (fFloatValue4 >= 350.0f && fFloatValue4 < 550.0f) {
                    rendererState.style.fontWeight = Float.valueOf(700.0f);
                } else if (fFloatValue4 >= 550.0f && fFloatValue4 < 900.0f) {
                    rendererState.style.fontWeight = Float.valueOf(900.0f);
                }
            } else {
                rendererState.style.fontWeight = style.fontWeight;
            }
        }
        if (isSpecified(style, PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH)) {
            rendererState.style.fontStyle = style.fontStyle;
        }
        if (isSpecified(style, 2251799813685248L)) {
            rendererState.style.fontStretch = style.fontStretch;
        }
        if (isSpecified(style, PlaybackStateCompat.ACTION_PREPARE_FROM_URI)) {
            rendererState.style.textDecoration = style.textDecoration;
            rendererState.fillPaint.setStrikeThruText(style.textDecoration == Style.TextDecoration.LineThrough);
            rendererState.fillPaint.setUnderlineText(style.textDecoration == Style.TextDecoration.Underline);
            if (SUPPORTS_STROKED_UNDERLINES) {
                rendererState.strokePaint.setStrikeThruText(style.textDecoration == Style.TextDecoration.LineThrough);
                rendererState.strokePaint.setUnderlineText(style.textDecoration == Style.TextDecoration.Underline);
            }
        }
        if (isSpecified(style, 68719476736L)) {
            rendererState.style.direction = style.direction;
        }
        if (isSpecified(style, PlaybackStateCompat.ACTION_SET_REPEAT_MODE)) {
            rendererState.style.textAnchor = style.textAnchor;
        }
        if (isSpecified(style, PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE_ENABLED)) {
            rendererState.style.overflow = style.overflow;
        }
        if (isSpecified(style, 2097152L)) {
            rendererState.style.markerStart = style.markerStart;
        }
        if (isSpecified(style, PlaybackStateCompat.ACTION_SET_PLAYBACK_SPEED)) {
            rendererState.style.markerMid = style.markerMid;
        }
        if (isSpecified(style, 8388608L)) {
            rendererState.style.markerEnd = style.markerEnd;
        }
        if (isSpecified(style, 16777216L)) {
            rendererState.style.display = style.display;
        }
        if (isSpecified(style, 33554432L)) {
            rendererState.style.visibility = style.visibility;
        }
        if (isSpecified(style, PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED)) {
            rendererState.style.clip = style.clip;
        }
        if (isSpecified(style, 268435456L)) {
            rendererState.style.clipPath = style.clipPath;
        }
        if (isSpecified(style, 536870912L)) {
            rendererState.style.clipRule = style.clipRule;
        }
        if (isSpecified(style, 1073741824L)) {
            rendererState.style.mask = style.mask;
        }
        if (isSpecified(style, 67108864L)) {
            rendererState.style.stopColor = style.stopColor;
        }
        if (isSpecified(style, 134217728L)) {
            rendererState.style.stopOpacity = style.stopOpacity;
        }
        if (isSpecified(style, 8589934592L)) {
            rendererState.style.viewportFill = style.viewportFill;
        }
        if (isSpecified(style, 17179869184L)) {
            rendererState.style.viewportFillOpacity = style.viewportFillOpacity;
        }
        if (isSpecified(style, 137438953472L)) {
            rendererState.style.imageRendering = style.imageRendering;
        }
        if (isSpecified(style, 274877906944L)) {
            rendererState.style.isolation = style.isolation;
        }
        if (isSpecified(style, 549755813888L)) {
            rendererState.style.mixBlendMode = style.mixBlendMode;
        }
        if (isSpecified(style, 562949953421312L)) {
            rendererState.style.fontKerning = style.fontKerning;
            rendererState.fontFeatureSet.applyKerning(style.fontKerning);
        }
        if (isSpecified(style, 35184372088832L)) {
            rendererState.style.fontFeatureSettings = style.fontFeatureSettings;
            rendererState.fontFeatureSet.applySettings(style.fontFeatureSettings);
        }
        if (isSpecified(style, 1099511627776L)) {
            rendererState.style.fontVariantLigatures = style.fontVariantLigatures;
            rendererState.fontFeatureSet.applySettings(style.fontVariantLigatures);
        }
        if (isSpecified(style, 2199023255552L)) {
            rendererState.style.fontVariantPosition = style.fontVariantPosition;
            rendererState.fontFeatureSet.applySettings(style.fontVariantPosition);
        }
        if (isSpecified(style, 4398046511104L)) {
            rendererState.style.fontVariantCaps = style.fontVariantCaps;
            rendererState.fontFeatureSet.applySettings(style.fontVariantCaps);
        }
        if (isSpecified(style, 8796093022208L)) {
            rendererState.style.fontVariantNumeric = style.fontVariantNumeric;
            rendererState.fontFeatureSet.applySettings(style.fontVariantNumeric);
        }
        if (isSpecified(style, 17592186044416L)) {
            rendererState.style.fontVariantEastAsian = style.fontVariantEastAsian;
            rendererState.fontFeatureSet.applySettings(style.fontVariantEastAsian);
        }
        if (SUPPORTS_PAINT_FONT_VARIATION_SETTINGS && isSpecified(style, 1125899906842624L)) {
            rendererState.style.fontVariationSettings = style.fontVariationSettings;
            rendererState.fontVariationSet.applySettings(style.fontVariationSettings);
        }
        if (isSpecified(style, 70368744177664L)) {
            rendererState.style.writingMode = style.writingMode;
        }
        if (isSpecified(style, 140737488355328L)) {
            rendererState.style.glyphOrientationVertical = style.glyphOrientationVertical;
        }
        if (isSpecified(style, 281474976710656L)) {
            rendererState.style.textOrientation = style.textOrientation;
        }
        if (isSpecified(style, 4503599627370496L)) {
            rendererState.style.letterSpacing = style.letterSpacing;
            if (SUPPORTS_PAINT_LETTER_SPACING) {
                rendererState.fillPaint.setLetterSpacing(style.letterSpacing.floatValue(this) / getCurrentFontSize());
                rendererState.strokePaint.setLetterSpacing(style.letterSpacing.floatValue(this) / getCurrentFontSize());
            }
        }
        if (isSpecified(style, 9007199254740992L)) {
            rendererState.style.wordSpacing = style.wordSpacing;
            if (SUPPORTS_PAINT_WORD_SPACING) {
                rendererState.fillPaint.setWordSpacing(style.wordSpacing.floatValue(this));
                rendererState.strokePaint.setWordSpacing(style.wordSpacing.floatValue(this));
            }
        }
    }

    /* JADX INFO: renamed from: net.pubnative.lite.sdk.utils.svgparser.utils.SVGAndroidRenderer$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$net$pubnative$lite$sdk$utils$svgparser$PreserveAspectRatio$Alignment;
        static final /* synthetic */ int[] $SwitchMap$net$pubnative$lite$sdk$utils$svgparser$utils$Style$CSSBlendMode;
        static final /* synthetic */ int[] $SwitchMap$net$pubnative$lite$sdk$utils$svgparser$utils$Style$LineCap;
        static final /* synthetic */ int[] $SwitchMap$net$pubnative$lite$sdk$utils$svgparser$utils$Style$LineJoin;

        static {
            int[] iArr = new int[Style.LineJoin.values().length];
            $SwitchMap$net$pubnative$lite$sdk$utils$svgparser$utils$Style$LineJoin = iArr;
            try {
                iArr[Style.LineJoin.Miter.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$net$pubnative$lite$sdk$utils$svgparser$utils$Style$LineJoin[Style.LineJoin.Round.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$net$pubnative$lite$sdk$utils$svgparser$utils$Style$LineJoin[Style.LineJoin.Bevel.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            int[] iArr2 = new int[Style.LineCap.values().length];
            $SwitchMap$net$pubnative$lite$sdk$utils$svgparser$utils$Style$LineCap = iArr2;
            try {
                iArr2[Style.LineCap.Butt.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$net$pubnative$lite$sdk$utils$svgparser$utils$Style$LineCap[Style.LineCap.Round.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$net$pubnative$lite$sdk$utils$svgparser$utils$Style$LineCap[Style.LineCap.Square.ordinal()] = 3;
            } catch (NoSuchFieldError unused6) {
            }
            int[] iArr3 = new int[PreserveAspectRatio.Alignment.values().length];
            $SwitchMap$net$pubnative$lite$sdk$utils$svgparser$PreserveAspectRatio$Alignment = iArr3;
            try {
                iArr3[PreserveAspectRatio.Alignment.xMidYMin.ordinal()] = 1;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$net$pubnative$lite$sdk$utils$svgparser$PreserveAspectRatio$Alignment[PreserveAspectRatio.Alignment.xMidYMid.ordinal()] = 2;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$net$pubnative$lite$sdk$utils$svgparser$PreserveAspectRatio$Alignment[PreserveAspectRatio.Alignment.xMidYMax.ordinal()] = 3;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$net$pubnative$lite$sdk$utils$svgparser$PreserveAspectRatio$Alignment[PreserveAspectRatio.Alignment.xMaxYMin.ordinal()] = 4;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$net$pubnative$lite$sdk$utils$svgparser$PreserveAspectRatio$Alignment[PreserveAspectRatio.Alignment.xMaxYMid.ordinal()] = 5;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                $SwitchMap$net$pubnative$lite$sdk$utils$svgparser$PreserveAspectRatio$Alignment[PreserveAspectRatio.Alignment.xMaxYMax.ordinal()] = 6;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                $SwitchMap$net$pubnative$lite$sdk$utils$svgparser$PreserveAspectRatio$Alignment[PreserveAspectRatio.Alignment.xMinYMid.ordinal()] = 7;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                $SwitchMap$net$pubnative$lite$sdk$utils$svgparser$PreserveAspectRatio$Alignment[PreserveAspectRatio.Alignment.xMinYMax.ordinal()] = 8;
            } catch (NoSuchFieldError unused14) {
            }
            int[] iArr4 = new int[Style.CSSBlendMode.values().length];
            $SwitchMap$net$pubnative$lite$sdk$utils$svgparser$utils$Style$CSSBlendMode = iArr4;
            try {
                iArr4[Style.CSSBlendMode.multiply.ordinal()] = 1;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                $SwitchMap$net$pubnative$lite$sdk$utils$svgparser$utils$Style$CSSBlendMode[Style.CSSBlendMode.screen.ordinal()] = 2;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                $SwitchMap$net$pubnative$lite$sdk$utils$svgparser$utils$Style$CSSBlendMode[Style.CSSBlendMode.overlay.ordinal()] = 3;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                $SwitchMap$net$pubnative$lite$sdk$utils$svgparser$utils$Style$CSSBlendMode[Style.CSSBlendMode.darken.ordinal()] = 4;
            } catch (NoSuchFieldError unused18) {
            }
            try {
                $SwitchMap$net$pubnative$lite$sdk$utils$svgparser$utils$Style$CSSBlendMode[Style.CSSBlendMode.lighten.ordinal()] = 5;
            } catch (NoSuchFieldError unused19) {
            }
            try {
                $SwitchMap$net$pubnative$lite$sdk$utils$svgparser$utils$Style$CSSBlendMode[Style.CSSBlendMode.color_dodge.ordinal()] = 6;
            } catch (NoSuchFieldError unused20) {
            }
            try {
                $SwitchMap$net$pubnative$lite$sdk$utils$svgparser$utils$Style$CSSBlendMode[Style.CSSBlendMode.color_burn.ordinal()] = 7;
            } catch (NoSuchFieldError unused21) {
            }
            try {
                $SwitchMap$net$pubnative$lite$sdk$utils$svgparser$utils$Style$CSSBlendMode[Style.CSSBlendMode.hard_light.ordinal()] = 8;
            } catch (NoSuchFieldError unused22) {
            }
            try {
                $SwitchMap$net$pubnative$lite$sdk$utils$svgparser$utils$Style$CSSBlendMode[Style.CSSBlendMode.soft_light.ordinal()] = 9;
            } catch (NoSuchFieldError unused23) {
            }
            try {
                $SwitchMap$net$pubnative$lite$sdk$utils$svgparser$utils$Style$CSSBlendMode[Style.CSSBlendMode.difference.ordinal()] = 10;
            } catch (NoSuchFieldError unused24) {
            }
            try {
                $SwitchMap$net$pubnative$lite$sdk$utils$svgparser$utils$Style$CSSBlendMode[Style.CSSBlendMode.exclusion.ordinal()] = 11;
            } catch (NoSuchFieldError unused25) {
            }
            try {
                $SwitchMap$net$pubnative$lite$sdk$utils$svgparser$utils$Style$CSSBlendMode[Style.CSSBlendMode.hue.ordinal()] = 12;
            } catch (NoSuchFieldError unused26) {
            }
            try {
                $SwitchMap$net$pubnative$lite$sdk$utils$svgparser$utils$Style$CSSBlendMode[Style.CSSBlendMode.saturation.ordinal()] = 13;
            } catch (NoSuchFieldError unused27) {
            }
            try {
                $SwitchMap$net$pubnative$lite$sdk$utils$svgparser$utils$Style$CSSBlendMode[Style.CSSBlendMode.color.ordinal()] = 14;
            } catch (NoSuchFieldError unused28) {
            }
            try {
                $SwitchMap$net$pubnative$lite$sdk$utils$svgparser$utils$Style$CSSBlendMode[Style.CSSBlendMode.luminosity.ordinal()] = 15;
            } catch (NoSuchFieldError unused29) {
            }
            try {
                $SwitchMap$net$pubnative$lite$sdk$utils$svgparser$utils$Style$CSSBlendMode[Style.CSSBlendMode.normal.ordinal()] = 16;
            } catch (NoSuchFieldError unused30) {
            }
        }
    }

    private void setPaintColour(RendererState rendererState, boolean z, SVGBase.SvgPaint svgPaint) {
        int i;
        Style style = rendererState.style;
        float fFloatValue = (z ? style.fillOpacity : style.strokeOpacity).floatValue();
        if (svgPaint instanceof SVGBase.Colour) {
            i = ((SVGBase.Colour) svgPaint).colour;
        } else if (!(svgPaint instanceof SVGBase.CurrentColor)) {
            return;
        } else {
            i = rendererState.style.color.colour;
        }
        int iColourWithOpacity = colourWithOpacity(i, fFloatValue);
        if (z) {
            rendererState.fillPaint.setColor(iColourWithOpacity);
        } else {
            rendererState.strokePaint.setColor(iColourWithOpacity);
        }
    }

    private Typeface checkGenericFont(String str, Float f, Style.FontStyle fontStyle) {
        int i;
        boolean z = fontStyle == Style.FontStyle.italic;
        if (f.floatValue() >= 700.0f) {
            i = z ? 3 : 1;
        } else {
            i = z ? 2 : 0;
        }
        str.hashCode();
        switch (str) {
            case "sans-serif":
            case "fantasy":
            case "cursive":
                return Typeface.create(Typeface.SANS_SERIF, i);
            case "monospace":
                return Typeface.create(Typeface.MONOSPACE, i);
            case "serif":
                return Typeface.create(Typeface.SERIF, i);
            default:
                return null;
        }
    }

    private static int clamp255(float f) {
        int i = (int) (f * 256.0f);
        if (i < 0) {
            return 0;
        }
        return Math.min(i, 255);
    }

    private static int colourWithOpacity(int i, float f) {
        int iRound = Math.round(((i >> 24) & 255) * f);
        return (i & ViewCompat.MEASURED_SIZE_MASK) | ((iRound < 0 ? 0 : Math.min(iRound, 255)) << 24);
    }

    private Path.FillType getFillTypeFromState() {
        if (this.state.style.fillRule != null && this.state.style.fillRule == Style.FillRule.EvenOdd) {
            return Path.FillType.EVEN_ODD;
        }
        return Path.FillType.WINDING;
    }

    private void setClipRect(float f, float f2, float f3, float f4) {
        float fFloatValueX = f3 + f;
        float fFloatValueY = f4 + f2;
        if (this.state.style.clip != null) {
            f += this.state.style.clip.left.floatValueX(this);
            f2 += this.state.style.clip.top.floatValueY(this);
            fFloatValueX -= this.state.style.clip.right.floatValueX(this);
            fFloatValueY -= this.state.style.clip.bottom.floatValueY(this);
        }
        this.canvas.clipRect(f, f2, fFloatValueX, fFloatValueY);
    }

    private void viewportFill() {
        int iColourWithOpacity;
        if (this.state.style.viewportFill instanceof SVGBase.Colour) {
            iColourWithOpacity = ((SVGBase.Colour) this.state.style.viewportFill).colour;
        } else if (!(this.state.style.viewportFill instanceof SVGBase.CurrentColor)) {
            return;
        } else {
            iColourWithOpacity = this.state.style.color.colour;
        }
        if (this.state.style.viewportFillOpacity != null) {
            iColourWithOpacity = colourWithOpacity(iColourWithOpacity, this.state.style.viewportFillOpacity.floatValue());
        }
        this.canvas.drawColor(iColourWithOpacity);
    }

    protected static class PathConverter implements SVGBase.PathInterface {
        float lastX;
        float lastY;
        final Path path = new Path();

        PathConverter(SVGBase.PathDefinition pathDefinition) {
            if (pathDefinition == null) {
                return;
            }
            pathDefinition.enumeratePath(this);
        }

        Path getPath() {
            return this.path;
        }

        @Override // net.pubnative.lite.sdk.utils.svgparser.utils.SVGBase.PathInterface
        public void moveTo(float f, float f2) {
            this.path.moveTo(f, f2);
            this.lastX = f;
            this.lastY = f2;
        }

        @Override // net.pubnative.lite.sdk.utils.svgparser.utils.SVGBase.PathInterface
        public void lineTo(float f, float f2) {
            this.path.lineTo(f, f2);
            this.lastX = f;
            this.lastY = f2;
        }

        @Override // net.pubnative.lite.sdk.utils.svgparser.utils.SVGBase.PathInterface
        public void cubicTo(float f, float f2, float f3, float f4, float f5, float f6) {
            this.path.cubicTo(f, f2, f3, f4, f5, f6);
            this.lastX = f5;
            this.lastY = f6;
        }

        @Override // net.pubnative.lite.sdk.utils.svgparser.utils.SVGBase.PathInterface
        public void quadTo(float f, float f2, float f3, float f4) {
            this.path.quadTo(f, f2, f3, f4);
            this.lastX = f3;
            this.lastY = f4;
        }

        @Override // net.pubnative.lite.sdk.utils.svgparser.utils.SVGBase.PathInterface
        public void arcTo(float f, float f2, float f3, boolean z, boolean z2, float f4, float f5) {
            SVGAndroidRenderer.arcTo(this.lastX, this.lastY, f, f2, f3, z, z2, f4, f5, this);
            this.lastX = f4;
            this.lastY = f5;
        }

        @Override // net.pubnative.lite.sdk.utils.svgparser.utils.SVGBase.PathInterface
        public void close() {
            this.path.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void arcTo(float f, float f2, float f3, float f4, float f5, boolean z, boolean z2, float f6, float f7, SVGBase.PathInterface pathInterface) {
        if (f == f6 && f2 == f7) {
            return;
        }
        if (f3 == 0.0f || f4 == 0.0f) {
            pathInterface.lineTo(f6, f7);
            return;
        }
        float fAbs = Math.abs(f3);
        float fAbs2 = Math.abs(f4);
        double radians = Math.toRadians(((double) f5) % 360.0d);
        double dCos = Math.cos(radians);
        double dSin = Math.sin(radians);
        double d = ((double) (f - f6)) / 2.0d;
        double d2 = ((double) (f2 - f7)) / 2.0d;
        double d3 = (dCos * d) + (dSin * d2);
        double d4 = ((-dSin) * d) + (d2 * dCos);
        double d5 = fAbs * fAbs;
        double d6 = fAbs2 * fAbs2;
        double d7 = d3 * d3;
        double d8 = d4 * d4;
        double d9 = (d7 / d5) + (d8 / d6);
        if (d9 > 0.99999d) {
            double dSqrt = Math.sqrt(d9) * 1.00001d;
            fAbs = (float) (((double) fAbs) * dSqrt);
            fAbs2 = (float) (dSqrt * ((double) fAbs2));
            d5 = fAbs * fAbs;
            d6 = fAbs2 * fAbs2;
        }
        double d10 = z == z2 ? -1.0d : 1.0d;
        double d11 = d5 * d6;
        double d12 = d5 * d8;
        double d13 = d6 * d7;
        double d14 = ((d11 - d12) - d13) / (d12 + d13);
        if (d14 < 0.0d) {
            d14 = 0.0d;
        }
        double dSqrt2 = d10 * Math.sqrt(d14);
        double d15 = fAbs;
        double d16 = fAbs2;
        double d17 = ((d15 * d4) / d16) * dSqrt2;
        float f8 = fAbs;
        float f9 = fAbs2;
        double d18 = dSqrt2 * (-((d16 * d3) / d15));
        double d19 = (((double) (f + f6)) / 2.0d) + ((dCos * d17) - (dSin * d18));
        double d20 = (((double) (f2 + f7)) / 2.0d) + (dSin * d17) + (dCos * d18);
        double d21 = (d3 - d17) / d15;
        double d22 = (d4 - d18) / d16;
        double d23 = ((-d3) - d17) / d15;
        double d24 = ((-d4) - d18) / d16;
        double d25 = (d21 * d21) + (d22 * d22);
        double dAcos = (d22 < 0.0d ? -1.0d : 1.0d) * Math.acos(d21 / Math.sqrt(d25));
        double dCheckedArcCos = ((d21 * d24) - (d22 * d23) >= 0.0d ? 1.0d : -1.0d) * checkedArcCos(((d21 * d23) + (d22 * d24)) / Math.sqrt(d25 * ((d23 * d23) + (d24 * d24))));
        if (dCheckedArcCos == 0.0d) {
            pathInterface.lineTo(f6, f7);
            return;
        }
        if (!z2 && dCheckedArcCos > 0.0d) {
            dCheckedArcCos -= 6.283185307179586d;
        } else if (z2 && dCheckedArcCos < 0.0d) {
            dCheckedArcCos += 6.283185307179586d;
        }
        float[] fArrArcToBeziers = arcToBeziers(dAcos % 6.283185307179586d, dCheckedArcCos % 6.283185307179586d);
        Matrix matrix = new Matrix();
        matrix.postScale(f8, f9);
        matrix.postRotate(f5);
        matrix.postTranslate((float) d19, (float) d20);
        matrix.mapPoints(fArrArcToBeziers);
        fArrArcToBeziers[fArrArcToBeziers.length - 2] = f6;
        fArrArcToBeziers[fArrArcToBeziers.length - 1] = f7;
        for (int i = 0; i < fArrArcToBeziers.length; i += 6) {
            pathInterface.cubicTo(fArrArcToBeziers[i], fArrArcToBeziers[i + 1], fArrArcToBeziers[i + 2], fArrArcToBeziers[i + 3], fArrArcToBeziers[i + 4], fArrArcToBeziers[i + 5]);
        }
    }

    private static double checkedArcCos(double d) {
        if (d < -1.0d) {
            return 3.141592653589793d;
        }
        if (d > 1.0d) {
            return 0.0d;
        }
        return Math.acos(d);
    }

    private static float[] arcToBeziers(double d, double d2) {
        int iCeil = (int) Math.ceil((Math.abs(d2) * 2.0d) / 3.141592653589793d);
        double d3 = d2 / ((double) iCeil);
        double d4 = d3 / 2.0d;
        double dSin = (Math.sin(d4) * 1.3333333333333333d) / (Math.cos(d4) + 1.0d);
        float[] fArr = new float[iCeil * 6];
        int i = 0;
        int i2 = 0;
        while (i < iCeil) {
            double d5 = d + (((double) i) * d3);
            double dCos = Math.cos(d5);
            double dSin2 = Math.sin(d5);
            double d6 = d3;
            fArr[i2] = (float) (dCos - (dSin * dSin2));
            fArr[i2 + 1] = (float) (dSin2 + (dCos * dSin));
            double d7 = d5 + d6;
            double dCos2 = Math.cos(d7);
            double dSin3 = Math.sin(d7);
            fArr[i2 + 2] = (float) ((dSin * dSin3) + dCos2);
            fArr[i2 + 3] = (float) (dSin3 - (dSin * dCos2));
            int i3 = i2 + 5;
            fArr[i2 + 4] = (float) dCos2;
            i2 += 6;
            fArr[i3] = (float) dSin3;
            i++;
            d3 = d6;
        }
        return fArr;
    }

    private static class MarkerVector {
        float dx;
        float dy;
        boolean isAmbiguous = false;
        final float x;
        final float y;

        MarkerVector(float f, float f2, float f3, float f4) {
            this.dx = 0.0f;
            this.dy = 0.0f;
            this.x = f;
            this.y = f2;
            double dSqrt = Math.sqrt((f3 * f3) + (f4 * f4));
            if (dSqrt != 0.0d) {
                this.dx = (float) (((double) f3) / dSqrt);
                this.dy = (float) (((double) f4) / dSqrt);
            }
        }

        void add(float f, float f2) {
            float f3 = f - this.x;
            float f4 = f2 - this.y;
            double dSqrt = Math.sqrt((f3 * f3) + (f4 * f4));
            if (dSqrt != 0.0d) {
                f3 = (float) (((double) f3) / dSqrt);
                f4 = (float) (((double) f4) / dSqrt);
            }
            float f5 = this.dx;
            if (f3 == (-f5) && f4 == (-this.dy)) {
                this.isAmbiguous = true;
                this.dx = -f4;
                this.dy = f3;
            } else {
                this.dx = f5 + f3;
                this.dy += f4;
            }
        }

        void add(MarkerVector markerVector) {
            float f = markerVector.dx;
            float f2 = this.dx;
            if (f == (-f2)) {
                float f3 = markerVector.dy;
                if (f3 == (-this.dy)) {
                    this.isAmbiguous = true;
                    this.dx = -f3;
                    this.dy = markerVector.dx;
                    return;
                }
            }
            this.dx = f2 + f;
            this.dy += markerVector.dy;
        }

        public String toString() {
            return "(" + this.x + StringUtils.COMMA + this.y + " " + this.dx + StringUtils.COMMA + this.dy + ")";
        }
    }

    private class MarkerPositionCalculator implements SVGBase.PathInterface {
        private boolean closepathReAdjustPending;
        private MarkerVector lastPos;
        private final List<MarkerVector> markers;
        private boolean normalCubic;
        private boolean startArc;
        private float startX;
        private float startY;
        private int subpathStartIndex;

        MarkerPositionCalculator(SVGBase.PathDefinition pathDefinition) {
            ArrayList arrayList = new ArrayList();
            this.markers = arrayList;
            this.lastPos = null;
            this.startArc = false;
            this.normalCubic = true;
            this.subpathStartIndex = -1;
            if (pathDefinition == null) {
                return;
            }
            pathDefinition.enumeratePath(this);
            if (this.closepathReAdjustPending) {
                this.lastPos.add((MarkerVector) arrayList.get(this.subpathStartIndex));
                arrayList.set(this.subpathStartIndex, this.lastPos);
                this.closepathReAdjustPending = false;
            }
            MarkerVector markerVector = this.lastPos;
            if (markerVector != null) {
                arrayList.add(markerVector);
            }
        }

        List<MarkerVector> getMarkers() {
            return this.markers;
        }

        @Override // net.pubnative.lite.sdk.utils.svgparser.utils.SVGBase.PathInterface
        public void moveTo(float f, float f2) {
            if (this.closepathReAdjustPending) {
                this.lastPos.add(this.markers.get(this.subpathStartIndex));
                this.markers.set(this.subpathStartIndex, this.lastPos);
                this.closepathReAdjustPending = false;
            }
            MarkerVector markerVector = this.lastPos;
            if (markerVector != null) {
                this.markers.add(markerVector);
            }
            this.startX = f;
            this.startY = f2;
            this.lastPos = new MarkerVector(f, f2, 0.0f, 0.0f);
            this.subpathStartIndex = this.markers.size();
        }

        @Override // net.pubnative.lite.sdk.utils.svgparser.utils.SVGBase.PathInterface
        public void lineTo(float f, float f2) {
            this.lastPos.add(f, f2);
            this.markers.add(this.lastPos);
            this.lastPos = new MarkerVector(f, f2, f - this.lastPos.x, f2 - this.lastPos.y);
            this.closepathReAdjustPending = false;
        }

        @Override // net.pubnative.lite.sdk.utils.svgparser.utils.SVGBase.PathInterface
        public void cubicTo(float f, float f2, float f3, float f4, float f5, float f6) {
            if (this.normalCubic || this.startArc) {
                this.lastPos.add(f, f2);
                this.markers.add(this.lastPos);
                this.startArc = false;
            }
            this.lastPos = new MarkerVector(f5, f6, f5 - f3, f6 - f4);
            this.closepathReAdjustPending = false;
        }

        @Override // net.pubnative.lite.sdk.utils.svgparser.utils.SVGBase.PathInterface
        public void quadTo(float f, float f2, float f3, float f4) {
            this.lastPos.add(f, f2);
            this.markers.add(this.lastPos);
            this.lastPos = new MarkerVector(f3, f4, f3 - f, f4 - f2);
            this.closepathReAdjustPending = false;
        }

        @Override // net.pubnative.lite.sdk.utils.svgparser.utils.SVGBase.PathInterface
        public void arcTo(float f, float f2, float f3, boolean z, boolean z2, float f4, float f5) {
            this.startArc = true;
            this.normalCubic = false;
            SVGAndroidRenderer.arcTo(this.lastPos.x, this.lastPos.y, f, f2, f3, z, z2, f4, f5, this);
            this.normalCubic = true;
            this.closepathReAdjustPending = false;
        }

        @Override // net.pubnative.lite.sdk.utils.svgparser.utils.SVGBase.PathInterface
        public void close() {
            this.markers.add(this.lastPos);
            lineTo(this.startX, this.startY);
            this.closepathReAdjustPending = true;
        }
    }

    private void renderMarkers(SVGBase.GraphicsElement graphicsElement) {
        SVGBase.Marker marker;
        SVGBase.Marker marker2;
        SVGBase.Marker marker3;
        List<MarkerVector> listCalculateMarkerPositions;
        int size;
        if (this.state.style.markerStart == null && this.state.style.markerMid == null && this.state.style.markerEnd == null) {
            return;
        }
        if (this.state.style.markerStart == null) {
            marker = null;
        } else {
            SVGBase.SvgObject svgObjectResolveIRI = graphicsElement.document.resolveIRI(this.state.style.markerStart);
            if (svgObjectResolveIRI != null) {
                marker = (SVGBase.Marker) svgObjectResolveIRI;
            } else {
                error("Marker reference '%s' not found", this.state.style.markerStart);
                marker = null;
            }
        }
        if (this.state.style.markerMid == null) {
            marker2 = null;
        } else {
            SVGBase.SvgObject svgObjectResolveIRI2 = graphicsElement.document.resolveIRI(this.state.style.markerMid);
            if (svgObjectResolveIRI2 != null) {
                marker2 = (SVGBase.Marker) svgObjectResolveIRI2;
            } else {
                error("Marker reference '%s' not found", this.state.style.markerMid);
                marker2 = null;
            }
        }
        if (this.state.style.markerEnd == null) {
            marker3 = null;
        } else {
            SVGBase.SvgObject svgObjectResolveIRI3 = graphicsElement.document.resolveIRI(this.state.style.markerEnd);
            if (svgObjectResolveIRI3 != null) {
                marker3 = (SVGBase.Marker) svgObjectResolveIRI3;
            } else {
                error("Marker reference '%s' not found", this.state.style.markerEnd);
                marker3 = null;
            }
        }
        if (graphicsElement instanceof SVGBase.Path) {
            listCalculateMarkerPositions = new MarkerPositionCalculator(((SVGBase.Path) graphicsElement).d).getMarkers();
        } else if (graphicsElement instanceof SVGBase.Line) {
            listCalculateMarkerPositions = calculateMarkerPositions((SVGBase.Line) graphicsElement);
        } else {
            listCalculateMarkerPositions = calculateMarkerPositions((SVGBase.PolyLine) graphicsElement);
        }
        if (listCalculateMarkerPositions == null || (size = listCalculateMarkerPositions.size()) == 0) {
            return;
        }
        Style style = this.state.style;
        Style style2 = this.state.style;
        this.state.style.markerEnd = null;
        style2.markerMid = null;
        style.markerStart = null;
        if (marker != null) {
            renderMarker(marker, listCalculateMarkerPositions.get(0));
        }
        if (marker2 != null && listCalculateMarkerPositions.size() > 2) {
            MarkerVector markerVectorRealignMarkerMid = listCalculateMarkerPositions.get(0);
            MarkerVector markerVector = listCalculateMarkerPositions.get(1);
            int i = 1;
            while (i < size - 1) {
                i++;
                MarkerVector markerVector2 = listCalculateMarkerPositions.get(i);
                markerVectorRealignMarkerMid = markerVector.isAmbiguous ? realignMarkerMid(markerVectorRealignMarkerMid, markerVector, markerVector2) : markerVector;
                renderMarker(marker2, markerVectorRealignMarkerMid);
                markerVector = markerVector2;
            }
        }
        if (marker3 != null) {
            renderMarker(marker3, listCalculateMarkerPositions.get(size - 1));
        }
    }

    private MarkerVector realignMarkerMid(MarkerVector markerVector, MarkerVector markerVector2, MarkerVector markerVector3) {
        float fDotProduct = dotProduct(markerVector2.dx, markerVector2.dy, markerVector2.x - markerVector.x, markerVector2.y - markerVector.y);
        if (fDotProduct == 0.0f) {
            fDotProduct = dotProduct(markerVector2.dx, markerVector2.dy, markerVector3.x - markerVector2.x, markerVector3.y - markerVector2.y);
        }
        if (fDotProduct > 0.0f) {
            return markerVector2;
        }
        if (fDotProduct == 0.0f && (markerVector2.dx > 0.0f || markerVector2.dy >= 0.0f)) {
            return markerVector2;
        }
        markerVector2.dx = -markerVector2.dx;
        markerVector2.dy = -markerVector2.dy;
        return markerVector2;
    }

    /* JADX WARN: Code duplicated, block: B:12:0x0037  */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x0114, code lost:
    
        if (r7 != 8) goto L67;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void renderMarker(net.pubnative.lite.sdk.utils.svgparser.utils.SVGBase.Marker r11, net.pubnative.lite.sdk.utils.svgparser.utils.SVGAndroidRenderer.MarkerVector r12) {
        /*
            Method dump skipped, instruction units count: 372
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: net.pubnative.lite.sdk.utils.svgparser.utils.SVGAndroidRenderer.renderMarker(net.pubnative.lite.sdk.utils.svgparser.utils.SVGBase$Marker, net.pubnative.lite.sdk.utils.svgparser.utils.SVGAndroidRenderer$MarkerVector):void");
    }

    private RendererState findInheritFromAncestorState(SVGBase.SvgObject svgObject) {
        RendererState rendererState = new RendererState();
        updateStyle(rendererState, Style.getDefaultStyle());
        return findInheritFromAncestorState(svgObject, rendererState);
    }

    private RendererState findInheritFromAncestorState(SVGBase.SvgObject svgObject, RendererState rendererState) {
        ArrayList arrayList = new ArrayList();
        while (true) {
            if (svgObject instanceof SVGBase.SvgElementBase) {
                arrayList.add(0, (SVGBase.SvgElementBase) svgObject);
            }
            if (svgObject.parent == null) {
                break;
            }
            svgObject = (SVGBase.SvgObject) svgObject.parent;
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            updateStyleForElement(rendererState, (SVGBase.SvgElementBase) it.next());
        }
        rendererState.viewBox = this.state.viewBox;
        rendererState.viewPort = this.state.viewPort;
        return rendererState;
    }

    private void checkForGradientsAndPatterns(SVGBase.SvgElement svgElement) {
        if (this.state.style.fill instanceof SVGBase.PaintReference) {
            decodePaintReference(true, svgElement.boundingBox, (SVGBase.PaintReference) this.state.style.fill);
        }
        if (this.state.style.stroke instanceof SVGBase.PaintReference) {
            decodePaintReference(false, svgElement.boundingBox, (SVGBase.PaintReference) this.state.style.stroke);
        }
    }

    private void decodePaintReference(boolean z, SVGBase.Box box, SVGBase.PaintReference paintReference) {
        SVGBase.SvgObject svgObjectResolveIRI = this.document.resolveIRI(paintReference.href);
        if (svgObjectResolveIRI == null) {
            error("%s reference '%s' not found", z ? "Fill" : "Stroke", paintReference.href);
            if (paintReference.fallback != null) {
                setPaintColour(this.state, z, paintReference.fallback);
                return;
            } else if (z) {
                this.state.hasFill = false;
                return;
            } else {
                this.state.hasStroke = false;
                return;
            }
        }
        if (svgObjectResolveIRI instanceof SVGBase.SvgLinearGradient) {
            makeLinearGradient(z, box, (SVGBase.SvgLinearGradient) svgObjectResolveIRI);
        } else if (svgObjectResolveIRI instanceof SVGBase.SvgRadialGradient) {
            makeRadialGradient(z, box, (SVGBase.SvgRadialGradient) svgObjectResolveIRI);
        } else if (svgObjectResolveIRI instanceof SVGBase.SolidColor) {
            setSolidColor(z, (SVGBase.SolidColor) svgObjectResolveIRI);
        }
    }

    private void makeLinearGradient(boolean z, SVGBase.Box box, SVGBase.SvgLinearGradient svgLinearGradient) {
        float f;
        float fFloatValue;
        float f2;
        float fFloatValueX;
        if (svgLinearGradient.href != null) {
            fillInChainedGradientFields(svgLinearGradient, svgLinearGradient.href);
        }
        int i = 0;
        boolean z2 = svgLinearGradient.gradientUnitsAreUser != null && svgLinearGradient.gradientUnitsAreUser.booleanValue();
        RendererState rendererState = this.state;
        Paint paint = z ? rendererState.fillPaint : rendererState.strokePaint;
        if (z2) {
            float fFloatValueX2 = svgLinearGradient.x1 != null ? svgLinearGradient.x1.floatValueX(this) : 0.0f;
            float fFloatValueY = svgLinearGradient.y1 != null ? svgLinearGradient.y1.floatValueY(this) : 0.0f;
            f = fFloatValueX2;
            f2 = fFloatValueY;
            fFloatValueX = (svgLinearGradient.x2 != null ? svgLinearGradient.x2 : SVGBase.Length.PERCENT_100).floatValueX(this);
            fFloatValue = svgLinearGradient.y2 != null ? svgLinearGradient.y2.floatValueY(this) : 0.0f;
        } else {
            float fFloatValue2 = svgLinearGradient.x1 != null ? svgLinearGradient.x1.floatValue(this, 1.0f) : 0.0f;
            float fFloatValue3 = svgLinearGradient.y1 != null ? svgLinearGradient.y1.floatValue(this, 1.0f) : 0.0f;
            float fFloatValue4 = svgLinearGradient.x2 != null ? svgLinearGradient.x2.floatValue(this, 1.0f) : 1.0f;
            f = fFloatValue2;
            fFloatValue = svgLinearGradient.y2 != null ? svgLinearGradient.y2.floatValue(this, 1.0f) : 0.0f;
            f2 = fFloatValue3;
            fFloatValueX = fFloatValue4;
        }
        statePush();
        this.state = findInheritFromAncestorState(svgLinearGradient);
        Matrix matrix = new Matrix();
        if (!z2) {
            matrix.preTranslate(box.minX, box.minY);
            matrix.preScale(box.width, box.height);
        }
        if (svgLinearGradient.gradientTransform != null) {
            matrix.preConcat(svgLinearGradient.gradientTransform);
        }
        int size = svgLinearGradient.children.size();
        if (size == 0) {
            statePop();
            if (z) {
                this.state.hasFill = false;
                return;
            } else {
                this.state.hasStroke = false;
                return;
            }
        }
        int[] iArr = new int[size];
        float[] fArr = new float[size];
        Iterator<SVGBase.SvgObject> it = svgLinearGradient.children.iterator();
        float f3 = -1.0f;
        while (it.hasNext()) {
            SVGBase.Stop stop = (SVGBase.Stop) it.next();
            float fFloatValue5 = stop.offset != null ? stop.offset.floatValue() : 0.0f;
            if (i == 0 || fFloatValue5 >= f3) {
                fArr[i] = fFloatValue5;
                f3 = fFloatValue5;
            } else {
                fArr[i] = f3;
            }
            statePush();
            updateStyleForElement(this.state, stop);
            SVGBase.Colour colour = (SVGBase.Colour) this.state.style.stopColor;
            if (colour == null) {
                colour = SVGBase.Colour.BLACK;
            }
            iArr[i] = colourWithOpacity(colour.colour, this.state.style.stopOpacity.floatValue());
            i++;
            statePop();
        }
        if ((f == fFloatValueX && f2 == fFloatValue) || size == 1) {
            statePop();
            paint.setColor(iArr[size - 1]);
            return;
        }
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        if (svgLinearGradient.spreadMethod != null) {
            if (svgLinearGradient.spreadMethod == SVGBase.GradientSpread.reflect) {
                tileMode = Shader.TileMode.MIRROR;
            } else if (svgLinearGradient.spreadMethod == SVGBase.GradientSpread.repeat) {
                tileMode = Shader.TileMode.REPEAT;
            }
        }
        statePop();
        LinearGradient linearGradient = new LinearGradient(f, f2, fFloatValueX, fFloatValue, iArr, fArr, tileMode);
        linearGradient.setLocalMatrix(matrix);
        paint.setShader(linearGradient);
        paint.setAlpha(clamp255(this.state.style.fillOpacity.floatValue()));
    }

    private void makeRadialGradient(boolean z, SVGBase.Box box, SVGBase.SvgRadialGradient svgRadialGradient) {
        float fFloatValue;
        float fFloatValue2;
        float fFloatValue3;
        float f;
        float fFloatValue4;
        float fFloatValue5;
        int[] iArr;
        long[] jArr;
        float fFloatValueX;
        float fFloatValueY;
        float fFloatValue6;
        if (svgRadialGradient.href != null) {
            fillInChainedGradientFields(svgRadialGradient, svgRadialGradient.href);
        }
        int i = 0;
        boolean z2 = svgRadialGradient.gradientUnitsAreUser != null && svgRadialGradient.gradientUnitsAreUser.booleanValue();
        RendererState rendererState = this.state;
        Paint paint = z ? rendererState.fillPaint : rendererState.strokePaint;
        if (z2) {
            SVGBase.Length length = new SVGBase.Length(50.0f, SVGBase.Unit.percent);
            float fFloatValueX2 = svgRadialGradient.cx != null ? svgRadialGradient.cx.floatValueX(this) : length.floatValueX(this);
            float fFloatValueY2 = svgRadialGradient.cy != null ? svgRadialGradient.cy.floatValueY(this) : length.floatValueY(this);
            if (svgRadialGradient.r != null) {
                length = svgRadialGradient.r;
            }
            float fFloatValue7 = length.floatValue(this);
            if (SUPPORTS_RADIAL_GRADIENT_WITH_FOCUS) {
                fFloatValueX = svgRadialGradient.fx != null ? svgRadialGradient.fx.floatValueX(this) : fFloatValueX2;
                fFloatValueY = svgRadialGradient.fy != null ? svgRadialGradient.fy.floatValueY(this) : fFloatValueY2;
                fFloatValue6 = svgRadialGradient.fr != null ? svgRadialGradient.fr.floatValue(this) : 0.0f;
            } else {
                fFloatValueX = 0.0f;
                fFloatValueY = 0.0f;
                fFloatValue6 = 0.0f;
            }
            f = fFloatValueX;
            fFloatValue4 = fFloatValueY;
            fFloatValue5 = fFloatValue6;
            fFloatValue3 = fFloatValue7;
            fFloatValue = fFloatValueX2;
            fFloatValue2 = fFloatValueY2;
        } else {
            fFloatValue = svgRadialGradient.cx != null ? svgRadialGradient.cx.floatValue(this, 1.0f) : 0.5f;
            fFloatValue2 = svgRadialGradient.cy != null ? svgRadialGradient.cy.floatValue(this, 1.0f) : 0.5f;
            fFloatValue3 = svgRadialGradient.r != null ? svgRadialGradient.r.floatValue(this, 1.0f) : 0.5f;
            if (SUPPORTS_RADIAL_GRADIENT_WITH_FOCUS) {
                float fFloatValue8 = svgRadialGradient.fx != null ? svgRadialGradient.fx.floatValue(this, 1.0f) : 0.5f;
                fFloatValue4 = svgRadialGradient.fy != null ? svgRadialGradient.fy.floatValue(this, 1.0f) : 0.5f;
                fFloatValue5 = svgRadialGradient.fr != null ? svgRadialGradient.fr.floatValue(this, 1.0f) : 0.0f;
                f = fFloatValue8;
            } else {
                f = 0.0f;
                fFloatValue4 = 0.0f;
                fFloatValue5 = 0.0f;
            }
        }
        statePush();
        this.state = findInheritFromAncestorState(svgRadialGradient);
        Matrix matrix = new Matrix();
        if (!z2) {
            matrix.preTranslate(box.minX, box.minY);
            matrix.preScale(box.width, box.height);
        }
        if (svgRadialGradient.gradientTransform != null) {
            matrix.preConcat(svgRadialGradient.gradientTransform);
        }
        int size = svgRadialGradient.children.size();
        if (size == 0) {
            statePop();
            if (z) {
                this.state.hasFill = false;
                return;
            } else {
                this.state.hasStroke = false;
                return;
            }
        }
        if (SUPPORTS_RADIAL_GRADIENT_WITH_FOCUS) {
            jArr = new long[size];
            iArr = null;
        } else {
            iArr = new int[size];
            jArr = null;
        }
        float[] fArr = new float[size];
        Iterator<SVGBase.SvgObject> it = svgRadialGradient.children.iterator();
        float f2 = -1.0f;
        while (it.hasNext()) {
            SVGBase.Stop stop = (SVGBase.Stop) it.next();
            float fFloatValue9 = stop.offset != null ? stop.offset.floatValue() : 0.0f;
            if (i == 0 || fFloatValue9 >= f2) {
                fArr[i] = fFloatValue9;
                f2 = fFloatValue9;
            } else {
                fArr[i] = f2;
            }
            statePush();
            updateStyleForElement(this.state, stop);
            SVGBase.Colour colour = (SVGBase.Colour) this.state.style.stopColor;
            if (colour == null) {
                colour = SVGBase.Colour.BLACK;
            }
            if (SUPPORTS_RADIAL_GRADIENT_WITH_FOCUS) {
                jArr[i] = Color.pack(colourWithOpacity(colour.colour, this.state.style.stopOpacity.floatValue()));
            } else {
                iArr[i] = colourWithOpacity(colour.colour, this.state.style.stopOpacity.floatValue());
            }
            i++;
            statePop();
        }
        if (fFloatValue3 == 0.0f || size == 1) {
            statePop();
            paint.setColor(iArr[size - 1]);
            return;
        }
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        if (svgRadialGradient.spreadMethod != null) {
            if (svgRadialGradient.spreadMethod == SVGBase.GradientSpread.reflect) {
                tileMode = Shader.TileMode.MIRROR;
            } else if (svgRadialGradient.spreadMethod == SVGBase.GradientSpread.repeat) {
                tileMode = Shader.TileMode.REPEAT;
            }
        }
        statePop();
        RadialGradient radialGradient = SUPPORTS_RADIAL_GRADIENT_WITH_FOCUS ? new RadialGradient(f, fFloatValue4, fFloatValue5, fFloatValue, fFloatValue2, fFloatValue3, jArr, fArr, tileMode) : new RadialGradient(fFloatValue, fFloatValue2, fFloatValue3, iArr, fArr, tileMode);
        radialGradient.setLocalMatrix(matrix);
        paint.setShader(radialGradient);
        paint.setAlpha(clamp255(this.state.style.fillOpacity.floatValue()));
    }

    private void fillInChainedGradientFields(SVGBase.GradientElement gradientElement, String str) {
        SVGBase.SvgObject svgObjectResolveIRI = gradientElement.document.resolveIRI(str);
        if (svgObjectResolveIRI == null) {
            warn("Gradient reference '%s' not found", str);
            return;
        }
        if (!(svgObjectResolveIRI instanceof SVGBase.GradientElement)) {
            error("Gradient href attributes must point to other gradient elements", new Object[0]);
            return;
        }
        if (svgObjectResolveIRI == gradientElement) {
            error("Circular reference in gradient href attribute '%s'", str);
            return;
        }
        SVGBase.GradientElement gradientElement2 = (SVGBase.GradientElement) svgObjectResolveIRI;
        if (gradientElement.gradientUnitsAreUser == null) {
            gradientElement.gradientUnitsAreUser = gradientElement2.gradientUnitsAreUser;
        }
        if (gradientElement.gradientTransform == null) {
            gradientElement.gradientTransform = gradientElement2.gradientTransform;
        }
        if (gradientElement.spreadMethod == null) {
            gradientElement.spreadMethod = gradientElement2.spreadMethod;
        }
        if (gradientElement.children.isEmpty()) {
            gradientElement.children = gradientElement2.children;
        }
        try {
            if (gradientElement instanceof SVGBase.SvgLinearGradient) {
                fillInChainedGradientFields((SVGBase.SvgLinearGradient) gradientElement, (SVGBase.SvgLinearGradient) svgObjectResolveIRI);
            } else {
                fillInChainedGradientFields((SVGBase.SvgRadialGradient) gradientElement, (SVGBase.SvgRadialGradient) svgObjectResolveIRI);
            }
        } catch (ClassCastException unused) {
        }
        if (gradientElement2.href != null) {
            fillInChainedGradientFields(gradientElement, gradientElement2.href);
        }
    }

    private void fillInChainedGradientFields(SVGBase.SvgLinearGradient svgLinearGradient, SVGBase.SvgLinearGradient svgLinearGradient2) {
        if (svgLinearGradient.x1 == null) {
            svgLinearGradient.x1 = svgLinearGradient2.x1;
        }
        if (svgLinearGradient.y1 == null) {
            svgLinearGradient.y1 = svgLinearGradient2.y1;
        }
        if (svgLinearGradient.x2 == null) {
            svgLinearGradient.x2 = svgLinearGradient2.x2;
        }
        if (svgLinearGradient.y2 == null) {
            svgLinearGradient.y2 = svgLinearGradient2.y2;
        }
    }

    private void fillInChainedGradientFields(SVGBase.SvgRadialGradient svgRadialGradient, SVGBase.SvgRadialGradient svgRadialGradient2) {
        if (svgRadialGradient.cx == null) {
            svgRadialGradient.cx = svgRadialGradient2.cx;
        }
        if (svgRadialGradient.cy == null) {
            svgRadialGradient.cy = svgRadialGradient2.cy;
        }
        if (svgRadialGradient.r == null) {
            svgRadialGradient.r = svgRadialGradient2.r;
        }
        if (svgRadialGradient.fx == null) {
            svgRadialGradient.fx = svgRadialGradient2.fx;
        }
        if (svgRadialGradient.fy == null) {
            svgRadialGradient.fy = svgRadialGradient2.fy;
        }
        if (svgRadialGradient.fr == null) {
            svgRadialGradient.fr = svgRadialGradient2.fr;
        }
    }

    private void setSolidColor(boolean z, SVGBase.SolidColor solidColor) {
        if (z) {
            if (isSpecified(solidColor.baseStyle, 2147483648L)) {
                this.state.style.fill = solidColor.baseStyle.solidColor;
                this.state.hasFill = solidColor.baseStyle.solidColor != null;
            }
            if (isSpecified(solidColor.baseStyle, 4294967296L)) {
                this.state.style.fillOpacity = solidColor.baseStyle.solidOpacity;
            }
            if (isSpecified(solidColor.baseStyle, 6442450944L)) {
                RendererState rendererState = this.state;
                setPaintColour(rendererState, z, rendererState.style.fill);
                return;
            }
            return;
        }
        if (isSpecified(solidColor.baseStyle, 2147483648L)) {
            this.state.style.stroke = solidColor.baseStyle.solidColor;
            this.state.hasStroke = solidColor.baseStyle.solidColor != null;
        }
        if (isSpecified(solidColor.baseStyle, 4294967296L)) {
            this.state.style.strokeOpacity = solidColor.baseStyle.solidOpacity;
        }
        if (isSpecified(solidColor.baseStyle, 6442450944L)) {
            RendererState rendererState2 = this.state;
            setPaintColour(rendererState2, z, rendererState2.style.stroke);
        }
    }

    private void checkForClipPath(SVGBase.SvgElement svgElement) {
        checkForClipPath(svgElement, svgElement.boundingBox);
    }

    private void checkForClipPath(SVGBase.SvgElement svgElement, SVGBase.Box box) {
        if (this.state.style.clipPath == null) {
            return;
        }
        if (SUPPORTS_PATH_OP) {
            Path pathCalculateClipPath = calculateClipPath(svgElement, box);
            if (pathCalculateClipPath != null) {
                this.canvas.clipPath(pathCalculateClipPath);
                return;
            }
            return;
        }
        checkForClipPath_OldStyle(svgElement, box);
    }

    private Path calculateClipPath(SVGBase.SvgElement svgElement, SVGBase.Box box) {
        Path pathObjectToPath;
        SVGBase.SvgObject svgObjectResolveIRI = svgElement.document.resolveIRI(this.state.style.clipPath);
        if (svgObjectResolveIRI == null) {
            error("ClipPath reference '%s' not found", this.state.style.clipPath);
            return null;
        }
        if (svgObjectResolveIRI.getNodeName() != "clipPath") {
            return null;
        }
        SVGBase.ClipPath clipPath = (SVGBase.ClipPath) svgObjectResolveIRI;
        this.stateStack.push(this.state);
        this.state = findInheritFromAncestorState(clipPath);
        boolean z = clipPath.clipPathUnitsAreUser == null || clipPath.clipPathUnitsAreUser.booleanValue();
        Matrix matrix = new Matrix();
        if (!z) {
            matrix.preTranslate(box.minX, box.minY);
            matrix.preScale(box.width, box.height);
        }
        if (clipPath.transform != null) {
            matrix.preConcat(clipPath.transform);
        }
        Path path = new Path();
        for (SVGBase.SvgObject svgObject : clipPath.children) {
            if ((svgObject instanceof SVGBase.SvgElement) && (pathObjectToPath = objectToPath((SVGBase.SvgElement) svgObject, true)) != null) {
                path.op(pathObjectToPath, Path.Op.UNION);
            }
        }
        if (this.state.style.clipPath != null) {
            if (clipPath.boundingBox == null) {
                clipPath.boundingBox = calculatePathBounds(path);
            }
            Path pathCalculateClipPath = calculateClipPath(clipPath, clipPath.boundingBox);
            if (pathCalculateClipPath != null) {
                path.op(pathCalculateClipPath, Path.Op.INTERSECT);
            }
        }
        path.transform(matrix);
        this.state = this.stateStack.pop();
        return path;
    }

    private Path objectToPath(SVGBase.SvgElement svgElement, boolean z) {
        Path pathMakePathAndBoundingBox;
        Path pathCalculateClipPath;
        this.stateStack.push(this.state);
        RendererState rendererState = new RendererState(this.state);
        this.state = rendererState;
        updateStyleForElement(rendererState, svgElement);
        if (!display() || !visible()) {
            this.state = this.stateStack.pop();
            return null;
        }
        if (svgElement instanceof SVGBase.Use) {
            if (!z) {
                error("<use> elements inside a <clipPath> cannot reference another <use>", new Object[0]);
            }
            SVGBase.Use use = (SVGBase.Use) svgElement;
            SVGBase.SvgObject svgObjectResolveIRI = svgElement.document.resolveIRI(use.href);
            if (svgObjectResolveIRI == null) {
                error("Use reference '%s' not found", use.href);
                this.state = this.stateStack.pop();
                return null;
            }
            if (!(svgObjectResolveIRI instanceof SVGBase.SvgElement)) {
                this.state = this.stateStack.pop();
                return null;
            }
            pathMakePathAndBoundingBox = objectToPath((SVGBase.SvgElement) svgObjectResolveIRI, false);
            if (pathMakePathAndBoundingBox == null) {
                return null;
            }
            if (use.boundingBox == null) {
                use.boundingBox = calculatePathBounds(pathMakePathAndBoundingBox);
            }
            if (use.transform != null) {
                pathMakePathAndBoundingBox.transform(use.transform);
            }
        } else if (svgElement instanceof SVGBase.GraphicsElement) {
            SVGBase.GraphicsElement graphicsElement = (SVGBase.GraphicsElement) svgElement;
            if (svgElement instanceof SVGBase.Path) {
                pathMakePathAndBoundingBox = new PathConverter(((SVGBase.Path) svgElement).d).getPath();
                if (svgElement.boundingBox == null) {
                    svgElement.boundingBox = calculatePathBounds(pathMakePathAndBoundingBox);
                }
            } else if (svgElement instanceof SVGBase.Rect) {
                pathMakePathAndBoundingBox = makePathAndBoundingBox((SVGBase.Rect) svgElement);
            } else if (svgElement instanceof SVGBase.Circle) {
                pathMakePathAndBoundingBox = makePathAndBoundingBox((SVGBase.Circle) svgElement);
            } else if (svgElement instanceof SVGBase.Ellipse) {
                pathMakePathAndBoundingBox = makePathAndBoundingBox((SVGBase.Ellipse) svgElement);
            } else {
                pathMakePathAndBoundingBox = svgElement instanceof SVGBase.PolyLine ? makePathAndBoundingBox((SVGBase.PolyLine) svgElement) : null;
            }
            if (pathMakePathAndBoundingBox == null) {
                return null;
            }
            if (graphicsElement.boundingBox == null) {
                graphicsElement.boundingBox = calculatePathBounds(pathMakePathAndBoundingBox);
            }
            if (graphicsElement.transform != null) {
                pathMakePathAndBoundingBox.transform(graphicsElement.transform);
            }
            pathMakePathAndBoundingBox.setFillType(getClipRuleFromState());
        } else if (svgElement instanceof SVGBase.Text) {
            SVGBase.Text text = (SVGBase.Text) svgElement;
            pathMakePathAndBoundingBox = makePathAndBoundingBox(text);
            if (text.transform != null) {
                pathMakePathAndBoundingBox.transform(text.transform);
            }
            pathMakePathAndBoundingBox.setFillType(getClipRuleFromState());
        } else {
            error("Invalid %s element found in clipPath definition", svgElement.getNodeName());
            return null;
        }
        if (this.state.style.clipPath != null && (pathCalculateClipPath = calculateClipPath(svgElement, svgElement.boundingBox)) != null) {
            pathMakePathAndBoundingBox.op(pathCalculateClipPath, Path.Op.INTERSECT);
        }
        this.state = this.stateStack.pop();
        return pathMakePathAndBoundingBox;
    }

    private void checkForClipPath_OldStyle(SVGBase.SvgElement svgElement, SVGBase.Box box) {
        SVGBase.SvgObject svgObjectResolveIRI = svgElement.document.resolveIRI(this.state.style.clipPath);
        if (svgObjectResolveIRI == null) {
            error("ClipPath reference '%s' not found", this.state.style.clipPath);
            return;
        }
        if (svgObjectResolveIRI.getNodeName() != "clipPath") {
            return;
        }
        SVGBase.ClipPath clipPath = (SVGBase.ClipPath) svgObjectResolveIRI;
        if (clipPath.children.isEmpty()) {
            this.canvas.clipRect(0, 0, 0, 0);
            return;
        }
        boolean z = clipPath.clipPathUnitsAreUser == null || clipPath.clipPathUnitsAreUser.booleanValue();
        if ((svgElement instanceof SVGBase.Group) && !z) {
            warn("<clipPath clipPathUnits=\"objectBoundingBox\"> is not supported when referenced from container elements (like %s)", svgElement.getNodeName());
            return;
        }
        clipStatePush();
        if (!z) {
            Matrix matrix = new Matrix();
            matrix.preTranslate(box.minX, box.minY);
            matrix.preScale(box.width, box.height);
            this.canvas.concat(matrix);
        }
        if (clipPath.transform != null) {
            this.canvas.concat(clipPath.transform);
        }
        this.state = findInheritFromAncestorState(clipPath);
        checkForClipPath(clipPath);
        Path path = new Path();
        Iterator<SVGBase.SvgObject> it = clipPath.children.iterator();
        while (it.hasNext()) {
            addObjectToClip(it.next(), true, path, new Matrix());
        }
        this.canvas.clipPath(path);
        clipStatePop();
    }

    private void addObjectToClip(SVGBase.SvgObject svgObject, boolean z, Path path, Matrix matrix) {
        if (display()) {
            clipStatePush();
            if (svgObject instanceof SVGBase.Use) {
                if (z) {
                    addObjectToClip((SVGBase.Use) svgObject, path, matrix);
                } else {
                    error("<use> elements inside a <clipPath> cannot reference another <use>", new Object[0]);
                }
            } else if (svgObject instanceof SVGBase.Path) {
                addObjectToClip((SVGBase.Path) svgObject, path, matrix);
            } else if (svgObject instanceof SVGBase.Text) {
                addObjectToClip((SVGBase.Text) svgObject, path, matrix);
            } else if (svgObject instanceof SVGBase.GraphicsElement) {
                addObjectToClip((SVGBase.GraphicsElement) svgObject, path, matrix);
            } else {
                error("Invalid %s element found in clipPath definition", svgObject.toString());
            }
            clipStatePop();
        }
    }

    private void clipStatePush() {
        CanvasLegacy.save(this.canvas, CanvasLegacy.MATRIX_SAVE_FLAG);
        this.stateStack.push(this.state);
        this.state = new RendererState(this.state);
    }

    private void clipStatePop() {
        this.canvas.restore();
        this.state = this.stateStack.pop();
    }

    private Path.FillType getClipRuleFromState() {
        if (this.state.style.clipRule != null && this.state.style.clipRule == Style.FillRule.EvenOdd) {
            return Path.FillType.EVEN_ODD;
        }
        return Path.FillType.WINDING;
    }

    private void addObjectToClip(SVGBase.Path path, Path path2, Matrix matrix) {
        updateStyleForElement(this.state, path);
        if (display() && visible()) {
            if (path.transform != null) {
                matrix.preConcat(path.transform);
            }
            Path path3 = new PathConverter(path.d).getPath();
            if (path.boundingBox == null) {
                path.boundingBox = calculatePathBounds(path3);
            }
            checkForClipPath(path);
            path2.setFillType(getClipRuleFromState());
            path2.addPath(path3, matrix);
        }
    }

    private void addObjectToClip(SVGBase.GraphicsElement graphicsElement, Path path, Matrix matrix) {
        Path pathMakePathAndBoundingBox;
        updateStyleForElement(this.state, graphicsElement);
        if (display() && visible()) {
            if (graphicsElement.transform != null) {
                matrix.preConcat(graphicsElement.transform);
            }
            if (graphicsElement instanceof SVGBase.Rect) {
                pathMakePathAndBoundingBox = makePathAndBoundingBox((SVGBase.Rect) graphicsElement);
            } else if (graphicsElement instanceof SVGBase.Circle) {
                pathMakePathAndBoundingBox = makePathAndBoundingBox((SVGBase.Circle) graphicsElement);
            } else if (graphicsElement instanceof SVGBase.Ellipse) {
                pathMakePathAndBoundingBox = makePathAndBoundingBox((SVGBase.Ellipse) graphicsElement);
            } else if (!(graphicsElement instanceof SVGBase.PolyLine)) {
                return;
            } else {
                pathMakePathAndBoundingBox = makePathAndBoundingBox((SVGBase.PolyLine) graphicsElement);
            }
            if (pathMakePathAndBoundingBox == null) {
                return;
            }
            checkForClipPath(graphicsElement);
            path.setFillType(getClipRuleFromState());
            path.addPath(pathMakePathAndBoundingBox, matrix);
        }
    }

    private void addObjectToClip(SVGBase.Use use, Path path, Matrix matrix) {
        updateStyleForElement(this.state, use);
        if (display() && visible()) {
            if (use.transform != null) {
                matrix.preConcat(use.transform);
            }
            SVGBase.SvgObject svgObjectResolveIRI = use.document.resolveIRI(use.href);
            if (svgObjectResolveIRI == null) {
                error("Use reference '%s' not found", use.href);
            } else {
                checkForClipPath(use);
                addObjectToClip(svgObjectResolveIRI, false, path, matrix);
            }
        }
    }

    private void addObjectToClip(SVGBase.Text text, Path path, Matrix matrix) {
        updateStyleForElement(this.state, text);
        if (display()) {
            if (text.transform != null) {
                matrix.preConcat(text.transform);
            }
            float fFloatValueY = 0.0f;
            float fFloatValueX = (text.x == null || text.x.size() == 0) ? 0.0f : text.x.get(0).floatValueX(this);
            float fFloatValueY2 = (text.y == null || text.y.size() == 0) ? 0.0f : text.y.get(0).floatValueY(this);
            float fFloatValueX2 = (text.dx == null || text.dx.size() == 0) ? 0.0f : text.dx.get(0).floatValueX(this);
            if (text.dy != null && text.dy.size() != 0) {
                fFloatValueY = text.dy.get(0).floatValueY(this);
            }
            if (this.state.style.textAnchor != Style.TextAnchor.Start) {
                float fCalculateTextWidth = calculateTextWidth(text);
                if (this.state.style.textAnchor == Style.TextAnchor.Middle) {
                    fCalculateTextWidth /= 2.0f;
                }
                fFloatValueX -= fCalculateTextWidth;
            }
            if (text.boundingBox == null) {
                TextBoundsCalculator textBoundsCalculator = new TextBoundsCalculator(fFloatValueX, fFloatValueY2);
                enumerateTextSpans(text, textBoundsCalculator);
                text.boundingBox = new SVGBase.Box(textBoundsCalculator.bbox.left, textBoundsCalculator.bbox.top, textBoundsCalculator.bbox.width(), textBoundsCalculator.bbox.height());
            }
            checkForClipPath(text);
            Path path2 = new Path();
            enumerateTextSpans(text, new PlainTextToPath(fFloatValueX + fFloatValueX2, fFloatValueY2 + fFloatValueY, path2));
            path.setFillType(getClipRuleFromState());
            path.addPath(path2, matrix);
        }
    }

    private class PlainTextToPath extends TextProcessor {
        final Path textAsPath;
        float x;
        float y;

        PlainTextToPath(float f, float f2, Path path) {
            super();
            this.x = f;
            this.y = f2;
            this.textAsPath = path;
        }

        @Override // net.pubnative.lite.sdk.utils.svgparser.utils.SVGAndroidRenderer.TextProcessor
        public boolean doTextContainer(SVGBase.TextContainer textContainer) {
            if (!(textContainer instanceof SVGBase.TextPath)) {
                return true;
            }
            SVGAndroidRenderer.warn("Using <textPath> elements in a clip path is not supported.", new Object[0]);
            return false;
        }

        @Override // net.pubnative.lite.sdk.utils.svgparser.utils.SVGAndroidRenderer.TextProcessor
        public void processText(String str) {
            if (SVGAndroidRenderer.this.visible()) {
                Path path = new Path();
                SVGAndroidRenderer.this.state.fillPaint.getTextPath(str, 0, str.length(), this.x, this.y, path);
                this.textAsPath.addPath(path);
            }
            float f = this.x;
            SVGAndroidRenderer sVGAndroidRenderer = SVGAndroidRenderer.this;
            this.x = f + sVGAndroidRenderer.measureText(str, sVGAndroidRenderer.state.fillPaint);
        }
    }

    private Path makePathAndBoundingBox(SVGBase.Line line) {
        float fFloatValueX = line.x1 == null ? 0.0f : line.x1.floatValueX(this);
        float fFloatValueY = line.y1 == null ? 0.0f : line.y1.floatValueY(this);
        float fFloatValueX2 = line.x2 == null ? 0.0f : line.x2.floatValueX(this);
        float fFloatValueY2 = line.y2 != null ? line.y2.floatValueY(this) : 0.0f;
        if (line.boundingBox == null) {
            line.boundingBox = new SVGBase.Box(Math.min(fFloatValueX, fFloatValueX2), Math.min(fFloatValueY, fFloatValueY2), Math.abs(fFloatValueX2 - fFloatValueX), Math.abs(fFloatValueY2 - fFloatValueY));
        }
        Path path = new Path();
        path.moveTo(fFloatValueX, fFloatValueY);
        path.lineTo(fFloatValueX2, fFloatValueY2);
        return path;
    }

    /* JADX WARN: Code duplicated, block: B:17:0x004e  */
    /* JADX WARN: Code duplicated, block: B:18:0x0055  */
    /* JADX WARN: Code duplicated, block: B:21:0x005a  */
    /* JADX WARN: Code duplicated, block: B:22:0x0062  */
    /* JADX WARN: Code duplicated, block: B:25:0x0073  */
    /* JADX WARN: Code duplicated, block: B:32:0x00e7  */
    private Path makePathAndBoundingBox(SVGBase.Rect rect) {
        float fFloatValueX;
        float fFloatValueY;
        float fMin;
        float fFloatValueX2;
        float fFloatValueY2;
        float fFloatValueX3;
        float fFloatValueY3;
        float f;
        float f2;
        Path path;
        Path path2;
        if (rect.rx == null && rect.ry == null) {
            fFloatValueX = 0.0f;
        } else if (rect.rx == null) {
            fFloatValueX = rect.ry.floatValueY(this);
        } else {
            if (rect.ry == null) {
                fFloatValueX = rect.rx.floatValueX(this);
            } else {
                fFloatValueX = rect.rx.floatValueX(this);
                fFloatValueY = rect.ry.floatValueY(this);
            }
            fMin = Math.min(fFloatValueX, rect.width.floatValueX(this) / 2.0f);
            float fMin2 = Math.min(fFloatValueY, rect.height.floatValueY(this) / 2.0f);
            if (rect.x != null) {
                fFloatValueX2 = rect.x.floatValueX(this);
            } else {
                fFloatValueX2 = 0.0f;
            }
            if (rect.y != null) {
                fFloatValueY2 = rect.y.floatValueY(this);
            } else {
                fFloatValueY2 = 0.0f;
            }
            fFloatValueX3 = rect.width.floatValueX(this);
            fFloatValueY3 = rect.height.floatValueY(this);
            if (rect.boundingBox == null) {
                rect.boundingBox = new SVGBase.Box(fFloatValueX2, fFloatValueY2, fFloatValueX3, fFloatValueY3);
            }
            f = fFloatValueX2 + fFloatValueX3;
            f2 = fFloatValueY2 + fFloatValueY3;
            path = new Path();
            if (fMin != 0.0f || fMin2 == 0.0f) {
                path2 = path;
                path2.moveTo(fFloatValueX2, fFloatValueY2);
                path2.lineTo(f, fFloatValueY2);
                path2.lineTo(f, f2);
                path2.lineTo(fFloatValueX2, f2);
                path2.lineTo(fFloatValueX2, fFloatValueY2);
            } else {
                float f3 = fMin * BEZIER_ARC_FACTOR;
                float f4 = BEZIER_ARC_FACTOR * fMin2;
                float f5 = fFloatValueY2 + fMin2;
                path.moveTo(fFloatValueX2, f5);
                float f6 = f5 - f4;
                float f7 = fFloatValueX2 + fMin;
                float f8 = f7 - f3;
                path.cubicTo(fFloatValueX2, f6, f8, fFloatValueY2, f7, fFloatValueY2);
                float f9 = f - fMin;
                path.lineTo(f9, fFloatValueY2);
                float f10 = f9 + f3;
                path.cubicTo(f10, fFloatValueY2, f, f6, f, f5);
                float f11 = f2 - fMin2;
                path.lineTo(f, f11);
                float f12 = f11 + f4;
                path2 = path;
                path.cubicTo(f, f12, f10, f2, f9, f2);
                path2.lineTo(f7, f2);
                path2.cubicTo(f8, f2, fFloatValueX2, f12, fFloatValueX2, f11);
                path2.lineTo(fFloatValueX2, f5);
            }
            path2.close();
            return path2;
        }
        fFloatValueY = fFloatValueX;
        fMin = Math.min(fFloatValueX, rect.width.floatValueX(this) / 2.0f);
        float fMin3 = Math.min(fFloatValueY, rect.height.floatValueY(this) / 2.0f);
        if (rect.x != null) {
            fFloatValueX2 = rect.x.floatValueX(this);
        } else {
            fFloatValueX2 = 0.0f;
        }
        if (rect.y != null) {
            fFloatValueY2 = rect.y.floatValueY(this);
        } else {
            fFloatValueY2 = 0.0f;
        }
        fFloatValueX3 = rect.width.floatValueX(this);
        fFloatValueY3 = rect.height.floatValueY(this);
        if (rect.boundingBox == null) {
            rect.boundingBox = new SVGBase.Box(fFloatValueX2, fFloatValueY2, fFloatValueX3, fFloatValueY3);
        }
        f = fFloatValueX2 + fFloatValueX3;
        f2 = fFloatValueY2 + fFloatValueY3;
        path = new Path();
        if (fMin != 0.0f) {
            path2 = path;
            path2.moveTo(fFloatValueX2, fFloatValueY2);
            path2.lineTo(f, fFloatValueY2);
            path2.lineTo(f, f2);
            path2.lineTo(fFloatValueX2, f2);
            path2.lineTo(fFloatValueX2, fFloatValueY2);
        } else {
            path2 = path;
            path2.moveTo(fFloatValueX2, fFloatValueY2);
            path2.lineTo(f, fFloatValueY2);
            path2.lineTo(f, f2);
            path2.lineTo(fFloatValueX2, f2);
            path2.lineTo(fFloatValueX2, fFloatValueY2);
        }
        path2.close();
        return path2;
    }

    private Path makePathAndBoundingBox(SVGBase.Circle circle) {
        float fFloatValueX = circle.cx != null ? circle.cx.floatValueX(this) : 0.0f;
        float fFloatValueY = circle.cy != null ? circle.cy.floatValueY(this) : 0.0f;
        float fFloatValue = circle.r.floatValue(this);
        float f = fFloatValueX - fFloatValue;
        float f2 = fFloatValueY - fFloatValue;
        float f3 = fFloatValueX + fFloatValue;
        float f4 = fFloatValueY + fFloatValue;
        if (circle.boundingBox == null) {
            float f5 = 2.0f * fFloatValue;
            circle.boundingBox = new SVGBase.Box(f, f2, f5, f5);
        }
        float f6 = BEZIER_ARC_FACTOR * fFloatValue;
        Path path = new Path();
        path.moveTo(fFloatValueX, f2);
        float f7 = fFloatValueX + f6;
        float f8 = fFloatValueY - f6;
        path.cubicTo(f7, f2, f3, f8, f3, fFloatValueY);
        float f9 = fFloatValueY + f6;
        path.cubicTo(f3, f9, f7, f4, fFloatValueX, f4);
        float f10 = fFloatValueX - f6;
        path.cubicTo(f10, f4, f, f9, f, fFloatValueY);
        path.cubicTo(f, f8, f10, f2, fFloatValueX, f2);
        path.close();
        return path;
    }

    private Path makePathAndBoundingBox(SVGBase.Ellipse ellipse) {
        float fFloatValueX = ellipse.cx != null ? ellipse.cx.floatValueX(this) : 0.0f;
        float fFloatValueY = ellipse.cy != null ? ellipse.cy.floatValueY(this) : 0.0f;
        float fFloatValueX2 = ellipse.rx.floatValueX(this);
        float fFloatValueY2 = ellipse.ry.floatValueY(this);
        float f = fFloatValueX - fFloatValueX2;
        float f2 = fFloatValueY - fFloatValueY2;
        float f3 = fFloatValueX + fFloatValueX2;
        float f4 = fFloatValueY + fFloatValueY2;
        if (ellipse.boundingBox == null) {
            ellipse.boundingBox = new SVGBase.Box(f, f2, fFloatValueX2 * 2.0f, 2.0f * fFloatValueY2);
        }
        float f5 = fFloatValueX2 * BEZIER_ARC_FACTOR;
        float f6 = BEZIER_ARC_FACTOR * fFloatValueY2;
        Path path = new Path();
        path.moveTo(fFloatValueX, f2);
        float f7 = fFloatValueX + f5;
        float f8 = fFloatValueY - f6;
        path.cubicTo(f7, f2, f3, f8, f3, fFloatValueY);
        float f9 = f6 + fFloatValueY;
        path.cubicTo(f3, f9, f7, f4, fFloatValueX, f4);
        float f10 = fFloatValueX - f5;
        path.cubicTo(f10, f4, f, f9, f, fFloatValueY);
        path.cubicTo(f, f8, f10, f2, fFloatValueX, f2);
        path.close();
        return path;
    }

    private Path makePathAndBoundingBox(SVGBase.PolyLine polyLine) {
        Path path = new Path();
        int i = 0;
        int length = polyLine.points != null ? polyLine.points.length : 0;
        if (length % 2 != 0) {
            return null;
        }
        if (length > 0) {
            while (length >= 2) {
                if (i == 0) {
                    path.moveTo(polyLine.points[i], polyLine.points[i + 1]);
                } else {
                    path.lineTo(polyLine.points[i], polyLine.points[i + 1]);
                }
                i += 2;
                length -= 2;
            }
            if (polyLine instanceof SVGBase.Polygon) {
                path.close();
            }
        }
        if (polyLine.boundingBox == null) {
            polyLine.boundingBox = calculatePathBounds(path);
        }
        return path;
    }

    private Path makePathAndBoundingBox(SVGBase.Text text) {
        float fFloatValueY = 0.0f;
        float fFloatValueX = (text.x == null || text.x.size() == 0) ? 0.0f : text.x.get(0).floatValueX(this);
        float fFloatValueY2 = (text.y == null || text.y.size() == 0) ? 0.0f : text.y.get(0).floatValueY(this);
        float fFloatValueX2 = (text.dx == null || text.dx.size() == 0) ? 0.0f : text.dx.get(0).floatValueX(this);
        if (text.dy != null && text.dy.size() != 0) {
            fFloatValueY = text.dy.get(0).floatValueY(this);
        }
        if (this.state.style.textAnchor != Style.TextAnchor.Start) {
            float fCalculateTextWidth = calculateTextWidth(text);
            if (this.state.style.textAnchor == Style.TextAnchor.Middle) {
                fCalculateTextWidth /= 2.0f;
            }
            fFloatValueX -= fCalculateTextWidth;
        }
        if (text.boundingBox == null) {
            TextBoundsCalculator textBoundsCalculator = new TextBoundsCalculator(fFloatValueX, fFloatValueY2);
            enumerateTextSpans(text, textBoundsCalculator);
            text.boundingBox = new SVGBase.Box(textBoundsCalculator.bbox.left, textBoundsCalculator.bbox.top, textBoundsCalculator.bbox.width(), textBoundsCalculator.bbox.height());
        }
        Path path = new Path();
        enumerateTextSpans(text, new PlainTextToPath(fFloatValueX + fFloatValueX2, fFloatValueY2 + fFloatValueY, path));
        return path;
    }

    /* JADX WARN: Code duplicated, block: B:102:0x0246 A[LOOP:3: B:100:0x0240->B:102:0x0246, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:75:0x01a5  */
    private void fillWithPattern(SVGBase.SvgElement svgElement, Path path, SVGBase.Pattern pattern) {
        float fFloatValueX;
        float fFloatValueY;
        float fFloatValueY2;
        float fFloatValueX2;
        boolean z;
        boolean z2;
        PreserveAspectRatio preserveAspectRatio;
        Iterator<SVGBase.SvgObject> it;
        boolean z3 = pattern.patternUnitsAreUser != null && pattern.patternUnitsAreUser.booleanValue();
        float fFloatValue = this.state.style.fillOpacity.floatValue();
        if (pattern.href != null) {
            fillInChainedPatternFields(pattern, pattern.href);
        }
        if (z3) {
            fFloatValueX = pattern.x != null ? pattern.x.floatValueX(this) : 0.0f;
            fFloatValueY2 = pattern.y != null ? pattern.y.floatValueY(this) : 0.0f;
            fFloatValueX2 = pattern.width != null ? pattern.width.floatValueX(this) : 0.0f;
            fFloatValueY = pattern.height != null ? pattern.height.floatValueY(this) : 0.0f;
        } else {
            float fFloatValue2 = pattern.x != null ? pattern.x.floatValue(this, 1.0f) : 0.0f;
            float fFloatValue3 = pattern.y != null ? pattern.y.floatValue(this, 1.0f) : 0.0f;
            float fFloatValue4 = pattern.width != null ? pattern.width.floatValue(this, 1.0f) : 0.0f;
            float fFloatValue5 = pattern.height != null ? pattern.height.floatValue(this, 1.0f) : 0.0f;
            fFloatValueX = (fFloatValue2 * svgElement.boundingBox.width) + svgElement.boundingBox.minX;
            float f = (fFloatValue3 * svgElement.boundingBox.height) + svgElement.boundingBox.minY;
            float f2 = fFloatValue4 * svgElement.boundingBox.width;
            fFloatValueY = fFloatValue5 * svgElement.boundingBox.height;
            fFloatValueY2 = f;
            fFloatValueX2 = f2;
        }
        if (fFloatValueX2 == 0.0f || fFloatValueY == 0.0f) {
            return;
        }
        PreserveAspectRatio preserveAspectRatio2 = pattern.preserveAspectRatio != null ? pattern.preserveAspectRatio : PreserveAspectRatio.LETTERBOX;
        statePush();
        this.canvas.clipPath(path);
        RendererState rendererState = new RendererState();
        updateStyle(rendererState, Style.getDefaultStyle());
        rendererState.style.overflow = false;
        this.state = findInheritFromAncestorState(pattern, rendererState);
        SVGBase.Box box = svgElement.boundingBox;
        if (pattern.patternTransform != null) {
            this.canvas.concat(pattern.patternTransform);
            Matrix matrix = new Matrix();
            if (pattern.patternTransform.invert(matrix)) {
                float[] fArr = {svgElement.boundingBox.minX, svgElement.boundingBox.minY, svgElement.boundingBox.maxX(), svgElement.boundingBox.minY, svgElement.boundingBox.maxX(), svgElement.boundingBox.maxY(), svgElement.boundingBox.minX, svgElement.boundingBox.maxY()};
                matrix.mapPoints(fArr);
                z = false;
                float f3 = fArr[0];
                z2 = true;
                float f4 = fArr[1];
                RectF rectF = new RectF(f3, f4, f3, f4);
                for (int i = 2; i <= 6; i += 2) {
                    if (fArr[i] < rectF.left) {
                        rectF.left = fArr[i];
                    }
                    if (fArr[i] > rectF.right) {
                        rectF.right = fArr[i];
                    }
                    int i2 = i + 1;
                    if (fArr[i2] < rectF.top) {
                        rectF.top = fArr[i2];
                    }
                    if (fArr[i2] > rectF.bottom) {
                        rectF.bottom = fArr[i2];
                    }
                }
                box = new SVGBase.Box(rectF.left, rectF.top, rectF.right - rectF.left, rectF.bottom - rectF.top);
            } else {
                z = false;
                z2 = true;
            }
        } else {
            z = false;
            z2 = true;
        }
        float fFloor = fFloatValueX + (((float) Math.floor((box.minX - fFloatValueX) / fFloatValueX2)) * fFloatValueX2);
        float fFloor2 = fFloatValueY2 + (((float) Math.floor((box.minY - fFloatValueY2) / fFloatValueY)) * fFloatValueY);
        float fMaxX = box.maxX();
        float fMaxY = box.maxY();
        SVGBase.Box box2 = new SVGBase.Box(0.0f, 0.0f, fFloatValueX2, fFloatValueY);
        boolean zPushLayer = pushLayer(fFloatValue);
        while (fFloor2 < fMaxY) {
            float f5 = fFloor;
            while (f5 < fMaxX) {
                box2.minX = f5;
                box2.minY = fFloor2;
                statePush();
                if (!this.state.style.overflow.booleanValue()) {
                    setClipRect(box2.minX, box2.minY, box2.width, box2.height);
                }
                if (pattern.viewBox != null) {
                    preserveAspectRatio = preserveAspectRatio2;
                    this.canvas.concat(calculateViewBoxTransform(box2, pattern.viewBox, preserveAspectRatio));
                } else {
                    preserveAspectRatio = preserveAspectRatio2;
                    boolean z4 = (pattern.patternContentUnitsAreUser == null || pattern.patternContentUnitsAreUser.booleanValue()) ? z2 : z;
                    this.canvas.translate(f5, fFloor2);
                    if (!z4) {
                        this.canvas.scale(svgElement.boundingBox.width, svgElement.boundingBox.height);
                    }
                    it = pattern.children.iterator();
                    while (it.hasNext()) {
                        render(it.next());
                    }
                    statePop();
                    f5 += fFloatValueX2;
                    preserveAspectRatio2 = preserveAspectRatio;
                    z2 = true;
                }
                it = pattern.children.iterator();
                while (it.hasNext()) {
                    render(it.next());
                }
                statePop();
                f5 += fFloatValueX2;
                preserveAspectRatio2 = preserveAspectRatio;
                z2 = true;
            }
            fFloor2 += fFloatValueY;
            z2 = true;
        }
        if (zPushLayer) {
            popLayer(pattern);
        }
        statePop();
    }

    private void fillInChainedPatternFields(SVGBase.Pattern pattern, String str) {
        SVGBase.SvgObject svgObjectResolveIRI = pattern.document.resolveIRI(str);
        if (svgObjectResolveIRI == null) {
            warn("Pattern reference '%s' not found", str);
            return;
        }
        if (!(svgObjectResolveIRI instanceof SVGBase.Pattern)) {
            error("Pattern href attributes must point to other pattern elements", new Object[0]);
            return;
        }
        if (svgObjectResolveIRI == pattern) {
            error("Circular reference in pattern href attribute '%s'", str);
            return;
        }
        SVGBase.Pattern pattern2 = (SVGBase.Pattern) svgObjectResolveIRI;
        if (pattern.patternUnitsAreUser == null) {
            pattern.patternUnitsAreUser = pattern2.patternUnitsAreUser;
        }
        if (pattern.patternContentUnitsAreUser == null) {
            pattern.patternContentUnitsAreUser = pattern2.patternContentUnitsAreUser;
        }
        if (pattern.patternTransform == null) {
            pattern.patternTransform = pattern2.patternTransform;
        }
        if (pattern.x == null) {
            pattern.x = pattern2.x;
        }
        if (pattern.y == null) {
            pattern.y = pattern2.y;
        }
        if (pattern.width == null) {
            pattern.width = pattern2.width;
        }
        if (pattern.height == null) {
            pattern.height = pattern2.height;
        }
        if (pattern.children.isEmpty()) {
            pattern.children = pattern2.children;
        }
        if (pattern.viewBox == null) {
            pattern.viewBox = pattern2.viewBox;
        }
        if (pattern.preserveAspectRatio == null) {
            pattern.preserveAspectRatio = pattern2.preserveAspectRatio;
        }
        if (pattern2.href != null) {
            fillInChainedPatternFields(pattern, pattern2.href);
        }
    }

    private void renderMask(SVGBase.Mask mask, SVGBase.SvgElement svgElement, SVGBase.Box box) {
        float fFloatValueX;
        float fFloatValueY;
        debug("Mask render", new Object[0]);
        if (mask.maskUnitsAreUser != null && mask.maskUnitsAreUser.booleanValue()) {
            fFloatValueX = mask.width != null ? mask.width.floatValueX(this) : box.width;
            fFloatValueY = mask.height != null ? mask.height.floatValueY(this) : box.height;
        } else {
            float fFloatValue = mask.width != null ? mask.width.floatValue(this, 1.0f) : 1.2f;
            float fFloatValue2 = mask.height != null ? mask.height.floatValue(this, 1.0f) : 1.2f;
            fFloatValueX = fFloatValue * box.width;
            fFloatValueY = fFloatValue2 * box.height;
        }
        if (fFloatValueX == 0.0f || fFloatValueY == 0.0f) {
            return;
        }
        statePush();
        RendererState rendererStateFindInheritFromAncestorState = findInheritFromAncestorState(mask);
        this.state = rendererStateFindInheritFromAncestorState;
        rendererStateFindInheritFromAncestorState.style.opacity = Float.valueOf(1.0f);
        boolean zPushLayer = pushLayer();
        this.canvas.save();
        if (mask.maskContentUnitsAreUser != null && !mask.maskContentUnitsAreUser.booleanValue()) {
            this.canvas.translate(box.minX, box.minY);
            this.canvas.scale(box.width, box.height);
        }
        renderChildren(mask, false);
        this.canvas.restore();
        if (zPushLayer) {
            popLayer(svgElement, box);
        }
        statePop();
    }
}
