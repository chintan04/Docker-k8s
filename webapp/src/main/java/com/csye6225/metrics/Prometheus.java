package com.csye6225.metrics;

import io.prometheus.client.Counter;

public class Prometheus {

    static final Counter requests = Counter.build()
            .name("requests_total").help("Total requests.").register();

    public static void increment() {
        requests.inc();
    }

}
