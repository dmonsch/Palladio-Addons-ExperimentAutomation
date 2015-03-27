/**
 */
package org.palladiosimulator.experimentautomation.experiments.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.palladiosimulator.experimentautomation.experiments.ExperimentsPackage;
import org.palladiosimulator.experimentautomation.experiments.ObjectModification;
import org.palladiosimulator.experimentautomation.variation.VariationType;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Object Modification</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>
 * {@link org.palladiosimulator.experimentautomation.experiments.impl.ObjectModificationImpl#getType
 * <em>Type</em>}</li>
 * <li>
 * {@link org.palladiosimulator.experimentautomation.experiments.impl.ObjectModificationImpl#getName
 * <em>Name</em>}</li>
 * <li>
 * {@link org.palladiosimulator.experimentautomation.experiments.impl.ObjectModificationImpl#getVariedObjectId
 * <em>Varied Object Id</em>}</li>
 * <li>
 * {@link org.palladiosimulator.experimentautomation.experiments.impl.ObjectModificationImpl#getValue
 * <em>Value</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ObjectModificationImpl extends ModificationImpl implements ObjectModification {
    /**
     * The cached value of the '{@link #getType() <em>Type</em>}' reference. <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @see #getType()
     * @generated
     * @ordered
     */
    protected VariationType type;

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
     * The default value of the '{@link #getVariedObjectId() <em>Varied Object Id</em>}' attribute.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #getVariedObjectId()
     * @generated
     * @ordered
     */
    protected static final String VARIED_OBJECT_ID_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getVariedObjectId() <em>Varied Object Id</em>}' attribute.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #getVariedObjectId()
     * @generated
     * @ordered
     */
    protected String variedObjectId = VARIED_OBJECT_ID_EDEFAULT;

    /**
     * The default value of the '{@link #getValue() <em>Value</em>}' attribute. <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     *
     * @see #getValue()
     * @generated
     * @ordered
     */
    protected static final long VALUE_EDEFAULT = 0L;

    /**
     * The cached value of the '{@link #getValue() <em>Value</em>}' attribute. <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     *
     * @see #getValue()
     * @generated
     * @ordered
     */
    protected long value = VALUE_EDEFAULT;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    protected ObjectModificationImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return ExperimentsPackage.Literals.OBJECT_MODIFICATION;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public VariationType getType() {
        if (this.type != null && this.type.eIsProxy()) {
            final InternalEObject oldType = (InternalEObject) this.type;
            this.type = (VariationType) this.eResolveProxy(oldType);
            if (this.type != oldType) {
                if (this.eNotificationRequired()) {
                    this.eNotify(new ENotificationImpl(this, Notification.RESOLVE,
                            ExperimentsPackage.OBJECT_MODIFICATION__TYPE, oldType, this.type));
                }
            }
        }
        return this.type;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public VariationType basicGetType() {
        return this.type;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void setType(final VariationType newType) {
        final VariationType oldType = this.type;
        this.type = newType;
        if (this.eNotificationRequired()) {
            this.eNotify(new ENotificationImpl(this, Notification.SET, ExperimentsPackage.OBJECT_MODIFICATION__TYPE,
                    oldType, this.type));
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
            this.eNotify(new ENotificationImpl(this, Notification.SET, ExperimentsPackage.OBJECT_MODIFICATION__NAME,
                    oldName, this.name));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public String getVariedObjectId() {
        return this.variedObjectId;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void setVariedObjectId(final String newVariedObjectId) {
        final String oldVariedObjectId = this.variedObjectId;
        this.variedObjectId = newVariedObjectId;
        if (this.eNotificationRequired()) {
            this.eNotify(new ENotificationImpl(this, Notification.SET,
                    ExperimentsPackage.OBJECT_MODIFICATION__VARIED_OBJECT_ID, oldVariedObjectId, this.variedObjectId));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public long getValue() {
        return this.value;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void setValue(final long newValue) {
        final long oldValue = this.value;
        this.value = newValue;
        if (this.eNotificationRequired()) {
            this.eNotify(new ENotificationImpl(this, Notification.SET, ExperimentsPackage.OBJECT_MODIFICATION__VALUE,
                    oldValue, this.value));
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
        case ExperimentsPackage.OBJECT_MODIFICATION__TYPE:
            if (resolve) {
                return this.getType();
            }
            return this.basicGetType();
        case ExperimentsPackage.OBJECT_MODIFICATION__NAME:
            return this.getName();
        case ExperimentsPackage.OBJECT_MODIFICATION__VARIED_OBJECT_ID:
            return this.getVariedObjectId();
        case ExperimentsPackage.OBJECT_MODIFICATION__VALUE:
            return this.getValue();
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
        case ExperimentsPackage.OBJECT_MODIFICATION__TYPE:
            this.setType((VariationType) newValue);
            return;
        case ExperimentsPackage.OBJECT_MODIFICATION__NAME:
            this.setName((String) newValue);
            return;
        case ExperimentsPackage.OBJECT_MODIFICATION__VARIED_OBJECT_ID:
            this.setVariedObjectId((String) newValue);
            return;
        case ExperimentsPackage.OBJECT_MODIFICATION__VALUE:
            this.setValue((Long) newValue);
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
        case ExperimentsPackage.OBJECT_MODIFICATION__TYPE:
            this.setType((VariationType) null);
            return;
        case ExperimentsPackage.OBJECT_MODIFICATION__NAME:
            this.setName(NAME_EDEFAULT);
            return;
        case ExperimentsPackage.OBJECT_MODIFICATION__VARIED_OBJECT_ID:
            this.setVariedObjectId(VARIED_OBJECT_ID_EDEFAULT);
            return;
        case ExperimentsPackage.OBJECT_MODIFICATION__VALUE:
            this.setValue(VALUE_EDEFAULT);
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
        case ExperimentsPackage.OBJECT_MODIFICATION__TYPE:
            return this.type != null;
        case ExperimentsPackage.OBJECT_MODIFICATION__NAME:
            return NAME_EDEFAULT == null ? this.name != null : !NAME_EDEFAULT.equals(this.name);
        case ExperimentsPackage.OBJECT_MODIFICATION__VARIED_OBJECT_ID:
            return VARIED_OBJECT_ID_EDEFAULT == null ? this.variedObjectId != null : !VARIED_OBJECT_ID_EDEFAULT
            .equals(this.variedObjectId);
        case ExperimentsPackage.OBJECT_MODIFICATION__VALUE:
            return this.value != VALUE_EDEFAULT;
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
        result.append(", variedObjectId: ");
        result.append(this.variedObjectId);
        result.append(", value: ");
        result.append(this.value);
        result.append(')');
        return result.toString();
    }

} // ObjectModificationImpl
