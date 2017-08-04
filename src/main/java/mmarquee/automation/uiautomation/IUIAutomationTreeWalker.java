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
package mmarquee.automation.uiautomation;

import com.sun.jna.Function;
import com.sun.jna.Pointer;
import com.sun.jna.platform.win32.COM.IUnknown;
import com.sun.jna.platform.win32.Guid;
import com.sun.jna.platform.win32.WinNT;
import com.sun.jna.ptr.PointerByReference;

/**
 * Created by Mark Humphreys on 02/02/2017.
 */
public interface IUIAutomationTreeWalker extends IUnknown {
    /**
     * The interface IID for QueryInterface et al
     */
    Guid.IID IID = new Guid.IID(
            "{4042C624-389C-4AFC-A630-9DF854A541FC}");

    int AddRef();
    int Release();
    WinNT.HRESULT QueryInterface(Guid.REFIID byValue, PointerByReference pointerByReference);

    int getParentElement(Pointer element, PointerByReference parent);
    int getFirstChildElement(Pointer element, PointerByReference first);
    int getLastChildElement(Pointer element, PointerByReference last);
    int getNextSiblingElement(Pointer element, PointerByReference next);
    int getPreviousSiblingElement(Pointer element, PointerByReference previous);
/* 8-14 cache equivalents */
    int getCondition(PointerByReference condition);

    class Converter {
        private static int METHODS = 16; // 0-2 IUnknown, 3-15 IUIAutomationTreeWalker

        public static IUIAutomationTreeWalker PointerToInterface(final PointerByReference ptr) {
            final Pointer interfacePointer = ptr.getValue();
            final Pointer vTablePointer = interfacePointer.getPointer(0);
            final Pointer[] vTable = new Pointer[METHODS];
            vTablePointer.read(0, vTable, 0, vTable.length);
            return new IUIAutomationTreeWalker() {
                // IUnknown

                @Override
                public WinNT.HRESULT QueryInterface(Guid.REFIID byValue, PointerByReference pointerByReference) {
                    Function f = Function.getFunction(vTable[0], Function.ALT_CONVENTION);
                    return new WinNT.HRESULT(f.invokeInt(new Object[]{interfacePointer, byValue, pointerByReference}));
                }

                @Override
                public int AddRef() {
                    Function f = Function.getFunction(vTable[1], Function.ALT_CONVENTION);
                    return f.invokeInt(new Object[]{interfacePointer});
                }

                public int Release() {
                    Function f = Function.getFunction(vTable[2], Function.ALT_CONVENTION);
                    return f.invokeInt(new Object[]{interfacePointer});
                }

                public int getParentElement(Pointer element, PointerByReference parent) {
                    Function f = Function.getFunction(vTable[3], Function.ALT_CONVENTION);
                    return f.invokeInt(new Object[]{interfacePointer, element, parent});
                }

                public int getFirstChildElement(Pointer element, PointerByReference first) {
                    Function f = Function.getFunction(vTable[4], Function.ALT_CONVENTION);
                    return f.invokeInt(new Object[]{interfacePointer, element, first});
                }

                public int getLastChildElement(Pointer element, PointerByReference last) {
                    Function f = Function.getFunction(vTable[5], Function.ALT_CONVENTION);
                    return f.invokeInt(new Object[]{interfacePointer, element, last});
                }

                public int getNextSiblingElement(Pointer element, PointerByReference next) {
                    Function f = Function.getFunction(vTable[6], Function.ALT_CONVENTION);
                    return f.invokeInt(new Object[]{interfacePointer, element, next});
                }

                public int getPreviousSiblingElement(Pointer element, PointerByReference previous) {
                    Function f = Function.getFunction(vTable[7], Function.ALT_CONVENTION);
                    return f.invokeInt(new Object[]{interfacePointer, element, previous});
                }

                public int getCondition(PointerByReference condition) {
                    Function f = Function.getFunction(vTable[15], Function.ALT_CONVENTION);
                    return f.invokeInt(new Object[]{interfacePointer, condition});
                }

            };
        }
    }
}
