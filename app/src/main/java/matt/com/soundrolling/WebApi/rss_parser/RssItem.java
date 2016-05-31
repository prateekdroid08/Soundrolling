package matt.com.soundrolling.WebApi.rss_parser;

/*
 * Copyright (C) 2014 Shirwa Mohamed <shirwa99@gmail.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

public class RssItem {
    String title;
    String link;
    String category;
    String dc_creator;
    String pubDate;
    String content_encoded;
    String media_content;


    public String getTitle() {
        return title;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDc_creator() {
        return dc_creator;
    }

    public void setDc_creator(String dc_creator) {
        this.dc_creator = dc_creator;
    }

    public String getPubDate() {
        return pubDate;
    }

    public void setPubDate(String pubDate) {
        this.pubDate = pubDate;
    }

    public String getContent_encoded() {
        return content_encoded;
    }

    public void setContent_encoded(String content_encoded) {
        this.content_encoded = content_encoded;
    }

    public String getMedia_content() {
        return media_content;
    }

    public void setMedia_content(String media_content) {
        this.media_content = media_content;
    }
}
