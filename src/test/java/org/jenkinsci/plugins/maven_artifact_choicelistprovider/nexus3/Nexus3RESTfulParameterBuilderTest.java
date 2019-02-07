package org.jenkinsci.plugins.maven_artifact_choicelistprovider.nexus3;

import static org.junit.Assert.assertEquals;

import javax.ws.rs.core.MultivaluedMap;

import org.jenkinsci.plugins.maven_artifact_choicelistprovider.ValidAndInvalidClassifier;
import org.junit.Test;

public class Nexus3RESTfulParameterBuilderTest {

    @Test
    public void testSth() {
        Nexus3RESTfulParameterBuilder p = new Nexus3RESTfulParameterBuilder();
        MultivaluedMap<String, String> create = p.create("a", "b", "c", "d", ValidAndInvalidClassifier.fromString("x, y"));
        System.out.println(create);

        int expectedIterations = 6;
        int iterationCount = 0;
        for (String current : create.keySet()) {
            for (String inner : create.get(current)) {
                System.out.println(current + ": " + inner);
                iterationCount++;
            }
        }
        assertEquals(expectedIterations, iterationCount);
    }
}
