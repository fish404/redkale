/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.redkale.net.http;

import static java.lang.annotation.ElementType.*;
import java.lang.annotation.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * 配合 HttpServlet 使用。
 * 用于指定HttpRequest.currentUser的数据类型。<br>
 * 注意： 数据类型是JavaBean
 *
 * <p>
 * 详情见: https://redkale.org
 *
 * @author zhangjx
 */
@Deprecated
@Inherited
@Documented
@Target({TYPE})
@Retention(RUNTIME)
public @interface HttpUserType {

    Class value();

}
