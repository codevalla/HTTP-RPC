/*
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.httprpc.test

import org.httprpc.Description
import org.httprpc.RequestMethod
import org.httprpc.WebService
import javax.servlet.annotation.WebServlet

@WebServlet(urlPatterns = ["/system-info/*"], loadOnStartup = 1)
@Description("System info service.")
class SystemInfoService : WebService() {
    class SystemInfo(
        val availableProcessors: Int,
        val freeMemory: Long,
        val totalMemory: Long
    )

    @RequestMethod("GET")
    @Description("Returns system info.")
    fun getSystemInfo(): SystemInfo {
        val runtime = Runtime.getRuntime()

        return SystemInfo(
            runtime.availableProcessors(),
            runtime.freeMemory(),
            runtime.totalMemory()
        )
    }
}
