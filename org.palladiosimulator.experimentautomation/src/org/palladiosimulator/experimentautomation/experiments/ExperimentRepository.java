/**
 */
package org.palladiosimulator.experimentautomation.experiments;

import org.eclipse.emf.cdo.CDOObject;
import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc --> A representation of the model object '
 * <em><b>Experiment Repository</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 * <li>
 * {@link org.palladiosimulator.experimentautomation.experiments.ExperimentRepository#getExperiments
 * <em>Experiments</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.palladiosimulator.experimentautomation.experiments.ExperimentsPackage#getExperimentRepository()
 * @model
 * @extends CDOObject
 * @generated
 */
public interface ExperimentRepository extends CDOObject {

    /**
     * Returns the value of the '<em><b>Experiments</b></em>' containment reference list. The list
     * contents are of type
     * {@link org.palladiosimulator.experimentautomation.experiments.Experiment}. <!--
     * begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Experiments</em>' containment reference list isn't clear, there
     * really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     *
     * @return the value of the '<em>Experiments</em>' containment reference list.
     * @see org.palladiosimulator.experimentautomation.experiments.ExperimentsPackage#getExperimentRepository_Experiments()
     * @model containment="true" ordered="false"
     * @generated
     */
    EList<Experiment> getExperiments();

} // ExperimentRepository
