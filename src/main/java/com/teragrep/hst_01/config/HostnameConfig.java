/*
 * Fallback hostname library for Java
 * Copyright (C) 2026 Suomen Kanuuna Oy
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.teragrep.hst_01.config;

import com.teragrep.hst_01.FallbackHostname;
import com.teragrep.hst_01.HostnameImpl;

import java.util.Objects;

/**
 * Configurable object that creates a FallbackHostname implementation with the configured value as a fallback.
 */

public final class HostnameConfig {

    private final FallbackHostname hostname;

    public HostnameConfig(final String fallbackHostname) {
        this.hostname = new FallbackHostname(new HostnameImpl(), fallbackHostname);
    }

    public FallbackHostname hostname() {
        return hostname;
    }

    @Override
    public boolean equals(final Object o) {
        final boolean equals;
        if (this == o) {
            equals = true;
        }
        else if (o == null || getClass() != o.getClass()) {
            equals = false;
        }
        else {
            final HostnameConfig config = (HostnameConfig) o;
            equals = Objects.equals(hostname, config.hostname);
        }
        return equals;
    }

    @Override
    public int hashCode() {
        return Objects.hash(hostname);
    }
}
