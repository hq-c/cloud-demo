package cn.itcast.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.apache.commons.lang3.StringUtils;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Component
public class LoginFilter extends ZuulFilter{
//    过滤器类型
    @Override
    public String filterType() {
        return FilterConstants.PRE_TYPE;
    }
//过滤器执行顺序（数值越小，优先级越高）
    @Override
    public int filterOrder() {
        //获取请求参数前过滤
        return FilterConstants.PRE_DECORATION_FILTER_ORDER - 1;
    }
//是否过滤
    @Override
    public boolean shouldFilter() {
        return true;
    }
//过滤器逻辑
    @Override
    public Object run() throws ZuulException {
//        获取请求上下文
        RequestContext ctx = RequestContext.getCurrentContext();
//        获取request
        HttpServletRequest request = ctx.getRequest();
//        获取请求参数access-token
        String token = request.getParameter("access-token");
//        判断是否存在
/*        if (token == null || token.trim().isEmpty()){
            return null;
        }*/

        if (StringUtils.isBlank(token)){
            //        不存在，未登录，则拦截
            ctx.setSendZuulResponse(false);
//            返回403
            ctx.setResponseStatusCode(HttpStatus.FORBIDDEN.value());
        }
        return null;
    }
}
