package com.yandex.div.core.resources;

import android.content.res.AssetFileDescriptor;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.content.res.loader.ResourcesLoader;
import android.graphics.Movie;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import com.amazon.device.ads.DTBMetricsConfiguration;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.yandex.div.core.dagger.Names;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: compiled from: ResourcesWrapper.kt */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000¸\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0010\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0002\u0010\u0003J%\u0010\u0004\u001a\u00020\u00052\u0016\u0010\u0006\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\b0\u0007\"\u0004\u0018\u00010\bH\u0017¢\u0006\u0002\u0010\tJ\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\rH\u0016J\u0010\u0010\u0010\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\rH\u0017J\u001e\u0010\u0010\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\r2\f\u0010\u0011\u001a\b\u0018\u00010\u0012R\u00020\u0001H\u0017J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\f\u001a\u00020\rH\u0017J\u001e\u0010\u0013\u001a\u00020\u00142\u0006\u0010\f\u001a\u00020\r2\f\u0010\u0011\u001a\b\u0018\u00010\u0012R\u00020\u0001H\u0017J\n\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\f\u001a\u00020\rH\u0016J\u0010\u0010\u0019\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\rH\u0016J\u0010\u0010\u001a\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\rH\u0016J\n\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J\u0012\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\u0006\u0010\f\u001a\u00020\rH\u0017J \u0010\u001d\u001a\u0004\u0018\u00010\u001e2\u0006\u0010\f\u001a\u00020\r2\f\u0010\u0011\u001a\b\u0018\u00010\u0012R\u00020\u0001H\u0016J\u001a\u0010\u001f\u001a\u0004\u0018\u00010\u001e2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010 \u001a\u00020\rH\u0017J(\u0010\u001f\u001a\u0004\u0018\u00010\u001e2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010 \u001a\u00020\r2\f\u0010\u0011\u001a\b\u0018\u00010\u0012R\u00020\u0001H\u0016J\u0010\u0010!\u001a\u00020\u00182\u0006\u0010\f\u001a\u00020\rH\u0017J\u0010\u0010\"\u001a\u00020#2\u0006\u0010\f\u001a\u00020\rH\u0017J \u0010$\u001a\u00020\u00182\u0006\u0010\f\u001a\u00020\r2\u0006\u0010%\u001a\u00020\r2\u0006\u0010&\u001a\u00020\rH\u0016J&\u0010'\u001a\u00020\r2\b\u0010(\u001a\u0004\u0018\u00010)2\b\u0010*\u001a\u0004\u0018\u00010)2\b\u0010+\u001a\u0004\u0018\u00010)H\u0016J\u0010\u0010,\u001a\u00020-2\u0006\u0010\f\u001a\u00020\rH\u0016J\u0010\u0010.\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\rH\u0016J\u0010\u0010/\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\u0012\u00100\u001a\u0004\u0018\u0001012\u0006\u0010\f\u001a\u00020\rH\u0017J\u0018\u00102\u001a\u00020)2\u0006\u0010\f\u001a\u00020\r2\u0006\u00103\u001a\u00020\rH\u0016J5\u00102\u001a\u00020)2\u0006\u0010\f\u001a\u00020\r2\u0006\u00103\u001a\u00020\r2\u0016\u00104\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u0001050\u0007\"\u0004\u0018\u000105H\u0016¢\u0006\u0002\u00106J\u0018\u00107\u001a\u0002082\u0006\u0010\f\u001a\u00020\r2\u0006\u00103\u001a\u00020\rH\u0016J\u0012\u00109\u001a\u0004\u0018\u00010)2\u0006\u0010:\u001a\u00020\rH\u0016J\u0012\u0010;\u001a\u0004\u0018\u00010)2\u0006\u0010:\u001a\u00020\rH\u0016J\u0012\u0010<\u001a\u0004\u0018\u00010)2\u0006\u0010:\u001a\u00020\rH\u0016J\u0012\u0010=\u001a\u0004\u0018\u00010)2\u0006\u0010:\u001a\u00020\rH\u0016J\u0010\u0010>\u001a\u00020)2\u0006\u0010\f\u001a\u00020\rH\u0016J-\u0010>\u001a\u00020)2\u0006\u0010\f\u001a\u00020\r2\u0016\u00104\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u0001050\u0007\"\u0004\u0018\u000105H\u0016¢\u0006\u0002\u0010?J\u001d\u0010@\u001a\n\u0012\u0006\b\u0001\u0012\u00020)0\u00072\u0006\u0010\f\u001a\u00020\rH\u0016¢\u0006\u0002\u0010AJ\u0010\u0010B\u001a\u0002082\u0006\u0010\f\u001a\u00020\rH\u0016J\u001c\u0010B\u001a\u0004\u0018\u0001082\u0006\u0010\f\u001a\u00020\r2\b\u0010C\u001a\u0004\u0018\u000108H\u0016J\u001d\u0010D\u001a\n\u0012\u0006\b\u0001\u0012\u0002080\u00072\u0006\u0010\f\u001a\u00020\rH\u0016¢\u0006\u0002\u0010EJ\"\u0010F\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\r2\b\u0010G\u001a\u0004\u0018\u00010H2\u0006\u0010I\u001a\u00020\u000fH\u0016J$\u0010F\u001a\u00020\u00052\b\u0010(\u001a\u0004\u0018\u00010)2\b\u0010G\u001a\u0004\u0018\u00010H2\u0006\u0010I\u001a\u00020\u000fH\u0016J*\u0010J\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\r2\u0006\u0010 \u001a\u00020\r2\b\u0010G\u001a\u0004\u0018\u00010H2\u0006\u0010I\u001a\u00020\u000fH\u0016J\u0010\u0010K\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\u001e\u0010L\u001a\u0004\u0018\u00010M2\b\u0010N\u001a\u0004\u0018\u00010O2\b\u0010P\u001a\u0004\u0018\u00010-H\u0016J\u0010\u0010Q\u001a\u00020M2\u0006\u0010\f\u001a\u00020\rH\u0016J\u0010\u0010R\u001a\u00020S2\u0006\u0010\f\u001a\u00020\rH\u0016J\u001a\u0010R\u001a\u00020S2\u0006\u0010\f\u001a\u00020\r2\b\u0010T\u001a\u0004\u0018\u00010HH\u0016J\u0012\u0010U\u001a\u0004\u0018\u00010V2\u0006\u0010\f\u001a\u00020\rH\u0016J&\u0010W\u001a\u00020\u00052\b\u0010X\u001a\u0004\u0018\u00010)2\b\u0010P\u001a\u0004\u0018\u00010O2\b\u0010Y\u001a\u0004\u0018\u00010ZH\u0016J\u001c\u0010[\u001a\u00020\u00052\b\u0010\\\u001a\u0004\u0018\u00010\u000b2\b\u0010Y\u001a\u0004\u0018\u00010ZH\u0016J%\u0010]\u001a\u00020\u00052\u0016\u0010\u0006\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\b0\u0007\"\u0004\u0018\u00010\bH\u0017¢\u0006\u0002\u0010\tJ\u001c\u0010^\u001a\u00020\u00052\b\u0010_\u001a\u0004\u0018\u00010\u00162\b\u0010`\u001a\u0004\u0018\u00010\u001cH\u0017R\u000e\u0010\u0002\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006a"}, d2 = {"Lcom/yandex/div/core/resources/ResourcesWrapper;", "Landroid/content/res/Resources;", "resources", "(Landroid/content/res/Resources;)V", "addLoaders", "", "loaders", "", "Landroid/content/res/loader/ResourcesLoader;", "([Landroid/content/res/loader/ResourcesLoader;)V", "getAnimation", "Landroid/content/res/XmlResourceParser;", "id", "", "getBoolean", "", "getColor", Names.THEME, "Landroid/content/res/Resources$Theme;", "getColorStateList", "Landroid/content/res/ColorStateList;", "getConfiguration", "Landroid/content/res/Configuration;", "getDimension", "", "getDimensionPixelOffset", "getDimensionPixelSize", "getDisplayMetrics", "Landroid/util/DisplayMetrics;", "getDrawable", "Landroid/graphics/drawable/Drawable;", "getDrawableForDensity", "density", "getFloat", "getFont", "Landroid/graphics/Typeface;", "getFraction", "base", "pbase", "getIdentifier", "name", "", "defType", "defPackage", "getIntArray", "", "getInteger", "getLayout", "getMovie", "Landroid/graphics/Movie;", "getQuantityString", FirebaseAnalytics.Param.QUANTITY, "formatArgs", "", "(II[Ljava/lang/Object;)Ljava/lang/String;", "getQuantityText", "", "getResourceEntryName", "resid", "getResourceName", "getResourcePackageName", "getResourceTypeName", "getString", "(I[Ljava/lang/Object;)Ljava/lang/String;", "getStringArray", "(I)[Ljava/lang/String;", "getText", "def", "getTextArray", "(I)[Ljava/lang/CharSequence;", "getValue", "outValue", "Landroid/util/TypedValue;", "resolveRefs", "getValueForDensity", "getXml", "obtainAttributes", "Landroid/content/res/TypedArray;", "set", "Landroid/util/AttributeSet;", "attrs", "obtainTypedArray", "openRawResource", "Ljava/io/InputStream;", "value", "openRawResourceFd", "Landroid/content/res/AssetFileDescriptor;", "parseBundleExtra", "tagName", "outBundle", "Landroid/os/Bundle;", "parseBundleExtras", "parser", "removeLoaders", "updateConfiguration", DTBMetricsConfiguration.CONFIG_DIR, "metrics", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public class ResourcesWrapper extends Resources {
    private final Resources resources;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ResourcesWrapper(Resources resources) {
        super(resources.getAssets(), resources.getDisplayMetrics(), resources.getConfiguration());
        Intrinsics.checkNotNullParameter(resources, "resources");
        this.resources = resources;
    }

    @Override // android.content.res.Resources
    public void addLoaders(ResourcesLoader... loaders) {
        Intrinsics.checkNotNullParameter(loaders, "loaders");
        this.resources.addLoaders((ResourcesLoader[]) Arrays.copyOf(loaders, loaders.length));
    }

    @Override // android.content.res.Resources
    public XmlResourceParser getAnimation(int id) throws Resources.NotFoundException {
        XmlResourceParser animation = this.resources.getAnimation(id);
        Intrinsics.checkNotNullExpressionValue(animation, "resources.getAnimation(id)");
        return animation;
    }

    @Override // android.content.res.Resources
    public boolean getBoolean(int id) throws Resources.NotFoundException {
        return this.resources.getBoolean(id);
    }

    @Override // android.content.res.Resources
    @Deprecated(message = "Deprecated in Java")
    public int getColor(int id) throws Resources.NotFoundException {
        return this.resources.getColor(id);
    }

    @Override // android.content.res.Resources
    public int getColor(int id, Resources.Theme theme) throws Resources.NotFoundException {
        return this.resources.getColor(id, theme);
    }

    @Override // android.content.res.Resources
    public ColorStateList getColorStateList(int id, Resources.Theme theme) throws Resources.NotFoundException {
        ColorStateList colorStateList = this.resources.getColorStateList(id, theme);
        Intrinsics.checkNotNullExpressionValue(colorStateList, "resources.getColorStateList(id, theme)");
        return colorStateList;
    }

    @Override // android.content.res.Resources
    @Deprecated(message = "Deprecated in Java")
    public ColorStateList getColorStateList(int id) throws Resources.NotFoundException {
        ColorStateList colorStateList = this.resources.getColorStateList(id);
        Intrinsics.checkNotNullExpressionValue(colorStateList, "resources.getColorStateList(id)");
        return colorStateList;
    }

    @Override // android.content.res.Resources
    public Configuration getConfiguration() {
        return this.resources.getConfiguration();
    }

    @Override // android.content.res.Resources
    public float getDimension(int id) throws Resources.NotFoundException {
        return this.resources.getDimension(id);
    }

    @Override // android.content.res.Resources
    public int getDimensionPixelOffset(int id) throws Resources.NotFoundException {
        return this.resources.getDimensionPixelOffset(id);
    }

    @Override // android.content.res.Resources
    public int getDimensionPixelSize(int id) throws Resources.NotFoundException {
        return this.resources.getDimensionPixelSize(id);
    }

    @Override // android.content.res.Resources
    public DisplayMetrics getDisplayMetrics() {
        return this.resources.getDisplayMetrics();
    }

    @Override // android.content.res.Resources
    public Drawable getDrawable(int id, Resources.Theme theme) throws Resources.NotFoundException {
        return this.resources.getDrawable(id, theme);
    }

    @Override // android.content.res.Resources
    @Deprecated(message = "Deprecated in Java")
    public Drawable getDrawable(int id) throws Resources.NotFoundException {
        return this.resources.getDrawable(id);
    }

    @Override // android.content.res.Resources
    @Deprecated(message = "Deprecated in Java")
    public Drawable getDrawableForDensity(int id, int density) throws Resources.NotFoundException {
        return this.resources.getDrawableForDensity(id, density);
    }

    @Override // android.content.res.Resources
    public Drawable getDrawableForDensity(int id, int density, Resources.Theme theme) {
        return this.resources.getDrawableForDensity(id, density, theme);
    }

    @Override // android.content.res.Resources
    public float getFloat(int id) throws Resources.NotFoundException {
        return this.resources.getFloat(id);
    }

    @Override // android.content.res.Resources
    public Typeface getFont(int id) throws Resources.NotFoundException {
        Typeface font = this.resources.getFont(id);
        Intrinsics.checkNotNullExpressionValue(font, "resources.getFont(id)");
        return font;
    }

    @Override // android.content.res.Resources
    public float getFraction(int id, int base, int pbase) throws Resources.NotFoundException {
        return this.resources.getFraction(id, base, pbase);
    }

    @Override // android.content.res.Resources
    public int getIdentifier(String name, String defType, String defPackage) {
        return this.resources.getIdentifier(name, defType, defPackage);
    }

    @Override // android.content.res.Resources
    public int[] getIntArray(int id) throws Resources.NotFoundException {
        int[] intArray = this.resources.getIntArray(id);
        Intrinsics.checkNotNullExpressionValue(intArray, "resources.getIntArray(id)");
        return intArray;
    }

    @Override // android.content.res.Resources
    public int getInteger(int id) throws Resources.NotFoundException {
        return this.resources.getInteger(id);
    }

    @Override // android.content.res.Resources
    public XmlResourceParser getLayout(int id) throws Resources.NotFoundException {
        XmlResourceParser layout = this.resources.getLayout(id);
        Intrinsics.checkNotNullExpressionValue(layout, "resources.getLayout(id)");
        return layout;
    }

    @Override // android.content.res.Resources
    @Deprecated(message = "Deprecated in Java")
    public Movie getMovie(int id) throws Resources.NotFoundException {
        return this.resources.getMovie(id);
    }

    @Override // android.content.res.Resources
    public String getQuantityString(int id, int quantity, Object... formatArgs) throws Resources.NotFoundException {
        Intrinsics.checkNotNullParameter(formatArgs, "formatArgs");
        String quantityString = this.resources.getQuantityString(id, quantity, Arrays.copyOf(formatArgs, formatArgs.length));
        Intrinsics.checkNotNullExpressionValue(quantityString, "resources.getQuantityStr…d, quantity, *formatArgs)");
        return quantityString;
    }

    @Override // android.content.res.Resources
    public String getQuantityString(int id, int quantity) throws Resources.NotFoundException {
        String quantityString = this.resources.getQuantityString(id, quantity);
        Intrinsics.checkNotNullExpressionValue(quantityString, "resources.getQuantityString(id, quantity)");
        return quantityString;
    }

    @Override // android.content.res.Resources
    public CharSequence getQuantityText(int id, int quantity) throws Resources.NotFoundException {
        CharSequence quantityText = this.resources.getQuantityText(id, quantity);
        Intrinsics.checkNotNullExpressionValue(quantityText, "resources.getQuantityText(id, quantity)");
        return quantityText;
    }

    @Override // android.content.res.Resources
    public String getResourceEntryName(int resid) throws Resources.NotFoundException {
        return this.resources.getResourceEntryName(resid);
    }

    @Override // android.content.res.Resources
    public String getResourceName(int resid) throws Resources.NotFoundException {
        return this.resources.getResourceName(resid);
    }

    @Override // android.content.res.Resources
    public String getResourcePackageName(int resid) throws Resources.NotFoundException {
        return this.resources.getResourcePackageName(resid);
    }

    @Override // android.content.res.Resources
    public String getResourceTypeName(int resid) throws Resources.NotFoundException {
        return this.resources.getResourceTypeName(resid);
    }

    @Override // android.content.res.Resources
    public String getString(int id, Object... formatArgs) throws Resources.NotFoundException {
        Intrinsics.checkNotNullParameter(formatArgs, "formatArgs");
        String string = this.resources.getString(id, Arrays.copyOf(formatArgs, formatArgs.length));
        Intrinsics.checkNotNullExpressionValue(string, "resources.getString(id, *formatArgs)");
        return string;
    }

    @Override // android.content.res.Resources
    public String getString(int id) throws Resources.NotFoundException {
        String string = this.resources.getString(id);
        Intrinsics.checkNotNullExpressionValue(string, "resources.getString(id)");
        return string;
    }

    @Override // android.content.res.Resources
    public String[] getStringArray(int id) throws Resources.NotFoundException {
        String[] stringArray = this.resources.getStringArray(id);
        Intrinsics.checkNotNullExpressionValue(stringArray, "resources.getStringArray(id)");
        return stringArray;
    }

    @Override // android.content.res.Resources
    public CharSequence getText(int id, CharSequence def) {
        return this.resources.getText(id, def);
    }

    @Override // android.content.res.Resources
    public CharSequence getText(int id) throws Resources.NotFoundException {
        CharSequence text = this.resources.getText(id);
        Intrinsics.checkNotNullExpressionValue(text, "resources.getText(id)");
        return text;
    }

    @Override // android.content.res.Resources
    public CharSequence[] getTextArray(int id) throws Resources.NotFoundException {
        CharSequence[] textArray = this.resources.getTextArray(id);
        Intrinsics.checkNotNullExpressionValue(textArray, "resources.getTextArray(id)");
        return textArray;
    }

    @Override // android.content.res.Resources
    public void getValue(String name, TypedValue outValue, boolean resolveRefs) throws Resources.NotFoundException {
        this.resources.getValue(name, outValue, resolveRefs);
    }

    @Override // android.content.res.Resources
    public void getValue(int id, TypedValue outValue, boolean resolveRefs) throws Resources.NotFoundException {
        this.resources.getValue(id, outValue, resolveRefs);
    }

    @Override // android.content.res.Resources
    public void getValueForDensity(int id, int density, TypedValue outValue, boolean resolveRefs) throws Resources.NotFoundException {
        this.resources.getValueForDensity(id, density, outValue, resolveRefs);
    }

    @Override // android.content.res.Resources
    public XmlResourceParser getXml(int id) throws Resources.NotFoundException {
        XmlResourceParser xml = this.resources.getXml(id);
        Intrinsics.checkNotNullExpressionValue(xml, "resources.getXml(id)");
        return xml;
    }

    @Override // android.content.res.Resources
    public TypedArray obtainAttributes(AttributeSet set, int[] attrs) {
        return this.resources.obtainAttributes(set, attrs);
    }

    @Override // android.content.res.Resources
    public TypedArray obtainTypedArray(int id) throws Resources.NotFoundException {
        TypedArray typedArrayObtainTypedArray = this.resources.obtainTypedArray(id);
        Intrinsics.checkNotNullExpressionValue(typedArrayObtainTypedArray, "resources.obtainTypedArray(id)");
        return typedArrayObtainTypedArray;
    }

    @Override // android.content.res.Resources
    public InputStream openRawResource(int id, TypedValue value) throws Resources.NotFoundException {
        InputStream inputStreamOpenRawResource = this.resources.openRawResource(id, value);
        Intrinsics.checkNotNullExpressionValue(inputStreamOpenRawResource, "resources.openRawResource(id, value)");
        return inputStreamOpenRawResource;
    }

    @Override // android.content.res.Resources
    public InputStream openRawResource(int id) throws Resources.NotFoundException {
        InputStream inputStreamOpenRawResource = this.resources.openRawResource(id);
        Intrinsics.checkNotNullExpressionValue(inputStreamOpenRawResource, "resources.openRawResource(id)");
        return inputStreamOpenRawResource;
    }

    @Override // android.content.res.Resources
    public AssetFileDescriptor openRawResourceFd(int id) throws Resources.NotFoundException {
        return this.resources.openRawResourceFd(id);
    }

    @Override // android.content.res.Resources
    public void parseBundleExtra(String tagName, AttributeSet attrs, Bundle outBundle) throws XmlPullParserException {
        this.resources.parseBundleExtra(tagName, attrs, outBundle);
    }

    @Override // android.content.res.Resources
    public void parseBundleExtras(XmlResourceParser parser, Bundle outBundle) throws XmlPullParserException, IOException {
        this.resources.parseBundleExtras(parser, outBundle);
    }

    @Override // android.content.res.Resources
    public void removeLoaders(ResourcesLoader... loaders) {
        Intrinsics.checkNotNullParameter(loaders, "loaders");
        this.resources.removeLoaders((ResourcesLoader[]) Arrays.copyOf(loaders, loaders.length));
    }

    @Override // android.content.res.Resources
    @Deprecated(message = "Deprecated in Java")
    public void updateConfiguration(Configuration config, DisplayMetrics metrics) {
        super.updateConfiguration(config, metrics);
        Resources resources = this.resources;
        if (resources != null) {
            resources.updateConfiguration(config, metrics);
        }
    }
}
