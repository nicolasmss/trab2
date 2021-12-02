package com.bcopstein;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class ProxyConfig {
    
        /**
         * Enable this bean if you want to setup HTTP proxy for Default Feign Client
         /
        @Bean
        public Client feignClient() {
          return new Client.Proxied(null, null, 
              new Proxy(Proxy.Type.HTTP,
                  new InetSocketAddress(proxyHost, proxyPort)));
        }
    
        /**
         * Enable this bean if you want to setup HTTP proxy for ApacheHttpClient Feign Client
         /
        @Bean
        public CloseableHttpClient feignClient() {
          return HttpClientBuilder.create().setProxy(
              new HttpHost(proxyHost, proxyPort)).build();
        }
    
        /**
         * Enable this bean if you want to setup HTTP proxy for OkHttpClient Feign Client
        /
        @Bean
        public OkHttpClient okHttpClient() {
          return new OkHttpClient.Builder()
              .proxy(new Proxy(Proxy.Type.HTTP, 
                  new InetSocketAddress(proxyHost, proxyPort)))
              .build();
    }

    //*/
}
