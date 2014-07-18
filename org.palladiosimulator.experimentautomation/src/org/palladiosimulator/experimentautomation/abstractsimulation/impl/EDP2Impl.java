/**
 */
package org.palladiosimulator.experimentautomation.abstractsimulation.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.palladiosimulator.edp2.models.Repository.Repository;
import org.palladiosimulator.experimentautomation.abstractsimulation.AbstractsimulationPackage;
import org.palladiosimulator.experimentautomation.abstractsimulation.EDP2;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>EDP2</b></em>'. <!--
 * end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>
 * {@link org.palladiosimulator.experimentautomation.abstractsimulation.impl.EDP2Impl#getRepository
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
    public Repository getRepository() {
        if (repository != null && repository.eIsProxy()) {
            InternalEObject oldRepository = (InternalEObject) repository;
            repository = (Repository) eResolveProxy(oldRepository);
            if (repository != oldRepository) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE,
                            AbstractsimulationPackage.EDP2__REPOSITORY, oldRepository, repository));
            }
        }
        return repository;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public Repository basicGetRepository() {
        return repository;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public void setRepository(Repository newRepository) {
        Repository oldRepository = repository;
        repository = newRepository;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, AbstractsimulationPackage.EDP2__REPOSITORY,
                    oldRepository, repository));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
        case AbstractsimulationPackage.EDP2__REPOSITORY:
            if (resolve)
                return getRepository();
            return basicGetRepository();
        }
        return super.eGet(featureID, resolve, coreType);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void eSet(int featureID, Object newValue) {
        switch (featureID) {
        case AbstractsimulationPackage.EDP2__REPOSITORY:
            setRepository((Repository) newValue);
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
    public void eUnset(int featureID) {
        switch (featureID) {
        case AbstractsimulationPackage.EDP2__REPOSITORY:
            setRepository((Repository) null);
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
    public boolean eIsSet(int featureID) {
        switch (featureID) {
        case AbstractsimulationPackage.EDP2__REPOSITORY:
            return repository != null;
        }
        return super.eIsSet(featureID);
    }

} // EDP2Impl
