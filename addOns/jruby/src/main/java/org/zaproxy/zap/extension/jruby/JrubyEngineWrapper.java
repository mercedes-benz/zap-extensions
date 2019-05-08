/*
 * Zed Attack Proxy (ZAP) and its related class files.
 *
 * ZAP is an HTTP/HTTPS proxy for assessing web application security.
 *
 * Copyright 2013 The ZAP Development Team
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
package org.zaproxy.zap.extension.jruby;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import javax.script.ScriptEngine;
import javax.swing.ImageIcon;

import org.fife.ui.rsyntaxtextarea.SyntaxConstants;
import org.zaproxy.zap.extension.script.DefaultEngineWrapper;
import org.zaproxy.zap.extension.script.ScriptWrapper;

public class JrubyEngineWrapper extends DefaultEngineWrapper {

	private final List<Path> defaultTemplates;

	public JrubyEngineWrapper(ScriptEngine engine, List<Path> defaultTemplates) {
		super(engine);

		if (defaultTemplates == null) {
			throw new IllegalArgumentException("Parameter defaultTemplates must not be null.");
		}

		this.defaultTemplates = defaultTemplates;
	}

	@Override
	public ImageIcon getIcon() {
		return ExtensionJruby.RUBY_ICON;
	}

	@Override
	public String getSyntaxStyle() {
		return SyntaxConstants.SYNTAX_STYLE_RUBY;
	}
	
	@Override
	public List<String> getExtensions() {
		List<String> list = new ArrayList<String>();
		list.add("rb");
		return list;
	}
	
	@Override
	public boolean isRawEngine() {
		return false;
	}

	@Override
	public boolean isDefaultTemplate(ScriptWrapper script) {
		if (script.getFile() == null) {
			return false;
		}

		return defaultTemplates.contains(script.getFile().toPath());
	}
}
