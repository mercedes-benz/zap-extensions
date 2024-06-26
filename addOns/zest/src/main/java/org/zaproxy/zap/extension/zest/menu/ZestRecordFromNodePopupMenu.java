/*
 * Zed Attack Proxy (ZAP) and its related class files.
 *
 * ZAP is an HTTP/HTTPS proxy for assessing web application security.
 *
 * Copyright 2014 The ZAP Development Team
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
package org.zaproxy.zap.extension.zest.menu;

import org.parosproxy.paros.Constant;
import org.parosproxy.paros.model.SiteNode;
import org.zaproxy.addon.commonlib.MenuWeights;
import org.zaproxy.zap.extension.zest.ExtensionZest;
import org.zaproxy.zap.view.popup.PopupMenuItemSiteNodeContainer;

@SuppressWarnings("serial")
public class ZestRecordFromNodePopupMenu extends PopupMenuItemSiteNodeContainer {

    private static final long serialVersionUID = 2282358266003940700L;

    private ExtensionZest extension;

    /** This method initializes */
    public ZestRecordFromNodePopupMenu(ExtensionZest extension) {
        super(Constant.messages.getString("zest.record.node.popup"), true);
        this.extension = extension;
    }

    @Override
    public boolean isSafe() {
        return true;
    }

    @Override
    protected void performAction(SiteNode node) {
        extension.getDialogManager().showZestRecordScriptDialog(node);
    }

    @Override
    public int getWeight() {
        return MenuWeights.MENU_SCRIPT_ZEST_RECORD_WEIGHT;
    }
}
