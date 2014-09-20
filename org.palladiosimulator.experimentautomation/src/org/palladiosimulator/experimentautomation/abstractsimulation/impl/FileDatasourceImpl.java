/**
 */
package org.palladiosimulator.experimentautomation.abstractsimulation.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.palladiosimulator.experimentautomation.abstractsimulation.AbstractsimulationPackage;
import org.palladiosimulator.experimentautomation.abstractsimulation.FileDatasource;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>File Datasource</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>
 * {@link org.palladiosimulator.experimentautomation.abstractsimulation.impl.FileDatasourceImpl#getLocation
 * <em>Location</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class FileDatasourceImpl extends EDP2DatasourceImpl implements FileDatasource {
    /**
     * The default value of the '{@link #getLocation() <em>Location</em>}' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #getLocation()
     * @generated
     * @ordered
     */
    protected static final String LOCATION_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getLocation() <em>Location</em>}' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #getLocation()
     * @generated
     * @ordered
     */
    protected String location = LOCATION_EDEFAULT;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    protected FileDatasourceImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return AbstractsimulationPackage.Literals.FILE_DATASOURCE;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public String getLocation() {
        return this.location;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void setLocation(final String newLocation) {
        final String oldLocation = this.location;
        this.location = newLocation;
        if (this.eNotificationRequired()) {
            this.eNotify(new ENotificationImpl(this, Notification.SET,
                    AbstractsimulationPackage.FILE_DATASOURCE__LOCATION, oldLocation, this.location));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public Object eGet(final int featureID, final boolean resolve, final boolean coreType) {
        switch (featureID) {
        case AbstractsimulationPackage.FILE_DATASOURCE__LOCATION:
            return this.getLocation();
        }
        return super.eGet(featureID, resolve, coreType);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void eSet(final int featureID, final Object newValue) {
        switch (featureID) {
        case AbstractsimulationPackage.FILE_DATASOURCE__LOCATION:
            this.setLocation((String) newValue);
            return;
        }
        super.eSet(featureID, newValue);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void eUnset(final int featureID) {
        switch (featureID) {
        case AbstractsimulationPackage.FILE_DATASOURCE__LOCATION:
            this.setLocation(LOCATION_EDEFAULT);
            return;
        }
        super.eUnset(featureID);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public boolean eIsSet(final int featureID) {
        switch (featureID) {
        case AbstractsimulationPackage.FILE_DATASOURCE__LOCATION:
            return LOCATION_EDEFAULT == null ? this.location != null : !LOCATION_EDEFAULT.equals(this.location);
        }
        return super.eIsSet(featureID);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public String toString() {
        if (this.eIsProxy()) {
            return super.toString();
        }

        final StringBuffer result = new StringBuffer(super.toString());
        result.append(" (location: ");
        result.append(this.location);
        result.append(')');
        return result.toString();
    }

} // FileDatasourceImpl
