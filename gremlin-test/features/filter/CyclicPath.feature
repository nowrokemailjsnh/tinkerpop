# Licensed to the Apache Software Foundation (ASF) under one
# or more contributor license agreements.  See the NOTICE file
# distributed with this work for additional information
# regarding copyright ownership.  The ASF licenses this file
# to you under the Apache License, Version 2.0 (the
# "License"); you may not use this file except in compliance
# with the License.  You may obtain a copy of the License at
#
# http://www.apache.org/licenses/LICENSE-2.0
#
# Unless required by applicable law or agreed to in writing,
# software distributed under the License is distributed on an
# "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
# KIND, either express or implied.  See the License for the
# specific language governing permissions and limitations
# under the License.

Feature: Step - cyclicPath()

  Scenario: g_VX1X_outXcreatedX_inXcreatedX_cyclicPath
    Given the modern graph
    And using the parameter vid1 defined as "v[marko].id"
    And the traversal of
      """
      g.V(vid1).out("created").in("created").cyclicPath()
      """
    When iterated to list
    Then the result should be unordered
      | result |
      | v[marko] |

  Scenario: g_VX1X_outXcreatedX_inXcreatedX_cyclicPath_path
    Given the modern graph
    And using the parameter vid1 defined as "v[marko].id"
    And the traversal of
      """
      g.V(vid1).out("created").in("created").cyclicPath().path()
      """
    When iterated to list
    Then the result should be unordered
      | result |
      | p[v[marko],v[lop],v[marko]] |

  Scenario: g_VX1X_asXaX_outXcreatedX_asXbX_inXcreatedX_asXcX_cyclicPath_fromXaX_toXbX_path
    Given the modern graph
    And using the parameter vid1 defined as "v[marko].id"
    And the traversal of
      """
      g.V(vid1).as("a").out("created").as("b").in("created").as("c").cyclicPath().from("a").to("b").path()
      """
    When iterated to list
    Then the result should be empty
