/**
 */
package org.palladiosimulator.experimentautomation.experiments;

/**
 * <!-- begin-user-doc --> A representation of the model object '
 * <em><b>Job Extension Modification</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 * <li>
 * {@link org.palladiosimulator.experimentautomation.experiments.JobExtensionModification#getExtensionID
 * <em>Extension ID</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.palladiosimulator.experimentautomation.experiments.ExperimentsPackage#getJobExtensionModification()
 * @model
 * @generated
 */
public interface JobExtensionModification extends Modification {
    /**
     * Returns the value of the '<em><b>Extension ID</b></em>' attribute. The default value is
     * <code>"org.palladiosimulator.quality.scalability"</code>. <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Extension ID</em>' attribute isn't clear, there really should be
     * more of a description here...
     * </p>
     * <!-- end-user-doc -->
     *
     * @return the value of the '<em>Extension ID</em>' attribute.
     * @see #setExtensionID(String)
     * @see org.palladiosimulator.experimentautomation.experiments.ExperimentsPackage#getJobExtensionModification_ExtensionID()
     * @model default="org.palladiosimulator.quality.scalability"
     * @generated
     */
    String getExtensionID();

    /**
     * Sets the value of the '
     * {@link org.palladiosimulator.experimentautomation.experiments.JobExtensionModification#getExtensionID
     * <em>Extension ID</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @param value
     *            the new value of the '<em>Extension ID</em>' attribute.
     * @see #getExtensionID()
     * @generated
     */
    void setExtensionID(String value);

} // JobExtensionModification
