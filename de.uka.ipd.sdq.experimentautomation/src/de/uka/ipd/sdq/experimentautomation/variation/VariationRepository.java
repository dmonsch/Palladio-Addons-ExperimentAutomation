/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.palladiosimulator.experimentautomation.variation;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Repository</b></em>'. <!--
 * end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.palladiosimulator.experimentautomation.variation.VariationRepository#getVariation <em>
 * Variation</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.palladiosimulator.experimentautomation.variation.VariationPackage#getVariationRepository()
 * @model
 * @generated
 */
public interface VariationRepository extends EObject {
    /**
     * Returns the value of the '<em><b>Variation</b></em>' containment reference list. The list
     * contents are of type {@link org.palladiosimulator.experimentautomation.variation.VariationType}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Variation</em>' containment reference list isn't clear, there
     * really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Variation</em>' containment reference list.
     * @see org.palladiosimulator.experimentautomation.variation.VariationPackage#getVariationRepository_Variation()
     * @model containment="true" ordered="false"
     * @generated
     */
    EList<VariationType> getVariation();

} // VariationRepository
