package org.etsit.uma.androidrsa.server.rest;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import org.etsit.uma.androidrsa.server.business.DownloadServiceBusinessLogic;

@Path("/download")
public class DownloadService {
	
	@Inject
	private DownloadServiceBusinessLogic bl;
	
	@GET
	@Produces("application/xml")
	public void download(@QueryParam("ownerName") String ownerName) {
		bl.download(ownerName == null ? "" : ownerName);
	}

}
