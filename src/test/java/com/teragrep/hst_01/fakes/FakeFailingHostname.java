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
package com.teragrep.hst_01.fakes;

import com.teragrep.hst_01.Hostname;

import java.net.UnknownHostException;

/**
 * Fake Hostname that simulates a failure to fetch hostname
 */

public class FakeFailingHostname implements Hostname {

    public FakeFailingHostname() {

    }

    public String asString() throws UnknownHostException {
        throw new UnknownHostException("Failed to retrieve hostname!");
    }
}
