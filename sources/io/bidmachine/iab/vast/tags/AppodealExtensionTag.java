package io.bidmachine.iab.vast.tags;

import io.bidmachine.iab.utils.IabElementStyle;
import io.bidmachine.iab.vast.VastExtension;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes13.dex */
public class AppodealExtensionTag extends ExtensionTag implements VastExtension {
    private final IabElementStyle d;
    private final IabElementStyle e;
    private final IabElementStyle f;
    private final IabElementStyle g;
    private final IabElementStyle h;
    private final IabElementStyle i;
    private final IabElementStyle j;
    private final IabElementStyle k;
    private final PostBannerTag l;
    private Integer m;
    private Integer n;
    private CompanionTag o;
    private Boolean p;
    private Float q;
    private boolean r;
    private boolean s;
    private boolean t;
    private boolean u;
    private Integer v;

    AppodealExtensionTag(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        IabElementStyle iabElementStyle;
        IabElementStyle iabElementStyle2;
        IabElementStyle iabElementStyle3;
        IabElementStyle iabElementStyle4;
        super(xmlPullParser);
        this.d = new IabElementStyle();
        this.e = new IabElementStyle();
        this.f = new IabElementStyle();
        this.g = new IabElementStyle();
        this.h = new IabElementStyle();
        this.i = new IabElementStyle();
        this.j = new IabElementStyle();
        this.k = new IabElementStyle();
        this.l = new PostBannerTag();
        this.r = false;
        this.s = false;
        this.t = false;
        this.u = false;
        xmlPullParser.require(2, null, "Extension");
        while (xmlPullParser.next() != 3) {
            if (xmlPullParser.getEventType() == 2) {
                String name = xmlPullParser.getName();
                if (VastXmlTag.a(name, VastTagName.VIDEO)) {
                    iabElementStyle = this.d;
                } else if (VastXmlTag.a(name, VastTagName.LOADING_VIEW)) {
                    iabElementStyle = this.j;
                } else if (VastXmlTag.a(name, VastTagName.COUNTDOWN)) {
                    iabElementStyle = this.k;
                } else if (VastXmlTag.a(name, VastTagName.PROGRESS)) {
                    iabElementStyle = this.h;
                } else if (VastXmlTag.a(name, VastTagName.CLOSEABLE_VIEW)) {
                    iabElementStyle = this.g;
                } else if (VastXmlTag.a(name, VastTagName.MUTE)) {
                    iabElementStyle = this.f;
                } else if (VastXmlTag.a(name, VastTagName.CTA)) {
                    iabElementStyle = this.e;
                } else if (VastXmlTag.a(name, VastTagName.REPEAT_VIEW)) {
                    iabElementStyle = this.i;
                } else if (VastXmlTag.a(name, VastTagName.POSTBANNER)) {
                    this.l.parse(xmlPullParser);
                } else if (VastXmlTag.a(name, VastTagName.AUTO_ROTATE)) {
                    this.p = Boolean.valueOf(VastXmlTag.b(xmlPullParser));
                } else if (VastXmlTag.a(name, VastTagName.R1)) {
                    this.t = VastXmlTag.b(xmlPullParser);
                } else if (VastXmlTag.a(name, VastTagName.R2)) {
                    this.u = VastXmlTag.b(xmlPullParser);
                } else if (VastXmlTag.a(name, "ForceOrientation")) {
                    this.v = VastXmlTag.g(VastXmlTag.c(xmlPullParser));
                } else if (VastXmlTag.a(name, VastTagName.CTA_TEXT)) {
                    this.e.setContent(VastXmlTag.c(xmlPullParser));
                } else {
                    if (VastXmlTag.a(name, VastTagName.SHOW_CTA)) {
                        iabElementStyle2 = this.e;
                    } else if (VastXmlTag.a(name, VastTagName.SHOW_MUTE)) {
                        iabElementStyle2 = this.f;
                    } else if (VastXmlTag.a(name, VastTagName.SHOW_COMPANION)) {
                        this.l.setVisible(VastXmlTag.b(xmlPullParser));
                    } else if (VastXmlTag.a(name, VastTagName.COMPANION_CLOSE_TIME)) {
                        int iF = VastXmlTag.f(VastXmlTag.c(xmlPullParser));
                        if (iF > -1) {
                            this.l.setCloseTimeSec(iF);
                        }
                    } else if (VastXmlTag.a(name, VastTagName.MUTED)) {
                        this.r = VastXmlTag.b(xmlPullParser);
                    } else if (VastXmlTag.a(name, VastTagName.VIDEO_CLICKABLE)) {
                        this.s = VastXmlTag.b(xmlPullParser);
                    } else {
                        if (VastXmlTag.a(name, VastTagName.CTA_X_POSITION)) {
                            iabElementStyle3 = this.e;
                        } else {
                            if (VastXmlTag.a(name, VastTagName.CTA_Y_POSITION)) {
                                iabElementStyle4 = this.e;
                            } else if (VastXmlTag.a(name, VastTagName.CLOSE_X_POSITION)) {
                                iabElementStyle3 = this.g;
                            } else if (VastXmlTag.a(name, VastTagName.CLOSE_Y_POSITION)) {
                                iabElementStyle4 = this.g;
                            } else if (VastXmlTag.a(name, VastTagName.MUTE_X_POSITION)) {
                                iabElementStyle3 = this.f;
                            } else if (VastXmlTag.a(name, VastTagName.MUTE_Y_POSITION)) {
                                iabElementStyle4 = this.f;
                            } else if (VastXmlTag.a(name, VastTagName.ASSETS_COLOR)) {
                                Integer numC = VastXmlTag.c(VastXmlTag.c(xmlPullParser));
                                if (numC != null) {
                                    this.m = numC;
                                }
                            } else if (VastXmlTag.a(name, VastTagName.ASSETS_BACKGROUND_COLOR)) {
                                Integer numC2 = VastXmlTag.c(VastXmlTag.c(xmlPullParser));
                                if (numC2 != null) {
                                    this.n = numC2;
                                }
                            } else if (VastXmlTag.a(name, "Companion")) {
                                CompanionTag companionTag = new CompanionTag(xmlPullParser);
                                if (companionTag.isValidTag() && companionTag.hasCreative()) {
                                    this.o = companionTag;
                                }
                            } else if (VastXmlTag.a(name, VastTagName.CLOSE_TIME)) {
                                String strC = VastXmlTag.c(xmlPullParser);
                                if (strC != null) {
                                    this.q = Float.valueOf(Float.parseFloat(strC));
                                }
                            } else if (VastXmlTag.a(name, VastTagName.SHOW_PROGRESS)) {
                                iabElementStyle2 = this.h;
                            } else {
                                VastXmlTag.d(xmlPullParser);
                            }
                            iabElementStyle4.setVerticalPosition(VastXmlTag.i(VastXmlTag.c(xmlPullParser)));
                        }
                        iabElementStyle3.setHorizontalPosition(VastXmlTag.h(VastXmlTag.c(xmlPullParser)));
                    }
                    iabElementStyle2.setVisible(Boolean.valueOf(VastXmlTag.b(xmlPullParser)));
                }
                VastXmlTag.a(xmlPullParser, iabElementStyle);
            }
        }
        xmlPullParser.require(3, null, "Extension");
    }

    @Override // io.bidmachine.iab.vast.VastExtension
    public Integer getAssetsBackgroundColor() {
        return this.n;
    }

    @Override // io.bidmachine.iab.vast.VastExtension
    public Integer getAssetsColor() {
        return this.m;
    }

    @Override // io.bidmachine.iab.vast.VastExtension
    public IabElementStyle getCloseStyle() {
        return this.g;
    }

    @Override // io.bidmachine.iab.vast.VastExtension
    public Float getCloseTimeSec() {
        return this.q;
    }

    @Override // io.bidmachine.iab.vast.VastExtension
    public CompanionTag getCompanionTag() {
        return this.o;
    }

    @Override // io.bidmachine.iab.vast.VastExtension
    public IabElementStyle getCountDownStyle() {
        return this.k;
    }

    @Override // io.bidmachine.iab.vast.VastExtension
    public IabElementStyle getCtaStyle() {
        return this.e;
    }

    @Override // io.bidmachine.iab.vast.VastExtension
    public Integer getForceOrientation() {
        return this.v;
    }

    @Override // io.bidmachine.iab.vast.VastExtension
    public IabElementStyle getLoadingStyle() {
        return this.j;
    }

    @Override // io.bidmachine.iab.vast.VastExtension
    public IabElementStyle getMuteStyle() {
        return this.f;
    }

    @Override // io.bidmachine.iab.vast.VastExtension
    public PostBannerTag getPostBannerTag() {
        return this.l;
    }

    @Override // io.bidmachine.iab.vast.VastExtension
    public IabElementStyle getProgressStyle() {
        return this.h;
    }

    @Override // io.bidmachine.iab.vast.VastExtension
    public IabElementStyle getRepeatStyle() {
        return this.i;
    }

    @Override // io.bidmachine.iab.vast.VastExtension
    public IabElementStyle getVideoStyle() {
        return this.d;
    }

    @Override // io.bidmachine.iab.vast.VastExtension
    public Boolean isAutoRotate() {
        return this.p;
    }

    @Override // io.bidmachine.iab.vast.VastExtension
    public boolean isMuted() {
        return this.r;
    }

    @Override // io.bidmachine.iab.vast.VastExtension
    public boolean isR1() {
        return this.t;
    }

    @Override // io.bidmachine.iab.vast.VastExtension
    public boolean isR2() {
        return this.u;
    }

    @Override // io.bidmachine.iab.vast.VastExtension
    public boolean isVideoClickable() {
        return this.s;
    }
}
