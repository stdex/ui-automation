/*
 * Copyright 2016-17 inpwtepydjuf@gmail.com
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package mmarquee.automation.controls;

import mmarquee.automation.AutomationException;
import mmarquee.automation.pattern.PatternNotFoundException;

/**
 * @author Mark Humphreys
 * Date 21/09/2016.
 */
public interface Selectable extends Automatable {
    /**
     * Selects the element.
     * @throws AutomationException Automation library error
     * @throws PatternNotFoundException Failed to find pattern
     */
    void select() throws AutomationException, PatternNotFoundException;

    /**
     * Whether the element is selected.
     * @return True if selected
     * @throws AutomationException Automation library error
     * @throws PatternNotFoundException Failed to find pattern
     */
    boolean isSelected() throws AutomationException, PatternNotFoundException;
}
