package com.csye6225.metrics;


import io.micrometer.prometheus.PrometheusCounter;
import io.prometheus.client.CollectorRegistry;
import io.prometheus.client.Counter;
import org.springframework.data.geo.Metrics;


public class Prometheus {

    static final Counter requests = Counter.build()
            .name("webapp").help("App statistics.").register(CollectorRegistry.defaultRegistry);

    public static void increment() {
        requests.inc();
    }




}
