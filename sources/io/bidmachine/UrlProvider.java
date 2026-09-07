package io.bidmachine;

import android.net.Uri;
import android.text.TextUtils;
import io.bidmachine.core.Logger;
import io.bidmachine.core.Utils;
import io.bidmachine.utils.lazy.LazyValue;
import java.util.Collection;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/* JADX INFO: loaded from: classes9.dex */
public class UrlProvider {
    private static final String PATH_AUCTION = "auction";
    private static final String PATH_INIT = "init";
    private static final String PATH_RTB = "rtb";
    private static final String PATH_V3 = "v3";
    private static String auctionUrlFromInit;
    private static String auctionUrlFromSuccessRequest;
    private static final String DEF_BASE_URL = "https://api.bidmachine.io";
    private static final String[] DEF_BASE_URLS = {DEF_BASE_URL, "https://x.everestop.io", "https://x.blueduckredapple.com", "https://x.thecatmachine.com"};
    private static final Queue<String> INIT_URL_QUEUE = new ConcurrentLinkedQueue();
    private static final Queue<String> AUCTION_URL_QUEUE = new ConcurrentLinkedQueue();

    static {
        setupUrls();
    }

    static void setEndpoint(final String str) {
        if (!Utils.isUrlValid(str)) {
            Logger.e((LazyValue<String>) new LazyValue() { // from class: io.bidmachine.UrlProvider$$ExternalSyntheticLambda0
                @Override // io.bidmachine.utils.lazy.LazyValue
                public final Object get() {
                    return String.format("Endpoint has an invalid format - %s", str);
                }
            });
        } else {
            if (BidMachineImpl.get().isInitializationStarted()) {
                Logger.e("Can't change endpoint url after initialization");
                return;
            }
            Uri uri = Uri.parse(str);
            setInitUrl(createInitUrl(uri));
            setAuctionUrl(createAuctionUrl(uri));
        }
    }

    static Queue<String> getInitUrlQueue() {
        return new ConcurrentLinkedQueue(INIT_URL_QUEUE);
    }

    static void setInitUrl(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        Queue<String> queue = INIT_URL_QUEUE;
        queue.clear();
        queue.add(str);
    }

    static Queue<String> getAuctionUrlQueue() {
        if (!TextUtils.isEmpty(auctionUrlFromInit)) {
            return new ConcurrentLinkedQueue<String>() { // from class: io.bidmachine.UrlProvider.1
                {
                    add(UrlProvider.auctionUrlFromInit);
                }
            };
        }
        if (!TextUtils.isEmpty(auctionUrlFromSuccessRequest)) {
            return new ConcurrentLinkedQueue<String>() { // from class: io.bidmachine.UrlProvider.2
                {
                    add(UrlProvider.auctionUrlFromSuccessRequest);
                }
            };
        }
        return new ConcurrentLinkedQueue(AUCTION_URL_QUEUE);
    }

    static synchronized void setAuctionUrlFromInit(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        auctionUrlFromInit = str;
    }

    static void setAuctionUrlFromSuccessRequest(String str) {
        if (auctionUrlFromSuccessRequest != null || TextUtils.isEmpty(str)) {
            return;
        }
        auctionUrlFromSuccessRequest = str;
    }

    static void setAuctionUrl(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        Queue<String> queue = AUCTION_URL_QUEUE;
        queue.clear();
        queue.add(str);
    }

    static void setupUrls() {
        Queue<String> queue = INIT_URL_QUEUE;
        String[] strArr = DEF_BASE_URLS;
        setupInitUrls(queue, strArr);
        setupAuctionUrls(AUCTION_URL_QUEUE, strArr);
    }

    static void reset() {
        setupUrls();
        auctionUrlFromInit = null;
        auctionUrlFromSuccessRequest = null;
    }

    private static String createInitUrl(Uri uri) {
        return uri.buildUpon().appendPath("auction").appendPath("init").toString();
    }

    private static String createAuctionUrl(Uri uri) {
        return uri.buildUpon().appendPath("auction").appendPath(PATH_RTB).appendPath(PATH_V3).toString();
    }

    private static void setupInitUrls(Collection<String> collection, String[] strArr) {
        collection.clear();
        for (String str : strArr) {
            collection.add(createInitUrl(Uri.parse(str)));
        }
    }

    private static void setupAuctionUrls(Collection<String> collection, String[] strArr) {
        collection.clear();
        for (String str : strArr) {
            collection.add(createAuctionUrl(Uri.parse(str)));
        }
    }
}
