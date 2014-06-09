/**
 */
package de.uka.ipd.sdq.experimentautomation.abstractsimulation.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.palladiosimulator.edp2.models.Repository.Repository;

import de.uka.ipd.sdq.experimentautomation.abstractsimulation.AbstractsimulationPackage;
import de.uka.ipd.sdq.experimentautomation.abstractsimulation.EDP2;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>EDP2</b></em>'. <!--
 * end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link de.uka.ipd.sdq.experimentautomation.abstractsimulation.impl.EDP2Impl#getRepository
 * <em>Repository</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class EDP2Impl extends PersistenceFrameworkImpl implements EDP2 {
    /**
     * The cached value of the '{@link #getRepository() <em>Repository</em>}' reference. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getRepository()
     * @generated
     * @ordered
     */
    protected Repository repository;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected EDP2Impl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return AbstractsimulationPackage.Literals.EDP2;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public Repository getRepository() {
        if (this.repository != null && this.repository.eIsProxy()) {
            final InternalEObject oldRepository = (InternalEObject) this.repository;
            this.repository = (Repository) this.eResolveProxy(oldRepository);
            if (this.repository != oldRepository) {
                if (this.eNotificationRequired()) {
                    this.eNotify(new ENotificationImpl(this, Notification.RESOLVE,
                            AbstractsimulationPackage.EDP2__REPOSITORY, oldRepository, this.repository));
                }
            }
        }
        return this.repository;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public Repository basicGetRepository() {
        return this.repository;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setRepository(final Repository newRepository) {
        final Repository oldRepository = this.repository;
        this.repository = newRepository;
        if (this.eNotificationRequired()) {
            this.eNotify(new ENotificationImpl(this, Notification.SET, AbstractsimulationPackage.EDP2__REPOSITORY,
                    oldRepository, this.repository));
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
        case AbstractsimulationPackage.EDP2__REPOSITORY:
            if (resolve) {
                return this.getRepository();
            }
            return this.basicGetRepository();
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
        case AbstractsimulationPackage.EDP2__REPOSITORY:
            this.setRepository((Repository) newValue);
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
        case AbstractsimulationPackage.EDP2__REPOSITORY:
            this.setRepository((Repository) null);
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
        case AbstractsimulationPackage.EDP2__REPOSITORY:
            return this.repository != null;
        }
        return super.eIsSet(featureID);
    }

} // EDP2Impl
