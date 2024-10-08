//package cn.com.common.config;
//
//import org.springframework.stereotype.Component;
//import org.springframework.web.cors.CorsConfiguration;
//import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
//import org.springframework.web.filter.CorsFilter;
//
//import java.util.Arrays;
//
///**
// *  跨域访问配置
// *
// *  @author Garyond
// */
//@Component
//public class CustomCorsFilter extends CorsFilter {
//
//    public CustomCorsFilter() {
//        super(configurationSource());
//    }
//
//    private static UrlBasedCorsConfigurationSource configurationSource() {
//        CorsConfiguration config = new CorsConfiguration();
//        config.setAllowCredentials(true);
//        config.addAllowedOrigin("*");
//        config.addAllowedHeader("*");
//        config.setMaxAge(36000L);
//        config.setAllowedMethods(Arrays.asList("GET", "HEAD", "POST", "PUT", "DELETE", "OPTIONS"));
//        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//        source.registerCorsConfiguration("/v1/**", config);
//        return source;
//    }
//}
