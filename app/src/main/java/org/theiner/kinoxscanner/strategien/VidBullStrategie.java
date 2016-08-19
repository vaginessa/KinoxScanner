package org.theiner.kinoxscanner.strategien;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.theiner.kinoxscanner.util.HTTPHelper;

/**
 * Created by TTheiner on 16.03.2016.
 */
public class VidBullStrategie extends HosterStrategie {

    public VidBullStrategie() {
        this.hosterName = "VidBull";
        this.hosterNummer = 50;
        this.delayInSec = 0;
    }

    @Override
    public String getVideoURL(String hosterURL) throws InterruptedException{
        String response = "";
        // get MP4 file link directly (with mobile browser setup)
        Document vidBullDocument = HTTPHelper.getDocumentFromUrl(hosterURL, "", true);

        Elements sources = vidBullDocument.getElementsByTag("source");
        if(sources.size()>0) {
            Element source = sources.get(0);

            response = source.attr("abs:src");

        }

        return response;
    }
}
