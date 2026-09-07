package com.iab.omid.library.odeeoio.adsession;

import android.view.View;
import com.iab.omid.library.odeeoio.b.c;
import com.iab.omid.library.odeeoio.b.f;
import com.iab.omid.library.odeeoio.d.e;
import com.iab.omid.library.odeeoio.publisher.AdSessionStatePublisher;
import com.iab.omid.library.odeeoio.publisher.b;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import java.util.regex.Pattern;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes7.dex */
public class a extends AdSession {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Pattern f2766a = Pattern.compile("^[a-zA-Z0-9 ]+$");
    private final AdSessionContext b;
    private final AdSessionConfiguration c;
    private com.iab.omid.library.odeeoio.e.a e;
    private AdSessionStatePublisher f;
    private boolean j;
    private boolean k;
    private PossibleObstructionListener l;
    private final List<c> d = new ArrayList();
    private boolean g = false;
    private boolean h = false;
    private final String i = UUID.randomUUID().toString();

    a(AdSessionConfiguration adSessionConfiguration, AdSessionContext adSessionContext) {
        this.c = adSessionConfiguration;
        this.b = adSessionContext;
        c(null);
        this.f = (adSessionContext.getAdSessionContextType() == AdSessionContextType.HTML || adSessionContext.getAdSessionContextType() == AdSessionContextType.JAVASCRIPT) ? new com.iab.omid.library.odeeoio.publisher.a(adSessionContext.getWebView()) : new b(adSessionContext.getInjectedResourcesMap(), adSessionContext.getOmidJsScriptContent());
        this.f.a();
        com.iab.omid.library.odeeoio.b.a.a().a(this);
        this.f.a(adSessionConfiguration);
    }

    private c a(View view) {
        for (c cVar : this.d) {
            if (cVar.a().get() == view) {
                return cVar;
            }
        }
        return null;
    }

    private void a(String str) {
        if (str != null) {
            if (str.length() > 50) {
                throw new IllegalArgumentException("FriendlyObstruction has detailed reason over 50 characters in length");
            }
            if (!f2766a.matcher(str).matches()) {
                throw new IllegalArgumentException("FriendlyObstruction has detailed reason that contains characters not in [a-z][A-Z][0-9] or space");
            }
        }
    }

    private static void b(View view) {
        if (view == null) {
            throw new IllegalArgumentException("FriendlyObstruction is null");
        }
    }

    private void c(View view) {
        this.e = new com.iab.omid.library.odeeoio.e.a(view);
    }

    private void d(View view) {
        Collection<a> collectionB = com.iab.omid.library.odeeoio.b.a.a().b();
        if (collectionB == null || collectionB.isEmpty()) {
            return;
        }
        for (a aVar : collectionB) {
            if (aVar != this && aVar.e() == view) {
                aVar.e.clear();
            }
        }
    }

    private void k() {
        if (this.j) {
            throw new IllegalStateException("Impression event can only be sent once");
        }
    }

    private void l() {
        if (this.k) {
            throw new IllegalStateException("Loaded event can only be sent once");
        }
    }

    public List<c> a() {
        return this.d;
    }

    public void a(List<com.iab.omid.library.odeeoio.e.a> list) {
        if (b()) {
            ArrayList arrayList = new ArrayList();
            Iterator<com.iab.omid.library.odeeoio.e.a> it = list.iterator();
            while (it.hasNext()) {
                View view = (View) it.next().get();
                if (view != null) {
                    arrayList.add(view);
                }
            }
            this.l.onPossibleObstructionsDetected(this.i, arrayList);
        }
    }

    void a(JSONObject jSONObject) {
        l();
        getAdSessionStatePublisher().a(jSONObject);
        this.k = true;
    }

    @Override // com.iab.omid.library.odeeoio.adsession.AdSession
    public void addFriendlyObstruction(View view, FriendlyObstructionPurpose friendlyObstructionPurpose, String str) {
        if (this.h) {
            return;
        }
        b(view);
        a(str);
        if (a(view) == null) {
            this.d.add(new c(view, friendlyObstructionPurpose, str));
        }
    }

    public boolean b() {
        return this.l != null;
    }

    void c() {
        k();
        getAdSessionStatePublisher().g();
        this.j = true;
    }

    void d() {
        l();
        getAdSessionStatePublisher().h();
        this.k = true;
    }

    public View e() {
        return (View) this.e.get();
    }

    @Override // com.iab.omid.library.odeeoio.adsession.AdSession
    public void error(ErrorType errorType, String str) {
        if (this.h) {
            throw new IllegalStateException("AdSession is finished");
        }
        e.a(errorType, "Error type is null");
        e.a(str, "Message is null");
        getAdSessionStatePublisher().a(errorType, str);
    }

    public boolean f() {
        return this.g && !this.h;
    }

    @Override // com.iab.omid.library.odeeoio.adsession.AdSession
    public void finish() {
        if (this.h) {
            return;
        }
        this.e.clear();
        removeAllFriendlyObstructions();
        this.h = true;
        getAdSessionStatePublisher().f();
        com.iab.omid.library.odeeoio.b.a.a().c(this);
        getAdSessionStatePublisher().b();
        this.f = null;
        this.l = null;
    }

    public boolean g() {
        return this.g;
    }

    @Override // com.iab.omid.library.odeeoio.adsession.AdSession
    public String getAdSessionId() {
        return this.i;
    }

    @Override // com.iab.omid.library.odeeoio.adsession.AdSession
    public AdSessionStatePublisher getAdSessionStatePublisher() {
        return this.f;
    }

    public boolean h() {
        return this.h;
    }

    public boolean i() {
        return this.c.isNativeImpressionOwner();
    }

    public boolean j() {
        return this.c.isNativeMediaEventsOwner();
    }

    @Override // com.iab.omid.library.odeeoio.adsession.AdSession
    public void registerAdView(View view) {
        if (this.h) {
            return;
        }
        e.a(view, "AdView is null");
        if (e() == view) {
            return;
        }
        c(view);
        getAdSessionStatePublisher().i();
        d(view);
    }

    @Override // com.iab.omid.library.odeeoio.adsession.AdSession
    public void removeAllFriendlyObstructions() {
        if (this.h) {
            return;
        }
        this.d.clear();
    }

    @Override // com.iab.omid.library.odeeoio.adsession.AdSession
    public void removeFriendlyObstruction(View view) {
        if (this.h) {
            return;
        }
        b(view);
        c cVarA = a(view);
        if (cVarA != null) {
            this.d.remove(cVarA);
        }
    }

    @Override // com.iab.omid.library.odeeoio.adsession.AdSession
    public void setPossibleObstructionListener(PossibleObstructionListener possibleObstructionListener) {
        this.l = possibleObstructionListener;
    }

    @Override // com.iab.omid.library.odeeoio.adsession.AdSession
    public void start() {
        if (this.g) {
            return;
        }
        this.g = true;
        com.iab.omid.library.odeeoio.b.a.a().b(this);
        this.f.a(f.a().d());
        this.f.a(this, this.b);
    }
}
