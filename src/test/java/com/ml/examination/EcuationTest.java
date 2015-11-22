package com.ml.examination;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Assert;
import org.junit.Test;

import com.ml.examination.ecuation.LinearEcuation;
import com.ml.examination.model.Position;


public class EcuationTest {

	  @Test
	  public void testLinealEcuation(){
		  
		  LinearEcuation linealEcuation = LinearEcuation.buildLinearEcuation(new Position(2, 5), new Position(4, 7));
		  
		 assertFalse("It should not be intersects the origin", linealEcuation.isIntersectingOrigin());
		 assertFalse("Intersects Origin", linealEcuation.isIntersectingOrigin());
		 assertTrue("Point is not on the line", linealEcuation.isPointOnTheLine(new Position(3, 6)));
		 Assert.assertEquals(3.0, linealEcuation.evaluate(0), 3);
	  }
}
