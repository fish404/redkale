/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.redkale.mq;

import org.redkale.convert.Convert;
import org.redkale.net.http.*;

/**
 *
 * <p>
 * 详情见: https://redkale.org
 *
 * @author zhangjx
 *
 * @since 2.1.0
 */
public class HttpMessageRequest extends HttpRequest {

    protected MessageRecord message;

    public HttpMessageRequest(HttpContext context, MessageRecord message) {
        super(context, message.decodeContent(HttpSimpleRequestCoder.getInstance()));
        this.message = message;
        this.currentUserid = message.getUserid();
    }

    public void setRequestURI(String uri) {
        this.requestURI = uri;
    }

    @Override
    public Convert getRespConvert() {
        return this.respConvert;
    }
}
