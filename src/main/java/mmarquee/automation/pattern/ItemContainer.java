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
package mmarquee.automation.pattern;

import mmarquee.automation.Element;
import mmarquee.automation.AutomationException;
import mmarquee.automation.PatternID;
import mmarquee.automation.PropertyID;

/**
 * Wrapper for the item container.
 *
 * @author Mark Humphreys
 * Date 25/02/2016.
 *
 */
public class ItemContainer extends BasePattern {

    /**
     * Constructor for the ItemContainer pattern.
     *
     * @param element The automation element for which the pattern is valid
     * @throws AutomationException If something goes wrong
     */
    public ItemContainer(final Element element) throws AutomationException {
    	super(element);
        this.patternID = PatternID.ItemContainer;
        this.availabilityPropertyID = PropertyID.IsItemContainerPatternAvailable;
    }
}
