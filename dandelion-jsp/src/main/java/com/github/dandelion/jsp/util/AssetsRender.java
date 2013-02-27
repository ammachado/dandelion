/*
 * [The "BSD licence"]
 * Copyright (c) 2013 Dandelion
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 * 1. Redistributions of source code must retain the above copyright
 * notice, this list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright
 * notice, this list of conditions and the following disclaimer in the
 * documentation and/or other materials provided with the distribution.
 * 3. Neither the name of DataTables4j nor the names of its contributors
 * may be used to endorse or promote products derived from this software
 * without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE AUTHOR ``AS IS'' AND ANY EXPRESS OR
 * IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES
 * OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED.
 * IN NO EVENT SHALL THE AUTHOR BE LIABLE FOR ANY DIRECT, INDIRECT,
 * INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT
 * NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
 * DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY
 * THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF
 * THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package com.github.dandelion.jsp.util;

import com.github.dandelion.core.asset.Asset;
import com.github.dandelion.core.asset.Assets;
import com.github.dandelion.core.html.LinkTag;
import com.github.dandelion.core.html.ScriptTag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import java.io.IOException;
import java.util.List;

/**
 * A HTML Render For 'Dandelion' Assets into a JSP context
 */
public class AssetsRender {
    /**
     * @param assets assets to render
     * @param out html output
     * @throws JspException If an error occured while writing
     */
    public static void render(List<Asset> assets, JspWriter out) throws JspException {
        try {
            for (Asset asset : assets) {
                switch (asset.getType()) {
                    case css:
                        out.println(new LinkTag(Assets.getAssetLocation(asset)).toHtml());
                        break;
                    case js:
                        out.println(new ScriptTag(Assets.getAssetLocation(asset)).toHtml());
                        break;
                    default:
                        break;
                }
            }
        } catch (IOException e) {
            throw new JspException(e);
        }
    }
}