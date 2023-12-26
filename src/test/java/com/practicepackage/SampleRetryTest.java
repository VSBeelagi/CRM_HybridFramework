package com.practicepackage;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.crm.GenericUtils.Baseclass;

public class SampleRetryTest extends Baseclass{

	@Test(retryAnalyzer = com.crm.GenericUtils.RetryImpl.class)
	public void retrytest()
	{
		Assert.assertEquals("A", "B");
	}
}
