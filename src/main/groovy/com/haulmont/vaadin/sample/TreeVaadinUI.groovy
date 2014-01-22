/*
 * Copyright 2013 Haulmont Ltd.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */

package com.haulmont.vaadin.sample

import com.vaadin.event.Action
import com.vaadin.server.VaadinRequest
import com.vaadin.ui.*

public class TreeVaadinUI extends UI {

    @Override
    protected void init(VaadinRequest request) {
        def layout = new VerticalLayout()
        def tree = new SuperTree(width: "200px", height: "200px", immediate: true)
        tree.addItem("Root")

        tree.addActionHandler(new Action.Handler() {

            def openAction = new Action("Open")

            @Override
            Action[] getActions(Object target, Object sender) {
                def actions = new Action[1]
                actions[0] = openAction
                return actions
            }

            @Override
            void handleAction(Action action, Object sender, Object target) {
                new Notification(String.valueOf(tree.getValue())).show(getPage())
            }
        })
        layout.addComponent(tree)

        setContent(layout)
    }
}