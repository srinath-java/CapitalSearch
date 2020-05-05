package com.srinath;

import static org.junit.Assert.assertEquals;

import org.junit.Assert;
import org.junit.Test;

import services.CapitalService;

public class CapitalServiceTest {


	@Test
	public void getCapitalByNullName(){
		CapitalService service=new CapitalService();

		try {
			service.getCapitalByName(null);
			Assert.fail("No exception was thrown");
		} catch (Exception e) {
			assertEquals("Name can't be null or empty.", e.getMessage());

		}

	}

	@Test
	public void getCapitalByEmptyName(){
		CapitalService service=new CapitalService();

		try {
			service.getCapitalByName("");
			Assert.fail("No exception was thrown");
		} catch (Exception e) {
			assertEquals("Name can't be null or empty.", e.getMessage());
		}

	}

	@Test
	public void getCapitalByValidName(){
		CapitalService service=new CapitalService();

		try {
			assertEquals("Panama City", service.getCapitalByName("Panama"));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Test
	public void getCapitalByInvalidName(){
		CapitalService service=new CapitalService();

		try {

			assertEquals("Not found", service.getCapitalByName("Panama12322"));
			Assert.fail("No exception was thrown");
		} catch (Exception e) {
			assertEquals("Not found", e.getMessage());
		}

	}

	@Test
	public void getCapitalByNullCode(){
		CapitalService service=new CapitalService();
		try {
			service.getCapitalByCode(null);
			Assert.fail("No exception was thrown");
		} catch (Exception e) {
			assertEquals("Code can't be null or empty.", e.getMessage());
		}

	}


	@Test
	public void getCapitalByEmptyCode(){
		CapitalService service=new CapitalService();
		try {
			service.getCapitalByCode("");
			Assert.fail("No exception was thrown");
		} catch (Exception e) {
			assertEquals("Code can't be null or empty.", e.getMessage());
		}

	}


	@Test
	public void getCapitalByValidCode(){
		CapitalService service=new CapitalService();
		try {
			assertEquals("Panama City", service.getCapitalByCode("PA"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Test
	public void getCapitalByInvalidCode(){
		CapitalService service=new CapitalService();
		try {

			service.getCapitalByCode("PA123");
			Assert.fail("No exception was thrown");
		} catch (Exception e) {
			assertEquals("Not found", e.getMessage());
		}

	}

}
