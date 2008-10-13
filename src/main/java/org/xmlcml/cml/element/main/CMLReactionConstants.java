package org.xmlcml.cml.element.main;

/**
 * constants for reaction elements.
 * 
 * @author pmr
 * 
 */
public interface CMLReactionConstants {
    /**
     * symbolic integer for reactant. [0] can be used in subscripts, etc.
     */
    int REACTANT_I = 0;

    /**
     * symbolic integer for product. [1] can be used in subscripts, etc.
     */
    int PRODUCT_I = 1;

    /**
     * symbolic string for reactant. [0] can be used in subscripts, etc.
     */
    String REACTANT_S = CMLReactant.TAG;

    /**
     * symbolic string for product. [1] can be used in subscripts, etc.
     */
    String PRODUCT_S = CMLProduct.TAG;

    /**
     * Ignore bond orders in mapping.
     * 
     */
    String IGNORE_ORDER = "/IgnoreBondOrders";

    /**
     * a complete atom map for the reaction. often used as the dictRef value
     */
    String MAP_REACTION_ATOM_MAP_COMPLETE = "REACTION ATOM MAP COMPLETE";

    /**
     * an incomplete atom map for the reaction. often used as the dictRef value
     */
    String MAP_REACTION_ATOM_MAP_INCOMPLETE = "REACTION ATOM MAP INCOMPLETE";

    /**
     * direction of mapping
     * 
     */
    String FROM_PRODUCT_TO_REACTANT = "from product to reactant";

    /**
     * direction of mapping
     * 
     */
    String FROM_SPECTATOR_PRODUCT_TO_REACTANT = "from cmlSpectator product to reactant";

}