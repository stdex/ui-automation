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

import mmarquee.automation.Element;
import mmarquee.automation.UIAutomation;
import mmarquee.automation.pattern.Value;
import mmarquee.uiautomation.IUIAutomation;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class AutomationPasswordEditBoxTest {
    @Test
    public void testGetValue_Gets_Value_From_Value_Pattern() throws Exception {
        Element element = Mockito.mock(Element.class);
        Value value = Mockito.mock(Value.class);
        
        when(element.getClassName()).thenReturn(PasswordEditBox.CLASS_NAME);

        when(value.isAvailable()).thenReturn(true);
        when(value.value()).thenReturn("VALUE");

        IUIAutomation mocked_automation = Mockito.mock(IUIAutomation.class);
        UIAutomation instance = new UIAutomation(mocked_automation);

        PasswordEditBox control = new PasswordEditBox(
                new ElementBuilder(element).addPattern(value).automation(instance));

        String val = control.getValue();

        assertTrue(val.equals("VALUE"));
    }

    @Test
    public void testSetValue() throws Exception {
        Element element = Mockito.mock(Element.class);
        Value value = Mockito.mock(Value.class);

        when(value.isAvailable()).thenReturn(true);
        
        when(element.getClassName()).thenReturn(PasswordEditBox.CLASS_NAME);

        IUIAutomation mocked_automation = Mockito.mock(IUIAutomation.class);
        UIAutomation instance = new UIAutomation(mocked_automation);

        PasswordEditBox control = new PasswordEditBox(
                new ElementBuilder(element).addPattern(value).automation(instance));

        control.setValue("VALUE");

        verify(value, atLeast(1)).setValue("VALUE");
    }
}
