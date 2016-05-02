package com.ecommerce.path;

import javax.servlet.ServletContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.ecommerce.config.SpringUtil;
import com.ecommerce.model.Session;
import com.ecommerce.model.User;

@Component
@Path("/services")
public class Ecommerce {
	

	@Context
	ServletContext servletContext;
	
//	public void initBO(){
//		if(bo == null){
//			WebApplicationContext ctx = WebApplicationContextUtils.getRequiredWebApplicationContext(servletContext);
//			bo = (HombreBo) ctx.getBean("stockBo");
//		}
//	}
	
	@POST
	@Path("/getUser")
	@Produces("application/json")
	public Response getUser(@FormParam(value = "userid") String userid,
							@FormParam(value = "tenant") String tenantId){
		Long id = Long.parseLong(userid);
		Long tenant = Long.parseLong(tenantId);
		User user  = SpringUtil.getUserService(servletContext).getUserById(tenant, id);
		return Response.status(Status.OK).entity(user).build();
	}
	
	@POST
	@Path("/login")
	@Produces("application/json")
	public Response login(@FormParam(value = "username") String username, 
						  @FormParam(value = "password") String password){
		Session session  = SpringUtil.getUserService(servletContext).getUserByUsernameAndPassword(username, username);
		servletContext.setAttribute(session.getSessionId(), session.getUser());
		return Response.status(Status.OK).entity(session).build();
	}
	
	
}
