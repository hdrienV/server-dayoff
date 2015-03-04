package org.dayoff.server.rest.resource.podcast;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

import org.dayoff.server.rest.errorhandling.CustomReasonPhraseException;
import org.dayoff.server.rest.service.PodcastService;
import org.springframework.beans.factory.annotation.Autowired;

@Path("/mocked-custom-reason-phrase-exception")
public class CustomReasonPhraseExceptionMockResource {
	
	@Autowired
	private PodcastService podcastService;
	
	@GET
	public void testReasonChangedInResponse() throws CustomReasonPhraseException{
		podcastService.generateCustomReasonPhraseException();
	}
}
