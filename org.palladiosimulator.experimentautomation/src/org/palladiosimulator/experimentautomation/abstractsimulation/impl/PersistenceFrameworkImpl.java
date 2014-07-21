/**
 */
package org.palladiosimulator.experimentautomation.abstractsimulation.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.palladiosimulator.experimentautomation.abstractsimulation.AbstractsimulationPackage;
import org.palladiosimulator.experimentautomation.abstractsimulation.Datasource;
import org.palladiosimulator.experimentautomation.abstractsimulation.PersistenceFramework;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Persistence Framework</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>
 * {@link org.palladiosimulator.experimentautomation.abstractsimulation.impl.PersistenceFrameworkImpl#getDatasource
 * <em>Datasource</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class PersistenceFrameworkImpl extends EObjectImpl implements PersistenceFramework {
    /**
     * The cached value of the '{@link #getDatasource() <em>Datasource</em>}' containment reference.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #getDatasource()
     * @generated
     * @ordered
     */
    protected Datasource datasource;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    protected PersistenceFrameworkImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return AbstractsimulationPackage.Literals.PERSISTENCE_FRAMEWORK;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public Datasource getDatasource() {
        return this.datasource;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public NotificationChain basicSetDatasource(final Datasource newDatasource, NotificationChain msgs) {
        final Datasource oldDatasource = this.datasource;
        this.datasource = newDatasource;
        if (this.eNotificationRequired()) {
            final ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
                    AbstractsimulationPackage.PERSISTENCE_FRAMEWORK__DATASOURCE, oldDatasource, newDatasource);
            if (msgs == null) {
                msgs = notification;
            } else {
                msgs.add(notification);
            }
        }
        return msgs;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void setDatasource(final Datasource newDatasource) {
        if (newDatasource != this.datasource) {
            NotificationChain msgs = null;
            if (this.datasource != null) {
                msgs = ((InternalEObject) this.datasource).eInverseRemove(this, EOPPOSITE_FEATURE_BASE
                        - AbstractsimulationPackage.PERSISTENCE_FRAMEWORK__DATASOURCE, null, msgs);
            }
            if (newDatasource != null) {
                msgs = ((InternalEObject) newDatasource).eInverseAdd(this, EOPPOSITE_FEATURE_BASE
                        - AbstractsimulationPackage.PERSISTENCE_FRAMEWORK__DATASOURCE, null, msgs);
            }
            msgs = this.basicSetDatasource(newDatasource, msgs);
            if (msgs != null) {
                msgs.dispatch();
            }
        } else if (this.eNotificationRequired()) {
            this.eNotify(new ENotificationImpl(this, Notification.SET,
                    AbstractsimulationPackage.PERSISTENCE_FRAMEWORK__DATASOURCE, newDatasource, newDatasource));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public NotificationChain eInverseRemove(final InternalEObject otherEnd, final int featureID,
            final NotificationChain msgs) {
        switch (featureID) {
        case AbstractsimulationPackage.PERSISTENCE_FRAMEWORK__DATASOURCE:
            return this.basicSetDatasource(null, msgs);
        }
        return super.eInverseRemove(otherEnd, featureID, msgs);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public Object eGet(final int featureID, final boolean resolve, final boolean coreType) {
        switch (featureID) {
        case AbstractsimulationPackage.PERSISTENCE_FRAMEWORK__DATASOURCE:
            return this.getDatasource();
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
        case AbstractsimulationPackage.PERSISTENCE_FRAMEWORK__DATASOURCE:
            this.setDatasource((Datasource) newValue);
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
        case AbstractsimulationPackage.PERSISTENCE_FRAMEWORK__DATASOURCE:
            this.setDatasource((Datasource) null);
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
        case AbstractsimulationPackage.PERSISTENCE_FRAMEWORK__DATASOURCE:
            return this.datasource != null;
        }
        return super.eIsSet(featureID);
    }

} // PersistenceFrameworkImpl
