package calculator;

import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

@Path("/calculator")
public class Service {
	
	@POST
	@Path("/addition")
	@Produces("text/html")
	public Response getResultadd(
			@FormParam("a") float a,
			@FormParam("b") float b) {
		float result=Calculator.addition(a,b);
		System.out.println(result);
		String output = "<font face='verdana' size='2'>" + " FirstInput - <u>"+a+"</u><br> SecondInput - <u>"+b+"</u><br>Addition Result - <u>"+result+"</u</font>";
		return Response.status(200).entity(output).build();
	}
	@POST
	@Path("/subtraction")
	@Produces("text/html")
	public Response getResultsub(
			@FormParam("a") float a,
			@FormParam("b") float b) {
		float result=Calculator.subtraction(a,b);
		System.out.println(result);
		String output = "<font face='verdana' size='2'>" + " FirstInput - <u>"+a+"</u><br>, SecondInput - <u>"+b+"</u><br>Subtraction Result - <u>"+result+"</u</font>";
		return Response.status(200).entity(output).build();
	}
		@POST
		@Path("/multiplication")
		@Produces("text/html")
		public Response getResultmul(
				@FormParam("a") float a,
				@FormParam("b") float b) {
			float result=Calculator.multiplication(a,b);
			System.out.println(result);
			String output = "<font face='verdana' size='2'>" + " FirstInput - <u>"+a+"</u><br>, SecondInput - <u>"+b+"</u><br>Multiplication Result - <u>"+result+"</u</font>";
			return Response.status(200).entity(output).build();
		}
		@POST
		@Path("/division")
		@Produces("text/html")
		public Response getResultdiv(
				@FormParam("a") float a,
				@FormParam("b") float b) {
			float result=Calculator.division(a,b);
			System.out.println(result);
			String output = "<font face='verdana' size='2'>" + " FirstInput - <u>"+a+"</u><br>, SecondInput - <u>"+b+"</u><br>Division Result - <u>"+result+"</u</font>";
			return Response.status(200).entity(output).build();
		}
	
	
}