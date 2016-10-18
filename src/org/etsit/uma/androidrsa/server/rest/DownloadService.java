package org.etsit.uma.androidrsa.server.rest;

import java.io.File;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import org.etsit.uma.androidrsa.server.business.DownloadServiceBusinessLogic;

@Path("/download")
public class DownloadService {

	@Inject
	private DownloadServiceBusinessLogic bl;

	@GET
	@Produces(MediaType.APPLICATION_OCTET_STREAM)
	public Response download(@QueryParam("ownerName") String ownerName) {
		File apk = bl.download(ownerName == null ? "" : ownerName);

		ResponseBuilder response = Response.ok((Object) apk);
		response.header("Content-Disposition", "attachment;filename=androidRsa.apk");
		return response.build();
	}

}
