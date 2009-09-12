/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package geneticimage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author Calvin Ashmore
 */
public class NodeFunctionLibrarySettings {

    private static NodeFunctionLibrarySettings instance;

    public static NodeFunctionLibrarySettings getInstance() {
        if (instance == null) {
            instance = new NodeFunctionLibrarySettings();
        }
        return instance;
    }
    private Map<String, Float> groupWeightMap = new HashMap<String, Float>();

    public float getWeight(String nfGroup) {
        if (groupWeightMap.get(nfGroup) != null) {
            return groupWeightMap.get(nfGroup);
        }
        return 1.0f;
    }

    public float getWeight(Class<? extends NodeFunction> nfClass) {
        if (nfClass.getEnclosingClass() != null) {
            String groupName = nfClass.getEnclosingClass().getSimpleName();
            return getWeight(groupName);
        }
        return 1.0f;
    }

    public void setWeight(String nfGroup, float weight) {
        groupWeightMap.put(nfGroup, weight);
    }

    public List<String> getGroupNames() {

        Set<String> groupNames = new HashSet<String>();

        for (NodeFunction nf : NodeFunctionFactory.allFunctions()) {

            // only get nfs with an enclosing class
            if (nf.getClass().getEnclosingClass() != null) {
                groupNames.add(nf.getClass().getEnclosingClass().getSimpleName());
            }
        }

        return new ArrayList<String>(groupNames);
    }
}
