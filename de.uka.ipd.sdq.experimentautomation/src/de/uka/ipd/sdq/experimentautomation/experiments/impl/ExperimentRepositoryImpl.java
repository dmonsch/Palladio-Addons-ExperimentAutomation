/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.experimentautomation.experiments.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import de.uka.ipd.sdq.experimentautomation.experiments.Experiment;
import de.uka.ipd.sdq.experimentautomation.experiments.ExperimentRepository;
import de.uka.ipd.sdq.experimentautomation.experiments.ExperimentsPackage;
import de.uka.ipd.sdq.experimentautomation.experiments.ToolConfiguration;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Experiment Repository</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>
 * {@link de.uka.ipd.sdq.experimentautomation.experiments.impl.ExperimentRepositoryImpl#getExperiments
 * <em>Experiments</em>}</li>
 * <li>
 * {@link de.uka.ipd.sdq.experimentautomation.experiments.impl.ExperimentRepositoryImpl#getToolConfiguration
 * <em>Tool Configuration</em>}</li>
 * <li>
 * {@link de.uka.ipd.sdq.experimentautomation.experiments.impl.ExperimentRepositoryImpl#getRepetitions
 * <em>Repetitions</em>}</li>
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
     * The cached value of the '{@link #getToolConfiguration() <em>Tool Configuration</em>}'
     * containment reference list. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getToolConfiguration()
     * @generated
     * @ordered
     */
    protected EList<ToolConfiguration> toolConfiguration;

    /**
     * The default value of the '{@link #getRepetitions() <em>Repetitions</em>}' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getRepetitions()
     * @generated
     * @ordered
     */
    protected static final int REPETITIONS_EDEFAULT = 0;

    /**
     * The cached value of the '{@link #getRepetitions() <em>Repetitions</em>}' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getRepetitions()
     * @generated
     * @ordered
     */
    protected int repetitions = REPETITIONS_EDEFAULT;

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
    public EList<ToolConfiguration> getToolConfiguration() {
        if (this.toolConfiguration == null) {
            this.toolConfiguration = new EObjectContainmentEList<ToolConfiguration>(ToolConfiguration.class, this,
                    ExperimentsPackage.EXPERIMENT_REPOSITORY__TOOL_CONFIGURATION);
        }
        return this.toolConfiguration;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public int getRepetitions() {
        return this.repetitions;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setRepetitions(final int newRepetitions) {
        final int oldRepetitions = this.repetitions;
        this.repetitions = newRepetitions;
        if (this.eNotificationRequired()) {
            this.eNotify(new ENotificationImpl(this, Notification.SET,
                    ExperimentsPackage.EXPERIMENT_REPOSITORY__REPETITIONS, oldRepetitions, this.repetitions));
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
        case ExperimentsPackage.EXPERIMENT_REPOSITORY__EXPERIMENTS:
            return ((InternalEList<?>) this.getExperiments()).basicRemove(otherEnd, msgs);
        case ExperimentsPackage.EXPERIMENT_REPOSITORY__TOOL_CONFIGURATION:
            return ((InternalEList<?>) this.getToolConfiguration()).basicRemove(otherEnd, msgs);
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
        case ExperimentsPackage.EXPERIMENT_REPOSITORY__TOOL_CONFIGURATION:
            return this.getToolConfiguration();
        case ExperimentsPackage.EXPERIMENT_REPOSITORY__REPETITIONS:
            return this.getRepetitions();
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
        case ExperimentsPackage.EXPERIMENT_REPOSITORY__TOOL_CONFIGURATION:
            this.getToolConfiguration().clear();
            this.getToolConfiguration().addAll((Collection<? extends ToolConfiguration>) newValue);
            return;
        case ExperimentsPackage.EXPERIMENT_REPOSITORY__REPETITIONS:
            this.setRepetitions((Integer) newValue);
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
        case ExperimentsPackage.EXPERIMENT_REPOSITORY__TOOL_CONFIGURATION:
            this.getToolConfiguration().clear();
            return;
        case ExperimentsPackage.EXPERIMENT_REPOSITORY__REPETITIONS:
            this.setRepetitions(REPETITIONS_EDEFAULT);
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
        case ExperimentsPackage.EXPERIMENT_REPOSITORY__TOOL_CONFIGURATION:
            return this.toolConfiguration != null && !this.toolConfiguration.isEmpty();
        case ExperimentsPackage.EXPERIMENT_REPOSITORY__REPETITIONS:
            return this.repetitions != REPETITIONS_EDEFAULT;
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
        result.append(" (repetitions: ");
        result.append(this.repetitions);
        result.append(')');
        return result.toString();
    }

} // ExperimentRepositoryImpl
