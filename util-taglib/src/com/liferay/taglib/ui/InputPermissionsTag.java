/**
 * Copyright (c) 2000-2008 Liferay, Inc. All rights reserved.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package com.liferay.taglib.ui;

import com.liferay.portal.security.permission.ResourceActionsUtil;
import com.liferay.taglib.util.IncludeTag;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

/**
 * <a href="InputPermissionsTag.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 * @author Wilson S. Man
 *
 */
public class InputPermissionsTag extends IncludeTag {

	public int doStartTag() {
		HttpServletRequest request =
			(HttpServletRequest)pageContext.getRequest();

		request.setAttribute(
			"liferay-ui:input-permissions:formName", _formName);

		if (_modelName != null) {
			List<String> supportedActions =
				ResourceActionsUtil.getModelResourceActions(_modelName);
			List<String> communityDefaultActions =
				ResourceActionsUtil.getModelResourceCommunityDefaultActions(
					_modelName);
			List<String> guestDefaultActions =
				ResourceActionsUtil.getModelResourceGuestDefaultActions(
					_modelName);
			List<String> guestUnsupportedActions =
				ResourceActionsUtil.getModelResourceGuestUnsupportedActions(
					_modelName);

			request.setAttribute(
				"liferay-ui:input-permissions:modelName", _modelName);
			request.setAttribute(
				"liferay-ui:input-permissions:supportedActions",
				supportedActions);
			request.setAttribute(
				"liferay-ui:input-permissions:communityDefaultActions",
				communityDefaultActions);
			request.setAttribute(
				"liferay-ui:input-permissions:guestDefaultActions",
				guestDefaultActions);
			request.setAttribute(
				"liferay-ui:input-permissions:guestUnsupportedActions",
				guestUnsupportedActions);
		}

		return EVAL_BODY_BUFFERED;
	}

	public void setFormName(String formName) {
		_formName = formName;
	}

	public void setModelName(String modelName) {
		_modelName = modelName;
	}

	protected String getDefaultPage() {
		return _PAGE;
	}

	private static final String _PAGE =
		"/html/taglib/ui/input_permissions/page.jsp";

	private String _formName = "fm";
	private String _modelName = null;

}