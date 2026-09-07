package io.bidmachine.iab.vast.tags;

import android.text.TextUtils;
import io.bidmachine.iab.utils.IabElementStyle;
import io.bidmachine.iab.vast.VastLog;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes9.dex */
public class PostBannerTag extends VastXmlTag {
    private String g;
    private final IabElementStyle c = new IabElementStyle();
    private final IabElementStyle d = new IabElementStyle();
    private final IabElementStyle e = new IabElementStyle();
    private final IabElementStyle f = new IabElementStyle();
    private float h = 0.0f;
    private float i = 0.0f;
    private boolean j = true;
    private boolean k = false;
    private boolean l = false;
    private boolean m = false;
    private boolean n = false;

    @Override // io.bidmachine.iab.vast.tags.VastXmlTag
    protected void a(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        IabElementStyle iabElementStyle;
        xmlPullParser.require(2, null, VastTagName.POSTBANNER);
        while (xmlPullParser.next() != 3) {
            if (xmlPullParser.getEventType() == 2) {
                try {
                    String name = xmlPullParser.getName();
                    if (VastXmlTag.a(name, VastTagName.CLOSE_TIME)) {
                        String strC = VastXmlTag.c(xmlPullParser);
                        if (!TextUtils.isEmpty(strC)) {
                            this.h = Float.parseFloat(strC);
                        }
                    } else if (VastXmlTag.a(name, "Duration")) {
                        String strC2 = VastXmlTag.c(xmlPullParser);
                        if (!TextUtils.isEmpty(strC2)) {
                            this.i = Float.parseFloat(strC2);
                        }
                    } else {
                        if (VastXmlTag.a(name, VastTagName.CLOSEABLE_VIEW)) {
                            iabElementStyle = this.c;
                        } else if (VastXmlTag.a(name, VastTagName.COUNTDOWN)) {
                            iabElementStyle = this.d;
                        } else if (VastXmlTag.a(name, VastTagName.LOADING_VIEW)) {
                            iabElementStyle = this.e;
                        } else if (VastXmlTag.a(name, VastTagName.PROGRESS)) {
                            iabElementStyle = this.f;
                        } else if (VastXmlTag.a(name, VastTagName.USE_NATIVE_CLOSE)) {
                            this.l = VastXmlTag.b(xmlPullParser);
                        } else if (VastXmlTag.a(name, VastTagName.IGNORE_SAFE_AREA)) {
                            this.k = VastXmlTag.b(xmlPullParser);
                        } else if (VastXmlTag.a(name, VastTagName.PRODUCT_LINK)) {
                            this.g = VastXmlTag.c(xmlPullParser);
                        } else if (VastXmlTag.a(name, VastTagName.R1)) {
                            this.m = VastXmlTag.b(xmlPullParser);
                        } else if (VastXmlTag.a(name, VastTagName.R2)) {
                            this.n = VastXmlTag.b(xmlPullParser);
                        } else {
                            VastXmlTag.d(xmlPullParser);
                        }
                        VastXmlTag.a(xmlPullParser, iabElementStyle);
                    }
                } catch (Throwable th) {
                    VastLog.e("VastXmlTag", th);
                }
            }
        }
        xmlPullParser.require(3, null, VastTagName.POSTBANNER);
    }

    public IabElementStyle getCloseStyle() {
        return this.c;
    }

    public float getCloseTimeSec() {
        return this.h;
    }

    public IabElementStyle getCountDownStyle() {
        return this.d;
    }

    public float getDurationSec() {
        return this.i;
    }

    public IabElementStyle getLoadingStyle() {
        return this.e;
    }

    public String getProductLink() {
        return this.g;
    }

    public IabElementStyle getProgressStyle() {
        return this.f;
    }

    public boolean isForceUseNativeClose() {
        return this.l;
    }

    public boolean isIgnoreSafeArea() {
        return this.k;
    }

    public boolean isR1() {
        return this.m;
    }

    public boolean isR2() {
        return this.n;
    }

    public boolean isVisible() {
        return this.j;
    }

    public void setCloseTimeSec(int closeTimeSec) {
        this.h = closeTimeSec;
    }

    public void setVisible(boolean visible) {
        this.j = visible;
    }
}
