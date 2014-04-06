/**
 *    Copyright 2011 Peter Murray-Rust et. al.
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */

package org.xmlcml.cml.element;

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