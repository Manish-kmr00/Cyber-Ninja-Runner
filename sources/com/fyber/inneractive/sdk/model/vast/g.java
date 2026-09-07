package com.fyber.inneractive.sdk.model.vast;

import android.text.TextUtils;
import com.fyber.inneractive.sdk.util.IAlog;
import com.fyber.inneractive.sdk.util.y0;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/* JADX INFO: loaded from: classes12.dex */
public abstract class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f1878a;
    public o e;
    public v g;
    public final ArrayList d = new ArrayList();
    public int f = 0;
    public final ArrayList h = new ArrayList(1);
    public final ArrayList b = new ArrayList();
    public final ArrayList c = new ArrayList();

    public final void a(Node node) {
        w wVar;
        Node nodeD = y0.d(node, "AdVerifications");
        if (nodeD != null) {
            for (Node node2 : y0.c(nodeD, "Verification")) {
                com.fyber.inneractive.sdk.measurement.i iVar = null;
                if (node2 != null) {
                    com.fyber.inneractive.sdk.measurement.i iVar2 = new com.fyber.inneractive.sdk.measurement.i();
                    iVar2.e = y0.b(node2, "vendor");
                    Node nodeD2 = y0.d(node2, "JavaScriptResource");
                    if (nodeD2 != null) {
                        iVar2.g = true;
                        try {
                            iVar2.f = y0.a(nodeD2);
                            iVar2.b = y0.b(nodeD2, "apiFramework");
                            iVar2.f1863a = new URL(iVar2.f);
                        } catch (MalformedURLException unused) {
                        }
                    }
                    Node nodeD3 = y0.d(node2, "TrackingEvents");
                    if (nodeD3 != null) {
                        for (Node node3 : y0.c(nodeD3, "Tracking")) {
                            if (node3 == null) {
                                wVar = null;
                            } else {
                                wVar = new w();
                                wVar.f1889a = y0.b(node3, "event");
                                wVar.b = y0.a(node3);
                                wVar.c = y0.b(node3, "offset");
                            }
                            if (node3 != null && wVar.f1889a.equalsIgnoreCase("verificationNotExecuted")) {
                                iVar2.a(x.EVENT_VERIFICATION_NOT_EXECUTED, wVar.b);
                            }
                        }
                    }
                    Node nodeD4 = y0.d(node2, "VerificationParameters");
                    if (nodeD4 != null) {
                        iVar2.d = y0.a(nodeD4);
                    }
                    iVar = iVar2;
                }
                if (iVar != null) {
                    IAlog.a("Verification Found - %s", iVar.toString());
                    this.d.add(iVar);
                }
            }
        }
    }

    public void b(Node node) {
        Node nodeD;
        NodeList childNodes;
        NodeList childNodes2;
        m mVar;
        h hVar;
        w wVar;
        w wVar2;
        r rVar;
        g gVar = this;
        Node nodeD2 = y0.d(node, "AdSystem");
        if (nodeD2 != null) {
            y0.b(nodeD2, "version");
            y0.a(nodeD2);
        }
        Node nodeD3 = y0.d(node, "Error");
        if (nodeD3 != null) {
            String strA = y0.a(nodeD3);
            if (!TextUtils.isEmpty(strA)) {
                gVar.f1878a = strA;
            }
        }
        Iterator it = y0.c(node, "Impression").iterator();
        while (it.hasNext()) {
            String strA2 = y0.a((Node) it.next());
            if (!TextUtils.isEmpty(strA2)) {
                gVar.b.add(strA2);
            }
        }
        Node nodeD4 = y0.d(node, "Creatives");
        if (nodeD4 != null) {
            Iterator it2 = y0.c(nodeD4, "Creative").iterator();
            while (it2.hasNext()) {
                Node node2 = (Node) it2.next();
                if (node2 == null) {
                    it2 = it2;
                    mVar = null;
                } else {
                    mVar = new m();
                    if (TextUtils.isEmpty(y0.b(node2, "AdID"))) {
                        y0.b(node2, "adId");
                    }
                    y0.b(node2, "id");
                    y0.a(node2, "sequence");
                    Node nodeD5 = y0.d(node2, "Linear");
                    if (nodeD5 != null) {
                        q qVar = new q();
                        Node nodeD6 = y0.d(nodeD5, "MediaFiles");
                        if (nodeD6 != null) {
                            ArrayList arrayListC = y0.c(nodeD6, "MediaFile");
                            if (!arrayListC.isEmpty()) {
                                qVar.f1885a = new ArrayList();
                                for (Iterator it3 = arrayListC.iterator(); it3.hasNext(); it3 = it3) {
                                    Node node3 = (Node) it3.next();
                                    if (node3 == null) {
                                        rVar = null;
                                    } else {
                                        rVar = new r();
                                        rVar.f1886a = y0.b(node3, "delivery");
                                        rVar.b = y0.a(node3, "width");
                                        rVar.c = y0.a(node3, "height");
                                        rVar.d = y0.b(node3, "type");
                                        y0.b(node3, "id");
                                        rVar.f = y0.b(node3, "apiFramework");
                                        rVar.e = y0.a(node3, "bitrate");
                                        String strB = y0.b(node3, "maintainAspectRatio");
                                        if (!TextUtils.isEmpty(strB)) {
                                            try {
                                                Boolean.valueOf(strB);
                                            } catch (Exception unused) {
                                            }
                                        }
                                        String strB2 = y0.b(node3, "scalable");
                                        if (!TextUtils.isEmpty(strB2)) {
                                            try {
                                                Boolean.valueOf(strB2);
                                            } catch (Exception unused2) {
                                            }
                                        }
                                        rVar.g = y0.a(node3);
                                    }
                                    if (rVar != null) {
                                        qVar.f1885a.add(rVar);
                                    }
                                }
                            }
                        }
                        Node nodeD7 = y0.d(nodeD5, "VideoClicks");
                        if (nodeD7 != null) {
                            qVar.c = y0.a(y0.d(nodeD7, "ClickThrough"));
                            ArrayList arrayListC2 = y0.c(nodeD7, "ClickTracking");
                            if (!arrayListC2.isEmpty()) {
                                qVar.d = new ArrayList();
                                Iterator it4 = arrayListC2.iterator();
                                while (it4.hasNext()) {
                                    String strA3 = y0.a((Node) it4.next());
                                    if (!TextUtils.isEmpty(strA3)) {
                                        qVar.d.add(strA3);
                                    }
                                }
                            }
                        }
                        Node nodeD8 = y0.d(nodeD5, "TrackingEvents");
                        if (nodeD8 != null) {
                            ArrayList arrayListC3 = y0.c(nodeD8, "Tracking");
                            if (!arrayListC3.isEmpty()) {
                                qVar.b = new ArrayList();
                                for (Iterator it5 = arrayListC3.iterator(); it5.hasNext(); it5 = it5) {
                                    Node node4 = (Node) it5.next();
                                    if (node4 == null) {
                                        wVar2 = null;
                                    } else {
                                        wVar2 = new w();
                                        wVar2.f1889a = y0.b(node4, "event");
                                        wVar2.b = y0.a(node4);
                                        wVar2.c = y0.b(node4, "offset");
                                    }
                                    if (wVar2 != null) {
                                        qVar.b.add(wVar2);
                                    }
                                }
                            }
                        }
                        Node nodeD9 = y0.d(nodeD5, "Duration");
                        if (nodeD9 != null) {
                            qVar.e = y0.a(nodeD9);
                        }
                        mVar.f1882a = qVar;
                    }
                    Node nodeD10 = y0.d(node2, "CompanionAds");
                    if (nodeD10 != null) {
                        j jVar = new j();
                        String strB3 = y0.b(nodeD10, "required");
                        if (!"all".equalsIgnoreCase(strB3)) {
                            "none".equalsIgnoreCase(strB3);
                        }
                        ArrayList arrayListC4 = y0.c(nodeD10, "Companion");
                        jVar.f1880a.clear();
                        Iterator it6 = arrayListC4.iterator();
                        while (it6.hasNext()) {
                            Node node5 = (Node) it6.next();
                            if (node5 == null) {
                                it6 = it6;
                                hVar = null;
                            } else {
                                hVar = new h();
                                hVar.f1879a = y0.a(node5, "width");
                                hVar.b = y0.a(node5, "height");
                                hVar.c = y0.b(node5, "id");
                                y0.b(node5, "apiFramework");
                                y0.a(node5, "expandedWidth");
                                y0.a(node5, "expandedHeight");
                                Node nodeD11 = y0.d(node5, "StaticResource");
                                if (nodeD11 != null) {
                                    l lVar = new l();
                                    lVar.f1881a = y0.b(nodeD11, "creativeType");
                                    lVar.b = y0.a(nodeD11);
                                    hVar.d = lVar;
                                }
                                Node nodeD12 = y0.d(node5, "HTMLResource");
                                if (nodeD12 != null) {
                                    hVar.f = y0.a(nodeD12);
                                }
                                Node nodeD13 = y0.d(node5, "IFrameResource");
                                if (nodeD13 != null) {
                                    hVar.e = y0.a(nodeD13);
                                }
                                Node nodeD14 = y0.d(node5, "CompanionClickThrough");
                                if (nodeD14 != null) {
                                    hVar.g = y0.a(nodeD14);
                                }
                                hVar.h.clear();
                                ArrayList arrayListC5 = y0.c(node5, "CompanionClickTracking");
                                if (arrayListC5.size() > 0) {
                                    Iterator it7 = arrayListC5.iterator();
                                    while (it7.hasNext()) {
                                        String strA4 = y0.a((Node) it7.next());
                                        if (!TextUtils.isEmpty(strA4)) {
                                            hVar.h.add(strA4);
                                        }
                                    }
                                }
                                hVar.j.clear();
                                Node nodeD15 = y0.d(node5, "TrackingEvents");
                                if (nodeD15 != null) {
                                    ArrayList<Node> arrayListC6 = y0.c(nodeD15, "Tracking");
                                    if (!arrayListC6.isEmpty()) {
                                        for (Node node6 : arrayListC6) {
                                            if (node6 == null) {
                                                wVar = null;
                                            } else {
                                                wVar = new w();
                                                wVar.f1889a = y0.b(node6, "event");
                                                wVar.b = y0.a(node6);
                                                wVar.c = y0.b(node6, "offset");
                                            }
                                            if (wVar != null) {
                                                hVar.j.add(wVar);
                                            }
                                        }
                                    }
                                }
                            }
                            if (hVar != null) {
                                jVar.f1880a.add(hVar);
                            }
                            it6 = it6;
                        }
                        mVar.b = jVar;
                    }
                }
                gVar = this;
                if (mVar != null) {
                    gVar.c.add(mVar);
                }
                it2 = it2;
            }
        }
        Node nodeD16 = y0.d(node, "Extensions");
        if (nodeD16 != null) {
            for (Node node7 : y0.c(nodeD16, "Extension")) {
                if ("AdVerifications".equalsIgnoreCase(y0.b(node7, "type"))) {
                    gVar.a(node7);
                }
                if ("FMPCompanionAssets".equalsIgnoreCase(y0.b(node7, "type"))) {
                    IAlog.a("parseFMPCompanionAssetsTag", new Object[0]);
                    Node nodeD17 = y0.d(node7, "FMPCompanionAssets");
                    if (nodeD17 != null) {
                        o oVar = new o();
                        String strB4 = y0.b(nodeD17, "enableMultipleCompanions");
                        if ("false".equalsIgnoreCase(strB4) || "0".equals(strB4)) {
                            oVar.d = false;
                        }
                        Node nodeD18 = y0.d(nodeD17, "Name");
                        if (nodeD18 != null) {
                            oVar.f1884a = y0.a(nodeD18);
                        }
                        Node nodeD19 = y0.d(nodeD17, "Description");
                        if (nodeD19 != null) {
                            y0.a(nodeD19);
                        }
                        oVar.b.clear();
                        Node nodeD20 = y0.d(nodeD17, "Icons");
                        if (nodeD20 != null) {
                            Iterator it8 = y0.c(nodeD20, "Icon").iterator();
                            while (it8.hasNext()) {
                                oVar.b.add(y0.a((Node) it8.next()));
                            }
                        }
                        Node nodeD21 = y0.d(nodeD17, "Rating");
                        if (nodeD21 != null) {
                            try {
                                Float.parseFloat(y0.a(nodeD21));
                            } catch (Exception unused3) {
                            }
                        }
                        Node nodeD22 = y0.d(nodeD17, "Screenshots");
                        if (nodeD22 != null) {
                            oVar.c = new ArrayList();
                            Iterator it9 = y0.c(nodeD22, "Screenshot").iterator();
                            while (it9.hasNext()) {
                                String strA5 = y0.a((Node) it9.next());
                                if (!TextUtils.isEmpty(strA5)) {
                                    oVar.c.add(strA5);
                                }
                            }
                        }
                        gVar.e = oVar;
                    }
                }
                if ("DynamicVideoControlsURL".equalsIgnoreCase(y0.b(node7, "type"))) {
                    Node nodeD23 = y0.d(node7, "DynamicVideoControlsURL");
                    n nVar = new n();
                    if (nodeD23 != null) {
                        nVar.f1883a = y0.a(nodeD23);
                    }
                    if (!TextUtils.isEmpty(nVar.f1883a)) {
                        gVar.h.add(nVar);
                    }
                }
                if ("StorePromoAssets".equalsIgnoreCase(y0.b(node7, "type")) && (nodeD = y0.d(node7, "DTSPR")) != null) {
                    v vVar = new v();
                    Node nodeD24 = y0.d(nodeD, "DTSPNm");
                    if (nodeD24 != null) {
                        vVar.b = y0.a(nodeD24);
                    }
                    Node nodeD25 = y0.d(nodeD, "DTSPTUrl");
                    if (nodeD25 != null) {
                        vVar.c = y0.a(nodeD25);
                    }
                    Node nodeD26 = y0.d(nodeD, "DTSPPNm");
                    if (nodeD26 != null) {
                        vVar.i = y0.a(nodeD26);
                    }
                    Node nodeD27 = y0.d(nodeD, "DTSPIap");
                    if (nodeD27 != null) {
                        vVar.d = y0.a(nodeD27);
                    }
                    Node nodeD28 = y0.d(nodeD, "DTSPCads");
                    if (nodeD28 != null) {
                        vVar.e = y0.a(nodeD28);
                    }
                    Node nodeD29 = y0.d(nodeD, "DTSPMedia");
                    if (nodeD29 != null && (childNodes2 = nodeD29.getChildNodes()) != null && childNodes2.getLength() != 0) {
                        for (int i = 0; i < childNodes2.getLength(); i++) {
                            Node nodeItem = childNodes2.item(i);
                            if (nodeItem != null) {
                                String nodeName = nodeItem.getNodeName();
                                if ("DTSPScrn".equalsIgnoreCase(nodeName)) {
                                    vVar.f.add(y0.a(nodeItem));
                                } else if ("DTSPVid".equalsIgnoreCase(nodeName)) {
                                    vVar.g.add(y0.a(nodeItem));
                                } else if ("DTSPIcon".equalsIgnoreCase(nodeName)) {
                                    vVar.f1888a = y0.a(nodeItem);
                                }
                            }
                        }
                    }
                    Node nodeD30 = y0.d(nodeD, "DTSPMetadata");
                    if (nodeD30 != null && (childNodes = nodeD30.getChildNodes()) != null && childNodes.getLength() != 0) {
                        String strA6 = null;
                        String strA7 = null;
                        String strA8 = null;
                        for (int i2 = 0; i2 < childNodes.getLength(); i2++) {
                            Node nodeItem2 = childNodes.item(i2);
                            if (nodeItem2 != null) {
                                String nodeName2 = nodeItem2.getNodeName();
                                if ("DTSPLabel".equalsIgnoreCase(nodeName2)) {
                                    strA6 = y0.a(nodeItem2);
                                } else if ("DTSPRating".equalsIgnoreCase(nodeName2)) {
                                    strA7 = y0.a(nodeItem2);
                                } else if ("DTSPSize".equalsIgnoreCase(nodeName2)) {
                                    strA8 = y0.a(nodeItem2);
                                }
                            }
                        }
                        if (!TextUtils.isEmpty(strA6) && !TextUtils.isEmpty(strA7) && !TextUtils.isEmpty(strA8)) {
                            vVar.h = new com.fyber.inneractive.sdk.flow.storepromo.model.d(strA7, strA6, strA8);
                        }
                    }
                    gVar.g = vVar;
                }
            }
        }
        a(node);
    }
}
