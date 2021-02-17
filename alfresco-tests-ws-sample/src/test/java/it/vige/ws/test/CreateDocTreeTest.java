package it.vige.ws.test;

import static org.apache.log4j.Logger.getLogger;

import java.io.IOException;
import java.io.Serializable;
import java.text.ParseException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.alfresco.mock.test.ws.AbstractWSForm;
import org.alfresco.mock.test.ws.MockWebScriptRequest;
import org.alfresco.mock.test.ws.MockWebScriptResponse;
import org.alfresco.service.cmr.repository.NodeRef;
import org.alfresco.service.cmr.repository.StoreRef;
import org.alfresco.service.cmr.search.SearchService;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.extensions.webscripts.AbstractWebScript;
import org.springframework.extensions.webscripts.WebScriptRequest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.tradeshift.test.remote.Remote;
import com.tradeshift.test.remote.RemoteTestRunner;

import it.vige.ws.api.CreateDocTree;

@RunWith(RemoteTestRunner.class)
@Remote(runnerClass = SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:test-module-context.xml")
public class CreateDocTreeTest extends AbstractWSForm {

	private final static Logger logger = getLogger(CreateDocTreeTest.class);
	private final static String ID_PARTNER = "prova";
	private final static String ID_PRATICA = "prova";
	private final static String FOLDER_WSSAMPLE = "/sites/vige-site/documentLibrary/Questions/" + ID_PARTNER + "/1970/01/"
			+ ID_PRATICA + "/Autogenerated";
	private Map<String, String> templateVars;

	@Autowired
	private CreateDocTree createDocTree;

	@Override
	protected AbstractWebScript getAbstractWebScript() {
		return createDocTree;
	}

	@Before
	public void init() {
		super.init();
		templateVars = new HashMap<String, String>();
		templateVars.put("idpartner", ID_PARTNER);
		templateVars.put("idpratica", ID_PRATICA);

		// Creating initial folders and sites
		NodeRef bdm = insertFolder(sites, "vige-site");
		NodeRef bdmDL = insertFolder(bdm, "documentLibrary");
		insertFolder(bdmDL, "Questions");
	}

	@Test
	public void execute() throws ParseException, IOException {

		logger.debug("start test");
		SearchService searchService = serviceRegistry.getSearchService();
		Map<String, Serializable> fields = new HashMap<String, Serializable>();
		{
			fields.put("dataCreazionePratica", "1970-01-01");
			fields.put("convenzione", "1970-01-01");
			fields.put("numeroPratica", "3456");
		}
		WebScriptRequest webScriptRequest = new MockWebScriptRequest("json", templateVars, createDocTree, fields,
				serviceRegistry);
		createDocTree.execute(webScriptRequest, new MockWebScriptResponse());

		// Verify
		List<NodeRef> nodeRefs = searchService
				.query(StoreRef.STORE_REF_WORKSPACE_SPACESSTORE, SearchService.LANGUAGE_XPATH, FOLDER_WSSAMPLE)
				.getNodeRefs();
		NodeRef result = nodeRefs.get(0);
		Assert.assertNotNull("Folder created", result);
		logger.debug("end test");
	}
}