package com.jp.systemdirector.projectzero.util;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class SetCharacterEncodingFilter implements Filter {
    /**
     * リクエストに設定するデフォルト文字エンコーディング
     */
    protected String encoding = null;

    /**
     * フィルタのサービスを停止する
     */
    public void destroy() {
        this.encoding = null;
    }

    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain) throws IOException, ServletException {
        if (request.getCharacterEncoding() == null) {
            if (encoding != null) {
                request.setCharacterEncoding(encoding);
            }
        }
        chain.doFilter(request, response);
    }

    /**
     * フィルタサービスを開始する 77
     * 
     * @param filterConfig
     *            フィルタ設定オブジェクト
     */
    public void init(FilterConfig filterConfig) throws ServletException {
        this.encoding = filterConfig.getInitParameter("encoding");
    }
}