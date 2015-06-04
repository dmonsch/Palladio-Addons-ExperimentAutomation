/**
 */
package org.palladiosimulator.experimentautomation.variation.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.palladiosimulator.experimentautomation.variation.VariationPackage;
import org.palladiosimulator.experimentautomation.variation.VariationType;

import de.uka.ipd.sdq.identifier.impl.IdentifierImpl;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Type</b></em>'. <!--
 * end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.palladiosimulator.experimentautomation.variation.impl.VariationTypeImpl#getName
 * <em>Name</em>}</li>
 * <li>
 * {@link org.palladiosimulator.experimentautomation.variation.impl.VariationTypeImpl#getStrategyClass
 * <em>Strategy Class</em>}</li>
 * <li>
 * {@link org.palladiosimulator.experimentautomation.variation.impl.VariationTypeImpl#getVariedEntityInterface
 * <em>Varied Entity Interface</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class VariationTypeImpl extends IdentifierImpl implements VariationType {

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
     * The default value of the '{@link #getStrategyClass() <em>Strategy Class</em>}' attribute.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getStrategyClass()
     * @generated
     * @ordered
     */
    protected static final String STRATEGY_CLASS_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getStrategyClass() <em>Strategy Class</em>}' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #getStrategyClass()
     * @generated
     * @ordered
     */
    protected String strategyClass = STRATEGY_CLASS_EDEFAULT;

    /**
     * The default value of the '{@link #getVariedEntityInterface()
     * <em>Varied Entity Interface</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getVariedEntityInterface()
     * @generated
     * @ordered
     */
    protected static final String VARIED_ENTITY_INTERFACE_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getVariedEntityInterface() <em>Varied Entity Interface</em>}
     * ' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getVariedEntityInterface()
     * @generated
     * @ordered
     */
    protected String variedEntityInterface = VARIED_ENTITY_INTERFACE_EDEFAULT;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected VariationTypeImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return VariationPackage.Literals.VARIATION_TYPE;
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
            this.eNotify(new ENotificationImpl(this, Notification.SET, VariationPackage.VARIATION_TYPE__NAME, oldName,
                    this.name));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public String getStrategyClass() {
        return this.strategyClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setStrategyClass(final String newStrategyClass) {
        final String oldStrategyClass = this.strategyClass;
        this.strategyClass = newStrategyClass;
        if (this.eNotificationRequired()) {
            this.eNotify(new ENotificationImpl(this, Notification.SET, VariationPackage.VARIATION_TYPE__STRATEGY_CLASS,
                    oldStrategyClass, this.strategyClass));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public String getVariedEntityInterface() {
        return this.variedEntityInterface;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setVariedEntityInterface(final String newVariedEntityInterface) {
        final String oldVariedEntityInterface = this.variedEntityInterface;
        this.variedEntityInterface = newVariedEntityInterface;
        if (this.eNotificationRequired()) {
            this.eNotify(new ENotificationImpl(this, Notification.SET,
                    VariationPackage.VARIATION_TYPE__VARIED_ENTITY_INTERFACE, oldVariedEntityInterface,
                    this.variedEntityInterface));
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
        case VariationPackage.VARIATION_TYPE__NAME:
            return this.getName();
        case VariationPackage.VARIATION_TYPE__STRATEGY_CLASS:
            return this.getStrategyClass();
        case VariationPackage.VARIATION_TYPE__VARIED_ENTITY_INTERFACE:
            return this.getVariedEntityInterface();
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
        case VariationPackage.VARIATION_TYPE__NAME:
            this.setName((String) newValue);
            return;
        case VariationPackage.VARIATION_TYPE__STRATEGY_CLASS:
            this.setStrategyClass((String) newValue);
            return;
        case VariationPackage.VARIATION_TYPE__VARIED_ENTITY_INTERFACE:
            this.setVariedEntityInterface((String) newValue);
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
        case VariationPackage.VARIATION_TYPE__NAME:
            this.setName(NAME_EDEFAULT);
            return;
        case VariationPackage.VARIATION_TYPE__STRATEGY_CLASS:
            this.setStrategyClass(STRATEGY_CLASS_EDEFAULT);
            return;
        case VariationPackage.VARIATION_TYPE__VARIED_ENTITY_INTERFACE:
            this.setVariedEntityInterface(VARIED_ENTITY_INTERFACE_EDEFAULT);
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
        case VariationPackage.VARIATION_TYPE__NAME:
            return NAME_EDEFAULT == null ? this.name != null : !NAME_EDEFAULT.equals(this.name);
        case VariationPackage.VARIATION_TYPE__STRATEGY_CLASS:
            return STRATEGY_CLASS_EDEFAULT == null ? this.strategyClass != null : !STRATEGY_CLASS_EDEFAULT
            .equals(this.strategyClass);
        case VariationPackage.VARIATION_TYPE__VARIED_ENTITY_INTERFACE:
            return VARIED_ENTITY_INTERFACE_EDEFAULT == null ? this.variedEntityInterface != null
            : !VARIED_ENTITY_INTERFACE_EDEFAULT.equals(this.variedEntityInterface);
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
        result.append(" (name: ");
        result.append(this.name);
        result.append(", strategyClass: ");
        result.append(this.strategyClass);
        result.append(", variedEntityInterface: ");
        result.append(this.variedEntityInterface);
        result.append(')');
        return result.toString();
    }

} // VariationTypeImpl
