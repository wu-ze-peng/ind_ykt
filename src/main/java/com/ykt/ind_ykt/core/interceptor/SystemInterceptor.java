package com.ykt.ind_ykt.core.interceptor;

import com.alibaba.fastjson.JSON;
import com.ykt.ind_ykt.core.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.util.HtmlUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Autor guoyh
 * @Date 2018/5/9 0009
 * @Usage   系统拦截器
 * @ChangeLog 201800509 添加了自动分页排序功能
 */
@Component
public class SystemInterceptor implements HandlerInterceptor {
        public static final String AND = "&";
        public static final String EQUAL = "=";
        private List<String> stopword;

        private Logger logger = LoggerFactory.getLogger(this.getClass());

        public SystemInterceptor(List<String> stopword) {
                this.stopword = stopword;
        }

        @Override
        public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
                if (RequestMethod
                        .POST.name().equals(request.getMethod()) || RequestMethod.GET.name().equals(request.getMethod())) {
                        Map<String, String[]> parameterMap = request.getParameterMap();
                        if (parameterMap.size() > 0) {
                                Map params = new HashMap();
                                for (Map.Entry<String, String[]> entry : parameterMap.entrySet()) {
                                        String valueStr = (entry.getValue() == null) ? null : entry.getValue()[0];
                                        if (StringUtils.isEmpty(valueStr)) {
                                                if (stopword.stream().anyMatch(item -> valueStr.indexOf(item) >= 0)) {
                                                        logger.info("请求参数包含特殊字符:" + JSON.toJSONString(parameterMap));
                                                        return false;
                                                }
                                        }
                                        params.put(HtmlUtils.htmlEscape(entry.getKey()), HtmlUtils.htmlEscape(valueStr));
                                }
                                logger.info(request.getRequestURI() + " : " + JSON.toJSONString(params));
                                request.setAttribute(Constants.QUERY_PARAMS, params);
                        }
                }else{
                        return false;
                }
                return true;
        }
}
