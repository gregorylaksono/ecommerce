package com.ecommerce.path;

import java.util.List;

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
import com.ecommerce.model.Category;
import com.ecommerce.model.Session;
import com.ecommerce.model.Tenant;
import com.ecommerce.model.Transaction;
import com.ecommerce.model.User;

@Component
@Path("/services")
public class Ecommerce {

	@Context
	ServletContext servletContext;
	
	private String generateSessionId(String prefix){
		String value = "";
		double dValue = Math.random();
		String capture = String.valueOf(dValue);
		int startIndex = capture.indexOf(".") + 1;
		String processed = capture.substring(startIndex, capture.length());
		value = prefix+processed;
		
		return value;
	}
	
	@GET
	@Path("/testme")
	@Produces("application/json")
	public Response testMe(){
		List<Transaction> trxs= SpringUtil.getTransactionService(servletContext).getTransactionByDate(null);
		return Response.status(Status.OK).entity(trxs).build();
	}
	
	@POST
	@Path("/test")
	@Produces("application/json")
	public Response test(@FormParam(value = "sessionId") String sessionId){
		Category cat = new Category();
		cat.setId(new Long(5));
		cat.setName("Test");
		return Response.status(Status.OK).entity(cat).build();
	}
	
	@POST
	@Path("/getUser")
	@Produces("application/json")
	public Response getUser(@FormParam(value = "sessionId") String sessionId,
							@FormParam(value = "userid") String userid){
		Object obj = servletContext.getAttribute(sessionId);
		if(obj == null){
			return Response.status(Status.FORBIDDEN).build();
		}
		Long id = Long.parseLong(userid);
		User user  = SpringUtil.getUserService(servletContext).getUserById(id);
		return Response.status(Status.OK).entity(user).build();
	}
	
	@POST
	@Path("/login")
	@Produces("application/json")
	public Response login(@FormParam(value = "username") String username, 
						  @FormParam(value = "password") String password){
		Session session  = SpringUtil.getUserService(servletContext).getUserByUsernameAndPassword(username, password);
		String sessionId = generateSessionId(session.getUser().getLastname());
		Object ob = null;
		while(ob == null){
			sessionId = generateSessionId(session.getUser().getLastname());
			ob = servletContext.getAttribute(sessionId);
		}
		servletContext.setAttribute(sessionId, session);
		return Response.status(Status.OK).entity(session).build();
	}
	
	@POST
	@Path("/forgetpassword")
	@Produces("application/json")
	public Response forgetpassword(@FormParam(value = "email") String email){
		boolean value = SpringUtil.getUserService(servletContext).forgetPassword(email);
		return Response.status(Status.OK).entity(value).build();
	}
	
	@POST
	@Path("/insertcategory")
	@Produces("application/json")
	public Response insertCategory(@FormParam(value = "sessionId") String sessionId,
								   @FormParam(value = "categoryName") String categoryName){
		Object obj = servletContext.getAttribute(sessionId);
		if(obj == null){
			return Response.status(Status.FORBIDDEN).build();
		}else{
			Session session = (Session) obj;
			Tenant tenant  = session.getUser().getTenant();
			Category cat = new Category();
			cat.setName(categoryName);;
			cat.setTenant(tenant);
			SpringUtil.getItemService(servletContext).insertCategory(cat);
			return Response.status(Status.OK).build();
		}
		
	}
	
	@POST
	@Path("/deleteCategory")
	@Produces("application/json")
	public Response deleteCategory(@FormParam(value = "sessionId") String sessionId,
								   @FormParam(value = "categoryName") String catId){
		Object obj = servletContext.getAttribute(sessionId);
		if(obj == null){
			return Response.status(Status.FORBIDDEN).build();
		}else{
			Long id = Long.parseLong(catId);
			Category category = SpringUtil.getItemService(servletContext).getCategoryById(id);
			SpringUtil.getItemService(servletContext).deleteCategory(category);
			
			return Response.status(Status.OK).build();
		}
		
	}
	
	@POST
	@Path("/updateCategory")
	@Produces("application/json")
	public Response updateCategory(@FormParam(value = "sessionId") String sessionId,
								   @FormParam(value = "categoryName") String catId,
								   @FormParam(value = "categoryName") String categoryName){
		Object obj = servletContext.getAttribute(sessionId);
		if(obj == null){
			return Response.status(Status.FORBIDDEN).build();
		}else{
			Long id = Long.parseLong(catId);
			Category category = SpringUtil.getItemService(servletContext).getCategoryById(id);
			category.setName(categoryName);
			SpringUtil.getItemService(servletContext).updateCategory(category);
			return Response.status(Status.OK).build();
		}
		
	}
	
}
