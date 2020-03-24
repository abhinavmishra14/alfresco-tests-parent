package org.alfresco.mock.test.activiti;

import java.io.Serializable;
import java.util.Date;

import org.alfresco.repo.workflow.activiti.ActivitiScriptNode;
import org.alfresco.service.ServiceRegistry;
import org.alfresco.service.cmr.repository.NodeRef;
import org.alfresco.service.namespace.QName;
import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;

public class MockActivitiScriptNode extends ActivitiScriptNode {

	public MockActivitiScriptNode(NodeRef nodeRef, ServiceRegistry services) {
		super(nodeRef, services);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public NodeValueConverter createValueConverter() {
		return new MockJBPMNodeConverter();
	}

	private class MockJBPMNodeConverter extends NodeValueConverter implements Serializable {
		
		@Override
		public Serializable convertValueForRepo(Serializable value) {
			if (value instanceof Date) {
				return value;
			} else {
				return super.convertValueForRepo(value);
			}
		}

		@Override
		public Serializable convertValueForScript(ServiceRegistry serviceRegistry, Scriptable theScope, QName qname,
				Serializable value) {
			// ALF-14863: If script-node is used outside of Script-call (eg. Activiti
			// evaluating an expression that contains variables of type ScriptNode)
			// a scope should be created solely for this conversion. The scope will ALWAYS
			// be set when value-conversion is called from the
			// ScriptProcessor
			ensureScopePresent();

			if (value instanceof NodeRef) {
				return new MockActivitiScriptNode(((NodeRef) value), serviceRegistry);
			} else if (value instanceof Date) {
				return value;
			} else {
				return super.convertValueForScript(serviceRegistry, theScope, qname, value);
			}
		}

		private void ensureScopePresent() {
			if (scope == null) {
				// Create a scope for the value conversion. This scope will be an empty scope
				// exposing basic Object and Function, sufficient for value-conversion.
				// In case no context is active for the current thread, we can safely enter end
				// exit one to get hold of a scope
				Context ctx = Context.getCurrentContext();
				boolean closeContext = false;
				if (ctx == null) {
					ctx = Context.enter();
					closeContext = true;
				}

				scope = ctx.initStandardObjects();
				scope.setParentScope(null);

				if (closeContext) {
					// Only an exit call should be done when context didn't exist before
					Context.exit();
				}
			}
		}
	}
}
