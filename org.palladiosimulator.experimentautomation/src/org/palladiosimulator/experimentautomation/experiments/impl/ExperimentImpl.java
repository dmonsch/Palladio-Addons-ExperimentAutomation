/**
 */
package org.palladiosimulator.experimentautomation.experiments.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.emf.internal.cdo.CDOObjectImpl;
import org.palladiosimulator.experimentautomation.abstractsimulation.StopCondition;
import org.palladiosimulator.experimentautomation.experiments.Experiment;
import org.palladiosimulator.experimentautomation.experiments.ExperimentDesign;
import org.palladiosimulator.experimentautomation.experiments.ExperimentsPackage;
import org.palladiosimulator.experimentautomation.experiments.InitialModel;
import org.palladiosimulator.experimentautomation.experiments.Modification;
import org.palladiosimulator.experimentautomation.experiments.ResponseMeasurement;
import org.palladiosimulator.experimentautomation.experiments.ToolConfiguration;
import org.palladiosimulator.experimentautomation.experiments.Variation;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Experiment</b></em>'. <!--
 * end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>
 * {@link org.palladiosimulator.experimentautomation.experiments.impl.ExperimentImpl#getVariations
 * <em>Variations</em>}</li>
 * <li>
 * {@link org.palladiosimulator.experimentautomation.experiments.impl.ExperimentImpl#getModifications
 * <em>Modifications</em>}</li>
 * <li>{@link org.palladiosimulator.experimentautomation.experiments.impl.ExperimentImpl#getId <em>
 * Id</em>}</li>
 * <li>{@link org.palladiosimulator.experimentautomation.experiments.impl.ExperimentImpl#getName
 * <em>Name</em>}</li>
 * <li>
 * {@link org.palladiosimulator.experimentautomation.experiments.impl.ExperimentImpl#getToolConfiguration
 * <em>Tool Configuration</em>}</li>
 * <li>
 * {@link org.palladiosimulator.experimentautomation.experiments.impl.ExperimentImpl#getStopConditions
 * <em>Stop Conditions</em>}</li>
 * <li>
 * {@link org.palladiosimulator.experimentautomation.experiments.impl.ExperimentImpl#getDescription
 * <em>Description</em>}</li>
 * <li>
 * {@link org.palladiosimulator.experimentautomation.experiments.impl.ExperimentImpl#getExperimentDesign
 * <em>Experiment Design</em>}</li>
 * <li>
 * {@link org.palladiosimulator.experimentautomation.experiments.impl.ExperimentImpl#getResponseMeasurement
 * <em>Response Measurement</em>}</li>
 * <li>
 * {@link org.palladiosimulator.experimentautomation.experiments.impl.ExperimentImpl#getInitialModel
 * <em>Initial Model</em>}</li>
 * <li>
 * {@link org.palladiosimulator.experimentautomation.experiments.impl.ExperimentImpl#getRepetitions
 * <em>Repetitions</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ExperimentImpl extends CDOObjectImpl implements Experiment {

    /**
     * The cached value of the '{@link #getVariations() <em>Variations</em>}' containment reference
     * list. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #getVariations()
     * @generated
     * @ordered
     */
    protected EList<Variation> variations;

    /**
     * The cached value of the '{@link #getModifications() <em>Modifications</em>}' containment
     * reference list. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #getModifications()
     * @generated
     * @ordered
     */
    protected EList<Modification> modifications;

    /**
     * The default value of the '{@link #getId() <em>Id</em>}' attribute. <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @see #getId()
     * @generated
     * @ordered
     */
    protected static final String ID_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getId() <em>Id</em>}' attribute. <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @see #getId()
     * @generated
     * @ordered
     */
    protected String id = ID_EDEFAULT;

    /**
     * The default value of the '{@link #getName() <em>Name</em>}' attribute. <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     *
     * @see #getName()
     * @generated
     * @ordered
     */
    protected static final String NAME_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getName() <em>Name</em>}' attribute. <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @see #getName()
     * @generated
     * @ordered
     */
    protected String name = NAME_EDEFAULT;

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
     * The cached value of the '{@link #getStopConditions() <em>Stop Conditions</em>}' containment
     * reference list. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #getStopConditions()
     * @generated
     * @ordered
     */
    protected EList<StopCondition> stopConditions;

    /**
     * The default value of the '{@link #getDescription() <em>Description</em>}' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #getDescription()
     * @generated
     * @ordered
     */
    protected static final String DESCRIPTION_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getDescription() <em>Description</em>}' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #getDescription()
     * @generated
     * @ordered
     */
    protected String description = DESCRIPTION_EDEFAULT;

    /**
     * The cached value of the '{@link #getExperimentDesign() <em>Experiment Design</em>}'
     * containment reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #getExperimentDesign()
     * @generated
     * @ordered
     */
    protected ExperimentDesign experimentDesign;

    /**
     * The cached value of the '{@link #getResponseMeasurement() <em>Response Measurement</em>}'
     * containment reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #getResponseMeasurement()
     * @generated
     * @ordered
     */
    protected ResponseMeasurement responseMeasurement;

    /**
     * The cached value of the '{@link #getInitialModel() <em>Initial Model</em>}' containment
     * reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #getInitialModel()
     * @generated
     * @ordered
     */
    protected InitialModel initialModel;

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
    protected ExperimentImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return ExperimentsPackage.Literals.EXPERIMENT;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EList<Variation> getVariations() {
        if (this.variations == null) {
            this.variations = new EObjectContainmentEList<Variation>(Variation.class, this,
                    ExperimentsPackage.EXPERIMENT__VARIATIONS);
        }
        return this.variations;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EList<Modification> getModifications() {
        if (this.modifications == null) {
            this.modifications = new EObjectContainmentEList<Modification>(Modification.class, this,
                    ExperimentsPackage.EXPERIMENT__MODIFICATIONS);
        }
        return this.modifications;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public String getId() {
        return this.id;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void setId(final String newId) {
        final String oldId = this.id;
        this.id = newId;
        if (this.eNotificationRequired()) {
            this.eNotify(new ENotificationImpl(this, Notification.SET, ExperimentsPackage.EXPERIMENT__ID, oldId,
                    this.id));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public String getName() {
        return this.name;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void setName(final String newName) {
        final String oldName = this.name;
        this.name = newName;
        if (this.eNotificationRequired()) {
            this.eNotify(new ENotificationImpl(this, Notification.SET, ExperimentsPackage.EXPERIMENT__NAME, oldName,
                    this.name));
        }
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
                    ExperimentsPackage.EXPERIMENT__TOOL_CONFIGURATION);
        }
        return this.toolConfiguration;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EList<StopCondition> getStopConditions() {
        if (this.stopConditions == null) {
            this.stopConditions = new EObjectContainmentEList<StopCondition>(StopCondition.class, this,
                    ExperimentsPackage.EXPERIMENT__STOP_CONDITIONS);
        }
        return this.stopConditions;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public String getDescription() {
        return this.description;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void setDescription(final String newDescription) {
        final String oldDescription = this.description;
        this.description = newDescription;
        if (this.eNotificationRequired()) {
            this.eNotify(new ENotificationImpl(this, Notification.SET, ExperimentsPackage.EXPERIMENT__DESCRIPTION,
                    oldDescription, this.description));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public ExperimentDesign getExperimentDesign() {
        return this.experimentDesign;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public NotificationChain basicSetExperimentDesign(final ExperimentDesign newExperimentDesign, NotificationChain msgs) {
        final ExperimentDesign oldExperimentDesign = this.experimentDesign;
        this.experimentDesign = newExperimentDesign;
        if (this.eNotificationRequired()) {
            final ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
                    ExperimentsPackage.EXPERIMENT__EXPERIMENT_DESIGN, oldExperimentDesign, newExperimentDesign);
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
    public void setExperimentDesign(final ExperimentDesign newExperimentDesign) {
        if (newExperimentDesign != this.experimentDesign) {
            NotificationChain msgs = null;
            if (this.experimentDesign != null) {
                msgs = ((InternalEObject) this.experimentDesign).eInverseRemove(this, EOPPOSITE_FEATURE_BASE
                        - ExperimentsPackage.EXPERIMENT__EXPERIMENT_DESIGN, null, msgs);
            }
            if (newExperimentDesign != null) {
                msgs = ((InternalEObject) newExperimentDesign).eInverseAdd(this, EOPPOSITE_FEATURE_BASE
                        - ExperimentsPackage.EXPERIMENT__EXPERIMENT_DESIGN, null, msgs);
            }
            msgs = this.basicSetExperimentDesign(newExperimentDesign, msgs);
            if (msgs != null) {
                msgs.dispatch();
            }
        } else if (this.eNotificationRequired()) {
            this.eNotify(new ENotificationImpl(this, Notification.SET,
                    ExperimentsPackage.EXPERIMENT__EXPERIMENT_DESIGN, newExperimentDesign, newExperimentDesign));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public ResponseMeasurement getResponseMeasurement() {
        return this.responseMeasurement;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public NotificationChain basicSetResponseMeasurement(final ResponseMeasurement newResponseMeasurement,
            NotificationChain msgs) {
        final ResponseMeasurement oldResponseMeasurement = this.responseMeasurement;
        this.responseMeasurement = newResponseMeasurement;
        if (this.eNotificationRequired()) {
            final ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
                    ExperimentsPackage.EXPERIMENT__RESPONSE_MEASUREMENT, oldResponseMeasurement, newResponseMeasurement);
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
    public void setResponseMeasurement(final ResponseMeasurement newResponseMeasurement) {
        if (newResponseMeasurement != this.responseMeasurement) {
            NotificationChain msgs = null;
            if (this.responseMeasurement != null) {
                msgs = ((InternalEObject) this.responseMeasurement).eInverseRemove(this, EOPPOSITE_FEATURE_BASE
                        - ExperimentsPackage.EXPERIMENT__RESPONSE_MEASUREMENT, null, msgs);
            }
            if (newResponseMeasurement != null) {
                msgs = ((InternalEObject) newResponseMeasurement).eInverseAdd(this, EOPPOSITE_FEATURE_BASE
                        - ExperimentsPackage.EXPERIMENT__RESPONSE_MEASUREMENT, null, msgs);
            }
            msgs = this.basicSetResponseMeasurement(newResponseMeasurement, msgs);
            if (msgs != null) {
                msgs.dispatch();
            }
        } else if (this.eNotificationRequired()) {
            this.eNotify(new ENotificationImpl(this, Notification.SET,
                    ExperimentsPackage.EXPERIMENT__RESPONSE_MEASUREMENT, newResponseMeasurement, newResponseMeasurement));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public InitialModel getInitialModel() {
        return this.initialModel;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public NotificationChain basicSetInitialModel(final InitialModel newInitialModel, NotificationChain msgs) {
        final InitialModel oldInitialModel = this.initialModel;
        this.initialModel = newInitialModel;
        if (this.eNotificationRequired()) {
            final ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
                    ExperimentsPackage.EXPERIMENT__INITIAL_MODEL, oldInitialModel, newInitialModel);
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
    public void setInitialModel(final InitialModel newInitialModel) {
        if (newInitialModel != this.initialModel) {
            NotificationChain msgs = null;
            if (this.initialModel != null) {
                msgs = ((InternalEObject) this.initialModel).eInverseRemove(this, EOPPOSITE_FEATURE_BASE
                        - ExperimentsPackage.EXPERIMENT__INITIAL_MODEL, null, msgs);
            }
            if (newInitialModel != null) {
                msgs = ((InternalEObject) newInitialModel).eInverseAdd(this, EOPPOSITE_FEATURE_BASE
                        - ExperimentsPackage.EXPERIMENT__INITIAL_MODEL, null, msgs);
            }
            msgs = this.basicSetInitialModel(newInitialModel, msgs);
            if (msgs != null) {
                msgs.dispatch();
            }
        } else if (this.eNotificationRequired()) {
            this.eNotify(new ENotificationImpl(this, Notification.SET, ExperimentsPackage.EXPERIMENT__INITIAL_MODEL,
                    newInitialModel, newInitialModel));
        }
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
            this.eNotify(new ENotificationImpl(this, Notification.SET, ExperimentsPackage.EXPERIMENT__REPETITIONS,
                    oldRepetitions, this.repetitions));
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
        case ExperimentsPackage.EXPERIMENT__VARIATIONS:
            return ((InternalEList<?>) this.getVariations()).basicRemove(otherEnd, msgs);
        case ExperimentsPackage.EXPERIMENT__MODIFICATIONS:
            return ((InternalEList<?>) this.getModifications()).basicRemove(otherEnd, msgs);
        case ExperimentsPackage.EXPERIMENT__TOOL_CONFIGURATION:
            return ((InternalEList<?>) this.getToolConfiguration()).basicRemove(otherEnd, msgs);
        case ExperimentsPackage.EXPERIMENT__STOP_CONDITIONS:
            return ((InternalEList<?>) this.getStopConditions()).basicRemove(otherEnd, msgs);
        case ExperimentsPackage.EXPERIMENT__EXPERIMENT_DESIGN:
            return this.basicSetExperimentDesign(null, msgs);
        case ExperimentsPackage.EXPERIMENT__RESPONSE_MEASUREMENT:
            return this.basicSetResponseMeasurement(null, msgs);
        case ExperimentsPackage.EXPERIMENT__INITIAL_MODEL:
            return this.basicSetInitialModel(null, msgs);
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
        case ExperimentsPackage.EXPERIMENT__VARIATIONS:
            return this.getVariations();
        case ExperimentsPackage.EXPERIMENT__MODIFICATIONS:
            return this.getModifications();
        case ExperimentsPackage.EXPERIMENT__ID:
            return this.getId();
        case ExperimentsPackage.EXPERIMENT__NAME:
            return this.getName();
        case ExperimentsPackage.EXPERIMENT__TOOL_CONFIGURATION:
            return this.getToolConfiguration();
        case ExperimentsPackage.EXPERIMENT__STOP_CONDITIONS:
            return this.getStopConditions();
        case ExperimentsPackage.EXPERIMENT__DESCRIPTION:
            return this.getDescription();
        case ExperimentsPackage.EXPERIMENT__EXPERIMENT_DESIGN:
            return this.getExperimentDesign();
        case ExperimentsPackage.EXPERIMENT__RESPONSE_MEASUREMENT:
            return this.getResponseMeasurement();
        case ExperimentsPackage.EXPERIMENT__INITIAL_MODEL:
            return this.getInitialModel();
        case ExperimentsPackage.EXPERIMENT__REPETITIONS:
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
        case ExperimentsPackage.EXPERIMENT__VARIATIONS:
            this.getVariations().clear();
            this.getVariations().addAll((Collection<? extends Variation>) newValue);
            return;
        case ExperimentsPackage.EXPERIMENT__MODIFICATIONS:
            this.getModifications().clear();
            this.getModifications().addAll((Collection<? extends Modification>) newValue);
            return;
        case ExperimentsPackage.EXPERIMENT__ID:
            this.setId((String) newValue);
            return;
        case ExperimentsPackage.EXPERIMENT__NAME:
            this.setName((String) newValue);
            return;
        case ExperimentsPackage.EXPERIMENT__TOOL_CONFIGURATION:
            this.getToolConfiguration().clear();
            this.getToolConfiguration().addAll((Collection<? extends ToolConfiguration>) newValue);
            return;
        case ExperimentsPackage.EXPERIMENT__STOP_CONDITIONS:
            this.getStopConditions().clear();
            this.getStopConditions().addAll((Collection<? extends StopCondition>) newValue);
            return;
        case ExperimentsPackage.EXPERIMENT__DESCRIPTION:
            this.setDescription((String) newValue);
            return;
        case ExperimentsPackage.EXPERIMENT__EXPERIMENT_DESIGN:
            this.setExperimentDesign((ExperimentDesign) newValue);
            return;
        case ExperimentsPackage.EXPERIMENT__RESPONSE_MEASUREMENT:
            this.setResponseMeasurement((ResponseMeasurement) newValue);
            return;
        case ExperimentsPackage.EXPERIMENT__INITIAL_MODEL:
            this.setInitialModel((InitialModel) newValue);
            return;
        case ExperimentsPackage.EXPERIMENT__REPETITIONS:
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
        case ExperimentsPackage.EXPERIMENT__VARIATIONS:
            this.getVariations().clear();
            return;
        case ExperimentsPackage.EXPERIMENT__MODIFICATIONS:
            this.getModifications().clear();
            return;
        case ExperimentsPackage.EXPERIMENT__ID:
            this.setId(ID_EDEFAULT);
            return;
        case ExperimentsPackage.EXPERIMENT__NAME:
            this.setName(NAME_EDEFAULT);
            return;
        case ExperimentsPackage.EXPERIMENT__TOOL_CONFIGURATION:
            this.getToolConfiguration().clear();
            return;
        case ExperimentsPackage.EXPERIMENT__STOP_CONDITIONS:
            this.getStopConditions().clear();
            return;
        case ExperimentsPackage.EXPERIMENT__DESCRIPTION:
            this.setDescription(DESCRIPTION_EDEFAULT);
            return;
        case ExperimentsPackage.EXPERIMENT__EXPERIMENT_DESIGN:
            this.setExperimentDesign((ExperimentDesign) null);
            return;
        case ExperimentsPackage.EXPERIMENT__RESPONSE_MEASUREMENT:
            this.setResponseMeasurement((ResponseMeasurement) null);
            return;
        case ExperimentsPackage.EXPERIMENT__INITIAL_MODEL:
            this.setInitialModel((InitialModel) null);
            return;
        case ExperimentsPackage.EXPERIMENT__REPETITIONS:
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
        case ExperimentsPackage.EXPERIMENT__VARIATIONS:
            return this.variations != null && !this.variations.isEmpty();
        case ExperimentsPackage.EXPERIMENT__MODIFICATIONS:
            return this.modifications != null && !this.modifications.isEmpty();
        case ExperimentsPackage.EXPERIMENT__ID:
            return ID_EDEFAULT == null ? this.id != null : !ID_EDEFAULT.equals(this.id);
        case ExperimentsPackage.EXPERIMENT__NAME:
            return NAME_EDEFAULT == null ? this.name != null : !NAME_EDEFAULT.equals(this.name);
        case ExperimentsPackage.EXPERIMENT__TOOL_CONFIGURATION:
            return this.toolConfiguration != null && !this.toolConfiguration.isEmpty();
        case ExperimentsPackage.EXPERIMENT__STOP_CONDITIONS:
            return this.stopConditions != null && !this.stopConditions.isEmpty();
        case ExperimentsPackage.EXPERIMENT__DESCRIPTION:
            return DESCRIPTION_EDEFAULT == null ? this.description != null : !DESCRIPTION_EDEFAULT
                    .equals(this.description);
        case ExperimentsPackage.EXPERIMENT__EXPERIMENT_DESIGN:
            return this.experimentDesign != null;
        case ExperimentsPackage.EXPERIMENT__RESPONSE_MEASUREMENT:
            return this.responseMeasurement != null;
        case ExperimentsPackage.EXPERIMENT__INITIAL_MODEL:
            return this.initialModel != null;
        case ExperimentsPackage.EXPERIMENT__REPETITIONS:
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
        result.append(" (id: ");
        result.append(this.id);
        result.append(", name: ");
        result.append(this.name);
        result.append(", description: ");
        result.append(this.description);
        result.append(", repetitions: ");
        result.append(this.repetitions);
        result.append(')');
        return result.toString();
    }

} // ExperimentImpl
