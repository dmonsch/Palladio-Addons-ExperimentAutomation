/**
 */
package org.palladiosimulator.experimentautomation.experiments.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.palladiosimulator.experimentautomation.experiments.Experiment;
import org.palladiosimulator.experimentautomation.experiments.ExperimentRepository;
import org.palladiosimulator.experimentautomation.experiments.ExperimentsPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Experiment Repository</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>
 * {@link org.palladiosimulator.experimentautomation.experiments.impl.ExperimentRepositoryImpl#getExperiments
 * <em>Experiments</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ExperimentRepositoryImpl extends EObjectImpl implements ExperimentRepository {
    /**
     * The cached value of the '{@link #getExperiments() <em>Experiments</em>}' containment
     * reference list. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getExperiments()
     * @generated
     * @ordered
     */
    protected EList<Experiment> experiments;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected ExperimentRepositoryImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return ExperimentsPackage.Literals.EXPERIMENT_REPOSITORY;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EList<Experiment> getExperiments() {
        if (this.experiments == null) {
            this.experiments = new EObjectContainmentEList<Experiment>(Experiment.class, this,
                    ExperimentsPackage.EXPERIMENT_REPOSITORY__EXPERIMENTS);
        }
        return this.experiments;
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
        case ExperimentsPackage.EXPERIMENT_REPOSITORY__EXPERIMENTS:
            return ((InternalEList<?>) this.getExperiments()).basicRemove(otherEnd, msgs);
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
        case ExperimentsPackage.EXPERIMENT_REPOSITORY__EXPERIMENTS:
            return this.getExperiments();
        }
        return super.eGet(featureID, resolve, coreType);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @SuppressWarnings("unchecked")
    @Override
    public void eSet(final int featureID, final Object newValue) {
        switch (featureID) {
        case ExperimentsPackage.EXPERIMENT_REPOSITORY__EXPERIMENTS:
            this.getExperiments().clear();
            this.getExperiments().addAll((Collection<? extends Experiment>) newValue);
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
        case ExperimentsPackage.EXPERIMENT_REPOSITORY__EXPERIMENTS:
            this.getExperiments().clear();
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
        case ExperimentsPackage.EXPERIMENT_REPOSITORY__EXPERIMENTS:
            return this.experiments != null && !this.experiments.isEmpty();
        }
        return super.eIsSet(featureID);
    }

} // ExperimentRepositoryImpl
