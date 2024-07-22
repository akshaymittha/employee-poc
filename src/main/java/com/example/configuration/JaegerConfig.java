package com.example.configuration;

import io.jaegertracing.internal.JaegerTracer;
import io.jaegertracing.internal.samplers.ConstSampler;
import io.micronaut.context.annotation.Bean;

public class JaegerConfig {
    @Bean
    public JaegerTracer jaegerTracer() {

        return new io.jaegertracing.Configuration("jaeger-client")
                .withSampler(new io.jaegertracing.Configuration.SamplerConfiguration().withType(ConstSampler.TYPE)
                        .withParam(1))
                .withReporter(new io.jaegertracing.Configuration.ReporterConfiguration().withLogSpans(true))
                .getTracer();
    }
}
