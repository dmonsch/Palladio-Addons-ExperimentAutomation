/**
 */
package org.palladiosimulator.experimentautomation.abstractsimulation.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.palladiosimulator.experimentautomation.abstractsimulation.AbstractsimulationPackage;
import org.palladiosimulator.experimentautomation.abstractsimulation.RandomNumberGeneratorSeed;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Random Number Generator Seed</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>
 * {@link org.palladiosimulator.experimentautomation.abstractsimulation.impl.RandomNumberGeneratorSeedImpl#getSeed0
 * <em>Seed0</em>}</li>
 * <li>
 * {@link org.palladiosimulator.experimentautomation.abstractsimulation.impl.RandomNumberGeneratorSeedImpl#getSeed1
 * <em>Seed1</em>}</li>
 * <li>
 * {@link org.palladiosimulator.experimentautomation.abstractsimulation.impl.RandomNumberGeneratorSeedImpl#getSeed2
 * <em>Seed2</em>}</li>
 * <li>
 * {@link org.palladiosimulator.experimentautomation.abstractsimulation.impl.RandomNumberGeneratorSeedImpl#getSeed3
 * <em>Seed3</em>}</li>
 * <li>
 * {@link org.palladiosimulator.experimentautomation.abstractsimulation.impl.RandomNumberGeneratorSeedImpl#getSeed4
 * <em>Seed4</em>}</li>
 * <li>
 * {@link org.palladiosimulator.experimentautomation.abstractsimulation.impl.RandomNumberGeneratorSeedImpl#getSeed5
 * <em>Seed5</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class RandomNumberGeneratorSeedImpl extends EObjectImpl implements RandomNumberGeneratorSeed {
    /**
     * The default value of the '{@link #getSeed0() <em>Seed0</em>}' attribute. <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     * 
     * @see #getSeed0()
     * @generated
     * @ordered
     */
    protected static final int SEED0_EDEFAULT = 0;

    /**
     * The cached value of the '{@link #getSeed0() <em>Seed0</em>}' attribute. <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     * 
     * @see #getSeed0()
     * @generated
     * @ordered
     */
    protected int seed0 = SEED0_EDEFAULT;

    /**
     * The default value of the '{@link #getSeed1() <em>Seed1</em>}' attribute. <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     * 
     * @see #getSeed1()
     * @generated
     * @ordered
     */
    protected static final int SEED1_EDEFAULT = 0;

    /**
     * The cached value of the '{@link #getSeed1() <em>Seed1</em>}' attribute. <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     * 
     * @see #getSeed1()
     * @generated
     * @ordered
     */
    protected int seed1 = SEED1_EDEFAULT;

    /**
     * The default value of the '{@link #getSeed2() <em>Seed2</em>}' attribute. <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     * 
     * @see #getSeed2()
     * @generated
     * @ordered
     */
    protected static final int SEED2_EDEFAULT = 0;

    /**
     * The cached value of the '{@link #getSeed2() <em>Seed2</em>}' attribute. <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     * 
     * @see #getSeed2()
     * @generated
     * @ordered
     */
    protected int seed2 = SEED2_EDEFAULT;

    /**
     * The default value of the '{@link #getSeed3() <em>Seed3</em>}' attribute. <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     * 
     * @see #getSeed3()
     * @generated
     * @ordered
     */
    protected static final int SEED3_EDEFAULT = 0;

    /**
     * The cached value of the '{@link #getSeed3() <em>Seed3</em>}' attribute. <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     * 
     * @see #getSeed3()
     * @generated
     * @ordered
     */
    protected int seed3 = SEED3_EDEFAULT;

    /**
     * The default value of the '{@link #getSeed4() <em>Seed4</em>}' attribute. <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     * 
     * @see #getSeed4()
     * @generated
     * @ordered
     */
    protected static final int SEED4_EDEFAULT = 0;

    /**
     * The cached value of the '{@link #getSeed4() <em>Seed4</em>}' attribute. <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     * 
     * @see #getSeed4()
     * @generated
     * @ordered
     */
    protected int seed4 = SEED4_EDEFAULT;

    /**
     * The default value of the '{@link #getSeed5() <em>Seed5</em>}' attribute. <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     * 
     * @see #getSeed5()
     * @generated
     * @ordered
     */
    protected static final int SEED5_EDEFAULT = 0;

    /**
     * The cached value of the '{@link #getSeed5() <em>Seed5</em>}' attribute. <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     * 
     * @see #getSeed5()
     * @generated
     * @ordered
     */
    protected int seed5 = SEED5_EDEFAULT;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected RandomNumberGeneratorSeedImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return AbstractsimulationPackage.Literals.RANDOM_NUMBER_GENERATOR_SEED;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public int getSeed0() {
        return this.seed0;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setSeed0(final int newSeed0) {
        final int oldSeed0 = this.seed0;
        this.seed0 = newSeed0;
        if (this.eNotificationRequired()) {
            this.eNotify(new ENotificationImpl(this, Notification.SET,
                    AbstractsimulationPackage.RANDOM_NUMBER_GENERATOR_SEED__SEED0, oldSeed0, this.seed0));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public int getSeed1() {
        return this.seed1;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setSeed1(final int newSeed1) {
        final int oldSeed1 = this.seed1;
        this.seed1 = newSeed1;
        if (this.eNotificationRequired()) {
            this.eNotify(new ENotificationImpl(this, Notification.SET,
                    AbstractsimulationPackage.RANDOM_NUMBER_GENERATOR_SEED__SEED1, oldSeed1, this.seed1));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public int getSeed2() {
        return this.seed2;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setSeed2(final int newSeed2) {
        final int oldSeed2 = this.seed2;
        this.seed2 = newSeed2;
        if (this.eNotificationRequired()) {
            this.eNotify(new ENotificationImpl(this, Notification.SET,
                    AbstractsimulationPackage.RANDOM_NUMBER_GENERATOR_SEED__SEED2, oldSeed2, this.seed2));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public int getSeed3() {
        return this.seed3;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setSeed3(final int newSeed3) {
        final int oldSeed3 = this.seed3;
        this.seed3 = newSeed3;
        if (this.eNotificationRequired()) {
            this.eNotify(new ENotificationImpl(this, Notification.SET,
                    AbstractsimulationPackage.RANDOM_NUMBER_GENERATOR_SEED__SEED3, oldSeed3, this.seed3));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public int getSeed4() {
        return this.seed4;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setSeed4(final int newSeed4) {
        final int oldSeed4 = this.seed4;
        this.seed4 = newSeed4;
        if (this.eNotificationRequired()) {
            this.eNotify(new ENotificationImpl(this, Notification.SET,
                    AbstractsimulationPackage.RANDOM_NUMBER_GENERATOR_SEED__SEED4, oldSeed4, this.seed4));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public int getSeed5() {
        return this.seed5;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setSeed5(final int newSeed5) {
        final int oldSeed5 = this.seed5;
        this.seed5 = newSeed5;
        if (this.eNotificationRequired()) {
            this.eNotify(new ENotificationImpl(this, Notification.SET,
                    AbstractsimulationPackage.RANDOM_NUMBER_GENERATOR_SEED__SEED5, oldSeed5, this.seed5));
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
        case AbstractsimulationPackage.RANDOM_NUMBER_GENERATOR_SEED__SEED0:
            return this.getSeed0();
        case AbstractsimulationPackage.RANDOM_NUMBER_GENERATOR_SEED__SEED1:
            return this.getSeed1();
        case AbstractsimulationPackage.RANDOM_NUMBER_GENERATOR_SEED__SEED2:
            return this.getSeed2();
        case AbstractsimulationPackage.RANDOM_NUMBER_GENERATOR_SEED__SEED3:
            return this.getSeed3();
        case AbstractsimulationPackage.RANDOM_NUMBER_GENERATOR_SEED__SEED4:
            return this.getSeed4();
        case AbstractsimulationPackage.RANDOM_NUMBER_GENERATOR_SEED__SEED5:
            return this.getSeed5();
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
        case AbstractsimulationPackage.RANDOM_NUMBER_GENERATOR_SEED__SEED0:
            this.setSeed0((Integer) newValue);
            return;
        case AbstractsimulationPackage.RANDOM_NUMBER_GENERATOR_SEED__SEED1:
            this.setSeed1((Integer) newValue);
            return;
        case AbstractsimulationPackage.RANDOM_NUMBER_GENERATOR_SEED__SEED2:
            this.setSeed2((Integer) newValue);
            return;
        case AbstractsimulationPackage.RANDOM_NUMBER_GENERATOR_SEED__SEED3:
            this.setSeed3((Integer) newValue);
            return;
        case AbstractsimulationPackage.RANDOM_NUMBER_GENERATOR_SEED__SEED4:
            this.setSeed4((Integer) newValue);
            return;
        case AbstractsimulationPackage.RANDOM_NUMBER_GENERATOR_SEED__SEED5:
            this.setSeed5((Integer) newValue);
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
        case AbstractsimulationPackage.RANDOM_NUMBER_GENERATOR_SEED__SEED0:
            this.setSeed0(SEED0_EDEFAULT);
            return;
        case AbstractsimulationPackage.RANDOM_NUMBER_GENERATOR_SEED__SEED1:
            this.setSeed1(SEED1_EDEFAULT);
            return;
        case AbstractsimulationPackage.RANDOM_NUMBER_GENERATOR_SEED__SEED2:
            this.setSeed2(SEED2_EDEFAULT);
            return;
        case AbstractsimulationPackage.RANDOM_NUMBER_GENERATOR_SEED__SEED3:
            this.setSeed3(SEED3_EDEFAULT);
            return;
        case AbstractsimulationPackage.RANDOM_NUMBER_GENERATOR_SEED__SEED4:
            this.setSeed4(SEED4_EDEFAULT);
            return;
        case AbstractsimulationPackage.RANDOM_NUMBER_GENERATOR_SEED__SEED5:
            this.setSeed5(SEED5_EDEFAULT);
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
        case AbstractsimulationPackage.RANDOM_NUMBER_GENERATOR_SEED__SEED0:
            return this.seed0 != SEED0_EDEFAULT;
        case AbstractsimulationPackage.RANDOM_NUMBER_GENERATOR_SEED__SEED1:
            return this.seed1 != SEED1_EDEFAULT;
        case AbstractsimulationPackage.RANDOM_NUMBER_GENERATOR_SEED__SEED2:
            return this.seed2 != SEED2_EDEFAULT;
        case AbstractsimulationPackage.RANDOM_NUMBER_GENERATOR_SEED__SEED3:
            return this.seed3 != SEED3_EDEFAULT;
        case AbstractsimulationPackage.RANDOM_NUMBER_GENERATOR_SEED__SEED4:
            return this.seed4 != SEED4_EDEFAULT;
        case AbstractsimulationPackage.RANDOM_NUMBER_GENERATOR_SEED__SEED5:
            return this.seed5 != SEED5_EDEFAULT;
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
        result.append(" (seed0: ");
        result.append(this.seed0);
        result.append(", seed1: ");
        result.append(this.seed1);
        result.append(", seed2: ");
        result.append(this.seed2);
        result.append(", seed3: ");
        result.append(this.seed3);
        result.append(", seed4: ");
        result.append(this.seed4);
        result.append(", seed5: ");
        result.append(this.seed5);
        result.append(')');
        return result.toString();
    }

} // RandomNumberGeneratorSeedImpl
