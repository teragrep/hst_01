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
package com.teragrep.hst_01;

import java.net.UnknownHostException;
import java.util.Objects;

public final class FallbackHostname implements Hostname {

    private final Hostname origin;
    private final String fallbackHostname;

    public FallbackHostname(final Hostname origin, final String fallbackHostname) {
        this.origin = origin;
        this.fallbackHostname = fallbackHostname;
    }

    /**
     * Attempts to retrieve the hostname by calling asString() on the decorated Hostname object, falling back to a
     * default if the call results in an exception
     * 
     * @return the hostname of the local machine, or a configured default value
     */
    public String asString() {
        String rv;
        try {
            rv = origin.asString();
        }
        catch (final UnknownHostException e) {
            rv = fallbackHostname;
        }
        return rv;
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
            final FallbackHostname that = (FallbackHostname) o;
            equals = Objects.equals(origin, that.origin) && Objects.equals(fallbackHostname, that.fallbackHostname);
        }
        return equals;
    }

    @Override
    public int hashCode() {
        return Objects.hash(origin, fallbackHostname);
    }
}
